/***************************************
* CViewport
* Author: Martin Adams
****************************************
* Moves the viewport to a correct 
* locatoin
****************************************/

import javax.media.j3d.*;
import javax.vecmath.*;

public class CViewport
{
	// Store the amount the strength of movement decelerates when
	// the user releases the key from the keyboard
  private static final float MOVE_DECELERATION     = 0.6f;
	private static final float ROTATION_DECELERATION = 0.5f;
	
	// Store the amount the user moves when in a large scale mode
	// or when shrunk to the scale of the maze
	public static final float LARGE_SCALE_MOVEMENT = 1.0f;
	public static final float SMALL_SCALE_MOVEMENT = 0.15f;
	
	// Store the maximum field of view angle and the normal field
	// of view angle used when animating the scale change
	public static final float MAX_FOV    = 2.0f;
	public static final float NORMAL_FOV = 1.0f;
	
	// Store the necessary objects required to manipulate the view
	private View              view           = null;
  private BranchGroup 		  parent         = null;
  private TransformGroup 	  viewFromGroup  = new TransformGroup();
	private TransformGroup    viewPitchGroup = new TransformGroup();
  private ViewPlatform      viewPlatform   = new ViewPlatform();
	private CViewportListener listener       = null;

	// Store the default scale of movement
	private float scaleMovement = LARGE_SCALE_MOVEMENT;
	
	// Forward movement
  private float   mForwardMovement = 0;
  private boolean mMovingForward   = false;
  
	// Sideways movement
	private float   mSidewaysMovement = 0;
	private boolean mMovingSideways   = false;
	
	// Turn movement
  private float   mYawMovement = 0;
  private boolean mMovingYaw   = false;
	
	// Pitch movement
	private float   mPitchMovement = 0;
	private boolean mMovingPitch   = false;
	
	// Store the current position values of where the viewport is
	// relative the centre of teh world
	public float currentX = 0.0f;
	public float currentY = 0.0f;
	public float currentZ = 0.0f;
	public Vector3f currentPosition = new Vector3f();
	
	// Scale values when the user enters/exits the table
	private boolean bScaleViewport   = false;
	private float   scaleFromHeight  = 0.0f;
	private float   scaleToHeight    = 0.0f;
	private long    currentAnimFrame = 0;
	private static final long ANIMATION_LENGTH = 100; // 1 seconds
  
  public CViewport(Canvas3D canvas, BranchGroup parent, CViewportListener l)
  {
    this.parent = parent;
		this.listener = l;

		// Setup the vew platform
    viewPlatform.setCapability(ViewPlatform.ALLOW_LOCAL_TO_VWORLD_READ);
    PhysicalBody body = new PhysicalBody();
    PhysicalEnvironment env = new PhysicalEnvironment();
    
		// Set the view from and pitch transform groups to read/write
		viewFromGroup.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		viewFromGroup.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
    viewPitchGroup.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		viewPitchGroup.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
		
		// Add the view platform the the pitch TG
		viewPitchGroup.addChild(viewPlatform);
		// Add teh pitch TG to the view from group
		viewFromGroup.addChild(viewPitchGroup);
		// Add the view from TG to the world
		parent.addChild(viewFromGroup);

		// Create a enw view
    view = new View();
    view.addCanvas3D(canvas);
    view.attachViewPlatform(viewPlatform);
    view.setPhysicalBody(body);
    view.setPhysicalEnvironment(env);
		
		// Set the view's field of view
		view.setFieldOfView(NORMAL_FOV);
		
		// Set the back clip distance to suit the scale we are working in
		view.setBackClipDistance(300.0);
  }

  public void moveForward(float strength)
  {
		// Set the mode to moving forward and the strength
    mForwardMovement = scaleMovement * strength;
	  mMovingForward   = true;
  }
  
  public void moveForward()
  {
		// Stop moving forward
    mMovingForward = false;
  }
	
	public void moveSideways(float strength)
	{
		// Set the mode to moving sideways and the strength
		mSidewaysMovement = scaleMovement * strength;
		mMovingSideways   = true;
	}
	
	public void moveSideways()
	{
		// Cancel the side stepping
		mMovingSideways = false;
	}
  
  public void moveYaw(float strength)
  {
		// Set the mode to turning left or right and the strength
    mYawMovement = strength;
	  mMovingYaw   = true;
  }
  
  public void moveYaw()
  {
		// Cancel the turning
    mMovingYaw = false;
  }
	
	public void movePitch(float strength)
	{
		// Set the mode to looking up or down and the strength
	  mPitchMovement = strength;
		mMovingPitch   = true;
	}
	
	public void movePitch()
	{
		// Cancel the looking up or down
	  mMovingPitch = false;
	}
	
	public void moveTo(float x, float y, float z)
	{
		// This moves the viewport to a specified position
		Transform3D change = new Transform3D();
		change.set(new Vector3d(x, y, z));
		viewFromGroup.setTransform(change);
	}
  
