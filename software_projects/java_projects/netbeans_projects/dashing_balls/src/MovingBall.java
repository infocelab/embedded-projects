/*
** Author: Robert Eisinger
** Date: 08-23-08
**
** Description: This class provides the framework for
** ball objects, with many paramters defined below
**
*/

import java.awt.*; //for Color

public class MovingBall
{
	//--------------------------------------------------------
	//					Declare private variables
	//--------------------------------------------------------

	//The size of the ball - x and y
	private int ballSizeX, ballSizeY;
	
	//The current position of the ball - x and y
	private int ballCX, ballCY;
	
	//The previous position of the ball - x and y
	private int ballPX, ballPY;
	
	//The applet dimensions - x and y
	private int maxX, maxY;
	
	//The ball's color
	Color color;

	//--------------------------------------------------------
	//						Constructor
	//--------------------------------------------------------

	public MovingBall(int xsize, int ysize, int cX, int cY, int pX, int pY, int windowSizeX, int windowSizeY, Color c)
	{
		//--------------------------------------------------------
		//				  Initialize private variables
		//--------------------------------------------------------
		
		ballSizeX = xsize; //the size of the ball - width
		ballSizeY = ysize; //the size of the ball - height
		
		ballCX = cX; //the current position - x value
		ballCY = cY; //the current position - y value
		
		ballPX = pX; //the previous position - x value
		ballPY = pY; //the previous position - y value
		
		maxX = windowSizeX; //the size of the screen - x value
		maxY = windowSizeY; //the size of the screen - y value
		
		color = c; //the color of the ball
	}

	//--------------------------------------------------------
	//						   Getter methods
	//--------------------------------------------------------
	
	//---------------
	// Ball Size
	//---------------
	
	public int getBallSizeX()
	{
		return ballSizeX;
	}
	
	public int getBallSizeY()
	{
		return ballSizeY;
	}
	
	//------------------
	// Current positions
	//------------------
	
	public int getCX()
	{
		return ballCX;
	}
	
	public int getCY()
	{
		return ballCY;
	}
	
	//-------------------
	// Previous positions
	//-------------------
	
	public int getPX()
	{
		return ballPX;
	}
	
	public int getPY()
	{
		return ballPY;
	}
	
	//---------------
	// Ball Color
	//---------------
	
	public Color getBallColor()
	{
		return color;
	}
	
	//--------------------------------------------------------
	//						   Setter methods
	//--------------------------------------------------------
	
	//------------------
	// Current positions
	//------------------
	
	public void setCX(int i)
	{
		ballCX = i;
	}
	
	public void setCY(int i)
	{
		ballCY = i;
	}
	
	//-------------------
	// Previous positions
	//-------------------
	
	public void setPX(int i)
	{
		ballPX = i;
	}
	
	public void setPY(int i)
	{
		ballPY = i;
	}
	
	//--------------------------------------------------------
	//						   Move the Ball
	//--------------------------------------------------------
	
