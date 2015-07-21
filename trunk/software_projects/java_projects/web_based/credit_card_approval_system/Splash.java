import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Splash extends JWindow {
	
  private int duration;
  JLabel stats = new JLabel("Status Message Here", JLabel.CENTER);


  public Splash(int d,boolean useSleep) {

    duration = d;
    JPanel content = (JPanel) getContentPane();
    content.setLayout(new BorderLayout());
    int width = 403;
    int height = 323;

    Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();

    int x = (screen.width - width) / 2;
    int y = (screen.height - height) / 2;
    setBounds(x, y, width, height);
		

    JLabel label = new JLabel(new ImageIcon("splash.gif"));
    content.add(label, BorderLayout.CENTER);
    content.add(stats, BorderLayout.SOUTH);
    Color dColor = new Color(0, 0, 0, 255);
    content.setBorder(BorderFactory.createLineBorder(dColor, 1));

		if(useSleep){
    	setVisible(true);
	    try {
	      Thread.sleep(duration);
	    } 
	    catch (Exception e) {
	    }
	    setVisible(false);
    }
  }
  public void setStatus(String thisStat){
  	stats.setText(thisStat);
  }
  public void setVisible(boolean cond){
  	super.setVisible(cond);
  	
  }
  public void sleep(int ms){
  	try{
  		Thread.sleep(ms);
  	}
  	catch(Exception e){}
  }
}

