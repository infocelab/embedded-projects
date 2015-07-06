import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author mike
 */
public class Tile {
    
    Image[] tiles = new Image[256];
    Image tile;
    
    int tileNumber;
    
    public Tile(int num) {
        
        tileNumber = num;
        
        switch(num) {
            case 1:
                tile = tiles[0];
                break;
            case 2:
                tile = tiles[1];
                break;
            case 3:
                tile = tiles[2];
                break;
            case 4:
                tile = tiles[3];
                break;
            case 5:
                tile = tiles[4];
                break;
            case 6:
                tile = tiles[5];
                break;
            case 7:
                tile = tiles[6];
                break;
            case 8:
                tile = tiles[7];
                break;
            case 9:
                tile = tiles[8];
                break;
            case 10:
                tile = tiles[9];
                break;
            case 11:
                tile = tiles[10];
                break;
            case 12:
                tile = tiles[11];
                break;
            case 13:
                tile = tiles[12];
                break;
            case 14:
                tile = tiles[13];
                break;
            case 15:
                tile = tiles[14];
                break;
            case 16:
                tile = tiles[15];
                break;
            case 17:
                tile = tiles[16];
                break;
            case 18:
                tile = tiles[17];
                break;
            case 19:
                tile = tiles[18];
                break;
            case 20:
                tile = tiles[19];
                break;
            case 21:
                tile = tiles[20];
                break;
            case 22:
                tile = tiles[21];
                break;
            case 23:
                tile = tiles[22];
                break;
            case 24:
                tile = tiles[23];
                break;
            case 25:
                tile = tiles[24];
                break;
            case 26:
                tile = tiles[25];
                break;
            case 27:
                tile = tiles[26];
                break;
            case 28:
                tile = tiles[27];
                break;
            case 29:
                tile = tiles[28];
                break;
            case 30:
                tile = tiles[29];
                break;
            case 31:
                tile = tiles[30];
                break;
            case 32:
                tile = tiles[31];
                break;
            case 33:
                tile = tiles[32];
                break;
            case 34:
                tile = tiles[33];
                break;
            case 35:
                tile = tiles[34];
                break;
            case 36:
                tile = tiles[35];
                break;
            case 37:
                tile = tiles[36];
                break;
            case 38:
                tile = tiles[37];
                break;
            case 39:
                tile = tiles[38];
                break;
            case 40:
                tile = tiles[39];
                break;
            case 41:
                tile = tiles[40];
                break;
            case 42:
                tile = tiles[41];
                break;
            case 43:
                tile = tiles[42];
                break;
            case 44:
                tile = tiles[43];
                break;
            default:
                tile = null;
                break;
            
        }
        
    }
    
    public void loadTiles() {
        
        BufferedImage tileSheet = null;
        
        try {
        
            tileSheet = ImageIO.read(new File("D:\\2D Game Res\\img\\tilesheet.png"));
        
        } catch (IOException e) {
            
            e.printStackTrace();
            
        }
        
        int i = 0;
        int x = 0;
        
        for(int y = 0; y < 512; y += 0) {
            
            if(i < tiles.length) {
            
                tiles[i] = tileSheet.getSubimage(x, y, 32, 32);
            
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
        
    }
    
    public Image[] getTiles() {
        
        return tiles;
        
    }
    
    public Image getTile(int num) {

        return tiles[num-1];
        
    }
    
    public int getTileNumber() {
        
        return tileNumber;
        
    }
    
}
