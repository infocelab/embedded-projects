import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.awt.*;
import java.awt.event.InputEvent.*;
import java.awt.image.*;
import java.util.*;
import java.util.TreeSet;
import java.awt.geom.AffineTransform;
import java.awt.image.*;
import javax.imageio.*;
import javax.swing.event.*;

public class eimg
{
public static void main(String ar[])
{
JFrame f=new ip();
JSplash s=new JSplash(f);
s.setVisible(true);
		try
		{
			Thread.sleep(5000);
  
		}
		catch(Exception ex)
		{}
		f.setVisible(true);
		s.setVisible(false);
                //f.show();
}
}
class ip extends JFrame implements ActionListener
{
String name1=" ";
int w,h;
//public BufferedImage image,bi, biFiltered;
ip()
{
setTitle("BALA IMAGE PROCESSOR");
setSize(1500,800);
addWindowListener(new WindowAdapter()
{
public void windowClosing(WindowEvent e)
{
System.exit(0);
}
});

Container cp=getContentPane();
p=new ipp();
cp.add(p,"Center");

JMenu f=new JMenu("FILE");
f.setMnemonic('F');

o=new JMenuItem("Open");
o.setMnemonic('O');
o.setActionCommand("Open");
o.addActionListener(this);
o.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,InputEvent.CTRL_MASK));
f.add(o);
f.addSeparator();

so=new JMenuItem("Save");
so.setMnemonic('S');
so.setActionCommand("Save");
so.addActionListener(this);
so.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,InputEvent.CTRL_MASK));

so.setEnabled(false);
f.add(so);
f.addSeparator();

e=new JMenuItem("Exit");
e.setMnemonic('X');
e.setActionCommand("Exit");
e.addActionListener(this);
e.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,InputEvent.ALT_MASK));
f.add(e);

JMenu ef=new JMenu("FILTERS");
ef.setMnemonic('E');

oe=new JMenuItem("Reset");
oe.setMnemonic('R');
oe.setActionCommand("Reset");
oe.addActionListener(this);
oe.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_0,InputEvent.CTRL_MASK));
oe.setEnabled(false);
ef.add(oe);
b=new JMenuItem("Blur");
b.setMnemonic('L');
b.setActionCommand("Blur");
b.addActionListener(this);
b.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1,InputEvent.CTRL_MASK));
b.setEnabled(false);
ef.add(b);

sh=new JMenuItem("Sharpen");
sh.setMnemonic('S');
sh.setActionCommand("Sharpen");
sh.addActionListener(this);
sh.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2,InputEvent.CTRL_MASK));
sh.setEnabled(false);
ef.add(sh);

rc=new JMenuItem("Contrast");
rc.setMnemonic('C');
rc.setActionCommand("Contrast");
rc.addActionListener(this);
rc.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_9,InputEvent.CTRL_MASK));
rc.setEnabled(false);
ef.add(rc);

bm=new JMenu("Brightness");
bm.setMnemonic('B');
bm.setEnabled(false);

binc=new JMenuItem("Increase");
binc.setMnemonic('I');
binc.setActionCommand("Increase");
binc.addActionListener(this);
binc.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_3,InputEvent.CTRL_MASK));
binc.setEnabled(false);
bm.add(binc);

bdec=new JMenuItem("Decrease");
bdec.setMnemonic('D');
bdec.setActionCommand("Decrease");
bdec.addActionListener(this);
bdec.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_3,InputEvent.CTRL_MASK));
bdec.setEnabled(false);
bm.add(bdec);
ef.add(bm);

ed=new JMenuItem("Edge Detect");
ed.setMnemonic('E');
ed.setActionCommand("Edge Detect");
ed.addActionListener(this);
ed.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_4,InputEvent.CTRL_MASK));
ed.setEnabled(false);
ef.add(ed);

n=new JMenuItem("Negative");
n.setMnemonic('N');
n.setActionCommand("Negative");
n.addActionListener(this);
n.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_5,InputEvent.CTRL_MASK));
n.setEnabled(false);
ef.add(n);

g=new JMenuItem("GrayScale");
g.setMnemonic('G');
g.setActionCommand("GrayScale");
g.addActionListener(this);
g.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_6,InputEvent.CTRL_MASK));
g.setEnabled(false);
ef.add(g);

