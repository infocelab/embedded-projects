

package criminal_identification;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Icon;
import javax.swing.ImageIcon;


public class criminal_eyes extends javax.swing.JFrame {

    List list_eye = new ArrayList();
    
    
    public criminal_eyes() {
        initComponents();
        list_eye.add("/criminal_identification/newpackage/eye/eye1.jpg");
        list_eye.add("/criminal_identification/newpackage/eye/eye2.jpg");
        list_eye.add("/criminal_identification/newpackage/eye/eye3.jpg");
        list_eye.add("/criminal_identification/newpackage/eye/eye4.jpg");
        list_eye.add("/criminal_identification/newpackage/eye/eye5.jpg");

        ImageIcon imageIcon = new javax.swing.ImageIcon(getClass().getResource(list_eye.get(0).toString()));
        Image image = imageIcon.getImage(); // transform it 
        Image newimg = image.getScaledInstance(200, 60,  java.awt.Image.SCALE_SMOOTH); 
        imageIcon = new ImageIcon(newimg);
        lbl_criminal_eyes_click_eye1.setIcon(imageIcon);
        lbl_criminal_eyes_click_eye1.setText("");
        
        imageIcon = new javax.swing.ImageIcon(getClass().getResource(list_eye.get(1).toString()));
        image = imageIcon.getImage(); // transform it 
        newimg = image.getScaledInstance(200, 60,   java.awt.Image.SCALE_SMOOTH); 
        imageIcon= new ImageIcon(newimg);
        lbl_criminal_eyes_click_eye2.setIcon(imageIcon);
        lbl_criminal_eyes_click_eye2.setText("");
        
        imageIcon = new javax.swing.ImageIcon(getClass().getResource(list_eye.get(2).toString()));
        image = imageIcon.getImage(); // transform it 
        newimg = image.getScaledInstance(200, 60,   java.awt.Image.SCALE_SMOOTH); 
        imageIcon = new ImageIcon(newimg);
        lbl_criminal_eyes_click_eye3.setIcon(imageIcon);
        lbl_criminal_eyes_click_eye3.setText("");
        
        imageIcon = new javax.swing.ImageIcon(getClass().getResource(list_eye.get(3).toString()));
        image = imageIcon.getImage(); // transform it 
        newimg = image.getScaledInstance(200, 60,  java.awt.Image.SCALE_SMOOTH); 
        imageIcon = new ImageIcon(newimg);
        lbl_criminal_eyes_click_eye4.setIcon(imageIcon);
        lbl_criminal_eyes_click_eye4.setText("");
        
        imageIcon = new javax.swing.ImageIcon(getClass().getResource(list_eye.get(4).toString()));
        image = imageIcon.getImage(); // transform it 
        newimg = image.getScaledInstance(200, 60,   java.awt.Image.SCALE_SMOOTH); 
        imageIcon = new ImageIcon(newimg);
        lbl_criminal_eyes_click_eye5.setIcon(imageIcon);
        lbl_criminal_eyes_click_eye5.setText("");
     
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_criminal_eyes_click_eye1 = new javax.swing.JLabel();
        lbl_criminal_eyes_click_eye2 = new javax.swing.JLabel();
        lbl_criminal_eyes_click_eye3 = new javax.swing.JLabel();
        lbl_criminal_eyes_click_eye4 = new javax.swing.JLabel();
        lbl_criminal_eyes_click_eye5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lbl_criminal_eyes_click_eye1.setText("jLabel1");
        lbl_criminal_eyes_click_eye1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_criminal_eyes_click_eye1MouseClicked(evt);
            }
        });

        lbl_criminal_eyes_click_eye2.setText("jLabel2");
        lbl_criminal_eyes_click_eye2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_criminal_eyes_click_eye2MouseClicked(evt);
            }
        });

        lbl_criminal_eyes_click_eye3.setText("jLabel3");
        lbl_criminal_eyes_click_eye3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_criminal_eyes_click_eye3MouseClicked(evt);
            }
        });

        lbl_criminal_eyes_click_eye4.setText("jLabel4");
        lbl_criminal_eyes_click_eye4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_criminal_eyes_click_eye4MouseClicked(evt);
            }
        });

        lbl_criminal_eyes_click_eye5.setText("jLabel5");
        lbl_criminal_eyes_click_eye5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_criminal_eyes_click_eye5MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_criminal_eyes_click_eye5)
                    .addComponent(lbl_criminal_eyes_click_eye3)
                    .addComponent(lbl_criminal_eyes_click_eye1)
                    .addComponent(lbl_criminal_eyes_click_eye4)
                    .addComponent(lbl_criminal_eyes_click_eye2))
                .addContainerGap(225, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_criminal_eyes_click_eye1)
                .addGap(26, 26, 26)
                .addComponent(lbl_criminal_eyes_click_eye2)
                .addGap(18, 18, 18)
                .addComponent(lbl_criminal_eyes_click_eye3)
                .addGap(18, 18, 18)
                .addComponent(lbl_criminal_eyes_click_eye4)
                .addGap(18, 18, 18)
                .addComponent(lbl_criminal_eyes_click_eye5)
                .addContainerGap(247, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lbl_criminal_eyes_click_eye1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_criminal_eyes_click_eye1MouseClicked
     //Image eye = getIconImage();
        criminal_identification.eye_ImageIcon=lbl_criminal_eyes_click_eye1.getIcon();
        criminal_identification.eye="eye1";
        this.setVisible(false);
    }//GEN-LAST:event_lbl_criminal_eyes_click_eye1MouseClicked

    private void lbl_criminal_eyes_click_eye2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_criminal_eyes_click_eye2MouseClicked
       criminal_identification.eye_ImageIcon=lbl_criminal_eyes_click_eye2.getIcon();
       criminal_identification.eye="eye2";
        this.setVisible(false);
        
    }//GEN-LAST:event_lbl_criminal_eyes_click_eye2MouseClicked

    private void lbl_criminal_eyes_click_eye3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_criminal_eyes_click_eye3MouseClicked
        criminal_identification.eye_ImageIcon=lbl_criminal_eyes_click_eye3.getIcon();
        criminal_identification.eye="eye3";
        this.setVisible(false);
    }//GEN-LAST:event_lbl_criminal_eyes_click_eye3MouseClicked

    private void lbl_criminal_eyes_click_eye4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_criminal_eyes_click_eye4MouseClicked
       criminal_identification.eye_ImageIcon=lbl_criminal_eyes_click_eye4.getIcon();
       criminal_identification.eye="eye4"; 
       this.setVisible(false);
    }//GEN-LAST:event_lbl_criminal_eyes_click_eye4MouseClicked

    private void lbl_criminal_eyes_click_eye5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_criminal_eyes_click_eye5MouseClicked
       criminal_identification.eye_ImageIcon=lbl_criminal_eyes_click_eye5.getIcon();
       criminal_identification.eye="eye5";
        this.setVisible(false);
    }//GEN-LAST:event_lbl_criminal_eyes_click_eye5MouseClicked

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
            java.util.logging.Logger.getLogger(criminal_eyes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(criminal_eyes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(criminal_eyes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(criminal_eyes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new criminal_eyes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lbl_criminal_eyes_click_eye1;
    private javax.swing.JLabel lbl_criminal_eyes_click_eye2;
    private javax.swing.JLabel lbl_criminal_eyes_click_eye3;
    private javax.swing.JLabel lbl_criminal_eyes_click_eye4;
    private javax.swing.JLabel lbl_criminal_eyes_click_eye5;
    // End of variables declaration//GEN-END:variables
}
