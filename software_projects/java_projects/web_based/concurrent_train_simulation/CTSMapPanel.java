
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.Container.*;
import javax.swing.border.Border;
import java.util.ArrayList;

/**
 *  <b><i><u>Description:</b></i></u>
 *  <br>
 *       Sets the map of this application and draws the train images, tracks, <br>
 *       stations, etc ...
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
public class CTSMapPanel extends JPanel {

	private int simSecs;
	private ArrayList trains;
	private ImageIcon stopIcon, lArr, rArr, dArr, uArr;
	private Color backColor;
	private ImageIcon stopSign;
	private boolean paused;

    /**
     *  Constructor
     **/
	public CTSMapPanel(){
    	//final Color bg = new Color(20,79,28);
        backColor =  CTSDefParameters.MAP_BACK_COLOR;
        setBackground(backColor);
        simSecs=0;
        stopIcon = new ImageIcon("/images/stop.gif");
        lArr = new ImageIcon("images/leftArr.gif");
        rArr = new ImageIcon("images/rightArr.gif");
        dArr = new ImageIcon("images/downArr.gif");
        uArr = new ImageIcon("images/upArr.gif");
        paused=false;
        trains = new ArrayList();
        stopSign = new ImageIcon(getClass().getResource("/images/stop.gif"));
	}

    /**
     *  Draws the graphics
     **/
	public void paintComponent(Graphics g) {
        super.paintComponent(g); //clears the background
		g.setColor(Color.white);

		// draw stations
		g.drawRoundRect(150,150,90,20,10,10);
		g.drawRoundRect(450,150,90,20,10,10);
		g.drawRoundRect(150,400,90,20,10,10);
		g.drawRoundRect(450,400,90,20,10,10);

		//draw outside track
		g.drawArc(600,380,50,50,270,90);//bottom arc
		g.drawArc(600,140,50,50,0,90); //top arc
		g.drawLine(50,140,625,140);//top line
		g.drawLine(50,430,625,430);//bottom line
		g.drawLine(650,165,650,405);//outside top to bottom line (right)
		g.drawLine(50,140,50,430);//outside top to bottom line (left)
		g.drawLine(20,390,50,390); // (--) bottom turning point
		g.drawLine(20,430,50,430); // (--) bottom turning point
		g.drawLine(20,390,20,430); // (|)  bottom turning point
		g.drawLine(20,180,50,180); // (--) top turning point
		g.drawLine(20,140,50,140); // (--) top turning point
		g.drawLine(20,180,20,140); // (|)  top turning point

		// draw arrows.
		g.drawImage(lArr.getImage(),25,190, null);  // ( <-- ) top l-a
		g.drawImage(rArr.getImage(),25,125, null);  // ( --> ) top r-a
		g.drawImage(lArr.getImage(),25,375, null);  // ( <-- ) bottom l-a
		g.drawImage(rArr.getImage(),25,440, null);  // ( --> ) bottom r-a

		// draw inside stations
		g.drawLine(130,180,260,180);//top left inside
		g.drawLine(430,180,560,180);//top right inside
		g.drawLine(130,390,260,390);//bottom left inside
		g.drawLine(430,390,560,390);//bottom right inside

		//draw diags
		g.drawLine(130,180,80,140);//top left track ie (\)
		g.drawLine(260,180,310,140);//top left loop ie (/)

		g.drawLine(430,180,380,140);//top right  ie (\)
		g.drawLine(560,180,610,140);//top right  ie (/)

		g.drawLine(130,390,80,430);//bottom left  ie (\)
		g.drawLine(260,390,310,430);//bottom left ie (/)

		g.drawLine(430,390,380,430);//bottom right  ie (\)
		g.drawLine(560,390,610,430);//bottom right  ie (/)

		// draw stations
		g.drawRoundRect(150,150,90,20,10,10);
		g.drawRoundRect(450,150,90,20,10,10);
		g.drawRoundRect(150,400,90,20,10,10);
		g.drawRoundRect(450,400,90,20,10,10);

		//Label stations
		g.drawString("Station 'A'",170,165);
		g.drawString("Station 'B'",470,165);
		g.drawString("Station 'D'",170,415);
		g.drawString("Station 'C'",470,415);

		// draw trains.
		CTSTrain train;
		for(int i=0; i<trains.size(); i++) {
			try {
				train = (CTSTrain)trains.get(i);
				g.drawImage(train.getTrainImage(), train.getXPos(), train.getYPos(), null);
			} catch (Exception Error) {
				System.out.println(Error);
			}
		}
		// draw stop signs.
		if (paused)
			g.drawImage(stopSign.getImage(), 300, 250, null);
	}


    /**
     *  Draws the map.
     *
     *  @param tr: The ArrayList containing the trains references.
     **/
	public void drawMap(ArrayList tr) {
		trains = tr;
		repaint();
	}


    /**
     *  Pauses the map.
     *
     *  @param status: True to pause, False to activate it again.
     **/
	public void setPause(boolean status) {
		paused=status;
		repaint();
	}
} // end of class Stations.