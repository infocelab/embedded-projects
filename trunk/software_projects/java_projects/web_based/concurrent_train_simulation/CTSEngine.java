
import java.util.*;
import java.lang.Thread.*;
import java.awt.event.*;
import javax.swing.Timer;

/**
 *  <b><i><u>Description:</b></i></u>
 *  <br>
 *      This is the most important class in this simulation. <br>
 *      This class is the controller class for all the "loops" in this simulation.<br>
 *      Its keeping track of the map information, and where are the trains and ir returns<br>
 *      that information to the trains for controling the checks at the trains movement.
 *      Furthermore this class define the simulation time and sends that time to the screen<br>
 *      as output.
 *	<p>
 *      <font color=red><b><i>The Map Elements Values</font></b></i>
 *  <p>
 *      <center><img src="map.gif" width="500" height="275" alt="The map elements value" border="0"></center>
 *  <p><br><br>
 *      <font color=red><b><i>Synchronization issues:</font></b></i>
 *      <p>
 *         In this class all methods except start(), setArrays() and actionPerformed() are synchronized.<br>
 *         The reason of doing the methods synchronized is safety. By invoking synchronization on them we <br>
 *         prevent illegal values. These methods may be accesed concurrently from the CTSStation objects <br>
 *         which are Threads and runs concurrently in this application.<p>
 *         Methods start() and setArrays() are not synchronized because they runs once at the creation of the<br>
 *         obejct and therefore they dont need to be syncronized.
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
 *  @see CTSDefParameters
 *  @see CTS
 *  @see CTSStats
 *  @see CTSScreen
 *  @see CTSTrain
 */
public class CTSEngine implements ActionListener {

	private int simSecs, prevSecs, countTrains, nextTrIns, totalTrains;
	private long startTime;
	private boolean trIns;
	private Timer timer;
	private ArrayList trains;
	private	Random rnd;
	private Date date;
	private CTSStation[] stations;
	private int[][] pathLocks;
	private int[][][] platLocks;
	private int[][][] waitingQueue;
	private int[][][] exitStatPos;
	private CTSTrain[][][] map;
	private ThreadGroup thrGroup;
	private CTSScreen ctsScreen;
	private CTSStats ctsStats;
	private CTSParameters ctsp;

    /**
     *  Constructor
     *
     *  @param ctsP: An object of class CTSParameters
     *  @param ctsScr: An object of class CTSScreen.It will be used for updating info on screens.
     *  @param sts: An object of class CTSStats. It will be used for updating stats.
     **/
	public CTSEngine(CTSParameters ctsP,CTSScreen ctsScr, CTSStats sts) {
		ctsp=ctsP;
		date = new Date();
		rnd = new Random();
		trains = new ArrayList();
		ctsStats = sts;
		ctsScreen = ctsScr;
		trIns = false;
		prevSecs=0;
		startTime = System.currentTimeMillis();
    	thrGroup = new ThreadGroup("Stations");
       	timer = new Timer(ctsp.DELAY,this);
		stations = new CTSStation[4];
		pathLocks = new int[2][6];
		platLocks = new int[2][4][2];
		waitingQueue = new int[2][4][2];
		exitStatPos = new int[2][4][2];
		map = new CTSTrain[2][3][370];
		setArrays();
	}


    /**
     *  Sets some extra action when we start the simulation.<br>
     *  e.g : updates the correct parameters in stats and screen objects.
     **/
	public void start() {
		// update arrays in stats obj according to parameters.
		ctsStats.setStartup();
		ctsScreen.setStartup();
		for(int i=0; i<stations.length; i++) {
			stations[i].start();
		}
	}


