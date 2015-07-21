/*
 * FrmRptMasterBudget.java
 * Created on April 14, 2008, 11:04 AM
 * @author  kusno
 */  
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;

public class FrmRptMasterBudget extends javax.swing.JFrame {    
   
    String functionID;
    public FrmRptMasterBudget(String sFunctionID) 
    {       
        initComponents(); 
        functionID = sFunctionID;
        if(functionID.equals("RPT-001"))
        {
            setTitle("Master Budget");
        }
        else
        {
            setTitle("Budget Detail per Month");
        }
        fillComboEmployee();
        fillComboGroup();      
    } 
    
    void fillComboEmployee()
    {
        String SQL = "SELECT CONCAT(MasterEmployee.Employeeid , '  ( ' , MasterEmployee.EmployeeName, ')' ) FROM MasterEmployee ORDER BY EmployeeID";
        Data clsCombo = new Data();
        clsCombo.FillComboBox(SQL, cmbFromEmployee,"");    
        clsCombo.FillComboBox(SQL, cmbToEmployee,"");    
        cmbFromEmployee.setSelectedIndex(0);
        cmbToEmployee.setSelectedIndex(cmbToEmployee.getItemCount()-1);        
    }
    
    void fillComboGroup()
    {
        String SQL = "SELECT BudgetGroupName FROM masterbudgetgroup ORDER BY BudgetGroupID";
        Data clsCombo = new Data();
        clsCombo.FillComboBox(SQL, cmbFromGroup,"");
        clsCombo.FillComboBox(SQL, cmbToGroup,"");        
        cmbFromGroup.setSelectedIndex(0);
        cmbToGroup.setSelectedIndex(cmbToGroup.getItemCount()-1);
    }        
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        cmdPrint = new javax.swing.JButton();
        cmdExit = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        cmbFromGroup = new javax.swing.JComboBox();
        cmbToGroup = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        cmbFromEmployee = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        cmbToEmployee = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Master Budget Report");
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

        cmbFromGroup.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cmbToGroup.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel3.setText("From Employee");

        cmbFromEmployee.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel4.setText("To Employee");

