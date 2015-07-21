/*
 * FrmTrxBeginningBalance.java
 * Created on April 14, 2008, 11:04 AM
 * @author  kusno
 */  
import java.util.ArrayList;
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
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import jxl.*;

public class FrmTrxBeginningBalance extends javax.swing.JFrame {    
     String[] strHeader = {"Budget ID","Budget Name","Group","Beginning Balance"};
     DefaultTableModel tabMode; 
     
    public FrmTrxBeginningBalance() 
    {
        tabMode = new DefaultTableModel(null,strHeader)                
        {
        public boolean isCellEditable(int row, int column)
        {
            if(column <= 2)
            {
                return false;
            }
            return true;
        } 
        };        
        initComponents();        
        formatColumn();      
        Data clsData = new Data();
        txtYear.setText(clsData.getActivePeriod());
        clsData = null;
    } 
     
    void fillTable()
    {
        Data clsData = new Data();        
        String SQL = "SELECT masterbudget.BudgetID, masterbudget.BudgetName, masterbudgetgroup.BudgetGroupName FROM masterbudget INNER JOIN masterbudgetgroup on masterbudget.BudgetGroupID = masterbudgetgroup.BudgetGroupID ORDER BY BudgetID";        
        tabMode.setRowCount(0);
        try{
            DBConnection getCn = new DBConnection();
            Connection cn = getCn.getConnection();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            while(rs.next())
            {
                String budgetID = rs.getString(1);
                String budgetName = rs.getString(2);                
                String groupName = rs.getString(3);       
                
                long beginningBalance = getBeginningBalance(budgetID);
                String fmt = "#############.######";
                DecimalFormat df = new DecimalFormat (fmt); 
                String strBeginningBalance = df.format (beginningBalance);               
                Object[] data = {budgetID,budgetName,groupName,strBeginningBalance};
                tabMode.addRow(data);     
            }          
            clsData.closingConnection (cn,st,rs);
        }
        catch(SQLException e)
        {
            
        }    
     }    
    
    private long getBeginningBalance(String id)
    {
        String SQL = "SELECT BeginningBalance FROM trxbudget WHERE BudgetID = '" + id + "' AND Year = '" + txtYear.getText().trim() + "' and EmployeeID = '" + txtEmployeeID.getText().trim() + "'";
        long beginningBalance = 0;
        try{
            DBConnection getCn = new DBConnection();
            Connection cn = getCn.getConnection();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(SQL);             
            if(rs.next())
            {
               beginningBalance = rs.getLong(1);
            }         
            Data close = new Data();
            close.closingConnection (cn,st,rs);
        }
        catch(SQLException e) {            
        }  
        return beginningBalance;
    }    
   
    private class TableRenderNumber extends DefaultTableCellRenderer{
      public Component getTableCellRendererComponent( 
      JTable table, 
      Object value, 
      boolean isSelected, 
      boolean isFocused, 
      int row, int column) { 
        setHorizontalAlignment(SwingConstants.RIGHT);
  
      Component component = super.getTableCellRendererComponent( 
        table, value, isSelected, isFocused, row, column); 
        if(column==3)
        {
             if( value == null || value .equals(""))
        {        
            ( (JLabel) component).setText(""); 
        }
        else
        {        
          double number =0;
          number = new Double(value.toString()).doubleValue();        
          DecimalFormat df = new DecimalFormat("###,###,###,###,###.00");
          ((JLabel) component).setText(df.format(number));
        }  
        }       
      return component; 
  }
}       
    void formatColumn()
    {        
          tbBudget.getColumnModel().getColumn(0).setPreferredWidth(60);
          tbBudget.getColumnModel().getColumn(1).setPreferredWidth(190);
          tbBudget.getColumnModel().getColumn(2).setPreferredWidth(100);          
          tbBudget.getColumnModel().getColumn(3).setCellRenderer(new TableRenderNumber()); 
          tbBudget.getColumnModel().getColumn(3).setPreferredWidth(100);           
          TableCellEditor fce = new NumericOnly();
	  tbBudget.setDefaultEditor(Object.class, fce);
    }
   
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbBudget = new javax.swing.JTable();
        cmdSave = new javax.swing.JButton();
        cmdExit = new javax.swing.JButton();
        pb = new javax.swing.JProgressBar();
        jLabel6 = new javax.swing.JLabel();
        txtEmployeeID = new javax.swing.JTextField();
        cmdLocateEmployee = new javax.swing.JButton();
        txtEmployeeName = new javax.swing.JTextField();
        txtYear = new javax.swing.JTextField();
        cmdExcel = new javax.swing.JButton();

