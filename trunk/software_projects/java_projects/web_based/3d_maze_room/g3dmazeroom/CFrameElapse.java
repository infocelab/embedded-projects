/***************************************
* CFrameElapse
* Author: Martin Adams
****************************************
* This class sets a behaviour to monitor
* every time a frame has been rendered
****************************************/

import javax.media.j3d.*;
import java.util.Enumeration;
import java.util.Calendar;

public class CFrameElapse extends Behavior
{
	// Create a wakeup criterion that will be used to
	// wake up every time a frame has been rendered
  private WakeupCriterion 		  wakeupNextFrame;
	
	// Store the link to the parent class
  private CFrameElapseListener 	listener = null;
  
	// Store the time variables to montior how long it
	// took to render the frames.  This is designed to
	// help make any animation take the same amount of
	// time on slower and faster computers
	private long     mCurrentTime   = 0;
  private long     mLastFrameTime = 0;
  public  float    mElapsedTime   = 0;
  private Calendar cal;
  
  CFrameElapse(CFrameElapseListener l)
  {
		// Store the parent class link
    listener = l;
		// Set the behaviour to wakeup every time a frame is rendered
    wakeupNextFrame = new WakeupOnElapsedFrames(0);
  }
    
  public void initialize()
  {
		// Activate the wakeup
    this.wakeupOn(wakeupNextFrame);
  }
  
  public void processStimulus(Enumeration criteria)
  {
		// This function is called every time a frame elapses
	
		// Calculate the time difference
    cal            = Calendar.getInstance();
    mCurrentTime   = cal.getTimeInMillis();
		mElapsedTime   = (mCurrentTime - mLastFrameTime) / 10;
		mLastFrameTime = mCurrentTime;
		
		if(criteria.nextElement().equals(wakeupNextFrame))
		{
			// Call the onFrameElapse function to inform the parent
			// class that a frame has elapsed
			listener.onFrameElapse();
		}
		// Tell the behaviour to wake up again on the next frame
		this.wakeupOn(wakeupNextFrame);
  }
}