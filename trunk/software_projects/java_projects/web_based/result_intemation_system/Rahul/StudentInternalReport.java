import javax.swing.*;
import javax.swing.plaf.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.plaf.metal.*;
import java.sql.*;
import java.io.*;
import javax.swing.table.*;
import java.awt.print.*;
class StudentInternalReport extends JFrame
{
	Container c;
	JPanel main;
	JComboBox course;
	JComboBox sem;
	JTable studid;
	JTable marks;
	Connection conn;
	Statement st;
	DefaultTableModel model;
	DefaultTableModel mdl;
	JComboBox appyrst;
	JComboBox appyred;
	int rowcopy;
	JButton save;
	JButton cancle;
	JButton print;
	SaveDialog dlg;
	String sts[];
	int row=0;
	JButton send;
	int height;
   	int width;
   	Dimension screenSize;
	StudentInternalReport()
	{
		Toolkit kits=Toolkit.getDefaultToolkit();
		screenSize=kits.getScreenSize();
		width=screenSize.width/2;
		height=screenSize.height/2;
		setSize(width+180,height+260);
		setLocation(screenSize.width/6,20);
		setTitle("Student Internal Report");

		StudentInternalReport.setDefaultLookAndFeelDecorated(true);
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("mainicon.png"));
		c=getContentPane();

		main=new JPanel();
		main.setLayout(new GridBagLayout());

