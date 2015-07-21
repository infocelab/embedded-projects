import javax.swing.*;
import javax.swing.plaf.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.plaf.metal.*;
import java.sql.*;
import java.io.*;
import javax.swing.event.*;
import javax.swing.table.*;
import com.sun.java.swing.plaf.motif.*;
	import com.sun.java.swing.plaf.windows.*;

class StaffContact extends JFrame
{

	Container c;
	JPanel main;
	private JTextField fcode;
	private JTextField fname;
	private JTextField fmname;
	private JTextField flname;
	private JTextArea addfield;
	private JComboBox joindateday;
	private JComboBox joindatemon;
	private JComboBox joindateyear;
	private JTextField mobno;
	private JTextField salary;
	private JTextField addsalary;
	private JTextArea education;
	private JButton New;
	private JButton save;
	private JButton modify;
	private JButton remove;
	private JButton exit;
	private JTable table;
	private JButton timetable;
	boolean therty=false;
	boolean twentynine=false;
	boolean twentyeight=false;
	JCheckBox chbox;
	TextValid onlyText;
	NumberValid onlyNumber;
	Connection conn;
	Statement st;
	LectureTimeTable tm;
	int height;
   	int width;
   	Dimension screenSize;
	StaffContact()
	{
		Toolkit kits=Toolkit.getDefaultToolkit();
		screenSize=kits.getScreenSize();
		width=screenSize.width/2;
		height=screenSize.height/2;
		setSize(width+180,height+260);
		setTitle("Staff Contact");
		setLocation(screenSize.width/6,20);
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				dispose();
				new MainMenuFrame().setVisible(true);
			}
		});
		StaffContact.setDefaultLookAndFeelDecorated(true);
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("mainicon.png"));
		c=getContentPane();
		JLabel l=new JLabel("<html><font size=6 color=#800080><i>Staff Information");
		JPanel titlepan=new JPanel()
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
				g.drawImage(img,0,0,width+180,50,null);
			}
		};
		titlepan.add(l);
		c.add(titlepan,"North");

		main=new JPanel()
		{
			public void paintComponent(Graphics g)
			{

				Toolkit kit=Toolkit.getDefaultToolkit();
				Image img=kit.getImage("plain.jpg");
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
				g.drawImage(img,0,0,width+180,height+260,null);
			}
		};
		main.setLayout(new GridBagLayout());

		onlyText=new TextValid();
		onlyNumber=new NumberValid();
		fcode=new JTextField(10);
		fcode.setToolTipText("Faculty Code");
		fcode.setEditable(false);
		fcode.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
		fname=new JTextField(20);
		fname.addKeyListener(onlyText);
		fname.setToolTipText("Enter Faculty Name");
		fname.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
		fmname=new JTextField(20);
		fmname.addKeyListener(onlyText);
		fmname.setToolTipText("Enter Middle Name");
		fmname.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
		flname=new JTextField(20);
		flname.addKeyListener(onlyText);
		flname.setToolTipText("Enter Last Name");
		flname.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
		addfield=new JTextArea(2,20);
		addfield.setToolTipText("Enter Faculty Address");
		addfield.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
		addfield.setWrapStyleWord(true);
		addfield.setLineWrap(true);
		JScrollPane addf=new JScrollPane(addfield);
		education=new JTextArea(2,20);
		education.setToolTipText("Enter Faculty,s Education");
		education.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
		education.setWrapStyleWord(true);
		education.setLineWrap(true);
		JScrollPane edu=new JScrollPane(education);
		joindateday=new JComboBox();
		joindateday.setToolTipText("Select  Day");
		joindateday.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
		joindatemon=new JComboBox(new String[]{"Jan ","Feb ","Mar ","Apr ","May ","June","July","Aug ","Sept","Oct ","Nov ","Desc"});
		joindatemon.setToolTipText("Select  Month");
		joindatemon.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
		joindateyear=new JComboBox();
		joindateyear.setToolTipText("Select  Year");
		joindateyear.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
		mobno=new JTextField(14);
		mobno.addKeyListener(onlyNumber);
		mobno.setToolTipText("Enter Mobile Number ");
		mobno.setBorder(BorderFactory.createBevelBorder(1,new Color(100,100,155),new Color(100,100,155)));
		mobno.setSelectionColor(Color.blue);
		mobno.setDisabledTextColor(Color.red);
		mobno.setCaretColor(Color.green);
		mobno.setSelectionColor(Color.pink);
		mobno.setFont(new Font("verdana", Font.BOLD, 12));
		salary=new JTextField(8);
		salary.addKeyListener(onlyNumber);
		salary.setToolTipText("Enter the Salary Of Faculty");
		salary.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
		addsalary=new JTextField(8);
		addsalary.addKeyListener(onlyNumber);
		addsalary.setToolTipText("Enter the Additional Salary Of Faculty eg. Bounce , Extra Lecture etc.");
		addsalary.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			conn=DriverManager.getConnection("jdbc:odbc:Teacher_Info","raj","17java71");
			st=conn.createStatement();
			ResultSet tableset=st.executeQuery("Select * from FacultyInfo ");
			int row=0;
			int i=0;
			while(tableset.next())
			{
				row++;
			}
			DefaultTableModel model=new DefaultTableModel(new String[]{"Faculty Code","Name","Last Name","Mobile No"},row);
			table=new JTable(model);
			tableset=st.executeQuery("Select * from FacultyInfo ");
			while(tableset.next())
			{
				model.setValueAt(tableset.getString(1).trim(),i,0);
				model.setValueAt(tableset.getString(2).trim(),i,1);
				model.setValueAt(tableset.getString(4).trim(),i,2);
				model.setValueAt(tableset.getString(8).trim(),i,3);
				i++;
			}

		}
		catch(Exception ex)
		{
		}
		table.setToolTipText("Select the Faculty for more information");
		JScrollPane table1=new JScrollPane(table);
		table.doLayout();
		table.setColumnSelectionAllowed(false);
		table.setSelectionMode(1);
		table.setEditingColumn(3);
		table.setGridColor(Color.magenta);
		table.setRowMargin(3);
		table.setSelectionBackground(new Color(194,253,254));
		table.setSelectionForeground(new Color(128,64,0));
		table.setShowHorizontalLines(false);
		table.setShowVerticalLines(false);

		timetable=new JButton("<html><font size=3 color=#000080> Add Time Table");
		timetable.setToolTipText("Add Time Table");
		New=new JButton("New");
		New.setToolTipText("Add New Faculty");
		save=new JButton("Save");
		save.setToolTipText("Save The Entry of Faculty");
		modify=new JButton("Modify");
		modify.setToolTipText("Modify the Entry");
		remove=new JButton("Remove");
		remove.setToolTipText("Remove The Faculty Entry");
		exit=new JButton("Exit");
		exit.setToolTipText("Close Staff Information Form");

		//Icon ic=new ImageIcon("mainicon.png");

		chbox=new JCheckBox("<html><font color=blue size=4>Send Daily Message");
		try
		{
			DataInputStream sin=new DataInputStream(new FileInputStream("status.dat"));
			String st=sin.readUTF();
			boolean flag=false;
			if(st.equals("true"))
				flag=true;
			chbox.setSelected(flag);
		}
		catch(Exception e)
		{

		}
		chbox.addItemListener(new ItemListener()
		{
			MessageThread msg=new MessageThread();
			public void itemStateChanged(ItemEvent ed)
			{
				boolean fg=chbox.isSelected();
				Icon warning=new ImageIcon("warning.png");
				Icon question=new ImageIcon("question.png");
				Icon info=new ImageIcon("info.png");
				if(fg==true)
				{

					int ans=JOptionPane.showConfirmDialog(null,"Are you sure you want to Send Daily Message?","Send",JOptionPane.YES_NO_OPTION,1,question);
					if(ans==JOptionPane.YES_OPTION)
					{
						try
						{
							DataOutputStream dout=new DataOutputStream(new FileOutputStream("status.dat"));
							dout.writeUTF("true");
							JOptionPane.showMessageDialog(null,"Message Sending Start","Send",JOptionPane.INFORMATION_MESSAGE,info);
				  			msg.start();

						}
						catch(Exception ex)
						{

						}
					}
					else
					{

						JOptionPane.showMessageDialog(null,"Sending Message Failed","Disacard",JOptionPane.WARNING_MESSAGE,warning);
					}
				}
				else
				{
					int ans=JOptionPane.showConfirmDialog(null,"Are you sure you want to Stop Daily Message?","Send",JOptionPane.YES_NO_OPTION,1,question);
					if(ans==JOptionPane.YES_OPTION)
					{
						try
						{
							DataOutputStream dout=new DataOutputStream(new FileOutputStream("status.dat"));
							dout.writeUTF("false");
							msg.suspend();
							JOptionPane.showMessageDialog(null,"Sending Message Stop","Disacard",JOptionPane.INFORMATION_MESSAGE,info);
							LoginFrame.stm.endMsg();
						}
						catch(Exception ex)
						{
						}
					}
					else
					{
					}
				}
			}
		});
		FacultyInfoHandler h=new FacultyInfoHandler();
		New.addActionListener(h);
		modify.addActionListener(h);
		save.addActionListener(h);
		remove.addActionListener(h);
		exit.addActionListener(h);
		try
		{
			DataInputStream sin=new DataInputStream(new FileInputStream("Faculty_id.dat"));
			fcode.setText(sin.readUTF());
		}
		catch(Exception ew)
		{
		}
		joindateday.setMaximumSize(joindateday.getMinimumSize());
		joindatemon.setMaximumSize(joindatemon.getMinimumSize());
		joindateyear.setMaximumSize(joindateyear.getMinimumSize());
		joindateday.setMaximumRowCount(10);
		joindatemon.setMaximumRowCount(10);
		joindateyear.setMaximumRowCount(10);
		DateHandlerF datehandler=new DateHandlerF();
		joindatemon.addActionListener(datehandler);
		joindateyear.addActionListener(datehandler);
		String day[]=new String[31];
		String year[]=new String[150];
		for(int i=0;i<31;i++)
		{
			day[i]=""+(i+1);
			joindateday.addItem(day[i]);
		}
		for(int i=0,y=1950;i<150;i++,y++)
		{
			year[i]=Integer.toString(y);
			joindateyear.addItem(year[i]);
		}
		joindateyear.setSelectedItem("2007");

		GridBagConstraints cons=new GridBagConstraints();
		cons.fill=GridBagConstraints.BOTH;
		cons.anchor=GridBagConstraints.EAST;
		cons.weightx=70;
		cons.weighty=5;
		cons.insets = new Insets(0,420, 0, 50);
		add(timetable,cons,0,0,2,1);
		cons.fill=GridBagConstraints.NONE;
		cons.weightx=10;
		cons.weighty=10;
		cons.insets = new Insets(0, 10, 5, 0);
		add(new JLabel("Faculty Code  : "),cons,0,1,1,1);
		add(new JLabel("Faculty Name  : "),cons,0,2,1,1);
		add(new JLabel("Middle name  : "),cons,0,3,1,1);
		add(new JLabel("Last Name  : "),cons,0,4,1,1);
		add(new JLabel("Address  : "),cons,0,5,1,2);
		add(new JLabel("Education  : "),cons,0,7,1,2);
		add(new JLabel("Date Of Joining  : "),cons,0,9,1,1);
		add(new JLabel("Mobile Number  : "),cons,0,11,1,1);
		add(new JLabel("Salary  : "),cons,0,12,1,1);
		add(new JLabel("Additional salary  : "),cons,0,13,1,1);
		cons.fill=GridBagConstraints.HORIZONTAL;
		cons.weightx = 50;

		cons.insets = new Insets(0, 10, 5, 40);
		add(fcode, cons, 1, 1, 1, 1);
		cons.insets = new Insets(0, 10, 1, 40);
		add(fname,cons,1,2,1,1);
		add(fmname,cons,1,3,1,1);
		add(flname,cons,1,4,1,1);
		cons.insets = new Insets(0, 10, 1, 200);
		cons.ipady = 20;
		add(addf,cons,1,5,1,2);
		add(edu,cons,1,7,1,2);
		cons.ipady = 0;
		cons.insets = new Insets(0, 10, 5, 40);
		Box datebox=Box.createHorizontalBox();
		datebox.add(joindateday);
		datebox.add(Box.createHorizontalStrut(10));
		datebox.add(joindatemon);
		datebox.add(Box.createHorizontalStrut(10));
		datebox.add(joindateyear);
		datebox.add(Box.createGlue());
		add(datebox,cons,1,9,1,1);
		cons.insets=new Insets(0,11,5,315);
		cons.ipady = 5;
		add(mobno,cons,1,11,1,1);
		cons.ipady = 0;
		cons.insets=new Insets(0,10,1,40);
		add(salary,cons,1,12,1,1);
		add(addsalary,cons,1,13,1,1);
		cons.weightx=20;
		cons.anchor=GridBagConstraints.CENTER;
		cons.insets = new Insets(10, 20, 5, 20);
		cons.ipadx=0;
		cons.ipady=20;
		cons.weighty = 20;
		Box hbox=Box.createHorizontalBox();
		hbox.add(Box.createGlue());
		hbox.add(New);
		hbox.add(Box.createHorizontalStrut(15));
		hbox.add(save);
		hbox.add(Box.createHorizontalStrut(15));
		hbox.add(modify);
		hbox.add(Box.createHorizontalStrut(15));
		hbox.add(remove);
		hbox.add(Box.createHorizontalStrut(15));
		hbox.add(exit);
		hbox.add(Box.createHorizontalStrut(15));
		hbox.add(chbox);
		hbox.add(Box.createGlue());
		add(hbox,cons,0,14,3,1);
		cons.weightx=100;
		cons.weighty=100;
		cons.insets=new Insets(5,16,10,15);
		cons.fill=GridBagConstraints.BOTH;
		add(table1,cons,0,15,3,3);
		table.addMouseListener(new FacultyTableHandler());
		addWindowListener(new StaffWindowHandler());
		timetable.addActionListener(new AddTimeTable());

	}
	public void add(Component comp,GridBagConstraints cons,int x,int y,int w,int h)
	{
		cons.gridx=x;
		cons.gridy=y;
		cons.gridwidth=w;
		cons.gridheight=h;
		comp.setPreferredSize(comp.getPreferredSize());
		main.add(comp,cons);
		c.add(main);
	}
	class StaffWindowHandler extends WindowAdapter
	{
		public void windowActivated(WindowEvent we)
		{
			try
			{
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				conn=DriverManager.getConnection("jdbc:odbc:Teacher_Info","raj","17java71");
				st=conn.createStatement();
				ResultSet tableset=st.executeQuery("Select * from FacultyInfo ");
				int row=0;
				int i=0;
				while(tableset.next())
				{
					row++;
				}
				DefaultTableModel model=new DefaultTableModel(new String[]{"Faculty Code","Name","Last Name","Mobile No"},row);
				tableset=st.executeQuery("Select * from FacultyInfo ");
				while(tableset.next())
				{
					model.setValueAt(tableset.getString(1).trim(),i,0);
					model.setValueAt(tableset.getString(2).trim(),i,1);
					model.setValueAt(tableset.getString(4).trim(),i,2);
					model.setValueAt(tableset.getString(8).trim(),i,3);
					i++;
				}
				table.setModel(model);
			}
			catch(Exception ex)
			{
			}
		}
	}
	class FacultyTableHandler extends MouseAdapter
	{
		public void mouseClicked(MouseEvent me)
		{
			int ro=table.getSelectedRow();
			String sel=(String)table.getValueAt(ro,0);
			try
			{
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				conn=DriverManager.getConnection("jdbc:odbc:Teacher_Info","raj","17java71");

				st=conn.createStatement();
				ResultSet set=st.executeQuery("select * from FacultyInfo ");
				String scd="";
				while(set.next())
				{
					scd=set.getString(1).trim();
					if(sel.equals(scd))
						break;
				}
				fcode.setText(scd);
				fname.setText(set.getString(2));
				fmname.setText(set.getString(3));
				flname.setText(set.getString(4));
				addfield.setText(set.getString(5));
				education.setText(set.getString(6));
				String dat=set.getString(7);
				String day=dat.substring(0,2);
				if(day.charAt(0) == '0')
					day=String.valueOf(day.charAt(1));
				String mon=dat.substring(3,7);
				String yr=dat.substring(8,12);
				joindateday.setSelectedItem(day);
				joindatemon.setSelectedItem(mon);
				joindateyear.setSelectedItem(yr);
				mobno.setText(set.getString(8));
				salary.setText(set.getString(9));
				addsalary.setText(set.getString(10));
				save.setEnabled(false);

			}
			catch(Exception ew)
			{
			}

		}
	}
	class AddTimeTable implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			tm=new LectureTimeTable();
			tm.setVisible(true);
		}
	}
	class LectureTimeTable extends JDialog
	{
		Container cont;
		JScrollPane tsc;
		JPanel tpan;
		JPanel pan;
		JButton lsave;
		JButton lcancle;
		JComboBox facul;
		JTextField hr[];
		JTextField mt[];
		JComboBox sub[];
		JComboBox cour[];
		//JRadioButton ststate[];
		//JRadioButton endstate[];
		//ButtonGroup group[];
		CourseSubjectHandler handler;
		LectureTimeTable()
		{
			super(StaffContact.this,"Time Table",true);
			setSize(840,590);
			setLocation(108,27);
			LectureTimeTable.setDefaultLookAndFeelDecorated(true);
			setResizable(false);
			setIconImage(Toolkit.getDefaultToolkit().getImage("mainicon.png"));
			//JTextField tf=new JTextField("Time Table",SwingConstants.CENTER);
			//tf.setBorder(BorderFactory.createBevelBorder(1,new Color(100,100,155),new Color(100,100,155)));
			//tf.setHorizontalAlignment(JTextField.CENTER);
			//tf.setEditable(false);
			//tf.setBackground(new Color(192,192,255));
			//tf.setFont(new Font("verdana",Font.BOLD,28));
			//tf.setForeground(new Color(255,255,255));
			cont=getContentPane();
			//cont.add(tf,"North");
			JLabel l=new JLabel("<html><font size=6 color=#800080><i>Lecture Time Table");
						JPanel titlepan=new JPanel()
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
					g.drawImage(img,0,0,840,50,null);
				}
			};
			titlepan.add(l);
			cont.add(titlepan,"North");
			pan=new JPanel();
			tpan=new JPanel();
			tsc=new JScrollPane(tpan);
			lsave=new JButton(" Save ");
			lcancle=new JButton("Cancle");
			pan.add(lsave);
			pan.add(lcancle);
			pan.setBackground(new Color(255,197,68));
			cont.add(pan,"South");
			facul=new JComboBox();
			facul.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
			facul.setMaximumSize(facul.getMinimumSize());
			facul.setMaximumRowCount(4);
			try
			{
				st=conn.createStatement();
				ResultSet set=st.executeQuery("select * from FacultyInfo ");
				while(set.next())
				{
					facul.addItem(set.getString(1) +"                        "+set.getString(2)+" "+set.getString(4));
				}
			}
			catch(Exception ex)
			{
			}

			tpan.setLayout(new GridBagLayout());
			GridBagConstraints cons=new GridBagConstraints();
			cons.fill=GridBagConstraints.HORIZONTAL;
			cons.anchor=GridBagConstraints.EAST;
			cons.weightx=100;
			cons.weighty=10;
			JPanel ft=new JPanel();
			ft.add(new JLabel("<html><font size=5 color=#800080><B>  Faculty   :  "));
			ft.add(facul);
			addt(ft,cons,0,0,7,1);
			cons.weightx=30;
			cons.insets=new Insets(0,0,5,0);
			cons.fill=GridBagConstraints.NONE;
			cons.anchor=GridBagConstraints.CENTER;
			addt(new JLabel("<html><font size=5 Color=#000080> Lecture Time"),cons,1,1,2,1);
			cons.anchor=GridBagConstraints.EAST;
			cons.fill=GridBagConstraints.HORIZONTAL;
			cons.weightx=0;
			addt(new JLabel("<html><font size=4 color=#000080>L.N."),cons,0,1,1,1);
			for(int i=1,j=2;i<=10;i++,j=j+2)
			{
				addt(new JLabel("<html><font size=4 color=#800000>"+i+"<html><font size=4 color=#800000>)"),cons,0,j,1,1);

			}
			cons.insets=new Insets(0,10,5,5);
			cons.weightx=20;
			addt(new JLabel("<html><font size=4 Color=#800000>Monday"),cons,4,1,1,1);
			addt(new JLabel("<html><font size=4 Color=#800000>Tusday"),cons,5,1,1,1);
			addt(new JLabel("<html><font size=4 Color=#800000>Wednesday"),cons,6,1,1,1);
			addt(new JLabel("<html><font size=4 Color=#800000>Thusday"),cons,7,1,1,1);
			addt(new JLabel("<html><font size=4 Color=#800000>Friday"),cons,8,1,1,1);
			addt(new JLabel("<html><font size=4 Color=#800000>Saterday"),cons,9,1,1,1);

			hr=new JTextField[20];
			mt=new JTextField[20];
		//	ststate=new JRadioButton[20];
		//	endstate=new JRadioButton[20];
		//	group=new ButtonGroup[20];
			cons.insets=new Insets(0,0,5,0);
			for(int i=0,j=2;i<20;i++,j++)
			{
				JPanel p=new JPanel();
				JPanel p2=new JPanel();
				hr[i]=new JTextField(2);
				hr[i].setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
				hr[i].setMaximumSize(hr[i].getPreferredSize());
				hr[i].addKeyListener(onlyNumber);
				p.add(hr[i]);
				p.add(new JLabel("<html><font size=3 color=#800000>:"));
				mt[i]=new JTextField(2);
				mt[i].setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
				mt[i].setMaximumSize(mt[i].getPreferredSize());
				mt[i].addKeyListener(onlyNumber);
				p.add(mt[i]);

				//group[k]=new ButtonGroup();
				//ststate[k]=new JRadioButton("AM",true);
				//ststate[k].setForeground(Color.blue);
				//ststate[k].setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
				//p.add(ststate[k]);
				//group[k].add(ststate[k]);
				//ststate[++k]=new JRadioButton("PM",false);
				//ststate[k].setForeground(Color.blue);
				//ststate[k].setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
				//p.add(ststate[k]);
				//group[--k].add(ststate[++k]);

				hr[++i]=new JTextField(2);
				hr[i].setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
				hr[i].setMaximumSize(hr[i].getPreferredSize());
				hr[i].addKeyListener(onlyNumber);
				p2.add(hr[i]);

				p2.add(new JLabel("<html><font size=3 color=#800000>:"));
				mt[i]=new JTextField(2);
				mt[i].setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
				mt[i].setMaximumSize(mt[i].getPreferredSize());
				mt[i].addKeyListener(onlyNumber);
				p2.add(mt[i]);


				//group[k]=new ButtonGroup();
				//endstate[--k]=new JRadioButton("AM",true);
				//endstate[k].setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
				//endstate[k].setForeground(Color.blue);
				//p2.add(endstate[k]);
				//group[++k].add(endstate[--k]);
				//endstate[++k]=new JRadioButton("PM",false);
				//endstate[k].setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
				//endstate[k].setForeground(Color.blue);
				//p2.add(endstate[k]);
				//group[k].add(endstate[k]);
				cons.weightx=10;
				addt(p,cons,1,j,2,1);
				cons.weightx=10;
				j++;
				addt(p2,cons,1,j,2,1);
			}
			handler=new CourseSubjectHandler();
			cons.anchor=GridBagConstraints.WEST;
			sub=new JComboBox[60];
			cour=new JComboBox[60];
			int t=0;
			for(int i=0,j=2;i<10;i++,j=j+2)
			{
				cons.insets=new Insets(0,0,5,10);
				cons.anchor=GridBagConstraints.WEST;
				cons.fill=GridBagConstraints.NONE;
				cons.weightx=0;
				addt(new JLabel("<html><font size=4 Color=#000080>To"),cons,3,j,1,1);
				for(int k=4;k<=9;k++)
				{
					cons.anchor=GridBagConstraints.EAST;
					cons.fill=GridBagConstraints.HORIZONTAL;
					cons.insets=new Insets(0,10,5,5);
					sub[t]=new JComboBox();
					sub[t].setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
					sub[t].setMaximumRowCount(5);
					sub[t].setEnabled(false);
					cour[t]=new JComboBox();
					cour[t].setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
					cour[t].setMaximumRowCount(5);
					cour[t].setActionCommand(""+t);
					cons.weightx=10;
					addt(sub[t],cons,k,j,1,1);
					addt(cour[t],cons,k,j+1,1,1);
					t++;
				}
			}
			for(int i=0;i<cour.length;i++)
			{
				cour[i].addItem("--OFF--");
				cour[i].setMaximumSize(cour[i].getMinimumSize());
			}
			try
			{
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				Connection cn=DriverManager.getConnection("jdbc:odbc:Student_Info","raj","17java71");

				Statement ste=cn.createStatement();
				ResultSet set=ste.executeQuery("select * from course_name");
				while(set.next())
				{
					String crs=set.getString(2).trim();
					for(int i=0;i<cour.length;i++)
					{
						cour[i].addItem(crs);
					}
				}
			}
			catch(Exception ex)
			{
			}
			for(int i=0;i<cour.length;i++)
			{
				cour[i].addActionListener(handler);
			}
			facul.addActionListener(new SelectFaculty());
			lsave.addActionListener(new SaveTimeTable());
			lcancle.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					tm.dispose();
				}
			});
			displayTimeTable();
		}
		void displayTimeTable()
		{
			try
			{
				String fact=(String)facul.getSelectedItem();
				String faclt=fact.substring(0,14).trim();
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				Connection cn=DriverManager.getConnection("jdbc:odbc:Student_Info","raj","17java71");
				Statement ste=cn.createStatement();
				st=conn.createStatement();
				ResultSet set=st.executeQuery("select * from "+faclt+"_time_table ");
				int i=0;
				int j=0;
				while(set.next())
				{

					Time stime=set.getTime(2);
					Time etime=set.getTime(3);

					String msub=set.getString(4).trim();
					if(msub!=null)
						msub=msub.trim();
					String mcr=set.getString(5).trim();
					String tsub=set.getString(6).trim();
					if(tsub!=null)
						tsub=tsub.trim();
					String tcr=set.getString(7).trim();
					String wsub=set.getString(8).trim();
					if(wsub!=null)
						wsub=wsub.trim();
					String wcr=set.getString(9).trim();
					String thsub=set.getString(10).trim();
					if(thsub!=null)
						thsub=thsub.trim();
					String thcr=set.getString(11).trim();
					String fsub=set.getString(12).trim();
					if(fsub!=null)
						fsub=fsub.trim();
					String fcr=set.getString(13).trim();
					String ssub=set.getString(14).trim();
					if(ssub!=null)
						ssub=ssub.trim();
					String scr=set.getString(15).trim();

					String sti=stime.toString();
					String sthr=sti.substring(0,2);
					String stmi=sti.substring(3,5);
					int starth=Integer.parseInt(sthr);
					int hour=0;

				//	if(starth>12)
				//	{
						hour=starth;
						sthr=String.valueOf(hour);

					//}
				//	if(starth >=12)
				//	{
					//	ststate[m].setSelected(false);
					//	ststate[++m].setSelected(true);
				//	}
				//	else
				//	{
					//	ststate[m].setSelected(true);
					//	ststate[++m].setSelected(false);
				//	}

					hr[i].setText(sthr);
					mt[i].setText(stmi);
					String eti=etime.toString();
					String enhr=eti.substring(0,2);
					String enmi=eti.substring(3,5);
					int endh=Integer.parseInt(enhr);
					hour=0;
					//if(endh>12)
					//{
						hour=endh;
						enhr=String.valueOf(hour);
					//}
					//if(endh >=12)
					//{
					//	endstate[m].setSelected(false);
					//	endstate[++m].setSelected(true);
					//}
					//else
					//{
					//	endstate[m].setSelected(true);
					//	endstate[++m].setSelected(false);
					//}
					hr[++i].setText(enhr);
					mt[i].setText(enmi);

					if(!mcr.equals("--OFF--"))
					{
						sub[j].removeAllItems();
						sub[j].setEnabled(true);
						ResultSet sets=ste.executeQuery("select * from "+mcr+"_sub ");
						while(sets.next())
						{
							String sbl=sets.getString(2).trim();
							sub[j].addItem(sbl);
						}
						cour[j].setSelectedItem(mcr);
						sub[j].setSelectedItem(msub);
					}
					else
					{
						cour[j].setSelectedItem(mcr);
						sub[j].removeAllItems();
					}
					if(!tcr.equals("--OFF--"))
					{
						sub[++j].removeAllItems();
						sub[j].setEnabled(true);
						ResultSet sets=ste.executeQuery("select * from "+tcr+"_sub ");
						while(sets.next())
						{
							String sbl=sets.getString(2).trim();
							sub[j].addItem(sbl);
						}
						cour[j].setSelectedItem(tcr);
						sub[j].setSelectedItem(tsub);
					}
					else
					{

						cour[j].setSelectedItem(tcr);
						sub[++j].removeAllItems();
					}
					if(!wcr.equals("--OFF--"))
					{
						sub[++j].removeAllItems();
						sub[j].setEnabled(true);
						ResultSet sets=ste.executeQuery("select * from "+wcr+"_sub ");
						while(sets.next())
						{
							String sbl=sets.getString(2).trim();
							sub[j].addItem(sbl);
						}
						cour[j].setSelectedItem(wcr);
						sub[j].setSelectedItem(wsub);

					}
					else
					{
						cour[j].setSelectedItem(wcr);
						sub[++j].removeAllItems();
					}

					if(!thcr.equals("--OFF--"))
					{
						sub[++j].removeAllItems();
						sub[j].setEnabled(true);
						ResultSet sets=ste.executeQuery("select * from "+thcr+"_sub ");
						while(sets.next())
						{
							String sbl=sets.getString(2).trim();
							sub[j].addItem(sbl);
						}
						cour[j].setSelectedItem(thcr);
						sub[j].setSelectedItem(thsub);

					}
					else
					{
						cour[j].setSelectedItem(thcr);
						sub[++j].removeAllItems();
					}

					if(!fcr.equals("--OFF--"))
					{
						sub[++j].removeAllItems();
						sub[j].setEnabled(true);
						ResultSet sets=ste.executeQuery("select * from "+fcr+"_sub ");
						while(sets.next())
						{
							String sbl=sets.getString(2).trim();
							sub[j].addItem(sbl);
						}
						cour[j].setSelectedItem(fcr);
						sub[j].setSelectedItem(fsub);

					}
					else
					{
						cour[j].setSelectedItem(fcr);
						sub[++j].removeAllItems();

					}

					if(!scr.equals("--OFF--"))
					{
						sub[++j].removeAllItems();
						sub[j].setEnabled(true);
						ResultSet sets=ste.executeQuery("select * from "+scr+"_sub ");
						while(sets.next())
						{
							String sbl=sets.getString(2).trim();
							sub[j].addItem(sbl);
						}
						cour[j].setSelectedItem(scr);
						sub[j].setSelectedItem(ssub);

					}
					else
					{
						cour[j].setSelectedItem(scr);
						sub[++j].removeAllItems();

					}

					i++;
					j++;
				}
			}
			catch(Exception ex)
			{
				System.out.println(ex);
			}
		}
		public void addt(Component comp,GridBagConstraints cons,int x,int y,int w,int h)
		{
			cons.gridx=x;
			cons.gridy=y;
			cons.gridwidth=w;
			cons.gridheight=h;
			comp.setPreferredSize(comp.getPreferredSize());
			tpan.add(comp,cons);
			cont.add(tsc);
		}
		class CourseSubjectHandler implements ActionListener
		{
			public void actionPerformed(ActionEvent e)
			{
				String ind=(String)e.getActionCommand();
				int index=Integer.parseInt(ind);
				String cr=(String)cour[index].getSelectedItem();

				try
				{
					Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
					Connection cn=DriverManager.getConnection("jdbc:odbc:Student_Info","raj","17java71");

					Statement ste=cn.createStatement();
					sub[index].removeAllItems();
					if(!cr.equals("--OFF--"))
					{
						sub[index].setEnabled(true);
						ResultSet set=ste.executeQuery("select * from "+cr+"_sub ");
						while(set.next())
						{
							String sbl=set.getString(2).trim();
							sub[index].addItem(sbl);
						}
					}
					else
					{
						sub[index].setEnabled(false);
					}
				}
				catch(Exception ex)
				{

				}
			}
		}
		class SelectFaculty implements ActionListener
		{
			public void actionPerformed(ActionEvent ae)
			{
				displayTimeTable();

			}
		}
		class SaveTimeTable implements ActionListener
		{
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					String fact=(String)facul.getSelectedItem();
					String faclt=fact.substring(0,14).trim();
					boolean flag=true;
					for(int i=0,j=0;i<20;i++,j++)
					{

						int h1=Integer.parseInt(hr[i].getText());
					//	boolean start=ststate[j].isSelected();
					//	boolean start2=ststate[++j].isSelected();
						if(h1>24 || h1<0)
						{
							hr[i].setBackground(Color.red);
							flag=false;
						}
						else
						{
							hr[i].setBackground(Color.white);
						}
						int m1=Integer.parseInt(mt[i].getText());
						if(m1>59 || m1<0)
						{
							mt[i].setBackground(Color.red);
							flag=false;
						}
						else
						{
							mt[i].setBackground(Color.white);
						}
						int h2=Integer.parseInt(hr[++i].getText());
						//boolean end=endstate[--j].isSelected();
						//boolean end2=endstate[++j].isSelected();
						if(h2 > 24 || h2 < 0)
						{
							hr[i].setBackground(Color.red);
							flag=false;
						}
						else
						{
							hr[i].setBackground(Color.white);
						}
						int m2=Integer.parseInt(mt[i].getText());
						if(m2>59 || m2<0)
						{
							mt[i].setBackground(Color.red);
							flag=false;
						}
						else
						{
							mt[i].setBackground(Color.white);
						}

						if((h1 > h2) && (m1 > m2))
						{
							hr[i].setBackground(Color.red);
							mt[i].setBackground(Color.red);
							flag=false;

						}
						if((h1==h2) && (m1 > m2))
						{
							hr[i].setBackground(Color.red);
							mt[i].setBackground(Color.red);
							flag=false;
						}

					}
					if(flag==true)
					{
						int k=0;
						for(int i=0,j=0,c=0;i<20;i++,j++,k++,c++)
						{
							Connection cn=DriverManager.getConnection("jdbc:odbc:Teacher_Info","raj","17java71");
							PreparedStatement ps=cn.prepareStatement("update "+faclt+"_time_table set StartTime=?,EndTime=?,Monday=?,MCourse=?,Tuesday=?,TuCourse=?,Wednesday=?,WCourse=?,Thusday=?,ThCourse=?,Friday=?,FCourse=?,Satureday=?,SCourse=? where LectureNo =?" );
							int h1=Integer.parseInt(hr[i].getText());
							int m1=Integer.parseInt(mt[i].getText());
							//boolean start=ststate[j].isSelected();
							//boolean start2=ststate[++j].isSelected();
							int h2=Integer.parseInt(hr[++i].getText());
							int m2=Integer.parseInt(mt[i].getText());
							//boolean end=endstate[--j].isSelected();
							//boolean end2=endstate[++j].isSelected();
							Time t1=new Time(0);
							Time t2=new Time(0);

							t1=new Time((h1*3600000)+(m1*60000)-19800000);
							t2=new Time((h2*3600000)+(m2*60000)-19800000);

							String croff;
							ps.setTime(1,t1);
							ps.setTime(2,t2);

							croff=(String)cour[c].getSelectedItem();
							if(!croff.equals("--OFF--"))
								ps.setString(3,(String)sub[c].getSelectedItem());
							else
								ps.setString(3," ");
							ps.setString(4,(String)cour[c].getSelectedItem());

							croff=(String)cour[++c].getSelectedItem();
							if(!croff.equals("--OFF--"))
								ps.setString(5,(String)sub[c].getSelectedItem());
							else
								ps.setString(5," ");
							ps.setString(6,(String)cour[c].getSelectedItem());

							croff=(String)cour[++c].getSelectedItem();
							if(!croff.equals("--OFF--"))
								ps.setString(7,(String)sub[c].getSelectedItem());
							else
								ps.setString(7," ");
							ps.setString(8,(String)cour[c].getSelectedItem());

							croff=(String)cour[++c].getSelectedItem();
							if(!croff.equals("--OFF--"))
								ps.setString(9,(String)sub[c].getSelectedItem());
							else
								ps.setString(9," ");
							ps.setString(10,(String)cour[c].getSelectedItem());

							croff=(String)cour[++c].getSelectedItem();
							if(!croff.equals("--OFF--"))
								ps.setString(11,(String)sub[c].getSelectedItem());
							else
								ps.setString(11," ");
							ps.setString(12,(String)cour[c].getSelectedItem());

							croff=(String)cour[++c].getSelectedItem();
							if(!croff.equals("--OFF--"))
								ps.setString(13,(String)sub[c].getSelectedItem());
							else
								ps.setString(13," ");
							ps.setString(14,(String)cour[c].getSelectedItem());

							ps.setInt(15,k+1);
							ps.execute();
						}
					}
					else
					{
						Icon error=new ImageIcon("error.png");
						JOptionPane.showMessageDialog(LectureTimeTable.this,"<html><font size=4 color=red>Lecture Time Is Not Valid </font></html> \n\t\t Please Enter Valid Time  \n\t Check Red Color Text Field  ","Lecture Time Table ",JOptionPane.ERROR_MESSAGE,error);

					}

				}
				catch(Exception ex)
				{
					System.out.println(ex);
					Icon error=new ImageIcon("error.png");
					JOptionPane.showMessageDialog(LectureTimeTable.this,"<html><font size=4 color=red>Lecture Time Is Not Valid </font></html> \n\t\t Please Enter Valid Time  \n\t Check Red Color Text Field  ","Lecture Time Table ",JOptionPane.ERROR_MESSAGE,error);

				}
			}
		}

	}
	class DateHandlerF implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			String mon=(String)joindatemon.getSelectedItem();
			int x=joindateyear.getSelectedIndex();
			int year=1950;
			year=year+x;
			if(mon.equals("Apr ")||mon.equals("June")||mon.equals("Sept")||mon.equals("Nov "))
			{
				joindateday.removeItem("31");
				therty=true;
				if (twentynine == true)
				{
					joindateday.addItem("30");
					twentynine = false;
					twentyeight = false;
				}
				if (twentyeight == true)
				{
					joindateday.addItem("29");
					joindateday.addItem("30");
					twentyeight = false;
					twentynine = false;
				}
			}
			else
			if(mon.equals("Feb ")&&year%4==0)
			{
				joindateday.removeItem("31");
				joindateday.removeItem("30");
				twentynine=true;
				therty = false;
				if (twentyeight == true)
				{
					joindateday.addItem("29");
					twentyeight = false;
					therty = false;
				}

			}
			else
			if(mon.equals("Feb "))
			{
				twentyeight=true;
				twentynine = false;
				therty = false;
				joindateday.removeItem("31");
				joindateday.removeItem("30");
				joindateday.removeItem("29");
			}
			else
			if(mon.equals("Jan ")||mon.equals("Mar ")||mon.equals("May ")||mon.equals("July")||mon.equals("Aug ")||mon.equals("Oct ")||mon.equals("Desc"))
			{
				if(therty==true)
				{
					joindateday.addItem("31");
					therty=false;
					twentynine = false;
					twentyeight = false;
				}
				else
				if(twentynine==true)
				{
					joindateday.addItem("30");
					joindateday.addItem("31");
					twentynine=false;
					therty = false;
					twentyeight = false;
				}
				else
				if(twentyeight==true)
				{
					joindateday.addItem("29");
					joindateday.addItem("30");
					joindateday.addItem("31");
					twentyeight=false;
					twentynine = false;
					therty = false;
				}
			}
		}
	}
	class FacultyInfoHandler implements ActionListener
	{

		public void actionPerformed(ActionEvent e)
		{
			String s=e.getActionCommand();
			if(s.equals("New"))
			{
				try
				{
					DataInputStream sin=new DataInputStream(new FileInputStream("Faculty_id.dat"));
					fcode.setText(sin.readUTF());
				}
				catch(Exception ex)
				{
				}
				fname.setText("");
				fmname.setText("");
				flname.setText("");
				addfield.setText("");
				education.setText("");
				mobno.setText("");
				salary.setText("0");
				addsalary.setText("0");
				save.setEnabled(true);
			}
			else
			if(s.equals("Save"))
			{
				boolean ok=false;
				try
				{
					String code=fcode.getText();
					String name=fname.getText();
					String midname=fmname.getText();
					String lastname=flname.getText();
					String address=addfield.getText();
					String eucate=education.getText();
					int dy=Integer.parseInt((String)joindateday.getSelectedItem());
					String dys="";
					if(dy>=1 && dy<=9)
						dys="0"+dy;
					else
						dys=""+dy;
					String date=""+dys+"-"+(String)joindatemon.getSelectedItem()+"-"+(String)joindateyear.getSelectedItem();
					String mobile=mobno.getText();
					int totals=Integer.parseInt(salary.getText());
					int adds=Integer.parseInt(addsalary.getText());
					String salaryf=Integer.toString(totals);
					String addsalaryf=Integer.toString(adds);
					if(name.equals("") || midname.equals("") || lastname.equals("") || address.equals("") || eucate.equals("") || salaryf.equals("") || addsalaryf.equals(""))
					{
							Icon error=new ImageIcon("error.png");
							JOptionPane.showMessageDialog(StaffContact.this,"<html><font size=4 color=red>Field Can Not Be Blank </font></html> \n\t\t Please enter All Information","Staff Information",JOptionPane.ERROR_MESSAGE,error);

					}
					else
					{
						String mobTest=mobno.getText();
						boolean valid=false;
						if((mobTest.length() == 10)||(mobTest.length() == 11))
						{
							valid=true;
							if(mobTest.length() == 11)
							{
								char ch=mobTest.charAt(0);
								if(ch != '0')
								{
									valid=false;
									Icon error=new ImageIcon("error.png");
									JOptionPane.showMessageDialog(StaffContact.this,"<html><font size=4 color=red>Mobile Number Not Be Valid </font></html> \n\t\t Please Enter Valid Mobile Number","Staff Information",JOptionPane.ERROR_MESSAGE,error);
								}
							}
						}
						else
						{
							valid=false;
							Icon error=new ImageIcon("error.png");
							JOptionPane.showMessageDialog(StaffContact.this,"<html><font size=4 color=red>Mobile Number Not Be Valid </font></html> \n\t\t Please Enter Valid Mobile Number","Staff Information",JOptionPane.ERROR_MESSAGE,error);
						}

						if(valid == true)
						{
							PreparedStatement ps=conn.prepareStatement("insert into FacultyInfo values(?,?,?,?,?,?,?,?,?,?,?)");
							ps.setString(1,code);
							ps.setString(2,name);
							ps.setString(3,midname);
							ps.setString(4,lastname);
							ps.setString(5,address);
							ps.setString(6,eucate);
							ps.setString(7,date);
							ps.setString(8,mobile);
							ps.setInt(9,totals);
							ps.setInt(10,adds);
							ps.setString(11,"false");
							ps.execute();
							ps.close();
							fname.setText("");
							fmname.setText("");
							flname.setText("");
							addfield.setText("");
							education.setText("");
							mobno.setText("");
							salary.setText("0");
							addsalary.setText("0");
							ps.close();
							DataInputStream dt=new DataInputStream(new FileInputStream("Faculty_id.dat"));
							String temp2=dt.readUTF();
							st.executeUpdate("create table "+temp2+"_time_table(LectureNo INTEGER,StartTime Time,EndTime Time,Monday CHAR(30),MCourse CHAR(30),Tuesday CHAR(30),TuCourse CHAR(30),Wednesday CHAR(30),WCourse CHAR(30),Thusday CHAR(30),ThCourse CHAR(30),Friday CHAR(30),FCourse CHAR(30),Satureday CHAR(30),SCourse CHAR(30))");
							PreparedStatement psp=conn.prepareStatement("insert into "+temp2+"_time_table values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
							for(int i=1;i<=10;i++)
							{
								psp.setInt(1,i);
								psp.setTime(2,new Time(-18000000-1800000));
								psp.setTime(3,new Time(-18000000-1800000));
								psp.setString(4,"");
								psp.setString(5,"--OFF--");
								psp.setString(6,"");
								psp.setString(7,"--OFF--");
								psp.setString(8,"");
								psp.setString(9,"--OFF--");
								psp.setString(10,"");
								psp.setString(11,"--OFF--");
								psp.setString(12,"");
								psp.setString(13,"--OFF--");
								psp.setString(14,"");
								psp.setString(15,"--OFF--");
								psp.execute();
							}
							String temp=temp2.substring(7);
							int x=Integer.parseInt(temp);
							if(x<9)
							{
								x++;
								temp2="Faculty000"+x;
							}
							else
							if(x<99)
							{
								x++;
								temp2="Faculty00"+x;
							}
							else
							if(x<999)
							{
								x++;
								temp2="Faculty0"+x;
							}
							else
							{
								x++;
								temp2="Faculty"+x;
							}

							DataOutputStream out=new DataOutputStream(new FileOutputStream("Faculty_id.dat"));
							out.writeUTF(temp2);
							dt.close();
							out.close();
							DataInputStream sin=new DataInputStream(new FileInputStream("Faculty_id.dat"));
							fcode.setText(sin.readUTF());
							ResultSet tableset=st.executeQuery("Select * from FacultyInfo ");
							int row=0;
							int i=0;
							while(tableset.next())
							{
								row++;
							}
							DefaultTableModel model=new DefaultTableModel(new String[]{"Faculty Code","Name","Last Name","Mobile No"},row);
							tableset=st.executeQuery("Select * from FacultyInfo ");
							while(tableset.next())
							{
								model.setValueAt(tableset.getString(1).trim(),i,0);
								model.setValueAt(tableset.getString(2).trim(),i,1);
								model.setValueAt(tableset.getString(4).trim(),i,2);
								model.setValueAt(tableset.getString(8).trim(),i,3);
								i++;
							}
							table.setModel(model);

						}
					}


				}
				catch(Exception e1)
				{
					Icon error=new ImageIcon("error.png");
					JOptionPane.showMessageDialog(StaffContact.this,"<html><font size=3 color=red> Please Fill All Information <br> Field can not be blank </font></html>  ","Student Information",JOptionPane.ERROR_MESSAGE,error);
				}
			}
			else
			if(s.equals("Modify"))
			{
				ModifyFacultyInfo info=new ModifyFacultyInfo();
				info.setVisible(true);

			}
			else
			if(s.equals("Remove"))
			{
				RemoveFacultyInfo info=new RemoveFacultyInfo();
				info.setVisible(true);
			}
			else
			{
				dispose();
				new MainMenuFrame().setVisible(true);
			}
		}
	}
	class ModifyFacultyInfo extends JFrame
	{
		Container mic=getContentPane();
		JTable fact;
		DefaultTableModel model;
		ModifyFaculty mdl;
		String fccode;
		ModifyFacultyInfo()
		{
			setSize(420,370);
			setTitle("Faculty Information");
			setLocation(330,170);
			addWindowListener(new WindowAdapter()
			{
				public void windowClosing(WindowEvent e)
				{
					dispose();
				}
			});
			ModifyFacultyInfo.setDefaultLookAndFeelDecorated(true);
			setResizable(false);
			setIconImage(Toolkit.getDefaultToolkit().getImage("mainicon.png"));
			JTextField tf=new JTextField("Select Faculty To Modify ",SwingConstants.CENTER);
			tf.setBorder(BorderFactory.createBevelBorder(1,new Color(100,100,155),new Color(100,100,155)));
			tf.setHorizontalAlignment(JTextField.CENTER);
			tf.setEditable(false);
			tf.setBackground(new Color(192,192,255));
			tf.setFont(new Font("verdana",Font.BOLD,20));
			tf.setForeground(new Color(255,255,255));
			mic.add(tf,"North");
			try
			{
				conn=DriverManager.getConnection("jdbc:odbc:Teacher_Info","raj","17java71");
				st=conn.createStatement();
				ResultSet tableset=st.executeQuery("Select * from FacultyInfo ");
				int row=0;
				int i=0;
				while(tableset.next())
				{
					row++;
				}
				model=new DefaultTableModel(new String[]{"Faculty Code","Name","Mobile No"},row);
				tableset=st.executeQuery("Select * from FacultyInfo ");
				while(tableset.next())
				{
					model.setValueAt(tableset.getString(1).trim(),i,0);
					String ft=tableset.getString(2).trim();
					ft=ft+" "+tableset.getString(4).trim();
					model.setValueAt(ft,i,1);
					model.setValueAt(tableset.getString(8).trim(),i,2);
					i++;
				}
				fact=new JTable(model);
				fact.addMouseListener(new ModifyFacultyList());
				fact.setToolTipText("Select The Faculty For Modify");
				fact.doLayout();
				fact.setColumnSelectionAllowed(false);
				fact.setSelectionMode(1);
				fact.setEditingColumn(3);
				fact.setGridColor(Color.pink);
				fact.setRowMargin(3);
				fact.setSelectionBackground(Color.gray);
				fact.setSelectionForeground(Color.red);
				fact.setShowHorizontalLines(false);
				fact.setShowVerticalLines(false);
				fact.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
				JScrollPane spl=new JScrollPane(fact);
				mic.add(spl);
			}
			catch(Exception es)
			{
			}
			addWindowListener(new WindowAdapter()
			{
				public void windowActivated(WindowEvent we)
				{
					try
					{
						ResultSet tableset=st.executeQuery("Select * from FacultyInfo");
						int row=0;
						int i=0;
						while(tableset.next())
						{
							row++;
						}
						DefaultTableModel md=new DefaultTableModel(new String[]{"Faculty Code","Name","Mobile No"},row);
						tableset=st.executeQuery("Select * from FacultyInfo");
						while(tableset.next())
						{
							md.setValueAt(tableset.getString(1).trim(),i,0);
							String ft=tableset.getString(2).trim();
							ft=ft+" "+tableset.getString(4).trim();
							md.setValueAt(ft,i,1);
							md.setValueAt(tableset.getString(8).trim(),i,2);
							i++;
						}
						fact.setModel(md);
					}
					catch(Exception es)
					{
					}
				}
			});
		}

		class ModifyFacultyList extends MouseAdapter
		{
			public void mouseClicked(MouseEvent e)
			{
				int ro=fact.getSelectedRow();
				fccode=(String)fact.getValueAt(ro,0);
				mdl=new ModifyFaculty(fccode);
				mdl.setVisible(true);
			}
		}
		class ModifyFaculty extends JDialog
		{
			JButton mok;
			JButton mcan;
			JPanel mpan;
			String mfact;
			Container cont;
			JTextField fco;
			JTextField fclname;
			JTextField fmidname;
			JTextField flastname;
			JTextArea addre;
			JTextArea educt;
			JTextField datetf;
			JTextField mnum;
			JTextField tsal;
			JTextField addtsal;
			ModifyFaculty(String s)
			{
				super(ModifyFacultyInfo.this,"Modify Student",true);
				mfact=s;
				setSize(420,400);
				setLocation(355,260);
				cont=getContentPane();
				JPanel bp=new JPanel();
				bp.setBackground(new Color(255,197,68));
				mok=new JButton("  Save  ");
				mcan=new JButton("Cancle");
				bp.add(mok);
				bp.add(mcan);
				cont.add(bp,"South");
				ModifyFact ms=new ModifyFact();
				mok.addActionListener(ms);
				mcan.addActionListener(ms);
				mpan=new JPanel();
				mpan.setLayout(new GridBagLayout());
				fco=new JTextField(10);
				fco.setToolTipText("Faculty Code");
				fco.setEditable(false);
				fco.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
				fclname=new JTextField(20);
				fclname.addKeyListener(onlyText);
				fclname.setToolTipText("Enter Faculty Name");
				fclname.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
				fmidname=new JTextField(20);
				fmidname.addKeyListener(onlyText);
				fmidname.setToolTipText("Enter Faculty's Middle Name");
				fmidname.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
				flastname=new JTextField(20);
				flastname.addKeyListener(onlyText);
				flastname.setToolTipText("Enter Faculty's Last Name");
				flastname.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
				addre=new JTextArea(2,20);
				addre.setToolTipText("Enter Faculty's Address");
				addre.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
				addre.setWrapStyleWord(true);
				addre.setLineWrap(true);
				JScrollPane addfd=new JScrollPane(addre);
				educt=new JTextArea(2,20);
				educt.setToolTipText("Enter Faculty's Education");
				educt.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
				educt.setWrapStyleWord(true);
				educt.setLineWrap(true);
				JScrollPane edc=new JScrollPane(educt);
				datetf=new JTextField(10);
				datetf.setToolTipText("Joining Date");
				datetf.setEditable(false);
				datetf.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
				mnum=new JTextField(14);
				mnum.addKeyListener(onlyNumber);
				mnum.setToolTipText("Enter Mobile Number ");
				mnum.setBorder(BorderFactory.createBevelBorder(1,new Color(100,100,155),new Color(100,100,155)));
				mnum.setSelectionColor(Color.blue);
				mnum.setDisabledTextColor(Color.red);
				mnum.setCaretColor(Color.green);
				mnum.setSelectionColor(Color.pink);
				mnum.setFont(new Font("verdana", Font.BOLD, 12));
				tsal=new JTextField(8);
				tsal.addKeyListener(onlyNumber);
				tsal.setToolTipText("Salary Of Faculty");
				tsal.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
				addtsal=new JTextField(8);
				addtsal.addKeyListener(onlyNumber);
				addtsal.setToolTipText("Additional Salary");
				addtsal.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
				GridBagConstraints cons=new GridBagConstraints();
				cons.fill=GridBagConstraints.NONE;
				cons.anchor=GridBagConstraints.EAST;
				cons.weightx=10;
				cons.weighty=10;
				cons.insets = new Insets(0, 10, 5, 0);
				mdadd(new JLabel("Faculty Code  : "),cons,0,0,1,1);
				mdadd(new JLabel("Faculty Name  : "),cons,0,1,1,1);
				mdadd(new JLabel("Middle name  : "),cons,0,2,1,1);
				mdadd(new JLabel("Last Name  : "),cons,0,3,1,1);
				mdadd(new JLabel("Address  : "),cons,0,4,1,2);
				mdadd(new JLabel("Education  :"),cons,0,6,1,2);
				mdadd(new JLabel("Date Of Joining  : "),cons,0,8,1,1);
				mdadd(new JLabel("Mobile Number  : "),cons,0,9,1,1);
				mdadd(new JLabel("Salary  : "),cons,0,10,1,1);
				mdadd(new JLabel("Additional salary  : "),cons,0,11,1,1);
				cons.fill=GridBagConstraints.HORIZONTAL;
				cons.weightx = 50;
				cons.insets = new Insets(0, 10, 5, 40);
				mdadd(fco, cons, 1, 0, 1, 1);
				cons.insets = new Insets(0, 10, 1, 40);
				mdadd(fclname,cons,1,1,1,1);
				mdadd(fmidname,cons,1,2,1,1);
				mdadd(flastname,cons,1,3,1,1);
				cons.insets = new Insets(0, 10, 1, 100);
				cons.ipady = 20;
				mdadd(addfd,cons,1,4,1,2);
				mdadd(edc,cons,1,6,1,2);
				cons.ipady=0;
				cons.insets = new Insets(0, 10, 1, 160);
				mdadd(datetf,cons,1,8,1,1);
				mdadd(mnum,cons,1,9,1,1);
				cons.ipady = 0;
				cons.insets=new Insets(0,10,1,40);
				mdadd(tsal,cons,1,10,1,1);
				mdadd(addtsal,cons,1,11,1,1);
				try
				{
					ResultSet minfo=st.executeQuery("select * from FacultyInfo ");
					String stco="";
					while(minfo.next())
					{
						stco=minfo.getString(1).trim();
						if(stco.equals(mfact))
						break;
					}
					fco.setText(stco);
					fclname.setText(minfo.getString(2));
					fmidname.setText(minfo.getString(3));
					flastname.setText(minfo.getString(4));
					addre.setText(minfo.getString(5));
					educt.setText(minfo.getString(6));
					datetf.setText(minfo.getString(7));
					mnum.setText(minfo.getString(8));
					tsal.setText(minfo.getString(9));
					addtsal.setText(minfo.getString(10));
				}
				catch(Exception ed)
				{
				}
			}
			public void mdadd(Component comp,GridBagConstraints cons,int x,int y,int w,int h)
			{
				cons.gridx=x;
				cons.gridy=y;
				cons.gridwidth=w;
				cons.gridheight=h;
				comp.setPreferredSize(comp.getPreferredSize());
				mpan.add(comp,cons);
				cont.add(mpan);
			}
			class ModifyFact implements ActionListener
			{
				public void actionPerformed(ActionEvent e)
				{
					String minfo=e.getActionCommand();
					if(minfo.equals("  Save  "))
					{
						boolean ok=false;
						try
						{
							String name=fclname.getText();
							String mdname=fmidname.getText();
							String ltname=flastname.getText();
							String address=addre.getText();
							String edct=educt.getText();
							String mobile=mnum.getText();
							int sal=Integer.parseInt(tsal.getText());
							int addsal=Integer.parseInt(addtsal.getText());
							String salf=Integer.toString(sal);
							String addsalf=Integer.toString(addsal);
							if(name.equals("") || mdname.equals("") || ltname.equals("") || edct.equals("")|| salf.equals("") || address.equals(""))
							{
								Icon error=new ImageIcon("error.png");
								JOptionPane.showMessageDialog(ModifyFaculty.this,"<html><font size=4 color=red>Field Can Not Be Blank </font></html> \n\t\t Please enter All Information","Staff Information",JOptionPane.ERROR_MESSAGE,error);
							}
							else
							{
								String mobTest=mnum.getText().trim();
								boolean valid=false;
								if((mobTest.length() == 10)||(mobTest.length() == 11))
								{
									valid=true;
									if(mobTest.length() == 11)
									{
										char ch=mobTest.charAt(0);
										if(ch != '0')
										{
											valid=false;
											Icon error=new ImageIcon("error.png");
											JOptionPane.showMessageDialog(ModifyFaculty.this,"<html><font size=4 color=red>Mobile Number Not Be Valid </font></html> \n\t\t Please Enter Valid Mobile Number","Staff Information",JOptionPane.ERROR_MESSAGE,error);
										}
									}
								}
								else
								{
									valid=false;
									Icon error=new ImageIcon("error.png");
									JOptionPane.showMessageDialog(ModifyFaculty.this,"<html><font size=4 color=red>Mobile Number Not Be Valid </font></html> \n\t\t Please Enter Valid Mobile Number","Staff Information",JOptionPane.ERROR_MESSAGE,error);
								}
								if(valid==true)
								{
									PreparedStatement pm=conn.prepareStatement("update FacultyInfo set fname=? ,fmname=? ,flname=? ,add=? ,educ=? ,mobno=? ,salary=? ,addsalary=? where fcode=?");
									pm.setString(1,name);
									pm.setString(2,mdname);
									pm.setString(3,ltname);
									pm.setString(4,address);
									pm.setString(5,edct);
									pm.setString(6,mobile);
									pm.setInt(7,sal);
									pm.setInt(8,addsal);
									pm.setString(9,mfact);
									pm.execute();
								}
								mdl.dispose();
							}
						}
						catch(Exception es)
						{
							Icon error=new ImageIcon("error.png");
							JOptionPane.showMessageDialog(ModifyFaculty.this,"<html><font size=4 color=red>Field Can Not Be Blank </font></html> \n\t\t Please enter All Information","Staff Information",JOptionPane.ERROR_MESSAGE,error);
						}
					}
					else
					{
						mdl.dispose();
					}
				}
			}
		}
	}
	class RemoveFacultyInfo extends JFrame
	{
		Container mic=getContentPane();
		DefaultTableModel model;
		RemoveFaculty dlg;
		JTable fact;
		String fccode;
		RemoveFacultyInfo()
		{
			setSize(420,370);
			setTitle("Faculty Information");
			setLocation(330,170);
			addWindowListener(new WindowAdapter()
			{
				public void windowClosing(WindowEvent e)
				{
					dispose();
				}
			});
			RemoveFacultyInfo.setDefaultLookAndFeelDecorated(true);
			setResizable(false);
			setIconImage(Toolkit.getDefaultToolkit().getImage("mainicon.png"));
			JTextField tf=new JTextField("Select Faculty To Remove ",SwingConstants.CENTER);
			tf.setBorder(BorderFactory.createBevelBorder(1,new Color(100,100,155),new Color(100,100,155)));
			tf.setHorizontalAlignment(JTextField.CENTER);
			tf.setEditable(false);
			tf.setBackground(new Color(192,192,255));
			tf.setFont(new Font("verdana",Font.BOLD,20));
			tf.setForeground(new Color(255,255,255));
			mic.add(tf,"North");
			try
			{
				conn=DriverManager.getConnection("jdbc:odbc:Teacher_Info","raj","17java71");
				st=conn.createStatement();
				ResultSet tableset=st.executeQuery("Select * from FacultyInfo ");
				int row=0;
				int i=0;
				while(tableset.next())
				{
					row++;
				}
				model=new DefaultTableModel(new String[]{"Faculty Code","Name","Mobile No"},row);
				tableset=st.executeQuery("Select * from FacultyInfo ");
				while(tableset.next())
				{
					model.setValueAt(tableset.getString(1).trim(),i,0);
					String ft=tableset.getString(2).trim();
					ft=ft+" "+tableset.getString(4).trim();
					model.setValueAt(ft,i,1);
					model.setValueAt(tableset.getString(8).trim(),i,2);
					i++;
				}
				fact=new JTable(model);
				fact.addMouseListener(new RemoveFacultyList());
				fact.setToolTipText("Select The Faculty For Modify");
				fact.doLayout();
				fact.setColumnSelectionAllowed(false);
				fact.setSelectionMode(1);
				fact.setEditingColumn(3);
				fact.setGridColor(Color.pink);
				fact.setRowMargin(3);
				fact.setSelectionBackground(Color.gray);
				fact.setSelectionForeground(Color.red);
				fact.setShowHorizontalLines(false);
				fact.setShowVerticalLines(false);
				fact.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
				JScrollPane spl=new JScrollPane(fact);
				mic.add(spl);
			}
			catch(Exception es)
			{
			}
			addWindowListener(new WindowAdapter()
			{
				public void windowActivated(WindowEvent we)
				{
					try
					{
						ResultSet tableset=st.executeQuery("Select * from FacultyInfo");
						int row=0;
						int i=0;
						while(tableset.next())
						{
							row++;
						}
						DefaultTableModel md=new DefaultTableModel(new String[]{"Faculty Code","Name","Mobile No"},row);
						tableset=st.executeQuery("Select * from FacultyInfo");
						while(tableset.next())
						{
							md.setValueAt(tableset.getString(1).trim(),i,0);
							String ft=tableset.getString(2).trim();
							ft=ft+" "+tableset.getString(4).trim();
							md.setValueAt(ft,i,1);
							md.setValueAt(tableset.getString(8).trim(),i,2);
							i++;
						}
						fact.setModel(md);
					}
					catch(Exception es)
					{
					}
				}
			});
		}
		class RemoveFacultyList extends MouseAdapter
		{
			public void mouseClicked(MouseEvent e)
			{
				int ro=fact.getSelectedRow();
				fccode=(String)fact.getValueAt(ro,0);
				dlg=new RemoveFaculty(fccode);
				dlg.setVisible(true);
			}
		}
		class RemoveFaculty extends JDialog
		{
			JButton rok;
			JButton rcan;
			String rmstud;
			RemoveFaculty(String s)
			{
				super(RemoveFacultyInfo.this,"Remove Faculty",true);
				rmstud=s;
				setSize(250,150);
				setLocation(400,280);
				JPanel bp=new JPanel();
				bp.setBackground(new Color(255,197,68));
				rok=new JButton("  Ok  ");
				rcan=new JButton("Cancle");
				bp.add(rok);
				bp.add(rcan);
				add(bp,"South");
				JPanel lp=new JPanel();
				lp.add(new JLabel("<html><font size=4 color=#800080>Do You Want To Ramove <br>    Faculty Information </font></html>"));
				add(lp);
				RemoveFact rs=new RemoveFact();
				rok.addActionListener(rs);
				rcan.addActionListener(rs);
			}
			class RemoveFact implements ActionListener
			{
				public void actionPerformed(ActionEvent ev)
				{
					String cm=ev.getActionCommand();
					if(cm.equals("  Ok  "))
					{
						try
						{
							PreparedStatement pts=conn.prepareStatement("delete from FacultyInfo where fcode=?");
							pts.setString(1,rmstud);
							pts.execute();
						}
						catch(Exception e)
						{
						}
						dlg.dispose();
					}
					else
					{
						dlg.dispose();
					}
				}
			}

		}

	}
}
