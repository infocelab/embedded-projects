import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Title:       MapPanel.java
 * Description: This class displays the map and the units, and allows the
 *              users to scroll it, and move units.
 * @author:     Shane Grund
 * @version:    1.0
 */
public class MapPanel extends JPanel implements ActionListener, KeyListener
{
      private int mapPieces[][];
      private int mapWidth, mapHeight, zoom, year;
      private int keyUp, keyDown, keyLeft, keyRight, keyZoom;

      private WorldPanel worldPanel;
      private MiniMap miniMap;
      private UnitInfoPanel unitPanel;
      private JPanel southPanel, eastPanel1;
      private GWMap myMap;

      private ImageIcon iconDefault;
      private Cursor cursor;

      private JButton upButton, downButton, leftButton, rightButton;

      /**
       * Constructor for mapPanel. It grabs a map and then
       * passes it to the worldPanel. it sets up actions for
       * button presses
       */
      public MapPanel(int size, int style)
      {
            this.setLayout(new BorderLayout());
            zoom = 32;//set initail zoom to 32;
				year = -4000;

            //set up initial key movements
            keyUp = KeyEvent.VK_W;
            keyLeft = KeyEvent.VK_A;
            keyRight = KeyEvent.VK_D;
            keyDown = KeyEvent.VK_S;
            keyZoom = KeyEvent.VK_Z;

            if(size == 100 && style == 2)
            {
                  //create the map
                  myMap = GWMap.getGWMap();
                  if (myMap == null)
                  {
                        GWMap.create(size, size, 100, 3, (float) 50.0, (float) 33.0, 2, 4);
                        myMap = GWMap.getGWMap();
                  }
                  else
                        myMap.reCreate(size, size, 100, 3, (float) 50.0, (float) 33.0, 2, 4);
                  generate();
            }

            else if(size == 75 && style == 2)
            {
                  //create the map
                  myMap = GWMap.getGWMap();
                  if (myMap == null)
                  {
                        GWMap.create(size, size, 75, 3, (float) 50.0, (float) 33.0, 2, 4);
                        myMap = GWMap.getGWMap();
                  }
                  else
                        myMap.reCreate(size, size, 75, 3, (float) 50.0, (float) 33.0, 2, 4);
                  generate();
            }

            else if(size == 50 && style == 2)
            {
                  //create the map
                  myMap = GWMap.getGWMap();
                  if (myMap == null)
                  {
                        GWMap.create(size, size, 50, 2, (float) 50.0, (float) 33.0, 2, 4);
                        myMap = GWMap.getGWMap();
                  }
                  else
                        myMap.reCreate(size, size, 50, 2, (float) 50.0, (float) 33.0, 2, 4);
                  generate();
            }

            if(size == 100 && style == 1)
            {
                  //create the map
                  myMap = GWMap.getGWMap();
                  if (myMap == null)
                  {
                        GWMap.create(size, size, 10, 1, (float) 50.0, (float) 33.0, 2, 4);
                        myMap = GWMap.getGWMap();
                  }
                  else
                        myMap.reCreate(size, size, 10, 1, (float) 50.0, (float) 33.0, 2, 4);
                  generate();
            }

            else if(size == 75 && style == 1)
            {
                  //create the map
                  myMap = GWMap.getGWMap();
                  if (myMap == null)
                  {
                        GWMap.create(size, size, 10, 1, (float) 50.0, (float) 33.0, 2, 4);
                        myMap = GWMap.getGWMap();
                  }
                  else
                        myMap.reCreate(size, size, 10, 1, (float) 50.0, (float) 33.0, 2, 4);
                  generate();
            }

            else if(size == 50 && style == 1)
            {
                  //create the map
                  myMap = GWMap.getGWMap();
                  if (myMap == null)
                  {
                        GWMap.create(size, size, 7, 1, (float) 50.0, (float) 33.0, 2, 4);
                        myMap = GWMap.getGWMap();
                  }
                  else
                        myMap.reCreate(size, size, 7, 1, (float) 50.0, (float) 33.0, 2, 4);
                  generate();
            }

            if(size == 100 && style == 3)
            {
                  //create the map
                  myMap = GWMap.getGWMap();
                  if (myMap == null)
                  {
                        GWMap.create(size, size, 120, 1, (float) 50.0, (float) 33.0, 2, 4);
                        myMap = GWMap.getGWMap();
                  }
                  else
                        myMap.reCreate(size, size, 120, 1, (float) 50.0, (float) 33.0, 2, 4);
                  generate();
            }

            else if(size == 75 && style == 3)
            {
                  //create the map
                  myMap = GWMap.getGWMap();
                  if (myMap == null)
                  {
                        GWMap.create(size, size, 100, 1, (float) 50.0, (float) 33.0, 2, 4);
                        myMap = GWMap.getGWMap();
                  }
                  else
                        myMap.reCreate(size, size, 100, 1, (float) 50.0, (float) 33.0, 2, 4);
                  generate();
            }

            else if(size == 50 && style == 3)
            {
                  //create the map
                  myMap = GWMap.getGWMap();
                  if (myMap == null)
                  {
                        GWMap.create(size, size, 75, 0, (float) 50.0, (float) 33.0, 2, 4);
                        myMap = GWMap.getGWMap();
                  }
                  else
                        myMap.reCreate(size, size, 75, 0, (float) 50.0, (float) 33.0, 2, 4);
                  generate();
            }

            //set up the cursor
            cursor = Cursor.getPredefinedCursor(Cursor.HAND_CURSOR);

            //set up the buttons
            leftButton = new JButton();
            leftButton.setFocusable(false);
            leftButton.setBorder(null);
            leftButton.setContentAreaFilled(false);
            leftButton.setCursor(cursor);
            iconDefault = new ImageIcon("images/left.gif");
            leftButton.setIcon(iconDefault);

            rightButton = new JButton();
            rightButton.setFocusable(false);
            rightButton.setBorder(null);
            rightButton.setContentAreaFilled(false);
            rightButton.setCursor(cursor);
            iconDefault = new ImageIcon("images/right.gif");
            rightButton.setIcon(iconDefault);

            upButton = new JButton();
            upButton.setFocusable(false);
            upButton.setBorder(null);
            upButton.setContentAreaFilled(false);
            upButton.setCursor(cursor);
            iconDefault = new ImageIcon("images/up.gif");
            upButton.setIcon(iconDefault);

            downButton = new JButton();
            downButton.setFocusable(false);
            downButton.setBorder(null);
            downButton.setContentAreaFilled(false);
            downButton.setCursor(cursor);
            iconDefault = new ImageIcon("images/down.gif");
            downButton.setIcon(iconDefault);

            leftButton.addActionListener(this);
            rightButton.addActionListener(this);
            upButton.addActionListener(this);
            downButton.addActionListener(this);

            //set up the panels
            worldPanel = new WorldPanel();
            this.add(worldPanel, BorderLayout.CENTER);

            southPanel = new JPanel(new FlowLayout());
            southPanel.setBackground(Color.black);
            southPanel.add(leftButton);
				southPanel.add(upButton);
            southPanel.add(downButton);
            southPanel.add(rightButton);
            this.add(southPanel, BorderLayout.SOUTH);

            miniMap = new MiniMap();
            unitPanel = new UnitInfoPanel();

            eastPanel1 = new JPanel(new BorderLayout());
            eastPanel1.setBackground(Color.black);
            eastPanel1.add(miniMap ,BorderLayout.SOUTH);
            eastPanel1.add(unitPanel, BorderLayout.CENTER);
            this.add(eastPanel1, BorderLayout.EAST);

            //create initial map
            worldPanel.setInitialMap(mapPieces, mapWidth, mapHeight);
            miniMap.setMap(mapPieces, mapWidth, mapHeight, 12, 12);
            int x = worldPanel.getFirstX();
            int y = worldPanel.getFirstY();
            miniMap.setNewXY(x,y,21,15);
            addKeyListener(this);
            this.setBackground(Color.black);
            this.requestFocus();
      }//end constructor

