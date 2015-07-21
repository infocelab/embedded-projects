/*
 * FrmMasterEmployee.java
 * Created on June 9, 2008, 8:30 AM
 * @author  kusno
 */ 
import javax.swing.JOptionPane;
import java.sql.*;
import javax.swing.JTable.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.*;

public class FrmMasterEmployee extends javax.swing.JFrame {
    transMode mode = new transMode();    
    String[] strHeader = {"Employee ID","Employee Name","Title ID","Title Name","Status"};
    DefaultTableModel tabMode;
    Data user = new Data(); 
    String UserID;    
     
    public FrmMasterEmployee() {
       mode.setTransMode(transMode.typeOfTransMode.Wait);
       tabMode = new DefaultTableModel(null,strHeader)
               {
    public boolean isCellEditable(int row, int column)
    {
        return false;
    }
};  
       initComponents(); 
       UserID = user.getUserID().trim();
       fillComboTitle();
       clearTextBox();
       enableControls();
       fillTable("");
    }
    
    void formatTableColumn()
    {        
          tblEmployee.getColumnModel().getColumn(0).setPreferredWidth(40);
          tblEmployee.getColumnModel().getColumn(1).setPreferredWidth(110);
          tblEmployee.getColumnModel().getColumn(2).setPreferredWidth(30);                    
          tblEmployee.getColumnModel().getColumn(3).setPreferredWidth(90);    
          tblEmployee.getColumnModel().getColumn(4).setPreferredWidth(30);    
    }
    
     void fillComboTitle() 
    {
        String SQL = "SELECT TitleName FROM MasterTitle ORDER BY Level";
        Data clsCombo = new Data();
        clsCombo.FillComboBox(SQL, cmbTitle, "--CHOOSEE--");
        clsCombo =  null;
    }
    
    void clearTextBox(){
        txtEmployeeID.setText("");
        txtEmployeeName.setText("");
        cmbStatus.setSelectedIndex(0);
        cmbTitle.setSelectedIndex(0);
    }
    
    void fillTable(String keyword)
    {
        String SQL = "";
        SQL = "SELECT me.EmployeeID, me.EmployeeName, me.TitleID, mt.TitleName, me.EmployeeStatus FROM MasterEmployee me inner join MasterTitle mt on me.TitleID = mt.TitleID ";
        if(chkActive.isSelected()==false)
        {
            if(!keyword.equals(""))
            {
                if(cmbSearch.getSelectedIndex()==0)
                {
                    SQL += " WHERE me.EmployeeID LIKE '%" + keyword + "%'";
                }
                else
                if(cmbSearch.getSelectedIndex()==1)                    
                {
                    SQL += " WHERE me.EmployeeName LIKE '%" + keyword + "%'";
                }
                else
                if(cmbSearch.getSelectedIndex()==2)                    
                {
                    SQL += " WHERE me.TitleId LIKE '%" + keyword + "%'";
                }
                else                 
                {
                    SQL += " WHERE MT.TitleName LIKE '%" + keyword + "%'";
                }
            }
        }
        else
        {
            SQL += " WHERE me.EmployeeStatus = 'A'";
            if(!keyword.equals(""))
            {
                if(cmbSearch.getSelectedIndex()==0)
                {
                    SQL += " AND me.EmployeeID LIKE '%" + keyword + "%'";
                }
                else
                if(cmbSearch.getSelectedIndex()==1)                    
                {
                    SQL += " AND me.EmployeeName LIKE '%" + keyword + "%'";
                }
                else
                if(cmbSearch.getSelectedIndex()==2)                    
                {
                    SQL += " AND me.TitleId LIKE '%" + keyword + "%'";
                }
                else                 
                {
                    SQL += " AND mt.TitleName LIKE '%" + keyword + "%'";
                }
            }            
        }        
        SQL += " ORDER BY me.EmployeeID";        
        tabMode.setRowCount(0);
        try{
            DBConnection getCn = new DBConnection();
            Connection cn = getCn.getConnection();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            while(rs.next())
            {
                String EmployeeID = rs.getString(1);
                String EmployeeName = rs.getString(2);
                String TitleID = rs.getString(3);
                String TitleName = rs.getString(4);
                String Status = rs.getString(5);
                Status = (Status.equals("A"))? "Active" : "Resign";
                String[] data = {EmployeeID,EmployeeName,TitleID,TitleName,Status};
                tabMode.addRow(data);
            }
            Data close = new Data();
            close.closingConnection (cn,st,rs);    
            close = null;
            formatTableColumn();
        }
        catch(SQLException e)
        {
            
        }        
    }     
    
