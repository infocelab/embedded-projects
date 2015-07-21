import javax.swing.*;
import java.awt.*;import java.sql.Statement;
import java.awt.event.*; import java.sql.ResultSet;
import java.awt.geom.*;  import java.util.Vector;import java.util.Date;
  import java.util.GregorianCalendar;import java.util.Calendar;	
public class p1 extends JPanel implements ActionListener
{   Statement st;ResultSet set;txt txtp;
    JTextField t1;JComboBox t5,t7;String stt1[]={"Triple","Single","Double"};String t5val;
    JTextField t2;JList t6;b pb;String stt2[]={"Male","Female"};String datef;
    JTextField t3; Vector vec;int m;reservation res;	GregorianCalendar gr = new GregorianCalendar();
    JTextField t4;	Date date1;String sdate="",sdate1="";
    Table tbl;
    JButton b1;notepad not;
    
    JButton b3;ImageIcon i=new ImageIcon("res\\81.gif");
    Box box1=Box.createVerticalBox(); Box box2=Box.createVerticalBox(); Box box3=Box.createVerticalBox();
	public p1(Statement st,txt x,b p,Table b,notepad not,reservation res)
	{    pb=p;tbl=b;	;this.res=res;
	     
	      this.st=st;txtp=x;
	      this.not=not;
	      datef=(gr.get(Calendar.MONTH)+1)+"/"+gr.get(Calendar.DATE)+"/"+gr.get(Calendar.YEAR);
	     setLayout(new BorderLayout());
	    
	      b1=new JButton ("Ok");b1.setIcon(new ImageIcon("res\\cin.png")); 
   		 
   		
   		  b1.addActionListener(this);
	     
	     add( new p12(),BorderLayout.CENTER); 
	     	    
	}
public void actionPerformed(ActionEvent e)
	{try{
	     
		if(e.getSource()==b1)
			{
				String snot=not.getdate();
  st.execute("INSERT INTO  customerInfo_tbl  Values('"+t1.getText()+"','"+t2.getText()+"','"+t7.getSelectedItem()+"','"+t3.getText()+"','"+t4.getText()+"','"+t5val+"','"+t6.getSelectedValue()+"','"+datef+"')" );

  st.execute("update  room set stat='Occupied' where room_num='"+t6.getSelectedValue()+"'");
        txtp.printme("Succesfuly Added"); remove();pb.update();pb.repaint(); getRoom(t5.getSelectedItem()+"");tbl.update();reservation.remove();
 boolean b3=st.execute("INSERT INTO  billing_tbl  Values('"+t2.getText()+"','"+m2(t5val)+"','0','0','0','0','0')" ); 
 	t1.setText("");t2.setText("");t3.setText("");t4.setText("");                                                                       
			}
	   }catch(Exception e1){System.out.print("Error kai malas");}	
	}
	public String m2(String s)
	{  String sss="";
		if(s.equalsIgnoreCase("Single"))sss= 500+"";
		if(s.equalsIgnoreCase("Double"))sss= 600+"";
		if(s.equalsIgnoreCase("Triple"))sss= 700+"";
      return sss;		
	}
	
	public void remove()
	{
		pb.repaint(); vec.removeAllElements();
	}
   private class p11 extends JPanel
   	{  
   		public p11()
     	{
   	      
   		  
   		 
   		  box1.add(b1);box1.add(Box.createVerticalStrut(20));
   		  
   		  add(box1);
   		  setBackground(new Color(120,120,120));
   		  
    	}
    	public Dimension getPreferredSize()
    		{
    			return new Dimension(120,300);
    		}
    		
