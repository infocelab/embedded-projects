import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.RescaleOp;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
public class Opacity extends JFrame
{
    private BufferedImage bi;
    float[] scales = { 1f, 1f, 1f, 0.5f };
    float[] offsets = new float[4];
    RescaleOp rop;
    JSlider js;
    public Opacity(String title,File imageSrc)
    {
        super(title);
        Container con=getContentPane();
        js=new JSlider(0,100);
       try {
            BufferedImage img = ImageIO.read(imageSrc);
            int w = img.getWidth(null);
            int h = img.getHeight(null);
            bi = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
            Graphics g = bi.getGraphics();
            g.drawImage(img, 0, 0, null);
        } catch (IOException e) {
            System.out.println("Image could not be read");
            System.exit(1);
        }
        js.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                    JSlider b = (JSlider)e.getSource();
                    JSlider slider = (JSlider)e.getSource();
                    setOpacity(slider.getValue()/100f);
                    repaint();                
            }
        });
        Dimension size = getPreferredSize();
        Dimension sliderSize = js.getPreferredSize();
        resize(size.width, size.height+sliderSize.height);
        con.add("South",js);
        pack();
    }
     public Dimension getPreferredSize() {
        return new Dimension(bi.getWidth(null), bi.getHeight(null));
    }

    public void setOpacity(float opacity) {
        scales[3] = opacity;
        rop = new RescaleOp(scales, offsets, null);
    }
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;
        g2d.setColor(Color.white);
        g2d.fillRect(0,0, getWidth(), getHeight());
        g2d.setColor(Color.black);
        g2d.setFont(new Font("Dialog", Font.BOLD, 24));
        g2d.drawImage(bi, rop, 0, 0);
    }
}
