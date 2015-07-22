/***************************************
* CWorld
* Author: Martin Adams
****************************************
* Create all world objects and 
* test for collisions
****************************************/

import com.sun.j3d.utils.geometry.*;
import com.sun.j3d.utils.image.TextureLoader;

import javax.media.j3d.*;
import javax.vecmath.*;
import java.net.URL;
import java.lang.Math;

public class CWorld
{
  private static final float LARGE_WALL_DISTANCE = 10.0f; // 10 cm

  private BranchGroup     parent       = null;
  private TransformGroup  worldTG      = new TransformGroup();
	private Canvas3D        parentCanvas = null;
	private CMaze           maze         = null;
	private CWorldListener  listener     = null;
	private String          appPath      = "";
	
	// Collision detection for the room
	private float roomX     = 0.0f;
	private float roomZ     = 0.0f;
	private float roomWidth = 0.0f;
	private float roomDepth = 0.0f;
	
	// Collision detection for the table
	private float   tableCentrePointX = 0.0f;
	private float   tableCentrePointZ = 0.0f;
	private float   tableRadius       = 0.0f;
	private boolean bOnTable          = false;

  public CWorld(BranchGroup parent, Canvas3D canvas, CWorldListener l, String appPath)
  {
		// Store the parameters into their respective global variables
    this.parent = parent;
		this.parentCanvas = canvas;
		this.listener = l;
		this.appPath = appPath;

		// Allow the world TG's transform to read and write
    worldTG.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
    worldTG.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);

		// Add the world TG to the universe
    parent.addChild(worldTG);

		// Create a new instance of the 3D maze object (this does not create the maze itself)
		maze = new CMaze(175.0f, 100.0f, 175.0f, 150.0f, 10.0f, 150.0f, canvas, appPath);

