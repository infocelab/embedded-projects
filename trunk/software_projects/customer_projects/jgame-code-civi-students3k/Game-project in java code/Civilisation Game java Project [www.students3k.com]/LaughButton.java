import java.applet.*;
import java.net.*;
import javax.swing.*;

/**
 * Title:       LaughButton.java
 * Description: This class plays the fight sounds when units clash
 * @author:     Shane Grund
 * @version:    1.0
 */
public class LaughButton implements Runnable
{
    AudioClip laugh = null;//new AudioClip();
    Thread runner;

    /**
     * Constructor sets up sound to be played and plays it and
     * then stops playing it.
     */
    LaughButton()
    {
            try
            {
                URL laughIn = new URL("file:sounds/foo.wav");
                laugh = JApplet.newAudioClip(laughIn);
                startLaughing();
                stopLaughing();
            } catch (MalformedURLException e) { }

    }//end laughButton

    void startLaughing()
    {
         if (runner == null)
         {
             runner = new Thread(this);
             runner.start();
         }
    }//end start laughing

    void stopLaughing()
    {
        if (runner != null)
        {
              laugh.stop();
              runner = null;
        }
    }//end stop laughing

    public void run()
    {
        laugh.play();
        Thread thisThread = Thread.currentThread();
        while (runner == thisThread)
        {
            try
            {
                Thread.sleep(5000);
            } catch (InterruptedException e) { }
        }//end while
   }//end run
}//end class
