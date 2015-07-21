/*
 * FrmTrxBudgetUsage.java
 * Created on April 16, 2008, 11:08 AM
 * @author  kusno
 */  
import java.text.NumberFormat; 
import java.util.ArrayList;
import java.text.DateFormat;
import javax.swing.border.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import javax.swing.JTable.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.*;
import javax.swing.*;
import javax.swing.event.*;
import java.text.DecimalFormat;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.lang.String.*;
import java.text.SimpleDateFormat;
import java.lang.*;
import java.util.Date.*;

public class FrmTrxBudgetUsage extends javax.swing.JFrame {
    DefaultTableModel tabMode; 
    transMode mode = new transMode();  
    Data user = new Data(); 
    String UserID;        
   
    public FrmTrxBudgetUsage() {
       String[] strHeader = {"Budget ID","Budget Name","Dept. Trans. No","Amount"};   
       tabMode = new DefaultTableModel(null,strHeader){
       public boolean isCellEditable(int row, int column)
         { 
             if(column <= 1)
             {
                 return false;
             }
             return true;
         }
         };
         UserID = user.getUserID().trim();
         mode.setTransMode(transMode.typeOfTransMode.Wait);
         initComponents(); 
         txtAmount.setDocument(new NumericPlainDocument());
         formatColumn();    
         clearTextBox(); 
         enableControls();
    }
  
    private class TableRenderNumber extends DefaultTableCellRenderer{
      public Component getTableCellRendererComponent( 
      JTable table, Object value,  boolean isSelected, boolean isFocused, int row, int column)
      { 
        setHorizontalAlignment(SwingConstants.RIGHT);  
        Component component = super.getTableCellRendererComponent(table, value, isSelected, isFocused, row, column); 
        if(column==3)
        {
             if( value == null || value .equals(""))
             {        
                ((JLabel) component).setText("0.00"); 
             }
             else
             {        
                double number = 0.0;
                DecimalFormat df = new DecimalFormat(",##0.00");
                try
                {                   
                     number = new Double(value.toString()).doubleValue();                            
                     ((JLabel)component).setText(df.format(number));                     
                }
                catch(Exception e)
                {
                   ((JLabel)component).setText("0.00");
                }               
             }  
        }       
      return component; 
    }
}     
     void formatColumn()
     {        
          tbDetail.getColumnModel().getColumn(0).setPreferredWidth(65);
          tbDetail.getColumnModel().getColumn(1).setPreferredWidth(170);
          tbDetail.getColumnModel().getColumn(2).setPreferredWidth(100);          
          tbDetail.getColumnModel().getColumn(3).setCellRenderer(new TableRenderNumber()); 
          tbDetail.getColumnModel().getColumn(3).setPreferredWidth(80);                    
     }  
      
