/**
 *  <b><i><u>Description:</b></i></u>
 *  <br>
 *  Controller of the stats values of this application. *
 *  <p>
 *     Creates the stats panel at the first screen.
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
 *  @see CTS
 **/

import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;

public class CTSStatsPanel extends JPanel {

	private CTSStats				stats;
	private GridBagConstraints		ctsCons;
	private  JLabel time = new JLabel();
	private  JLabel sAs1text = new JLabel();
	private  JLabel sAs2text = new JLabel();
	private  JLabel sAs3text = new JLabel();
	private  JLabel sAs4text = new JLabel();
	private  JLabel sBs1text = new JLabel();
	private  JLabel sBs2text = new JLabel();
	private  JLabel sBs3text = new JLabel();
	private  JLabel sBs4text = new JLabel();
	private  JLabel sCs1text = new JLabel();
	private  JLabel sCs2text = new JLabel();
	private  JLabel sCs3text = new JLabel();
	private  JLabel sCs4text = new JLabel();
	private  JLabel sDs1text = new JLabel();
	private  JLabel sDs2text = new JLabel();
	private  JLabel sDs3text = new JLabel();
	private  JLabel sDs4text = new JLabel();
	private  JLabel stAactImg = new JLabel();
	private  JLabel stBactImg = new JLabel();
	private  JLabel stCactImg = new JLabel();
	private  JLabel stDactImg = new JLabel();
	private  JLabel stAImg = new JLabel();
	private  JLabel stBImg = new JLabel();
	private  JLabel stCImg = new JLabel();
	private  JLabel stDImg = new JLabel();
	private  JCheckBox chA, chB, chC, chD;
	private  CTS cts;
	private  Color backColor;
	private  boolean s0,s1,s2,s3;
	private  CheckButtonListener listener;


    /**
     *  Constructor
     *
     *  @param ctsP an object of the main controller class
     *  @param st The Stats.
     */
	public CTSStatsPanel(CTS ctsS, CTSStats st) {
		cts = ctsS;
		stats = st;
		s0=true;
		s1=true;
		s2=true;
		s3=true;
		ctsCons = new GridBagConstraints();
		listener = new CheckButtonListener();
		initComponents();
		setSize(130,600);
	}


