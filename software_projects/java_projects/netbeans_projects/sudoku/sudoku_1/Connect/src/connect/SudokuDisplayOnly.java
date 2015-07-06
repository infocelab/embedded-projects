import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
 
public class SudokuDisplayOnly extends JFrame {
   // Name-constants for the various dimensions
   public static final int ROWS = 9; // ROWS by COLS cells
   public static final int COLS = 9;
   public static final int CELL_SIZE = 60; // Cell width/height
   public static final int CANVAS_WIDTH = CELL_SIZE * COLS;
   public static final int CANVAS_HEIGHT = CELL_SIZE * ROWS;
 
   // Game board
   private int[][] cells;
   private JTextField[][] tfCells;
 
   // Puzzle to solve. Can have more and pick one in random.
   private int[][] puzzle =
      {{5, 3, 4, 6, 7, 8, 9, 1, 2},
       {6, 7, 2, 1, 9, 5, 3, 4, 8},
       {1, 9, 8, 3, 4, 2, 5, 6, 7},
       {8, 5, 9, 7, 6, 1, 4, 2, 3},
       {4, 2, 6, 8, 5, 3, 7, 9, 1},
       {7, 1, 3, 9, 2, 4, 8, 5, 6},
       {9, 6, 1, 5, 3, 7, 2, 8, 4},
       {2, 8, 7, 4, 1, 9, 6, 3, 5},
       {3, 4, 5, 2, 8, 6, 1, 7, 9}};
 
   // Mask for puzzle should be generated randomly
   private boolean[][] mask =
      {{false, false, false, false, false, true, false, false, false},
       {false, false, false, false, false, false, false, false, true},
       {false, false, true, false, false, false, false, false, false},
       {true, false, false, false, false, false, false, false, false},
       {false, false, false, true, false, false, false, false, false},
       {false, false, false, false, false, false, true, false, false},
       {false, false, false, false, false, false, false, true, false},
       {false, true, false, false, false, false, false, false, false},
       {false, false, false, false, true, false, false, false, false}};
 
   /** Constructor to setup the game and the GUI */
   public SudokuDisplayOnly() {
      Container cp = getContentPane();
      cp.setLayout(new GridLayout(ROWS, COLS));
 
      cells = new int[ROWS][COLS];
      tfCells = new JTextField[ROWS][COLS]; // allocate JTextField array
 
      // Create 9x9 JTextFields and place on the GridLayout
      for (int row = 0; row < ROWS; ++row) {
         for (int col = 0; col < COLS; ++col) {
            tfCells[row][col] = new JTextField(); // allocate element of array
            cp.add(tfCells[row][col]);  // ContentPane adds JTextField
            int number = puzzle[row][col];
            if (mask[row][col]) {
               cells[row][col] = 0;
               tfCells[row][col].setText("");  // empty
               tfCells[row][col].setEditable(true);
               tfCells[row][col].setBackground(Color.YELLOW);
            } else {
               cells[row][col] = number;
               tfCells[row][col].setText(number + "");
               tfCells[row][col].setEditable(false);
            }
            tfCells[row][col].setHorizontalAlignment(JTextField.CENTER);
            tfCells[row][col].setFont(new Font("Monospaced", Font.BOLD, 20));
         }
      }
      cp.setPreferredSize(new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT));
 
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      pack();
      setTitle("Sudoku");
      setVisible(true);
   }
 
   /** The entry main() entry method */
   public static void main(String[] args) {
      // Run the GUI construction on the event-dispatching thread for thread safety
      javax.swing.SwingUtilities.invokeLater(new Runnable() {
         @Override
         public void run() {
            new SudokuDisplayOnly(); // Let the constructor do the job
         }
      });
   }
   
}