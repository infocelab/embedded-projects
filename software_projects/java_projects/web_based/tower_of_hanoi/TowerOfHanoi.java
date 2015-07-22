// <APPLET code = "TowerOfHanoi.class" width = "700" height = "500"></APPLET>

// Applet for the Tower Of Hanoi game

import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import javax.swing.*;

/**
 * This is the Tower of Hanoi game class
 */
public class TowerOfHanoi extends Applet implements ActionListener, 
													MouseListener, 
													MouseMotionListener {
	
	// Declaring Objects, GUI Components and variables
	ShowInstructions showInstructions;
	
	Arrow arrowUp,
		  arrowDown;
		  
	// Array of Discs
	Disc[] disc;
	
	// Array of Towers
	Tower[] tower;
	
	/** Number of moves made by the user */
	long moveCount;
	
	/** Whether the hand is holding a disc or empty */
	boolean holdingDisc;
	
	/** Number of Discs used in game */
	int numDisc;
	
	Button restartButton,
		   helpButton;
	
	Panel titlePanel,
		  diffPanel,
		  buttPanel,
		  northPanel;
	
	Label diffLabel,
		  titleLabel;
	
	JRadioButton threeDiscJRadio,
				 fourDiscJRadio,
				 fiveDiscJRadio,
				 sixDiscJRadio;
	
	ButtonGroup discButtonGroup;
	
	// Initialize variables and components
	public void init() {
		
		// Creating new Objects
		showInstructions = new ShowInstructions();
		
		arrowUp = new Arrow("up");
		arrowDown = new Arrow("down");
		
		tower = new Tower[3];
		
		for (int i=0;i<=2;i++) {
			tower[i] = new Tower();
		}
		
		disc = new Disc[6];
		
		for (int i=0;i<=5;i++) {
			disc[i] = new Disc();
		}
		
		// Applet settings
		setLayout(new FlowLayout());
		setBackground(new Color(155,200,200));
		addMouseListener(this);
		addMouseMotionListener(this);
		
		// Initializing JButton
		restartButton = new Button("Restart");
		restartButton.setFont(new Font("", Font.BOLD, 16));
		restartButton.addActionListener(this);
		
		helpButton = new Button("Instruction");
		helpButton.setFont(new Font("", Font.BOLD, 16));
		helpButton.addActionListener(this);
		
		// Initializing JPanel
		titlePanel = new Panel();
		buttPanel = new Panel();
		
		diffPanel = new Panel();
		diffPanel.setLayout(new FlowLayout());
		
		northPanel = new Panel();
		northPanel.setLayout(new BorderLayout(0,0));
		
		// Initializing JLabel
		diffLabel = new Label("Discs :");
		diffLabel.setFont(new Font("", Font.BOLD, 16));
		
		titleLabel = new Label("TOWER OF HANOI");
		titleLabel.setFont(new Font("", Font.BOLD, 44));
		titleLabel.setForeground(new Color(75,100,155));
		
		// Initializing JRadio buttons
		threeDiscJRadio = new JRadioButton("Three", true);
		threeDiscJRadio.setFont(new Font("", Font.BOLD, 14));
		threeDiscJRadio.setBackground(new Color(155,200,200));
		threeDiscJRadio.setForeground(Color.red);
		threeDiscJRadio.addActionListener(this);
		
		fourDiscJRadio = new JRadioButton("Four", false);
		fourDiscJRadio.setFont(new Font("", Font.BOLD, 14));
		fourDiscJRadio.setBackground(new Color(155,200,200));
		fourDiscJRadio.addActionListener(this);
		
		fiveDiscJRadio = new JRadioButton("Five", false);
		fiveDiscJRadio.setFont(new Font("", Font.BOLD, 14));
		fiveDiscJRadio.setBackground(new Color(155,200,200));
		fiveDiscJRadio.addActionListener(this);
		
		sixDiscJRadio = new JRadioButton("Six", false);
		sixDiscJRadio.setFont(new Font("", Font.BOLD, 14));
		sixDiscJRadio.setBackground(new Color(155,200,200));
		sixDiscJRadio.addActionListener(this);
		
		// Grouping radio buttons
		discButtonGroup = new ButtonGroup();
		discButtonGroup.add(threeDiscJRadio);
		discButtonGroup.add(fourDiscJRadio);
		discButtonGroup.add(fiveDiscJRadio);
		discButtonGroup.add(sixDiscJRadio);	
		
	}// End of method init

	/**
	 * Start of applet
	 */
	public void start() {
		
		titlePanel.add(titleLabel);
		
		buttPanel.add(restartButton);
		buttPanel.add(helpButton);
		
		diffPanel.add(diffLabel);
		diffPanel.add(threeDiscJRadio);
		diffPanel.add(fourDiscJRadio);
		diffPanel.add(fiveDiscJRadio);
		diffPanel.add(sixDiscJRadio);
		
		
		northPanel.add(titlePanel, BorderLayout.NORTH);
		northPanel.add(diffPanel, BorderLayout.CENTER);
		northPanel.add(buttPanel, BorderLayout.SOUTH);
		
		add(northPanel);
		
		// Default game starts 3 discs, Disc subscript 0 to 2
		numDisc = 2;
		
		gameStart();
	}// End of method start

	// Unused interface methods
	public void mouseEntered(MouseEvent me) { }
	public void mouseExited(MouseEvent me) { }
	public void mouseClicked(MouseEvent me) { }
	public void mouseReleased(MouseEvent me) { }
	public void mouseDragged(MouseEvent me) { }
	
	public void mouseMoved(MouseEvent me) {
		updateArrows(me.getX(),me.getY());
	}

	public void mousePressed(MouseEvent me) { 
		updateArrows(me.getX(),me.getY());
		updateDiscs(me.getX(),me.getY());
	}

	/**
	 * Method to trap button and radiobutton events
	 */
	public void actionPerformed(ActionEvent e) {
	
		// Show help dialog 
		if (e.getSource() == helpButton) {
			showInstructions.show();
		}	
		
		// Reset and restart the game
		if (e.getSource() == restartButton) {
			gameStart();
		}	

		if (e.getSource() == threeDiscJRadio ||
			e.getSource() == fourDiscJRadio ||
			e.getSource() == fiveDiscJRadio ||
			e.getSource() == sixDiscJRadio) {
				
			threeDiscJRadio.setForeground(Color.black);
			fourDiscJRadio.setForeground(Color.black);
			fiveDiscJRadio.setForeground(Color.black);
			sixDiscJRadio.setForeground(Color.black);
			
			if (threeDiscJRadio.isSelected() == true) {
				threeDiscJRadio.setForeground(Color.red);
				numDisc = 2; // Subscript start from 0
			}
			if (fourDiscJRadio.isSelected() == true) {
				fourDiscJRadio.setForeground(Color.red);	
				numDisc = 3;
			}
			if (fiveDiscJRadio.isSelected() == true) {
				fiveDiscJRadio.setForeground(Color.red);	
				numDisc = 4;
			}
			if (sixDiscJRadio.isSelected() == true) {
				sixDiscJRadio.setForeground(Color.red);	
				numDisc = 5;
			}	
		}
	}// End of method actionPerformed

	/**
	 * Method to display all graphics of the game
	 */
	public void paint(Graphics g) {
		
		// Draw the 3 tower
		g.setColor(new Color(242,185,13));
		g.fillRoundRect(140,240,20,165,5,5);
		g.fillRoundRect(340,240,20,165,5,5);
		g.fillRoundRect(540,240,20,165,5,5);
		
		g.setColor(new Color(0,0,0));
		g.drawRoundRect(140,240,20,165,5,5);
		g.drawRoundRect(340,240,20,165,5,5);
		g.drawRoundRect(540,240,20,165,5,5);

		// Draw the table base
		g.setColor(new Color(242,185,13));
		g.fillRoundRect(50,400,600,25,5,5);
		g.setColor(new Color(0,0,0));
		g.drawRoundRect(50,400,600,25,5,5);
		
		
		// Display the moves the user has made
		g.setColor(Color.black);
		g.setFont(new Font("", Font.BOLD, 20));
		g.drawString("Moves: " + moveCount,300,460);
		
		// Display the arrows
		if (arrowUp.getVisible() == true) {
			g.setColor(Color.red);
			g.fillPolygon(arrowUp.getPolyX(),
						  arrowUp.getPolyY(),
						  arrowUp.getPolyX().length);
			g.setColor(Color.black);
			g.drawPolygon(arrowUp.getPolyX(),
						  arrowUp.getPolyY(),
						  arrowUp.getPolyX().length);
		}
		
		if (arrowDown.getVisible() == true) {
			g.setColor(Color.red);
			g.fillPolygon(arrowDown.getPolyX(),
						  arrowDown.getPolyY(),
						  arrowDown.getPolyX().length);
			g.setColor(Color.black);
			g.drawPolygon(arrowDown.getPolyX(),
						  arrowDown.getPolyY(),
						  arrowDown.getPolyX().length);
		}
		
		// Display the game discs
		for (int i=0;i<=5;i++) {
			
			// Only draw discs that are used in the game
			if (disc[i].isUsed() == true) {

				int discWidth,
					discDrawX,
					discDrawY;
				
				// Set disc width
				discWidth = 60 + (disc[i].getSize() * 20);
				
				// Set tower location
				discDrawX = 50 + (disc[i].getTower() * 200);
				
				// Set disc size X-offset
				discDrawX = discDrawX + (100 - discWidth/2);
				
				// Set level location
				discDrawY = 280 + ((5 - disc[i].getLevel()) * 20);
				
				if (disc[i].isSelected() == true) {
					g.setColor(new Color(234,115,115));
				}
				else {
					g.setColor(new Color(84,99,233));
				}
				
				g.fillRoundRect(discDrawX,discDrawY,discWidth,20,25,25);
				g.setColor(Color.black);
				g.drawRoundRect(discDrawX,discDrawY,discWidth,20,25,25);
			}
		}
	}// End of paint method

	/**
	 * Method to update the arrows displayed
	 */
	public void updateArrows(int posX, int posY) {
		int movedX = posX;
		int movedY = posY;
		
		// No disc is currently selected to be moved
		if (holdingDisc == false) { 
			
			// If mouse is within play area
			if (movedX>50 &&
				movedX<650 &&
				movedY>160 &&
				movedY<400) {

				arrowUp.setVisible(true);
				arrowDown.setVisible(false);
				
				// 1st Tower
				if (movedX<250 && arrowUp.getCurrentTower()!=0) {
					arrowUp.hand(0);
					repaint();
				}
				
				// 2nd Tower
				if (movedX>250 && movedX<450 && arrowUp.getCurrentTower()!=1) {
					arrowUp.hand(1);
					repaint();
				}
				
				// 3rd Tower
				if (movedX>450 && arrowUp.getCurrentTower()!=2) {
					arrowUp.hand(2);
					repaint();
				}
			}
			else {
				if (arrowUp.getVisible() == true || 
					arrowDown.getVisible() == true) {
						
					arrowUp.setVisible(false);
					arrowDown.setVisible(false);
					repaint();
				}
			}
		}

		// A Disc is currently selected to be moved
		if (holdingDisc == true) { 
			
			// If mouse is within play area
			if (movedX>50 &&
				movedX<650 &&
				movedY>160 &&
				movedY<400) {

				arrowUp.setVisible(false);
				arrowDown.setVisible(true);
				
				// 1st Tower
				if (movedX<250 && arrowDown.getCurrentTower()!=0) {
					arrowDown.hand(0);
					repaint();
				}
				
				// 2nd Tower
				if (movedX>250 && movedX<450 && arrowDown.getCurrentTower()!=1) {
					arrowDown.hand(1);
					repaint();
				}
				
				// 3rd Tower
				if (movedX>450 && arrowDown.getCurrentTower()!=2) {
					arrowDown.hand(2);
					repaint();
				}
			}
			// Fall outside of detectable area
			else {
				if (arrowUp.getVisible() == true || 
					arrowDown.getVisible() == true) {
						
					arrowUp.setVisible(false);
					arrowDown.setVisible(false);
					repaint();
				}
			}
		}		
	} // End of method updateArrows

	/**
	 * Method to update the discs displayed
	 */
	public void updateDiscs(int posX, int posY) {
		
		int clickedX = posX;
		int clickedY = posY;
		
		// Perform a drop disc action
		if (holdingDisc == true) {
			
			// If mouse is within play area
			if (clickedX>50 &&
				clickedX<650 &&
				clickedY>160 &&
				clickedY<400) {
				
				int discOnHand=-1;
				
				for (int i=0;i<=5;i++) {
					if (disc[i].isSelected() == true) {
						discOnHand = i;
						break;
					}
				}
				
				// 1st Tower
				if (clickedX<250) {
					dropDisc(0,disc[discOnHand].getSize());
				}
				
				// 2nd Tower
				if (clickedX>250 && clickedX<450) {
					dropDisc(1,disc[discOnHand].getSize());
				}
				
				// 3rd Tower
				if (clickedX>450) {
					dropDisc(2,disc[discOnHand].getSize());		
				}
				repaint();
				checkWinCondition();
			}			
		}
		
		// Perform a pickup disc action
		else {
			
			// If mouse is within play area
			if (clickedX>50 &&
				clickedX<650 &&
				clickedY>160 &&
				clickedY<400) {
					
				// 1st Tower
				if (clickedX<250) {
					pickupDisc(0);
				}
				
				// 2nd Tower
				if (clickedX>250 && clickedX<450) {
					pickupDisc(1);
				}
				
				// 3rd Tower
				if (clickedX>450) {
					pickupDisc(2);					
				}
				repaint();
			}
		}
	}// End of method updateDiscs
	
	/**
	 * Method to drop a disc onto a Tower
	 */
	public void dropDisc(int destTower, int discSize)
	{
		dropCheck:
		
		// Perform a level by level check for empty space
		for (int i=0;i<=5;i++) {
			
			// If found an empty slot
			if (tower[destTower].getLevel(i) == false) {
				
				// If empty slot is at tower base, auto drop
				if (i == 0) {
					tower[destTower].setLevel(i,true);
					disc[discSize].setTower(destTower);
					disc[discSize].setLevel(0);
					disc[discSize].setSelected(false);
					
					moveCount++;
					holdingDisc = false;
				}
				// If empty slot is above a disc
				else {
					
					// Perform a disc by disc check
					for (int j=0;j<=5;j++) {
						
						/* 
						 * If disc is used, located on the same tower,
						 * occupying the level below the current checking
						 * level, AND has the size BIGGER than the size
						 * of the current disc being drop 
						 */
						if (disc[j].isUsed() == true &&
							disc[j].getTower() == destTower &&
							disc[j].getLevel() == i-1 &&
							disc[j].getSize() > discSize) {
								
							// Perform the drop
							tower[destTower].setLevel(i,true);
							disc[discSize].setTower(destTower);
							disc[discSize].setLevel(i);
							disc[discSize].setSelected(false);
							
							moveCount++;
							holdingDisc = false;
							
							break dropCheck;
						}
					}
				}
			}
		}
	} // End of method dropDisc

	/**
	 * Method to reset all variables to start a new game
	 */
	public void gameStart() {
		
		holdingDisc = false;
	
		for (int i=0;i<=5;i++) {
			// Reset discs
			disc[i].setUsed(false);
			
			for (int j=0;j<=2;j++) {
				// Reset towers
				tower[j].setLevel(i,false);
			}
		}
		
		// Populate the towers with discs
		dropInitDisc(numDisc);
		
		moveCount = 0;
		
		repaint();
		
	}// End of method gameStart

	/**
	 * Method to determine wheter the winning conditions are met
	 */
	public void checkWinCondition() {
		
		boolean win = true;
		
		for (int i=0;i<=5;i++)
		{
			if (disc[i].isUsed() == true &&
				disc[i].getTower() != 2) {
				
				win = false;
			}
		}
		
		if (win == true) {
			JOptionPane.showMessageDialog(this, 
			"You have won the game in " + moveCount + " moves.",
			"Congratulations!", JOptionPane.INFORMATION_MESSAGE);
			
			gameStart();
		}
		
	}// End of method checkWinCondition

	/**
	 * Method to drop an initial set of disc for game start
	 */
	public void dropInitDisc(int amount) {
		
		// Drop from big discs to small discs
		for (int i=5;i>=(5-amount);i--) { 
			disc[i].setUsed(true);
			dropDisc(0,i);
		}
	}// End of method dropInitDisc

	/**
	 * Method to perform the pickup disc from tower
	 */
	public void pickupDisc(int sourceTower) {
					
		// Check from small discs to big discs
		for (int i=0;i<=5;i++) {
			if (disc[i].isUsed() == true &&
				disc[i].getTower() == sourceTower) {
								
				// Pickup a disc
				disc[i].setSelected(true);
							
				// Clear the place the disc is picked from
				tower[sourceTower].setLevel(disc[i].getLevel(),false);
				
				holdingDisc = true;							
				
				break;
			}
		}
		repaint();		
		
	}// End of method pickupDisc

} // End of class TowerOfHanoi

