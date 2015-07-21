/*
 * FrmLocateMasterBudget.java
 * Created on April 8, 2008, 3:17 PM
 * @author  kusno
 */ 

import java.sql.*;
import javax.swing.JTable.*;
import javax.swing.table.DefaultTableModel;

public class FrmLocateMasterEmployee extends javax.swing.JDialog {
    transMode mode = new transMode();    
    String[] strJdl = {"Employee ID","Employee Name","Title Name"};
    DefaultTableModel tabMode;
    Object employeeID;
    Object employeeName;
 
    public FrmLocateMasterEmployee() {
       mode.setTransMode(transMode.typeOfTransMode.Wait);
       tabMode = new DefaultTableModel(null,strJdl)
               {
    public boolean isCellEditable(int row, int column)
    {
        return false;
    }
};  
       initComponents(); 
       fillTable("");
       formatTableColumn();
    }
    
    void formatTableColumn()
    {        
          tblBudget.getColumnModel().getColumn(0).setPreferredWidth(40);
          tblBudget.getColumnModel().getColumn(1).setPreferredWidth(140);
          tblBudget.getColumnModel().getColumn(2).setPreferredWidth(80);     
    }
    
    public String getEmployeeID()
    {
        if(employeeID==null)
        {
          return "";            
        }
        else
        {
          return employeeID.toString().trim();            
        }         
    }
    
    public String getEmployeeName()
    {
        if(employeeName==null)
        {
          return "";            
        }
        else
        {
          return employeeName.toString().trim();            
        }         
    }      
      
    void fillTable(String keyword)
    {
        String SQL = "";
        SQL = "SELECT me.employeeID, me.employeeName, mt.titleName FROM masterEmployee me INNER JOIN masterTitle mt on me.TitleID = mt.TitleID WHERE me.EmployeeStatus = 'A' ";      
        if(!keyword.equals(""))
        {
            if(cmbSearch.getSelectedIndex()==0)
            {
                SQL += " AND me.employeeID LIKE '%" + keyword + "%'";
            }
            else if(cmbSearch.getSelectedIndex()==1)
            {
                SQL += " WHERE me.employeeName LIKE '%" + keyword + "%'";
            }
            else
            {
                SQL += " WHERE mt.titleName LIKE '%" + keyword + "%'";
            }
        }         
        SQL += " ORDER BY me.employeeID";     
        tabMode.setRowCount(0);
        try{
            DBConnection getCn = new DBConnection();
            Connection cn = getCn.getConnection();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            while(rs.next())
            {
                String employeeId = rs.getString(1);
                String employeeName = rs.getString(2);
                String titleName = rs.getString(3);
                String[] data = {employeeId,employeeName,titleName};
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
                 
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtKeyword = new javax.swing.JTextField();
        cmdSearch = new javax.swing.JButton();
        cmbSearch = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBudget = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Locate Employee");
        setAlwaysOnTop(true);
        setModal(true);
        setResizable(false);

        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jLabel4.setText("Keyword");

        cmdSearch.setText("Find");
        cmdSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdSearchActionPerformed(evt);
            }
        });

        cmbSearch.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Employee ID", "Employee Name", "Title Name" }));
        cmbSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbSearchActionPerformed(evt);
            }
        });

        jLabel5.setText("base on");

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jLabel4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 49, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(txtKeyword, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 84, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(6, 6, 6)
                .add(cmdSearch, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 64, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(10, 10, 10)
                .add(jLabel5, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 46, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(cmbSearch, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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

        tblBudget.setModel(tabMode);
        tblBudget.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBudgetMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblBudget);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, jScrollPane1, 0, 0, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 379, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        pack();
        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        java.awt.Dimension dialogSize = getSize();
        setLocation((screenSize.width-dialogSize.width)/2,(screenSize.height-dialogSize.height)/2);
    }// </editor-fold>//GEN-END:initComponents

    private void cmdSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdSearchActionPerformed
        fillTable(txtKeyword.getText().trim());
}//GEN-LAST:event_cmdSearchActionPerformed

    private void tblBudgetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBudgetMouseClicked
        employeeID = tblBudget.getModel().getValueAt(tblBudget.getSelectedRow(), 0);
        employeeName = tblBudget.getModel().getValueAt(tblBudget.getSelectedRow(), 1);
        setVisible (false);
        dispose();   
}//GEN-LAST:event_tblBudgetMouseClicked

    private void cmbSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbSearchActionPerformed
        fillTable(txtKeyword.getText().trim());        
}//GEN-LAST:event_cmbSearchActionPerformed
 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cmbSearch;
    private javax.swing.JButton cmdSearch;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblBudget;
    private javax.swing.JTextField txtKeyword;
    // End of variables declaration//GEN-END:variables
}
