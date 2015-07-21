 import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.io.File.*;
import java.io.*;
import java.net.*;


class pro extends JFrame
{
JLabel name,last,city,con,email,dob,about,l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,image,lv,lk,lk1,lk2;
JPanel j1,j2,j3,j4,j5,j6,j7,j8,j9;
JTextField t1,t2,t3,t4,t5;
ImageIcon i1,i2,i3,i4,i5,i6,i7,i8,i9,i10,i11,i12;
JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14,b15,b16,b17,b18,b19;	
String str,str1="",str2="",str3="",str4="",str5="",str6="",str7="",myname="";
Container cp;
int bg=1,fg=1,tm=1;
Color ru,mu,tu;
JButton n1,n2,n3,n4,n5,n6;
JPanel p1,p2,p3,p4,p5,p6;

pro(){
super("Profile");

cp=getContentPane();
cp.setLayout(null);

try

		{

			UIManager.setLookAndFeel ("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");

		}

		catch(Exception e)
		{}


try{
FileReader r=new FileReader("res.xml");
t1=new JTextField();
t1.read(r,null);
str1=t1.getText();
r.close();
}catch(Exception fr){}

	j1=new JPanel(null,true);
	
	int len=str1.length();


	name=new JLabel();
	try{
	
	for(int k=0;k<len;k++)
 	{
	  char ch=str1.charAt(k);
	 // System.out.println(ch);
	    if(ch=='<' && str1.charAt(k+1)=='f' && str1.charAt(k+2)=='>')
	      {
	       for(int j=k+3;j<len;j++)
	        {
	         char ch2=str1.charAt(j);
	           if(ch2!='<' && str1.charAt(j+1)!='/' && str1.charAt(j+2)!='f' && str1.charAt(j+3)!='>'){
		         str5=str5+ch2;
		         }
			
	          else{
		         break;	}				
	 			 }	
		 System.out.println(str5);			

		 }	
	}

	}catch(Exception de){}
	myname=str5;
	name.setText("Name="+str5);
	name.setBounds(10,10,150,20);
	j1.add(name);

// Last NAme

	last=new JLabel();
	try{
	str5="";
	
	for(int k=0;k<len;k++)
 	{
	  char ch=str1.charAt(k);
	//  System.out.println(ch);
	    if(ch=='<' && str1.charAt(k+1)=='l' && str1.charAt(k+2)=='>')
	      {
	       for(int j=k+3;j<len;j++)
	        {
	         char ch2=str1.charAt(j);
	           if(ch2!='<' && str1.charAt(j+1)!='/' && str1.charAt(j+2)!='l' && str1.charAt(j+3)!='>'){
		         str5=str5+ch2;
		         }
			
	          else{
		         break;	}				
	 			 }	
		 System.out.println(str5);			

		 }	
	}

	}catch(Exception de){}

	last.setText("Last Name="+str5);
	last.setBounds(10,25,150,20);
	j1.add(last);


// last name end


// Email
email=new JLabel();
try{
	str5="";
	
	for(int k=0;k<len;k++)
 	{
	  char ch=str1.charAt(k);
	//  System.out.println(ch);
	    if(ch=='<' && str1.charAt(k+1)=='e' && str1.charAt(k+2)=='>')
	      {
	       for(int j=k+3;j<len;j++)
	        {
	         char ch2=str1.charAt(j);
	                 if(ch2!='<' ){
		         str5=str5+ch2;
		         }
			
	          else{
		         break;	}				
	 			 }	
		 System.out.println(str5);			

		 }	
	}

	}catch(Exception de){System.out.println(de);}

	
	email.setText("E-mail="+str5);
	email.setBounds(10,45,250,20);
	j1.add(email);


//email end

//City 
city=new JLabel();
try{
	str5="";
	
	for(int k=0;k<len;k++)
 	{
	  char ch=str1.charAt(k);
	//  System.out.println(ch);
	    if(ch=='<' && str1.charAt(k+1)=='c' && str1.charAt(k+2)=='>')
	      {
	       for(int j=k+3;j<len;j++)
	        {
	        	 char ch2=str1.charAt(j);
	           if(ch2!='<' && str1.charAt(j+1)!='/' && str1.charAt(j+2)!='c' && str1.charAt(j+3)!='>'){
		         str5=str5+ch2;
		         }
			
	          else{
		         break;	}				
	 			 }	
		 System.out.println(str5);			

		 }	
	}

	}catch(Exception de){System.out.println(de);}

	
	city.setText("E-mail="+str5);
	city.setBounds(10,105,250,20);
	j1.add(city);

//End of City

j2=new JPanel(null,true);

 lk=new JLabel("About me");
Font f=new Font("Arial",Font.BOLD,14);
lk.setFont(f);
lk.setBounds(40,04,160,25);
lk.setBackground(Color.black);
Color c=new Color(100,200,100);
lk.setForeground(c);
j2.add(lk);

j2.setBackground(Color.black);
j2.setSize(200,30);
j2.setLocation(190,230);
cp.add(j2);

j1.setSize(200,200);
j1.setBackground(Color.white);
j1.setLocation(190,250); 
cp.add(j1);

// Date of Birth
dob=new JLabel();
try{
	str5="";
	
	for(int k=0;k<len;k++)
 	{
	  char ch=str1.charAt(k);
	//  System.out.println(ch);
	    if(ch=='<' && str1.charAt(k+1)=='d' && str1.charAt(k+2)=='>')
	      {
	       for(int j=k+3;j<len;j++)
	        {
	         char ch2=str1.charAt(j);
	           if(ch2!='<' && str1.charAt(j+1)!='/' && str1.charAt(j+2)!='d' && str1.charAt(j+3)!='>'){
		         str5=str5+ch2;
		         }
			
	          else{
		         break;	}				
	 			 }	
		 System.out.println(str5);			

		 }	
	}

	}catch(Exception de){System.out.println(de);}

	
	dob.setText("Date Of Birth="+str5);
	dob.setBounds(10,65,250,20);
	j1.add(dob);
	
	try{
	str5="";
	
	for(int k=0;k<len;k++)
 	{
	  char ch=str1.charAt(k);
	//  System.out.println(ch);
	    if(ch=='<' && str1.charAt(k+1)=='m' && str1.charAt(k+2)=='>')
	      {
	       for(int j=k+3;j<len;j++)
	        {
	         char ch2=str1.charAt(j);
	           if(ch2!='<' && str1.charAt(j+1)!='/' && str1.charAt(j+2)!='m' && str1.charAt(j+3)!='>'){
		         str5=str5+ch2;
		         }
			
	          else{
		         break;	}				
	 			 }	
		 System.out.println(str5);			

		 }	
	}

	}catch(Exception de){ System.out.println(de);}
	dob.setText(dob.getText()+"  "+ str5);

// End Of DOB

// Country
str5="";
con=new JLabel();
try{
	int mgr=0;
	for(int k=0;k<len;k++)
 	{
	  char ch=str1.charAt(k);
	 // System.out.println(ch);
	    if(ch=='<' && str1.charAt(k+1)=='c' && str1.charAt(k+2)=='o' && str1.charAt(k+3)=='>')
	      {
	       for(int j=k+4;j<len;j++)
	        {
		//System.out.println("Match Found");
	         char ch2=str1.charAt(j);
	           if(ch2!='<' && str1.charAt(j+1)!='/' && str1.charAt(j+2)!='c' && str1.charAt(j+3)!='o'  && str1.charAt(j+4)!='>' ){
			//System.out.println("Char Found");
		         str5=str5+ch2;
		         }
			
	          else{
		         break;	}				
	 			 }	
		 //System.out.println("Msg=" + str5);			

		 }	
	}

	}catch(Exception de){}
	
	con.setText("Contry="+str5);
	con.setBounds(10,105,250,20);
	j1.add(con);


//End Of Country

//Adding About Me

about=new JLabel();
str5=" ";
try{
	
	for(int k=0;k<len;k++)
 	{
	  char ch=str1.charAt(k);
	 // System.out.println(ch);
	    if(ch=='<' && str1.charAt(k+1)=='x' && str1.charAt(k+2)=='>')
	      {
	       for(int j=k+3;j<len;j++)
	        {
	         char ch2=str1.charAt(j);
	           if(ch2!='<' && str1.charAt(j+1)!='/' && str1.charAt(j+2)!='x' && str1.charAt(j+3)!='>'){
		         str5=str5+ch2;
		         }
			
	          else{
		         break;	}				
	 			 }	
		 System.out.println(str5);			

		 }	
	}

	}catch(Exception de){}

	
	about.setText("About me="+str5);
	about.setBounds(10,130,250,20);
	j1.add(about);

//End About



//End Of Country

//Adding About Me


str5=" ";
try{
	int mgr=0;
	for(int k=0;k<len;k++)
 	{
	  char ch=str1.charAt(k);
	 // System.out.println(ch);
	    if(ch=='<' && str1.charAt(k+1)=='c' && str1.charAt(k+2)=='o' && str1.charAt(k+3)=='>')
	      {
	       for(int j=k+4;j<len;j++)
	        {
		//System.out.println("Match Found");
	         char ch2=str1.charAt(j);
	           if(ch2!='<' && str1.charAt(j+1)!='/' && str1.charAt(j+2)!='c' && str1.charAt(j+3)!='o'  && str1.charAt(j+4)!='>' ){
			//System.out.println("Char Found");
		         str5=str5+ch2;
		         }
			
	          else{
		         break;	}				
	 			 }	
		 System.out.println("Msg=" + str5);			

		 }	
	}

	}catch(Exception de){}
	 System.out.println("Msg=" + str5);
	
//End About

String imagew="";
File fw1=new File("image/"+myname+".jpg");
if(fw1.isFile() && fw1.exists() )
{
imagew="image/"+myname+".jpg";
}

File fw2=new File("image/"+myname+".gif");
if(fw2.isFile() && fw2.exists() )
{
imagew="image/"+myname+".gif";
}

File fw3=new File("image/"+myname+".png");
if(fw3.isFile() && fw3.exists() )
{
imagew="image/"+myname+".png";
}

File fw4=new File("image/"+myname+".bmp");
if(fw4.isFile() && fw4.exists() )
{
imagew="image/"+myname+".bmp";
}

ImageIcon i7=new ImageIcon("image/pravin.jpg");
JLabel ima=new JLabel(i7);
ima.setBounds(10,10,120,120);
ima.setBackground(Color.green);
ima.setVisible(true);
cp.add(ima);

j3=new JPanel(null,true);

 lk2=new JLabel("My Task");

lk2.setFont(f);
lk2.setBounds(40,04,160,25);
lk2.setBackground(Color.black);

lk2.setForeground(c);
j3.add(lk2);

j3.setLocation(10,150);
j3.setBackground(Color.black);
j3.setSize(140,30);
cp.add(j3);

j4=new JPanel(null,true);

b1=new JButton(" Messages ");
b1.setBounds(10,10,120,30);
j4.add(b1);

b2=new JButton(" Setting ");
b2.setBounds(10,50,120,30);
j4.add(b2);

b3=new JButton(" Chatting ");
b3.setBounds(10,100,120,30);
j4.add(b3);

b5=new JButton(" Data Sharing ");
b5.setBounds(10,140,120,30);
j4.add(b5);

b6=new JButton(" Gotp Web ");
b6.setBounds(10,180,120,30);
j4.add(b6);

b7=new JButton(" Play Music ");
b7.setBounds(10,230,120,30);
j4.add(b7);

b8=new JButton(" Play Games ");
b8.setBounds(10,270,120,30);
j4.add(b8);



n1=new JButton(" Refresh ");
n1.setBounds(10,310,120,30);
j4.add(n1);




n2=new JButton(" Change Theme ");
n2.setBounds(10,350,120,30);
j4.add(n2);



n3=new JButton(" Send Message ");
n3.setBounds(10,350,120,30);
j4.add(n3);



j4.setLocation(10,180);
j4.setBackground(Color.white);
j4.setSize(140,400);
cp.add(j4);


// ActionListrers 


		b1.addActionListener(new ActionListener()
		{
		public void actionPerformed(ActionEvent e)
		{
		
		scrap sc=new scrap();
		setVisible(false);
		sc.setVisible(true);
		sc.setSize(800,600);			

		}
		});

		b8.addActionListener(new ActionListener()
		{
		public void actionPerformed(ActionEvent e)
		{
			game g=new game();
			g.setVisible(true);
			g.setSize(550,450);
			g.setLocation(150,80);
	
		}
		});

		b7.addActionListener(new ActionListener()
		{
		public void actionPerformed(ActionEvent e)
		{
			player1 p=new player1("Mirror Player");
			p.setVisible(true);
			p.setSize(400,600);
	
		}
		});

		n1.addActionListener(new ActionListener()
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
		}catch(Exception gty){}	
		}
		});

		b5.addActionListener(new ActionListener()
		{
		public void actionPerformed(ActionEvent e)
		{

		MyUpload1 uk=new MyUpload1();
		uk.setVisible(true);
		uk.setSize(560,560);

		}
		});

		n2.addActionListener(new ActionListener()
		{
		public void actionPerformed(ActionEvent e)
		{
		final JFrame jf=new JFrame();
		jf.setTitle("Change Theme");
		 p1=new JPanel(null,true);

		JButton b1=new JButton("Change Task");
		JButton b2=new JButton("Chage Task Fore.");
		JButton b3=new JButton("Chage Background");
		
		b1.setBounds(10,20,110,20);
		b2.setBounds(130,20,110,20);
		b3.setBounds(70,50,110,20);
		
		p1.add(b1); p1.add(b2);p1.add(b3);
		
		 p1.setBorder(
      	BorderFactory.createCompoundBorder(
        BorderFactory.createTitledBorder("Change Theme"),
        BorderFactory.createEmptyBorder(0,0,2,2)));

		 p2=new JPanel(null,true);
		 lv=new JLabel(" Task " );
		lv.setForeground(Color.white);
		lv.setFont(new Font("Arial",Font.PLAIN,14));
		lv.setBounds(40,0,100,30);
		p2.add(lv);
		p2.setBounds(0,80,250,30);
		p2.setBackground(Color.black);
		jf.add(p2);
		
		p3=new JPanel(null,true);
		p3.setBackground(Color.white);
		p3.setBounds(0,110,250,150);
		jf.add(p3);	


		p1.setBounds(0,0,250,60);
		jf.add(p1);
		
		jf.setVisible(true);
		jf.setLocation(100,100);
		jf.setSize(250,350);
		 

		Button app=new Button("Apply");
		app.setBounds(60,280,100,30);
		p1.add(app);

		app.addActionListener(new ActionListener()
		{
		public void actionPerformed(ActionEvent e)
		{
		   lk.setForeground(lv.getForeground());
		   lk1.setForeground(lv.getForeground());	
		   lk2.setForeground(lv.getForeground());
		   // ru=new Color( lv.getForeground() );	

		   j2.setBackground(p2.getBackground()); 	
	           j3.setBackground(p2.getBackground());
		   j6.setBackground(p2.getBackground());		 
		   
		  
		j1.setBackground(p3.getBackground());  // About Background Color			
		j4.setBackground(p3.getBackground());  // My Task Background	Color 		  
		j5.setBackground(p3.getBackground());  // Adding Friends Colors
		// j7.setBackground(p2.getBackground()); //Null Pointer exception catch by Java 1.5 Version (JDK1.6)	 	

		}
		});
		

		b1.addActionListener(new ActionListener()
		{
		public void actionPerformed(ActionEvent e)
		{
		if(tm==9)
		{
		lv.setForeground(Color.red);
	        tm=1;
		}
		else if(tm==8){ lv.setForeground(Color.blue); tm++;  }
		else if(tm==7){ lv.setForeground(Color.black); tm++;  }	
		else if(tm==6){ lv.setForeground(Color.magenta); tm++;  }
		else if(tm==5){  Color cb=new Color(134,154,166); lv.setForeground(cb); tm++;  }
		else if(tm==4){ Color cb2=new Color(174,204,186); lv.setForeground(cb2); tm++;  }
		else if(tm==3){ lv.setForeground(Color.orange); tm++;  }
		else if(tm==2){ lv.setForeground(Color.white); tm++;  }
		else if(tm==1){ lv.setForeground(Color.green); tm++;  }
		}
		});

		b3.addActionListener(new ActionListener()
		{
		public void actionPerformed(ActionEvent e)
		{
		if(fg==9)
		{
		p2.setBackground(Color.red);
	        fg=1;
		}
		else if(fg==8){ p3.setBackground(Color.blue); fg++;  }
		else if(fg==7){ p3.setBackground(Color.black); fg++;  }	
		else if(fg==6){ p3.setBackground(Color.magenta); fg++;  }
		else if(fg==5){  Color cb=new Color(134,154,166); p3.setBackground(cb); fg++;  }
		else if(fg==4){ Color cb2=new Color(174,204,186); p3.setBackground(cb2); fg++;  }
		else if(fg==3){ p3.setBackground(Color.orange); fg++;  }
		else if(fg==2){ p3.setBackground(Color.white); fg++;  }
		else if(fg==1){ p3.setBackground(Color.green); fg++;  }
		}
		});

		b2.addActionListener(new ActionListener()
		{
		public void actionPerformed(ActionEvent e)
		{
		if(bg==9)
		{
		p2.setBackground(Color.red);
	        bg=1;
		}
		else if(bg==8){ p2.setBackground(Color.blue); bg++;  }
		else if(bg==7){ p2.setBackground(Color.black); bg++;  }	
		else if(bg==6){ p2.setBackground(Color.magenta); bg++;  }
		else if(bg==5){  Color cb=new Color(134,154,166); p2.setBackground(cb); bg++;  }
		else if(bg==4){ Color cb2=new Color(174,204,186); p2.setBackground(cb2); bg++;  }
		else if(bg==3){ p2.setBackground(Color.orange); bg++;  }
		else if(bg==2){ p2.setBackground(Color.white); bg++;  }
		else if(bg==1){ p2.setBackground(Color.green); bg++;  }
		}
		});

		
		}
		});
		

		b3.addActionListener(new ActionListener()
		{
		public void actionPerformed(ActionEvent e)
		{
		JMessenger main = new JMessenger();
		}
		});


