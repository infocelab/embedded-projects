/**
   GWMap -- Generate world class for Game
   Copyright (c) Ian Foley, March 2004

   You are free to use and modify this code, but you must acknowledge adaptations of this
   code in your program. However many actual lines of code you write yourself in the
   final submission, this code (and any adaptations of it) will count as 10% of acknowledged
   code in your final submission.

   The GWMap class is a singleton, that is only one object of this class may exist at a time.
   It is initially created by the static create() method.

   The static getGWMap() method can be called from any class to obtain a reference to the
   existing GWMap object. It will return null if GWMap has not been created.

   A code fragment something like the following will create a 100x100 map array. You can work
   out how the variables need to be declared

       gwMap = GWMap.getGWMap();
       if (gwMap == null)
       {
         GWMap.create(100,100,100,3,(float)50.0,(float)33.0,2,4);
         gwMap = GWMap.getGWMap();
       }
       else
        gwMap.reCreate(100,100,100,3,(float)50.0,(float)33.0,2,4);
       map = gwMap.Generate3();

   Note that 3 increasingly sophisticated map generation algorithms can be called upon.

   The map images are loaded from the GWTerrain.png file. Each image is 32x32 pixels.
   The images are stored together with 20 images per row and are referenced by a
   position offset. Offset 0 (the first image is sea, Offset 1 is a full land square. The
   remaining land images enable a nice coastline to be developed. You will work out
   exactly how to draw the image yourself. All of the map is stored in layer 0, so the
   other layers are free for you to add other things which should appear on top of
   the map. The default map has 100x100 squares and has 4 layers.

   Use the following Graphics drawImage() method which enables you to specify source position
   and destination position to draw the map.

   public abstract boolean drawImage(Image img,
                                     int dx1,
                                     int dy1,
                                     int dx2,
                                     int dy2,
                                     int sx1,
                                     int sy1,
                                     int sx2,
                                     int sy2,
                                     ImageObserver observer)

   Draws as much of the specified area of the specified image as is currently available,
   scaling it on the fly to fit inside the specified area of the destination drawable
   surface. Transparent pixels do not affect whatever pixels are already there.
   This method returns immediately in all cases, even if the image area to be drawn
   has not yet been scaled, dithered, and converted for the current output device.
   If the current output representation is not yet complete then drawImage returns false.
   As more of the image becomes available, the process that draws the image notifies
   the specified image observer.

   This method always uses the unscaled version of the image to render the
   scaled rectangle and performs the required scaling on the fly. It does not
   use a cached, scaled version of the image for this operation.
   Scaling of the image from source to destination is performed such that the
   first coordinate of the source rectangle is mapped to the first coordinate
   of the destination rectangle, and the second source coordinate is mapped to
   the second destination coordinate. The subimage is scaled and flipped as needed
   to preserve those mappings.


   Parameters:
   img - the specified image to be drawn
   dx1 - the x coordinate of the first corner of the destination rectangle.
   dy1 - the y coordinate of the first corner of the destination rectangle.
   dx2 - the x coordinate of the second corner of the destination rectangle.
   dy2 - the y coordinate of the second corner of the destination rectangle.
   sx1 - the x coordinate of the first corner of the source rectangle.
   sy1 - the y coordinate of the first corner of the source rectangle.
   sx2 - the x coordinate of the second corner of the source rectangle.
   sy2 - the y coordinate of the second corner of the source rectangle.
   observer - object to be notified as more of the image is scaled and converted.

   Returns:
    true if the current output representation is complete; false otherwise.
   Since:
    JDK1.1

 */

import java.util.*;

class GWMap
{
  private static GWMap gwMap = null;
  private Random random;

    // Parameters needed to construct a GWMap object
  private int mapWidth = 100;   // Width of map in squares
  private int mapHeight = 100;  // Height of map in squares
  private int numIslands = 100; // Number of islands to generate
  private int numContinents = 3;// Number of continents to generate
  private float percentageContinent = (float)50.0; // % of land which is in continents
  private float percentageLand = (float)33.0;      // Overall % of land to aim for
  private int iNations = 2;     // Number of nations in game
  private int iLayers = 4;      // Number of graphical layers to display

    // Arrays which hold map data
  private int[][] map;          // Array of indexes to tiles in layers
  private int[] nationMap;      // Which nation does a tile belong to? 0 = sea

    // Instance variables used to generate map
  private int world;            // Variable to hold mapWidth*mapHeight
  private int maxSize;          // Max size of islands
  private int contSize;         // Max size of continents
  private int[] origPos;        // Starting square for an island
  private int[] startPos;       // Square from which to compute next land square
  private int[] loc;            // Adjacent location in 8 directions with radius 1
  private int[] loc2;           // Location 2 squares away
  private int[] choice;         // Equally near locations
  private int[] adjacent;       // Adjacent square in 8 directions with radius 1
  private int[] adjacent2;      // Content of square 2 squares away
  private float[] distance;     // Distance of adjacent square from original square
  private float[] distance2;    // Distance of square from original square
  private float avDist;         // Average distance from original position

  public GWMap(int mapWidth,int mapHeight,int numIslands,int numContinents,
    float percentageContinent,float percentageLand,int iNations,int iLayers)
  {
    if (gwMap != null)
    {
      System.out.println("GWMap already exists");
      return;
    }
    gwMap = this;
    this.mapWidth = mapWidth;
    this.mapHeight = mapHeight;
    this.numIslands = numIslands;
    this.numContinents = numContinents;
    this.percentageContinent = percentageContinent;
    this.percentageLand = percentageLand;
    this.iNations = iNations;
    this.iLayers = iLayers;
    world = mapWidth*mapHeight;
    map = new int[iLayers][world];
    nationMap = new int[world];
    origPos = new int[numIslands];
    startPos = new int[numIslands];
    loc = new int[8];
    loc2 = new int[16];
    choice = new int[16];
    adjacent = new int[8];
    adjacent2 = new int[16];
    distance = new float[8];
    distance2 = new float[16];
  }

  public static GWMap getGWMap()
  {
    return gwMap;
  }

  public static void create(int mapWidth,int mapHeight,int numIslands,
    int numContinents,float percentageContinent,float percentageLand,
    int iNations,int iLayers)
  {
      // everything is taken care of in the constructor
    new GWMap(mapWidth,mapHeight,numIslands,numContinents,
     percentageContinent,percentageLand,iNations,iLayers);
  }

