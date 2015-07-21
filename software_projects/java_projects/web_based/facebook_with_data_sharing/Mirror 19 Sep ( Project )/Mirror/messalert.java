import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.io.File.*;
import javax.media.*;
import javax.swing.event.*;
import javax.sound.midi.*; 

class messalert extends JFrame 
{
JLabel l,l4,l2;
profile ff;
JTextArea reply,get;
JButton button1,button2,button3,b4,refresh;
JTextField jt;
Player player;
FileWriter w;
FileReader r;
String str1,month;
Container cp;
int g=0,jj=0;
int i=0;
JPopupMenu popup;
String pravin="";
messalert(String name,String mess)
{
super(name);
str1=mess;
cp=getContentPane();
cp.setLayout(null);

popup=new JPopupMenu();
int h=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS;
int v=ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS;

l=new JLabel();
l.setBounds(10,10,90,30);
cp.add(l);

b4=new JButton();
b4.setBounds(40,10,70,70);
cp.add(b4);
//  System.out.println("all rights Reserved : Pravin H. Rane");
refresh=new JButton("Refresh");
refresh.setBounds(230,10,90,25);
cp.add(refresh);


l2=new JLabel();
l2.setBounds(130,60,70,20);
cp.add(l2);
//  System.out.println("all rights Reserved : Pravin H. Rane");
get=new JTextArea();
get.setEditable(false);
get.setForeground(Color.darkGray);
JScrollPane j=new JScrollPane(get,v,h);
j.setBounds(90,90,350,100);
cp.add(j);

JLabel l1=new JLabel("Reply  To User");
l1.setBounds(10,210,100,30);
cp.add(l1);

reply=new JTextArea();
JScrollPane js=new JScrollPane(reply,v,h);
js.setBounds(90,230,350,100);
cp.add(js);
//  System.out.println("all rights Reserved : Pravin H. Rane");

button1=new JButton("Send");
button1.setBounds(20,360,60+40,30);
cp.add(button1);

button2=new JButton("Send Image");
button2.setBounds(100+40,360,60+50,30);
cp.add(button2);

button3=new JButton("Send  File");
button3.setBounds(180+90,360,60+40,30);
cp.add(button3);
//  System.out.println("all rights Reserved : Pravin H. Rane");

try{
FileReader rq=new FileReader(str1+"/"+"Scrap"+"/"+"last.txt");
JTextField jtq=new JTextField();
jtq.read(rq,null);
rq.close();

if(!get.getText().equals(jtq.getText()))
{
		// File fx=new File("Message.Wav");
		// player=Manager.createPlayer(fx.toURL());
		// player.start();
}

}catch(Exception dec){System.out.println(dec);}

try{
FileWriter wv=new FileWriter(str1+"/file.dat");
wv.write(0+"");
wv.close();

FileReader r=new FileReader(str1+"/"+"Scrap"+"/"+"pointer.dat");
jt=new JTextField();
jt.read(r,null);
g=Integer.parseInt(jt.getText());


g=g-1;
r.close();

FileReader r3=new FileReader(str1+"/"+"scrap"+"/"+g+".user");
jt=new JTextField();
jt.read(r3,null);
l2.setText(jt.getText());
l2.setForeground(Color.red);
r3.close();

FileReader tr= new FileReader(jt.getText()+"/imagepath.txt");
JTextField vv=new JTextField();
vv.read(tr,null);
ImageIcon ii=new ImageIcon(vv.getText());
b4.setIcon(ii);
tr.close();
//  System.out.println("all rights Reserved : Pravin H. Rane");



FileReader r11=new FileReader(str1+"/"+"scrap"+"/"+g+".txt");
jt=new JTextField();
jt.read(r11,null);
get.setText(jt.getText());
pravin=get.getText();
try{
FileWriter wc=new FileWriter(str1+"/"+"Scrap"+"/"+"last.txt");
wc.write(pravin+"");
wc.close();
}catch(Exception fe){System.out.println(fe);}
//  System.out.println("all rights Reserved : Pravin H. Rane");
r11.close();

FileReader rn=new FileReader(str1+"/file.dat");
JTextField ft=new JTextField();
ft.read(rn,null);
int gg=Integer.parseInt(ft.getText());
rn.close();
if(gg==1)
{
error e=new error("File was Received !!!");
e.setVisible(true);
e.setSize(120,100);
e.setLocation(90,90);
//  System.out.println("all rights Reserved : Pravin H. Rane");
FileReader r111=new FileReader(str1+"/"+"scrap"+"/"+g+".txt");
jt=new JTextField();
jt.read(r111,null);
r111.close();

FileWriter w=new FileWriter(str1+"/"+jj+".rar");
w.write(jt.getText());
w.close();
//  System.out.println("all rights Reserved : Pravin H. Rane");
FileWriter ww=new FileWriter(str1+"/file.dat");
ww.write(0+"");
ww.close();	 
}	

}catch(Exception se){System.out.println(se);}

popup.addMouseListener(new MouseListener()
{

public void  mouseClicked(MouseEvent de){    
		int x=getX();
		int y=getY();
		}
public void  mousePressed(MouseEvent ne){   }
public void  mouseEntered(MouseEvent ce){   }
public void  mouseReleased(MouseEvent ae){   }
public void  mouseExited(MouseEvent le){   }

});


button1.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent de)
{

try{
//  System.out.println("all rights Reserved : Pravin H. Rane");
FileReader r2=new FileReader(str1+"/"+"scrap"+"/"+"pointer.dat");
jt=new JTextField();
jt.read(r2,null);
g=Integer.parseInt(jt.getText());
g=g-1;
r2.close();

r=new FileReader(str1+"/scrap/"+g+".user");
jt=new JTextField();
jt.read(r,null);
r.close();

FileReader  r3=new FileReader(jt.getText()+"/scrap/pointer.dat");
JTextField jt1=new JTextField();
jt1.read(r3,null);
r3.close();

w=new FileWriter(jt.getText()+"/scrap/"+jt1.getText()+".txt");
Date d=new Date();
long da=d.getDate();
long m=d.getMonth();
long h=d.getHours();
long mi=d.getMinutes();
long se=d.getSeconds();
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
reply.setText(reply.getText()+"\n \n \n"+h+":"+mi+":"+se+"\n"+da+"  "+month);
//  System.out.println("all rights Reserved : Pravin H. Rane");
w.write(reply.getText());

w.close();

w=new FileWriter(jt.getText()+"/scrap/"+jt1.getText()+".user");
w.write(str1);
w.close();


FileReader r1=new FileReader(jt.getText()+"/"+"scrap"+"/"+"pointer.dat");
JTextField jt2=new JTextField();
jt2.read(r1,null);
i=Integer.parseInt(jt2.getText());
r1.close();

w=new FileWriter(jt.getText()+"/scrap/pointer.dat");
i++;
w.write(i+"");
w.close();

w=new FileWriter(jt.getText()+"/scrap/pointer1.dat");

w.write(i+"");
w.close();


reply.setText(null);

error e=new error("Message send Successfully!!!");
e.setVisible(true);
e.setSize(200,100);
e.setLocation(50,50);
}catch(IOException se){  System.out.println(se); }
}
});
//  System.out.println("all rights Reserved : Pravin H. Rane");


