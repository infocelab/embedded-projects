/*
 * FrmMasterBudget.java
 * Created on April 8, 2008, 3:17 PM
 * @author  kusno
 */
import javax.swing.JOptionPane;
import java.sql.*;
import javax.swing.JTable.*;
import javax.swing.table.DefaultTableModel;
 
public class FrmMasterBudget extends javax.swing.JFrame {
    transMode mode = new transMode();    
    String[] strHeader = {"Budget ID","Budget Name","Group ID","Group Name"};
    DefaultTableModel tabMode;
    Data user = new Data(); 
    String UserID;    
    
    public FrmMasterBudget() {
       UserID = user.getUserID().trim();
       mode.setTransMode(transMode.typeOfTransMode.Wait);
       tabMode = new DefaultTableModel(null,strHeader)
               {
    public boolean isCellEditable(int row, int column)
    {
        return false;
    }
};  
       initComponents();
       clearTextBox();
       enableControls();
       fillComboGroup();
       fillTable("");
       formatTableColumn();
    }
    
    void formatTableColumn()
    {        
          tblBudget.getColumnModel().getColumn(0).setPreferredWidth(50);
          tblBudget.getColumnModel().getColumn(1).setPreferredWidth(170);
          tblBudget.getColumnModel().getColumn(2).setPreferredWidth(40);                    
          tblBudget.getColumnModel().getColumn(3).setPreferredWidth(90);    
    }
    
    void fillComboGroup()
    {
        String SQL = "SELECT BudgetGroupName FROM masterbudgetgroup ORDER BY BudgetGroupID";
        Data clsCombo = new Data();
        clsCombo.FillComboBox(SQL, cmbGroup, "ALL GROUP");
        clsCombo =  null;
    }
    
    void clearTextBox(){
        txtBudgetID.setText("");
        txtBudgetName.setText("");
        txtGroupID.setText("");
        txtGroupName.setText("");
    }
    
