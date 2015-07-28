/***************************************
* CMaze
* Author: Martin Adams
****************************************
* Create a 3D maze and test for 
* collisions
****************************************/

import com.sun.j3d.utils.image.TextureLoader;

import javax.media.j3d.*;
import javax.vecmath.*;
import java.net.URL;

class CMaze
{
  private static final float SMALL_WALL_DISTANCE = 2.0f; // 2cm
	
	// Store the application path to load the texutre
	private String   appPath      = "";
	// Store the canvas object to assist loading the texture
  private Canvas3D parentCanvas = null;
	
	// Store the maze's position and dimensions
	private float posX = 0;
	private float posY = 0;
	private float posZ = 0;
	private float scaleWidth = 0;
	private float scaleHeight = 0;
	private float scaleDepth = 0;

	// Define the maze	
	private static final int mazeDef[] = {
		0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
		0,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,0,
		0,1,0,0,0,0,0,0,1,0,0,0,0,0,0,1,0,0,1,0,
		0,1,0,1,1,1,1,1,1,0,1,1,1,1,0,1,0,1,1,0,
		0,1,0,0,0,0,0,0,0,0,0,0,0,1,1,1,0,1,1,0,
		0,1,1,1,0,1,1,1,1,1,1,1,0,0,1,0,0,0,1,0,
		0,1,0,1,0,1,0,1,0,0,0,1,0,0,1,0,1,0,1,0,
		0,1,0,1,1,1,0,1,0,1,0,1,1,0,1,1,1,0,1,0,
		0,1,0,0,0,0,0,0,0,1,0,1,0,0,0,0,0,0,1,0,
		0,1,1,0,1,1,1,1,1,1,0,1,0,1,1,1,1,1,1,0,
		0,1,0,0,1,0,0,0,0,0,0,1,0,0,0,0,1,0,1,0,
		0,1,0,1,1,0,1,0,1,0,1,1,1,1,0,1,1,0,1,0,
		0,1,0,0,0,0,1,0,1,0,0,0,0,0,0,0,0,0,1,0,
		0,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,1,1,0,
		0,1,1,0,1,0,1,0,0,0,0,0,0,0,0,0,0,0,1,0,
		0,1,0,0,1,0,0,0,1,1,1,1,1,0,1,1,1,0,1,0,
		0,1,0,1,1,1,1,0,1,0,0,0,1,0,0,0,1,0,1,0,
		0,1,0,1,0,1,1,0,1,0,1,0,1,1,1,1,1,0,1,0,
		0,1,0,0,0,0,0,0,0,0,1,0,0,0,0,1,0,0,1,0,
		0,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,0,
		0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0
	};
	
	// Set the maze dimensions
	private static final int width = 20;
	private static final int height = 21;
	
	// Store the distance between each maze block
	private float blockWidth = 1.0f;
	private float blockDepth = 1.0f;
		
	// Store the maze object
	private IndexedQuadArray maze = null;
	
	// Store the last valid maze block that the user was in	
	private int lastValidX = 0;
	private int lastValidY = 0;
	
	// Store the coordinate index where the top coordinates start
	private int topStart     = 0;
	private int indexCount   = 0;
	private int normalCount  = 0;
	private int textureCount = 0;
	
	// Store the normals for each surface for the maze
	private static final Vector3f normals[] = {
		new Vector3f( 0.0f,  0.0f,  1.0f), // North facing
		new Vector3f( 0.0f,  0.0f, -1.0f), // South facing
		new Vector3f( 1.0f,  0.0f,  0.0f), // West facing
		new Vector3f(-1.0f,  0.0f,  0.0f), // East facing
		new Vector3f( 0.0f,  1.0f,  0.0f), // Down facing
		new Vector3f( 0.0f, -1.0f,  0.0f), // Up facing
	};
	
	// Store the texture coordinates for each surface
	private static final TexCoord2f textureCoords[] = {
		new TexCoord2f(0.0f, 0.0f), // bottom left
		new TexCoord2f(1.0f, 0.0f), // bottom right
		new TexCoord2f(1.0f, 1.0f), // top right
		new TexCoord2f(0.0f, 1.0f)  // top left
	};

  public CMaze(float x, float y, float z, float width, float height, float depth, Canvas3D canvas, String appPath)
	{
		// Set the global values to the parameters
		this.posX         = x;
		this.posY         = y;
		this.posZ         = z;
		this.scaleWidth   = width;
		this.scaleHeight  = height;
		this.scaleDepth   = depth;
		this.parentCanvas = canvas;
		this.appPath      = appPath;
		
		// Calculate the block width (the distance between points)
		this.blockWidth = (this.scaleWidth / this.width);
		this.blockDepth = (this.scaleDepth / this.height);
		
		// Store the array starting point where coordinate indexes for the higher point start
		this.topStart = (this.height * (this.width + 1)) + this.width + 1;
	}
	
