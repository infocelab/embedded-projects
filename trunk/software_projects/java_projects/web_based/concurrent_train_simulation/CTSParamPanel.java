
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *  <b><i><u>Description:</b></i></u>
 *  <br>
 *  	Provides to user the ability to insert values for this simulation
 *	<p>
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
 *  @see CTSDefParameters
 *  @see CTSScreen
 */
public class CTSParamPanel extends JFrame {

	private GridBagConstraints gb1 = new GridBagConstraints();

	private JLabel title = new JLabel("Parameters Setup Panel");
	private JLabel lb1 = new JLabel("Number of Trains:           ");
	private JLabel lb2 = new JLabel("Simulation Speed            ");
	private JLabel lb3 = new JLabel("Default Direction           ");
	private JLabel lb4 = new JLabel("Min Train Ins.Time (in sec) ");
	private JLabel lb5 = new JLabel("Max Train Ins.Time (in sec) ");

	private JTextField tf1 = new JTextField(8);
	private JTextField tf2 = new JTextField(8);
	private JTextField tf3 = new JTextField(8);
	private JTextField tf4 = new JTextField(8);
	private JTextField tf5 = new JTextField(8);

	private JLabel in1 = new JLabel(" Numbers from 0 to 25          ");
	private JLabel in2 = new JLabel(" Numbers from 0 to 2000        ");
	private JLabel in3 = new JLabel(" Numbers from 0 to 1           ");
	private JLabel in4 = new JLabel(" Possitive numbers             ");
	private JLabel in5 = new JLabel(" Numbers greater than Min Time ");

	private JButton set, def, exit;
	private Color backColor;

	private int[] pInfo = new int[5];
	private CTSParameters ctsp;

    /**
     * Constructor for objects of class CTSParamPanel
     */
    public CTSParamPanel(CTSParameters ctsPar) {
		ctsp = ctsPar;
		init();
		setSize(600,300);
		setTitle("C.T.S Parameters Setup Panel");
		show();
    }

	/**
	 * Sets the components.
	 */
    public void init() {
		getContentPane().setLayout(new GridBagLayout());
		backColor=CTSDefParameters.BACK_COLOR;
		getContentPane().setBackground(backColor);

		set = new JButton("Save Values");
		set.setBackground (backColor);
	    set.setForeground (new Color(246,243,218));
	    set.setPreferredSize (new Dimension(110, 25));
		set.setMaximumSize (new Dimension(110, 25));
		set.addActionListener (new ActionListener () {
			public void actionPerformed (ActionEvent evt) {
				saveValues();
			}
		});


		def = new JButton("Show Default");
		def.setBackground (backColor);
	    def.setForeground (new Color(246,243,218));
	    def.setPreferredSize (new Dimension(110, 25));
		def.setMaximumSize (new Dimension(110, 25));
		def.addActionListener (new ActionListener () {
			public void actionPerformed (ActionEvent evt) {
				defaultValues();
			}
		});

		exit = new JButton("Exit");
		exit.setBackground (backColor);
	    exit.setForeground (new Color(246,243,218));
	    exit.setPreferredSize (new Dimension(110, 25));
		exit.setMaximumSize (new Dimension(110, 25));
		exit.addActionListener (new ActionListener () {
			public void actionPerformed (ActionEvent evt) {
				// saves the values
				saveValues();
				// close the panel.
				dispose();
			}
		});

		setLabel(title,0,0,Color.blue);
		setLabel(new JLabel(" "),0,1,Color.white);
		setLabel(lb1,0,2,Color.yellow);
		setTextField(tf1,1,2,Color.white);
		setLabel(in1,2,2,Color.white);
		setLabel(lb2,0,3,Color.yellow);
		setTextField(tf2,1,3,Color.white);
		setLabel(in2,2,3,Color.white);
		setLabel(lb3,0,4,Color.yellow);
		setTextField(tf3,1,4,Color.white);
		setLabel(in3,2,4,Color.white);
		setLabel(lb4,0,5,Color.yellow);
		setTextField(tf4,1,5,Color.white);
		setLabel(in4,2,5,Color.white);
		setLabel(lb5,0,6,Color.yellow);
		setTextField(tf5,1,6,Color.white);
		setLabel(in5,2,6,Color.white);
		setLabel(new JLabel(" "),0,7,Color.white);
		setCons(0,8);
		getContentPane().add(set,gb1);
		setCons(1,8);
		getContentPane().add(def,gb1);
		setCons(2,8);
		getContentPane().add(exit,gb1);
		setCons(2,10);
	}


	/**
	 * Sets the labels for this panel.
	 *
	 * @param label The Label to add
	 * @param grdx  The value of gridx.
	 * @param grdy  The value of gridy.
	 * @param foreColor The Foreground Color.
	 */
	public void setLabel(JLabel label, int grdx, int grdy, Color foreColor) {
		label.setHorizontalAlignment(SwingConstants.LEFT);
		label.setForeground(foreColor);
		label.setBackground(backColor);
		setCons(grdx,grdy);
		getContentPane().add(label,gb1);
	}