em=new JMenuItem("Emboss");
em.setMnemonic('M');
em.setActionCommand("Emboss");
em.addActionListener(this);
em.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_7,InputEvent.CTRL_MASK));
em.setEnabled(false);
ef.add(em);


JMenu om=new JMenu("OPTIONS");
om.setMnemonic('O');

s=new JMenuItem("Histogram");
s.setMnemonic('H');
s.setActionCommand("Histogram");

s.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent e)
{
    p.Histogram();
}
});
s.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H,InputEvent.CTRL_MASK));
s.setEnabled(false);
om.add(s);
//JMenu z=new JMenu("Size");
//z.setMnemonic('S');

//inc=new JMenuItem("Increase");
//inc.setMnemonic('I');
//inc.setActionCommand("Increase");
//inc.addActionListener(new ActionListener()
//{
//public void actionPerformed(ActionEvent e)
//{
//    increase is=new increase(name1,name1+"-Increase");
//is.setBounds(10,10,500,500);
//is.setVisible(true);
//}
//});

//inc.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I,InputEvent.CTRL_MASK));
//z.add(inc);

//dec=new JMenuItem("Decrease");
//dec.setMnemonic('D');
//dec.setActionCommand("Decrease");
//dec.addActionListener(this);
//dec.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D,InputEvent.CTRL_MASK));
//z.add(dec);
//om.add(z);


ma=new JMenuItem("Magnifier");
ma.setMnemonic('M');
ma.setActionCommand("Magnifier");
ma.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent e)
{

Magnifier m=new Magnifier();

}
});
ma.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M,InputEvent.CTRL_MASK));
ma.setEnabled(false);
om.add(ma);


opac=new JMenuItem("Opacity");
opac.setMnemonic('O');
opac.setActionCommand("Opacity");
opac.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent e)
{
    try{
        Opacity opa=new Opacity("Opacity for the Image",new File(name1));
        Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
        opa.setBounds(0,0,(int)d.getWidth(),(int)d.getHeight());
        opa.setVisible(true);
    }
    catch(Exception mre)
    {
        System.out.println("Error in URL ==> "+mre.getMessage());
    }
}});
opac.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,InputEvent.CTRL_MASK));
opac.setEnabled(false);
om.add(opac);

rc1=new JMenuItem("Cube");
rc1.setMnemonic('C');
rc1.setActionCommand("Cube");
rc1.addActionListener(this);
rc1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_9,InputEvent.CTRL_MASK));
rc1.setEnabled(false);
om.add(rc1);

JPanel p=new JPanel();
tb=new JToolBar("FILTERS");
p.setBorder(BorderFactory.createEtchedBorder());
		
res = new JButton(new ImageIcon("UNDO.gif"));
res.setToolTipText("Reset");
bl = new JButton(new ImageIcon("blur.gif"));
bl.setToolTipText("Blur");
sha = new JButton(new ImageIcon("bulb.gif"));
sha.setToolTipText("Sharpen");
con = new JButton(new ImageIcon("object.gif"));
con.setToolTipText("Contrast");
bri = new JButton(new ImageIcon("PLUS.gif"));
bri.setToolTipText("Increase Brightness");
brd = new JButton(new ImageIcon("MINUS.gif"));
brd.setToolTipText("Decrease Brightness");
edt = new JButton(new ImageIcon("edge.gif"));
edt.setToolTipText("Edge Detect");
neg=new JButton(new ImageIcon("neg.gif"));
neg.setToolTipText("Negative");
gray=new JButton(new ImageIcon("LINE.gif"));
gray.setToolTipText("Gray Scale");
emb=new JButton(new ImageIcon("emboss.gif"));
emb.setToolTipText("Emboss");
save=new JButton(new ImageIcon("save.gif"));
save.setToolTipText("Save");
mag=new JButton(new ImageIcon("zoom.gif"));
mag.setToolTipText("Magnifier");
tb.add(save);
tb.add(res);
tb.add(bl);
tb.add(sha);
tb.add(con);
tb.add(bri);
tb.add(brd);
tb.add(edt);
tb.add(neg);
tb.add(gray);
tb.add(emb);
tb.add(mag);
save.addActionListener(this);
res.addActionListener(this);
res.addActionListener(this);
bl.addActionListener(this);
sha.addActionListener(this);
con.addActionListener(this);
bri.addActionListener(this);
brd.addActionListener(this);
edt.addActionListener(this);
neg.addActionListener(this);
gray.addActionListener(this);
emb.addActionListener(this);
mag.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent e)
{

Magnifier m=new Magnifier();

}
});

