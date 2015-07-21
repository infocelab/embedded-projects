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
class GestContact extends JFrame
{
	JPanel main;
	Container c=getContentPane();
	private JTextField  gcode;
	private JTextField gname;
	private JTextArea addfield1;
	private JTextArea Activity;
	private JTextArea ExtraSkill;
	private JTextArea Education;
	JComboBox joindateday;
	JComboBox joindatemon;
	JComboBox joindateyear;
	private JTextField mobno;
	private JButton New;
	private JButton save;
	private JButton modify;
	private JButton remove;
	private JButton exit;
	private JTable table;
	boolean therty=false;
	boolean twentynine=false;
	boolean twentyeight=false;
	TextValid onlyText;
	NumberValid onlyNumber;
	Connection conn;
	Statement st;
	JTable gest;
	DefaultTableModel model;
	int width;
	int height;
	Dimension screenSize;
	Container mic;
	GestContact()
	{
		Toolkit kits=Toolkit.getDefaultToolkit();
		screenSize=kits.getScreenSize();
		width=screenSize.width/2-50;
		height=screenSize.height/2;
		setSize(width+180,height+260);
		setLocation(screenSize.width/6,20);setTitle("Guest Information");
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				dispose();
				new MainMenuFrame().setVisible(true);
			}
		});
		GestContact.setDefaultLookAndFeelDecorated(true);
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("mainicon.png"));

		c=getContentPane();
		JLabel l=new JLabel("<html><font size=6 color=#800080><i>Gest Information");
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
				g.drawImage(img,0,0,width+180,100,null);
			}
		};
		/*JPanel im=new JPanel()
		{

			public void paintComponent(Graphics g)
			{
				Toolkit kit=Toolkit.getDefaultToolkit();
				Image img=kit.getImage("wl.GIF");
				MediaTracker t=new MediaTracker(this);
				t.addImage(img,3);
				while(true)
				{
					try
					{
						t.waitForID(3);
							break;
					}
					catch(Exception e)
					{
					}
				}
				img.setAccelerationPriority(1);
				int i=1;
				while(i<5)
				{
					g.drawImage(img,0,35,240,440,null);
					try
					{
						Thread.sleep(100);
					}
					catch(Exception es)
					{
					}
					i++;
				}
			}
		};*/
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
		main.setBackground(new Color(245,240,255));

		onlyText=new TextValid();
		onlyNumber=new NumberValid();

		gcode=new JTextField(10);
		gcode.setToolTipText("Gest Code");
		gcode.setEditable(false);
		gcode.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
		gname=new JTextField(20);
		gname.setToolTipText("Enter Gest Full Name");
		gname.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
		addfield1=new JTextArea(2,20);
		addfield1.setToolTipText("Enter Gest's Address");
		addfield1.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
		addfield1.setWrapStyleWord(true);
		addfield1.setLineWrap(true);
		JScrollPane addfield=new JScrollPane(addfield1);
		Activity=new JTextArea(2,20);
		Activity.setToolTipText("Enter Gest's Activite In Socail Work Or Any Place");
		Activity.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
		Activity.setWrapStyleWord(true);
		Activity.setLineWrap(true);
		JScrollPane activity=new JScrollPane(Activity);
		ExtraSkill=new JTextArea(2,20);
		ExtraSkill.setToolTipText("Enter Gest's Extra Skill");
		ExtraSkill.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
		ExtraSkill.setWrapStyleWord(true);
		ExtraSkill.setLineWrap(true);
		JScrollPane extraskill=new JScrollPane(ExtraSkill);
		Education=new JTextArea(2,20);
		Education.setToolTipText("Enter Gest's Education");
		Education.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
		Education.setWrapStyleWord(true);
		Education.setLineWrap(true);
		JScrollPane education=new JScrollPane(Education);
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

		New=new JButton("New");
		New.setToolTipText("Add New Entry");
		save=new JButton("Save");
		save.setToolTipText("Save The Entry of Gest");
		modify=new JButton("Modify");
		modify.setToolTipText("Modify the Entry");
		remove=new JButton("Remove");
		remove.setToolTipText("Remove The Gest Entry");
		exit=new JButton("Exit");
		exit.setToolTipText("Close Gest Contact Form");
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			conn=DriverManager.getConnection("jdbc:odbc:Gest_Info","raj","17java71");
			st=conn.createStatement();
			ResultSet tableset=st.executeQuery("Select * from GestInfo ");
			int row=0;
			int i=0;
			while(tableset.next())
			{
				row++;
			}
			DefaultTableModel model=new DefaultTableModel(new String[]{"Gest ID","Name","Mobile No"},row);
			tableset=st.executeQuery("Select * from GestInfo ");
			while(tableset.next())
			{
				model.setValueAt(tableset.getString(1).trim(),i,0);
				model.setValueAt(tableset.getString(2).trim(),i,1);
				model.setValueAt(tableset.getString(8).trim(),i,2);
				i++;
			}
			table=new JTable(model);

		}
		catch(Exception e)
		{
		}
		table.addMouseListener(new GestTableHandler());
		table.setToolTipText("Select The Gest For More Information");
		JScrollPane table1=new JScrollPane(table);
		table.doLayout();
		table.setColumnSelectionAllowed(false);
		table.setSelectionMode(1);
		table.setEditingColumn(3);
		table.setGridColor(Color.pink);
		table.setRowMargin(3);
		table.setSelectionBackground(new Color(194,253,254));
		table.setSelectionForeground(new Color(128,64,0));
		table.setShowHorizontalLines(false);
		table.setShowVerticalLines(false);



		GridBagConstraints cons=new GridBagConstraints();
		cons.fill=GridBagConstraints.NONE;
		cons.anchor=GridBagConstraints.EAST;
		cons.weightx=10;
		cons.weighty=10;

		cons.insets = new Insets(20, 10, 5, 0);
		add(new JLabel("Gest Code  : "),cons,0,0,1,1);
		cons.insets = new Insets(0, 10, 5, 0);
		add(new JLabel("Gest Full Name  : "),cons,0,1,1,1);
		add(new JLabel("Address  : "),cons,0,2,1,2);
		add(new JLabel("Activity : "),cons,0,4,1,2);
		add(new JLabel("Extra Skill : "),cons,0,6,1,2);
		add(new JLabel("Education : "),cons,0,8,1,2);
		add(new JLabel("Date Of Entry  : "),cons,0,10,1,1);
		add(new JLabel("Mobile Number  : "),cons,0,12,1,1);
		cons.fill=GridBagConstraints.HORIZONTAL;
		cons.weightx = 0;
		cons.insets = new Insets(20, 10, 5, 60);
		add(gcode, cons, 1, 0, 2, 1);
		cons.insets = new Insets(0, 10, 5, 60);

		add(gname,cons,1,1,2,1);

		cons.weightx = 0;
		cons.insets = new Insets(0, 10, 1, 10);
		cons.ipady = 20;
		add(addfield,cons,1,2,1,2);
		add(activity,cons,1,4,1,2);
		add(extraskill,cons,1,6,1,2);
		add(education,cons,1,8,1,2);
		//add(im,cons,2,2,1,4);
		cons.ipady = 0;
		cons.insets = new Insets(0, 10, 5, 40);
		Box datebox=Box.createHorizontalBox();
		datebox.add(joindateday);
		datebox.add(Box.createHorizontalStrut(10));
		datebox.add(joindatemon);
		datebox.add(Box.createHorizontalStrut(10));
		datebox.add(joindateyear);
		datebox.add(Box.createGlue());
		add(datebox,cons,1,10,1,1);
		cons.insets=new Insets(0,10,5,115);
		cons.ipady = 5;
		add(mobno,cons,1,12,1,1);
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
		hbox.add(Box.createGlue());
		add(hbox,cons,0,14,3,1);
		cons.weightx=100;
		cons.weighty=100;
		cons.insets=new Insets(5,16,10,15);
		cons.fill=GridBagConstraints.BOTH;
		cons.anchor=GridBagConstraints.PAGE_END;
		add(table1,cons,0,15,3,3);
		cons.weightx=100;
		cons.weighty=60;
		cons.insets=new Insets(0,0,0,0);
		add(new ImageLabel("wl.GIF"),cons,2,1,1,12);


		mobno.setMaximumSize(mobno.getMinimumSize());
		joindateday.setMaximumSize(joindateday.getMinimumSize());
		joindatemon.setMaximumSize(joindatemon.getMinimumSize());
		joindateyear.setMaximumSize(joindateyear.getMinimumSize());
		joindateday.setMaximumRowCount(10);
		joindatemon.setMaximumRowCount(10);
		joindateyear.setMaximumRowCount(10);
		DateHandler3 datehandler=new DateHandler3();
		joindatemon.addActionListener(datehandler);
		joindateyear.addActionListener(datehandler);
		String day[]=new String[31];
		String year[]=new String[150];
		GestInfoHandler h=new GestInfoHandler();
		New.addActionListener(h);
		modify.addActionListener(h);
		save.addActionListener(h);
		remove.addActionListener(h);
		exit.addActionListener(h);
		addWindowListener(new GestWindowHandler());
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
		try
		{
			DataInputStream sin=new DataInputStream(new FileInputStream("Gest_id.dat"));
			gcode.setText(sin.readUTF());

		}
		catch(Exception e)
		{
		}


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
	class DateHandler3 implements ActionListener
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
	class GestTableHandler extends MouseAdapter
	{
		public void mouseClicked(MouseEvent me)
		{
			int ro=table.getSelectedRow();
			String sel=(String)table.getValueAt(ro,0);
			try
			{
				st=conn.createStatement();
				ResultSet set=st.executeQuery("select * from GestInfo");
				String gcd="";
				while(set.next())
				{
					gcd=set.getString(1).trim();
					if(sel.equals(gcd))
						break;
				}
				gcode.setText(gcd);
				gname.setText(set.getString(2));
				addfield1.setText(set.getString(3));
				Activity.setText(set.getString(4));
				ExtraSkill.setText(set.getString(5));
				Education.setText(set.getString(6));
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
				save.setEnabled(false);

			}
			catch(Exception ew)
			{
			}

		}
	}
	class GestWindowHandler extends WindowAdapter
	{
		public void windowActivated(WindowEvent we)
		{
			try
			{
				conn=DriverManager.getConnection("jdbc:odbc:Gest_Info","raj","17java71");
				st=conn.createStatement();
				ResultSet tableset=st.executeQuery("Select * from GestInfo ");
				int row=0;
				int i=0;
				while(tableset.next())
				{
					row++;
				}
				DefaultTableModel model=new DefaultTableModel(new String[]{"Gest ID","Name","Mobile No"},row);
				tableset=st.executeQuery("Select * from GestInfo ");
				while(tableset.next())
				{
					model.setValueAt(tableset.getString(1).trim(),i,0);
					model.setValueAt(tableset.getString(2).trim(),i,1);
					model.setValueAt(tableset.getString(8).trim(),i,2);
					i++;
				}
				table.setModel(model);
			}
			catch(Exception e)
			{
			}
		}
	}
	class GestInfoHandler implements ActionListener
	{

		public void actionPerformed(ActionEvent e)
		{
			String s=e.getActionCommand();
			if(s.equals("New"))
			{
				try
				{
					DataInputStream sin=new DataInputStream(new FileInputStream("Gest_id.dat"));
					gcode.setText(sin.readUTF());
				}
				catch(Exception ex)
				{
				}
				gname.setText("");
				addfield1.setText("");
				Activity.setText("");
				ExtraSkill.setText("");
				Education.setText("");
				save.setEnabled(true);
				mobno.setText("");
			}
			else
			if(s.equals("Save"))
			{
				boolean ok=false;
				try
				{
					String code=gcode.getText();
					String name=gname.getText();
					String address=addfield1.getText();
					String activity=Activity.getText();
					String extraskill=ExtraSkill.getText();
					String educate=Education.getText();
					int dy=Integer.parseInt((String)joindateday.getSelectedItem());
					String dys="";
					if(dy>=1 && dy<=9)
						dys="0"+dy;
					else
						dys=""+dy;
					String date=""+dys+"-"+(String)joindatemon.getSelectedItem()+"-"+(String)joindateyear.getSelectedItem();
					String mobile=mobno.getText();
					if(name.equals("") || address.equals(""))
					{
							Icon error=new ImageIcon("error.png");
							JOptionPane.showMessageDialog(GestContact.this,"<html><font size=4 color=red>Name Address Not Be Blank </font></html> \n\t\t Please Enter Information","Gest Contact",JOptionPane.ERROR_MESSAGE,error);

					}
					else
					{
						boolean valid=false;
						if((mobile.length() == 10)||(mobile.length() == 11))
						{
							valid=true;
							if(mobile.length() == 11)
							{
								char ch=mobile.charAt(0);
								if(ch != '0')
								{
									valid=false;
									Icon error=new ImageIcon("error.png");
									JOptionPane.showMessageDialog(GestContact.this,"<html><font size=4 color=red>Mobile Number Not Be Valid </font></html> \n\t\t Please Enter Valid Mobile Number","Gest Contact",JOptionPane.ERROR_MESSAGE,error);
								}
							}
						}
						else
						{
							valid=false;
							Icon error=new ImageIcon("error.png");
							JOptionPane.showMessageDialog(GestContact.this,"<html><font size=4 color=red>Mobile Number Not Be Valid </font></html> \n\t\t Please Enter Valid Mobile Number","GestContact",JOptionPane.ERROR_MESSAGE,error);
						}

						if(valid == true)
						{
							PreparedStatement ps=conn.prepareStatement("insert into GestInfo values(?,?,?,?,?,?,?,?)");
							ps.setString(1,code);
							ps.setString(2,name);
							ps.setString(3,address);
							ps.setString(4,activity);
							ps.setString(5,extraskill);
							ps.setString(6,educate);
							ps.setString(7,date);
							ps.setString(8,mobile);
							ps.execute();
							ps.close();
							gname.setText("");
							addfield1.setText("");
							Activity.setText("");
							ExtraSkill.setText("");
							Education.setText("");
							mobno.setText("");
							ps.close();
							DataInputStream dt=new DataInputStream(new FileInputStream("Gest_id.dat"));
							String temp2=dt.readUTF();
							String temp=temp2.substring(4);
							int x=Integer.parseInt(temp);
							if(x<9)
							{
								x++;
								temp2="Gest000"+x;
							}
							else
							if(x<99)
							{
								x++;
								temp2="Gest00"+x;
							}
							else
							if(x<999)
							{
								x++;
								temp2="Gest0"+x;
							}
							else
							{
								x++;
								temp2="Gest"+x;
							}

							DataOutputStream out=new DataOutputStream(new FileOutputStream("Gest_id.dat"));
							out.writeUTF(temp2);
							dt.close();
							out.close();
							DataInputStream sin=new DataInputStream(new FileInputStream("Gest_id.dat"));
							gcode.setText(sin.readUTF());
							ResultSet tableset=st.executeQuery("Select * from GestInfo ");
							int row=0;
							int i=0;
							while(tableset.next())
							{
								row++;
							}
							DefaultTableModel model=new DefaultTableModel(new String[]{"Gest ID","Name","Mobile No"},row);
							tableset=st.executeQuery("Select * from GestInfo ");
							while(tableset.next())
							{
								model.setValueAt(tableset.getString(1).trim(),i,0);
								model.setValueAt(tableset.getString(2).trim(),i,1);
								model.setValueAt(tableset.getString(8).trim(),i,2);
								i++;
							}
							table.setModel(model);

						}
					}


				}
				catch(Exception e1)
				{
					Icon error=new ImageIcon("error.png");
					JOptionPane.showMessageDialog(GestContact.this,"<html><font size=3 color=red> Name Address Not Be Blank </font></html> \n\t\t Please Enter Information ","Gest Contact",JOptionPane.ERROR_MESSAGE,error);
				}
			}
			else
			if(s.equals("Modify"))
			{
				ModifyGestInfo info=new ModifyGestInfo();
				info.setVisible(true);

			}
			else
			if(s.equals("Remove"))
			{
				RemoveGestInfo info=new RemoveGestInfo();
				info.setVisible(true);
			}
			else
			{
				dispose();
				new MainMenuFrame().setVisible(true);
			}
		}
	}
	class ModifyGestInfo extends JFrame
	{

		ModifyGest mdl;
		String gscode;
		ModifyGestInfo()
		{
			final int width2=screenSize.width/3;
			final int height2=screenSize.height/3;
			setSize(width2+60, height2+100);
			setLocation(width2-20,height2-50);
			setTitle("Gest Contact");
			mic=getContentPane();
			ModifyGestInfo.setDefaultLookAndFeelDecorated(true);
			setResizable(false);
			setIconImage(Toolkit.getDefaultToolkit().getImage("mainicon.png"));
			addWindowListener(new WindowAdapter()
			{
				public void windowClosing(WindowEvent e)
				{
					dispose();
				}
			});

			JLabel l=new JLabel("<html><font size=5 color=#800080><i>Select Guest To Remove");
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
					g.drawImage(img,0,0,width2+60,height2+100,null);
				}
			};
			title.add(l);
			mic.add("North",title);

			try
			{
				ResultSet tableset=st.executeQuery("Select * from GestInfo ");
				int row=0;
				int i=0;
				while(tableset.next())
				{
					row++;
				}
				model=new DefaultTableModel(new String[]{"Gest ID","Name","Mobile No"},row);
				tableset=st.executeQuery("Select * from GestInfo ");
				while(tableset.next())
				{
					model.setValueAt(tableset.getString(1).trim(),i,0);
					model.setValueAt(tableset.getString(2).trim(),i,1);
					model.setValueAt(tableset.getString(8).trim(),i,2);
					i++;
				}
				gest=new JTable(model);
				gest.addMouseListener(new ModifyGestList());
				gest.setToolTipText("Select The Gest For Modify");
				gest.doLayout();
				gest.setColumnSelectionAllowed(false);
				gest.setSelectionMode(1);
				gest.setEditingColumn(3);
				gest.setGridColor(Color.pink);
				gest.setRowMargin(3);
				gest.setSelectionBackground(Color.gray);
				gest.setSelectionForeground(Color.red);
				gest.setShowHorizontalLines(false);
				gest.setShowVerticalLines(false);
				gest.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
				JScrollPane spl=new JScrollPane(gest);
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

						ResultSet tableset=st.executeQuery("Select * from GestInfo");
						int row=0;
						int i=0;
						while(tableset.next())
						{
							row++;
						}
						DefaultTableModel md=new DefaultTableModel(new String[]{"Gest Id","Name","Mobile No"},row);
						tableset=st.executeQuery("Select * from GestInfo");
						while(tableset.next())
						{
							md.setValueAt(tableset.getString(1).trim(),i,0);
							md.setValueAt(tableset.getString(2).trim(),i,1);
							md.setValueAt(tableset.getString(8).trim(),i,2);
							i++;
						}
						gest.setModel(md);
					}
						catch(Exception es)
					{
					}
				}
			});
		}
		class ModifyGestList extends MouseAdapter
		{
			public void mouseClicked(MouseEvent e)
			{
					int ro=gest.getSelectedRow();
					gscode=(String)gest.getValueAt(ro,0);
					mdl=new ModifyGest(gscode);
					mdl.setVisible(true);
			}
		}
		class ModifyGest extends JDialog
		{
			private JTextField  gcd;
			private JTextField gnm;
			private JTextArea addf;
			private JTextArea Acti;
			private JTextArea ExtSk;
			private JTextArea Edt;
			private JTextField mbno;
			private JTextField datetf;
			private JButton gok;
			private JButton gcancle;
			TextValid onlyText;
			NumberValid onlyNumber;
			Connection conn;
			Statement st;
			String mgest;
			JPanel mpan;
			Container cont;

			ModifyGest(String s)
			{
				super(ModifyGestInfo.this,"Modify Gest",true);
				mgest=s;
				setSize(420,400);
				setLocation(355,260);
				cont=getContentPane();
				JPanel bp=new JPanel();
				bp.setBackground(new Color(255,197,68));
				gok=new JButton("  Save  ");
				gcancle=new JButton("Cancle");
				bp.add(gok);
				bp.add(gcancle);
				cont.add(bp,"South");
				ModifyGestHandler ms=new ModifyGestHandler();
				gok.addActionListener(ms);
				gcancle.addActionListener(ms);

				mpan=new JPanel();
				mpan.setLayout(new GridBagLayout());
				gcd=new JTextField(10);
				gcd.setToolTipText("Gest ID");
				gcd.setEditable(false);
				gcd.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
				gnm=new JTextField(20);
				gnm.addKeyListener(onlyText);
				gnm.setToolTipText("Enter Gest Name");
				gnm.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
				addf=new JTextArea(2,20);
				addf.setToolTipText("Enter Gest's Address");
				addf.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
				addf.setWrapStyleWord(true);
				addf.setLineWrap(true);
				JScrollPane addfd=new JScrollPane(addf);
				Acti=new JTextArea(2,20);
				Acti.setToolTipText("Enter Gest's Activity");
				Acti.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
				Acti.setWrapStyleWord(true);
				Acti.setLineWrap(true);
				JScrollPane acti=new JScrollPane(Acti);
				ExtSk=new JTextArea(2,20);
				ExtSk.setToolTipText("Enter Gest's Extra Skill");
				ExtSk.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
				ExtSk.setWrapStyleWord(true);
				ExtSk.setLineWrap(true);
				JScrollPane extsk=new JScrollPane(ExtSk);
				Edt=new JTextArea(2,20);
				Edt.setToolTipText("Enter Gest's Education");
				Edt.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
				Edt.setWrapStyleWord(true);
				Edt.setLineWrap(true);
				JScrollPane edt=new JScrollPane(Edt);
				datetf=new JTextField(10);
				datetf.setToolTipText("Joining Date");
				datetf.setEditable(false);
				datetf.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
				mbno=new JTextField(14);
				mbno.addKeyListener(onlyNumber);
				mbno.setToolTipText("Enter Mobile Number ");
				mbno.setBorder(BorderFactory.createBevelBorder(1,new Color(100,100,155),new Color(100,100,155)));
				mbno.setSelectionColor(Color.blue);
				mbno.setDisabledTextColor(Color.red);
				mbno.setCaretColor(Color.green);
				mbno.setSelectionColor(Color.pink);
				mbno.setFont(new Font("verdana", Font.BOLD, 12));
				GridBagConstraints cons=new GridBagConstraints();
				cons.fill=GridBagConstraints.NONE;
				cons.anchor=GridBagConstraints.EAST;
				cons.weightx=10;
				cons.weighty=10;
				cons.insets = new Insets(0, 10, 5, 0);
				mdadd(new JLabel("Gest Code  : "),cons,0,0,1,1);
				mdadd(new JLabel("Gest Name  : "),cons,0,1,1,1);
				mdadd(new JLabel("Address  : "),cons,0,2,1,2);
				mdadd(new JLabel("Activity  : "),cons,0,4,1,2);
				mdadd(new JLabel("Extra Skill  : "),cons,0,6,1,2);
				mdadd(new JLabel("Education  :"),cons,0,8,1,2);
				mdadd(new JLabel("Date Of Joining  : "),cons,0,10,1,1);
				mdadd(new JLabel("Mobile Number  : "),cons,0,11,1,1);
				cons.fill=GridBagConstraints.HORIZONTAL;
				cons.weightx = 50;
				cons.insets = new Insets(0, 10, 5, 40);
				mdadd(gcd, cons, 1, 0, 1, 1);
				cons.insets = new Insets(0, 10, 1, 40);
				mdadd(gnm,cons,1,1,1,1);
				cons.insets = new Insets(0, 10, 1, 100);
				cons.ipady = 20;
				mdadd(addfd,cons,1,2,1,2);
				mdadd(acti,cons,1,4,1,2);
				mdadd(extsk,cons,1,6,1,2);
				mdadd(edt,cons,1,8,1,2);
				cons.ipady=0;
				cons.insets = new Insets(0, 10, 1, 160);
				mdadd(datetf,cons,1,10,1,1);
				mdadd(mbno,cons,1,11,1,1);
				try
				{
					conn=DriverManager.getConnection("jdbc:odbc:Gest_Info","raj","17java71");
					st=conn.createStatement();
					ResultSet minfo=st.executeQuery("select * from GestInfo");
					String gsco="";
					while(minfo.next())
					{
						gsco=minfo.getString(1).trim();
						if(gsco.equals(mgest))
							break;
					}
					gcd.setText(gsco);
					gnm.setText(minfo.getString(2));
					addf.setText(minfo.getString(3));
					Acti.setText(minfo.getString(4));
					ExtSk.setText(minfo.getString(5));
					Edt.setText(minfo.getString(6));
					datetf.setText(minfo.getString(7));
					mbno.setText(minfo.getString(8));
				}
				catch(Exception ed)
				{
					System.out.println(ed);
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
			class ModifyGestHandler implements ActionListener
			{
				public void actionPerformed(ActionEvent e)
				{
					String minfo=e.getActionCommand();
					if(minfo.equals("  Save  "))
					{
						boolean ok=false;
						try
						{
							String gid=gcd.getText();
							String name=gnm.getText();
							String address=addf.getText();
							String activity=Acti.getText();
							String extraskill=ExtSk.getText();
							String edct=Edt.getText();
							String mobile=mbno.getText();
							if(name.equals("") || address.equals(""))
							{
								Icon error=new ImageIcon("error.png");
								JOptionPane.showMessageDialog(ModifyGest.this,"<html><font size=4 color=red>Field Name Address Not Be Blank </font></html> \n\t\t Please enter Information","Gest Information",JOptionPane.ERROR_MESSAGE,error);
							}
							else
							{
								String mobTest=mbno.getText().trim();
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
											JOptionPane.showMessageDialog(ModifyGest.this,"<html><font size=4 color=red>Mobile Number Not Be Valid </font></html> \n\t\t Please Enter Valid Mobile Number","Gest Information",JOptionPane.ERROR_MESSAGE,error);
										}
									}
								}
								else
								{
									valid=false;
									Icon error=new ImageIcon("error.png");
									JOptionPane.showMessageDialog(ModifyGest.this,"<html><font size=4 color=red>Mobile Number Not Be Valid </font></html> \n\t\t Please Enter Valid Mobile Number","Gest Information",JOptionPane.ERROR_MESSAGE,error);
								}
								if(valid==true)
								{
									PreparedStatement pm=conn.prepareStatement("update GestInfo set GestName=? ,address=? ,activity=? ,extraskill=? ,education=? ,mobno=? where GestId=?");
									pm.setString(1,name);
									pm.setString(2,address);
									pm.setString(3,activity);
									pm.setString(4,extraskill);
									pm.setString(5,edct);
									pm.setString(6,mobile);
									pm.setString(7,gid);
									pm.execute();
								}
								mdl.dispose();
							}
						}
						catch(Exception es)
						{
							Icon error=new ImageIcon("error.png");
							JOptionPane.showMessageDialog(ModifyGest.this,"<html><font size=4 color=red>Name Address Not Be Blank </font></html> \n\t\t Please Enter Information","Gest Information",JOptionPane.ERROR_MESSAGE,error);
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
	class RemoveGestInfo extends JFrame
	{
		Container mic=getContentPane();
		RemoveGest dlg;
		String gscode;
		RemoveGestInfo()
		{
			final int width2=screenSize.width/3;
			final int height2=screenSize.height/3;
			setSize(width2+60, height2+100);
			setLocation(width2-20,height2-50);
			setTitle("Gest Information");
			addWindowListener(new WindowAdapter()
			{
				public void windowClosing(WindowEvent e)
				{
					dispose();
				}
			});
			RemoveGestInfo.setDefaultLookAndFeelDecorated(true);
			setResizable(false);
			setIconImage(Toolkit.getDefaultToolkit().getImage("mainicon.png"));
			JLabel l=new JLabel("<html><font size=5 color=#800080><i>Select Guest To Remove");
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
					g.drawImage(img,0,0,width2+60,height2+100,null);
				}
			};
			title.add(l);
			mic.add("North",title);
			try
			{
				ResultSet tableset=st.executeQuery("Select * from GestInfo ");
				int row=0;
				int i=0;
				while(tableset.next())
				{
					row++;
				}
				model=new DefaultTableModel(new String[]{"Gest ID","Name","Mobile No"},row);
				tableset=st.executeQuery("Select * from GestInfo ");
				while(tableset.next())
				{
					model.setValueAt(tableset.getString(1).trim(),i,0);
					model.setValueAt(tableset.getString(2).trim(),i,1);
					model.setValueAt(tableset.getString(8).trim(),i,2);
					i++;
				}
				gest=new JTable(model);
				gest.addMouseListener(new RemoveGestList());
				gest.setToolTipText("Select The Gest For Modify");
				gest.doLayout();
				gest.setColumnSelectionAllowed(false);
				gest.setSelectionMode(1);
				gest.setEditingColumn(3);
				gest.setGridColor(Color.pink);
				gest.setRowMargin(3);
				gest.setSelectionBackground(Color.gray);
				gest.setSelectionForeground(Color.red);
				gest.setShowHorizontalLines(false);
				gest.setShowVerticalLines(false);
				gest.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
				JScrollPane spl=new JScrollPane(gest);
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
						ResultSet tableset=st.executeQuery("Select * from GestInfo");
						int row=0;
						int i=0;
						while(tableset.next())
						{
							row++;
						}
						DefaultTableModel md=new DefaultTableModel(new String[]{"Gest Id","Name","Mobile No"},row);
						tableset=st.executeQuery("Select * from GestInfo");
						while(tableset.next())
						{
							md.setValueAt(tableset.getString(1).trim(),i,0);
							md.setValueAt(tableset.getString(2).trim(),i,1);
							md.setValueAt(tableset.getString(8).trim(),i,2);
							i++;
						}
						gest.setModel(md);
					}
					catch(Exception es)
					{
					}
				}
			});
		}
		class RemoveGestList extends MouseAdapter
		{
			public void mouseClicked(MouseEvent e)
			{
				int ro=gest.getSelectedRow();
				gscode=(String)gest.getValueAt(ro,0);
				dlg=new RemoveGest(gscode);
				dlg.setVisible(true);
			}
		}
		class RemoveGest extends JDialog
		{
			JButton rok;
			JButton rcan;
			String rmgest;
			RemoveGest(String s)
			{
				super(RemoveGestInfo.this,"Remove Gest",true);
				rmgest=s;
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
				lp.add(new JLabel("<html><font size=4 color=#800080>Do You Want To Ramove <br>    Gest Information </font></html>"));
				add(lp);
				RemoveGst rs=new RemoveGst();
				rok.addActionListener(rs);
				rcan.addActionListener(rs);
			}
			class RemoveGst implements ActionListener
			{
				public void actionPerformed(ActionEvent ev)
				{
					String cm=ev.getActionCommand();
					if(cm.equals("  Ok  "))
					{
						try
						{
							PreparedStatement pts=conn.prepareStatement("delete from GestInfo where GestId=?");
							pts.setString(1,rmgest);
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