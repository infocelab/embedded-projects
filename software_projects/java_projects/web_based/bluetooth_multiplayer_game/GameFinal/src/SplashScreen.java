import java.io.IOException;
import javax.microedition.lcdui.game.*;
import javax.microedition.lcdui.*;
import java.util.*;



public class SplashScreen extends GameCanvas 
{
    Main main;
    Image img;
    Sprite s1;
    Graphics g;
    boolean leAnim;
    Timer t;
    int width, height;
    int s1check; // to check if the number of frames shown == total num to be shown
    // s1 lone eagle & s2 game studios sprite
    
    public SplashScreen(Main m) 
    {
        super(false);
        setFullScreenMode(true);
        // setting up all initial values
        main = m;
        leAnim = true;
        
        g= getGraphics();
        s1check =0;
        try
        {
            img = Image.createImage("/lesheet.png");
            s1 = new Sprite(img, 176, 50);
            img = Image.createImage("/studiologo.png");
            
        }
        
        catch(IOException e)
        {
            System.err.println("Error loading images" + e.getMessage());
        }
    }
    
    public void startAnim() // this func will start the animation process
    {
        // set up the anim timer after initializing all variables
        
        width = getWidth();
        height = getHeight();
        int[] seq = {11,10,9,8,7,6,5,4,3,2,1,0};
        s1.setFrameSequence(seq);
        s1.setFrame(0);
        //s1.setRefPixelPosition(s1.getWidth()/2, s1.getHeight()/2);
        int x = width/2 - s1.getWidth()/2;
        int y = height/2 - s1.getHeight()/2;
        s1.setPosition(x,y);
        
        t = new Timer();
        animateTask anim = new animateTask();
        t.schedule(anim,0, 175);
    }
    
    public void paint()
    {
        
        // this function does all the meaty part
        g.setColor(0,0,0);
        g.fillRect(0,0,getWidth(),getHeight());
        if(leAnim == true)
        {
            s1.paint(g);
            s1.nextFrame();
            s1check++;
            if(s1check == s1.getFrameSequenceLength())
            {
                leAnim = false;
                
                // now the next iteration of timer will display the next image not this sprite sequence
                s1check=0;
            }
            
        }
        
        else
        {
            g.setColor(0,0,0);
            g.fillRect(0,0,getWidth(),getHeight());
            g.drawImage(img, width/2, height/2,Graphics.HCENTER|Graphics.VCENTER);
            int delayvalue =20;
            if(s1check > delayvalue)
            {
                s1=null;
                img = null;
                t.cancel();
                main.displayMenu(); // this func in main will set the display to game Menu class
                
            }
            s1check++;
            // s1check used to displayMenu in next iteration if the game studio image has been displayed once
            
            
        }
        
        flushGraphics();
    }
    
    // inner timertask class
    
    class animateTask extends TimerTask
    {
        public animateTask()
        {         
         
        }
        
        public void run()
        {
            paint();
        }
    }
}
