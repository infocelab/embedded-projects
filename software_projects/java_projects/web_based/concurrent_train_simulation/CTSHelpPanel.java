
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *  <b><i><u>Description:</b></i></u>
 *  <br>
 *       This class provide basic information about the behaviour of the <br>
 *       basic elements of this sim, such as trains, etc ,,,
 *	<p>
 *  <b>Project Web Site:</b><i>
 *  <br>
 *  <a href="http://www.geocities.com/cts">http://www.geocities.com/ctsproj</a><i>
 *
 *  @author <img src="my_img.jpg" width="56" height="70" alt="Author's photo" border="0">
 *   		<br>
 *          <a href="mailto: dimtsan@hotmail.com"><b>Jim Tsanakaliotis</b></a>
 *          <br>
 *          Author web site: <a href="http://www.geocities.com/dimtsan">http://www.geocities.com/dimtsan</a>
 *  @version <font color=red><b>1.0</font><i> &nbsp * 06 April 2001 *</b></i>
 *  @see CTSScreen
 */
public class CTSHelpPanel extends JFrame {

	private GridBagConstraints gb1 = new GridBagConstraints();
	private JTabbedPane ctsPane = new JTabbedPane();
	private Color backColor;

    /**
     * Constructor for objects of class ctsHelpPanel
     */
    public CTSHelpPanel() {
		getContentPane().setLayout(new GridBagLayout());
		backColor = CTSDefParameters.BACK_COLOR;
		getContentPane().setBackground(backColor);
		init();
		setTitle("C.T.S Help Panel");
		setSize(600,500);
		show();
    }

	/**
	 * 	Sets the components.
	 */
    public void init() {
		TrBehaviour trb	= new TrBehaviour();
		ctsHButPanel	bPanel = new ctsHButPanel();

		ctsPane.setForeground(Color.blue);
		ctsPane.addTab("Trains Behaviour", trb);

		gb1.gridx = 0;
		gb1.gridy = 0;
		getContentPane().add(ctsPane,gb1);

		ctsHButPanel ctsButtons = new ctsHButPanel();
		gb1.gridx = 0;
		gb1.gridy = 1;
		getContentPane().add(ctsButtons,gb1);
	}


	/**
	 * 	Sets the constraints.
	 */
	public void setCons(int newX, int newY) {
		gb1.gridx = newX;
		gb1.gridy = newY;
	}


    /**
     * The main method of this class.
     *
     * @param: The arguments.
     **/
	public static void main(String[] args) {
		CTSHelpPanel test = new CTSHelpPanel();
	}

/**
 *  <b><i><u>Description:</b></i></u>
 *  <br>
 *       Sets the labels of the CTSHelpPanel objects.
 *	<p>
 *  <b>Project Web Site:</b><i>
 *  <br>
 *  <a href="http://www.geocities.com/cts">http://www.geocities.com/cts</a><i>
 *
 *  @author <a href="mailto: dimtsan@hotmail.com"><b>Jim Tsanakaliotis</b></a>
 *          <br>
 *          Author web site: <a href="http://www.geocities.com/dimtsan">http://www.geocities.com/dimtsan</a>
 *
 *  @version <font color=red><b>1.0</font><i> &nbsp * 06 April 2001 *</b></i>
 */
 class ctsLabel extends JLabel {
    /**
     * Constructor for objects of class ctsLabel
     */
    public ctsLabel(String str) {
		super(str);
		setForeground(Color.white);
    }
 } // end of class ctsLabel


/**
 *  <b><i><u>Description:</b></i></u>
 *  <br>
 *       Sets the information about the trains behaviour.
 *	<p>
 *  <b>Project Web Site:</b><i>
 *  <br>
 *  <a href="http://www.geocities.com/cts">http://www.geocities.com/cts</a><i>
 *
 *  @author <a href="mailto: dimtsan@hotmail.com"><b>Jim Tsanakaliotis</b></a>
 *          <br>
 *          Author web site: <a href="http://www.geocities.com/dimtsan">http://www.geocities.com/dimtsan</a>
 *
 *  @version <font color=red><b>1.0</font><i> &nbsp * 06 April 2001 *</b></i>
 */
public class TrBehaviour extends JPanel
{
	private GridBagConstraints gb1 = new GridBagConstraints();