	/**
	 * Sets the labels for this panel.
	 *
	 * @param tf The JTextField to add
	 * @param grdx  The value of gridx.
	 * @param grdy  The value of gridy.
	 * @param foreColor The Foreground Color.
	 */
	 public void setTextField(JTextField tf, int grdx, int grdy, Color foreColor) {
		tf.setHorizontalAlignment(SwingConstants.LEFT);
		tf.setForeground(foreColor);
		tf.setBackground(backColor);
		setCons(grdx,grdy);
		getContentPane().add(tf,gb1);
	}


	/**
	 *  Sets the components
	 *
	 *	@param newX The value of gridx
	 *	@param newY The value of gridy
	 */
	public void setCons(int newX, int newY)	{
		gb1.gridx = newX;
		gb1.gridy = newY;
	}


	/**
	 * Saves the current values typed from the user in the textfields.
	 * If the user didnt type anything, default values are saved.
	 */
	public void saveValues() {
			if (tf1.getText().length() !=0)	{
				if (Integer.parseInt(tf1.getText()) > 0 && Integer.parseInt(tf1.getText()) <= CTSDefParameters.MAX_NUMOF_TRAINS)
					pInfo[0] = Integer.parseInt(tf1.getText());
				else
					pInfo[0] = CTSDefParameters.DEF_NUM_OF_TRAINS;
			}
			else {
				tf1.setText(Integer.toString(CTSDefParameters.DEF_NUM_OF_TRAINS));
				pInfo[0] = CTSDefParameters.DEF_NUM_OF_TRAINS;
			}
			if (tf2.getText().length() !=0) {
				if (Integer.parseInt(tf2.getText()) > 0 && Integer.parseInt(tf2.getText()) <= CTSDefParameters.MAX_DELAY)
					pInfo[1] = Integer.parseInt(tf2.getText());
				else
					pInfo[1] = CTSDefParameters.DEF_DELAY;
			}
			else {
				tf2.setText(Integer.toString(CTSDefParameters.DEF_DELAY));
				pInfo[1] = CTSDefParameters.DEF_DELAY;
			}
			if (tf3.getText().length() !=0) {
				if (Integer.parseInt(tf3.getText()) == 0 || Integer.parseInt(tf3.getText()) == 1)
					pInfo[2] = Integer.parseInt(tf3.getText());
				else
					pInfo[2] = CTSDefParameters.DEF_DIRECTION;
			}
			else {
				tf3.setText(Integer.toString(CTSDefParameters.DEF_DIRECTION));
				pInfo[2] = CTSDefParameters.DEF_DIRECTION;
			}
			if (tf4.getText().length() !=0) {
				if (Integer.parseInt(tf4.getText()) >= 0)
					pInfo[3] = Integer.parseInt(tf4.getText());
				else
					pInfo[3] = CTSDefParameters.MIN_INSERTION_TIME;
			}
			else {
				tf4.setText(Integer.toString(CTSDefParameters.MIN_INSERTION_TIME));
				pInfo[3] = CTSDefParameters.MIN_INSERTION_TIME;
			}
			if (tf5.getText().length() !=0) {
				if (Integer.parseInt(tf5.getText()) >= 0 && Integer.parseInt(tf5.getText()) >= Integer.parseInt(tf4.getText()) )
					pInfo[4] = Integer.parseInt(tf5.getText());
				else
					pInfo[4] = CTSDefParameters.MAX_INSERTION_TIME;
			}
			else {
				tf5.setText(Integer.toString(CTSDefParameters.MAX_INSERTION_TIME));
				pInfo[4] = CTSDefParameters.MAX_INSERTION_TIME;
			}
			// update the values in the parameters class.
			ctsp.setParameters(pInfo);
	} // end of method saveValues().

	/**
	 * Saves the current values typed from the user in the textfields.
	 * If the user didnt type anything, default values are saved.
	 */
	public void defaultValues() {
		tf1.setText(Integer.toString(CTSDefParameters.DEF_NUM_OF_TRAINS));
		tf2.setText(Integer.toString(CTSDefParameters.DEF_DELAY));
		tf3.setText(Integer.toString(CTSDefParameters.DEF_DIRECTION));
		tf4.setText(Integer.toString(CTSDefParameters.MIN_INSERTION_TIME));
		tf5.setText(Integer.toString(CTSDefParameters.MAX_INSERTION_TIME));
	} // end of method defaultValues()

	/*
	 * Returns the values.
	 *
	 * @return an array of the stored values.
	 */
	public int[] getValues() {
		saveValues();
		return pInfo;
	} // end of method getValues()


    /**
     * The main method of this class.
     *
     * @param: The arguments.
     **/
	public static void main(String[] args) {
		CTSParamPanel myPanel = new CTSParamPanel(new CTSParameters());
	} //end of main method
} // end of class CTSParamPanel()
