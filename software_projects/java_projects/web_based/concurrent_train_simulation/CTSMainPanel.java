/**
 *  <b><i><u>Description:</b></i></u>
 *  <br>
 *       This class sets the main controller buttons of this application.
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
 *
 *  @version <font color=red><b>1.0</font><i> &nbsp * 06 April 2001 *</b></i>
 *  @see CTSScreen
 */

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

public class CTSMainPanel extends JPanel {
	private GridBagConstraints 		ctsCons;
	private JButton 				controlButton, helpButton,
									navButton, quitButton, paramButton,tstatsButton;
	private CTS cts;
	private CTSScreen screen;
	private boolean credits,editp,tstats;
	private char control;
	private CTSParameters ctsp;
	private Color backColor;
	private JMenuItem p1,p2,p3,p4,p5;
	private JPopupMenu pmenu;
	private JSlider slider;
	private JLabel	sliderValue;
	private CTSMapPanel mapPanel;

    /**
     *  Constructor
     *
     *  @param mapP The current map of this application
     *  @param ctsP The parameters.
     *  @param ct   The main controller of this application.
     *  @param scr  The screen
	 *  @param stats  The stats controller
     **/
	public CTSMainPanel(CTSMapPanel mapP, CTSParameters ctsP, CTS ct, CTSScreen scr,CTSStatsPanel statsPanel) {
		mapPanel=mapP;
		ctsp=ctsP;
		cts=ct;
		screen=scr;
		control='s';
		credits=false;
		tstats=false;
		editp=false;
		backColor=CTSDefParameters.BACK_COLOR;
		initComponents();
	} //end of constructor


