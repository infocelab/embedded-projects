import javax.swing.*;
import java.awt.*;import java.awt.event.*;
import java.awt.print.*;

public class receipt extends JFrame implements ActionListener
{   PrinterJob printme = PrinterJob.getPrinterJob();
  JTextArea f;JButton b;
    public receipt() 
    {   
    	super("Receipt");
    	Container con=getContentPane();
        con.setLayout(new FlowLayout());
    	f=new JTextArea(19,25);f.setEditable(false);
    	f.setFont(new Font("",Font.BOLD,12));
    	b=new JButton("PRINT");
    	b.addActionListener(this);
    	con.add(new JScrollPane(f));
    	con.add(b);
    	
    	setSize(320,400);
    	
    }
    public void actionPerformed(ActionEvent e)
    	{try{
    	
    		printme.print();System.out.print("fsf");
    	    }catch(Exception e4){System.out.print("walay Printer");}
    	}
    public static void main(String args[]){new receipt();}
}