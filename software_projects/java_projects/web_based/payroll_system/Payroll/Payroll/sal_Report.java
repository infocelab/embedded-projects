import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;
import java.sql.*;
import javax.swing.border.*;

class sal_Report extends JInternalFrame implements ActionListener
{
	int x,y;
	sal_Report()
	{
		super("SALARY REPORT",true,true,true,true);
		setSize(Payroll.x,Payroll.y-35);
		Container c= getContentPane();
		c.setLayout(new BorderLayout());

		search=new JButton("Search");
		search.setMnemonic('S');
		search.addActionListener(this);
		search.setBackground(Color.DARK_GRAY);
		search.setForeground(new Color(80,105,255));

		idCB=new JComboBox ();
		idCB.setBackground(Color.DARK_GRAY);
		idCB.setForeground(Color.white);

		monCB=new JComboBox (Months);
		monCB.setBackground(Color.DARK_GRAY);
		monCB.setForeground(Color.white);

		yerCB=new JComboBox ();
		yerCB.setBackground(Color.DARK_GRAY);
		yerCB.setForeground(Color.white);

		for(int i=2008;i<=2050;i++)
		{
			yerCB.addItem(""+i);
		}

		north=new JPanel();
		north.setLayout(new GridLayout(1,7,25,25));
		north.add(new JLabel("Select ID"));
		north.add(idCB);
		north.add(new JLabel("Select Month"));
		north.add(monCB);
		north.add(new JLabel("Select Year"));
		north.add(yerCB);
		north.add(search);
		north.setBackground(Color.white);
		add(north,"North");


		south=new JPanel();
		south.setBorder(BorderFactory.createRaisedBevelBorder());
		none=new JButton(" None ");
		none.setMnemonic('N');
		none.addActionListener(this);

		exitt=new JButton(" Exit ");
		exitt.addActionListener(this);
		exitt.setForeground(Color.red);
		exitt.setBackground(Color.gray);
		exitt.setMnemonic('X');
		south.add(none);
		south.add(exitt);
		add(south,"South");

		try
		{
			clsConnection connect=new clsConnection();
			conn = connect.setConnection(conn,"","");
			showResult("select * from salary");

			st=conn.createStatement();
			rs=st.executeQuery("select emp_Id from Emp_Master order by emp_Id asc");
			while(rs.next())
			{
				idCB.addItem(rs.getString(1));
			}

		}
		catch(Exception er)
		{
			System.out.println(""+er);
		}

		jTable = makeTable ();
		jTable.setBorder(new LineBorder(Color.LIGHT_GRAY,3));
		scroller = new JScrollPane (jTable);
		add(scroller);
	}
	public void actionPerformed(ActionEvent e)
	{
		Object obj=e.getSource();
		if(obj==search)
		{

			String id=""+idCB.getSelectedItem();
			String mon=""+monCB.getSelectedItem();
			String yea=""+yerCB.getSelectedItem();

			showResult("select * from salary where emp_Id='"+id+"'AND month ='"+mon+"'AND year ='"+yea+"' ");
			scroller.getViewport().remove (jTable);
			scroller.getViewport().add (makeTable ());
			repaint();

		}
		if(obj==exitt)
		{
			setVisible(false);
		}
		if(obj==none)
		{
			showResult("select * from salary ");//where emp_Id='"+id+"'AND month ='"+mon+"'AND year ='"+yea+"' ");
			scroller.getViewport().remove (jTable);
			scroller.getViewport().add (makeTable ());
			repaint();

		}
	}
	public JTable makeTable ()
	{
		String colsName[] = {"Month","Year","ID","Name","Dept","Pday","Bpay","Bamt","DA","OA","HRA","OT","TotGross","Mdi",
		"PF","Ded","Adv","Kan","TotDed","TotSal"};

		jTable = new JTable (rowRec, colsName)
		{
			public boolean isCellEditable (int iRows, int iCols)
			{
				return false;
			}
		};
		jTable.setRowHeight (25);
		jTable.setCellSelectionEnabled(true);
		jTable .setBackground(Color.DARK_GRAY);
		jTable .setForeground(Color.white);
		jTable.clearSelection();
		return jTable;
	}
	public void showResult(String q)
	{
		rec = 0;
		total = 0;
		try
		{

			String records[][] = new String [15000][20];

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

				rec++;
			}
			total = rec;

				rowRec = new String [total][20];
				for (int i = 0; i < total; i++)
				{
					for (int j = 0; j <=19; j++)
					{
						rowRec[i][j] = 	records[i][j];
					}
				}

		}
		catch (Exception sqlEx)
		{
			JOptionPane.showMessageDialog (null, ""+sqlEx);
		}
	}

	private JTable jTable;
	private JScrollPane  scroller;
	private String Months[] = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul",	"Aug", "Sep", "Oct", "Nov", "Dec"};
	private JButton search;
	private JPanel north ,south;
	private JComboBox idCB,monCB,yerCB;
	private JButton none,exitt;
	private int rec = 0;
	private int total = 0;
	private String rowRec[][];
	private static Connection conn;
	private static Statement st;
	private static ResultSet rs,rs1;
}
