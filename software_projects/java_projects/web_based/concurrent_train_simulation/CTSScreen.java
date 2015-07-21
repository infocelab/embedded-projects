
/**
 *  <b><i><u>Description:</b></i></u>
 *  <br>
 *      This sets the screen
 *  <p>
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
 *  @see CTSMainPanel
 *  @see CTSMapPanel
 *  @see CTSHelpPanel
 *  @see CTSTStatsPanel
 *  @see CTSStatsPanel
 */

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class CTSScreen extends JFrame {
	private GridBagLayout 			ctsLayout;
	private GridBagConstraints		ctsCons;
	private Color					backColor;
	private JTabbedPane 			ctsPane;
	private CTSMainPanel			ctsMainPanel;
	private CTSStatsPanel			ctsStatsPanel;
	private CTSMapPanel				ctsMapPanel;
	private CTSCreditPanel			ctsCreditPanel;
	private CTSTStatsPanel          ctsTStatsPanel;
	private CTSStats  				stats;
	private CTS						cts;
	private CTSParameters 			ctsp;
	private WindowAdapter     	 	WAdapter;

    /**
     * Constructor for objects of class CTSParamPanel
     *
     * @param ctsP the parameters
     * @param ct the main controller class
     * @param st the stats Obj.
     */
	public CTSScreen(CTSParameters ctsP, CTS ct, CTSStats st) {
		ctsLayout = new GridBagLayout();
		ctsCons = new GridBagConstraints();
		ctsp=ctsP;
		stats=st;
		cts=ct;
		backColor = CTSDefParameters.BACK_COLOR;
		createScreen();
    	setSize(800, 620);
    	setTitle(" *** Concurrent Train Simulation (C.T.S) Project *** @ Monash University ~ School of Network Computing ***");
    	show();
 	 }

	/**
	 *  Creates the screen with the panels
	 */
	public void createScreen() {
		getContentPane().setLayout(ctsLayout);
		getContentPane().setBackground(backColor);
		ctsStatsPanel = new CTSStatsPanel(cts,stats);
		ctsMapPanel = new CTSMapPanel();
		ctsMainPanel = new CTSMainPanel(ctsMapPanel,ctsp,cts,this,ctsStatsPanel);
		ctsTStatsPanel = new CTSTStatsPanel(stats,ctsp);
		ctsCreditPanel = new CTSCreditPanel();

		// setup the JTabbedPane.
		ctsPane = new JTabbedPane();
		ctsPane.setPreferredSize(new java.awt.Dimension(670, 500));
		ctsPane.setMinimumSize(new java.awt.Dimension(670, 500));
		ctsCons.gridx = 0;
		ctsCons.gridy = 0;
		ctsCons.anchor = java.awt.GridBagConstraints.WEST;
		ctsLayout.setConstraints(ctsPane, ctsCons);
		getContentPane().add(ctsPane);

		ctsPane.addTab("Simulation", ctsMapPanel);
		ctsPane.addTab("Credits", ctsCreditPanel);
		ctsPane.addTab("Train Stats", ctsTStatsPanel);

		ctsMainPanel.setPreferredSize(new java.awt.Dimension(600, 80));
		ctsMainPanel.setMinimumSize(new java.awt.Dimension(600, 80));
		ctsCons.gridx = 0;
		ctsCons.gridy = 1;
		ctsCons.anchor = java.awt.GridBagConstraints.WEST;
		getContentPane().add(ctsMainPanel, ctsCons);

		ctsStatsPanel.setPreferredSize(new java.awt.Dimension(130, 600));
		ctsStatsPanel.setMinimumSize(new java.awt.Dimension(130, 600));
		ctsCons.gridx = 1;
		ctsCons.gridy = 0;
		ctsCons.gridheight = 2;
		getContentPane().add(ctsStatsPanel, ctsCons);

		createWindowListener();
	}


    /**
     *  Sets some extra action when we start the simulation.
     **/
	public void setStartup() {
		ctsMainPanel.setStartup();
		ctsTStatsPanel.setStartup();
	}

	/**
	 * This method is called every cycle from the SOEngine.
	 * This method draws the screen and sets the stats
	 * on the appropriate panels.
	 */
	public void updateScreens(ArrayList trains,int simSecs) {
		ctsMapPanel.drawMap(trains);
		ctsStatsPanel.setStats(simSecs);
		if(trains.size()!=0)
			ctsTStatsPanel.setStats(trains);
	} //end of method


	/**
	 *  Sets the desired tab item to be shown.
	 */
	public void setTabIndex(int nIndex) {
		ctsPane.setSelectedIndex(nIndex);
	} // end of method


	/**
	 *  Returns the value of the timer.
	 *
	 *  @return an integer of the timer value.
	 */
	public int getTimerValue() {
		return ctsMainPanel.getTimerValue();
	}


	/**
	 *  Closes the application when user clicks the exit symbol in the window
	 */
	protected void createWindowListener() {
    	WAdapter = new WindowAdapter() {
       		public void windowClosing(WindowEvent evt) {
        		System.exit(0);
      		}
    	};
    	addWindowListener(WAdapter);
  	} //end of method
}