/**
 * This class shows the instruction guide frame
 */
class ShowInstructions extends JFrame implements ActionListener{
	
	String instruction;
	
	Frame helpFrame;
	
	Button closeButton;
	
	TextArea helpTextArea;
	
	// Initialize components
	public ShowInstructions() {
		
		instruction = "The purpose of the game is to get the 3 discs " +
					  "stacked up on the right-most peg. However, 2 rules " +
					  "apply. You may only move 1 disc at a time. You may " +
					  "only place a disc on an empty peg or on top of a " +
					  "larger disc. You may not place a larger disc on a " +
					  "smaller disc.";
		
		helpFrame = new Frame("Game Instructions");
		helpFrame.setLayout(new BorderLayout());

		// Centering the frame on the desktop
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameSize = helpFrame.getSize();
		helpFrame.setLocation(((screenSize.width - frameSize.width) / 2),
							((screenSize.height - frameSize.height) / 2));		
	
		closeButton = new Button("Close");
		closeButton.setFont(new Font("",Font.BOLD,14));
		closeButton.addActionListener(this);
		
		helpTextArea = new TextArea(instruction,5,50, TextArea.SCROLLBARS_NONE);
		helpTextArea.setFont(new Font("",Font.BOLD, 14));
		
		helpFrame.add(helpTextArea, BorderLayout.NORTH);
		helpFrame.add(closeButton, BorderLayout.SOUTH);	
	}

