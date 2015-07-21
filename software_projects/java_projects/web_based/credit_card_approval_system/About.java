import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class About extends JDialog implements MouseListener, KeyListener {

	JPanel content = (JPanel) getContentPane();
	JLabel label = new JLabel(new ImageIcon("about4.gif"));
	
	EasierGridLayout dLayout = new EasierGridLayout();

    public About(JFrame parent) {
		super(parent, true);
		addMouseListener(this);
		addKeyListener(this);
		
		content.setBackground(Color.BLACK);
		content.setLayout(dLayout);		
		dLayout.Center(label,1,1,2,2);		
		content.add(label);
		
	    int width = 400;
	    int height = 320;
	
	    Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
	
	    int x = (screen.width - width) / 2;
	    int y = (screen.height - height) / 2;
	    setBounds(x, y, width, height);
		setUndecorated(true);
	    Color dColor = new Color(0, 0, 0, 255);
	    content.setBorder(BorderFactory.createLineBorder(dColor, 1));
		show();
    }

    //public static void main(String[] args) {
	//new About2(null);
    //}

    public void mouseClicked(MouseEvent e) {
	    setVisible(false);
   	}

    public void mousePressed(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public void keyPressed(KeyEvent e) {
    	setVisible(false);
    }

    public void keyReleased(KeyEvent e) {
    }

    public void keyTyped(KeyEvent e) {
    }
}