  public void reCreate(int mapWidth,int mapHeight,int numIslands,int numContinents,
    float percentageContinent,float percentageLand,int iNations,int iLayers)
  {
    if (gwMap == null)
    {
      System.out.println("GWMap does not exist");
      return;
    }
    gwMap = this;
    this.mapWidth = mapWidth;
    this.mapHeight = mapHeight;
    this.numIslands = numIslands;
    this.numContinents = numContinents;
    this.percentageContinent = percentageContinent;
    this.percentageLand = percentageLand;
    this.iNations = iNations;
    this.iLayers = iLayers;
    world = mapWidth*mapHeight;
    map = new int[iLayers][world];
    nationMap = new int[world];
    origPos = new int[numIslands];
    startPos = new int[numIslands];
    loc = new int[8];
    loc2 = new int[16];
    choice = new int[16];
    adjacent = new int[8];
    adjacent2 = new int[16];
    distance = new float[8];
    distance2 = new float[16];
  }

  public int getNumLayers()
  {
    return iLayers;
  }

  public int getMapWidth()
  {
    return mapWidth;
  }

  public int getMapHeight()
  {
    return mapHeight;
  }

    //Initialize the map
  public void InitializeMap()
  {
    int i, j;

      // Clear the map
    for  (i = 0;i < world;i++)
    {
        // Base layer gets sea = 0
      map[0][i] = 0;
      nationMap[i] = 0;
        // Other layers get 0
      for (j = 1;j < iLayers;j++)
      {
        map[j][i] = 0;
      }
        // All Land is > 0
    }
  }

    // Distance in squares between a (original square) and b
    // If b has not been wrapped, calculation is straightforward
  public float Dist(int a,int b)
  {
    int xOrig,yOrig,xCur,yCur,x,y,oldXCur;
    float d,d1,d2,d3,d4;
    xOrig = a%mapWidth;
    yOrig = a/mapWidth;
    xCur = b%mapWidth;
    yCur = b/mapWidth;
    x = Math.abs(xOrig-xCur);
    y = Math.abs(yOrig-yCur);
    d1 = (float)Math.sqrt(x*x + y*y);
    d = d1;
      // Assume current wrapped. Original cannot be wrapped
      // If b wrapped in x direction
    oldXCur = xCur;
    if (xCur < mapWidth/2)
     xCur += mapWidth;
    else
     xCur -= mapWidth;
    x = Math.abs(xOrig-xCur);
    d2 = (float)Math.sqrt(x*x + y*y);
    if (d2 < d)
     d = d2;
      // If b wrapped in x and y direction
    if (yCur < mapHeight/2)
     yCur += mapHeight;
    else
     yCur -= mapHeight;
    y = Math.abs(yOrig-yCur);
    d3 = (float)Math.sqrt(x*x + y*y);
    if (d3 < d)
     d = d3;
      // if b wrapped in y direction
    xCur = oldXCur;
    x = Math.abs(xOrig-xCur);
    d4 = (float)Math.sqrt(x*x + y*y);
    if (d4 < d)
     d = d4;
    return (float)d;
  }

    // Find position of adjacent squares to sPos and store in loc.
    // Store contents of these locations in adjacent.
    // Store distance of these locations from the original island square
    // Compute average distance from the original square
  public void FindAdjacent(int j,int sPos)
  {
    int k;
    int iThisRow;
    int iNextRow;
    float totalDist = (float)0.0;
    float no = (float)0.0;

    k = 0;    // North
    loc[k] = sPos;
    loc[k] -= mapHeight;
    if (loc[k] < 0)
    {
      loc[k] += world;
    }
    k = 2;    // East
    loc[k] = sPos;
    iThisRow = loc[k]/mapWidth;
    loc[k]++;
    iNextRow = loc[k]/mapWidth;
    if (iNextRow > iThisRow)
    {
      loc[k] -= mapWidth;
    }
    k = 4;    // South
    loc[k] = sPos;
    loc[k] += mapHeight;
    if (loc[k] >= world )
    {
      loc[k] -= world;
    }
    k = 6;    // West
    loc[k] = sPos;
    iThisRow = loc[k]/mapWidth;
    loc[k]--;
    iNextRow = loc[k]/mapWidth;
    if (iNextRow < iThisRow || loc[k] < 0)
    {
      loc[k] += mapWidth;
    }
    k = 1;    // NE
    loc[k] = loc[2];      // Go East
    loc[k] -= mapHeight;  // Go North
    if (loc[k] < 0)
    {
      loc[k] += world;
    }
    k = 3;    // SE
    loc[k] = loc[2];      // Go East
    loc[k] += mapHeight;  // Go South
    if (loc[k] >= world )
    {
      loc[k] -= world;
    }
    k = 5;    // SW
    loc[k] = loc[6];      // Go West
    loc[k] += mapHeight;  // Go South
    if (loc[k] >= world )
    {
      loc[k] -= world;
    }
    k = 7;    // NW
    loc[k] = loc[6];      // Go West
    loc[k] -= mapHeight;  // Go North
    if (loc[k] < 0)
    {
      loc[k] += world;
    }

    for (k = 0;k < 8;k++)
    {
      adjacent[k] = map[0][loc[k]];
      distance[k] = Dist(origPos[j],loc[k]);
      if (adjacent[k] != 0)   // Not equal to sea
      {
        totalDist += distance[k];
        no += 1.0;
      }
    }
    if (no > 0.0)
     avDist = totalDist/no;
    else
     avDist = (float)0.0;
  }