	/**
	 * Method to show the help frame to the user
	 */
	public void show() {
		helpFrame.pack();
		helpFrame.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == closeButton) {
			helpFrame.setVisible(false);
		}
	}
} // Enf of class ShowInstructions

/**
 * This is the disc object used in the game
 */
class Disc {
	
	private boolean used,
					selected;
	
	private int size,
				onTower,
				onLevel;
		
	private static int sizeCounter = 0;
		
	// Initialize a new disc size for every disc created
	public Disc() {			
			
		size = sizeCounter;
		used = false;
		selected = false;
		
		onTower = 0;
		onLevel = sizeCounter;
		
		sizeCounter++;
	}
	
	/**
	 * Method to set the selected state of the disc
	 */
	public void setSelected(boolean state) {
		selected = state;
	}//End of method setSelected
	
	/**
	 * Method to set whether the game disc is used
	 */
	public void setUsed(boolean state) {
		used = state;	
	}// End of method setUsed
	
	/**
	 * Method to get the disc tower position
	 */
	public int getTower() {
		return onTower;
	}// End of method getTower
	
	/**
	 * Method to get the disc level location
	 */
	public int getLevel() {
		return onLevel;
	}// End of method getLevel
		
	/**
	 * Method to set the disc tower location
	 */
	public void setTower(int towerNum) {
		onTower = towerNum;
	}// End of method setTower
	