JMenu am=new JMenu("ABOUT");
am.setMnemonic('A');

a=new JMenuItem("Author");
a.setMnemonic('U');
a.setActionCommand("Author");
a.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent e)

{
JOptionPane jOptionPane = new JOptionPane();
          JTextArea jTextArea = new JTextArea();
          jTextArea.setEditable(false);
          jTextArea.setText("Name : M.Balachandran \n" +
                             "Course : II MCA \n" +
                             "Reg No : 057102 \n" +
                             "University : GRU \n" +
                             "Native : Tuticorin \n"  +
                             "Email Id : balamathi@gmail.com \n" +
                              "Contact No : +919994878586 \n");
          jOptionPane.showMessageDialog(null,
                                          jTextArea,
                                          "Image Processor About Author",
                                          JOptionPane.INFORMATION_MESSAGE);
}
});
a.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U,InputEvent.CTRL_MASK));
am.add(a);

pr=new JMenuItem("Project");
pr.setMnemonic('P');
pr.setActionCommand("Project");
pr.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent e)
{
//JOptionPane.showMessageDialog(null,"THIS PROJECT IS DEVELOPED FOR USING IMAGE PROCESSING FILTERS");
JSplash1 s1=new JSplash1();
s1.setVisible(true);
		try
		{
			Thread.sleep(5000);
		}
		catch(Exception ex)
		{}
}
});
pr.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P,InputEvent.CTRL_MASK));
am.add(pr);

JMenuBar mb=new JMenuBar();
mb.add(f);
mb.add(ef);
mb.add(om);
mb.add(am);
setJMenuBar(mb);

