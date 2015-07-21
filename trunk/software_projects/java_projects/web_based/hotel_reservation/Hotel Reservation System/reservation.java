import java.sql.*;
import javax.swing.*;import javax.swing.table.DefaultTableModel;
import java.awt.*;import java.util.*;import java.util.GregorianCalendar;import java.util.Calendar;
import java.awt.event.*;import java.awt.geom.*;

public class reservation extends JPanel implements ActionListener 
{  
    Statement st; JTable tb;
    JButton i1,i2;static Vector vec;static JList t6; JComboBox t5,t7;String stt2[]={"Male","Female"};String t5val;
    ResultSet set;int i=0;CardLayout card;j j;JTextField t1,t2,t3,t4;String stt1[]={"Triple","Single","Double"};
   String arr[][];MyDate my;txt txt;p1 p1;String datef;GregorianCalendar gr = new GregorianCalendar();
   String arr1[]={"NAME","LASTNAME","Reservation Date","Room No."};Table tb1;
   JPopupMenu pop;JMenuItem im1;JMenuItem im2,in;JButton k;    DefaultTableModel mod; 
      public reservation(Statement st,Table tb1, txt txt,p1 p1) 
    {      
    	this.tb1=tb1;this.txt=txt;this.p1=p1;
    	i1=new JButton(new ImageIcon("res\\Res1_1.png")){public Dimension getPreferredSize(){return new Dimension(135,70);}};
            i2=new JButton(new ImageIcon("res\\Add_1.png")){public Dimension getPreferredSize(){return new Dimension(135,70);}};    	       	   
    	    i2.setRolloverIcon(new ImageIcon("res\\Add2_1.png"));
    	     i1.setRolloverIcon(new ImageIcon("res\\Res2_1.png"));
    		this.st=st;
    		datef=(gr.get(Calendar.MONTH)+1)+"/"+gr.get(Calendar.DATE)+"/"+gr.get(Calendar.YEAR);
    	   update();
    		mod=new DefaultTableModel(arr,arr1);
    			tb=new JTable(mod)
    			{
    	   	                  public boolean isCellEditable(int row, int column)
    	   	   	{
    	   	   		return false;
    	   	   	}
    	   	   	
    	   	    };
    		
           in=new JMenuItem("Check In"); in.setIcon(new ImageIcon("res\\naks.png"));
           im1=new JMenuItem("Other Info");im2=new JMenuItem("Cancel");
           im2.setIcon(new ImageIcon("res\\lo.png"));
           im1.setIcon(new ImageIcon("res\\jeg.png"));
           im2.addActionListener(this);im1.addActionListener(this);in.addActionListener(this);
           pop=new JPopupMenu();pop.add(im1);pop.add(im2);pop.add(in);
           j=new j();
           j2 j2=new j2();
            setLayout(new BorderLayout());
            
            	card.show(j,"add");
            i1.addActionListener(this);i2.addActionListener(this);
           
            
            
            add(j,BorderLayout.CENTER);add(j2,BorderLayout.NORTH);
        	
    }
    public void actionPerformed(ActionEvent e)
    {
    	if(e.getSource()==i1)
    	{
    		card.show(j,"res");
    		
    	}
    		if(e.getSource()==i2)
    	{
    		
    		card.show(j,"add");
    	}
    	if(e.getSource()==im2)
    		{   try{
    		    
    			String mak=tb.getValueAt(tb.getSelectedRow(),1)+"";
    			String mak2=tb.getValueAt(tb.getSelectedRow(),3)+"";
    		    String result=getNum(mak,mak2);
    			st.execute("update  room set stat='vacant' where room_num='"+result+"'"); 
    		   	st.execute("DELETE FROM reservation_tbl WHERE lastName='"+mak+"' and room_num='"+mak2+"'");
    		   	txt.printme("Cancelation Process\nCompleted");
    		    delete(tb.getSelectedRow());
    			tb1.update();
    		
    			
    			}catch(Exception et){}
    		}
    		if(e.getSource()==im1)
    		{   try{
    		    
    			String mak=tb.getValueAt(tb.getSelectedRow(),1)+"";
    			
    				String s1="",s2="",s3="";
    		   	set=st.executeQuery("SELECT * FROM Reservation_tbl WHERE lastName='"+mak+"'");
    		   	  while(set.next()){s1=set.getString("Gender");s2=set.getString("address");s3=set.getString("Room_type");}
    			    
    		   	txt.printme("Gender\t"+s1+
    		   		        "\nAddress\t"+s2+
    		   		        "\nRoom Type\t"+s3	
    		   		);
    		   
    		
    			
    			}catch(Exception et){}
    		}
    		if(e.getSource()==in)
    			{  try{
    			
    			    String mak=tb.getValueAt(tb.getSelectedRow(),1)+"";
    			    String mak2=tb.getValueAt(tb.getSelectedRow(),3)+"";
    				String sj=JOptionPane.showInputDialog(this,"Enter Cell No.");
    				String name,last,gen,add,type,num; 
    				set=st.executeQuery("Select * from Reservation_tbl where lastname='"+mak+"' and room_num='"+mak2+"'");
    				
    				set.next();name=set.getString("name");
    				last=set.getString("lastname");
    				gen=set.getString("gender");
    				add=set.getString("address");
    				type=set.getString("room_type");
    				num=set.getString("room_num");
    			     
    			    st.execute("DELETE FROM reservation_tbl WHERE lastName='"+mak+"' and room_num='"+mak2+"'");
    				delete(tb.getSelectedRow());
    			    tb1.update();
    				
  st.execute("INSERT INTO  customerInfo_tbl  Values('"+name+"','"+last+"','"+gen+"','"+add+"','"+sj+"','"+type+"','"+num+"','"+datef+"')" );

  st.execute("update  room set stat='Occupied' where room_num='"+num+"'");
        p1.txtp.printme("Proccess Complete"); p1.remove();p1.pb.update();p1.pb.repaint(); p1.getRoom(type+"");p1.tbl.update();reservation.remove();
 boolean b3=st.execute("INSERT INTO  billing_tbl  Values('"+last+"','"+p1.m2(type)+"','0','0','0','0','0')" ); 
    			     }catch(Exception eh){}
    			}
    	
    }
     public String getNum(String san,String mak2)
    	{  String s1="";String s2=san;
    	   try{
    	   
    		 set=st.executeQuery("Select room_num from Reservation_tbl where lastname='"+s2+"' and room_num='"+mak2+"'");
				 set.next();
				 	
				 	        
	              		s1=set.getString("room_num");
    			    
    	
    	   }catch(Exception e2){}
    	  
    	   	return s1;	    
    	}
    	public void insert(String []a)
    		{
    			mod.insertRow(mod.getRowCount(), a); 
    		}
    	public void delete(int a)
    		{
    			mod.removeRow(a); 
    		}	
     public void update()
    	{
    		 try{
        	getnum();
            
        	set=st.executeQuery("Select * from reservation_tbl ");
          
            
            while(set.next())
            	{   
            		
            	    arr[i][0]=set.getString("Name"); arr[i][1]=set.getString("LastName");
            		arr[i][2]=set.getString("Res_date");arr[i][3]=set.getString("Room_num");
            		i++;
            	}
             
            	tb.repaint();
            	i=0;System.out.print("update");
           }
           catch(Exception e){}
    	}
   public void getnum()
   	{   try{
   	
   			set=st.executeQuery("SELECT COUNT(*) as N FROM reservation_tbl");
           	set.next();int s=Integer.parseInt(set.getString("N"));
           	arr=new String[s][4];
   	       }catch(Exception e){}
   	}
    class j extends JPanel
    	{   
    	   JPanel p1;
    	  
