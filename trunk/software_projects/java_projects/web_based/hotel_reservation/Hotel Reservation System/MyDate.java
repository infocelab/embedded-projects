
import javax.swing.*;
import java.awt.event.*;import java.util.*;
import java.awt.*;

public class MyDate extends Panel implements ItemListener
{
    JComboBox m;JComboBox d;JComboBox y;
    String sm[]={"January","February","March","April","May","June","July","August","September","October","November","December"};
    String sy[]={"2009","2010","2011","2012","2013","2014","2015"}; 
    Vector vec;String date;
   
    public MyDate()
    {   
    	vec=new Vector();
    	for(int i=0;i<31;i++)
    			{
    				
    				vec.addElement((i+1)+"");
    			}
    	Box v=Box.createHorizontalBox();
    		Box v2=Box.createVerticalBox();
    
        y=new JComboBox(sy);
    	m=new JComboBox(sm);m.addItemListener(this);
    	d=new JComboBox(vec);
    	
    	v.add(m);
    	v.add(d);
    	v2.add(y);v2.add(v);
    	add(v2);
    
    	repaint();
    }
    public void paintComponent(Graphics g)
    	{
    		super.paint(g);
    		y.repaint();
    		m.repaint();
    		d.repaint();
    		
    	}
    public void  itemStateChanged(ItemEvent e)
   		  	{  String sel="";
   		  		if(e.getStateChange()==ItemEvent.SELECTED)
   		  			{
   		  			    sel= m.getSelectedItem()+"" ;
   		  			   if(sel.equalsIgnoreCase("January")||sel.equalsIgnoreCase("March")||sel.equalsIgnoreCase("May")||sel.equalsIgnoreCase("July")||sel.equalsIgnoreCase("August")||sel.equalsIgnoreCase("October")||sel.equalsIgnoreCase("December"))
   		  			   	{
   		  			   		
   		  			   		if(!vec.contains("30"))vec.addElement("30");
   		  			   		if(!vec.contains("31")){vec.addElement("31");d.repaint();}
   		  			   		   
   		  			   	}
   		  			   else if(sel.equalsIgnoreCase("February"))
   		  			   	{
   		  			   		vec.removeElement("31");vec.removeElement("30");d.repaint();
   		  			   	}
   		  			   	else
   		  			   		{   
   		  			   			vec.removeElement("31"); 
   		  			   			if(!vec.contains("30"))vec.addElement("30");d.repaint();

   		  			   		} 
   		  			   	d.repaint();		   
   		  			   	}
   		  		  		   		  			
   		  	      	
   		  	}
   public String day()
   	{
   				String date=(m.getSelectedIndex()+1)+"/"+d.getSelectedItem()+"/"+y.getSelectedItem();
   		  		
   		  		return date;
   	}
   			  	
   
}