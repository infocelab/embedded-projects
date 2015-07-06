import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author mike
 */
public class Game implements ActionListener {

    JFrame frame;
    DP panel;
    KL keyListener;
    
    MapLoader loader;
    
    Timer time;
    
    Tile arb = new Tile(0);
    
    public Game() {
        
        arb.loadTiles();
        
        frame = new JFrame("2D Game");
        panel = new DP();
        keyListener = new KL();
        
        loader = new MapLoader();
        
        loader.load();
        
    }
    
    public static void main(String[] args) {
        
        Game g = new Game();
        g.setUp();
        
    }
    
    public void setUp() {
        
        frame.setSize(800,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(BorderLayout.CENTER, panel);
        panel.setFocusable(true);
        panel.addKeyListener(keyListener);
        frame.setVisible(true);
        
        time = new Timer(5, this);
        time.start();
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        frame.repaint();
        
    }
    
    public class DP extends JPanel {
        
        public void paintComponent(Graphics g) {
            
            g.drawRect(0,0,frame.getWidth(), frame.getHeight());
            
            Image[] tiles;
            int[][] mapTileNumbers = loader.getTiles();
            
            tiles = arb.getTiles();
            
            int x = 0;
            int y = 0;
            
            int m = 0;
            int n = 0;
            
            for(int i = 0; i < mapTileNumbers.length*32; i++) {
                
                if(x == mapTileNumbers.length*32) {
                    
                    x = 0;
                    y+=32;
                    
                }
                
                if(n > mapTileNumbers[m].length -1) {
                    
                    n = 0;
                    m++;
                    
                }
                
                if(mapTileNumbers[m][n] == 1) {
                
                    g.drawImage(arb.getTile(1), x, y, 32, 32, null);
                
                } else if (mapTileNumbers[m][n] == 2) {
                    
                    g.drawImage(arb.getTile(2), x, y, 32, 32, null);
                    
                }
                
                n++;
                x+=32;
                
            }
            
        }
        
    }
    
    public class KL extends KeyAdapter {
        
    }
    
}
