/*
 *   *       Please Visit us at www.codemiles.com     *
 *  This Program was Developed by www.codemiles.com forums Team
 *  *           Please Don't Remove This Comment       *
 */
package Snake_engin;

import javax.swing.JOptionPane;
import m_snake.MainPanel.snakeBody.Food;
import m_snake.MainPanel.snakeBody.snake;
/**
 *
 * @author SQLStudent
 */
public class engin {
    
    /** Creates a new instance of engin */
    public engin() 
    {
   
    }
 
    public   void Move_mySnake(int newDirection,boolean food_eaten)
    {
       
      
        if(!Game_Over)
        {
        
        switch(newDirection)
        {
            case 1:    if(direction!=3)
                            {
                       my_snake.put_Head_postion(0,-step_to_move);
                       direction=1;
                            }
                    else move_as_last(direction);
                       break;//UP
                       
            case 2:   if(direction!=4)   
                       {
                   my_snake.put_Head_postion(step_to_move,0);
                     direction=2; 
                            }
                        else move_as_last(direction);
                    break;//RIGHT
            case 3:    
                      if(direction!=1)
                      {
                   my_snake.put_Head_postion(0,step_to_move);
                      direction=3;
                      }
                      else move_as_last(direction);
                     break;//DOWN
                                  
            case 4:   
                       if(direction!=2)
                       {
                  my_snake.put_Head_postion(-step_to_move,0);
                        direction=4; 
                       }
                      else move_as_last(direction);
                     
                      break;//LEFT
        } 
      
          
            if(food_eaten)
            {
               my_snake.Increase_lenght();// IF the Snake ate new Food
            }
        my_snake.Move_snake();
        
      
       if((my_snake.getHeadX()==snakeFood.get_int_X())&&(my_snake.getHeadY()== snakeFood.get_int_Y()))
        {
            snakeFood.getFood();
            Score+=20;
            
            my_snake.Increase_lenght();
            while(check_food_place())
            {
               snakeFood.getFood();    
            }
            
        }
        
        Game_Over=my_snake.check_game_over();
        
        
        }
        if(Game_Over)
        {
            JOptionPane.showConfirmDialog(null,"Score = "+Integer.toString(Score),"Your Score",JOptionPane.DEFAULT_OPTION);
        //    Thread.yield();
        }
                 
        
    }
    public void move_as_last(int diirec)
    {
         switch(direction)
        {
            case 1:    
                           
                       my_snake.put_Head_postion(0,-step_to_move);
                   
                           
                       break;//UP
                       
            case 2:    
                   my_snake.put_Head_postion(step_to_move,0);
                    
                    break;//RIGHT
            case 3:    
                       
                   my_snake.put_Head_postion(0,step_to_move);
                        
                     break;//DOWN
                                  
            case 4:   
                     
                  my_snake.put_Head_postion(-step_to_move,0);
                       
                     
                      break;//LEFT
        } 
      
       
    }
    public int[] return_Snake_postionsX()
    {
        return my_snake.get_All_postionsX();
    }
    public int[] return_Snake_postionsY()
    {
        return my_snake.get_All_postionsY();
    }
   
    public int get_Oval_size()
    {
        return my_snake.getOval_Size();
    }
    
    public int get_my_snake_lenght()
    {
        return my_snake.get_lenght();
    }
    public void set_step_length()
    {
        step_to_move=5;
    }
    public int get_Food_X()
    {
        return (int)snakeFood.getX();
    }
    public int get_Food_Y()
    {
        return (int)snakeFood.getY();
    }
    public boolean check_food_place()
    {
       int xfood=(int)snakeFood.getX();
       int yfood=(int)snakeFood.getY();
       if(xfood>260||yfood>260)return true;
       else 
        return my_snake.compare_with_foodPostion(xfood,yfood);
       
    }
    
     public boolean get_Game_over()
    {
        return Game_Over;
    }
     
   private int direction=2;
   private boolean Game_Over;
   private boolean Moving_vertical=false;
   private snake my_snake=new snake();
   private final Food snakeFood=new Food();
   private int step_to_move=20;    
   private int Score;
   
}
/*
 *   *       Please Visit us at www.codemiles.com     *
 *  This Program was Developed by www.codemiles.com forums Team
 *  *           Please Don't Remove This Comment       *
 */