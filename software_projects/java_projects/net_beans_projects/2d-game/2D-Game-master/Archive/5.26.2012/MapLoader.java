import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author mike
 */
public class MapLoader {

    File map = new File("D:\\2D Game Res\\maps\\map.txt");
    Scanner scan;
    
    String[][] stringTileNumbers = new String[128][128];
    int[][] tileNumbers = new int[128][128];
    
    public void load() {
        
        try {
            
            scan = new Scanner(map);
            
            int x = 0;
            int y = 0;
            
            while(scan.hasNext()) {
            
                stringTileNumbers[y] = scan.next().split(",");
            
                y++;
                
            }
            
            for(int i = 0; i < stringTileNumbers.length; i++) {
                
                for(int j = 0; j < stringTileNumbers[i].length; j++) {
                
                    if(stringTileNumbers[i][j] == null) {
                        
                        tileNumbers[i][j] = 0;
                        
                    } else {
                    
                        tileNumbers[i][j] = Integer.parseInt(stringTileNumbers[i][j]);
                    
                    }
                    
                }
                    
            }
            
        } catch (IOException ex) {
            
            ex.printStackTrace();
            
        }
        
    }
    
    public int[][] getTiles() {
        
        return tileNumbers;
        
    }
    
}