package server;

/* @ Xolani Gwaqa
     Client Server UPE
     */



import java.io.*;
import java.net.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class Server extends JFrame implements ActionListener {
	
	private JTextArea display;
   	private JButton close;
   	private JButton sendto;
   	private ServerSocket socket;
   	private Socket conn;
   	private DataInputStream input;
	private DataOutputStream output;
	private JTextField sendmsg;
	  java.util.Timer timer = new java.util.Timer();
	
	public Server(){
		
	  super( "Server" );
      display = new JTextArea();
      close = new JButton("Read");
      sendto = new JButton("Send");
      sendmsg = new JTextField();
      sendto.addActionListener(this);
      close.addActionListener(this);
      getContentPane().add("North",sendmsg);
     

      JScrollPane scroll = new JScrollPane(display);
      getContentPane().add("Center",scroll);
      JPanel p = new JPanel();
    //  p.add(close);
      p.add(sendto);
      getContentPane().add("South",p);
    
      addWindowListener(new WindowAdapter() {
      	public void windowClosing(WindowEvent ev){
      	    timer.cancel();       
	      	System.exit(0);
      	}
      });
      setSize( 300, 500 );
      setVisible( true );
      
      try {
	      
	      socket = new ServerSocket(100);
	      display.append("Waiting for connection....\n");
	      conn = socket.accept();
	      input = new DataInputStream(conn.getInputStream());
	      output = new DataOutputStream(conn.getOutputStream());
	      display.append("Got connection....\n");
	     
	   
      }
      catch(Exception ex){
	      timer.cancel();
	      JOptionPane.showMessageDialog(null,ex.toString());
	      
      }
      
      
     TimerTask task = new TimerTask() 
     {
       public void run() 
       {
         ReadFromClient();
       }
     };
    
     timer.schedule(task, 0, 2000);
 
   }
   public void ReadFromClient()
   {
   	 try
       { 
	    String msg = input.readUTF();
	    display.append("Got message Client ...\n");
	    display.append("Client: "+ String.valueOf(msg) + "\n");
       }
        catch(Exception ex){
	      timer.cancel();
	      JOptionPane.showMessageDialog(null,ex.toString());
      }

   }
   public void actionPerformed(ActionEvent e)
   {
	   if(e.getActionCommand().equals("Send")){
	   	
	   try{ 
	    output.writeUTF(sendmsg.getText());
	    display.append("Sending message to Client...\n");
	   }
        catch(Exception ex){
	      timer.cancel();
	      JOptionPane.showMessageDialog(null,ex.toString());
      }
      }	//end if      
      
 }	
	public static void main(String args[]) {
		
		Server s = new Server();
		s.show();
		
	}
	
}
