/*
 * FrmMasterBudgetGroup.java
 * Created on April 8, 2008, 3:17 PM
 * @author  kusno
 */ 
import javax.swing.JOptionPane;
import java.sql.*;
import javax.swing.JTable.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.*;

public class FrmMasterBudgetGroup extends javax.swing.JFrame {
    transMode mode = new transMode();    
    String[] strHeader = {"Group ID","Group name"};
    DefaultTableModel tabMode;
    Data user = new Data(); 
    String UserID;    
     
    public FrmMasterBudgetGroup() {
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
       clearTextBox();
       enableControls();
       fillTable("");
    }
    
    void clearTextBox(){
        txtGroupID.setText("");
        txtGroupName.setText("");
    }
    
    void fillTable(String keyword)
    {
        String SQL = "";
        SQL = "SELECT * FROM masterbudgetgroup ";
        if(!keyword.equals(""))
        {
            if(cmbSearch.getSelectedIndex()==0)
            {
                SQL += " WHERE BudgetGroupID LIKE '%" + keyword + "%'";
            }
            else
            {
                SQL += " WHERE BudgetGroupName LIKE '%" + keyword + "%'";
            }
        }
        SQL += " ORDER BY BudgetGroupID";
        tabMode.setRowCount(0);
        try{
            DBConnection getCn = new DBConnection();
            Connection cn = getCn.getConnection();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            while(rs.next())
            {
                String ID = rs.getString(1);
                String Name = rs.getString(2);
                String[] data = {ID,Name};
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
    
    void enableControls()
    {
        if(mode.getTransMode()==transMode.typeOfTransMode.Wait)
        {
            txtGroupID.setEnabled(false);
            txtGroupName.setEnabled(false);
            cmdNew.setEnabled(true);
            cmdExit.setEnabled(true);
            Modify.setEnabled(false);
            cmdSave.setEnabled(false);
            cmdCancel.setEnabled(false);
            cmdDelete.setEnabled(false);
        }else            
            {
                 txtGroupID.setEnabled(true);
                 txtGroupName.setEnabled(true);
                 cmdNew.setEnabled(false);
                 cmdExit.setEnabled(false);
                 Modify.setEnabled(false);
                 cmdSave.setEnabled(true);
                 cmdCancel.setEnabled(true);
                 cmdDelete.setEnabled(false);
                 txtGroupID.setFocusable(true);
                 if(mode.getTransMode()==transMode.typeOfTransMode.EditRecord)
                 {
                      txtGroupID.setEnabled(false);
                      cmdDelete.setEnabled(true);
                      txtGroupName.requestFocus();
                 }
            }
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        txtGroupID = new javax.swing.JTextField();
        txtGroupName = new javax.swing.JTextField();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBudgetGroup = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Master Budget Group");
        setAlwaysOnTop(true);
        setResizable(false);

        jLabel2.setText("Budget Group Name");

        txtGroupName.setAutoscrolls(false);

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

        jLabel3.setText("Budget Group ID");

        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jLabel4.setText("Keyword");

        cmbSearch.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Group ID", "Group Name" }));

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
                .add(jLabel4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 69, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(txtKeyword, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 84, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(cmdSearch)
                .add(39, 39, 39)
                .add(jLabel5, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 57, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(cmbSearch, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 114, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
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
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tblBudgetGroup.setModel(tabMode);
        tblBudgetGroup.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBudgetGroupMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblBudgetGroup);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(layout.createSequentialGroup()
                                .add(cmdNew, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 74, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(Modify))
                            .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                                .add(org.jdesktop.layout.GroupLayout.LEADING, jLabel3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .add(org.jdesktop.layout.GroupLayout.LEADING, jLabel2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(txtGroupID, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 84, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(255, 255, 255))
                            .add(layout.createSequentialGroup()
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                                    .add(org.jdesktop.layout.GroupLayout.LEADING, txtGroupName)
                                    .add(org.jdesktop.layout.GroupLayout.LEADING, layout.createSequentialGroup()
                                        .add(cmdSave, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 68, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                        .add(cmdCancel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 67, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                        .add(cmdDelete)
                                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                        .add(cmdExit, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 71, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap())))
                    .add(layout.createSequentialGroup()
                        .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(24, Short.MAX_VALUE))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                        .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 482, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(txtGroupID, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel3))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(txtGroupName, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel2))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(Modify)
                    .add(cmdDelete)
                    .add(cmdCancel)
                    .add(cmdSave)
                    .add(cmdNew)
                    .add(cmdExit))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 359, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(355, 355, 355))
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-510)/2, (screenSize.height-550)/2, 510, 550);
    }// </editor-fold>//GEN-END:initComponents

    private void cmdExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdExitActionPerformed
        dispose();
        setVisible(false);
    }//GEN-LAST:event_cmdExitActionPerformed

    private void cmdNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdNewActionPerformed
        Data User = new Data(); 
        if(User.UserRight(UserID, "MST-003",Data.typeOfAction.Add)==false)
        {
            JOptionPane.showMessageDialog(this, "You dont have right to add data.","Information",JOptionPane.OK_OPTION);
            return ;
        }
        mode.setTransMode(transMode.typeOfTransMode.AddRecord);
        clearTextBox();
        enableControls();
        txtGroupID.requestFocus();
    }//GEN-LAST:event_cmdNewActionPerformed

    private void cmdSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdSaveActionPerformed
        int result = JOptionPane.showConfirmDialog(this,"Do you want to save data ?","Confirmation",JOptionPane.YES_NO_OPTION);
        if(result==JOptionPane.YES_OPTION)
        {
            if(isValidate()==true)
            {
                Data clsData = new Data();
                String SQL = "";
                if(mode.getTransMode()==transMode.typeOfTransMode.AddRecord)
                {                    
                    SQL = "INSERT INTO masterbudgetgroup VALUES('" + txtGroupID.getText().trim() + "', '" + txtGroupName.getText().trim() + "')";
                    clsData.ExecuteSQL(SQL);                          
                }    
                else
                {
                     SQL = "UPDATE masterbudgetgroup SET BudgetGroupName = '" + txtGroupName.getText().trim() + "' WHERE BudgetGroupID = '" + txtGroupID.getText().trim() + "'";
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

    private void tblBudgetGroupMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBudgetGroupMouseClicked
        if(mode.getTransMode()==transMode.typeOfTransMode.Wait)
        {
            Object groupID = tblBudgetGroup.getModel().getValueAt(tblBudgetGroup.getSelectedRow(), 0);
            Object groupName = tblBudgetGroup.getModel().getValueAt(tblBudgetGroup.getSelectedRow(), 1);
            txtGroupID.setText(groupID.toString().trim());
            txtGroupName.setText(groupName.toString().trim()); 
            Modify.setEnabled(true);
         }
}//GEN-LAST:event_tblBudgetGroupMouseClicked

    private void cmdDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdDeleteActionPerformed
        Data User = new Data(); 
        if(User.UserRight(UserID, "MST-003",Data.typeOfAction.Delete)==false)
        {
            JOptionPane.showMessageDialog(this, "You dont have right to delete data.","Information",JOptionPane.OK_OPTION);
            return ;
        }
        
        if(groupIDIsAlreadyUsed()==true)
        {
            JOptionPane.showMessageDialog(this,"ID can not be deleted, it has been used by Budget Detail.","Information",JOptionPane.OK_OPTION);            
        }
        else
        {
            int result = JOptionPane.showConfirmDialog(this, "Do you want to delete ?","Confirmation",JOptionPane.YES_NO_OPTION);
            if(result==JOptionPane.YES_OPTION)
            {
                Data clsData = new Data();
                String SQL = "DELETE FROM masterbudgetgroup WHERE BudgetGroupID = '" + txtGroupID.getText().trim() + "'"; 
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
        if(!txtGroupID.getText().equals(""))
        {
           mode.setTransMode(transMode.typeOfTransMode.EditRecord);
           enableControls();              
        }        
}//GEN-LAST:event_ModifyActionPerformed
    
    private boolean groupIDIsAlreadyUsed()
    {
         boolean tempResult = false;         
         String SQL = "SELECT BudgetGroupID FROM masterbudgetdetail WHERE BudgetGroupID = '" + txtGroupID.getText().trim() + "'";
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
        if(txtGroupID.getText().trim().equals(""))
        {
            JOptionPane.showMessageDialog(this, "Group ID is still empty.","Warning",JOptionPane.OK_OPTION);            
            return false;
        } 
        if(txtGroupName.getText().trim().equals(""))
        {
            JOptionPane.showMessageDialog(this, "Group name is still empty.","Warning",JOptionPane.OK_OPTION);
            return false;
        }                 
        
        if(mode.getTransMode()==transMode.typeOfTransMode.AddRecord)
        {
             Data clsData = new Data();
             String Kode = "";
             Kode = clsData.getFieldStringValue("masterbudgetgroup", "BudgetGroupID",txtGroupID.getText().trim(),"BudgetGroupID");
             if(!Kode.equals(""))
             {
                JOptionPane.showMessageDialog(this, "Group ID is already exists.","Warning",JOptionPane.OK_OPTION);                        
                return false;
             } 
        }   
        else
        {
            Data User = new Data(); 
            if(User.UserRight(UserID, "MST-003",Data.typeOfAction.Modify)==false)
            {
                JOptionPane.showMessageDialog(this, "You dont have right to modify data.","Information",JOptionPane.OK_OPTION);
                return false ;
            }
        }
        return true;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Modify;
    private javax.swing.JComboBox cmbSearch;
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblBudgetGroup;
    private javax.swing.JTextField txtGroupID;
    private javax.swing.JTextField txtGroupName;
    private javax.swing.JTextField txtKeyword;
    // End of variables declaration//GEN-END:variables
}
