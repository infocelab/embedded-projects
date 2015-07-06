import javax.swing.*;

/**
 * Title:       Unit.java
 * Description: This class set up a unit for a particular player
 * @author:     Shane Grund
 * @version:    1.0
 */
public class Unit
{
      private ImageIcon settlerIcon, warriorIcon, swordsmanIcon, spearmanIcon;
      private ImageIcon archerIcon, catapultIcon, galleyIcon, horsemanIcon;
      private ImageIcon settlerIcon1, warriorIcon1, swordsmanIcon1, spearmanIcon1;
      private ImageIcon archerIcon1, catapultIcon1, galleyIcon1, horsemanIcon1;
      private ImageIcon myIcon;

      private int unitType, attack, defence, movement, position;
      private int playerNo, movementsLeft;

      /**
       * This constructor sets up all the different unit images
       * it also sets up movement rates attack, defence ect...
       * @param type int
       * @param playNo int
       */
      public Unit(int type, int playNo)
      {
            unitType = type;
            playerNo = playNo;

            //set up image icons;
            settlerIcon = new ImageIcon("images/Units/settler2.png");
            warriorIcon = new ImageIcon("images/Units/warrior2.png");
            swordsmanIcon = new ImageIcon("images/Units/swordsman2.png");
            spearmanIcon = new ImageIcon("images/Units/spearman2.png");
            archerIcon = new ImageIcon("images/Units/archer2.png");
            catapultIcon = new ImageIcon("images/Units/catapult2.png");
            galleyIcon = new ImageIcon("images/Units/galley2.png");
            horsemanIcon = new ImageIcon("images/Units/horseman2.png");

            settlerIcon1 = new ImageIcon("images/Units/settler1.png");
            warriorIcon1 = new ImageIcon("images/Units/warrior1.png");
            swordsmanIcon1 = new ImageIcon("images/Units/swordsman1.png");
            spearmanIcon1 = new ImageIcon("images/Units/spearman1.png");
            archerIcon1 = new ImageIcon("images/Units/archer1.png");
            catapultIcon1 = new ImageIcon("images/Units/catapult1.png");
            galleyIcon1 = new ImageIcon("images/Units/galley1.png");
            horsemanIcon1 = new ImageIcon("images/Units/horseman1.png");

            //set up this players icon
            if(type == 1)
            {
                  if(playerNo == 1)
                        myIcon = settlerIcon1;
                  else
                        myIcon = settlerIcon;
                  movement = 1;
                  attack = 0;
                  defence = 0;
            }//end if
            else if(type == 2)
            {
                  if(playerNo == 1)
                        myIcon = warriorIcon1;
                  else
                        myIcon = warriorIcon;
                  movement = 1;
                  attack = 1;
                  defence = 1;
            }//end if
            else if(type == 3)
            {
                  if(playerNo == 1)
                        myIcon = swordsmanIcon1;
                  else
                        myIcon = swordsmanIcon;
                  movement = 2;
                  attack = 2;
                  defence = 2;
            }//end if
            else if(type == 4)
            {
                  if(playerNo == 1)
                        myIcon = spearmanIcon1;
                  else
                        myIcon = spearmanIcon;
                  movement = 1;
                  attack = 2;
                  defence = 1;
            }//end if
            else if(type == 5)
            {
                  if(playerNo == 1)
                        myIcon = archerIcon1;
                  else
                        myIcon = archerIcon;
                  movement = 1;
                  attack = 3;
                  defence = 2;
            }//end if
            else if(type == 6)
            {
                  if(playerNo == 1)
                        myIcon = catapultIcon1;
                  else
                        myIcon = catapultIcon;
                  movement = 2;
                  attack = 5;
                  defence = 0;
            }//end if
            else if(type == 7)
            {
                  if(playerNo == 1)
                        myIcon = galleyIcon1;
                  else
                        myIcon = galleyIcon;
                  movement = 6;
                  attack = 1;
                  defence = 1;
            }//end if
            else if(type == 8)
            {
                  if(playerNo == 1)
                        myIcon = horsemanIcon1;
                  else
                        myIcon = horsemanIcon;
                  movement = 3;
                  attack = 2;
                  defence = 2;
            }//end if
            movementsLeft = movement;
      }//end constructor

      public ImageIcon getImage()
      {
            return myIcon;
      }//end getImage

      public void setPosition(int x)
      {
            position = x;
      }//end setPosition

      public int getPosition()
      {
            return position;
      }//end getPosition

      public int getMovement()
      {
            return movement;
      }//end getMovement

      public int getAttack()
      {
            return attack;
      }//end getAttack

      public int getDefence()
      {
            return defence;
      }//end getDefence

      public int getUnitType()
      {
            return unitType;
      }//end getUnitType

      public void setMovementsLeft(int i)
      {
            movementsLeft = i;
      }//end setMovementLeft

      public int getMovementsLeft()
      {
            return movementsLeft;
      }//end getMovementsLeft

      public void resetMovement()
      {
            movementsLeft = movement;
      }//end resetMovement
}//end class
