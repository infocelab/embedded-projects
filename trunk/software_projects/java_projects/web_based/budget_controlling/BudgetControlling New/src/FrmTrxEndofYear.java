/*
 * FrmTrxEndofYear.java
 * Created on April 14, 2008, 11:04 AM
 * @author  kusno
 */  
import java.util.ArrayList; 
import javax.swing.JOptionPane; 
import javax.swing.*;
import javax.swing.event.*;
import java.sql.*;
import java.awt.*;

public class FrmTrxEndofYear extends javax.swing.JFrame {    
   
    public FrmTrxEndofYear() 
    {       
        initComponents(); 
        Data data = new Data();
        lbFromYear.setText(data.getActivePeriod());
        int thn = Integer.valueOf(lbFromYear.getText().trim()).intValue()+1;
        lbToYear.setText(Integer.toString(thn)) ;
    }          
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        lbFromYear = new javax.swing.JLabel();
        cmdProcess = new javax.swing.JButton();
        cmdExit = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        lbToYear = new javax.swing.JLabel();
        chkDeleteOldTrx = new javax.swing.JCheckBox();
        chkDeleteResignEmployee = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("End of Year");
        setAlwaysOnTop(true);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel1.setText("From Year :");

        lbFromYear.setFont(new java.awt.Font("Tahoma", 1, 12));
        lbFromYear.setText("4");

