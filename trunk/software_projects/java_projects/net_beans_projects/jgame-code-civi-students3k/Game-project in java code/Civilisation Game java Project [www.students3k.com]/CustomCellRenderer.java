import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;

/**
 * Title:       CustomCellRenderer
 * Description: This class is used for displaying pictures in a JTable
 * @author:     Shane Grund
 * @version:    1.0
 */
class CustomCellRenderer extends JLabel implements TableCellRenderer {
      private boolean isSelected;
      private boolean hasFocus;
      private ImageIcon[] suitImages;

      /**
       * This constructor sets up all the images to be
       * used in the JTable
       */
      public CustomCellRenderer()
      {
            suitImages = new ImageIcon[9];
            suitImages[1] = new ImageIcon("images/units/settler.png");
            suitImages[2] = new ImageIcon("images/units/warrior.png");
            suitImages[3] = new ImageIcon("images/units/spearman.png");
            suitImages[4] = new ImageIcon("images/units/archer.png");
            suitImages[5] = new ImageIcon("images/units/swordsman.png");
            suitImages[6] = new ImageIcon("images/units/catapult.png");
            suitImages[7] = new ImageIcon("images/units/galley.png");
            suitImages[8] = new ImageIcon("images/units/horseman.png");
      }//end constructor

      /**
       * This method sets up each row for everything inside JTable
       * @param table JTable
       * @param value Object
       * @param isSelected boolean
       * @param hasFocus boolean
       * @param row int
       * @param column int
       * @return Component
       */
      public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
      {
            String sText = (String) value;
            this.isSelected = isSelected;
            this.hasFocus = hasFocus;

            //set up the first column
            if (column == 0)
            {
                  if (row == 0)
                  {
                        setText("Unit");
                  }
                  else if (row == 1)
                  {
                        setText("Movement");
                  }
                  else if (row == 2)
                  {
                        setText("Attack");
                  }
                  else
                  {
                        setText("Defence");
                  }
            } //end if

            //set up the setler column
            if (column == 1)
            {
                  if (row == 0)
                  {
                        setIcon(suitImages[column]);
                  }
                  else if (row == 1)
                  {
                        setIcon(null);
                        setText("1");
                  }
                  else if (row == 2)
                  {
                        setIcon(null);
                        setText("0");
                  }
                  else
                  {
                        setIcon(null);
                        setText("0");
                  }
            }

            //set up the warrior column
            if (column == 2)
            {
                  if (row == 0)
                  {
                        setIcon(suitImages[column]);
                  }
                  else if (row == 1)
                  {
                        setIcon(null);
                        setText("1");
                  }
                  else if (row == 2)
                  {
                        setIcon(null);
                        setText("1");
                  }
                  else
                  {
                        setIcon(null);
                        setText("1");
                  }
            }

            //set up the spearman column
            if (column == 3)
            {
                  if (row == 0)
                  {
                        setIcon(suitImages[column]);
                  }
                  else if (row == 1)
                  {
                        setIcon(null);
                        setText("1");
                  }
                  else if (row == 2)
                  {
                        setIcon(null);
                        setText("2");
                  }
                  else
                  {
                        setIcon(null);
                        setText("1");
                  }
            }

            //set up the archer column
            if (column == 4)
            {
                  if (row == 0)
                  {
                        setIcon(suitImages[column]);
                  }
                  else if (row == 1)
                  {
                        setIcon(null);
                        setText("1");
                  }
                  else if (row == 2)
                  {
                        setIcon(null);
                        setText("3");
                  }
                  else
                  {
                        setIcon(null);
                        setText("2");
                  }
            }

            //set up the swordsman column
            if (column == 5)
            {
                  if (row == 0)
                  {
                        setIcon(suitImages[column]);
                  }
                  else if (row == 1)
                  {
                        setIcon(null);
                        setText("2");
                  }
                  else if (row == 2)
                  {
                        setIcon(null);
                        setText("2");
                  }
                  else
                  {
                        setIcon(null);
                        setText("2");
                  }
            }

            //set up the catapolt column
            if (column == 6)
            {
                  if (row == 0)
                  {
                        setIcon(suitImages[column]);
                  }
                  else if (row == 1)
                  {
                        setIcon(null);
                        setText("2");
                  }
                  else if (row == 2)
                  {
                        setIcon(null);
                        setText("5");
                  }
                  else
                  {
                        setIcon(null);
                        setText("0");
                  }
            }

            //set up the ship column
            if (column == 7)
            {
                  if (row == 0)
                  {
                        setIcon(suitImages[column]);
                  }
                  else if (row == 1)
                  {
                        setIcon(null);
                        setText("6");
                  }
                  else if (row == 2)
                  {
                        setIcon(null);
                        setText("1");
                  }
                  else
                  {
                        setIcon(null);
                        setText("1");
                  }
            }

            //set up the horseman column
            if (column == 8)
            {
                  if (row == 0)
                  {
                        setIcon(suitImages[column]);
                  }
                  else if (row == 1)
                  {
                        setIcon(null);
                        setText("3");
                  }
                  else if (row == 2)
                  {
                        setIcon(null);
                        setText("2");
                  }
                  else
                  {
                        setIcon(null);
                        setText("2");
                  }
            }
            return this;
      } //end method
} //end class
