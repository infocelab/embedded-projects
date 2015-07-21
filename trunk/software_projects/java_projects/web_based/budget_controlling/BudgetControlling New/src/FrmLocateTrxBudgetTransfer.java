/*
 * FrmLocateTrxBudgetTransfer.java
 * Created on April 8, 2008, 3:17 PM
 * @author  kusno
 */ 
import java.sql.*;
import javax.swing.JTable.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.*;
import javax.swing.table.DefaultTableModel;
import java.text.DecimalFormat;
import javax.swing.table.DefaultTableCellRenderer;  
import javax.swing.JTable.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.*;
import javax.swing.*;
import javax.swing.event.*;

public class FrmLocateTrxBudgetTransfer extends javax.swing.JDialog {
    transMode mode = new transMode();    
    String[] strHeader = {"No.","Date","Employee Name","From","To","Amount"};
    DefaultTableModel tabMode;
    Object transNo; 
    String year;
 
    public FrmLocateTrxBudgetTransfer() {
       mode.setTransMode(transMode.typeOfTransMode.Wait);
       tabMode = new DefaultTableModel(null,strHeader)
               {
    public boolean isCellEditable(int row, int column)
    {
        return false;
    }
};  
       initComponents();       
       formatColumn();
       Data data = new Data();
       year = data.getActivePeriod();
       fillTable("");
       formatColumn();
      // formatTableColumn();
    }
    
     void formatTableColumn()
    {        
          tblBudget.getColumnModel().getColumn(0).setPreferredWidth(20);
          tblBudget.getColumnModel().getColumn(1).setPreferredWidth(20);
          tblBudget.getColumnModel().getColumn(2).setPreferredWidth(80);
          tblBudget.getColumnModel().getColumn(3).setPreferredWidth(110);                    
          tblBudget.getColumnModel().getColumn(4).setPreferredWidth(110);    
          tblBudget.getColumnModel().getColumn(5).setPreferredWidth(50);             
    }
    
    public String getTransNo()
    {
        if(transNo==null)
        {
          return "";            
        }
        else
        {
          return transNo.toString().trim();            
        }         
    }
         
     void fillTable(String keyword)
     {        
        String SQL = "";
        SQL = "SELECT trx.TransNo, trx.TransDate, d1.BudgetName, d2.BudgetName, trx.Amount, me.EmployeeName FROM trxbudgettransfer trx inner join masterbudget d1 on d1.BudgetID = trx.FromBudgetID inner join masterbudget d2 on d2.BudgetID = trx.ToBudgetID INNER JOIN masteremployee me on me.EmployeeID = trx.employeeID WHERE trx.Year = '" + year + "' ";      
        if(!keyword.equals(""))
        {
            if(cmbSearch.getSelectedIndex()==0)
            {
                SQL += " AND trx.TransNo LIKE '%" + keyword + "%'";
            }
             
        }        
        SQL += " GROUP BY  trx.TransNo, trx.TransDate ORDER BY trx.TransNo DESC";     
        tabMode.setRowCount(0);
        try{
            DBConnection getCn = new DBConnection();
            Connection cn = getCn.getConnection();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            while(rs.next())
            {
                String No = rs.getString(1);
                Date transDate = rs.getDate(2); 
                String from = rs.getString(3);
                String to = rs.getString(4);
                String employeeName = rs.getString(6);
                double total =rs.getDouble(5);
                String fmt = "##,###,###,###.00";
                DecimalFormat df = new DecimalFormat (fmt); 
                String strTotal = df.format (total);  
                Object[] data = {No, transDate, employeeName, from, to, strTotal};
                tabMode.addRow(data);
            }
            Data close = new Data();
            close.closingConnection (cn,st,rs);
            close = null;
        }
        catch(SQLException e)
        {
            
        }        
    }
    