      /**
       * Performs all actions when buttons get pressed
       * @param e ActionEvent
       */
      public void actionPerformed(ActionEvent e)
      {
            if(e.getSource() == upButton)
            {
                  upPressed();
            }//end if
            if(e.getSource() == downButton)
            {
                  downPressed();
            }//end if
            if(e.getSource() == leftButton)
            {
                  leftPressed();
            }//end if
            if(e.getSource() == rightButton)
            {
                  rightPressed();
            }//end if
      }//end action performed

      /**
       * This moves the map up
       */
      public void upPressed()
      {
            worldPanel.newMapPos(0,-zoom);
            miniMap.newMapPos(0,-1);
      }//end upPressed

      /**
       * This moves the map down
       */
      public void downPressed()
      {
            worldPanel.newMapPos(0,zoom);
            miniMap.newMapPos(0,1);
      }

      /**
       * This moves the map left
       */
      public void leftPressed()
      {
            worldPanel.newMapPos(-zoom,0);
            miniMap.newMapPos(-1,0);
      }

      /**
       * This moves the map right
       */
      public void rightPressed()
      {
            worldPanel.newMapPos(zoom,0);
            miniMap.newMapPos(1,0);
      }

      /**
       * This handles all the key presses
       * @param e KeyEvent
       */
      public void keyPressed(KeyEvent e)
      {
				int currentPlayer = worldPanel.getCurrentPlayer();
            int currentUnit = worldPanel.getCurrentUnit();
				int type = 0;
				if(currentPlayer == 1)
						type = worldPanel.player1.units[currentUnit - 1].getUnitType();
				else
						type = worldPanel.player2.units[currentUnit - 1].getUnitType();
            if(e.getKeyCode() == keyUp)
                  upPressed();
            else if(e.getKeyCode() == keyDown)
                  downPressed();
            else if(e.getKeyCode() == keyLeft)
                  leftPressed();
            else if(e.getKeyCode() == keyRight)
                  rightPressed();
            else if(e.getKeyCode() == KeyEvent.VK_UP)
				{
						if(type == 7)
								moveShipUp();
						else
                  		moveUnitUp();
				}
            else if(e.getKeyCode() == KeyEvent.VK_DOWN)
				{
						if(type == 7)
								moveShipDown();
						else
                  		moveUnitDown();
				}
            else if(e.getKeyCode() == KeyEvent.VK_LEFT)
				{
						if(type == 7)
								moveShipLeft();
						else
                  		moveUnitLeft();
				}
            else if(e.getKeyCode() == KeyEvent.VK_RIGHT)
				{
						if(type == 7)
								moveShipRight();
						else
                  		moveUnitRight();
				}
            else if(e.getKeyCode() == KeyEvent.VK_C)
                  createNewCity();
            else if(e.getKeyCode() == KeyEvent.VK_B)
                  createNewUnit();
            else if(e.getKeyCode() == KeyEvent.VK_SPACE)
                  spacePressed();
      }//end key pressed

      public void keyReleased(KeyEvent e){}
      public void keyTyped(KeyEvent e){}

