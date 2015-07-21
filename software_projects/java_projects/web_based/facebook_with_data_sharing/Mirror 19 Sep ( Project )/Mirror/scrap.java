import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JApplet;
import javax.swing.JButton;
import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.io.File.*;

class scrap extends JFrame
{
JLabel name,last,city,con,email,dob,about,l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,image;
JPanel j1,j2,j3,j4,j5,j6,j7,j8,j9;
JTextField t1,t2,t3,t4,t5;
ImageIcon i1,i2,i3,i4,i5,i6,i7,i8,i9,i10,i11,i12;
JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14,b15,b16,b17,b18,b19;	
String str,str1="",str2="",str3="",str4="",str5="",str6="",str7="",myname="";
JTextArea a1,a2,a3,a4;
Container cp;
JComboBox c1,c2,c3,c4,c5;
Button bv1,bv2,bv3,r1,r2,r3;
int len;
int y;
String temp;
String font="";
int size=12;

scrap()
{
super("My Messages");

t2=new JTextField();

cp=getContentPane();
cp.setLayout(null);

try{

FileReader cv=new FileReader("res.xml");
t1=new JTextField();
t1.read(cv,null);
cv.close();
str1=t1.getText();
len=str1.length();

	int mgr=0;
	for(int k=0;k<len;k++)
 	{
	  char ch=str1.charAt(k);
	 // System.out.println(ch);
	    if(ch=='<' && str1.charAt(k+1)=='s' && str1.charAt(k+2)=='r' && str1.charAt(k+3)=='>')
	      {
	       for(int j=k+4;j<len;j++)
	        {
		//System.out.println("Match Found");
	         char ch2=str1.charAt(j);
	           if(ch2!='<' && str1.charAt(j+1)!='/' && str1.charAt(j+2)!='s' && str1.charAt(j+3)!='r'  && str1.charAt(j+4)!='>' ){
			//System.out.println("Char Found");
		         str5=str5+ch2;
		         }
			
	          else{
		         break;	}				
	       }       	
		 //System.out.println("Msg=" + str5);	
		 temp=str5;
		 y=Integer.parseInt(str5);
		
		 System.out.println("Total Message="+y);

		 }	
	}

}catch(Exception gt){ System.out.println(gt); }


int h=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS;
int v=ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS;

j1=new JPanel(null,true);



b1=new JButton();
b1.setBounds(10,20,100,100);
j1.add(b1);
a1=new JTextArea();
a1.setEditable(false);
JScrollPane jsp=new JScrollPane(a1,v,h);
jsp.setBounds(130,04,350,120);
j1.add(jsp);


bv1=new Button("Save Message");
bv1.setBounds(560,80,120,30);
cp.add(bv1);

r1=new Button("Reply To User");
r1.setBounds(560,130,120,30);
cp.add(r1);

j1.setBounds(40,40,500,150);
cp.add(j1);


j1.setBorder(
      BorderFactory.createCompoundBorder(
        BorderFactory.createTitledBorder("Message"),
        BorderFactory.createEmptyBorder(5,0,5,5)));

j2=new JPanel(null,true);


b2=new JButton();
b2.setBounds(10,20,100,100);
j2.add(b2);

a2=new JTextArea();
a2.setEditable(false);
JScrollPane jsp2=new JScrollPane(a2,v,h);
jsp2.setBounds(130,04,350,120);
j2.add(jsp2);

bv2=new Button("Save Message");
bv2.setBounds(560,240,120,30);
cp.add(bv2);

r2=new Button("Reply To User");
r2.setBounds(560,300,120,30);
cp.add(r2);

j2.setBounds(40,210,500,150);
cp.add(j2);


j2.setBorder(
      BorderFactory.createCompoundBorder(
        BorderFactory.createTitledBorder("Message"),
        BorderFactory.createEmptyBorder(5,0,5,5)));


j3=new JPanel(null,true);


b3=new JButton();
b3.setBounds(10,20,100,100);
j3.add(b3);
a3=new JTextArea();
JScrollPane jsp3=new JScrollPane(a3,v,h);
jsp3.setBounds(130,04,350,120);
j3.add(jsp3);
a3.setEditable(false);
bv3=new Button("Save Message");
bv3.setBounds(560,410,120,30);
cp.add(bv3);


r3=new Button("Reply To User");
r3.setBounds(560,460,120,30);
cp.add(r3);

j3.setBounds(40,380,500,150);
cp.add(j3);

j3.setBorder(
      BorderFactory.createCompoundBorder(
        BorderFactory.createTitledBorder("Message"),
        BorderFactory.createEmptyBorder(5,0,5,5)));

j4=new JPanel(null,true);



j4.setBounds(0,0,800,30);
Toolkit t=Toolkit.getDefaultToolkit();
String str33[]=t.getFontList();


cp.add(j4);
c1=new JComboBox();
c1.addItem("Arial");
c1.addItem("Arial Black");
c1.addItem("TimesRoman");
c1.addItem("Courier");
c1.addItem("Helvetica");
c1.setBounds(60,06,120,20);
j4.add(c1);
cp.add(j4);

c2=new JComboBox();
for(int x=8;x<78;x++)
{
c2.addItem(x+"");
}
c2.setBounds(210,06,120,20);
j4.add(c2);

b11=new JButton("Home");
b11.setBounds(360,06,100,20);
j4.add(b11);

b12=new JButton("Next");
b12.setBounds(480,06,100,20);
j4.add(b12);

b9=new JButton("Next");
b9.setBounds(480,06,100,20);
b9.setVisible(false);
j4.add(b9);

b10=new JButton("Next");
b10.setBounds(480,06,100,20);
b10.setVisible(false);
j4.add(b10);

j4.setBorder(
      BorderFactory.createCompoundBorder(
        BorderFactory.createTitledBorder("Setting"),
        BorderFactory.createEmptyBorder(0,0,5,5)));

try{
	//for(int u=y-1;u<-1;u--)
	{
        int mgr=0;
	str5="Message Box Empty!";
	for(int k=0;k<len;k++)
 	{
	  //t2.setText(y+"");
	  //temp=t2.getText();
	  //y--;	
	  //char ch4=temp.charAt(0);
	  

	  char ch=str1.charAt(k);
	  //System.out.println(ch);
	    if(ch=='<' && str1.charAt(k+1)=='s' && str1.charAt(k+2)=='r' && str1.charAt(k+3)=='0' && str1.charAt(k+4)=='>' )
	      {
		str5="";
	       for(int j=k+5;j<len;j++)
	        {
		//System.out.println("Match Found");
	             char ch2=str1.charAt(j);
	             if(ch2!='<'){
			//System.out.println("Char Found"+ch2);
		         str5=str5+ch2;
		         }
			
	          else{
		         break;	}				
	       }       	
		 System.out.println("Msg"+y+"=" + str5);	
		 a1.setText(str5);
		  if(a1.getText().equals(" ") || a1.getText()==" " ||a1.getText().equals(null) || a1.getText()==null )
		 {
		   a1.setText("Empty Message");	
		 }	

		 System.out.println("y="+y);

		 }	
		
	}	 	
	
	}
}catch(Exception ft){System.out.println(ft);}






	
try{
	//for(int u=y-1;u<-1;u--)
	{
        int mgr=0;
	str5="";
	str5="Message Box Empty";
	for(int k=0;k<len;k++)
 	{
	  //t2.setText(y+"");
	  //temp=t2.getText();
	  //y--;	
	  //char ch4=temp.charAt(0);
	  

	  char ch=str1.charAt(k);
	 // System.out.println(ch);
	    if(ch=='<' && str1.charAt(k+1)=='s' && str1.charAt(k+2)=='r' && str1.charAt(k+3)=='1' && str1.charAt(k+4)=='>' )
	      {
		str5="";
	       for(int j=k+5;j<len;j++)
	        {
		//System.out.println("Match Found");
	             char ch2=str1.charAt(j);
	             if(ch2!='<'){
			//System.out.println("Char Found"+ch2);
		         str5=str5+ch2;
		         }
			
	          else{
		         break;	}				
	       }   
	       	    	
		 System.out.println("Msg"+y+"=" + str5);	
		 a2.setText(str5);
		 if(str5.equals(" ") || str5==" " ||a2.getText().equals(null) || a2.getText()==null )
		 {
		   a2.setText("Empty Message");	
		 }	
		 System.out.println("y="+y);

		 }

			
	}	 	
	
	}
}catch(Exception ft){System.out.println(ft);}









try{
	//for(int u=y-1;u<-1;u--)
	{
        int mgr=0;
	str5="";
	str5="Message Box Empty!";
	for(int k=0;k<len;k++)
 	{
	  //t2.setText(y+"");
	  //temp=t2.getText();
	  //y--;	
	  //char ch4=temp.charAt(0);
	  

	  char ch=str1.charAt(k);
	 // System.out.println(ch);
	    if(ch=='<' && str1.charAt(k+1)=='s' && str1.charAt(k+2)=='r' && str1.charAt(k+3)=='3' && str1.charAt(k+4)=='>' )
	      {
		str5="";
	       for(int j=k+5;j<len;j++)
	        {
		//System.out.println("Match Found");
	             char ch2=str1.charAt(j);
	             if(ch2!='<'){
			//System.out.println("Char Found"+ch2);
		         str5=str5+ch2;
		         }
			
	          else{
		         break;	}				
	       }    
	      	   	
		 System.out.println("Msg"+y+"=" + str5);	
		 a3.setText(str5);
		   if(str5.equals("") || str5=="" || a3.getText().equals(null) || a3.getText()==null )
		 {
		   a3.setText("Empty Message");	
		 }	
		 System.out.println("y="+y);

		 }
		 
	}	 	
	
	}
}catch(Exception ft){System.out.println(ft);}


//Action Listeners

		bv1.addActionListener(new ActionListener()
		{
		public void actionPerformed(ActionEvent e)
		{
		try{
		JFrame jf=new JFrame();
		FileDialog d=new FileDialog(jf,"Save Message File");
		d.setMode(FileDialog.SAVE);
		d.setVisible(true);

		String dir=d.getDirectory();
		String file=d.getFile();

		FileWriter g=new FileWriter(dir+file+".log");
		g.write(a1.getText());
		g.close();
		}catch(Exception fr){}		
		}
		});

		bv2.addActionListener(new ActionListener()
		{
		public void actionPerformed(ActionEvent e)
		{
		try{
		JFrame jf=new JFrame();
		FileDialog d=new FileDialog(jf,"Save Message File");
		d.setMode(FileDialog.SAVE);
		d.setVisible(true);

		String dir=d.getDirectory();
		String file=d.getFile();

		FileWriter g=new FileWriter(dir+file+".log");
		g.write(a2.getText());
		g.close();
		}catch(Exception fr){}		
		}
		});

		bv3.addActionListener(new ActionListener()
		{
		public void actionPerformed(ActionEvent e)
		{
		try{
		JFrame jf=new JFrame();
		FileDialog d=new FileDialog(jf,"Save Message File");
		d.setMode(FileDialog.SAVE);
		d.setVisible(true);

		String dir=d.getDirectory();
		String file=d.getFile();

		FileWriter g=new FileWriter(dir+file+".log");
		g.write(a3.getText());
		g.close();
		}catch(Exception fr){}		
		}
		});
		
		c1.addItemListener(new ItemListener()
		{
		public void itemStateChanged(ItemEvent d)
		{
		font=(String)d.getItem();
		a1.setFont(new Font(font,Font.PLAIN,size));
		a2.setFont(new Font(font,Font.PLAIN,size));
		a3.setFont(new Font(font,Font.PLAIN,size));

		}
		});
		
		c2.addItemListener(new ItemListener()
		{
		public void itemStateChanged(ItemEvent d)
		{
		String str=(String)d.getItem();
		JTextField ty=new JTextField();
		ty.setText(str+"");
		System.out.println("Font Size="+str);
		size=Integer.parseInt(ty.getText());
		a1.setFont(new Font(font,Font.PLAIN,size));
		a2.setFont(new Font(font,Font.PLAIN,size));
		a3.setFont(new Font(font,Font.PLAIN,size));

		}
		});

		b11.addActionListener(new ActionListener()
		{
		public void actionPerformed(ActionEvent e)
		{
		try{

		Runtime ty=Runtime.getRuntime();
		ty.exec("ServerRun.bat");
		System.out.println("Start client");

		Thread.sleep(1000);

		pro p=new pro();
		p.setVisible(true);
		setVisible(false);
		
		p.setSize(800,600);

		}catch(Exception hy){}
		}
		});


		

}
}