    /**
     *  This is the main method of this class and this simulation.<br>
     *  Controls the cycles and define the main logic in this simulation.
     **/
	synchronized private void simulate() {
		setTime();
		CTSTrain train;
		for(int i=0; i<trains.size(); i++) {
			train = (CTSTrain)trains.get(i);
			train.simulate();
		}
		// if time to insert a train;
		if(trIns && simSecs>=nextTrIns) {
			boolean safeInsertion=false;
			switch(ctsp.DIRECTION) {
				case 0:
					if((getPathLock((1-ctsp.DIRECTION),1)==0) &&
						getSafeMove(ctsp.DIRECTION,0,-1)) {
							safeInsertion=true;
					}
				break;
				case 1:
					if((getPathLock((1-ctsp.DIRECTION),5)==0) &&
						getSafeMove(ctsp.DIRECTION,0,-1)) {
							safeInsertion=true;
					}
				break;
			}
			// if it is safe to insert train, insert one.
			if(safeInsertion) {
				insertTrain();
			}
		}
		ctsScreen.updateScreens(trains, simSecs);
		// update timer if changed.
		timer.setDelay(ctsScreen.getTimerValue());
	}


    /**
      * Inserts a new train on the map.
     **/
	synchronized public void insertTrain() {
		if(totalTrains <ctsp.NUM_OF_TRAINS) {
			int rndDir=ctsp.DIRECTION;
			int sYpos=0;
			switch(rndDir) {
				case 0: sYpos=137; break;
				case 1: sYpos=427; break;
			}
			// add a new express train.
			if(countTrains == 4){
				CTSTrain train = new CTSTrain("images/expTr.gif",'x',rndDir, trains.size(), this,stations,50, sYpos);
				trains.add(train);
				map[0][0][0] = train;
				countTrains = 0;
			} else {
				CTSTrain train = new CTSTrain("images/T"+(rnd.nextInt(6)+1)+".gif",'n',rndDir, trains.size(), this,stations,50, sYpos);
				trains.add(train);
				map[0][0][0] = train;
				countTrains++;
			}
			trIns=false;
			totalTrains++;
		}
	}


    /**
      * Sets correctly the arrays when we start the application.
     **/
	private void setArrays() {
		stations[0] = new CTSStation(this,ctsStats,thrGroup,"Station-A",0);
		stations[1] = new CTSStation(this,ctsStats,thrGroup,"Station-B",1);
		stations[2] = new CTSStation(this,ctsStats,thrGroup,"Station-C",2);
	   	stations[3] = new CTSStation(this,ctsStats,thrGroup,"Station-D",3);
		// set station exit point
		exitStatPos[0][3][1]=0;
		exitStatPos[1][0][1]=0;
		exitStatPos[0][3][0]=5;
		exitStatPos[1][0][0]=5;
		exitStatPos[0][0][1]=47;
		exitStatPos[1][3][1]=47;
		exitStatPos[0][0][0]=65;
		exitStatPos[1][3][0]=65;
		exitStatPos[0][1][1]=94;
		exitStatPos[1][2][1]=94;
		exitStatPos[0][2][1]=140;
		exitStatPos[1][1][1]=140;
		exitStatPos[0][1][0]=179;
		exitStatPos[1][2][0]=179;
		exitStatPos[0][2][0]=241;
		exitStatPos[1][1][0]=241;
	}


    /**
      * Keeps track of trains position in the map.
      *
      * @param train: The current train.
      * @param odir:  The old direction.
      * @param ndir:  The new direction.
      * @param opos:  The old position
      * @param npos:  The new position
      * @param oloc:  The old location
      * @param nloc:  The new location
      **/
	synchronized public void  setMapInfo(CTSTrain train, int odir,int ndir ,int opos, int npos, int oloc,int nloc) {
		map[odir][oloc][opos] = null;
		map[ndir][nloc][npos] = train;
	}


    /**
      * Sets the total running time for this simulation.
	  */
	synchronized public void setTime() {
		Long l = new Long(System.currentTimeMillis() - startTime);
		simSecs = (l.intValue() / 1000)+prevSecs;
		if(!trIns) {
			int min = ctsp.MIN_INSERTION_TIME;
			int max = ctsp.MAX_INSERTION_TIME;
			nextTrIns = simSecs+rnd.nextInt(max-min+1)+min;
			trIns=true;
		}
	}