      /**
       * This moves unit down
       */
      private void moveUnitDown()
      {
            boolean moved = true;
            int currentPlayer = worldPanel.getCurrentPlayer();
            int currentUnit = worldPanel.getCurrentUnit();

            //if firstPlayer move unit down
            if(currentPlayer == 1)
            {
                  int currentPos = worldPanel.player1.units[currentUnit - 1].getPosition();
                  int temp1 = mapWidth * mapHeight - mapWidth;
                  int temp2 = mapWidth * mapHeight;
                  if(currentPos >= temp1 && currentPos < temp2)
                  {
                        int newPos = currentPos % mapHeight;
                        int mapTemp = mapPieces[0][newPos];
                        if(mapTemp == 0 || mapTemp == 14)//if unit tries to move into sea
                              moved = false;
                        else
                              worldPanel.player1.units[currentUnit - 1].setPosition(newPos);
                  }//end if
                  else
                  {
                        int mapTemp = mapPieces[0][currentPos + mapWidth];
                        if(mapTemp == 0 || mapTemp == 14)//if unit tries to move into sea
                              moved = false;
                        else
                              worldPanel.player1.units[currentUnit - 1].setPosition(currentPos + mapWidth);
                  }//end else
            }//end if

            //if secondPlayer move unit down
            if(currentPlayer == 2)
            {
                  int currentPos = worldPanel.player2.units[currentUnit - 1].getPosition();
                  int temp1 = mapWidth * mapHeight - mapWidth;
                  int temp2 = mapWidth * mapHeight;
                  if(currentPos >= temp1 && currentPos < temp2)
                  {
                        int newPos = currentPos % mapHeight;
                        int mapTemp = mapPieces[0][newPos];
                        if(mapTemp == 0 || mapTemp == 14)//if unit tries to move into sea
                              moved = false;
                        else
                              worldPanel.player2.units[currentUnit - 1].setPosition(newPos);
                  }
                  else
                  {
                        int mapTemp = mapPieces[0][currentPos + mapWidth];
                        if(mapTemp == 0 || mapTemp == 14)//if unit tries to move into sea
                              moved = false;
                        else
                              worldPanel.player2.units[currentUnit - 1].setPosition(currentPos + mapWidth);
                  }//end if
            }//end if

            //set up new player once unit has moved
            playerMoved(currentPlayer,currentUnit,moved);

            //set up new mapPosition if player moved
            if(moved == true)
                  setMapPos();
      }//end moveUnitDown

      /**
       * This moves unit left
       */
      private void moveUnitLeft()
      {
            boolean moved = true;
            int currentPlayer = worldPanel.getCurrentPlayer();
            int currentUnit = worldPanel.getCurrentUnit();

            //if firstPlayer move unit left
            if(currentPlayer == 1)
            {
                  int currentPos = worldPanel.player1.units[currentUnit - 1].getPosition();
                  if(currentPos == 0)
                  {
                        int mapTemp = mapPieces[0][mapWidth - 1];
                        if(mapTemp == 0 || mapTemp == 14)//if unit tries to move into sea
                              moved = false;
                        else
                              worldPanel.player1.units[currentUnit - 1].setPosition(mapWidth - 1);
                  }
                  else
                  {
                        int temp1 = currentPos % mapWidth;
                        if(temp1 == 0)
                        {
                              int mapTemp = mapPieces[0][currentPos + mapWidth - 1];
                              if(mapTemp == 0 || mapTemp == 14)//if unit tries to move into sea
                                    moved = false;
                              else
                                    worldPanel.player1.units[currentUnit - 1].setPosition(currentPos + mapWidth - 1);
                        }//end if
                        else
                        {
                              int mapTemp = mapPieces[0][currentPos - 1];
                              if(mapTemp == 0 || mapTemp == 14)//if unit tries to move into sea
                                    moved = false;
                              else
                                    worldPanel.player1.units[currentUnit - 1].setPosition(currentPos - 1);
                        }//end else
                  }//end else
            }//end if

            //if firstPlayer move unit left
            if(currentPlayer == 2)
            {
                  int currentPos = worldPanel.player2.units[currentUnit - 1].getPosition();
                  if(currentPos == 0)
                  {
                        int mapTemp = mapPieces[0][mapWidth - 1];
                        if(mapTemp == 0 || mapTemp == 14)//if unit tries to move into sea
                              moved = false;
                        else
                              worldPanel.player2.units[currentUnit - 1].setPosition(mapWidth - 1);
                  }
                  else
                  {
                        int temp1 = currentPos % mapWidth;
                        if(temp1 == 0)
                        {
                              int mapTemp = mapPieces[0][currentPos + mapWidth - 1];
                              if(mapTemp == 0 || mapTemp == 14)//if unit tries to move into sea
                                    moved = false;
                              else
                                    worldPanel.player2.units[currentUnit - 1].setPosition(currentPos + mapWidth - 1);
                        }//end if
                        else
                        {
                              int mapTemp = mapPieces[0][currentPos - 1];
                              if(mapTemp == 0 || mapTemp == 14)//if unit tries to move into sea
                                    moved = false;
                              else
                                    worldPanel.player2.units[currentUnit - 1].setPosition(currentPos - 1);
                        }//end else
                  }//end else
            }//end if

            //set up new player once unit has moved
            playerMoved(currentPlayer,currentUnit,moved);

            //set up new mapPosition if player moved
            if(moved == true)
                  setMapPos();
      }//end moveUnitLeft

