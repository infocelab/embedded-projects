/*
 * FrmMasterTitle.java
 *
 * Created on June 9, 2008, 10:00 AM
 *
 * @author  kusno
 */ 
import javax.swing.JOptionPane;
import java.sql.*;
import javax.swing.JTable.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.*;

public class FrmMasterTitle extends javax.swing.JFrame {
    transMode mode = new transMode();    
    String[] strHeader = {"Title ID","Title Name","Level"};
    DefaultTableModel tabMode;
    Data user = new Data(); 
    String UserID;    
     
    public FrmMasterTitle() {
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
        txtTitleID.setText("");
        txtTitleName.setText("");
        txtLevel.setText("0");
    }
    
    void formatTableColumn()
    {        
          tbTitle.getColumnModel().getColumn(0).setPreferredWidth(50);
          tbTitle.getColumnModel().getColumn(1).setPreferredWidth(170);
          tbTitle.getColumnModel().getColumn(2).setPreferredWidth(40);                              
    }
    
    void fillTable(String keyword)
    {
        String SQL = "";
        SQL = "SELECT * FROM mastertitle ";
        if(!keyword.equals(""))
        {
            if(cmbSearch.getSelectedIndex()==0)
            {
                SQL += " WHERE TitleID LIKE '%" + keyword + "%'";
            }
            else
            {
                SQL += " WHERE TitleName LIKE '%" + keyword + "%'";
            }
        }
        SQL += " ORDER BY Level";
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
                int iLevel = rs.getInt(3);
                String Level =Integer.toString(iLevel);
                String[] data = {ID,Name,Level};
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
            txtTitleID.setEnabled(false);
            txtTitleName.setEnabled(false);
            txtLevel.setEnabled(false);
            cmdNew.setEnabled(true);
            cmdExit.setEnabled(true);
            cmdModify.setEnabled(false);
            cmdSave.setEnabled(false);
            cmdCancel.setEnabled(false);
            cmdDelete.setEnabled(false);
        }else            
            {
                 txtTitleID.setEnabled(true);
                 txtTitleName.setEnabled(true);
                 txtLevel.setEnabled(true);
                 cmdNew.setEnabled(false);
                 cmdExit.setEnabled(false);
                 cmdModify.setEnabled(false);
                 cmdSave.setEnabled(true);
                 cmdCancel.setEnabled(true);
                 cmdDelete.setEnabled(false);
                 if(mode.getTransMode()==transMode.typeOfTransMode.EditRecord)
                 {
                      txtTitleID.setEnabled(false);
                      cmdDelete.setEnabled(true);
                      txtTitleName.requestFocus();
                 }
            }
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        txtTitleID = new javax.swing.JTextField();
        txtTitleName = new javax.swing.JTextField();
        cmdNew = new javax.swing.JButton();
        cmdModify = new javax.swing.JButton();
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
        tbTitle = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        txtLevel = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Master Title");
        setAlwaysOnTop(true);
        setResizable(false);

        jLabel2.setText("Title Name");

        txtTitleName.setAutoscrolls(false);

