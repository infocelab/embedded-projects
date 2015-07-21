
import java.util.*;

/**
 *  <b><i><u>Description:</b></i></u>
 *  <br>
 *      This class defines the station behaviour. The stations keep the stats <br>
 *      and update them in the stats object.
 *	<p>
 *      <font color=blue><b><i>Synchronization issues:</font></b></i>
 *      <p>
 *         This class extends Thread. That means that objects of this class runs concurrently on this application.<br>
 *         Because of that synchronization of this class method was desirable for safety issues.
 *
 *         All methods of this class are synchronized to prevent illegal writing or reading of values <br>
 *         from others objects.
 * 		   <p>
 *		   For more information about concurrency refer to <a href="http://java.sun.com">http://java.sun.com</a><i>
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
 *
 *  @version <font color=red><b>2.0</font><i> &nbsp * 06 April 2001 *</b></i>
 *  @see CTSTrain
 *  @see CTSStation
 */
 public class CTSStation extends Thread {

	private int stationNo, curTrP0, curTrP1, sleepTime,test;
	private CTSEngine ctsEngine;
	private CTSStats stats;
	private boolean active;

    /**
     *  Constructor
     *
     *  @param ctsEng: The engine of this application
     *  @param st An object of class CTSStats. It will be used for updating stats.
     *  @param thGroup The group of this thread object.
     *  @param name The name of this Object.
     *  @param stNo  The number of this station.
     **/
 	public CTSStation(CTSEngine ctsEng, CTSStats st, ThreadGroup thGroup, String name, int stNo) {
		super(thGroup, name);
		ctsEngine = ctsEng;
		stats=st;
		stationNo=stNo;
		active=true;
		test=0;
	}

    /**
     *  Sets the status of this station to be active or disabled.
     *
     *  @param status True to activate station, false to deactivate.
     */
	public synchronized void setStatus(boolean status) {
		active=status;
	}


    /**
     *  Sets the actions related to a train arrival.
     *
     *  @param plat The current plat.
     *  @param train The current train.
     */
	public synchronized void setArrival(int plat, CTSTrain train) {
		switch(plat) {
			case 0:
				curTrP0++;
			break;
			case 1:
				curTrP1++;
			break;
		}
		/* update stats on CTSStats */
		// 1: stationStats.
		stats.setStats(1,stationNo,plat,0,1,train.getNo());
		stats.setStats(0,stationNo,plat,0,ctsEngine.getTime(),train.getNo());
		if(train.getType() == 'x') {
			stats.setStats(1,stationNo,plat,2,1,train.getNo());
		}
	}


    /**
     *  Sets the actions related to a train departure.
     *
     *  @param plat The current plat.
     *  @param train The current train.
     */
	public synchronized void setDeparture(int plat, CTSTrain train) {
		switch(plat) {
			case 0:
				curTrP0--;
			break;
			case 1:
				curTrP1--;
			break;
		}
		/* update stats on CTSStats */
		stats.setStats(1,stationNo,plat,1,1,train.getNo());
		stats.setStats(0,stationNo,plat,1,ctsEngine.getTime(),train.getNo());
	}


    /**
     *  Sets the actions related to a train departure.
     *
     *  @return a boolean indicating the status of this station.
     */
	public synchronized boolean getStatus() {
		return active;
	}
} // end of class Station.