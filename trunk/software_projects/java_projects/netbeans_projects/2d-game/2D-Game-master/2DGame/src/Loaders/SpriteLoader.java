/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Loaders;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author mike
 * 
 */
public class SpriteLoader {
    
    File sprites;
    BufferedImage spriteSheet;
    Image[][] playerSprites = new Image[4][3];
    
    public SpriteLoader() {
        
        sprites = new File("build\\classes\\res\\img\\spritesheet.png");
        
    }
    
    public void load() {
        
        try {
            spriteSheet = ImageIO.read(sprites);
            int i = 0;
            int j = 0;
        
            for(int y = 2; y < 135; y += 32) {
                for(int x = 0; x < 71; x += 24) {
                    if(j == 4) {
                        break;
                    } else {
                        playerSprites[j][i] = spriteSheet.getSubimage(x,y,24,32);
                        i++;
                    }
                }
                i = 0;
                j++;
            }
            
        } catch (IOException ex) {
            System.out.println("ERROR: Faild to load sprites.");
        }
        
    }
    
    public Image[][] getSprite() {
        return playerSprites;
    }
    
}
