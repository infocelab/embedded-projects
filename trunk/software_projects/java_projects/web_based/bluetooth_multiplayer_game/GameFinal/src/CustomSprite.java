import javax.microedition.lcdui.game.*;
import javax.microedition.lcdui.*;

public class CustomSprite extends Sprite
{
    int health = 100;
    
    int direction = 0, prevDirection = 0; 
    /* direction guide
     *0= right
     *1= 30degree down
     *2= 45degree down
     *3= 75degree down
     *4= down
     *5=
     *6=
     *7=
     *8=left
     *9=
     *10=
     *11=
     *12=up
     *13=
     *14=
     *15=
     */
    
    public CustomSprite(Image img,int width, int height)
    {
        super(img, width, height);
    }
    
    public int decrementHealth(int decr)
    {
        health -= decr;
        return health;
    }
    
    public int getDirection()
    {
        return direction;
    }
    
    public void setDirection(int x)
    {
        prevDirection = direction;
        direction = x;
    }
    
    
   
}