	public TransformGroup generateMaze()
	{
		TransformGroup tg = new TransformGroup();

		// Create the IndexedQuadArray object ready for defining the points and surfaces
		maze = new IndexedQuadArray((width + 1)*(height + 1)*2, IndexedQuadArray.COORDINATES | IndexedQuadArray.NORMALS |
		 		IndexedQuadArray.TEXTURE_COORDINATE_2, (getSurfaceCount() * 4));

		// Generate all the possible coordinates that could be used in this maze		
		generateCoordinates();
		
		// Set the normals for the maze
		maze.setNormals(0, normals);
		
		// Set the texture coordinates for the maze
		maze.setTextureCoordinates(0, 0, textureCoords);
		
		// Generate all the surfaces that build up the maze walls
		generateSurfaces();
		
		// Create an appearance for this maze
		Appearance mazeAppearance = new Appearance();
		
		// Set the material properties
    Color3f ambientColour = new Color3f(0.2f, 0.2f, 0.2f); // dark grey
		Color3f diffuseColour = new Color3f(1.0f, 1.0f, 1.0f); // white
		Color3f specularColour = new Color3f(0.0f, 0.0f, 0.0f); // white
		Color3f emissiveColour = new Color3f(0.0f, 0.0f, 0.0f); // black
			
		Material material = new Material(ambientColour, emissiveColour,
		                       diffuseColour, specularColour, 0.0f);	

		// Set the maze material and load the grid texture
		mazeAppearance.setMaterial(material);
		mazeAppearance.setTexture(loadTexture("textures/grid_128.jpg"));
		
		// Set the texture properties to work with the material properties
		TextureAttributes texAttributes = new TextureAttributes();
		texAttributes.setTextureMode(TextureAttributes.MODULATE);
		mazeAppearance.setTextureAttributes(texAttributes);
		
		// Make sure the surfaces are flat shaded to work with the lights
		ColoringAttributes colAttrib = new ColoringAttributes(0.0f, 0.0f, 1.0f, ColoringAttributes.SHADE_FLAT);
		mazeAppearance.setColoringAttributes(colAttrib);	
		
		// Add the newly generated maze the the transform group		
		tg.addChild(new Shape3D(maze, mazeAppearance));
		
		// Move the maze into position
		Transform3D move = new Transform3D();
		move.set(new Vector3f(this.posX, this.posY, this.posZ));
		tg.setTransform(move);
		
		// Return the maze in the TG
		return tg;
	}
	
	private void generateSurfaces()
	{
		// This function loops through each maze block and generates the necessary top, right and bottom surfaces		
		
		int x = 0;
		int y = 0;
		
		// Loop through the maze rows
		for(y = 0; y < height; y++)
		{
			// Loop through the maze columns for this row
			for(x = 0; x < width; x++)
			{
				// Make sure we are not at the right edge
				if (x + 1 < width && y + 1 < height)
				{
					if(mazeDef[(y*width)+x] == 0) // currently no block
					{
						if(mazeDef[(y*width) + (x+1)] == 1) // the one to the right is a block, draw wall
						{
							drawWestFacingWall(x+1,y);
						}
						if(mazeDef[((y+1)*width) + x] == 1) // the one to the bottom is a block, draw wall
						{
							drawNorthFacingWall(x,y+1);
						}
					}
					else // there is a block here
					{
						if(mazeDef[(y*width) + (x+1)] == 0) // the one to the right is no block, draw wall
						{
							drawEastFacingWall(x,y);
						}
						if(mazeDef[(((y+1)*width) + x)] == 0) // there is none to the bottom, draw wall
						{
							drawSouthFacingWall(x,y);
						}
						// Draw the top of this block
						drawBlockTopSurface(x,y);
					}
				}
			}
		}
	}
	