	/**
	 * 	Sets the components.
	 */
	public void initComponents() {
		setLayout (new GridBagLayout());
		setBackground(backColor);
		ctsCons = new GridBagConstraints();
		slider=new JSlider();

		controlButton = new JButton("Start");
		paramButton = new JButton("Set Param");
		helpButton = new JButton("Help");
		navButton = new JButton("Credits");
		tstatsButton = new JButton("Train Stats");
		quitButton = new JButton("Quit");
		addButton(controlButton,"Start",80,0,0);
		addButton(paramButton,"Set/View Parameters",115,1,0);
		addButton(helpButton,"Info about the simulation",80,2,0);
		addButton(navButton,"Credits/Map Button",115,3,0);
		addButton(tstatsButton,"Train Stats/Map Button",115,4,0);
		addButton(quitButton,"Exit CTS application",80,5,0);

		// setup popup menu.
		pmenu = new JPopupMenu(" Current Parameters on this Simulation ");
		p1 = new JMenuItem(ctsp.getParName(0)+" : "+Integer.toString(ctsp.getParValue(0)));
		p2 = new JMenuItem(ctsp.getParName(1)+" : "+Integer.toString(ctsp.getParValue(1)));
		p3 = new JMenuItem(ctsp.getParName(2)+" : "+Integer.toString(ctsp.getParValue(2)));
		p4 = new JMenuItem(ctsp.getParName(3)+" : "+Integer.toString(ctsp.getParValue(3)));
		p5 = new JMenuItem(ctsp.getParName(4)+" : "+Integer.toString(ctsp.getParValue(4)));
		p1.setBackground(backColor);
		p2.setBackground(backColor);
		p3.setBackground(backColor);
		p4.setBackground(backColor);
		p5.setBackground(backColor);
		p1.setForeground(Color.white);
		p2.setForeground(Color.white);
		p3.setForeground(Color.white);
		p4.setForeground(Color.white);
		p5.setForeground(Color.white);
		pmenu.setBackground(backColor);
		pmenu.add(p1);
		pmenu.add(p2);
		pmenu.add(p3);
		pmenu.add(p4);
		pmenu.add(p5);

		// set up Action Listeners
		controlButton.addActionListener (new ActionListener () { //add an ActionListener to this button
			public void actionPerformed (ActionEvent evt) {
				switch(control) {
					case 's':
						cts.start();
						control='p';
						controlButton.setText("Pause");
						editp=true;
						paramButton.setText("View Param");
					break;
					case 'p':
						cts.pause();
						control='r';
						mapPanel.setPause(true);
						controlButton.setText("Restart");
					break;
					case 'r':
						cts.restart();
						control='p';
						mapPanel.setPause(false);
						controlButton.setText("Pause");
					break;
				}
			}
		});

		paramButton.addActionListener (new ActionListener () { //add an ActionListener to this button
			public void actionPerformed (ActionEvent evt) {
				if (!editp) {
					CTSParamPanel panel = new CTSParamPanel(ctsp);
				}
				// else if app already started.
				else {
					p1.setText(ctsp.getParName(0)+" : "+Integer.toString(ctsp.getParValue(0)));
					p2.setText(ctsp.getParName(1)+" : "+Integer.toString(ctsp.getParValue(1)));
					p3.setText(ctsp.getParName(2)+" : "+Integer.toString(ctsp.getParValue(2)));
					p4.setText(ctsp.getParName(3)+" : "+Integer.toString(ctsp.getParValue(3)));
					p5.setText(ctsp.getParName(4)+" : "+Integer.toString(ctsp.getParValue(4)));
					pmenu.show(screen,100,100);
				}

			}
		});
		helpButton.addActionListener (new ActionListener () { //add an ActionListener to this button
			public void actionPerformed (ActionEvent evt) {
				CTSHelpPanel helpPanel = new CTSHelpPanel();
			}
		});
		navButton.addActionListener (new ActionListener () {
			public void actionPerformed (ActionEvent evt) { //add an ActionListener to this button
				if(!credits) {
					screen.setTabIndex(1);
					navButton.setText("Back to Map");
					credits=true;
				} else {
					screen.setTabIndex(0);
					navButton.setText("Credits");
					credits=false;
				}
			}
		});
		tstatsButton.addActionListener (new ActionListener () {
			public void actionPerformed (ActionEvent evt) { //add an ActionListener to this button
				if(!tstats) {
					screen.setTabIndex(2);
					tstatsButton.setText("Back to Map");
					tstats=true;
				} else {
					screen.setTabIndex(0);
					tstatsButton.setText("Train Stats");
					tstats=false;
				}
			}
		});
		quitButton.addActionListener (new ActionListener () { //add an ActionListener to this button
			public void actionPerformed (ActionEvent evt) {
				System.exit(0);
			}
		});

		ctsCons.gridx = 0;
		ctsCons.gridy = 1;
		add(new JLabel(" ") ,ctsCons);

		sliderValue = new JLabel("Cycle interval: "+ctsp.DELAY+" ms");
		sliderValue.setBackground(backColor);
		sliderValue.setForeground(new Color(246,243,218));
		ctsCons.gridx = 0;
		ctsCons.gridy = 2;
		ctsCons.gridwidth = 2;
		add(sliderValue ,ctsCons);

		slider.setBackground(backColor);
		slider.setMinorTickSpacing(100);
		slider.setMinimum(CTSDefParameters.MIN_DELAY);
		slider.setMaximum(CTSDefParameters.MAX_DELAY);
		slider.setValue(ctsp.DELAY);
		slider.setPaintTicks(true);
	    slider.setForeground(new Color(246,243,218));
	    slider.setPreferredSize (new Dimension(200, 25));
		ctsCons.gridx = 1;
		ctsCons.gridy = 2;
		ctsCons.gridwidth = 4;
		add(slider ,ctsCons);
		slider.addChangeListener(new ChangeListener() { //add a ChangeListener to the slider
		    public void stateChanged(ChangeEvent evt) {
				setSliderLabel();
		    }
		});
	} //end of method


	/**
	 * 	Adds a button to the panel.
	 */
	public void addButton(JButton button,String toolTipText,int wid, int grdx, int grdy) {
		button.setToolTipText (toolTipText);
		button.setBackground (backColor);
		button.setForeground (new Color(246,243,218));
		button.setPreferredSize (new Dimension(wid, 25));
		button.setMaximumSize (new Dimension(wid, 25));
		ctsCons.gridx = grdx;
		ctsCons.gridy = grdy;
		add(button ,ctsCons);
	}


	/**
	 * 	Sets some actions related to the beggining of the application.
	 */
	public void setStartup() {
		slider.setValue(ctsp.DELAY);
		setSliderLabel();
	}

	/**
	 * Method that updates the label with the cycle interval.
	 **/
	public void setSliderLabel() {
		sliderValue.setText("Cycle interval: " + slider.getValue() + " ms ");
	}

	/**
	 *  Method that returns the value of the slider.
	 **/
	public int getTimerValue() {
		return slider.getValue();
	}
} //end of class
