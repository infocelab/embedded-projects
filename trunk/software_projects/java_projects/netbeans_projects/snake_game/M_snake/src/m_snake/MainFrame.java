/*
 *   *       Please Visit us at www.codemiles.com     *
 *  This Program was Developed by www.codemiles.com forums Team
 *  *           Please Don't Remove This Comment       *
 */

package m_snake;
import java.awt.Container;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JApplet;
import javax.swing.JFrame;
import m_snake.MainPanel.myPanel;

/**
 *
 * @author SQLStudent
 */
public class MainFrame extends JApplet implements KeyListener{
    
    /** Creates a new instance of MainFrame */
    public void init() {
        setSize(540,540);
        Container cpane=getContentPane();
        
        
        
        cpane.add(snakePanel);
        addKeyListener(this);
        
        
        
        
        
    }
    
    /**
     * @param args the command line arguments
     *
     */
    public static void main(String[] args) {
        // TODO code application logic here
        MainFrame my_Game=new MainFrame();
        JFrame myFrame=new JFrame(" Simple Snake Game ");
        myFrame.setSize(800,500);
        myFrame.getContentPane().add(my_Game);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.addKeyListener(my_Game);
        
        my_Game.init();
        my_Game.start();
        my_Game.setVisible(true);
        myFrame.setVisible(true);
        
    }
    
    public void keyTyped(KeyEvent e) {
    }
    
    public void keyPressed(KeyEvent e) {
        
        if(e.getKeyCode()==UP) {
            snakePanel.set_Direction(1);
        } else if (e.getKeyCode()==RIGHT) {
            snakePanel.set_Direction(2);
        } else if(e.getKeyCode()==DOWN) {
            snakePanel.set_Direction(3);
        } else if(e.getKeyCode()==LEFT) {
            snakePanel.set_Direction(4);
        }
    }
    
    public void keyReleased(KeyEvent e) {
    }
    private final int LEFT = 37;
    private final int RIGHT = 39;
    private final int UP = 38;
    private final int DOWN = 40;
    private   myPanel snakePanel=new myPanel();
    
}
/*
 *   *       Please Visit us at www.codemiles.com     *
 *  This Program was Developed by www.codemiles.com forums Team
 *  *           Please Don't Remove This Comment       *
 */