    // Find position of squares 2 squares away
    // Store contents of these locations in adjacent2.
    // Store distance of these locations from the original island square
  public void FindAdjacent2(int j)
  {
    int k,m;
    int iThisRow;
    int iNextRow;

    m = 0;
    loc2[m] = loc[0];   // 2 squares north
    loc2[m] -= mapHeight;
    if (loc2[m] < 0)
    {
      loc2[m] += world;
    }
    m = 1;
    loc2[m] = loc2[m-1];  // NNE 2 squares
    iThisRow = loc2[m]/mapWidth;
    loc2[m]++;
    iNextRow = loc2[m]/mapWidth;
    if (iNextRow > iThisRow)
    {
      loc2[m] -= mapWidth;
    }
    m = 2;
    loc2[m] = loc2[m-1];  // Go East
    iThisRow = loc2[m]/mapWidth;
    loc2[m]++;
    iNextRow = loc2[m]/mapWidth;
    if (iNextRow > iThisRow)
    {
      loc2[m] -= mapWidth;
    }
    for (m = 3;m < 7;m++)
    {
      loc2[m] = loc2[m-1];  // Go South
      loc2[m] += mapHeight;
      if (loc2[m] >= world )
      {
        loc2[m] -= world;
      }
    }
    for (m = 7;m < 11;m++)
    {
      loc2[m] = loc2[m-1];  // Go West
      iThisRow = loc2[m]/mapWidth;
      loc2[m]--;
      iNextRow = loc2[m]/mapWidth;
      if (iNextRow < iThisRow || loc2[m] < 0)
      {
        loc2[m] += mapWidth;
      }
    }
    for (m = 11;m < 15;m++)
    {
      loc2[m] = loc2[m-1];  // Go North
      loc2[m] -= mapHeight;
      if (loc2[m] < 0)
      {
        loc2[m] += world;
      }
    }
    m = 15;
    loc2[m] = loc2[m-1];  // SSW+
    iThisRow = loc2[m]/mapWidth;
    loc2[m]++;
    iNextRow = loc2[m]/mapWidth;
    if (iNextRow > iThisRow)
    {
      loc2[m] -= mapWidth;
    }

    for (k = 0;k < 16;k++)
    {
      adjacent2[k] = map[0][loc2[k]];
      distance2[k] = Dist(origPos[j],loc2[k]);
    }
  }

