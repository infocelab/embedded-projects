/*
 * FrmRptBudgetUsage.java
 * Created on April 23, 2008, 09:20 AM
 * @author  kusno
 */  
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;

public class FrmRptBudgetUsage extends javax.swing.JFrame {    
   
    public FrmRptBudgetUsage() 
    {       
        initComponents(); 
        isiComboGroup(); 
        java.util.Date currDate= new java.util.Date();        
        cmbMonth.setSelectedIndex(currDate.getMonth());
    } 
    
    void isiComboGroup()
    {
        String SQL = "SELECT BudgetGroupName FROM masterbudgetgroup ORDER BY BudgetGroupID";
        Data clsCombo = new Data();
        clsCombo.FillComboBox(SQL, cmbFrom,"");
        clsCombo.FillComboBox(SQL, cmbTo,"");        
        cmbFrom.setSelectedIndex(0);
        cmbTo.setSelectedIndex(cmbTo.getItemCount()-1);
    }        
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        cmdPrint = new javax.swing.JButton();
        cmdExit = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        cmbFrom = new javax.swing.JComboBox();
        cmbTo = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        cmbMonth = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Budget Usage Report");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel1.setText("From Group");

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

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel2.setText("To Group");

        cmbFrom.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cmbTo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

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
                    .add(layout.createSequentialGroup()
                        .add(cmdPrint, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 79, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(cmdExit, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 75, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(layout.createSequentialGroup()
                        .add(jLabel3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 114, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(cmbMonth, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 122, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(jLabel2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(jLabel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 114, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                            .add(cmbFrom, 0, 334, Short.MAX_VALUE)
                            .add(org.jdesktop.layout.GroupLayout.LEADING, cmbTo, 0, 334, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 23, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(cmbMonth, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 23, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(cmbFrom, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 23, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(cmbTo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(23, 23, 23)
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
      String from = data.getFieldStringValue("masterbudgetgroup", "BudgetGroupName", cmbFrom.getSelectedItem().toString().trim(), "BudgetGroupID");
      String to = data.getFieldStringValue("masterbudgetgroup", "BudgetGroupName", cmbTo.getSelectedItem().toString().trim(), "BudgetGroupID");
      String SQL;     
      SQL = "SELECT k.TransNo, k.TransDate, me.EmployeeName, k.Description, kd.BudgetID, a.BudgetName , kd.DeptReffNo, kd.Amount, kd.Seq FROM trxbudgetusage k inner join trxbudgetusagedetail kd on k.TransNo = kd.TransNo INNER JOIN masterbudget a on kd.BudgetID = a.BudgetID INNER JOIN masterbudgetgroup g on g.BudgetGroupID = a.BudgetGroupID INNER JOIN MasterEmployee me on k.EmployeeID = me.EmployeeID ";
      SQL = SQL + " WHERE k.Year = '" + year + "' AND MONTH(k.TransDate) = '" + month + "' AND g.BudgetGroupID >= '" + from + "' AND g.BudgetGroupID <= '" + to + "' ORDER BY k.TransNo, kd.seq";                 
      try
      {
           DBConnection getCn = new DBConnection();
           Connection cn = getCn.getConnection();
           Statement st = cn.createStatement();
           ResultSet rs = st.executeQuery(SQL);
           Report rpt = new Report();
           rpt.loadReport("rptTrxBudgetUsage.jrxml", rs, null); 
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
    private javax.swing.JComboBox cmbFrom;
    private javax.swing.JComboBox cmbMonth;
    private javax.swing.JComboBox cmbTo;
    private javax.swing.JButton cmdExit;
    private javax.swing.JButton cmdPrint;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
