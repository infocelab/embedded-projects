import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.PixelGrabber;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
public class histogram extends JFrame
{
    Image img;
    int iw,ih;
    int pixels[];
    int w,h;
    int his[]=new int[256];
    int max_his=0;

    public histogram(BufferedImage name,String title)
    {
                   super(title);
        try
        {
            //SSURL u=new URL(name);
            Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
            img=name;         
            MediaTracker t=new MediaTracker(this);
            t.addImage(img,0);
            setResizable(false);
            t.waitForID(0);
            h=(int)d.getHeight();
            w=(int)d.getWidth();
            iw=img.getWidth(null);
            ih=img.getHeight(null);
            pixels=new int[iw*ih];
            PixelGrabber pg=new PixelGrabber(img,0,0,iw,ih,pixels,0,iw);
            pg.grabPixels();
        }
        catch(Exception e)
        {
        };

        for(int i=0;i<iw*ih;i++)
        {
            int p=pixels[i];
            int r=0xff & (p>>16);
            int g=0xff & (p>>8);
            int b=0xff & (p);
            int y=(int) (.33*r+.56*g+.11*b);
            his[y]++;
        }

        for(int i=0;i<256;i++)
        {
            if (his[i]>max_his)
            max_his=his[i];
        }
    }
public void paint(Graphics g)
{
    g.drawImage(img,0,0,null);
    int x=(w-256)/2;
    int lasty=h-h*his[0]/max_his;
    for(int i=0;i<256;i++,x++)
    {
        int y=h-h*his[i]/max_his;
        g.setColor(new Color(i,i,i));
        g.fillRect(x,y,1,h);
        g.setColor(Color.red);
        g.drawLine(x-1,lasty,x,y);
        lasty=y;
    }
}
    public void update() {
    }
}