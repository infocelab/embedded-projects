package connect;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.util.Timer;
import java.util.TimerTask;
public class ConnectGUI extends javax.swing.JFrame 
{
   public static int T_FONT_SIZE = 220;
  public static int d1 = 5;
  public static int d2 = 5;
   public static int ans = 5;
  public static int oper = 1;
    public static int range = 1;
     public static int time = 5;
public static int disp = 0;
  Random rand; // = new Random(System.currentTimeMillis());

   Timer timer ; 
   JFrame frame=null;
    class RemindTask extends TimerTask {
    public void run() {
        //frame.setVisible(false);
        if(disp == 0)
        {
        d1 = rand.nextInt((int) Math.pow(10,range));
    
        d2 = rand.nextInt((int) Math.pow(10,range));
        }
        //frame.setVisible(true);
        frame.repaint();
    }
  }

   public class OvalPanelCanvas extends JPanel {
  public OvalPanelCanvas() {
  }
  public void paintComponent(Graphics g) {
    int width = getWidth();
    int height = getHeight();
    g.setColor(Color.black);
    //g.drawOval(0, 0, width, height);
    g.setColor(Color.MAGENTA);
    g.setFont(new Font("TimesRoman", Font.PLAIN, T_FONT_SIZE)); 
    int w=50;
     
         g.drawString( String.valueOf(d1), w , height/2);
         w = w+ T_FONT_SIZE;
         String opr = "";
         if(oper == 1)
         {
             opr = "+";
             ans = d1 + d2;
         }
         else if(oper == 2)
         {
             opr = "-";
             ans = d1 - d2;
         }
         else if(oper == 3)
         {
             opr = "*";
             ans = d1 * d2;
         }
         else if(oper == 4)
         {
             opr = "/";
             ans = d1 / d2;
         }
         
         g.drawString(opr, w , height/2);
         w = w+ T_FONT_SIZE;
         g.drawString(String.valueOf(d2), w , height/2);
         w = w+ T_FONT_SIZE;
        if(disp == 0)
        {
            disp = 1;
        }
        else if(disp == 1)
        {
            w=50;
            g.drawString("=", w , height/2 + 200);
         w = w+ T_FONT_SIZE;
          g.drawString(String.valueOf(ans), w , height/2 + 200);
          disp=0;
        }
         
        
        }
    
}
    public ConnectGUI() 
    {
        initComponents(); 
        rand = new Random(System.currentTimeMillis());
        
        this.getRootPane().setDefaultButton(btn_start);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cmb_operation = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        cmb_time = new javax.swing.JComboBox();
        btn_start = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        spn_range = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 255));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Kids Math Quiz");
        jLabel3.setBorder(new javax.swing.border.MatteBorder(null));

        jLabel5.setText("Select Operation");

        cmb_operation.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Addition", "Subtraction", "Multiplication", "Division" }));

        jLabel6.setText("Select Time(seconds)");

        cmb_time.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "5", "10", "15", "30", "45", "60" }));
        cmb_time.setToolTipText("");

        btn_start.setText("Start");
        btn_start.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_startActionPerformed(evt);
            }
        });

        jLabel1.setText("Select Range");

        spn_range.setModel(new javax.swing.SpinnerNumberModel(1, 1, 5, 1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(245, 245, 245)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel1))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cmb_operation, 0, 117, Short.MAX_VALUE)
                                    .addComponent(cmb_time, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(spn_range)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(154, 154, 154)
                        .addComponent(btn_start)))
                .addContainerGap(255, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(106, 106, 106)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cmb_operation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(spn_range, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cmb_time, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(63, 63, 63)
                .addComponent(btn_start)
                .addGap(83, 83, 83))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        
    }//GEN-LAST:event_formWindowOpened

    private void btn_startActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_startActionPerformed
        
        String operation = cmb_operation.getSelectedItem().toString();
        range = Integer.valueOf(spn_range.getValue().toString());
        time= Integer.valueOf(cmb_time.getSelectedItem().toString());
        
        if(operation.equals("Adition"))
        {
            oper=1;
        }
        else if(operation.equals("Subtraction"))
        {
            oper=2;
        }
        else if(operation.equals("Multiplication"))
        {
            oper=3;
        }
        else if(operation.equals("Division"))
        {
            oper=4;
        }
      if(frame == null)
      {
        frame = new JFrame("Kids Math Quiz");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new OvalPanelCanvas());
        frame.setSize(1200, 800);
         frame.setVisible(true);
      } 
       // if(frame !=  null)
         //   frame.setVisible(false);
        
       
     
        
        timer = new Timer();
        
        timer.scheduleAtFixedRate(new RemindTask(),10, Integer.valueOf(time) * 1000);
        
      
        
    }//GEN-LAST:event_btn_startActionPerformed

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
            java.util.logging.Logger.getLogger(ConnectGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConnectGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConnectGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConnectGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConnectGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_start;
    private javax.swing.JComboBox cmb_operation;
    private javax.swing.JComboBox cmb_time;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JSpinner spn_range;
    // End of variables declaration//GEN-END:variables
}
