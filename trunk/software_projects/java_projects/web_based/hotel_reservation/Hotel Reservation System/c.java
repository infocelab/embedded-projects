import javax.swing.*;
import java.awt.geom.*;
import java.awt.event.*;
import java.awt.*;

public class c extends JPanel 
{   
   
    
    ImageIcon i=new ImageIcon("res\\rain.gif");
    ImageIcon i2=new ImageIcon("res\\rain.gif");
    ImageIcon i3=new ImageIcon("res\\rain.gif");
	public c()
	{
	 
		  
	 setBackground(Color.BLACK);    
	
	
     
	}
	public void paintComponent(Graphics g)
		{
			super.paintComponent(g);
			Graphics2D g2d=(Graphics2D)g;
		    i.paintIcon(this,g2d,0,-220);
		    i2.paintIcon(this,g2d,250,-150);
		    i3.paintIcon(this,g2d,500,-150);
		    	
			g2d.setFont(new Font("Algerian",Font.BOLD,50));
		
			
			g2d.setPaint(new GradientPaint(50,50,Color.BLUE,100,100,Color.YELLOW));
			
			g2d.drawString("BONAIR INN",20,60);
		}
   public  Dimension getPreferredSize()
    {
    	return new Dimension(400,100);
    }
	
	
	 	
}
 