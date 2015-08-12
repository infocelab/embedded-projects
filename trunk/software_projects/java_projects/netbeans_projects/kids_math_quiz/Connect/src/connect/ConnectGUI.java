package connect;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
public class ConnectGUI extends javax.swing.JFrame 
{
   public static int T_FONT_SIZE = 220;
  public static int d1 = 5;
  public static int d2 = 5;
   public static int ans = 5;
  public static int oper = 1;
    public static int range = 1;
     public static int time = 5;
     public static int img_count = 0;
public static int disp = 0;
  Random rand; // = new Random(System.currentTimeMillis());

   Timer timer ; 
   JFrame frame=null;
   BufferedImage img=null;
   ImageIcon imageIcon = null;
   Image image = null;
    class RemindTask extends TimerTask {
    public void run() {
        if(disp == 0)
        {
        d1 = rand.nextInt((int) Math.pow(10,range));
    
        d2 = rand.nextInt((int) Math.pow(10,range));
        }
        try {
              if(img_count++ <=  10)
              {
            img = ImageIO.read(new File("m1.jpg"));
            image = img.getScaledInstance(1500,800, Image.SCALE_SMOOTH);
              }
              else if(img_count++ <= 20)
              {
            img = ImageIO.read(new File("m2.jpg"));
              image = img.getScaledInstance(1500,800, Image.SCALE_SMOOTH);
              }
              else if(img_count++ <= 30)
              {
                  img = ImageIO.read(new File("m3.jpg"));
              image = img.getScaledInstance(1500,800, Image.SCALE_SMOOTH);
              }
              else if(img_count++ > 30)
                        {
                            img_count=0;
                        }
               
        } catch (IOException ex) {
            Logger.getLogger(ConnectGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        frame.repaint();
    }
  }

   public class OvalPanelCanvas extends JPanel {
  public OvalPanelCanvas() {
  }
  
  public void drawTextOval(String text ,int w, int height, Graphics g, Color c)
  {
       int x = w, y = height;
        int ovalWidth = T_FONT_SIZE, ovalHeight = T_FONT_SIZE;

        g.setColor(Color.PINK);
        g.fillOval(x-ovalWidth/2, y-ovalHeight/2,ovalWidth, ovalHeight);
        FontMetrics fm = g.getFontMetrics();
        double textWidth = fm.getStringBounds(text, g).getWidth();
        g.setColor(c);
        g.drawString(text, (int) (x - textWidth/2),(int) (y + fm.getMaxAscent() / 3));
  }
  
  public void drawTextPoly(String text ,int w, int height, Graphics g, Color c)
  {
       int x = w, y = height;
        int ovalWidth = T_FONT_SIZE + 50, ovalHeight = T_FONT_SIZE;

        g.setColor(Color.PINK);
        //g.fillOval(x-ovalWidth/2, y-ovalHeight/2,ovalWidth, ovalHeight);
        g.fill3DRect(x-ovalWidth/2, y-ovalHeight/2,ovalWidth, ovalHeight, rootPaneCheckingEnabled);
        FontMetrics fm = g.getFontMetrics();
        double textWidth = fm.getStringBounds(text, g).getWidth();
        g.setColor(c);
        g.drawString(text, (int) (x - textWidth/2),(int) (y + fm.getMaxAscent() / 3));
  }
  
  public void paintComponent(Graphics g) {
    int width = getWidth();
    int height = getHeight();
    g.setColor(Color.black);
    String color = cmb_color.getSelectedItem().toString();
    
    g.drawImage(image, 0, 0, null);
    g.setColor(Color.BLACK);
    if(color.equals("MAGENTA"))
    {
        g.setColor(Color.MAGENTA);
    }
    else if(color.equals("BLUE"))
    {
        g.setColor(Color.BLUE);
    }
    else if(color.equals("RED"))
    {
        g.setColor(Color.RED);
    }
    else if(color.equals("GREEN"))
    {
        g.setColor(Color.GREEN);
    }
    else if(color.equals("BLACK"))
    {
        g.setColor(Color.black);
    }
    
    Color c = g.getColor();
    
    g.setFont(new Font("TimesRoman", Font.PLAIN, T_FONT_SIZE)); 
    int w=150;
    
      drawTextOval(String.valueOf(d1),w,height/3,g, c);
        //g.drawString( String.valueOf(d1), w , height/2);
        //g.drawOval(w, height/4, T_FONT_SIZE, T_FONT_SIZE);
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
             opr = "X";
             ans = d1 * d2;
         }
         else if(oper == 4)
         {
             opr = "/";
             ans = d1 / d2;
         }
         if(d1 > 0)
        w +=  T_FONT_SIZE * (int)(Math.log10(d1)+1);
             else
        w +=  T_FONT_SIZE ;
         
        g.drawString(opr, w , height/3);
        w = w+ T_FONT_SIZE * 2;
        
          drawTextOval(String.valueOf(d2),w,height/3,g, c);
        //g.drawString(String.valueOf(d2), w , height/2);
        w = w+ T_FONT_SIZE;
        if(disp == 0)
        {
            disp = 1;
        }
        else if(disp == 1)
        {
            w=200;
            g.drawString("=", w , height/2 + 200);
         w = w+ T_FONT_SIZE;
        drawTextPoly(String.valueOf(ans), w+ 50 , height/2 + 150,g, c);
        
         //g.drawString(String.valueOf(ans), w , height/2 + 200);
          disp=0;
        }
         
        
        }
    
}
    public ConnectGUI() 
    {
        initComponents(); 
        rand = new Random(System.currentTimeMillis());
        cmb_color.addItem("BLUE");
        cmb_color.addItem("MAGENTA");
        cmb_color.addItem("RED");
        cmb_color.addItem("GREEN");
        cmb_color.addItem("BLACK");
         try {
                img = ImageIO.read(new File("m1.jpg"));
                
            } catch (IOException ex) {
                Logger.getLogger(ConnectGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
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
        jLabel2 = new javax.swing.JLabel();
        cmb_color = new javax.swing.JComboBox();

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
        jLabel3.setText("Math Quiz");
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

        spn_range.setModel(new javax.swing.SpinnerNumberModel(1, 1, 3, 1));

        jLabel2.setText("Select Color");

        cmb_color.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_colorActionPerformed(evt);
            }
        });

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
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cmb_operation, 0, 117, Short.MAX_VALUE)
                                    .addComponent(cmb_time, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(spn_range)
                                    .addComponent(cmb_color, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(154, 154, 154)
                        .addComponent(btn_start)))
                .addContainerGap(306, Short.MAX_VALUE))
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
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cmb_color, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(55, 55, 55)
                .addComponent(btn_start)
                .addGap(38, 38, 38))
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
        if(frame != null)
            frame.setVisible(false);
        frame = new JFrame("Math Quiz");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.add(new OvalPanelCanvas());
        image = img.getScaledInstance(1500,800, Image.SCALE_SMOOTH);
        frame.setVisible(true);
        if(timer != null)
        timer.cancel();
        timer = new Timer();
        
        timer.scheduleAtFixedRate(new RemindTask(),10, Integer.valueOf(time) * 1000);
        
    }//GEN-LAST:event_btn_startActionPerformed

    private void cmb_colorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_colorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb_colorActionPerformed

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
    private javax.swing.JComboBox cmb_color;
    private javax.swing.JComboBox cmb_operation;
    private javax.swing.JComboBox cmb_time;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JSpinner spn_range;
    // End of variables declaration//GEN-END:variables
}
