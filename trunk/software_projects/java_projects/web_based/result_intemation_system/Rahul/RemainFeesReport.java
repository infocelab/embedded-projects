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
import java.awt.print.*;
class RemainFeesReport extends JFrame
{
	JPanel main=new JPanel();
	Container c=getContentPane();
	private JTable table;
	Connection conn;
	Statement st;
	JComboBox cmb;
	JButton print;
	JButton cancle;
	private JComboBox courselist;
	private JComboBox appyrst;
	private JComboBox appyred;
	RemainFeesReport()
	{
		setSize(620,520);
		setTitle("Student Information");
		setLocation(240,80);
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				dispose();
			}
		});
		StudentByCourseReport.setDefaultLookAndFeelDecorated(true);
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("mainicon.png"));
		c=getContentPane();

		main.setLayout(new BorderLayout());
		main.setBackground(new Color(245,240,255));
		JLabel l=new JLabel("<html><font size=6 color=#800080><i>Remaining Fees Details");
		JPanel title=new JPanel()
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
				g.drawImage(img,0,0,620,50,null);
			}
		};
		title.add(l);
		main.add("North",title);
		Icon prt=new ImageIcon("PRINT.png");
		print=new JButton("Print",prt);
		print.setToolTipText("Print");
		cancle=new JButton("Exit");
		cancle.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				dispose();
			}
		});
		print.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				PrinterJob jb=PrinterJob.getPrinterJob();
				jb.printDialog();
			}
		});
		cancle.setToolTipText("Exit");
		courselist=new JComboBox();
		courselist.setMaximumRowCount(5);
		courselist.setToolTipText("Select Course");
		JPanel butpan=new JPanel();
		butpan.add(print);
		butpan.add(cancle);
		butpan.add(courselist);
		butpan.setBackground(new Color(255,197,68));
		c.add("South",butpan);
		appyrst=new JComboBox();
		appyrst.setToolTipText("Select apperaed year");
		appyrst.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
		appyred=new JComboBox();
		appyred.setToolTipText("Select apperaed year");
		appyred.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
		butpan.add(appyrst);
		butpan.add(appyred);
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			conn=DriverManager.getConnection("jdbc:odbc:Student_Info","raj","17java71");
			st=conn.createStatement();
			ResultSet set=st.executeQuery("select * from course_name");
			ResultSet tableset;
			while(set.next())
			{
				courselist.addItem(set.getString(2));
			}
			String cours=(String)courselist.getSelectedItem();
			for(int y=1950;y<2100;y++)
			{
				appyrst.addItem(Integer.toString(y));
			}
			appyrst.setSelectedItem("2007");
			int row=0;
			int i=0;
			if(cours!=null)
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
						if(cr.equals(cours))
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
				catch(Exception ec)
				{
				}
			}
			if(cours!=null)
			{
				String appyear=(String)appyrst.getSelectedItem()+"-"+(String)appyred.getSelectedItem();
				PreparedStatement ps=conn.prepareStatement("select * from "+cours+"_stud_info where appyear=?");
				ps.setString(1,appyear);
				tableset=ps.executeQuery();
				while(tableset.next())
				{
					row++;
				}
				DefaultTableModel model=new DefaultTableModel(new String[]{"SCode","Name","Total Fees","Paid Fees","Additional Fees","Remaining Fees"},row);
				table=new JTable(model);
				ps.setString(1,appyear);
				tableset=ps.executeQuery();
				while(tableset.next())
				{

					model.setValueAt(tableset.getString(1).trim(),i,0);
					String str=tableset.getString(2).trim();
					str=str+" "+tableset.getString(4).trim();
					model.setValueAt(str,i,1);
					model.setValueAt(tableset.getString(8).trim(),i,2);
					model.setValueAt(tableset.getString(9).trim(),i,3);
					model.setValueAt(tableset.getString(10).trim(),i,4);
					model.setValueAt(tableset.getString(11).trim(),i,5);
					i++;
				}
			}
		}
		catch(Exception ex)
		{
		}
		JScrollPane sp=new JScrollPane(table);
		main.add(sp);
		table.setSelectionMode(0);
		table.setFont(new Font("Times New Roman",Font.PLAIN,13));
		table.setForeground(Color.white);
		table.setGridColor(new Color(0,128,192));
	  	table.setBackground(new Color(0,128,192));
        table.getTableHeader().setReorderingAllowed(false);
        c.add(main);
        courselist.addActionListener(new CourseHandler());
        appyrst.addActionListener(new CourseHandler());

	}
	class CourseHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			try
			{
				appyred.removeAllItems();
				int row=0;
				int i=0;
				ResultSet set;
				ResultSet tableset;
				String cours=(String)courselist.getSelectedItem();
				if(cours!=null)
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
							if(cr.equals(cours))
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
					catch(Exception ec)
					{
					}
				}
				if(cours!=null)
				{
					String appyear=(String)appyrst.getSelectedItem()+"-"+(String)appyred.getSelectedItem();
					PreparedStatement ps=conn.prepareStatement("select * from "+cours+"_stud_info where appyear=?");
					ps.setString(1,appyear);
					tableset=ps.executeQuery();
					while(tableset.next())
					{
						row++;
					}
					DefaultTableModel model=new DefaultTableModel(new String[]{"SCode","Name","Total Fees","Paid Fees","Additional Fees","Remaining Fees"},row);

					ps.setString(1,appyear);
					tableset=ps.executeQuery();
					while(tableset.next())
					{

						model.setValueAt(tableset.getString(1).trim(),i,0);
						String str=tableset.getString(2).trim();
						str=str+" "+tableset.getString(4).trim();
						model.setValueAt(str,i,1);
						model.setValueAt(tableset.getString(8).trim(),i,2);
						model.setValueAt(tableset.getString(9).trim(),i,3);
						model.setValueAt(tableset.getString(10).trim(),i,4);
						model.setValueAt(tableset.getString(11).trim(),i,5);
						i++;
					}
					table.setModel(model);
				}
			}
			catch(Exception ex)
			{
			}
		}
	}
}