      private class TableRenderNumber extends DefaultTableCellRenderer{
      public Component getTableCellRendererComponent( 
      JTable table, 
      Object value, 
      boolean isSelected, 
      boolean isFocused, 
      int row, int column)
      { 
        setHorizontalAlignment(SwingConstants.RIGHT);  
      Component component = super.getTableCellRendererComponent(table, value, isSelected, isFocused, row, column); 
        if(column==6)
        {
             if( value == null || value .equals(""))
        {        
            ( (JLabel) component).setText(""); 
        }
        else
        {        
          double number = 0.0;
          number = new Double(value.toString()).doubleValue();        
          DecimalFormat df = new DecimalFormat("##,###,###,###.00");
          ( (JLabel) component).setText(df.format(number));
        }  
        }       
      return component; 
  }
}       
    void formatColumn()
    {        
//          tblBudget.getColumnModel().getColumn(0).setPreferredWidth(20);
//          tblBudget.getColumnModel().getColumn(1).setPreferredWidth(20);
//          tblBudget.getColumnModel().getColumn(2).setPreferredWidth(80);
//          tblBudget.getColumnModel().getColumn(3).setPreferredWidth(110);                    
//          tblBudget.getColumnModel().getColumn(4).setPreferredWidth(110);    
//          tblBudget.getColumnModel().getColumn(5).setPreferredWidth(50);  
          
          tblBudget.getColumnModel().getColumn(0).setPreferredWidth(20);
          tblBudget.getColumnModel().getColumn(1).setPreferredWidth(20);
          tblBudget.getColumnModel().getColumn(2).setPreferredWidth(80);
          tblBudget.getColumnModel().getColumn(3).setPreferredWidth(110);
          tblBudget.getColumnModel().getColumn(4).setPreferredWidth(110);          
          tblBudget.getColumnModel().getColumn(5).setPreferredWidth(60);          
          tblBudget.getColumnModel().getColumn(5).setCellRenderer(new TableRenderNumber()); 
     }
                 
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtKeyword = new javax.swing.JTextField();
        cmbSearch = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        cmdSearch = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBudget = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Locate Budget Transfer");
        setAlwaysOnTop(true);
        setModal(true);
        setResizable(false);

        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jLabel4.setText("Keyword");

        cmbSearch.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Trans. No" }));

        jLabel5.setText("base on");

        cmdSearch.setText("Find");
        cmdSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdSearchActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jLabel4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 50, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(txtKeyword, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 84, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(cmdSearch)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jLabel5, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 52, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(cmbSearch, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 131, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel4)
                    .add(txtKeyword, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(cmdSearch)
                    .add(jLabel5)
                    .add(cmbSearch, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(9, Short.MAX_VALUE))
        );

        tblBudget.setModel(tabMode);
        tblBudget.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBudgetMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tblBudgetMouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblBudgetMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblBudget);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 545, Short.MAX_VALUE)
                    .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(11, 11, 11)
                .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 45, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 353, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        java.awt.Dimension dialogSize = getSize();
        setLocation((screenSize.width-dialogSize.width)/2,(screenSize.height-dialogSize.height)/2);
    }// </editor-fold>//GEN-END:initComponents

    private void cmdSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdSearchActionPerformed
        fillTable(txtKeyword.getText().trim());
}//GEN-LAST:event_cmdSearchActionPerformed

    private void tblBudgetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBudgetMouseClicked
        transNo = tblBudget.getModel().getValueAt(tblBudget.getSelectedRow(), 0);        
        setVisible (false);
        dispose();
}//GEN-LAST:event_tblBudgetMouseClicked

    private void tblBudgetMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBudgetMouseEntered
     
    }//GEN-LAST:event_tblBudgetMouseEntered

    private void tblBudgetMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBudgetMousePressed
       
    }//GEN-LAST:event_tblBudgetMousePressed
  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cmbSearch;
    private javax.swing.JButton cmdSearch;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblBudget;
    private javax.swing.JTextField txtKeyword;
    // End of variables declaration//GEN-END:variables
}
