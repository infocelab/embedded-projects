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

public class FirmAccount1_1 extends javax.swing.JFrame 
{
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    
    public FirmAccount1_1() 
    {    
        initComponents();
        lbl_copyright_6.setText("Copyright@Computronics Lab");
        
     
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
        btn_firm_acc_save = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtarea_firm_account_address = new javax.swing.JTextArea();
        btn_firm_acc_close = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        lbl_copyright_6 = new javax.swing.JLabel();

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

        btn_firm_acc_save.setText("save");
        btn_firm_acc_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_firm_acc_saveActionPerformed(evt);
            }
        });

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
                        .addGap(256, 256, 256)
                        .addComponent(btn_firm_acc_save)
                        .addGap(42, 42, 42)
                        .addComponent(btn_firm_acc_close))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(31, 31, 31)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lbl_firm_acc_firm_name)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(tbx_firm_acc_firm_name, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(87, 87, 87)
                                    .addComponent(lbl_firm_acc_city))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(lbl_firm_acc_mobile_number)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(tbx_firm_acc_mobile_no, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(lbl_firm_acc_address)
                                        .addGap(18, 18, 18)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tbx_firm_acc_city, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(273, 273, 273)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(30, 30, 30)
                                    .addComponent(lbl_firm_acc_contact_name)
                                    .addGap(18, 18, 18)
                                    .addComponent(tbx_firm_acc_contact_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel3)))))
                .addContainerGap(243, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_firm_acc_firm_name)
                    .addComponent(tbx_firm_acc_firm_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_firm_acc_contact_name)
                    .addComponent(tbx_firm_acc_contact_name, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbl_firm_acc_address)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lbl_firm_acc_city)
                                .addComponent(tbx_firm_acc_city, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(116, 116, 116))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_firm_acc_mobile_number)
                    .addComponent(tbx_firm_acc_mobile_no, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(84, 84, 84)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_firm_acc_save)
                    .addComponent(btn_firm_acc_close))
                .addGap(220, 220, 220)
                .addComponent(lbl_copyright_6))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_firm_acc_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_firm_acc_saveActionPerformed
        String firm_name = tbx_firm_acc_firm_name.getText();
        String contact_name  = tbx_firm_acc_contact_name.getText();
        String address = txtarea_firm_account_address.getText();
        String city = tbx_firm_acc_city.getText();
        String mobile_number = tbx_firm_acc_mobile_no.getText();
        
        if(firm_name.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Firm Name Cannot be Empty"); 
            return;
        }
    
        if(contact_name.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Contact Name Cannot be Empty"); 
            return;
        }
         
        if(address.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Address Cannot be Empty"); 
            return;
        }
        
        if(city.equals(""))
        {
            JOptionPane.showMessageDialog(null, "City Cannot be Empty"); 
            return;
        }
        
        if(mobile_number.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Mobile Number Cannot be Empty"); 
            return;
        }
        
        if(!mobile_number.equals("") && mobile_number.length() != 10)
        {
            JOptionPane.showMessageDialog(null, "Moblie Number Must be 10 Digit only"); 
            return; 
        }
        
        Date today = new Date();
        SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy");
        String date = DATE_FORMAT.format(today);
        String sql;
        
        //TBD
        // check the firm name already exists 
        // if yes then update else insert
        
        sql = "Insert into firm_account (firm_name,contact_name,address,city,mobile_number,date,user_type) values ('" +  firm_name + "','" + contact_name + "','" + address + "','" + city + "','" + mobile_number + "','" + date +"','" + Information.user_type + "')";
        
        try
        {
            conn = Connect.ConnectDB();
            pst = conn.prepareStatement(sql);
            pst.executeUpdate();
        
            JOptionPane.showMessageDialog(null, "saved");
            tbx_firm_acc_firm_name.setText("");
            tbx_firm_acc_city.setText("");
            txtarea_firm_account_address.setText("");
            tbx_firm_acc_contact_name.setText("");
            tbx_firm_acc_mobile_no.setText("");
            conn.close();
        }
        catch(SQLException | HeadlessException e)
        {
            JOptionPane.showMessageDialog(null, e);          
        }   
    }//GEN-LAST:event_btn_firm_acc_saveActionPerformed

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
    private javax.swing.JButton btn_firm_acc_save;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_copyright_6;
    private javax.swing.JLabel lbl_firm_acc_address;
    private javax.swing.JLabel lbl_firm_acc_city;
    private javax.swing.JLabel lbl_firm_acc_contact_name;
    private javax.swing.JLabel lbl_firm_acc_firm_name;
    private javax.swing.JLabel lbl_firm_acc_mobile_number;
    private javax.swing.JTextField tbx_firm_acc_city;
    private javax.swing.JTextField tbx_firm_acc_contact_name;
    private javax.swing.JTextField tbx_firm_acc_firm_name;
    private javax.swing.JTextField tbx_firm_acc_mobile_no;
    private javax.swing.JTextArea txtarea_firm_account_address;
    // End of variables declaration//GEN-END:variables
}
