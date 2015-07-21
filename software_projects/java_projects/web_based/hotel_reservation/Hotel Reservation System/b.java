import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;import java.util.*;

public class b extends JPanel implements ActionListener
{   Statement st;
    JList list;	Vector v;String s;
    JMenuItem i1,bill2,i3,bill1;JMenu bill;charge ch;Connection con;
    JPopupMenu pop;String string[]; ResultSetMetaData data;
    ResultSet set;txt txtb;
	public b(Statement st,txt txt,Table tbl) 
	{   
	    this.st=st;txtb=txt;	 v=new Vector();
	   	   
	    update();
	    list=new JList(v);
		i1=new checkout(st,this,tbl,txtb); ch=new charge(st,list,txtb);
		bill=new JMenu("Bills");bill1=new JMenuItem("Bill Info");bill2=new JMenuItem("Total Bills");bill.add(bill1);bill.add(bill2);
        bill.add(ch);bill.setIcon(new ImageIcon("res\\bill.png"));
		bill2.addActionListener(this);bill1.addActionListener(this);
		i3=new JMenuItem("Info");i3.addActionListener(this);
	    pop=new JPopupMenu();i3.setIcon(new ImageIcon("res\\cinfo.png"));
	    pop.add(i1);pop.add(bill);pop.add(i3);
		
		list.setVisibleRowCount(15);
		JLabel l=new JLabel("Customer");l.setFont(new Font("Cooper Black",Font.BOLD,16));l.setForeground(Color.RED);
		JLabel l2=new JLabel();l2.setIcon(new ImageIcon("res\\info.gif"));
		add(l);add(l2);
		add(new JScrollPane(list));
		list.setFixedCellHeight(20);
		list.setFixedCellWidth(140);
		
	    list.addMouseListener(
		new MouseAdapter()
			{
				public void mousePressed(MouseEvent e)
					{
						if(e.isPopupTrigger())pop.show(e.getComponent(),e.getX(),getY()-100);
					}
                public void mouseReleased(MouseEvent e)
                	{
                		if(e.isPopupTrigger())pop.show(e.getComponent(),e.getX(),getY()-100);
                	}
			}
		);
	}
	public void update()
		{
		 try{	
		 
	    v.removeAllElements(); 
	    set=st.executeQuery("Select lastname from CustomerInfo_tbl  ");
		data=set.getMetaData();
		int i=0;

		    while(set.next())
		    {
		    	  String s=set.getString("lastname");
		    	 
		    	  if(s==null)continue;
		         boolean b= v.add(s);
		         
		    }
		    
		 }catch(Exception e){System.out.print("Errorme");}  
		}
		public void updateTotal()
    		{  try{
    		 
    		
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
	public void actionPerformed(ActionEvent e)
		{try{
		
			 s=list.getSelectedValue()+"";
			if(e.getSource()==bill2)
				{
			     
			     
			     updateTotal();
			     
				 set=st.executeQuery("Select total_bill from billing_tbl where lastname='"+s+"'");
				 while(set.next()){
				 	        
	             String s1=set.getString("total_bill");
		         txtb.printme("Total Expenses is Php "+s1);
				 }
				}
					if(e.getSource()==bill1)
				{
			      
				 set=st.executeQuery("Select * from billing_tbl where lastname='"+s+"'");
				 while(set.next()){
				 	        
	             
		         txtb.printme ("Room Bills is   \t"+"Php "+set.getString("Room_bill")+
		         	           "\nExtra Bed is   \t"+"Php "+set.getString("Extra_bed")+
		         	          "\nFood Bill is   \t\t"+"Php "+set.getString("food_bill")+
		         	          "\nService Bill is\t"+"Php "+set.getString("Service_bill")+
		         	          "\nOther Bill is  \t\t"+"Php "+set.getString("other_bill"));                    
				 }
				}
				if(e.getSource()==i3)
					{
						     	set=st.executeQuery("Select * from customerInfo_tbl where lastname='"+s+"'");
          
            
            					while(set.next())
            					{   
            		
            	  					txtb.printme("Name         \t\t"+set.getString("name")+
            	  						         "\nLastName   \t\t"+set.getString("LastName")+
            	  						         "\nGender     \t\t"+set.getString("Gender")+
            	  						         "\nCell No.   \t\t"+set.getString("Cell#")+
            	  						         "\nRoom Type  \t\t"+set.getString("Room_type")+
            	  						         "\nRoom No.   \t\t"+set.getString("Room_num")+
            	  						         "\nCheckIn Date   \t"+set.getString("Date")		
            	  						        );	  
            					
            					}
            					
				
					}
			}		
			catch(Exception ex){System.out.print("whahahahha");}	
		}
    public Dimension getPreferredSize(){return new Dimension(150,50);}
    
   
	
}
 