import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
 import java.util.GregorianCalendar;import java.util.Calendar;	

public class checkout extends JMenuItem implements ActionListener {
b b;	GregorianCalendar gr = new GregorianCalendar();Payment pay;
Statement st;ResultSet set;JList list;Table tbl;txt txt;String datef;
    public checkout(Statement st,b b,Table tbl,txt txt) 
    {   super("Check Out");this.b=b;setIcon(new ImageIcon("res\\out.png"));
        
     datef=(gr.get(Calendar.MONTH)+1)+"/"+gr.get(Calendar.DATE)+"/"+gr.get(Calendar.YEAR);
       this.tbl=tbl;
       this.txt=txt;
    	this.st=st;this.list=b.list;
    	addActionListener(this);
    }
    public void actionPerformed(ActionEvent e)
    	{
    		String name,lastname,totalbill,room,roomtype,in,out;
     try{
     		
    	String s=list.getSelectedValue()+"";
    	  
    	 
    	  String result=getNum(s);
    	  
    	   
    	    set=st.executeQuery("Select * from  customerinfo_tbl where lastname='"+s+"'");
				   set.next();       
	              		name=set.getString("name");
	              		lastname=set.getString("lastname");
    			        room=set.getString("room_num");
    			        roomtype=set.getString("room_type");
    			        in=set.getString("date");
    			        out=datef;   
    	    set=st.executeQuery("Select total_bill from  billing_tbl where lastname='"+s+"'");
    	          set.next();  totalbill=set.getString("total_bill");
    	   
    	    pay=new Payment(name,lastname,totalbill,room,roomtype,in,out);
    	   
    	     boolean bb=st.execute("INSERT INTO  archiving_tbl  Values('"+name+"','"+lastname+"','"+room+"','"+roomtype+"','"+totalbill+"','"+in+"','"+out+"')" );
    	   
    	   boolean b3=st.execute("update  room set stat='vacant' where room_num='"+result+"'");
          tbl.update();
    	    boolean b1=st.execute("DELETE FROM billing_tbl WHERE lastName='"+s+"'");
    	  boolean b2=st.execute("DELETE FROM customerInfo_tbl WHERE lastName='"+s+"'");
    	  b.update();b.list.repaint();
    	  txt.printme("Check out  \nProcess Complete");
    	  

    	  
    	  
     }catch(Exception e2){System.out.print("ioppopop");} 
    	}
    public String getNum(String san)
    	{  String s1="";String s2=san;
    	   try{
    	   
    		 set=st.executeQuery("Select room_num from CustomerInfo_tbl where lastname='"+s2+"'");
				 while(set.next())
				 	{
				 	        
	              		s1=set.getString("room_num");
    			    }
    	
    	   }catch(Exception e2){}
    	  
    	   	return s1;	    
    	}
}