	/**
	 * Method to set the disc level position
	 */
	public void setLevel(int levelNum) {
		onLevel = levelNum;
	}// End of method setLevel
	
	
	/**
	 * Method to return whether the disc is used in the game
	 */
	public boolean isUsed() {
		return used;
	}// End of method isUsed

	/**
	 * Method to return whether the disc is selected
	 */
	public boolean isSelected() {
		return selected;
	}// End of method isSelected
	
	/**
	 * Method to get the size of the disc
	 */
	public int getSize() {
		return size;
	}// End of method getSize
	
} // End of class Disc

/**
 * This is the tower object used in the game
 */
class Tower {
	
	//** Mark whether the specified level of the tower is used */
	private boolean level[];
					   
	public Tower() {
		level = new boolean[6];
		for (int i=0;i<=5;i++) {
			level[i] = false;
		}
	}
	
	/**
	 * Method to get the occupied state of the tower level
	 */
	public boolean getLevel(int requestedLevel) {
		return level[requestedLevel];
	}// End of method getLevel
	
	/**
	 * Method to set the occupied state of the tower level
	 */
	public void setLevel(int targetLevel, boolean state) {
		level[targetLevel] = state;
	}// End of method setLevel
							
} // End of class Tower

/**
 * This class manipulates the up/down arrows displayed to the user
 */
