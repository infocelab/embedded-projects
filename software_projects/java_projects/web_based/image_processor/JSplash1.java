import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
public class JSplash1 extends JFrame
{
    private JLabel splashImage;
    private JLabel ime;
    private JPanel panel;
    private Dimension screensize;
    private static String statusString = "";
    private Image image;
    public JSplash1()
    {
        //super(parent);
setTitle("IMAGE PROCESSOR ABOUT PROJECT");
        splashImage = new JLabel(new ImageIcon(getClass().getResource(
                   "splash3.jpg")));
        getContentPane().add(splashImage, BorderLayout.CENTER);
        pack();
        screensize = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((screensize.width / 2) - (getSize().width / 2),
                    (screensize.height / 2) - (getSize().height / 2));
        splashImage.setBorder(BorderFactory.createLineBorder(		
                          new Color(75, 75, 75)));
    }
}