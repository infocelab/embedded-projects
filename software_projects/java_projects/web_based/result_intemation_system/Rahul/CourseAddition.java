import javax.swing.*;
import javax.swing.plaf.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.plaf.metal.*;
import java.util.*;
import java.sql.*;
import java.io.*;

class CourseAddition extends JFrame
{
	JTextField coursename;
	JTextField courseid;
	JTextField totalfees;
	JComboBox duration;
	JTextField sem1[]=new JTextField[12];
	JTextField sem2[]=new JTextField[12];
	JTextField sem3[]=new JTextField[12];
	JTextField sem4[]=new JTextField[12];
	JTextField sem5[]=new JTextField[12];
	JTextField sem6[]=new JTextField[12];
	JTextField sem7[]=new JTextField[12];
	JTextField sem8[]=new JTextField[12];

	Container c = getContentPane();
	JPanel main;
	JPanel butpanel=new JPanel();
	boolean fristfour=false;
	boolean lastfour=false;
	SubjectList sl;
	SubjectListSem sls;
	boolean slflag=false;
	boolean slsflag=false;
	static int count;
	int width;
	int height;
	Dimension screenSize;
	CourseAddition()
	{

		Toolkit kits=Toolkit.getDefaultToolkit();
		screenSize=kits.getScreenSize();
		width=screenSize.width/3;
		height=screenSize.height/3;
		setSize(width+50, height);
		setTitle("New Course");
		setLocation(width-20,height);
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				dispose();
				if(slflag==true)
				{
					if(sl.isShowing())
						sl.dispose();
				}
				if(slsflag==true)
				{
					if(sls.isShowing())
						sls.dispose();
				}
			}
		});
		CourseAddition.setDefaultLookAndFeelDecorated(true);
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("mainicon.png"));
		JLabel l=new JLabel("<html><font size=6 color=#800080><i>Add New Course");
		JPanel title=new JPanel()
		{
			public void paintComponent(Graphics g)
			{

				Toolkit kit=Toolkit.getDefaultToolkit();
				Image img=kit.getImage("HEADER.gif");
				MediaTracker t=new MediaTracker(this);
				t.addImage(img,1);
				while(true)
				{
					try
					{
						t.waitForID(1);
						break;
					}
					catch(Exception e)
					{
					}
				}
				g.drawImage(img,0,0,width+50,50,null);
			}
		};
		title.add(l);
		add(title,"North");
		main = new JPanel()
		{
			public void paintComponent(Graphics g)
			{
				Toolkit kit=Toolkit.getDefaultToolkit();
				Image img=kit.getImage("cors.jpg");
				MediaTracker t=new MediaTracker(this);
				t.addImage(img,1);
				while(true)
				{
					try
					{
						t.waitForID(1);
						break;
					}
					catch(Exception e)
					{
					}
				}
				g.drawImage(img,0,0,width+50, height,null);
			}

		};
		main.setLayout(new GridBagLayout());
		main.setBackground(new Color(245, 240, 255));
		GridBagConstraints cons = new GridBagConstraints();
		cons.fill = GridBagConstraints.NONE;
		cons.anchor = GridBagConstraints.EAST;
		cons.weightx = 0;
		cons.weighty = 10;
		courseid = new JTextField();
		courseid.setEditable(false);
		try
		{
			DataInputStream dt=new DataInputStream(new FileInputStream("courid.dat"));
			courseid.setText(dt.readUTF());
		}
		catch(Exception e)
		{
		}

		coursename= new JTextField();
		totalfees= new JTextField();
		totalfees.addKeyListener(new NumberValid());
		duration= new JComboBox(new String[]{"Two Semester","Four Semester","Six Semester","Eight Semester","One Year","Two Year","Three Year","Four Year"});
		JScrollPane dp=new JScrollPane(duration);
		duration.setMaximumRowCount(4);
		JButton save = new JButton("Save");
		JButton exit = new JButton("Exit");
		exit.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				dispose();
				if(slflag==true)
				{
					if(sl.isShowing())
						sl.dispose();
				}
				if(slsflag==true)
				{
					if(sls.isShowing())
						sls.dispose();
				}
			}
		});
		save.addActionListener(new CourseSave());


		cons.insets = new Insets(10, 10, 2, 0);
		add(new JLabel("<html><font color=#00FF00>Course ID  : "), cons, 0, 0, 1, 1);
		cons.insets = new Insets(0, 10, 2, 0);
		add(new JLabel("<html><font color=#00FF00>Course Name  : "), cons, 0, 1, 1, 1);
		add(new JLabel("<html><font color=#00FF00>Total Fees  : "), cons, 0, 2, 1, 1);
		add(new JLabel("<html><font color=#00FF00>Durestion Of Course  : "), cons, 0, 3, 1, 1);

		cons.weightx = 80;
		cons.fill = GridBagConstraints.HORIZONTAL;
		cons.insets = new Insets(10, 5, 2, 20);
		add(courseid, cons, 1, 0, 1, 1);
		cons.insets = new Insets(0, 5, 2, 20);
		add(coursename, cons, 1, 1, 1, 1);
		add(totalfees, cons, 1, 2, 1, 1);
		add(dp, cons, 1, 3, 1, 1);
		butpanel.setBackground(new Color(255,197,68));
		butpanel.add(save);
		butpanel.add(exit);
		add(butpanel,"South");
	}
	 public void add(Component comp, GridBagConstraints cons, int x, int y, int w, int h)
	 {
		 cons.gridx = x;
		 cons.gridy = y;
		 cons.gridwidth = w;
		 cons.gridheight = h;
		 comp.setPreferredSize(comp.getPreferredSize());
		 main.add(comp, cons);
		 c.add(main);
	 }
	 class CourseSave implements ActionListener
	 {
		 public void actionPerformed(ActionEvent e)
		 {
			 String cname=coursename.getText().trim();
			 String cid=courseid.getText();
			 String tfees=totalfees.getText();
			 if(cname.equals("") || cid.equals("") || tfees.equals(""))
			 {
				 Icon error=new ImageIcon("error.png");
				 JOptionPane.showMessageDialog(CourseAddition.this,"<html><font size=4 color=red>Please Enter All Information</font></html> \n\t\t values can not be blank","Login",JOptionPane.ERROR_MESSAGE,error);
			 }
			 else
			 {
				try
				{
					Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
					Connection conn=DriverManager.getConnection("jdbc:odbc:Student_Info","raj","17java71");
					Statement st=conn.createStatement();
					ResultSet set=st.executeQuery("select * from course_name");
					boolean rc=true;
					while(set.next())
					{
						if(cname.equalsIgnoreCase(set.getString(2)))
						{
							Icon error=new ImageIcon("error.png");
							JOptionPane.showMessageDialog(CourseAddition.this,"<html><font size=4 color=red>Course All Ready Exits <font></html> \n\t\t Please Enter Another Course Name","Login",JOptionPane.ERROR_MESSAGE,error);
							rc=false;
							break;
						}
					}
					for(int i=0;i<cname.length();i++)
					{
						char ch=cname.charAt(i);
						if(ch == '.' || ch == '[' || ch == ']' || ch == '{' || ch == '}' || ch == '!')
						{
							Icon error=new ImageIcon("error.png");
							JOptionPane.showMessageDialog(CourseAddition.this,"<html><font size=3 color=blue> Make sure that name doesn't contain  a <br>period ( . ), exclamation ( ! ), bracket ( [] ) ,<br> non-pritable charecter such as a carrige <br> return.</font><br> <font size=4 color=red> Please Enter Another Course Name </html>","Login",JOptionPane.ERROR_MESSAGE,error);
							rc=false;
							break;
						}
					}
					if(rc==true)
					{
					 	sl=new SubjectList();
					 	sl.setVisible(true);
					}
				}
				catch(Exception e1)
				{
				}



			 }

		 }
	}
	class SubjectList extends JDialog
	{
		JPanel coursePanel;
		Container cr=getContentPane();
		String cdur;
		SubjectList()
		{
			super(CourseAddition.this,"Subject List",true);
			setSize(width+100,height+250);
			setLocation(width-20,40);
			setResizable(false);
			setIconImage(Toolkit.getDefaultToolkit().getImage("mainicon.png"));
			SubjectList.setDefaultLookAndFeelDecorated(true);
			slflag=true;

			//JTextField tfh=new JTextField("Enter The Subject",SwingConstants.CENTER);
			//tfh.setBorder(BorderFactory.createBevelBorder(1,new Color(100,100,155),new Color(100,100,155)));
			//tfh.setHorizontalAlignment(JTextField.CENTER);
			//tfh.setEditable(false);
			//tfh.setBackground(new Color(192,192,255));
			//tfh.setFont(new Font("verdana",Font.BOLD,20));
			//tfh.setForeground(new Color(255,255,255));
			//cr.add(tfh,"North");
			JLabel l=new JLabel("<html><font size=5 color=#800080><i>Enter The Subject");
			JPanel title=new JPanel()
			{
				public void paintComponent(Graphics g)
				{

					Toolkit kit=Toolkit.getDefaultToolkit();
					Image img=kit.getImage("HEADER.gif");
					MediaTracker t=new MediaTracker(this);
					t.addImage(img,1);
					while(true)
					{
						try
						{
							t.waitForID(1);
							break;
						}
						catch(Exception e)
						{
						}
					}
					g.drawImage(img,0,0,600,50,null);
				}
			};
			title.add(l);
			cr.add(title,"North");

			JButton ok=new JButton("  Ok  ");
			JButton cancle=new JButton("Cancle");
			JPanel butPanel=new JPanel();
			butPanel.setBackground(new Color(255,197,68));
			butPanel.add(ok);
			butPanel.add(cancle);
			cr.add(butPanel,"South");

			SubjectListener listen=new SubjectListener();
			ok.addActionListener(listen);
			cancle.addActionListener(listen);

			cdur=(String)duration.getSelectedItem();

			coursePanel=new JPanel()
			{
				public void paintComponent(Graphics g)
				{
					Toolkit kit=Toolkit.getDefaultToolkit();
					Image img=kit.getImage("Gradient2.jpg");
					MediaTracker t=new MediaTracker(this);
					t.addImage(img,1);
					while(true)
					{
						try
						{
							t.waitForID(1);
							break;
						}
						catch(Exception e)
						{
						}
					}
					g.drawImage(img,0,0,660,660,null);
				}
			};
			coursePanel.setLayout(new GridBagLayout());

			GridBagConstraints cons=new GridBagConstraints();
			cons.fill=GridBagConstraints.BOTH;
			cons.anchor=GridBagConstraints.WEST;
			cons.weightx=100;
			cons.weighty=0;

			ContainerOrderFocusTraversalPolicy cp=new ContainerOrderFocusTraversalPolicy();
			cp.setImplicitDownCycleTraversal(true);

			cons.anchor=GridBagConstraints.EAST;
			if(cdur.equals("Eight Semester")||cdur.equals("Six Semester")||cdur.equals("Four Semester")||cdur.equals("Two Semester"))
			{
				add(new JLabel("<HTML><FONT SIZE=4 color=blue style=verdana> 1 st Semester "),cons,1,0,3,1);
			}
			else
			{
				add(new JLabel("<HTML><FONT SIZE=4 color=blue style=verdana> 1 st Year "),cons,1,0,3,1);
			}
			cons.anchor=GridBagConstraints.WEST;
			for(int i=0;i<12;i++)
			{
				sem1[i]=new JTextField(10);

			}
			for(int i=1,k=0;i<4;i++)
			{
				for(int j=0;j<4;j++)
				{
					add(sem1[k],cons,j,i,1,1);
					sem1[k].setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
					k++;
				}
			}
			cons.anchor=GridBagConstraints.EAST;
			if(cdur.equals("Eight Semester")||cdur.equals("Six Semester")||cdur.equals("Four Semester")||cdur.equals("Two Semester"))
			{
				add(new JLabel("<HTML><FONT SIZE=4 color=blue style=verdana> 2 nd Semester "),cons,1,4,3,1);
			}
			else
			{
				add(new JLabel("<HTML><FONT SIZE=4 color=blue style=verdana> 2 nd Year "),cons,1,4,3,1);
			}
			cons.anchor=GridBagConstraints.WEST;
			for(int i=0;i<12;i++)
			{
				sem2[i]=new JTextField(10);
			}
			for(int i=5,k=0;i<8;i++)
			{
				for(int j=0;j<4;j++)
				{
					add(sem2[k],cons,j,i,1,1);
					sem2[k].setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
					k++;
				}
			}
			cons.anchor=GridBagConstraints.EAST;
			if(cdur.equals("Eight Semester")||cdur.equals("Six Semester")||cdur.equals("Four Semester")||cdur.equals("Two Semester"))
			{
				add(new JLabel("<HTML><FONT SIZE=4 color=blue style=verdana> 3 rd Semester "),cons,1,8,3,1);
			}
			else
			{
				add(new JLabel("<HTML><FONT SIZE=4 color=blue style=verdana> 3 rd Year "),cons,1,8,3,1);
			}
			cons.anchor=GridBagConstraints.WEST;
			for(int i=0;i<12;i++)
			{
				sem3[i]=new JTextField(10);
			}
			for(int i=9,k=0;i<12;i++)
			{
				for(int j=0;j<4;j++)
				{
					add(sem3[k],cons,j,i,1,1);
					sem3[k].setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
					k++;
				}
			}
			cons.anchor=GridBagConstraints.EAST;
			if(cdur.equals("Eight Semester")||cdur.equals("Six Semester")||cdur.equals("Four Semester")||cdur.equals("Two Semester"))
			{
				add(new JLabel("<HTML><FONT SIZE=4 color=blue style=verdana> 4 th Semester "),cons,1,12,3,1);
			}
			else
			{
				add(new JLabel("<HTML><FONT SIZE=4 color=blue style=verdana> 4 th Year "),cons,1,12,3,1);
			}
			cons.anchor=GridBagConstraints.WEST;
			for(int i=0;i<12;i++)
			{
				sem4[i]=new JTextField(10);
			}
			for(int i=13,k=0;i<16;i++)
			{
				for(int j=0;j<4;j++)
				{
					add(sem4[k],cons,j,i,1,1);
					sem4[k].setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
					k++;
				}
			}


			if(cdur.equals("Four Year")||cdur.equals("Three Year")||cdur.equals("Two Year")||cdur.equals("One Year"))
			{
				if(cdur.equals("Three Year"))
				{
					for(int i=0;i<12;i++)
					{
						sem4[i].setEditable(false);
					}
				}
				else
				if(cdur.equals("Two Year"))
				{
					for(int i=0;i<12;i++)
					{
						sem4[i].setEditable(false);
						sem3[i].setEditable(false);
					}
				}
				else
				if(cdur.equals("One Year"))
				{
					for(int i=0;i<12;i++)
					{
						sem4[i].setEditable(false);
						sem3[i].setEditable(false);
						sem2[i].setEditable(false);
					}
				}



			}
			if(cdur.equals("Eight Semester")||cdur.equals("Six Semester")||cdur.equals("Four Semester")||cdur.equals("Two Semester"))
			{

				if(cdur.equals("Two Semester"))
				{
					for(int i=0;i<12;i++)
					{
						sem4[i].setEditable(false);
						sem3[i].setEditable(false);
					}
				}



			}

		}
		public void add(Component comp,GridBagConstraints cons,int x,int y,int w,int h)
		{
				cons.gridx=x;
				cons.gridy=y;
				cons.gridwidth=w;
				cons.gridheight=h;
				cons.insets = new Insets(5, 5, 0, 5);
				comp.setSize(comp.getPreferredSize());
				coursePanel.add(comp,cons);
				cr.add(coursePanel);
		}
		class SubjectListener implements ActionListener
		{
			public void actionPerformed(ActionEvent e)
			{
				String str=e.getActionCommand();
				if(str.equals("  Ok  "))
				{
					String s1=sem1[0].getText();
					String s2=sem2[0].getText();
					String s3=sem3[0].getText();
					String s4=sem4[0].getText();
					if(cdur.equals("Six Semester")||cdur.equals("Eight Semester"))
					{
						if(s1.equals("")||s2.equals("")||s3.equals("")||s4.equals(""))
						{
							Icon error=new ImageIcon("error.png");
					 		JOptionPane.showMessageDialog(SubjectList.this,"<html><font size=4 color=red>Subject Can Not Be Blank </font></html> \n\t\t Please enter minimum One Subject","Login",JOptionPane.ERROR_MESSAGE,error);

						}
						else
						{
							sls=new SubjectListSem();
							sls.setVisible(true);
						}

					}
					else
					{

						if(cdur.equals("Four Semester") || cdur.equals("Four Year"))
						{
							if(s1.equals("")||s2.equals("")||s3.equals("")||s4.equals(""))
							{
								Icon error=new ImageIcon("error.png");
					 			JOptionPane.showMessageDialog(SubjectList.this,"<html><font size=4 color=red>Subject Can Not Be Blank </font></html> \n\t\t Please enter minimum One Subject","Login",JOptionPane.ERROR_MESSAGE,error);
							}
							else
							{
								CourseEntry ce=new CourseEntry();
								ce.saveSub();
								ce.createTables();
								sl.dispose();

							}
						}
						else
						if(cdur.equals("Three Semester") || cdur.equals("Three Year"))
						{
							if(s1.equals("")||s2.equals("")||s3.equals(""))
							{
								Icon error=new ImageIcon("error.png");
								JOptionPane.showMessageDialog(SubjectList.this,"<html><font size=4 color=red>Subject Can Not Be Blank </font></html> \n\t\t Please enter minimum One Subject","Login",JOptionPane.ERROR_MESSAGE,error);
							}
							else
							{
								CourseEntry ce=new CourseEntry();
								ce.saveSub();
								ce.createTables();
								sl.dispose();
							}

						}
						else
						if(cdur.equals("Two Semester") || cdur.equals("Two Year"))
						{
							if(s1.equals("")||s2.equals(""))
							{
								Icon error=new ImageIcon("error.png");
						      		JOptionPane.showMessageDialog(SubjectList.this,"<html><font size=4 color=red>Subject Can Not Be Blank </font></html> \n\t\t Please enter minimum One Subject","Login",JOptionPane.ERROR_MESSAGE,error);
							}
							else
							{
								CourseEntry ce=new CourseEntry();
								ce.saveSub();
								ce.createTables();
								sl.dispose();
							}

						}
						else
						if(cdur.equals("One Semester") || cdur.equals("One Year"))
						{
							if(s1.equals(""))
							{
								Icon error=new ImageIcon("error.png");
						      		JOptionPane.showMessageDialog(SubjectList.this,"<html><font size=4 color=red>Subject Can Not Be Blank </font></html> \n\t\t Please enter minimum One Subject","Login",JOptionPane.ERROR_MESSAGE,error);
							}
							else
							{
								CourseEntry ce=new CourseEntry();
								ce.saveSub();
								ce.createTables();
								sl.dispose();
							}

						}

					}

				}
				else
				{
					sl.dispose();
				}
			}
		}


	}
	class SubjectListSem extends JDialog
	{
		JPanel coursePanel;

		Container cr=getContentPane();
		String cdur;
		SubjectListSem()
		{
			super(CourseAddition.this,"Subject List",true);
			setSize(width+100,height+250);
			setLocation(width-20,40);
			setResizable(false);
			setIconImage(Toolkit.getDefaultToolkit().getImage("mainicon.png"));
			SubjectList.setDefaultLookAndFeelDecorated(true);
			slsflag=true;

			//JTextField tfh=new JTextField("Enter The Subject",SwingConstants.CENTER);
			//tfh.setBorder(BorderFactory.createBevelBorder(1,new Color(100,100,155),new Color(100,100,155)));
			//tfh.setHorizontalAlignment(JTextField.CENTER);
			//tfh.setEditable(false);
			//tfh.setBackground(new Color(192,192,255));
			//tfh.setFont(new Font("verdana",Font.BOLD,20));
			//tfh.setForeground(new Color(255,255,255));
			//cr.add(tfh,"North");

			JLabel l=new JLabel("<html><font size=5 color=#800080><i>Enter The Subject");
			JPanel title=new JPanel()
			{
				public void paintComponent(Graphics g)
				{

					Toolkit kit=Toolkit.getDefaultToolkit();
					Image img=kit.getImage("HEADER.gif");
					MediaTracker t=new MediaTracker(this);
					t.addImage(img,1);
					while(true)
					{
						try
						{
							t.waitForID(1);
							break;
						}
						catch(Exception e)
						{
						}
					}
					g.drawImage(img,0,0,600,50,null);
				}
			};
			title.add(l);
			cr.add(title,"North");


			JButton ok=new JButton("  Ok  ");
			JButton cancle=new JButton("Cancle");
			SubjectListener2 handler=new SubjectListener2();
			ok.addActionListener(handler);
			cancle.addActionListener(handler);
			JPanel butPanel=new JPanel();
			butPanel.setBackground(new Color(255,197,68));
			butPanel.add(ok);
			butPanel.add(cancle);
			cr.add(butPanel,"South");

			cdur=(String)duration.getSelectedItem();

			coursePanel=new JPanel()
			{
				public void paintComponent(Graphics g)
				{
					Toolkit kit=Toolkit.getDefaultToolkit();
					Image img=kit.getImage("Gradient2.jpg");
					MediaTracker t=new MediaTracker(this);
					t.addImage(img,1);
					while(true)
					{
						try
						{
							t.waitForID(1);
							break;
						}
						catch(Exception e)
						{
						}
					}
					g.drawImage(img,0,0,470,500,null);
				}
			};
			coursePanel.setLayout(new GridBagLayout());


			GridBagConstraints cons=new GridBagConstraints();
			cons.fill=GridBagConstraints.BOTH;
			cons.anchor=GridBagConstraints.WEST;
			cons.weightx=100;
			cons.weighty=0;
			ContainerOrderFocusTraversalPolicy cp=new ContainerOrderFocusTraversalPolicy();
			cp.setImplicitDownCycleTraversal(true);

			cons.anchor=GridBagConstraints.EAST;
			add(new JLabel("<HTML><FONT SIZE=4 color=blue style=verdana> 5 th Semester "),cons,1,0,3,1);

			cons.anchor=GridBagConstraints.WEST;
			for(int i=0;i<12;i++)
			{
				sem5[i]=new JTextField(10);
			}
			for(int i=1,k=0;i<4;i++)
			{
				for(int j=0;j<4;j++)
				{
					add(sem5[k],cons,j,i,1,1);
					sem5[k].setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
					k++;
				}
			}
			cons.anchor=GridBagConstraints.EAST;
			add(new JLabel("<HTML><FONT SIZE=4 color=blue style=verdana> 6 th Semester "),cons,1,4,3,1);

			cons.anchor=GridBagConstraints.WEST;
			for(int i=0;i<12;i++)
			{
				sem6[i]=new JTextField(10);
			}
			for(int i=5,k=0;i<8;i++)
			{
				for(int j=0;j<4;j++)
				{
					add(sem6[k],cons,j,i,1,1);
					sem6[k].setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
					k++;
				}
			}
			cons.anchor=GridBagConstraints.EAST;
			add(new JLabel("<HTML><FONT SIZE=4 color=blue style=verdana> 7 th Semester "),cons,1,8,3,1);

			cons.anchor=GridBagConstraints.WEST;
			for(int i=0;i<12;i++)
			{
				sem7[i]=new JTextField(10);
			}
			for(int i=9,k=0;i<12;i++)
			{
				for(int j=0;j<4;j++)
				{
					add(sem7[k],cons,j,i,1,1);
					sem7[k].setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
					k++;
				}
			}
			cons.anchor=GridBagConstraints.EAST;
			add(new JLabel("<HTML><FONT SIZE=4 color=blue style=verdana> 8 th Semester "),cons,1,12,3,1);
			cons.anchor=GridBagConstraints.WEST;
			for(int i=0;i<12;i++)
			{
				sem8[i]=new JTextField(10);
			}
			for(int i=13,k=0;i<16;i++)
			{
				for(int j=0;j<4;j++)
				{
					add(sem8[k],cons,j,i,1,1);
					sem8[k].setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
					k++;
				}
			}


			if(cdur.equals("Eight Semester")||cdur.equals("Six Semester"))
			{

				if(cdur.equals("Six Semester"))
				{
					for(int i=0;i<12;i++)
					{
						sem8[i].setEditable(false);
						sem7[i].setEditable(false);
					}
				}

			}

		}
		public void add(Component comp,GridBagConstraints cons,int x,int y,int w,int h)
		{
			cons.gridx=x;
			cons.gridy=y;
			cons.gridwidth=w;
			cons.gridheight=h;
			cons.insets = new Insets(5, 5, 0, 5);
			comp.setSize(comp.getPreferredSize());
			coursePanel.add(comp,cons);
			cr.add(coursePanel);
		}
		class SubjectListener2 implements ActionListener
		{
			public void actionPerformed(ActionEvent e)
			{
				String str=e.getActionCommand();
				if(str.equals("  Ok  "))
				{
					String s5=sem5[0].getText();
					String s6=sem6[0].getText();
					String s7=sem7[0].getText();
					String s8=sem8[0].getText();
					if(cdur.equals("Eight Semester"))
					{
						if(s5.equals("")||s6.equals("")||s7.equals("")||s8.equals(""))
						{
							Icon error=new ImageIcon("error.png");
					 		JOptionPane.showMessageDialog(CourseAddition.this,"<html><font size=4 color=red>Subject Can Not Be Blank </font></html> \n\t\t Please enter minimum One Subject","Login",JOptionPane.ERROR_MESSAGE,error);
						}
						else
						{
							CourseEntry cs=new CourseEntry();
							cs.saveSub();
							cs.saveSubLast();
							cs.createTables();
							sls.dispose();
							sl.dispose();
						}
					}
					else
					if(cdur.equals("Six Semester"))
					{
						if(s5.equals("")||s6.equals(""))
						{
							Icon error=new ImageIcon("error.png");
					 		JOptionPane.showMessageDialog(CourseAddition.this,"<html><font size=4 color=red>Subject Can Not Be Blank </font></html> \n\t\t Please enter minimum One Subject","Login",JOptionPane.ERROR_MESSAGE,error);
						}
						else
						{
							CourseEntry cs=new CourseEntry();
							cs.saveSub();
							cs.saveSubLast();
							cs.createTables();
							sls.dispose();
							sl.dispose();
						}
					}



				}
				else
				{
					sls.dispose();
				}
			}
		}


	}
	class CourseEntry
	{
		Connection conn;
		Statement st;
		DataOutputStream dout;
		String tem;
		String cname;
		CourseEntry()
		{
			try
			{
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				conn=DriverManager.getConnection("jdbc:odbc:Student_Info","raj","17java71");
				st=conn.createStatement();
			}
			catch(Exception e)
			{
			}


		}
		public void saveSub()
		{
			JTextField semtemp[];
			cname=coursename.getText().trim();
			String cid=courseid.getText();
			String tfees=totalfees.getText();
			String dur=(String)duration.getSelectedItem();
			count=0;
			try
			{
				PreparedStatement ps=conn.prepareStatement("insert into course_name values(?,?,?,?)");
				ps.setString(1,cid);
				ps.setString(2,cname);
				ps.setInt(3,Integer.parseInt(tfees));
				ps.setString(4,dur);
				ps.execute();
				if(dur.equals("Four Year")||dur.equals("Four Semester")||dur.equals("Eight Semester")||dur.equals("Six Semester"))
				{
					tem=cname+"_sub";
					st.executeUpdate("create table "+tem+" (sub_id DOUBLE,sub_name CHAR(30))");
					PreparedStatement insert=conn.prepareStatement("insert into "+tem+" values(?,?)");
					int i=0;
					int j=1;
					Double d=1.1;
					semtemp=sem1;
					while(j<=4)
					{
						String sub=semtemp[i].getText();
						while(!sub.equals(""))
						{
							insert.setDouble(1,d);
							insert.setString(2,sub);
							insert.execute();
							d +=0.1;
							i++;
							sub=semtemp[i].getText();
							count++;
						}

						i=0;
						j++;

						if(j==2)
						{
							semtemp=sem2;
							d=2.1;
						}
						if(j==3)
						{
							semtemp=sem3;
							d=3.1;
						}
						if(j==4)
						{
							semtemp=sem4;
							d=4.1;
						}
					}

				}
				else
				if(dur.equals("Three Year"))
				{
					tem=cname+"_sub";
					st.executeUpdate("create table "+tem+" (sub_id DOUBLE,sub_name CHAR(30))");
					PreparedStatement insert=conn.prepareStatement("insert into "+tem+" values(?,?)");
					int i=0;
					int j=1;
					Double d=1.1;
					semtemp=sem1;
					while(j<=3)
					{
						String sub=semtemp[i].getText();
						while(!sub.equals(""))
						{
							insert.setDouble(1,d);
							insert.setString(2,sub);
							insert.execute();
							d +=0.1;
							i++;
							sub=semtemp[i].getText();
							count++;
						}
						i=0;
						j++;

						if(j==2)
						{
							semtemp=sem2;
							d=2.1;
						}
						if(j==3)
						{
							semtemp=sem3;
							d=3.1;
						}
					}

				}
				else
				if(dur.equals("Two Year")||dur.equals("Two Semester"))
				{
					tem=cname+"_sub";
					st.executeUpdate("create table "+tem+" (sub_id DOUBLE,sub_name CHAR(30))");
					PreparedStatement insert=conn.prepareStatement("insert into "+tem+" values(?,?)");
					int i=0;
					int j=1;
					Double d=1.1;
					semtemp=sem1;
					while(j<=2)
					{
						String sub=semtemp[i].getText();
						while(!sub.equals(""))
						{
							insert.setDouble(1,d);
							insert.setString(2,sub);
							insert.execute();
							d +=0.1;
							i++;
							sub=semtemp[i].getText();
							count++;
						}
						i=0;
						j++;
						d +=1.0;
						if(j==2)
						{
							semtemp=sem2;
							d=2.1;
						}
					}

				}
				else
				if(dur.equals("One Year"))
				{
					tem=cname+"_sub";
					st.executeUpdate("create table "+tem+" (sub_id DOUBLE,sub_name CHAR(30))");
					PreparedStatement insert=conn.prepareStatement("insert into "+tem+" values(?,?)");
					int i=0;
					int j=1;
					Double d=1.1;
					semtemp=sem1;
					while(j<=1)
					{
						String sub=semtemp[i].getText();
						while(!sub.equals(""))
						{
							insert.setDouble(1,d);
							insert.setString(2,sub);
							insert.execute();
							d +=0.1;
							i++;
							sub=semtemp[i].getText();
							count++;
						}
						j++;
					}

				}
				dout=new DataOutputStream(new FileOutputStream(cname+"_id.dat"));
				dout.writeUTF(cname+"0001");

				DataInputStream dt=new DataInputStream(new FileInputStream("courid.dat"));
				String temp2=dt.readUTF();
				String temp=temp2.substring(3);
				int x=Integer.parseInt(temp);
				if(x<9)
				{
					temp=temp2.substring(3);
					x=Integer.parseInt(temp);
					x++;
					temp2="cur000"+x;
				}
				else
				{
					temp=temp2.substring(3);
					x=Integer.parseInt(temp);
					x++;
					temp2="cur00"+x;
				}
				DataOutputStream out=new DataOutputStream(new FileOutputStream("courid.dat"));
				out.writeUTF(temp2);
				dt.close();
				out.close();
			}
			catch(Exception e)
			{
			}
		}
		public void saveSubLast()
		{
			JTextField semtemp[];
			cname=coursename.getText().trim();
			String dur=(String)duration.getSelectedItem();
			try
			{
				if(dur.equals("Eight Semester"))
				{
					PreparedStatement insert=conn.prepareStatement("insert into "+tem+" values(?,?)");
					int i=0;
					int j=1;
					Double d=5.1;
					semtemp=sem5;
					while(j<=4)
					{
						String sub=semtemp[i].getText();
						while(!sub.equals(""))
						{
							insert.setDouble(1,d);
							insert.setString(2,sub);
							insert.execute();
							d +=0.1;
							i++;
							sub=semtemp[i].getText();
							count++;
						}
						i=0;
						j++;

						if(j==2)
						{
							semtemp=sem6;
							d=6.1;
						}
						if(j==3)
						{
							semtemp=sem7;
							d=7.1;
						}
						if(j==4)
						{
							semtemp=sem8;
							d=8.1;
						}
					}
					insert.close();
				}
				else
				if(dur.equals("Six Semester"))
				{
					PreparedStatement insert=conn.prepareStatement("insert into "+tem+" values(?,?)");
					int i=0;
					int j=1;
					Double d=5.1;
					semtemp=sem1;
					while(j<=2)
					{
						String sub=semtemp[i].getText();
						while(!sub.equals(""))
						{
							insert.setDouble(1,d);
							insert.setString(2,sub);
							insert.execute();
							d +=0.1;
							i++;
							sub=semtemp[i].getText();
							count++;
						}
						i=0;
						j++;
						d +=1.0;
						if(j==2)
						{
							semtemp=sem6;
							d=6.1;
						}

					}
					insert.close();
				}

			}
			catch(Exception ex)
			{
			}
		}
		public void createTables()
		{
			try
			{
				st.executeUpdate("create table "+cname+"_stud_info (scode CHAR(20),sname CHAR(25),mname CHAR(25),lname CHAR(25),address CHAR(60),dateofjoin CHAR(15),mobno CHAR(12),totalfees INTEGER,paidfees INTEGER,addfees INTEGER,remfees INTEGER,appyear CHAR(12))");
				String dur=(String)duration.getSelectedItem();
				int x=0;
				if(dur.equals("One Year"))
					x=1;
				if(dur.equals("Two Year")||dur.equals("Two Semester"))
					x=2;
				if(dur.equals("Three Year"))
					x=3;
				if(dur.equals("Four Year")||dur.equals("Four Semester"))
					x=4;
				if(dur.equals("Six Semester"))
					x=6;
				if(dur.equals("Eight Semester"))
					x=8;
				for(int i=1;i<=x;i++)
					st.executeUpdate("create table "+cname+"_marks"+i+" (scode CHAR(20),appyear CHAR(12))");
				ResultSet sc=st.executeQuery("select * from "+tem+"");
				int t=0;
				String sb[]=new String[count];
				String str=null;
				while(sc.next())
				{
					String s=sc.getString(1);
					sb[t]=s.replace(".","0");
					t++;
				}
				for(t=0;t<sb.length;t++)
				{
					if((Integer.parseInt(sb[t])>100)&&(Integer.parseInt(sb[t])<200))
					{
						str="S"+sb[t];
						st.executeUpdate("alter table "+cname+"_marks1 add "+str+" INTEGER");
					}

					if((Integer.parseInt(sb[t])>200)&&(Integer.parseInt(sb[t])<300))
					{
						str="S"+sb[t];
						st.executeUpdate("alter table "+cname+"_marks2 add "+str+" INTEGER");
					}
					if((Integer.parseInt(sb[t])>300)&&(Integer.parseInt(sb[t])<400))
					{
						str="S"+sb[t];
						st.executeUpdate("alter table "+cname+"_marks3 add "+str+" INTEGER");
					}
					if((Integer.parseInt(sb[t])>400)&&(Integer.parseInt(sb[t])<500))
					{
						str="S"+sb[t];
						st.executeUpdate("alter table "+cname+"_marks4 add "+str+" INTEGER");
					}
					if((Integer.parseInt(sb[t])>500)&&(Integer.parseInt(sb[t])<600))
					{
						str="S"+sb[t];
						st.executeUpdate("alter table "+cname+"_marks5 add "+str+" INTEGER");
					}
					if((Integer.parseInt(sb[t])>600)&&(Integer.parseInt(sb[t])<700))
					{
						str="S"+sb[t];
						st.executeUpdate("alter table "+cname+"_marks6 add "+str+" INTEGER");
					}
					if((Integer.parseInt(sb[t])>700)&&(Integer.parseInt(sb[t])<800))
					{
						str="S"+sb[t];
						st.executeUpdate("alter table "+cname+"_marks7 add "+str+" INTEGER");
					}
					if((Integer.parseInt(sb[t])>800)&&(Integer.parseInt(sb[t])<900))
					{
						str="S"+sb[t];
						st.executeUpdate("alter table "+cname+"_marks8 add "+str+" INTEGER");
					}
				}

			}
			catch(Exception e)
			{
			}
		}


	}
}
