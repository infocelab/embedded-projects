/*
 *   *       Please Visit us at www.codemiles.com     *
 *  This Program was Developed by www.codemiles.com forums Team
 *  *           Please Don't Remove This Comment       *
 */
package m_snake.MainPanel.snakeBody;

import javax.swing.JOptionPane;

/**
 *
 * @author SQLStudent
 */

public class snake {
    
    /** Creates a new instance of snake */
    public snake() {
        for(int i=0;i<snake_length;i++) {
            PostionsX[i]=20;
            PostionsY[i]=20;
            
        }
    }
    
    public   void Move_snake() {
        for(int i=0;i<snake_length;i++) {
            PostionsX[snake_length-i]=PostionsX[snake_length-(i+1)];
            PostionsY[snake_length-i]=PostionsY[snake_length-(i+1)];
            
            
        }
        
        PostionsX[0]=headX;
        PostionsY[0]=headY;
        
    }
    
    public    void put_Head_postion(int x,int y) {
        headX+=x;
        headY+=y;
        
    }
    public    boolean check_game_over() {
        for(int i=1;i<snake_length;i++)
            
        {
            if((PostionsX[i]==headX)&&(PostionsY[i]==headY)) {
                
                
                return true;
            }
        }
        if(headX<0||headX>760||headY<0||headY>460) {
           
            return true;
        }
        
        return false;
    }
    
    public boolean compare_with_foodPostion(int x,int y) {
        
        for(int i=0;i<snake_length;i++) {
            if(x==PostionsX[i]&&y==PostionsY[i]) {
                return true;
            }
        }
        
        return false;
    }
    
    public synchronized void Increase_lenght() {
        snake_length++;
    }
    
    public int get_lenght() {
        return snake_length;
    }
    
    public int getOval_Size() {
        return Oval_size;
    }
    
    
    
    public int[] get_All_postionsX() {
        return PostionsX;
    }
    
    public int[] get_All_postionsY() {
        return PostionsY;
    }
    
    public int getHeadX() {
        return  PostionsX[0];
    }
    public int getHeadY() {
        return  PostionsY[0];
    }
    
    private int headX=20;
    private int headY=20;
    private int[] PostionsX=new int[300];
    private int[] PostionsY=new int[300];
    private int snake_length=5;
    private final int Oval_size=20;
    
}/*
 *   *       Please Visit us at www.codemiles.com     *
 *  This Program was Developed by www.codemiles.com forums Team
 *  *           Please Don't Remove This Comment       *
 */
