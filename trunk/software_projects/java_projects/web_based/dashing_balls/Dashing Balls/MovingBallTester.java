/* Author: Robert Eisinger
** Date: 8-23-08
**
** Description: This class provides the main method and
** the key listener and runs the game
*/

import java.awt.*; //for Graphics
import java.awt.event.*; //for KeyListener
import javax.swing.*; //for JFrame

public class MovingBallTester
{
	//Declare private variables
	private final int UPGAP_Y, LOWGAP_Y;
	private MovingBallPanel mbp;
	private JFrame movingBallFrame;

	
	//Constructor
	public MovingBallTester()
	{
		//Initialize private variables
		LOWGAP_Y = 270;
		UPGAP_Y = 210;
		mbp = new MovingBallPanel(LOWGAP_Y, UPGAP_Y);
		movingBallFrame = new JFrame("Moving Ball");
		
		//Set up the Basics of the Frame
		movingBallFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		movingBallFrame.addKeyListener(new KeypadListener());
		movingBallFrame.setResizable(false);
		
		//Add the MovingBallPanel to the Frame
		movingBallFrame.getContentPane().add(mbp);
		
		//Display the frame so the user can see it
		displayFrame();

		//Run the game
		runGame();
	}
	
	//--------------------------------------------------------
	//					Methods called in the constructor
	//--------------------------------------------------------
	
	//Displays the frame so the user can see it
	public void displayFrame()
	{
		movingBallFrame.pack();
		movingBallFrame.show();
	}
	
	//Runs the game
	public void runGame()
	{
		//show "Loading"
		sleep(500);
		mbp.beginGame1();
		sleep(300);
		
		//show "Loading."
		mbp.beginGame2();
		sleep(300);
		
		//show "Loading.."
		mbp.beginGame3();
		sleep(300);
		
		//show "Loading..."
		mbp.beginGame4();
		sleep(300);
		
		//repeat process two more times
		mbp.beginGame1();
		sleep(300);
		mbp.beginGame2();
		sleep(300);
		mbp.beginGame3();
		sleep(300);
		mbp.beginGame4();
		sleep(300);
		mbp.beginGame1();
		sleep(300);
		mbp.beginGame2();
		sleep(300);
		mbp.beginGame3();
		sleep(300);
		mbp.beginGame4();
		sleep(300);
		
		//The game runs until the user exits
		while(true)
		{
			//The y value of the upper and lower
			//parts of the middle bar gap
			int lowerY = mbp.getLowerY();
			int upperY = mbp.getUpperY();
			
			//Move the balls
			mbp.callMoveBallMethod(lowerY,upperY);
			
			//Are the blue balls on the right and
			//are the yellow balls on the left?
			if(mbp.checkBalls())
			{
				//If so, restart with an extra ball
				mbp.addAnotherBall();
			}
		}
	}
	
	//--------------------------------------------------------
	//							Sleep method
	//--------------------------------------------------------
	
	//Stalls the program so that program slows down
	public void sleep(int i)
	{
		try 
		{
			Thread.sleep(i); 
		}
		catch (Exception e) { }
	}
	
	//--------------------------------------------------------
	//						Key Listener Class
	//--------------------------------------------------------
	
	//This is just a private class that takes care of user keypad
	//motion; specifically, up and down to move the middle bar
	private class KeypadListener implements KeyListener
	{
		//When the user presses up or down, this method is called
		public void keyPressed(KeyEvent e)
		{
			//Figure out if the user pressed up or down
			int source = e.getKeyCode();
			
			//If the user pressed up
			if(source == KeyEvent.VK_UP)
			{
				//Move the gap up
				mbp.moveGapLocationUp();
				
			}
			//If the user pressed down
			else if(source == KeyEvent.VK_DOWN)
			{
				//Move the gap down
				mbp.moveGapLocationDown();
			}
		}
		
		//Methods that need to be implemented
		public void keyReleased(KeyEvent e)	{}
		public void keyTyped(KeyEvent e){}
	}
	
	//--------------------------------------------------------
	//							Main method
	//--------------------------------------------------------
	
	//Just call the constructor, which will then call runGame
	//and make the game run
	public static void main (String[] args)
	{
		new MovingBallTester();
	}
}