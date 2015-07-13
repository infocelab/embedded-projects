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

public class FirmAccount_edit_entry extends javax.swing.JFrame 
{
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    
    public FirmAccount_edit_entry() 
    {    
        initComponents();
        lbl_copyright_6.setText("Copyright@Computronics Lab");
        tbx_edit_entry_firm_name.setText(Information.firm_name_temp);
        tbx_edit_entry_credit.setText(Information.credit_temp);
        tbx_edit_entry_debit.setText(Information.debit_temp);
        tbx_edit_entry_comment.setText(Information.comment_temp);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_firm_acc_firm_name = new javax.swing.JLabel();
        tbx_edit_entry_firm_name = new javax.swing.JTextField();
        btn_edit_entry_update = new javax.swing.JButton();
        btn_firm_acc_close = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        lbl_copyright_6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        tbx_edit_entry_credit = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tbx_edit_entry_debit = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbx_edit_entry_comment = new javax.swing.JTextArea();

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

        lbl_firm_acc_firm_name.setText("Firm Name:");

        tbx_edit_entry_firm_name.setEditable(false);
        tbx_edit_entry_firm_name.setPreferredSize(new java.awt.Dimension(120, 30));
        tbx_edit_entry_firm_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbx_edit_entry_firm_nameActionPerformed(evt);
            }
        });

        btn_edit_entry_update.setText("Update");
        btn_edit_entry_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_edit_entry_updateActionPerformed(evt);
            }
        });

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

        jLabel1.setText("Credit:");

        jLabel2.setText("Debit:");

        jLabel4.setText("Comment:");

        tbx_edit_entry_comment.setColumns(20);
        tbx_edit_entry_comment.setRows(5);
        jScrollPane1.setViewportView(tbx_edit_entry_comment);

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
                        .addGap(273, 273, 273)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btn_edit_entry_update)
                                .addGap(42, 42, 42)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(18, 18, 18)
                                        .addComponent(tbx_edit_entry_debit, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(9, 9, 9)
                                        .addComponent(btn_firm_acc_close))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lbl_firm_acc_firm_name)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(31, 31, 31))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(31, 31, 31)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(tbx_edit_entry_credit, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(tbx_edit_entry_firm_name, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 211, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))))))
                .addContainerGap(240, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_firm_acc_firm_name)
                    .addComponent(tbx_edit_entry_firm_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tbx_edit_entry_credit, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(tbx_edit_entry_debit, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 145, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_edit_entry_update)
                    .addComponent(btn_firm_acc_close))
                .addGap(16, 16, 16)
                .addComponent(lbl_copyright_6))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_edit_entry_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_edit_entry_updateActionPerformed
      
        String credit  = tbx_edit_entry_credit.getText();
        String debit = tbx_edit_entry_debit.getText();
        String comment = tbx_edit_entry_comment.getText();
       
       
        try 
        {
            // if is number
            if(!credit.equals(""))
            {
                Float.parseFloat(credit);
            }
        } 
        catch (NumberFormatException e) 
        {
            // else then do blah
            JOptionPane.showMessageDialog(null, "Credit Should be Number only"); 
            return;
        }
        
         try 
        {
            // if is number
            if(!debit.equals(""))
            {
                Float.parseFloat(debit);
            }
        } 
        catch (NumberFormatException e) 
        {
            // else then do blah
            JOptionPane.showMessageDialog(null, "Debit Should be Number only"); 
            return;
        }
        
        if(!credit.equals("") && !debit.equals("")) 
        {
            JOptionPane.showMessageDialog(null, "Both Credit and Debit cannot be Accepted"); 
            return;
        }
        
        if(credit.equals("") && debit.equals("")) 
        {
            JOptionPane.showMessageDialog(null, "Both Credit and Debit cannot be Empty"); 
            return;
        }
        
        String sql="";
        sql = "Update table_daily_data_entry set credit='" + credit + "',debit='" + debit + "', comment='" + comment + "'where rowid="+ Information.edit_rowid;
        try
        {
           conn = Connect.ConnectDB();
           pst = conn.prepareStatement(sql);
           pst.executeUpdate();
           //JOptionPane.showMessageDialog(null, "Update Success");
           
           conn.close();
           this.setVisible(false);
           new Information().setVisible(true);
        }
        catch(SQLException | HeadlessException e)
        {
          JOptionPane.showMessageDialog(null, e);          
        }
        
        
        
    }//GEN-LAST:event_btn_edit_entry_updateActionPerformed

    private void tbx_edit_entry_firm_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbx_edit_entry_firm_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tbx_edit_entry_firm_nameActionPerformed

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
    private javax.swing.JButton btn_edit_entry_update;
    private javax.swing.JButton btn_firm_acc_close;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_copyright_6;
    private javax.swing.JLabel lbl_firm_acc_firm_name;
    private javax.swing.JTextArea tbx_edit_entry_comment;
    private javax.swing.JTextField tbx_edit_entry_credit;
    private javax.swing.JTextField tbx_edit_entry_debit;
    private javax.swing.JTextField tbx_edit_entry_firm_name;
    // End of variables declaration//GEN-END:variables
}