// End


j6=new JPanel(null,true);
 lk1=new JLabel("My Friends");

lk1.setFont(f);
lk1.setBounds(40,04,160,25);
lk1.setBackground(Color.black);

lk1.setForeground(c);
j6.add(lk1);

j6.setBackground(Color.black);
j6.setSize(280,30);
j6.setLocation(420,20);
cp.add(j6);



j5=new JPanel(null,true);

// Addinf Friend 1

str5="";
try{
	int mgr=0;
	for(int k=0;k<len;k++)
 	{
	  char ch=str1.charAt(k);
	 // System.out.println(ch);
	    if(ch=='<' && str1.charAt(k+1)=='f' && str1.charAt(k+2)=='r' && str1.charAt(k+3)=='0' && str1.charAt(k+4)=='>')
	      {
	       for(int j=k+5;j<len;j++)
	        {
		//System.out.println("Match Found");
	         char ch2=str1.charAt(j);
	           if(ch2!='<' && str1.charAt(j+1)!='/' && str1.charAt(j+2)!='f' && str1.charAt(j+3)!='r'  && str1.charAt(j+4)!='0' && str1.charAt(j+5)!='>'){
		   //System.out.println("Char Found");
		   str5=str5+ch2;
		         }
			
	          else{
		         break;	}				
	 			 }	
		 System.out.println("Msg=" + str5);			

		 }	
	}

	}catch(Exception de){}
	 System.out.println("Msg=" + str5);