class Arrow {
	
	// Booleans used to mark whether to display a specific arrow
	boolean visible;
	
	private int polyX[] = {0,0,0,0,0,0,0},
	    		polyY[] = {0,0,0,0,0,0,0},
	    		dPolyX[] = {0,0,0,0,0,0,0},
	    		dPolyY[] = {0,0,0,0,0,0,0},
	    		modX = 125,
	    		modY = 170,
	    		currentTower;
	 
	// Initialize variables	
	public Arrow(String direction) {

		currentTower = -1;
		visible = false;
		
		// Initialize the UP arrow polygon
		if (direction == "up") {
		
			polyX[0] = 25 + modX;
			polyX[1] = 50 + modX;
			polyX[2] = 35 + modX;
			polyX[3] = 35 + modX;
			polyX[4] = 15 + modX;
			polyX[5] = 15 + modX;
			polyX[6] = 0 + modX;

			polyY[0] = 0 + modY;
			polyY[1] = 25 + modY;
			polyY[2] = 25 + modY;
			polyY[3] = 50 + modY;
			polyY[4] = 50 + modY;
			polyY[5] = 25 + modY;
			polyY[6] = 25 + modY;
		}
		
		// Initialize the DOWN arrow polygon
		if (direction == "down") {
			
			polyX[0] = 15 + modX;
			polyX[1] = 35 + modX;
			polyX[2] = 35 + modX;
			polyX[3] = 50 + modX;
			polyX[4] = 25 + modX;
			polyX[5] = 0 + modX;
			polyX[6] = 15 + modX;

			polyY[0] = 0 + modY;
			polyY[1] = 0 + modY;
			polyY[2] = 25 + modY;
			polyY[3] = 25 + modY;
			polyY[4] = 50 + modY;
			polyY[5] = 25 + modY;
			polyY[6] = 25 + modY;
		}
	}
	
