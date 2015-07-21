import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.io.*;
import java.util.*;
import java.sql.*;
import javax.swing.border.*;
import java.text.*;

class OverTime extends JInternalFrame implements FocusListener
{
	int x,y;
	OverTime()
	{
		super("Over Time",false,true,false,true);
		Dimension dim =Toolkit.getDefaultToolkit().getScreenSize();
		x=dim.width;
		y=dim.height;

		Container c=getContentPane();
		c.setLayout(new BorderLayout());
		setSize(x/2,y/2);
		setLocation(x/4,y/4);
		setVisible(true);

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
				g.drawImage(img,0,0,x/2,y/2,null);
			}
		};

		center.setBorder(BorderFactory.createRaisedBevelBorder());
		center.setLayout(new GridLayout(6,2,10,10));

		emp_ID=new JTextField();
		emp_ID.addFocusListener(this);
		emp_name=new JTextField();emp_name.setEditable(false);
		emp_date=new JTextField();emp_date.setEditable(false);
		emp_Dept=new JTextField();emp_Dept.setEditable(false);
		emp_time=new JComboBox(combo);

		emp_IDLB=new JLabel("Enter Employee ID");
		emp_nameLB=new JLabel("Enter Employee Name");
		emp_dateLB=new JLabel("Enter Current Date");
		emp_DeptLB=new JLabel("Enter Employee Dept.");
		emp_timeLB=new JLabel("Enter Total Work Time");

		local=DateFormat.getAvailableLocales();
		Locale ll=local[52];
		java.util.Date now=new java.util.Date();
		DateFormat fmt =DateFormat.getDateInstance(DateFormat.MEDIUM,ll);
		String str=fmt.format(now);
		emp_date.setText(str);

		center.add(emp_IDLB);
		center.add(emp_ID);
		center.add(emp_nameLB);
		center.add(emp_name);
		center.add(emp_dateLB);
		center.add(emp_date);
		center.add(emp_DeptLB);
		center.add(emp_Dept);
		center.add(emp_timeLB);
		center.add(emp_time);
		add(center);

		save=new JButton("Ok");
		save.setMnemonic('K');

		close=new JButton("Exit");
		close.setMnemonic('X');

		atten=new JButton("Attend");
		atten.setMnemonic('A');

		south=new JPanel();
		south.setLayout(new GridLayout(1,3,25,25));
		south.setBorder(BorderFactory.createLoweredBevelBorder());
		south.setBackground(Color.gray);
		c.add(south,"South");
		south.add(save);
		save.setBackground(Color.white);
		south.add(close);
		close.setBackground(Color.white);
		south.add(atten);
		atten.setBackground(Color.gray);
		atten.setForeground(Color.white);

		try
		{
			clsConnection connect=new clsConnection();
			conn = connect.setConnection(conn,"","");
		}
		catch(Exception er)
		{
			JOptionPane.showMessageDialog(null,""+er);
		}

		save.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if(emp_ID.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null,"Please Enter the EmpId");
					emp_ID.requestFocus();
				}
				else
				{
					try
					{
						insertData();
						JOptionPane.showMessageDialog(null,"Recored has been Store");
						clear();clear();
						emp_ID.requestFocus();
					}
					catch(Exception ex)
					{
						JOptionPane.showMessageDialog(null,"Attendance");
						clear();
						emp_ID.requestFocus();
					}
				}
			}
		});
		close.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				setVisible(false);
				dispose();
				Payroll.diskPane.requestFocus();
			}
		});
		atten.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				setVisible(false);
				dispose();
				Attendenc atten=new Attendenc();
				atten.requestFocus();
				Payroll.diskPane.add(atten);
				atten.setVisible(true);
			}
		});

	}
	public void focusGained (FocusEvent fe) { }
	public void focusLost (FocusEvent fe)
	{
		boolean b=false;
		try
		{
			if(emp_ID.getText().equals(""))
			{
				close.requestFocus();
			}
			else
			{
				st=conn.createStatement();
				rs=st.executeQuery("select * from Emp_Master where emp_Id='"+emp_ID.getText()+"'");
				rs.next();
				{
					if(emp_ID.getText().equals(""+rs.getString(1)))
					{
						b=true;
						emp_name.setText(""+rs.getString(3));
						emp_Dept.setText(""+rs.getString(6));
					}
					else
					{
						b=false;
					}
				}
			}
		}
		catch(Exception er)
		{
			if(b==false)
			{
				clear();
				emp_ID.requestFocus();
				//JOptionPane.showMessageDialog(null,"Recored has not found");
			}
		}
	}
	public void insertData() throws Exception
	{
		String query=emp_date.getText();
		StringTokenizer toke=new StringTokenizer(query,"-");
		String f1=toke.nextToken();
		String f2=toke.nextToken();
		String f3=toke.nextToken();

		String query1=(String)emp_time.getSelectedItem();
		StringTokenizer toke1=new StringTokenizer(query1," ");
		String f11=toke1.nextToken();
		String f12=toke1.nextToken();

		ps=conn.prepareStatement("insert into overtime values(?,?,?,?,?)");
		ps.setString(1,emp_ID.getText());
		ps.setString(2,emp_name.getText());
		ps.setString(3,emp_date.getText());
		ps.setString(4,emp_Dept.getText());
		ps.setString(5,f11);
		ps.execute();




		int colName=Integer.parseInt(f1);
		int n=Integer.parseInt(f11);
		st=conn.createStatement();
		rs=st.executeQuery("Select * from OT_detail WHERE emp_Id LIKE'"+emp_ID.getText()+"' AND month LIKE'"+f2+"' AND year  LIKE'"+f3+"'");
		while(rs.next())
		{
			int count=Integer.parseInt(""+rs.getString(36));
			int otime=Integer.parseInt(f11);
			n=count+otime;
		}
		insertData(f2,f3,f1,n);
		String q="Update OT_detail set "+f1+"='"+f11+"', C='"+n+"' WHERE emp_Id LIKE'"+emp_ID.getText()+"' AND month LIKE'"+f2+"' AND year  LIKE'"+f3+"'";
		st.executeUpdate(q);



	}
	public void insertData(String tok1,String tok2,String tok3,int k)throws Exception
	{
		String query=(String)emp_time.getSelectedItem();
		StringTokenizer toke=new StringTokenizer(query," ");
		String f1=toke.nextToken();
		String f2=toke.nextToken();




		ps1=conn.prepareStatement("insert into OT_detail values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		ps1.setString(1,emp_ID.getText());
		ps1.setString(2,emp_name.getText());
		ps1.setString(3,tok1);
		ps1.setString(4,tok2);
		ps1.setString(36,"");

		for(int i=5;i<=35;i++)
		{
			ps1.setString(i,"");
		}
		ps=conn.prepareStatement("Update OT_detail set "+tok3+"=? ,C=? WHERE emp_Id ='"+emp_ID.getText()+"' AND Name='"+emp_name.getText()+"' AND month ='"+tok1+"' AND year  ='"+tok2+"'");
		ps.setString(1,f1);
		ps.setString(2,""+k);
		ps.executeUpdate();

		ps1.executeUpdate();
	}
	public void clear()
	{
		emp_ID.setText("");
		emp_name.setText("");
		emp_Dept.setText("");
	}
	private JButton save,close,atten;
	private JPanel south,center,east;
	private JComboBox emp_time;

	private String combo[]={"1 hr","2 hrs","3 hrs","4 hrs","5 hrs","6 hrs"};

	private JTextField emp_ID,emp_name,emp_date,emp_Dept;
	private JLabel emp_IDLB,emp_nameLB,emp_dateLB,emp_DeptLB,emp_timeLB;
	Locale  local[];
	String s[];
	private Connection conn;
	private PreparedStatement ps,ps1,ps2;
	private Statement st;
	private ResultSet rs;
	private ResultSetMetaData rsMT;

}
