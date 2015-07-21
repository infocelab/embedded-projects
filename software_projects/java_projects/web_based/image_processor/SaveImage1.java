import java.io.*;
import java.util.TreeSet;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;
import java.awt.image.*;
import javax.imageio.*;
import javax.swing.*;

public class SaveImage1 extends JFrame implements ActionListener {

    String descs[] = {
    "Original", 
        "Convolve : LowPass",
        "Convolve : Sharpen", 
        "LookupOp",
    };

    int opIndex;
    private BufferedImage bi, biFiltered;
    int w, h;
    
    public static final float[] SHARPEN3x3 = { // sharpening filter kernel
        0.f, -1.f,  0.f,
       -1.f,  5.f, -1.f,
        0.f, -1.f,  0.f
    };

    public static final float[] BLUR3x3 = {
        0.1f, 0.1f, 0.1f,    // low-pass filter kernel
        0.1f, 0.2f, 0.1f,
        0.1f, 0.1f, 0.1f
    };
    JButton b1;
    public SaveImage1(BufferedImage b,String title) {
        super(title);
        Container con=getContentPane();
        
        JComboBox formats = new JComboBox(getFormats());
        b1=new JButton("Exit");
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        formats.setActionCommand("Formats");
        formats.addActionListener(this);
        JPanel panel = new JPanel();      
        panel.add(new JLabel("Save As"));
        panel.add(formats);
        panel.add(b1);
        formats.setActionCommand("Formats");
        formats.addActionListener(this);
        con.add(panel,"South");
        try {
            //bi = ImageIO.read(new File(name));
            w = b.getWidth(null);
            h = b.getHeight(null);
            if (b.getType() != BufferedImage.TYPE_INT_RGB) {
                BufferedImage bi2 =new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
                Graphics big = bi2.getGraphics();
                big.drawImage(b, 0, 0, null);
                biFiltered = b = bi2;
            }
        } catch (Exception e) {
            System.out.println("Image could not be read");
            System.exit(1);
        }
    }

    public Dimension getPreferredSize() {
        return new Dimension(w, h);
    }

    String[] getDescriptions() {
        return descs;
    }

    void setOpIndex(int i) {
        opIndex = i;
    }

    public void paint(Graphics g) {
        filterImage();
        g.drawImage(biFiltered, 0, 0, null);
    }

    int lastOp;
    public void filterImage() {
        BufferedImageOp op = null;

        if (opIndex == lastOp) {
            return;
        }
        lastOp = opIndex;
        switch (opIndex) {

        case 0: biFiltered = bi; /* original */
                return; 
        case 1:  /* low pass filter */
        case 2:  /* sharpen */
            float[] data = (opIndex == 1) ? BLUR3x3 : SHARPEN3x3;
            op = new ConvolveOp(new Kernel(3, 3, data),ConvolveOp.EDGE_NO_OP,null);
  
            break;

        case 3 : /* lookup */
            byte lut[] = new byte[256];
            for (int j=0; j<256; j++) {
                lut[j] = (byte)(256-j); 
            }
            ByteLookupTable blut = new ByteLookupTable(0, lut); 
            op = new LookupOp(blut, null);
            break;
        }

        /* Rather than directly drawing the filtered image to the
         * destination, filter it into a new image first, then that
         * filtered image is ready for writing out or painting. 
         */
        biFiltered = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        op.filter(bi, biFiltered);
    }

    /* Return the formats sorted alphabetically and in lower case */
    public String[] getFormats() {
        String[] formats = ImageIO.getWriterFormatNames();
        TreeSet<String> formatSet = new TreeSet<String>();
        for (String s : formats) {
            formatSet.add(s.toLowerCase());
        }
        return formatSet.toArray(new String[0]);
    }


     public void actionPerformed(ActionEvent e) {
         JComboBox cb = (JComboBox)e.getSource();
         if (cb.getActionCommand().equals("SetFilter")) {
             setOpIndex(cb.getSelectedIndex());
             repaint();
         } else if (cb.getActionCommand().equals("Formats")) {
             /* Save the filtered image in the selected format.
              * The selected item will be the name of the format to use
              */
             String format = (String)cb.getSelectedItem();
             /* Use the format name to initialise the file suffix.
              * Format names typically correspond to suffixes
              */
             File saveFile = new File("savedimage."+format);
             JFileChooser chooser = new JFileChooser();
             chooser.setSelectedFile(saveFile);
             int rval = chooser.showSaveDialog(cb);
             if (rval == JFileChooser.APPROVE_OPTION) {
                 saveFile = chooser.getSelectedFile();
                 /* Write the filtered image in the selected format,
                  * to the file chosen by the user.
                  */
                 try {
                     ImageIO.write(biFiltered, format, saveFile);
                 } catch (IOException ex) {
                 }
             }
         }
    };

   // public static void main(String s[]) {
   //     JFrame f = new JFrame("Save Image Sample");
  //      f.addWindowListener(new WindowAdapter() {
  //          public void windowClosing(WindowEvent e) {System.exit(0);}
 //       });
        //SaveImage1 si = new SaveImage1();
        //f.add("Center", si);
 //       JComboBox choices = new JComboBox(si.getDescriptions());
 //       choices.setActionCommand("SetFilter");
 //       choices.addActionListener(si);
 //       JComboBox formats = new JComboBox(si.getFormats());
 //       formats.setActionCommand("Formats");
//        formats.addActionListener(si);
 //       JPanel panel = new JPanel();
 //       panel.add(choices);
 //       panel.add(new JLabel("Save As"));
   //     panel.add(formats);
 //       f.add("South", panel);
 //       f.pack();
 //       f.setVisible(true);
  //  }
}
