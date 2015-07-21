import java.awt.Component; 
import javax.swing.JTable.*; 
import javax.swing.table.*;
import javax.swing.JLabel.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;
import javax.swing.table.*;
import javax.swing.text.*; 

class NumericOnly extends DefaultCellEditor
    {
	NumericOnly()
	{
            super(new JTextField()); 
	}
 
	public boolean stopCellEditing()
	{
            try
            {
                String editingValue = (String)getCellEditorValue();
                char[] source = editingValue.toCharArray();
                char[] result = new char[source.length];
                int j = 0;
                for (int i = 0; i < result.length; i++)
                {
                    char x = source[i];           
                    if (Character.isDigit(source[i]) || (x=='.'))
                    {
                        result[j++] = source[i];
                    }
                    else 
                    {
                        JTextField textField = (JTextField)getComponent();
                        textField.setBorder(new LineBorder(Color.red));
                        textField.selectAll();
                        textField.requestFocusInWindow();
                        return false;                   
                    }
                }
            }
	   catch(ClassCastException exception)
            {
		return false;
	    } 
	    return super.stopCellEditing();
       }
 
	public Component getTableCellEditorComponent(
	JTable table, Object value, boolean isSelected, int row, int column)
	{
            Component c = super.getTableCellEditorComponent(
            table, value, isSelected, row, column);
            ((JComponent)c).setBorder(new LineBorder(Color.black));
            return c;
	}
    }   
    