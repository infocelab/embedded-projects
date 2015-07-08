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
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author SHARMA
 */
public class Borrow extends javax.swing.JFrame {

    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    public Borrow() {
        initComponents();
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_borrow_back = new javax.swing.JButton();
        lbl_borrow_books = new javax.swing.JLabel();
        lbl_borrow_student_id = new javax.swing.JLabel();
        lbl_borrow_book_id = new javax.swing.JLabel();
        btn_borrow_borrow = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_borrow = new javax.swing.JTable();
        txt_borrow_book_id = new javax.swing.JTextField();
        txt_borrow_std_id = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btn_borrow_back.setText("Back to Home Page");
        btn_borrow_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_borrow_backActionPerformed(evt);
            }
        });

        lbl_borrow_books.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbl_borrow_books.setForeground(new java.awt.Color(51, 51, 255));
        lbl_borrow_books.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_borrow_books.setText("Borrow Books");
        lbl_borrow_books.setBorder(new javax.swing.border.MatteBorder(null));

        lbl_borrow_student_id.setText("Student ID :");

        lbl_borrow_book_id.setText("Book ID :");

        btn_borrow_borrow.setText("Borrow");
        btn_borrow_borrow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_borrow_borrowActionPerformed(evt);
            }
        });

        tbl_borrow.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student ID", "Book ID", "Date"
            }
        ));
        jScrollPane1.setViewportView(tbl_borrow);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 56, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 674, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btn_borrow_borrow)
                        .addGap(350, 350, 350))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(287, 287, 287)
                        .addComponent(btn_borrow_back))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(234, 234, 234)
                        .addComponent(lbl_borrow_books, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addComponent(lbl_borrow_student_id)
                        .addGap(62, 62, 62)
                        .addComponent(txt_borrow_std_id, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(66, 66, 66)
                        .addComponent(lbl_borrow_book_id)
                        .addGap(79, 79, 79)
                        .addComponent(txt_borrow_book_id, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_borrow_books, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_borrow_student_id)
                    .addComponent(txt_borrow_std_id, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_borrow_book_id, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_borrow_book_id))
                .addGap(52, 52, 52)
                .addComponent(btn_borrow_borrow)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_borrow_back)
                .addGap(32, 32, 32))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_borrow_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_borrow_backActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
                new Information().setVisible(true);
    }//GEN-LAST:event_btn_borrow_backActionPerformed

    private void btn_borrow_borrowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_borrow_borrowActionPerformed
        // TODO add your handling code here:
        
        String student_id = txt_borrow_std_id.getText();
        String book_id = txt_borrow_book_id.getText();
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
        sql = "Insert into borrow (student_id,book_id,date) values ('" +  student_id + "','" + book_id + "','" + date + "')";
            
        try
        {
           conn = Connect.ConnectDB();
           pst = conn.prepareStatement(sql);
           pst.executeUpdate();
        
           //JOptionPane.showMessageDialog(null, "saved");
           txt_borrow_std_id.setText("");
           txt_borrow_book_id.setText("");
            
           
           conn.close();
        }
        catch(SQLException | HeadlessException e)
        {
          JOptionPane.showMessageDialog(null, e);          
        }
        
        DefaultTableModel model = (DefaultTableModel) tbl_borrow.getModel();
        model.addRow(row);
        
    }//GEN-LAST:event_btn_borrow_borrowActionPerformed

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
            java.util.logging.Logger.getLogger(Borrow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Borrow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Borrow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Borrow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Borrow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_borrow_back;
    private javax.swing.JButton btn_borrow_borrow;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_borrow_book_id;
    private javax.swing.JLabel lbl_borrow_books;
    private javax.swing.JLabel lbl_borrow_student_id;
    private javax.swing.JTable tbl_borrow;
    private javax.swing.JTextField txt_borrow_book_id;
    private javax.swing.JTextField txt_borrow_std_id;
    // End of variables declaration//GEN-END:variables
}
