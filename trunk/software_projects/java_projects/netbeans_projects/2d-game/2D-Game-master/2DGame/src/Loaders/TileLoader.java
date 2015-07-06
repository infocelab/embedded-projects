package Loaders;

import Game.Tile;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author mike
 */
public class TileLoader {
    
    public Tile[] tiles = new Tile[256];
    
    int tileNumber;
    int i;
    int x;
    
    public void loadTiles() {
        
        BufferedImage tileSheet = null;
        
        try {
        
            tileSheet = ImageIO.read(new File("build\\classes\\res\\img\\tilesheet2.png"));
            
            i = 0;
            x = 0;

            for(int y = 0; y < 512; y += 0) {

                if(i < tiles.length) {

                    switch(i) {
                        case 0:
                            tiles[i] = new Tile(tileSheet.getSubimage(x, y, 32, 32),i,(byte)0,(byte)0,(byte)0,(byte)0,(byte)0);
                            break;
                        case 1:
                            tiles[i] = new Tile(tileSheet.getSubimage(x, y, 32, 32),i,(byte)0,(byte)0,(byte)0,(byte)0,(byte)0);
                            break;
                        case 2:
                            tiles[i] = new Tile(tileSheet.getSubimage(x, y, 32, 32),i,(byte)1,(byte)1,(byte)1,(byte)1,(byte)1);
                            break;
                        case 3:
                            tiles[i] = new Tile(tileSheet.getSubimage(x, y, 32, 32),i,(byte)1,(byte)1,(byte)1,(byte)1,(byte)1);
                            break;
                        case 4:
                            tiles[i] = new Tile(tileSheet.getSubimage(x, y, 32, 32),i,(byte)1,(byte)1,(byte)0,(byte)0,(byte)10);
                            break;
                        case 5:
                            tiles[i] = new Tile(tileSheet.getSubimage(x, y, 32, 32),i,(byte)0,(byte)1,(byte)0,(byte)1,(byte)10);
                            break;
                        case 6:
                            tiles[i] = new Tile(tileSheet.getSubimage(x, y, 32, 32),i,(byte)0,(byte)1,(byte)0,(byte)0,(byte)10);
                            break;
                        case 7:
                            tiles[i] = new Tile(tileSheet.getSubimage(x, y, 32, 32),i,(byte)0,(byte)0,(byte)0,(byte)1,(byte)10);
                            break;
                        case 8:
                            tiles[i] = new Tile(tileSheet.getSubimage(x, y, 32, 32),i,(byte)0,(byte)0,(byte)1,(byte)1,(byte)10);
                            break;
                        case 9:
                            tiles[i] = new Tile(tileSheet.getSubimage(x, y, 32, 32),i,(byte)1,(byte)0,(byte)1,(byte)0,(byte)10);
                            break;
                        case 10:
                            tiles[i] = new Tile(tileSheet.getSubimage(x, y, 32, 32),i,(byte)0,(byte)0,(byte)1,(byte)0,(byte)10);
                            break;
                        case 11:
                            tiles[i] = new Tile(tileSheet.getSubimage(x, y, 32, 32),i,(byte)1,(byte)0,(byte)0,(byte)0,(byte)10);
                            break;
                        case 12:
                            tiles[i] = new Tile(tileSheet.getSubimage(x, y, 32, 32),i,(byte)10,(byte)10,(byte)10,(byte)10,(byte)1);
                            break;
                        case 13:
                            tiles[i] = new Tile(tileSheet.getSubimage(x, y, 32, 32),i,(byte)10,(byte)10,(byte)10,(byte)10,(byte)1);
                            break;
                        case 14:
                            tiles[i] = new Tile(tileSheet.getSubimage(x, y, 32, 32),i,(byte)10,(byte)10,(byte)10,(byte)10,(byte)1);
                            break;
                        case 15:
                            tiles[i] = new Tile(tileSheet.getSubimage(x, y, 32, 32),i,(byte)10,(byte)10,(byte)10,(byte)10,(byte)1);
                            break;
                        case 16:
                            tiles[i] = new Tile(tileSheet.getSubimage(x, y, 32, 32),i,(byte)10,(byte)10,(byte)10,(byte)10,(byte)1);
                            break;
                        case 17:
                            tiles[i] = new Tile(tileSheet.getSubimage(x, y, 32, 32),i,(byte)10,(byte)10,(byte)10,(byte)10,(byte)1);
                            break;
                        case 18:
                            tiles[i] = new Tile(tileSheet.getSubimage(x, y, 32, 32),i,(byte)10,(byte)10,(byte)10,(byte)10,(byte)1);
                            break;
                        case 19:
                            tiles[i] = new Tile(tileSheet.getSubimage(x, y, 32, 32),i,(byte)10,(byte)10,(byte)10,(byte)10,(byte)1);
                            break;
                    }

                }

                i++;
                x += 32;

                if(x == 512) {
                    x = 0;
                    y+= 32;
                }

                if(y == 512) {

                    break;

                }

            }
        
        } catch (IOException e) {
            System.out.println("ERROR: Failed to load the tile sheet.");
        }
        
    }
    
    public Tile[] getTiles() {
        
        return tiles;
        
    }
    
    public Tile getTile(int num) {

        return tiles[num-1];
        
    }
    
}