      /**
       * This moves unit right
       */
      private void moveUnitRight()
      {
            boolean moved = true;
            int currentPlayer = worldPanel.getCurrentPlayer();
            int currentUnit = worldPanel.getCurrentUnit();

            //if firstPlayer move unit right
            if(currentPlayer == 1)
            {
                  int currentPos = worldPanel.player1.units[currentUnit - 1].getPosition();
                  int temp1 = (currentPos + 1) % mapWidth;
                  if(temp1 == 0)
                  {
                        int mapTemp = mapPieces[0][currentPos - mapWidth + 1];
                        if(mapTemp == 0 || mapTemp == 14)//if unit tries to move into sea
                              moved = false;
                        else
                              worldPanel.player1.units[currentUnit - 1].setPosition(currentPos - mapWidth + 1);
                  }
                  else
                  {
                        int mapTemp = mapPieces[0][currentPos + 1];
                        if(mapTemp == 0 || mapTemp == 14)//if unit tries to move into sea
                              moved = false;
                        else
                              worldPanel.player1.units[currentUnit - 1].setPosition(currentPos + 1);
                  }
            }//end if

            //if secondPlayer move unit right
            if(currentPlayer == 2)
            {
                  int currentPos = worldPanel.player2.units[currentUnit - 1].getPosition();
                  int temp1 = (currentPos + 1) % mapWidth;
                  if(temp1 == 0)
                  {
                        int mapTemp = mapPieces[0][currentPos - mapWidth + 1];
                        if(mapTemp == 0 || mapTemp == 14)//if unit tries to move into sea
                              moved = false;
                        else
                              worldPanel.player2.units[currentUnit - 1].setPosition(currentPos - mapWidth + 1);
                  }//end if
                  else
                  {
                        int mapTemp = mapPieces[0][currentPos + 1];
                        if(mapTemp == 0 || mapTemp == 14)//if unit tries to move into sea
                              moved = false;
                        else
                              worldPanel.player2.units[currentUnit - 1].setPosition(currentPos + 1);
                  }//end else
            }//end if

            //set up new player once unit has moved
            playerMoved(currentPlayer,currentUnit,moved);

            //set up new mapPosition if player moved
            if(moved == true)
                  setMapPos();
      }//end move Unit Right

      /**
       * This moves unit up
       */
      private void moveUnitUp()
      {
            boolean moved = true;
            int currentPlayer = worldPanel.getCurrentPlayer();
            int currentUnit = worldPanel.getCurrentUnit();

            //if firstPlayer move unit up
            if(currentPlayer == 1)
            {
                  int currentPos = worldPanel.player1.units[currentUnit - 1].getPosition();
                  if(currentPos >= 0 && currentPos < mapWidth)
                  {
                        int newPos = mapHeight -1;
                        int newPos2 = mapHeight * newPos + currentPos;
                        int mapTemp = mapPieces[0][newPos2];
                        if(mapTemp == 0 || mapTemp == 14)//if they try to move on water
                              moved = false;
                        else
                              worldPanel.player1.units[currentUnit - 1].setPosition(newPos2);
                  }
                  else
                  {
                        int mapTemp = mapPieces[0][currentPos - mapWidth];
                        if(mapTemp == 0 || mapTemp == 14)//if they try to move on water
                              moved = false;
                        else
                              worldPanel.player1.units[currentUnit - 1].setPosition(currentPos - mapWidth);
                  }
            }//end if

            //if secondPlayer move unit up
            if(currentPlayer == 2)
            {
                  int currentPos = worldPanel.player2.units[currentUnit - 1].getPosition();
                  if(currentPos >= 0 && currentPos < mapWidth)
                  {
                        int newPos = mapHeight -1;
                        int newPos2 = mapHeight * newPos + currentPos;
                        int mapTemp = mapPieces[0][newPos2];
                        if(mapTemp == 0 || mapTemp == 14)//if they try to move on water
                              moved = false;
                        else
                              worldPanel.player2.units[currentUnit - 1].setPosition(newPos2);
                  }
                  else
                  {
                        int mapTemp = mapPieces[0][currentPos - mapWidth];
                        if(mapTemp == 0 || mapTemp == 14)//if they try to move on water
                              moved = false;
                        else
                              worldPanel.player2.units[currentUnit - 1].setPosition(currentPos - mapWidth);
                  }//end else
            }//end if

            //set up new player once unit has moved
            playerMoved(currentPlayer,currentUnit,moved);

            //set up new mapPosition if player moved
            if(moved == true)
                  setMapPos();
      }//end move unit up

      /**
       * This changes the map position after a player has
       * moved so that the map will be focusing on the
       * next player
       */
      private void setMapPos()
      {
            try
            {
                  Thread.sleep(1000);//so that you can see players move
            }
            catch(Exception e){}
            int currentPlayer = worldPanel.getCurrentPlayer();
            int currentUnit = worldPanel.getCurrentUnit();
            int unitPos = 0;
            int firstX = 0;
            int firstY = 0;
            if (currentPlayer == 1)
            {
                  unitPos = worldPanel.player1.units[currentUnit - 1].getPosition();
            }
            if (currentPlayer == 2)
            {
                  unitPos = worldPanel.player2.units[currentUnit - 1].getPosition();
            }
            int tempX = unitPos % mapWidth;
            int tempY = unitPos - tempX;
            if (tempY == 0) {}
            else
                  tempY = tempY / mapHeight;
            tempX = tempX - 11;
            tempY = tempY - 7;
            if (tempX >= 0)
                  firstX = tempX;
            else
                  firstX = tempX + mapWidth;
            if (tempY >= 0)
                  firstY = tempY;
            else
                  firstY = tempY + mapWidth;

            int drawWidth = worldPanel.getDrawWidth();
            int drawHeight = worldPanel.getDrawHeight();
            worldPanel.setNewXYPos(firstX, firstY);
            miniMap.setNewXY(firstX, firstY, drawWidth, drawHeight);
      }//end set mapPos