        org.jdesktop.layout.GroupLayout jDialog1Layout = new org.jdesktop.layout.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Beginning Balance");
        setAlwaysOnTop(true);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12));
        jLabel1.setText("Year");

        tbBudget.setModel(tabMode);
        tbBudget.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                tbBudgetInputMethodTextChanged(evt);
            }
        });
        jScrollPane1.setViewportView(tbBudget);

        cmdSave.setText("Save");
        cmdSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdSaveActionPerformed(evt);
            }
        });

        cmdExit.setText("Exit");
        cmdExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdExitActionPerformed(evt);
            }
        });

        pb.setStringPainted(true);

        jLabel6.setText("Employee ID");

        txtEmployeeID.setBackground(new java.awt.Color(255, 255, 255));
        txtEmployeeID.setEditable(false);

        cmdLocateEmployee.setText("...");
        cmdLocateEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdLocateEmployeeActionPerformed(evt);
            }
        });

        txtEmployeeName.setBackground(new java.awt.Color(255, 255, 255));
        txtEmployeeName.setEditable(false);

        txtYear.setBackground(new java.awt.Color(255, 255, 255));
        txtYear.setEditable(false);

        cmdExcel.setText("Export from Excel");
        cmdExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdExcelActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(jLabel6, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 76, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(txtEmployeeID, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 84, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(cmdLocateEmployee, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 27, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(txtEmployeeName, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE))
                    .add(layout.createSequentialGroup()
                        .add(jLabel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 41, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(39, 39, 39)
                        .add(txtYear, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 47, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(pb, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 322, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 455, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                        .add(cmdSave, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 73, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(cmdExit, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 72, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 185, Short.MAX_VALUE)
                        .add(cmdExcel)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 23, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(txtYear, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(pb, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel6)
                    .add(txtEmployeeID, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(cmdLocateEmployee, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 23, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(txtEmployeeName, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 412, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(cmdExit, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 23, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(cmdSave, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 23, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(cmdExcel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 23, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        java.awt.Dimension dialogSize = getSize();
        setLocation((screenSize.width-dialogSize.width)/2,(screenSize.height-dialogSize.height)/2);
    }// </editor-fold>//GEN-END:initComponents

    private boolean isValidate()
    {         
         Data data = new Data();
         String SQL;
         String tempResult;
         SQL = "SELECT BeginningBalanceStatus FROM trxperioddetail WHERE EmployeeID = '" + txtEmployeeID.getText().trim() + "' AND Year = '" + txtYear.getText().trim() + "'";
         try{
            DBConnection getCn = new DBConnection();
            Connection cn = getCn.getConnection();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(SQL);             
            if(rs.next())
            {
                 tempResult = rs.getString(1).trim();
                 if(tempResult.equals("1"))
                 {
                    JOptionPane.showMessageDialog(this,"Beginning Balance can not be saved any more. It's locked.","Information",JOptionPane.OK_OPTION);             
                    data.closingConnection(cn, st, rs);
                    data=null;
                    return false;
                 }        
                 data.closingConnection(cn, st, rs);
                 data=null;               
            }                      
        }
        catch(SQLException e) 
        {
            
        }  
        return true;
    }
    
    private void cmdSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdSaveActionPerformed
        Data user = new Data(); 
        String UserID;    
        UserID = user.getUserID().trim();
        if(user.UserRight(UserID, "TSK-001",Data.typeOfAction.Add)==false)
        {
            JOptionPane.showMessageDialog(this, "You dont have right to add.","Information",JOptionPane.OK_OPTION);
            user = null;
            return ;
        }
        user = null;
        
        ArrayList<String> SQLArray = new ArrayList<String>();
        String SQL;         
        Data Exec = new Data();
        if(isValidate()==false)
        {
            return;
        }
        int result = JOptionPane.showConfirmDialog(this,"You can not change data that you want to save.\nDo you want to continue ?","Confirmation",JOptionPane.YES_NO_OPTION);
      
        if(result==JOptionPane.YES_OPTION)
        {               
             double row = tabMode.getRowCount(); 
             int move = 0;
             double moved = 0.0;
             pb.setMaximum(100);                
             for(int i=0; i<row; i++)
             {                    
                String id = (String)tabMode.getValueAt(i, 0);
                Object beginningBalance = tabMode.getValueAt(i, 3);                 
                if(isBudgetIDExists(id)==true)
                {
                    SQL = "UPDATE trxbudget SET BeginningBalance = " + beginningBalance + " WHERE BudgetID = '" + id + "' AND EmployeeID = '" + txtEmployeeID.getText().trim() + "' AND Year = '" + txtYear.getText().trim() + "'";                            
                }
                else
                {
                    SQL = "INSERT INTO trxbudget (BudgetID, Year, EmployeeID, BeginningBalance) VALUES('" + id + "','" + txtYear.getText().trim() + "', '" + txtEmployeeID.getText().trim() + "', " + beginningBalance + ")";
                }                                
                SQLArray.add(SQL);
                moved = (i/row) * 100;                 
                move = (int)moved; 
                pb.setValue(move);
            }              
            SQL = "UPDATE trxperioddetail SET BeginningBalanceStatus = '1' WHERE Year = '" + txtYear.getText().trim() + "' and EmployeeID = '" + txtEmployeeID.getText().trim() + "'";                        
            SQLArray.add(SQL);
            Exec.ExecuteSQL(SQLArray);
            Exec = null;
            fillTable();           
        }                  
    }//GEN-LAST:event_cmdSaveActionPerformed

    private boolean isBudgetIDExists(String id)
    {
        boolean exists = false;
        String SQL = "SELECT BudgetID FROM trxbudget WHERE BudgetID = '" + id + "' AND Year = '" + txtYear.getText().trim() + "' and EmployeeID = '" + txtEmployeeID.getText().trim() + "'";        
         try{
            DBConnection getCn = new DBConnection();
            Connection cn = getCn.getConnection();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(SQL);             
            if(rs.next())
            {
               exists = true;
            }          
            rs.close(); st.close(); cn.close();            
        }
        catch(SQLException e) {
        }  
        return exists;
    }
    
    private void cmdExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdExitActionPerformed
          dispose();
          setVisible(false);
    }//GEN-LAST:event_cmdExitActionPerformed

    private void tbBudgetInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_tbBudgetInputMethodTextChanged
}//GEN-LAST:event_tbBudgetInputMethodTextChanged

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
        if(!pEmployeeID.equals(""))
        {         
            fillTable();            
        }
}//GEN-LAST:event_cmdLocateEmployeeActionPerformed

    private void cmdExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdExcelActionPerformed
        if(txtEmployeeID.getText().trim().equals(""))
        {
            JOptionPane.showMessageDialog(this, "Employee ID is still empty.","Warning",JOptionPane.INFORMATION_MESSAGE);
            cmdLocateEmployee.requestFocus();
            return;
        }
        try              
        {
            JFileChooser jfc = new JFileChooser(); 
            ExampleFileFilter filter = new ExampleFileFilter();
            filter.addExtension("xls");            
            filter.setDescription("Excel");            
            jfc.setFileFilter(filter);

            int result = jfc.showOpenDialog(this); 
            if (result==JFileChooser.APPROVE_OPTION) 
            { 
                 exportFromExcel(jfc.getSelectedFile().toString());
            } else 
            {
                System.out.println("Open file cancelled, or error!"); 
            }
        }            
        catch(Exception e)
        {
            
        }
    }//GEN-LAST:event_cmdExcelActionPerformed
     
    void exportFromExcel(String fileName)
    {
        ArrayList<String> SQLArray = new ArrayList<String>();        
        String SQL;       
        String checkBudgetID;
        Data data = new Data();
        
        if(isValidate()==false)
        {
            return;
        }
        try
        {
             Workbook workbook = Workbook.getWorkbook(new File(fileName)); 
             Sheet sheet = workbook.getSheet(0); 
             
             boolean ok;
             ok = true;
             int n = 1;
             while(ok==true)
             {             
                 Cell cEmployeeID = sheet.getCell(0,n);                   
                 if(sheet.getCell(0,n)==null)
                 {
                     ok = false;
                 }
                 Cell cBudgetID = sheet.getCell(2,n); 
                 Cell cAmount = sheet.getCell(4,n);              
                 
                 String employeeID = cEmployeeID.getContents();                
                 String budgetID = cBudgetID.getContents();
                 String sAmount = cAmount.getContents();
                 double amount = Double.valueOf(sAmount).doubleValue();     
                 
                 checkBudgetID = data.getFieldStringValue("MasterBudget", "BudgetID", budgetID, "budgetID");
                 if(!checkBudgetID.equals("") && employeeID.equals(txtEmployeeID.getText().trim()))
                 {
                     if(isBudgetIDExists(budgetID)==true)
                     {
                        SQL = "UPDATE trxbudget SET BeginningBalance = " + amount + " WHERE BudgetID = '" + budgetID + "' AND EmployeeID = '" + txtEmployeeID.getText().trim() + "' AND Year = '" + txtYear.getText().trim() + "'";                            
                     }   
                     else
                     {
                        SQL = "INSERT INTO trxbudget (BudgetID, Year, EmployeeID, BeginningBalance) VALUES('" + budgetID + "','" + txtYear.getText().trim() + "', '" + txtEmployeeID.getText().trim() + "', " + amount + ")";
                     }                                
                     SQLArray.add(SQL);
                 }
                 n = n + 1;
             }
             workbook.close(); 
        }
        catch(Exception e)
        {
            System.out.println(e.toString());          
        }
        if(SQLArray.size()>0)
        {
            SQL = "UPDATE trxperioddetail SET BeginningBalanceStatus = '1' WHERE Year = '" + txtYear.getText().trim() + "' and EmployeeID = '" + txtEmployeeID.getText().trim() + "'";
            SQLArray.add(SQL);
            data.ExecuteSQL(SQLArray);
            fillTable();
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmdExcel;
    private javax.swing.JButton cmdExit;
    private javax.swing.JButton cmdLocateEmployee;
    private javax.swing.JButton cmdSave;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JProgressBar pb;
    private javax.swing.JTable tbBudget;
    public javax.swing.JTextField txtEmployeeID;
    public javax.swing.JTextField txtEmployeeName;
    public javax.swing.JTextField txtYear;
    // End of variables declaration//GEN-END:variables
}
