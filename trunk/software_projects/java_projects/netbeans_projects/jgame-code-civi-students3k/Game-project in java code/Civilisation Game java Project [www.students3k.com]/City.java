import javax.swing.*;

/**
 * Title:       City.java
 * Description: This class holds city information
 * @author:     Shane Grund
 * @version:    1.0
 */
public class City
{
      private ImageIcon cityIcon;
      private int pos;

      public City(int playerNo)
      {
            if(playerNo == 1)
                  cityIcon = new ImageIcon("images/Cities/player1.png");
            else if(playerNo == 2)
                  cityIcon = new ImageIcon("images/Cities/player2.png");
      }//end constructor

      public ImageIcon getImage()
      {
            return cityIcon;
      }

      public void setLocation(int x)
      {
            pos = x;
      }

      public int getLocation()
      {
            return pos;
      }
}//end class
