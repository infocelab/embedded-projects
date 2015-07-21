import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.applet.AppletContext.*;
import java.util.*;
import javax.swing.event.*;
import java.lang.reflect.*;
import javax.swing.border.*;
import javax.swing.plaf.basic.*;
import  java.awt.image.ImageConsumer ;
import java.awt.image.ImageObserver; 
import   java.applet.AudioClip;
import javax.swing.filechooser.FileView;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.*;
import javax.swing.event.*;
import java.lang.reflect.*;
import javax.swing.border.*;
import javax.swing.plaf.basic.*;
import  java.awt.image.ImageConsumer ;
import java.awt.image.ImageObserver; 
import javax.media.*;
import java.net.*;
import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.media.*;
import javax.swing.event.*;
import javax.sound.midi.*; 
import javax.swing.Timer;



class player1 extends JWindow
{
Player p;
JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12;
JList l;
JFileChooser chooser;
JTextField jt,timer;
DefaultListModel model;
JFrame jf;
JSlider vb ;
Container cp1;
JPanel j1,j2,j3,j4,j5,cp;
JLabel jk2;
String stre[];
int u=0,as=0;
Timer t;

player1(String dd)
{
jf=new JFrame();
try

		{

			UIManager.setLookAndFeel ("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");

		}

		catch(Exception e)
		{}

setLocation(100,10);
setVisible(true);
cp1=getContentPane();
cp1.setLayout(null);

cp=new JPanel(null,true);

cp.setBackground(Color.white);
cp.setLocation(0,30);
cp.setSize(400,565);
cp1.add(cp);

Color cvz=new Color(125,135,165);
j1=new JPanel(null,true);
Font fp=new Font("Arial",Font.BOLD,14);
JLabel lz=new JLabel("Mirror Player");
lz.setFont(fp);
lz.setBounds(10,02,100,26);
j1.add(lz);

b11=new JButton("-");
b11.setBounds(315,03,40,20);
//j1.add(b11);

ImageIcon il=new ImageIcon("image/a.gif");
b12=new JButton(il);
b12.setBounds(355,03,20,20);
j1.add(b12);

b11.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent e){
try{
setVisible(false);
System.out.println("Press 0 to Open Player Window");

}catch(Exception fr){}
}
});

b12.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent e){
try{
System.exit(0);
}catch(Exception fr){}
}
});

j3=new JPanel(null,true);
Color cvz1=new Color(135,145,155);
j3.setSize(390,90);
j3.setLocation(05,03);
j3.setBackground(cvz1);
cp.add(j3);

j1.setLocation(0,0);
j1.setBackground(cvz);
j1.setSize(400,30);
cp1.add(j1);




int hz=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
int vz=ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;

ImageIcon il1=new ImageIcon("image/play.gif");
b1=new JButton(il1);
ImageIcon il2=new ImageIcon("image/pause.gif");
b2=new JButton(il2);
ImageIcon il3=new ImageIcon("image/add2.gif");
b3=new  JButton(il3);
ImageIcon il6=new ImageIcon("image/del.gif");
b4=new JButton(il6);
ImageIcon il4=new ImageIcon("image/add.gif");
b5=new JButton(il4);
ImageIcon il5=new ImageIcon("image/remove.gif");
b6=new JButton(il5);		
b7=new JButton("Add Playlist");



try{
UIManager.setLookAndFeel("com.sun.javax.swing.plaf.WindowsLookAndFeel");

}catch(Exception se){ }





jt=new JTextField();
//  System.out.println("all rights Reserved : Pravin H. Rane");
jt.setBounds(10,50,370,30);
jt.setEditable(false);
model=new DefaultListModel();
l=new  JList(model);

ImageIcon il22=new ImageIcon("image/mymusic.gif");
jk2=new JLabel(il22);
jk2.setVisible(false);
jk2.setBounds(180,100,180,45);
jk2.setForeground(Color.red);
//cp.add(jk2);

