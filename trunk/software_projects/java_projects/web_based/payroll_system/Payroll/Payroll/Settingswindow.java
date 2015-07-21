import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;
import java.sql.*;

class Settingswindow extends JInternalFrame implements ItemListener,ActionListener
{
	int x,y;
	Settingswindow()
	{
		super("Basic Settings Window",true,true,true,true);

		Dimension dim =Toolkit.getDefaultToolkit().getScreenSize();
		x=dim.width;
		y=dim.height;
		setSize(x,y-35);

		Container c=getContentPane();
		c.setLayout(new BorderLayout());

		bas_PayTF=new JTextField(25);
		bas_PayTF.setHorizontalAlignment (JTextField.RIGHT);
		validation.keyEvent(bas_PayTF,false);

		daTF=new JTextField("0");
		daTF.setHorizontalAlignment (JTextField.RIGHT);
		validation.keyEvent(daTF,false);

		Other_AllTF=new JTextField("0");
		Other_AllTF.setHorizontalAlignment (JTextField.RIGHT);
		validation.keyEvent(Other_AllTF,false);

		hraTF=new JTextField("0");
		hraTF.setHorizontalAlignment (JTextField.RIGHT);
		validation.keyEvent(hraTF,false);

		mediTF=new JTextField("0");
		mediTF.setHorizontalAlignment (JTextField.RIGHT);
		validation.keyEvent(mediTF,false);

		pfTF=new JTextField("0");
		pfTF.setHorizontalAlignment (JTextField.RIGHT);
		validation.keyEvent(pfTF,false);

		licTF=new JTextField("0");
		licTF.setHorizontalAlignment (JTextField.RIGHT);
		validation.keyEvent(licTF,false);

		advTF=new JTextField("0");
		advTF.setHorizontalAlignment (JTextField.RIGHT);
		validation.keyEvent(advTF,false);

		kantTF=new JTextField("0");
		kantTF.setHorizontalAlignment (JTextField.RIGHT);
		validation.keyEvent(kantTF,false);

		daTF1=new JTextField("Enter in Rupies");
		daTF1.setEditable(false);
		daTF1.setBackground(Color.white);
		Other_AllTF1=new JTextField("Enter in Rupies");
		Other_AllTF1.setEditable(false);;
		Other_AllTF1.setBackground(Color.white);
		hraTF1=new JTextField("Enter in Rupies");
		hraTF1.setEditable(false);
		hraTF1.setBackground(Color.white);
		mediTF1=new JTextField("Enter in Rupies");
		mediTF1.setEditable(false);
		mediTF1.setBackground(Color.white);
		pfTF1=new JTextField("Enter in Rupies");
		pfTF1.setEditable(false);
		pfTF1.setBackground(Color.white);
		licTF1=new JTextField("Enter in Rupies");
		licTF1.setEditable(false);
		licTF1.setBackground(Color.white);
		advTF1=new JTextField("Enter in Rupies");
		advTF1.setEditable(false);
		advTF1.setBackground(Color.white);
		kantTF1=new JTextField("Enter in Rupies");
		kantTF1.setEditable(false);
		kantTF1.setBackground(Color.white);

		daCB=new JCheckBox("D.A",false);
		daCB.addItemListener(this);
		Other_AllCB=new JCheckBox("Other Allownce",false);
		Other_AllCB.addItemListener(this);
		hraCB=new JCheckBox("HRA",false);
		hraCB.addItemListener(this);
		mediCB=new JCheckBox("Medical",false);
		mediCB.addItemListener(this);
		pfCB=new JCheckBox("PF",false);
		pfCB.addItemListener(this);
		licCB=new JCheckBox("LIC",false);
		licCB.addItemListener(this);
		advCB=new JCheckBox("Advance",false);
		advCB.addItemListener(this);
		kantCB=new JCheckBox("Kanting",false);
		kantCB.addItemListener(this);


		west=new JPanel()
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
				g.drawImage(img,0,0,x,y-35,null);
			}
		};
		JPanel pan=new JPanel();
		pan.setLayout(new GridLayout(2,1,00,00));
		pan.add(west,"North");

		jTable=new JTable(new AbstractTable());
		JScrollPane sp=new JScrollPane(jTable);
		pan.add(sp);

		jTable.setRowHeight (20);
		jTable.setCellSelectionEnabled(true);
		jTable.clearSelection();
		jTable.setBackground(Color.gray);
		jTable.setForeground(Color.white);
		jTable.setFont(new Font("Aria",Font.BOLD,12));

		c.add(pan);
		west.setBorder(BorderFactory.createRaisedBevelBorder());
		west.setLayout(new GridLayout(9,4,05,05));
		west.add(new JLabel("Check For %"));
		west.add(new JLabel("Allownce"));
		west.add(new JLabel("Allownce Value"));
		west.add(new JLabel("Information"));

		west.add(new JLabel(" D A Allownce"));
		west.add(daCB);
		west.add(daTF);
		west.add(daTF1);

		west.add(new JLabel("Other Allownce"));
		west.add(Other_AllCB);
		west.add(Other_AllTF);
		west.add(Other_AllTF1);

		west.add(new JLabel("HRA Allownce"));
		west.add(hraCB);
		west.add(hraTF);
		west.add(hraTF1);

		west.add(new JLabel("Check For %"));
		west.add(new JLabel("Deduction"));
		west.add(new JLabel("Deduction Value"));
		west.add(new JLabel("Information"));


		west.add(new JLabel("ESI/Medical Allownce"));
		west.add(mediCB);
		west.add(mediTF);
		west.add(mediTF1);

	/*	west.add(new JLabel("          PF"));
		west.add(pfCB);
		west.add(pfTF);
		west.add(pfTF1);*/

		west.add(new JLabel("Deduction LIC"));
		west.add(licCB);
		west.add(licTF);
		west.add(licTF1);

		west.add(new JLabel("Advance"));
		west.add(advCB);
		west.add(advTF);
		west.add(advTF1);

		west.add(new JLabel("Kanting"));
		west.add(kantCB);
		west.add(kantTF);
		west.add(kantTF1);


		north=new JPanel();
		north.setBorder(BorderFactory.createLoweredBevelBorder());
		north.setBackground(Color.gray);
		c.add(north,"North");
		empComb=new JComboBox();
		empComb.setBackground(Color.white);
		//north.setLayout(new GridLayout(1,8,25,25));
		north.add(new JLabel("    "));
		north.add(new JLabel("<html><body><font size='5' color=#FFEEEEE><b>&nbsp;&nbsp;  Select DepartMent Name &nbsp;&nbsp;</b></font></body></html>"));
		north.add(empComb);
		north.add(new JLabel("    "));

		north.add(new JLabel("    "));
		north.add(new JLabel("<html><body><font size='5' color=#FFEEEEE><b>&nbsp;&nbsp; Basic &nbsp;&nbsp;</b></font></body></html>"));
		north.add(bas_PayTF);
		north.add(new JLabel("    "));


		center=new JDesktopPane();
		center.setBorder(BorderFactory.createLoweredBevelBorder());
		center.setBackground(Color.gray);
		center.setLayout(null);
		calcy=new MyCalc();
		calcy.setBounds(0,0,335,225);
		center.add(calcy);
		calcy.setVisible(true);
		//c.add(center);



		south=new JPanel();
		c.add(south,"South");
		south.setBackground(Color.gray);
		south.setBorder(BorderFactory.createRaisedBevelBorder());
		south.setLayout(new GridLayout(1,6,10,10));

		saveBut=new JButton("Save");
		saveBut.setBackground(Color.white);
		saveBut.setMnemonic('K');

		modifBut=new JButton("Modify");
		modifBut.setBackground(Color.white);
		modifBut.setMnemonic('M');

		deleBut=new JButton("Delete");
		deleBut.setBackground(Color.white);
		deleBut.setMnemonic('D');

		clearBut=new JButton("Clear");
		clearBut.setBackground(Color.white);
		clearBut.setMnemonic('C');

		exitBut=new JButton("Exit");
		exitBut.setBackground(Color.white);
		exitBut.setMnemonic('X');

		searBut=new JButton("Search");
		searBut.setBackground(Color.white);
		searBut.setMnemonic('S');

		calBut=new JButton("Calcy");
		calBut.setBackground(Color.white);

		south.add(saveBut);saveBut.addActionListener(this);
		south.add(modifBut);modifBut.addActionListener(this);
		south.add(deleBut);deleBut.addActionListener(this);
		south.add(searBut);searBut.addActionListener(this);
		south.add(clearBut);clearBut.addActionListener(this);
		south.add(calBut);calBut.addActionListener(this);
		south.add(exitBut);exitBut.addActionListener(this);

		try
		{
			clsConnection connect=new clsConnection();
			conn = connect.setConnection(conn,"","");
			st=conn.createStatement();
			rs=st.executeQuery("Select * from Dep_Master");
			load_jTable();

			while(rs.next())
			{
				empComb.addItem(rs.getString(2));
			}

		}
		catch(Exception er){}
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
								searchFun("Select * from Basic Order by emp_Dept='"+jTable.getValueAt(i,j)+"'");
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
			if(bas_PayTF.getText().equals("") ||daTF.getText().equals("")||Other_AllTF.getText().equals("")|| hraTF.getText().equals("")||mediTF.getText().equals("")||pfTF.getText().equals("")||licTF.getText().equals("")||advTF.getText().equals("")||kantTF.getText().equals(""))
			{
				JOptionPane.showMessageDialog(null,"Please All Field FillUP It");
			}
			else
			{
				dataFunction("insert into Basic values(?,?,?,?,?,?,?,?,?,?)");
				load_jTable();
			}
		}
		if(obj==modifBut)
		{
			dataFunction("update Basic set emp_Dept=?,basic=?,DA=?,oterAllow=?,HRA=?,ESI=?,PF=?,deduct=?,adv=?,kant=? where emp_Dept LIKE '"+(String)empComb.getSelectedItem()+"'");
			load_jTable();
		}
		if(obj==deleBut)
		{
			try
			{
				ps=conn.prepareStatement("delete from Basic where (emp_Dept=?)");
				String s=(String)empComb.getSelectedItem();
				ps.setString(1,s);

				int reply = JOptionPane.showConfirmDialog (this,"Are you really want to Remove Data \n\n",
				"Employee Ditails", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
				if(reply==JOptionPane.YES_OPTION)
				{
					ps.execute();
					JOptionPane.showMessageDialog(null,"Recored has been Store");
					clear();
					load_jTable();
				}
			}
			catch(Exception er)
			{
				JOptionPane.showMessageDialog(null,""+er);
			}
		}
		if(obj==searBut)
		{
			String q=JOptionPane.showInputDialog(null,"Enter the DepartMent Name");
			searchFun("Select * from Basic where emp_Dept='"+q+"'");
		}
		if(obj==clearBut)
		{
			clear();
		}
		if(obj==exitBut)
		{
			dispose();
		}
		if(obj==calBut)
		{
			MyCalc m=new MyCalc();
			//Payroll.diskPane.add(m);
			//m.setVisible(true);

		}
	}
	public void searchFun(String str)
	{
		try
		{
			st=conn.createStatement();
			rs=st.executeQuery(str);
			rs.next();
			{
				empComb.setSelectedItem(""+rs.getString(1));
				bas_PayTF.setText(""+rs.getString(2));
				daTF.setText(""+rs.getString(3));
				Other_AllTF.setText(""+rs.getString(4));
				hraTF.setText(""+rs.getString(5));
				mediTF.setText(""+rs.getString(6));
				//pfTF.setText(""+rs.getString(7));
				licTF.setText(""+rs.getString(8));
				advTF.setText(""+rs.getString(9));
				kantTF.setText(""+rs.getString(10));
			}
		}
		catch(Exception er)
		{
			JOptionPane.showMessageDialog(null,""+er);
		}
	}
	public void dataFunction(String d)
	{
		try
		{
			ps=conn.prepareStatement(d);
			ps.setString(1,(String)empComb.getSelectedItem());
			ps.setString(2,bas_PayTF.getText());

			if(daTF1.getText().equals("Enter in % of Basic"))
			{
				double basic =Double.parseDouble(bas_PayTF.getText());
				double val=Double.parseDouble(daTF.getText());
				double tot=basic*val/100;
				ps.setString(3,""+tot);
			}
			else if(daTF1.getText().equals("Enter in Rupies"))
			{
				ps.setString(3,""+daTF.getText());
			}

			if(Other_AllTF1.getText().equals("Enter in % of Basic"))
			{
				double basic =Double.parseDouble(bas_PayTF.getText());
				double val=Double.parseDouble(Other_AllTF.getText());
				double tot=(basic*val)/100;
				ps.setString(4,""+tot);
			}
			else if(Other_AllTF1.getText().equals("Enter in Rupies"))
			{
				ps.setString(4,""+Other_AllTF.getText());
			}


			if(hraTF1.getText().equals("Enter in % of Basic"))
			{
				double basic =Double.parseDouble(bas_PayTF.getText());
				double val=Double.parseDouble(hraTF.getText());
				double tot=(basic*val)/100;
				ps.setString(5,""+tot);
			}
			else if(hraTF1.getText().equals("Enter in Rupies"))
			{
				ps.setString(5,""+hraTF.getText());
			}

			if(mediTF1.getText().equals("Enter in % of Basic"))
			{
				double basic =Double.parseDouble(bas_PayTF.getText());
				double val=Double.parseDouble(mediTF.getText());
				double tot=(basic*val)/100;
				ps.setString(6,""+tot);
			}
			else if(mediTF1.getText().equals("Enter in Rupies"))
			{
				ps.setString(6,""+mediTF.getText());
			}


			if(pfTF1.getText().equals("Enter in % of Basic"))
			{
				double basic =Double.parseDouble(bas_PayTF.getText());
				double val=Double.parseDouble(pfTF.getText());
				double tot=(basic*val)/100;
				ps.setString(7,"00");
			}
			 else if(pfTF1.getText().equals("Enter in Rupies"))
			{
				ps.setString(7,"00");
			}


			if(licTF1.getText().equals("Enter in % of Basic"))
			{
				double basic =Double.parseDouble(bas_PayTF.getText());
				double val=Double.parseDouble(licTF.getText());
				double tot=(basic*val)/100;
				ps.setString(8,""+tot);
			}
			else if(licTF1.getText().equals("Enter in Rupies"))
			{
				ps.setString(8,""+licTF.getText());
			}

			if(advTF1.getText().equals("Enter in % of Basic"))
			{
				double basic =Double.parseDouble(bas_PayTF.getText());
				double val=Double.parseDouble(advTF.getText());
				double tot=(basic*val)/100;
				ps.setString(9,""+tot);
			}
			else if(advTF1.getText().equals("Enter in Rupies"))
			{
				ps.setString(9,""+advTF.getText());
			}
			if(kantTF1.getText().equals("Enter in % of Basic"))
			{
				double basic =Double.parseDouble(bas_PayTF.getText());
				double val=Double.parseDouble(kantTF.getText());
				double tot=(basic*val)/100;
				ps.setString(10,""+tot);
			}
			else if(kantTF1.getText().equals("Enter in Rupies"))
			{
				ps.setString(10,""+kantTF.getText());
			}
			int reply = JOptionPane.showConfirmDialog (this,"Are you really want to Confirm Data \n\n",
			"Employee Ditails", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
			if(reply==JOptionPane.YES_OPTION)
			{
				ps.execute();
				JOptionPane.showMessageDialog(null,"Recored has been Store");
				clear();
			}
		}
		catch(Exception er)
		{
			JOptionPane.showMessageDialog(null,""+er);
		}
	}
	public void itemStateChanged(ItemEvent e)
	{
		if(daCB.isSelected())
		{
			daTF1.setText("Enter in % of Basic");
		}
		else if(daCB.isSelected()==false)
		{
			daTF1.setText("Enter in Rupies");
		}
		if(Other_AllCB.isSelected())
		{
			Other_AllTF1.setText("Enter in % of Basic");
		}
		else if(Other_AllCB.isSelected()==false)
		{
			Other_AllTF1.setText("Enter in Rupies");
		}
		if(hraCB.isSelected())
		{
			hraTF1.setText("Enter in % of Basic");
		}
		else if(hraCB.isSelected()==false)
		{
			hraTF1.setText("Enter in Rupies");
		}
		if(mediCB.isSelected())
		{
			mediTF1.setText("Enter in % of Basic");
		}
		else if(mediCB.isSelected()==false)
		{
			mediTF1.setText("Enter in Rupies");
		}
		if(pfCB.isSelected())
		{
			pfTF1.setText("Enter in % of Basic");
		}
		else if(pfCB.isSelected()==false)
		{
			pfTF1.setText("Enter in Rupies");
		}
		if(licCB.isSelected())
		{
			licTF1.setText("Enter in % of Basic");
		}
		else if(licCB.isSelected()==false)
		{
			licTF1.setText("Enter in Rupies");
		}
		if(advCB.isSelected())
		{
			advTF1.setText("Enter in % of Basic");
		}
		else if(advCB.isSelected()==false)
		{
			advTF1.setText("Enter in Rupies");
		}
		if(kantCB.isSelected())
		{
			kantTF1.setText("Enter in % of Basic");
		}
		else if(kantCB.isSelected()==false)
		{
			kantTF1.setText("Enter in Rupies");
		}
	}
	public void clear()
	{
		bas_PayTF.setText("");
		daTF.setText("");
		Other_AllTF.setText("");
		hraTF.setText("");
		mediTF.setText("");
		pfTF.setText("");
		licTF.setText("");
		advTF.setText("");
		kantTF.setText("");
	}
	class AbstractTable extends javax.swing.table.AbstractTableModel
	{
		private String[] columnNames = {"Emp_Dept ","Basic Amt.","D.A.","Other Allownce","H.R.A","E.S.I.","P.F.","Deduction","Advance","Kanting"};
		private Object[][] data = new Object[100][100];

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
				String temp = ("SELECT * FROM Basic ");//ORDER BY emp_Dept");
				int  Numrow = 0;
				ResultSet result = st.executeQuery(temp);
				while (result.next())
				{
					jTable.setValueAt(""+result.getString(1),Numrow,0);
					jTable.setValueAt(""+result.getString(2),Numrow,1);
					jTable.setValueAt(""+result.getString(3),Numrow,2);
					jTable.setValueAt(""+result.getString(4),Numrow,3);
					jTable.setValueAt(""+result.getString(5),Numrow,4);
					jTable.setValueAt(""+result.getString(6),Numrow,5);
					//jTable.setValueAt(""+result.getString(7),Numrow,6);
					jTable.setValueAt(""+result.getString(8),Numrow,7);
					jTable.setValueAt(""+result.getString(9),Numrow,8);
					jTable.setValueAt(""+result.getString(10),Numrow,9);

					Numrow++;
				}
			}
		}
		catch ( SQLException sqlex )
		{
		}
	}
	public static void main(String []argd)
	{
		Payroll p=new Payroll();
		p.show();
	}

	private JTextField bas_PayTF,daTF,Other_AllTF,hraTF,mediTF,pfTF,licTF,advTF,kantTF,
						daTF1,Other_AllTF1,hraTF1,mediTF1,pfTF1,licTF1,advTF1,kantTF1;
	private JCheckBox daCB,Other_AllCB,hraCB,mediCB,pfCB,licCB,advCB,kantCB;
	private JComboBox empComb;
	private JPanel north,south,west;
	private JDesktopPane center;
	private MyCalc calcy;
	private JButton saveBut,modifBut,deleBut,clearBut,exitBut,searBut,calBut;

	private Connection conn;
	private PreparedStatement ps;
	private Statement st;
	private ResultSet rs;
	private ResultSetMetaData rsMT;
	private JTable jTable;


}