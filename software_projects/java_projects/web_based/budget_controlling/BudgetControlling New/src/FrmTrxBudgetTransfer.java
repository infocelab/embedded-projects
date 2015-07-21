/*
 * FrmTrxBudgetTransfer.java
 * Created on April 16, 2008, 11:08 AM
 * @author  kusno
 */   
import java.text.NumberFormat; 
import java.util.ArrayList; 
import javax.swing.JOptionPane; 
import javax.swing.*;
import javax.swing.event.*;
import java.text.DecimalFormat;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*; 

public class FrmTrxBudgetTransfer extends javax.swing.JFrame {
    transMode mode = new transMode();  
    Data user = new Data(); 
    String UserID;    
    
    public FrmTrxBudgetTransfer() {
         mode.setTransMode(transMode.typeOfTransMode.Wait);
         initComponents(); 
         UserID = user.getUserID().trim();
         txtAmount.setDocument(new NumericPlainDocument());         
         clearTextBox(); 
         enableControls();
    }

    void enableControls()
    {
        if(mode.getTransMode()==transMode.typeOfTransMode.Wait)
        {
           txtTransNo.setText("[Auto number]") ;
           txtTransNo.setEnabled(false);
           dtTransDate.setEnabled(false);
           cmdLocateFromBudget.setEnabled(false);
           cmdLocateToBudget.setEnabled(false);                
           cmdLocateEmployee.setEnabled(false);
           txtDescription.setEnabled(false); 
           txtAmount.setEnabled(false);                                                  
           cmdNew.setEnabled(true);
           cmdExit.setEnabled(true);
           cmdLoad.setEnabled(true);
           cmdSave.setEnabled(false);
           cmdCancel.setEnabled(false);
           cmdDelete.setEnabled(false);
        }
        else            
        {
           dtTransDate.setEnabled(true);
           txtDescription.setEnabled(true);
           txtAmount.setEnabled(true);                                  
           cmdLocateFromBudget.setEnabled(true);
           cmdLocateFromBudget.requestFocus();
           cmdLocateToBudget.setEnabled(true);
           cmdLocateEmployee.setEnabled(true);
           cmdNew.setEnabled(false);
           cmdExit.setEnabled(false);
           cmdLoad.setEnabled(false);
           cmdSave.setEnabled(true);
           cmdCancel.setEnabled(true);
           cmdDelete.setEnabled(false);           
           if(mode.getTransMode()==transMode.typeOfTransMode.EditRecord)
           {
                 cmdLoad.setEnabled(false);
                 cmdDelete.setEnabled(true);
                 dtTransDate.setEnabled(false);
           }
         }
    }
     
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cmdSave = new javax.swing.JButton();
        cmdCancel = new javax.swing.JButton();
        cmdExit = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDescription = new javax.swing.JTextArea();
        txtTransNo = new javax.swing.JTextField();
        cmdNew = new javax.swing.JButton();
        cmdLoad = new javax.swing.JButton();
        cmdDelete = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        txtFromBudgetID = new javax.swing.JTextField();
        cmdLocateFromBudget = new javax.swing.JButton();
        txtFromBudgetName = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txtToBudgetID = new javax.swing.JTextField();
        cmdLocateToBudget = new javax.swing.JButton();
        txtToBudgetName = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtAmount = new javax.swing.JTextField();
        txtEmployeeID = new javax.swing.JTextField();
        cmdLocateEmployee = new javax.swing.JButton();
        txtEmployeeName = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        dtTransDate = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Budget Transfer");
        setAlwaysOnTop(true);
        setResizable(false);