    /**
     * Constructor for objects of class TrBehaviour
     */
    public TrBehaviour()
    {
		setLayout(new GridBagLayout());
		setBackground(backColor);
		setCons(0,0);
		JLabel aLabel = new JLabel(" Trains Behaviour ");
		aLabel.setForeground(Color.red);
		add(aLabel,gb1);
		setCons(0,1);
		add(new JLabel("   "),gb1);
		setCons(0,2);
		add(new ctsLabel(" Trains insert the station at the beggining at a cycle between        "),gb1);
		setCons(0,3);
		add(new ctsLabel(" 3 and 6 seconds. When the trains currently on map are equal to       "),gb1);
		setCons(0,4);
		add(new ctsLabel(" the maximum number of trains we specified no more trains are coming. "),gb1);
		setCons(0,5);
		add(new ctsLabel(" Trains can move to both directions. When a trains leaves from station"),gb1);
		setCons(0,6);
		add(new ctsLabel(" its locking both the path and the plat on the next station its going "),gb1);
		setCons(0,7);
		add(new ctsLabel(" to arrive. Its checking if the path if free first, then if there is  "),gb1);
		setCons(0,8);
		add(new ctsLabel(" any free plat at the next station. If both plat are free then its    "),gb1);
		setCons(0,9);
		add(new ctsLabel(" choosing the one that have same direction trains on it. If no train  "),gb1);
		setCons(0,10);
		add(new ctsLabel(" is in both plat then plat 0 its chosen by default. If others trains  "),gb1);
		setCons(0,11);
		add(new ctsLabel(" coming, then the train waits until all others can pass by.           "),gb1);
		setCons(0,12);
		add(new ctsLabel(" ***  Express Trains ***        "),gb1);
		setCons(0,13);
		add(new ctsLabel(" If the trains is an express then the train is not stopping at the    "),gb1);
		setCons(0,14);
		add(new ctsLabel(" stations. When an express train exits a station is locking the next  "),gb1);
		setCons(0,15);
		add(new ctsLabel(" 2 stations so it can move faster than the other trains. This however "),gb1);
		setCons(0,16);
		add(new ctsLabel(" will be done, after a time of 150 sec, so we ensure we will not have "),gb1);
		setCons(0,17);
		add(new ctsLabel(" a colision between express and new trains on map. Future version will "),gb1);
		setCons(0,18);
		add(new ctsLabel(" support less time.  "),gb1);
	}


    /**
     *  Sets the constraints of this layout.
     */
	public void setCons(int newX, int newY)
	{
		gb1.gridx = newX;
		gb1.gridy = newY;
	}
} // end of class TrBehaviour.


/**
 *  <b><i><u>Description:</b></i></u>
 *  <br>
 *       Sets the buttons of this panel.
 *	<p>
 *  <b>Project Web Site:</b><i>
 *  <br>
 *  <a href="http://www.geocities.com/cts">http://www.geocities.com/cts</a><i>
 *
 *  @author <a href="mailto: dimtsan@hotmail.com"><b>Jim Tsanakaliotis</b></a>
 *          <br>
 *          Author web site: <a href="http://www.geocities.com/dimtsan">http://www.geocities.com/dimtsan</a>
 *
 *  @version <font color=red><b>1.0</font><i> &nbsp * 06 April 2001 *</b></i>
 */
public class ctsHButPanel extends JPanel
{

	private GridBagConstraints gb1 = new GridBagConstraints();
	private JButton trains, close;

    /**
     * Constructor for objects of class ctsHButPanel
     */
    public ctsHButPanel()
    {
		setLayout(new GridBagLayout());
		setBackground(backColor);

		trains = new JButton("Trains Behav.");
		trains.setBackground (backColor);
	    trains.setForeground (new Color(246,243,218));
	    trains.setPreferredSize (new Dimension(150, 25));
		trains.setMaximumSize (new Dimension(150, 25));
		gb1.gridx = 0;
		gb1.gridy = 0;
		add(trains ,gb1);
		trains.addActionListener (new ActionListener () {
			public void actionPerformed (ActionEvent evt) {
				ctsPane.setSelectedIndex(0);
			}
		});

		close = new JButton("Close");
		close.setBackground (Color.red);
	    close.setForeground (new Color(246,243,218));
	    close.setPreferredSize (new Dimension(110, 25));
		close.setMaximumSize (new Dimension(110, 25));
		gb1.gridx = 1;
		gb1.gridy = 0;
		add(close ,gb1);
		close.addActionListener (new ActionListener () {
			public void actionPerformed (ActionEvent evt) {
				dispose();
			}
		});
	}
} // end of class ctsHButPanel
} // end of class ctsHelpPanel.
