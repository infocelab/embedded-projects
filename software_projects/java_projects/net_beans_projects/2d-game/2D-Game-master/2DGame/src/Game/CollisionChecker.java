package Game;

import java.awt.Rectangle;

/**
 *
 * @author Mike
 */
public class CollisionChecker {
    
    Rectangle t1;
    Rectangle t2Whole;
    Rectangle t2P1;
    Rectangle t2P2;
    Rectangle t2P3;
    Rectangle t2P4;
    boolean splitTile = false;
    
    public boolean checkCollision(Player p, Tile t) {
        
        splitTile = false;
        t1 = new Rectangle(p.getX(), p.getY(), 24, 32);
        if(t.getTileBytes() != null) {
            for(int i = 0; i < t.tileBytes.length; i++) {
                if(t.tileBytes[i] != 0) {
                    splitTile = true;
                }
            }   
        }
        
        //if the byte is 0 then collision does not need to be checked for
        if(t.getCollisionType() != 0 && splitTile == false) {
            
            t2Whole = new Rectangle(t.getX(), t.getY(), 32, 32);

            if(t1.intersects(t2Whole)) {
                return true;
            } else if (t2Whole.intersects(t1)) {
                return true;
            } else {
                return false;
            }
        
        } else if(splitTile) {
            
            t2P1 = new Rectangle(t.getX(), t.getY(),16,16);
            t2P2 = new Rectangle(t.getX() + 16, t.getY(),16,16);
            t2P3 = new Rectangle(t.getX(), t.getY() + 16,16,16);
            t2P4 = new Rectangle(t.getX() + 16, t.getY() + 16,16,16);
            
            if(t.tileBytes[0] == 1) {
                if(t1.intersects(t2P1)) {
                    return true;
                } else if (t2P1.intersects(t1)) {
                    return true;
                } else {
                    return false;
                }
            } else if(t.tileBytes[1] == 1) {
                if(t1.intersects(t2P2)) {
                    return true;
                } else if (t2P2.intersects(t1)) {
                    return true;
                } else {
                    return false;
                }
            } else if(t.tileBytes[2] == 1) {
                if(t1.intersects(t2P3)) {
                    return true;
                } else if (t2P3.intersects(t1)) {
                    return true;
                } else {
                    return false;
                }
            } else if(t.tileBytes[3] == 1) {
                if(t1.intersects(t2P4)) {
                    return true;
                } else if (t2P4.intersects(t1)) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
            
        } else {
            return false;
        }
        
    }
    
    public int dirWhenCollision(Player p) {
        return p.getDirection();
    }
    
}