button2.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent de)
{
JFileChooser f=new JFileChooser();
while(true)
{
int val=f.showOpenDialog(messalert.this);
File file=f.getSelectedFile();
if(val==JFileChooser.CANCEL_OPTION || val==-1)
{
break;
}
else
{
String str=file.getPath();
reply.setText(str+"");
}

}

}
});
button3.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent de)
{
try{
FileWriter w=new FileWriter(str1+"/file.dat");
w.write(1);
w.close();
}catch(Exception ge){}
JFileChooser f=new JFileChooser();
while(true)
{
int val=f.showOpenDialog(messalert.this);
File file=f.getSelectedFile();
String path=file.getPath();
if(val==JFileChooser.CANCEL_OPTION || val==-1)
{
break;
}
else
{
try{
FileReader r=new FileReader(path);
JTextArea a1=new JTextArea();
a1.read(r,null);
r.close();
reply.setText(a1.getText());		
}catch(Exception se){ System.out.println("Server Down");}
}

}
}
});
b4.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent de)
{	
	
	
	profile1 p=new profile1("Profile1",str1,l2.getText());
	setVisible(false);
	p.setVisible(true);
	p.setSize(800,800);
	p.setLocation(10,10);

}
});

refresh.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent de)
{
	messalert m=new messalert("Message Alert",str1);
	setVisible(false);
	m.setVisible(true);
	m.setSize(450,450);
	m.setLocation(90,90);

		

	
}
});


}
}