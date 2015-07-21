package chatclient;

import protocols.*;

import java.io.*;
import java.net.*;
import javax.swing.*;


//MAIN CLASS THAT HANDLES THE CONNECTION TO SERVER
public class ChatClient
{
	private boolean connected;
	
	int serverSocketNumber;
	String serverAddress;
	private Socket socket;

	String Name;
	private int clientID;

	ObjectOutputStream out;
	ObjectInputStream in;

	DefaultListModel clientList;

	private InputListener listener;
	ClientInterface window;

	//RESPONSIBLE FOR LISTENING TO INPUT STREAM FOR INCOMING MESSAGES
	class InputListener extends Thread
	{
		//Provides a way to pause the listener
		boolean running = false;
	
		public void run()
		{
			//Loops forever but if listener is paused then skips code
			while( true )
			{
				if( running )
				{
					//Detect the type of message and take appropriate action
					try
					{
						Object serverMsg = in.readObject();
	
						if( serverMsg instanceof Message )
						{
							window.showMessage( (Message)serverMsg );
						}
						else if( serverMsg instanceof ChatRequest )
						{
							window.openNewTab( ((ChatRequest)serverMsg).senderId );
						}
						else if( serverMsg instanceof UpdateList )
						{
							//If informationis about new user logging in
							if( ((UpdateList)serverMsg).requestType == true )
							{
								clientList.addElement( ((UpdateList)serverMsg).newClient );
							}
							//If information is about user logging out
							else
							{
								window.notifyUserLeft( ((UpdateList)serverMsg).newClient );
								clientList.removeElement( ((UpdateList)serverMsg).newClient );
							}
						}
						else if( serverMsg instanceof ServerShutDown )
						{
							disconnectFromServer( false );
							window.notifyDisconnect();
							JOptionPane.showMessageDialog( window,"Server Has Been Shut Down","Connection Error",JOptionPane.ERROR_MESSAGE );
						}
						else if( serverMsg instanceof KickedOutNotice )
						{
							disconnectFromServer( false );
							window.notifyDisconnect();
							JOptionPane.showMessageDialog( window,"Server Kicked You Out","Connection Error",JOptionPane.ERROR_MESSAGE );
						}
					}
					catch( ClassNotFoundException cnfe )
					{
						JOptionPane.showMessageDialog( window, "Class of a serialized object cannot be found.", "Termination Error", JOptionPane.ERROR_MESSAGE );
						shutDown();
					}
					catch( InvalidClassException ice )
					{
						JOptionPane.showMessageDialog( window, "Something is wrong with a class used by serialization.", "Termination Error", JOptionPane.ERROR_MESSAGE );
						shutDown();
					}
					catch( StreamCorruptedException sce )
					{
						JOptionPane.showMessageDialog( window, "Control information in the stream is inconsistent.", "Termination Error", JOptionPane.ERROR_MESSAGE );
						shutDown();
					}
					catch( OptionalDataException ode )
					{
						JOptionPane.showMessageDialog( window, "Primitive data was found in the stream instead of objects.", "Termination Error", JOptionPane.ERROR_MESSAGE );
						shutDown();
					}
					catch( IOException ioe)
					{
						//JOptionPane.showMessageDialog( null, "Any of the usual Input/Output related exceptions.", "Termination Error", JOptionPane.ERROR_MESSAGE );
						//shutDown();
					}
				}
			}
		}
	}

	//Transmit the message from user to server for the main room
	void sendPublicMessage( String userMsg ) throws IOException
	{
		Message msg = new Message();
		msg.audience = true;
		msg.roomNumber = 0;
		msg.senderId = clientID;
		msg.message = Name + " says > " + userMsg;

		out.writeObject( msg );
		out.flush();
	}
	
	//Transmit the message from user to server for one intended client
	void sendPrivateMessage( int recipient, String userMsg ) throws IOException
	{
		Message msg = new Message();
		msg.audience = false;
		msg.recieverId = recipient;
		msg.senderId = clientID;
		msg.message = Name + " says > " + userMsg;

		out.writeObject( msg );
		out.flush();
	}
	
	//Transmit a request that this user wants to chat privately with
	//someone on the list
	void sendChatRequest( int recieverId )
	{
		ChatRequest request = new ChatRequest();
		request.recieverId = recieverId;
		request.senderId = clientID;

		try
		{
			out.writeObject( request );
		}
		catch( IOException io_e )
		{}
	}
	
