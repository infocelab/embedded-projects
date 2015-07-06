import java.awt.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;

/**
 * Title:       UnitTable.java
 * Description: This sets up a JTable in a JPanel and displays a JTable
 *              with units and there pics
 * @author:     Shane Grund
 * @version:    1.0
 */
class UnitTable extends JPanel
{
      protected JPanel bottomPanel, centerPanel;
      protected JTable table;
      protected JLabel lblMain;
      protected JScrollPane scrollPane;

      private String columnNames[];
      private String dataValues[][];

      /**
       * This sets a a JTable in a JPanel
       */
      public UnitTable()
      {
            // Set the Panel characteristics
            this.setLayout(new BorderLayout());
            this.setBackground(Color.white);

            lblMain = new JLabel("Civilisation Conquest Units");
            lblMain.setForeground(new Color(51, 167, 91));
            lblMain.setHorizontalAlignment(SwingConstants.CENTER);
            lblMain.setFont(new Font("Dialog", 1, 32));
            this.add(lblMain, BorderLayout.NORTH);

            // Create a panel to hold all other components
            bottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
            bottomPanel.setBackground(Color.white);
            this.add(bottomPanel, BorderLayout.SOUTH);

            // Create the custom data model
            CustomDataModel customDataModel = new CustomDataModel();

            // Create a new table instance
            table = new JTable(customDataModel);
            table.setRowHeight(65);
            CreateColumns();

            // Configure some of JTable's paramters
            table.setShowHorizontalLines( true );

            centerPanel = new JPanel(new BorderLayout());
            centerPanel.setBackground(Color.white);

            // Add the table to a scrolling pane
            scrollPane = table.createScrollPaneForTable(table);
            centerPanel.add(scrollPane, BorderLayout.CENTER);
            this.add(centerPanel);
      }//end constructor

      /**
       * This method sets up all the columns of the JTable
       */
      public void CreateColumns()
      {
            // Say that we are manually creating the columns
            table.setAutoCreateColumnsFromModel(false);

            for( int iCtr = 0; iCtr < 9; iCtr++ )
            {
                  // Manually create a new column
                  TableColumn column = new TableColumn( iCtr );
                  if(iCtr == 0)
                        column.setHeaderValue( (Object)("") );
                  if(iCtr == 1)
                        column.setHeaderValue( (Object)("Setler") );
                  if(iCtr == 2)
                        column.setHeaderValue( (Object)("Warrior") );
                  if(iCtr == 3)
                        column.setHeaderValue( (Object)("Spearman") );
                  if(iCtr == 4)
                        column.setHeaderValue( (Object)("Archer") );
                  if(iCtr == 5)
                        column.setHeaderValue( (Object)("Swordman") );
                  if(iCtr == 6)
                        column.setHeaderValue( (Object)("Catapolt") );
                  if(iCtr == 7)
                        column.setHeaderValue( (Object)("Ship") );
                  if(iCtr == 8)
                        column.setHeaderValue( (Object)("horseman") );

                  // Add a cell renderer for this class
                  column.setCellRenderer( new CustomCellRenderer() );

                  // Add the column to the table
                  table.addColumn( column );
            }//end for
      }//end create Column
}//end class
