import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

public class JSplash extends JWindow {
    
    private JLabel splashImage;
    private JLabel ime;
    private JPanel panel;
    private Dimension screensize;
    
    private static String statusString = "";
    
    private Image image;
    
    public JSplash(JFrame parent) {
        super(parent);
        splashImage = new JLabel(new ImageIcon(getClass().getResource(
                   "images/tracksplash.jpg")));

        getContentPane().add(splashImage, BorderLayout.CENTER);
        
        pack();
        
        screensize = Toolkit.getDefaultToolkit().getScreenSize();
        
        setLocation((screensize.width / 2) - (getSize().width / 2),
                    (screensize.height / 2) - (getSize().height / 2));
        
        splashImage.setBorder(BorderFactory.createLineBorder(
                          new Color(75, 75, 75)));
                          
    }        
}
