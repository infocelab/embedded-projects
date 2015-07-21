import java.awt.*;
import javax.swing.*;
import java.util.*;

/**
 *  <b><i><u>Description:</b></i></u>
 *  <br>
 *      This define the behaviour of the train. This class defines the movement of <br>
 *      the train and controls and safety in movement. Keep track of the stats and send them<br>
 *      to the station.
 *	<p>
 *      <font color=blue><b><i>Synchronization issues:</font></b></i>
 *      <p>
 *         The method setMapPos was specified as synchronized for safety issues.<br>
 *         Because we access other concurrent objects (stations) from that method <br>
 *         synchronization needs to be implemented to prevent illegal updates and dirty reads.
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
 *  @see CTSStats
 *  @see CTSEngine
 *  @see CTSStation
 *  @see CTSSParameters
 */

public class CTSTrain {

	private	int xpos, ypos, stAtStTime, pos, loc, moveDir, stopTime, avPlat, waitingCycles, curStation;
	private final int trainNo;
	private	final ImageIcon img;
	private CTSStation[] stations;
	private CTSEngine ctsEngine;
	private final char trType;
	private boolean safeMove, stopSign, turn, wait, safeExit;
	private String name;
	private Random rnd;


    /**
     *  Constructor
     *
     *  @param nImg The image of this train.
     *  @param type The type of this train (Express or not)
     *  @param mDir The starting direction of this  train.
     *  @param no The Number of this train.
     *  @param eng The engine.
     *  @param st The stations.
     *  @param x The starting x position
     *  @param y The starting y position
     */
	public CTSTrain(String nImg,char type,int mDir,int no,CTSEngine eng,CTSStation[] st,int x,int y) {
		pos=0;
		loc=0;
		xpos=x;
		ypos=y;
		trainNo=no;
		stAtStTime=CTSDefParameters.STOP_ATSTATION_TIME;
		ctsEngine = eng;
		name="Train: "+trainNo;
		trType = type;
		stations = st;
		moveDir=mDir;
		avPlat=0;
		safeMove=true;
		stopSign=false;
		turn=false;
		wait=false;
		curStation=-1;
		rnd = new Random();
		img = new ImageIcon(nImg);
		switch(moveDir) {
			case 0:
				ctsEngine.setPlatLock(moveDir,0,0,1);
				ctsEngine.setPathLock(moveDir,1,1);
			break;
			case 1:
				ctsEngine.setPlatLock(moveDir,3,0,1);
				ctsEngine.setPathLock(moveDir,5,1);
			break;
		}
	}

	/**
	 *  Simulates the train behaviour.
	 **/
	public void simulate()  {
		if(stopSign) {
			if(ctsEngine.getTime()==(stopTime+stAtStTime)) {
				stopSign=false;
				stopTime=0;
			}
		} else if (ctsEngine.getSafeMove(moveDir,loc,pos)){
			setMapPos();
			if(safeMove)
				setCoords();
		}
		//System.err.println(" pos: "+pos+" xpos: "+xpos+" ypos: "+ypos+" stop: "+stopSign+" mov: "+moveDir+" loc: "+loc+" EngSafe: "+ctsEngine.getSafeMove(moveDir,loc,pos)+" sMov:"+safeMove);
		// simulate waiting cycles
		if(waitingCycles<CTSDefParameters.MAX_WAIT_TIME & waitingCycles>0) {
			wait=true;
		} else {
			wait=false;
		}
	} // end of method simulate()