i1=new ImageIcon(str5+".jpg");
b1=new JButton(i1);
b1.setBounds(10,10,70,70);
l1=new JLabel(str5);
l1.setBounds(10,90,70,20);
j5.add(b1);j5.add(l1);

if(str5==null || str5=="" || str5.equals(""))
{
b1.setVisible(false);
l1.setVisible(false);
}

//End 1


// Addinf Friend 2

str5="";
try{
	int mgr=0;
	for(int k=0;k<len;k++)
 	{
	  char ch=str1.charAt(k);
	 // System.out.println(ch);
	    if(ch=='<' && str1.charAt(k+1)=='f' && str1.charAt(k+2)=='r' && str1.charAt(k+3)=='1' && str1.charAt(k+4)=='>')
	      {
	       for(int j=k+5;j<len;j++)
	        {
		System.out.println("Match Found");
	         char ch2=str1.charAt(j);
	           if(ch2!='<' && str1.charAt(j+1)!='/' && str1.charAt(j+2)!='f' && str1.charAt(j+3)!='r'  && str1.charAt(j+4)!='1' && str1.charAt(j+5)!='>'){
			System.out.println("Char Found");
		         str5=str5+ch2;
		         }
			
	          else{
		         break;	}				
	 			 }	
		 System.out.println("Msg=" + str5);			

		 }	
	}

	}catch(Exception de){}
	 System.out.println("Msg=" + str5);