    void fillTable(String keyword)
    {
        String SQL = "";
        SQL = "SELECT masterbudget.BudgetID, masterbudget.BudgetName,  masterbudgetgroup.* FROM masterbudget INNER JOIN masterbudgetgroup on masterbudget.BudgetGroupID = masterbudgetgroup.BudgetGroupID";      
        if(!keyword.equals(""))
        {
            if(cmbSearch.getSelectedIndex()==0)
            {
                SQL += " WHERE BudgetID LIKE '%" + keyword + "%'";
            }
            else if(cmbSearch.getSelectedIndex()==1)
            {
                SQL += " WHERE BudgetName LIKE '%" + keyword + "%'";
            }
            else
            {
                SQL += " WHERE BudgetGroupName LIKE '%" + keyword + "%'";
            }
        }
        if(cmbGroup.getSelectedIndex() >= 1)
        {
            if(!keyword.equals(""))
            {
                SQL += " AND masterbudgetgroup.BudgetGroupName = '" + cmbGroup.getSelectedItem().toString().trim() + "'";
            }
            else
            {
                
            }   SQL += " WHERE masterbudgetgroup.BudgetGroupName = '" + cmbGroup.getSelectedItem().toString().trim() + "'";   
        }
        
        SQL += " ORDER BY BudgetID";     
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
                String groupID = rs.getString(3);
                String groupName = rs.getString(4);
                String[] data = {budgetID,budgetName,groupID,groupName};
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
            txtBudgetID.setEnabled(false);
            txtBudgetName.setEnabled(false);
            cmdLocateGroup.setEnabled(false);
            cmdNew.setEnabled(true);
            cmdExit.setEnabled(true);
            cmdEdit.setEnabled(false);
            cmdSave.setEnabled(false);
            cmdCancel.setEnabled(false);
            cmdDelete.setEnabled(false);
        }else            
            {
                 txtBudgetID.setEnabled(true);
                 txtBudgetName.setEnabled(true);
                 cmdLocateGroup.setEnabled(true);
                 cmdNew.setEnabled(false);
                 cmdExit.setEnabled(false);
                 cmdEdit.setEnabled(false);
                 cmdSave.setEnabled(true);
                 cmdCancel.setEnabled(true);
                 cmdDelete.setEnabled(false);
                 txtBudgetID.setFocusable(true);                
                 if(mode.getTransMode()==transMode.typeOfTransMode.EditRecord)
                 {
                     cmdLocateGroup.setEnabled(false);
                     txtBudgetID.setEnabled(false);
                     cmdDelete.setEnabled(true);
                     txtBudgetName.requestFocus();
                 }
            }
    }
     
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        txtBudgetID = new javax.swing.JTextField();
        txtBudgetName = new javax.swing.JTextField();
        cmdNew = new javax.swing.JButton();
        cmdEdit = new javax.swing.JButton();
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
        cmbGroup = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBudget = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        txtGroupID = new javax.swing.JTextField();
        cmdLocateGroup = new javax.swing.JButton();
        txtGroupName = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Master Budget");
        setAlwaysOnTop(true);
        setResizable(false);

        jLabel2.setText("Budget Name");

        txtBudgetName.setAutoscrolls(false);

        cmdNew.setText("Add");
        cmdNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdNewActionPerformed(evt);
            }
        });

        cmdEdit.setText("Modify");
        cmdEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdEditActionPerformed(evt);
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

        jLabel3.setText("Budget ID");

        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jLabel4.setText("Keyword");

        cmbSearch.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Budget ID", "Budget Name", "Group" }));

        jLabel5.setText("base on");

        cmdSearch.setText("Find");
        cmdSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdSearchActionPerformed(evt);
            }
        });

        cmbGroup.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Budget ID", "Budget Name", "Group" }));
        cmbGroup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbGroupActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(cmbGroup, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 159, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(10, 10, 10)
                .add(jLabel4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 55, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(txtKeyword, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 84, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(cmdSearch)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jLabel5, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 48, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(cmbSearch, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 118, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(cmbGroup, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
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
        });
        jScrollPane1.setViewportView(tblBudget);

        jLabel6.setText("Group");

        txtGroupID.setEditable(false);

        cmdLocateGroup.setText("...");
        cmdLocateGroup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdLocateGroupActionPerformed(evt);
            }
        });

        txtGroupName.setEditable(false);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                            .add(org.jdesktop.layout.GroupLayout.LEADING, jLabel2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(org.jdesktop.layout.GroupLayout.LEADING, jLabel6, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(org.jdesktop.layout.GroupLayout.LEADING, jLabel3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(layout.createSequentialGroup()
                                .add(txtGroupID, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 84, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                                .add(cmdLocateGroup, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 27, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(txtGroupName, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 237, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                            .add(txtBudgetID, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 132, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(txtBudgetName))
                        .add(89, 89, 89))
                    .add(layout.createSequentialGroup()
                        .add(cmdNew, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 72, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(cmdEdit, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 73, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(cmdSave, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 72, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(cmdCancel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 69, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(cmdDelete)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(cmdExit, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 66, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(jScrollPane1))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(txtGroupID, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel6)
                    .add(txtGroupName, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(cmdLocateGroup, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 23, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel3)
                    .add(txtBudgetID, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel2)
                    .add(txtBudgetName, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(18, 18, 18)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(cmdDelete)
                    .add(cmdCancel)
                    .add(cmdEdit)
                    .add(cmdNew)
                    .add(cmdSave)
                    .add(cmdExit))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 45, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 395, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(312, 312, 312))
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-607)/2, (screenSize.height-627)/2, 607, 627);
    }// </editor-fold>//GEN-END:initComponents

    private void cmdExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdExitActionPerformed
        dispose();
        setVisible(false);
    }//GEN-LAST:event_cmdExitActionPerformed

    private void cmdNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdNewActionPerformed
        Data User = new Data(); 
        if(User.UserRight(UserID, "MST-004",Data.typeOfAction.View)==false)
        {
            JOptionPane.showMessageDialog(this, "You dont have right to add data.","Information",JOptionPane.OK_OPTION);
            return;
        }
        
        mode.setTransMode(transMode.typeOfTransMode.AddRecord);
        clearTextBox();
        enableControls();
        txtBudgetID.requestFocus();
    }//GEN-LAST:event_cmdNewActionPerformed

    private void cmdSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdSaveActionPerformed
        int result = JOptionPane.showConfirmDialog(this,"Do you want to save it ?","Confirmation",JOptionPane.YES_NO_OPTION);
        if(result==JOptionPane.YES_OPTION)
        {
            if(isValidate()==true)
            {
                Data clsData = new Data();
                String SQL = "";
                if(mode.getTransMode()==transMode.typeOfTransMode.AddRecord)
                {                    
                    SQL = "INSERT INTO masterbudget VALUES('" + txtBudgetID.getText().trim() + "', '" + txtBudgetName.getText().trim() + "', '" + txtGroupID.getText().trim() + "')";
                    clsData.ExecuteSQL(SQL);                          
                }    
                else
                {
                     SQL = "UPDATE masterbudget SET BudgetName = '" + txtBudgetName.getText().trim() + "' WHERE BudgetID = '" + txtBudgetID.getText().trim() + "'";
                     clsData.ExecuteSQL(SQL);    
                }
                mode.setTransMode(transMode.typeOfTransMode.Wait);
                clsData = null;
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

    private void tblBudgetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBudgetMouseClicked
       if(mode.getTransMode()==transMode.typeOfTransMode.Wait)
       {
            Object kodeAnggaran = tblBudget.getModel().getValueAt(tblBudget.getSelectedRow(), 0);
            Object namaAnggaran = tblBudget.getModel().getValueAt(tblBudget.getSelectedRow(), 1);
            Object kodeGroup = tblBudget.getModel().getValueAt(tblBudget.getSelectedRow(), 2);
            Object namaGroup = tblBudget.getModel().getValueAt(tblBudget.getSelectedRow(), 3);
            txtBudgetID.setText(kodeAnggaran.toString().trim());
            txtBudgetName.setText(namaAnggaran.toString().trim()); 
            txtGroupID.setText(kodeGroup.toString().trim());
            txtGroupName.setText(namaGroup.toString().trim()); 
            cmdEdit.setEnabled(true);
       }
}//GEN-LAST:event_tblBudgetMouseClicked

    private void cmdDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdDeleteActionPerformed
         Data User = new Data(); 
         if(User.UserRight(UserID, "MST-004",Data.typeOfAction.Delete)==false)
         {
             JOptionPane.showMessageDialog(this, "You dont have right to delete data.","Information",JOptionPane.OK_OPTION);
             return ;
         }
        
        if(budgetIDIsAlreadyUsed()==true)
        {
            JOptionPane.showMessageDialog(this,"ID can not be deleted, It has been used by trxBudget.","Information",JOptionPane.OK_OPTION);            
        }
        else
        {
            int result = JOptionPane.showConfirmDialog(this, "Dou you want to delete data ?","Confirmation",JOptionPane.YES_NO_OPTION);
            if(result==JOptionPane.YES_OPTION)
            {
                Data clsData = new Data();
                String SQL = "DELETE FROM masterbudget WHERE BudgetID = '" + txtBudgetID.getText().trim() + "'"; 
                clsData.ExecuteSQL(SQL);     
                clsData = null;
                mode.setTransMode(transMode.typeOfTransMode.Wait);
                enableControls(); 
                clearTextBox();
                fillTable("");                
            }
        }
    }//GEN-LAST:event_cmdDeleteActionPerformed

    private void cmdEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdEditActionPerformed
        if(!txtBudgetID.getText().equals(""))
        {
           mode.setTransMode(transMode.typeOfTransMode.EditRecord);        
           enableControls();              
        }        
    }//GEN-LAST:event_cmdEditActionPerformed

    private void cmdLocateGroupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdLocateGroupActionPerformed
        FrmLocateMasterBudgetGroup frmOpen = new FrmLocateMasterBudgetGroup();       
        frmOpen.setBounds(50, 50, 500, 500);
        frmOpen.setVisible(true);         
        String pGroupID = "";
        String pGroupName = "";
        pGroupID = frmOpen.getGroupID();  
        pGroupName = frmOpen.getGroupName();  
        txtGroupID.setText(pGroupID.toString());
        txtGroupName.setText(pGroupName.toString()); 
        txtBudgetID.setText(txtGroupID.getText().trim());
}//GEN-LAST:event_cmdLocateGroupActionPerformed

    private void cmbGroupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbGroupActionPerformed
        fillTable(txtKeyword.getText().trim());        
    }//GEN-LAST:event_cmbGroupActionPerformed
         
    private boolean budgetIDIsAlreadyUsed()
    {
         boolean tempResult = false;         
         String SQL = "SELECT BudgetID FROM trxbudget WHERE BudgetID = '" + txtBudgetID.getText().trim() + "'";
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
              close.closingConnection(cn, st, rs);
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
            JOptionPane.showMessageDialog(this, "Group Id is still empty.","Warning",JOptionPane.OK_OPTION);            
            return false;
        } 
         
        if(txtBudgetID.getText().trim().equals(""))
        {
            JOptionPane.showMessageDialog(this, "Budget ID is still empty.","Warning",JOptionPane.OK_OPTION);            
            return false;
        } 
        if(txtBudgetName.getText().trim().equals(""))
        {
            JOptionPane.showMessageDialog(this, "Budget Name is still empty.","Warning",JOptionPane.OK_OPTION);
            return false;
        }                 
        Data data = new Data();
        if(mode.getTransMode()==transMode.typeOfTransMode.AddRecord)
        {            
             String ID = "";
             ID = data.getFieldStringValue("masterbudget", "BudgetID",txtBudgetID.getText().trim(),"BudgetID");
             if(!ID.equals(""))
             {
                JOptionPane.showMessageDialog(this, "Budget ID is already exists.","Warning",JOptionPane.OK_OPTION);                        
                data = null;
                return false;
             }                 
        }     
        else
        {            
             if(data.UserRight(UserID, "MST-004",Data.typeOfAction.Modify)==false)
             {
                JOptionPane.showMessageDialog(this, "You dont have right to modify data.","Information",JOptionPane.OK_OPTION);
                data = null;
                return false;
             }
        }
        data = null;
        return true;
    }     
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cmbGroup;
    private javax.swing.JComboBox cmbSearch;
    private javax.swing.JButton cmdCancel;
    private javax.swing.JButton cmdDelete;
    private javax.swing.JButton cmdEdit;
    private javax.swing.JButton cmdExit;
    private javax.swing.JButton cmdLocateGroup;
    private javax.swing.JButton cmdNew;
    private javax.swing.JButton cmdSave;
    private javax.swing.JButton cmdSearch;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblBudget;
    private javax.swing.JTextField txtBudgetID;
    private javax.swing.JTextField txtBudgetName;
    public javax.swing.JTextField txtGroupID;
    public javax.swing.JTextField txtGroupName;
    private javax.swing.JTextField txtKeyword;
    // End of variables declaration//GEN-END:variables
}
