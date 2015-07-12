package connect;

import java.awt.*;
import static java.awt.Color.GREEN;
import java.awt.event.*;
import java.sql.SQLException;
import javax.swing.*;
import javax.swing.JFrame;
/**
 * Tic-Tac-Toe: Two-player Graphics version with Simple-OO
 */
@SuppressWarnings("serial")
public class TTTGraphics2P extends JFrame {
   // Named-constants for the game board
   public static final int ROWS = 8;  // ROWS by COLS cells
   public static final int COLS = 8;
 
   // Named-constants of the various dimensions used for graphics drawing
   public static final int CELL_SIZE = 50; // cell width and height (square)
   public static final int CANVAS_WIDTH = CELL_SIZE * COLS;  // the drawing canvas
   public static final int CANVAS_HEIGHT = CELL_SIZE * ROWS;
   public static final int GRID_WIDTH = 2;                   // Grid-line's width
   public static final int GRID_WIDHT_HALF = GRID_WIDTH / 2; // Grid-line's half-width
   // Symbols (cross/nought) are displayed inside a cell, with padding from border
   public static final int CELL_PADDING = CELL_SIZE / 6;
   public static final int SYMBOL_SIZE = CELL_SIZE - CELL_PADDING * 2; // width/height
   public static final int SYMBOL_STROKE_WIDTH = 8; // pen's stroke width
 
   // Named-constants of the various dimensions used for score board drawing
   public static final int T_ROWS = 4;  // ROWS by COLS cells
   public static final int T_COLS = 4;
   public static final int T_CELL_SIZE = 50; // cell width and height (square)
   public static final int T_GRID_WIDTH = 2;                   // Grid-line's width
   public static final int T_GRID_WIDHT_HALF = T_GRID_WIDTH / 2; // Grid-line's half-width
   public static int P1_SCORE = 0;
   public static int P2_SCORE = 0;
   public static int T_FONT_SIZE = 18;
   public static int T_OFFSET_HOR = 400;
   public static int T_OFFSET_VER = 80;
   
   // Use an enumeration (inner class) to represent the various states of the game
   public enum GameState {
      PLAYING, DRAW, CROSS_WON, NOUGHT_WON
   }
   private GameState currentState;  // the current game state
 
   // Use an enumeration (inner class) to represent the seeds and cell contents
   public enum Seed {
      EMPTY, CROSS, NOUGHT
   }
   private Seed currentPlayer;  // the current player
 
   private Seed[][] board   ; // Game board of ROWS-by-COLS cells
   private DrawCanvas canvas; // Drawing canvas (JPanel) for the game board
  
   private JLabel statusBar;  // Status Bar
 
   /** Constructor to setup the game and the GUI components */
   