        cmdSave.setText("Save");
        cmdSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdSaveActionPerformed(evt);
            }
        });

        cmdCancel.setText("Cancel");
        cmdCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdCancelActionPerformed(evt);
            }
        });

        cmdExit.setText("Exit");
        cmdExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdExitActionPerformed(evt);
            }
        });

        jLabel6.setText("Trans. No");

        jLabel7.setText("Trans. Date");

        jLabel8.setText("Amount to be transferred");

        txtDescription.setColumns(20);
        txtDescription.setRows(5);
        jScrollPane2.setViewportView(txtDescription);

        cmdNew.setText("Add");
        cmdNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdNewActionPerformed(evt);
            }
        });

        cmdLoad.setText("Load");
        cmdLoad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdLoadActionPerformed(evt);
            }
        });

        cmdDelete.setText("Delete");
        cmdDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdDeleteActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("From"));

        txtFromBudgetID.setEditable(false);

        cmdLocateFromBudget.setText("...");
        cmdLocateFromBudget.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdLocateFromBudgetActionPerformed(evt);
            }
        });

        txtFromBudgetName.setEditable(false);
        txtFromBudgetName.setDisabledTextColor(new java.awt.Color(255, 255, 255));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel10.setText("Budget ID");

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(jLabel10, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 106, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(20, 20, 20)
                .add(txtFromBudgetID, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 105, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(cmdLocateFromBudget, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 27, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(txtFromBudgetName, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 242, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(cmdLocateFromBudget, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 23, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(txtFromBudgetID, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel10)
                    .add(txtFromBudgetName, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(6, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(153, 204, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("To"));

        txtToBudgetID.setEditable(false);

        cmdLocateToBudget.setText("...");
        cmdLocateToBudget.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdLocateToBudgetActionPerformed(evt);
            }
        });

        txtToBudgetName.setEditable(false);
        txtToBudgetName.setDisabledTextColor(new java.awt.Color(255, 255, 255));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel11.setText("Budget ID");

        org.jdesktop.layout.GroupLayout jPanel2Layout = new org.jdesktop.layout.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel2Layout.createSequentialGroup()
                .add(jLabel11, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 99, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(27, 27, 27)
                .add(txtToBudgetID, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 105, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(cmdLocateToBudget, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 27, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(txtToBudgetName, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 241, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(249, 249, 249))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel11, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 14, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(txtToBudgetID, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(cmdLocateToBudget, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 23, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(txtToBudgetName, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(6, Short.MAX_VALUE))
        );

        jLabel14.setText("Description");

        txtAmount.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        txtEmployeeID.setEditable(false);

        cmdLocateEmployee.setText("...");
        cmdLocateEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdLocateEmployeeActionPerformed(evt);
            }
        });

        txtEmployeeName.setEditable(false);
        txtEmployeeName.setDisabledTextColor(new java.awt.Color(255, 255, 255));

        jLabel12.setText("Employee ID");

        dtTransDate.setToolTipText("please choose date..");
        dtTransDate.setDateFormatString("yyyy-MM-dd");

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jPanel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 533, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(jLabel12, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(jLabel7, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(jLabel6, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE))
                        .add(18, 18, 18)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(layout.createSequentialGroup()
                                .add(txtEmployeeID, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 105, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(cmdLocateEmployee, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 27, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(txtEmployeeName, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 242, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                            .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                                .add(org.jdesktop.layout.GroupLayout.LEADING, dtTransDate, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .add(org.jdesktop.layout.GroupLayout.LEADING, txtTransNo, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE))))
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(jLabel8, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(jLabel14, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 112, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .add(22, 22, 22)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(txtAmount, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 124, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jScrollPane2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 385, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                    .add(layout.createSequentialGroup()
                        .add(cmdNew, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 85, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(cmdLoad, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 86, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(cmdSave, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 84, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(cmdCancel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 83, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(cmdDelete, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 87, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(cmdExit, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 79, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel6)
                    .add(txtTransNo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jLabel7)
                    .add(dtTransDate, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel12)
                    .add(txtEmployeeID, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(cmdLocateEmployee, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 23, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(txtEmployeeName, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 55, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jPanel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 55, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(txtAmount, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel8))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jScrollPane2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel14))
                .add(18, 18, 18)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(cmdNew)
                    .add(cmdLoad)
                    .add(cmdSave)
                    .add(cmdCancel)
                    .add(cmdDelete)
                    .add(cmdExit))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.getAccessibleContext().setAccessibleName("from");

        setBounds(0, 0, 568, 410);
    }// </editor-fold>//GEN-END:initComponents

    private boolean isValidate()
    {     
        if(mode.getTransMode()==transMode.typeOfTransMode.EditRecord)
        {
              Data User = new Data(); 
              if(User.UserRight(UserID, "TSK-003",Data.typeOfAction.Modify)==false)
              {
                 JOptionPane.showMessageDialog(this, "You dont have right to modify data.","Information",JOptionPane.OK_OPTION);
                 return false;
              }
        }
        
        if(txtEmployeeID.getText().trim().equals(""))
        {
            JOptionPane.showMessageDialog(this, "Employee ID source is still empty.","Warning",JOptionPane.OK_OPTION);
            cmdLocateEmployee.requestFocus();
            return false;
        }
        
        if(txtFromBudgetID.getText().trim().equals(""))
        {
             JOptionPane.showMessageDialog(this, "Budget ID source is still empty.","Warning",JOptionPane.OK_OPTION);
             cmdLocateFromBudget.requestFocus();
             return false;
        }
        
        if(txtToBudgetID.getText().trim().equals(""))
        {
             JOptionPane.showMessageDialog(this, "Budget ID destination is still empty.","Warning",JOptionPane.OK_OPTION);
             cmdLocateToBudget.requestFocus();
             return false;
        }
        
        if(txtFromBudgetID.getText().trim().equals(txtToBudgetID.getText()))
        {
             JOptionPane.showMessageDialog(this, "Budget ID source and Destination can not be same.","Warning",JOptionPane.OK_OPTION);
             cmdLocateToBudget.requestFocus();
             return false;
        }
        
        if(txtAmount.getText().trim().equals("") || txtAmount.getText().trim().equals("0"))
        {
            JOptionPane.showMessageDialog(this,"Amount to be transferred is still empty or zero.","Warning",JOptionPane.OK_OPTION);
            txtAmount.requestFocus();
            return false;
        }
        
        double d = Double.valueOf(txtAmount.getText()).doubleValue();
        if(d==0)
        {
            JOptionPane.showMessageDialog(this,"Amount to be transferred is still empty or zero.","Warning",JOptionPane.OK_OPTION);
            txtAmount.requestFocus();
            return false;
        }        
        
        Data thn = new Data();
        String yearBudget =  thn.getActivePeriod();         
        String year;
        year =Integer.toString( dtTransDate.getDate().getYear()+1900);        
        if(!year.equals(yearBudget))
        {
            JOptionPane.showMessageDialog(this, "Transaction date is wrong.\nMust be same with year Budget : " + yearBudget,"Warning",JOptionPane.OK_OPTION);                        
            dtTransDate.requestFocus();
            return false;
        }                         
        return true;
    }
    
    private boolean rollBackTransfer(String sMonth, Integer year)
    {
        ArrayList<String> SQLRB = new ArrayList<String>();
        String SQL = "SELECT FromBudgetID, ToBudgetID, Amount FROM trxbudgettransfer where TransNo = '" + txtTransNo.getText().trim() + "'";   
        try {
            DBConnection getCn = new DBConnection();
            Connection cnRollback = getCn.getConnection();
            Statement stRollback = cnRollback.createStatement();
            ResultSet rsRollback = stRollback.executeQuery(SQL);
            while(rsRollback.next())
            {
                String from = rsRollback.getString(1);
                String to = rsRollback.getString(2);
                Double amount = rsRollback.getDouble(3);
                SQLRB.add("UPDATE trxbudget SET BudgetOut" + sMonth + "=BudgetOut" + sMonth + "-" + amount + " WHERE Year = " + year + " AND BudgetID = '" + from + "' AND EmployeeID = '" + txtEmployeeID.getText().trim() + "'");                
                SQLRB.add("UPDATE trxbudget SET BudgetIn" + sMonth + "=BudgetIn" + sMonth + "-" + amount + " WHERE Year = " + year + " AND BudgetID = '" + to + "' AND EmployeeID = '" + txtEmployeeID.getText().trim() + "'");                
            }
            Data data = new Data();
            data.ExecuteSQL(SQLRB);
            data.closingConnection (cnRollback,stRollback,rsRollback);
            data = null;
        }
        catch (SQLException e) 
        {
           return false;
        }
        return true;
    }
    
    private String getAutoNumber(Integer year)
    {
        String temp=Integer.toString(year) + "-00001";
        String SQL = "SELECT TransNo FROM trxbudgettransfer WHERE Year = " + year + " ORDER BY TransNo DESC LIMIT 1 ";   
        try {
            DBConnection getCn = new DBConnection();
            Connection cnNo = getCn.getConnection();
            Statement stNo = cnNo.createStatement();
            ResultSet rsNo = stNo.executeQuery(SQL);
            if(rsNo.next())
            {
                String tempNo = rsNo.getString(1).trim().substring(5);      
                int No = Integer.valueOf(tempNo).intValue()+1;                               
                NumberFormat formatter = new DecimalFormat("00000");
                temp  = Integer.toString(year) + "-" + formatter.format(No);                  
            }           
            Data data = new Data();       
            data.closingConnection (cnNo,stNo,rsNo);
            data = null;
        }
        catch (SQLException e) 
        {
           System.out.println(e.toString()); 
           return temp;
        }        
        return temp;
    }
    
    private void cmdSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdSaveActionPerformed
        int result = JOptionPane.showConfirmDialog(this,"Do you want to save ?","Confirmation",JOptionPane.YES_NO_OPTION); 
        ArrayList<String> SQL = new ArrayList<String>();
       
        int year = 0; int month= 0; 
        String sMonth;
        String date;
        year = dtTransDate.getDate().getYear() + 1900;
        month = dtTransDate.getDate().getMonth() + 1;
        sMonth =  Integer.toString(month);
        sMonth = (sMonth.length()==1) ? "0" + sMonth : sMonth;
        date = Integer.toString(year) + "-" + sMonth + "-" +  dtTransDate.getDate().getDate();
        
        if(result==JOptionPane.YES_OPTION) 
        {
            if(isValidate()==true)
            {
                Data Exec = new Data();
                if(mode.getTransMode()==transMode.typeOfTransMode.EditRecord)
                {
                    if(rollBackTransfer(sMonth, year)==false)
                    {
                        JOptionPane.showMessageDialog(this, "Error when trying to save data.","Information",JOptionPane.OK_OPTION);
                        return;
                    }                                    
                    //SQL.add("UPDATE trxbudgettransfer SET TransDate = '" + txtTransDate.getText().trim() + "', Year = '" + year + "', Description = '" + txtDescription.getText().trim() + "', Amount = " + txtAmount.getText().trim() + ", FromBudgetID = '" + txtFromBudgetID.getText().trim() + "', ToBudgetID = '" + txtToBudgetID.getText().trim() + "', EmployeeID = '" + txtEmployeeID.getText().trim() + "' WHERE TransNo = '" + txtTransNo.getText().trim() + "'");                                         
                    SQL.add("UPDATE trxbudgettransfer SET TransDate = '" + date + "', Year = '" + year + "', Description = '" + txtDescription.getText().trim() + "', Amount = " + txtAmount.getText().trim() + ", FromBudgetID = '" + txtFromBudgetID.getText().trim() + "', ToBudgetID = '" + txtToBudgetID.getText().trim() + "', EmployeeID = '" + txtEmployeeID.getText().trim() + "' WHERE TransNo = '" + txtTransNo.getText().trim() + "'");                                         
                    SQL.add("UPDATE trxbudget SET BudgetOut" + sMonth + "=BudgetOut" + sMonth + "+" + txtAmount.getText().trim() + " WHERE Year = " + year + " AND BudgetID = '" + txtFromBudgetID.getText().trim() + "' AND EmployeeID = '" + txtEmployeeID.getText().trim() + "'");                
                    SQL.add("UPDATE trxbudget SET BudgetIn" + sMonth + "=BudgetIn" + sMonth + "+" +  txtAmount.getText().trim() + " WHERE Year = " + year + " AND BudgetID = '" + txtToBudgetID.getText().trim() + "' AND EmployeeID = '" + txtEmployeeID.getText().trim() + "'");                
                    Exec.ExecuteSQL(SQL); 
                }
                else
                if(mode.getTransMode()==transMode.typeOfTransMode.AddRecord)
                {
                    String autoNumber = getAutoNumber(year);
                    SQL.add("INSERT INTO trxbudgettransfer VALUES('" + autoNumber + "', '" + date + "', '" + txtEmployeeID.getText().trim() + "', '" + txtFromBudgetID.getText().trim() + "', '" + txtToBudgetID.getText().trim() + "', " + txtAmount.getText().trim() + ", '" + year + "','" + txtDescription.getText().trim() + "')");                                             
                    SQL.add("UPDATE trxbudget SET BudgetOut" + sMonth + "=BudgetOut" + sMonth + "+" + txtAmount.getText().trim() + " WHERE Year = " + year + " AND BudgetID = '" + txtFromBudgetID.getText().trim() + "' AND EmployeeID = '" + txtEmployeeID.getText().trim() + "'");                
                    SQL.add("UPDATE trxbudget SET BudgetIn" + sMonth + "=BudgetIn" + sMonth + "+" +  txtAmount.getText().trim() + " WHERE Year = " + year + " AND BudgetID = '" + txtToBudgetID.getText().trim() + "' AND EmployeeID = '" + txtEmployeeID.getText().trim() + "'");                            
                    Exec.ExecuteSQL(SQL);                    
                }                  
                Exec = null;
                mode.setTransMode(transMode.typeOfTransMode.Wait);  
                clearTextBox();        
                enableControls();             
            }
        }
    }//GEN-LAST:event_cmdSaveActionPerformed
    
    void clearTextBox()
    {   
        dtTransDate.setDate(new java.util.Date());        
        txtEmployeeID.setText("");
        txtEmployeeName.setText("");
        txtDescription.setText("");
        txtFromBudgetID.setText("");
        txtFromBudgetName.setText("");
        txtToBudgetID.setText("");
        txtToBudgetName.setText("");
        txtAmount.setText("0");
     }
    
    private void cmdCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdCancelActionPerformed
        mode.setTransMode(transMode.typeOfTransMode.Wait);  
        clearTextBox();        
        enableControls();              
    }//GEN-LAST:event_cmdCancelActionPerformed

    private void cmdExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdExitActionPerformed
        dispose();
        setVisible(false);
    }//GEN-LAST:event_cmdExitActionPerformed

    private void cmdLocateFromBudgetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdLocateFromBudgetActionPerformed
        FrmLocateMasterBudget frmOpenFrom = new FrmLocateMasterBudget();
        frmOpenFrom.setBounds(50, 50, 650, 500);
        frmOpenFrom.setVisible(true);
        String pID = "";
        String pName = "";
        pID = frmOpenFrom.getBudgetID();
        pName = frmOpenFrom.getBudgetName();
        txtFromBudgetID.setText(pID.toString());
        txtFromBudgetName.setText(pName);    
}//GEN-LAST:event_cmdLocateFromBudgetActionPerformed

    private void cmdNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdNewActionPerformed
        Data User = new Data(); 
        if(User.UserRight(UserID, "TSK-003",Data.typeOfAction.Modify)==false)
        {
             JOptionPane.showMessageDialog(this, "You dont have right to modify data.","Information",JOptionPane.OK_OPTION);
             return;
        }
        mode.setTransMode(transMode.typeOfTransMode.AddRecord);
        clearTextBox();        
        enableControls();
        txtDescription.requestFocus();        
}//GEN-LAST:event_cmdNewActionPerformed

    private void cmdLoadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdLoadActionPerformed
        FrmLocateTrxBudgetTransfer frmLoad = new FrmLocateTrxBudgetTransfer();
        frmLoad.setBounds(50, 50, 700, 480);
        frmLoad.setVisible(true);         
        String transNo = ""; 
        transNo = frmLoad.getTransNo();       
        if(!transNo.trim().equals(""))
        {                
             mode.setTransMode(transMode.typeOfTransMode.EditRecord);  
             clearTextBox();        
             enableControls(); 
             loadHeader(transNo);            
        }
        else
        {
            JOptionPane.showMessageDialog(this, "No Transaction number is selected.","Information",JOptionPane.OK_OPTION);
        }
}//GEN-LAST:event_cmdLoadActionPerformed

    void loadHeader(String TransNo)
    {
        String SQL = "SELECT TransNo, TransDate, FromBudgetID, d1.BudgetName, ToBudgetID , d2.BudgetName, Amount, Description, me.employeeID, me.employeeName FROM trxbudgettransfer trx inner join masterbudget d1 on d1.BudgetID = trx.FromBudgetID inner join masterbudget d2 on d2.BudgetID = trx.ToBudgetID INNER JOIN masteremployee me on trx.employeeID = me.EmployeeID WHERE TransNo = '" + TransNo.trim() + "'";   
        try {
            DBConnection getCn = new DBConnection();
            Connection cn = getCn.getConnection();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            if(rs.next())
            {
                String transNo = rs.getString(1);
                java.util.Date transDate = rs.getDate(2);                
                String fromID = rs.getString(3);
                String fromName = rs.getString(4);
                String toID = rs.getString(5);
                String toName = rs.getString(6);
                String employeeID = rs.getString(9);
                String employeeName = rs.getString(10);
                
                long amount = rs.getLong(7);
                String fmt = "#############.##";
                DecimalFormat df = new DecimalFormat (fmt); 
                String strAmount= df.format (amount); 
                 
                String description = rs.getString(8);               
                
                txtTransNo.setText(transNo); 
                dtTransDate.setDate(transDate);
                
                txtFromBudgetID.setText(fromID);
                txtFromBudgetName.setText(fromName);
                txtToBudgetID.setText(toID);
                txtToBudgetName.setText(toName);
                txtEmployeeID.setText(employeeID);
                txtEmployeeName.setText(employeeName);
                txtAmount.setText(strAmount);
                txtDescription.setText(description);               
            }
            Data data = new Data();
            data.closingConnection (cn,st,rs);
            data = null;
        }
        catch (Exception e)
        {
            System.out.println(e.toString());
        }
    }    
      
    private void cmdDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdDeleteActionPerformed
        Data User = new Data(); 
        if(User.UserRight(UserID, "TSK-003",Data.typeOfAction.Delete)==false)
        {
             JOptionPane.showMessageDialog(this, "You dont have right to delete.","Information",JOptionPane.OK_OPTION);
             return;
        }
        int result = JOptionPane.showConfirmDialog(this,"Do you want to delete ?","Confirmation",JOptionPane.YES_NO_OPTION); 
        ArrayList<String> SQL = new ArrayList<String>();
       
        Data Exec = new Data();             
        int year, month;
        String sMonth;      
        
        year = dtTransDate.getDate().getYear() + 1900;
        month = dtTransDate.getDate().getMonth() + 1;
        sMonth =  Integer.toString(month);
        sMonth = (sMonth.length()==1) ? "0" + sMonth : sMonth;
        
        if(result==JOptionPane.YES_OPTION) 
        {          
            if(rollBackTransfer(sMonth, year)==false)
            {
                JOptionPane.showMessageDialog(this, "Error when trying to save.","Information",JOptionPane.OK_OPTION);
                return;
            }                                                
            SQL.add("DELETE FROM trxbudgettransfer WHERE TransNo = '" + txtTransNo.getText().trim() + "'");                              
            Exec.ExecuteSQL(SQL); 
            Exec = null;
            mode.setTransMode(transMode.typeOfTransMode.Wait);
            clearTextBox();        
            enableControls();
        }           
}//GEN-LAST:event_cmdDeleteActionPerformed
   
    private void cmdLocateToBudgetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdLocateToBudgetActionPerformed
        FrmLocateMasterBudget frmOpenTo = new FrmLocateMasterBudget();
        frmOpenTo.setBounds(50, 50, 650, 500);
        frmOpenTo.setVisible(true);
        String pID = "";
        String pName = "";
        pID = frmOpenTo.getBudgetID();
        pName = frmOpenTo.getBudgetName();
        txtToBudgetID.setText(pID.toString());
        txtToBudgetName.setText(pName);
        txtAmount.requestFocus();
}//GEN-LAST:event_cmdLocateToBudgetActionPerformed

    private void cmdLocateEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdLocateEmployeeActionPerformed
      FrmLocateMasterEmployee frmOpen = new FrmLocateMasterEmployee();
      frmOpen.setBounds(50, 50, 500, 500);
      frmOpen.setVisible(true);
      String pEmployeeID = "";
      String pEmployeeName = "";
      pEmployeeID = frmOpen.getEmployeeID();
      pEmployeeName = frmOpen.getEmployeeName();
      txtEmployeeID.setText(pEmployeeID.toString());
      txtEmployeeName.setText(pEmployeeName.toString());          
}//GEN-LAST:event_cmdLocateEmployeeActionPerformed
         
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmdCancel;
    private javax.swing.JButton cmdDelete;
    private javax.swing.JButton cmdExit;
    private javax.swing.JButton cmdLoad;
    private javax.swing.JButton cmdLocateEmployee;
    private javax.swing.JButton cmdLocateFromBudget;
    private javax.swing.JButton cmdLocateToBudget;
    private javax.swing.JButton cmdNew;
    private javax.swing.JButton cmdSave;
    private com.toedter.calendar.JDateChooser dtTransDate;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField txtAmount;
    private javax.swing.JTextArea txtDescription;
    private javax.swing.JTextField txtEmployeeID;
    private javax.swing.JTextField txtEmployeeName;
    private javax.swing.JTextField txtFromBudgetID;
    private javax.swing.JTextField txtFromBudgetName;
    private javax.swing.JTextField txtToBudgetID;
    private javax.swing.JTextField txtToBudgetName;
    private javax.swing.JTextField txtTransNo;
    // End of variables declaration//GEN-END:variables
}
