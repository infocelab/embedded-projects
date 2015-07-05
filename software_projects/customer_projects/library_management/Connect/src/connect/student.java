/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connect;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author SHARMA
 */
public class student extends javax.swing.JFrame {

    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    public student() {
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

        btn_student_back = new javax.swing.JButton();
        lbl_student_std_information = new javax.swing.JLabel();
        lbl_student_branch = new javax.swing.JLabel();
        lbl_student_year = new javax.swing.JLabel();
        lbl_student_email = new javax.swing.JLabel();
        lbl_student_name = new javax.swing.JLabel();
        lbl_student_id = new javax.swing.JLabel();
        lbl_student_address = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txt_student_name = new javax.swing.JTextField();
        txt_student_email = new javax.swing.JTextField();
        txt_student_id = new javax.swing.JTextField();
        txt_student_contact_number = new javax.swing.JTextField();
        txt_student_address = new javax.swing.JTextField();
        btn_student_save = new javax.swing.JButton();
        cmbox_student_year = new javax.swing.JComboBox();
        cmbox_student_branch = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btn_student_back.setText("Back to Home Page");
        btn_student_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_student_backActionPerformed(evt);
            }
        });

        lbl_student_std_information.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbl_student_std_information.setForeground(new java.awt.Color(51, 51, 255));
        lbl_student_std_information.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_student_std_information.setText("Student Information");
        lbl_student_std_information.setBorder(new javax.swing.border.MatteBorder(null));

        lbl_student_branch.setText("Branch :");

        lbl_student_year.setText("Year :");

        lbl_student_email.setText("E-mail :");

        lbl_student_name.setText("Name :");

        lbl_student_id.setText("Student ID :");

        lbl_student_address.setText("Address :");

        jLabel8.setText("Contact Number :");

        btn_student_save.setText("Save");
        btn_student_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_student_saveActionPerformed(evt);
            }
        });

        cmbox_student_year.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "---Select---", "1", "2", "3", "4" }));

        cmbox_student_branch.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "---Select---", "Computer science", "Electronics", "Mechanical", "Information Technology" }));
        cmbox_student_branch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbox_student_branchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbl_student_id, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(76, 76, 76)
                        .addComponent(txt_student_id, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txt_student_name, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_student_address, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_student_branch, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(272, 272, 272)
                                    .addComponent(lbl_student_name, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txt_student_address, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cmbox_student_branch, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lbl_student_year, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lbl_student_email, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(txt_student_contact_number, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(4, 4, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_student_email, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbox_student_year, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(105, 105, 105))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(266, 266, 266)
                        .addComponent(lbl_student_std_information, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(275, 275, 275)
                        .addComponent(btn_student_save)
                        .addGap(121, 121, 121)
                        .addComponent(btn_student_back)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_student_std_information, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_student_name, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_student_id, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_student_name, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_student_id, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_student_email, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_student_address, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_student_email, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_student_address, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_student_contact_number, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_student_year, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbox_student_year, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_student_branch, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbox_student_branch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(68, 68, 68)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_student_save)
                    .addComponent(btn_student_back))
                .addContainerGap(136, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_student_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_student_backActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
                new Information().setVisible(true);
    }//GEN-LAST:event_btn_student_backActionPerformed

    private void cmbox_student_branchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbox_student_branchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbox_student_branchActionPerformed

    private void btn_student_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_student_saveActionPerformed
        // TODO add your handling code here:
          String sql;
        String student_id = txt_student_id.getText();
        String name = txt_student_name.getText();
        String address = txt_student_address.getText();
        String email = txt_student_email.getText();
        String contact_number = txt_student_contact_number.getText();
        String branch = cmbox_student_branch.getSelectedItem().toString();
        int year = cmbox_student_year.getSelectedIndex();
        
        if(student_id.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Student ID cannot be Empty");
            return;
        }
        if(name.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Student Name cannot be Empty");
            return;
        }
        if(address.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Address cannot be Empty");
            return;
        }
        if(email.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Email cannot be Empty");
            return;
        }
        if(contact_number.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Contact Number cannot be Empty");
            return;
        }
        if(branch.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Branch cannot be Empty");
            return;
        }
        if(year==0)
        {
            JOptionPane.showMessageDialog(null, "Year cannot be Empty");
            return;
        }
        
        
        sql = "Insert into student_information (student_id,name,address,email,contact_number,branch,year) values ('" +  student_id + "','" + name +"','" + address + "','" + email + "','" + contact_number + "','"+branch+"','"+year+ "')";
         try
      {
           conn = Connect.ConnectDB();
           pst = conn.prepareStatement(sql);
           pst.executeUpdate();
        
           txt_student_id.setText("");
           txt_student_name.setText("");
           txt_student_address.setText("");
           txt_student_email.setText("");
           txt_student_contact_number.setText("");
           cmbox_student_branch.removeAllItems();
           cmbox_student_year.removeAllItems();
           conn.close();
      }
     catch(SQLException | HeadlessException e)
     {
          JOptionPane.showMessageDialog(null, e);          
     }
        
        
    }//GEN-LAST:event_btn_student_saveActionPerformed

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
            java.util.logging.Logger.getLogger(student.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(student.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(student.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(student.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new student().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_student_back;
    private javax.swing.JButton btn_student_save;
    private javax.swing.JComboBox cmbox_student_branch;
    private javax.swing.JComboBox cmbox_student_year;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel lbl_student_address;
    private javax.swing.JLabel lbl_student_branch;
    private javax.swing.JLabel lbl_student_email;
    private javax.swing.JLabel lbl_student_id;
    private javax.swing.JLabel lbl_student_name;
    private javax.swing.JLabel lbl_student_std_information;
    private javax.swing.JLabel lbl_student_year;
    private javax.swing.JTextField txt_student_address;
    private javax.swing.JTextField txt_student_contact_number;
    private javax.swing.JTextField txt_student_email;
    private javax.swing.JTextField txt_student_id;
    private javax.swing.JTextField txt_student_name;
    // End of variables declaration//GEN-END:variables
}