      /**
       * This creates a new city and displays it on the map
       */
      private void createNewCity()
      {
            int currentPlayer = worldPanel.getCurrentPlayer();
            int currentUnit = worldPanel.getCurrentUnit();
            boolean canBuild = false;

            if(currentPlayer == 1)
            {
                  int unitType = worldPanel.player1.units[currentUnit - 1].getUnitType();
                  if(unitType == 1)//if unit is a settler
                        canBuild = true;
            }

            else if(currentPlayer == 2)
            {
                  int unitType = worldPanel.player1.units[currentUnit - 1].getUnitType();
                  if(unitType == 1)//if unit is a settler
                        canBuild = true;
            }

            //if the unit who presses build is a settler
            if(canBuild == true)
            {
                  if(currentPlayer == 1)
                  {
                        int playerLoc = worldPanel.player1.units[currentUnit - 1].getPosition();
                        worldPanel.player1.addCity(playerLoc);
                        currentUnit++;
                        worldPanel.setCurrentUnit(currentUnit);
                  }//end if
                  else if(currentPlayer == 2)
                  {
                        int playerLoc = worldPanel.player2.units[currentUnit - 1].getPosition();
                        worldPanel.player2.addCity(playerLoc);
                        currentUnit++;
                        worldPanel.setCurrentUnit(currentUnit);
                  }//end elseif
            }//end if

            //set new player and unit if necessary
            int temp = worldPanel.getNumUnits(currentPlayer);
            if(currentUnit > temp)
            {
                  if(currentPlayer == 1)
                        worldPanel.setCurrentPlayer(2);
                  else
                        worldPanel.setCurrentPlayer(1);
                  worldPanel.setCurrentUnit(1);
            }//end if

            //set up new mapPosition if player moved
            if(canBuild == true)
                  setMapPos();
            setInfoPanel();
      }//end createNewCity

      /**
       * This creates a new unit and displays it on screen
       */
      private void createNewUnit()
      {
            int currentPlayer = worldPanel.getCurrentPlayer();
            int currentUnit = worldPanel.getCurrentUnit();
            int randomNumber = (int)Math.ceil(Math.random() * 8);
            boolean canBuild = false;

            if(currentPlayer == 1)
            {
                  int unitType = worldPanel.player1.units[currentUnit - 1].getUnitType();
                  if(unitType == 1)//if unit is a settler
                        canBuild = true;
            }

            else if(currentPlayer == 2)
            {
                  int unitType = worldPanel.player2.units[currentUnit - 1].getUnitType();
                  if(unitType == 1)//if unit is a settler
                        canBuild = true;
            }

            //if the unit who presses build is a settler
            if(canBuild == true)
            {
                  if(currentPlayer == 1)
                  {
                        int playerLoc = worldPanel.player1.units[currentUnit - 1].getPosition();
                        worldPanel.player1.addUnit2(randomNumber);
                        int noUnits = worldPanel.player1.getNumUnits();
								if(randomNumber == 7)//if unit is a ship
									worldPanel.player1.units[noUnits].setPosition(getSeaLoc(playerLoc));
								else
                        	worldPanel.player1.units[noUnits].setPosition(playerLoc);
                        worldPanel.player1.setNumUnits(noUnits + 1);
                        currentUnit++;
                        worldPanel.setCurrentUnit(currentUnit);
                  }//end if
                  else if(currentPlayer == 2)
                  {
                        int playerLoc = worldPanel.player2.units[currentUnit - 1].getPosition();
                        worldPanel.player2.addUnit2(randomNumber);
                        int noUnits = worldPanel.player2.getNumUnits();
								if(randomNumber == 7)//if unit is a ship
									worldPanel.player2.units[noUnits].setPosition(getSeaLoc(playerLoc));
								else
                        	worldPanel.player2.units[noUnits].setPosition(playerLoc);
                        worldPanel.player2.setNumUnits(noUnits + 1);
                        currentUnit++;
                        worldPanel.setCurrentUnit(currentUnit);
                  }//end elseif
            }//end if

            //set new player and unit if necessary
            int temp = worldPanel.getNumUnits(currentPlayer);
            if(currentUnit > temp)
            {
                  if(currentPlayer == 1)
                        worldPanel.setCurrentPlayer(2);
                  else
                        worldPanel.setCurrentPlayer(1);
                  worldPanel.setCurrentUnit(1);
            }//end if

            //set up new mapPosition if player moved
            if(canBuild == true)
                  setMapPos();
            setInfoPanel();//set up information panel
      }//end buildNewUnit

