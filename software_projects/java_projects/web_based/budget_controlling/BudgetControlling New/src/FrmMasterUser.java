/*
 * FrmMasterUser.java
 *
 * Created on April 8, 2008, 3:17 PM
 *
 * @author  kusno
 */ 
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.sql.*;
import javax.swing.JTable.*;
import javax.swing.table.DefaultTableModel;

public class FrmMasterUser extends javax.swing.JFrame {
    transMode mode = new transMode();    
    String[] strHeader = {"User ID","Nama User", "Status"};
    DefaultTableModel tabMode;
    Data user = new Data(); 
    String UserID;        

    public FrmMasterUser() {
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
        txtUserID.setText("");
        txtUserName.setText("");
        txtPassword.setText("");
        cmbStatus.setSelectedIndex(0);
    }
    
    void fillTable(String kataKunci)
    {
        String SQL = "";
        SQL = "SELECT UserID, UserName, Status FROM masteruser ";
        if(!kataKunci.equals(""))
        {
            if(cmbSearch.getSelectedIndex()==0)
            {
                SQL += " WHERE userid LIKE '%" + kataKunci + "%'";
            }
            else
            {
                SQL += " WHERE username LIKE '%" + kataKunci + "%'";
            }
        }
        SQL += " ORDER BY UserID";
        tabMode.setRowCount(0);
        try
        {
            DBConnection getCn = new DBConnection();
            Connection cn = getCn.getConnection();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            while(rs.next())
            {
                String ID = rs.getString(1);
                String Name = rs.getString(2);
                String Status = rs.getString(3);
                String[] data = {ID,Name,Status};
                tabMode.addRow(data);
            }           
            Data close = new Data();
            close.closingConnection (cn,st,rs);        
        }
        catch(SQLException e)
        {
            
        }        
    }
     
    void enableControls()
    {
        if(mode.getTransMode()==transMode.typeOfTransMode.Wait)
        {
            txtUserID.setEnabled(false);
            txtUserName.setEnabled(false);
            txtPassword.setEnabled(false);
            cmbStatus.setEnabled(false);
            cmdNew.setEnabled(true);
            cmdExit.setEnabled(true);
            cmdEdit.setEnabled(false);
            cmdSave.setEnabled(false);
            cmdCancel.setEnabled(false);
            cmdDelete.setEnabled(false);
        }else            
            {
                 txtUserID.setEnabled(true);
                 txtUserName.setEnabled(true);
                 txtPassword.setEnabled(true);
                 cmbStatus.setEnabled(false);
                 cmdNew.setEnabled(false);
                 cmdExit.setEnabled(false);
                 cmdEdit.setEnabled(false);
                 cmdSave.setEnabled(true);
                 cmdCancel.setEnabled(true);
                 cmdDelete.setEnabled(false);
                 txtUserID.setFocusable(true);
                 if(mode.getTransMode()==transMode.typeOfTransMode.EditRecord)
                 {
                      txtUserID.setEnabled(false);
                      cmdDelete.setEnabled(true);
                      cmbStatus.setEnabled(true);
                      txtUserName.requestFocus();
                 }
            }
    }
     
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        txtUserID = new javax.swing.JTextField();
        txtUserName = new javax.swing.JTextField();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tbUser = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        cmbStatus = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Master User");
        setAlwaysOnTop(true);
        setResizable(false);

        jLabel2.setText("User Name");

        txtUserName.setAutoscrolls(false);

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

        jLabel3.setText("User ID");

        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jLabel4.setText("Keyword");

