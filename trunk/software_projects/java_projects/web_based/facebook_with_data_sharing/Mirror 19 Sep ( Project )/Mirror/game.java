import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.io.File.*;
import java.net.*;
import java.applet.AppletContext.*;
import java.applet.AppletContext;  

class game extends JWindow
{
JButton b1,b2,b3,b4,b5,b6,b7,b8,b9;
//  Additional Buttons For  Post Implementations
// JButton  pp,pr,pa,pv,pi,pn,pr,pa,pn,pe;
JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10;
Container cp1;
JPanel j1,cp;

game(){

cp1=getContentPane();
try

		{

			UIManager.setLookAndFeel ("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");

		}

		catch(Exception e)
		{}

cp1.setLayout(null);

cp=new JPanel(null,true);
cp.setLocation(0,30);
cp.setBackground(Color.white);
cp.setSize(550,450);
cp1.add(cp);



j1=new JPanel(null,true);
JLabel lk=new JLabel("Games");
Font fcv=new Font("Arial",Font.BOLD,16);
lk.setFont(fcv);
lk.setBounds(30,02,100,30);

j1.add(lk);
JButton x=new JButton("X");
x.setBounds(510,02,38,28);
j1.add(x);

x.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent e){
setVisible(false);

}
});

Color cvz=new Color(125,135,165);
j1.setBackground(cvz);
j1.setLocation(0,0);
j1.setSize(550,30);
cp1.add(j1);

Font f=new Font("Arial",Font.BOLD,14);
ImageIcon i1=new ImageIcon("image/1.gif");
b1=new JButton(i1);
l1=new JLabel("cannon-blast");
l1.setForeground(Color.magenta);
l1.setFont(f);
l1.setBounds(10,160,150,20);
cp.add(l1);
b1.setBounds(10,10,150,150);
cp.add(b1);



ImageIcon i2=new ImageIcon("image/2.gif");
b2=new JButton(i2);
l2=new JLabel("disc-golf");
l2.setForeground(Color.magenta);
l2.setFont(f);
l2.setBounds(190,160,150,20);
cp.add(l2);
b2.setBounds(190,10,150,150);
cp.add(b2);

ImageIcon i3=new ImageIcon("image/3.gif");
b3=new JButton(i3);
l3=new JLabel("reel-gold");
l3.setForeground(Color.magenta);
l3.setFont(f);
l3.setBounds(360,160,150,20);
cp.add(l3);
b3.setBounds(360,10,150,150);
cp.add(b3);

ImageIcon i4=new ImageIcon("image/4.gif");
b4=new JButton(i4);
l4=new JLabel("king-of-the-hill");
l4.setForeground(Color.magenta);
l4.setFont(f);
l4.setBounds(10,380,150,20);
cp.add(l4);
b4.setBounds(10,220,150,150);
cp.add(b4);



ImageIcon i5=new ImageIcon("image/5.gif");
b5=new JButton(i5);
l5=new JLabel("samurai-warrior");
l5.setForeground(Color.magenta);
l5.setFont(f);
l5.setBounds(190,380,150,20);
cp.add(l5);
b5.setBounds(190,220,150,150);
cp.add(b5);


ImageIcon i6=new ImageIcon("image/6.gif");
b6=new JButton(i6);
l6=new JLabel("  Avatar ");
l6.setForeground(Color.magenta);
l6.setFont(f);
l6.setBounds(360,380,150,20);
cp.add(l6);
b6.setBounds(360,220,150,150);
cp.add(b6);

b7=new JButton(" Next > ");
b7.setBounds(190,400,150,40);
//cp.add(b7);

b8=new JButton(" < Prev ");
b8.setBounds(30,400,150,40);
//cp.add(b8);

b1.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent e){
try{
Runtime r=Runtime.getRuntime();
r.exec("games/cannon-blast.exe");
System.out.println("Checking Free Memory :"+r.totalMemory()); 
URL u=new URL("file://1.wav");
// System.out.println("  Audio Clip");
AudioClip a=Applet.newAudioClip(u);
// System.out.println("Playing  ");
a.loop();
File f=new File("1.wav");
a.play();
// System.out.println("  Looping");

// System.out.println(" Stoping ");
a.stop();



URL u2=new URL("doc://1.wav");
// System.out.println("  Audio Clip");
AudioClip a2=Applet.newAudioClip(u);
System.out.println("Playing  ");
a2.loop();

a2.play();
// System.out.println("  Looping");

// System.out.println(" Stoping ");
a2.stop();
}catch(Exception fe){ }


}
});
b2.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent e){
try{
Runtime r=Runtime.getRuntime();
r.exec("games/disc-golf.exe");
System.out.println(r.totalMemory()); 
}catch(Exception fe){ }

}
});

b3.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent e){
try{
Runtime r=Runtime.getRuntime();
r.exec("games/reel-gold.exe");
System.out.println(r.totalMemory()); 

}catch(Exception fe){ }

}
});
b4.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent e){
try{
Runtime r=Runtime.getRuntime();
r.exec("games/king-of-the-hill.exe");
System.out.println(r.totalMemory()); 
}catch(Exception fe){ }

}
});
b5.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent e){
try{
Runtime r=Runtime.getRuntime();
r.exec("games/samurai-warrior.exe");
System.out.println(r.totalMemory()); 
}catch(Exception fe){ }

}
});
b6.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent e){
try{
Runtime r=Runtime.getRuntime();
r.exec("games/avatar-the-last-air-bender-bending-battle.exe");
System.out.println(r.totalMemory()); 
}catch(Exception fr){}
}
});

}
}
                             