      /**
       * This handles all info once player has moved like setting its
       * movement rate down one
       */
      private void playerMoved(int currentPlayer, int currentUnit, boolean moved)
      {
            if(moved == true)//if player has made a legitimate move
            {
                  worldPanel.repaint();
                  int movesLeft = 0;
                  if(currentPlayer == 1)
                  {
                        int myPos = worldPanel.player1.units[currentUnit - 1].getPosition();

                        //check to see if a player challenges another player
                        for(int i = 0; i < worldPanel.player2.getNumUnits(); i++)
                        {
                              int pos = worldPanel.player2.units[i].getPosition();
                              if(myPos == pos)
                              {
                                    fight(1, currentUnit - 1, i);
                                    return;
                              }
                        }//end for

                        //check to see if a player captures a city
                        for(int i = 0; i < worldPanel.player2.getNumCities(); i++)
                        {
                              int pos = worldPanel.player2.cities[i].getLocation();
                              if(myPos == pos)
                              {
                                    captureCity(1,i);
                                    return;
                              }
                        }//end for
                        movesLeft = worldPanel.player1.units[currentUnit - 1].getMovementsLeft();
                        int temp = worldPanel.player1.units[currentUnit - 1].getPosition();
                        int temp1 = mapPieces[0][temp];
                        if(temp1 == 54 || temp1 == 51 || temp1 == 52 || temp1 == 53)//if unit moves on rock or something
                              worldPanel.player1.units[currentUnit - 1].setMovementsLeft(movesLeft - 2);
                        else
                              worldPanel.player1.units[currentUnit - 1].setMovementsLeft(movesLeft - 1);
                        movesLeft = worldPanel.player1.units[currentUnit - 1].getMovementsLeft();
                  }//end if
                  else if(currentPlayer == 2)
                  {
                        int myPos = worldPanel.player2.units[currentUnit - 1].getPosition();

                        //check to see if a player challenges another player
                        for(int i = 0; i < worldPanel.player1.getNumUnits(); i++)
                        {
                              int pos = worldPanel.player1.units[i].getPosition();
                              if(myPos == pos)
                              {
                                    fight(2, currentUnit - 1, i);
                                    return;
                              }
                        }

                        //check to see if a player captures a city
                        for(int i = 0; i < worldPanel.player1.getNumCities(); i++)
                        {
                              int pos = worldPanel.player1.cities[i].getLocation();
                              if(myPos == pos)
                              {
                                    captureCity(2,i);
                                    return;
                              }
                        }//end for
                        movesLeft = worldPanel.player2.units[currentUnit - 1].getMovementsLeft();
                        int temp = worldPanel.player2.units[currentUnit - 1].getPosition();
                        int temp1 = mapPieces[0][temp];
                        if(temp1 == 54 || temp1 == 51 || temp1 == 52 || temp1 == 53)//if unit moves on rock or something
                              worldPanel.player2.units[currentUnit - 1].setMovementsLeft(movesLeft - 2);
                        else
                              worldPanel.player2.units[currentUnit - 1].setMovementsLeft(movesLeft - 1);
                        movesLeft = worldPanel.player2.units[currentUnit - 1].getMovementsLeft();

                        //worldPanel.player2.units[currentUnit - 1].setMovementsLeft(movesLeft - 1);
                        movesLeft = worldPanel.player2.units[currentUnit - 1].getMovementsLeft();
                  }

                  if(movesLeft <= 0)//if unit has run out of moves
                  {
                        if(currentPlayer == 1)
                        {
                              worldPanel.player1.units[currentUnit - 1].resetMovement();
                        }
                        if(currentPlayer == 2)
                        {
                              worldPanel.player2.units[currentUnit - 1].resetMovement();
                        }
                        currentUnit++;
                  }//end if
                  worldPanel.setCurrentUnit(currentUnit);
            }//end if

            int temp = worldPanel.getNumUnits(currentPlayer);
            if(currentUnit > temp)
            {
                  if(currentPlayer == 1)
                        worldPanel.setCurrentPlayer(2);
                  else
						{
                        worldPanel.setCurrentPlayer(1);
								year = unitPanel.getYear() + 20;//add 20 years to the game
						}
                  worldPanel.setCurrentUnit(1);
            }//end if

            setInfoPanel();//set up the information panel
      }//end playerMoved

      /**
       * This generates a new map using the provided
       * GWMap class
       */
      private void generate()
      {
            mapPieces = myMap.Generate3();
            mapWidth = myMap.getMapWidth();
            mapHeight = myMap.getMapHeight();
      }//end generate

      /**
       * This handles when units clash. It determines who wins and deals
       * with disposing of the losing unit.
       * @param playerNo int
       * @param fighter int
       * @param challenger int
       */
      private void fight(int playerNo, int fighter, int challenger)
      {
            LaughButton lt = new LaughButton();
            if(playerNo == 1)
            {
                  int attack = worldPanel.player1.units[fighter].getAttack();
                  int defence = worldPanel.player2.units[challenger].getDefence();
                  double attack1 = Math.random() * attack;
                  double defence1 = Math.random() * defence;
                  if(attack1 >= defence1)//player1 wins
                        worldPanel.player2.removeUnit(challenger);
                  else
                  {
                        worldPanel.player1.removeUnit(fighter);
                        worldPanel.setCurrentUnit(1);
                  }
            }//end if

            if(playerNo == 2)
            {
                  int attack = worldPanel.player2.units[fighter].getAttack();
                  int defence = worldPanel.player1.units[challenger].getDefence();
                  double attack1 = Math.random() * attack;
                  double defence1 = Math.random() * defence;
                  if(attack1 >= defence1)//player2 wins
                        worldPanel.player1.removeUnit(challenger);
                  else
                  {
                        worldPanel.player2.removeUnit(fighter);
                        worldPanel.setCurrentUnit(1);
                  }
            }//end if
            setMapPos();
            setInfoPanel();
      }//end fight

      /**
       * This handles when a city has been captured, it sets the
       * nation to recognise that it has got one less city, and it
       * also disposese of that city on the map.
       * @param playerNo int
       * @param city int
       */
      private void captureCity(int playerNo, int city)
      {
            if(playerNo == 1)
            {
                  worldPanel.player2.removeCity(city);
            }

            if(playerNo == 2)
            {
                  worldPanel.player1.removeCity(city);
            }
      }

      /**
       * This allows for a unit to skip a turn without
       * actually moving anywhere
       */
      private void spacePressed()
      {
            boolean moved = true;
            int currentPlayer = worldPanel.getCurrentPlayer();
            int currentUnit = worldPanel.getCurrentUnit();
            playerMoved(currentPlayer,currentUnit,moved);
            setMapPos();
      }//end space pressed

