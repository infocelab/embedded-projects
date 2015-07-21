import java.rmi.*;
import java.util.*;
import java.rmi.server.*;

// ChatServer Program which implements Server Interface

public class ChatServer extends UnicastRemoteObject implements ChatServerInter
{
Vector logins;               // Maintains all User Names
Hashtable clienttable;       // Maintains user names and their References
Enumeration currentusers;    // Used to get All the users
ChatClientInter clientref;   // Used to refer to a particular Client

 public ChatServer() throws RemoteException
	{
		super();	
		logins=new Vector();
		clienttable=new Hashtable();
	}
 public void login(String name,ChatClientInter client) throws RemoteException
	{
		clienttable.put(name,client);
		logins.addElement(name);
		currentusers=clienttable.elements();
                /* Adding New User Name in all Online Users list */
		while(currentusers.hasMoreElements())
		{
		clientref=(ChatClientInter)currentusers.nextElement();
		clientref.addUser(name);
		}
	}
 public void logout(String name) throws RemoteException
	{
		clienttable.remove(name);
		logins.removeElement(name);
		currentusers=clienttable.elements();
		while(currentusers.hasMoreElements())
		{
		clientref=(ChatClientInter)currentusers.nextElement();
		clientref.removeUser(name);
		}
	}
 public void sendMessage(String message,String name) throws RemoteException
	{
		if(name.equals("All"))
	         {
                    currentusers=clienttable.elements();
                      while(currentusers.hasMoreElements())
                        {
                          clientref=(ChatClientInter)currentusers.nextElement();
                          clientref.send(message);
                        }
	          }
		else
		 {
                   try{
		  clientref=(ChatClientInter)clienttable.get(name);
		  clientref.send(message);
                      }catch(Exception e){}
		 }
	}
 public Vector getUsers() throws RemoteException
	{	
		return logins;
	}
 public boolean exists(String name)throws RemoteException
	{
		return clienttable.containsKey(name);
	}

 public static void main(String args[]) throws RemoteException
        {
	  try
	   {
        java.rmi.registry.LocateRegistry.createRegistry(1099);
	ChatServer obj=new ChatServer();
	Naming.rebind("ChatServer", obj);
	System.out.println("ChatServer started.........");
	   }
	catch(Exception e)
	   {	
        System.out.println("Error Occurred while Starting the Server...\nPort 1099 May be in Use or Server Not Binded\n");
	   }
        }
}	
