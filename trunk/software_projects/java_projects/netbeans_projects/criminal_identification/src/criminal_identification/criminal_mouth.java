
package criminal_identification;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;

public class criminal_mouth extends javax.swing.JFrame {

   List list_mouth = new ArrayList();
   
    public criminal_mouth() {
        initComponents();
        list_mouth.add("/criminal_identification/newpackage/mouth/mouth1.jpg");
        list_mouth.add("/criminal_identification/newpackage/mouth/mouth2.jpg");
        list_mouth.add("/criminal_identification/newpackage/mouth/mouth3.jpg");
        list_mouth.add("/criminal_identification/newpackage/mouth/mouth4.jpg");
        list_mouth.add("/criminal_identification/newpackage/mouth/mouth5.jpg");
       

        ImageIcon imageIcon = new javax.swing.ImageIcon(getClass().getResource(list_mouth.get(0).toString()));
        Image image = imageIcon.getImage(); // transform it 
        Image newimg = image.getScaledInstance(170, 70,  java.awt.Image.SCALE_SMOOTH); 
        imageIcon = new ImageIcon(newimg);
        lbl_criminal_mouth_choose1.setIcon(imageIcon);
        lbl_criminal_mouth_choose1.setText("");
        
        imageIcon = new javax.swing.ImageIcon(getClass().getResource(list_mouth.get(1).toString()));
        image = imageIcon.getImage(); // transform it 
        newimg = image.getScaledInstance(170, 70,   java.awt.Image.SCALE_SMOOTH); 
        imageIcon= new ImageIcon(newimg);
        lbl_criminal_mouth_choose2.setIcon(imageIcon);
        lbl_criminal_mouth_choose2.setText("");
        
        imageIcon = new javax.swing.ImageIcon(getClass().getResource(list_mouth.get(2).toString()));
        image = imageIcon.getImage(); // transform it 
        newimg = image.getScaledInstance(170, 70,   java.awt.Image.SCALE_SMOOTH); 
        imageIcon = new ImageIcon(newimg);
        lbl_criminal_mouth_choose3.setIcon(imageIcon);
        lbl_criminal_mouth_choose3.setText("");
        
        imageIcon = new javax.swing.ImageIcon(getClass().getResource(list_mouth.get(3).toString()));
        image = imageIcon.getImage(); // transform it 
        newimg = image.getScaledInstance(170, 70,  java.awt.Image.SCALE_SMOOTH); 
        imageIcon = new ImageIcon(newimg);
        lbl_criminal_mouth_choose4.setIcon(imageIcon);
        lbl_criminal_mouth_choose4.setText("");
     
        imageIcon = new javax.swing.ImageIcon(getClass().getResource(list_mouth.get(4).toString()));
        image = imageIcon.getImage(); // transform it 
        newimg = image.getScaledInstance(170, 70,  java.awt.Image.SCALE_SMOOTH); 
        imageIcon = new ImageIcon(newimg);
        lbl_criminal_mouth_choose5.setIcon(imageIcon);
        lbl_criminal_mouth_choose5.setText("");
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_criminal_mouth_choose1 = new javax.swing.JLabel();
        lbl_criminal_mouth_choose2 = new javax.swing.JLabel();
        lbl_criminal_mouth_choose3 = new javax.swing.JLabel();
        lbl_criminal_mouth_choose4 = new javax.swing.JLabel();
        lbl_criminal_mouth_choose5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lbl_criminal_mouth_choose1.setText("jLabel1");
        lbl_criminal_mouth_choose1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_criminal_mouth_choose1MouseClicked(evt);
            }
        });

        lbl_criminal_mouth_choose2.setText("jLabel2");
        lbl_criminal_mouth_choose2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_criminal_mouth_choose2MouseClicked(evt);
            }
        });

        lbl_criminal_mouth_choose3.setText("jLabel3");
        lbl_criminal_mouth_choose3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_criminal_mouth_choose3MouseClicked(evt);
            }
        });

        lbl_criminal_mouth_choose4.setText("jLabel4");
        lbl_criminal_mouth_choose4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_criminal_mouth_choose4MouseClicked(evt);
            }
        });

        lbl_criminal_mouth_choose5.setText("jLabel5");
        lbl_criminal_mouth_choose5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_criminal_mouth_choose5MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_criminal_mouth_choose5)
                    .addComponent(lbl_criminal_mouth_choose4)
                    .addComponent(lbl_criminal_mouth_choose3)
                    .addComponent(lbl_criminal_mouth_choose2)
                    .addComponent(lbl_criminal_mouth_choose1))
                .addContainerGap(241, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_criminal_mouth_choose1)
                .addGap(18, 18, 18)
                .addComponent(lbl_criminal_mouth_choose2)
                .addGap(18, 18, 18)
                .addComponent(lbl_criminal_mouth_choose3)
                .addGap(18, 18, 18)
                .addComponent(lbl_criminal_mouth_choose4)
                .addGap(18, 18, 18)
                .addComponent(lbl_criminal_mouth_choose5)
                .addContainerGap(240, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lbl_criminal_mouth_choose1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_criminal_mouth_choose1MouseClicked
        criminal_identification.mouth_ImageIcon=lbl_criminal_mouth_choose1.getIcon();
        criminal_identification.mouth="mouth1";
        this.setVisible(false);
    }//GEN-LAST:event_lbl_criminal_mouth_choose1MouseClicked

    private void lbl_criminal_mouth_choose2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_criminal_mouth_choose2MouseClicked
        criminal_identification.mouth_ImageIcon=lbl_criminal_mouth_choose2.getIcon();
        criminal_identification.mouth="mouth2";
        this.setVisible(false);    }//GEN-LAST:event_lbl_criminal_mouth_choose2MouseClicked

    private void lbl_criminal_mouth_choose3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_criminal_mouth_choose3MouseClicked
        criminal_identification.mouth_ImageIcon=lbl_criminal_mouth_choose3.getIcon();
        criminal_identification.mouth="mouth3";
        this.setVisible(false);
    }//GEN-LAST:event_lbl_criminal_mouth_choose3MouseClicked

    private void lbl_criminal_mouth_choose4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_criminal_mouth_choose4MouseClicked
        criminal_identification.mouth_ImageIcon=lbl_criminal_mouth_choose4.getIcon();
        criminal_identification.mouth="mouth4";
        this.setVisible(false);
    }//GEN-LAST:event_lbl_criminal_mouth_choose4MouseClicked

    private void lbl_criminal_mouth_choose5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_criminal_mouth_choose5MouseClicked
       criminal_identification.mouth_ImageIcon=lbl_criminal_mouth_choose5.getIcon();
       criminal_identification.mouth="mouth5";
        this.setVisible(false);
    }//GEN-LAST:event_lbl_criminal_mouth_choose5MouseClicked

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
            java.util.logging.Logger.getLogger(criminal_mouth.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(criminal_mouth.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(criminal_mouth.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(criminal_mouth.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new criminal_mouth().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lbl_criminal_mouth_choose1;
    private javax.swing.JLabel lbl_criminal_mouth_choose2;
    private javax.swing.JLabel lbl_criminal_mouth_choose3;
    private javax.swing.JLabel lbl_criminal_mouth_choose4;
    private javax.swing.JLabel lbl_criminal_mouth_choose5;
    // End of variables declaration//GEN-END:variables
}