	//Save new configuration values to file
	void setConfiguration( String newServer, int newPort )
	{
		try
		{
			FileWriter configFile = new FileWriter("clientConfig.cfg");
			configFile.write( newServer.trim() + ";" + newPort + ";" );
			configFile.close();
		}
		catch( IOException io_e )
		{
			JOptionPane.showMessageDialog( window,"Cannot Save Configuration File","File Error",JOptionPane.ERROR_MESSAGE );
		}
	}
	
	//Get configuration options from file and store in variables
	void getConfiguration()
	{
		try
		{
			char[] buffer = new char[255];

			FileReader configFile = new FileReader("clientConfig.cfg");
			
			configFile.read( buffer );
			serverAddress = String.copyValueOf( buffer );
			String[] temp = serverAddress.split(";");
			
			serverAddress = temp[0];
			serverSocketNumber = Integer.parseInt( temp[1] );
			
		}
		catch( FileNotFoundException fnf_e )
		{
			JOptionPane.showMessageDialog( window,"Configuration File Not Found, Using Defaults","Configuration File Missing",JOptionPane.ERROR_MESSAGE );

			serverSocketNumber = 1665;
			serverAddress = "localhost";
		}
		catch( IOException io_e )
		{
			JOptionPane.showMessageDialog( window,"Error Reading Configuration File, Using Defaults","Configuration Error",JOptionPane.ERROR_MESSAGE );
			
			serverSocketNumber = 1665;
			serverAddress = "localhost";
		}			
	}
	
	//Take steps to disconnect from server.
	// reason = true means user choice
	//reason = false means by server
	synchronized void disconnectFromServer( boolean reason )
	{
		try
		{
			if( connected )
			{
				//Pause the listener thread
				listener.running = false;
			
				if( reason = true )
				{
					out.writeObject( new LogOut() );
					out.flush();
				}
			
				out.close();
				socket.close();
				
				clientList.clear();
				connected = false;
			}
		}
		catch( IOException ex )
		{}
	}

	//Take steps to conect to the server
	synchronized boolean connectToServer()
	{
		getConfiguration();
		
		try
		{
			InetAddress addr = InetAddress.getByName( serverAddress );
			socket = new Socket( addr,serverSocketNumber );
		}
		catch( UnknownHostException e )
		{
			JOptionPane.showMessageDialog( window,"Host Not Found, Reconfigure...","Host Lookup Error",JOptionPane.ERROR_MESSAGE );
			return false;
		}
		catch( IOException e )
		{
			JOptionPane.showMessageDialog( window,"Server Not Found, Check If Server Exists...","Socket Error",JOptionPane.ERROR_MESSAGE );
			return false;
		}

		try
		{
			in = new ObjectInputStream( socket.getInputStream() );
			out = new ObjectOutputStream( socket.getOutputStream() );
		}
		catch( IOException e )
		{
			JOptionPane.showMessageDialog( window,"Cannot Create Data Stream, Closing Client...","Data Stream Error",JOptionPane.ERROR_MESSAGE );
			try
			{
				socket.close();
			}
			catch( IOException io_e )
			{}
			
			return false;
		}

		if( !handShake() )
			return false;
		listener.running = true;
		
		//If connecting for first time start the listener object
		if( listener.isAlive() == false )
		{
			listener.start();
		}
		
		connected = true;
		return true;
	}
	
	//Set up parameters with the server
	private boolean handShake()
	{
		try
		{
			if( ((ConnectionNotice)in.readObject()).status )
			{
				out.writeObject( Name );
				if( ((ConnectionNotice)in.readObject()).status == false )
				{
					JOptionPane.showMessageDialog( window,"Name Already In Use. Change Login Name","Nick Error",JOptionPane.ERROR_MESSAGE );
					return false;
				}
					
				clientList = (DefaultListModel)in.readObject();
				clientID = clientList.getSize()-1;
				return true;
			}
			else
			{
				JOptionPane.showMessageDialog( window, "Maximum User Limit Reached. Server Rejected Connection", "Connection Rejected", JOptionPane.ERROR_MESSAGE );
			}
		}
		catch( Exception e )
		{}
		
		return false;
	}

	void shutDown()
	{
		disconnectFromServer( true );
		listener = null;
		System.exit(0);
	}

	ChatClient()
	{
		connected = false;
		listener = new InputListener();
		window = new ClientInterface( this );
	}

	public static void main( String args[] )  throws IOException
	{
		new ChatClient();
	}
}