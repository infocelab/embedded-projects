import java.io.IOException;
import javax.microedition.lcdui.*;
import javax.microedition.lcdui.game.*;

public class About extends GameCanvas
{
    Main main;
    Image  img;
    public About(Main m)
    {
        super(false);
        main = m;
        setFullScreenMode(true);
        
        Graphics g = getGraphics();
        try
        {
            img = Image.createImage("/about.png");
        }
        catch(IOException e)
        {
            System.err.println("Error loading image in about class" + e.getMessage());
        }
        g.drawImage(img,0,0, Graphics.TOP|Graphics.LEFT);
        flushGraphics();
    }
    public void keyPressed(int key)
    {
        main.displayMenu();
    }
}


