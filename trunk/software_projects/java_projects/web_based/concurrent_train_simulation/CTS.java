/**
 *  <b><i><u>Description:</b></i></u>
 *  <br>
 *  This class is the main class of CTS (Concurrent Train Simulation)<br>
 *  application. Its creating the main objects of this application.<p>
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
 *  @see CTSParameters
 *  @see CTSScreen
 *  @see CTSEngine
 *  @see CTSStats
 */
public class CTS { //implements ActionListener, MouseListener

	// variables
  	private CTSParameters ctsp;
  	private CTSScreen ctsScreen;
  	private CTSEngine ctsEngine;
  	private CTSStats stats;

	/**
	 * Constructor of this class.
	 */
	public CTS() {
		ctsp = new CTSParameters();
		stats = new CTSStats(ctsp);
		ctsScreen = new CTSScreen(ctsp,this,stats);
		ctsEngine = new CTSEngine(ctsp,ctsScreen,stats);
	}

    /**
     *  Starts the simulation.
     **/
	public void start() {
		ctsEngine.start();
		ctsEngine.setTimer('s');
	}

    /**
     *  Restarts the simulation.
     **/
	public void restart() {
		ctsEngine.setTimer('s');
	}

    /**
     *  Pause the simulation.
     **/
	public void pause() {
		ctsEngine.setTimer('p');
	}

    /**
     *  Sets the station status to be true or false.
     *
     *  @param st: The station number.
     *  @param status: The status.
     **/
	public void setStationStatus(int st,boolean status) {
		ctsEngine.setStationStatus(st,status);
	}

    /**
     * The main method of this class.
     *
     * @param: The arguments.
     **/
	public static void main(String args[]){
		try {
			CTS Obj = new CTS();
		} catch(Exception e) {
			System.out.println(e);
		}
	} // end of main method.
} // end of class CTS.