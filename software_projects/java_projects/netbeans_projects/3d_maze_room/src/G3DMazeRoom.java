/***************************************
* G3DMazeRoom
* Author: Martin Adams
****************************************
* Main application to create 3D world
* and monitor keyboard input
****************************************/

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.GraphicsConfiguration;

import com.sun.j3d.utils.applet.MainFrame;
import com.sun.j3d.utils.universe.*;

import javax.media.j3d.*;
import javax.vecmath.*;
import java.awt.event.*;

public class G3DMazeRoom extends Applet
implements KeyListener, CFrameElapseListener, CViewportListener, CWorldListener
{
  private Canvas3D      canvas3D = null;
  private CWorld        world = null;
  private CViewport     view = null;
  private CFrameElapse  frameElapse = null;
	private String        appPath = "LOCAL";

	public G3DMazeRoom(String appPath)
	{
		// Load the program using this new path
		this.appPath = appPath;
		load();
	}

  public G3DMazeRoom()
  {
		// The applet has been loaded from the web so set the location to the images
		this.appPath = "http://martin.student-film.com/wip/maze/";
		load();
	}
	
	public void load()
	{		
		// Create a virtual universe to contain our 3D world
    VirtualUniverse universe = new VirtualUniverse();
    Locale loc = new Locale(universe);
    GraphicsConfiguration config = SimpleUniverse.getPreferredConfiguration();
    
		// Add the Canvas3D to the window
    setLayout(new BorderLayout());
    canvas3D = new Canvas3D(config);
    add("Center", canvas3D);
		
		// Add a keyboard listener to the Canvas3D to respond to user input
    canvas3D.addKeyListener(this);

    // Create our viewport
    BranchGroup viewport = new BranchGroup();
    view = new CViewport(canvas3D, viewport, this);
    loc.addBranchGraph(viewport);   

    // Create our world
    BranchGroup scene = new BranchGroup();
    world = new CWorld(scene, canvas3D, this, appPath);
    
    // Monitor every frame elapse
    frameElapse = new CFrameElapse(this);
	  BoundingSphere bounds = new BoundingSphere(new Point3d(0.0,0.0,0.0), Double.POSITIVE_INFINITY);
		frameElapse.setSchedulingBounds(bounds);
    scene.addChild(frameElapse);

		// Compile and add the scene
    scene.compile();
    loc.addBranchGraph(scene);
		
		// Move the viewport to a default position
		view.moveTo(250.0f, 150.0f, 600.0f);
  }

  public void keyReleased(KeyEvent e)
  {
    switch(e.getKeyCode())
		{
			case KeyEvent.VK_UP:
				view.moveForward();
				break;
			case KeyEvent.VK_DOWN:
				view.moveForward();
				break;
			case KeyEvent.VK_LEFT:
				view.moveYaw();
				break;
			case KeyEvent.VK_RIGHT:
				view.moveYaw();
				break;
			case KeyEvent.VK_COMMA:
				view.moveSideways();
				break;
			case KeyEvent.VK_PERIOD:
				view.moveSideways();
				break;
			case KeyEvent.VK_A:
			  view.movePitch();
				break;
			case KeyEvent.VK_Z:
			  view.movePitch();
				break;
		}
  }

  public void keyTyped(KeyEvent e) {}

  public void keyPressed(KeyEvent e)
  {
    switch(e.getKeyCode())
    {
      case KeyEvent.VK_UP:
        view.moveForward(-1f);
        break;
      case KeyEvent.VK_DOWN:
        view.moveForward(1f);
        break;
      case KeyEvent.VK_LEFT:
	      view.moveYaw(0.05f);
        break;
      case KeyEvent.VK_RIGHT:
	      view.moveYaw(-0.05f);
        break;
			case KeyEvent.VK_COMMA:
				view.moveSideways(-1f);
				break;
			case KeyEvent.VK_PERIOD:
				view.moveSideways(1f);
				break;
			case KeyEvent.VK_A:
			  view.movePitch(0.05f);
				break;
			case KeyEvent.VK_Z:
			  view.movePitch(-0.05f);
				break;
    }
  }
 
  public void onFrameElapse()
  {
    // A frame has advanced so get the view to update
		// any animation
	  view.updateViewport(frameElapse.mElapsedTime);
  }

  public void onEnterTable()
	{
		// The user has entered the table area so get the
		// viewport to shrink to the smaller scale
	  view.shrinkToHeight(105.0f);
	}

  public void onExitTable()
	{
		// The user has left the table area so get the
		// viewport to enlarge to the normal scale
	  view.enlargeToHeight(150.0f);
	}
	
	public void onCollisionDetect(Vector3f newPosition)
	{
		// There was a collision with an object so set the
		// viewport's position to the corrected value
		view.boundMove(newPosition);
	}

	public void onViewportMove(Vector3f position)
	{
		// The viewport's position was moved so check for
		// any collision with any objects in the world
		world.processMovement(position);
	}
	
  public static void main(String[] args)
  {
	  // The program has been loaded from the command prompt so assume
		// the textures are relative to the current path
	
		// Load the applet in a window
    Frame frame = new MainFrame(new G3DMazeRoom(""), 500, 400);
		
		// Show the welcome message
		System.out.println("/---------------------------------------\\");
		System.out.println("| Java 3D Maze                          |");
		System.out.println("| Created by Martin Adams               |");
		System.out.println("|---------------------------------------|");
		System.out.println("| Controls                              |");
		System.out.println("|       Up Key : Move Forward           |");
		System.out.println("|     Down Key : Move Backwards         |");
		System.out.println("|     Left Key : Turn Left              |");
		System.out.println("|    Right Key : Turn Right             |");
		System.out.println("|    Comma Key : Side Step Left         |");
		System.out.println("|   Period Key : Side Step Right        |");
		System.out.println("|        A Key : Look Up                |");
		System.out.println("|        Z Key : Look Down              |");
		System.out.println("|---------------------------------------|");
		System.out.println("| Notes                                 |");
		System.out.println("|   Please click the window to activate |");
		System.out.println("\\---------------------------------------/"); 
  }
}