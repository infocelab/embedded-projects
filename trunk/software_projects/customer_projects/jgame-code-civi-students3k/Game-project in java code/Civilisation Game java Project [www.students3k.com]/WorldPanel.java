import javax.swing.*;
import java.awt.*;

/**
 * Title:       WorldPanel.java
 * Description: This class sets displays the game map and handles when
 *              the map needs to change position or zoom, it handles the
 *              drawing of what should be drawn to the screen
 * @author:     Shane Grund
 * @version:    1.0
 */
public class WorldPanel extends JPanel
{
      private int firstX;
      private int firstY;

      private int zoom;
      private int currentPlayer, currentUnit;

      private int mapWidth;
      private int mapHeight;

      private int[][] myMap;

      private ImageIcon[] myIcons;

      protected Nation player1, player2;
      protected int iconsToDrawWidth, iconsToDrawHeight;

      /**
       * The constructor for the world panel. Sets up
       * some instance varibles, and declares the panels
       * attributes
       */
      public WorldPanel()
      {
            this.setBackground(Color.black);

            zoom = 32; // set up the initial zoom

            //set up the images
            myIcons = new ImageIcon[55];
            for(int i = 0; i < myIcons.length; i++)
            {
                  myIcons[i] = new ImageIcon("images/Map Pieces/Map" + i + ".png");
            }

            //set initial values
            firstX = 0;
            firstY = 0;
      }//end constructor

      /**
       * Paints the map depending on the position and map size
       * @param g the graphics object
       */
      public void paint(Graphics g)
      {
            //set initial drawingPositions to 0 will be incremented in the loop
            int drawPosX = 0;
            int drawPosY = 0;

            int arrayPos = 0;

            //get screen res info
            int width = this.getWidth();
            int height = this.getHeight();

            int leftOverWidth = this.getWidth() % zoom;
            int leftOverHeight = this.getHeight() % zoom;

            iconsToDrawWidth = (width - leftOverWidth) / zoom;
            iconsToDrawHeight = (height - leftOverHeight) / zoom;

            int tempX = firstX;
            int tempY = firstY;
            for(int i = 0; i < iconsToDrawHeight; i++)
            {
                  if(tempY == mapHeight)
                        tempY = tempY - mapHeight;
                  tempX = firstX;
                  drawPosX = 0;
                  for(int b = 0; b < iconsToDrawWidth; b++)
                  {
                        if(tempX == mapWidth)
                              tempX = tempX - mapWidth;
                        arrayPos = tempY * mapWidth + tempX;
                        int mapPieceToDraw = myMap[0][arrayPos];
                        Image tempIcon = myIcons[mapPieceToDraw].getImage();

                        //see if player 1 cities fall on the array position to draw
                        for(int c = 0; c < player1.getCities().length; c++)
                        {
                              if(player1.cities[c] != null)
                              {
                                    if (arrayPos == player1.cities[c].getLocation())
                                    {
                                          tempIcon = player1.cities[c].getImage().getImage();
                                    }
                              }
                        }//end for

                        //see if player 1 units fall on the array position to draw
                        for(int c = 0; c < player1.getUnits().length; c++)
                        {
                              if(player1.units[c] != null)
                              {
                                    if (arrayPos == player1.units[c].getPosition())
                                    {
                                          tempIcon = player1.units[c].getImage().getImage();
                                    }
                              }
                        }//end for

                        //see if player 2 cities fall on the array position to draw
                        for(int c = 0; c < player2.getCities().length; c++)
                        {
                              if(player2.cities[c] != null)
                              {
                                    if(arrayPos == player2.cities[c].getLocation())
                                    {
                                          tempIcon = player2.cities[c].getImage().getImage();
                                    }
                              }
                        }//end for

                        //see if player 2 cities fall on the array position to draw
                        for(int c = 0; c < player2.getUnits().length; c++)
                        {
                              if(player2.units[c] != null)
                              {
                                    if(arrayPos == player2.units[c].getPosition())
                                    {
                                          tempIcon = player2.units[c].getImage().getImage();
                                    }
                              }
                        }//end for

                        g.drawImage(tempIcon, drawPosX, drawPosY, null);
                        tempX++;
                        drawPosX = drawPosX + zoom;
                  }//end for
                  drawPosY = drawPosY + zoom;
                  tempY++;
            }//end for
				
				//highlight current moving unit
				g.setColor(Color.red);
				g.drawRect(352,223,32,32);
      }//end paint

