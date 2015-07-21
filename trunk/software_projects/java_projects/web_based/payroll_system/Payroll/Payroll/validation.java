import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
public class validation
{
	public static void keyEvent(JTextField tf,boolean b)
	{
		if(b==false)
		{
			tf.addKeyListener(new KeyListener()
			{

				public void keyPressed(KeyEvent e){}
				public void keyTyped(KeyEvent ee)
				{
					char c = ee.getKeyChar ();
					int kk=ee.getKeyCode();
					if (!((Character.isDigit (c)) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_PERIOD) || (kk == 110)))
					{
						Toolkit.getDefaultToolkit().beep ();
						ee.consume ();
					}
				}
				public void keyReleased(KeyEvent eee){}
			});
		}
		else
		{
			tf.addKeyListener(new KeyListener()
			{
				public void keyPressed(KeyEvent e){}
				public void keyTyped(KeyEvent ee)
				{
					char c = ee.getKeyChar ();
					if ((Character.isDigit (c)))
					{
						Toolkit.getDefaultToolkit().beep ();
						ee.consume ();
					}
				}
				public void keyReleased(KeyEvent eee){}
			});
		}
	}
}