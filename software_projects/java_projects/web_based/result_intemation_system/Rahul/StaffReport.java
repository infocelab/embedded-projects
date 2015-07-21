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
class StaffReport extends JFrame
{
	JPanel main=new JPanel();
	Container c;
	JTable table;
	Connection conn;
	JButton print;
	JButton cancle;
	int row=0;
	int i=0;
	StaffReport()
	{
		setSize(620,520);
		setTitle("Staff Information");
		setLocation(240,80);
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				dispose();
			}
		});
		c=getContentPane();
		StaffReport.setDefaultLookAndFeelDecorated(true);
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("mainicon.png"));

		main.setLayout(new BorderLayout());
		main.setBackground(new Color(245,240,255));
		JLabel l=new JLabel("<html><font size=6 color=#800080><i>Staff Information");
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
		JPanel butpan=new JPanel();
		butpan.add(print);
		butpan.add(cancle);
		butpan.setBackground(new Color(255,197,68));
		c.add("South",butpan);
		print.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				PrinterJob jb=PrinterJob.getPrinterJob();
				jb.printDialog();
			}
		});
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			conn=DriverManager.getConnection("jdbc:odbc:Teacher_Info","raj","17java71");
			PreparedStatement ps=conn.prepareStatement("select * from FacultyInfo ");
			ResultSet tableset=ps.executeQuery();
				while(tableset.next())
				{
					row++;
				}
				DefaultTableModel model=new DefaultTableModel(new String[]{"FCode","Name","Date Of Joining","Contact No"},row);
				tableset=ps.executeQuery();
				while(tableset.next())
				{

					model.setValueAt(tableset.getString(1).trim(),i,0);
					String str=tableset.getString(2).trim();
					str=str+" "+tableset.getString(4).trim();
					model.setValueAt(str.trim(),i,1);
					model.setValueAt(tableset.getString(7).trim(),i,2);
					model.setValueAt(tableset.getString(8).trim(),i,3);
					i++;
				}
				table=new JTable(model);
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

	}

}