package chatserver;

import java.io.*;
import java.net.*;
import java.util.*;
import javax.swing.*;

import protocols.*;


//MAIN CLASS THAT HANDLES THE CONNECTION REQUESTS
public class ChatServer
{
	int serverPort;
	int serverLimit;
	ServerSocket server;
	
	int onlineUsers;

	//List of all client hadling threads in the server.Synchronized
	Vector handlers;

	ServerInterface window;


	//HANDLER FOR EACH INDIVIDUAL CLIENT
	public class ChatHandler implements Runnable
	{
		protected ClientInfo clientInfo = new ClientInfo();
	
		protected Socket socket;
		protected ObjectInputStream in;
		protected ObjectOutputStream out;
	
		//Thread on which to run this handler
		protected Thread listener;
	
	
		public ChatHandler( int clientID, Socket socket )
		{
			clientInfo.clientId = clientID;
			this.socket = socket;
			//onlineUsers = 0;
		}
	
		//Set up parameters and required data with the client
		protected boolean handShake()
		{
			try
			{
				clientInfo.clientName = (String)in.readObject();
				
				if( window.clientList.size()>0 && window.clientList.indexOf( clientInfo.clientName ) != -1 )
				{
					try
					{
						ConnectionNotice status = new ConnectionNotice();
						status.status = false;
						out.writeObject( status );
						out.flush();
						socket.close();
						return false;
					}
					catch( IOException w )
					{}
				}
	
				try
				{
					ConnectionNotice status = new ConnectionNotice();
					status.status = true;
					out.writeObject( status );
				}
				catch( IOException w )
				{}

				//Add client to list and send it the complete
				//client list
				window.clientList.addElement( clientInfo.clientName );
				out.writeObject( window.clientList );
	
				//Tell all other clients about the new client
				//Construct an protocol object and broadcast it
				UpdateList newClient = new UpdateList();
				newClient.requestType = true;
				newClient.newClient = clientInfo.clientName;
				broadcast( newClient );
				
				onlineUsers++;
			}
			catch( Exception e )
			{}
			return true;
		}
	
		public synchronized void start()
		{
			if ( listener == null )
			{
				try
				{
					//The order in whick these streams are created
					//is important. Reverse the order in client.
					out = new ObjectOutputStream( socket.getOutputStream() );
					in = new ObjectInputStream( socket.getInputStream() );
		
					ConnectionNotice status = new ConnectionNotice();

					if ( onlineUsers >= serverLimit )
					{
						//server.window.taMessages.append(onlineUsers+" " + 
						//ChatHandler client = (ChatHandler)handlers.elementAt( onlineUsers-1 );
						try
						{
							status.status = false;
							out.writeObject( status );
							out.flush();
							socket.close();
							return;
						}
						catch( IOException w )
						{}
					}

					try
					{
						status.status = true;
						out.writeObject( status );
					}
					catch( IOException w )
					{}

					if( !handShake() )
						return;
	
					//Create a new thread and start listening to the client
					listener = new Thread( this );
					listener.start();
				}
	
				catch( IOException ignored )
				{
				}
			}
		}
	
		public synchronized void stop()
		{
			if ( listener != null )
			{
				//if ( listener != Thread.currentThread() )
				//{
				try
				{
					listener.interrupt();
					listener = null;
	
					//Remove handler from list.Remove client from active list
					//Notify all other users that this client has left.
					handlers.removeElement( this );
					window.clientList.removeElement( clientInfo.clientName );
					UpdateList newClient = new UpdateList();
					newClient.requestType = false;
					newClient.newClient = clientInfo.clientName;
					broadcast( newClient );
	
					//Close the sockets and show message in server window
					out.close();
					socket.close();
					window.taMessages.append( "Connection to client " + clientInfo.clientId + " closed...\n" );
				}
				catch( IOException io_ex )
				{
					JOptionPane.showMessageDialog( window, "Error closing connection to client", "Termination Error", JOptionPane.ERROR_MESSAGE );
				}
				//}
			}
		}
	
	
		public void run()
		{
			try
			{
				handlers.addElement( this );
	
				//Listen to input stream for messages from this client
				while ( true )
				{
					try
					{
						Object clientMsg = in.readObject();
	
						if( clientMsg instanceof Message )
						{
							//If public message then broadcast
							if( ((Message)clientMsg).audience == true )
							{
								broadcast( clientMsg );
							}
							else //private message
							{
								//To Locate the intended reciever.
								//1) Get the id of recipient (recieverId)
								//2) Get the reference of handler
								//3) send message on its output stream
								((ChatHandler)(handlers.elementAt(((Message)clientMsg).recieverId))).out.writeObject(clientMsg);
							}
						}
						else if( clientMsg instanceof ChatRequest )
						{
							//Tell the intended recipient that this
							//client wants to start a private chat
							//To Locate the intended reciever.
							//1) Get the id of recipient (recieverId)
							//2) Get the reference of handler
							//3) send request on its output stream
							((ChatHandler)(handlers.elementAt(((ChatRequest)clientMsg).recieverId))).out.writeObject(clientMsg);
						}
						else if( clientMsg instanceof LogOut )
						{
							onlineUsers--;
							break;
						}
						else
						{
							//If an unknown object is recieved
							System.out.println( clientMsg );
						}
					}
					catch( ClassNotFoundException cnfe )
					{
						JOptionPane.showMessageDialog( window, "Class of a serialized object cannot be found.", "Termination Error", JOptionPane.ERROR_MESSAGE );
						break;
					}
					catch( InvalidClassException ice )
					{
						JOptionPane.showMessageDialog( window, "Something is wrong with a class used by serialization.", "Termination Error", JOptionPane.ERROR_MESSAGE );
						break;
					}
					catch( StreamCorruptedException sce )
					{
						JOptionPane.showMessageDialog( window, "Control information in the stream is inconsistent.", "Termination Error", JOptionPane.ERROR_MESSAGE );
						break;
					}
					catch( OptionalDataException ode )
					{
						JOptionPane.showMessageDialog( window, "Primitive data was found in the stream instead of objects.", "Termination Error", JOptionPane.ERROR_MESSAGE );
						break;
					}
					catch( IOException ioe)
					{
						//JOptionPane.showMessageDialog( null, "Any of the usual Input/Output related exceptions.", "Termination Error", JOptionPane.ERROR_MESSAGE );
						break;
					}
				}
			}
			catch ( Exception ignored )
			{
			}
			finally
			{
				stop();
			}
		}
	
	
		//Broadcasts a message to all clients
		protected void broadcast( Object clientMsg )
		{
			//Object streams have to be protected
			synchronized ( handlers )
			{
				Enumeration enum = handlers.elements();
	
				//Loop through all the clients
				while ( enum.hasMoreElements() )
				{
					ChatHandler handler = ( ChatHandler ) enum.nextElement();
					try
					{
						handler.out.writeObject( clientMsg );
						out.flush();
					}
					catch ( IOException ex )
					{
						handler.stop();
					}
				}
			}
		}
	}