        cmdNew.setText("Add");
        cmdNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdNewActionPerformed(evt);
            }
        });

        cmdModify.setText("Modify");
        cmdModify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdModifyActionPerformed(evt);
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

        jLabel3.setText("Title ID");

        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jLabel4.setText("Keyword");

        cmbSearch.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Title ID", "Title Name" }));

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

        tbTitle.setModel(tabMode);
        tbTitle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbTitleMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbTitle);

        jLabel6.setText("Level");

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 482, Short.MAX_VALUE)
                        .addContainerGap())
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                            .add(org.jdesktop.layout.GroupLayout.LEADING, jLabel3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(org.jdesktop.layout.GroupLayout.LEADING, jLabel2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(txtTitleID, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 50, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(txtTitleName, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 280, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                        .add(jLabel6, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(txtLevel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 50, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(324, 324, 324))
                    .add(layout.createSequentialGroup()
                        .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(24, Short.MAX_VALUE))
                    .add(layout.createSequentialGroup()
                        .add(cmdNew, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 74, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(cmdModify)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(cmdSave, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 68, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(cmdCancel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 67, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(cmdDelete)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(cmdExit, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 71, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(50, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel3)
                    .add(txtTitleID, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel2)
                    .add(txtTitleName, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(8, 8, 8)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(jLabel6)
                    .add(txtLevel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(14, 14, 14)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(cmdModify)
                    .add(cmdDelete)
                    .add(cmdCancel)
                    .add(cmdSave)
                    .add(cmdNew)
                    .add(cmdExit))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 330, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
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
        if(User.UserRight(UserID, "MST-005",Data.typeOfAction.Add)==false)
        {
            JOptionPane.showMessageDialog(this, "You dont have right to add data.","Information",JOptionPane.OK_OPTION);
            return ;
        }
        mode.setTransMode(transMode.typeOfTransMode.AddRecord);
        clearTextBox();
        enableControls();
        txtTitleID.requestFocus();
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
                    SQL = "INSERT INTO mastertitle VALUES('" + txtTitleID.getText().trim() + "', '" + txtTitleName.getText().trim() + "', '" + txtLevel.getText().trim() + "')";
                    clsData.ExecuteSQL(SQL);                          
                }    
                else
                {
                     SQL = "UPDATE mastertitle SET TitleName = '" + txtTitleName.getText().trim() + "', Level = '" + txtLevel.getText().trim() + "' WHERE TitleID = '" + txtTitleID.getText().trim() + "'";
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

    private void tbTitleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbTitleMouseClicked
        if(mode.getTransMode()==transMode.typeOfTransMode.Wait)
        {
            Object groupID = tbTitle.getModel().getValueAt(tbTitle.getSelectedRow(), 0);
            Object groupName = tbTitle.getModel().getValueAt(tbTitle.getSelectedRow(), 1);
            Object level = tbTitle.getModel().getValueAt(tbTitle.getSelectedRow(), 2);
            txtTitleID.setText(groupID.toString().trim());
            txtTitleName.setText(groupName.toString().trim()); 
            txtLevel.setText(level.toString().trim());
            cmdModify.setEnabled(true);
         }
}//GEN-LAST:event_tbTitleMouseClicked

    private void cmdDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdDeleteActionPerformed
        Data User = new Data(); 
        if(User.UserRight(UserID, "MST-005",Data.typeOfAction.Delete)==false)
        {
            JOptionPane.showMessageDialog(this, "You dont have right to delete data.","Information",JOptionPane.OK_OPTION);
            return ;
        }
        
        if(titleIDIsAlreadyUsed()==true)
        {
            JOptionPane.showMessageDialog(this,"ID can not be deleted, it has been used by Employee.","Information",JOptionPane.OK_OPTION);            
        }
        else
        {
            int result = JOptionPane.showConfirmDialog(this, "Do you want to delete ?","Confirmation",JOptionPane.YES_NO_OPTION);
            if(result==JOptionPane.YES_OPTION)
            {
                Data clsData = new Data();
                String SQL = "DELETE FROM mastertitle WHERE TitleID = '" + txtTitleID.getText().trim() + "'"; 
                clsData.ExecuteSQL(SQL);     
                mode.setTransMode(transMode.typeOfTransMode.Wait);
                clsData = null;
                enableControls(); 
                clearTextBox();
                fillTable("");                
            }
        }
    }//GEN-LAST:event_cmdDeleteActionPerformed

    private void cmdModifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdModifyActionPerformed
        if(!txtTitleID.getText().equals(""))
        {
           mode.setTransMode(transMode.typeOfTransMode.EditRecord);
           enableControls();              
        }        
}//GEN-LAST:event_cmdModifyActionPerformed
    
    private boolean titleIDIsAlreadyUsed()
    {
         boolean tempResult = false;         
         String SQL = "SELECT TitleID FROM masteremployee WHERE TitleID = '" + txtTitleID.getText().trim() + "'";
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
        if(txtTitleID.getText().trim().equals(""))
        {
            JOptionPane.showMessageDialog(this, "Title ID is still empty.","Warning",JOptionPane.OK_OPTION);            
            return false;
        } 
        if(txtTitleName.getText().trim().equals(""))
        {
            JOptionPane.showMessageDialog(this, "Title name is still empty.","Warning",JOptionPane.OK_OPTION);
            return false;
        }                 
        
        if(mode.getTransMode()==transMode.typeOfTransMode.AddRecord)
        {
             Data clsData = new Data();
             String Kode = "";
             Kode = clsData.getFieldStringValue("mastertitle", "TitleID",txtTitleID.getText().trim(),"TitleID");
             if(!Kode.equals(""))
             {
                JOptionPane.showMessageDialog(this, "Title ID is already exists.","Warning",JOptionPane.OK_OPTION);                        
                return false;
             } 
        }   
        else
        {
            Data User = new Data(); 
            if(User.UserRight(UserID, "MST-005",Data.typeOfAction.Modify)==false)
            {
                JOptionPane.showMessageDialog(this, "You dont have right to modify data.","Information",JOptionPane.OK_OPTION);
                return false ;
            }
        }
        return true;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cmbSearch;
    private javax.swing.JButton cmdCancel;
    private javax.swing.JButton cmdDelete;
    private javax.swing.JButton cmdExit;
    private javax.swing.JButton cmdModify;
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
    private javax.swing.JTable tbTitle;
    private javax.swing.JTextField txtKeyword;
    private javax.swing.JTextField txtLevel;
    private javax.swing.JTextField txtTitleID;
    private javax.swing.JTextField txtTitleName;
    // End of variables declaration//GEN-END:variables
}
