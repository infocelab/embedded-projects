import java.awt.*;
import javax.swing.*;

/**
    Class where the game starts. Sets up the screen and all
    subclasses will implement the draw(Graphics2D g) method
*/
public abstract class GameCore
{
      private static final DisplayMode POSSIBLE_MODES[] = {
          new DisplayMode(800, 600, 32, 0),
          new DisplayMode(800, 600, 24, 0),
          new DisplayMode(800, 600, 16, 0),
          new DisplayMode(640, 480, 32, 0),
          new DisplayMode(640, 480, 24, 0),
          new DisplayMode(640, 480, 16, 0)};

      protected static final int FONT_SIZE = 24;
      private boolean isRunning;
      protected ScreenManager screen;

      /**
          Calls init() and gameLoop()
       */
      public void run()
      {
            try
            {
                  init();
                  gameLoop();
            }//end try

            finally
            {
                  screen.restoreScreen();
            }//end finally
      }//end run

      /**
          Sets full screen mode and initiates and objects.
       */
      public void init()
      {
            screen = new ScreenManager();
            DisplayMode displayMode = screen.findFirstCompatibleMode(POSSIBLE_MODES);
            screen.setFullScreen(displayMode);

            Window window = screen.getFullScreenWindow();
            window.setFont(new Font("Dialog", Font.PLAIN, FONT_SIZE));

            isRunning = true;
      }//end init

      public Image loadImage(String fileName)
      {
            return new ImageIcon(fileName).getImage();
      }//end loadImage

      /**
          Runs through the game loop until stop() is called.
       */
      public void gameLoop()
      {
            long startTime = System.currentTimeMillis();
            long currTime = startTime;

            while (isRunning)
            {
                  long elapsedTime = System.currentTimeMillis() - currTime;
                  currTime += elapsedTime;

                  // update
                  update(elapsedTime);

                  // draw the screen
                  Graphics2D g = screen.getGraphics();
                  draw(g);
                  g.dispose();
                  screen.update();

                  // take a nap
                  try
                  {
                        Thread.sleep(20);
                  }//end try
                  catch (InterruptedException ex){}
            }//end while
      }//end gameloop

      /**
          Updates the state of the game/animation based on the
          amount of elapsed time that has passed.
       */
      public void update(long elapsedTime)
      {
            // do nothing
      }//end update

      /**
          Draws to the screen. Subclasses must override this
          method.
       */
      public abstract void draw(Graphics2D g);
}//end class
