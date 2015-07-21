import javax.swing.*;import java.util.Date;
import java.util.Vector;  import java.util.GregorianCalendar;import java.util.Calendar;	
import java.util.StringTokenizer;
import java.sql.*;
public class m extends JFrame
 {
 	Statement st;ResultSet set;notepad not;GregorianCalendar gr = new GregorianCalendar();
    Date current;String sdate;Vector vec;Vector vecname;
    public m(Statement st,notepad not) 
    {
    	this.st=st;
    	this.not=not;
    	
    	vec=new Vector();vecname=new Vector();
    	String s=not.getdate();
    	sdate=s.substring(8,s.length());
    	StringTokenizer stok2=new StringTokenizer(sdate,"/");
    	int day,mon,yer;
    	mon=(gr.get(Calendar.MONTH)+1);
	    day=gr.get(Calendar.DATE);
	    yer=gr.get(Calendar.YEAR);
    
    	current=new Date(yer,mon,day);
    	update();
    }
    
    public void update()
    	{ String s1;String s2;String s3;
    	try{
    	
    		set=st.executeQuery("Select * from CustomerInfo_tbl ");
				 while(set.next())
				 	{
				 	        
	              		s1=set.getString("Date");
	              		s2=set.getString("Room_Type");
	              		s3=set.getString("lastname");
	              		StringTokenizer stok=new StringTokenizer(s1,"/");
	              		int day,mon,yer;
	              		mon=Integer.parseInt(stok.nextToken());
	              		day=Integer.parseInt(stok.nextToken());
	              		yer=Integer.parseInt(stok.nextToken());
	              		
	              	
	              	    Date cusDate=new Date(yer,mon,day);	
	              	  	vecname.add(s3);
	              	  	date1(cusDate,s2);	  	
	              	 
	              	  	
	              		
    			    }
    			 h();  
    	   }catch(Exception e){System.out.print("Exception1");}
    	}
    public void hour1()
    {
    	
    	
    }
      public void h()
    {  try{
        for(int io=0;io<vec.size();io++)
        	{ 
    	       st.execute(" UPDATE billing_tbl SET room_bill='"+vec.get(io)+"' WHERE LastName='"+vecname.get(io)+"'");
        	}
    	  }catch(Exception e){}
    }
    public  void  date1(Date d4,String s)
    {
    	 
    	       
         Date d3=d4;
         int result=0;
    	 int o=1;
    	 
    	 while(d3.before(current))
    	 	{
    	 		
    	 		if(d3.getMonth()==1||d3.getMonth()==3||d3.getMonth()==5||d3.getMonth()==7||d3.getMonth()==8||d3.getMonth()==10||d3.getMonth()==12)
    	 			{   
    	 				if(d3.getDate()==31){d3.setMonth(d3.getMonth()+1);d3.setDate(0);}
    	 		          d3.setDate(d3.getDate()+1);
    	 	    			o++;
    	 			}
    	 
    			else if(d3.getMonth()==2)
    	 	    	{    
    	 	    		  if(d3.getDate()==28){d3.setMonth(d3.getMonth()+1);d3.setDate(0);}
    	 	    		  	
    	 		           d3.setDate(d3.getDate()+1);
    	 	   				 o++;
    	     		}
    	 		else
    	 			{
    	 				if(d3.getDate()==30){d3.setMonth(d3.getMonth()+1);d3.setDate(0);}
    	 		           d3.setDate(d3.getDate()+1);
    	 	   				 o++;
    	 			}
    	 
    	 		
    	 		 	    
    	 	} 
    	  
    	   if(s.equalsIgnoreCase("Single"))
    	   	{
    	   		result=o*500;
    	   	}
    	   	if(s.equalsIgnoreCase("Double"))
    	   	{
    	   		result=o*600;
    	   	}
    	   	if(s.equalsIgnoreCase("triple"))
    	   	{
    	   		result=o*700;
    	   	} 
    	   	
    	 		
    	  vec.add(result);
    }
    	    
   
   public static void main(String args[])
   	{
   		
   	} 
}