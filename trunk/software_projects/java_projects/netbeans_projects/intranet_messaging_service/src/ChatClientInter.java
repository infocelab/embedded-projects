import java.rmi.*;

// Client Interface which provide methods that can be invoked by the Server

public interface ChatClientInter extends Remote
{
     public void addUser(String s)throws RemoteException;

// Invoked by the Server to add New User name in the Client List Box

     public void removeUser(String s)throws RemoteException;

// Invoked by the Server to remove the User name currently logged out, 
// from the Client List Box

     public void send(String s)throws RemoteException;

//Invoked by the Server to append the Message in the Client TextArea

}