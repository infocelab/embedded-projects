import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
public class charge extends JMenu implements ActionListener
{
    JMenu i2,i3,i4;Statement st;JList list;
    txt2 t1,t2,t3,t4;ResultSet set; JMenuItem i1;
    JTextField tx1,tx2,tx3,tx4;txt txt;
    public charge(Statement st,JList list,txt t)
    {   super("Charge");
        txt=t;
        this.st=st;this.list=list;
        
      
    	t1=new txt2();t2=new txt2();t3=new txt2();t4=new txt2();
    	tx1=t1.getT();tx2=t2.getT();tx3=t3.getT();tx4=t4.getT();
    	tx1.addActionListener(this);tx2.addActionListener(this);
    	tx3.addActionListener(this);tx4.addActionListener(this); 
    	i1=new JMenuItem("Extra Bed");i2=new JMenu("Food Bill");i3=new JMenu("Service Bill");
    	i4=new JMenu("Other Bill");i1.addActionListener(this);
    	i2.add(t2);i3.add(t3);i4.add(t4);
    	add(i1);add(i2);add(i3);add(i4);
    }
    public void actionPerformed(ActionEvent e)
    	{ try{
    	   String s=list.getSelectedValue()+"";
    	  
    		if(e.getSource()==i1)
    			{
    			
    		
    			   boolean b1=st.execute(" UPDATE billing_tbl SET Extra_bed='100' WHERE LastName='"+s+"'");
    			  updateTotal(s);
    			  txt.printme("Extra Bed Bill\nAdded");
    			}
    		if(e.getSource()==tx2)
    			{
    					String s1="";	
    			    
				     set=st.executeQuery("Select food_bill from billing_tbl where lastname='"+s+"'");
				   while(set.next())
				 	{
				 	        
	              		s1=set.getString("food_bill");
    			    }
    			    int i=Integer.parseInt(s1);
    			    int i2=Integer.parseInt(tx2.getText()); tx2.setText("");
    			   int add=i+i2;String result=""+add;
    			    boolean b2=st.execute(" UPDATE billing_tbl SET food_bill='"+result+"' WHERE LastName='"+s+"'");
    			    updateTotal(s);
    			    txt.printme("Food Bill \nAdded");
    			}
    		if(e.getSource()==tx3)
    			{
    						String s1="";	
    			   
				     set=st.executeQuery("Select service_bill from billing_tbl where lastname='"+s+"'");
				   while(set.next())
				 	{
				 	        
	              		s1=set.getString("service_bill");
    			    }
    			    int i=Integer.parseInt(s1);
    			    int i2=Integer.parseInt(tx3.getText()); tx3.setText("");
    			   int add=i+i2;String result=""+add;
    			    boolean b3=st.execute(" UPDATE billing_tbl SET service_bill='"+result+"' WHERE LastName='"+s+"'");
    			   updateTotal(s);
    			   txt.printme("Service Bill \nAdded");
    			}
    		if(e.getSource()==tx4)
    			{
    						String s1="";	
    			   
				     set=st.executeQuery("Select other_bill from billing_tbl where lastname='"+s+"'");
				   while(set.next())
				 	{
				 	        
	              		s1=set.getString("other_bill");
    			    }
    			    int i=Integer.parseInt(s1);
    			    int i2=Integer.parseInt(tx4.getText()); tx4.setText("");
    			   int add=i+i2;String result=""+add;
    			    boolean b4=st.execute(" UPDATE billing_tbl SET other_bill='"+result+"' WHERE LastName='"+s+"'");
    			    updateTotal(s);
    			    txt.printme("Other Bill \nAdded");
    			}
    			
    		  	
    			}catch(Exception ex){}
    	}
    	public void updateTotal(String ins )
    		{  try{
    		 
    			String s=ins;
    			String ss1="",ss2="",ss3="",ss4="",ss5="";
    			set=st.executeQuery("Select Room_Bill from billing_tbl where lastname='"+s+"'");
				 while(set.next())
				 	{
				 	        
	              		ss5=set.getString("Room_Bill");
    			    }
    			 set=st.executeQuery("Select Extra_bed from billing_tbl where lastname='"+s+"'");
				 while(set.next())
				 	{
				 	        
	              		ss1=set.getString("Extra_bed");
    			    }
    			     set=st.executeQuery("Select food_bill from billing_tbl where lastname='"+s+"'");
				 while(set.next())
				 	{
				 	        
	              		ss2=set.getString("food_bill");
    			    }
    			     set=st.executeQuery("Select service_bill from billing_tbl where lastname='"+s+"'");
    			     
				 while(set.next())
				 	{
				 	        
	              		ss3=set.getString("service_bill");
    			    }
    			     set=st.executeQuery("Select other_bill from billing_tbl where lastname='"+s+"'");
				 while(set.next())
				 	{
				 	        
	              		ss4=set.getString("other_bill");
    			    }
    		 
    			    int ii1=Integer.parseInt(ss1);int ii2=Integer.parseInt(ss2);
    			    int ii3=Integer.parseInt(ss3);int ii4=Integer.parseInt(ss4);int ii5=Integer.parseInt(ss5);
    			    int in=ii1+ii2+ii3+ii4+ii5;String st1=in+"";
    			   set=st.executeQuery(" UPDATE billing_tbl SET total_bill='"+st1+"' WHERE LastName='"+s+"'");
    			  	
    			   
    		}catch(Exception e){}
    		}	
    class txt2 extends JPanel 
    	{  JTextField f;
    		public txt2()
    			{
    				JLabel l=new JLabel("Php  ");
    				add(l);f=new JTextField(7);
    				add(f);
    			}
    		public JTextField getT(){return f;}
    	}
}