    	  JPanel p2;
    		public j()
    			{
    				card=new CardLayout();
    			p1=new JPanel();
    			p1.setLayout(new BorderLayout());	
    			p2=new p12()
    				{
    					public Dimension getPreferredSize(){return new Dimension(100,100);}
    					public void paint(Graphics g)
    						{       super.paint(g);
    								Graphics2D g2=(Graphics2D)g;
    		
    								g2.setStroke(new BasicStroke(2));
    								g2.draw(new RoundRectangle2D.Double(2,2,465,267,10,10));
    						}
    				};
    				
    			setLayout(card);
    		   
    	   	    tb.addMouseListener(
	   	         new MouseAdapter()
		  	{
				public void mousePressed(MouseEvent e)
					{
						if(e.isPopupTrigger())pop.show(e.getComponent(),e.getX(),getY());
					}
                public void mouseReleased(MouseEvent e)
                	{
                		if(e.isPopupTrigger())pop.show(e.getComponent(),e.getX(),getY());
                	}
			     }
			     
	       	);  
	       		
    			tb.setFont(new Font("Curz MT",Font.BOLD,16));    			
              	tb.setRowHeight(30);
                tb.setAutoResizeMode( JTable.AUTO_RESIZE_NEXT_COLUMN);
                p1.add(JTable.createScrollPaneForTable(tb));
               
                this.add("res",p1);this.add("add",p2);
    			}
    		public Dimension getPreferredSize(){return new Dimension(300,300);}	
    			     
    	}
    