rc1.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent e)
{
JFrame jf=new JFrame("CUBE");
JLabel lab=new JLabel("Cube");
jf.getContentPane().add(lab,BorderLayout.NORTH);

JPanel panel1=new JPanel(new GridLayout(1,2));
JLabel l=new JLabel();

classone one=new classone();
getContentPane().add(one);
panel1.add(one);
one.init();
jf.getContentPane().add(panel1,BorderLayout.CENTER);
jf.pack();
jf.setBounds(0,50,500,500);
panel1.add(l);
jf.setVisible(true);
}
});
}
public void actionPerformed(ActionEvent evt)
{
Object source=evt.getSource();

if(source==so)
{
    try{

    //SaveImage1 sm=new SaveImage1(image,"Save the Image");
   // Toolkit tk=Toolkit.getDefaultToolkit();
  //  Dimension d=tk.getScreenSize();
  //  sm.setBounds(0,0,(int)d.getWidth(),(int)d.getHeight());
  //  sm.setVisible(true);
        String type=JOptionPane.showInputDialog("Select the image type","jpg(or)bmp(or)gif(or)png");
        if(type.indexOf("or")>=0)
        {
            JOptionPane.showMessageDialog(this,"Select only one type.\nCan't Save Try Again","Error",JOptionPane.ERROR_MESSAGE);
            return;
        }
        p.SaveImage(type);
        JOptionPane.showMessageDialog(this,"Saved Successfully","Saved",JOptionPane.INFORMATION_MESSAGE);
       }
    catch(Exception e)
    {
        System.out.println("Error "+e.getMessage());
    }
}

if(source==save)
{
    try{

    //SaveImage1 sm=new SaveImage1(image,"Save the Image");
   // Toolkit tk=Toolkit.getDefaultToolkit();
  //  Dimension d=tk.getScreenSize();
  //  sm.setBounds(0,0,(int)d.getWidth(),(int)d.getHeight());
  //  sm.setVisible(true);
        String type=JOptionPane.showInputDialog("Select the image type","jpg(or)bmp(or)gif(or)png");
        if(type.indexOf("or")>=0)
        {
            JOptionPane.showMessageDialog(this,"Select only one type.\nCan't Save Try Again","Error",JOptionPane.ERROR_MESSAGE);
            return;
        }
        p.SaveImage(type);
        JOptionPane.showMessageDialog(this,"Saved Successfully","Saved",JOptionPane.INFORMATION_MESSAGE);
       }
    catch(Exception e)
    {
        System.out.println("Error "+e.getMessage());
    }
}

float i=0;
if(source==o)
{
//Panel cd=new Panel();
p.add(tb,BorderLayout.NORTH);
add(tb);

JFileChooser chooser=new JFileChooser();
int r=chooser.showOpenDialog(this);
chooser.setCurrentDirectory(new File(name1));
if(r==JFileChooser.APPROVE_OPTION)
{
name=chooser.getSelectedFile().getAbsolutePath();
name1=name;
p.loadImage(name);
so.setEnabled(true);
oe.setEnabled(true);
b.setEnabled(true);
sh.setEnabled(true);
rc.setEnabled(true);
bm.setEnabled(true);
binc.setEnabled(true);
bdec.setEnabled(true);
ed.setEnabled(true);
n.setEnabled(true);
g.setEnabled(true);
em.setEnabled(true);
s.setEnabled(true);
ma.setEnabled(true);
opac.setEnabled(true);
rc1.setEnabled(true);
}
setTitle("IMAGE PROCESSOR"+"-BALA"+"\""+name+"\"");
}


else if(source==e)
System.exit(0);

else if(source==b)
p.blur();

else if(source==sh)
p.sharpen();

//else if(source==so)
//p.SaveImage();

else if(source==binc)
p.brightinc();

else if(source==bdec)
p.brightdec();

else if(source==ed)
p.edge();

else if(source==n)
p.negative();

else if(source==oe)
p.reset(name);

else if(source==g)
p.gray(name);

else if(source==em)
p.emboss();

else if(source==rc1)
p.bala();

else if(source==bl)
p.blur();


else if(source==sha)
p.sharpen();

//else if(source==so)
//p.SaveImage();

else if(source==bri)
p.brightinc();

else if(source==brd)
p.brightdec();

else if(source==edt)
p.edge();

else if(source==neg)
p.negative();

else if(source==res)
p.reset(name);

else if(source==gray)
p.gray(name);

else if(source==emb)
p.emboss();

else if(source==rc1)
p.bala();


else if(source==opac)
{
    //i=i+10;
    //p.setOpacity(i);
     

}
}
//private  JSlider opacitySlider;
private ipp p;
private JMenuItem o;
private JMenuItem s;
private JMenuItem sa;
private JMenuItem e;
private JMenuItem b;
private JMenuItem sh;
private JMenuItem rc;
private JMenuItem binc;
private JMenuItem bdec;
private JMenuItem ed;
private JMenuItem n;
private JMenuItem oe;
private JMenuItem g;
private JMenuItem em;
private JMenuItem a;
private JMenuItem rc1;
private JMenuItem pr;
private JMenuItem ma;
private JMenuItem z;
private JMenuItem inc;
private JMenuItem dec;
private JMenuItem so;
private JMenuItem opac;
private JMenu bm;
private JToolBar tb;
private JButton res;
private JButton bl;
private JButton sha;
private JButton con;
private JButton bri;
private JButton brd;
private JButton edt;
private JButton neg;
private JButton gray;
private JButton emb;
private JButton mag;
private JButton save;

private String name;
//public void paint(Graphics g)
//{
//        Graphics2D g2d = (Graphics2D)g;
//        g2d.setColor(Color.white);
//        g2d.fillRect(0,0, getWidth(), getHeight());
//        g2d.setColor(Color.black);
//        g2d.setFont(new Font("Dialog", Font.BOLD, 24));
//        g2d.drawString("Java 2D is great!", 10, 80);
//        g2d.drawImage(p.getImg(),p.rop,100, 100);
//}
}