    /**
      * Sets the locks on the platforms.
      *
      * @param dir:     The current direction.
      * @param station: The station to set the lock.
      * @param plat:    The plat to set the lock.
      * @param status:  The action on those locks.
	  */
	synchronized public void setPlatLock (int dir, int station, int plat, int status) {
		platLocks[dir][station][plat] += status;
		//System.out.println(" SetPlatLock: movDir/station/plat/status: "+dir+" / "+station+" / "+plat+" / "+platLocks[dir][station][plat]);
	}


    /**
      * Sets the locks on the paths.
      *
      * @param dir:     The current direction.
      * @param path:    The path to set the lock.
      * @param status:  The action on those locks.
	  */
	synchronized public void setPathLock(int dir,int path, int status) {
		pathLocks[dir][path-1] += status;
	}


    /**
      * Sets the locks on the paths.
      *
      * @param action:   The action on this timer.<br>
      *			            -  case's': start timer <br>
      *			            -  case'p': stop timer
	  */
	synchronized public void setTimer(char action) {
	 	switch (action) {
			case 's':
				startTime = System.currentTimeMillis();
				timer = new Timer(ctsp.DELAY,this);
				startTime = System.currentTimeMillis();
				timer.start();
			break;
			case 'p':
				prevSecs=simSecs;
				timer.stop();
			break;
		}
	}


    /**
      * Keeps track of waitingTimes on platforms for trains.
      *
      * @param moveDir: The current direction.
      * @param station: The current station.
      * @param plat:   	The current plat.
      * @param status:  The action.
	  */
	synchronized public void setQueue(int moveDir,int station, int plat, int status) {
		waitingQueue[moveDir][station][plat] = status;
	}


    /**
      * Activate or deactivate stations.
      *
      * @param st: The current station.
      * @param status:  False to deactivate, true to activate.
	  */
	synchronized public void setStationStatus(int st, boolean status) {
		stations[st].setStatus(status);
	}

    /**
      * Returns information about the queue of trains.
      *
      * @param moveDir: The current direction.
      * @param station: The current station.
      * @param plat:   	The current plat.
      *
      * @return an integer specifying the number of cycles that the train in this position waits.
	  */
	synchronized public int getQueue(int moveDir, int station, int plat) {
		return waitingQueue[moveDir][station][plat];
	}


    /**
      * Returns information about locks on platforms.
      *
      * @param dir:     The current direction.
      * @param station: The current station.
      * @param plat:   	The current plat.
      *
      * @return an integer specifying the number of trains on that platform.
	  */
	synchronized public int getPlatLock(int dir, int station, int plat) {
		return platLocks[dir][station][plat];
	}

    /**
      * Returns information about locks on paths.
      *
      * @param dir:     The current direction.
      * @param path:   	The current path.
      *
      * @return an integer specifying the number of trains on that path.
	  */
	synchronized public int getPathLock(int dir,int path) {
		return pathLocks[dir][path-1];
	}


    /**
      * Returns information about exit positions on the map.
      *
      * @param dir:     The current direction.
      * @param station: The current station.
      * @param plat:   	The current plat.
      *
      * @return an integer specifying the value of the exit position.
	  */
	synchronized public int getExitPos(int dir, int station, int plat) {
		return exitStatPos[dir][station][plat];
	}


    /**
      * Returns information about exit positions on the map.
      *
      * @param dir:     The current direction.
      * @param loc:     The current location.
      * @param pos:   	The current position of the train.
      *
      * @return a boolean specifying true for safe move or false for unsafe move.
	  */
	synchronized public boolean getSafeMove(int dir,int loc, int pos) {
		if (map[dir][loc][pos+1] == null & map[dir][loc][pos+2] == null)
			return true;
		else
			return false;
	}


    /**
      * Returns information about the total runing time of the simulation.
      *
      * @return an integer of the current seconds specifying the total simulation time.
	  */
	synchronized public int getTime() {
		return simSecs;
	}

    /**
      * Haddles actionevents thrown by the timer of this class.
 	  */
	public void actionPerformed(ActionEvent evt) {
		String command = evt.getActionCommand();
		if (command == null) {
			simulate();
		}
	}
} // end of class CTSEngine.