	/**
	 *  Sets the actions related to the position of the train.
	 **/
	public synchronized void setMapPos() {
		switch(loc) {
			case 0:
				switch(pos+1) {
					// enter stations
					case 6: case 66: case 181: case 242:
						int oldPos=pos+1;
						int stNo=0;
						switch (oldPos) {
							case 6:  stNo=0; break;
							case 66:  stNo=1; break;
							case 181:  stNo=2; break;
							case 242:  stNo=3; break;
						}
						if(moveDir==1) {stNo=(3-stNo);}
						if (avPlat==1) {
							switch (oldPos) {
								case 6: pos=0; break;
								case 66: pos=47; break;
								case 181: pos=94; break;
								case 242: pos=141; break;
							}
							ctsEngine.setMapInfo(this,moveDir,moveDir,(oldPos-1),pos,loc,1);
							loc=1;
						}
						else {
							ctsEngine.setMapInfo(this,moveDir,moveDir,pos,(pos+1),loc,loc);
							loc=0;
							pos++;
						}
						setLocks(0,stNo);
						synchronized(this) {
							stations[stNo].setArrival(avPlat,this);
						}
						curStation=stNo;
					break;
					// stop at stations
					case 29: case 88: case 203: case 263:
						int aNo=0;
						switch (pos+1) {
							case 29:   aNo=0; break;
							case 88:   aNo=1; break;
							case 203:  aNo=2; break;
							case 263:  aNo=3; break;
						}
						if(trType != 'x' && stations[aNo].getStatus()) {
							stopSign=true;
							stopTime=ctsEngine.getTime();
							ctsEngine.setMapInfo(this,moveDir,moveDir,pos,pos+1,loc,loc);
							pos++;
						} else {
							ctsEngine.setMapInfo(this,moveDir,moveDir,pos,(pos+1),loc,loc);
							pos++;
						}
					break;
					// exit stations
					case 49: case 111: case 225: case 286:
						// define current station.
						int stsNo=0;
						switch (pos+1) {
							case 49:  stsNo=0; break;
							case 111:  stsNo=1; break;
							case 225:  stsNo=2; break;
							case 286:  stsNo=3; break;
						}
						if(moveDir==1) { stsNo=(3-stsNo);}
						// if safe move --> move .!!
						if (getSafeExit(stsNo)) {
							waitingCycles=0;
							ctsEngine.setQueue(moveDir,stsNo,loc,waitingCycles);
							setLocks(1,stsNo);
							if((stsNo==3&&moveDir==0) || (stsNo==0&&moveDir==1)) {
								setLocks(3,stsNo);
							}
							stations[stsNo].setDeparture(0,this);
							ctsEngine.setMapInfo(this,moveDir,moveDir,pos,(pos+1),loc,loc);
							pos++;
							safeMove=true;
						} else {
							waitingCycles++;
							safeMove=false;
							ctsEngine.setQueue(moveDir,stsNo,loc,waitingCycles);
						}
						curStation=-1;
					break;
					// case enter path No6.
					case 295:
						setLocks(2,0);
						ctsEngine.setMapInfo(this,moveDir,moveDir,pos,(pos+1),loc,loc);
						pos++;
					break;
					// turning point.
					case 302:
						if(turn) {
							ctsEngine.setMapInfo(this,moveDir,moveDir,pos,0,loc,2);
							setLocks(2,1); // curSts in this case represents a flag about entering or leaving the turning point.
							pos=0;
							loc=2;
							turn=false;
							curStation=4;
						} else {
							ctsEngine.setMapInfo(this,moveDir,moveDir,pos,(pos+1),loc,loc);
							pos++;
						}
					break;
					// end of one loop.
					case 352:
						ctsEngine.setMapInfo(this,moveDir,moveDir,pos,0,loc,loc);
						pos=0;
						switch(moveDir) {
							case 0: ypos=137; break;
							case 1: ypos=427; break;
						}
						setLocks(2,3);
					break;
					// in all other cases just move.
					default:
						ctsEngine.setMapInfo(this,moveDir,moveDir,pos,(pos+1),0,0);
						pos++;
					break;
				} // end of switch (pos +1)
			break; // end case 0
			case 1:
				switch(pos+1) {
					// stop at stations
					case 23: case 70: case 116: case 162:
						int sNo=0;
						switch (pos+1) {
							case 23:   sNo=0; break;
							case 70:   sNo=1; break;
							case 116:  sNo=2; break;
							case 162:  sNo=3; break;
						}
						if (trType != 'x' && stations[sNo].getStatus()) {
							stopSign=true;
							stopTime=ctsEngine.getTime();
							ctsEngine.setMapInfo(this,moveDir,moveDir,pos,(pos+1),loc,loc);
							pos++;
						} else {
							ctsEngine.setMapInfo(this,moveDir,moveDir,pos,(pos+1),loc,loc);
							pos++;
						}
					break;
					// exit stations from plat-1.
					case 45: case 92: case 139: case 186:
						int statNo=0;
						int tmpPos=0;
						int tmpxPos=0;
						int tmpyPos=0;
						switch (pos+1) {
							case 45:  statNo=0; tmpPos=51;  tmpxPos=300; tmpyPos=137; break;
							case 92:  statNo=1; tmpPos=112; tmpxPos=605; tmpyPos=137; break;
							case 139: statNo=2; tmpPos=227; tmpxPos=380; tmpyPos=427; break;
							case 186: statNo=3; tmpPos=288; tmpxPos=75;  tmpyPos=427; break;
						}
						if(moveDir==1) {
							switch(tmpyPos) {
								case 137: tmpyPos=427; break;
								case 427: tmpyPos=137; break;
							}
						}
						if(moveDir==1) { statNo=(3-statNo);}
						// if safeMove then move.
						if(ctsEngine.getSafeMove(moveDir,0,tmpPos-2) && getSafeExit(statNo)) {
							ctsEngine.setMapInfo(this,moveDir,moveDir,pos,tmpPos,1,0);
							waitingCycles=0;
							ctsEngine.setQueue(moveDir,statNo,loc,waitingCycles);
							setLocks(1,statNo);
							if((statNo==3&&moveDir==0) || (statNo==0&&moveDir==1)) {
								setLocks(3,statNo);
							}
							stations[statNo].setDeparture(1,this);
							pos=tmpPos;
							loc=0;
							xpos=tmpxPos;
							ypos=tmpyPos;
 							safeMove=true;
						} else {
							waitingCycles++;
							safeMove=false;
							ctsEngine.setQueue(moveDir,statNo,loc,waitingCycles);
						}
						curStation=-1;
					break;
					default:
						ctsEngine.setMapInfo(this,moveDir,moveDir,pos,(pos+1),loc,loc);
						pos++;
					break;
				}
			break;
			case 2:
				switch(pos+1) {
					// prepare to exit.
					case 18:
						// doesnt matter in this case what we pass as curSts to getSafeMove()
						if(getSafeExit(0)) {
							// set Locks
							ctsEngine.setMapInfo(this,moveDir,(1-moveDir),pos,0,2,0);
							moveDir = 1-moveDir;
							setLocks(2,2);
							loc=0;
							pos=0;
							switch(moveDir) {
								case 0: ypos=137; break;
								case 1: ypos=427; break;
							}
							xpos=45;
							safeMove=true;
						} else {
							safeMove=false;
						}
						curStation=-1;
					break;
					// else move inside turning point.
					default:
						ctsEngine.setMapInfo(this,moveDir,moveDir,pos,(pos+1),2,2);
						pos++;
					break;
				}
			break;
		} // end of switch loc.
	} // end of method setMapPos