        cmdProcess.setText("Process");
        cmdProcess.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdProcessActionPerformed(evt);
            }
        });

        cmdExit.setText("Exit");
        cmdExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdExitActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel2.setText("To Year :");

        lbToYear.setFont(new java.awt.Font("Tahoma", 1, 12));
        lbToYear.setText("4");

        chkDeleteOldTrx.setText("Delete Current Transactions");

        chkDeleteResignEmployee.setText("Delete Resign Employee");

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                            .add(org.jdesktop.layout.GroupLayout.LEADING, jLabel2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(org.jdesktop.layout.GroupLayout.LEADING, jLabel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(lbFromYear, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 53, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(lbToYear, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 53, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(192, Short.MAX_VALUE))
                    .add(layout.createSequentialGroup()
                        .add(cmdProcess)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(cmdExit, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 74, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                            .add(org.jdesktop.layout.GroupLayout.LEADING, chkDeleteResignEmployee, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(org.jdesktop.layout.GroupLayout.LEADING, chkDeleteOldTrx, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 23, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(lbFromYear, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 23, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 23, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(lbToYear, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 23, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(18, 18, 18)
                .add(chkDeleteOldTrx)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(chkDeleteResignEmployee)
                .add(18, 18, 18)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(cmdProcess)
                    .add(cmdExit))
                .addContainerGap())
        );

        pack();
        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        java.awt.Dimension dialogSize = getSize();
        setLocation((screenSize.width-dialogSize.width)/2,(screenSize.height-dialogSize.height)/2);
    }// </editor-fold>//GEN-END:initComponents

    private boolean isValidate()
    {         
         Data data = new Data();
         String x =  data.getFieldStringValue("trxperiod", "Year", lbFromYear.getText().trim(), "Status");
         if(x.equals("1"))
         {
             JOptionPane.showMessageDialog(this,"You can not apply End of Year for year " + lbFromYear.getText().trim() + ".\nIt has been processed.","Information",JOptionPane.OK_OPTION);
             return false;
         }
         return true;
    }
    
    private void cmdProcessActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdProcessActionPerformed
        Data user = new Data(); 
        String UserID;    
        UserID = user.getUserID().trim();
        Data User = new Data(); 
        if(User.UserRight(UserID, "TSK-004",Data.typeOfAction.Add)==false)
        {
             JOptionPane.showMessageDialog(this, "You dont have right to modify data.","Information",JOptionPane.OK_OPTION);
             return;
        }
        
        ArrayList<String> SQLArray = new ArrayList<String>();
        String SQL;         
        Data Exec = new Data();
        if(isValidate()==false)
        {
            return;
        }
        int result = JOptionPane.showConfirmDialog(this,"You can not modify data that have been processed.\nDo you still want to continue ?","Confirmation",JOptionPane.YES_NO_OPTION);      
        if(result==JOptionPane.YES_OPTION)
        {            
            SQL = "DELETE FROM trxbudget WHERE Year = '" + lbToYear.getText().trim() + "'";
            SQLArray.add(SQL);            
            
            SQL = "INSERT INTO trxbudget (BudgetID, Year, EmployeeID, BeginningBalance) ";
            SQL = SQL + " SELECT BudgetID, '" + lbToYear.getText().trim() + "', EmployeeID, (BudgetIn01+BudgetIn02+BudgetIn03+BudgetIn04+BudgetIn05+BudgetIn06+BudgetIn07+BudgetIn08+BudgetIn09+BudgetIn10+BudgetIn11+BudgetIn12) + BeginningBalance -(BudgetOut01+BudgetOut02+BudgetOut03+BudgetOut04+BudgetOut05+BudgetOut06+BudgetOut07+BudgetOut08+BudgetOut09+BudgetOut10+BudgetOut11+BudgetOut12) as LastBalance  FROM trxbudget WHERE Year =  '" + lbFromYear.getText().trim() + "'";
            SQLArray.add(SQL);
            
            SQL = "UPDATE trxperiod SET Status = 1 WHERE Year = '" + lbFromYear.getText().trim() + "'";                        
            SQLArray.add(SQL);
            
            SQL = "UPDATE trxperioddetail SET BeginningBalanceStatus = 1 WHERE Year = '" + lbFromYear.getText().trim() + "'";                        
            SQLArray.add(SQL);
            
            if(chkDeleteOldTrx.isSelected()==true)
            {                
                SQL = "DELETE FROM trxbudget WHERE Year = '" + lbFromYear.getText().trim() + "'";
                SQLArray.add(SQL);   
            
                SQL = "DELETE FROM trxbudgettransfer WHERE Year = '" + lbFromYear.getText().trim() + "'";
                SQLArray.add(SQL);   
                
                SQL = "DELETE trxbudgetusagedetail FROM trxbudgetusagedetail t1 INNER JOIN trxbudgetusage t2 ON t1.transno=t2.transno WHERE t2.year = '" + lbFromYear.getText().trim() + "'";
                SQLArray.add(SQL);   
                
                SQL = "DELETE FROM trxbudgetusage WHERE Year = '" + lbFromYear.getText().trim() + "'";
                SQLArray.add(SQL);   
            }
            
            if(chkDeleteResignEmployee.isSelected()==true)
            {
                SQL = "DELETE trxbudget FROM trxbudget INNER JOIN MasterEmployee me on me.EmployeeID = trxbudget.EmployeeID WHERE me.EmployeeStatus = 'R'";
                SQLArray.add(SQL);   
            
                SQL = "DELETE trxbudgettransfer FROM trxbudgettransfer INNER JOIN MasterEmployee me on me.EmployeeID = trxbudgettransfer.EmployeeID WHERE me.EmployeeStatus = 'R'";
                SQLArray.add(SQL);   
                
                SQL = "DELETE trxbudgetusagedetail FROM trxbudgetusagedetail t1 INNER JOIN trxbudgetusage t2 ON t1.transno=t2.transno INNER JOIN MasterEmployee me on me.EmployeeID = t2.EmployeeID WHERE me.EmployeeStatus = 'R'";
                SQLArray.add(SQL);   
                
                SQL = "DELETE trxbudgetusage FROM trxbudgetusage INNER JOIN MasterEmployee me on me.EmployeeID = trxbudgetusage.EmployeeID WHERE me.EmployeeStatus = 'R'";
                SQLArray.add(SQL);  
                
                SQL = "DELETE trxperioddetail FROM trxperioddetail INNER JOIN MasterEmployee me on me.EmployeeID = trxperioddetail.EmployeeID WHERE me.EmployeeStatus = 'R'";
                SQLArray.add(SQL);   
                
                SQL = "DELETE FROM masterEmployee WHERE EmployeeStatus = 'R'";
                SQLArray.add(SQL);                                 
            }   

            SQL = "INSERT INTO trxperiod VALUES ('" + lbToYear.getText().trim() + "',0)";                        
            SQLArray.add(SQL);
            
            SQL = "INSERT INTO trxperioddetail SELECT EmployeeID, '" + lbToYear.getText().trim() + "','0' as BeginningBalance FROM MasterEmployee WHERE EmployeeStatus = 'A'";
            SQLArray.add(SQL);
     
            Exec.ExecuteSQL(SQLArray);  
            Exec = null;
            
            JOptionPane.showMessageDialog(this, "End of Year is done.","Information",JOptionPane.INFORMATION_MESSAGE);
        }                  
}//GEN-LAST:event_cmdProcessActionPerformed
 
    private void cmdExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdExitActionPerformed
          dispose();
          setVisible(false);
    }//GEN-LAST:event_cmdExitActionPerformed
        
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox chkDeleteOldTrx;
    private javax.swing.JCheckBox chkDeleteResignEmployee;
    private javax.swing.JButton cmdExit;
    private javax.swing.JButton cmdProcess;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lbFromYear;
    private javax.swing.JLabel lbToYear;
    // End of variables declaration//GEN-END:variables
}
