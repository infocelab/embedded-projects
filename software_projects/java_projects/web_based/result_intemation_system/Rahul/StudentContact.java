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
class StudentContact extends JFrame
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
	StudentContact()
	{
		setSize(620,520);
		setTitle("Student Contact Number");
		setLocation(240,80);
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				dispose();
			}
		});
		StudentContact.setDefaultLookAndFeelDecorated(true);
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("mainicon.png"));
		c=getContentPane();

		main.setLayout(new BorderLayout());
		main.setBackground(new Color(245,240,255));
		JLabel l=new JLabel("<html><font size=6 color=#800080><i>Student Contact Number");
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
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			conn=DriverManager.getConnection("jdbc:odbc:Student_Info","raj","17java71");
			st=conn.createStatement();
			ResultSet set=st.executeQuery("select * from course_name");
			ResultSet tableset;
			int row=0;
			int i=0;
			while(set.next())
			{
				courselist.addItem(set.getString(2));
			}
			String cours=(String)courselist.getSelectedItem();

			if(cours!=null)
			{

				PreparedStatement ps=conn.prepareStatement("select * from "+cours+"_stud_info ");
				tableset=ps.executeQuery();
				while(tableset.next())
				{
					row++;
				}
				DefaultTableModel model=new DefaultTableModel(new String[]{"SCode","Name","Last Name","Contact Number"},row);
				table=new JTable(model);
				tableset=ps.executeQuery();
				while(tableset.next())
				{

					model.setValueAt(tableset.getString(1).trim(),i,0);
					model.setValueAt(tableset.getString(2).trim(),i,1);
					model.setValueAt(tableset.getString(4).trim(),i,2);
					model.setValueAt(tableset.getString(7).trim(),i,3);
					i++;
				}
				table=new JTable(model);
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

	}
	class CourseHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			try
			{
				ResultSet tableset;
				int row=0;
				int i=0;
				String cours=(String)courselist.getSelectedItem();

				if(cours!=null)
				{

					PreparedStatement ps=conn.prepareStatement("select * from "+cours+"_stud_info ");
					tableset=ps.executeQuery();
					while(tableset.next())
					{
						row++;
					}
					DefaultTableModel model=new DefaultTableModel(new String[]{"SCode","Name","Last Name","Contact Number"},row);
					tableset=ps.executeQuery();
					while(tableset.next())
					{

						model.setValueAt(tableset.getString(1).trim(),i,0);
						model.setValueAt(tableset.getString(2).trim(),i,1);
						model.setValueAt(tableset.getString(4).trim(),i,2);
						model.setValueAt(tableset.getString(7).trim(),i,3);
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