      /**
       * This sets the information panel so the user can
       * see who much movement his unit has and also how
       * strong and weak the units are.
       */
      private void setInfoPanel()
      {
            //set up info panel
            unitPanel.setPlayer(worldPanel.getCurrentPlayer());
				unitPanel.setYear(year);
            int tempUnit = worldPanel.getCurrentUnit();

            if(worldPanel.getCurrentPlayer() == 1)
            {
                  unitPanel.setImageIcon(worldPanel.player1.units[tempUnit - 1].getImage());
                  unitPanel.setAttack(worldPanel.player1.units[tempUnit - 1].getAttack());
                  unitPanel.setDefence(worldPanel.player1.units[tempUnit - 1].getDefence());
                  unitPanel.setMovement(worldPanel.player1.units[tempUnit - 1].getMovementsLeft());
            }
            else
            {
                  unitPanel.setImageIcon(worldPanel.player2.units[tempUnit - 1].getImage());
                  unitPanel.setAttack(worldPanel.player2.units[tempUnit - 1].getAttack());
                  unitPanel.setDefence(worldPanel.player2.units[tempUnit - 1].getDefence());
                  unitPanel.setMovement(worldPanel.player2.units[tempUnit - 1].getMovementsLeft());
            }
      }//end set info panel
		
		/**
       * This handles when a boat has been built it will place it
		 * on the ocean
       * @param playerLoc int
       * @return the sea location to place the ship
       */
		private int getSeaLoc(int playerLoc)
		{
			boolean test = false;
			int mapTemp = 0;
			//sea how far the sea location is to the left
			while(test == false)
			{
				int temp1 = playerLoc % mapWidth;
				if(temp1 == 0)
				{
					mapTemp = mapPieces[0][playerLoc + mapWidth - 1];
					playerLoc = playerLoc + mapWidth;
				}
				else
				{
					mapTemp = mapPieces[0][playerLoc - 1];
				}
				if(mapTemp == 0)//seaLoc
					test = true;
				playerLoc--;
			}
			return playerLoc;
		}
		
		/*
		 * This moves a ship left
		 */
		private void moveShipLeft()
		{
				boolean moved = true;
         	int currentPlayer = worldPanel.getCurrentPlayer();
            int currentUnit = worldPanel.getCurrentUnit();

            //if firstPlayer move unit left
            if(currentPlayer == 1)
            {
                  int currentPos = worldPanel.player1.units[currentUnit - 1].getPosition();
                  if(currentPos == 0)
                  {
                        int mapTemp = mapPieces[0][mapWidth - 1];
                        if(mapTemp != 0)//if unit tries to move onto land
                              moved = false;
                        else
                              worldPanel.player1.units[currentUnit - 1].setPosition(mapWidth - 1);
                  }
                  else
                  {
                        int temp1 = currentPos % mapWidth;
                        if(temp1 == 0)
                        {
                              int mapTemp = mapPieces[0][currentPos + mapWidth - 1];
                              if(mapTemp != 0)//if unit tries to move onto land
                                    moved = false;
                              else
                                    worldPanel.player1.units[currentUnit - 1].setPosition(currentPos + mapWidth - 1);
                        }//end if
                        else
                        {
                              int mapTemp = mapPieces[0][currentPos - 1];
                              if(mapTemp != 0)//if unit tries to move onto land
                                    moved = false;
                              else
                                    worldPanel.player1.units[currentUnit - 1].setPosition(currentPos - 1);
                        }//end else
                  }//end else
            }//end if

            //if firstPlayer move unit left
            if(currentPlayer == 2)
            {
                  int currentPos = worldPanel.player2.units[currentUnit - 1].getPosition();
                  if(currentPos == 0)
                  {
                        int mapTemp = mapPieces[0][mapWidth - 1];
                        if(mapTemp != 0)//if unit tries to move onto land
                              moved = false;
                        else
                              worldPanel.player2.units[currentUnit - 1].setPosition(mapWidth - 1);
                  }
                  else
                  {
                        int temp1 = currentPos % mapWidth;
                        if(temp1 == 0)
                        {
                              int mapTemp = mapPieces[0][currentPos + mapWidth - 1];
                              if(mapTemp != 0)//if unit tries to move onto land
                                    moved = false;
                              else
                                    worldPanel.player2.units[currentUnit - 1].setPosition(currentPos + mapWidth - 1);
                        }//end if
                        else
                        {
                              int mapTemp = mapPieces[0][currentPos - 1];
                              if(mapTemp != 0)//if unit tries to move onto land
                                    moved = false;
                              else
                                    worldPanel.player2.units[currentUnit - 1].setPosition(currentPos - 1);
                        }//end else
                  }//end else
            }//end if

            //set up new player once unit has moved
            playerMoved(currentPlayer,currentUnit,moved);

            //set up new mapPosition if player moved
            if(moved == true)
                  setMapPos();
		}
		
