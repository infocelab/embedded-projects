import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.lang.reflect.InvocationTargetException;
import javax.swing.JFrame;

/**
    The ScreenManager class manages initializing and displaying
    full screen graphics modes.
*/
public class ScreenManager
{
  protected GraphicsDevice device;

  /**
      Creates a new ScreenManager object.
  */
  public ScreenManager()
  {
    GraphicsEnvironment environment = GraphicsEnvironment.getLocalGraphicsEnvironment();
    device = environment.getDefaultScreenDevice();
  }//end screen manager

  /**
      Returns a list of compatible display modes for the
      default device on the system.
  */
  public DisplayMode[] getCompatibleDisplayModes()
  {
    return device.getDisplayModes();
  }//end getCompatibleMode

  /**
      Returns the first compatible mode in a list of modes.
      Returns null if no modes are compatible.
  */
  public DisplayMode findFirstCompatibleMode(DisplayMode modes[])
  {
    DisplayMode goodModes[] = device.getDisplayModes();
    for (int i = 0; i < modes.length; i++)
    {
      for (int j = 0; j < goodModes.length; j++)
      {
        if (displayModesMatch(modes[i], goodModes[j]))
        {
          return modes[i];
        }//end if
      }//end for
    }//end for

    return null;
  }//end findFirstCompatibleMode

  /**
      Returns the current display mode.
  */
  public DisplayMode getCurrentDisplayMode()
  {
    return device.getDisplayMode();
  }// end getCurrentDisplayMode

  /**
      Determines if two display modes "match". Two display
      modes match if they have the same resolution, bit depth,
      and refresh rate. The bit depth is ignored if one of the
      modes has a bit depth of DisplayMode.BIT_DEPTH_MULTI.
      Likewise, the refresh rate is ignored if one of the
      modes has a refresh rate of
      DisplayMode.REFRESH_RATE_UNKNOWN.
  */
  public boolean displayModesMatch(DisplayMode mode1, DisplayMode mode2)
  {
    if (mode1.getWidth() != mode2.getWidth() || mode1.getHeight() != mode2.getHeight())
    {
      return false;
    }//end if

    if (mode1.getBitDepth() != DisplayMode.BIT_DEPTH_MULTI &&
        mode2.getBitDepth() != DisplayMode.BIT_DEPTH_MULTI &&
        mode1.getBitDepth() != mode2.getBitDepth())
    {
      return false;
    }//end if

     if (mode1.getRefreshRate() !=
         DisplayMode.REFRESH_RATE_UNKNOWN &&
         mode2.getRefreshRate() !=
         DisplayMode.REFRESH_RATE_UNKNOWN &&
         mode1.getRefreshRate() != mode2.getRefreshRate())
     {
       return false;
     }//end if

     return true;
  }//displayModesMatch

  /**
      Enters full screen mode and changes the display mode.
      If the specified display mode is null or not compatible
      with this device, or if the display mode cannot be
      changed on this system, the current display mode is used.
      The display uses a BufferStrategy with 2 buffers.
  */
  public void setFullScreen(DisplayMode displayMode)
  {
    final JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setUndecorated(true);
    frame.setIgnoreRepaint(true);
    frame.setResizable(false);

    device.setFullScreenWindow(frame);

    if (displayMode != null && device.isDisplayChangeSupported())
    {
      try
      {
        device.setDisplayMode(displayMode);
      }//end try

      catch (IllegalArgumentException ex){}

      // fix for mac os x
      frame.setSize(displayMode.getWidth(), displayMode.getHeight());
    }//end if

    // avoid potential deadlock in 1.4.1_02
    try
    {
      EventQueue.invokeAndWait(new Runnable()
      {
        public void run()
        {
          frame.createBufferStrategy(2);
        }//end run
      });
    }//end try

    catch (InterruptedException ex){}
    catch (InvocationTargetException  ex){}
  }//end set full screen

  /**
      Gets the graphics context for the display. The
      ScreenManager uses double buffering, so applications must
      call update() to show any graphics drawn.
      The application must dispose of the graphics object.
  */
  public Graphics2D getGraphics()
  {
    Window window = device.getFullScreenWindow();

    if (window != null)
    {
      BufferStrategy strategy = window.getBufferStrategy();
      return (Graphics2D)strategy.getDrawGraphics();
    }//end if

    else
    {
        return null;
    }//end else
  }//end getGraphics

  /**
      Updates the display.
  */
  public void update()
  {
    Window window = device.getFullScreenWindow();
    if (window != null)
    {
      BufferStrategy strategy = window.getBufferStrategy();
      if (!strategy.contentsLost())
      {
        strategy.show();
      }//end if
    }//end if
    Toolkit.getDefaultToolkit().sync();
  }//end update

  /**
      Returns the window currently used in full screen mode.
      Returns null if the device is not in full screen mode.
  */
  public JFrame getFullScreenWindow()
  {
    return (JFrame)device.getFullScreenWindow();
  }//getFullScreenWindow

  /**
      Returns the width of the window currently used in full
      screen mode. Returns 0 if the device is not in full
      screen mode.
  */
  public int getWidth()
  {
    Window window = device.getFullScreenWindow();

    if (window != null)
    {
      return window.getWidth();
    }//end if

    else
    {
        return 0;
    }//end else
  }//end getWidth

  /**
      Returns the height of the window currently used in full
      screen mode. Returns 0 if the device is not in full
      screen mode.
   */
  public int getHeight()
  {
    Window window = device.getFullScreenWindow();

    if (window != null)
    {
      return window.getHeight();
    }//end if

    else
    {
        return 0;
    }//end else
  }//end getHeight

  /**
      Restores the screen's display mode.
   */
  public void restoreScreen()
  {
    Window window = device.getFullScreenWindow();

    if (window != null)
    {
      window.dispose();
    }//end if

    device.setFullScreenWindow(null);
  }//end restoreScreen

  /**
      Creates an image compatible with the current display.
   */
  public BufferedImage createCompatibleImage(int w, int h,int transparancy)
  {
    Window window = device.getFullScreenWindow();
    if (window != null)
    {
      GraphicsConfiguration gc =
      window.getGraphicsConfiguration();
      return gc.createCompatibleImage(w, h, transparancy);
    }//end if

    return null;
  }//end createCompatibleImage
}//end class
