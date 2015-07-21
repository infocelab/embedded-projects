import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Table extends JPanel 
{  
    Statement st;
    
    ResultSet set;
   JTable tb;;String arr[][]=new String[36][3];
   String arr1[]={"ROOM NO.","ROOM STATUS","ROOM TYPE"};
    int i=0;
      ImageIcon i1=new ImageIcon("res\\haa.gif");
    ImageIcon i2=new ImageIcon("res\\haa.gif");
   j j=new j();
    public Table(Statement st ) 
    {      
    	try{
    	
    	   	
    		this.st=st;
           update();
           
          
    	}catch(Exception e){System.out.print("error");}
            setLayout(new BorderLayout());
            add(new j2(),BorderLayout.NORTH);
            add(j,BorderLayout.CENTER);
        	
    }
    public void update()
    	{
    		 try{
        	
        
        	set=st.executeQuery("Select * from room ");
             
            
            while(set.next())
            	{   
            		
            	    arr[i][0]=set.getString("room_Num"); arr[i][1]=set.getString("stat"); arr[i][2]=set.getString("type");
            		
            		i++;
            	}
            	i=0;
            	tb.repaint();
           }
           catch(Exception e){}
    	}
  
    
    class j extends JPanel
    	{   
    		public j()
    			{
    			setLayout(new BorderLayout());
    			JTable tb=new JTable(arr,arr1)
    			{
    	   	  public boolean isCellEditable(int row, int column)
    	   	   	{
    	   	   		return false;
    	   	   	}	
    	   	};
    			tb.setFont(new Font("Curz MT",Font.BOLD,16));    			
              	tb.setRowHeight(30);
                tb.setAutoResizeMode( JTable.AUTO_RESIZE_NEXT_COLUMN);
                add(JTable.createScrollPaneForTable(tb));
    			}
    		public Dimension getPreferredSize(){return new Dimension(300,300);}	
    			     
    	}
     class j2 extends JPanel 
    	{   
    		
    		public j2()
    			{
    				  
    			setLayout(new FlowLayout(0,0,0));
    			setBackground(new Color(100,100,250));	   
    			 
    		        
    			}
    			public void paint(Graphics g)
    				{
    					super.paint(g);
    					i1.paintIcon(this,g,0,-220);
		 			   i2.paintIcon(this,g,230,-220);
		 			   g.setColor(Color.BLUE);
    					g.setFont(new Font("Cooper Black",Font.BOLD,30));
    					g.drawString("ROOM MONITORING",50,40);
    				
    				}
    			
    		public Dimension getPreferredSize(){return new Dimension(400,70);}	
    			     
    	}
 
    
}