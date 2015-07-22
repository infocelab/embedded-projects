//Hangman
//by Chris Elwell

import java.awt.*; 
import java.applet.*; 
import javax.swing.*;

public class ElwellAssignment5 extends Applet{
// guessWord is when the users guesses the entire word at once
// guessList is which characters the user has guessed so far
String hiddenWord="", guessWord, guessList;
// number of wrong letter guesses
int missCount;
// maximum number of misses allowed
int maxMisses;
// mouseOver is boolean to the Mouse being over the "new game" button
boolean win, gameOver, mouseOver = true;
// this varible is needed to tell MouseMove not to repaint() if already hanged
boolean hanged;
// array corresponding to the hiddenWord, defining user's knowledge of each character
boolean[] knownChars;
// background color
Color bgColor = new Color(0x00dddddd);

	public void init()
	{
		// adjust window size, and background color
		setSize(1000,625);
		setBackground(bgColor);
		// instructions to user
		JOptionPane.showMessageDialog(this, "Use your keyboard to guess each letter.  Hit the spacebar to guess the entire word.", "Java Hangman - by Chris Elwell", JOptionPane.INFORMATION_MESSAGE);
		JOptionPane.showMessageDialog(this, "Click on the screen to activate. Have fun!", "Java Hangman - by Chris Elwell", JOptionPane.INFORMATION_MESSAGE);	
		// start up a new game
		newGame();
	}

	public void newGame()
	{
        // set the random hidden word
		hiddenWord = getHiddenWord();
        guessList = "";
        guessWord = "";
        // define size of knownChars by the length of the hidden word
        knownChars = new boolean[hiddenWord.length()];
        // make known characters false unless it happens to be a space
        for (int i=0; i<hiddenWord.length(); i++)
        {	
        	if (hiddenWord.charAt(i) == ' ')
        		knownChars[i] = true;
        	else
        		knownChars[i] = false;
        }
        // initiate variables for a new game
        win = false;
        missCount = 0;
        maxMisses = 7;
        gameOver = false;
        hanged = false;
	}
	
	public void paint(Graphics g)
	{
		// highlight the "new word" button
		if (mouseOver)
			g.setColor(Color.white);
		else
			g.setColor(new Color(0x00eeeeee));
		// "new word" button
		g.fillRect(50, 60, 100, 30);
		g.setColor(new Color(0x00aaaaaa));
		g.drawRect(49, 59, 102, 32);
		g.setColor(Color.black);
		g.setFont(new Font("Helvetica", Font.BOLD, 16));
		g.drawString("new word", 64, 80);
		g.setFont(new Font("Helvetica", Font.BOLD, 32));
		// draw gallows
		// base
		g.drawLine(50,550,375,550);
		// vertical pole
		g.drawLine(150,550,150,150);
		// cross-bar
		g.drawLine(150,150,375,150);
		// rope
		g.drawLine(375,150,375,199);
		// draw blank lines and known characters
		for(int i=0; i<=(hiddenWord.length()-1)*2; i++)
		{
			if (i%2 == 0)
			{
				if (hiddenWord.charAt(i/2) != ' ')
					g.drawLine(i*15+225,100,(i+1)*15+225,100);
				if (knownChars[i/2] == true)
					g.drawString(""+hiddenWord.charAt(i/2), i*15+224, 95);
			}
		}
		// draw figure according to number of misses
		switch (missCount)
		{
		// string 'em up
		case 7: animateHang(g); break;
		// left arm
		case 6: g.drawLine(375,270,300,280);
		// right arm
		case 5: g.drawLine(375,270,450,280);
		// left leg
		case 4: g.drawLine(375,400,325,450);
		// right leg
		case 3: g.drawLine(375,400,425,450);
		// torso
		case 2: g.drawLine(375,250,375,400);
		// face
		case 1: {g.drawOval(349,199,51,51); g.setColor(new Color(0x00ffcc99)); g.fillOval(350,200,50,50);}
		}
		// display list of all character guesses
		g.setColor(Color.black);
		for(int i=0; i<guessList.length(); i++)
		{
			g.drawString(""+guessList.charAt(i),50+i*28,40);
		}
		// display winning acknowledgements, and display correct answer:
		// (to make up for a complete answer entry as well as single char guess)
		if (win == true)
		{
			// 0x00009900 is dark green
			g.setColor(new Color(0x00009900));
			g.drawString("You Win!",600,200);
			gameOver = true;
			for(int i=0; i<=(hiddenWord.length()-1)*2; i++)
			{
				if (i%2 == 0)
				{
					g.drawString(""+hiddenWord.charAt(i/2), i*15+224, 95);
				}
			}
		}
		// display losing acknowledgements, and display correct answer
		if (missCount == maxMisses)
		{
			g.setColor(Color.red);
			g.drawString("You Lose!",600,200);
			gameOver = true;
			for(int i=0; i<=(hiddenWord.length()-1)*2; i++)
			{
				if (i%2 == 0)
				{
					g.drawString(""+hiddenWord.charAt(i/2), i*15+224, 95);
				}
			}
		}
		
		// display number of misses
		g.setColor(Color.black);
		g.setFont(new Font("Helvetica", Font.BOLD, 16));
		g.drawString("Misses: "+missCount,155,168);
		
	}
	
