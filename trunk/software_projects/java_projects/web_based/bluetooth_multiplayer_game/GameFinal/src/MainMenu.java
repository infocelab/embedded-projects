import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import javax.microedition.lcdui.*;
import javax.microedition.lcdui.game.*;
import javax.microedition.media.*;

public class MainMenu extends GameCanvas
{
    Main main;
    Image imgBack1, imgFront;
    Graphics g;
    Sprite menuElements;
    int index;
    int width, height;
    int menuX,menuY,i,incrY,incrX;
    InputStream is;
    Player player;
    Timer t;
    public MainMenu(Main m)
    {
        super(false); // DONT supress key events and use key polling
        setFullScreenMode(true);
        g= getGraphics();
        width = getWidth();
        height = getHeight();
        
        main = m;
        index = 0;// this value will define menu interactiveness
        incrX=5;
        incrY= -2;
        try
        {
            imgBack1 = Image.createImage("/menusprite.png");
            menuElements = new Sprite(imgBack1, 100, 10);
            imgBack1 = Image.createImage("/back1.png");
            imgFront = Image.createImage("/mainscreen.png");
            
            is = getClass().getResourceAsStream("/backTrack.midi");
            player = Manager.createPlayer(is, "audio/midi");
            player.prefetch();
            
        }
        catch(IOException e)
        {
            System.err.println("Error loading images" + e.getMessage());
        }
        catch(MediaException e)
        {
            System.err.println("Error loading player" + e.getMessage());
        }
                
    }
    
    public void startMenu()
    {
        try
        {        
            
            player.start();        
            paint();
        }
       /* t = new Timer();
        menuInputTask mTask = new menuInputTask();
        t.schedule(mTask,0, 300); // check input every 300 ms
        */
        catch(MediaException e)
        {
            System.err.println("Error loading player" + e.getMessage());
        }
    }
    
    public void keyPressed(int keyCode)
    {
        //int keyStates = getKeyStates();
        if(getKeyCode(DOWN) == keyCode || keyCode == KEY_NUM8)
        {
            if(index == 4)
            {
                index = 0;
            }
            else
            {
                index++;
            }
             paint();
             System.err.println("Down" +index);
        }
        if(getKeyCode(UP) == keyCode  || keyCode == KEY_NUM2)
        {
            if(index == 0)
            {
                index = 4;
            }
            else
            {
                index--;
            }
             paint();
             System.err.println("UP " +index);
        }
        
        if(getKeyCode(FIRE) == keyCode || keyCode == KEY_NUM5)
        {
             paint();
             System.err.println("Fire " +index);
            switch(index)
            {
                
                case 0:
                    main.newGame();
                    break;
                case 1:
                    main.options();
                    break;
                case 2:
                    main.help();
                    break;
                case 3:
                    main.about();
                    break;
                case 4:
                    imgBack1= null;
                    imgFront = null;
                    menuElements = null;
                    
                    try
                    {
                        player.stop();
                    }
                    catch(MediaException e)
                    {
                        System.err.println("Error stoping player"+ e.getMessage());
                    }
                    player= null;
                    is = null;
                    //t.cancel();
                    System.gc();
                    main.exit();
            }
        }
       
    }
    
