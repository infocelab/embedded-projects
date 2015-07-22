import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Casa extends JPanel{
  	private boolean sel = false;
  	private boolean possivel = false;
  	private boolean dama = false;
  	private Color selColor = null;
  	private Color posColor = null;
	private Graphics canvas = null;
	
	public void paintComponent( Graphics g ){
	  canvas = g;
	  super.paintComponent( g );
	  g.fillOval( 5, 5, super.getWidth() -10, super.getHeight() - 10);
	  if (sel){
		canvas.setColor(selColor);
		canvas.drawRect(0,0, super.getWidth()-1, super.getHeight()-1);
		canvas.drawRect(1,1, super.getWidth()-3, super.getHeight()-3);
	  }
  	  if (possivel){
		canvas.setColor(posColor);
		canvas.drawRect(0,0, super.getWidth()-1, super.getHeight()-1);
		canvas.drawRect(1,1, super.getWidth()-3, super.getHeight()-3);
	  }
	  if (dama){
		canvas.setColor(Color.yellow);
		g.fillOval( 15, 15, super.getWidth() -30, super.getHeight() - 30);
	  }

	}
	
	public void seleciona(boolean s, Color cor){
		sel = s;
		selColor = cor;
		repaint();
	}
	
    public void setPossivel(boolean s, Color cor){
		possivel = s;
		posColor = cor;
		repaint();
	}	
	
	public void setDama(boolean valor){
		dama = valor;
	}	
	
	public boolean isPossivel(){
		return possivel;
	}
	
	public boolean isSelected(){
		return sel;
	}
	
	public boolean isDama()	{
		return dama;
	}
	
	// the following methods are used by layout managers
	public Dimension getPreferredSize()	{
	  return new Dimension( 50, 50 );
	}
	
	public Dimension getMinimumSize() {
	  return getPreferredSize();
	}
	
}