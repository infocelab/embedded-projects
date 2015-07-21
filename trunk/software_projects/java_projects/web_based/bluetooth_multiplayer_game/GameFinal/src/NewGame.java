import javax.microedition.lcdui.*;
import javax.microedition.lcdui.game.*;

public class NewGame extends GameCanvas
{
    Graphics g;
    Main main;
    public NewGame(Main m)
    {
        super(false);
        setFullScreenMode(true);
        g = getGraphics();
        main = m;
    }
    
    public void start()
    {
        g.setColor(0,0,0);
        g.fillRect(0,0,getWidth(), getHeight());
        g.setColor(255,255,255);
        g.drawString("Press", 0,0, Graphics.TOP|Graphics.LEFT);
        g.drawString("1 to act as server", 0, 50, Graphics.TOP|Graphics.LEFT);
        g.drawString("2 to act as client",0,100, Graphics.TOP|Graphics.LEFT);
        flushGraphics();
        
    }
    
    public void keyPressed(int keyCode)
    {
        if(keyCode == Canvas.KEY_NUM1)
        {
            main.callServer();
            
        }
        if(keyCode == Canvas.KEY_NUM2)
        {
            main.callClient();
        }
    }
}
