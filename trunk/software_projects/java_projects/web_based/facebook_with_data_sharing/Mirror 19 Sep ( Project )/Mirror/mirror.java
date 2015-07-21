


// Note : If you Inastall Java Media Framework  2.1 then Delete
// All "//" Values for this Mirror.java Files .

// Author : Pravin H. Rane


/*  <applet code="orkut.class"  width="500" height="300">
</applet>*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.*;
 import  java.applet.AudioClip;
import java.net.*;
import  java.applet.AppletContext.*;
import java.applet.AppletContext;  
import java.applet.*;
//   import java.net.URL;

import java.net.*;
import java.io.*;
// import javax.media.*;





public class mirror extends JFrame 
{
JProgressBar jb;
JButton b;
mirror()
{
 try{
//  File f=new File("Mirror.mp3");
//   Player p=Manager.createPlayer(f.toURL());
//   p.start();

//   AudioClip a=Applet.newAudioClip(f.toURL());
//   a.play();
}
catch(Exception de){}


}
public static void main(String args[])
{



String start,res;
ServerRun1 client;
BufferedReader br;
PrintWriter wr;

String msg;
char ch='y';


login l=new login("Login User");

mirror mk=new mirror();
Date d=new Date();
long date=d.getDate();
long m=d.getMonth();
long year=d.getYear();
long time=d.getTime();
long hour=d.getHours();
long min=d.getMinutes();
long sec=d.getSeconds();
String month="";
if(m==0){  month="Jan"; }
if(m==1){  month="Feb"; }
if(m==2){  month="Mar"; }
if(m==3){  month="Aprl"; }
if(m==4){  month="May"; }
if(m==5){  month="Jun"; }
if(m==6){  month="July"; }
if(m==7){  month="Aug"; }
if(m==8){  month="Sep"; }
if(m==9){  month="Oct"; }
if(m==10){  month="Nov"; }
if(m==11){  month="Dec"; }

System.out.println("Time :"+hour+":"+min+":"+sec   +"\n"+"Date  :"+date+"/"+month); 

System.out.println("@ MirrorZone.com");


l.setVisible(true);
l.setSize(800,780);

}
} 