	/**
 	 * Sets the coordinates (x,y) based on the value of pos.
 	 **/
	public void setCoords() {
		switch (loc) {
			//  movement on expected track.
			case 0:
				if (pos<118) {
					xpos +=5;
				} else if(pos<120) {
					xpos +=5;
					switch(moveDir){
						case 0: ypos+=5; break;
						case 1: ypos-=5; break;
					}
				} else if(pos<174) {
					switch(moveDir){
						case 0: ypos+=5; break;
						case 1: ypos-=5; break;
					}
				} else if(pos<176) {
					switch(moveDir){
						case 0: ypos+=5; break;
						case 1: ypos-=5; break;
					}
					xpos -=5;
				} else if(pos<294) {
					xpos -=5;
				} else if(pos<352) {
					switch(moveDir){
						case 0: ypos-=5; break;
						case 1: ypos+=5; break;
					}
				}
			break;
			// movement inside express lanes
			case 1:
				if (pos<10 || (pos>47 & pos<58)) {
					xpos +=5;
					switch(moveDir){
						case 0: ypos+=4; break;
						case 1: ypos-=4; break;
					}
				} else if(pos<36 || (pos>47 & pos<84)) {
					xpos +=5;
				} else if(pos<46 || (pos>47 & pos<93)) {
					xpos +=5;
					switch(moveDir){
						case 0: ypos-=4; break;
						case 1: ypos+=4; break;
					}
				} else if((pos>=94 & pos<104) || (pos>140 & pos<151)) {
					xpos -=5;
					switch(moveDir){
						case 0: ypos-=4; break;
						case 1: ypos+=4; break;
					}
				} else if((pos>=104 & pos<131) || (pos>=151 & pos<177)) {
					xpos -=5;
				} else if((pos>=131 & pos<140) || (pos>=177 & pos<188)) {
				 	xpos -=5;
					switch(moveDir){
						case 0: ypos+=4; break;
						case 1: ypos-=4; break;
					}
				}
			break;
			// turning points movement.
			case 2:
				if(pos<6) {
					xpos -=5;
				} else if(pos<14) {
					switch(moveDir) {
						case 0: ypos+=5; break;
						case 1: ypos-=5; break;
					}
				} else if(pos<18) {
					xpos +=5;
				}
			break;
		} // end of switch (loc) for case moveDir=0.
	} // end of method setCoords.

