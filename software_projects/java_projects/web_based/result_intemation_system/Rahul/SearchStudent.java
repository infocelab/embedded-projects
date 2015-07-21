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
class SearchStudent extends JFrame
{
	JPanel main=new JPanel();
	Container c=getContentPane();
	private JTable table;
	Connection conn;
	Connection conn2;
	Statement st;
	JButton ok;
	DefaultTableModel model;
	SearchStudent(String fname,String lname)
	{
		setSize(620,520);
		setTitle("Search Result");
		setLocation(240,80);
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				dispose();
			}
		});
		try
		{
			setAlwaysOnTop(true);
		}
		catch(Exception es){}
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("mainicon.png"));

		main.setLayout(new BorderLayout());
		main.setBackground(new Color(245,240,255));
		JLabel l=new JLabel("<html><font size=6 color=#800080><i>Search Result");
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
		ok=new JButton("Ok");
		ok.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				dispose();
			}
		});
		ok.setToolTipText("Ok");
		JPanel butpan=new JPanel();
		butpan.add(ok);
		butpan.setBackground(new Color(255,197,68));
		c.add("South",butpan);
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			conn=DriverManager.getConnection("jdbc:odbc:Student_Info","raj","17java71");
			st=conn.createStatement();
			ResultSet set=st.executeQuery("select * from course_name");
			int row=0;
			int i=0;

			PreparedStatement prs=null;
			while(set.next())
			{
				prs=conn.prepareStatement("select * from "+set.getString(2).trim()+"_stud_info where sname=? and lname=? ");
				prs.setString(1,fname);
				prs.setString(2,lname);
				ResultSet ss=prs.executeQuery();
				while(ss.next())
				{
					row++;
				}

			}
			set.close();

			// Display search Result On Table
			model=new DefaultTableModel(new String[]{"Scode","Name","Course","Date Of Joining","Mobile No"},row);
			set=st.executeQuery("select * from course_name");
			while(set.next())
			{

				String crname=set.getString(2).trim();
				prs=conn.prepareStatement("select * from "+crname+"_stud_info where sname=? and lname=? ");
				prs.setString(1,fname);
				prs.setString(2,lname);
				ResultSet ss=prs.executeQuery();
				while(ss.next())
				{

					model.setValueAt(ss.getString(1).trim(),i,0);
					String str=ss.getString(2).trim();
					str=str+" "+ss.getString(4).trim();
					model.setValueAt(str,i,1);
					model.setValueAt(crname.trim(),i,2);
					model.setValueAt(ss.getString(6).trim(),i,3);
					model.setValueAt(ss.getString(7).trim(),i,4);
					i++;
				}
			}
		}
		catch(Exception ex)
		{

		}
		table=new JTable(model);
		JScrollPane sp=new JScrollPane(table);
		main.add(sp);
		table.setSelectionMode(0);
		table.setFont(new Font("Times New Roman",Font.PLAIN,13));
		table.setForeground(Color.white);
		table.setGridColor(new Color(0,128,192));
	  	table.setBackground(new Color(0,128,192));
        table.getTableHeader().setReorderingAllowed(false);
        c.add(main);
	}

}