i2=new ImageIcon(str5+".jpg");
b2=new JButton(i1);
b2.setBounds(100,10,70,70);
l2=new JLabel(str5);
l2.setBounds(100,90,70,20);
j5.add(b2);j5.add(l2);


if(str5==null || str5=="" || str5.equals(""))
{
b2.setVisible(false);
l2.setVisible(false);
}

//End 2


//strart 3
str5="";
try{
	int mgr=0;
	for(int k=0;k<len;k++)
 	{
	  char ch=str1.charAt(k);
	 // System.out.println(ch);
	    if(ch=='<' && str1.charAt(k+1)=='f' && str1.charAt(k+2)=='r' && str1.charAt(k+3)=='2' && str1.charAt(k+4)=='>')
	      {
	       for(int j=k+5;j<len;j++)
	        {
		System.out.println("Match Found");
	         char ch2=str1.charAt(j);
	           if(ch2!='<' && str1.charAt(j+1)!='/' && str1.charAt(j+2)!='f' && str1.charAt(j+3)!='2'  && str1.charAt(j+4)!='1' && str1.charAt(j+5)!='>'){
			System.out.println("Char Found");
		         str5=str5+ch2;
		         }
			
	          else{
		         break;	}				
	 			 }	
		 System.out.println("Msg=" + str5);			

		 }	
	}

	}catch(Exception de){}
	 System.out.println("Msg=" + str5);
