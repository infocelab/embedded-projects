package Game;

import Loaders.TileLoader;
import Loaders.SpriteLoader;
import Loaders.MapLoader;
import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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
    TileLoader arb;
    Player player;
    SpriteLoader sLoader;
    CollisionChecker cChecker;
    
    int animationFrame;
    int[][] mapTileNumbers;
    Tile[] tiles;
    int x = 0;
    int y = 0;
    int m = 0;
    int n = 0;
    int incr = 0;
    int t = 0;
    boolean[] collisionBools = new boolean[250000];
    int[] collisionInts = new int[250000];
    
    public Game() {
        
        arb = new TileLoader();
        arb.loadTiles();
        frame = new JFrame("2D Game");
        panel = new DP();
        keyListener = new KL();
        loader = new MapLoader();
        loader.load();
        sLoader = new SpriteLoader();
        sLoader.load();
        player = new Player(0,0,sLoader.getSprite());
        cChecker = new CollisionChecker();
        
        mapTileNumbers = loader.getTiles();
        tiles = new Tile[250000];
        
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
        
        generateMap();
        
        time = new Timer(5, this);
        time.start();
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        for(int i = 0; i < tiles.length; i++) {
            if(tiles[i] != null) {
                collisionBools[i] = cChecker.checkCollision(player, tiles[i]);
                collisionInts[i] = cChecker.dirWhenCollision(player);
            }
        }
        player.move(collisionBools, collisionInts);
        frame.repaint();
        
    }
    
    public void generateMap() {
            
        for(int i = 0; i < mapTileNumbers.length*32; i++) {
                
            if(x == mapTileNumbers.length*32) {
                    
                x = 0;
                y+=32;
                    
            }
                
            if(n > mapTileNumbers[m].length -1) {
                    
                n = 0;
                m++;
                    
            }
                
            for(int j = 1; j < arb.tiles.length; j++) {
                
                if(mapTileNumbers[m][n] == j) {

                    tiles[incr] = new Tile(arb.getTile(j));
                    tiles[incr].setX(x);
                    tiles[incr].setY(y);
                    incr++;
                    
                }
                
            }
                
            n++;
            x+=32;
            
        }
        
    }
    
    public class DP extends JPanel {
        
        @Override
        public void paintComponent(Graphics g) {
            
            g.drawRect(0,0,frame.getWidth(), frame.getHeight());
            for(int i = 0; i < tiles.length; i++) {
                if(tiles[i] != null) {
                    g.drawImage(tiles[i].getTile(), tiles[i].getX(), tiles[i].getY(), 32, 32, null);
                }
            }
            g.drawImage(player.sprite[player.getDirection()][1], player.x, player.y, 24, 32, null);
            animationFrame++;
            
            if(animationFrame >= 30 && animationFrame < 80) {
                g.drawImage(player.sprite[player.getDirection()][0], player.x, player.y, 24, 32, null);
            } else if (animationFrame >= 80 && animationFrame < 150) {
                g.drawImage(player.sprite[player.getDirection()][2], player.x, player.y, 24, 32, null);
                animationFrame = 0;
            }
            g.drawString("COORDS: (" + player.getX() + ", " + player.getY() + ")", 0, 290);
            for(int i = 0; i < collisionBools.length; i++) {
                if(collisionBools[i]) {
                    g.drawString("COLLISION!", 0, 300);
                }
            }
        }
        
    }
    
    public class KL extends KeyAdapter {
        
        @Override
        public void keyPressed(KeyEvent e) {
            player.keyPressed(e);
        }
        
        @Override
        public void keyReleased(KeyEvent e) {
            player.keyReleased(e);
        }
        
    }
    
}