        cmbSearch.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "User ID", "User Name" }));
        cmbSearch.setSelectedIndex(1);

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
                .add(jLabel4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 57, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(txtKeyword, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 84, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(cmdSearch)
                .add(18, 18, 18)
                .add(jLabel5, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 50, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(cmbSearch, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 95, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
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

        tbUser.setModel(tabMode);
        tbUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbUserMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbUser);

        jLabel6.setText("Password");

        cmbStatus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Active", "In-Active" }));

        jLabel7.setText("Status");

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jLabel3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 126, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jLabel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 132, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jLabel6, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 112, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jLabel7, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 112, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .add(4, 4, 4)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(txtUserID, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 84, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(txtUserName, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 180, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                                .add(org.jdesktop.layout.GroupLayout.LEADING, cmbStatus, 0, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .add(org.jdesktop.layout.GroupLayout.LEADING, txtPassword, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE))))
                    .add(org.jdesktop.layout.GroupLayout.LEADING, layout.createSequentialGroup()
                        .add(cmdNew, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 68, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(cmdEdit)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(cmdSave)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(cmdCancel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 67, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(cmdDelete, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 65, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(cmdExit, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(txtUserID, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel3))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel2)
                    .add(txtUserName, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel6)
                    .add(txtPassword, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel7)
                    .add(cmbStatus, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(12, 12, 12)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(cmdEdit)
                    .add(cmdSave)
                    .add(cmdCancel)
                    .add(cmdNew)
                    .add(cmdExit)
                    .add(cmdDelete))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 316, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(376, 376, 376))
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-448)/2, (screenSize.height-565)/2, 448, 565);
    }// </editor-fold>//GEN-END:initComponents

    private void cmdExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdExitActionPerformed
        dispose();
        setVisible(false);
    }//GEN-LAST:event_cmdExitActionPerformed

    private void cmdNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdNewActionPerformed
        Data User = new Data(); 
        if(User.UserRight(UserID, "MST-001",Data.typeOfAction.Add)==false)
        {
             JOptionPane.showMessageDialog(this, "You dont have righ to add data.","Information",JOptionPane.OK_OPTION);
             return;
        }
        user = null;
        mode.setTransMode(transMode.typeOfTransMode.AddRecord);
        clearTextBox();
        enableControls();
        txtUserID.requestFocus();
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
                    SQL = "INSERT INTO masteruser VALUES('" + txtUserID.getText().trim() + "', '" + txtPassword.getText().trim() + "','" + txtUserName.getText().trim() + "', 'A')";
                    clsData.ExecuteSQL(SQL);                          
                }    
                else
                {
                     char status ='I';
                     if(cmbStatus.getSelectedIndex()==0)
                     {
                         status ='A';
                     }
                     SQL = "UPDATE masteruser SET UserName = '" + txtUserName.getText().trim() + "', Password = '" + txtPassword.getText().trim() + "', Status = '" + status + "' WHERE UserID = '" + txtUserID.getText().trim() + "'";
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

    private void tbUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbUserMouseClicked
        if(mode.getTransMode()==transMode.typeOfTransMode.Wait)
        {
            Object userID = tbUser.getModel().getValueAt(tbUser.getSelectedRow(), 0);
            Object userName = tbUser.getModel().getValueAt(tbUser.getSelectedRow(), 1);
            Object status = tbUser.getModel().getValueAt(tbUser.getSelectedRow(), 2);

            Data clsData = new Data();
            String password = "";
            password = clsData.getFieldStringValue("masteruser", "UserID",userID.toString(),"Password");                  
            System.out.println(password);
            txtUserID.setText(userID.toString().trim());
            txtUserName.setText(userName.toString().trim()); 
            txtPassword.setText(password);
            if(status.equals("A"))
            {
                cmbStatus.setSelectedIndex(0);
            }
            else
            {
                cmbStatus.setSelectedIndex(1);
            }           
            cmdEdit.setEnabled(true);
            clsData = null;
        }          
}//GEN-LAST:event_tbUserMouseClicked

    private void cmdDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdDeleteActionPerformed
            Data data = new Data(); 
            if(data.UserRight(UserID, "MST-001",Data.typeOfAction.Delete)==false)
            {
                JOptionPane.showMessageDialog(this, "You dont have right to delete data.","Information",JOptionPane.OK_OPTION);
                return;
            }        
            int result = JOptionPane.showConfirmDialog(this, "Do you want to delete this User ID ?","Confirmation",JOptionPane.YES_NO_OPTION);
            if(result==JOptionPane.YES_OPTION)
            {           
                String SQL = "DELETE FROM masteruser WHERE UserID = '" + txtUserID.getText().trim() + "'"; 
                data.ExecuteSQL(SQL);             
                SQL = "DELETE FROM masterfunctiondetail WHERE UserID = '" + txtUserID.getText().trim() + "'";                
                data.ExecuteSQL(SQL);             
                data = null;
                mode.setTransMode(transMode.typeOfTransMode.Wait);
                enableControls(); 
                clearTextBox();
                fillTable("");                
            }         
    }//GEN-LAST:event_cmdDeleteActionPerformed

    private void cmdEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdEditActionPerformed
        if(!txtUserID.getText().equals(""))
        {
           mode.setTransMode(transMode.typeOfTransMode.EditRecord);
           enableControls();              
        }        
    }//GEN-LAST:event_cmdEditActionPerformed
        
    private boolean isValidate()
    { 
        if(txtUserID.getText().trim().equals(""))
        {
            JOptionPane.showMessageDialog(this, "User ID is still empty.","Warning",JOptionPane.OK_OPTION);            
            return false;
        } 
        if(txtUserName.getText().trim().equals(""))
        {
            JOptionPane.showMessageDialog(this, "User name is still empty.","Warning",JOptionPane.OK_OPTION);
            return false;
        } 
        if(txtPassword.getText().trim().equals(""))
        {
            JOptionPane.showMessageDialog(this, "Password is still empty.","Warning",JOptionPane.OK_OPTION);
            return false;
        }
        
        if(mode.getTransMode()==transMode.typeOfTransMode.AddRecord)
        {
             Data clsData = new Data();
             String Kode = "";
             Kode = clsData.getFieldStringValue("masteruser", "UserID",txtUserID.getText().trim(),"UserID");
             if(!Kode.equals(""))
             {
                JOptionPane.showMessageDialog(this, "User ID is already exists.","Warning",JOptionPane.OK_OPTION);                        
                return false;
             } 
             
             Kode = clsData.getFieldStringValue("masteruser", "UserName",txtUserName.getText().trim(),"UserName");
             if(!Kode.equals(""))
             {
                JOptionPane.showMessageDialog(this, "User name is already exists.","Peringatan",JOptionPane.OK_OPTION);                        
                return false;
             } 
        } 
        else
        {
            Data User = new Data(); 
            if(User.UserRight(UserID, "MST-001",Data.typeOfAction.Modify)==false)
            {
                JOptionPane.showMessageDialog(this, "You dont have right to modify data.","Information",JOptionPane.OK_OPTION);
                return false;
            }        
        }
        return true;
    }     
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cmbSearch;
    private javax.swing.JComboBox cmbStatus;
    private javax.swing.JButton cmdCancel;
    private javax.swing.JButton cmdDelete;
    private javax.swing.JButton cmdEdit;
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
    private javax.swing.JTable tbUser;
    private javax.swing.JTextField txtKeyword;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUserID;
    private javax.swing.JTextField txtUserName;
    // End of variables declaration//GEN-END:variables
}