class ipp extends JPanel
{
int w,h;
public BufferedImage b;
    public static final float[] SHARPEN3x3 = { // sharpening filter kernel
        0.f, -1.f,  0.f,
       -1.f,  5.f, -1.f,
        0.f, -1.f,  0.f
    };
    boolean yes=false;
    float[] scales = { 1f, 1f, 1f, 0.5f };
    float[] offsets = new float[4];
    RescaleOp rop;
    public static final float[] BLUR3x3 = {
        0.1f, 0.1f, 0.1f,    // low-pass filter kernel
        0.1f, 0.2f, 0.1f,
        0.1f, 0.1f, 0.1f
    };
     int opIndex;
     int lastOp;
public BufferedImage getImg()
{
    return(image);
}
public void Histogram()
{
    histogram m=new histogram(image,"Histogram");
    Toolkit tk=Toolkit.getDefaultToolkit();
    Dimension d=tk.getScreenSize();
    m.setBounds(0,0,(int)d.getWidth(),(int)d.getHeight());
    m.setVisible(true);
}
public void SaveImage(String type)
{
    File saveFile = new File("savedimage."+type);
    JFileChooser chooser = new JFileChooser();
    chooser.setSelectedFile(saveFile);
    int rval = chooser.showSaveDialog(this);
    if (rval == JFileChooser.APPROVE_OPTION) {
     saveFile = chooser.getSelectedFile();
     /* Write the filtered image in the selected format,
      * to the file chosen by the user.
      */
     try {
         ImageIO.write(image, type, saveFile);
     } catch (IOException ex) {
     }
    }
}
public void paintComponent(Graphics g)
{
String m1="BALA-IMAGE PROCESSOR Version 1.1";
String m2="MINI PROJECT";
String m3="APRIL-2007";

Font f1=new Font("Times New Roman",Font.BOLD,40);
Font f2=new Font("Monotype Corsiva",Font.BOLD,24);
Font f3=new Font("Times Roman",Font.BOLD+Font.ITALIC,16);

FontMetrics fm=g.getFontMetrics(f1);

int w1=fm.stringWidth(m1);
int h1=fm.getAscent();
int x1=(getSize().width-w1)/2;
int y1=(getSize().height+h1)/2;

int w2=fm.stringWidth(m2);
int h2=fm.getAscent();
int x2=(getSize().width-w2)/2;
int y2=(getSize().height+h2)/2;

int w3=fm.stringWidth(m3);
int h3=fm.getAscent();
int x3=(getSize().width-w3)/2;
int y3=(getSize().height+h3)/2;

super.paintComponent(g);

if(image==null)
{
g.setFont(f1);
g.setColor(Color.red);
g.drawString(m1,x1,y1);
g.setFont(f2);
g.setColor(Color.blue);
g.drawString(m2,x2+10,y2+50);
g.setFont(f3);
g.setColor(Color.black);
g.drawString(m3,x3+20,y3+120);
}
else
{
    //if(yes==false)
        g.drawImage(image,0,0,null);
  //  else
    //{
                // yes=false;
   // }
}
}
    public String[] getFormats() {
        String[] formats = ImageIO.getWriterFormatNames();
        TreeSet<String> formatSet = new TreeSet<String>();
        for (String s : formats) {
            formatSet.add(s.toLowerCase());
        }
        return formatSet.toArray(new String[0]);
    }
 public void loadImage(String name)
{
            Image img=Toolkit.getDefaultToolkit().getImage(name);
     try{
            image = ImageIO.read(new File(name));
     }
     catch(IOException ioe)
     {
         System.out.println("Error ==>"+ioe.getMessage());
     }

w = image.getWidth(null);
h = image.getHeight(null);
MediaTracker t=new MediaTracker(this);
t.addImage(img,0);
try
{
t.waitForID(0);
}
catch(InterruptedException e)
{
}
image=new BufferedImage(img.getWidth(null),img.getHeight(null),BufferedImage.TYPE_INT_RGB);
Graphics2D g2=image.createGraphics();
g2.drawImage(img,0,0,null);
repaint();
}

public void reset(String name)
{
Image img=Toolkit.getDefaultToolkit().getImage(name);
MediaTracker t=new MediaTracker(this);
t.addImage(img,0);
try
{
t.waitForID(0);
}
catch(InterruptedException e)
{
}
image=new BufferedImage(img.getWidth(null),img.getHeight(null),BufferedImage.TYPE_INT_RGB);
Graphics2D g2=image.createGraphics();
g2.drawImage(img,0,0,null);
repaint();
}

public void gray(String name)
{
Image img=Toolkit.getDefaultToolkit().getImage(name);
MediaTracker t=new MediaTracker(this);
t.addImage(img,0);
try
{
t.waitForID(0);
}
catch(InterruptedException e)
{
}
image=new BufferedImage(img.getWidth(null),img.getHeight(null),BufferedImage.TYPE_BYTE_GRAY);
Graphics2D g2=image.createGraphics();
g2.drawImage(img,0,0,null);
repaint();
}

private void filter(BufferedImageOp op)
{
BufferedImage filteredImage=new BufferedImage(image.getWidth(),image.getHeight(),image.getType());
op.filter(image,filteredImage);
image=filteredImage;
repaint();
}

private void convolve(float [] elements)
{
Kernel kernel=new Kernel(3,3,elements);
ConvolveOp op=new ConvolveOp(kernel);
filter(op);
}

public void blur()
{
float weight=1.0f/9.0f;
float[] elements=new float[9];

for(int i=0;i<9;i++)
elements[i]=weight;
convolve(elements);
}

public void bala()
{
Kernel kernel=new Kernel(3,3,new float[] {1,0,0,0,0,0,0,0,1});
BufferedImageOp op=new ConvolveOp(kernel);
filter(op);
}

public void sharpen()
{
float[] elements={0.0f,-1.0f,0.0f,-1.0f,5.0f,-1.0f,0.0f,-1.0f,0.0f};
convolve(elements);
}

void edge()
{
float[] elements={0.0f,-1.0f,0.0f,-1.0f,4.0f,-1.0f,0.0f,-1.0f,0.0f};
convolve(elements);
}

public void brightinc()
{
float a=1.5f;
float b=-20.0f;
RescaleOp op=new RescaleOp(a,b,null);
filter(op);
}

public void brightdec()
{
float a=1.0f;
float b=-20.0f;
RescaleOp op=new RescaleOp(a,b,null);
filter(op);
}

void negative()
{
byte negative []=new byte[256];
for(int i=0;i<252;i++)
negative[i]=(byte)(255-i);

ByteLookupTable table=new ByteLookupTable(0,negative);
LookupOp op=new LookupOp(table,null);
filter(op);
}

void emboss()
{
Kernel kernel=new Kernel(3,3,new float[] {-1,-1,0,-1,1,1,0,1,1});
BufferedImageOp op=new ConvolveOp(kernel);
filter(op);
}

private BufferedImage image;

}