    // Modify land according to surrounding sea.
  public int[][] modifyLand()
  {
    int i,j,k,iCount;

    j = 0;  // Value irrelevent
    for (i = 0; i < world;i++)
    {
      if (map[0][i] == 0)
      {
        if (j >= 100)
         System.out.println("Island: "+j+" j too big ");
        FindAdjacent(j,i);
        iCount = 0;
        for (k = 0;k < 8;k++)
        {
          if (adjacent[k] == 0)    // Sea
          {
            iCount++;
          }
        }
        if (iCount == 0)    // location i is completely surrounded by land
         map[0][i] = 14;
      }
    }

    for (i = 0; i < world;i++)
    {
      //j = nationMap[i] - 1;
      //if (j < 0)
      // j = 0;
      if (map[0][i] > 0)
      {
        FindAdjacent(j,i);
        iCount = 0;
        for (k = 0;k < 8;k++)
        {
          if (adjacent[k] == 0)    // Sea
          {
            iCount++;
          }
        }
        if (iCount == 1)
        {
          if (adjacent[0] == 0)
           map[0][i] = 2;
          else
          if (adjacent[2] == 0)
           map[0][i] = 3;
          else
          if (adjacent[4] == 0)
           map[0][i] = 4;
          else
          if (adjacent[6] == 0)
           map[0][i] = 5;
          else
          if (adjacent[1] == 0)
           map[0][i] = 13;
          else
          if (adjacent[3] == 0)
           map[0][i] = 10;
          else
          if (adjacent[5] == 0)
           map[0][i] = 11;
          else
          if (adjacent[7] == 0)
           map[0][i] = 12;
        }
        else
        if (iCount == 2)
        {
          if (adjacent[0] == 0 && adjacent[2] == 0)
           map[0][i] = 6;
          else
          if (adjacent[2] == 0 && adjacent[4] == 0)
           map[0][i] = 7;
          else
          if (adjacent[4] == 0 && adjacent[6] == 0)
           map[0][i] = 8;
          else
          if (adjacent[6] == 0 && adjacent[0] == 0)
           map[0][i] = 9;
          else
          if (adjacent[3] == 0 && adjacent[7] == 0)
           map[0][i] = 21;
          else
          if (adjacent[1] == 0 && adjacent[5] == 0)
           map[0][i] = 23;
          else
          if (adjacent[7] == 0 && adjacent[1] == 0)
           map[0][i] = 25;
          else
          if (adjacent[1] == 0 && adjacent[3] == 0)
           map[0][i] = 20;
          else
          if (adjacent[3] == 0 && adjacent[5] == 0)
           map[0][i] = 22;
          else
          if (adjacent[5] == 0 && adjacent[7] == 0)
           map[0][i] = 24;
          else
          if (adjacent[0] == 0 && adjacent[3] == 0)
           map[0][i] = 32;
          else
          if (adjacent[0] == 0 && adjacent[5] == 0)
           map[0][i] = 33;
          else
          if (adjacent[2] == 0 && adjacent[5] == 0)
           map[0][i] = 34;
          else
          if (adjacent[2] == 0 && adjacent[7] == 0)
           map[0][i] = 35;
          else
          if (adjacent[4] == 0 && adjacent[7] == 0)
           map[0][i] = 36;
          else
          if (adjacent[4] == 0 && adjacent[1] == 0)
           map[0][i] = 37;
          else
          if (adjacent[6] == 0 && adjacent[1] == 0)
           map[0][i] = 30;
          else
          if (adjacent[6] == 0 && adjacent[3] == 0)
           map[0][i] = 31;
          else
          if (adjacent[0] == 0 && adjacent[4] == 0)
           map[0][i] = 38;
          else
          if (adjacent[2] == 0 && adjacent[6] == 0)
           map[0][i] = 39;
          else
          if (adjacent[0] == 0)
           map[0][i] = 2;
          else
          if (adjacent[2] == 0)
           map[0][i] = 3;
          else
          if (adjacent[4] == 0)
           map[0][i] = 4;
          else
          if (adjacent[6] == 0)
           map[0][i] = 5;
        }
        else
        if (iCount == 3)
        {
          if (adjacent[6] == 0 && adjacent[0] == 0 && adjacent[2] == 0)
           map[0][i] = 16;
          else
          if (adjacent[0] == 0 && adjacent[2] == 0 && adjacent[4] == 0)
           map[0][i] = 17;
          else
          if (adjacent[2] == 0 && adjacent[4] == 0 && adjacent[6] == 0)
           map[0][i] = 18;
          else
          if (adjacent[4] == 0 && adjacent[6] == 0 && adjacent[0] == 0)
           map[0][i] = 19;
          else
          if (adjacent[7] == 0 && adjacent[1] == 0 && adjacent[3] == 0)
           map[0][i] = 45;
          else
          if (adjacent[1] == 0 && adjacent[3] == 0 && adjacent[5] == 0)
           map[0][i] = 46;
          else
          if (adjacent[3] == 0 && adjacent[5] == 0 && adjacent[7] == 0)
           map[0][i] = 47;
          else
          if (adjacent[5] == 0 && adjacent[7] == 0 && adjacent[1] == 0)
           map[0][i] = 48;
          else
          if (adjacent[0] == 0 && adjacent[3] == 0 && adjacent[5] == 0)
           map[0][i] = 27;
          else
          if (adjacent[2] == 0 && adjacent[5] == 0 && adjacent[7] == 0)
           map[0][i] = 28;
          else
          if (adjacent[4] == 0 && adjacent[7] == 0 && adjacent[1] == 0)
           map[0][i] = 29;
          else
          if (adjacent[1] == 0 && adjacent[3] == 0 && adjacent[6] == 0)
           map[0][i] = 26;
          else
          if (adjacent[2] == 0 && adjacent[4] == 0 && adjacent[7] == 0)
           map[0][i] = 40;
          else
          if (adjacent[4] == 0 && adjacent[6] == 0 && adjacent[1] == 0)
           map[0][i] = 41;
          else
          if (adjacent[6] == 0 && adjacent[0] == 0 && adjacent[3] == 0)
           map[0][i] = 42;
          else
          if (adjacent[0] == 0 && adjacent[2] == 0 && adjacent[5] == 0)
           map[0][i] = 43;
          else
          if (adjacent[7] == 0 && adjacent[0] == 0 && adjacent[1] == 0)
           map[0][i] = 2;
          else
          if (adjacent[1] == 0 && adjacent[2] == 0 && adjacent[3] == 0)
           map[0][i] = 3;
          else
          if (adjacent[3] == 0 && adjacent[4] == 0 && adjacent[5] == 0)
           map[0][i] = 4;
          else
          if (adjacent[5] == 0 && adjacent[6] == 0 && adjacent[7] == 0)
           map[0][i] = 5;
          else
          if (adjacent[0] == 0 && adjacent[2] == 0)
           map[0][i] = 6;
          else
          if (adjacent[2] == 0 && adjacent[4] == 0)
           map[0][i] = 7;
          else
          if (adjacent[4] == 0 && adjacent[6] == 0)
           map[0][i] = 8;
          else
          if (adjacent[6] == 0 && adjacent[0] == 0)
           map[0][i] = 9;
          else
          if (adjacent[0] == 0 && adjacent[4] == 0)
           map[0][i] = 38;
          else
          if (adjacent[2] == 0 && adjacent[6] == 0)
           map[0][i] = 39;
          else
          if (adjacent[0] == 0 && adjacent[3] == 0)
           map[0][i] = 32;
          else
          if (adjacent[0] == 0 && adjacent[5] == 0)
           map[0][i] = 33;
          else
          if (adjacent[2] == 0 && adjacent[5] == 0)
           map[0][i] = 34;
          else
          if (adjacent[2] == 0 && adjacent[7] == 0)
           map[0][i] = 35;
          else
          if (adjacent[4] == 0 && adjacent[7] == 0)
           map[0][i] = 36;
          else
          if (adjacent[4] == 0 && adjacent[1] == 0)
           map[0][i] = 37;
          else
          if (adjacent[6] == 0 && adjacent[1] == 0)
           map[0][i] = 30;
          else
          if (adjacent[6] == 0 && adjacent[3] == 0)
           map[0][i] = 31;
        }
        else
        if (iCount == 4)
        {
          if (adjacent[0] == 0 && adjacent[2] == 0 && adjacent[4] == 0 && adjacent[6] == 0)
           map[0][i] = 15;
          else
          if (adjacent[1] == 0 && adjacent[3] == 0 && adjacent[5] == 0 && adjacent[7] == 0)
           map[0][i] = 44;
          else
          if (adjacent[6] == 0 && adjacent[0] == 0 && adjacent[2] == 0)
           map[0][i] = 16;
          else
          if (adjacent[0] == 0 && adjacent[2] == 0 && adjacent[4] == 0)
           map[0][i] = 17;
          else
          if (adjacent[2] == 0 && adjacent[4] == 0 && adjacent[6] == 0)
           map[0][i] = 18;
          else
          if (adjacent[4] == 0 && adjacent[6] == 0 && adjacent[0] == 0)
           map[0][i] = 19;
          else
          if (adjacent[2] == 0 && adjacent[4] == 0 && adjacent[7] == 0)
           map[0][i] = 40;
          else
          if (adjacent[4] == 0 && adjacent[6] == 0 && adjacent[1] == 0)
           map[0][i] = 41;
          else
          if (adjacent[6] == 0 && adjacent[0] == 0 && adjacent[3] == 0)
           map[0][i] = 42;
          else
          if (adjacent[0] == 0 && adjacent[2] == 0 && adjacent[5] == 0)
           map[0][i] = 43;
          else
          if (adjacent[0] == 0 && adjacent[2] == 0)
           map[0][i] = 6;
          else
          if (adjacent[2] == 0 && adjacent[4] == 0)
           map[0][i] = 7;
          else
          if (adjacent[4] == 0 && adjacent[6] == 0)
           map[0][i] = 8;
          else
          if (adjacent[6] == 0 && adjacent[0] == 0)
           map[0][i] = 9;
          else
          if (adjacent[0] == 0 && adjacent[4] == 0)
           map[0][i] = 38;
          else
          if (adjacent[2] == 0 && adjacent[6] == 0)
           map[0][i] = 39;
          else
          if (adjacent[0] == 0 && adjacent[3] == 0)
           map[0][i] = 32;
          else
          if (adjacent[0] == 0 && adjacent[5] == 0)
           map[0][i] = 33;
          else
          if (adjacent[2] == 0 && adjacent[5] == 0)
           map[0][i] = 34;
          else
          if (adjacent[2] == 0 && adjacent[7] == 0)
           map[0][i] = 35;
          else
          if (adjacent[4] == 0 && adjacent[7] == 0)
           map[0][i] = 36;
          else
          if (adjacent[4] == 0 && adjacent[1] == 0)
           map[0][i] = 37;
          else
          if (adjacent[6] == 0 && adjacent[1] == 0)
           map[0][i] = 30;
          else
          if (adjacent[6] == 0 && adjacent[3] == 0)
           map[0][i] = 31;
        }
        else
        if (iCount == 5)
        {
          if (adjacent[0] == 0 && adjacent[2] == 0 && adjacent[4] == 0 && adjacent[6] == 0)
           map[0][i] = 15;
          else
          if (adjacent[6] == 0 && adjacent[0] == 0 && adjacent[2] == 0)
           map[0][i] = 16;
          else
          if (adjacent[0] == 0 && adjacent[2] == 0 && adjacent[4] == 0)
           map[0][i] = 17;
          else
          if (adjacent[2] == 0 && adjacent[4] == 0 && adjacent[6] == 0)
           map[0][i] = 18;
          else
          if (adjacent[4] == 0 && adjacent[6] == 0 && adjacent[0] == 0)
           map[0][i] = 19;
          else
          if (adjacent[2] == 0 && adjacent[4] == 0 && adjacent[7] == 0)
           map[0][i] = 40;
          else
          if (adjacent[4] == 0 && adjacent[6] == 0 && adjacent[1] == 0)
           map[0][i] = 41;
          else
          if (adjacent[6] == 0 && adjacent[0] == 0 && adjacent[3] == 0)
           map[0][i] = 42;
          else
          if (adjacent[0] == 0 && adjacent[2] == 0 && adjacent[5] == 0)
           map[0][i] = 43;
          else
          if (adjacent[0] == 0 && adjacent[2] == 0)
           map[0][i] = 6;
          else
          if (adjacent[2] == 0 && adjacent[4] == 0)
           map[0][i] = 7;
          else
          if (adjacent[4] == 0 && adjacent[6] == 0)
           map[0][i] = 8;
          else
          if (adjacent[6] == 0 && adjacent[0] == 0)
           map[0][i] = 9;
          else
          if (adjacent[0] == 0 && adjacent[4] == 0)
           map[0][i] = 38;
          else
          if (adjacent[2] == 0 && adjacent[6] == 0)
           map[0][i] = 39;
          else
          if (adjacent[0] == 0 && adjacent[3] == 0)
           map[0][i] = 32;
          else
          if (adjacent[0] == 0 && adjacent[5] == 0)
           map[0][i] = 33;
          else
          if (adjacent[2] == 0 && adjacent[5] == 0)
           map[0][i] = 34;
          else
          if (adjacent[2] == 0 && adjacent[7] == 0)
           map[0][i] = 35;
          else
          if (adjacent[4] == 0 && adjacent[7] == 0)
           map[0][i] = 36;
          else
          if (adjacent[4] == 0 && adjacent[1] == 0)
           map[0][i] = 37;
          else
          if (adjacent[6] == 0 && adjacent[1] == 0)
           map[0][i] = 30;
          else
          if (adjacent[6] == 0 && adjacent[3] == 0)
           map[0][i] = 31;
        }
        else
        if (iCount == 6)
        {
          if (adjacent[0] == 0 && adjacent[2] == 0 && adjacent[4] == 0 && adjacent[6] == 0)
           map[0][i] = 15;
          else
          if (adjacent[6] == 0 && adjacent[0] == 0 && adjacent[2] == 0)
           map[0][i] = 16;
          else
          if (adjacent[0] == 0 && adjacent[2] == 0 && adjacent[4] == 0)
           map[0][i] = 17;
          else
          if (adjacent[2] == 0 && adjacent[4] == 0 && adjacent[6] == 0)
           map[0][i] = 18;
          else
          if (adjacent[4] == 0 && adjacent[6] == 0 && adjacent[0] == 0)
           map[0][i] = 19;
          else
          if (adjacent[2] == 0 && adjacent[4] == 0 && adjacent[7] == 0)
           map[0][i] = 40;
          else
          if (adjacent[4] == 0 && adjacent[6] == 0 && adjacent[1] == 0)
           map[0][i] = 41;
          else
          if (adjacent[6] == 0 && adjacent[0] == 0 && adjacent[3] == 0)
           map[0][i] = 42;
          else
          if (adjacent[0] == 0 && adjacent[2] == 0 && adjacent[5] == 0)
           map[0][i] = 43;
          else
          if (adjacent[0] == 0 && adjacent[4] == 0)
           map[0][i] = 38;
          else
          if (adjacent[2] == 0 && adjacent[6] == 0)
           map[0][i] = 39;
        }
        else
        if (iCount == 7)
        {
          if (adjacent[0] == 0 && adjacent[2] == 0 && adjacent[4] == 0 && adjacent[6] == 0)
           map[0][i] = 15;
          else
          if (adjacent[6] == 0 && adjacent[0] == 0 && adjacent[2] == 0)
           map[0][i] = 16;
          else
          if (adjacent[0] == 0 && adjacent[2] == 0 && adjacent[4] == 0)
           map[0][i] = 17;
          else
          if (adjacent[2] == 0 && adjacent[4] == 0 && adjacent[6] == 0)
           map[0][i] = 18;
          else
          if (adjacent[4] == 0 && adjacent[6] == 0 && adjacent[0] == 0)
           map[0][i] = 19;
        }
        else
        if (iCount == 8)    // location i is surrounded completely by sea
         map[0][i] = 15;
      }
    }

    // Count land
    iCount = 0;
    for (i = 0; i < world;i++)
    {
      if (map[0][i] > 0)
       iCount++;
    }
    //System.out.println("Percent land "+(iCount*100)/world);
    for(int t = 0; t < map[0].length; t++)
    {
      if(map[0][t] == 1)
      {
        int temp = (int)Math.round(Math.random() * 12 + 1);
        if(temp < 7)
          map[0][t] = 48 + temp;
      }
    }
    return map;
  }

