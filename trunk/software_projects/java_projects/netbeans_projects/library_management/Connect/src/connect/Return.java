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
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author SHARMA
 */
public class Return extends javax.swing.JFrame {

   Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    public Return() {
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

        btn_return_back = new javax.swing.JButton();
        lbl_return_books = new javax.swing.JLabel();
        lbl_return_student_id = new javax.swing.JLabel();
        lbl_return_book_id = new javax.swing.JLabel();
        btn_return_return = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_return = new javax.swing.JTable();
        txt_return_std_id = new javax.swing.JTextField();
        txt_return_book_id = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btn_return_back.setText("Back to Home Page");
        btn_return_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_return_backActionPerformed(evt);
            }
        });

        lbl_return_books.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbl_return_books.setForeground(new java.awt.Color(51, 51, 255));
        lbl_return_books.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_return_books.setText("Return Books");
        lbl_return_books.setBorder(new javax.swing.border.MatteBorder(null));

        lbl_return_student_id.setText("Student ID :");

        lbl_return_book_id.setText("Book ID :");

        btn_return_return.setText("Return");
        btn_return_return.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_return_returnActionPerformed(evt);
            }
        });

        tbl_return.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student ID", "Book ID", "Date "
            }
        ));
        jScrollPane1.setViewportView(tbl_return);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 48, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 674, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
            .addGroup(layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(lbl_return_student_id)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(lbl_return_books, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(txt_return_std_id, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(85, 85, 85)
                        .addComponent(lbl_return_book_id)
                        .addGap(51, 51, 51)
                        .addComponent(txt_return_book_id, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(303, 303, 303)
                        .addComponent(btn_return_back))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(321, 321, 321)
                        .addComponent(btn_return_return)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_return_books, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_return_student_id)
                    .addComponent(lbl_return_book_id)
                    .addComponent(txt_return_std_id, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_return_book_id, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addComponent(btn_return_return)
                .addGap(51, 51, 51)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btn_return_back)
                .addGap(38, 38, 38))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_return_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_return_backActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
                new Information().setVisible(true);
    }//GEN-LAST:event_btn_return_backActionPerformed

    private void btn_return_returnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_return_returnActionPerformed
        // TODO add your handling code here:
        String student_id = txt_return_std_id.getText();
        String book_id = txt_return_book_id.getText();
        if(student_id.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Student ID Cannot be Empty"); 
            return;
        }
        if(book_id.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Book ID Cannot be Empty"); 
            return;
        }
        Date today = new Date();
        SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy");
        String date = DATE_FORMAT.format(today);
        
        Object row[]={student_id, book_id, date};
        
        String sql;
        sql = "Insert into return (student_id,book_id,date) values ('" +  student_id + "','" + book_id + "','" + date + "')";
            
        try
        {
           conn = Connect.ConnectDB();
           pst = conn.prepareStatement(sql);
           pst.executeUpdate();
        
           //JOptionPane.showMessageDialog(null, "saved");
           txt_return_std_id.setText("");
           txt_return_book_id.setText("");
            
           
           conn.close();
        }
        catch(SQLException | HeadlessException e)
        {
          JOptionPane.showMessageDialog(null, e);          
        }
        
        DefaultTableModel model = (DefaultTableModel) tbl_return.getModel();
        model.addRow(row);
        
    }//GEN-LAST:event_btn_return_returnActionPerformed

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
            java.util.logging.Logger.getLogger(Return.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Return.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Return.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Return.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Return().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_return_back;
    private javax.swing.JButton btn_return_return;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_return_book_id;
    private javax.swing.JLabel lbl_return_books;
    private javax.swing.JLabel lbl_return_student_id;
    private javax.swing.JTable tbl_return;
    private javax.swing.JTextField txt_return_book_id;
    private javax.swing.JTextField txt_return_std_id;
    // End of variables declaration//GEN-END:variables
}