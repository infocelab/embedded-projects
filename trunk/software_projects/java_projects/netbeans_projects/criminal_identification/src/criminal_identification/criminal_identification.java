
package criminal_identification;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Icon;

/**
 *
 * @author SHARMA
 */
public class criminal_identification extends javax.swing.JFrame {
public static Icon eye_ImageIcon=null;
public static Icon nose_ImageIcon=null;
public static Icon mouth_ImageIcon=null;
public static Icon hair_ImageIcon=null;
public static Icon face_ImageIcon=null;
  List list_face = new ArrayList();
 static String criminal_details_temp="";

public static String eye="";
public static String hair="";
public static String nose="";
public static String mouth="";
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    

    public criminal_identification() {
        initComponents();
                
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_criminal_iden_search_by_eye = new javax.swing.JButton();
        lbl_criminal_iden_set_eye = new javax.swing.JLabel();
        btn_criminal_iden_search_by_nose = new javax.swing.JButton();
        btn_criminal_iden_search_by_mouth = new javax.swing.JButton();
        btn_criminal_iden_search_by_hair = new javax.swing.JButton();
        lbl_criminal_iden_set_nose = new javax.swing.JLabel();
        lbl_criminal_iden_set_mouth = new javax.swing.JLabel();
        lbl_criminal_iden_set_hair = new javax.swing.JLabel();
        btn_criminal_iden_match = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(735, 502));
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

        btn_criminal_iden_search_by_eye.setText("Choose Eye");
        btn_criminal_iden_search_by_eye.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_criminal_iden_search_by_eyeActionPerformed(evt);
            }
        });

        lbl_criminal_iden_set_eye.setText("jLabel2");

        btn_criminal_iden_search_by_nose.setText("Choose Nose");
        btn_criminal_iden_search_by_nose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_criminal_iden_search_by_noseActionPerformed(evt);
            }
        });

        btn_criminal_iden_search_by_mouth.setText("Choose Mouth");
        btn_criminal_iden_search_by_mouth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_criminal_iden_search_by_mouthActionPerformed(evt);
            }
        });

        btn_criminal_iden_search_by_hair.setText("Choose Hair");
        btn_criminal_iden_search_by_hair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_criminal_iden_search_by_hairActionPerformed(evt);
            }
        });

        lbl_criminal_iden_set_nose.setText("jLabel1");

        lbl_criminal_iden_set_mouth.setText("jLabel1");

        lbl_criminal_iden_set_hair.setText("jLabel1");

        btn_criminal_iden_match.setText("Match With Other Criminals");
        btn_criminal_iden_match.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_criminal_iden_matchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_criminal_iden_search_by_hair, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55)
                        .addComponent(btn_criminal_iden_search_by_eye, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                        .addComponent(btn_criminal_iden_search_by_nose, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lbl_criminal_iden_set_hair))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_criminal_iden_set_eye, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbl_criminal_iden_set_nose, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addGap(65, 65, 65)
                .addComponent(btn_criminal_iden_search_by_mouth, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lbl_criminal_iden_set_mouth)
                .addGap(237, 237, 237))
            .addGroup(layout.createSequentialGroup()
                .addGap(262, 262, 262)
                .addComponent(btn_criminal_iden_match)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_criminal_iden_search_by_hair)
                    .addComponent(btn_criminal_iden_search_by_eye)
                    .addComponent(btn_criminal_iden_search_by_nose)
                    .addComponent(btn_criminal_iden_search_by_mouth))
                .addGap(45, 45, 45)
                .addComponent(lbl_criminal_iden_set_hair)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_criminal_iden_set_eye)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_criminal_iden_set_nose)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_criminal_iden_set_mouth)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 277, Short.MAX_VALUE)
                .addComponent(btn_criminal_iden_match)
                .addGap(38, 38, 38))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_criminal_iden_search_by_eyeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_criminal_iden_search_by_eyeActionPerformed
       new criminal_eyes().setVisible(true);
    }//GEN-LAST:event_btn_criminal_iden_search_by_eyeActionPerformed

    private void formFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusGained
         lbl_criminal_iden_set_eye.setIcon(eye_ImageIcon);
    }//GEN-LAST:event_formFocusGained

    private void formMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseEntered
     lbl_criminal_iden_set_eye.setIcon(eye_ImageIcon);
     lbl_criminal_iden_set_eye.setText("");
     
     lbl_criminal_iden_set_nose.setIcon(nose_ImageIcon);
     lbl_criminal_iden_set_nose.setText("");
     
     lbl_criminal_iden_set_mouth.setIcon(mouth_ImageIcon);
     lbl_criminal_iden_set_mouth.setText("");
     
     lbl_criminal_iden_set_hair.setIcon(hair_ImageIcon);
     lbl_criminal_iden_set_hair.setText("");
    }//GEN-LAST:event_formMouseEntered

    private void btn_criminal_iden_search_by_noseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_criminal_iden_search_by_noseActionPerformed
        new criminal_nose().setVisible(true);
    }//GEN-LAST:event_btn_criminal_iden_search_by_noseActionPerformed

    private void btn_criminal_iden_search_by_mouthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_criminal_iden_search_by_mouthActionPerformed
        new criminal_mouth().setVisible(true);
    }//GEN-LAST:event_btn_criminal_iden_search_by_mouthActionPerformed

    private void btn_criminal_iden_search_by_hairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_criminal_iden_search_by_hairActionPerformed
         new criminal_hair().setVisible(true);
    }//GEN-LAST:event_btn_criminal_iden_search_by_hairActionPerformed

    private void btn_criminal_iden_matchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_criminal_iden_matchActionPerformed
    //criminal_details_temp=list_face.toString();
        new criminal_face().setVisible(true);
        
      
    }//GEN-LAST:event_btn_criminal_iden_matchActionPerformed

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
            java.util.logging.Logger.getLogger(criminal_identification.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(criminal_identification.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(criminal_identification.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(criminal_identification.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new criminal_identification().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_criminal_iden_match;
    private javax.swing.JButton btn_criminal_iden_search_by_eye;
    private javax.swing.JButton btn_criminal_iden_search_by_hair;
    private javax.swing.JButton btn_criminal_iden_search_by_mouth;
    private javax.swing.JButton btn_criminal_iden_search_by_nose;
    private javax.swing.JLabel lbl_criminal_iden_set_eye;
    private javax.swing.JLabel lbl_criminal_iden_set_hair;
    private javax.swing.JLabel lbl_criminal_iden_set_mouth;
    private javax.swing.JLabel lbl_criminal_iden_set_nose;
    // End of variables declaration//GEN-END:variables
}
