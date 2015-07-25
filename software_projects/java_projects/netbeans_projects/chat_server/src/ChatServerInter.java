import java.rmi.*;
import java.util.*;

//Server Interface which provide methods that can be invoked by a Client

public interface ChatServerInter extends Remote
{

    public void login(String s,ChatClientInter cli) throws RemoteException;

// Invoked by a Client while Opening the Client Application    

    public void logout(String s) throws RemoteException;

// Invoked by a client while Closing the Client Application  

    public boolean exists(String s)throws RemoteException;

// Invoked by a Client before Logging in, to Check 
// whether the Login ID already Exists or Not.

    public Vector getUsers() throws RemoteException;

// Invoked by a Client to Get all the user names that are online,
// and to add the names to a List Box

    public void sendMessage(String s,String name)throws RemoteException;

//Invoked by a Client to Send a Message

}