        cmbToEmployee.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(jLabel3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 100, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(cmbFromEmployee, 0, 263, Short.MAX_VALUE))
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jLabel4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 100, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jLabel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 100, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jLabel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 86, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .add(10, 10, 10)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(cmbToGroup, 0, 263, Short.MAX_VALUE)
                            .add(cmbFromGroup, 0, 263, Short.MAX_VALUE)
                            .add(cmbToEmployee, 0, 263, Short.MAX_VALUE)))
                    .add(layout.createSequentialGroup()
                        .add(cmdPrint, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 71, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(cmdExit, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 78, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 23, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(cmbFromEmployee, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 23, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(cmbToEmployee, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(18, 18, 18)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 23, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(cmbFromGroup, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(cmbToGroup, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 23, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(18, 18, 18)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(cmdPrint)
                    .add(cmdExit))
                .add(30, 30, 30))
        );

        pack();
        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        java.awt.Dimension dialogSize = getSize();
        setLocation((screenSize.width-dialogSize.width)/2,(screenSize.height-dialogSize.height)/2);
    }// </editor-fold>//GEN-END:initComponents
     
    private void cmdPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdPrintActionPerformed
      Data data = new Data(); 
      String year = data.getActivePeriod();
      String fromEmployee = cmbFromEmployee.getSelectedItem().toString().trim().substring(0,7);
      String toEmployee = cmbToEmployee.getSelectedItem().toString().trim().substring(0,7);
      String fromGroup = data.getFieldStringValue("masterbudgetgroup", "BudgetGroupName", cmbFromGroup.getSelectedItem().toString().trim(), "BudgetGroupID");
      String toGroup = data.getFieldStringValue("masterbudgetgroup", "BudgetGroupName", cmbToGroup.getSelectedItem().toString().trim(), "BudgetGroupID");
      String SQL;
      String fileName;
      if(functionID.equals("RPT-001"))
      {
          fileName = "rptMasterBudget.jrxml";
          SQL = "SELECT G.BudgetGroupName, me.EmployeeName, A.BudgetID, A.BudgetName, BeginningBalance, BeginningBalance + (BudgetIn01+BudgetIn02+BudgetIn03+BudgetIn04+BudgetIn05+BudgetIn06+BudgetIn07+BudgetIn08+BudgetIn09+BudgetIn10+BudgetIn11+BudgetIn12)-(BudgetOut01+BudgetOut02+BudgetOut03+BudgetOut04+BudgetOut05+BudgetOut06+BudgetOut07+BudgetOut08+BudgetOut09+BudgetOut10+BudgetOut11+BudgetOut12) as LastBalance ";
          SQL = SQL + " FROM masterbudget A inner join masterbudgetgroup G on A.BudgetGroupID = G.BudgetGroupID Inner Join trxbudget trx on trx.BudgetID = A.BudgetID INNER JOIN MasterEmployee me on trx.EmployeeID = me.EmployeeID ";
          SQL = SQL + " WHERE trx.EmployeeID >='" + fromEmployee + "' AND trx.EmployeeID <= '" + toEmployee + "' AND trx.Year = '" + year + "' AND G.BudgetGroupID >= '" + fromGroup + "' AND G.BudgetGroupID <= '" + toGroup + "' ORDER BY me.EmployeeID, G.BudgetGroupID, trx.BudgetID";
      }
      else
      {
          fileName = "rptMasterBudgetPerMonth.jrxml";
          SQL = "SELECT G.BudgetGroupName, me.EmployeeName, A.BudgetID, A.BudgetName, BeginningBalance,BudgetIn01,BudgetIn02,BudgetIn03,BudgetIn04,BudgetIn05,BudgetIn06,BudgetIn07,BudgetIn08,BudgetIn09,BudgetIn10,BudgetIn11,BudgetIn12,BudgetOut01,BudgetOut02,BudgetOut03,BudgetOut04,BudgetOut05,BudgetOut06,BudgetOut07,BudgetOut08,BudgetOut09,BudgetOut10,BudgetOut11,BudgetOut12, ";
          SQL = SQL + " BeginningBalance + (BudgetIn01+BudgetIn02+BudgetIn03+BudgetIn04+BudgetIn05+BudgetIn06+BudgetIn07+BudgetIn08+BudgetIn09+BudgetIn10+BudgetIn11+BudgetIn12)-(BudgetOut01+BudgetOut02+BudgetOut03+BudgetOut04+BudgetOut05+BudgetOut06+BudgetOut07+BudgetOut08+BudgetOut09+BudgetOut10+BudgetOut11+BudgetOut12) as LastBalance FROM masterbudget A inner join masterbudgetgroup G on A.BudgetGroupID = G.BudgetGroupID ";
          SQL = SQL + " Inner Join trxbudget trx on trx.BudgetID = A.BudgetID INNER JOIN MasterEmployee me on trx.EmployeeID = me.EmployeeID ";
          SQL = SQL + " WHERE trx.EmployeeID >='" + fromEmployee + "' AND trx.EmployeeID <= '" + toEmployee + "' AND trx.Year = '" + year + "' AND G.BudgetGroupID >= '" + fromGroup + "' AND G.BudgetGroupID <= '" + toGroup + "' ORDER BY me.EmployeeID, G.BudgetGroupID, trx.BudgetID";      }                 
      try
      {
           DBConnection getCn = new DBConnection();
           Connection cn = getCn.getConnection();
           Statement st = cn.createStatement();
           ResultSet rs = st.executeQuery(SQL);           
           HashMap hm = new HashMap(); 
           hm.put("Year",year) ;           
           Report rpt = new Report();
           rpt.loadReport(fileName, rs, hm);
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
    private javax.swing.JComboBox cmbFromEmployee;
    private javax.swing.JComboBox cmbFromGroup;
    private javax.swing.JComboBox cmbToEmployee;
    private javax.swing.JComboBox cmbToGroup;
    private javax.swing.JButton cmdExit;
    private javax.swing.JButton cmdPrint;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}