ImageIcon il21=new ImageIcon("image/author.gif");
JLabel jk12=new JLabel(il21);

jk12.setBounds(20,100,180,45);
jk12.setForeground(Color.red);
cp.add(jk12);

timer=new JTextField();
timer.setBounds(250,90,70,25);
cp.add(timer);

timer.setText("00:00:00");
setVisible(true);



int delay = 1; //milliseconds
  ActionListener taskPerformer = new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        as=as+1;  
	timer.setText("0"+u+":"+as+"  Sec");
	if(as==60)
	{
	u=u+1;
	
	timer.setText("0"+u+":"+as+"  Sec");
	t.stop();
	t.restart();
	t.setRepeats(true);
	vb.setValue(u);
	}
	//...Perform a task...
      }
  };

t=new Timer(delay, taskPerformer);

//t.setMaximum(60);

vb=new JSlider();
vb.setBounds(210,120,150,25);
cp.add(vb);vb.setMinimum(0);
vb.setMaximum(5);


JLabel jk=new JLabel("Playlist");
jk.setBounds(60,100,100,25);
jk.setForeground(Color.red);
//cp.add(jk);

//l.setBorder( 5, Color.black);
l.setBackground(Color.black);
l.setForeground(Color.red);
JScrollPane jsp=new JScrollPane(l,vz,hz);
jsp.setBounds(10,150,350,400);
cp.add(jsp);
j3.add(jt);
b1.setEnabled(true);
b2.setEnabled(false);
b1.setBounds(10,02,43,43);
b2.setBounds(60,02,43,43);
b3.setBounds(115,02,43,43);
b4.setBounds(160,02,43,43);
b5.setBounds(250,02,43,43);
b6.setBounds(300,02,43,43);


j3.add(b1);
j3.add(b2);
j3.add(b3);
j3.add(b4);
j3.add(b5);
j3.add(b6);
j3.add(b7);

try{
FileReader rk1=new FileReader("Playlist/playlist.dat");
JTextField jtk=new JTextField();
jtk.read(rk1,null);
int vk=Integer.parseInt(jtk.getText());
rk1.close();

for(int z=0;z<vk;z++)
{
FileReader tr=new FileReader("Playlist/Mysong"+z+".mmm");
JTextField lk=new JTextField();
lk.read(tr,null);
if(!lk.getText().equals("nullnull")){
model.addElement(lk.getText());


}
else{
System.out.println("Playlist Contain an empty playlist File");
System.out.println("File name :"+"Playlist/Mysong"+z+"\n\n\n\n");
}
tr.close();

}

}catch(Exception dem){System.out.println(dem);}


b7.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent e){
try{

FileReader rr1=new FileReader("Playlist/playlist.dat");
JTextField jtg=new JTextField();
jtg.read(rr1,null);
int v=Integer.parseInt(jtg.getText());
rr1.close();

FileWriter wr1=new FileWriter("MySong"+v+".mmm");
wr1.write(jt.getText());
wr1.close();


FileWriter wr2=new FileWriter("Playlist/playlist.dat");
v=v+1;
wr2.write(v+"");
wr2.close();

 


}catch(Exception de){}

}
});