class classone extends JApplet
{
public void init(int x,int y)
{
this.repaint();
}

public void paint(Graphics g)
{
Graphics2D g2D=(Graphics2D)g;
g2D.setPaint(Color.red);

Point2D.Float p1=new Point2D.Float(50.0f,10.0f);
float width1=60;
float height1=80;
Rectangle2D.Float rect=new Rectangle2D.Float(p1.x,p1.y,width1,height1);
g2D.draw(rect);

Point2D.Float p2=new Point2D.Float(150.0f,100.0f);
float width2=width1+30;
float height2=height1+40;
Rectangle2D.Float rect1=new Rectangle2D.Float((float)(p2.getX()),(float)(p2.getY()),width2,height2);
g2D.setPaint(Color.blue);
Line2D.Float line=new Line2D.Float(p1,p2);
g2D.draw(line);
p1.setLocation(p1.x+width1,p1.y);
p2.setLocation(p2.x+width2,p2.y);
g2D.draw(new Line2D.Float(p1,p2));
p1.setLocation(p1.x,p1.y+height1);
p2.setLocation(p2.x,p2.y+height2);
g2D.draw(new Line2D.Float(p1,p2));
p1.setLocation(p1.x-width1,p1.y);
p2.setLocation(p2.x-width2,p2.y);
g2D.draw(new Line2D.Float(p1,p2));
p1.setLocation(p1.x,p1.y-height1);
p2.setLocation(p2.x,p2.y-height2);
g2D.draw(new Line2D.Float(p1,p2));
g2D.drawString("RECTANGLE",60,250);
}
}
