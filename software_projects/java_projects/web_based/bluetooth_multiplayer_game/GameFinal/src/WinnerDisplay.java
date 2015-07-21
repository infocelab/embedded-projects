import javax.microedition.lcdui.*;
import javax.microedition.lcdui.game.*;

public class WinnerDisplay extends GameCanvas
{
    Main main;
    public WinnerDisplay(Main m, int code)
    {
        super(false);
        main = m;
        setFullScreenMode(true);
        Graphics g = getGraphics();
        g.setColor(255,255,255);
        g.fillRect(0,0,getWidth(), getHeight());
        g.setColor(0,0,0);
        
        if(code == -51)
        {
            g.drawString("Server has won!!!", 0,0, Graphics.TOP|Graphics.LEFT);
        }
        else
        {
             g.drawString("Client has won!!!", 0,0, Graphics.TOP|Graphics.LEFT);
        }
        flushGraphics();
    }
    
    public void keyPressed(int key)
    {
        main.exit();
    }
}
