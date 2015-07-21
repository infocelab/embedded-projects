import javax.swing.*;
import java.awt.*;

public interface mainInterface
{
	public static Splash splash3 = new Splash("Starting App...");
	public Thread th = new Thread(splash3);
	public ImageIcon splPic = new ImageIcon("splash.gif");
	public JLabel l = new JLabel(splPic);
	public JWindow splashWindow = new JWindow();
	public Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
}