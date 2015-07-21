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


class play1 extends JFrame
{
FileReader r;
Player player;
JTextField jt;
int count=0;
int count1=0;
String str2="";
int i=3;
play1(String str)
{
str2=str;
System.out.println("Play1 Start");
try{
 	r=new FileReader(str+"/scrap/pointer.dat");
	jt=new JTextField();
	jt.read(r,null);
	count=Integer.parseInt(jt.getText());
	r.close();
	System.out.println("Message File Loaded !!");
	}catch(Exception de){System.out.println(de);}
try{
 
r=new FileReader(str+"/scrap/pointer.dat");
jt=new JTextField();
jt.read(r,null);
count1=Integer.parseInt(jt.getText());
r.close();

System.out.println("Count File Loadede !!");
System.out.println("File Counted !");
for(int j=0;j<1000;j++)
{
	
	if(count1>count)
	{
		File f=new File("Message.mp3");
		player=Manager.createPlayer(f.toURL());
		player.start();
		count=count1;
		play1 pp=new play1(str2);
	}
	if(j==999)
	{
	j=0;
	}

}
}catch(Exception fe){System.out.println(fe);}
}
}