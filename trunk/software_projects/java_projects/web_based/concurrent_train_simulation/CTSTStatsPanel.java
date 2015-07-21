/**
 *  <p>
 *     Creates the stats panel for the trains.
 *  <p>
 *  trainsStats[trainNo][station][plat][0]: Arrived Times
 *	<br>	   	 			 			   [1]: Departed Times
 *  <p>
 *  stationStats[stationNo][plat][0]: Arrived Trains (Total Number)
 *	<br>      	    			 [1]: Departed Trains (Total Number)
 *	<br>    	    			 [2]: Express Trains (Total Number)
 *  <p>
 *  <b>Project Web Site:</b><i>
 *  <br>
 *  <a href="http://www.geocities.com/cts">http://www.geocities.com/ctsproj</a><i>
 *
 *  @author <img src="my_img.jpg" width="56" height="70" alt="Author's photo" border="0">
 *   		<br>
 *          <a href="mailto: dimtsan@hotmail.com"><b>Jim Tsanakaliotis</b></a>
 *          <br>
 *          Author web site: <a href="http://www.geocities.com/dimtsan">http://www.geocities.com/dimtsan</a>
 *  @version <font color=red><b>2.0</font><i> &nbsp * 06 April 2001 *</b></i>
 *  @see CTSScreen
 *  @see CTSStats
 **/
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class CTSTStatsPanel extends JPanel {

	private JLabel st1 = new JLabel();
	private JLabel st2 = new JLabel();
	private JLabel st3 = new JLabel();
	private JLabel st4 = new JLabel();
	private JLabel st5 = new JLabel();
	private JLabel st6 = new JLabel();
	private JLabel st7 = new JLabel();
	private JLabel st8 = new JLabel();
	private JLabel st9 = new JLabel();
	private JLabel st10 = new JLabel();
	private JLabel st11 = new JLabel();
	private JLabel st12 = new JLabel();
	private JLabel st13 = new JLabel();
	private JLabel st14 = new JLabel();
	private JLabel st15 = new JLabel();
	private JLabel st16 = new JLabel();
	private JLabel st17 = new JLabel();
	private JLabel st18 = new JLabel();
	private JLabel st19 = new JLabel();
	private JLabel st20 = new JLabel();
	private JLabel st21 = new JLabel();
	private JLabel st22 = new JLabel();
	private JLabel st23 = new JLabel();
	private JLabel st24 = new JLabel();
	private JLabel st25 = new JLabel();
	private JRadioButton rb0 = new JRadioButton("No");
	private JRadioButton rb1 = new JRadioButton("Yes");
	private ButtonGroup rbGroup = new ButtonGroup();
	private RadioButtonListener listener;
	private boolean activate;

	private ArrayList trains;
	private GridBagConstraints 	ctsCons;
	private JComboBox dropMenu;
	private CTSParameters ctsp;
	private CTSStats stats;


    /**
     *  Constructor
     *
     *  @param statsS The Stats Obj.
     *  @param ctsP  The parameters.
     */
	public CTSTStatsPanel(CTSStats statS, CTSParameters ctsP) {
		stats=statS;
		ctsp=ctsP;
		setBackground(CTSDefParameters.BACK_COLOR);
		dropMenu = new JComboBox();
		ctsp = new CTSParameters();
		listener = new RadioButtonListener();
		trains = new ArrayList();
		ctsCons = new GridBagConstraints();
		activate=false;
		initComponents();
	} //end of constructor




	/**
	 * 	Sets the components.
	 */
	public void initComponents() {
		setLayout(new GridBagLayout());

		// setup title labels
		JLabel trLabel = new JLabel(" SELECT TRAIN:      ");
		dropMenu.setBackground(CTSDefParameters.BACK_COLOR);
		// add labels
		addLabel(trLabel,0,0);
		trLabel.setForeground(Color.red);
		ctsCons.gridx=1;
		ctsCons.gridy=0;
		add(dropMenu,ctsCons);
		rb0.setSelected(true);
		rb1.setSelected(false);
		rb0.addItemListener(listener);
		rb1.addItemListener(listener);
		rbGroup.add(rb0);
		rbGroup.add(rb1);

		JLabel actStLabel = new JLabel(" ACTIVE STATS ");
		actStLabel.setForeground(Color.red);
		addLabel(actStLabel,3,0);
		addJRadioButton(rb1,4,0);
		addJRadioButton(rb0,5,0);

		addLabel(new JLabel(" "),0,1);
		addLabel(new JLabel(" Map Position:      "),0,2);
		addLabel(new JLabel(" x Position:        "),0,3);
		addLabel(new JLabel(" y Position:        "),0,4);
		addLabel(new JLabel(" CurStation:        "),0,5);
		addLabel(new JLabel(" CurDirection:      "),0,6);
		addLabel(new JLabel(" Selected Plat:     "),0,7);
		addLabel(new JLabel(" Stopped?:          "),0,8);
		addLabel(new JLabel(" Waiting on Queue?  "),0,9);
		addLabel(new JLabel(" Waiting to Exit?   "),0,10);
		addLabel(new JLabel(" "),0,11);
		addLabel(new JLabel(" Stations: "),1,12);
		addLabel(new JLabel(" * A * "),2,12);
		addLabel(new JLabel(" * B * "),3,12);
		addLabel(new JLabel(" * C * "),4,12);
		addLabel(new JLabel(" * D * "),5,12);
		addLabel(new JLabel(" Plat-0 "),1,13);
		addLabel(new JLabel(" Last Arrival (secs):  "),0,14);
		addLabel(new JLabel(" Last Departure (secs):"),0,15);
		addLabel(new JLabel(" "),0,16);
		addLabel(new JLabel(" Plat-1 "),1,17);
		addLabel(new JLabel(" Last Arrival (secs):  "),0,18);
		addLabel(new JLabel(" Last Departure (secs):"),0,19);
		// add Stats Labels
		addSLabel(st1,1,2);
		addSLabel(st2,1,3);
		addSLabel(st3,1,4);
		addSLabel(st4,1,5);
		addSLabel(st5,1,6);
		addSLabel(st6,1,7);
		addSLabel(st7,1,8);
		addSLabel(st8,1,9);
		addSLabel(st9,1,10);
		addSLabel(st10,2,14);
		addSLabel(st11,2,15);
		addSLabel(st12,3,14);
		addSLabel(st13,3,15);
		addSLabel(st14,4,14);
		addSLabel(st15,4,15);
		addSLabel(st16,5,14);
		addSLabel(st17,5,15);
		addSLabel(st18,2,18);
		addSLabel(st19,2,19);
		addSLabel(st20,3,18);
		addSLabel(st21,3,19);
		addSLabel(st22,4,18);
		addSLabel(st23,4,19);
		addSLabel(st24,5,18);
		addSLabel(st25,5,19);
		for(int i=0; i<ctsp.NUM_OF_TRAINS; i++) {
			dropMenu.addItem("Train No: "+i);
		}

	} //end of method


    /**
     *  Sets some extra action when we start the simulation.<br>
     **/
	public void setStartup() {
		dropMenu=new JComboBox();
		for(int i=0; i<ctsp.NUM_OF_TRAINS; i++) {
			dropMenu.addItem("Train No: "+i);
		}
		dropMenu.setSelectedIndex(0);
	}


	/**
	 *  This sets the message of these trains.
	 */
	synchronized public void setStats(ArrayList tr) {
		if(activate) {
			trains=tr;
			CTSTrain curTrain = (CTSTrain) trains.get(dropMenu.getSelectedIndex());
			String s = "";
			st1.setText(Integer.toString(curTrain.getPos()));
			st2.setText(Integer.toString(curTrain.getXPos()));
			st3.setText(Integer.toString(curTrain.getYPos()));
			switch(curTrain.getCurStation()) {
				case 0:  s="Station A"; break;
				case 1:  s="Station B"; break;
				case 2:  s="Station C"; break;
				case 3:  s="Station D"; break;
				case -1: s="Out of Station"; break;
				case 4:  s="Turning Point"; break;
			}
			st4.setText(s);
			switch(curTrain.getCurDir()) {
				case 0:  s="Right"; break;
				case 1:  s="Left";  break;
			}
			st5.setText(s);
			switch(curTrain.getCurPlat()) {
				case 0:  s="Plat 0"; break;
				case 1:  s="Plat 1";  break;
				case 2:  s="Turning Point Plat";  break;
			}
			st6.setText(s);
			if(curTrain.getStopSign())
				s="Yes";
			else
				s="No";
			st7.setText(s);
			if(curTrain.getWait())
				s="Yes";
			else
				s="No";
			st8.setText(s);
			if(curTrain.getSafeExit())
			 	s="No";
			else if(!curTrain.getSafeExit())
				s="Yes";
			st9.setText(s);
			st10.setText(stats.getPanelStats(curTrain.getNo(),0,0,0));
			st11.setText(stats.getPanelStats(curTrain.getNo(),0,0,1));
			st12.setText(stats.getPanelStats(curTrain.getNo(),1,0,0));
			st13.setText(stats.getPanelStats(curTrain.getNo(),1,0,1));
			st14.setText(stats.getPanelStats(curTrain.getNo(),2,0,0));
			st15.setText(stats.getPanelStats(curTrain.getNo(),2,0,1));
			st16.setText(stats.getPanelStats(curTrain.getNo(),3,0,0));
			st17.setText(stats.getPanelStats(curTrain.getNo(),3,0,1));
			st18.setText(stats.getPanelStats(curTrain.getNo(),0,1,0));
			st19.setText(stats.getPanelStats(curTrain.getNo(),0,1,1));
			st20.setText(stats.getPanelStats(curTrain.getNo(),1,1,0));
			st21.setText(stats.getPanelStats(curTrain.getNo(),1,1,1));
			st22.setText(stats.getPanelStats(curTrain.getNo(),2,1,0));
			st23.setText(stats.getPanelStats(curTrain.getNo(),2,1,1));
			st24.setText(stats.getPanelStats(curTrain.getNo(),3,1,0));
			st25.setText(stats.getPanelStats(curTrain.getNo(),3,1,1));
		}
	}

   /**
     * This sets the status of the stats to be activated or not.
     */
	public void setStatus(boolean status) {
		if (status) {
			activate=status;
		} else {
			st1.setText(" -- ");
			st2.setText(" -- ");
			st3.setText(" -- ");
			st4.setText(" -- ");
			st5.setText(" -- ");
			st6.setText(" -- ");
			st7.setText(" -- ");
			st8.setText(" -- ");
			st9.setText(" -- ");
			st10.setText(" -- ");
			st11.setText(" -- ");
			st12.setText(" -- ");
			st13.setText(" -- ");
			st14.setText(" -- ");
			st15.setText(" -- ");
			st16.setText(" -- ");
			st17.setText(" -- ");
			st18.setText(" -- ");
			st19.setText(" -- ");
			st20.setText(" -- ");
			st21.setText(" -- ");
			st22.setText(" -- ");
			st23.setText(" -- ");
			st24.setText(" -- ");
			st25.setText(" -- ");
			activate=status;
		}
	}


	/**
	 * 	Adds a Label.
	 *
	 *  @param label The lable to add.
	 *  @param grdx The value of the gridx.
	 *  @param grdy The value of the gridy
	 *
	 */
	public void addLabel(JLabel label, int grdx, int grdy) {
		label.setPreferredSize(new Dimension(130, 20));
		label.setHorizontalAlignment(SwingConstants.LEFT);
		label.setBackground(CTSDefParameters.BACK_COLOR);
		label.setForeground(Color.white);
		label.setFont(new Font("Arial",1,11));
		ctsCons.gridx = grdx;
		ctsCons.gridy = grdy;
		add(label, ctsCons);
	}


	/**
	 * 	Adds a JRadioButton
	 *
	 *  @param rb The button to add.
	 *  @param grdx The value of the gridx.
	 *  @param grdy The value of the gridy
	 *
	 */
	public void addJRadioButton(JRadioButton rb, int grdx, int grdy) {
		rb.setPreferredSize(new Dimension(130, 20));
		rb.setBackground(CTSDefParameters.BACK_COLOR);
		rb.setForeground(Color.yellow);
		rb.setFont(new Font("Arial",1,11));
		ctsCons.gridx = grdx;
		ctsCons.gridy = grdy;
		add(rb, ctsCons);
	}


	/**
	 * 	Adds a Label.
	 *
	 *  @param label The lable to add.
	 *  @param grdx The value of the gridx.
	 *  @param grdy The value of the gridy
	 *
	 */
	public void addSLabel(JLabel label, int grdx, int grdy) {
		label.setPreferredSize(new Dimension(100, 20));
		label.setHorizontalAlignment(SwingConstants.LEFT);
		label.setBackground(CTSDefParameters.BACK_COLOR);
		if(grdy>10)
			label.setForeground(Color.yellow);
		else
			label.setForeground(Color.black);
		label.setFont(new Font("Arial",1,11));
		ctsCons.gridx = grdx;
		ctsCons.gridy = grdy;
		add(label, ctsCons);
	}


	/**
	 * 	A listener for the buttons.
	 */
	private class RadioButtonListener implements ItemListener {
		public void itemStateChanged(ItemEvent e) {
			if(e.getSource()==rb0) {
				setStatus(false);
			}
			else if (e.getSource()==rb1) {
				setStatus(true);
			}
		}
	} // end of class RadioButtonListener
}//end of class

