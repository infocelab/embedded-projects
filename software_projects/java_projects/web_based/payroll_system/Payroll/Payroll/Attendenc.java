import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.io.*;
import java.util.*;
import java.sql.*;
import javax.swing.border.*;
import java.text.*;

class Attendenc extends JInternalFrame implements FocusListener
{
	Locale  local[];
	String s[];
	Attendenc()
	{
		super("Attendence",false,true,false,false);
		setSize(Payroll.x/2,Payroll.y/2);
		setLocation(Payroll.x/4,Payroll.y/4);

		Container c=getContentPane();
		c.setLayout(new BorderLayout());
		JPanel north=new JPanel();
		JLabel l=new JLabel("Daily Attendence Entry Book");
		l.setForeground(new Color(255,255,255));
		north.setBackground(Color.gray);
		l.setFont(new Font("Arial",Font.BOLD,20));
		north.add(l);
		c.add(north,"North");

		emp_IDText=new JTextField();
		emp_IDText.addFocusListener(this);
		emp_NameText=new JTextField();
		emp_DateText=new JTextField();
		emp_PlaceText=new JTextField();
		emp_Flag=new JTextField("A");

		local=DateFormat.getAvailableLocales();
		Locale ll=local[52];
		java.util.Date now=new java.util.Date();
		DateFormat fmt =DateFormat.getDateInstance(DateFormat.MEDIUM,ll);
		String str=fmt.format(now);
		emp_DateText.setText(str);

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
				g.drawImage(img,0,0,Payroll.x/2,Payroll.y/2,null);
			}
		};

		west.setBorder(BorderFactory.createRaisedBevelBorder());
		west.setLayout(new GridLayout(5,2,5,25));
		west.add(new JLabel(label[0]));
		west.add(emp_IDText);
		west.add(new JLabel(label[1]));
		west.add(emp_NameText);
		emp_NameText.setEditable(false);
		west.add(new JLabel(label[2]));
		west.add(emp_DateText);
		emp_DateText.setEditable(false);
		west.add(new JLabel(label[3]));
		west.add(emp_PlaceText);
		emp_PlaceText.setEditable(false);
		west.add(new JLabel("Attendence"));
		west.add(emp_Flag);
		emp_Flag.setEditable(false);

		c.add(west);

		south=new JPanel();
		south.setLayout(new GridLayout(1,3,25,25));
		south.setBackground(Color.gray);
		south.setBorder(new LineBorder(Color.LIGHT_GRAY,3));
		ok_Button=new JButton("<html><body><font size= '4'><b>&nbsp;&nbsp; OK &nbsp;&nbsp;</b></font></body></html>");
		cancel_Button=new JButton("<html><body><font size= '4'><b>&nbsp;&nbsp; CANCEL &nbsp;&nbsp;</b></font></body></html>");
		south.add(ok_Button);
		ok_Button.setBackground(Color.gray);
		ok_Button.setForeground(new Color(0,255,0));
		ok_Button.setMnemonic('K');
		south.add(cancel_Button);
		ot_Button=new JButton("Over Time");
		ot_Button.setBackground(Color.white);
		ot_Button.setForeground(Color.gray);
		ot_Button.setMnemonic('T');
		south.add(ot_Button);

		cancel_Button.setBackground(Color.gray);
		cancel_Button.setForeground(new Color(255,200,200));
		cancel_Button.setMnemonic('X');
		c.add(south,"South");

		try
		{
			clsConnection connect=new clsConnection();
			conn = connect.setConnection(conn,"","");

		}
		catch(Exception er)
		{
			JOptionPane.showMessageDialog(null,""+er);
		}

		ok_Button.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					if(emp_IDText.getText().equals(""))
					{
						JOptionPane.showMessageDialog(null,"Please Insert into the Emp_ID");
					}
					else
					{
						insertData();
						JOptionPane.showMessageDialog(null,"Recored has been Store");
						clear();clear();
						emp_IDText.requestFocus();
					}
				}
				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null,"Attendance");
					clear();
					emp_IDText.requestFocus();
				}
			}
		});
		cancel_Button.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				setVisible(false);
				dispose();
				Payroll.diskPane.requestFocus();
			}
		});
		ot_Button.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				setVisible(false);
				OverTime ot=new OverTime();
				Payroll.diskPane.add(ot);
				ot.requestFocus();
				ot.setVisible(true);

			}
		});

	}
	public void focusGained (FocusEvent fe) { }
	public void focusLost (FocusEvent fe)
	{
		boolean b=false;
		try
		{
			if(emp_IDText.getText().equals(""))
			{
				cancel_Button.requestFocus();
			}
			else
			{
				st=conn.createStatement();
				rs=st.executeQuery("select * from Emp_Master where emp_Id='"+emp_IDText.getText()+"'");
				rs.next();
				{
					if(emp_IDText.getText().equals(""+rs.getString(1)))
					{
						b=true;
						emp_NameText.setText(""+rs.getString(3));
						emp_PlaceText.setText(""+rs.getString(6));
						emp_Flag.setText("P");
						ok_Button.requestFocus();
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
				emp_IDText.requestFocus();
				//JOptionPane.showMessageDialog(null,"Recored has not found");
			}
		}
	}
	public void clear()
	{
		emp_IDText.setText("");
		emp_NameText.setText("");
		emp_PlaceText.setText("");
		emp_Flag.setText("A");
	}
	public void insertData() throws Exception
	{
		ps=conn.prepareStatement("insert into attend values(?,?,?,?,?)");
		ps.setString(1,emp_IDText.getText());
		ps.setString(2,emp_NameText.getText());
		ps.setString(3,emp_DateText.getText());
		ps.setString(4,emp_PlaceText.getText());
		ps.setString(5,emp_Flag.getText());
		ps.execute();


		String query=emp_DateText.getText();
		StringTokenizer toke=new StringTokenizer(query,"-");
		String f1=toke.nextToken();
		String f2=toke.nextToken();
		String f3=toke.nextToken();
		int colName=Integer.parseInt(f1);
		insertData(f2,f3,f1,"0");

		st=conn.createStatement();
		rs=st.executeQuery("Select * from att_Detail WHERE emp_Id LIKE'"+emp_IDText.getText()+"' AND month LIKE'"+f2+"' AND year  LIKE'"+f3+"'");
		while(rs.next())
		{
			n=Integer.parseInt(rs.getString(36));
			n+=1;
		}
		//String query1="Update att_Detail set "+f1+"='P' WHERE emp_Id LIKE '"+emp_IDText.getText()+"'";
		String query1="Update att_Detail set "+f1+"='P' ,P='"+n+"'WHERE emp_Id LIKE'"+emp_IDText.getText()+"' AND month LIKE'"+f2+"' AND year  LIKE'"+f3+"'";
		st.executeUpdate(query1);
	}
	public void insertData(String tok1,String tok2,String tok3 ,String p)throws Exception
	{
		ps1=conn.prepareStatement("insert into att_Detail values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		ps1.setString(1,emp_IDText.getText());
		ps1.setString(2,emp_NameText.getText());
		ps1.setString(3,tok1);
		ps1.setString(4,tok2);
		ps1.setString(36,p);

		for(int i=5;i<=35;i++)
		{
			ps1.setString(i," ");
		}
		st=conn.createStatement();
		rs=st.executeQuery("Select * from att_Detail WHERE emp_Id LIKE'"+emp_IDText.getText()+"' AND month LIKE'"+tok1+"' AND year  LIKE'"+tok2+"'");
		while(rs.next())
		{
			n=Integer.parseInt(rs.getString(36));
			n+=1;
		}

		ps=conn.prepareStatement("Update att_Detail set "+tok3+"=? ,P=? WHERE emp_Id ='"+emp_IDText.getText()+"' AND Name='"+emp_NameText.getText()+"' AND month ='"+tok1+"' AND year  ='"+tok2+"'");
		ps.setString(1,"P");
		ps.setString(2,""+n);
		ps.executeUpdate();
		ps1.executeUpdate();

	}
	private String label[]={"Employee ID","Name","Current Date","DepartMent"};
	private JTextField emp_IDText,emp_NameText,emp_DateText,emp_PlaceText,emp_Flag;
	private JButton ok_Button,cancel_Button,ot_Button;
	private JPanel west,south;
	private Connection conn;
	private PreparedStatement ps,ps1,ps2;
	private Statement st;
	private ResultSet rs;
	int n=0,k;

}