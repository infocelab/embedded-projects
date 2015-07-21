import javax.swing.*;import java.sql.*;
import java.awt.*;import java.awt.event.*;
import java.util.*;import java.awt.print.*;

public class Payment extends JFrame implements ActionListener
{   Statement st;
  receipt rec;JTextArea area;String name,lastname,totalbill,room,roomtype,in,out;
  JTextField f;JButton b;
    public Payment(String s1,String s2,String s3,String s4,String s5,String s6,String s7) 
    {   super("Payment");
        this.st=st;rec=new receipt();
        area=rec.f;
        name=s1;lastname=s2;totalbill=s3;room=s4;roomtype=s5;in=s6;out=s7;
    	Container con=getContentPane();
        con.setLayout(new FlowLayout());
    	f=new JTextField(9);
    	f.setFont(new Font("",Font.BOLD,12));
    	b=new JButton("CASH");b.setIcon(new ImageIcon("res\\pay.png"));
    	b.addActionListener(this);
    	con.add(b);
    	con.add(new JScrollPane(f));
    	setLocation(300,300);
    	setSize(280,90);show();
    	
    }
    public void actionPerformed(ActionEvent e)
    	{try{
    		  int result=Integer.parseInt(f.getText())-Integer.parseInt(totalbill);
    	       area.setText("                         Bonair Inn  \n"+
    	       	             "Cogon,Cagayan de Oro Ave.\n"+
    	       	             "Osmenia Street,Cagayan de Oro City,Philippines\n"+
    	       	             "                        CASH INVOICE\n\n\n"+		
    	       	            "Name :\t\t"+name+"\n"+
    	       	            "LastName :\t\t"+lastname+"\n"+
    	       	            "Room No. :\t\t"+room+"\n"+
    	       	            "Room Type :\t\t"+roomtype+"\n"+
    	       	            "Date Check In :\t\t"+in+"\n"+
    	       	            "Date Check Out :\t"+out+"\n"+
    	       	            "Total Bill :\t\t"+totalbill+"\n"+
    	       	            "Cash :\t\t"+f.getText()+"\n"+	
    	       	            "Change :\t\t"+result	);				                  
    	       
    	       rec.show();	
    	    }
    	    catch(NumberFormatException en){JOptionPane.showMessageDialog(this,"Bopols Manka Oi");}
    	    catch(Exception e4){}
    	}
    
    
    
}