    void enableControls()
    {
        if(mode.getTransMode()==transMode.typeOfTransMode.Wait)
        {
            txtEmployeeID.setEnabled(false);
            txtEmployeeName.setEnabled(false);
            cmbStatus.setEnabled(false);
            cmbTitle.setEnabled(false);
            cmdNew.setEnabled(true);
            cmdExit.setEnabled(true);
            Modify.setEnabled(false);
            cmdSave.setEnabled(false);
            cmdCancel.setEnabled(false);
            cmdDelete.setEnabled(false);
        }else            
            {
                 txtEmployeeID.setEnabled(true);
                 txtEmployeeName.setEnabled(true);
                 cmbStatus.setEnabled(true);
                 cmbStatus.setSelectedIndex(0);
                 cmbTitle.setEnabled(true);
                 cmdNew.setEnabled(false);
                 cmdExit.setEnabled(false);
                 Modify.setEnabled(false);
                 cmdSave.setEnabled(true);
                 cmdCancel.setEnabled(true);
                 cmdDelete.setEnabled(false);
                 txtEmployeeID.setFocusable(true);
                 if(mode.getTransMode()==transMode.typeOfTransMode.EditRecord)
                 {
                      txtEmployeeID.setEnabled(false);
                      cmdDelete.setEnabled(true);
                      txtEmployeeName.requestFocus();
                 }
            }
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        txtEmployeeID = new javax.swing.JTextField();
        txtEmployeeName = new javax.swing.JTextField();
        cmdNew = new javax.swing.JButton();
        Modify = new javax.swing.JButton();
        cmdSave = new javax.swing.JButton();
        cmdCancel = new javax.swing.JButton();
        cmdDelete = new javax.swing.JButton();
        cmdExit = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtKeyword = new javax.swing.JTextField();
        cmbSearch = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        cmdSearch = new javax.swing.JButton();
        chkActive = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEmployee = new javax.swing.JTable();
        cmbStatus = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        cmbTitle = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Master Employee");
        setAlwaysOnTop(true);
        setResizable(false);

        jLabel2.setText("Employee Name");

        txtEmployeeName.setAutoscrolls(false);

        cmdNew.setText("Add");
        cmdNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdNewActionPerformed(evt);
            }
        });

        Modify.setText("Modify");
        Modify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModifyActionPerformed(evt);
            }
        });

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

        cmdDelete.setText("Delete");
        cmdDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdDeleteActionPerformed(evt);
            }
        });

        cmdExit.setText("Exit");
        cmdExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdExitActionPerformed(evt);
            }
        });

        jLabel3.setText("Employee ID");

        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jLabel4.setText("Keyword");

        cmbSearch.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Employee ID", "Employee Name", "Title ID", "Title Name" }));

        jLabel5.setText("base on");

        cmdSearch.setText("Find");
        cmdSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdSearchActionPerformed(evt);
            }
        });

        chkActive.setSelected(true);
        chkActive.setText("Active Staff only");
        chkActive.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkActiveActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(chkActive)
                .add(18, 18, 18)
                .add(jLabel4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 55, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(txtKeyword, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 84, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(cmdSearch)
                .add(18, 18, 18)
                .add(jLabel5, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 45, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(2, 2, 2)
                .add(cmbSearch, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(57, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(chkActive)
                    .add(jLabel4)
                    .add(txtKeyword, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(cmdSearch)
                    .add(cmbSearch, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel5))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tblEmployee.setModel(tabMode);
        tblEmployee.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblEmployeeMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblEmployee);

        cmbStatus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Active", "Resign" }));

        jLabel6.setText("Status");

        cmbTitle.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Group ID", "Group Name" }));

        jLabel7.setText("Title");

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(layout.createSequentialGroup()
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(jLabel6, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                                    .add(jLabel7, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED))
                            .add(layout.createSequentialGroup()
                                .add(cmdNew, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 74, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(Modify)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED))
                            .add(jLabel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 88, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jLabel3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 74, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                                    .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                    .add(txtEmployeeID, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 84, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                    .add(290, 290, 290))
                                .add(layout.createSequentialGroup()
                                    .add(cmdSave, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 68, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                    .add(cmdCancel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 67, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                    .add(cmdDelete)
                                    .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                    .add(cmdExit, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 71, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                            .add(txtEmployeeName, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 294, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(cmbStatus, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 125, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(cmbTitle, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 171, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .add(150, 150, 150))
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                            .add(org.jdesktop.layout.GroupLayout.LEADING, jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(org.jdesktop.layout.GroupLayout.LEADING, jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 563, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(txtEmployeeID, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel3))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel2)
                    .add(txtEmployeeName, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel7)
                    .add(cmbTitle, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel6)
                    .add(cmbStatus, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(18, 18, 18)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(cmdNew)
                    .add(Modify)
                    .add(cmdSave)
                    .add(cmdCancel)
                    .add(cmdDelete)
                    .add(cmdExit))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 302, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(355, 355, 355))
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-589)/2, (screenSize.height-550)/2, 589, 550);
    }// </editor-fold>//GEN-END:initComponents

    private void cmdExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdExitActionPerformed
        dispose();
        setVisible(false);
    }//GEN-LAST:event_cmdExitActionPerformed

    private void cmdNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdNewActionPerformed
        Data User = new Data(); 
        if(User.UserRight(UserID, "MST-006",Data.typeOfAction.Add)==false)
        {
            JOptionPane.showMessageDialog(this, "You dont have right to add data.","Information",JOptionPane.OK_OPTION);
            return ;
        }
        mode.setTransMode(transMode.typeOfTransMode.AddRecord);
        clearTextBox();
        enableControls();
        txtEmployeeID.requestFocus();
    }//GEN-LAST:event_cmdNewActionPerformed

    private void cmdSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdSaveActionPerformed
        int result = JOptionPane.showConfirmDialog(this,"Do you want to save data ?","Confirmation",JOptionPane.YES_NO_OPTION);
        if(result==JOptionPane.YES_OPTION)
        {
            if(isValidate()==true)
            {
                Data clsData = new Data();
                String SQL = "";
                String Status;
                Status = (cmbStatus.getSelectedIndex()==0) ? "A":"R";
                String TitleID;
                TitleID = clsData.getFieldStringValue("MasterTitle", "TitleName", cmbTitle.getSelectedItem().toString().trim(),"TitleID");
                if(mode.getTransMode()==transMode.typeOfTransMode.AddRecord)
                {                    
                    SQL = "INSERT INTO masteremployee VALUES('" + txtEmployeeID.getText().trim() + "', '" + txtEmployeeName.getText().trim() + "','" + Status + "','" + TitleID + "')";                                       
                    clsData.ExecuteSQL(SQL);
                    SQL = "INSERT INTO trxperioddetail VALUES ('" + txtEmployeeID.getText().trim() + "' , '" + clsData.getActivePeriod().toString() + "','0')";
                    clsData.ExecuteSQL(SQL);
                }    
                else
                {
                     SQL = "UPDATE masteremployee SET EmployeeName = '" + txtEmployeeName.getText().trim() + "', Status = '" + Status + "', TitleID = '" + TitleID + "' WHERE EmployeeID = '" + txtEmployeeID.getText().trim() + "'";                       
                     clsData.ExecuteSQL(SQL);
                }
                      
                clsData = null;
                mode.setTransMode(transMode.typeOfTransMode.Wait);
                enableControls(); 
                clearTextBox();
                fillTable("");
           }  
        }                 
    }//GEN-LAST:event_cmdSaveActionPerformed

    private void cmdCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdCancelActionPerformed
        mode.setTransMode(transMode.typeOfTransMode.Wait);
        enableControls();       
        clearTextBox();
    }//GEN-LAST:event_cmdCancelActionPerformed

    private void cmdSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdSearchActionPerformed
        fillTable(txtKeyword.getText().trim());
}//GEN-LAST:event_cmdSearchActionPerformed

    private void tblEmployeeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEmployeeMouseClicked
        if(mode.getTransMode()==transMode.typeOfTransMode.Wait)
        {
            Object employeeID = tblEmployee.getModel().getValueAt(tblEmployee.getSelectedRow(), 0);
            Object employeeName = tblEmployee.getModel().getValueAt(tblEmployee.getSelectedRow(), 1);
            Object titleID = tblEmployee.getModel().getValueAt(tblEmployee.getSelectedRow(), 3);
            Object status = tblEmployee.getModel().getValueAt(tblEmployee.getSelectedRow(), 4);            
            txtEmployeeID.setText(employeeID.toString().trim());
            txtEmployeeName.setText(employeeName.toString().trim()); 
            cmbTitle.setSelectedItem(titleID.toString().trim());
            cmbStatus.setSelectedItem(status);
            Modify.setEnabled(true);
         }
}//GEN-LAST:event_tblEmployeeMouseClicked

    private void cmdDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdDeleteActionPerformed
        Data User = new Data(); 
        if(User.UserRight(UserID, "MST-006",Data.typeOfAction.Delete)==false)
        {
            JOptionPane.showMessageDialog(this, "You dont have right to delete data.","Information",JOptionPane.OK_OPTION);
            return ;
        }
        
        if(employeeIDisAlreadyUsed()==true)
        {
            JOptionPane.showMessageDialog(this,"Employee ID can not be deleted, it has been used by Budget Detail.","Information",JOptionPane.OK_OPTION);            
        }
        else
        {
            int result = JOptionPane.showConfirmDialog(this, "Do you want to delete ?","Confirmation",JOptionPane.YES_NO_OPTION);
            if(result==JOptionPane.YES_OPTION)
            {
                Data clsData = new Data();
                String SQL = "DELETE FROM masteremployee WHERE EmployeeID = '" + txtEmployeeID.getText().trim() + "'"; 
                clsData.ExecuteSQL(SQL);   
                SQL = "DELETE FROM trxperioddetail where EmployeeID = '" + txtEmployeeID.getText().trim() + "'";
                clsData.ExecuteSQL(SQL);   
                mode.setTransMode(transMode.typeOfTransMode.Wait);
                clsData = null;
                enableControls(); 
                clearTextBox();
                fillTable("");                
            }
        }
    }//GEN-LAST:event_cmdDeleteActionPerformed

    private void ModifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModifyActionPerformed
        if(!txtEmployeeID.getText().equals(""))
        {
           mode.setTransMode(transMode.typeOfTransMode.EditRecord);
           enableControls();              
        }        
}//GEN-LAST:event_ModifyActionPerformed

    private void chkActiveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkActiveActionPerformed
        fillTable(txtKeyword.getText().trim());
    }//GEN-LAST:event_chkActiveActionPerformed
    
    private boolean employeeIDisAlreadyUsed()
    {
         boolean tempResult = false;         
         String SQL = "SELECT EmployeeID FROM trxbudget WHERE EmployeeID = '" + txtEmployeeID.getText().trim() + "'";
         DBConnection getCn = new DBConnection();
         try
         {
              Connection cn = getCn.getConnection();
              Statement st = cn.createStatement();
              ResultSet rs = st.executeQuery(SQL);
              if(rs.next())
              {
                 tempResult = true;       
              }     
              Data close = new Data();
              close.closingConnection (cn,st,rs);
              close = null;
          }
          catch(SQLException e)
          {
               System.out.println(e.toString());
          }
          return tempResult;
    }
      
    private boolean isValidate()
    { 
        if(txtEmployeeID.getText().trim().equals(""))
        {
            JOptionPane.showMessageDialog(this, "Employee ID is still empty.","Warning",JOptionPane.OK_OPTION);            
            return false;
        } 
        if(txtEmployeeName.getText().trim().equals(""))
        {
            JOptionPane.showMessageDialog(this, "Employee name is still empty.","Warning",JOptionPane.OK_OPTION);
            return false;
        }            
        
        if(txtEmployeeID.getText().length()!=7)
        {
             JOptionPane.showMessageDialog(this, "Employee ID length must be 8 digits.","Warning",JOptionPane.OK_OPTION);
            return false;
        }
        
        if(cmbTitle.getSelectedIndex()==0)
        {
            JOptionPane.showMessageDialog(this, "Title is not selected","Warning",JOptionPane.OK_OPTION);
            return false;
        }
        
        if(mode.getTransMode()==transMode.typeOfTransMode.AddRecord)
        {
             Data clsData = new Data();
             String Kode = "";
             Kode = clsData.getFieldStringValue("masteremployee", "EmployeeID",txtEmployeeID.getText().trim(),"EmployeeID");
             if(!Kode.equals(""))
             {
                JOptionPane.showMessageDialog(this, "Employee ID is already exists.","Warning",JOptionPane.OK_OPTION);                        
                return false;
             } 
        }   
        else
        {
            Data User = new Data(); 
            if(User.UserRight(UserID, "MST-006",Data.typeOfAction.Modify)==false)
            {
                JOptionPane.showMessageDialog(this, "You dont have right to modify data.","Information",JOptionPane.OK_OPTION);
                return false ;
            }
        }
        return true;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Modify;
    private javax.swing.JCheckBox chkActive;
    private javax.swing.JComboBox cmbSearch;
    private javax.swing.JComboBox cmbStatus;
    private javax.swing.JComboBox cmbTitle;
    private javax.swing.JButton cmdCancel;
    private javax.swing.JButton cmdDelete;
    private javax.swing.JButton cmdExit;
    private javax.swing.JButton cmdNew;
    private javax.swing.JButton cmdSave;
    private javax.swing.JButton cmdSearch;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblEmployee;
    private javax.swing.JTextField txtEmployeeID;
    private javax.swing.JTextField txtEmployeeName;
    private javax.swing.JTextField txtKeyword;
    // End of variables declaration//GEN-END:variables
}
