
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;
import java.util.Vector;

public class MESTable extends JPanel
{

    JTable table;
    private DefaultTableModel tableModel;
    JScrollPane scroll;
    private boolean useWhiteForground = true, useWhiteBackGround = false, isWHITE_HEADER = false;
    int unique = -1;
    Object[] columns;
    int[]columnSize;
    int TOTAL_ROW=3;
    int TOTAL_COLUMN = 1;

    String label = null;

    public MESTable(Object[] col){
        super();
        String[] ar = new String[col.length];
        for(int i = 0; i < col.length; i++){
            ar[i] = col[i].toString();
        }

        init();
        setUpColumn(ar, null);
}

    public MESTable(){
        super();
        init();
    }
    public MESTable(String lab,String[] col){
        super();
        this.label = lab;
        init();
        columns = col;
        setUpColumn(col, null);
    }

    public MESTable(String[] col){
        this(col, null);
    }


    public MESTable(String[] col, TableCellRenderer renderer){
        super();

        init();
        columns = col;
        setUpColumn(col, renderer);
    }

    public void setRowSelectectionAllowed(boolean allowed){
        table.setRowSelectionAllowed(allowed);
    }
    void init(){

        tableModel = new DefaultTableModel();
        table = new JTable(tableModel){

               public boolean isCellEditable(int row, int column){
			        return tableModel.getColumnName(column).equals("Amount") ;
			    }
               public boolean isRowSelected(int row){
			         if(row == getSelectedRow()){
	      	            return true;
			        }else return false;
			    }
			    public void setEnabled(boolean b){
			        super.setEnabled(b);
			        scroll.setEnabled(b);
			        scroll.getHorizontalScrollBar().setEnabled(b);
			        scroll.getVerticalScrollBar().setEnabled(b);
			    }
		    };
		table.setSelectionMode(0);
        table.setFont(new Font("Times New Roman",Font.PLAIN,13));
        table.setForeground(Color.white);
        table.setGridColor(new Color(0,128,192));
       // table.setBackground(new Color(0,128,192));

        table.getTableHeader().setReorderingAllowed(false);

        scroll = new JScrollPane(table);
        if(label == null){
            this.setLayout(new GridLayout());
            add(scroll);
        }else
        if(label != null){
            this.setLayout(new BorderLayout());
            JLabel labelLabel = new JLabel(label, JLabel.CENTER);
            //labelLabel.setBackground(new Color(0,128,192));
            labelLabel.setForeground(Color.black);
	        labelLabel.setBorder(new EtchedBorder());
	        labelLabel.setOpaque(true);
            add(labelLabel, BorderLayout.NORTH);
            add(scroll, BorderLayout.CENTER);

        }
        scroll.getViewport().setBackground(new Color(255,255,230));

    }

   public void setEnabled(boolean b){
        table.setEnabled(b);
        scroll.setEnabled(b);
        scroll.getHorizontalScrollBar().setEnabled(b);
        scroll.getVerticalScrollBar().setEnabled(b);
        super.setEnabled(b);
   }

   public void setUpColumn(Object[]  col){
        for(int i = 0; i < col.length; i++){
            tableModel.addColumn((String)col[i]);

        }
   }

   public void setUpColumn(String[]  col, TableCellRenderer renderer){
        for(int i = 0; i < col.length; i++){
            tableModel.addColumn((String)col[i]);

        }

		DefaultTableCellRenderer
		    tableHeaderRenderer = new DefaultTableCellRenderer() {
			public Component getTableCellRendererComponent(
			                    JTable table, Object value,
			                    boolean isSelected, boolean hasFocus,
			                    int row, int column) {

                JLabel label = (JLabel) this;

				label.setText(value+"");
				label.setHorizontalAlignment(JLabel.CENTER);
				label.setForeground(Color.black);

				//label.setBackground(new Color(240,224,212));
				label.setBackground(Color.white);
				//label.setBackground(new Color(213,229,219));
				////label.setBackground(Color.white);
				label.setBorder(BorderFactory.createEtchedBorder());
	            label.setFont(new Font("", Font.BOLD,11));

		   		return this;
			}
		};
		table.getTableHeader().setDefaultRenderer(tableHeaderRenderer);

   }
   public void setColumnSize(int col, int size){
        table.getColumn(table.getColumnName(col)).setPreferredWidth(size);
   }
   public void setMaximum(int col, int min , int max){
        table.getColumn(table.getColumnName(col)).setMaxWidth(min);
        table.getColumn(table.getColumnName(col)).setMinWidth(min);

   }
   public void setColumnSize(int[] col){
        columnSize = col;
        for(int i = 0; i < col.length; i++){
            setColumnSize(i,col[i]);
        }
   }
   public void useDefaultRenderer(int[] not){

        for(int i = 0; i < tableModel.getColumnCount(); i++){
            for(int x = 0; x < not.length; x++){
                if(x != not[x]){
                    table.setDefaultRenderer(table.getColumnClass(i), new JComponentCellRenderer() );
                }
            }
        }

   }

   public DefaultTableModel getTableModel(){
        return tableModel;
   }

   public JTable getTable(){
        return table;
   }

    class JComponentCellRenderer implements TableCellRenderer{
        public Component getTableCellRendererComponent(JTable table, Object value,
                boolean isSelected, boolean hasFocus, int row, int column) {
		    if(value instanceof JComponent ){
		        if(isSelected){

    	            JComponent l = (JComponent)tableModel.getValueAt(row,column);
		            l.setOpaque(true);
		            l.setBackground(table.getBackground().darker());
		            if(useWhiteForground){
		            l.setForeground(Color.white);
		            }
		            l.setFont(new Font("", Font.PLAIN, 12));
    	        }
		        if(!isSelected){
		            JComponent l = (JComponent)tableModel.getValueAt(row,column);
		            l.setBackground(useWhiteBackGround ? Color.white : table.getBackground());
		            l.setForeground(useWhiteForground ? Color.black : l.getForeground());
		            l.setFont(new Font("", Font.PLAIN, 12));


		        }
		        return (JComponent)value;
      	    }
      	    else return (JComponent)value;
		}
	}

//dri

	public String getValueAtSelectedRow(int  col){
	    try{
	        return ((JLabel)table.getValueAt(table.getSelectedRow(), col)).getText();
	    }catch(NullPointerException npe){
	        return null;
	    }
	}
	public void setValueAt(int row, int col, String value){
	    ((JLabel)table.getValueAt(row, col)).setText(value);
	}
	public String getValueAt(int row , int col){
	    return ((JLabel)table.getValueAt(row, col)).getText();
	}
	public Object getObjectAt(int row, int col){
	    return table.getValueAt(row, col);
	}

	public JScrollPane getScroll(){
	    return scroll;
	}


}