      /**
       * Paints the map in The x = 0 y = 0 position
       * It will also load in the image files;
       * @param map the double array of map pieces
       */
      public void setInitialMap(int[][] map, int mapW, int mapH)
      {
            //set map dynamics
            mapWidth = mapW;
            mapHeight = mapH;
            myMap = map;

            //set up initial player cities
            player1 = new Nation(1);
            player1.addUnit(1);//settler unit
            player1.addUnit(2);//warrior unit
            player1.setNumUnits(2);
            player2 = new Nation(2);
            player2.addUnit(1);//settler unit
            player2.addUnit(2);//warrior unit
            player2.setNumUnits(2);
            currentPlayer = 1;
            currentUnit = 1;

            int totalPieces = mapWidth * mapHeight;
            boolean b = false;
            while(b == false)
            {
                  int temp = (int)Math.round(Math.random() * totalPieces);
                  if(myMap[0][temp] == 1)
                  {
                        City[] city = player1.getCities();
                        city[0].setLocation(temp);
                        b = true;
                  }
                  Unit[] unit = player1.getUnits();
                  unit[0].setPosition(temp - 1);
                  unit[1].setPosition(temp + 1);
            }//end while

            b = false;
            while(b == false)
            {
                  int temp = (int)Math.round(Math.random() * totalPieces);
                  if(myMap[0][temp] == 1)
                  {
                        City[] city = player2.getCities();
                        city[0].setLocation(temp);
                        b = true;
                  }//end if
                  Unit[] unit = player2.getUnits();
                  unit[0].setPosition(temp - 1);
                  unit[1].setPosition(temp + 1);
            }//end while

            //set up the initial starting point on the map
            int unitPos = player1.units[0].getPosition();
            int tempX = unitPos % mapWidth;
            int tempY = unitPos - tempX;
            if(tempY == 0){}
            else
                  tempY = tempY / mapHeight;
            tempX = tempX - 11;
            tempY = tempY - 7;
            if(tempX >=0)
                  firstX = tempX;
            else
                  firstX = tempX + mapWidth;
            if(tempY >=0)
                  firstY = tempY;
            else
                  firstY = tempY + mapWidth;

            //paint the initial starting point with player cities and units
            repaint();
      }//end setInitialMap

      public int getFirstX()
      {
            return firstX;
      }//end getFirstY

      public int getFirstY()
      {
            return firstY;
      }//end getFirstX

      /**
       * Set a new map position. It gets passed in new positions
       * depending on what button has been pressed. It basically
       * tells the map to move 32 pixels in a particular direction.
       * @param x - the new x location
       * @param y - the new y pos
       */
      public void newMapPos(int x, int y)
      {
            if(x != 0)
            {
                  firstX = firstX + (x / zoom);
                  if(firstX == -1)
                        firstX = firstX + mapWidth;
                  if(firstX == mapWidth)
                        firstX = firstX - mapWidth;
            }//end if
            if(y != 0)
            {
                  firstY = firstY + (y / zoom);
                  if(firstY == -1)
                        firstY = firstY + mapHeight;
                  if(firstY == mapHeight)
                        firstY = firstY - mapHeight;
            }//end if
            repaint();
      }//end newMapPos

      public int getCurrentPlayer()
      {
            return currentPlayer;
      }//end getCurrentPlayer

      public void setCurrentPlayer(int i)
      {
            currentPlayer = i;
      }//end setCurrentPlayer

      public int getCurrentUnit()
      {
            return currentUnit;
      }//end getCurrentUnit

      public void setCurrentUnit(int i)
      {
            currentUnit = i;
      }//end setCurrentUnit

      public int getNumUnits(int i)
      {
            if(i == 1)
                  return player1.getNumUnits();
            else
                  return player2.getNumUnits();
      }//end getNumUnits

      public void setNewXYPos(int x, int y)
      {
            firstX = x;
            firstY = y;
            repaint();
      }//end setNewXYPos

      public int getDrawWidth()
      {
            return iconsToDrawWidth;
      }//end getDrawWidth

      public int getDrawHeight()
      {
            return iconsToDrawHeight;
      }//end getDrawHeight
}//end class