    void enableControls()
    {
        if(mode.getTransMode()==transMode.typeOfTransMode.Wait)
        {
           txtTransNo.setText("[Auto number]") ;
           txtTransNo.setEnabled(false);
           txtDeptReffNo.setEnabled(false);
           dtTransDate.setEnabled(false);
           cmdLocateEmployee.setEnabled(false);
           txtDescription.setEnabled(false);        
           txtAmount.setEnabled(false);                                  
           cmdAddRow.setEnabled(false);
           cmdDeleteRow.setEnabled(false);           
           cmdLocateBudget.setEnabled(false);
           cmdNew.setEnabled(true);
           cmdExit.setEnabled(true);
           cmdLoad.setEnabled(true);
           cmdSave.setEnabled(false);
           cmdCancel.setEnabled(false);
           cmdDelete.setEnabled(false);
        }
        else            
        {
           txtDeptReffNo.setEnabled(true);
           dtTransDate.setEnabled(true);
           txtDescription.setEnabled(true);
           txtAmount.setEnabled(true);                                  
           cmdAddRow.setEnabled(true);
           cmdDeleteRow.setEnabled(true);                 
           cmdLocateBudget.setEnabled(true);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tbDetail = new javax.swing.JTable();
        cmdSave = new javax.swing.JButton();
        cmdCancel = new javax.swing.JButton();
        cmdExit = new javax.swing.JButton();
        cmdLocateBudget = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDescription = new javax.swing.JTextArea();
        txtTransNo = new javax.swing.JTextField();
        cmdNew = new javax.swing.JButton();
        cmdLoad = new javax.swing.JButton();
        cmdDelete = new javax.swing.JButton();
        txtBudgetID = new javax.swing.JTextField();
        txtBudgetName = new javax.swing.JTextField();
        txtDeptReffNo = new javax.swing.JTextField();
        txtAmount = new javax.swing.JTextField();
        cmdAddRow = new javax.swing.JButton();
        cmdDeleteRow = new javax.swing.JButton();
        cmdLocateEmployee = new javax.swing.JButton();
        txtEmployeeID = new javax.swing.JTextField();
        txtEmployeeName = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        dtTransDate = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Budget Usage");
        setAlwaysOnTop(true);
        setResizable(false);

        tbDetail.setModel(tabMode);
        jScrollPane1.setViewportView(tbDetail);

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

        cmdLocateBudget.setText("...");
        cmdLocateBudget.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdLocateBudgetActionPerformed(evt);
            }
        });

        jLabel6.setText("Trans. No");

        jLabel7.setText("Trans. Date");

        jLabel8.setText("Description");

        txtDescription.setColumns(20);
        txtDescription.setRows(5);
        jScrollPane2.setViewportView(txtDescription);

        txtTransNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTransNoActionPerformed(evt);
            }
        });

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

        txtBudgetID.setEditable(false);

        txtBudgetName.setEditable(false);
        txtBudgetName.setDisabledTextColor(new java.awt.Color(255, 255, 255));

        txtAmount.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        cmdAddRow.setFont(new java.awt.Font("Tahoma", 1, 18));
        cmdAddRow.setText("+");
        cmdAddRow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdAddRowActionPerformed(evt);
            }
        });

        cmdDeleteRow.setFont(new java.awt.Font("Tahoma", 1, 18));
        cmdDeleteRow.setText("-");
        cmdDeleteRow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdDeleteRowActionPerformed(evt);
            }
        });

        cmdLocateEmployee.setText("...");
        cmdLocateEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdLocateEmployeeActionPerformed(evt);
            }
        });

        txtEmployeeID.setEditable(false);

        txtEmployeeName.setEditable(false);
        txtEmployeeName.setDisabledTextColor(new java.awt.Color(255, 255, 255));

        jLabel10.setText("Employee ID");

        dtTransDate.setToolTipText("please choose date..");
        dtTransDate.setDateFormatString("yyyy-MM-dd");

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                            .add(org.jdesktop.layout.GroupLayout.LEADING, layout.createSequentialGroup()
                                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 481, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(cmdDeleteRow))
                            .add(org.jdesktop.layout.GroupLayout.LEADING, layout.createSequentialGroup()
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(txtBudgetID, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 105, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                    .add(jLabel6, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 61, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                    .add(jLabel7, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 76, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                .add(6, 6, 6)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(layout.createSequentialGroup()
                                        .add(txtEmployeeID, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 102, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .add(9, 9, 9)
                                        .add(cmdLocateEmployee, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 27, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                        .add(txtEmployeeName, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 270, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                    .add(layout.createSequentialGroup()
                                        .add(cmdLocateBudget, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 27, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .add(18, 18, 18)
                                        .add(txtDeptReffNo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 134, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                        .add(txtAmount, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 116, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                        .add(cmdAddRow))
                                    .add(jScrollPane2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 395, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                    .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                                        .add(org.jdesktop.layout.GroupLayout.LEADING, dtTransDate, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .add(org.jdesktop.layout.GroupLayout.LEADING, txtTransNo, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)))))
                        .addContainerGap(9, Short.MAX_VALUE))
                    .add(layout.createSequentialGroup()
                        .add(cmdNew, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 74, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(cmdLoad, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 79, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(cmdSave, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 69, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(cmdCancel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 69, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(cmdDelete, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 73, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(cmdExit, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 70, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(396, 396, 396))
                    .add(jLabel8)
                    .add(jLabel10, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 76, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(layout.createSequentialGroup()
                        .add(txtBudgetName, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 444, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(95, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(layout.createSequentialGroup()
                        .add(jLabel6)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(jLabel7)
                        .add(7, 7, 7))
                    .add(layout.createSequentialGroup()
                        .add(txtTransNo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(dtTransDate, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel10)
                    .add(txtEmployeeID, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(cmdLocateEmployee, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 23, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(txtEmployeeName, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(8, 8, 8)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jLabel8)
                    .add(jScrollPane2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(txtBudgetID, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(cmdLocateBudget, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 23, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(txtDeptReffNo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(txtAmount, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(cmdAddRow, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 23, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(txtBudgetName, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 197, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(cmdCancel)
                            .add(cmdDelete)
                            .add(cmdSave)
                            .add(cmdExit)
                            .add(cmdNew)
                            .add(cmdLoad)))
                    .add(cmdDeleteRow, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 23, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(17, 17, 17))
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-557)/2, (screenSize.height-504)/2, 557, 504);
    }// </editor-fold>//GEN-END:initComponents

    private boolean isValidate()
    {        
        if(mode.getTransMode()==transMode.typeOfTransMode.EditRecord)
        {
            Data User = new Data(); 
            if(User.UserRight(UserID, "TSK-002",Data.typeOfAction.Modify)==false)
            {
                JOptionPane.showMessageDialog(this, "You dont have right to modify data.","Information",JOptionPane.OK_OPTION);
                return false;
            }     
        }
        
        if(txtEmployeeID.getText().equals(""))
        {
            JOptionPane.showMessageDialog(this,"Employee ID is still empty.","Warning",JOptionPane.OK_OPTION);
            cmdLocateEmployee.requestFocus();
            return false;
        }
        
        if(tabMode.getRowCount()==0)
        {
            JOptionPane.showMessageDialog(this, "Detail of usage is still empty.","Warning",JOptionPane.OK_OPTION);
            return false;
        }
        
        for(byte n=0;n<tabMode.getRowCount();n++)
        {
            String vID = (String)tabMode.getValueAt(n, 0);
            String vDeptReffNo = (String)tabMode.getValueAt(n,2);
            if(detailAlreadyExists(vID, vDeptReffNo,n)==true)
            {
                return false;
            }            
            Object BeginningBalance = tabMode.getValueAt(n, 3);                                    
            String str = BeginningBalance.toString(); 
            try
            {                  
                double d = Double.valueOf(str).doubleValue();                
            }
            catch(Exception e)
            {
                byte nn = (byte)n;
                JOptionPane.showMessageDialog(this, "There is an error while you are trying to input numeric value in row no-" + (nn+1) + "\nThe Amount is : " + str,"Warning",JOptionPane.OK_OPTION);
                return false;
            }
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
     
    private ArrayList<String>rollBackDetail(String sMonth, Integer year)
    {
        ArrayList<String> SQLRB = new ArrayList<String>();
        String SQL = "SELECT BudgetID, Amount FROM trxbudgetusagedetail where TransNo = '" + txtTransNo.getText().trim() + "'";   
        try {
            DBConnection getCn = new DBConnection();
            Connection cnRollback = getCn.getConnection();
            Statement stRollback = cnRollback.createStatement();
            ResultSet rsRollback = stRollback.executeQuery(SQL);
            while(rsRollback.next())
            {
                String ID = rsRollback.getString(1);
                Double amount = rsRollback.getDouble(2);
                SQLRB.add("UPDATE trxbudget SET BudgetOut" + sMonth + "=BudgetOut" + sMonth + "-" + amount + " WHERE Year = " + year + " AND BudgetID = '" + ID + "' AND EmployeeID = '" + txtEmployeeID.getText().trim() + "'");                
            }
            Data data = new Data();
            data.closingConnection (cnRollback,stRollback,rsRollback);
            data = null;
        }
        catch (SQLException e) 
        {
           return null;
        }
        return SQLRB;
    }
    
    private String getAutoNumber(Integer year)
    {
        String temp=Integer.toString(year) + "-00001";
        String SQL = "SELECT TransNo FROM trxbudgetusage WHERE Year = " + year + " ORDER BY TransNo DESC LIMIT 1 ";   
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
        
        double row = tabMode.getRowCount();       
        if(result==JOptionPane.YES_OPTION) 
        {
            if(isValidate()==true)
            {
                Data Exec = new Data();
                if(mode.getTransMode()==transMode.typeOfTransMode.EditRecord)
                {
                    ArrayList<String> tempSQL = new ArrayList<String>();
                    tempSQL = rollBackDetail(sMonth, year);
                    for (int n=0;n <= tempSQL.size() -1; n++)
                    {
                        SQL.add(tempSQL.get(n).toString());
                    }                                                  
                    SQL.add("DELETE FROM trxbudgetusagedetail WHERE TransNo = '" + txtTransNo.getText().trim() + "'");                  
                    SQL.add("UPDATE trxbudgetusage SET TransDate = '" + date + "', Year = '" + year + "', Description = '" + txtDescription.getText().trim() + "', EmployeeID = '" + txtEmployeeID.getText().trim() + "' WHERE TransNo = '" + txtTransNo.getText().trim() + "'");                                         
                    for(int i=0; i<row; i++) 
                    {
                        int ii = i + 1;
                        String id = (String)tabMode.getValueAt(i, 0);
                        String deptReffNo = (String)tabMode.getValueAt(i,2);
                        Object amount = tabMode.getValueAt(i, 3);    
                        SQL.add("INSERT INTO trxbudgetusagedetail VALUES('" + txtTransNo.getText().trim() + "', '" + id + "', '" + deptReffNo + "', " + amount + ", " + ii + ")");                                                
                        SQL.add("UPDATE trxbudget SET BudgetOut" + sMonth + "=BudgetOut" + sMonth + "+" + amount + " WHERE Year = " + year + " AND EmployeeID = '" + txtEmployeeID.getText().trim() + "' AND BudgetID = '" + id + "'");
                    }  
                    Exec.ExecuteSQL(SQL); 
                }
                else
                if(mode.getTransMode()==transMode.typeOfTransMode.AddRecord)
                {
                    String autoNumber = getAutoNumber(year);
                    SQL.add("INSERT INTO trxbudgetusage VALUES('" + autoNumber + "', '" + date + "', '" + txtEmployeeID.getText().trim() + "', '" + year + "','" + txtDescription.getText().trim() + "')");                                             
                    for(int i=0; i<row; i++) 
                    {
                        int ii = i + 1;
                        String id = (String)tabMode.getValueAt(i, 0);
                        String deptReffNo = (String)tabMode.getValueAt(i,2);
                        Object amount = tabMode.getValueAt(i, 3);    
                        SQL.add("INSERT INTO trxbudgetusagedetail VALUES('" + autoNumber + "', '" + id + "', '" + deptReffNo + "', " + amount + "," + ii + ")");                        
                        SQL.add("UPDATE trxbudget SET BudgetOut" + sMonth + "=BudgetOut" + sMonth + "+" + amount + " WHERE Year = " + year + " AND BudgetID = '" + id + "' AND EmployeeID = '" + txtEmployeeID.getText().trim() + "'");
                    }
                    Exec.ExecuteSQL(SQL); 
                    Exec = null;
                }                        
                mode.setTransMode(transMode.typeOfTransMode.Wait);  
                clearTextBox();        
                enableControls();             
            }
        }
    }//GEN-LAST:event_cmdSaveActionPerformed
    
    void clearTextBox()
    {
        txtDeptReffNo.setText("");        
        dtTransDate.setDate(new java.util.Date());   
        txtDescription.setText("");
        txtBudgetID.setText("");
        txtBudgetName.setText("");
        txtAmount.setText("0");
        txtEmployeeID.setText("");
        txtEmployeeName.setText("");
        tabMode.setRowCount(0); 
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

    private void cmdLocateBudgetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdLocateBudgetActionPerformed
        FrmLocateMasterBudget frmOpen = new FrmLocateMasterBudget();
        frmOpen.setBounds(50, 50, 650, 500);
        frmOpen.setVisible(true);
        String pID = "";
        String pName = "";
        pID = frmOpen.getBudgetID();
        pName = frmOpen.getBudgetName();
        txtBudgetID.setText(pID.toString());
        txtBudgetName.setText(pName);
        txtDeptReffNo.requestFocus();
}//GEN-LAST:event_cmdLocateBudgetActionPerformed

    private void txtTransNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTransNoActionPerformed
   
}//GEN-LAST:event_txtTransNoActionPerformed

    private void cmdNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdNewActionPerformed
        Data User = new Data(); 
        if(User.UserRight(UserID, "TSK-002",Data.typeOfAction.Add)==false)
        {
             JOptionPane.showMessageDialog(this, "You dont have right to add data.","Information",JOptionPane.OK_OPTION);
             return ;
        }        
        mode.setTransMode(transMode.typeOfTransMode.AddRecord);
        clearTextBox();        
        enableControls();
        cmdLocateEmployee.requestFocus();        
}//GEN-LAST:event_cmdNewActionPerformed

    private void cmdLoadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdLoadActionPerformed
        FrmLocateTrxBudgetUsage frmLoad = new FrmLocateTrxBudgetUsage();
        frmLoad.setBounds(50, 50, 550, 490);
        frmLoad.setVisible(true);         
        String transNo = ""; 
        transNo = frmLoad.getTransNo();       
        if(!transNo.trim().equals(""))
        {                
             mode.setTransMode(transMode.typeOfTransMode.EditRecord);  
             clearTextBox();        
             enableControls(); 
             loadHeader(transNo);
             loadDetail(transNo);             
        }
        else
        {
            JOptionPane.showMessageDialog(this, "No Transaction is selected.","Information",JOptionPane.OK_OPTION);
        }
}//GEN-LAST:event_cmdLoadActionPerformed

    void loadHeader(String TransNo)
    {
        String SQL = "SELECT TransNo, TransDate, trx.EmployeeId, me.EmployeeName, Description FROM trxbudgetusage trx INNER JOIN masteremployee me on trx.employeeID = me.EmployeeID where TransNo = '" + TransNo.trim() + "'";   
        try {
            DBConnection getCn = new DBConnection();
            Connection cn = getCn.getConnection();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            if(rs.next())
            {
                String transNo = rs.getString(1);
                java.util.Date transDate = rs.getDate(2);
                String EmployeeID = rs.getString(3);
                String EmployeeName = rs.getString(4);
                String note = rs.getString(5);
                
                txtTransNo.setText(transNo);
                dtTransDate.setDate(transDate);
                txtEmployeeID.setText(EmployeeID);
                txtEmployeeName.setText(EmployeeName);
                txtDescription.setText(note);               
            }
            Data data = new Data();
            data.closingConnection (cn,st,rs);
            data = null;
        }
        catch (Exception e)
        {
            
        }
    }
    
    void loadDetail(String TransNo)
    {
        String SQL = "SELECT trxbudgetusagedetail.BudgetID, BudgetName, DeptReffNo, Amount FROM trxbudgetusagedetail INNER JOIN masterbudget on trxbudgetusagedetail.BudgetID = masterbudget.BudgetID WHERE TransNo = '" + TransNo.trim() + "' ORDER BY Seq";   
        try {
            DBConnection getCn = new DBConnection();
            Connection cn = getCn.getConnection();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            while(rs.next())
            {
                String id = rs.getString(1);
                String name = rs.getString(2);
                String deptNo = rs.getString(3); 
                long amount = rs.getLong(4);
                String fmt = "#############.######";
                DecimalFormat df = new DecimalFormat (fmt); 
                String sAmount = df.format (amount); 
                Object[] data = {id,name,deptNo,sAmount};
                tabMode.addRow(data);
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
        if(User.UserRight(UserID, "TSK-002",Data.typeOfAction.Delete)==false)
        {
             JOptionPane.showMessageDialog(this, "You dont have right to delete.","Information",JOptionPane.OK_OPTION);
             return ;
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
            ArrayList<String> tempSQL = new ArrayList<String>();
            tempSQL = rollBackDetail(sMonth, year);
            for (int n=0;n <= tempSQL.size() -1; n++)
            {
                SQL.add(tempSQL.get(n).toString());
            }                                 
            SQL.add("DELETE FROM trxbudgetusage WHERE TransNo = '" + txtTransNo.getText().trim() + "'");                  
            SQL.add("DELETE FROM trxbudgetusagedetail WHERE TransNo = '" + txtTransNo.getText().trim() + "'");                              
            Exec.ExecuteSQL(SQL);   
            Exec = null;
            mode.setTransMode(transMode.typeOfTransMode.Wait);
            clearTextBox();        
            enableControls();
        }           
}//GEN-LAST:event_cmdDeleteActionPerformed
   
    private void cmdAddRowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdAddRowActionPerformed
        if(txtDeptReffNo.getText().trim().equals(""))
        {
            JOptionPane.showMessageDialog(this,"Department Reff No. is still empty.","Warning",JOptionPane.OK_OPTION);
            txtDeptReffNo.requestFocus();
            return;
        }
        
        if(txtBudgetID.getText().trim().equals(""))
        {
            JOptionPane.showMessageDialog(this,"Budget ID is still empty.","Warning",JOptionPane.OK_OPTION);
            cmdLocateBudget.requestFocus();
            return;
        }
        
        if(detailAlreadyExists(txtBudgetID.getText().trim(),txtDeptReffNo.getText().trim())==true)
        {
            return;
        }
        
        if(txtAmount.getText().trim().equals("") || txtAmount.getText().trim().equals("0"))
        {
            JOptionPane.showMessageDialog(this,"Amount is still empty or zero.","Warning",JOptionPane.OK_OPTION);
            txtAmount.requestFocus();
            return;
        }
        
        double d = Double.valueOf(txtAmount.getText()).doubleValue();
        if(d==0)
        {
            JOptionPane.showMessageDialog(this,"Amount is still empty or zero.","Warning",JOptionPane.OK_OPTION);
            txtAmount.requestFocus();
            return;
        }        
        DecimalFormat df = new DecimalFormat ("0.00"); 
        String strNilai = df.format (d);                
        Object[] data = {txtBudgetID.getText().trim(),txtBudgetName.getText().trim(),txtDeptReffNo.getText().trim(),strNilai};               
        tabMode.addRow(data);        
}//GEN-LAST:event_cmdAddRowActionPerformed

    private boolean detailAlreadyExists(String id, String DeptReffNo)
    {
        for(byte i=0;i<tabMode.getRowCount();i++)
        {
            String vID = (String)tabMode.getValueAt(i, 0);
            String vDeptReffNo = (String)tabMode.getValueAt(i,2);
            if(vID.trim().equals(id.trim()) && vDeptReffNo.trim().equals(DeptReffNo.trim()))
            {
                byte ii = (byte)i;
                JOptionPane.showMessageDialog(this,"Budget ID : " + id + " with Dept. Reff. No : " + DeptReffNo + " is already exists in row no-" + (i+1),"Information",JOptionPane.OK_OPTION);
                return true;
            }
        }        
        return false;
    }
    
    private boolean detailAlreadyExists(String id, String DeptReffNo, byte notRow)
    {
        for(byte i=0;i<tabMode.getRowCount();i++)
        {
            if(notRow!=i)
            {
               String vID = (String)tabMode.getValueAt(i, 0);
               String vDeptReffNo = (String)tabMode.getValueAt(i,2);
               if(vID.trim().equals(id.trim()) && vDeptReffNo.trim().equals(DeptReffNo.trim()))
               {
                  byte ii = (byte)i;
                  JOptionPane.showMessageDialog(this,"Budget ID : " + id + " with Dept. Reff. No : " + DeptReffNo + " is already exists in row no-" + (i+1),"Information",JOptionPane.OK_OPTION);
                  return true;
               }  
            }           
        }        
        return false;
    }
    
    private void cmdDeleteRowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdDeleteRowActionPerformed
        System.out.println(tbDetail.getSelectedRow());
        if(tbDetail.getSelectedRow()>=0)
        {
            tabMode.removeRow(tbDetail.getSelectedRow());
        }
}//GEN-LAST:event_cmdDeleteRowActionPerformed

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
    private javax.swing.JButton cmdAddRow;
    private javax.swing.JButton cmdCancel;
    private javax.swing.JButton cmdDelete;
    private javax.swing.JButton cmdDeleteRow;
    private javax.swing.JButton cmdExit;
    private javax.swing.JButton cmdLoad;
    private javax.swing.JButton cmdLocateBudget;
    private javax.swing.JButton cmdLocateEmployee;
    private javax.swing.JButton cmdNew;
    private javax.swing.JButton cmdSave;
    private com.toedter.calendar.JDateChooser dtTransDate;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbDetail;
    private javax.swing.JTextField txtAmount;
    private javax.swing.JTextField txtBudgetID;
    private javax.swing.JTextField txtBudgetName;
    private javax.swing.JTextField txtDeptReffNo;
    private javax.swing.JTextArea txtDescription;
    private javax.swing.JTextField txtEmployeeID;
    private javax.swing.JTextField txtEmployeeName;
    private javax.swing.JTextField txtTransNo;
    // End of variables declaration//GEN-END:variables
}
