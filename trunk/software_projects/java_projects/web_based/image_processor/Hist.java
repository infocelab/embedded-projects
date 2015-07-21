import java.awt.*;
import java.awt.image.*;
import javax.swing.*;
import java.applet.*;
/*<applet code=Hist width=500 height=500>
<param name="img" value="splash1.jpg">
</applet>*/
public class Hist extends JApplet
{
Dimension d;
Image img;
int iw,ih;
int pixels[];
int w,h;
int his[]=new int[256];
int max_his=0;

public void init()
{
d=getSize();
w=d.width;
h=d.height;

try
{
img=getImage(getDocumentBase(),getParameter("img"));
MediaTracker t=new MediaTracker(this);
t.addImage(img,0);
t.waitForID(0);
iw=img.getWidth(null);
ih=img.getHeight(null);
pixels=new int[iw*ih];
PixelGrabber pg=new PixelGrabber(img,0,0,iw,ih,pixels,0,iw);
pg.grabPixels();
}
catch(Exception e)
{
    System.out.println("Error ==>" + e.getMessage());
}

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

public void update()
{
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
}