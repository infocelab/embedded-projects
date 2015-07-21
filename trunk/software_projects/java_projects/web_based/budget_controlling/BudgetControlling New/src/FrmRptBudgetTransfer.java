/*
 * FrmRptBudgetTransfer.java
 * Created on April 23, 2008, 09:20 AM
 * @author  kusno
 */  
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;
import java.sql.*;

public class FrmRptBudgetTransfer extends javax.swing.JFrame {    
   
    public FrmRptBudgetTransfer() 
    {       
        initComponents(); 
        java.util.Date currDate= new java.util.Date();        
        cmbMonth.setSelectedIndex(currDate.getMonth());
    }        
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cmdPrint = new javax.swing.JButton();
        cmdExit = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        cmbMonth = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Budget Transfer Report");
        setResizable(false);

        cmdPrint.setText("Print");
        cmdPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdPrintActionPerformed(evt);
            }
        });

        cmdExit.setText("Exit");
        cmdExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdExitActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel3.setText("Month");

        cmbMonth.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" }));

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jLabel3)
                    .add(cmdPrint, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 86, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(cmbMonth, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 122, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(cmdExit, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 77, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 23, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(cmbMonth, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(26, 26, 26)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(cmdExit)
                    .add(cmdPrint))
                .addContainerGap())
        );

        pack();
        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        java.awt.Dimension dialogSize = getSize();
        setLocation((screenSize.width-dialogSize.width)/2,(screenSize.height-dialogSize.height)/2);
    }// </editor-fold>//GEN-END:initComponents
     
    private void cmdPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdPrintActionPerformed
      Data data = new Data(); 
      String year = data.getActivePeriod();
      int month = cmbMonth.getSelectedIndex() + 1;
      String SQL;
     
      SQL = "SELECT trx.TransNo, me.EmployeeName, trx.TransDate, trx.FromBudgetID, d1.BudgetName as FromBudgetName,  trx.ToBudgetID, d2.BudgetName as ToBudgetName, trx.Amount, trx.Description  FROM trxbudgettransfer trx INNER JOIN masterbudget d1 on d1.BudgetID = FromBudgetID INNER JOIN masterbudget d2 on d2.BudgetID = ToBudgetID INNER JOIN MasterEmployee me on trx.EmployeeID = me.EmployeeID ";
      SQL = SQL + " WHERE trx.Year = '" + year + "' AND MONTH(trx.TransDate) = '" + month + "' ORDER BY trx.TransNo";                 
      try
      {
           DBConnection getCn = new DBConnection();
           Connection cn = getCn.getConnection();
           Statement st = cn.createStatement();
           ResultSet rs = st.executeQuery(SQL);
           Report rpt = new Report();
           rpt.loadReport("rptTrxBudgetTransfer.jrxml", rs, null); 
           rpt = null;
      }
      catch(SQLException e)
      {
           System.out.println(e.toString());
      }
}//GEN-LAST:event_cmdPrintActionPerformed
 
    private void cmdExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdExitActionPerformed
          dispose();
          setVisible(false);
    }//GEN-LAST:event_cmdExitActionPerformed
        
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cmbMonth;
    private javax.swing.JButton cmdExit;
    private javax.swing.JButton cmdPrint;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