		JLabel l=new JLabel("<html><font size=6 color=#800080><i>Internal Exam Marks");

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
				g.drawImage(img,0,0,width+180,50,null);
			}
		};

		title.add(l);
		c.add(title,"North");

		course=new JComboBox();
		course.setToolTipText("Select Course");
		course.setMaximumRowCount(10);
		course.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));

		sem=new JComboBox();
		sem.setToolTipText("Select Course");
		sem.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
		sem.setMaximumRowCount(10);

		appyrst=new JComboBox();
		appyrst.setToolTipText("Select apperaed year");
		appyrst.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
		appyrst.setFont(new Font("verdana",Font.BOLD,12));
		appyrst.setForeground(new Color(20,0,0));

		appyred=new JComboBox();
		appyred.setToolTipText("Select apperaed year");
		appyred.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
		appyred.setFont(new Font("verdana",Font.BOLD,12));
		appyred.setForeground(new Color(20,0,0));

		int i=0;
		int subno=0;
		double dd;
		ResultSet tableset=null;
		String appyear;
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			conn=DriverManager.getConnection("jdbc:odbc:Student_Info","raj","17java71");
			st=conn.createStatement();

			//Adding course into the list
			ResultSet set=st.executeQuery("select * from course_name");
			while(set.next())
			{
				course.addItem(set.getString(2));

			}

			//Adding year into the appyear year
			for(int y=1950;y<2100;y++)
			{
				appyrst.addItem(Integer.toString(y));
			}
			appyrst.setSelectedItem("2007");

			//course duration
			String crs=(String)course.getSelectedItem();
			if(crs!=null)
			{
				int x=0;
				try
				{
					set=st.executeQuery("select * from course_name");

					String dur=null;
					while(set.next())
					{
						String cr=set.getString(2).trim();
						dur=set.getString(4).trim();
						if(cr.equals(crs))
							break;
					}

					if(dur.equals("Two Semester") || dur.equals("One Year"))
						x=1;
					else
					if(dur.equals("Four Semester") || dur.equals("Two Year"))
						x=2;
					else
					if(dur.equals("Six Semester") || dur.equals("Three Year"))
						x=3;
					else
					if(dur.equals("Eight Semester") || dur.equals("Four Year"))
						x=4;


					int y=Integer.parseInt((String)appyrst.getSelectedItem());
					y=y+x;
					appyred.addItem(Integer.toString(y));

				}
				catch(Exception ec){}
			}
			appyear=(String)appyrst.getSelectedItem()+"-"+(String)appyred.getSelectedItem();

			String cours=(String)course.getSelectedItem();

			//count row
			if(cours!=null)
			{

				tableset=st.executeQuery("Select * from "+cours+"_stud_info where appyear='"+appyear+"' order by scode");
				while(tableset.next())
				{
					row++;
				}
			}

			model=new DefaultTableModel(new String[]{"SCode"},row);
			studid=new JTable(model);


			//Adding value in Table
			if(cours!=null)
			{
				tableset=st.executeQuery("Select * from "+cours+"_stud_info where appyear='"+appyear+"' order by scode");
				while(tableset.next())
				{

					model.setValueAt(tableset.getString(1).trim(),i,0);
					i++;
				}

				set=st.executeQuery("select * from course_name");
				String cr=null;
				String courdur=null;


				//Adding item into the semester list
				while(set.next())
				{
					cr=set.getString(2).trim();
					courdur=set.getString(4);
					if(cours.equals(cr))
						break;
				}


				if(courdur.equals("Two Semester"))
				{
					sem.addItem(new String("Semester No One"));
					sem.addItem(new String("Semester No Two"));

				}
				if(courdur.equals("Four Semester"))
				{
					sem.addItem(new String("Semester No One"));
					sem.addItem(new String("Semester No Two"));
					sem.addItem(new String("Semester No Three"));
					sem.addItem(new String("Semester No Four"));
				}
				if(courdur.equals("Six Semester"))
				{
					sem.addItem(new String("Semester No One"));
					sem.addItem(new String("Semester No Two"));
					sem.addItem(new String("Semester No Three"));
					sem.addItem(new String("Semester No Four"));
					sem.addItem(new String("Semester No Five"));
					sem.addItem(new String("Semester No Six"));
				}
				if(courdur.equals("Eight Semester"))
				{	sem.addItem(new String("Semester No One"));
					sem.addItem(new String("Semester No Two"));
					sem.addItem(new String("Semester No Three"));
					sem.addItem(new String("Semester No Four"));
					sem.addItem(new String("Semester No Five"));
					sem.addItem(new String("Semester No Six"));
					sem.addItem(new String("Semester No Seven"));
					sem.addItem(new String("Semester No Eight"));
				}
				if(courdur.equals("One Year"))
					sem.addItem(new String("Year No One"));
				if(courdur.equals("Two Year"))
				{
					sem.addItem(new String("Year No One"));
					sem.addItem(new String("Year No Two"));
				}
				if(courdur.equals("Three Year"))
				{
					sem.addItem(new String("Year No One"));
					sem.addItem(new String("Year No Two"));
					sem.addItem(new String("Year No Three"));
				}
				if(courdur.equals("Four Year"))
				{	sem.addItem(new String("Year No One"));
					sem.addItem(new String("Year No Two"));
					sem.addItem(new String("Year No Three"));
					sem.addItem(new String("Year No Four"));
				}
				String dur=null;


				ResultSet rset=st.executeQuery("select * from "+cours+"_sub ");

				String semt=(String)sem.getSelectedItem();
				if(semt.charAt(0) == 'S')
					dur=semt.substring(12).trim();
				if(semt.charAt(0) == 'Y')
					dur=semt.substring(7).trim();
				String s[]=new String[9];
				int f=0;

				if(dur.equals("One"))
				{
					f=0;
					while((rset.next()))
					{
						dd=Double.parseDouble(rset.getString(1));
						if(dd < 2.0)
						{
							s[f]=new String(rset.getString(2));
							f++;
						}
					}
				}

				sts=new String[f];

				for(int j=0;j<f;j++)
					sts[j]=new String(s[j]);

				row=0;

				tableset=st.executeQuery("Select * from "+cours+"_stud_info where appyear='"+appyear+"' order by scode");

				while(tableset.next())
				{
					row++;
				}
				mdl=new DefaultTableModel(sts,row);


				PreparedStatement pst=conn.prepareStatement("select * from "+cours+"_marks1 where appyear=? order by scode");
				pst.setString(1,appyear);
				ResultSet reset=pst.executeQuery();

				ResultSetMetaData mt=reset.getMetaData();
				int col=mt.getColumnCount();

				i=0;
				if(reset!=null)
				{

					while(reset.next())
					{
						for(int j=0;j<col-2;j++)
						{
							String temp=reset.getString(j+3).trim();
							mdl.setValueAt(temp,i,j);
						}
						i++;
					}
				}
			}
			marks=new JTable(mdl);
		}
		catch(Exception e)
		{

		}
		JScrollPane studid1=new JScrollPane(studid);
		studid.doLayout();
		studid.setColumnSelectionAllowed(false);
		studid.setSelectionMode(1);
		studid.setEditingColumn(3);
		studid.setGridColor(Color.pink);
		studid.setDragEnabled(false);
		studid.setRowMargin(3);
		studid.setSelectionBackground(new Color(194,253,254));
		studid.setSelectionForeground(new Color(128,64,0));
		studid.setShowHorizontalLines(false);
		studid.setShowVerticalLines(false);
		//studid.setFont(new Font("Times New Roman",0,14));
		studid.setRowMargin(5);
		studid.setRowHeight(22);

		JScrollPane marks1=new JScrollPane(marks);
		marks.doLayout();
		marks.setColumnSelectionAllowed(false);
		marks.setSelectionMode(1);
		marks.setEditingColumn(3);
		marks.setGridColor(Color.pink);
		marks.setDragEnabled(false);
		marks.setRowMargin(3);
		marks.setSelectionBackground(new Color(194,253,254));
		marks.setSelectionForeground(new Color(128,64,0));
		marks.setShowHorizontalLines(true);
		marks.setShowVerticalLines(true);
		//marks.setFont(new Font("Times New Roman",0,14));
		marks.setRowMargin(5);
		marks.setRowHeight(22);


		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				dispose();
				new MainMenuFrame().setVisible(true);
			}
		});


		GridBagConstraints cons=new GridBagConstraints();
		cons.fill=GridBagConstraints.BOTH;
		cons.anchor=GridBagConstraints.EAST;
		cons.weightx=0;
		cons.weighty=0;

		cons.weightx=30;
		add(course,cons,0,0,3,1);
		cons.weightx=10;

		Box cor = Box.createHorizontalBox();
		cor.add(Box.createGlue());
		cor.add(new JLabel("Appered Year"));
		cor.add(Box.createHorizontalStrut(5));
		cor.add(appyrst);
		cor.add(Box.createHorizontalStrut(5));
		cor.add(new JLabel("TO"));
		cor.add(appyred);
		cor.add(Box.createHorizontalStrut(5));


		add(cor, cons, 4, 0, 3, 1);
		cons.weightx=0;

		add(sem,cons,8,0,2,1);
		cons.fill=GridBagConstraints.BOTH;
		cons.weightx=15;
		cons.weighty=100;

		add(studid1,cons,0,1,3,10);
		cons.weightx=85;
		cons.weighty=100;

		add(marks1,cons,4,1,6,10);
		course.addActionListener(new CourseHandler());
		appyrst.addActionListener(new CourseHandler());
		sem.addActionListener(new SessionHandler());



		JPanel bp=new JPanel();
		bp.setBackground(new Color(255,197,68));

		save=new JButton("Save");
		Icon prt=new ImageIcon("PRINT.png");
		print=new JButton("Print",prt);
		cancle=new JButton("Cancle");
		Icon ic=new ImageIcon("mainicon.png");
		send=new JButton("Send To All",ic);

		bp.add(save);
		bp.add(send);
		bp.add(print);
		bp.add(cancle);
		add(bp,"South");

		SaveHandler sh=new SaveHandler();
		save.addActionListener(sh);
		cancle.addActionListener(sh);
		send.addActionListener(new MarksSendHandler());

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
	class CourseHandler implements ActionListener
	{
		double dd;
		public void actionPerformed(ActionEvent e)
		{
			String cour=(String)course.getSelectedItem();
			try
			{
				st=conn.createStatement();
				ResultSet set=st.executeQuery("select * from course_name");
				String cr=null;
				String courdur=null;
				//Add Semester or year of course to semester list
				while(set.next())
				{
					cr=set.getString(2).trim();
					courdur=set.getString(4);
					if(cour.equals(cr))
						break;
				}
				sem.removeAllItems();
				if(courdur.equals("Two Semester"))
				{
					sem.addItem(new String("Semester No One"));
					sem.addItem(new String("Semester No Two"));

				}
				if(courdur.equals("Four Semester"))
				{
					sem.addItem(new String("Semester No One"));
					sem.addItem(new String("Semester No Two"));
					sem.addItem(new String("Semester No Three"));
					sem.addItem(new String("Semester No Four"));
				}
				if(courdur.equals("Six Semester"))
				{
					sem.addItem(new String("Semester No One"));
					sem.addItem(new String("Semester No Two"));
					sem.addItem(new String("Semester No Three"));
					sem.addItem(new String("Semester No Four"));
					sem.addItem(new String("Semester No Five"));
					sem.addItem(new String("Semester No Six"));
				}
				if(courdur.equals("Eight Semester"))
				{	sem.addItem(new String("Semester No One"));
					sem.addItem(new String("Semester No Two"));
					sem.addItem(new String("Semester No Three"));
					sem.addItem(new String("Semester No Four"));
					sem.addItem(new String("Semester No Five"));
					sem.addItem(new String("Semester No Six"));
					sem.addItem(new String("Semester No Seven"));
					sem.addItem(new String("Semester No Eight"));
				}
				if(courdur.equals("One Year"))
					sem.addItem(new String("Year No One"));
				if(courdur.equals("Two Year"))
				{
					sem.addItem(new String("Year No One"));
					sem.addItem(new String("Year No Two"));
				}
				if(courdur.equals("Three Year"))
				{
					sem.addItem(new String("Year No One"));
					sem.addItem(new String("Year No Two"));
					sem.addItem(new String("Year No Three"));
				}
				if(courdur.equals("Four Year"))
				{	sem.addItem(new String("Year No One"));
					sem.addItem(new String("Year No Two"));
					sem.addItem(new String("Year No Three"));
					sem.addItem(new String("Year No Four"));
				}
				String dur=null;

				//change appyear year as per the course duration
				if(cour!=null)
				{
					int x=0;
					try
					{
						ResultSet reset=st.executeQuery("select * from course_name");
						while(reset.next())
						{
							String cors=reset.getString(2).trim();
							dur=reset.getString(4).trim();
							if(cors.equals(cour))
								break;
						}
						if(dur.equals("Two Semester") || dur.equals("One Year"))
							x=1;
						else
						if(dur.equals("Four Semester") || dur.equals("Two Year"))
							x=2;
						else
						if(dur.equals("Six Semester") || dur.equals("Three Year"))
							x=3;
						else
						if(dur.equals("Eight Semester") || dur.equals("Four Year"))
							x=4;
						appyred.removeAllItems();
						int y=Integer.parseInt((String)appyrst.getSelectedItem());
						y=y+x;
						appyred.addItem(Integer.toString(y));

					}
					catch(Exception ec)
					{
					}
				}
				String appyear=(String)appyrst.getSelectedItem()+"-"+(String)appyred.getSelectedItem();

				//count row of the table
				PreparedStatement ps=conn.prepareStatement("Select * from "+cour+"_stud_info where appyear=? order by scode");
				ps.setString(1,appyear);
				ResultSet tableset=ps.executeQuery();
				int i=0;
				int row=0;
				while(tableset.next())
				{
					row++;
				}
				DefaultTableModel model2=new DefaultTableModel(new String[]{"SCode"},row);

				//Set the student code in table
				ps=conn.prepareStatement("Select * from "+cour+"_stud_info where appyear=? order by scode");
				ps.setString(1,appyear);
				tableset=ps.executeQuery();
				while(tableset.next())
				{

					model2.setValueAt(tableset.getString(1).trim(),i,0);
					i++;
				}

				studid.setModel(model2);

				rowcopy=row;
				dur=null;
				//get the subject into the table and set on table column.

				ResultSet rset=st.executeQuery("select * from "+cour+"_sub ");
				String semt=(String)sem.getSelectedItem();
				if(semt.charAt(0) == 'S')
					dur=semt.substring(12).trim();
				if(semt.charAt(0) == 'Y')
					dur=semt.substring(7).trim();
				String s[]=new String[9];
				int f=0;
				int semno=0;

				if(dur.equals("One"))
				{
					semno=1;
					f=0;
					while((rset.next()))
					{
						dd=Double.parseDouble(rset.getString(1));
						if(dd < 2.0)
						{
							s[f]=new String(rset.getString(2));
							f++;
						}
					}
				}
				if(dur.equals("Two"))
				{
					semno=2;
					f=0;
					while((rset.next()))
					{
						dd=Double.parseDouble(rset.getString(1));
						if(dd > 2.0 && dd < 3.0)
						{
							s[f]=new String(rset.getString(2));
							f++;
						}
					}
				}
				if(dur.equals("Three"))
				{
					semno=3;
					f=0;
					while((rset.next()))
					{
						dd=Double.parseDouble(rset.getString(1));
						if(dd > 3.0 && dd < 4.0)
						{
							s[f]=new String(rset.getString(2));
							f++;
						}
					}

				}
				if(dur.equals("Four"))
				{
					semno=4;
					f=0;
					while((rset.next()))
					{
						dd=Double.parseDouble(rset.getString(1));
						if(dd > 4.0 && dd < 5.0)
						{
							s[f]=new String(rset.getString(2));
							f++;
						}
					}

				}
				if(dur.equals("Five"))
				{
					semno=5;
					f=0;
					while((rset.next()))
					{
						dd=Double.parseDouble(rset.getString(1));
						if(dd > 5.0 && dd < 6.0)
						{
							s[f]=new String(rset.getString(2));
							f++;
						}
					}

				}
				if(dur.equals("Six"))
				{
					semno=6;
					f=0;
					while((rset.next()))
					{
						dd=Double.parseDouble(rset.getString(1));
						if(dd > 6.0 && dd < 7.0)
						{
							s[f]=new String(rset.getString(2));
							f++;
						}
					}

				}
				if(dur.equals("Seven"))
				{
					semno=7;
					f=0;
					while((rset.next()))
					{
						dd=Double.parseDouble(rset.getString(1));
						if(dd > 7.0 && dd < 8.0)
						{
							s[f]=new String(rset.getString(2));
							f++;
						}
					}

				}
				if(dur.equals("Eight"))
				{
					semno=8;
					f=0;
					while((rset.next()))
					{
						dd=Double.parseDouble(rset.getString(1));
						if(dd > 8.0 && dd < 9.0)
						{
							s[f]=new String(rset.getString(2));
							f++;
						}
					}

				}

				sts=new String[f];
				for(int j=0;j<f;j++)
					sts[j]=new String(s[j]);
				ps=conn.prepareStatement("Select * from "+cour+"_stud_info where appyear=? order by scode");
				ps.setString(1,appyear);
				tableset=ps.executeQuery();
				row=0;
				while(tableset.next())
				{
					row++;
				}
				mdl=new DefaultTableModel(sts,row);
				appyear=(String)appyrst.getSelectedItem()+"-"+(String)appyred.getSelectedItem();

				PreparedStatement pst=conn.prepareStatement("select * from "+cour+"_marks"+semno+" where appyear=? order by scode");
				pst.setString(1,appyear);

				ResultSet reset=pst.executeQuery();
				ResultSetMetaData mt=reset.getMetaData();
				int col=mt.getColumnCount();
				i=0;
				while(reset.next())
				{
					for(int j=0;j<col-2;j++)
					{
						String temp=reset.getString(j+3).trim();
						mdl.setValueAt(temp,i,j);
					}
					i++;
				}
				marks.setModel(mdl);

			}
			catch(Exception ex)
			{
				System.out.println(ex);
			}
		}
	}
	class SessionHandler implements ActionListener
	{
		int f=0;
		double dd;
		int semno=0;
		int i=0;
		public void actionPerformed(ActionEvent e)
		{
			try
			{
				String appyear=(String)appyrst.getSelectedItem()+"-"+(String)appyred.getSelectedItem();

				String cour=(String)course.getSelectedItem();
				st=conn.createStatement();
				ResultSet rset=st.executeQuery("select * from "+cour+"_sub ");
				String crs=(String)sem.getSelectedItem();
				String dur=null;
				if(crs.charAt(0) == 'S')
					dur=crs.substring(12).trim();
				if(crs.charAt(0) == 'Y')
					dur=crs.substring(7).trim();
				String s[]=new String[9];

				if(dur.equals("One"))
				{
					semno=1;
					f=0;
					while(rset.next())
					{
						dd=Double.parseDouble(rset.getString(1));
						if(dd > 1.0 && dd < 2.0)
						{
							s[f]=new String(rset.getString(2));
							f++;
						}
					}
				}
				else
				if(dur.equals("Two"))
				{
					semno=2;
					f=0;
					while(rset.next())
					{
						dd=Double.parseDouble(rset.getString(1));
						if(dd > 2.0 && dd < 3.0)
						{
							s[f]=new String(rset.getString(2));
							f++;
						}

					}
				}
				else
				if(dur.equals("Three"))
				{
					semno=3;
					f=0;
					while(rset.next())
					{
						dd=Double.parseDouble(rset.getString(1));
						if(dd > 3.0 && dd < 4.0)
						{
							s[f]=new String(rset.getString(2));
							f++;
						}
					}
				}
				else
				if(dur.equals("Four"))
				{
					semno=4;
					f=0;
					while(rset.next())
					{
						dd=Double.parseDouble(rset.getString(1));
						if(dd > 4.0 && dd < 5.0)
						{
							s[f]=new String(rset.getString(2));
							f++;
						}
					}
				}
				else
				if(dur.equals("Five"))
				{
					semno=5;
					f=0;
					while(rset.next())
					{
						dd=Double.parseDouble(rset.getString(1));
						if(dd > 5.0 && dd < 6.0)
						{
							s[f]=new String(rset.getString(2));
							f++;
						}
					}
				}
				else
				if(dur.equals("Six"))
				{
					semno=6;
					f=0;
					while(rset.next())
					{
						dd=Double.parseDouble(rset.getString(1));
						if(dd > 6.0 && dd < 7.0)
						{
							s[f]=new String(rset.getString(2));
							f++;
						}
					}
				}
				else
				if(dur.equals("Seven"))
				{
					semno=7;
					f=0;
					while(rset.next())
					{
						dd=Double.parseDouble(rset.getString(1));
						if(dd > 7.0 && dd < 8.0)
						{
							s[f]=new String(rset.getString(2));
							f++;
						}
					}
				}
				else
				if(dur.equals("Eight"))
				{
					semno=8;
					f=0;
					while(rset.next())
					{
						dd=Double.parseDouble(rset.getString(1));
						if(dd > 8.0 && dd <9.0)
						{
							s[f]=new String(rset.getString(2));
							f++;
						}
					}
				}
				String sts[]=new String[f];
				for(int j=0;j<f;j++)
					sts[j]=new String(""+s[j]);

				PreparedStatement ps=conn.prepareStatement("Select * from "+cour+"_stud_info where appyear=? order by scode");
				ps.setString(1,appyear);
				ResultSet tableset=ps.executeQuery();
				row=0;

				while(tableset.next())
				{
					row++;
				}

				DefaultTableModel mdl=new DefaultTableModel(sts,row);
				marks.setModel(mdl);

				sts=new String[f];

				for(int j=0;j<f;j++)
					sts[j]=new String(s[j]);
				row=0;
				tableset=st.executeQuery("Select * from "+cour+"_stud_info where appyear='"+appyear+"' order by scode");
				while(tableset.next())
				{
					row++;
				}
				mdl=new DefaultTableModel(sts,row);

				PreparedStatement pst=conn.prepareStatement("select * from "+cour+"_marks"+semno+" where appyear=? order by scode");
				pst.setString(1,appyear);
				ResultSet reset=pst.executeQuery();

				ResultSetMetaData mt=reset.getMetaData();
				int col=mt.getColumnCount();
				i=0;
				while(reset.next())
				{
					for(int j=0;j<sts.length;j++)
					{
						String temp=reset.getString(j+3).trim();
						mdl.setValueAt(temp,i,j);
					}
					i++;
				}
				marks.setModel(mdl);
			}
			catch(Exception ex)
			{
			}

		}

	}
	class SaveHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			String str=e.getActionCommand();
			if(str.equals("Save"))
			{
				dlg=new SaveDialog();
				dlg.setVisible(true);
			}
			if(str.equals("Print"))
			{
				PrinterJob jb=PrinterJob.getPrinterJob();
				jb.printDialog();
			}
			if(str.equals("Cancle"))
			{
				dispose();
				new MainMenuFrame().setVisible(true);
			}
		}
	}
	class SaveDialog extends JDialog
	{
		JButton ok;
		JButton can;
		JLabel ls;
		SaveDialog()
		{
			super(StudentInternalReport.this,"Student Internal Report",true);
			setSize(250,150);
			setLocation(400,280);
			JPanel bp=new JPanel();
			bp.setBackground(new Color(255,197,68));
			ok=new JButton("  Ok  ");
			can=new JButton("Cancle");
			bp.add(ok);
			bp.add(can);
			add(bp,"South");
			JPanel lp=new JPanel();
			lp.add(new JLabel("<html><font size=4 color=#800080>Save Student's Internal Exam <br> Marks <br> </font></html>"));
			add(lp);
			SaveMarks s=new SaveMarks();
			ok.addActionListener(s);
			can.addActionListener(s);

		}
	}
	class SaveMarks implements ActionListener
	{

		String crs=(String)sem.getSelectedItem();
		String cour=(String)course.getSelectedItem();
		String dur=null;
		int subno;
		int marktable;
		SaveMarks()
		{
			if(crs.charAt(0) == 'S')
				dur=crs.substring(12).trim();
			if(crs.charAt(0) == 'Y')
				dur=crs.substring(7).trim();
		}
		public void actionPerformed(ActionEvent e)
		{
			String str=e.getActionCommand();
			if(str.equals("  Ok  "))
			{
				if(dur.equals("One"))
				{
					subno=100;
					marktable=1;
				}
				else
				if(dur.equals("Two"))
				{
					subno=200;
					marktable=2;
				}
				else
				if(dur.equals("Three"))
				{
					subno=300;
					marktable=3;
				}
				else
				if(dur.equals("Four"))
				{
					subno=400;
					marktable=4;
				}
				else
				if(dur.equals("Five"))
				{
					subno=500;
					marktable=5;
				}
				else
				if(dur.equals("Six"))
				{
					subno=600;
					marktable=6;
				}
				else
				if(dur.equals("Seven"))
				{
					subno=700;
					marktable=7;
				}
				else
				if(dur.equals("Eight"))
				{
					subno=800;
					marktable=8;
				}
				int length=marks.getColumnCount();
				int ro=marks.getRowCount();
				try
				{
					String sel="";
					String scode="";
					int subno2=0;
					int i=0;
					int j=0;
					conn=DriverManager.getConnection("jdbc:odbc:Student_Info","raj","17java71");
					st.close();
					PreparedStatement ps=null;
					String appyear=(String)appyrst.getSelectedItem()+"-"+(String)appyred.getSelectedItem();
					for(i=0;i<ro;i++)
					{
						scode=(String)studid.getValueAt(i,0);
						subno2=subno;

						for(j=0;j<length;j++)
						{
							sel=(String)marks.getValueAt(i,j);

							subno2++;
							ps=conn.prepareStatement("update "+cour+"_marks"+marktable+" set S"+subno2+"=? where scode=? ");
							int selint=0;
							while(true)
							{
								try
								{
									selint=Integer.parseInt(sel);
									break;
								}
								catch(NumberFormatException ne)
								{
									Icon error=new ImageIcon("error.png");
									JOptionPane.showMessageDialog(StudentInternalReport.this,"<html><font size=4 color=red>Please Enter Valid Marks</font></html>","Internal Marks",JOptionPane.ERROR_MESSAGE,error);
									break;
								}
							}
							ps.setInt(1,selint);
							ps.setString(2,scode);
							System.out.println("OK");
							ps.execute();
						}
						ps.close();
					}
					dlg.dispose();
				}
				catch(Exception es)
				{
				}

			}
			else
			{
				dlg.dispose();
			}
		}
	}
	class MarksSendHandler implements ActionListener
	{
		int i=0;
		int j=0;
		String scode;
		String sel;
		public void actionPerformed(ActionEvent e)
		{
			Icon warning=new ImageIcon("warning.png");
			Icon question=new ImageIcon("question.png");
			Icon info=new ImageIcon("info.png");
			int ans=JOptionPane.showConfirmDialog(null,"Are you sure you want to Send Message?","Send",JOptionPane.YES_NO_OPTION,1,question);

			if(ans==JOptionPane.YES_OPTION)
			{
				try
				{
					int length=marks.getColumnCount();
					int ro=marks.getRowCount();
					String appyear=(String)appyrst.getSelectedItem()+"-"+(String)appyred.getSelectedItem();
					String sm=(String)sem.getSelectedItem();
					String cors=(String)course.getSelectedItem();
					conn=DriverManager.getConnection("jdbc:odbc:Student_Info","raj","17java71");
					st=conn.createStatement();
					ResultSet set=st.executeQuery("select mobno from "+cors+"_stud_info where appyear='"+appyear+"' " );
					String message1="Internal Exam Marks \n";
					message1=message1+sm+"\n";
					String message;
					set.next();
					for(i=0;i<ro;i++)
					{
						String mobileno=set.getString(1).trim();
						scode=(String)studid.getValueAt(i,0);
						message=scode+"\n";
						for(j=0;j<length;j++)
						{
							sel=(String)marks.getValueAt(i,j);
							message=message+marks.getColumnName(j)+" : "+sel+"\n";
						}
						message1=message1+message;
						System.out.println(message1);


						//send message on mbile
						SMSClient c=new SMSClient(1);
						c.sendMessage(mobileno,message1);

						//Construct New Message
						message1="Internal Exam Marks \n";
						message1=message1+sm+"\n";
						message="";

						System.out.println(mobileno);
						set.next();
						try
						{
							Thread.sleep(5000);
						}
						catch(Exception exc)
						{
						}
					}
					JOptionPane.showMessageDialog(null,"Message Send Successfully","Send",JOptionPane.INFORMATION_MESSAGE,info);
				}
				catch(Exception es)
				{
				}
			}
			if(ans==JOptionPane.NO_OPTION)
			{
				JOptionPane.showMessageDialog(null,"Sending Message Failed","Disacard",JOptionPane.WARNING_MESSAGE,warning);
			}

		}
	}


}