	public void setLocks(int action, int curSts) {
		switch(action) {
			// enter stations locks
			case 0:
		 		// release previous path
				switch (moveDir) {
				 	case 0: ctsEngine.setPathLock(moveDir,curSts+1,-1);	break;
				 	case 1: ctsEngine.setPathLock(moveDir,curSts+2,-1); break;
				}
			break;
			// exit stations locks
			case 1:
				// release previous plat lock.
				ctsEngine.setPlatLock(moveDir,curSts,loc,-1);
				// set next lock on next station.
				switch(curSts) {
					case 0: case 1: case 2: curSts++; break;
					case 3: curSts=0; break;
				}
				if(moveDir==1) {
					switch(curSts) {
						case 1: case 0: curSts+=2; break;
						case 2: case 3: curSts-=2; break;
					}
				}
				ctsEngine.setPlatLock(moveDir,curSts,avPlat,1);
				// set path lock
				switch(curSts) {
					case 1: case 2: case 3: curSts++; break;
					case 0: curSts=5;
				}
				if(moveDir==1) {
					switch(curSts) {
						case 5: case 4: curSts-=3; break;
						case 2: case 3: curSts++; break;
					}
				}
			    ctsEngine.setPathLock(moveDir,curSts,1);
			break;
			// turning points locks and end of track locks.
			case 2:
				switch(curSts) {
					// entering the path 6
					case 0:
						// release previous lock
						switch(moveDir) {
							case 0: ctsEngine.setPathLock(moveDir,5,-1); break;
							case 1: ctsEngine.setPathLock(moveDir,1,-1); break;
						}
					break;
					// entering a turning point.
					case 1:
						// release path 6
						ctsEngine.setPathLock(moveDir,6,-1);
					break;
					// exiting turning points.
					case 2:
						switch(moveDir) {
							case 0:
								ctsEngine.setPathLock(moveDir,1,1);
								ctsEngine.setPlatLock(moveDir,0,avPlat,1);
							break;
							case 1:
								ctsEngine.setPathLock(moveDir,5,1);
								ctsEngine.setPlatLock(moveDir,3,avPlat,1);
							break;
						}
					break;
					// end of track.
					case 3:
						// release lock for path 6.
						ctsEngine.setPathLock(moveDir,6,-1);
					break;
				}
			break;
			// exiting a station and going to turning point.
			case 3:
				ctsEngine.setPathLock(moveDir,6,1);
				if(!turn) {
					switch (moveDir) {
						case 0: ctsEngine.setPathLock(moveDir,1,1); break;
						case 1: ctsEngine.setPathLock(moveDir,5,1); break;
					}
				}
				// else release all locks from setLocks(1,curSts).
				else {
					switch(curSts) {
						case 0: case 1: case 2: curSts++; break;
						case 3: curSts=0; break;
					}
					if(moveDir==1) {
						switch(curSts) {
							case 1: case 0: curSts+=2; break;
							case 2: case 3: curSts-=2; break;
						}
					}
					ctsEngine.setPlatLock(moveDir,curSts,avPlat,-1);
				}
			break;
		}
	} // end of method setLocks().


