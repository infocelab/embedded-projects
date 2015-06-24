/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connect;

import static connect.Information.showFirmAccount;
import java.awt.Color;
import java.awt.HeadlessException;
import java.sql.SQLException;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/**
 *
 * @author celab-amit
 */
public class FirmAccount1 extends javax.swing.JFrame {

    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    
    /**
     * Creates new form FirmAccount1
     */
    public FirmAccount1() {
        
        initComponents();
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtarea_firm_account_address = new javax.swing.JTextArea();
        txt_firm_account_debit = new javax.swing.JTextField();
        txt_firm_account_credit = new javax.swing.JTextField();
        btn_firm_acc_close = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(154, 201, 178));
        setMaximumSize(new java.awt.Dimension(214748, 214748));
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

        jLabel1.setText("Debit");

        jLabel2.setText("Credit");

        txtarea_firm_account_address.setColumns(20);
        txtarea_firm_account_address.setRows(5);
        jScrollPane1.setViewportView(txtarea_firm_account_address);

        btn_firm_acc_close.setText("Close");
        btn_firm_acc_close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_firm_acc_closeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_firm_acc_firm_name)
                                    .addComponent(lbl_firm_acc_address))
                                .addGap(36, 36, 36))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(58, 58, 58))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(lbl_firm_acc_mobile_number)
                                        .addGap(18, 18, 18)))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tbx_firm_acc_mobile_no, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lbl_firm_acc_city))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(tbx_firm_acc_firm_name, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(36, 36, 36)
                                        .addComponent(lbl_firm_acc_contact_name))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txt_firm_account_debit)
                                        .addGap(80, 80, 80)
                                        .addComponent(jLabel2)))
                                .addGap(44, 44, 44)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tbx_firm_acc_city, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(tbx_firm_acc_contact_name, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txt_firm_account_credit)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(216, 216, 216)
                        .addComponent(btn_firm_acc_save)
                        .addGap(39, 39, 39)
                        .addComponent(btn_firm_acc_close)))
                .addGap(142, 142, 142))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(tbx_firm_acc_contact_name, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_firm_acc_firm_name)
                            .addComponent(tbx_firm_acc_firm_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_firm_acc_contact_name))
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_firm_acc_address)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lbl_firm_acc_city)
                                        .addComponent(tbx_firm_acc_city, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tbx_firm_acc_mobile_no, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_firm_acc_mobile_number))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(txt_firm_account_debit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_firm_account_credit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_firm_acc_save)
                    .addComponent(btn_firm_acc_close))
                .addContainerGap(155, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_firm_acc_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_firm_acc_saveActionPerformed
        // TODO add your handling code here:
        
        String firm_name = tbx_firm_acc_firm_name.getText();
        String contact_name  = tbx_firm_acc_contact_name.getText();
        String address = txtarea_firm_account_address.getText();
        String city = tbx_firm_acc_city.getText();
        String mobile_number = tbx_firm_acc_mobile_no.getText();
        String debit = txt_firm_account_debit.getText();
        String credit = txt_firm_account_credit.getText();
       

        
        //Object row[]={"1", firm_name, contact_name, address, city, mobile_number};
        //table_daily_data_entry.setAutoResizeMode(table_daily_data_entry.AUTO_RESIZE_OFF);
       // table_daily_data_entry.getColumnModel().getColumn(0).setPreferredWidth(20);
       // table_daily_data_entry.getColumnModel().getColumn(1).setPreferredWidth(100);
       // table_daily_data_entry.getColumnModel().getColumn(2).setPreferredWidth(100);
       // table_daily_data_entry.getColumnModel().getColumn(3).setPreferredWidth(100);
       // table_daily_data_entry.getColumnModel().getColumn(4).setPreferredWidth(400);
        
        Date today = new Date();
        SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy");
        String date = DATE_FORMAT.format(today);
        String sql;
        if( Information.user_type.equals("b"))
        {         
        
        sql = "Insert into firm_account (firm_name,contact_name,address,city,mobile_number,debit,credit,date,user_type) values ('" +  firm_name + "','" + contact_name + "','" + address + "','" + city + "','" + mobile_number + "','" + debit + "','" + credit + "','" + date +"','" + Information.user_type + "')";
        } 
        else
        {
        sql = "Insert into firm_account (firm_name,contact_name,address,city,mobile_number,debit,credit,date,user_type) values ('" +  firm_name + "','" + contact_name + "','" + address + "','" + city + "','" + mobile_number + "','" + debit + "','" + credit + "','" + date +"','" + Information.user_type + "')";
        }
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
           txt_firm_account_debit.setText("");
           txt_firm_account_credit.setText("");
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
        // TODO add your handling code here:
        
        this.setVisible(false);
        new Information().setVisible(true);
    }//GEN-LAST:event_btn_firm_acc_closeActionPerformed

    private void formFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusGained
        // TODO add your handling code here:
    
    }//GEN-LAST:event_formFocusGained

    private void formMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseEntered
        // TODO add your handling code here:
          String sql = "SELECT * FROM firm_account WHERE firm_name='" + Information.firm_name_temp + "'";
            
      try
      {
        conn = Connect.ConnectDB();
        pst = conn.prepareStatement(sql);
        rs = pst.executeQuery();
        if(rs.next()){
            
            tbx_firm_acc_firm_name.setText(rs.getString("firm_name"));
            tbx_firm_acc_contact_name.setText(rs.getString("city"));
            txtarea_firm_account_address.setText(rs.getString("address"));
            tbx_firm_acc_city.setText(rs.getString("contact_name"));
            tbx_firm_acc_mobile_no.setText(rs.getString("mobile_number"));
            txt_firm_account_debit.setText(rs.getString("debit"));
            txt_firm_account_credit.setText(rs.getString("credit"));

             }
       
        conn.close();
      }
     catch(SQLException | HeadlessException e)
     {
          JOptionPane.showMessageDialog(null, e);          
     }
         
            
      sql = "SELECT * FROM firm_account WHERE firm_name='" + Information.firm_name_temp_creditor + "'";
            
      try
      {
        conn = Connect.ConnectDB();
        pst = conn.prepareStatement(sql);
        rs = pst.executeQuery();
        if(rs.next()){
            
            tbx_firm_acc_firm_name.setText(rs.getString("firm_name"));
            tbx_firm_acc_contact_name.setText(rs.getString("city"));
            txtarea_firm_account_address.setText(rs.getString("address"));
            tbx_firm_acc_city.setText(rs.getString("contact_name"));
            tbx_firm_acc_mobile_no.setText(rs.getString("mobile_number"));
            txt_firm_account_debit.setText(rs.getString("debit"));
            txt_firm_account_credit.setText(rs.getString("credit"));

             }
       // if(rs.next())
       // {
       //     tbx_firm_acc_firm_name.setText("");
       //     tbx_firm_acc_city.setText("");
      //      txtarea_firm_account_address.setText("");
       //     tbx_firm_acc_contact_name.setText("");
       //     tbx_firm_acc_mobile_no.setText("");
       //     txt_firm_account_debit.setText("");
       //     txt_firm_account_credit.setText("");
        //        }
        conn.close();
      }
     catch(SQLException | HeadlessException e)
     {
          JOptionPane.showMessageDialog(null, e);          
     }
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_firm_acc_address;
    private javax.swing.JLabel lbl_firm_acc_city;
    private javax.swing.JLabel lbl_firm_acc_contact_name;
    private javax.swing.JLabel lbl_firm_acc_firm_name;
    private javax.swing.JLabel lbl_firm_acc_mobile_number;
    private javax.swing.JTextField tbx_firm_acc_city;
    private javax.swing.JTextField tbx_firm_acc_contact_name;
    private javax.swing.JTextField tbx_firm_acc_firm_name;
    private javax.swing.JTextField tbx_firm_acc_mobile_no;
    private javax.swing.JTextField txt_firm_account_credit;
    private javax.swing.JTextField txt_firm_account_debit;
    private javax.swing.JTextArea txtarea_firm_account_address;
    // End of variables declaration//GEN-END:variables
}