	public void updateViewport(float elapsedTime)
	{
		// This function updates any change to thew viewport when
		// the each frame is rendered
		
	  boolean bMove        = false;
	  Transform3D change   = new Transform3D();
		Transform3D movement = new Transform3D();
		
		// Store the current position before moving
		//viewFromGroup.getTransform(restorePosition);
	
		// See if there is a scale animation in progress.
		// If so process it and ignore any movment the user
		// is trying to make.
		if(bScaleViewport)
		{
			processScaleAnimation(elapsedTime);
		}
		else
		{
			// See if the viewport needs moving forward
			if(mForwardMovement > 0.05f || mForwardMovement < -0.05f)
			{
				// Decelerate if the user released the key
				if(!mMovingForward) mForwardMovement *= MOVE_DECELERATION;
				
				// Create a new transform value
				movement.set(new Vector3d(0,0,elapsedTime * mForwardMovement));
				
				// Add it to the existing matrix
				viewFromGroup.getTransform(change);
				change.mul(movement);
				viewFromGroup.setTransform(change);
				
				bMove = true;
			}
			
			// See if the viewport needs moving sideways
			if(mSidewaysMovement > 0.05f || mSidewaysMovement < -0.05f)
			{
			  // Decelerate if the user released the key
				if(!mMovingSideways) mSidewaysMovement *= MOVE_DECELERATION;
				
				// Create a new transform value
				movement.set(new Vector3d(elapsedTime * mSidewaysMovement, 0, 0));
				
				// Add it to the existing matrix
				viewFromGroup.getTransform(change);
				change.mul(movement);
				viewFromGroup.setTransform(change);
				
				bMove = true;
			}
			
			// See if the viewport needs rotating about the Y
			if(mYawMovement > 0.001f || mYawMovement < -0.001f)
			{
			  // Decelerate if the user released the key
				if(!mMovingYaw) mYawMovement *= ROTATION_DECELERATION;
			
				// Get the current matrix transformation
				viewFromGroup.getTransform(movement);
				
				// Add the new rotation to this matrix
				change.set(new AxisAngle4d(0, 1, 0, elapsedTime * mYawMovement));
				movement.mul(change);
				viewFromGroup.setTransform(movement);		
			}
			
			// See if the view port needs rotating about the X
			if(mPitchMovement > 0.001f || mPitchMovement < -0.001f)
			{
			  // Decelerate if the user released the key
				if(!mMovingPitch) mPitchMovement *= ROTATION_DECELERATION;
				
				// Get the current matrix transform
				viewPitchGroup.getTransform(movement);
				//viewFromGroup.getTransform(movement);
				
				// Add the new rotaton to this matrix
				change.set(new AxisAngle4d(1, 0, 0, elapsedTime * mPitchMovement));
				movement.mul(change);
				//viewFromGroup.setTransform(movement);
				viewPitchGroup.setTransform(movement);
			}
		}
		
		// If the viewport's position changed then call the parent class's onViewportMove
		// procedture to check for any collisions with world objects
		if(bMove)
		{
			// Get the camera's position
			getPosition();
			listener.onViewportMove(currentPosition);
		}
	}
	
	private void processScaleAnimation(float elapsedTime)
	{
		// This changes the viewport's position for each animation frame when the user enters/exits the table area
	  
		boolean bEnlarge = false;
		
		// See if we are enlarging the viewport
		if(scaleFromHeight < scaleToHeight)
		{
		  bEnlarge = true;
		}
		
		// Add the animation time and test for the last frame of the animation
		currentAnimFrame += (long)elapsedTime;
		if(currentAnimFrame > ANIMATION_LENGTH)
		{
			currentAnimFrame = ANIMATION_LENGTH;
			bScaleViewport = false;
		}
		
		// Move the height of the viewport 
		float percent = (float)currentAnimFrame / (float)ANIMATION_LENGTH;
		float moveTo;
		if(bEnlarge)
		{
			moveTo = scaleFromHeight + (percent * (scaleToHeight - scaleFromHeight));
		}
		else
		{
		  // Reverse the percentage as we are shrinking
			percent = 1 - percent;
			moveTo = scaleToHeight + (percent * (scaleFromHeight - scaleToHeight));
		}
		
		// Move to the new height
		Transform3D change = new Transform3D();
		Vector3f currentPos = new Vector3f();
		
		viewFromGroup.getTransform(change);
		change.get(currentPos);
		
		currentPos.y = moveTo;
		change.setTranslation(currentPos);
		viewFromGroup.setTransform(change);
		
		// Change the FOV through the animation
		float fov;
		if(percent > 0.5)  // keep expanding fov
		{
		  // get the percent between 0 and 1
			fov = (float)(1 - ((percent - 0.5) * 2));
		}
		else // reset fov
		{
		  // get the percent between 0 and 1
			fov = (percent * 2);
		}
		fov = NORMAL_FOV + (fov * (MAX_FOV - NORMAL_FOV));

    view.setFieldOfView(fov);
	}
	
	public void boundMove(Vector3f newPosition)
	{
	  Transform3D restore = new Transform3D();

		// Get the current transformation and only reset the position and not the
		// rotation and scale
		viewFromGroup.getTransform(restore);
		restore.setTranslation(newPosition);
		viewFromGroup.setTransform(restore);
	}
	
	public void getPosition()
	{
		Transform3D xform = new Transform3D();
		
		// Get the transformation from the origin to the viewport
		viewPlatform.getLocalToVworld(xform);
		
		// Get the x,y,z coordinates for this position
		xform.get(currentPosition);
		
		currentX = currentPosition.x;
		currentY = currentPosition.y;
		currentZ = currentPosition.z;
	}
	
	public void shrinkToHeight(float y)
	{
		// This function sets the values to start the shink animation
		bScaleViewport   = true;
		currentAnimFrame = 0;
		scaleToHeight    = y;
		scaleFromHeight  = this.currentY;
		scaleMovement    = SMALL_SCALE_MOVEMENT;
		
		// Adjust the movment scale if the user has the key currenly pressed down
		mForwardMovement *= SMALL_SCALE_MOVEMENT;
	}
	
	public void enlargeToHeight(float y)
	{
		// This function sets the values to start the enlarge animation
		bScaleViewport   = true;
		currentAnimFrame = 0;
		scaleToHeight    = y;
		scaleFromHeight  = this.currentY;
		scaleMovement    = LARGE_SCALE_MOVEMENT;
		
		// Adjust the movment scale if the user has the key currenly pressed down
		mForwardMovement /= SMALL_SCALE_MOVEMENT;
	}
}