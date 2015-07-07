/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import java.awt.Image;
import java.awt.event.KeyEvent;

public class Player {

    int x, y, dx, dy, key, dir;
    Image[][] sprite = new Image[4][3];
    boolean fromBreak = false;
    int iFromBreak;
    
    public Player(int x, int y, Image[][] sprite) {
        
        this.x = x;
        this.y = y;
        dx = 0;
        dy = 0;
        System.arraycopy(sprite[0], 0, this.sprite[0], 0, 3);
        System.arraycopy(sprite[1], 0, this.sprite[1], 0, 3);
        System.arraycopy(sprite[2], 0, this.sprite[2], 0, 3);
        System.arraycopy(sprite[3], 0, this.sprite[3], 0, 3);
    }
    
    public void move(boolean[] collisions, int[] directions) {
        
        fromBreak = false;
        for(int i = 0; i < collisions.length; i++) {
            if(collisions[i]) {
                fromBreak = true;
                iFromBreak = directions[i];
                break;
            }
        }
        
        if(fromBreak) {
            switch(iFromBreak){
                case 0:
                    if(dy != -1) {
                        y += dy + 1;
                    }
                    break;
                case 1:
                    if(dx != 1) {
                        x += dx - 1;
                    }
                    break;
                case 2:
                    if(dy != 1) {
                        y += dy - 1;
                    }
                    break;
                case 3:
                    if(dx != -1) {
                        x += dx + 1;
                    }
                    break;
            }
        } else {
            x += dx;
            y += dy;
            if(x < 0)
                x=0;
            if(y < 0)
                y=0;
            
        }
        
    }
    
    public void keyPressed(KeyEvent e) {
        
        key = e.getKeyCode();
        
        switch(key) {
            case KeyEvent.VK_UP:
                dy = -1;
                dir = 0;
                break;
            case KeyEvent.VK_DOWN:
                dy = 1;
                dir = 2;
                break;
            case KeyEvent.VK_LEFT:
                dx = -1;
                dir = 3;
                break;
            case KeyEvent.VK_RIGHT:
                dx = 1;
                dir = 1;
                break;
        }
        
    }

    public void keyReleased(KeyEvent e) {
    
        key = e.getKeyCode();
        
        switch(key) {
            case KeyEvent.VK_UP:
                dy = 0;
                break;
            case KeyEvent.VK_DOWN:
                dy = 0;
                break;
            case KeyEvent.VK_LEFT:
                dx = 0;
                break;
            case KeyEvent.VK_RIGHT:
                dx = 0;
                break;
        }
        
    }
    
    public int getDirection() {
        return dir;
    }
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
    
}
