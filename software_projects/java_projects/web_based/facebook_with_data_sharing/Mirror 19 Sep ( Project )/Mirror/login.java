import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.*;

class login extends JFrame
{
JTextField login;
JProgressBar jb;
JPasswordField passwd;
JButton log,reset,newUser;
//  Additional Buttons For  Post Implementations
// JButton  r,a,n,e,p,r,a,v,i,n;
JLabel uname,pwd,info,imageicon,imageicon1,info2,info3;
FileReader r1;
JTextField read1;
JFileChooser ch;
Container cp;
int i=1;

login(String str)
{
super("Login");
cp=getContentPane();
cp.setLayout(null);
try

		{

			UIManager.setLookAndFeel ("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");

		}

		catch(Exception e)
		{}


	System.out.println("Plaese wait checking System For Java Media Framework........");
	try{
	File ak47=new File("C:/Program Files/JMF2.1.1e/bin/jmfinit.exe");
	if(ak47.exists() || ak47.isFile())
	{
	System.out.println("JAva Media Framework FOund....");
	System.out.println("Path=C:/Program Files/JMF2.1.1e/bin");
	}
	else{
		System.out.println("Java Media Framework is not Found....");
		System.out.println("Pleaes wait while Installing........");
		Runtime r=Runtime.getRuntime();
		r.exec("jmf-2_1_1e-windows-i586.exe");
	   }
	
	}catch(Exception de){}

	//  Adding component to frame
	login=new JTextField();
	passwd=new JPasswordField();
	log=new JButton("Login");
	Color c=new Color(255,255,255);
	log.setBackground(c);
	reset=new JButton("Reset"); 
	reset.setBackground(c);

	uname=new JLabel("Enter User Name:");
	pwd=new JLabel("Password:");
	newUser=new JButton("Sign Up !");
	newUser.setBackground(c);
	info=new JLabel("<html><a href=null>If you want to join or Create new</a></html>");
                info2=new JLabel("<html><a href=null>Mirror account you must click on </a></html>");
                info3=new JLabel("<html><a href=null>the Create new User </a></html>");	
	JLabel lc=new JLabel("Currently Mirror User");
	lc.setBounds(550,470,200,20);
	cp.add(lc);
	jb=new JProgressBar();
	jb.setBounds(550,500,200,20);
	cp.add(jb);
	jb.setValue(0);
	int gh=jb.getValue();
	JLabel  ln=new JLabel("User :"+gh);
	ln.setBounds(550,530,70,30);
	cp.add(ln);
	//  System.out.println("all rights Reserved : Pravin H. Rane");
	// adding image on orkut
	try{
	FileReader reader=new FileReader("image/point.dat");
	JTextField jtg=new JTextField();
	jtg.read(reader,null);
	int zz=Integer.parseInt(jtg.getText());
	reader.close();
	
	// if(zz<=3)
	// {
	ImageIcon image=new ImageIcon("image/mirror2.GIF");
	imageicon=new JLabel(image);
	
	FileWriter w=new FileWriter("image/point.dat");
	zz=zz+1;
	w.write(zz+"");
	w.close();
	// }
	// else{
	// ImageIcon image=new ImageIcon("image/mirror"+1+".jpg");
	// imageicon=new JLabel(image);
	
	// FileWriter w=new FileWriter("image/point.dat");
	
	// w.write(2+"");
	// w.close();
	
	// }
	}catch(Exception fe){}        
        ImageIcon image1=new ImageIcon("image/my.jpg");
	imageicon1=new JLabel(image1);

	// setting bounds
	imageicon.setBounds(10,10,500,550);
	imageicon1.setBounds(560,90,120,50);
	uname.setBounds(520,150,100,30);
	login.setBounds(620,150,150,30);
//  System.out.println("all rights Reserved : Pravin H. Rane");
	pwd.setBounds(520,190,100,30);
	passwd.setBounds(620,190,150,30);
	log.setBounds(540,230,100,30);
	reset.setBounds(650,230,100,30);
	info.setBounds(530,280,200,20);
	info2.setBounds(530,300,200,20);
	info3.setBounds(530,320,200,20);
	newUser.setBounds(540,350,160,30);

	// adding to container
	cp.add(imageicon);cp.add(uname);cp.add(login);
	cp.add(pwd);cp.add(passwd);cp.add(log);
	cp.add(reset);cp.add(newUser);cp.add(info);
	cp.add(info2);cp.add(info3);cp.add(imageicon1);

	try{
		FileReader rrr=new FileReader("Progress.dat");
		JTextField ggg=new JTextField();
		ggg.read(rrr,null);
		int k=Integer.parseInt(ggg.getText());
		rrr.close();
		jb.setValue(k);
		ln.setText("User :"+ k);
		
	}catch(Exception de){System.out.println(de);}	

	try{
	FileReader vr=new FileReader("Pointer.dat");
	JTextField hh=new JTextField();
	hh.read(vr,null);
	JLabel kl=new JLabel(hh.getText());
	kl.setForeground(Color.red);
	kl.setBounds(600,650,200,20);
	cp.add(kl);	
	}catch(Exception de){}
		
// Adding actionListeners and performing the actions


newUser.addActionListener(new ActionListener()
{

	public void actionPerformed(ActionEvent e)
	{
	//newUser1 u=new newUser1();
	//u.setVisible(true);
	//u.setSize(600,600);
	//u.setLocation(10,10);
	}
});
reset.addActionListener(new ActionListener()
{

	public void actionPerformed(ActionEvent e)
	{
	login.setText("");
	//  System.out.println("all rights Reserved : Pravin H. Rane");
	passwd.setText("");
	passwd.setBackground(Color.white);
	}
});
log.addActionListener(new ActionListener()
{

	public void actionPerformed(ActionEvent e)
	{
	

	try{
	
	
	FileWriter rw=new FileWriter("Send.txt");
	rw.write("<"+login.getText()+">"+"{"+passwd.getText()+"}"+"\r\n"); 
	rw.close();
	
	Runtime ty=Runtime.getRuntime();
	ty.exec("ServerRun.bat");
	System.out.println("Start client");

	int m=0;
	File f=new File("res.xml");
	do{
		if(f.isFile() && f.exists())
		{
		pro p=new pro();
		p.setVisible(true);
		setVisible(false);
		log.setText("Wait coonect to Server");
		p.setSize(800,600);
		m=1;
		break;
		}

	}while(m==1);

	}catch(Exception fr){}
}
});

	
}
}