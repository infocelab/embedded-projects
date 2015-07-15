
package mediaplayer;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.media.CannotRealizeException;
import javax.media.ControllerEvent;
import javax.media.ControllerListener;
import javax.media.Manager;
import javax.media.NoPlayerException;
import javax.media.RealizeCompleteEvent;
import javax.sound.midi.ControllerEventListener;
import javax.sound.midi.ShortMessage;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.media.Player;


public class mediaplayer extends javax.swing.JFrame implements ActionListener, ControllerEventListener{

   
    public mediaplayer() 
    {
        initComponents();
        setTitle("Media Player");
        setSize(600,400);
        setLocation(500,100);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jMenu3.setText("File");

        jMenuItem2.setText("Open");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem2);

        jMenuBar2.add(jMenu3);

        setJMenuBar(jMenuBar2);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        try
        {
            getfile();
            createfile();
        }
        catch(Exception ex)
        {
           JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() 
        {
            public void run() 
            {
                new mediaplayer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem2;
    // End of variables declaration//GEN-END:variables
    private File file;
    private Player player;
    private void getfile() 
    {
        try
        {
            JFileChooser choose = new JFileChooser();
            choose.showOpenDialog(this);
            file = choose.getSelectedFile();
            if(!file.exists())
            {
                throw new FileNotFoundException();        
            }
        }
        catch(HeadlessException | FileNotFoundException e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
    
    }

    private void createfile() 
    {
        try
        {
            player= Manager.createPlayer(file.toURI().toURL());
            //player.addControllerListener((ControllerListener) this);
            player.start();
           // player.realize();
        }
        catch(IOException | NoPlayerException ex)
        {
            JOptionPane.showMessageDialog(null, ex);
        }
    
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
     
    }

    @Override
    public void controlChange(ShortMessage s) 
    {
    
    }
    public void controllerUpdate(ControllerEvent f) 
    {
        try
        {
            Container con = getContentPane();
            if(f instanceof RealizeCompleteEvent)
            {
                Component visualcomponent =player.getVisualComponent();
                if(visualcomponent!=null)
                {
                    con.add(visualcomponent,BorderLayout.CENTER);
                }
                Component controlcon =player.getControlPanelComponent();
                if(controlcon!=null)
                {
                    con.add(controlcon,BorderLayout.SOUTH);
                }
                con.doLayout();
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