    // Random location of islands
    // Build land by choosing NSEW direction for next land square randomly
    // and by allowing 50% chance of returning to previous land to promote
    // rounder land
    // Allow islands to merge
    // Continuous world (land wraps at edges)
    // Produces worlds with long, thin straggled islands
  public int[][] Generate1()
  {
    int iRandDir;
    int i,j;
    int iThisRow;
    int iNextRow;
    int islandSize;
    int iCount;//,iPick;
    int savePos = 0;
    float dist;       // minimum distance

      // Factor of 2 would have correct if land did not duplicate.
    maxSize = (int)(10.0*(float)world*percentageLand/(100.0*(float)numIslands));
    System.out.println("Max island size " + maxSize);

      // Clear the map
    InitializeMap();

      // Seed the random-number generator with current time so that
      // the numbers will be different every time we run.
    random = new Random();

      // Randomly create starting locations
    boolean tooClose = false;
    boolean loop = true;
    for (i = 0;i < numIslands;i++)
    {
        // Set island starting positions
      while (loop)
      {
        startPos[i] = random.nextInt(world);
        for (j = 0;j < i;j++)
        {
          dist = Dist(startPos[i],startPos[j]);
          if (dist <= 2.0)
          {
            tooClose = true;
            break;
          }
        }
        if (!tooClose)
         loop = false;
        tooClose = false;
      }
      loop = true;
      origPos[i] = startPos[i];

        // Place land at these positions
      map[0][startPos[i]] = 1;
      nationMap[startPos[i]] = i + 1;
    }

      // Move around
    for (j = 0;j < numIslands;j++)
    {
      islandSize = random.nextInt(maxSize);
      System.out.println("Island: "+j+" Size "+islandSize+
       " Start "+startPos[j]);
      i = 0;
      iCount = 0;
      while (i < islandSize)
      {
        iRandDir = random.nextInt(4);

          // Move up
        if (iRandDir == 0)
        {
          savePos = startPos[j];
          startPos[j] -= mapWidth;
          if (startPos[j] < 0)
          {
            startPos[j] += world;
          }
        }
          // Move right
        else
        if (iRandDir == 1)
        {
          savePos = startPos[j];
          iThisRow = startPos[j]/mapWidth;
          startPos[j]++;
          iNextRow = startPos[j]/mapWidth;
          if (iNextRow > iThisRow)
          {
            startPos[j] -= mapWidth;
          }
        }
          // Move down
        else
        if (iRandDir == 2)
        {
          savePos = startPos[j];
          startPos[j] += mapWidth;
          if (startPos[j] >= world )
          {
            startPos[j] -= world;
          }
        }
          // Move left
        else
        if (iRandDir == 3)
        {
          savePos = startPos[j];
          iThisRow = startPos[j]/mapWidth;
          startPos[j]--;
          iNextRow = startPos[j]/mapWidth;
          if (iNextRow < iThisRow || startPos[j] < 0)
          {
            startPos[j] += mapWidth;
          }
        }

          // Place land at these positions
        if (startPos[j] < 0 || startPos[j] >= 10000)
        {
          System.out.println("Location "+j+" "+startPos[j]+
           " Rand dir "+iRandDir);
        }
        map[0][startPos[j]] = 1;
        nationMap[startPos[j]] = j + 1;
          // 50% probability of returning to previous location
          // to promote a rounder land area
        if (random.nextInt(2) == 0)
         startPos[j] = savePos;
        i++;
      }
    }
    return modifyLand();
  }

