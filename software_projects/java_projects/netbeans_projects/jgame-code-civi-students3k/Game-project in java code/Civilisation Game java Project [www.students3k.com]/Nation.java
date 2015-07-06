/**
 * Title:       Nation.java
 * Description: This class is used so nations can be created
 *              Note that each nation is created in a seperate
 *              thread
 * @author:     Shane Grund
 * @version:    1.0
 */
public class Nation
{
      protected City[] cities;
      protected Unit[] units;
      private int playerNumber, count, cityCount;
      private int numUnits;
      protected boolean started = false;
      private String name;

      /**
       * This constuctor just sets up which player is to be set up
       * @param playerNo int
       */
      public Nation(int playerNo)
      {
            playerNumber = playerNo;
            count = 0;
				name = "Player" + playerNumber;
            cityCount = 1;

            if(playerNumber == 1)
            {
                  cities = new City[20];
                  cities[0] = new City(1);
                  units = new Unit[50];
                  started = true;
            }//end player1
            if(playerNumber == 2)
            {
                  cities = new City[20];
                  cities[0] = new City(2);
                  units = new Unit[50];
                  started = true;
            }//end player2
      }//end constructor

      public int getNumUnits()
      {
            return numUnits;
      }//end getNumUnits

      public void setNumUnits(int i)
      {
            numUnits = i;
      }//end setNumUnits

      public City[] getCities()
      {
            return cities;
      }//end getCities

      public int getNumCities()
      {
            return cityCount;
      }//end getNumCities

      /**
       * This method adds a city to the current players cities.
       * @param pos int
       */
      public void addCity(int pos)
      {
            if(cityCount < 20)
            {
                  cities[cityCount] = new City(playerNumber);
                  cities[cityCount].setLocation(pos);
                  cityCount++;
            }//end if
      }//end addCity

      /**
       * This method adds a unit to the current players units
       * @param type int
       */
      public void addUnit(int type)
      {
            if(count < 50)
            {
                  units[count] = new Unit(type, playerNumber);
                  count++;
            }//end if
      }//end addUnit

      /**
       * This method adds a unit to the current players units
       * @param type int
       */
      public void addUnit2(int type)
      {
            if(count < 50)
            {
                  units[numUnits] = new Unit(type, playerNumber);
                  count++;
            }//end if
      }//end addUnit2


      public Unit[] getUnits()
      {
            return units;
      }//end getUnits

      /**
       * This removes a unit from the current players units
       * @param no int
       */
      public void removeUnit(int no)
      {
            for(int i = no; i < numUnits; i++)
            {
                  units[i] = units[i + 1];
            }//end for
            numUnits--;
            if(numUnits == 0)
            {
                  System.out.println("Player" + playerNumber + " LOSES");
                  System.exit(0);
            }//end if
      }//end removeUnit

      /**
       * This removes a city from the current players cities
       * @param no int
       */
      public void removeCity(int no)
      {
            for(int i = no; i < cityCount; i++)
            {
                  cities[i] = cities[i + 1];
            }//end for
            cityCount--;
            if(cityCount == 0)
            {
                  System.out.println("Player" + playerNumber + " LOSES");
                  System.exit(0);
            }//end if
      }//end removeCity
}//end class
