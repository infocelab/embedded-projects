import javax.swing.*;
import java.awt.*;

/**
 * Title:       MiniMap.java
 * Description: This class displays a miniture version of the map so the
 *              user can see whats going on without having to scroll the
 *              large map
 * @author:     Shane Grund
 * @version:    1.0
 */
public class MiniMap extends JPanel
{
      private int[][] myMap;
      private int mapWidth;
      private int mapHeight;
      private int startX, startY;
      private int iconsToDrawWidth, iconsToDrawHeight;

      private ImageIcon[] myIcons;

      /**
       * The constructot sets up the images to be drawn
       */
      public MiniMap()
      {
            this.setPreferredSize(new Dimension(120,120));

            //set up the images
            myIcons = new ImageIcon[55];
            for(int i = 0; i < myIcons.length; i++)
            {
                  myIcons[i] = new ImageIcon("images/Map Pieces/Map" + i + ".png");
            }
      }//end constructor

      /**
       * This method paints the mini map to the panel
       * @param g Graphics
       */
      public void paint(Graphics g)
      {
            if(myMap == null){}
            else
            {
                  int tempX = 0;
                  int tempY = 20;
                  int drawY = 0;
                  for(int i = 0; i < mapHeight; i++)
                  {
                        tempX = 0;
                        for(int b = 0; b < mapWidth; b++)
                        {
                              int arrayPos = drawY + tempX;
                              int mapPieceToDraw = myMap[0][arrayPos];
                              Image tempIcon = myIcons[mapPieceToDraw].getImage();
                              g.drawImage(tempIcon, tempX + 20, tempY, 1, 1, null);
                              tempX++;
                        }//end for
                        tempY++;
                        drawY +=mapHeight;
                  }//end for

                  g.drawRect(startX + 20,startY + 20,iconsToDrawWidth,iconsToDrawHeight);
            }//end else
      }//end paint

      /**
       * This method gets called once the original map is created
       * and can just clone the exact version of the normal map
       * @param map int[][]
       * @param mapW int
       * @param mapH int
       * @param width int
       * @param height int
       */
      public void setMap(int map[][], int mapW, int mapH, int width, int height)
      {
            myMap = map;
            mapWidth = mapW;
            mapHeight = mapH;
            iconsToDrawWidth = 21;
            iconsToDrawHeight = 15;
            repaint();
      }

      /**
       * This method sets players x y coordinates and represents the visible
       * portion in the mini map
       * @param x int
       * @param y int
       * @param width int
       * @param height int
       */
      public void setNewXY(int x, int y, int width, int height)
      {
            startX = x;
            startY = y;
            iconsToDrawWidth = width;
            iconsToDrawHeight = height;
            repaint();
      }//end set new XY

      /**
       * This set a new map position once a player has moved
       * @param x int
       * @param y int
       */
      public void newMapPos(int x, int y)
      {
            startX +=x;
            if(startX == -1)
                  startX = startX + mapWidth;
            if(startX == mapWidth)
                  startX = startX - mapWidth;
            startY +=y;
            if(startY == -1)
                  startY = startY + mapHeight;
            if(startY == mapHeight)
                  startY = startY - mapHeight;
            repaint();
      }
}//end class
