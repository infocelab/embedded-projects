import java.awt.event.*;
import java.awt.*;
class NumberValid extends KeyAdapter
{
	public void keyTyped(KeyEvent e)
	{
		char ch=e.getKeyChar();
		if(ch < '0' || ch > '9')
		{
			 Toolkit.getDefaultToolkit().beep();
			e.consume();
		}
	}
}