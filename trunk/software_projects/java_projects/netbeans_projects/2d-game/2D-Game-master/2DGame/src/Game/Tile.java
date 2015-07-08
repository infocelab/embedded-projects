package Game;

import java.awt.Image;

public class Tile {
    
    Image tile;
    //for predictive tile laying in editor
    byte b1;
    byte b2;
    byte b3;
    byte b4;
    //for collision detection
    byte b5;
    //for returning all values at once
    byte[] tileBytes;
    //for collision detection
    int x = 0;
    int y = 0;
    int tileNumber;
    
    public Tile(Image img, int num, byte b1, byte b2, byte b3, byte b4, byte b5) {
        
        tile = img;
        tileNumber = num;
        this.b1 = b1;
        this.b2 = b2;
        this.b3 = b3;
        this.b4 = b4;
        //this.b5 = b5;
        this.b5 = 1;  // always collision
        
        tileBytes = new byte[] {b1,b2,b3,b4};
               
    }
    
    public Tile(Tile t) {
        
        tile = t.getTile();
        tileNumber = t.getTileNumber();
        b1 = t.getTileByte(0);
        b2 = t.getTileByte(1);
        b3 = t.getTileByte(2);
        b4 = t.getTileByte(3);
        b5 = t.getCollisionType();
        tileBytes = t.getTileBytes();
        
    }
    
    public byte[] getTileBytes() {
        
        return tileBytes;
        
    }
    
    public byte getTileByte(int index) {
        
        if(index < tileBytes.length || index >= 0) {
            return tileBytes[index];
        } else {
            System.out.println("ERROR: Not a valid index.");
            return 0;
        }
        
    }
    
    public byte getCollisionType() {
        
        return b5;
        
    }
    
    public void setCollisionType(byte ct) {
        
        b5=ct;
        
    }
    public Image getTile() {
        
        return tile;
        
    }
    
    public void setTile(Image img) {
        
        tile = img;
        
    }
    
    public void setX(int x) {
        
        this.x = x;
        
    }
    
    public void setY(int y) {
        
        this.y = y;
        
    }
    
    public int getX() {
        
        return x;
        
    }
    
    public int getY() {
        
        return y;
        
    }
    
    public int getTileNumber() {
        
        return tileNumber;
        
    }
    
    public String toString() {
        return "Tile Numnber: " + tileNumber + " b5: " + b5 + " Collision Bytes: " + b1 + ", " + b2 + ", " + b3 + ", " + b4 + " X: " + getX() + " Y: " + getY();
    }
    
}