    // -- TYPE 2 --
    // Random location of islands
    // Method finds 4 adjacent squares and then selects one of these providing.
    // it is a sea square. First criteria for selection is that the sea square is the
    // one choice to the original land square. If there is more than one equally near,
    // then that square is chosen randomly between them.
    // Islands can merge if they have diagonally adjacent land.
    // Continuous world (land wraps at edges)
    // Produces world with very rounded islands
  public int[][] Generate2()
  {
    int i,j,k,m;
    int iThisRow;
    int iNextRow;
    int islandSize;
    int iCount;//,iPick;
    int iSize;
    float dist;       // minimum distance
    float newDist;

      // Factor of 2 means average size should be about right
    maxSize = (int)(2.0*(float)mapWidth*(float)mapHeight*percentageLand/
     (100.0*(float)numIslands));
    System.out.println("Max island size "+maxSize);

      // Clear the map
    InitializeMap();

      // Seed the random-number generator with current time so that
      // the numbers will be different every time we run.
    random = new Random();

      // Randomly create starting locations
    boolean tooClose = false;
    boolean loop = true;
    for (i = 0;i < numIslands;i++)
    {
        // Set island starting positions
      while (loop)
      {
        startPos[i] = random.nextInt(world);
        for (j = 0;j < i;j++)
        {
          dist = Dist(startPos[i],startPos[j]);
          if (dist <= 6.0)
          {
            tooClose = true;
            break;
          }
        }
        if (!tooClose)
         loop = false;
        tooClose = false;
      }
      loop = true;
      origPos[i] = startPos[i];

        // Place land at these positions
      map[0][startPos[i]] = 1;
      nationMap[startPos[i]] = i + 1;
    }

      // Generate islands one by one
    for (j = 0;j < numIslands;j++)
    {
      islandSize = random.nextInt(maxSize);
      iSize = 0;
      System.out.println("Island: "+j+" Size "+islandSize+
       " Start "+startPos[j]);
      i = 0;
      while (i < islandSize)
      {
          // Find adjacent 4 locations. Store in loc[k].
          // Store content of these squares in adjacent[k]
        for (k = 0; k < 4;k++)
        {
          loc[k] = startPos[j];
          if (k == 0)   // North
          {
            loc[k] -= mapHeight;
            if (loc[k] < 0)
            {
              loc[k] += world;
            }
          }
          else
          if (k == 1)   // East
          {
            iThisRow = loc[k]/mapWidth;
            loc[k]++;
            iNextRow = loc[k]/mapWidth;
            if (iNextRow > iThisRow)
            {
              loc[k] -= mapWidth;
            }
          }
          else
          if (k == 2)   // South
          {
            loc[k] += mapHeight;
            if (loc[k] >= world )
            {
              loc[k] -= world;
            }
          }
          else
          if (k == 3)   // West
          {
            iThisRow = loc[k]/mapWidth;
            loc[k]--;
            iNextRow = loc[k]/mapWidth;
            if (iNextRow < iThisRow || loc[k] < 0)
            {
              loc[k] += mapWidth;
            }
          }
          adjacent[k] = map[0][loc[k]];
          distance[k] = Dist(origPos[j],loc[k]);
        }
          // Count number of adjacent sea locations
        iCount = 0;
        for (k = 0;k < 4;k++)
        {
          if (adjacent[k] == 0)    // Sea
           iCount++;
        }
          // If no adjacent sea squares stop generating this island
        if (iCount == 0)
        {
          System.out.println("Break - no adjacent sea squares");
          break;
        }
          // Select locations nearer or further to the original land square
          // depending on strategy
        m = 0;
        boolean isNearest;
        int strategy;
        strategy = random.nextInt(100);
        if (strategy > 19)    // Choose nearest 80% of time
        {
          dist = (float)9999.0;
          isNearest = true;
        }
        else
        {
          dist = -1;
          isNearest = false;
        }
        iCount = 0;
        for (k = 0;k < 4;k++)
        {
          if (adjacent[k] == 0)
          {
            newDist = distance[k];
            if (isNearest)
            {
              if (newDist < dist)
              {
                dist = newDist;
                iCount = 1;
                choice[0] = loc[k];
                m = 0;
              }
              else
              if (newDist == dist)
              {
                iCount++;
                m++;
                choice[m] = loc[k];
              }
            }
            else
            {
              if (newDist > dist)
              {
                dist = newDist;
                iCount = 1;
                choice[0] = loc[k];
                m = 0;
              }
              else
              if (newDist == dist)
              {
                iCount++;
                m++;
                choice[m] = loc[k];
              }
            }
          }
        }
        if (iCount == 1)    // Only 1 choice, choose this one
        {
          iSize++;
          map[0][choice[0]] = 1;
          startPos[j] = choice[0];
          nationMap[startPos[j]] = j + 1;
        }
          // Greater than 1 choice, randomly pick 1
        else
        if (iCount > 1)
        {
          m = random.nextInt(iCount);
          iSize++;
          map[0][choice[m]] = 1;
          nationMap[startPos[j]] = j + 1;
            // Some probability of returning to previous location
            // providing that square has an adjacent sea square
          //if (rand()%iCount == 0)
          if (isNearest)
           startPos[j] = choice[m];
        }
        i++;
      }
      System.out.println("Island: "+j+" Actual Size "+iSize);
    }
    return modifyLand();
  }

