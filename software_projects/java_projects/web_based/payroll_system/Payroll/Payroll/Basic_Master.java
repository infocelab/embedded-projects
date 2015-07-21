import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;
import java.sql.*;
import javax.swing.border.*;

class Basic_Master extends JInternalFrame implements ActionListener
{
	int x,y;
	Basic_Master()
	{
		super("Attendance Master ",true,true,true,true);
		setSize(Payroll.x,Payroll.y-35);
		Container c= getContentPane();
		c.setLayout(new BorderLayout());

		emp_ID=new JComboBox();
		emp_ID.setBackground(Color.gray);
		emp_ID.setForeground(Color.white);

		mouth=new JComboBox(Months);
		mouth.setBackground(Color.gray);
		mouth.setForeground(Color.white);

		year=new JComboBox();
		year.setBackground(Color.gray);
		year.setForeground(Color.white);

		go=new JButton("Search Report");
		go.setMnemonic('S');
		go.addActionListener(this);
		go.setBackground(Color.gray);
		go.setForeground(Color.green);

		try
		{
			clsConnection connect=new clsConnection();
			conn = connect.setConnection(conn,"","");
			showResult("select * from att_Detail order by emp_Id asc");

			st=conn.createStatement();
			rs=st.executeQuery("select emp_Id from Emp_Master order by emp_Id asc");
			while(rs.next())
			{
				emp_ID.addItem(rs.getString(1));
			}

		}
		catch(Exception er)
		{
			System.out.println(""+er);
		}

		north=new JPanel();
		north.setBorder(BorderFactory.createRaisedBevelBorder());
		north.setLayout(new GridLayout(1,6,25,25));
		//north.setBackground(Color.gray);
		north.add(new JLabel("Select Emp_ID"));
		north.add(emp_ID);
		north.add(new JLabel("Select Month"));
		north.add(mouth);
		north.add(new JLabel("Select Year"));
		north.add(year);
		north.add(go);
		c.add(north,"North");



		south=new JPanel();
		south.setLayout(new BorderLayout());
		south.setBorder(BorderFactory.createRaisedBevelBorder());

		none=new JButton(" None ");
		none.setMnemonic('N');
		none.addActionListener(this);

		slary=new JButton("Salary");
		slary.setMnemonic('P');
		slary.addActionListener(this);

		search=new JButton("Search");
		search.addActionListener(this);

		exitt=new JButton(" Exit ");
		exitt.setMnemonic('X');
		exitt.addActionListener(this);
		exitt.setForeground(Color.red);
		exitt.setBackground(Color.gray);
		JPanel east=new JPanel();

		east.add(slary);
		//east.add(search);
		south.add(east);
		south.add(none,"West");
		south.add(exitt,"East");
		c.add(south,"South");

		table = makeTable ();
		table.setBorder(new LineBorder(Color.LIGHT_GRAY,3));
		scroller = new JScrollPane (table);
		add(scroller);


		for(int i=2008;i<=2050;i++)
		{
			year.addItem(""+i);
		}
	}
	public void actionPerformed(ActionEvent e)
	{
		Object obj=e.getSource();

		if(obj==go)
		{
			String id=""+emp_ID.getSelectedItem();
			String mon=""+mouth.getSelectedItem();
			String yea=""+year.getSelectedItem();

			showResult("select * from att_Detail where emp_Id ='"+id+"'AND month ='"+mon+"'AND year ='"+yea+"' ");
			scroller.getViewport().remove (table);
			scroller.getViewport().add (makeTable ());
			repaint();
		}
		else if(obj==none)
		{
			showResult("select * from att_Detail");
			scroller.getViewport().remove (table);
			scroller.getViewport().add (makeTable ());
			repaint();
		}
		else if(obj==exitt)
		{
			dispose();
		}
		else if(obj==slary)
		{
			Salary salary=new Salary();
			Payroll.diskPane.add(salary);
			salary.setVisible(true);
		}
	}
	private JTable makeTable ()
	{
		String colsName[] = {"Emp_ID","Name","Month","Year","1","2","3","4","5","6","7","8","9","10",
		"11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31","P"};

		table = new JTable (rowRec, colsName)
		{
			public boolean isCellEditable (int iRows, int iCols)
			{
				return false;
			}
		};

		table.setRowHeight (25);
		table.setCellSelectionEnabled(true);
		table .setBackground(Color.gray);
		table .setForeground(Color.white);
		table.clearSelection();
		return table;
	}
	public void showResult(String q)
	{
		rec = 0;
		total = 0;
		try
		{

			String records[][] = new String [5000][36];

			st=conn.createStatement();
			rs = st.executeQuery (q);

			while (rs.next ())
			{
				records[rec][0] = ""+rs.getString (1);
				records[rec][1] = ""+rs.getString (2);
				records[rec][2] = ""+rs.getString (3);
				records[rec][3] = ""+rs.getString (4);
				records[rec][4] = ""+rs.getString (5);
				records[rec][5] = ""+rs.getString (6);
				records[rec][6] = ""+rs.getString (7);
				records[rec][7] = ""+rs.getString (8);
				records[rec][8] = ""+rs.getString (9);
				records[rec][9] = ""+rs.getString (10);
				records[rec][10] = ""+rs.getString (11);
				records[rec][11] = ""+rs.getString (12);
				records[rec][12] = ""+rs.getString (13);
				records[rec][13] = ""+rs.getString (14);
				records[rec][14] = ""+rs.getString (15);
				records[rec][15] = ""+rs.getString (16);
				records[rec][16] = ""+rs.getString (17);
				records[rec][17] = ""+rs.getString (18);
				records[rec][18] = ""+rs.getString (19);
				records[rec][19] = ""+rs.getString (20);
				records[rec][20] = ""+rs.getString (21);
				records[rec][21] = ""+rs.getString (22);
				records[rec][22] = ""+rs.getString (23);
				records[rec][23] = ""+rs.getString (24);
				records[rec][24] = ""+rs.getString (25);
				records[rec][25] = ""+rs.getString (26);
				records[rec][26] = ""+rs.getString (27);
				records[rec][27] = ""+rs.getString (28);
				records[rec][28] = ""+rs.getString (29);
				records[rec][29] = ""+rs.getString (30);
				records[rec][30] = ""+rs.getString (31);
				records[rec][31] = ""+rs.getString (32);
				records[rec][32] = ""+rs.getString (33);
				records[rec][33] = ""+rs.getString (34);
				records[rec][34] = ""+rs.getString (35);
				records[rec][35] = ""+rs.getString (36);
				rec++;
			}
			total = rec;
			{
				rowRec = new String [total][36];
				for (int i = 0; i < total; i++)
				{
					for (int j = 0; j <=35; j++)
					{
						rowRec[i][j] = 	records[i][j];
					}
				}
			}
		}
		catch (Exception sqlEx)
		{
			JOptionPane.showMessageDialog (null, ""+sqlEx);
		}
	}
	private JPanel north,south;
	private JComboBox emp_ID,mouth,year;
	private JTable table ;
	private JScrollPane scroller ;
	private int rec = 0;
	private int total = 0;
	private String rowRec[][];
	private String Months[] = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul",	"Aug", "Sep", "Oct", "Nov", "Dec"};
	private JButton go,slary,none,exitt,search;
	private Connection conn;
	private Statement st;
	private ResultSet rs,rs1;

}
