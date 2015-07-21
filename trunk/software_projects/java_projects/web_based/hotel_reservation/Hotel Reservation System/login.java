import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class login extends JInternalFrame implements ActionListener
{
    JTextField tx1;JPasswordField tx2;Statement st;
    ResultSet set; JInternalFrame a;JButton b;
    public login(Statement st,JInternalFrame a)
    {       
    		super("Log In",false,true,false,true);
    		Box box1=Box.createHorizontalBox();
    		Box box2=Box.createHorizontalBox();
    		Box box3=Box.createVerticalBox();
    		this.a=a;
    		this.st=st;
    		Container con=getContentPane();
    		b=new JButton("log");
    		con.setLayout(new FlowLayout());
    		box1.add(new JLabel("UserName"));
    		tx1=new JTextField(7);
    		box1.add(tx1);
    		box2.add(new JLabel("Password "));
    	    tx2=new JPasswordField(7);
    	    box2.add(tx2);
    	    b.addActionListener(this);
    	    box3.add(Box.createVerticalStrut(13));box3.add(box1);box3.add(Box.createVerticalStrut(13));box3.add(box2);box3.add(Box.createVerticalStrut(13));box3.add(b);
    	    setContentPane(box3);
    	    setLocation(300,300);
    	    setSize(250,150);show();
    	    
    }
    public void actionPerformed(ActionEvent e)
    	{  
    		
    	
    	try{
    	       String s1=""; 
    		     set=st.executeQuery("Select user from user_tbl where pass='"+tx2.getText()+"'");
				   set.next();
	
	              		s1=set.getString("user");
	              if(s1.equalsIgnoreCase(tx1.getText())){a.show();setVisible(true);} 		
    			   else JOptionPane.showMessageDialog(this,"Error in user name\nor Password"); 
                   
	     
	            tx1.setText("");tx2.setText("");
    			    
    	     }catch(Exception e4){JOptionPane.showMessageDialog(this,"Error in user name\nor Password"); }	    
    	}
    
    
}