		/*
		 * This moves a ship right
		 */
		private void moveShipRight()
		{
				boolean moved = true;
            int currentPlayer = worldPanel.getCurrentPlayer();
            int currentUnit = worldPanel.getCurrentUnit();

            //if firstPlayer move unit right
            if(currentPlayer == 1)
            {
                  int currentPos = worldPanel.player1.units[currentUnit - 1].getPosition();
                  int temp1 = (currentPos + 1) % mapWidth;
                  if(temp1 == 0)
                  {
                        int mapTemp = mapPieces[0][currentPos - mapWidth + 1];
                        if(mapTemp != 0)//if unit tries to move onto land
                              moved = false;
                        else
                              worldPanel.player1.units[currentUnit - 1].setPosition(currentPos - mapWidth + 1);
                  }
                  else
                  {
                        int mapTemp = mapPieces[0][currentPos + 1];
                        if(mapTemp != 0)//if unit tries to move onto land
                              moved = false;
                        else
                              worldPanel.player1.units[currentUnit - 1].setPosition(currentPos + 1);
                  }
            }//end if

            //if secondPlayer move unit right
            if(currentPlayer == 2)
            {
                  int currentPos = worldPanel.player2.units[currentUnit - 1].getPosition();
                  int temp1 = (currentPos + 1) % mapWidth;
                  if(temp1 == 0)
                  {
                        int mapTemp = mapPieces[0][currentPos - mapWidth + 1];
                        if(mapTemp != 0)//if unit tries to move onto land
                              moved = false;
                        else
                              worldPanel.player2.units[currentUnit - 1].setPosition(currentPos - mapWidth + 1);
                  }//end if
                  else
                  {
                        int mapTemp = mapPieces[0][currentPos + 1];
                        if(mapTemp != 0)//if unit tries to move onto land
                              moved = false;
                        else
                              worldPanel.player2.units[currentUnit - 1].setPosition(currentPos + 1);
                  }//end else
            }//end if

            //set up new player once unit has moved
            playerMoved(currentPlayer,currentUnit,moved);

            //set up new mapPosition if player moved
            if(moved == true)
                  setMapPos();
		}
		
		/*
		 * This moves a ship up
		 */
		private void moveShipUp()
		{
				boolean moved = true;
            int currentPlayer = worldPanel.getCurrentPlayer();
            int currentUnit = worldPanel.getCurrentUnit();

            //if firstPlayer move unit up
            if(currentPlayer == 1)
            {
                  int currentPos = worldPanel.player1.units[currentUnit - 1].getPosition();
                  if(currentPos >= 0 && currentPos < mapWidth)
                  {
                        int newPos = mapHeight -1;
                        int newPos2 = mapHeight * newPos + currentPos;
                        int mapTemp = mapPieces[0][newPos2];
                        if(mapTemp != 0)//if unit tries to move onto land
                              moved = false;
                        else
                              worldPanel.player1.units[currentUnit - 1].setPosition(newPos2);
                  }
                  else
                  {
                        int mapTemp = mapPieces[0][currentPos - mapWidth];
                        if(mapTemp != 0)//if unit tries to move onto land
                              moved = false;
                        else
                              worldPanel.player1.units[currentUnit - 1].setPosition(currentPos - mapWidth);
                  }
            }//end if

            //if secondPlayer move unit up
            if(currentPlayer == 2)
            {
                  int currentPos = worldPanel.player2.units[currentUnit - 1].getPosition();
                  if(currentPos >= 0 && currentPos < mapWidth)
                  {
                        int newPos = mapHeight -1;
                        int newPos2 = mapHeight * newPos + currentPos;
                        int mapTemp = mapPieces[0][newPos2];
                        if(mapTemp != 0)//if unit tries to move onto land
                              moved = false;
                        else
                              worldPanel.player2.units[currentUnit - 1].setPosition(newPos2);
                  }
                  else
                  {
                        int mapTemp = mapPieces[0][currentPos - mapWidth];
                        if(mapTemp != 0)//if unit tries to move onto land
                              moved = false;
                        else
                              worldPanel.player2.units[currentUnit - 1].setPosition(currentPos - mapWidth);
                  }//end else
            }//end if

            //set up new player once unit has moved
            playerMoved(currentPlayer,currentUnit,moved);

            //set up new mapPosition if player moved
            if(moved == true)
                  setMapPos();
		}
		
		/*
		 * This moves a ship down
		 */
		private void moveShipDown()
		{
				boolean moved = true;
            int currentPlayer = worldPanel.getCurrentPlayer();
            int currentUnit = worldPanel.getCurrentUnit();

            //if firstPlayer move unit down
            if(currentPlayer == 1)
            {
                  int currentPos = worldPanel.player1.units[currentUnit - 1].getPosition();
                  int temp1 = mapWidth * mapHeight - mapWidth;
                  int temp2 = mapWidth * mapHeight;
                  if(currentPos >= temp1 && currentPos < temp2)
                  {
                        int newPos = currentPos % mapHeight;
                        int mapTemp = mapPieces[0][newPos];
                        if(mapTemp != 0)//if unit tries to move onto land
                              moved = false;
                        else
                              worldPanel.player1.units[currentUnit - 1].setPosition(newPos);
                  }//end if
                  else
                  {
                        int mapTemp = mapPieces[0][currentPos + mapWidth];
                        if(mapTemp != 0)//if unit tries to move onto land
                              moved = false;
                        else
                              worldPanel.player1.units[currentUnit - 1].setPosition(currentPos + mapWidth);
                  }//end else
            }//end if

            //if secondPlayer move unit down
            if(currentPlayer == 2)
            {
                  int currentPos = worldPanel.player2.units[currentUnit - 1].getPosition();
                  int temp1 = mapWidth * mapHeight - mapWidth;
                  int temp2 = mapWidth * mapHeight;
                  if(currentPos >= temp1 && currentPos < temp2)
                  {
                        int newPos = currentPos % mapHeight;
                        int mapTemp = mapPieces[0][newPos];
                        if(mapTemp != 0)//if unit tries to move onto land
                              moved = false;
                        else
                              worldPanel.player2.units[currentUnit - 1].setPosition(newPos);
                  }
                  else
                  {
                        int mapTemp = mapPieces[0][currentPos + mapWidth];
                        if(mapTemp != 0)//if unit tries to move onto land
                              moved = false;
                        else
                              worldPanel.player2.units[currentUnit - 1].setPosition(currentPos + mapWidth);
                  }//end if
            }//end if

            //set up new player once unit has moved
            playerMoved(currentPlayer,currentUnit,moved);

            //set up new mapPosition if player moved
            if(moved == true)
                  setMapPos();
		}
}//end class
