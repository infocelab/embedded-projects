import javax.swing.*;
import java.awt.*;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JWindow;

public class frmSplash extends JWindow implements Runnable{
	public void run(){
		JLabel SplashLabel = new JLabel(new ImageIcon("pic.png"));
		
		Dimension screen = 	Toolkit.getDefaultToolkit().getScreenSize();
		
		getContentPane().add(SplashLabel,BorderLayout.CENTER);
		
		setSize(600,500);
		setLocation((screen.width - 490)/2,((screen.height-300)/2));
		show();
	}
}