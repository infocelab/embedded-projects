import java.io.IOException;
import javax.microedition.lcdui.*;
import javax.microedition.lcdui.game.*;

public class Help extends GameCanvas
{
    Main main;
    Image  img;
    public Help(Main m)
    {
        super(false);
        main = m;
        setFullScreenMode(true);
        
        Graphics g = getGraphics();
        try
        {
            img = Image.createImage("/help.png");
        }
        catch(IOException e)
        {
            System.err.println("Error loading image in help class" + e.getMessage());
        }
        g.setColor(0,0,0);
        g.fillRect(0,0, getWidth(),getHeight());
        g.drawImage(img,0,0, Graphics.TOP|Graphics.LEFT);
        flushGraphics();
    }
    public void keyPressed(int key)
    {
        main.displayMenu();
    }
}