i3=new ImageIcon(str5+".jpg");
b3=new JButton(i1);
b3.setBounds(190,10,70,70);
l3=new JLabel(str5);
l3.setBounds(190,90,70,20);
j5.add(b3);j5.add(l3);

if(str5==null || str5=="" || str5.equals(""))
{
b3.setVisible(false);
l3.setVisible(false);
}


//end 3



// Strat 4
str5="";
try{
	int mgr=0;
	for(int k=0;k<len;k++)
 	{
	  char ch=str1.charAt(k);
	 // System.out.println(ch);
	    if(ch=='<' && str1.charAt(k+1)=='f' && str1.charAt(k+2)=='r' && str1.charAt(k+3)=='3' && str1.charAt(k+4)=='>')
	      {
	       for(int j=k+5;j<len;j++)
	        {
		System.out.println("Match Found");
	         char ch2=str1.charAt(j);
	           if(ch2!='<' && str1.charAt(j+1)!='/' && str1.charAt(j+2)!='f' && str1.charAt(j+3)!='3'  && str1.charAt(j+4)!='1' && str1.charAt(j+5)!='>'){
			System.out.println("Char Found");
		         str5=str5+ch2;
		         }
			
	          else{
		         break;	}				
	 			 }	
		 System.out.println("Msg=" + str5);			

		 }	
	}

	}catch(Exception de){}
	 System.out.println("Msg=" + str5);
