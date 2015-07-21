import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.io.File.*;


class setting extends JWindow
{
JLabel l1,l2,l3,l4;
JTextField t1,t2,t3,t4,t5,t6;
JButton b1,b2,b3,b4,b5,b6,b7,b8;
JPasswordField p1,p2,p3,p4;
Container cp1;
String str1;
File f;
JPanel j1,cp;
 
setting(String str,String user)
{
cp1=getContentPane();
cp1.setLayout(null);
j1=new JPanel(null,true);
JLabel lk=new JLabel("Setting");
JButton jh1=new JButton("X");

Color cvz=new Color(125,135,165);
Font fcv=new Font("Arial",Font.BOLD,14);
lk.setFont(fcv);
lk.setBounds(20,04,120,25);
jh1.setBounds(360,02,38,28);
jh1.setBackground(cvz);
j1.add(jh1);

j1.add(lk);
cp1.add(lk);

j1.setLocation(0,0);
j1.setSize(400,30);

j1.setBackground(cvz);
cp1.add(j1);

cp=new JPanel(null,true);
cp.setLocation(0,30);
cp.setBackground(Color.white);
cp.setSize(400,320);

cp1.add(cp);

str1=user;
l1=new JLabel("User Name");
t1=new JTextField();
b1=new JButton("Change");
l1.setBounds(10,10,150,25);
t1.setBounds(10,30,150,25);
b1.setBounds(180,30,80,25);
cp.add(l1);cp.add(t1);cp.add(b1);
try

		{

			UIManager.setLookAndFeel ("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");

		}

		catch(Exception e)
		{}

l2=new JLabel("Password");
p2=new JPasswordField();
p3=new JPasswordField();
l3=new JLabel("Current Password");
l4=new JLabel("New Password");
l2.setBounds(40,55,150,25);
l3.setBounds(10,90,120,25);
p2.setBounds(140,90,150,25);
l4.setBounds(10,125,120,25);
//  System.out.println("all rights Reserved : Pravin H. Rane");
p3.setBounds(140,125,150,25);
b2=new JButton("Change");
b2.setBounds(310,110,80,25);
cp.add(l2);cp.add(p2);cp.add(p3);cp.add(l4);cp.add(l3);cp.add(b2);

b3=new JButton("Delete Profile");
b3.setBounds(10,195,150,30);
cp.add(b3);
b4=new JButton();

JButton b33=new JButton("Cancel");
b33.setBounds(60,230,150,30);
//cp.add(b33);

jh1.addActionListener(new ActionListener()
	{
	public void actionPerformed(ActionEvent fr){
	try{
		setVisible(false);
	   }catch(Exception de){}
	}
	});	

b33.addActionListener(new ActionListener()
	{
	public void actionPerformed(ActionEvent fr){
	try{
		setVisible(false);
	   }catch(Exception de){}
	}
	});	

try{
FileReader r=new FileReader(user+"/scrap/pointer1.dat");
JTextField hh=new JTextField();
hh.read(r,null);
int u=Integer.parseInt(hh.getText());
r.close();
if(u==0)
{
b4.setText("Unlock ScrapBook");
}
else
{
b4.setText("lock ScrapBook");
}

}catch(Exception se){System.out.println(se);}
b4.setBounds(170,195,150,30);
cp.add(b4);



	b1.addActionListener(new ActionListener()
	{
	public void actionPerformed(ActionEvent fr){
	try{
	if(!t1.getText().equals(""))
	{
	FileWriter w=new FileWriter(str1+"/First name.txt");
	w.write(t1.getText());
	w.close();
	
	try{
	FileReader ru=new FileReader(str1+"/friends/pointer.dat");
	System.out.println("Reading "+str1+"'s Pointer"+"\n" );
	JTextField jk=new JTextField();
	jk.read(ru,null);
	int frg=Integer.parseInt(jk.getText());
	System.out.println(frg);
	ru.close(); 
	System.out.println("\n"+"Reading "+str1+"'s Friends name" );
	
	for(int ir=0;ir<=frg;ir++)
	{
	FileReader ru1=new FileReader(str1+"/friends/"+ir+".txt");
	JTextField jk1=new JTextField();
	jk1.read(ru1,null);
	System.out.println(ir+". "+ jk1.getText() );
	
	String str2=jk1.getText();
	ru1.close(); 	

	FileReader ru3=new FileReader(str2+"/friends/pointer.dat");
	System.out.println("\n"+"\n"+"Reading "+str2+"'s Pointer" );
	
		JTextField jk3=new JTextField();
		jk3.read(ru3,null);
		int fr3=Integer.parseInt(jk.getText());
		System.out.println(fr3);
		ru3.close(); 
		System.out.println("\n"+"\n"+"Reading "+str2+"'s Friends name" );
		for(int jr=0;jr<fr3;jr++)
		{
		FileReader ru12=new FileReader(str2+"/friends/"+jr+".txt");
		JTextField jk12=new JTextField();
		
	
		jk12.read(ru12,null);
		System.out.println(jr+". "+jk12.getText());
	
		ru12.close(); 	

		if(jk12.getText().equals(str1))
		{
		FileWriter rq=new FileWriter(str2+"/friends/"+jr+".txt");
		rq.write(t1.getText());
		rq.close();
		System.out.println("\n"+"\n"+"Changing "+str1+"'s Name as "+t1.getText()+"\n"+"\n" );
	
		}
	    }
	
	  }	
	}catch(Exception der){ System.out.println("Changing Name Sucessfully...");}
	File fg=new File(str1);
	File fg2=new File(t1.getText());
	fg.renameTo(fg2);
	
	error e=new error("User Name Change Sucessfully");
	e.setVisible(true);
	e.setSize(200,100);
	e.setLocation(55,55);
	}
	else
	{
	error e=new error("Please Enter User Name !");
	e.setVisible(true);
	e.setSize(200,100);
	e.setLocation(55,55);
	}
	}catch(Exception se){}
	}
	});




	b2.addActionListener(new ActionListener()
	{
	public void actionPerformed(ActionEvent fr){
	try{
	FileReader r=new FileReader(str1+"/password.txt");
	t6=new JTextField();
	t6.read(r,null);
	r.close();
	if(t6.getText().equals(p2.getText()))
	{
	FileWriter w=new FileWriter(str1+"/password.txt");
	w.write(p3.getText());
	w.close();
	//  System.out.println("all rights Reserved : Pravin H. Rane");
	error e=new error("Pasword Change Sucessfully");
	e.setVisible(true);
	e.setSize(200,100);
	e.setLocation(55,55);
	}
	else
	{
	error e=new error("Pasword is not match with current Password");
	e.setVisible(true);
	e.setSize(320,100);
	e.setLocation(55,55);
	}
	}catch(Exception se){ System.out.println("No change"); }
	}
	});
b3.addActionListener(new ActionListener()
	{
	public void actionPerformed(ActionEvent fr){
	try{
	f=new File(str1+"/First name.txt");
	f.delete();
	
	f=new File(str1+"/last name.txt");
	f.delete();

	f=new File(str1+"/password.txt");
	f.delete();
	try{
		FileReader r3=new FileReader(str1+"/scrap/pointer.dat");
		JTextField jj4=new JTextField();
		jj4.read(r3,null);
		int gv=Integer.parseInt(jj4.getText());
		r3.close();
	
		for(int i=0;i<gv;i++)
			{
			f=new File(str1+"/scrap/"+i+".txt");
			f.delete();
			}
		}catch(Exception de){}
	f=new File(str1+"/scrap/pointer.dat");
	f.delete();
	
	try{
	FileReader r2=new FileReader(str1+"/friends/pointer.dat");
	JTextField jj2=new JTextField();
	int g2=Integer.parseInt(jj2.getText());
	r2.close();//  System.out.println("all rights Reserved : Pravin H. Rane");
	
	for(int i2=0;i2<g2;i2++)
	{
	f=new File(str1+"/friends/"+i2+".txt");
	f.delete();
	}
	}catch(Exception fe){}
	f=new File(str1+"/friends/pointer.dat");
	f.delete();
	
	error e=new error("Profile  Deleted");
	e.setVisible(true);
	e.setSize(120,100);
	e.setLocation(55,55);
	}catch(SecurityException ge){ System.out.println(ge); }
}
});



b4.addActionListener(new ActionListener()
	{
	public void actionPerformed(ActionEvent fr){
try{
FileReader r=new FileReader(str1+"/scrap/pointer1.dat");
JTextField hh=new JTextField();
hh.read(r,null);
int u=Integer.parseInt(hh.getText());
r.close();

if(u!=0)
{
FileWriter ww=new FileWriter(str1+"/scrap/pointer1.dat");
ww.write("-1");
ww.close();

error e=new error("Scrap Book was Lock  !!!!!");
e.setVisible(true);
e.setSize(150,99);
e.setLocation(70,70);
}

else
{
FileReader r1=new FileReader(str1+"/scrap/pointer.dat");
JTextField hh1=new JTextField();
hh.read(r1,null);
int u1=Integer.parseInt(hh1.getText());
r1.close();


FileWriter ww1=new FileWriter(str1+"/scrap/pointer1.dat");
ww1.write(u1);
ww1.close();

error e=new error("Scrap Book was UnLock!!!!!");
e.setVisible(true);
e.setSize(150,99);
e.setLocation(70,70);
}


}catch(Exception d){System.out.println(d);}
}
});
//  System.out.println("all rights Reserved : Pravin H. Rane");
}
}