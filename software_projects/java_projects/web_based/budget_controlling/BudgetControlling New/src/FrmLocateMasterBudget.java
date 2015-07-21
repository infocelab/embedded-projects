/*
 * FrmLocateMasterBudget.java
 * Created on April 8, 2008, 3:17 PM
 * @author  kusno
 */ 

import java.sql.*;
import javax.swing.JTable.*;
import javax.swing.table.DefaultTableModel;

public class FrmLocateMasterBudget extends javax.swing.JDialog {
    transMode mode = new transMode();    
    String[] strJdl = {"Budget ID","Budget Name","Group ID","Group Name"};
    DefaultTableModel tabMode;
    Object budgetID;
    Object budgetName;
 
    public FrmLocateMasterBudget() {
       mode.setTransMode(transMode.typeOfTransMode.Wait);
       tabMode = new DefaultTableModel(null,strJdl)
               {
    public boolean isCellEditable(int row, int column)
    {
        return false;
    }
};  
       initComponents();
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
    
    public String getBudgetID()
    {
        if(budgetID==null)
        {
          return "";            
        }
        else
        {
          return budgetID.toString().trim();            
        }         
    }
    
    public String getBudgetName()
    {
        if(budgetName==null)
        {
          return "";            
        }
        else
        {
          return budgetName.toString().trim();            
        }         
    }
    
    void fillComboGroup()
    {
        String SQL = "SELECT BudgetGroupName FROM masterbudgetgroup ORDER BY BudgetGroupID";
        Data clsCombo = new Data();
        clsCombo.FillComboBox(SQL, cmbGroup, "ALL GROUP");
        clsCombo = null;
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
                String budgetId = rs.getString(1);
                String budgetName = rs.getString(2);
                String groupID = rs.getString(3);
                String groupName = rs.getString(4);
                String[] data = {budgetId,budgetName,groupID,groupName};
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
        cmbSearch = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        cmdSearch = new javax.swing.JButton();
        cmbGroup = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBudget = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Locate Budget");
        setAlwaysOnTop(true);
        setModal(true);
        setResizable(false);

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
                .add(cmbGroup, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 151, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jLabel4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 49, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(txtKeyword, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 84, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(cmdSearch, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 64, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(18, 18, 18)
                .add(jLabel5, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 43, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(cmbSearch, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 99, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
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

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, jScrollPane1)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 45, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 388, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
        budgetID = tblBudget.getModel().getValueAt(tblBudget.getSelectedRow(), 0);
        budgetName = tblBudget.getModel().getValueAt(tblBudget.getSelectedRow(), 1);
        setVisible (false);
        dispose();   
}//GEN-LAST:event_tblBudgetMouseClicked

    private void cmbGroupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbGroupActionPerformed
        fillTable(txtKeyword.getText().trim());        
    }//GEN-LAST:event_cmbGroupActionPerformed
 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cmbGroup;
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