i4=new ImageIcon(str5+".jpg");
b4=new JButton(i1);
b4.setBounds(10,130,70,70);
l4=new JLabel(str5);
l4.setBounds(10,200,70,20);
j4.add(b4);j5.add(l4);

if(str5==null || str5=="" || str5.equals(""))
{
b4.setVisible(false);
l4.setVisible(false);
}

//End 4

j5.setSize(280,400);
j5.setBackground(Color.white);
j5.setLocation(420,50);
cp.add(j5);

//Start 5
str5="";
try{
	int mgr=0;
	for(int k=0;k<len;k++)
 	{
	  char ch=str1.charAt(k);
	 // System.out.println(ch);
	    if(ch=='<' && str1.charAt(k+1)=='f' && str1.charAt(k+2)=='r' && str1.charAt(k+3)=='4' && str1.charAt(k+4)=='>')
	      {
	       for(int j=k+5;j<len;j++)
	        {
		System.out.println("Match Found");
	         char ch2=str1.charAt(j);
	           if(ch2!='<' && str1.charAt(j+1)!='/' && str1.charAt(j+2)!='f' && str1.charAt(j+3)!='4'  && str1.charAt(j+4)!='1' && str1.charAt(j+5)!='>'){
			System.out.println("Char Found");
		         str5=str5+ch2;
		         }
			
	          else{
		         break;	}				
	 			 }	
		 System.out.println("Msg=" + str5);			

		 }	
	}

	}catch(Exception de){}
	 System.out.println("Msg=" + str5);