    	public void paint(Graphics g)
    	{
    		super.paint(g);
    		Graphics2D g2=(Graphics2D)g;
    		
    		g2.setStroke(new BasicStroke(2));
    		g2.draw(new RoundRectangle2D.Double(2,2,149,345,10,10));
    	}	
   	}  
   	private class p12 extends JPanel implements ItemListener ,ActionListener
   	{  Box v1;Timer time=new Timer(1000,this);int i0=0;
   		public p12() 
     	{ vec=new Vector();
     	  t6=new JList();	t6.setFixedCellHeight(15);t6.setVisibleRowCount(5);
		                     t6.setFixedCellWidth(10);
     	  time.start();
     	  t1=new JTextField(10);t5=new JComboBox(stt1);t7=new JComboBox(stt2);
   		  t2=new JTextField(10);Font f=new Font("Georgia",Font.BOLD,12);
   		  t3=new JTextField(10);JLabel l1=new JLabel("Name:");JLabel l2=new JLabel("Last Name:");
   		  JLabel l5=new JLabel("Room Type");JLabel l6=new JLabel("Room No.");
   		  JLabel l3=new JLabel("Address");JLabel l4=new JLabel("Cell No.:");JLabel l7=new JLabel("Gender:");
   		  l1.setFont(f);l2.setFont(f);l3.setFont(f);l4.setFont(f);l5.setFont(f);l6.setFont(f);l7.setFont(f);
   		  t4=new JTextField(10);t5.addItemListener(this);
   		  
     		
   	      Box h1=Box.createHorizontalBox(); Box h2=Box.createHorizontalBox();Box h7=Box.createHorizontalBox();
   	      Box h3=Box.createHorizontalBox(); Box h4=Box.createHorizontalBox();
   	      Box h5=Box.createHorizontalBox(); Box h6=Box.createHorizontalBox();
   		  Box hbox=Box.createHorizontalBox();
   		  
   		  h1.add(l1);h1.add(Box.createHorizontalStrut(90));h1.add(t1);
   		  h2.add(l2);h2.add(Box.createHorizontalStrut(60));h2.add(t2);
   		  h7.add(l7);h7.add(Box.createHorizontalStrut(80));h7.add(t7);
   	      h3.add(l3);h3.add(Box.createHorizontalStrut(80));h3.add(t3);
   	      h4.add(l4);h4.add(Box.createHorizontalStrut(78));h4.add(t4);
   		  h5.add(l5);h5.add(Box.createHorizontalStrut(40));h5.add(t5);   		  
   		  h6.add(l6);h6.add(Box.createHorizontalStrut(58));h6.add(new JScrollPane(t6));
   		   
   		   
   		  v1=Box.createVerticalBox(); Box v2=Box.createVerticalBox();
   		  v1.add(Box.createVerticalStrut(105));
   		  v1.add(h1);v1.add(Box.createVerticalStrut(13));
   		  v1.add(h2);v1.add(Box.createVerticalStrut(13));
   		  v1.add(h7);v1.add(Box.createVerticalStrut(13));
   		  v1.add(h3);v1.add(Box.createVerticalStrut(13));
   		  v1.add(h4);v1.add(Box.createVerticalStrut(13));
   		  
   		  v2.add(Box.createVerticalStrut(105));
   		  v2.add(h5);v2.add(Box.createVerticalStrut(20));
          v2.add(h6);v2.add(Box.createVerticalStrut(10));
          v2.add(Box.createVerticalStrut(15));
          v2.add(b1);
          hbox.add(v1);hbox.add(Box.createHorizontalStrut(15)); hbox.add(v2);
         add(hbox);
   		  
   		   
   		    	}
   		   public void actionPerformed(ActionEvent e)
   		   	{  
   		   		 
   		   		repaint();
   		   	} 	
   		  	public void paint(Graphics g)
    		{
    		super.paint(g);
    		date1=new Date();
    		Graphics2D g2=(Graphics2D)g;
    		ImageIcon i=new ImageIcon("res\\line.gif");
    		ImageIcon i2=new ImageIcon("res\\line.gif");
    		ImageIcon i3=new ImageIcon("res\\m.png");
    		i.paintIcon(this,g2,0,80);
    		i2.paintIcon(this,g2,0,330);
    		i3.paintIcon(this,g2,0,0);
    		g2.setStroke(new BasicStroke(3));
    	
    		String s=not.getdate();
    		g.setFont(new Font("Cooper Black",Font.BOLD,18));
    		g2.draw(new RoundRectangle2D.Double(0,0,467,340,10,10));
    			g2.setColor(new Color(100,100,250));
    		String s2="",m="",h="";
    		if(date1.getSeconds()<=9)s2="0"+date1.getSeconds();
    		else s2=""+date1.getSeconds();
    		
    		if(date1.getMinutes()<=9)m="0"+date1.getMinutes();
    		else m=""+date1.getMinutes();
    		
    			
    		if(date1.getHours()<=9)h="0"+date1.getHours();
    		else h=""+date1.getHours();
    		
    		g2.drawString("Time :"+h+":"+m+":"+s2,15,35);
    		g2.drawString("Date :"+datef,15,60);
    	   
    		}  	
   		  public void  itemStateChanged(ItemEvent e)
   		  	{
   		  		if(e.getStateChange()==ItemEvent.SELECTED)
   		  			{
   		  			  vec.removeAllElements(); getRoom(t5.getSelectedItem()+"");t5val=t5.getSelectedItem()+"";
   		  			}	   		  			
   		  	} 	
   	     	
          
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

 