package Loaders;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class MapLoader {

    File map;
    Scanner scan;
    
    String[][] stringTileNumbers = new String[500][500];
    int[][] tileNumbers = new int[500][500];
    
    public MapLoader(File f) {
        
        map = f;
        
    }
    
    public MapLoader() {
        
        map = new File("build\\classes\\res\\maps\\map.txt");
        
    }
    
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
                        
                        tileNumbers[i][j] = -1;
                        
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