package connect;
import static connect.Information.showFirmAccount;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.sql.SQLException;
import java.util.Date;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

public class FirmAccount1 extends javax.swing.JFrame 
{
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    
    public FirmAccount1() 
    {    
        initComponents();
        lbl_copyright_6.setText("Copyright@Computronics Lab");
        
        if(showFirmAccount==1)
        {
            tbl_firm_acc_details.setVisible(true);
            String sql = "SELECT * FROM table_daily_data_entry where firm_name ='" +Information.firm_name_temp+ "'";
            DefaultTableModel model_t = (DefaultTableModel) tbl_firm_acc_details.getModel();
            model_t.setRowCount(0);
            try
            {
                conn = Connect.ConnectDB();
                pst = conn.prepareStatement(sql);
                rs = pst.executeQuery();
                if(rs.next())
                {
                    int count=1;
                    do
                    {
                        Object row[]={count,  rs.getString("credit"), rs.getString("debit"), rs.getString("date")};
                        model_t.addRow(row);
                             
                        count++;
                    }while(rs.next());
                }
                conn.close();
            }
            catch(SQLException | HeadlessException e)
            {
                JOptionPane.showMessageDialog(null, e);          
            }
        
            
            sql = "SELECT * FROM firm_account WHERE firm_name='" + Information.firm_name_temp + "'";
            
            try
            {
                conn = Connect.ConnectDB();
                pst = conn.prepareStatement(sql);
                rs = pst.executeQuery();
                if(rs.next())
                {
                    tbx_firm_acc_firm_name.setText(rs.getString("firm_name"));
                    tbx_firm_acc_contact_name.setText(rs.getString("contact_name"));
                    txtarea_firm_account_address.setText(rs.getString("address"));
                    tbx_firm_acc_city.setText(rs.getString("city"));
                    tbx_firm_acc_mobile_no.setText(rs.getString("mobile_number"));
                }
                conn.close();
            }
            catch(SQLException | HeadlessException e)
            {
                JOptionPane.showMessageDialog(null, e);          
            }
            tbx_firm_acc_firm_name.setEditable(false);
            tbx_firm_acc_contact_name.setEditable(false);
            txtarea_firm_account_address.setEditable(false);
            tbx_firm_acc_city.setEditable(false);
            tbx_firm_acc_mobile_no.setEditable(false);
        }
        else
        {
            tbl_firm_acc_details.setEnabled(false);
            Dimension d = new Dimension();
            d.height = 0;
            d.width=0;
            tbl_firm_acc_details.setPreferredSize(d);
            
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_firm_acc_mobile_number = new javax.swing.JLabel();
        tbx_firm_acc_mobile_no = new javax.swing.JTextField();
        lbl_firm_acc_firm_name = new javax.swing.JLabel();
        tbx_firm_acc_firm_name = new javax.swing.JTextField();
        lbl_firm_acc_contact_name = new javax.swing.JLabel();
        tbx_firm_acc_city = new javax.swing.JTextField();
        lbl_firm_acc_address = new javax.swing.JLabel();
        lbl_firm_acc_city = new javax.swing.JLabel();
        tbx_firm_acc_contact_name = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtarea_firm_account_address = new javax.swing.JTextArea();
        btn_firm_acc_close = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        lbl_copyright_6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_firm_acc_details = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 255));
        setResizable(false);
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                formFocusGained(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                formMouseEntered(evt);
            }
        });

        lbl_firm_acc_mobile_number.setText("Mobile Number:");

        tbx_firm_acc_mobile_no.setPreferredSize(new java.awt.Dimension(120, 30));

        lbl_firm_acc_firm_name.setText("Firm Name:");

        tbx_firm_acc_firm_name.setPreferredSize(new java.awt.Dimension(120, 30));
        tbx_firm_acc_firm_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbx_firm_acc_firm_nameActionPerformed(evt);
            }
        });

        lbl_firm_acc_contact_name.setText("Contact Name:");

        tbx_firm_acc_city.setPreferredSize(new java.awt.Dimension(120, 30));

        lbl_firm_acc_address.setText("Address:");

        lbl_firm_acc_city.setText("City:");

        tbx_firm_acc_contact_name.setPreferredSize(new java.awt.Dimension(120, 30));

        txtarea_firm_account_address.setColumns(20);
        txtarea_firm_account_address.setRows(5);
        jScrollPane1.setViewportView(txtarea_firm_account_address);

        btn_firm_acc_close.setText("Close");
        btn_firm_acc_close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_firm_acc_closeActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Mangla Traders");
        jLabel3.setBorder(new javax.swing.border.MatteBorder(null));

        lbl_copyright_6.setText("Copyright to Computronics Lab");

        tbl_firm_acc_details.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "S No.", "Credit", "Debit", "Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tbl_firm_acc_details);
        if (tbl_firm_acc_details.getColumnModel().getColumnCount() > 0) {
            tbl_firm_acc_details.getColumnModel().getColumn(0).setResizable(false);
            tbl_firm_acc_details.getColumnModel().getColumn(1).setResizable(false);
            tbl_firm_acc_details.getColumnModel().getColumn(3).setResizable(false);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lbl_copyright_6))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(372, 372, 372)
                        .addComponent(btn_firm_acc_close)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 715, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_firm_acc_city)
                                    .addComponent(lbl_firm_acc_firm_name))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tbx_firm_acc_firm_name, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tbx_firm_acc_city, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(36, 36, 36)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lbl_firm_acc_contact_name)
                                    .addComponent(lbl_firm_acc_mobile_number))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(tbx_firm_acc_contact_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(lbl_firm_acc_address))
                                    .addComponent(tbx_firm_acc_mobile_no, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(273, 273, 273)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_firm_acc_firm_name)
                            .addComponent(tbx_firm_acc_firm_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_firm_acc_contact_name)
                            .addComponent(tbx_firm_acc_contact_name, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_firm_acc_address))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(tbx_firm_acc_city, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbl_firm_acc_city)
                                    .addComponent(lbl_firm_acc_mobile_number)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(tbx_firm_acc_mobile_no, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_firm_acc_close)
                .addGap(8, 8, 8)
                .addComponent(lbl_copyright_6))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbx_firm_acc_firm_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbx_firm_acc_firm_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tbx_firm_acc_firm_nameActionPerformed

    private void btn_firm_acc_closeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_firm_acc_closeActionPerformed
        this.setVisible(false);
        new Information().setVisible(true);
    }//GEN-LAST:event_btn_firm_acc_closeActionPerformed

    private void formFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusGained
        // TODO add your handling code here: 
    }//GEN-LAST:event_formFocusGained

    private void formMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseEntered
      
    }//GEN-LAST:event_formMouseEntered

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FirmAccount1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FirmAccount1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FirmAccount1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FirmAccount1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FirmAccount1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_firm_acc_close;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_copyright_6;
    private javax.swing.JLabel lbl_firm_acc_address;
    private javax.swing.JLabel lbl_firm_acc_city;
    private javax.swing.JLabel lbl_firm_acc_contact_name;
    private javax.swing.JLabel lbl_firm_acc_firm_name;
    private javax.swing.JLabel lbl_firm_acc_mobile_number;
    private javax.swing.JTable tbl_firm_acc_details;
    private javax.swing.JTextField tbx_firm_acc_city;
    private javax.swing.JTextField tbx_firm_acc_contact_name;
    private javax.swing.JTextField tbx_firm_acc_firm_name;
    private javax.swing.JTextField tbx_firm_acc_mobile_no;
    private javax.swing.JTextArea txtarea_firm_account_address;
    // End of variables declaration//GEN-END:variables
}
