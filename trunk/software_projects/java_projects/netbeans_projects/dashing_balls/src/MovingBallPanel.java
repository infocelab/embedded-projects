/* 
** Author: Robert Eisinger
** Date: 8-23-08
**
** Description: This class allows the tester class to run, 
** because the tester class manipulates the MovingBall
** class via this class. This is the panel that is directly
** added to the JFrame
**
*/

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class MovingBallPanel extends JPanel
{	
	//--------------------------------------------------------
	//					Declare private variables
	//--------------------------------------------------------
	
	//This is the arraylist of balls
	private ArrayList<MovingBall> mb;
	
	//This is the arraylist of the balls in 
	//their original location. Througout the
	//program, the positions of the balls in
	//the mb array list change. However, the
	//initials arraylist is just the initial
	//positions of the balls, so that when an
	//extra ball is added, the original balls
	//can start over in their initial spots
	private ArrayList<MovingBall> initials;
	
	//The y values of the upper gap and lower gap
	private int gapLY, gapTY;
	
	//A variable representing the level the user is on
	private int level;
	
	//Width and Height
	private final int APPLET_WIDTH, APPLET_HEIGHT;
	
	
	//--------------------------------------------------------
	//						Constructor
	//--------------------------------------------------------
	
	public MovingBallPanel(int lowerGapY, int topGapY)
	{
		//--------------------------------------------------------
		//				  Initialize private variables
		//--------------------------------------------------------
		
		//The array lists of balls
		mb = new ArrayList<MovingBall>();
		initials = new ArrayList<MovingBall>();
		
		//The upper and lower y values of the gap
		gapLY = lowerGapY;
		gapTY = topGapY;
		
		//The game starts on level 1
		level = 1;
		
		//The applet is 640 x 480
		APPLET_WIDTH = 640;
		APPLET_HEIGHT = 480;
		
		//--------------------------------------------------------
		//				 Set up the BASICS of the panel
		//--------------------------------------------------------
		
		//The panel has dimensions of 640 width and 480 height
		setPreferredSize(new Dimension(APPLET_WIDTH, APPLET_HEIGHT));
		
		//Set the background to be black
		setBackground(Color.black);

		//Declare mb to start out with 4 pre-defined balls
		//SEE MOVING BALL CLASS FOR EXPLANATION OF PARAMETERS
		mb.add(new MovingBall(20, 20, 136, 39,  131, 34,  APPLET_WIDTH, APPLET_HEIGHT, Color.cyan));
		mb.add(new MovingBall(20, 20, 200, 200, 205, 195, APPLET_WIDTH, APPLET_HEIGHT, Color.cyan));
		mb.add(new MovingBall(20, 20, 453, 282, 448, 277, APPLET_WIDTH, APPLET_HEIGHT, Color.yellow));
		mb.add(new MovingBall(20, 20, 97,  365, 92,  360, APPLET_WIDTH, APPLET_HEIGHT, Color.yellow));
		
		//Add those same balls to the initials array
		//SEE MOVING BALL CLASS FOR EXPLANATION OF PARAMETERS
		initials.add(new MovingBall(20, 20, 136, 39, 131,  34,  APPLET_WIDTH, APPLET_HEIGHT, Color.cyan));
		initials.add(new MovingBall(20, 20, 200, 200, 205, 195, APPLET_WIDTH, APPLET_HEIGHT, Color.cyan));
		initials.add(new MovingBall(20, 20, 453, 282, 448, 277, APPLET_WIDTH, APPLET_HEIGHT, Color.yellow));
		initials.add(new MovingBall(20, 20, 97,  365, 92,  360, APPLET_WIDTH, APPLET_HEIGHT, Color.yellow));
	}
	
	//--------------------------------------------------------
	//							Graphics methods
	//--------------------------------------------------------
	
	//This method is called initially and is 
	//periodically called automatically
	public void paintComponent(Graphics g)
	{
		//paint background
		g.setColor(Color.black);
		g.fillRect(0,0,640,480);
		
		//paint middle white bar
		g.setColor(Color.white);
		g.fillRect(315,0,10,gapTY);
		g.fillRect(315,gapLY,10,(480-gapLY));
		
		//put "blue" on the left
		//and "yellow" on the right
		g.setColor(Color.cyan);
		g.drawString("Blue", 145,20);
		g.setColor(Color.yellow);
		g.drawString("Yellow", 475,20); 
		
		//draw directions
		g.setColor(Color.yellow);
		g.drawString("Directions", 541, 410);
		g.drawString("1.Use the up and down", 500,430);
		g.drawString("arrows to move", 510,442);
		g.drawString("2.Get the balls on their", 500, 457);
		g.drawString("proper sides", 510, 470);
		
		//draw level
		g.setColor(Color.cyan);
		g.drawString(("Level: " + level), 8, 472);

		//paint balls
		for(int x = 0; x < mb.size(); x++)
		{
			MovingBall t = mb.get(x);
			g.setColor(t.getBallColor());
			g.fillOval(t.getCX(), t.getCY(), t.getBallSizeX(),t.getBallSizeY());
		}	
	}
	
	//Draws "Loading"
	public void beginGame1()
	{
		Graphics g = getGraphics();
		g.setColor(Color.black);
		g.fillRect(186,157,14,5);
		g.fillRect(520,157,14,5);
		g.setColor(Color.cyan);
		g.drawString("Loading", 145,160);
		g.setColor(Color.yellow);
		g.drawString("Loading", 475,160);
	}
	
	//Draws "Loading."
	public void beginGame2()
	{
		Graphics g = getGraphics();
		g.setColor(Color.black);
		g.fillRect(186,157,14,5);
		g.fillRect(520,157,14,5);
		g.setColor(Color.cyan);
		g.drawString("Loading.", 145,160);
		g.setColor(Color.yellow);
		g.drawString("Loading.", 475,160);
	}
	
	//Draws "Loading.."
	public void beginGame3()
	{
		Graphics g = getGraphics();
		g.setColor(Color.black);
		g.fillRect(186,157,14,5);
		g.fillRect(520,157,14,5);
		g.setColor(Color.cyan);
		g.drawString("Loading..", 145,160);
		g.setColor(Color.yellow);
		g.drawString("Loading..", 475,160);
	}
	
	//Draws "Loading..."
	public void beginGame4()
	{
		Graphics g = getGraphics();
		g.setColor(Color.black);
		g.fillRect(186,157,14,5);
		g.fillRect(520,157,14,5);
		g.setColor(Color.cyan);
		g.drawString("Loading...", 145,160);
		g.setColor(Color.yellow);
		g.drawString("Loading...", 475,160);
	}
	
	//--------------------------------------------------------
	//							Getter methods
	//--------------------------------------------------------
	
	//returns the y value for the lower gap
	public int getLowerY()
	{
		return gapLY;
	}
	
	//returns the y value for the upper gap
	public int getUpperY()
	{
		return gapTY;
	}
	
	//--------------------------------------------------------
	//							Moving The Balls
	//--------------------------------------------------------
	
	//This method goes through each individual ball
	//and updates its position by calling the moveBall()
	//method in the MovingBall class
	public void callMoveBallMethod(int l, int u)
	{
		for(int x = 0; x < mb.size(); x++)
		{
			//get the current ball
			MovingBall t = mb.get(x);
			
			//update its position
			t.moveBall(l,u);
			
			//now draw the new ball's position
			repaint();

		}
		
		//stall the program so the ball is not too fast
		sleep(20);
	}
	
	//--------------------------------------------------------
	//							Advancing levels
	//--------------------------------------------------------
	
	//This method determines whether or not the
	//blue balls are on the left side and the
	//yellow balls are on the right side
	public boolean checkBalls()
	{
		for(int x = 0; x < mb.size(); x++)
		{
			//get the current ball
			MovingBall temp = mb.get(x);
			
			//get its color
			Color c = temp.getBallColor();
			
			//get its current x position
			int currentXPosition = temp.getCX();
			
			//if it's blue, make sure it is on the left
			if(c == Color.cyan)
			{
				if( !(currentXPosition<315) )
				{
					return false;
				}
			}
			
			//if it's yellow, make sure it is on the right
			else
			{
				if( !(currentXPosition>325) )
				{
					return false;
				}
			}
		}
		return true;
	}
	
	//If the checkBalls() method returns true, it means
	//that the user is ready to advance to the next level.
	//So this method is used to add another ball to the game randomly
	public void addAnotherBall()
	{
		//Make a random object used throughout this method
		Random rm = new Random();
		
		//Get random x and y values representing the 
		//current x and current y position of the new ball
		int cxValue = rm.nextInt(550) + 25;
		int cyValue = rm.nextInt(435) + 25;
		
		//xValue and yValue are numbers used to determine
		//the previous x and y positioin of the new ball
		//Set it to a default of -1 so the compiler does
		//not produce a "variable not initialized" error
		int xValue = -1;
		int yValue = -1;
		
		//get a number between 1 and 4 representing
		//the four possible ways for the ball to travel
		int n = rm.nextInt(4) + 1;
		
		//depending on the random number 1-4, initialize
		//xValue and yValue 
		if(n == 1)
		{
			xValue = 5;
			yValue = 5;
		}
		else if(n == 2)
		{
			xValue = 5;
			yValue = -5;
		}
		else if(n == 3)
		{
			xValue = -5;
			yValue = 5;
		}
		else if(n == 4)
		{
			xValue = -5;
			yValue = -5;
		}
		
		//get a random number to determine the color
		//of the new ball
		int k = rm.nextInt(2) + 1;
		
		//if k is 1, then the ball is cyan
		//if k is 2, then the ball is yellow
		Color g = Color.cyan;
		if(k == 2)
		{
			g = Color.yellow;
		}
		
		//now create the new ball
		initials.add(new MovingBall(20, 20, cxValue, cyValue, (cxValue+xValue), (cyValue+yValue), APPLET_WIDTH, APPLET_HEIGHT, g));
		
		//clear all the current balls so that the level can start over
		mb.clear();
		
		//now reset mb using the initials array with the 
		//inital positions of all the balls
		for(int y = 0; y < initials.size(); y++)
		{
			mb.add(initials.get(y));
		}
		
		//increaes the level
		level++;
		
		//if this new ball that was added makes that level win,
		//then that will be pointless, because the user won't 
		//have to do anything to advance to the next level.
		//So if this happens, this loop will get rid of the ball
		//that was just added, and try it again, until a ball is added
		//that does not make the level advance automatically
		if(checkBalls())
		{
			level--;
			initials.remove(initials.size()-1);
			addAnotherBall();
		}
		
		//while the program is cointinuing until it creates
		//a random ball that doesn't automatically make the 
		//level advance, it will cycle through the "Loading"
		//two times
		beginGame1();
		sleep(300);
		beginGame2();
		sleep(300);
		beginGame3();
		sleep(300);
		beginGame4();
		sleep(300);
		beginGame1();
		sleep(300);
		beginGame2();
		sleep(300);
		beginGame3();
		sleep(300);
		beginGame4();
		sleep(300);
	}
	
	//--------------------------------------------------------
	//						Responding to input
	//--------------------------------------------------------
	
	//If the user presses "up" on the keyboard,
	//then the gap is moved up
	public void moveGapLocationUp()
	{
		gapLY-=10;
		gapTY-=10;
		
	}
	
	//If the user presses "down" on the keyboard,
	//then the gap is moved down.
	public void moveGapLocationDown()
	{
		gapLY+=10;
		gapTY+=10;
	}
	
	//--------------------------------------------------------
	//							Sleep method
	//--------------------------------------------------------
	
	//Stalls the program so that program slows down
	public void sleep(int i)
	{
		try 
		{
			Thread.sleep (i); 
		}
		catch (Exception e) { }
	}
}
		