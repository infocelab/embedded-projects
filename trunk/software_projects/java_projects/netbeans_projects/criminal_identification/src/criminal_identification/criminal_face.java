
package criminal_identification;

import static criminal_identification.criminal_identification.eye;
import static criminal_identification.criminal_identification.face;
import static criminal_identification.criminal_identification.hair;
import static criminal_identification.criminal_identification.mouth;
import static criminal_identification.criminal_identification.nose;
import java.awt.HeadlessException;
import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class criminal_face extends javax.swing.JFrame {

   Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    List list_face = new ArrayList();
    
    public criminal_face() {
        initComponents();
        list_face.add("/criminal_identification/newpackage/face/face1.jpg");
        list_face.add("/criminal_identification/newpackage/face/face2.jpg");
        list_face.add("/criminal_identification/newpackage/face/face3.jpg");
        list_face.add("/criminal_identification/newpackage/face/face4.jpg");
        list_face.add("/criminal_identification/newpackage/face/face5.jpg");
        
         int [] face={0,0,0,0,0,0};
        face[0]=0;
        face[1]=0;
        face[2]=0;
        face[3]=0;
        face[4]=0;
        face[5]=0;
        
        //for matching hair
        
        String sql = "SELECT * FROM criminal where hair ='" +hair+ "'";
        try
        {
            conn = Connect.ConnectDB();
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            if(rs.next())
            {
                
               Object row[]={ rs.getString("face")};
               if(row[0].equals("face1"))
                   face[1]+=10;
               else if(row[0].equals("face2"))
                   face[2]+=10;
               else if(row[0].equals("face3"))
                   face[3]+=10;
               else if(row[0].equals("face4"))
                   face[4]+=10;
               else if(row[0].equals("face5"))
                   face[5]+=10;
            }
            conn.close();
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, e);          
        } 
        
        //for matching the eye
        
        sql = "SELECT * FROM criminal where eye ='" +eye+ "'";
        try
        {
            conn = Connect.ConnectDB();
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            if(rs.next())
            {
                
               Object row[]={ rs.getString("face")};
               if(row[0].equals("face1"))
                   face[1]+=10;
               else if(row[0].equals("face2"))
                   face[2]+=10;
               else if(row[0].equals("face3"))
                   face[3]+=10;
               else if(row[0].equals("face4"))
                   face[4]+=10;
               else if(row[0].equals("face5"))
                   face[5]+=10;
            }
            conn.close();
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, e);          
        } 
        
        //for matching the nose
        
        sql = "SELECT * FROM criminal where nose ='" +nose+ "'";
        try
        {
            conn = Connect.ConnectDB();
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            if(rs.next())
            {
                
               Object row[]={ rs.getString("face")};
               if(row[0].equals("face1"))
                   face[1]+=10;
               else if(row[0].equals("face2"))
                   face[2]+=10;
               else if(row[0].equals("face3"))
                   face[3]+=10;
               else if(row[0].equals("face4"))
                   face[4]+=10;
               else if(row[0].equals("face5"))
                   face[5]+=10;
            }
            conn.close();
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, e);          
        } 
        //for matching the mouth
        
        sql = "SELECT * FROM criminal where mouth ='" +mouth+ "'";
        try
        {
            conn = Connect.ConnectDB();
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            if(rs.next())
            {
                
               Object row[]={ rs.getString("face")};
               if(row[0].equals("face1"))
                   face[1]+=10;
               else if(row[0].equals("face2"))
                   face[2]+=10;
               else if(row[0].equals("face3"))
                   face[3]+=10;
               else if(row[0].equals("face4"))
                   face[4]+=10;
               else if(row[0].equals("face5"))
                   face[5]+=10;
            }
            conn.close();
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, e);          
        } 
        
       // int max=((face[1]>face[2])&&(face[1]>face[3])&&(face[1]>face[4])&&(face[1]>face[5]))?face[1]:(((face[2]>face[5])&&(face[2]>face[3])&&(face[2]>face[4]))?face[2]:(face[3]>face[4])&&(face[3]>face[5])?face[3]:(face[3]>face[4])?face[4]:face[5]);
        int large=face[1];
        int index=1;
        for(int i=1;i<5;i++)
        {
            if(face[i+1] > large)
            {
               large=face[i+1];
               index=i+1;
            }
        }       
        ImageIcon imageIcon = new javax.swing.ImageIcon(getClass().getResource(list_face.get(index-1).toString()));
        Image image = imageIcon.getImage(); // transform it 
        Image newimg = image.getScaledInstance(300, 250,  java.awt.Image.SCALE_SMOOTH); 
        imageIcon = new ImageIcon(newimg);
        lbl_criminal_iden_match_result.setIcon(imageIcon);
        lbl_criminal_iden_match_result.setText("");
        int c=index;
         sql = "SELECT * FROM details WHERE face='face"+c+"'";
            
            try
            {
                conn = Connect.ConnectDB();
                pst = conn.prepareStatement(sql);
                rs = pst.executeQuery();
                if(rs.next())
                {
                    txt_criminal_face_name.setText(rs.getString("name"));
                    txt_criminal_face_age.setText(rs.getString("age"));
                    txt_criminal_face_address.setText(rs.getString("address"));
                    txt_criminal_face_crime.setText(rs.getString("crime"));
                   
                }
                conn.close();
            }
            catch(SQLException | HeadlessException e)
            {
                JOptionPane.showMessageDialog(null, e);          
            }
            txt_criminal_face_name.setEditable(false);
            txt_criminal_face_age.setEditable(false);
            txt_criminal_face_address.setEditable(false);
            txt_criminal_face_crime.setEditable(false);
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_criminal_iden_match_result = new javax.swing.JLabel();
        btn_criminal_face_ok = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_criminal_face_name = new javax.swing.JTextField();
        txt_criminal_face_age = new javax.swing.JTextField();
        txt_criminal_face_address = new javax.swing.JTextField();
        txt_criminal_face_crime = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(127, 201, 164));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                formMouseEntered(evt);
            }
        });

        lbl_criminal_iden_match_result.setText("jLabel1");

        btn_criminal_face_ok.setText("OK");
        btn_criminal_face_ok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_criminal_face_okActionPerformed(evt);
            }
        });

        jLabel1.setText("Criminal Name :");

        jLabel2.setText("Age :");

        jLabel3.setText("Address :");

        jLabel4.setText("Crime :");

        txt_criminal_face_name.setBackground(new java.awt.Color(139, 197, 197));

        txt_criminal_face_age.setBackground(new java.awt.Color(139, 197, 197));

        txt_criminal_face_address.setBackground(new java.awt.Color(139, 197, 197));

        txt_criminal_face_crime.setBackground(new java.awt.Color(139, 197, 197));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(93, 93, 93)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txt_criminal_face_name, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_criminal_face_age, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_criminal_face_address, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_criminal_face_crime, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lbl_criminal_iden_match_result, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addComponent(btn_criminal_face_ok, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lbl_criminal_iden_match_result)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 241, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_criminal_face_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_criminal_face_age, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_criminal_face_address, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_criminal_face_crime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_criminal_face_ok)
                .addGap(32, 32, 32))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseEntered
       
       
    }//GEN-LAST:event_formMouseEntered

    private void btn_criminal_face_okActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_criminal_face_okActionPerformed
        
        this.setVisible(false);
        new criminal_identification().setVisible(true);
    }//GEN-LAST:event_btn_criminal_face_okActionPerformed

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
            java.util.logging.Logger.getLogger(criminal_face.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(criminal_face.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(criminal_face.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(criminal_face.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new criminal_face().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_criminal_face_ok;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lbl_criminal_iden_match_result;
    private javax.swing.JTextField txt_criminal_face_address;
    private javax.swing.JTextField txt_criminal_face_age;
    private javax.swing.JTextField txt_criminal_face_crime;
    private javax.swing.JTextField txt_criminal_face_name;
    // End of variables declaration//GEN-END:variables
}
