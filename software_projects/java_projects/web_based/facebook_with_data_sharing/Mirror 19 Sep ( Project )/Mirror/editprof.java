import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.*;
import javax.swing.event.*;
import java.lang.reflect.*;
import javax.swing.border.*;
import javax.swing.plaf.basic.*;
import javax.swing.filechooser.FileView;

class editprof extends JFrame
{
private String filepath,user1;
JTextField name,last,email,col1,uni1,state,city1;
JPasswordField pwd;
JLabel name1,last1,email1,icon,date1,about,sx,allow,col,uni,con1,state1,city,pass;
ImageIcon image;
JButton addimage,next;
JComboBox date,month,year,gen,con; 
JTextArea main;
FileWriter w;
FileReader r;
JTextField read1;
JCheckBox c1,c2,c3,c4;
Container cp;
editprof(String str,String user)
{
cp=getContentPane();
cp.setLayout(null);
user1=user;
try

		{

			UIManager.setLookAndFeel ("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");

		}

		catch(Exception e)
		{}

	JTextField ft=new JTextField();
	name1=new JLabel("First Name");
	try{
	r=new FileReader(user+"/First name.txt");
	ft.read(r,null);
	r.close();
	}catch(Exception de){}
	name=new JTextField();
	name.setText(ft.getText());	

	last1=new JLabel("Enter Last Name");
	try{
	r=new FileReader(user+"/last name.txt");
	ft.read(r,null);
	r.close();
	}catch(Exception de){}
	last=new JTextField();
	last.setText(ft.getText());

	pass =new JLabel("Password");
	try{
	r=new FileReader(user+"/password.txt");
	ft.read(r,null);
	r.close();
	}catch(Exception de){}
	pwd=new JPasswordField();
	pwd.setText(ft.getText());
	pwd.setEditable(false);

	email1=new JLabel("Enter email address");
	try{
	r=new FileReader(user+"/email.txt");
	ft.read(r,null);
	r.close();
	}catch(Exception de){}
	email=new JTextField();
	email.setText(ft.getText());	

        addimage=new JButton("Add Image");
	icon=new JLabel();


  	
	date1=new JLabel("Date Of Birth");
	date=new JComboBox();
	for(int i=1;i<=31;i++)
	{
	date.addItem(i);
	}	

	month=new JComboBox();
	month.addItem("Jan");
	month.addItem("Feb");
	month.addItem("Mar");
	month.addItem("Apr");
	month.addItem("May");
	month.addItem("Jun");
	month.addItem("Jul");
	month.addItem("Aug");
	month.addItem("Sep");
	month.addItem("Oct");
	month.addItem("Nov");
	month.addItem("Dec");
	
	year=new JComboBox();
	for(int j=1900;j<=2010;j++)
	{
	year.addItem(j);
	}
	
	sx=new JLabel("Gender");
	gen=new JComboBox();
	gen.addItem("Male");
	gen.addItem("Female");
            
	con1=new JLabel("Country Name");
 	con=new JComboBox();
	con.addItem(" Austrelia");
	con.addItem(" America");
	con.addItem(" Antartica");
	con.addItem(" Africa");
	con.addItem(" Canda");
	con.addItem(" Corea");
	con.addItem(" Chaina");
	con.addItem(" Denmark");
	con.addItem(" England");
	con.addItem(" Franc");
	con.addItem(" Hangery");
	con.addItem(" Holand");
	con.addItem(" Itali");
	con.addItem(" India");
	con.addItem(" Indonesia");
	con.addItem(" Jermany");
	con.addItem(" Japan");
	con.addItem(" Korea");
	con.addItem(" Kembridge");
	con.addItem(" Merusalem");
	con.addItem(" Noth America");
	con.addItem(" Norvey");
	con.addItem(" West Indies");
	con.addItem(" Peru");
	con.addItem(" Zimbawe");

	
	about=new JLabel("About me");
	try{
	r=new FileReader(user+"/about.txt");
	ft.read(r,null);
	r.close();
	}catch(Exception de){}
	int h=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS;
	int v=ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS;

	main=new  JTextArea(); 
	main.setText(ft.getText());
	
	JScrollPane jsp=new JScrollPane(main,v,h);

	allow=new JLabel("Allow To:");
	JCheckBox c1=new JCheckBox(" orkut Friends");
	JCheckBox c2=new JCheckBox("Collage Friends");
	JCheckBox c3=new JCheckBox("Business Partner");
	JCheckBox c4=new JCheckBox("Relatives");

	col=new JLabel("Collage Name:");
	try{
	r=new FileReader(user+"/Collage.txt");
	ft.read(r,null);
	r.close();
	}catch(Exception de){}
	col1=new JTextField();
	col1.setText(ft.getText());	
	try{
	r=new FileReader(user+"/UniverSity.txt");
	ft.read(r,null);
	r.close();
	}catch(Exception de){}
	uni=new JLabel("Univercity");
	uni1=new JTextField();
 	uni1.setText(ft.getText());

	state1=new JLabel("State Name");
	try{
	r=new FileReader(user+"/state.txt");
	ft.read(r,null);
	r.close();
	}catch(Exception de){}
	state=new JTextField();
	state.setText(ft.getText());
	
	city=new JLabel("City");
	try{
	r=new FileReader(user+"/City.txt");
	ft.read(r,null);
	r.close();
	}catch(Exception de){}
	city1=new JTextField();
	city1.setText(ft.getText());	

	try{
	r=new FileReader(user+"/imagepath.txt");
	ft.read(r,null);
	r.close();
	}catch(Exception de){}
	ImageIcon io=new ImageIcon(ft.getText());
	icon.setIcon(io);

	next=new JButton("Update");
	next.setBackground(Color.white);
 	// adding to container
	
	name1.setBounds(10,10,130,25);
	name.setBounds(150,10,130,25);                
	
	last1.setBounds(10,40,130,25);
	last.setBounds(150,40,130,25);
	
	email1.setBounds(10,70,130,25);
	email.setBounds(150,70,130,25);
	
	pass.setBounds(290,70,130,25);
	pwd.setBounds(390,70,130,25);

	addimage.setBounds(350,440,100,25);
	icon.setBounds(490,410,100,100);

	date1.setBounds(10,100,130,25);
	date.setBounds(120,100,40,25);
	month.setBounds(180,100,130,25);
	year.setBounds(320,100,130,25);
	
	sx.setBounds(10,140,130,25);
	gen.setBounds(150,140,130,25);

               about.setBounds(10,180,130,25);
	jsp.setBounds(150,180,250,80);

	allow.setBounds(10,260,130,25);
	c1.setBounds(150,260,130,25);
	c2.setBounds(290,260,130,25);
	
	c3.setBounds(150,290,130,25);
	c4.setBounds(290,290,130,25);

	uni.setBounds(10,330,130,25);
	uni1.setBounds(150,330,130,25);
	col.setBounds(10,360,130,25);
	col1.setBounds(150,360,130,25);
	
	con1.setBounds(10,390,130,25);
	con.setBounds(150,390,130,25);

	state1.setBounds(10,430,130,25);
	state.setBounds(150,430,130,25);
	
	city.setBounds(10,460,130,25);
	city1.setBounds(150,460,130,25);

	next.setBounds(50,490,130,25);

	cp.add(name);cp.add(name1);cp.add(last);
	cp.add(last1);cp.add(email);cp.add(email1);
	cp.add(addimage);cp.add(icon);cp.add(date1);
	cp.add(date);cp.add(month);cp.add(year);
	cp.add(about);cp.add(jsp);cp.add(sx);
	cp.add(gen);cp.add(allow);cp.add(c1);cp.add(c2);
	cp.add(c3);cp.add(c4);cp.add(next);cp.add(uni);
	cp.add(uni1);cp.add(col);cp.add(col1);cp.add(con);
	cp.add(con1);cp.add(state1);cp.add(state);cp.add(city);cp.add(city1);
	cp.add(next);cp.add(pwd);cp.add(pass);

addimage.addActionListener(new ActionListener()
{

	public void actionPerformed(ActionEvent e)
	{
	filepath=name.getText();
	JFileChooser chooser=new JFileChooser();

	while(true)
		{
		int val=chooser.showOpenDialog(editprof.this);
		File f=chooser.getSelectedFile();
		String path=f.getPath();
		String name=f.getName();

		try{

			if(val==JFileChooser.CANCEL_OPTION || val==-1)
			{
				break;
			}
			else
			{
			image=new ImageIcon(path);
			icon.setIcon(image);
			w=new FileWriter(filepath+"/"+"imagePath.txt");
	      		w.write(path+"");	
	      		w.close();
			break;
			}	
		}catch(Exception se){}
		}

	}
}); 	

date.addItemListener(new ItemListener()
{
	public void itemStateChanged(ItemEvent e)
	{
	int str=(Integer)e.getItem();
	File f=new File(name.getText());
	f.mkdir();
	try{
	      w=new FileWriter(name.getText()+"/"+"date.txt");
	      w.write(str+"");	
	      w.close();			
	     }catch(IOException de){}	

	}
});	

month.addItemListener(new ItemListener()
{
	public void itemStateChanged(ItemEvent e1)
	{
	String str=(String)e1.getItem();
	File f=new File(name.getText());
	f.mkdir();
	try{
	    w=new FileWriter(name.getText()+"/"+"month.txt");
	   w.write(str+"");	
	    w.close();			
	     }catch(IOException de){}

	}
});
con.addItemListener(new ItemListener()
{
	public void itemStateChanged(ItemEvent e2)
	{
	String str=(String)e2.getItem();
	File f=new File(name.getText());
	f.mkdir();
	try{
	    w=new FileWriter(name.getText()+"/"+"contry.txt");
	   w.write(str+"");	
	    w.close();			
	     }catch(IOException de){}

	}
});
year.addItemListener(new ItemListener()
{
	public void itemStateChanged(ItemEvent e2)
	{
	int str=(Integer)e2.getItem();
	File f=new File(name.getText());
	f.mkdir();
	try{
	    w=new FileWriter(name.getText()+"/"+"year.txt");
	   w.write(str+"");	
	    w.close();			
	     }catch(IOException de){}

	}
});
gen.addItemListener(new ItemListener()
{
	public void itemStateChanged(ItemEvent e3)
	{
	String str=(String)e3.getItem();
	File f=new File(name.getText());
	f.mkdir();
	try{
	    w=new FileWriter(name.getText()+"/"+"gender.txt");
	   w.write(str+"");	
	    w.close();			
	     }catch(IOException de){}

	}
});

next.addActionListener(new ActionListener()
{
	public void actionPerformed(ActionEvent se)
	{
	try{
		
		w=new FileWriter(name.getText()+"/"+"First name.txt");
		w.write(name.getText());
		w.close();
		
		w=new FileWriter(name.getText()+"/"+"last name.txt");
		w.write(last.getText());
		w.close();
		
		w=new FileWriter(name.getText()+"/"+"email.txt");
		w.write(email.getText());
		w.close();
	
		w=new FileWriter(name.getText()+"/"+"Collage.txt");
		w.write(col1.getText());
		w.close();

		w=new FileWriter(name.getText()+"/"+"UniverSity.txt");
		w.write(uni1.getText());
		w.close();

		w=new FileWriter(name.getText()+"/"+"state.txt");
		w.write(state.getText());
		w.close();

		w=new FileWriter(name.getText()+"/"+"City.txt");
		w.write(city1.getText());
		w.close();

		w=new FileWriter(name.getText()+"/"+"about.txt");
		w.write(main.getText());
		w.close();

		w=new FileWriter(name.getText()+"/"+"password.txt");
		w.write(pwd.getText());
		w.close();
		
		profile e1=new profile("My Profile",user1);
		e1.setVisible(true);
		e1.setLocation(00,00);
		e1.setSize(800,800);
		setVisible(false);
	     }catch(Exception be){ }	
	}
});
		
}
}