import javax.swing.*;
import javax.swing.table.*;

/**
 * Title:       CustomDataModel
 * Description: This class sets up the amount of rows and columns in
 *              my JTable.
 * @author:     Shane Grund
 * @version:    1.0
 */
class CustomDataModel extends AbstractTableModel
{
      public Object getValueAt( int iRowIndex, int iColumnIndex )
      {
            return "" + iColumnIndex + "," + iRowIndex;
      }

      public void setValueAt( Object aValue, int iRowIndex, int iColumnIndex ){}

      public int getColumnCount()
      {
            return 0;// Return 0 because we handle our own columns
      }

      public int getRowCount()
      {
            return 4;
      }
}//end class
