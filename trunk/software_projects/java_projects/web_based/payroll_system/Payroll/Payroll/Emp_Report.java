import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.io.*;

import java.util.*;
import java.text.*;
import java.lang.String;
import java.awt.print.*;
import java.awt.PrintJob.*;		//For Printing the Records.


class Emp_Report extends JInternalFrame
{
	JTable table;
	Emp_Report()
	{
		super("Employee Report",true,true,true,true);
		Dimension dim =Toolkit.getDefaultToolkit().getScreenSize();
		int x=dim.width;
		int y=dim.height;
		setSize(x,y-30);

		JPanel north=new JPanel();
		north.setLayout(new GridLayout(1,6,25,25));
		empId_CB=new JComboBox();
		empDept_CB=new JComboBox();
		empCat_CB=new JComboBox(category);
		north.add(new JLabel("Select the EMP_Id"));
		north.add(empId_CB);
		north.add(new JLabel("Select the EMP_DEPT"));
		north.add(empDept_CB);
		north.add(new JLabel("Select the EMP_CATE"));
		north.add(empCat_CB);
		add(north,"North");


		try
		{
			clsConnection connect=new clsConnection();
			conn = connect.setConnection(conn,"","");
			showResult("SELECT * FROM Emp_Master ORDER BY emp_Id");

			st=conn.createStatement();
			rs=st.executeQuery("SELECT * FROM Emp_Master ORDER BY emp_Id");
			while(rs.next())
			{
				empId_CB.addItem(""+rs.getString(1));
			}
			rs.close();
			st.close();

			st=conn.createStatement();
			rs=st.executeQuery("SELECT * FROM Dep_Master ORDER BY dept_Name");
			while(rs.next())
			{
				empDept_CB.addItem(""+rs.getString(2));
			}

		}
		catch(Exception er){}
		table=makeTable ();
		scroll=new JScrollPane(table);
		add(scroll);

		printPriew=new JButton("<html><body><font size='4'><b>&nbsp;&nbsp;PrintPreview &nbsp;&nbsp;</b></font></body></html>");
		printPriew.setMnemonic('P');
		exitBut=new JButton("<html><body><font size='4'><b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Exit &nbsp; &nbsp;&nbsp;&nbsp;&nbsp;</b></font></body></html>");
		exitBut.setMnemonic('X');
		none=new JButton("<html><body><font size='4'><b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;None &nbsp; &nbsp;&nbsp;&nbsp;&nbsp;</b></font></body></html>");
		none.setMnemonic('N');

		JPanel south=new JPanel();
		south.setLayout(new BorderLayout());
		south.setBorder(BorderFactory.createRaisedBevelBorder());
		south.add(printPriew);
		south.add(exitBut,"East");
		south.add(none,"West");
		add(south,"South");

		printPriew.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				queryStr=JOptionPane.showInputDialog(null,"Enter the employee ID");
				Emp_Print ep=new Emp_Print();
				ep.setVisible(true);
				textArea.setText("\t\tEmployee Service Record\t\t\n");
				textArea.append("     ----------------------------------------------------------------------------------------------------------------------------\n");
				try
				{
					st=conn.createStatement();
					rs=st.executeQuery("Select * from Emp_Master Order by emp_Id='"+queryStr+"'");

					rs.next();{
					textArea.append(
					"\n\tEmployee ID -:     \t" + rs.getString(1) + "\n\n" +
					"\tEmployee Grade -:    \t"+rs.getString(2 )+ "\n\n" +
					"\tEmployee Name -:     \t"+rs.getString(3) + "\n\n" +
					"\tEmployee Address -:  \t"+rs.getString(4)+"\n\n" +
					"\tEmployee Catogary -: \t"+rs.getString(5)+"\n\n" +
					"\tEmployee Department-:\t"+rs.getString(6)+"\n\n" +
					"\tEmployee Sex -:      \t"+rs.getString(7)+"\n\n" +
					"\tEmployee Birth Date-:\t"+rs.getString(8) + "\n\n" +
					"\tEmployee Birth Date-:\t"+rs.getString(9)+"\n\n" +
					"\tEmployee City -:     \t"+rs.getString(10)+"\n\n" +
					"\tEmployee Pincode-:   \t"+rs.getString(11)+"\n\n" +
					"\tEmployee Phone No -: \t"+rs.getString(12)+"\n\n" +
					"\tEmployee Mobile-:    \t"+rs.getString(13)+"\n\n" +
					"\tEmployee Qulification-:\t"+rs.getString(14)+"\n\n" +
					"\tEmployee Bank AC-:   \t"+rs.getString(15)+"\n\n" +
					"\tEmployee PF. No -:   \t"+rs.getString(16));

					//painting(rs.getString(17));pictuLabel.repaint();*/
				}
				}
				catch(Exception er)
				{
				}

			}
		});
		exitBut.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				dispose();
				Payroll.diskPane.requestFocus();
			}
		});
		none.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				showResult("SELECT * FROM Emp_Master order by emp_Id asc ");
				scroll.getViewport().remove (table);
				scroll.getViewport().add (makeTable ());
				repaint();
			}
		});

		empId_CB.addItemListener(new ItemListener()
		{
			public void itemStateChanged(ItemEvent e)
			{
				showResult("SELECT * FROM Emp_Master where emp_Id ='"+(String)empId_CB.getSelectedItem()+"'");
				scroll.getViewport().remove (table);
				scroll.getViewport().add (makeTable ());
				repaint();
			}
		});
		empDept_CB.addItemListener(new ItemListener()
		{
			public void itemStateChanged(ItemEvent e)
			{
				showResult("SELECT * FROM Emp_Master where dept_Name ='"+(String)empDept_CB.getSelectedItem()+"'");
				scroll.getViewport().remove (table);
				scroll.getViewport().add (makeTable ());
				repaint();
			}
		});
		empCat_CB.addItemListener(new ItemListener()
		{
			public void itemStateChanged(ItemEvent e)
			{
				showResult("SELECT * FROM Emp_Master where categary ='"+(String)empCat_CB.getSelectedItem()+"'");
				scroll.getViewport().remove (table);
				scroll.getViewport().add (makeTable ());
				repaint();
			}
		});
	}
	class Emp_Print extends JFrame implements ActionListener
	{
		Emp_Print()
		{

			setTitle("PrintPreview");
			Dimension dim =Toolkit.getDefaultToolkit().getScreenSize();
			int x=dim.width;
			int y=dim.height;
			setSize(x/2,y-75);
			setLocation(x/4,30);

			textArea=new JTextArea(45,25);
			textArea.setEditable(false);
			textArea.setFont(new Font("Monospaced",Font.PLAIN,10));
			JScrollPane sp=new JScrollPane(textArea);
			add(sp);

			printBut=new JButton("Print");
			exitBut=new JButton("Exit");
			pane.add(printBut);
			pane.add(exitBut);
			pane.setBorder(BorderFactory.createRaisedBevelBorder());
			pane.setBackground(Color.gray);
			add(pane,"South");

			exitBut.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					dispose();
				}
			});

			printBut.addActionListener(this);


		}
		public void actionPerformed(ActionEvent e)
		{

			if(e.getSource()==printBut)
			{
				try
				{
					String s=textArea.getText();
					//printRecord (s);

				}
				catch(Exception er)
				{
					JOptionPane.showMessageDialog(null,""+er);
				}
			}
		}
		void printRecord (String rec)
		{
			StringReader sr = new StringReader (rec);
			LineNumberReader lnr = new LineNumberReader (sr);
			Font typeface = new Font ("Times New Roman", Font.PLAIN, 12);
			Properties p = new Properties ();
			PrintJob pJob = getToolkit().getPrintJob (this, "Print Customer Balance Report", p);

			if (pJob != null)
			{
				Graphics gr = pJob.getGraphics ();
				if (gr != null)
				{
					FontMetrics fm = gr.getFontMetrics (typeface);
					int margin = 20;
					int pageHeight = pJob.getPageDimension().height - margin;
					int fontHeight = fm.getHeight();
					int fontDescent = fm.getDescent();
					int curHeight = margin;
					String nextLine;
					gr.setFont (typeface);

					try
					{
						do
						{
							nextLine = lnr.readLine ();
							if (nextLine != null)
							{
								if ((curHeight + fontHeight) > pageHeight)
								{	//New Page.
									gr.dispose();
									gr = pJob.getGraphics ();
									curHeight = margin;
								}
								curHeight += fontHeight;
								if (gr != null)
								{
									gr.setFont (typeface);
									gr.drawString (nextLine, margin, curHeight - fontDescent);
								}
							}
						}
						while (nextLine != null);
					}
					catch (EOFException eof) { }
					catch (Throwable t) { }
				}
				gr.dispose();
			}
			if (pJob != null)
			pJob.end ();
		}
		private JButton printBut,exitBut;
		private JPanel pane=new JPanel();
	}

	private JTable makeTable ()
	{
		String colsName[]={"Empl_Id","Grade","Emp_Name","Address","Catagory","Depart","Sex","BDate","JDate",
							"City","Pincode","Ph.No","Mob.No.","Qulification","Bank A/c","PF. No","img"};

		table = new JTable (rowRec, colsName)
		{
			public boolean isCellEditable (int iRows, int iCols)
			{
				return false;
			}
		};

		table.setRowHeight (25);
		table.setCellSelectionEnabled(true);
		table.clearSelection();
		table.setBackground(Color.DARK_GRAY);
		table.setForeground(Color.white);
		table.setFont(new Font("Aria",Font.BOLD,12));
		return table;
	}
	public void showResult(String q)
	{
		rec = 0;
		total = 0;
		try
		{

			String records[][] = new String [5000][17];

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

				rec++;
			}
			total = rec;
			{
				rowRec = new String [total][17];
				for (int i = 0; i < total; i++)
				{
					for (int j = 0; j <=16; j++)
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

	private Connection conn;
	JScrollPane scroll;
	private JComboBox empId_CB,empDept_CB,empCat_CB;
	private String category[]={"Genral","OBC","NT","VJNT","NT-A","NT-B","NT-C","SC","ST",};
	private ResultSet rs;
	private Statement st;
	private JButton printPriew,exitBut,none;
	private JTextArea textArea;
	private String queryStr;
	private int rec = 0;
	private int total = 0;
	private String rowRec[][];
}