	public String getHiddenWord() {
		// possible hidden words
		String[] wordList = {"thanksgiving","radio","car","you are cool","java","what is up man","seven","chris","elwell","right"};
		// chose one of those and generalize it with toLowerCase()
		hiddenWord = wordList[(int)(Math.random()*(wordList.length+1))];
		hiddenWord = hiddenWord.toLowerCase();
		
		return hiddenWord;
	}
	
	public boolean validateGuess(String guess)
	{
		if (guess.equalsIgnoreCase(hiddenWord))
			return true;
		else
			return false;
	}
	
	public void guessTheWord() 
	{
		guessWord = JOptionPane.showInputDialog(null, "Guess the entire word:");
		if (validateGuess(guessWord))
		{
			win = true;
		}
		else
		{
			// you lose
			missCount = maxMisses;
		}
	}

	public boolean keyDown(Event e, int k)
	{
		if (!gameOver)
		{
		boolean rightGuess = false;
		// Cast the "key pressed" to a character
		char keyChar = (char) k;
		if (keyChar != ' ')
		{
			// if character has previously been choosen, then get out of this method
			for(int i=0; i<guessList.length(); i++)
			{
				if (keyChar == guessList.charAt(i) || keyChar == guessList.toUpperCase().charAt(i))
					return true;
			}
			// concatenate the "key pressed" to the list of all chars pressed
			guessList = guessList+keyChar;
			// is the "key pressed" is one of the chars in the hidden word, then define it as known
			// in the knownChars array
			for(int i=0; i<hiddenWord.length(); i++)
			{
				if (keyChar == hiddenWord.charAt(i) || keyChar == hiddenWord.toUpperCase().charAt(i))
				{
					rightGuess = true;
					knownChars[i] = true;
				}				
			}
			// this loop makes "win = false" if there are any unknown characters
			// otherwise "win = true"
			win = true;
			for(int i=0; i<hiddenWord.length(); i++)
			{
				if (knownChars[i] == false)
				{
					win = false;
				}
			}
			if (rightGuess == false)
				missCount++;
		}
		else
		{
			// the user chose the spacebar, to guess the entire word
			guessTheWord();
		}

		repaint();
		}
		return true;
	}
		
	// to handle the "new word" button
	public boolean mouseDown(Event evt, int x, int y)
	{
		if ((x>50 && x<150) && (y>60 && y<90))
		{
			newGame();
			repaint();
		}
		return true;
	}
	
	public boolean mouseMove(Event evt, int x, int y)
	{
		// to detect crosses over the boundaries of the button
		// otherwise it would repaint needlessly
		boolean mouseToogle = mouseOver;
		if ((x>50 && x<150) && (y>60 && y<90))
		{
			mouseOver = true;
		}
		else
		{
			mouseOver = false;		
		}
		// if mouse comes into or exits button, then repaint() with or w/o highlights
		// except: void this is the animation will reoccur as a result of repainting
		if (mouseToogle != mouseOver && !hanged)
			repaint();
		
		return true;		
	}
		
	public void animateHang(Graphics g)
	{
		/* Animation of hanging:
		*  Make him grab his neck and make face flash colors from red down to blue purple.
		*/
		
		// this varible is need to tell MouseMove not to repaint() if already hanged, 
		// that would show the animation all over again. So, you have to sacrifice the
		// "new word" button highlight feature
		hanged = true;
		
		// first draw main skeleton
		g.setColor(Color.black);
		// arms
		g.drawLine(375,270,335,280);
		g.drawLine(375,270,415,280);
		g.drawLine(335,280,375,250);
		g.drawLine(415,280,375,250);
		// legs
		g.drawLine(375,400,350,375);
		g.drawLine(375,400,400,375);
		g.drawLine(350,375,350,400);
		g.drawLine(400,375,400,400);
		// torso
		g.drawLine(375,250,375,400);
		// face outline
		g.drawOval(349,199,51,51);
		// animate face hue
		int c;
		for (int i=0; i<220000; i++)
		{
			// every thousand to slow down
			c = i/1000;
			Color faceHue = new Color(255-c,0,c);
			g.setColor(faceHue);
			// draw the face with the current color
			g.fillOval(350,200,50,50);
		}
		
		// delete previous arms and legs
		g.setColor(bgColor);
		// arms
		g.drawLine(375,270,335,280);
		g.drawLine(375,270,415,280);
		g.drawLine(335,280,375,250);
		g.drawLine(415,280,375,250);
		// legs
		g.drawLine(375,400,350,375);
		g.drawLine(375,400,400,375);
		g.drawLine(350,375,350,400);
		g.drawLine(400,375,400,400);
		
		// clean up torso drawing (has been chopped by arm and leg removal)
		g.setColor(Color.black);
		g.drawLine(375,250,375,400);
		// redraw arms and legs in "dead" position
		// left arm
		g.drawLine(375,270,370,330);
		// right arm
		g.drawLine(375,270,380,330);
		// left leg
		g.drawLine(375,400,370,460);
		// right leg
		g.drawLine(375,400,380,460);
		
	}
	
}