	//Listen to connection requests from clients
	protected void listenForClients( ServerSocket server )
	{
		window.taMessages.append( "Listening For Connections...\n\n" );

		int clientID = 0;

		while ( true )
		{
			try
			{
				//Listen to socket. When request recieved start
				//a handler and start listening again
				Socket client = server.accept();
				ChatHandler handler = new ChatHandler( ++clientID, client );
				window.taMessages.append( "Connection accepted: "+ clientID + "\n" );
				handler.start();
			}
			catch( IOException io_ex )
			{
				JOptionPane.showMessageDialog( window,"Cannot Setup Connection","Client Connection Error",JOptionPane.ERROR_MESSAGE );
			}
		}
	}

	protected void shutDown()
	{
		Enumeration enum = handlers.elements();
		ServerShutDown shutdown = new ServerShutDown();

		synchronized( handlers )
		{
			//Close connection to all clients.Stop all handlers
			while ( enum.hasMoreElements() )
			{
				try
				{
					((ChatHandler)(handlers.firstElement())).out.writeObject(shutdown);
				}
				catch( Exception e )
				{}
	
				((ChatHandler)(handlers.firstElement())).stop();
			}
		}
		System.exit(0);
	}

	//Save new configuration options to file
	protected  synchronized void setConfiguration( int newPort , int newLimit )
	{
		try
		{
			FileWriter configFile = new FileWriter("serverConfig.cfg");
			//configFile.write( newPort );
			configFile.write( newPort + ";"+ newLimit+";" );
			//configFile.write( newLimit );
			configFile.close();
			serverLimit = newLimit;
		}
		catch( IOException io_e )
		{
			JOptionPane.showMessageDialog( window,"Cannot Save Configuration File","File Error",JOptionPane.ERROR_MESSAGE );
		}
	}
	
	protected synchronized void getConfiguration()
	{
		try
		{
			char[] buffer = new char[15];

			FileReader configFile = new FileReader("serverConfig.cfg");
			
			configFile.read( buffer );
			
			//String[] temp = ( String.copyValueOf( buffer ) ).split(";");
			
			String value = String.copyValueOf( buffer );
			String[] temp = value.split(";");
			
			//system.out.println(temp[0]);
			//system.out.println(temp[1]);
			//serverPort = Integer.parseInt( temp[0] );
			serverPort = Integer.parseInt( temp[0] );
			//configFile.read( buffer );
			serverLimit = Integer.parseInt( temp[1] );		
			configFile.close();
		}
		catch( FileNotFoundException fnf_e )
		{
			JOptionPane.showMessageDialog( null,"Configuration File Not Found, Using Defaults","Configuration File Missing",JOptionPane.ERROR_MESSAGE );

			serverPort = 1665;
			serverLimit = 20;
		}
		catch( IOException io_e )
		{
			JOptionPane.showMessageDialog( null,"Error Reading Configuration File, Using Defaults","Configuration Error",JOptionPane.ERROR_MESSAGE );
			
			serverPort = 1665;
			serverLimit = 20;
		}			
	}

	ChatServer()
	{
		getConfiguration();
		onlineUsers=0;
		try
		{
			//Bind server on socket,show interface and listen for
			//client connection requests
			server = new ServerSocket( serverPort );
			handlers = new Vector();
			window = new ServerInterface( this );
			listenForClients( server );
		}
		catch( IOException io_e )
		{
			JOptionPane.showMessageDialog( null,"Cannot Start Server","ServerSocket Error",JOptionPane.ERROR_MESSAGE );
			System.exit(0);
		}
		finally
		{
			try
			{
				if( server != null )
					server.close();
			}
			catch( IOException e )
			{}	
		}
	}
	
	public static void main( String[] args ) throws IOException
	{
		new ChatServer();
	}
}