/*
 *   *       Please Visit us at www.codemiles.com     *
 *  This Program was Developed by www.codemiles.com forums Team
 *  *           Please Don't Remove This Comment       *
 */

package m_snake.MainPanel.snakeBody;

import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Float;
import java.util.Random;


/**
 *
 * @author SQLStudent
 */
public class Food {
    
    /** Creates a new instance of Food */
    public Food() {
        Food_Postion.setLocation((((int)((Math.random()*(100)))%20)*20),((((int)(Math.random()*(10)))%20)*20));
        int x=(int)Food_Postion.getX();
        int y=(int)Food_Postion.getY();
        
        while(x>260||y>260) {
            Food_Postion.setLocation((((int)((Math.random()*(100)))%20)*20),((((int)(Math.random()*(10)))%20)*20));
            x=(int)Food_Postion.getX();
            y=(int)Food_Postion.getY();
        }
        
    }
    public void getFood() {
        //  Food_Postion.setLocation((((int)(Food_Generator.nextInt(20)*(100)))%20)*20,((((int)(Food_Generator.nextInt(100)*(10)))%20)*20));
        Food_Postion.setLocation((((int)((Math.random()*(100)))%20)*20),((((int)(Math.random()*(10)))%20)*20));
        
        
        
    }
    public double getX() {
        return Food_Postion.getX();
    }
    public double getY() {
        return Food_Postion.getY();
    }
    
    public int get_int_X() {
        return (int)Food_Postion.x;
    }
    public int get_int_Y() {
        return (int)Food_Postion.y;
    }
    
    
    Point2D.Float Food_Postion=new Point2D.Float();
    Random Food_Generator=new Random();
    
    
}
/*
 *   *       Please Visit us at www.codemiles.com     *
 *  This Program was Developed by www.codemiles.com forums Team
 *  *           Please Don't Remove This Comment       *
 */