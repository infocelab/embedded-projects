/**
 *  <b><i><u>Description:</b></i></u>
 *  <br>
 *  This is the class for defining the credit panel.<br>
 *  Its showing information about the author and the project.<p>
 *
 *  <b>Project Web Site:</b><i><br>
 *  <a href="http://www.geocities.com/cts">www.geocities.com/ctsproj</a><i>
 *
 *  @author <img src="my_img.jpg" width="56" height="70" alt="Author's photo" border="0">
 *   		<br>
 *          <a href="mailto: dimtsan@hotmail.com"><b>Jim Tsanakaliotis</b></a>
 *          <br>
 *          Author web site: <a href="http://www.geocities.com/dimtsan">http://www.geocities.com/dimtsan</a>
 *  @version <font color=red><b>1.0</font><i> &nbsp * 06 April 2001 *</b></i>
 *  @see CTSScreen
 */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class CTSCreditPanel extends JPanel implements ActionListener {
	private ImageIcon			scrollText, scrollTr;
	private int 				x,y, trDir;
	private Timer				timer;
	private GridBagConstraints 	ctsCons;

	/**
	 * Constructor of this class.
	 */
	public CTSCreditPanel() {
		x=10;
		y=400;
		trDir=1;
		timer = new Timer(20,this);
		ctsCons = new GridBagConstraints();
		scrollText = new ImageIcon(getClass().getResource("images/scroll_text.gif"));
		scrollTr = new ImageIcon(getClass().getResource("images/scroll_train.gif"));
		initComponents();
		timer.start();
	} //end of constructor

    /**
     *  Sets the components.<br>
     *  Haddles initialization of the components and sets their properties.
     *
     *  @param g: A Graphics object
     **/
	public void initComponents() {
		setLayout(new BorderLayout());
		setBackground(CTSDefParameters.BACK_COLOR);
		// setup the logo label
		JLabel ctsLogo = new JLabel();
		ctsLogo.setMinimumSize(new Dimension(700, 500));
		ctsLogo.setIcon(new ImageIcon(getClass().getResource("images/ctsLogo.gif")));
		add(ctsLogo, BorderLayout.NORTH);
	} //end of method

    /**
     *  Paints the components on the panel.
     *
     *  @param g: A Graphics object
     **/
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(scrollText.getImage(),250,y,null);
		g.drawImage(scrollTr.getImage(),x,120,null);
		if(x<-110) { x=700; }
		if(y<-600) { y=550; }
	} //end of method

    /**
     *  Hadles the actionEvents.
     *
     *  @param evt: The action event.
     **/
	public void actionPerformed(ActionEvent evt) {
		//for the scrolling text-animation
		y-=2;
		//for the scrolling train animation
		x-=2;
		repaint();
	}
}//end of class

