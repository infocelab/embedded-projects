import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;
import java.sql.*;

class Salary extends JInternalFrame implements ActionListener
{
	Salary()
	{
		super("Salary",true,true,true,true);
		setSize(Payroll.x,Payroll.y-35);

		Container c=getContentPane();
		c.setLayout(new BorderLayout());


		north=new JPanel();
		north.setBackground(Color.DARK_GRAY);
		north.setBorder(BorderFactory.createLoweredBevelBorder());
		JLabel title=new JLabel("Payment Sleep For The Month Of");
		title.setForeground(new Color(255,255,255));
		title.setFont(new Font("Arial",Font.BOLD,20));
		mouthCB=new JComboBox(Months);
		yearCB=new JComboBox();
		north.add(title);
		north.add(mouthCB);
		north.add(yearCB);
		c.add(north,"North");

		for(int i=2008;i<=2050;i++)
		{
			String year=""+i;
			yearCB.addItem(year);
		}

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
				g.drawImage(img,0,0,Payroll.x/2+100,Payroll.y-75,null);
			}
		};
		west.setBorder(BorderFactory.createRaisedBevelBorder());
		west.setLayout(new GridLayout(20,2,0,10));
		c.add(west,"West");

		emp_IDTF=new JTextField(20);
		emp_NameTF=new JTextField(20);emp_NameTF.setEnabled(false);
		emp_NameTF.setFont(new Font("Arial",Font.BOLD,14));
		emp_dept=new JTextField(20);emp_dept.setEnabled(false);
		emp_dept.setFont(new Font("Arial",Font.BOLD,14));
		pres_DayTF=new JTextField(20);pres_DayTF.setEnabled(false);
		pres_DayTF.setFont(new Font("Arial",Font.BOLD,14));
		bas_PayTF=new JTextField(20);bas_PayTF.setEnabled(false);
		bas_PayTF.setFont(new Font("Arial",Font.BOLD,14));
		bas_AmtTF=new JTextField(20);bas_AmtTF.setEnabled(false);
		bas_AmtTF.setFont(new Font("Arial",Font.BOLD,14));
		daTF=new JTextField(20);daTF.setEnabled(false);
		daTF.setFont(new Font("Arial",Font.BOLD,14));
		Other_AllTF=new JTextField(20);Other_AllTF.setEnabled(false);
		Other_AllTF.setFont(new Font("Arial",Font.BOLD,14));
		hraTF=new JTextField(20);hraTF.setEnabled(false);
		hraTF.setFont(new Font("Arial",Font.BOLD,14));
		overtiTF=new JTextField("0",20);overtiTF.setEnabled(false);
		overtiTF.setFont(new Font("Arial",Font.BOLD,14));
		tot_GrTf=new JTextField(20);tot_GrTf.setEnabled(false);
		tot_GrTf.setFont(new Font("Arial",Font.BOLD,14));
		mediTF=new JTextField(20);mediTF.setEnabled(false);
		mediTF.setFont(new Font("Arial",Font.BOLD,14));
		pfTF=new JTextField(20);pfTF.setEnabled(false);
		pfTF.setFont(new Font("Arial",Font.BOLD,14));
		licTF=new JTextField(20);licTF.setEnabled(false);
		licTF.setFont(new Font("Arial",Font.BOLD,14));
		advTF=new JTextField(20);advTF.setEnabled(false);
		advTF.setFont(new Font("Arial",Font.BOLD,14));
		kantTF=new JTextField(20);kantTF.setEnabled(false);
		kantTF.setFont(new Font("Arial",Font.BOLD,14));
		totDedTf=new JTextField(20);totDedTf.setEnabled(false);
		totDedTf.setFont(new Font("Arial",Font.BOLD,14));
		totSaltf=new JTextField(20);totSaltf.setEnabled(false);
		totSaltf.setFont(new Font("Arial",Font.BOLD,14));


		west.add(new JLabel(label[0]));
		west.add(emp_IDTF);
		west.add(new JLabel(label[1]));
		west.add(emp_NameTF);
		west.add(new JLabel("Emp Department"));
		west.add(emp_dept);

		west.add(new JLabel(label[2]));
		west.add(pres_DayTF);
		west.add(new JLabel(label[3]));
		west.add(bas_PayTF);
		west.add(new JLabel(label[4]));
		west.add(bas_AmtTF);
		west.add(new JLabel(label[5]));
		west.add(daTF);
		west.add(new JLabel(label[6]));
		west.add(Other_AllTF);
		west.add(new JLabel(label[7]));
		west.add(hraTF);
		west.add(new JLabel(label[8]));
		west.add(tot_GrTf);
		west.add(jseparator1);
		west.add(jseparator2);
		jseparator1.setPreferredSize(new Dimension(dimension.width, 100));
		jseparator2.setPreferredSize(new Dimension(dimension.width, 100));
		west.add(new JLabel(label[9]));
		west.add(mediTF);
		west.add(new JLabel(label[10]));
		west.add(pfTF);
		west.add(new JLabel(label[11]));
		west.add(licTF);
		west.add(new JLabel(label[12]));
		west.add(advTF);
		west.add(new JLabel(label[13]));
		west.add(kantTF);
		west.add(new JLabel(label[14]));
		west.add(totDedTf);
		west.add(jseparator3);
		west.add(jseparator4);
		jseparator3.setPreferredSize(new Dimension(dimension.width, 100));
		jseparator4.setPreferredSize(new Dimension(dimension.width, 100));
		west.add(new JLabel("OT Salary"));
		west.add(overtiTF);
		west.add(new JLabel(label[15]));
		west.add(totSaltf);


		south=new JPanel();
		south.setBorder(BorderFactory.createRaisedBevelBorder());
		south.setBackground(Color.DARK_GRAY);
		south.setLayout(new GridLayout(8,1,35,35));
		c.add(south,"East");

		payBut=new JButton("<html><body><font size='3'><b>&nbsp;&nbsp;Payment &nbsp;&nbsp;</b></font></body></html>");
		payBut.setBackground(new Color(205,200,155));
		payBut.addActionListener(this);
		payBut.setMnemonic('P');

		saveBut=new JButton("<html><body><font size='3'><b>&nbsp;&nbsp;Save &nbsp;&nbsp;</b></font></body></html>");
		saveBut.setBackground(new Color(160,170,155));
		saveBut.addActionListener(this);
		saveBut.setMnemonic('K');
		//modifyBut=new JButton("<html><body><font size='3'><b>&nbsp;&nbsp;Modify &nbsp;&nbsp;</b></font></body></html>");
		//modifyBut.setBackground(new Color(255,255,255));
		deleBut=new JButton("<html><body><font size='3'><b>&nbsp;&nbsp;Delete &nbsp;&nbsp;</b></font></body></html>");
		deleBut.setBackground(new Color(160,170,155));
		deleBut.addActionListener(this);
		deleBut.setMnemonic('D');

		searBut=new JButton("<html><body><font size='3'><b>&nbsp;&nbsp;Search &nbsp;&nbsp;</b></font></body></html>");
		searBut.setBackground(new Color(160,170,155));
		searBut.addActionListener(this);
		searBut.setMnemonic('S');

		viewBut=new JButton("<html><body><font size='3'><b>&nbsp;&nbsp; VIEW &nbsp;&nbsp;</b></font></body></html>");
		viewBut.setBackground(new Color(160,170,155));
		viewBut.addActionListener(this);
		viewBut.setMnemonic('V');

		clearBut=new JButton("<html><body><font size='3'><b>&nbsp;&nbsp;Clear &nbsp;&nbsp;</b></font></body></html>");
		clearBut.setBackground(new Color(160,170,155));
		clearBut.addActionListener(this);
		clearBut.setMnemonic('C');

		closeBut=new JButton("<html><body><font size='2'><b>&nbsp;&nbsp;Exit &nbsp;&nbsp;</b></font></body></html>");
		closeBut.addActionListener(this);
		closeBut.setMnemonic('X');

		south.add(payBut);
		south.add(saveBut);
	//	south.add(modifyBut);
		south.add(deleBut);
		south.add(searBut);
		south.add(viewBut);
		south.add(clearBut);
		south.add(closeBut);
		closeBut.setBackground(new Color(255,245,235));
		closeBut.setForeground(Color.red);


		east=new JPanel();
		east.setLayout(new BorderLayout());
		east.setBorder(BorderFactory.createLoweredBevelBorder());
		east.setBackground(Color.LIGHT_GRAY);
		p=new pane();
		p.setBackground(Color.gray);
		east.add(p,"North");
		MyCalc mcal=new MyCalc();
		mcal.setVisible(true);
		east.add(mcal,"South");
		p.setVisible(false);
		add(east);


		try
		{
			clsConnection connect=new clsConnection();
			conn = connect.setConnection(conn,"","");
		}
		catch(Exception er){}

		emp_IDTF.addFocusListener(new FocusAdapter()
		{
			public void focusLost(FocusEvent e)
			{
				p.setVisible(false);
				payBut.requestFocus();
			}
		});

	}
	public void actionPerformed(ActionEvent e)
	{
		p.setVisible(false);
		Object obj=e.getSource();
		if(obj==saveBut)
		{
			if(emp_IDTF.getText().equals("")||emp_NameTF.getText().equals(""))
			{
				JOptionPane.showMessageDialog(null,"Please Enter the Employee ID & Click The Payment Button");
			}
			else
			{
				String mon=(String)mouthCB.getSelectedItem();
					String year=(String)yearCB.getSelectedItem();
				try
				{
					ps=conn.prepareStatement("insert into salary values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

					ps.setString(1,mon);
					ps.setString(2,year);
					ps.setString(3,emp_IDTF.getText());
					ps.setString(4,emp_NameTF.getText());
					ps.setString(5,emp_dept.getText());
					ps.setString(6,pres_DayTF.getText());
					ps.setString(7,bas_PayTF.getText());
					ps.setString(8,bas_AmtTF.getText());
					ps.setString(9,daTF.getText());
					ps.setString(10,Other_AllTF.getText());
					ps.setString(11,hraTF.getText());
					ps.setString(12,overtiTF.getText());
					ps.setString(13,tot_GrTf.getText());
					ps.setString(14,mediTF.getText());
					ps.setString(15,pfTF.getText());
					ps.setString(16,licTF.getText());
					ps.setString(17,advTF.getText());
					ps.setString(18,kantTF.getText());
					ps.setString(19,totDedTf.getText());
					ps.setString(20,totSaltf.getText());
					ps.executeUpdate();
					JOptionPane.showMessageDialog(null,"Recored has been save");
					clear();
				}
				catch(Exception er)
				{
					JOptionPane.showMessageDialog(null,"The Employee "+emp_NameTF.getText()+" Payment recored's for the mouth of "+mon+"  "+year+" already store it");
					clear();
				}
			}
		}
		if(obj==payBut)
		{
			p.setVisible(false);
			if(emp_IDTF.getText().equals(""))
			{
				JOptionPane.showMessageDialog(null,"Please Enter the Employee ID");
			}
			else
			{
				try
				{
					st=conn.createStatement();
					rs=st.executeQuery("select * from Emp_Master where emp_Id='"+emp_IDTF.getText()+"'");
					while(rs.next())
					{
						emp_NameTF.setText(rs.getString(3));
						emp_dept.setText(rs.getString(6));
					}
					rs.close();
					st.close();

					st=conn.createStatement();
					rs=st.executeQuery("select * from att_Detail where emp_ID='"+emp_IDTF.getText()+"'AND month='"+(String)mouthCB.getSelectedItem()+"'AND year='"+(String)yearCB.getSelectedItem()+"'");
					rs.next();
					{
						pres_DayTF.setText(""+rs.getString(36));
					}
					rs.close();
					st.close();

					st=conn.createStatement();
					rs=st.executeQuery("select * from Basic where emp_Dept='"+emp_dept.getText()+"'");
					rs.next();
					{
						bas_PayTF.setText(""+rs.getString(2));

						int preDay=Integer.parseInt(pres_DayTF.getText());
						float prePay=Float.parseFloat(bas_PayTF.getText());
						float bacAmt=(prePay/26)*preDay;
						bas_AmtTF.setText(""+bacAmt);

						float BasicDA=Float.parseFloat(""+rs.getString(3));
						float totDa=(BasicDA/26)*preDay;

						daTF.setText(""+totDa);
						float othr=Integer.parseInt(rs.getString(4));
						float other=othr/26*preDay;
						Other_AllTF.setText(""+other);
						float hra=Float.parseFloat(""+rs.getString(5));
						float hraTot=hra/26*preDay;
						hraTF.setText(""+hraTot);

						float da=Float.parseFloat(daTF.getText());
						float otal=Float.parseFloat(Other_AllTF.getText());
						//float over=Float.parseFloat(overtiTF.getText());
						float hr=Float.parseFloat(hraTF.getText());
						float tot=da+otal+hr+bacAmt;
						tot_GrTf.setText(""+tot);

						mediTF.setText(""+rs.getString(6));

						//float pf=Float.parseFloat(""+rs.getString(7));
						float pftot=tot/100*10;

						pfTF.setText(""+pftot);
						licTF.setText(""+rs.getString(8));
						advTF.setText(""+rs.getString(9));
						kantTF.setText(""+rs.getString(10));

						float esi=Float.parseFloat(mediTF.getText());
						float pf=Float.parseFloat(pfTF.getText());
						float lic=Float.parseFloat(licTF.getText());
						float adv=Float.parseFloat(advTF.getText());
						float kan=Float.parseFloat(kantTF.getText());

						float totDed=esi+pf+lic+adv+kan;
						totDedTf.setText(""+totDed);

						float totSal=tot-totDed;
						totSaltf.setText(""+totSal);
					}
					rs.close();
					st.close();

					st=conn.createStatement();
					rs=st.executeQuery("select * from OT_detail where emp_ID='"+emp_IDTF.getText()+"'AND month='"+(String)mouthCB.getSelectedItem()+"'AND year='"+(String)yearCB.getSelectedItem()+"'");
					while(rs.next())
					{
						int ot=Integer.parseInt(""+rs.getString(36));
						float basPay=Float.parseFloat(""+bas_PayTF.getText());

						float perdayy=basPay/26;
						float otPay=perdayy*ot/8;
						overtiTF.setText(""+otPay);

						float tdet=Float.parseFloat(totDedTf.getText());
						float tgro=Float.parseFloat(tot_GrTf.getText());

						float a=tgro-tdet;
						float b=a+otPay;
						totSaltf.setText(""+b);
					}
					rs.close();
					st.close();
				}
				catch(Exception er)
				{
					JOptionPane.showMessageDialog(null,""+er);
					clear();
					emp_IDTF.requestFocus();
				}
			}
		}
		if(obj==deleBut)
		{
			if(emp_IDTF.getText().equals("")||emp_NameTF.getText().equals(""))
			{
				JOptionPane.showMessageDialog(null,"Please Enter the Employee ID & Click The Payment Button");
			}
			else
			{
				String mon=(String)mouthCB.getSelectedItem();
				String year=(String)yearCB.getSelectedItem();
				try
				{
					ps=conn.prepareStatement("delete from salary where (emp_Id=? AND month =? AND year =?)");
					ps.setString(1,emp_IDTF.getText());
					ps.setString(2,mon);
					ps.setString(3,year);
					int reply = JOptionPane.showConfirmDialog (this,"Are you really want to Confirm Data Remove \n\n",
					"Employee Ditails", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
					if(reply==JOptionPane.YES_OPTION)
					{
						ps.execute();
						JOptionPane.showMessageDialog(null,"Recored has been Deleted");
						clear();
					}

				}
				catch(Exception er)
				{
					JOptionPane.showMessageDialog(null,""+er);
				}
			}
		}
		if(obj==closeBut)
		{
			dispose();
		}
		if(obj==clearBut)
		{
			p.setVisible(false);
			clear();
		}
		if(obj==searBut)
		{
			p.setVisible(true);
		}
		if(obj==viewBut)
		{
			sal_Report sr=new sal_Report();
			Payroll.diskPane.add(sr);
			sr.setVisible(true);
		}

	}
	public void clear()
	{
		emp_IDTF.setText("");
		emp_NameTF.setText("");
		emp_dept.setText("");
		pres_DayTF.setText("");
		bas_PayTF.setText("");
		bas_AmtTF.setText("");
		daTF.setText("");
		Other_AllTF.setText("");
		overtiTF.setText("");
		hraTF.setText("");
		tot_GrTf.setText("");
		mediTF.setText("");
		pfTF.setText("");
		licTF.setText("");
		advTF.setText("");
		kantTF.setText("");
		totDedTf.setText("");
		totSaltf.setText("");
	}

	private pane p;
	private JTextField emp_IDTF,emp_NameTF ,emp_dept,pres_DayTF,bas_PayTF,bas_AmtTF,daTF,Other_AllTF,overtiTF,hraTF,tot_GrTf,
							mediTF,pfTF,licTF,advTF,kantTF,totDedTf,totSaltf;

	private JTextField emp_IDTF1;

	private String label[]={"Employee ID","Employee Name","Present Day","Basic Pay","Basic Amount","D.A","Other Allownce","H.R.A","Total Gross Salary",
							"ESI/Medical","PF","Dedaction/LIC/RD","Advance","Kanting","Total Dedation","Total Salary"};

	private JPanel west,south,north;
	private JComboBox mouthCB,yearCB,mouthCB1,yearCB1;
	private JPanel east;
	private JButton payBut,saveBut,deleBut,searBut,viewBut,clearBut,closeBut,showBut;
	//,modifyBut

	private Connection conn;
	private PreparedStatement ps;
	private Statement st,st1;
	private ResultSet rs,rs1;

	private String Months[] = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul",
					"Aug", "Sep", "Oct", "Nov", "Dec"};
	//private JButton firstBut,nextBut,preBut,lastBut,;

	//JSeparator jseparator1,jseparator2;
	JSeparator  jseparator1= new JSeparator(JSeparator.HORIZONTAL);
	JSeparator  jseparator2= new JSeparator(JSeparator.HORIZONTAL);
	JSeparator  jseparator3= new JSeparator(JSeparator.HORIZONTAL);
	JSeparator  jseparator4= new JSeparator(JSeparator.HORIZONTAL);
	Dimension dimension= jseparator1.getPreferredSize();
	Dimension dim = jseparator2.getPreferredSize();
	Dimension dimension2= jseparator3.getPreferredSize();
	Dimension dim2 = jseparator4.getPreferredSize();


	class pane extends JPanel
	{
		pane()
		{
			setLayout(new GridLayout(4,2,25,25));

			mouthCB1=new JComboBox(Months);
			mouthCB1.setBackground(Color.white);
			yearCB1=new JComboBox();
			yearCB1.setBackground(Color.white);

			for(int i=2008;i<=2050;i++)
			{
				String year=""+i;
				yearCB1.addItem(year);
			}

			showBut=new JButton("Show");
			showBut.setBackground(Color.white);
			emp_IDTF1=new JTextField();
			JLabel tfL=new JLabel("Enter the Emp_ID");
			tfL.setForeground(new Color(100,250,175));
			JLabel cbL1=new JLabel("Select The Month");
			cbL1.setForeground(new Color(100,250,175));
			JLabel cbL2=new JLabel("Select The Year");
			cbL2.setForeground(new Color(100,250,175));

			add(tfL);
			add(emp_IDTF1);
			add(cbL1);
			add(mouthCB1);
			add(cbL2);
			add(yearCB1);
			add(showBut);
			add(new JLabel(" "));

			showBut.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					try
					{
						if(emp_IDTF1.getText().equals(""))
						{
							JOptionPane.showMessageDialog(null,"Enter the Emp_ID");
						}
						else
						{
							st=conn.createStatement();
							rs=st.executeQuery("select * from salary where month='"+(String)mouthCB1.getSelectedItem()+"' and year='"+(String)yearCB1.getSelectedItem()+"'and emp_Id='"+emp_IDTF1.getText()+"'");
							rs.next();
							{
								mouthCB.setSelectedItem(""+rs.getString(1));
								yearCB.setSelectedItem(""+rs.getString(2));
								emp_IDTF.setText(""+rs.getString(3));
								emp_NameTF.setText(""+rs.getString(4));
								emp_dept.setText(""+rs.getString(5));
								pres_DayTF.setText(""+rs.getString(6));
								bas_PayTF.setText(""+rs.getString(7));
								bas_AmtTF.setText(""+rs.getString(8));
								daTF.setText(""+rs.getString(9));
								Other_AllTF.setText(""+rs.getString(10));
								hraTF.setText(""+rs.getString(11));
								overtiTF.setText(""+rs.getString(12));
								tot_GrTf.setText(""+rs.getString(13));
								mediTF.setText(""+rs.getString(14));
								pfTF.setText(""+rs.getString(15));
								licTF.setText(""+rs.getString(16));
								advTF.setText(""+rs.getString(17));
								kantTF.setText(""+rs.getString(18));
								totDedTf.setText(""+rs.getString(19));
								totSaltf.setText(""+rs.getString(20));

								emp_IDTF1.setText("");
							}
						}
					}
					catch(Exception er)
					{
						JOptionPane.showMessageDialog(null,"Record Not Found");
					}
				}
			});
		}
	}
}