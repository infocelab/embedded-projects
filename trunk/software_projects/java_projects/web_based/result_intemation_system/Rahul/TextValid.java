import java.awt.event.*;
import java.awt.*;
class TextValid extends KeyAdapter
{
	public void keyTyped(KeyEvent e)
	{
		char ch=e.getKeyChar();
		if((ch >= 'a' && ch <='z')||(ch >='A' && ch <='Z'))
		{
		}
		else
		{
			 Toolkit.getDefaultToolkit().beep();
			e.consume();
		}
	}
}