/*
 * FrmMasterUserFunction.java
 * Created on April 8, 2008, 3:17 PM
 * @author  kusno
 */ 
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.sql.*; 
import javax.swing.JTable.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn; 

public class FrmMasterUserFunction extends javax.swing.JFrame {        
 DefaultTableModel tabMode; 
 
    public FrmMasterUserFunction() {  
         String[] strHeader = {"Function ID","Function Name","View","Add","Modify","Delete"};   
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
         initComponents();      
         clearTextBox();                
    }    
     
    void clearTextBox(){ 
        txtUserID.setText("");
        txtUserName.setText("");
    }
    
    void fillTable()
    {       
          tabMode.setRowCount(0);           
          Data User = new Data();
          String UserID;
          UserID = txtUserID.getText();          
          Object data01[] = {"MST-001","Master User", new Boolean(User.UserRight(UserID, "MST-001",Data.typeOfAction.View)),new Boolean(User.UserRight(UserID, "MST-001",Data.typeOfAction.Add)),new Boolean(User.UserRight(UserID, "MST-001",Data.typeOfAction.Modify)),new Boolean(User.UserRight(UserID, "MST-001",Data.typeOfAction.Delete))};
          Object data02[] = {"MST-002","Master Function", new Boolean(User.UserRight(UserID, "MST-002",Data.typeOfAction.View)),new Boolean(User.UserRight(UserID, "MST-002",Data.typeOfAction.Add)),new Boolean(User.UserRight(UserID, "MST-002",Data.typeOfAction.Modify)),new Boolean(User.UserRight(UserID, "MST-002",Data.typeOfAction.Delete))};
          Object data03[] = {"MST-003","Master Budget Group", new Boolean(User.UserRight(UserID, "MST-003",Data.typeOfAction.View)),new Boolean(User.UserRight(UserID, "MST-003",Data.typeOfAction.Add)),new Boolean(User.UserRight(UserID, "MST-003",Data.typeOfAction.Modify)),new Boolean(User.UserRight(UserID, "MST-003",Data.typeOfAction.Delete))};
          Object data04[] = {"MST-004","Master Budget", new Boolean(User.UserRight(UserID, "MST-004",Data.typeOfAction.View)),new Boolean(User.UserRight(UserID, "MST-004",Data.typeOfAction.Add)),new Boolean(User.UserRight(UserID, "MST-004",Data.typeOfAction.Modify)),new Boolean(User.UserRight(UserID, "MST-004",Data.typeOfAction.Delete))};
          Object data05[] = {"MST-005","Master Title", new Boolean(User.UserRight(UserID, "MST-005",Data.typeOfAction.View)),new Boolean(User.UserRight(UserID, "MST-005",Data.typeOfAction.Add)),new Boolean(User.UserRight(UserID, "MST-005",Data.typeOfAction.Modify)),new Boolean(User.UserRight(UserID, "MST-005",Data.typeOfAction.Delete))};
          Object data06[] = {"MST-006","Master Employee", new Boolean(User.UserRight(UserID, "MST-006",Data.typeOfAction.View)),new Boolean(User.UserRight(UserID, "MST-006",Data.typeOfAction.Add)),new Boolean(User.UserRight(UserID, "MST-006",Data.typeOfAction.Modify)),new Boolean(User.UserRight(UserID, "MST-006",Data.typeOfAction.Delete))};
          Object data07[] = {"TSK-001","Trx. Beginning Balance Budget", new Boolean(User.UserRight(UserID, "TSK-001",Data.typeOfAction.View)),new Boolean(User.UserRight(UserID, "TSK-001",Data.typeOfAction.Add)),new Boolean(User.UserRight(UserID, "TSK-001",Data.typeOfAction.Modify)),new Boolean(User.UserRight(UserID, "TSK-001",Data.typeOfAction.Delete))};
          Object data08[] = {"TSK-002","Trx. Budget Usage", new Boolean(User.UserRight(UserID, "TSK-002",Data.typeOfAction.View)),new Boolean(User.UserRight(UserID, "TSK-002",Data.typeOfAction.Add)),new Boolean(User.UserRight(UserID, "TSK-002",Data.typeOfAction.Modify)),new Boolean(User.UserRight(UserID, "TSK-002",Data.typeOfAction.Delete))};
          Object data09[] = {"TSK-003","Trx. Budget Transfer", new Boolean(User.UserRight(UserID, "TSK-003",Data.typeOfAction.View)),new Boolean(User.UserRight(UserID, "TSK-003",Data.typeOfAction.Add)),new Boolean(User.UserRight(UserID, "TSK-003",Data.typeOfAction.Modify)),new Boolean(User.UserRight(UserID, "TSK-003",Data.typeOfAction.Delete))};
          Object data10[] = {"TSK-004","Trx. End of Year", new Boolean(User.UserRight(UserID, "TSK-004",Data.typeOfAction.View)),new Boolean(User.UserRight(UserID, "TSK-004",Data.typeOfAction.Add)),new Boolean(User.UserRight(UserID, "TSK-004",Data.typeOfAction.Modify)),new Boolean(User.UserRight(UserID, "TSK-004",Data.typeOfAction.Delete))};
          Object data11[] = {"RPT-001","Report Master Budget", new Boolean(User.UserRight(UserID, "RPT-001",Data.typeOfAction.View)),new Boolean(User.UserRight(UserID, "RPT-001",Data.typeOfAction.Add)),new Boolean(User.UserRight(UserID, "RPT-001",Data.typeOfAction.Modify)),new Boolean(User.UserRight(UserID, "RPT-001",Data.typeOfAction.Delete))};
          Object data12[] = {"RPT-002","Report Budget Per Month", new Boolean(User.UserRight(UserID, "RPT-002",Data.typeOfAction.View)),new Boolean(User.UserRight(UserID, "RPT-002",Data.typeOfAction.Add)),new Boolean(User.UserRight(UserID, "RPT-002",Data.typeOfAction.Modify)),new Boolean(User.UserRight(UserID, "RPT-002",Data.typeOfAction.Delete))};
          Object data13[] = {"RPT-003","Report Budget Usage", new Boolean(User.UserRight(UserID, "RPT-003",Data.typeOfAction.View)),new Boolean(User.UserRight(UserID, "RPT-003",Data.typeOfAction.Add)),new Boolean(User.UserRight(UserID, "RPT-003",Data.typeOfAction.Modify)),new Boolean(User.UserRight(UserID, "RPT-003",Data.typeOfAction.Delete))};
          Object data14[] = {"RPT-004","Report Budget Transfer", new Boolean(User.UserRight(UserID, "RPT-004",Data.typeOfAction.View)),new Boolean(User.UserRight(UserID, "RPT-004",Data.typeOfAction.Add)),new Boolean(User.UserRight(UserID, "RPT-004",Data.typeOfAction.Modify)),new Boolean(User.UserRight(UserID, "RPT-004",Data.typeOfAction.Delete))};
          
          TableColumn chkLihat = tbFunction.getColumnModel().getColumn(2);    
          chkLihat.setCellEditor(tbFunction.getDefaultEditor(Boolean.class));  
          chkLihat.setCellRenderer(tbFunction.getDefaultRenderer(Boolean.class));          
                   
          TableColumn chkTambah = tbFunction.getColumnModel().getColumn(3);    
          chkTambah.setCellEditor(tbFunction.getDefaultEditor(Boolean.class));  
          chkTambah.setCellRenderer(tbFunction.getDefaultRenderer(Boolean.class));
          
          TableColumn chkUbah = tbFunction.getColumnModel().getColumn(4);    
          chkUbah.setCellEditor(tbFunction.getDefaultEditor(Boolean.class));  
          chkUbah.setCellRenderer(tbFunction.getDefaultRenderer(Boolean.class));
          
          TableColumn chkHapus = tbFunction.getColumnModel().getColumn(5);    
          chkHapus.setCellEditor(tbFunction.getDefaultEditor(Boolean.class));  
          chkHapus.setCellRenderer(tbFunction.getDefaultRenderer(Boolean.class));
            
          tbFunction.getColumnModel().getColumn(0).setPreferredWidth(70); 
          tbFunction.getColumnModel().getColumn(1).setPreferredWidth(180); 
          tbFunction.getColumnModel().getColumn(2).setPreferredWidth(55); 
          tbFunction.getColumnModel().getColumn(3).setPreferredWidth(55); 
          tbFunction.getColumnModel().getColumn(4).setPreferredWidth(55); 
          tbFunction.getColumnModel().getColumn(5).setPreferredWidth(55); 
                              
          tabMode.addRow(data01);
          tabMode.addRow(data02);
          tabMode.addRow(data03);
          tabMode.addRow(data04);
          tabMode.addRow(data05);
          tabMode.addRow(data06);
          tabMode.addRow(data07);
          tabMode.addRow(data08);
          tabMode.addRow(data09);
          tabMode.addRow(data10);
          tabMode.addRow(data11);  
          tabMode.addRow(data12);
          tabMode.addRow(data13);  
          tabMode.addRow(data14);
    }
      
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cmdSave = new javax.swing.JButton();
        cmdCancel = new javax.swing.JButton();
        cmdExit = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbFunction = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        txtUserID = new javax.swing.JTextField();
        cmdLocateUser = new javax.swing.JButton();
        txtUserName = new javax.swing.JTextField();
        chkView = new javax.swing.JCheckBox();
        chkAdd = new javax.swing.JCheckBox();
        chkModify = new javax.swing.JCheckBox();
        chkDelete = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("User Function");
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