   public TTTGraphics2P() {
       
      canvas = new DrawCanvas();  // Construct a drawing canvas (a JPanel)
     
      canvas.setPreferredSize(new Dimension(CANVAS_WIDTH + T_OFFSET_HOR, CANVAS_HEIGHT+T_OFFSET_VER));
 
      // The canvas (JPanel) fires a MouseEvent upon mouse-click
      canvas.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {  // mouse-clicked handler
            int mouseX = e.getX();
            int mouseY = e.getY();
            if(mouseX > 530  && mouseY > 150  )
                if( mouseX< 608&& mouseY< 170)
            {
                try
        {
            //this.
            new myshow().setVisible(true);
        }catch(HeadlessException u)
        {    
            JOptionPane.showMessageDialog(null, u);
        }
          
              //this.setVisible(false);
             //JOptionPane.showMessageDialog (null, "OK");
            }
            
            System.out.println("value of X="+mouseX);
            System.out.println("value of Y="+mouseY);
            // Get the row and column clicked
            int rowSelected = mouseY / CELL_SIZE;
            int colSelected = mouseX / CELL_SIZE;
 
            if (currentState == GameState.PLAYING) {
               if (rowSelected >= 0 && rowSelected < ROWS && colSelected >= 0
                     && colSelected < COLS && board[rowSelected][colSelected] == Seed.EMPTY) {
                  board[rowSelected][colSelected] = currentPlayer; // Make a move
                  updateGame(currentPlayer, rowSelected, colSelected); // update state
                  // Switch player
                  currentPlayer = (currentPlayer == Seed.CROSS) ? Seed.NOUGHT : Seed.CROSS;
               }
            } else {       // game over
               initGame(); // restart the game
            }
            // Refresh the drawing canvas
            repaint();  // Call-back paintComponent().
            
         }

          private void setVisible(boolean b) {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }
      });
 
      // Setup the status bar (JLabel) to display status message
      statusBar = new JLabel("  ");
      statusBar.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 15));
      statusBar.setBorder(BorderFactory.createEmptyBorder(2, 5, 4, 5));
 
      Container cp = getContentPane();
      cp.setLayout(new BorderLayout());
      cp.add(canvas, BorderLayout.CENTER);
      cp.add(statusBar, BorderLayout.PAGE_END); // same as SOUTH
      
 
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      pack();  // pack all the components in this JFrame
      setTitle("Tic Tac Toe");
      setVisible(true);  // show this JFrame
 
      board = new Seed[ROWS][COLS]; // allocate array
      initGame(); // initialize the game board contents and game variables
   }
    
   
   /** Initialize the game-board contents and the status */
   public void initGame() {
      for (int row = 0; row < ROWS; ++row) {
         for (int col = 0; col < COLS; ++col) {
            board[row][col] = Seed.EMPTY; // all cells empty
         }
      }
      currentState = GameState.PLAYING; // ready to play
      currentPlayer = Seed.CROSS;       // cross plays first
   }
 
   /** Update the currentState after the player with "theSeed" has placed on
       (rowSelected, colSelected). */
   public void updateGame(Seed theSeed, int rowSelected, int colSelected) {
      if (hasWon(theSeed, rowSelected, colSelected)) {  // check for win
         currentState = (theSeed == Seed.CROSS) ? GameState.CROSS_WON : GameState.NOUGHT_WON;
      } else if (isDraw()) {  // check for draw
         currentState = GameState.DRAW;
      }
      // Otherwise, no change to current state (still GameState.PLAYING).
   }
 
   /** Return true if it is a draw (i.e., no more empty cell) */
   public boolean isDraw() {
      for (int row = 0; row < ROWS; ++row) {
         for (int col = 0; col < COLS; ++col) {
            if (board[row][col] == Seed.EMPTY) {
               return false; // an empty cell found, not draw, exit
            }
         }
      }
      return true;  // no more empty cell, it's a draw
   }
 
   /** Return true if the player with "theSeed" has won after placing at
       (rowSelected, colSelected) */
   public boolean hasWon(Seed theSeed, int rowSelected, int colSelected) {
      return (board[rowSelected][0] == theSeed  // 3-in-the-row
            && board[rowSelected][1] == theSeed
            && board[rowSelected][2] == theSeed
       || board[0][colSelected] == theSeed      // 3-in-the-column
            && board[1][colSelected] == theSeed
            && board[2][colSelected] == theSeed
       || rowSelected == colSelected            // 3-in-the-diagonal
            && board[0][0] == theSeed
            && board[1][1] == theSeed
            && board[2][2] == theSeed
       || rowSelected + colSelected == 2  // 3-in-the-opposite-diagonal
            && board[0][2] == theSeed
            && board[1][1] == theSeed
            && board[2][0] == theSeed);
      
   }
 
   /**
    *  Inner class DrawCanvas (extends JPanel) used for custom graphics drawing.
    */
   
   class DrawCanvas extends JPanel {
      @Override
      public void paintComponent(Graphics g) {  // invoke via repaint()
         super.paintComponent(g);    // fill background
         setBackground(Color.WHITE); // set its background color
         //g.drawString("abc", ROWS, ROWS);
         char [] a = { 'A' };
         g.drawChars(a, 0, 1, 415, 28);
         char [] b = { 'B' };
         g.drawChars(b, 0, 1, 415, 75);
          char [] c = { 'C' };
         g.drawChars(c, 0, 1, 415, 125);
         char [] d = { 'D' };
         g.drawChars(d, 0, 1, 415, 176);
         char [] e = { 'E' };
         g.drawChars(e, 0, 1, 415, 221);
         char [] f = { 'F' };
         g.drawChars(f, 0, 1, 415, 274);
         char [] g1 = { 'G' };
         g.drawChars(g1, 0, 1, 415, 326);
         char [] h = { 'H' };
         g.drawChars(h, 0, 1, 415, 376);
         char [] i = { '1' };
         g.drawChars(i, 0, 1, 24, 418);
         char [] j = { '2' };
         g.drawChars(j, 0, 1, 75, 418);
         char [] k = { '3' };
         g.drawChars(k, 0, 1, 124, 418);
         char [] l = { '4' };
         g.drawChars(l, 0, 1, 174, 418);
         char [] m = { '5' };
         g.drawChars(m, 0, 1, 224, 418);
         char [] n = { '6' };
         g.drawChars(n, 0, 1, 274, 418);
         char [] o = { '7' };
         g.drawChars(o, 0, 1, 324, 418);
         char [] p = { '8' };
         g.drawChars(p, 0, 1, 374, 418);
         
         // Draw the grid-lines
        g.setColor(Color.BLACK);
         for (int row = 1; row <= ROWS; ++row) {
            g.fillRoundRect(0, CELL_SIZE * row - GRID_WIDHT_HALF,
                  CANVAS_WIDTH-1, GRID_WIDTH, 0, 0);
         }
         for (int col = 1; col <= COLS; ++col) {
            g.fillRoundRect(CELL_SIZE * col - GRID_WIDHT_HALF, 0,
                  GRID_WIDTH, CANVAS_HEIGHT-1, 0, 0);
         }
         g.setColor(Color.GREEN);
         g.fillRoundRect(530,150,80, 20, 0, 0);
          g.setColor(Color.BLACK);
         g.drawString("BOOK", 552, 165); 
         // g.drawString("BOOK", 569, 160);       
      // char [] rgc = { 'B', 'O', 'O', 'K' };
       // g.drawChars(rgc, 0, 4, 569, 160);
        
         
         // Draw the Seeds of all the cells if they are not empty
         // Use Graphics2D which allows us to set the pen's stroke
         Graphics2D g2d = (Graphics2D)g;
         g2d.setStroke(new BasicStroke(SYMBOL_STROKE_WIDTH, BasicStroke.CAP_ROUND,
               BasicStroke.JOIN_ROUND));  // Graphics2D only
         for (int row = 0; row < ROWS; ++row) {
            for (int col = 0; col < COLS; ++col) {
               int x1 = col * CELL_SIZE ;
               int y1 = row * CELL_SIZE ;
               if (board[row][col] != Seed.EMPTY) {
                  
               
                  g2d.setColor(Color.RED);
                  g2d.fillRect(x1, y1,CELL_SIZE-1 , CELL_SIZE-1);
                  
               }
               /*if (board[row][col] == Seed.CROSS) {
                  g2d.setColor(Color.RED);
                  int x2 = (col + 1) * CELL_SIZE - CELL_PADDING;
                  int y2 = (row + 1) * CELL_SIZE - CELL_PADDING;
                  //g2d.drawLine(x1, y1, x2, y2);
                  //g2d.drawLine(x2, y1, x1, y2);
                  g2d.fillRect(x1, y1,CELL_SIZE , CELL_SIZE);
                  
               } else if (board[row][col] == Seed.NOUGHT) {
                  g2d.setColor(Color.BLUE);
                  g2d.drawOval(x1, y1, SYMBOL_SIZE, SYMBOL_SIZE);
               }
               */
            }
         }
 
         // Print status-bar message
      /*   if (currentState == GameState.PLAYING) {
            statusBar.setForeground(Color.BLACK);
            if (currentPlayer == Seed.CROSS) {
               statusBar.setText("X's Turn");
            } else {
               statusBar.setText("O's Turn");
            }
         } else if (currentState == GameState.DRAW) {
            statusBar.setForeground(Color.RED);
            statusBar.setText("It's a Draw! Click to play again.");
         } else if (currentState == GameState.CROSS_WON) {
            statusBar.setForeground(Color.RED);
            statusBar.setText("'X' Won! Click to play again.");
            P1_SCORE++;
         } else if (currentState == GameState.NOUGHT_WON) {
            statusBar.setForeground(Color.RED);
            statusBar.setText("'O' Won! Click to play again.");
            P2_SCORE++;
         }
     */ }
   }
 
   /** The entry main() method
     * @param args */
   
   public static void main(String[] args) {
       JFrame frame = new JFrame();
      // Run GUI codes in the Event-Dispatching thread for thread safety
      SwingUtilities.invokeLater(new Runnable() {
         @Override
         public void run() {
            //new TTTGraphics2P().setVisible(true);
             new myshow().setVisible(true);
            //this.setVisible(true); // Let the constructor do the job
         }
      });
   }
}