    // Create the world objects
		createWorld();
  }

  public void processMovement(Vector3f position)
	{
		// This function returns whether the specified position has activated any collision detection
		// or event such as enter/exit the table area
		
		// Check to see if the user is outside the room area
		if(outsideRoom(position))
		{
			// Call the onCollisionDetect function with the updated position
			listener.onCollisionDetect(position);
			return;
		}
		
		// Check to see if the user has moved on or off the table
    checkTableTransition(position);
		
		// Only check for maze collision when on the table
		if(bOnTable)
		{
		  // Check the maze collision detection
			if(maze.checkCollisionDetection(position))
			{
			// Call the onCollisionDetect function with the updated position
			  listener.onCollisionDetect(position);
				return;
			}
		}
	}
	
	private void checkTableTransition(Vector3f position)
	{
		if(bOnTable)
		{
			// Check to see if the user is outside the table radius
			if (distanceBetween2Points(position.x, position.z, tableCentrePointX, tableCentrePointZ) > tableRadius)
			{
				bOnTable = false;
				listener.onExitTable();
			}
		}
		else
		{
			// Check to see if the user is inside the table radius
			if (distanceBetween2Points(position.x, position.z, tableCentrePointX, tableCentrePointZ) < tableRadius)
			{
				bOnTable = true;
				listener.onEnterTable();
			}
		}
	}
	
	private float distanceBetween2Points(float x1, float y1, float x2, float y2)
	{
		// Return the distance between the two points using pythagoras
		return (float)(Math.sqrt(((x2-x1)*(x2-x1)) + ((y2-y1)*(y2-y1))));
	}
	
	
	private boolean outsideRoom(Vector3f position)
	{
		// This function checks to see if the user's position is outside the room boundaries
	  boolean bCollide = false;

		// Test to see if the user has tried to exit the room along the x axis
		if(position.x < roomX + LARGE_WALL_DISTANCE)
		{
			position.x = roomX + LARGE_WALL_DISTANCE;
			bCollide = true;
		}
		else if(position.x > roomX + roomWidth - LARGE_WALL_DISTANCE)
		{
			position.x = roomX + roomWidth - LARGE_WALL_DISTANCE;
			bCollide = true;
		}
		
		// Test to see if the user has tried to exit the room along the z axis
		if(position.z < roomZ + LARGE_WALL_DISTANCE)
		{
		  position.z = roomZ + LARGE_WALL_DISTANCE;
			bCollide = true;
		}
		else if(position.z > roomZ + roomDepth - LARGE_WALL_DISTANCE)
		{
		  position.z = roomZ + roomDepth - LARGE_WALL_DISTANCE;
			bCollide = true;
		}
		
		return bCollide;
	}

  public void createWorld()
  {
    // Create a 3D cube for the time being
		worldTG.addChild(createRoom(0.0f,0.0f,0.0f,500.0f,300.0f,700.0f));
		worldTG.addChild(createTable(250.0f, 0.0f, 250.0f, 200.0f, 100.0f));
		worldTG.addChild(createLights());
		worldTG.addChild(maze.generateMaze());
  }
	
	private TransformGroup createTable(float x, float y, float z, float diameter, float height)
	{
		// Create the TGs for the table sections
	  TransformGroup tableTop = new TransformGroup();
		TransformGroup tableLeg = new TransformGroup();
		TransformGroup tableBase = new TransformGroup();
		
		// Store the table properties for detection for when user enters/exits the table
		this.tableCentrePointX = x;
		this.tableCentrePointZ = z;
		this.tableRadius       = diameter / 2;
		
		// Generate an appearance for this shape
    Color3f ambientColour  = new Color3f(0.2f, 0.2f, 0.2f); // dark grey
		Color3f diffuseColour  = new Color3f(1.0f, 1.0f, 1.0f); // white
		Color3f specularColour = new Color3f(0.2f, 0.2f, 0.2f); // dark grey
		Color3f emissiveColour = new Color3f(0.0f, 0.0f, 0.0f); // black
			
		// Create a material for the appearance
		Material material = new Material(ambientColour, emissiveColour,
		                          diffuseColour, specularColour, 5.0f);	

		// Create the object's appearance and load the wood texture
		Appearance appearance = new Appearance();
		appearance.setMaterial(material);
		appearance.setTexture(loadTexture("textures/pinewood_128.jpg"));
		
		// Set the texture's attributes to blend with the material properties
		TextureAttributes texAttributes = new TextureAttributes();
		texAttributes.setTextureMode(TextureAttributes.MODULATE);

		// Scale the texture to fit on the surface of the table 2x2
		Transform3D scaleTex = new Transform3D();
		scaleTex.setScale(2);
		texAttributes.setTextureTransform(scaleTex);
		
		// Set the textures attributes to the appearance
		appearance.setTextureAttributes(texAttributes);
		
		// Add a cylinder as the table top
		tableTop.addChild(new Cylinder(diameter / 2, 5.0f, Cylinder.GENERATE_NORMALS | Cylinder.GENERATE_TEXTURE_COORDS, 30, 30, appearance));
		
		// Move the table top to the top of the leg
		Transform3D change = new Transform3D();
		change.set(new Vector3f(0.0f, height / 2, 0.0f));
		tableTop.setTransform(change);
		
		// Create the leg
		tableLeg.addChild(new Cylinder(7.0f, height, Cylinder.GENERATE_NORMALS | Cylinder.GENERATE_TEXTURE_COORDS, 10, 10, appearance));
		tableLeg.addChild(tableTop);
		
		// Move the table leg and top into position
		change.set(new Vector3f(0.0f, height / 2, 0.0f));
		tableLeg.setTransform(change);
		
		// Create the base
		tableBase.addChild(new Cylinder(50.0f, 5.0f, Cylinder.GENERATE_NORMALS | Cylinder.GENERATE_TEXTURE_COORDS, 20, 20, appearance));
		tableBase.addChild(tableLeg);
		
		// Move the entire table into position
		change.set(new Vector3f(x, y, z));
		tableBase.setTransform(change);
		
		return tableBase;
	}
	
	public TransformGroup createLights()
	{
		// Create a light TG to store all the lights into
	  TransformGroup lights = new TransformGroup();
		
		// Set the lights bounding area to everywhere
		BoundingSphere boundingSphere = new BoundingSphere(
				new Point3d(0.0,0.0,0.0), Double.POSITIVE_INFINITY);
		
		// Create an ambient light at 40%
		Color3f ambientColour = new Color3f(0.4f, 0.4f, 0.4f);
		AmbientLight ambientLight = new AmbientLight(ambientColour);
		ambientLight.setInfluencingBounds(boundingSphere);
		lights.addChild(ambientLight);
		
		// Setup a first directional light
		Color3f directionalColour = new Color3f(1.0f, 1.0f, 1.0f);
		Vector3f direction = new Vector3f(0.2f, 0.6f, 0.4f);
		DirectionalLight directionalLight = new DirectionalLight(directionalColour, direction);
		directionalLight.setInfluencingBounds(boundingSphere);
		lights.addChild(directionalLight);
		
		// Setup a second directional light
		Color3f directionalColour2 = new Color3f(0.6f, 0.6f, 0.6f);
		Vector3f direction2 = new Vector3f(-0.2f, -0.6f, -0.4f);
		DirectionalLight directionalLight2 = new DirectionalLight(directionalColour2, direction2);
		directionalLight2.setInfluencingBounds(boundingSphere);
		lights.addChild(directionalLight2);

		// Return the lights TG		
		return lights;
	}
	
	public TransformGroup createRoom(float x, float y, float z, float width, float height, float depth)
	{
		// Store the collision detection details globally about the room
		this.roomX     = x;
		this.roomZ     = z;
		this.roomWidth = width;
		this.roomDepth = depth;
	
		// Create 3 indexed arrays for the walls, floor and ceiling
		IndexedQuadArray wallsShape = new IndexedQuadArray(8, IndexedQuadArray.COORDINATES | IndexedQuadArray.NORMALS |
																												 IndexedQuadArray.TEXTURE_COORDINATE_2, 16);
		IndexedQuadArray floorShape = new IndexedQuadArray(8, IndexedQuadArray.COORDINATES | IndexedQuadArray.NORMALS |
																												 IndexedQuadArray.TEXTURE_COORDINATE_2, 4);
		IndexedQuadArray roofShape = new IndexedQuadArray(8, IndexedQuadArray.COORDINATES | IndexedQuadArray.NORMALS |
		                                                     IndexedQuadArray.TEXTURE_COORDINATE_2, 4);
		
		// Specify the room coordinates for the 8 points
		Point3f[] shapeCoordinates = {
			new Point3f(x, y, z),
			new Point3f(x + width, y, z),
			new Point3f(x + width, y + height, z),
			new Point3f(x, y + height, z),
			new Point3f(x, y, z + depth),
			new Point3f(x + width, y, z + depth),
			new Point3f(x + width, y + height, z + depth),
			new Point3f(x, y + height, z + depth)			
		};
		
		// Specify the wall surfaces
		int wallsCoordIndices[] = {
		  0, 1, 2, 3,	// back wall
			1, 5, 6, 2, // right wall
			5, 4, 7, 6, // front wall
			4, 0, 3, 7  // left wall
		};
		
		// Specify the ceiling surfaces
		int roofCoordIndices[] = {
		  2, 6, 7, 3 // roof
		};
		
		// Specify the floor surfaces
		int floorCoordIndices[] = {
		  0, 4, 5, 1  // floor
		};
		
		// Specify the wall normals
		Vector3f[] wallsNormals = {
			new Vector3f( 0.0f, 0.0f, -1.0f), // z netagive - back wall
			new Vector3f( 1.0f, 0.0f,  0.0f), // x positive - right wall
			new Vector3f( 0.0f, 0.0f,  1.0f), // z positive - front wall
			new Vector3f(-1.0f, 0.0f,  0.0f)  // x negative - left wall
		};
		
		// Specify the ceiling normals
		Vector3f[] roofNormals = {
			new Vector3f(0.0f, 1.0f, 0.0f) // y positive - roof
		};
		
		// Specify the floor normals
		Vector3f[] floorNormals = {
			new Vector3f(0.0f, -1.0f, 0.0f) // y negative - floor
		};
		
		// Attach the wall normals to each wall point
		int wallsNormalIndices[] =
		{
			0,0,0,0,
			1,1,1,1,
			2,2,2,2,
			3,3,3,3
		};
		
		// Attach the ceiling normals to each ceiling point
		int roofNormalIndices[] =
		{
		  0,0,0,0
		};
		
		// Attach the floor normals to each floor point
		int floorNormalIndices[] =
		{
		  0,0,0,0
		};
		
		// Specify the wall texture coordiantes		
		TexCoord2f wallsTexCoords[] = {
			new TexCoord2f(0.0f, 0.0f),	// bottom left
			new TexCoord2f(7.0f, 0.0f), // bottom right, 7 along the x
			new TexCoord2f(7.0f, 5.0f), // top right, 7 along the x, 5 in the y
			new TexCoord2f(0.0f, 5.0f)  // top left, 5 in the y
		};
		
		// Apecify the texture coordinates for the floor and ceiling
		TexCoord2f vertTexCoords[] = {
			new TexCoord2f(0.0f, 0.0f), // bottom left
			new TexCoord2f(5.0f, 0.0f), // bottom right x5
			new TexCoord2f(5.0f, 5.0f), // top right x5
			new TexCoord2f(0.0f, 5.0f), // top left x5
		};
		
		// Attach the wall coordinates to the wall points
		int texWallCoordIndices[] =
		{
			0, 1, 2, 3,	// back wall
			0, 1, 2, 3, // right wall
			0, 1, 2, 3, // front wall
			0, 1, 2, 3 // left wall
		};
		
		// Attach the floor and ceiling coordinates to the floor and ceiling points
		int texVertCoordIndices[] =
		{
		  0, 1, 2, 3
		};
		
		// Create the walls based on the above points, normals and texture coordinates
		wallsShape.setCoordinates(0, shapeCoordinates);
		wallsShape.setCoordinateIndices(0, wallsCoordIndices);
		wallsShape.setNormals(0, wallsNormals);
		wallsShape.setNormalIndices(0, wallsNormalIndices);
		wallsShape.setTextureCoordinates(0, 0, wallsTexCoords);
		wallsShape.setTextureCoordinateIndices(0, 0, texWallCoordIndices);
		
		// Create the floor based on the above points, normals and texture coordinates
		floorShape.setCoordinates(0, shapeCoordinates);
		floorShape.setCoordinateIndices(0, floorCoordIndices);
		floorShape.setNormals(0, floorNormals);
		floorShape.setNormalIndices(0, floorNormalIndices);
		floorShape.setTextureCoordinates(0, 0, vertTexCoords);
		floorShape.setTextureCoordinateIndices(0, 0, texVertCoordIndices);
		
		// Create the roof based on the above points, normals and texture coordinates
		roofShape.setCoordinates(0, shapeCoordinates);
		roofShape.setCoordinateIndices(0, roofCoordIndices);
		roofShape.setNormals(0, roofNormals);
		roofShape.setNormalIndices(0, roofNormalIndices);
		roofShape.setTextureCoordinates(0, 0, vertTexCoords);
		roofShape.setTextureCoordinateIndices(0, 0, texVertCoordIndices);
				
		// Generate the surface material for the room
    Color3f ambientColour = new Color3f(0.2f, 0.2f, 0.2f); // dark grey
		Color3f diffuseColour = new Color3f(1.0f, 1.0f, 1.0f); // white
		Color3f specularColour = new Color3f(0.2f, 0.2f, 0.2f); // dark grey
		Color3f emissiveColour = new Color3f(0.0f, 0.0f, 0.0f); // black
		
		Material material = new Material(ambientColour, emissiveColour,
		                       diffuseColour, specularColour, 5.0f);	

		// Set the walls appearance loading the brick texture
		Appearance wallsAppearance = new Appearance();
		wallsAppearance.setMaterial(material);
		wallsAppearance.setTexture(loadTexture("textures/brick_128.jpg"));

		// Set the floor appearance loading the floor texture
		Appearance floorAppearance = new Appearance();
		floorAppearance.setMaterial(material);
		floorAppearance.setTexture(loadTexture("textures/wood_floor_128.jpg"));
		
		// Set the ceiling appearance loading the roof texture
		Appearance roofAppearance = new Appearance();
		roofAppearance.setMaterial(material);
		roofAppearance.setTexture(loadTexture("textures/roof_128.jpg")); 
		
		// Set the texture attributes to work with the surface material
		TextureAttributes texAttributes = new TextureAttributes();
		texAttributes.setTextureMode(TextureAttributes.MODULATE);
		wallsAppearance.setTextureAttributes(texAttributes);
		floorAppearance.setTextureAttributes(texAttributes);
		
		// Make sure the walls are flat shaded to react to lights
		ColoringAttributes colAttrib = new ColoringAttributes(0.0f, 0.0f, 1.0f, ColoringAttributes.SHADE_FLAT);
		wallsAppearance.setColoringAttributes(colAttrib);		
		floorAppearance.setColoringAttributes(colAttrib);
			
		// Create the actual shapes and add them to the room TG
		TransformGroup tg = new TransformGroup();
		tg.addChild(new Shape3D(wallsShape, wallsAppearance));
		tg.addChild(new Shape3D(floorShape, floorAppearance));
		tg.addChild(new Shape3D(roofShape, roofAppearance));
		
		return tg;
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
}