	//This method updates the position of the ball based on its
	//current position and previous position. The paramaters are
	//the lowerY and the upperY for the gap in the middle of the game
	//so that the ball knows to bounce off that bar, but not if 
	//is at the position where the gap is. In that case, it goes
	//through the gap.
	public void moveBall(int lowY, int upY)
	{
		//Just making new variables with shorter names
		int cx = getCX();
		int cy = getCY();
		int px = getPX();
		int py = getPY();
		
		//These values represent the change that will be made
		//to the ball. There are four possible directions 
		//the ball can go. These variables are used to determine
		//that direction
		int x = 0;
		int y = 0;
		
		//--------------------------------------------------------
		//						  Middle Bar Corners
		//--------------------------------------------------------
		
		//if the ball hits the top left corner of the middle bar
		if( (cx>=325) && (cx<=330) && (cy<=5) && (cy<=upY || cy>=lowY) )
		{
			x = 5;
			y = 5;
			cx = 327;
			cy = 2;
		}
		
		//if the ball hits the bottom left corner of the middle bar
		else if( (cx>=325) && (cx<=330) && (cy>=475-ballSizeY) && (cy<=upY || cy>=lowY) )
		{
			x = 5;
			y = -5;
			cx = 327;
			cy = maxY-ballSizeY-2;
		}
		
		//if the ball hits the top right corner of the middle bar
		else if( (cx>=310-ballSizeX) && (cx<=315-ballSizeX) && (cy<=5) && (cy<=upY || cy>=lowY) )
		{
			x = -5;
			y = 5;
			cx = 310-ballSizeX-2;
			cy = 2;
		}
		
		//if the ball hits the bottom right corner of the middle bar
		else if( (cx>=310-ballSizeX) && (cx<=315-ballSizeX) && (cy>=475-ballSizeY) && (cy<=upY || cy>=lowY) )
		{
			x = -5;
			y = -5;
			cx = 315-ballSizeX-2;
			cy = maxY-ballSizeY-2;
		}
		
		//--------------------------------------------------------
		//				 		 Middle Bar Non Corners
		//--------------------------------------------------------
		
		//if the ball hits the left side of the middle bar, and it is going from [down right] to [down left]
		else if( ( (cx>=315-ballSizeX && cx<=325-ballSizeX) && (cy<=upY || cy>=lowY )) && (cx-px>=5) && (cy-py>=5) )
		{
			x-=5;
			y+=5;
		}
		
		//if the ball hits the left side of the middle bar, and it is giong from [up right] to [up left]
		else if( ( (cx>=315-ballSizeX && cx<=325-ballSizeX) && (cy<=upY || cy>=lowY ) ) && (cx-px>=5) && (py-cy>=5) ) 
		{
			x-=5;
			y-=5;
		}
		
		//if the ball hits the right side of the middle bar, and it is going from [down left] to [down right]
		else if( ( (cx>=315 && cx<=325) && (cy<=upY || cy>=lowY ) ) && (px-cx>=5) && (cy-py>=5) )
		{
			x+=5;
			y+=5;
		}
		
		//if the ball hits the right side of the middle bar, and it is going from [up left] to [up right]
		else if( ( (cx>=315 && cx<=325) && (cy<=upY || cy>=lowY ) ) && (px-cx>=5) && (py-cy>=5) )
		{
			x+=5;
			y-=5;
		}
		
		//--------------------------------------------------------
		//				 Normal Motion -- Not hitting sides
		//--------------------------------------------------------
		
		//if the ball is moving [down right]
		else if( !(cy>=maxY-ballSizeY) && !(cx>=maxX-ballSizeX) && !(cy<=0) && !(cx<=0) && (cx>=5) && (cy>=5) && (cx-px>=5) && (cy-py>=5) )
		{
			x+=5;
			y+=5;
		}
		
		//if the ball is moving [up right]
		else if( !(cy>=maxY-ballSizeY) && !(cx>=maxX-ballSizeX) && !(cy<=0) && !(cx<=0) && (cx>=5)&& (cy>=5) && (cx-px>=5) && (py-cy>=5) )
		{
			x+=5;
			y-=5;
		}
		
		//if the ball is moving [down left]
		else if( !(cy>=maxY-ballSizeY) && !(cx>=maxX-ballSizeX) && !(cy<=0) && !(cx<=0) && (cx>=5)&& (cy>=5) && (px-cx>=5) && (cy-py>=5) )
		{
			x-=5;
			y+=5;
		}
		
		//if the ball is moving [up left]
		else if( !(cy>=maxY-ballSizeY) && !(cx>=maxX-ballSizeX) && !(cy<=0) && !(cx<=0) && (cx>=5)&& (cy>=5) && (px-cx>=5) && (py-cy>=5) )
		{
			x-=5;
			y-=5;		
		}	
		
		//--------------------------------------------------------
		//			 Normal Corners -- Non Barrier Corners
		//--------------------------------------------------------
		
		//if the ball hits the top left corner
		else if( (cx<=4) && (cy<=4) ) 
		{
			x = 5;
			y = 5;
			cx = 2;
			cy = 2;
		}
		
		//if the ball hits the bottom left corner
		else if( (cx<=4) && (cy>=maxY-ballSizeY-4) )
		{
			x = 5;
			y = -5;
			cx = 2;
			cy = maxY-ballSizeY-2;
		}
		
		//if the ball hits the top right corner
		else if( (cy<=4) && (cx>=maxX-ballSizeX-4) )
		{
			x = -5;
			y = 5;
			cx = maxX-ballSizeX-2;
			cy = 2;
		}
		
		//if the ball hits the bottom right corner
		else if( (cy>=maxY-ballSizeY-4) && (cx>=maxX-ballSizeX-4) )
		{
			x = -5;
			y = -5;
			cx = maxX-ballSizeX-2;
			cy = maxY-ballSizeY-2;
		}
		
		//--------------------------------------------------------
		//			 Normal Sides - Non Barrier Sides
		//--------------------------------------------------------
		
		//if the ball hits the bottom side and goes from [down right] to [up right]
		else if( (cy >= 480-ballSizeY) && (cx-px>= 5) && (cy-py>=5) )
		{	
			x+=5;
			y-=5;
		}
		
		//if the ball hits the bottom side and goes from [down left] to [up left]
		else if( (cy>=480-ballSizeY) && (px-cx>=5) && (cy-py>=5) )
		{
			x-=5;
			y-=5;
		}
		
		//if the ball hits the top side and goes from [up right] to [down right]
		else if( (cy <= 4) && (cx-px >=5) && (py-cy>=5) )
		{
			x+=5;
			y+=5;
		}
		
		//if the ball hits the top side and goes from [up left] to [down left]
		else if( (cy<=4) &&  (px-cx>=5) && (py-cy>=5) )
		{
			x-=5;
			y+=5;
		}
		
		//if the ball hits the right side and goes from [down right] to [down left]
		else if( (cx>=640-ballSizeX) &&  (cx-px>=5) && (cy-py>=5) )
		{
			x-=5;
			y+=5;
		}
		
		//if the ball hits the right side and goes from [up right] to [up left]
		else if( (cx>=640-ballSizeX) && (cx-px>=5) && (py-cy>=5) )
		{
			x-=5;
			y-=5;
		}
		
		//if the ball hits the left side and goes from [down left] to [down right]
		else if( (cx<=4)  && (px-cx>=5) && (cy-py>=5) )
		{	
			x+=5;
			y+=5;
		}
		
		//if the ball hits the left side and goes from [up left] to [up right]
		else if( (cx<=4) &&  (px-cx>=5) && (py-cy>=5) )
		{
			x+=5;
			y-=5;
		}
		
		//Now that we have determined what direction the ball should go
		//based on its current and previoud psotitions, we need to update
		//the current positions and previous positions. The NEW previous 
		//positions will be the OLD current positions
		setPX(cx);
		setPY(cy);
		setCX(cx+x);
		setCY(cy+y);
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