    // -- TYPE 3 --
    // Random location of islands. Size is randomly chosen.
    // Method finds 8 adjacent squares and the 16 next most adjacent squares.
    // It then selects one of the adjacent squares providing it is a sea square
    // according to the following algorithm
    // It determines all squares that are (1) equally near to the original land square
    // or (2) equally far from the original land square. The choice between (1) and (2)
    // is random with the probability of selecting (1) set to value stored in strategy.
    // If (1) is set to 100%, the result is very rounded islands. As this probability
    // is reduced, the islands become less orderly which is desired, but they also
    // contain more inland lakes and become more anf more stratified. The default is
    // 90%. An attempt is also made to keep the islands separated from each other. This
    // done by trying to keep the land 2 squares away from the starting square sea if
    // it is further away from the original land square of the island then the sea
    // being examined as the next possible land square.
    //
    // Continuous world (land wraps at edges)
    // Produces world with somewhat rounded islands, but with interesting deviations
  public int[][] Generate3()
  {
    int i,j,k,m;
    int iThisRow;
    int iNextRow;
    int islandSize;
    int iCount;//,iPick;
    int iSize;
    float dist;       // minimum distance

      // These are fixed size
    contSize = (int)((float)mapWidth*(float)mapHeight*percentageLand*percentageContinent/
     (100.0*100.0*(float)numContinents));
      // Factor of 2 means average size should be about right
    maxSize = (int)(2.0*(float)mapWidth*(float)mapHeight*percentageLand*
      (100.0 - percentageContinent)/(100.0*100.0*(float)numIslands));
    //System.out.println("Max island size "+maxSize);

      // Clear the map
    InitializeMap();

      // Seed the random-number generator with current time so that
      // the numbers will be different every time we run.
    random = new Random();

      // Randomly create starting locations
    boolean tooClose = false;
    boolean loop;
    boolean land;
    int iAdj;
    int iAdj2;
    for (j = 0;j < numIslands;j++)
    {
        // Set island starting positions
        // Position continents first as far apart as possible
      loop = true;
      while (loop)
      {
        land = true;
        while (land)
        {
          startPos[j] = random.nextInt(world);
          //System.out.println("Island: "+j+" Start "+startPos[j]);
          FindAdjacent(j,startPos[j]);
          iAdj = 0;
          for (k = 0;k < 8;k++)
          {
            if (adjacent[k] == 0)    // Sea
             iAdj++;
          }
          FindAdjacent2(j);
          iAdj2 = 0;
          for (k = 0;k < 16;k++)
          {
            if (adjacent2[k] == 0)    // Sea
             iAdj2++;
          }
          if ((map[0][startPos[j]] == 0) && (iAdj == 8) && (iAdj2 == 16))
           land = false;
        }
        for (i = 0;i < j;i++)
        {
          dist = Dist(startPos[j],startPos[i]);
          if ((j < numContinents) && (dist <= mapWidth/(numContinents + 1)))
          {
            tooClose = true;
            break;
          }
          else
          if (dist <= 3.0)
          {
            tooClose = true;
            break;
          }
        }
        if (!tooClose)
         loop = false;
        tooClose = false;
      }
      origPos[j] = startPos[j];

        // Place land at these positions
      map[0][startPos[j]] = 1;
      nationMap[startPos[j]] = j + 1;

      // Generate islands one by one
      if (j < numContinents)    // Continents first
      {
        islandSize = contSize;
      }
      else
       islandSize = random.nextInt(maxSize) + 1;
      iSize = 0;
      //System.out.println("Island: "+j+" Size "+islandSize+
      // " Start "+startPos[j]);
      i = 0;
      while (i < islandSize)
      {
        for (k = 0;k < 16;k++)
         choice[k] = 0;
          // Find adjacent 8 locations. Store in loc[k].
          // Store content of these squares in adjacent[k]
        FindAdjacent(j,startPos[j]);
          // Find squares two away from start position
          // Sore these in adjacent2
        FindAdjacent2(j);
          // Select locations nearer or further to the original land square
          // depending on strategy
        boolean isNearest;
        int strategy;
        int boundary;
        if (j < numContinents)
         boundary = 20;
        else
         boundary = 10;
        strategy = random.nextInt(100);
        if (strategy >= boundary)
        {
          dist = (float)9999.0;
          isNearest = true;
        }
        else
        {
          dist = -1;
          isNearest = false;
        }
        int early,before,centre,after,late;
        boolean OK;
        iCount = 0;
        m = 0;
        k = 0;
        while (k < 8)
        {
          OK = false;
          if (k%2 == 0)       // Even k (centre squares)
          {
            if (k == 0)
            {
              before = 15;
              centre = 0;
              after = 1;
            }
            else
            {
              before = 2*k - 1;
              centre = before + 1;
              after = centre + 1;
            }
            if (adjacent[k] == 0)     // Sea
            {
              if ((distance2[centre] > distance[k] && adjacent2[centre] == 0) ||
                (distance2[centre] <= distance[k]))
              {
                if ((distance2[before] > distance[k] && adjacent2[before] == 0) ||
                  (distance2[before] <= distance[k]))
                {
                  if ((distance2[after] > distance[k] && adjacent2[after] == 0) ||
                    (distance2[after] <= distance[k]))
                  {
                    OK = true;
                  }
                }
              }
            }
          }
          else              // Odd k (corner squares)
          {
            if (k == 7)
            {
              early = 12;
              before = 13;
              centre = 14;
              after = 15;
              late = 0;
            }
            else
            {
              early = 2*(k - 1);
              before = early + 1;
              centre = before + 1;
              after = centre + 1;
              late = after + 1;
            }
            if (adjacent[k] == 0)
            {
              if ((distance2[centre] > distance[k] && adjacent2[centre] == 0) ||
                (distance2[centre] <= distance[k]))
              {
                if ((distance2[before] > distance[k] && adjacent2[before] == 0) ||
                  (distance2[before] <= distance[k]))
                {
                  if ((distance2[after] > distance[k] && adjacent2[after] == 0) ||
                    (distance2[after] <= distance[k]))
                  {
                    if ((distance2[early] > distance[k] && adjacent2[early] == 0) ||
                      (distance2[early] <= distance[k]))
                    {
                      if ((distance2[late] > distance[k] && adjacent2[late] == 0) ||
                        (distance2[late] <= distance[k]))
                      {
                        OK = true;
                      }
                    }
                  }
                }
              }
            }
          }
          if (OK)
          {
            //if (dist < avDist)
            // dist = avDist;
            if (isNearest)
            {
              if (distance[k] < dist)
              {
                dist = distance[k];
                iCount = 1;
                choice[0] = loc[k];
                m = 0;
              }
              else
              if (distance[k] == dist)
              {
                iCount++;
                m++;
                choice[m] = loc[k];
              }
            }
            else
            {
              if (distance[k] > dist)
              {
                dist = distance[k];
                iCount = 1;
                choice[0] = loc[k];
                m = 0;
              }
              else
              if (distance[k] == dist)
              {
                iCount++;
                m++;
                choice[m] = loc[k];
              }
            }
          }
          k += 1;
        }
        if (iCount == 0)    // No choices. Relax condition and try again
        {
            // Count number of adjacent sea locations
          m = 0;
          for (k = 0;k < 8;k++)
          {
            if (adjacent[k] == 0)    // Sea
            {
              choice[m] = loc[k];
              m++;
              iCount++;
            }
          }
        }
        if (iCount == 0)    // No choices. Relax condition more and try again
        {
            // Count number of sea locations two squares away
          m = 0;
          for (k = 0;k < 16;k++)
          {
            if (adjacent2[k] == 0)    // Sea
            {
              choice[m] = loc2[k];
              m++;
              iCount++;
            }
          }
        }
        if (iCount == 0)
        {
          int loc;
          int times;
            // Randomly choose adjacent2 square not a corner
          m = random.nextInt(12);
          if (m < 3)  // Choose adjacent2[0] and go north until sea
          {
            loop = true;
            times = 0;
            loc = loc2[0];
            while (loop)
            {
              times++;
              if (times == mapHeight)
               break;
              loc -= mapHeight;
              if (loc < 0)
              {
                loc += world;
              }
              if (map[0][loc] == 0)
               loop = false;
            }
            if (times < mapHeight)
            {
              choice[0] = loc;
              iCount = 1;
            }
            else
             iCount = 0;
          }
          else
          if (m < 6)  // Choose adjacent2[4] and go east until sea
          {
            loop = true;
            times = 0;
            loc = loc2[4];
            while (loop)
            {
              times++;
              if (times == mapHeight)
               break;
              iThisRow = loc/mapWidth;
              loc++;
              iNextRow = loc/mapWidth;
              if (iNextRow > iThisRow)
              {
                loc -= mapWidth;
              }
              if (map[0][loc] == 0)
               loop = false;
            }
            if (times < mapHeight)
            {
              choice[0] = loc;
              iCount = 1;
            }
            else
             iCount = 0;
          }
          else
          if (m < 9)  // Choose adjacent2[8] and go south until sea
          {
            loop = true;
            times = 0;
            loc = loc2[8];
            while (loop)
            {
              times++;
              if (times == mapHeight)
               break;
              loc += mapHeight;
              if (loc >= world )
              {
                loc -= world;
              }
              if (map[0][loc] == 0)
               loop = false;
            }
            if (times < mapHeight)
            {
              choice[0] = loc;
              iCount = 1;
            }
            else
             iCount = 0;
          }
          else
          if (m < 12) // Choose adjacent2[12] and go west until sea
          {
            loop = true;
            times = 0;
            loc = loc2[12];
            while (loop)
            {
              times++;
              if (times == mapHeight)
               break;
              iThisRow = loc/mapWidth;
              loc--;
              iNextRow = loc/mapWidth;
              if (iNextRow < iThisRow || loc < 0)
              {
                loc += mapWidth;
              }
              if (map[0][loc] == 0)
               loop = false;
            }
            if (times < mapHeight)
            {
              choice[0] = loc;
              iCount = 1;
            }
            else
             iCount = 0;
          }
        }
        if (iCount == 0)    // No choices. Exit island creation
        {
          System.out.println("Break - no squares can be found");
          break;
        }
          // Only 1 choice, choose this one
        else
        if (iCount == 1)
        {
          iSize++;
          map[0][choice[0]] = 1;
          startPos[j] = choice[0];
          nationMap[startPos[j]] = j + 1;
        }
          // Greater than 1 choice, randomly pick 1
        else
        {
          m = random.nextInt(iCount);
          iSize++;
          map[0][choice[m]] = 1;
            // Some probability of returning to previous location
            // providing that square has an adjacent sea square
          //if (rand()%iCount == 0)
          //if (isNearest)
          startPos[j] = choice[m];
          nationMap[startPos[j]] = j + 1;
        }
        i++;
      }
      //System.out.println("Island: "+j+" Actual Size "+iSize);
    }

    return modifyLand();
  }

}