b3.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent e){
try{
if(jt.getText().equals(""))
{
b1.setEnabled(true);
b2.setEnabled(false);
}
else{
b1.setEnabled(false);
b2.setEnabled(true);
}//  System.out.println("all rights Reserved : Pravin H. Rane");

JFrame f1=new JFrame();
FileDialog d=new FileDialog(f1,"Select Music File");
d.setVisible(true);

String f=d.getFile(); 


String dir=d.getDirectory();
if(!f.equals(""))
{
model.addElement(dir+f);
}
else{
System.out.println("Error In File Reading or File not Selected !");
}

try{
FileReader r=new FileReader("Playlist.wpl");
JTextField jj=new JTextField();
jj.read(r,null);
r.close();

 
FileWriter w=new FileWriter("Playlist.wpl");
w.write(jj.getText()+"\n"+dir+f);
w.close();



}catch(Exception fe){  
try{ FileWriter w1=new FileWriter("Playlist.wpl");
w1.write(dir+f);
w1.close();} catch(Exception fd){} }



File temp1=new File(dir+f);

try{

FileReader rr1=new FileReader("Playlist/playlist.dat");
JTextField jtg=new JTextField();
jtg.read(rr1,null);
int v=Integer.parseInt(jtg.getText());
rr1.close();

FileWriter wr1=new FileWriter("Playlist/MySong"+v+".mmm");
wr1.write(dir+f);
wr1.close();


FileWriter wr2=new FileWriter("Playlist/playlist.dat");
v=v+1;
wr2.write(v+"");
wr2.close();
}catch(Exception fer){System.out.println(fer);}

}catch(Exception de){  System.out.println(de);}




}//  System.out.println("all rights Reserved : Pravin H. Rane");
});


b1.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent e){

	try{
	jk2.setVisible(true);
	b1.setEnabled(false);
	b2.setEnabled(true);
	String str=(String)l.getSelectedValue();
	File temp=new File(str);
	String name=temp.getName();
	jt.setText("Now Playing : "+name);
	p=Manager.createPlayer(temp.toURL());
	p.start();

	double lb=p.getDuration().getSeconds();
	//vb.setMaximum(ln);
	int ss = (int) lb%60; 		
	int ms = (int)(lb/60)%60;		
	int hs = (int)((lb/60)/60)%60;

	System.out.println(hs+":"+ms+":"+ss+" Sec");
	int z=l.getSelectedIndex();
	System.out.println(z+"");
	double ln2=p.getMediaTime().getSeconds();
	System.out.println(ln2+"");
	
	double lb2=p.getDuration().getSeconds();
	System.out.println(lb2+" total");
	t.start();
	vb.setMaximum((int)lb2);
	lb2=lb2/60;
	
	System.out.println(lb2+" min");
	lb2=lb2/60;
	
	System.out.println(lb2+" sec");


		
		run();

	   }
		
		catch ( IOException iOException )
		{
		     System.err.println( "Error reading from the source" );
		}
		
		
catch(Exception fe){ 
    
try{



String str=(String)l.getSelectedValue();
File temp=new File(str);
jt.setText(str);
AudioClip a=Applet.newAudioClip(temp.toURL());
a.play();
}catch(Exception de){}
 }
}
});


b2.addActionListener(new ActionListener()
{//  System.out.println("all rights Reserved : Pravin H. Rane");
public void actionPerformed(ActionEvent e){
b1.setEnabled(true);

b2.setEnabled(false);
jk2.setVisible(false);
p.stop();

}

});
b4.addActionListener(new ActionListener()
{//  System.out.println("all rights Reserved : Pravin H. Rane");
public void actionPerformed(ActionEvent e){
String str=(String)l.getSelectedValue();
model.removeElement(str);
}
});


b5.addActionListener(new ActionListener()
{//  System.out.println("all rights Reserved : Pravin H. Rane");
public void actionPerformed(ActionEvent e){

	

//p.setVolumeLevel(String.valueOf(vb.getValue()));                                                                 
				

}
});

//  System.out.println("all rights Reserved : Pravin H. Rane");
}
void run()
{
Date d=new Date();
int m=d.getMinutes();
int h=d.getHours();
int s=d.getSeconds();

		double l = p.getMediaTime().getSeconds();
		
		int seconds = (int) l%60; 
		
		int minutes = (int)(l/60)%60;
		
		int hour = (int)((l/60)/60)%60;
		System.out.println(seconds+" "+minutes);

}

public static void main(String args[])
{
player1 p=new player1("Mirror Player");
p.setVisible(true);
p.setSize(400,600);
} 
}




