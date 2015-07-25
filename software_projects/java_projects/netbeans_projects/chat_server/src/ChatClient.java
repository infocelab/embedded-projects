import java.rmi.*;
import java.rmi.server.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Enumeration;

// ChatClient Program which implements Client Interface

public class ChatClient extends Frame implements ChatClientInter,ActionListener,WindowListener,ItemListener
{	
Enumeration onlineusers;      // Used to get all the user names
ChatServerInter serverref;    // Used to refer the Server
Panel mesgPanel,labelPanel;  
Dialog loginwin; // Login Dialog which appears while opening the application	
Dialog errorwin; // Error Dialog to display Error Messages
Label errorMesg,fromlabel,tolabel,fromid,toid,loginlabel;
TextField loginname; // Login TextField
TextField msgbox;    // Message Box to type the Message
TextArea messages;   // Text Area where All messages will be Appended
Button send,login,cancel;   // Button which invokes sendMessage Method  
List userslist;      // Maintains Online User Names
String mylogin;      // Maintains the Client Login Name
String serverName;   // Maintains Server IP Address or Host Name
public ChatClient(String serverName)
{
        this.serverName=serverName;
	try
	{
           UnicastRemoteObject.exportObject(this);
           serverref=(ChatServerInter)Naming.lookup("rmi://"+serverName+"/ChatServer");
	}
        catch(Exception e)
        {
           System.out.println("Server Address is Invalid.Please Check...");
           System.exit(0);
        }
	Font f=new Font("Arial",Font.BOLD,16);

        /*   Preparing Login Window   */

        loginlabel=new Label("Enter a Nick Name  :  ");
        loginlabel.setFont(f);
        loginlabel.setBackground(Color.lightGray);
        loginname=new TextField(15);
	loginname.setForeground(Color.blue);
	loginname.setFont(f);
        login=new Button("Login");
        login.setFont(f);
        cancel=new Button("Cancel");
        cancel.setFont(f);
        loginwin=new Dialog(this, "Login Screen", true);
        loginwin.setLayout(new GridBagLayout());
        loginwin.add(loginlabel);
	loginwin.add(loginname);
        GridBagConstraints gbc=new GridBagConstraints();
        gbc.gridx=0;
        gbc.insets=new Insets(30,30,10,10);
        loginwin.add(login,gbc);
        gbc.gridx=1;
        loginwin.add(cancel,gbc);
        loginwin.setBounds(100,100,350,150);

        /*  Preparing Error Window    */

        errorMesg=new Label();
        errorMesg.setFont(f);
        errorMesg.setForeground(Color.blue);
        errorwin=new Dialog(this,"Error",true);
        errorwin.add(errorMesg);
        errorwin.setBounds(100,100,250,70);

        /*  Preparing Application Window  */

	userslist=new List(10);
	userslist.setForeground(Color.blue);
	userslist.setFont(f);
	messages=new TextArea(10,30);

           /* Preparing Message Panel  */

	msgbox=new TextField(60);
        msgbox.setFont(f);
        send=new Button("Send");
        send.setFont(f);
        mesgPanel=new Panel();
        mesgPanel.add(msgbox);
        mesgPanel.add(send);
        mesgPanel.setBackground(Color.lightGray);

           /* Preparing Label Panel   */

         fromlabel=new Label("From  :  ",Label.RIGHT);
         fromlabel.setFont(f);
         fromlabel.setForeground(Color.blue);
         fromlabel.setBackground(Color.lightGray);
         fromid=new Label();
         fromid.setFont(f);
         fromid.setForeground(Color.darkGray);
         fromid.setBackground(Color.lightGray);
         tolabel=new Label("To   :  ",Label.RIGHT);
         tolabel.setFont(f);
         tolabel.setForeground(Color.blue);
         tolabel.setBackground(Color.lightGray);
         toid=new Label();
         toid.setFont(f);
         toid.setForeground(Color.magenta);
         toid.setBackground(Color.lightGray);
         labelPanel=new Panel();
         labelPanel.setLayout(new GridLayout(1,4));
         labelPanel.add(fromlabel);
         labelPanel.add(fromid);
         labelPanel.add(tolabel);
         labelPanel.add(toid);

           /*   Adding all Components to Main Layout  */
	add(userslist,BorderLayout.EAST);
        add(messages,BorderLayout.CENTER);
        add(labelPanel,BorderLayout.NORTH);
        add(mesgPanel,BorderLayout.SOUTH);

           /*  Adding the UI components to the Listeners  */
	loginname.addActionListener(this);
	msgbox.addActionListener(this);
	send.addActionListener(this);
        login.addActionListener(this);
        cancel.addActionListener(this);
	addWindowListener(this);
	loginwin.addWindowListener(this);
	errorwin.addWindowListener(this);
        userslist.addItemListener(this);

           /* Setting Initial Screen   */

        messages.setFont(new Font("Arial",Font.BOLD,14));
	messages.setEditable(false);
	setTitle("Chat Client Application");
        setBounds(50,50,600,400);
        setVisible(true);
	loginwin.setVisible(true);
}
public void addUser(String name)throws RemoteException
{
/* To Identify the Logged User Name in the list  */
if(name.equals(mylogin))
   userslist.add("*"+name+"*");
else
   userslist.add(name);
}
public void removeUser(String name)throws RemoteException
{
userslist.remove(name);
}
public void send(String mesg)throws RemoteException
{
messages.append(mesg+"\n");
setState(Frame.NORMAL);        /*To set the focus to the minimized window*/
show();                        /*when a message is recieved*/ 
}
public void actionPerformed(ActionEvent ae)
{
          try
            {
        if(ae.getSource()==loginname||ae.getSource()==login)
	{
                mylogin=loginname.getText().toLowerCase();
                if(mylogin.trim().equals("")) return;
                if(mylogin.equals("all"))     //User Name "all" is Invalid
                {
                   loginname.setText("");
                   errorMesg.setText("This Name is Not Acceptable");
                   errorwin.setVisible(true);
                }
                else if(!serverref.exists(mylogin))
		{
		    serverref.login(mylogin,this);
		    loginwin.setVisible(false);
                    userslist.removeAll();
                    userslist.add("All");
                    onlineusers=serverref.getUsers().elements();
                      while(onlineusers.hasMoreElements())
                             addUser(""+onlineusers.nextElement());
                    userslist.select(0);   //Selecting All by default
                   fromid.setText(mylogin);
                   toid.setText(userslist.getSelectedItem());
		}
		else
		{
		loginname.setText("");
                errorMesg.setText("This Name is Already in Use");                  
		errorwin.setVisible(true);
		}
	}
	else if((ae.getSource()==msgbox)||(ae.getSource()==send))
	{
                if(msgbox.getText().equals("")) return;
                String toWhom=userslist.getSelectedItem(); 
                serverref.sendMessage(mylogin+"   :   "+msgbox.getText(),toWhom);
                if(!toWhom.equals("All")&&!toWhom.equals("*"+mylogin+"*"))
                       send(mylogin+"   :   "+msgbox.getText());
                msgbox.setText("");

	}
        else if(ae.getSource()==cancel)
            System.exit(0);
      }
      catch(Exception e)
      {
	System.out.println("Error"+e);
      }
}
public void itemStateChanged(ItemEvent ie)
{
      toid.setText(userslist.getSelectedItem());
}
public void windowClosing(WindowEvent we)
{
if(we.getSource()==this)
 	{
		try
		{
			serverref.logout(mylogin);
		}
                catch(Exception e) {}
		System.exit(0);
	}
else if(we.getSource()==errorwin)
errorwin.setVisible(false);
}
public void windowOpened(WindowEvent we){}
public void windowClosed(WindowEvent we){}
public void windowIconified(WindowEvent we){}
public void windowDeiconified(WindowEvent we){}
public void windowActivated(WindowEvent we){}
public void windowDeactivated(WindowEvent we){}
public static void main(String args[])
{
	try
	{
                ChatClient obj=new ChatClient(args[0]);
	}
        catch(ArrayIndexOutOfBoundsException e)
	{
             System.out.println("Usage : java ChatClient <SERVER HOST | IP ADDRESS>");
             System.out.println("Ex1    : java ChatClient 192.100.100.200");
             System.out.println("Ex2    : java ChatClient serversys1");
        }
	catch(Exception e)
	{
           System.out.println("The following Error Occurred while starting Client...");
           System.out.println(e.getMessage());
        }
}
}
