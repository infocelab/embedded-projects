import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;
import javax.swing.border.*;
import java.sql.*;

class Department extends JInternalFrame implements ActionListener
{
	Department()
	{
		super("Department",true,true,true,true);
		setSize(Payroll.x,Payroll.y-35);

		Container c=getContentPane();
		c.setLayout(new BorderLayout());

		depr_NoTF=new JTextField("dept_0001");
		depr_NoTF.setToolTipText("Enter The DepartMent No ");

		dept_NameTF=new JTextField();
		dept_NameTF.setToolTipText("Enter The DepartMent Name ");
		validation.keyEvent(dept_NameTF,true);

		ept_TotWorkerTF=new JTextField();
		ept_TotWorkerTF.setToolTipText("Enter The DepartMent Total Worker  ");
		validation.keyEvent(ept_TotWorkerTF,false);

		dept_WorkSheepTF=new JComboBox(sheep);
		dept_WorkSheepTF.setToolTipText("Select The DepartMent Total Work Sheep in Day By Day ");

		dept_TimerTf=new JTextField();
		dept_TimerTf.setToolTipText("Enter The DepartMent Time ");


		center=new JPanel()
		{
			public void paintComponent(Graphics g)
			{
				Toolkit kit = Toolkit.getDefaultToolkit();
				Image img =kit.getImage("Image/BACK5.jpg");
				MediaTracker t=new MediaTracker(this);
				t.addImage(img,0);
				while(true)
				{
					try
					{
						t.waitForAll();
						break;
					}
					catch(Exception ee)
					{}
				}
					g.drawImage(img,0,0,Payroll.x,Payroll.y/2,null);

			}
		};
		c.add(center,"North");
		center.setBorder(BorderFactory.createRaisedBevelBorder());
		center.setLayout(new GridLayout(5,2,5,25));
		center.add(new JLabel(label[0]));
		center.add(depr_NoTF);
		center.add(new JLabel(label[1]));
		center.add(dept_NameTF);
		center.add(new JLabel(label[2]));
		center.add(ept_TotWorkerTF);
		center.add(new JLabel(label[3]));
		center.add(dept_WorkSheepTF);
		center.add(new JLabel(label[4]));
		center.add(dept_TimerTf);

		south=new JPanel();
		south.setBackground(Color.gray);
		south.setBorder(new LineBorder(Color.LIGHT_GRAY,3));

		saveBut=new JButton("Save");
		saveBut.setToolTipText("Push The Save Button And Store The Record");
		saveBut.addActionListener(this);
		saveBut.setMnemonic('K');

		modifyBut=new JButton("Modify");
		modifyBut.setToolTipText("Push The Modify Button And Update The Record");
		modifyBut.addActionListener(this);
		modifyBut.setMnemonic('M');

		deleBut=new JButton("Delete");
		deleBut.setToolTipText("Push The Delete Button And Remove The Record");
		deleBut.addActionListener(this);
		deleBut.setMnemonic('D');

		searchBut=new JButton("Search");
		searchBut.setToolTipText("Push The Search Button And Find The Record");
		searchBut.addActionListener(this);
		searchBut.setMnemonic('S');

		clearBut=new JButton("Clear");
		clearBut.setToolTipText("Push The Clear Button And Clear The Text In Form");
		clearBut.addActionListener(this);
		clearBut.setMnemonic('C');

		exitBut=new JButton("Exit");
		exitBut.setToolTipText("Push The Exit Button And Close The Window");
		exitBut.addActionListener(this);
		exitBut.setMnemonic('X');
		south.add(saveBut);
		south.add(modifyBut);
		south.add(deleBut);
		south.add(searchBut);
		south.add(clearBut);
		south.add(exitBut);

		c.add(south,"South");

		try
		{
			clsConnection connect=new clsConnection();
			conn = connect.setConnection(conn,"","");

		}
		catch(Exception er)
		{
		}
		jTable=new JTable(new AbstractTable());
		JScrollPane sp=new JScrollPane(jTable);
		add(sp);
		load_jTable();

		jTable.setRowHeight (20);
		jTable.setCellSelectionEnabled(true);
		jTable.clearSelection();
		jTable.setBackground(Color.gray);
		jTable.setForeground(Color.white);
		jTable.setFont(new Font("Aria",Font.BOLD,12));

		jTable.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

		final ListSelectionModel rowSel = jTable.getSelectionModel();

		rowSel.addListSelectionListener(new ListSelectionListener()
		{
			public void valueChanged(ListSelectionEvent e)
			{
				try
				{
					int i=0,j=0;
					for(i=0;i<jTable.getRowCount();i++)
					{
						for(j=0;j<jTable.getColumnCount();j++)
						{
							if(jTable.isCellSelected(i,j))
							{
								st=conn.createStatement();
								rs=st.executeQuery("select * from Dep_Master Order by dept_No='"+jTable.getValueAt(i,j)+"',dept_Name='"+jTable.getValueAt(i,j)+"'");
								rs.next();

								depr_NoTF.setText(""+rs.getString(1));
								dept_NameTF.setText(""+rs.getString(2));
								ept_TotWorkerTF.setText(""+rs.getString(3));
								dept_WorkSheepTF.setSelectedItem(""+rs.getString(4));
								dept_TimerTf.setText(""+rs.getString(5));

							}
						}
					}

				}
				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null,"Recored has not found");
					clear();

				}
			}

		});

	}
	public void actionPerformed(ActionEvent e)
	{
		Object obj=e.getSource();

		if(obj==saveBut)
		{
			try
			{
				if(depr_NoTF.getText().equals("")||dept_NameTF.getText().equals("")||ept_TotWorkerTF.getText().equals("")||dept_TimerTf.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null,"Please All Field Fill Up It");
				}
				else
				{
					ps=conn.prepareStatement("insert into Dep_Master values(?,?,?,?,?)");
					ps.setString(1,depr_NoTF.getText());
					ps.setString(2,dept_NameTF.getText());
					ps.setString(3,ept_TotWorkerTF.getText());
					ps.setString(4,(String)dept_WorkSheepTF.getSelectedItem());
					ps.setString(5,dept_TimerTf.getText());

					int reply = JOptionPane.showConfirmDialog (this,
					"Are you really want to Confirm Data \n\n"+
					"Department No \t=\t"+depr_NoTF.getText()+"\n"+
					"Department Name \t=\t"+dept_NameTF.getText()+"\n"+
					"Department Total Worker\t=\t"+ept_TotWorkerTF.getText()+"\n"+
					"Department Total sheep\t=\t"+(String)dept_WorkSheepTF.getSelectedItem()+"\n"+
					"Department Timer (hours)\t=\t"+dept_TimerTf.getText()+"\n\n",""
					, JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);

					if (reply == JOptionPane.YES_OPTION)
					{
						JOptionPane.showMessageDialog(null,"DepartMent  "+depr_NoTF.getText()+" Recode Has Been Save");
						ps.execute();
						clear();
						load_jTable();
					}
				}
			}
			catch(Exception ex)
			{
				JOptionPane.showMessageDialog(null,""+ex);
			}

		}
		if(obj==deleBut)
		{
			try
			{
				if(depr_NoTF.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null,"Please Emter The Department ID");
				}
				else
				{
					int reply = JOptionPane.showConfirmDialog (this,
					"Are you really want to Delete\nthe " + depr_NoTF.getText()+ " Record?",
					"Department in Company", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);

					if(reply==JOptionPane.YES_OPTION)
					{
						ps=conn.prepareStatement("delete from Dep_Master where (dept_No=?)");
						ps.setString(1,depr_NoTF.getText());
						clear();
						ps.execute();
						load_jTable();
					}
					else
					{
						System.out.println("All right");
					}
				}
			}
			catch(Exception ex)
			{
				JOptionPane.showMessageDialog(null,""+ex);
			}
		}
		if(obj==modifyBut)
		{
			if(depr_NoTF.getText().equals("")||dept_NameTF.getText().equals("")||ept_TotWorkerTF.getText().equals("")||dept_TimerTf.getText().equals(""))
			{
				JOptionPane.showMessageDialog(null,"Please All Field Fill Up It");
			}
			else
			{
				try
				{
					ps=conn.prepareStatement("Update Dep_Master SET dept_No=?,dept_Name=?,dept_Twork=?,work_Sheep=?,total_Time=? WHERE dept_No LIKE '"+depr_NoTF.getText()+"'");
					ps.setString(1,depr_NoTF.getText());
					ps.setString(2,dept_NameTF.getText());
					ps.setString(3,ept_TotWorkerTF.getText());
					ps.setString(4,(String)dept_WorkSheepTF.getSelectedItem());
					ps.setString(5,dept_TimerTf.getText());
					ps.execute();
					JOptionPane.showMessageDialog(null,"Recored Has been Update");
					load_jTable();
				}
				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null,""+ex);
				}
			}
		}
		if(obj==searchBut)
		{
			try
			{
				String dept=JOptionPane.showInputDialog(null,"Enter the Department NO");
				st=conn.createStatement();
				rs=st.executeQuery("select * from Dep_Master where dept_No='"+dept+"'");
				rs.next();
				{
					depr_NoTF.setText(""+rs.getString(1));
					dept_NameTF.setText(""+rs.getString(2));
					ept_TotWorkerTF.setText(""+rs.getString(3));
					dept_WorkSheepTF.setSelectedItem(""+rs.getString(4));
					dept_TimerTf.setText(""+rs.getString(5));
				}
			}
			catch(Exception ex)
			{
				JOptionPane.showMessageDialog(null,"Recored has not found");
			}

		}
		if(obj==clearBut)
		{
			clear();
		}
		if(obj==exitBut)
		{
			dispose();
			Payroll.diskPane.requestFocus();
		}
	}
	class AbstractTable extends javax.swing.table.AbstractTableModel
	{
		private String[] columnNames = {"Department No","Department Name","Department Total Worker","Department Work Sheep","Department Timer"};
		private Object[][] data = new Object[1000][1000];

			public int getColumnCount() {
				return columnNames.length;
			}

			public int getRowCount() {
				return data.length;
			}

			public String getColumnName(int col) {
				return columnNames[col];
			}

			public Object getValueAt(int row, int col)
			{
				return data[row][col];
			}

			public void setValueAt(Object value, int row, int col) {
				data[row][col] = value;
				fireTableCellUpdated(row, col);
			}
	}
	public void load_jTable()
	{
		try
		{
			st = conn.createStatement();
			{
				String temp = ("SELECT * FROM Dep_Master ORDER BY dept_No");
				int  Numrow = 0;
				ResultSet result = st.executeQuery(temp);
				while (result.next())
				{
					jTable.setValueAt(""+result.getString(1),Numrow,0);
					jTable.setValueAt(""+result.getString(2),Numrow,1);
					jTable.setValueAt(""+result.getString(3),Numrow,2);
					jTable.setValueAt(""+result.getString(4),Numrow,3);
					jTable.setValueAt(""+result.getString(5),Numrow,4);
					Numrow++;
				}
			}
		}
		catch ( SQLException sqlex )
		{
		}
	}
	public void clear()
	{
		depr_NoTF.setText("");
		dept_NameTF.setText("");
		ept_TotWorkerTF.setText("");
		dept_TimerTf.setText("");
	}

	private JPanel center,south;
	private String label[]={"Department No","Department Name","Department Total Worker","Department Work Sheep","Department Time Hours"};
	private JTextField depr_NoTF,dept_NameTF,ept_TotWorkerTF,dept_TimerTf;
	private JComboBox dept_WorkSheepTF;
	private JButton saveBut,modifyBut,deleBut,searchBut,clearBut,exitBut;
	private String sheep[]={"One","Two","Three","Four","Five"};
	private static int selectedRow;

	private static JTable  jTable;

	private Connection conn;
	private PreparedStatement ps;
	private Statement st;
	private ResultSet rs;


}