	/**
	 *  Returns an indication about safe exit or not from a station or a turning point.
	 **/
	public boolean getSafeExit(int curSts) {
		boolean smRes=false;
		int nextpath=0;
		int curSts2=0; // for x checking.
		// define next station.
		switch(curSts) {
			case 0: case 1: case 2: curSts++; break;
			case 3: curSts=0; curSts2=1; break;
		}
		// define next station and path if moveDir=1;
		if(moveDir==1) {
			switch(curSts) {
				case 0: case 1: curSts+=2; break;
				case 2: case 3: curSts-=2; break;
			}
			switch(curSts) {
				case 0: case 1: case 2: nextpath=curSts+2; break;
				case 3: nextpath=1; break;
			}
		} else {
			switch(curSts) {
				case 1: case 2: case 3: nextpath=curSts+1; break;
				case 0: nextpath=5; break;
			}
		}
		// check if exiting final stations
		boolean apFree=true;
		if((curSts==0 & moveDir==0) || (curSts==3 & moveDir==1)) {
			if(ctsEngine.getPathLock(1-moveDir,6)==0) {
				int dec = rnd.nextInt(100);
				if(dec<51 & ctsEngine.getSafeMove(moveDir,2,-1)) {
					turn=true;
					smRes=true;
				}
				else {
					apFree=true;
				}
			}
			else {
				apFree=false;
			}
		}

		if(moveDir==0) {
			switch(curSts) {
				case 0: case 1: case 2: curSts2 = curSts+1; break;
				case 3: curSts2=0; break;
			}
		} else if (moveDir==1) {
			switch(curSts) {
				case 3: case 1: case 2: curSts2 = curSts-1; break;
				case 0: curSts2=3; break;
			}
		}
		// if exiting a turning station
		if(loc==2) {
			moveDir=1-moveDir;
			switch(moveDir) {
				case 0: nextpath=1; curSts=0; curSts2=1; break;
				case 1: nextpath=5; curSts=3; curSts2=2; break;
			}
		}

		int ODPlat0=ctsEngine.getPlatLock(1-moveDir,curSts,0);
		int ODPlat1=ctsEngine.getPlatLock(1-moveDir,curSts,1);
		int SDPlat0=ctsEngine.getPlatLock(moveDir,curSts,0);
		int SDPlat1=ctsEngine.getPlatLock(moveDir,curSts,1);
		// check if path is free.
		if(ctsEngine.getPathLock(1-moveDir,nextpath)!=0) {
			smRes=false;
		}
		else if(ctsEngine.getPathLock(1-moveDir,nextpath)==0 && apFree) {
			// check if both platform are taken
			if(ODPlat0!=0 && ODPlat1!=0) {
				smRes=false;
			}
			// check if other trains wait too long ...
			else if(((ctsEngine.getQueue((1-moveDir),curSts,0)<CTSDefParameters.DELAY_FLAG)
			       & (ctsEngine.getQueue((1-moveDir),curSts,1)<CTSDefParameters.DELAY_FLAG)) || !wait) {
				// if both are free.
				if(ODPlat0==0 && ODPlat1==0) {
					// check if this is the first train to its direction in this station.
					if(SDPlat0==0 && SDPlat1==0) {
					   	// select 0 by default.
					   	avPlat=0;
					} else if (SDPlat0!=0) {
						if(trType=='x' && SDPlat1==0 && (ctsEngine.getPlatLock(1-moveDir,curSts2,0)==0
							|| ctsEngine.getPlatLock(1-moveDir,curSts2,0)==0) && ctsEngine.getTime()>180) {
							avPlat=1;
						} else {
							avPlat=0;
						}
					} else if (SDPlat1!=0) {
						if(trType=='x' && SDPlat0==0 && (ctsEngine.getPlatLock(1-moveDir,curSts2,0)==0
							|| ctsEngine.getPlatLock(1-moveDir,curSts2,0)==0) && ctsEngine.getTime()>180) {
							avPlat=0;
						} else {
							avPlat=1;
						}
					}
				}
				else if(ctsEngine.getPlatLock(1-moveDir,curSts,0)!=0){
					avPlat=1;
				}
				else if(ctsEngine.getPlatLock(1-moveDir,curSts,1)!=0){
					avPlat=0;
				}
				// check if free pos to that plat.
				int checkPos=0;
				if(loc==2) {
					switch(avPlat) {
						case 0: checkPos=5; break;
						case 1: checkPos=0; break;
					}
					// finally if plat is free move.
					if(!ctsEngine.getSafeMove(moveDir,avPlat,checkPos)) {
						smRes=false;
					}
					else {
						smRes=true;
					}
				} else {
					if(ctsEngine.getSafeMove(moveDir,avPlat,ctsEngine.getExitPos(moveDir,curSts,avPlat))) {
						smRes=true;
					} else {
						smRes=false;
					}
				}
			}
		}
		// if we are inside a turning station set the right moveDir.
		if(loc==2) { moveDir=1-moveDir;	}
		safeExit=smRes;
		return smRes;
	} // getSafeExit().

