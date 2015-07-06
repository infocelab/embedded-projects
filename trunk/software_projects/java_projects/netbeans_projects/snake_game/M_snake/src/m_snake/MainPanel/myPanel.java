/*
 *   *       Please Visit us at www.codemiles.com     *
 *  This Program was Developed by www.codemiles.com forums Team
 *  *           Please Don't Remove This Comment       *
 */

package m_snake.MainPanel;

import Snake_engin.engin;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import m_snake.MainPanel.snakeBody.Food;
import m_snake.MainPanel.snakeBody.snake;

/**
 *
 * @author SQLStudent
 */
public class myPanel extends JPanel  {
    
    /** Creates a new instance of myPanel */
    public myPanel() {
        
        
        
        setBorder(my_border);
        
        // mythread.setPriority(1);
        mythread.start();
        
    }
    public   void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D  g2D=(Graphics2D)g;
        
        g2D.setColor(Color.BLUE);
        
     /*   g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        g2D.setRenderingHint(RenderingHints.KEY_RENDERING,RenderingHints.VALUE_RENDER_QUALITY);*/
        
        Parts_X=my_engin.return_Snake_postionsX();
        Parts_Y=my_engin.return_Snake_postionsY();
        
        for(int i=0;i<my_engin.get_my_snake_lenght();i++) {
            
            
            
            g2D.fillRect(Parts_X[i],Parts_Y[i],my_Oval_size,my_Oval_size);
            
        }
        g2D.setColor(Color.RED);
        
        g2D.fillOval(my_engin.get_Food_X()+5,my_engin.get_Food_Y()+5,my_Oval_size-5,my_Oval_size-5);
        
        
    }
    
    
    class MY_Thread extends Thread {
        public   void run() {
            while(true) {
                my_engin.Move_mySnake(direction,false);
                try {
                    
                    Thread.sleep(100);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                repaint();
                if(my_engin.get_Game_over()) {
                    stop();
                }
            }
        }
    }
    
    public void set_Direction(int newDirection) {
        direction=newDirection;
    }
    
    
    private engin my_engin=new engin();
    private int Parts_X[];
    private int Parts_Y[];
    private int direction=2;
    
    private boolean is_my_first_moves=true;
    
    private final MY_Thread mythread=new MY_Thread();
    private final int my_Oval_size=my_engin.get_Oval_size();
    
    private final int LEFT = 37;
    private final int RIGHT = 39;
    private final int UP = 38;
    private final int DOWN = 40;
    private LineBorder my_border=new LineBorder(Color.green.darker(),3);
    
    
}
/*
 *   *       Please Visit us at www.codemiles.com     *
 *  This Program was Developed by www.codemiles.com forums Team
 *  *           Please Don't Remove This Comment       *
 */