i5=new ImageIcon(str5+".jpg");
b5=new JButton(i1);
b5.setBounds(90,130,70,70);
l5=new JLabel(str5);
l5.setBounds(90,200,70,20);
j5.add(b5);j5.add(l5);

if(str5==null || str5=="" || str5.equals(""))
{
b5.setVisible(false);
l5.setVisible(false);
}


//End 5

//Start 6
str5="";
try{
	int mgr=0;
	for(int k=0;k<len;k++)
 	{
	  char ch=str1.charAt(k);
	 // System.out.println(ch);
	    if(ch=='<' && str1.charAt(k+1)=='f' && str1.charAt(k+2)=='r' && str1.charAt(k+3)=='5' && str1.charAt(k+4)=='>')
	      {
	       for(int j=k+5;j<len;j++)
	        {
		System.out.println("Match Found");
	         char ch2=str1.charAt(j);
	           if(ch2!='<' && str1.charAt(j+1)!='/' && str1.charAt(j+2)!='f' && str1.charAt(j+3)!='5'  && str1.charAt(j+4)!='1' && str1.charAt(j+5)!='>'){
			System.out.println("Char Found");
		         str5=str5+ch2;
		         }
			
	          else{
		         break;	}				
	 			 }	
		 System.out.println("Msg=" + str5);			

		 }	
	}

	}catch(Exception de){}
	 System.out.println("Msg=" + str5);
i6=new ImageIcon(str5+".jpg");
b6=new JButton(i1);
b6.setBounds(190,130,70,70);
l6=new JLabel(str5);
l6.setBounds(190,200,70,20);
j6.add(b6);j5.add(l6);

if(str5==null || str5=="" || str5.equals(""))
{
b6.setVisible(false);
l6.setVisible(false);
}

//End 6


// Start 7

str5="";
try{
	int mgr=0;
	for(int k=0;k<len;k++)
 	{
	  char ch=str1.charAt(k);
	 // System.out.println(ch);
	    if(ch=='<' && str1.charAt(k+1)=='f' && str1.charAt(k+2)=='r' && str1.charAt(k+3)=='6' && str1.charAt(k+4)=='>')
	      {
	       for(int j=k+5;j<len;j++)
	        {
		System.out.println("Match Found");
	         char ch2=str1.charAt(j);
	           if(ch2!='<' && str1.charAt(j+1)!='/' && str1.charAt(j+2)!='f' && str1.charAt(j+3)!='6'  && str1.charAt(j+4)!='1' && str1.charAt(j+5)!='>'){
			System.out.println("Char Found");
		         str5=str5+ch2;
		         }
			
	          else{
		         break;	}				
	 			 }	
		 System.out.println("Msg=" + str5);			

		 }	
	}

	}catch(Exception de){}
	 System.out.println("Msg=" + str5);
i7=new ImageIcon(str5+".jpg");
b7=new JButton(i1);
b7.setBounds(10,220,70,70);
l7=new JLabel(str5);
l7.setBounds(10,290,70,20);
j5.add(b7);j5.add(l7);

if(str5==null || str5=="" || str5.equals(""))
{
b7.setVisible(false);
l7.setVisible(false);
}



//End 7
}

public static void main(String args[])
{
pro p=new pro();
p.setSize(800,600);
p.setVisible(true);
}

}