 	/**
 	 * Returns the train image
 	 *
 	 * @return  the image of this train
 	 **/
	public Image getTrainImage() {
		return img.getImage();
	}


 	/**
 	 * Returns the position of this train
 	 *
 	 * @return  an integer of the value of current position
 	 **/
	public synchronized int getPos() {
		return pos;
	}

 	/**
 	 * Returns the  x position of this train
 	 *
 	 * @return  an integer of the value of current x position
 	 **/	public synchronized int getXPos() {
		return xpos;
	}


 	/**
 	 * Returns the y position of this train
 	 *
 	 * @return  an integer of the value of y current position
 	 **/
	public synchronized int getYPos() {
		return ypos;
	}


 	/**
 	 * Returns the current station where the train is.
 	 *
 	 * @return  an integer of the number of the current station.
 	 **/
	public synchronized int getCurStation() {
		return curStation;
	}

 	/**
 	 * Returns the direction
 	 *
 	 * @return  an integer of the value of current direction
 	 **/
	public synchronized int getCurDir() {
		return moveDir;
	}


 	/**
 	 * Returns the current platform
 	 *
 	 * @return  an integer of the number of current platform
 	 **/
	public synchronized int getCurPlat() {
		return avPlat;
	}


 	/**
 	 * Returns true if the train is stopped at a station or false if not.
 	 *
 	 * @return  a boolean of the value of the variable stopSign
 	 **/
	public synchronized boolean getStopSign() {
		return stopSign;
	}


 	/**
 	 * Returns true if the train is waiting for any reason.
 	 *
 	 * @return  a boolean of the value of the variable wait
 	 **/
	public synchronized boolean getWait() {
		return wait;
	}


 	/**
 	 * Returns true if the train is waiting to exit a station
 	 *
 	 * @return  a boolean of the value of the variable safeExit
 	 **/
	public boolean getSafeExit() {
		return safeExit;
	}


 	/**
 	 * Returns the type of this train.
 	 *
 	 * @return  an integer representing the type of this train.
 	 **/
	public int getType() {
		return trType;
	}


 	/**
 	 * Returns the name of this train.
 	 *
 	 * @return  a String for the name of this train.
 	 **/
	public String getName() {
		return name;
	}

 	/**
 	 * Returns the No of this train.
 	 *
 	 * @return  an integer of the number of this train.
 	 **/
	public int getNo() {
		return trainNo;
	}
} // end of class Train.