	private int getSurfaceCount()
	{
		// This funciton is similar to generateSurfaces() except it only counts how many surfaces
		// will be required to create the completed maze
		
		int count = 0;
		int x     = 0;
		int y     = 0;
		
		// Loop through the maze rows
		for(y = 0; y < height; y++)
		{
			// Loop through the maze columns for this row
			for(x = 0; x < width; x++)
			{
				// Make sure we are not at the right edge
				if (x + 1 < width && y + 1 < height)
				{
					if(mazeDef[(y*width)+x] == 0) // currently no block
					{
						if(mazeDef[(y*width) + (x+1)] == 1) // the one to the right is a block, draw wall
						{
							count++;
						}
						if(mazeDef[((y+1)*width) + x] == 1) // the one to the bottom is a block, draw wall
						{
							count++;
						}
					}
					else // there is a block here
					{
						if(mazeDef[(y*width) + (x+1)] == 0) // the none to the right is no block, draw wall
						{
							count++;
						}
						if(mazeDef[(((y+1)*width) + x)] == 0) // there is none to the bottom, draw wall
						{
							count++;
						}
						// Draw the top of this block
						count++;
					}
				}
			}
		}
		
		// Return the number of surfaces there were
		return count;
	}
	
	private void generateCoordinates()
	{
		// This function generates all the possible coordinates that could be used to
		// create the maze.  These coordinates will then be indexed to define the
		// required surfaces.
	
		int x          = 0;
		int y          = 0;
		int indexPoint = 0;
		
		// Loop through each edge in the row
		for(y = 0; y <= height; y++)
		{
			// Loop through each edge in the column for this row
			for(x = 0; x <= width; x++)
			{
				// Define the coordinate for this point in the x,y maze
				maze.setCoordinate(indexPoint, new Point3f(x * this.blockWidth, 0.0f, y * this.blockDepth));
				indexPoint++;
			}
		}

		// Repeat the above routine except position the coordinates higher in the Y axis
		for(y = 0; y <= height; y++)
		{
			for(x = 0; x <= width; x++)
			{
				maze.setCoordinate(indexPoint, new Point3f(x * this.blockWidth, this.scaleHeight, y * this.blockDepth));
				indexPoint++;
			}
		}
	}
	
	private void drawBlockTopSurface(int x, int y)
	{
		// This function creates a horizontal surface
		int p1 = topStart + ((y + 1) * (width + 1)) + x;
		int p2 = p1 + 1;
		int p3 = topStart + (y * (width + 1)) + x + 1;
		int p4 = p3 - 1;

    drawSurface(p1, p2, p3, p4);
		addNormals(5); // Up facing
	}
	
	private void drawNorthFacingWall(int x, int y)
	{
		// This function creates a surface facing up
		int p1 = (y * (width + 1)) + x + 1;
		int p2 = p1 - 1;
		int p3 = p2 + topStart;
		int p4 = p3 + 1;

    drawSurface(p1, p2, p3, p4);
		addNormals(0); // North facing
	}
	
	private void drawSouthFacingWall(int x, int y)
	{
		// This function creates a surface facing down
		int p1 = ((y + 1) * (width + 1)) + x;
		int p2 = p1 + 1;
		int p3 = p2 + topStart;
		int p4 = p3 - 1;
		
        drawSurface(p1, p2, p3, p4);
		addNormals(1); // South facing
	}
	
	private void drawEastFacingWall(int x, int y)
	{
		// This function creates a surface facing right
		int p1 = ((y + 1) * (width + 1)) + x + 1;
		int p2 = (y * (width + 1)) + x + 1;
		int p3 = p2 + topStart;
		int p4 = p1 + topStart;

		drawSurface(p1, p2, p3, p4);
		addNormals(3); // East facing
	}
	
	private void drawWestFacingWall(int x, int y)
	{
		// This function creates a surface facing left
		int p1 = (y * (width + 1)) + x;
		int p2 = ((y + 1) * (width + 1)) + x;
		int p3 = p2 + topStart;
		int p4 = p1 + topStart;

		drawSurface(p1, p2, p3, p4);
		addNormals(2); // West facing
	}
	
	private void drawSurface(int p1, int p2, int p3, int p4)
	{
		// This function joins the 4 points together to create a quad surface
    maze.setCoordinateIndex(indexCount, p1);
		indexCount++;
		maze.setCoordinateIndex(indexCount, p2);
		indexCount++;
		maze.setCoordinateIndex(indexCount, p3);
		indexCount++;
		maze.setCoordinateIndex(indexCount, p4);
		indexCount++;
		
		// Add the texture coordinate for each point in this surface
		for(int coordIndex = 0; coordIndex < 4; coordIndex++)
		{
		  maze.setTextureCoordinateIndex(0, textureCount, coordIndex);
			textureCount++;
		}
	}
	
	private void addNormals(int index)
	{
		// This function adds the correct normal for each point in this surface
		for(int count = 0; count < 4; count++)
		{
			maze.setNormalIndex(normalCount, index);
			normalCount++;
		}
	}