	// Set the UP/DOWN arrow for a specific tower
	public void hand(int fromTower) {
		
		currentTower = fromTower;
		visible = true;
					
		// Positions the arrow at the top of the tower
		for (int i=0;i<=6;i++) {
			dPolyX[i] = polyX[i] + (200 * fromTower);
			dPolyY[i] = polyY[i];
		}			
	}
	
	/**
	 * Method to get the current tower the arrow is at
	 */
	public int getCurrentTower() {
		return currentTower;
	}// End of method getCurrentTower
	
	/**
	 * Method to set the current tower the arrow is at
	 */
	public void setCurrentTower(int targetTower) {
		currentTower = targetTower;
	}// End of method setCurrentTower
	
	/**
	 * Method to get polygon X coordinates
	 */
	public int[] getPolyX() {
		return dPolyX;
	}// End of method getPolyX
	
	/**
	 * Method to get polygon Y coordinates
	 */
	public int[] getPolyY() {
		return dPolyY;
	}// End of method getPolyY
	
	/**
	 * Method to set the visible state of the arrow
	 */
	public void setVisible(boolean state) {
		visible = state;
	}// End of method setVisible
	
	/**
	 * Method to get the visibility state of the arrow
	 */
	public boolean getVisible() {
		return visible;
	}// End of method getVisible
	 
} // End of class Arrow