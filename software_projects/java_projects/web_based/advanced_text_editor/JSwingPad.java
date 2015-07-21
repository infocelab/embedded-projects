/* ================================================
				JSwingPad Text Editor v 1.1
			       100 % Pure Java
       		  Created by: Puneet Wadhwa
             Email:puneet_tech@yahoo.com
			 Website:www.puneetwadhwa.com
   =================================================
*/

//Import the required packages
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class JSwingPad extends JFrame implements ActionListener,WindowListener
{
	MenuBar mbar;			  //Used for creating a Menu Bar
	Menu file,help,edit,colors;	   //Used for creating Menus
	MenuItem m1,m2,m3,m4,m5,m6,m7,m8,m9,cut,paste,copy,delete,about; //Creates MenuItems
	Font fn=new Font("Courier",0,14);
	TextArea ta=new TextArea(5,4);
    String cuttext="",txtmsg="";
	int getcaretpos=0,setcaretpos=0;
	FileDialog fd1,fd2; //Created a Windows like File Dialog Box
	JToolBar tb=new JToolBar();
	JButton sa,op,ex,cu,co,pa,de,ne;

	JSwingPad()       //Creating a constructor of our own class
	{
		setTitle("JSwingPad Text Editor © Puneet Wadhwa");
		fd2=new FileDialog(this,"Save As..",FileDialog.SAVE);
		fd1=new FileDialog(this,"Open..",FileDialog.LOAD);
		
		mbar=new MenuBar();
		m1=new MenuItem("New");
		m2=new MenuItem("Save");
		m3=new MenuItem("Open");
		m4=new MenuItem("Print");
		m5=new MenuItem("Exit"); //Here the menu items were added to the menubar

		m5.addActionListener(this);
		m4.addActionListener(this);
		m3.addActionListener(this);
		m2.addActionListener(this);
		m1.addActionListener(this);
							//Here the Mouse Event listeners are added


		file=new Menu("File");
		help=new Menu("Help");
		about=new MenuItem("About");
		
		file.add(m1);
		file.add(m2);
		file.add(m3);
//		file.add(m4);
		file.addSeparator();
		file.add(m5);

		m6=new MenuItem("Red");
		m7=new MenuItem("Blue");
		m8=new MenuItem("Green");
		m6.addActionListener(this);
		m7.addActionListener(this);
		m8.addActionListener(this);

 		edit=new Menu("Edit");
		colors=new Menu("Colors");

		ne=new JButton(new ImageIcon("new.gif"));
		ne.setToolTipText("New");

		sa=new JButton(new ImageIcon("save.gif"));
		sa.setToolTipText("Save");
		op=new JButton(new ImageIcon("open.gif"));
		op.setToolTipText("Open");
		ex=new JButton(new ImageIcon("exit.gif"));
		ex.setToolTipText("Exit");
		cu=new JButton(new ImageIcon("cut.gif"));
		cu.setToolTipText("Cut");
		co=new JButton(new ImageIcon("copy.gif"));
		co.setToolTipText("Copy");
		pa=new JButton(new ImageIcon("paste.gif"));
		pa.setToolTipText("Paste");
		de=new JButton(new ImageIcon("delete.gif"));
		de.setToolTipText("Delete");

		sa.addActionListener(this);
		op.addActionListener(this);
		ex.addActionListener(this);
		cu.addActionListener(this);
		co.addActionListener(this);
		pa.addActionListener(this);
		ne.addActionListener(this);
		de.addActionListener(this);

		tb.setMargin(new Insets(0,0,2,2)); //Setting margins for toolbar
		tb.add(ne);	//Adds buttons to the tool bar
		tb.add(sa);//Adds buttons to the tool bar
		tb.add(op);//Adds buttons to the tool bar
		tb.addSeparator();//Adds a separator
		
		tb.add(cu);//Adds buttons to the tool bar
		tb.add(co);//Adds buttons to the tool bar
		tb.add(pa);//Adds buttons to the tool bar
		tb.add(de);//Adds buttons to the tool bar

		tb.addSeparator();//Adds a separator

		tb.add(ex);

		cut=new MenuItem("Cut");
		paste=new MenuItem("Paste");
		copy=new MenuItem("Copy");
		delete=new MenuItem("Delete");

		cut.addActionListener(this);
		paste.addActionListener(this);
		copy.addActionListener(this);
		delete.addActionListener(this);
		about.addActionListener(this);

		colors.add(m6);
		colors.add(m7);
		colors.add(m8);
		
		edit.add(colors);
		edit.addSeparator();
		edit.add(cut);
		edit.add(copy);
		edit.add(paste);
		edit.add(delete);
		
		help.add(about);

		mbar.add(file);
		mbar.add(edit);
		mbar.add(help);
		
		ta.setFont(fn);
		Container c=getContentPane();
		c.add(ta);

		c.add(tb,"North");
		setMenuBar(mbar);
		addWindowListener(this);
	}

	public void windowClosing(WindowEvent we)
	{
			System.out.println("Thank you for using JSwingpad by Puneet Wadhwa");
			System.exit(0);
			//If the application is exited this method is called !
	}

//Following are some blank methods overriden because we implemented WindowEvent interface



	public void windowIconified(WindowEvent we)
	{
	}

	public void windowDeiconified(WindowEvent we)
	{
	}

	public void windowClosed(WindowEvent we)
	{
	}

	public void windowDeactivated(WindowEvent we)
	{
	}

	public void windowActivated(WindowEvent we)
	{
	}

	public void windowOpened(WindowEvent we)
	{
	}

	//Method called when action event occurs

	public void actionPerformed(ActionEvent e)
	{
		if ((e.getSource()==m5)||(e.getSource()==ex))
		{
			System.out.println("Thank you for using JSwingpad by Puneet Wadhwa");
			System.exit(0);
		}
		
		if ((e.getSource()==copy) ||(e.getSource()==co))
		{
			cuttext=ta.getSelectedText();
			//Basically we are storing the selected text into a variable
		}

		if ((e.getSource()==cut)||(e.getSource()==cu))
		{
			cuttext=ta.getSelectedText();
			int cutindex=ta.getText().indexOf(cuttext);
			ta.replaceRange("",cutindex,cutindex+cuttext.length());
			//We store the cut text into a var. and replace it with a blank string
		}

		if ((e.getSource()==delete)||(e.getSource()==de))
		{
			cuttext=ta.getSelectedText();
			int cutindex= ta.getText().indexOf(cuttext);
			ta.replaceRange("",cutindex,cutindex+cuttext.length());
			//We replace selected text with a blank string
		}

		if ((e.getSource()==paste) ||(e.getSource()==pa))
		{	
			getcaretpos=ta.getCaretPosition();
			ta.insertText(cuttext,getcaretpos);
			//Here we insert copied or cut text at the Cursor posn.
			//Warning: This method has now been deprecated, but has been tested to work with JDK 1.2
		}
		
		if (e.getSource()==about)
		{
			 JFrame jf=new JFrame();
			 jf.setBounds(220,130,248,291);
			 //to set the size and location of the frame
			 Container c=jf.getContentPane();
			 //in swing the components are always added to the content pane
			 c.setLayout(new FlowLayout());
			 //sets the layout of container as flow layout
			
			 ImageIcon ic=new ImageIcon("jswingpadc.gif");
			 //Basically used for the Splash Screen
			 JLabel jl=new JLabel(ic);
			 c.add(jl);
			 jf.show();
			 //creates and shows a frame containing a label (with image inside)
		}									   
		if ((e.getSource()==m1)||(e.getSource()==ne))
		{
			ta.setText("");
		}
		
		if ((e.getSource()==m3)||(e.getSource()==op))
		{
			txtmsg="";
			fd1.setVisible(true);
			String filename=fd1.getFile();
			String dirname=fd1.getDirectory();
			File openfile=new File(dirname,filename);
			//creates a file object for a file obtd. from dialog box

			try
			{
				FileInputStream fis=new FileInputStream(openfile);
				//creates an input stream
				//streams are like passages for data

				int bytelength=fis.available();
				//calculates the file size

				for (int bytecount=0;bytecount<bytelength;bytecount++)
				{
					//this loop runs till end of file
					char fch=(char)fis.read();
					txtmsg=txtmsg+fch;
				}
				ta.setText(txtmsg);
			}
			catch(Exception ioe)
			{
				System.out.println("An exception has occured");
			}
		}
		//the following block of code changes the background
		//color of the text area as per user's choice

		if (e.getSource()==m6)
		{
			ta.setBackground(new Color(255,204,255));
			ta.setForeground(new Color(0,0,102));
		}
		if (e.getSource()==m7)
		{
			ta.setBackground(new Color(153,204,255));
			ta.setForeground(Color.black);
		}
		if (e.getSource()==m8)
		{
			ta.setBackground(new Color(204,255,204));
			ta.setForeground(Color.black);
		}
		if ((e.getSource()==m2)||(e.getSource()==sa))
		{
			try
			{
				fd2.setVisible(true);
				FileOutputStream fos1=new FileOutputStream(fd2.getDirectory()+fd2.getFile());
				fos1.write(ta.getText().getBytes());
				fos1.close();
			}
			catch(Exception ioe)
			{
				System.out.println(ioe);
			}
		}
	}

	public static void main(String[] args) 
	{
		JSwingPad jf=new JSwingPad();
		jf.setSize(400,400);
		jf.show();
	}
}