  private Texture2D loadTexture(String filename)
	{
		TextureLoader loader = null;
		
		// See whether to get the file from the web or from the local path
		if(appPath.length() > 0)
		{
			// Load the texture from a URL
			URL path = null;
			
			try
			{
				path = new URL(appPath + filename);
			}
			catch(Exception e) {}

		  // Download from the web
			loader = new TextureLoader(path, parentCanvas);
		}
		else
		{
			// Load from the local drive
			loader = new TextureLoader(filename, parentCanvas);
		}
		
		// Get the image from the TextureLoader
		ImageComponent2D image = loader.getImage();
		
		// Set the texture's properties
		Texture2D texture = new Texture2D(Texture.BASE_LEVEL, Texture.RGB, image.getWidth(), image.getHeight());
		texture.setImage(0, image);
		
		// Return th etexture
		return texture;
	}
	
	public boolean checkCollisionDetection(Vector3f position)
	{
		// This function tests the specified vector and sees if it collides with any of the maze walls
		boolean bXCollision = false;
		boolean bZCollision = false;
		
		// First make sure the user is within the maze grid
		if(position.x > posX && position.x < posX + scaleWidth &&
		   position.z > posZ && position.z < posZ + scaleDepth)
		{
			// Check if there is a collision in the X direction
			bXCollision = hitXWall(position.x + SMALL_WALL_DISTANCE, position);
			if(!bXCollision)
				bXCollision = hitXWall(position.x - SMALL_WALL_DISTANCE, position);
			// Check if there is a collision in the Z direction
			bZCollision = hitYWall(position.z + SMALL_WALL_DISTANCE, position);
			if(!bZCollision)
			  bZCollision = hitYWall(position.z - SMALL_WALL_DISTANCE, position);			
		}
		
		// Store this position as it may be used to place the viewport into
		// if the user collides with a wall on the next check
		int gridX = (int)(((position.x - posX) / scaleWidth) * width);
		int gridY = (int)(((position.z - posZ) / scaleDepth) * height);

		lastValidX = gridX;
		lastValidY = gridY;
		
		// Return whether there was a collision
		return bXCollision | bZCollision;
	}
	
	private boolean hitXWall(float x, Vector3f position)
	{
		// This function tests to see if the position intersects with a block
		// along the X axis.  If it does, it corrects the position to force
		// the user back into a valid block
		
	  boolean bCollision = false;
	  // Convert the coordinate x into a grid value
		int gridX = (int)(((x - posX) / scaleWidth) * width);
		int gridY = (int)(((position.z - posZ) / scaleDepth) * height);

		// Make sure that these coordinates are within the grid
		if(gridX >= width || gridY >= height)
		  return false;
			
		// See if we have collided with a wall
		if(mazeDef[(gridY * width) + gridX] == 1)
		{
			// There has been a collision so the best thing to do is
			// move the viewport to the nearest valid edge
			moveXTo(lastValidX, gridX, position);
			bCollision = true;
		}
		return bCollision;
	}
	
	private boolean hitYWall(float z, Vector3f position)
	{
		// This function tests to see if the position intersects with a block
		// along the Z axis.  If it does, it corrects the position to force
		// the user back into a valid block
	
	  boolean bCollision = false;
	  // Convert the coordinate x into a grid value
		int gridX = (int)(((position.x - posX) / scaleWidth) * width);
		int gridY = (int)(((z - posZ) / scaleDepth) * height);

		// Make sure that these coordinates are within the grid
		if(gridX >= width || gridY >= height)
		  return false;
			
		// See if we have collided with a wall
		if(mazeDef[(gridY * width) + gridX] == 1)
		{
			// There has been a collision so the best thing to do is
			// move the viewport to the nearest valid edge
			moveYTo(lastValidY, gridY, position);
			bCollision = true;
		}
		return bCollision;
	}
	
	private void moveXTo(int toX, int fromX, Vector3f position)
	{
		// This moves the X position into a valid block
		if(toX > fromX) // LHS of toX
		{
			position.x = (((float)toX / width) * scaleWidth) + posX + SMALL_WALL_DISTANCE;
		}
		else // RHS of toX
		{
			position.x = (((float)(toX + 1) / width) * scaleWidth) + posX - SMALL_WALL_DISTANCE;
		}
	}
	
	private void moveYTo(int toY, int fromY, Vector3f position)
	{
		// This moves the Y position into a valid block
		if(toY > fromY) // top of toY
		{
			position.z = (((float)toY / height) * scaleDepth) + posZ + SMALL_WALL_DISTANCE;
		}
		else // bottom of to Y
		{
			position.z = (((float)(toY + 1) / height) * scaleDepth) + posZ - SMALL_WALL_DISTANCE;
		}
	}
}