    /**
     *  Method for setting up the components
     *
     */
	public void initComponents() {
		backColor = CTSDefParameters.BACK_COLOR;
		Color fontColor = new Color(246,243,218);
		setLayout(new GridBagLayout());
		setBackground(backColor);

		// labels for the stats variables
		JLabel stA1 = new JLabel();
		JLabel stA2 = new JLabel();
		JLabel stA3 = new JLabel();
		JLabel stA4 = new JLabel();
		JLabel stB1 = new JLabel();
		JLabel stB2 = new JLabel();
		JLabel stB3 = new JLabel();
		JLabel stB4 = new JLabel();
		JLabel stC1 = new JLabel();
		JLabel stC2 = new JLabel();
		JLabel stC3 = new JLabel();
		JLabel stC4 = new JLabel();
		JLabel stD1 = new JLabel();
		JLabel stD2 = new JLabel();
		JLabel stD3 = new JLabel();
		JLabel stD4 = new JLabel();
		JLabel clockImg = new JLabel();
		chA = new JCheckBox();
		chB = new JCheckBox();
		chC = new JCheckBox();
		chD = new JCheckBox();
		// add them in frame
		addJCheckBox(chA,1,2);
		addJCheckBox(chB,1,7);
		addJCheckBox(chC,1,12);
		addJCheckBox(chD,1,17);
		//set up the basic images
		addImgLabel(clockImg,"clock.gif",backColor,0,0,70,30);
		addImgLabel(stAImg,"stALogo.jpg",backColor,0,2,70,30);
		addImgLabel(stBImg,"stBLogo.jpg",backColor,0,7,70,30);
		addImgLabel(stCImg,"stCLogo.jpg",backColor,0,12,70,30);
		addImgLabel(stDImg,"stDLogo.jpg",backColor,0,17,70,30);
		//set up the description labels
		addLabel(stA1,"Total Trains:",backColor,fontColor,0,3,70,16);
		addLabel(stA4,"Expr.Tr.:",backColor,fontColor,0,4,70,16);
		addLabel(stA2,"Plat-0:",backColor,fontColor,0,5,70,16);
		addLabel(stA3,"Plat-1:",backColor,fontColor,0,6,70,16);
		addLabel(stB1,"Total Trains:",backColor,fontColor,0,8,70,16);
		addLabel(stB4,"Expr.Tr.:",backColor,fontColor,0,9,70,16);
		addLabel(stB2,"Plat-0:",backColor,fontColor,0,10,70,16);
		addLabel(stB3,"Plat-1:",backColor,fontColor,0,11,70,16);
		addLabel(stC1,"Total Trains:",backColor,fontColor,0,13,70,16);
		addLabel(stC4,"Expr.Tr.:",backColor,fontColor,0,14,70,16);
		addLabel(stC2,"Plat-0:",backColor,fontColor,0,15,70,16);
		addLabel(stC3,"Plat-1:",backColor,fontColor,0,16,70,16);
		addLabel(stD1,"Total Trains:",backColor,fontColor,0,18,70,16);
		addLabel(stD4,"Expr.Tr.:",backColor,fontColor,0,19,70,16);
		addLabel(stD2,"Plat-0:",backColor,fontColor,0,20,70,16);
		addLabel(stD3,"Plat-1:",backColor,fontColor,0,21,70,16);
		//set up the stats label
		addLabel(time,"0 sec",backColor,fontColor,1,0,52,16);
		addLabel(sAs1text,stats.getStats(0,0,'t'),backColor,fontColor,1,3,22,16);
		addLabel(sAs2text,stats.getStats(0,0,'p'),backColor,fontColor,1,5,22,16);
		addLabel(sAs3text,stats.getStats(0,1,'p'),backColor,fontColor,1,6,22,16);
		addLabel(sAs4text,stats.getStats(0,0,'e'),backColor,fontColor,1,4,22,16);
		addLabel(sBs1text,stats.getStats(1,0,'t'),backColor,fontColor,1,8,22,16);
		addLabel(sBs2text,stats.getStats(1,0,'p'),backColor,fontColor,1,10,22,16);
		addLabel(sBs3text,stats.getStats(1,1,'p'),backColor,fontColor,1,11,22,16);
		addLabel(sBs4text,stats.getStats(1,0,'e'),backColor,fontColor,1,9,22,16);
		addLabel(sCs1text,stats.getStats(2,0,'t'),backColor,fontColor,1,13,22,16);
		addLabel(sCs2text,stats.getStats(2,0,'p'),backColor,fontColor,1,15,22,16);
		addLabel(sCs3text,stats.getStats(2,1,'p'),backColor,fontColor,1,16,22,16);
		addLabel(sCs4text,stats.getStats(2,0,'e'),backColor,fontColor,1,14,22,16);
		addLabel(sDs1text,stats.getStats(3,0,'t'),backColor,fontColor,1,18,22,16);
		addLabel(sDs2text,stats.getStats(3,0,'p'),backColor,fontColor,1,20,22,16);
		addLabel(sDs3text,stats.getStats(3,1,'p'),backColor,fontColor,1,21,22,16);
		addLabel(sDs4text,stats.getStats(3,0,'e'),backColor,fontColor,1,19,22,16);
	}

	/**
	 *
	 *  This sets the message on the message board.
	 */
 	public void setStats(int secs) {
		if(s0) {
			sAs1text.setText(stats.getStats(0,0,'t'));
			sAs2text.setText(stats.getStats(0,0,'p'));
			sAs3text.setText(stats.getStats(0,1,'p'));
			sAs4text.setText(stats.getStats(1,0,'e'));
		} else {
			sAs1text.setText("--");
			sAs2text.setText("--");
			sAs3text.setText("--");
			sAs4text.setText("--");
		}
		if(s1) {
			sBs1text.setText(stats.getStats(1,0,'t'));
			sBs2text.setText(stats.getStats(1,0,'p'));
			sBs3text.setText(stats.getStats(1,1,'p'));
			sBs4text.setText(stats.getStats(1,0,'e'));
		} else {
			sBs1text.setText("--");
			sBs2text.setText("--");
			sBs3text.setText("--");
			sBs4text.setText("--");
		}
		if(s2) {
			sCs1text.setText(stats.getStats(2,0,'t'));
			sCs2text.setText(stats.getStats(2,0,'p'));
			sCs3text.setText(stats.getStats(2,1,'p'));
			sCs4text.setText(stats.getStats(2,0,'e'));
		} else {
			sCs1text.setText("--");
			sCs2text.setText("--");
			sCs3text.setText("--");
			sCs4text.setText("--");
		}
		if(s3) {
			sDs1text.setText(stats.getStats(3,0,'t'));
			sDs2text.setText(stats.getStats(3,0,'p'));
			sDs3text.setText(stats.getStats(3,1,'p'));
			sDs4text.setText(stats.getStats(3,0,'e'));
		} else {
			sDs1text.setText("--");
			sDs2text.setText("--");
			sDs3text.setText("--");
			sDs4text.setText("--");
		}
		time.setText(Integer.toString(secs)+"sec");
	}