  class j2 extends JPanel
    	{   
    		public j2()
    			{  
    			setLayout(new FlowLayout(0,0,0));
    				   
    			  add(i2);add(i1);
    		        	setBackground(new Color(255,255,255));
    			}
    			public void paint(Graphics g)
    				{
    					super.paint(g);
    					ImageIcon i=new ImageIcon("res\\guestbook.gif");
    					i.paintIcon(this,g ,310,-37);
    				}
    		public Dimension getPreferredSize(){return new Dimension(400,70);}	
    			     
    	}
    	
    	
    	
    	
    	
    	
    public class p12 extends JPanel implements ItemListener ,ActionListener
   	{  Box v1;
   		public p12() 
     	{ vec=new Vector();
     	  t6=new JList();	t6.setFixedCellHeight(15);t6.setVisibleRowCount(5);
		                    t6.setFixedCellWidth(10);
     	  
     	  t1=new JTextField(10);t5=new JComboBox(stt1);t7=new JComboBox(stt2);
   		  t2=new JTextField(10);Font f=new Font("Georgia",Font.BOLD,12);k=new JButton("ok");k.addActionListener(this);
   		  t3=new JTextField(10);JLabel l1=new JLabel("Name:");JLabel l2=new JLabel("Last Name:");
   		  JLabel l5=new JLabel("Room Type");JLabel l6=new JLabel("Room No.");k.setIcon(new ImageIcon("res\\ucab.png"));
   		  JLabel l3=new JLabel("Address");JLabel l4=new JLabel("Date.:");JLabel l7=new JLabel("Gender:");
   		  l1.setFont(f);l2.setFont(f);l3.setFont(f);l4.setFont(f);l5.setFont(f);l6.setFont(f);l7.setFont(f);
   		  t4=new JTextField(10);t5.addItemListener(this); my=new MyDate();
   		  
     		
   	      Box h1=Box.createHorizontalBox(); Box h2=Box.createHorizontalBox();Box h7=Box.createHorizontalBox();
   	      Box h3=Box.createHorizontalBox(); Box h4=Box.createHorizontalBox();
   	      Box h5=Box.createHorizontalBox(); Box h6=Box.createHorizontalBox();
   		  
   		  h1.add(l1);h1.add(Box.createHorizontalStrut(60));h1.add(t1);
   		  h2.add(l2);h2.add(Box.createHorizontalStrut(30));h2.add(t2);
   		  h7.add(l7);h7.add(Box.createHorizontalStrut(50));h7.add(t7);
   	      h3.add(l3);h3.add(Box.createHorizontalStrut(50));h3.add(t3);
   	      h4.add(l4);h4.add(Box.createHorizontalStrut(60));h4.add(my);
   	      h4.repaint();
   		  h5.add(l5);h5.add(Box.createHorizontalStrut(30));h5.add(t5);
   		  
   		  h6.add(l6);h6.add(Box.createHorizontalStrut(40));h6.add(new JScrollPane(t6));
   		  
   		   v1=Box.createVerticalBox();Box v2=Box.createVerticalBox();Box hh=Box.createHorizontalBox();
   		  v1.add(Box.createVerticalStrut(20));
   		  v1.add(h1);v1.add(Box.createVerticalStrut(10));
   		  v1.add(h2);v1.add(Box.createVerticalStrut(10));
   		  v1.add(h7);v1.add(Box.createVerticalStrut(10));
   		  v1.add(h3);v1.add(Box.createVerticalStrut(10));
   		  v1.add(h4);v1.add(Box.createVerticalStrut(10));
   		  v2.add(Box.createVerticalStrut(15));
   		  v2.add(h5);v2.add(Box.createVerticalStrut(25));
          v2.add(h6);v2.add(Box.createVerticalStrut(50));
          v2.add(Box.createVerticalStrut(2));
          v2.add(k);
          hh.add(v1);hh.add(Box.createHorizontalStrut(30));hh.add(v2);
         add(hh);
   		  
   		   
   		    	}
   		  public void  itemStateChanged(ItemEvent e)
   		  	{
   		  		if(e.getStateChange()==ItemEvent.SELECTED)
   		  			{
   		  			  vec.removeAllElements(); getRoom(t5.getSelectedItem()+"");t5val=t5.getSelectedItem()+"";
   		  			}	   		  			
   		  	} 	
   	     
         public void actionPerformed(ActionEvent e)
         	{
         	try{
         	String t66=t6.getSelectedValue()+"";
         	 st.execute("INSERT INTO  reservation_tbl  Values('"+t1.getText()+"','"+t2.getText()+"','"+t7.getSelectedItem()+"','"+t3.getText()+"','"+my.day()+"','"+t5val+"','"+t66+"')");
         	 st.execute("update  room set stat='Reserved' where room_num='"+t6.getSelectedValue()+"'");
         	 tb1.update();tb1.repaint();vec.removeAllElements(); getRoom(t5.getSelectedItem()+"");
         	 String s0[]={t1.getText(),t2.getText(),my.day(),t66};p1.remove();
         	 insert(s0);tb.repaint();txt.printme("Reservation Process\nCompleted");
         
         	  }catch(Exception e2){System.out.print("haynaku");}	
         	} 
         		
   		}
   		 public static void remove()
        	{
        	   vec.removeAllElements();t6.repaint();	
        	} 
   			public void getRoom(String s)
   			{
   		    try{
   		    
        	set=st.executeQuery("Select * from room where stat='vacant' and type='"+s+"'");
           
            
            while(set.next())
            	{   
            	    boolean b=vec.add(set.getString("Room_num"));
            	}
            t6.setListData(vec);	
   		    }catch(Exception e){System.out.print("barkada");}	
           }    
    
}