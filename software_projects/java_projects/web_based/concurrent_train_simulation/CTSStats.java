
import java.util.*;

/**
 *  <b><i><u>Description:</b></i></u>
 *  <br>
 *  Controller of the stats values of this application.
 *
 *  <p>
 *  Stats Internal Structure:
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
 *
 *  @version <font color=red><b>2.0</font><i> &nbsp * 06 April 2001 *</b></i>
 *  @see CTSParameters
 *  @see CTS
 *  @see CTSStation
 **/
public class CTSStats {

	private ArrayList[][][][] trainsStats;
	private int[][][] stationStats;
	private CTSParameters ctsp;
	private int numOfTrains;

    /**
     *  Constructor
     *
     *  @param ctsP The parameters of this simulation.
     */
	public CTSStats(CTSParameters ctsP) {
		ctsp=ctsP;
		numOfTrains=ctsp.NUM_OF_TRAINS;
		trainsStats = new ArrayList[numOfTrains][4][2][2];
		stationStats = new int[4][2][3];
	}


    /**
     *  Sets some actions related to the beggining of this application
     */
	public void setStartup() {
		numOfTrains=ctsp.NUM_OF_TRAINS;
		trainsStats = new ArrayList[numOfTrains][4][2][2];
		for(int i=0; i<numOfTrains; i++) {
			for (int x=0; x<4; x++) {
				for (int y=0; y<2; y++) {
					for (int z=0; z<2; z++) {
						trainsStats[i][x][y][z] = new ArrayList();
						trainsStats[i][x][y][z].add(new Integer(0));
					}
				}
			}
		}
	}


    /**
     *  Sets the stats.
     *
     *  @param stsType The type of this train
     *  @param stationNo The station number
     *  @param plat The current plat
     *  @param stationNo The type of stats.
     *  @param statsNo The number of station.
     *  @param trainNo The number of the train.
     */
	synchronized public void setStats(int stsType, int stationNo, int plat, int type, int statsNum, int trainNo) {
		switch (stsType) {
			case 0: trainsStats[trainNo][stationNo][plat][type].add(new Integer(statsNum)); break;
			case 1: stationStats[stationNo][plat][type] += statsNum; break;
		}
	}


    /**
     *  Returns the stats.
     *
     *  @param stationNo The station number
     *  @param plat The current plat
     *  @param type The type of stats.
     *
     *  @return a String representing the value of the desirable stat.
     */
	synchronized public String getStats(int stationNo, int plat, char type) {
		String s="";
		switch(type) {
			case 'p': s=Integer.toString(stationStats[stationNo][plat][0]); break;
			case 't': s=Integer.toString(stationStats[stationNo][0][0]+stationStats[stationNo][1][0]); break;
			case 'e': s=Integer.toString(stationStats[stationNo][0][2]+stationStats[stationNo][1][2]); break;
		}
		return s;
	}

    /**
     *  Returns stats.
     *
     *  @param stationNo The station number
     *  @param plat The current plat
     *  @param type The type of stats.
     *
     *  @return a String representing the value of the desirable stat.
     */
	synchronized public String getPanelStats(int trainNo, int stationNo, int plat, int type) {
		Integer anInt = (Integer) trainsStats[trainNo][stationNo][plat][type].get(trainsStats[trainNo][stationNo][plat][type].size()-1);
		return anInt.toString();
	}
} // end of CTSStats class.