        tbFunction.setModel(tabMode);
        jScrollPane1.setViewportView(tbFunction);

        jLabel6.setText("User ID");

        txtUserID.setEditable(false);

        cmdLocateUser.setText("...");
        cmdLocateUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdLocateUserActionPerformed(evt);
            }
        });

        txtUserName.setEditable(false);

        chkView.setText("View");
        chkView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkViewActionPerformed(evt);
            }
        });

        chkAdd.setText("Add");
        chkAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkAddActionPerformed(evt);
            }
        });

        chkModify.setText("Modify");
        chkModify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkModifyActionPerformed(evt);
            }
        });

        chkDelete.setText("Delete");
        chkDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkDeleteActionPerformed(evt);
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
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jLabel6)
                            .add(cmdSave, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 69, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(layout.createSequentialGroup()
                                .add(cmdCancel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 69, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(cmdExit, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 65, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                            .add(layout.createSequentialGroup()
                                .add(txtUserID, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 84, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(cmdLocateUser, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 27, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(txtUserName, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 237, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 67, Short.MAX_VALUE))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 502, Short.MAX_VALUE)
                    .add(layout.createSequentialGroup()
                        .add(chkView)
                        .add(18, 18, 18)
                        .add(chkAdd)
                        .add(18, 18, 18)
                        .add(chkModify)
                        .add(10, 10, 10)
                        .add(chkDelete)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel6)
                    .add(txtUserID, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(cmdLocateUser, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 23, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(txtUserName, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(15, 15, 15)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(cmdCancel)
                    .add(cmdExit)
                    .add(cmdSave))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(chkView)
                    .add(chkAdd)
                    .add(chkModify)
                    .add(chkDelete))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 238, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-520)/2, (screenSize.height-376)/2, 520, 376);
    }// </editor-fold>//GEN-END:initComponents

    private void cmdExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdExitActionPerformed
        dispose();
        setVisible(false);
    }//GEN-LAST:event_cmdExitActionPerformed

    private void cmdSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdSaveActionPerformed
        Data data = new Data(); 
        String UserID;    
        UserID = data.getUserID().trim();       
        if(data.UserRight(UserID, "MST-002",Data.typeOfAction.Modify)==false)
        {
             JOptionPane.showMessageDialog(this, "You dont have right to add data.","Informasi",JOptionPane.OK_OPTION);
             return ;
        }
        ArrayList<String> SQLArray = new ArrayList<String>(); 
        int result = JOptionPane.showConfirmDialog(this,"Do you want to save ?","Konfirmasi",JOptionPane.YES_NO_OPTION);
        if(result==JOptionPane.YES_OPTION)
        {
            if(isDataCorrect()==true)
            {   
                String SQL = "DELETE FROM masterfunctiondetail WHERE UserID = '" + txtUserID.getText().trim() + "'";
                SQLArray.add(SQL);             
                double row = tabMode.getRowCount();                                    
                for(int i=0; i<row; i++)
                {                    
                    String functionID = (String)tabMode.getValueAt(i, 0);
                    Boolean canView = (Boolean)tabMode.getValueAt(i,2);
                    Boolean canAdd = (Boolean)tabMode.getValueAt(i,3);
                    Boolean canModify = (Boolean)tabMode.getValueAt(i,4);
                    Boolean canDelete = (Boolean)tabMode.getValueAt(i,5); 
                    
                    int canViewValue = canView==true ? 1 : 0;
                    int canAddValue = canAdd==true ? 1 : 0;
                    int canModifyValue = canModify==true ? 1 : 0;
                    int canDeleteValue = canDelete==true ? 1 : 0;                    
                    SQL = "INSERT INTO masterfunctiondetail VALUES('" + txtUserID.getText().trim() + "', '" + functionID.trim() + "', " + canViewValue + "," + canAddValue + "," + canModifyValue + ", " + canDeleteValue + ")";
                    SQLArray.add(SQL); 
                }
                data.ExecuteSQL(SQLArray);
                data = null;
                clearTextBox();
                tabMode.setRowCount(0); 
           }  
        }                  
    }//GEN-LAST:event_cmdSaveActionPerformed

    private void cmdCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdCancelActionPerformed
         clearTextBox();
         tabMode.setRowCount(0);   
    }//GEN-LAST:event_cmdCancelActionPerformed

    private void cmdLocateUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdLocateUserActionPerformed
        FrmLocateUser frmOpen = new FrmLocateUser();       
        frmOpen.setBounds(50, 50, 500, 500);
        frmOpen.setVisible(true);         
        String pUserID = "";
        String pUserName = "";
        pUserID = frmOpen.getUserID();
        pUserName = frmOpen.getUserName();
        txtUserID.setText(pUserID.toString());
        txtUserName.setText(pUserName.toString());   
        if(!txtUserID.getText().equals("") || txtUserID.getText()!=null)
        {
            fillTable();
        }
}//GEN-LAST:event_cmdLocateUserActionPerformed

    private void chkViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkViewActionPerformed
          int row = tabMode.getRowCount();                
          for(byte i=0; i<row; i++)
          {   
              tabMode.setValueAt(chkView.isSelected(),i, 2); 
          }
}//GEN-LAST:event_chkViewActionPerformed

    private void chkAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkAddActionPerformed
          int row = tabMode.getRowCount();                
          for(byte i=0; i<row; i++)
          {   
              tabMode.setValueAt(chkAdd.isSelected(),i, 3); 
          }
}//GEN-LAST:event_chkAddActionPerformed

    private void chkModifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkModifyActionPerformed
          int row = tabMode.getRowCount();                
          for(byte i=0; i<row; i++)
          {   
              tabMode.setValueAt(chkModify.isSelected(),i, 4); 
          }
}//GEN-LAST:event_chkModifyActionPerformed

    private void chkDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkDeleteActionPerformed
          int row = tabMode.getRowCount();                
          for(byte i=0; i<row; i++)
          {   
              tabMode.setValueAt(chkDelete.isSelected(),i,5); 
          }
}//GEN-LAST:event_chkDeleteActionPerformed
         
    private boolean isDataCorrect()
    { 
        if(txtUserID.getText().trim().equals(""))
        {
            JOptionPane.showMessageDialog(this, "User ID is still empty.","Warning",JOptionPane.OK_OPTION);            
            return false;
        }         
        return true;
    }  
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox chkAdd;
    private javax.swing.JCheckBox chkDelete;
    private javax.swing.JCheckBox chkModify;
    private javax.swing.JCheckBox chkView;
    private javax.swing.JButton cmdCancel;
    private javax.swing.JButton cmdExit;
    private javax.swing.JButton cmdLocateUser;
    private javax.swing.JButton cmdSave;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbFunction;
    public javax.swing.JTextField txtUserID;
    public javax.swing.JTextField txtUserName;
    // End of variables declaration//GEN-END:variables
}