	/**
	 * 	Adds a Label.
	 *
	 *  @param label The lable to add.
	 *  @param s The text of the string
	 *  @param backColor The Background Color.
	 *  @param fontColor The Color of the Fonts.
	 *  @param grdx The value of the gridx.
	 *  @param grdy The value of the gridy
	 *  @param prefx The x value of the dimension of this label.
	 *  @param prefy The y value of the dimension of this label.
	 *
	 */
	public void addLabel(JLabel label, String s, Color backColor, Color fontColor, int grdx, int grdy, int prefx, int prefy) {
		label.setPreferredSize(new Dimension(prefx, prefy));
		label.setHorizontalAlignment(SwingConstants.LEFT);
		label.setBackground(backColor);
		label.setForeground(fontColor);
		label.setText(s);
		label.setFont(new Font("Arial",1,11));
		ctsCons.gridx = grdx;
		ctsCons.gridy = grdy;
		add(label, ctsCons);

	}


	/**
	 * 	Adds a JCheckBox
	 *
	 *  @param chBox The JCheckBox to add.
	 *  @param grdx The value of the gridx.
	 *  @param grdy The value of the gridy
     */
	public void addJCheckBox(JCheckBox chBox, int grdx, int grdy) {
		chBox.setSelected(true);
		chBox.setBackground(backColor);
		chBox.setForeground(Color.white);
		chBox.addItemListener(listener);
		ctsCons.gridx = grdx;
		ctsCons.gridy = grdy;
		add(chBox, ctsCons);
	}


	/**
	 * 	Adds a JLabel containing images.
	 *
	 *  @param label The lable to add.
	 *  @param s The text of the string
	 *  @param backColor The Background Color.
	 *  @param grdx The value of the gridx.
	 *  @param grdy The value of the gridy
	 *  @param prefx The x value of the dimension of this label.
	 *  @param prefy The y value of the dimension of this label.
     */
	public void addImgLabel(JLabel label, String imgName, Color backColor, int grdx, int grdy, int prefx, int prefy) {
		label.setPreferredSize(new Dimension(prefx, prefy));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBackground(backColor);
		label.setIcon(new ImageIcon(getClass().getResource("/images/"+imgName)));
		ctsCons.gridx = grdx;
		ctsCons.gridy = grdy;
		add(label, ctsCons);
	}


	/**
	 * 	A listener for checkboxes.
	 */
	private class CheckButtonListener implements ItemListener {
		public void itemStateChanged(ItemEvent e) {
			if(e.getSource()==chA) {
				cts.setStationStatus(0,chA.isSelected());
				s0=chA.isSelected();
				if(s0) {
					stAImg.setIcon(new ImageIcon(getClass().getResource("/images/stALogo.jpg")));
				} else if(!s0){
					stAImg.setIcon(new ImageIcon(getClass().getResource("/images/dstALogo.jpg")));
				}
			}
			else if (e.getSource()==chB) {
				cts.setStationStatus(1,chB.isSelected());
				s1=chB.isSelected();
				if(s1) {
					stBImg.setIcon(new ImageIcon(getClass().getResource("/images/stBLogo.jpg")));
				} else if(!s1){
					stBImg.setIcon(new ImageIcon(getClass().getResource("/images/dstBLogo.jpg")));
				}
			}
			else if (e.getSource()==chC) {
				cts.setStationStatus(2,chC.isSelected());
				s2=chC.isSelected();
				if(s2) {
					stCImg.setIcon(new ImageIcon(getClass().getResource("/images/stCLogo.jpg")));
				} else if(!s2){
					stCImg.setIcon(new ImageIcon(getClass().getResource("/images/dstCLogo.jpg")));
				}
			}
			else if (e.getSource()==chD) {
				cts.setStationStatus(3,chD.isSelected());
				s3=chD.isSelected();
				if(s3) {
					stDImg.setIcon(new ImageIcon(getClass().getResource("/images/stDLogo.jpg")));
				} else if(!s3){
					stDImg.setIcon(new ImageIcon(getClass().getResource("/images/dstDLogo.jpg")));
				}
			}
		}
	}
} // end of class CTSStatsPanel.