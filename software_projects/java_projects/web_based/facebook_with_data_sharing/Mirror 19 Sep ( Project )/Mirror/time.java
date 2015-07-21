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


class time extends JFrame 
{
JTextField   jt;
JButton b;
time()
{
Container cp=getContentPane();
cp.setLayout(new BorderLayout());
b=new JButton("Ok");
jt=new JTextField();
cp.add(jt,BorderLayout.CENTER);
cp.add(b,BorderLayout.SOUTH);

Date d=new Date();


long h=d.getHours();
long m=d.getMinutes();
long s=d.getSeconds();
jt.setText( "Time :" +h+":"+m+":"+s);

return;



}
} 