    public void paint()
    {
        g.setColor(0,0,0);
        g.fillRect(0,0,getWidth(),getHeight());
        g.drawImage(imgBack1,0,0, Graphics.TOP|Graphics.LEFT);
        g.drawImage(imgFront,0,0, Graphics.TOP|Graphics.LEFT);
        i = 0;
        menuY= 80;
        menuX= width/2- menuElements.getWidth()/2;
        if(index == 0) // new game selected
        {
            menuElements.setFrame(1); // ng selected red
            menuElements.setPosition(menuX + incrX,menuY + incrY);
            menuElements.paint(g);
            i+=2;
            
            menuElements.setFrame(2); // opt white
            menuElements.setPosition(menuX,  menuY + i*10);
            menuElements.paint(g);
            i+=2;
            
            menuElements.setFrame(4); //help white
            menuElements.setPosition(menuX, menuY + i*10);
            menuElements.paint(g);
            i+=2;
            
            menuElements.setFrame(6); // about white
            menuElements.setPosition(menuX, menuY + i*10);
            menuElements.paint(g);
            i+=2;
            
            menuElements.setFrame(8); // exit white
            menuElements.setPosition(menuX, menuY + i*10);
            menuElements.paint(g);
            
            i =0;
        }
        
        
        if(index == 1) // options selected
        {
            menuElements.setFrame(0); // ng white
            menuElements.setPosition(menuX ,menuY);
            menuElements.paint(g);
            i+=2;
            
            menuElements.setFrame(3); // opt red
            menuElements.setPosition(menuX + incrX,  menuY + i*10 + incrY);
            menuElements.paint(g);
            i+=2;
            
            menuElements.setFrame(4); //help white
            menuElements.setPosition(menuX, menuY + i*10);
            menuElements.paint(g);
            i+=2;
            
            menuElements.setFrame(6); // about white
            menuElements.setPosition(menuX, menuY + i*10);
            menuElements.paint(g);
            i+=2;
            
            menuElements.setFrame(8); // exit white
            menuElements.setPosition(menuX, menuY + i*10);
            menuElements.paint(g);
            
            i =0;
        }
        
        
        if(index == 2) // help selected
        {
            menuElements.setFrame(0); // ng white
            menuElements.setPosition(menuX ,menuY);
            menuElements.paint(g);
            i+=2;
            
            menuElements.setFrame(2); // opt white
            menuElements.setPosition(menuX,  menuY + i*10);
            menuElements.paint(g);
            i+=2;
            
            menuElements.setFrame(5); //help red
            menuElements.setPosition(menuX + incrX, menuY + i*10 + incrY);
            menuElements.paint(g);
            i+=2;
            
            menuElements.setFrame(6); // about white
            menuElements.setPosition(menuX, menuY + i*10);
            menuElements.paint(g);
            i+=2;
            
            menuElements.setFrame(8); // exit white
            menuElements.setPosition(menuX, menuY + i*10);
            menuElements.paint(g);
            
            i =0;
        }
        
        if(index == 3) // about selected
        {
            menuElements.setFrame(0); // ng white
            menuElements.setPosition(menuX ,menuY);
            menuElements.paint(g);
            i+=2;
            
            menuElements.setFrame(2); // opt white
            menuElements.setPosition(menuX,  menuY + i*10);
            menuElements.paint(g);
            i+=2;
            
            menuElements.setFrame(4); //help white
            menuElements.setPosition(menuX , menuY + i*10 );
            menuElements.paint(g);
            i+=2;
            
            menuElements.setFrame(7); // about red
            menuElements.setPosition(menuX + incrX, menuY + i*10 + incrY);
            menuElements.paint(g);
            i+=2;
            
            menuElements.setFrame(8); // exit white
            menuElements.setPosition(menuX, menuY + i*10);
            menuElements.paint(g);
            
            i =0;
        }
        
        
         if(index == 4) // exit selected
        {
            menuElements.setFrame(0); // ng white
            menuElements.setPosition(menuX ,menuY);
            menuElements.paint(g);
            i+=2;
            
            menuElements.setFrame(2); // opt white
            menuElements.setPosition(menuX,  menuY + i*10);
            menuElements.paint(g);
            i+=2;
            
            menuElements.setFrame(4); //help white
            menuElements.setPosition(menuX , menuY + i*10 );
            menuElements.paint(g);
            i+=2;
            
            menuElements.setFrame(6); // about white
            menuElements.setPosition(menuX , menuY + i*10 );
            menuElements.paint(g);
            i+=2;
            
            menuElements.setFrame(9); // exit red
            menuElements.setPosition(menuX + incrX, menuY + i*10 + incrY);
            menuElements.paint(g);
            
            i =0;
        }
       
        
        flushGraphics();
    }
    
    // inner timer class
    class menuInputTask extends TimerTask
    {
        public void run()
        {
           // input();
        }
        
    }
   
}
