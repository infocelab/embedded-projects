import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.io.*;
import java.util.*;
import java.sql.*;
import javax.swing.border.*;

class Emp_Master extends JInternalFrame implements ActionListener
{
	int x,y;
	Emp_Master()
	{
		super("Employee Master ",true,true,true,true);
		Dimension dim =Toolkit.getDefaultToolkit().getScreenSize();
		x=dim.width;
		y=dim.height-35;
		setSize(x,y);

		empTF_Id=new JTextField(15);
		empTF_Name=new JTextField(25);
		validation.keyEvent(empTF_Name,true);
		empTF_city=new JTextField(20);
		validation.keyEvent(empTF_city,true);
		empTF_pinCod=new JTextField(20);
		validation.keyEvent(empTF_pinCod,false);
		empTF_Ph=new JTextField(20);
		validation.keyEvent(empTF_Ph,false);
		empTF_Mobil=new JTextField(20);
		validation.keyEvent(empTF_Mobil,false);
		empTF_Quli=new JTextField(20);
		empTF_Acc=new JTextField(20);
		empTF_Pfno=new JTextField(20);

		String sex[]={"Male","Female"};
		empCB_sex=new JComboBox(sex);
		empCB_cate=new JComboBox(category);
		empTF_gade=new JComboBox(grade);
		empTF_Dept=new JComboBox ();
		empCB_Bday=new JComboBox();
		empCB_Bmon=new JComboBox(Months);
		empCB_Byear=new JComboBox();
		empCB_Jday=new JComboBox();
		empCB_Jmon=new JComboBox(Months);
		empCB_Jyear=new JComboBox();
		//empCB_act=new JComboBox();


		for(int i=1;i<=31;i++)
		{
			String day=""+i;
			empCB_Bday.addItem(day);
			empCB_Jday.addItem(day);
		}
		for(int i=1950;i<=2020;i++)
		{
			String year=""+i;
			empCB_Byear.addItem(year);
			empCB_Jyear.addItem(year);

		}

		Container c= getContentPane();
		c.setLayout(new BorderLayout());

		JPanel pa=new JPanel();
		pa.setBorder(new LineBorder(Color.LIGHT_GRAY,3));
		pa.setBackground(Color.gray);
		titleLabel=new JLabel("Employee Master");
		titleLabel.setForeground(new Color(255,255,255));
		titleLabel.setFont(new Font("Arial",Font.BOLD,20));
		pa.add(titleLabel);
		add(pa,"North");


		north=new JPanel()
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
					g.drawImage(img,0,0,Payroll.x/2+175,Payroll.y-35,null);

			}

		};
		c.add(north,"West");
		north.setLayout(new GridLayout(16,2,10,10));
		north.setBorder(BorderFactory.createRaisedBevelBorder());

		north.add(new JLabel("<html><body><font size='4'><b>&nbsp;&nbsp;"+ label[0]+" &nbsp;&nbsp;</b></font></body></html>"));
		north.add(empTF_Id);
		north.add(new JLabel("<html><body><font size='4'><b>&nbsp;&nbsp;"+ label[5]+" &nbsp;&nbsp;</b></font></body></html>"));
		north.add(empTF_gade);
		north.add(new JLabel("<html><body><font size='4'><b>&nbsp;&nbsp;"+ label[1]+" &nbsp;&nbsp;</b></font></body></html>"));
		north.add(empTF_Name);
		north.add(new JLabel("<html><body><font size='4'><b>&nbsp;&nbsp;"+ label[9]+" &nbsp;&nbsp;</b></font></body></html>"));
		north.add(sp);
		area.setLineWrap(true);
		north.add(new JLabel("<html><body><font size='4'><b>&nbsp;&nbsp;"+ label[4]+" &nbsp;&nbsp;</b></font></body></html>"));
		north.add(empCB_cate);
		north.add(new JLabel("<html><body><font size='4'><b>&nbsp;&nbsp;"+ label[2]+" &nbsp;&nbsp;</b></font></body></html>"));
		north.add(empTF_Dept);
		north.add(new JLabel("<html><body><font size='4'><b>&nbsp;&nbsp;"+ label[3]+" &nbsp;&nbsp;</b></font></body></html>"));
		north.add(empCB_sex);

		panel1=new JPanel();
		panel2=new JPanel();

		panel1.setLayout(new GridLayout(1,4,5,5));
		panel2.setLayout(new GridLayout(1,4,5,5));


		north.add(new JLabel("<html><body><font size='4'><b>&nbsp;&nbsp;"+ label[6]+" &nbsp;&nbsp;</b></font></body></html>"));
		north.add(panel1);
		panel1.add(empCB_Bday);
		panel1.add(empCB_Bmon);
		panel1.add(empCB_Byear);
		/*west.add(new JLabel(" "));
		west.add(new JLabel(" DD - "));
		west.add(new JLabel(" MM - "));
		west.add(new JLabel(" YYYY  "));*/
		north.add(new JLabel("<html><body><font size='4'><b>&nbsp;&nbsp;"+ label[7]+" &nbsp;&nbsp;</b></font></body></html>"));
		north.add(panel2);
		panel2.add(empCB_Jday);
		panel2.add(empCB_Jmon);
		panel2.add(empCB_Jyear);

		north.add(new JLabel("<html><body><font size='4'><b>&nbsp;&nbsp;"+ label[10]+" &nbsp;&nbsp;</b></font></body></html>"));
		north.add(empTF_city);
		north.add(new JLabel("<html><body><font size='4'><b>&nbsp;&nbsp;"+ label[11]+" &nbsp;&nbsp;</b></font></body></html>"));
		north.add(empTF_pinCod);
		north.add(new JLabel("<html><body><font size='4'><b>&nbsp;&nbsp;"+ label[12]+" &nbsp;&nbsp;</b></font></body></html>"));
		north.add(empTF_Ph);
		north.add(new JLabel("<html><body><font size='4'><b>&nbsp;&nbsp;"+ label[13]+" &nbsp;&nbsp;</b></font></body></html>"));
		north.add(empTF_Mobil);
		north.add(new JLabel("<html><body><font size='4'><b>&nbsp;&nbsp;"+ label[14]+" &nbsp;&nbsp;</b></font></body></html>"));
		north.add(empTF_Quli);
		north.add(new JLabel("<html><body><font size='4'><b>&nbsp;&nbsp;"+ label[15]+" &nbsp;&nbsp;</b></font></body></html>"));
		north.add(empTF_Acc);
		north.add(new JLabel("<html><body><font size='4'><b>&nbsp;&nbsp;"+ label[16]+" &nbsp;&nbsp;</b></font></body></html>"));
		north.add(empTF_Pfno);

		south=new JPanel();
		south.setBorder(BorderFactory.createRaisedBevelBorder());
		south.setLayout(new GridLayout(1,5,25,25));
		add(south,"South");

		pituBut=new JButton("<html><body><font size='3'><b>&nbsp;&nbsp;img&nbsp;&nbsp;</b></font></body></html>",new ImageIcon("Image/empPHT.png"));
		pituBut.setMnemonic('I');

		saveBut=new JButton("<html><body><font size='3'><b>&nbsp;&nbsp;Save &nbsp;&nbsp;</b></font></body></html>");
		saveBut.setMnemonic('K');
		saveBut.setBackground(new Color(255,255,255));

		modifyBut=new JButton("<html><body><font size='3'><b>&nbsp;&nbsp;Modify &nbsp;&nbsp;</b></font></body></html>");
		modifyBut.setBackground(new Color(255,255,255));
		modifyBut.setMnemonic('M');

		deleBut=new JButton("<html><body><font size='3'><b>&nbsp;&nbsp;Delete &nbsp;&nbsp;</b></font></body></html>");
		deleBut.setBackground(new Color(255,255,255));
		deleBut.setMnemonic('D');

		searBut=new JButton("<html><body><font size='3'><b>&nbsp;&nbsp;Search &nbsp;&nbsp;</b></font></body></html>");
		searBut.setBackground(new Color(255,255,255));
		searBut.setMnemonic('S');

		viewBut=new JButton("<html><body><font size='3'><b>&nbsp;&nbsp;View &nbsp;&nbsp;</b></font></body></html>");
		viewBut.setBackground(new Color(255,255,255));
		viewBut.setMnemonic('V');

		clearBut=new JButton("<html><body><font size='3'><b>&nbsp;&nbsp;Clear &nbsp;&nbsp;</b></font></body></html>");
		clearBut.setBackground(new Color(255,255,255));
		clearBut.setMnemonic('C');

		firstBut=new JButton("",new ImageIcon("Image/first.png"));
		firstBut.setMnemonic('F');
		nextBut=new JButton("",new ImageIcon("Image/next.png"));
		nextBut.setMnemonic('N');
		preBut=new JButton("",new ImageIcon("Image/prev.png"));
		preBut.setMnemonic('P');
		lastBut=new JButton("",new ImageIcon("Image/last.png"));
		lastBut.setMnemonic('L');

		closeBut=new JButton("<html><body><font size='2'><b>&nbsp;&nbsp;Exit &nbsp;&nbsp;</b></font></body></html>");
		closeBut.setMnemonic('X');


		south.add(firstBut);
		firstBut.setBackground(Color.gray);
		south.add(nextBut);
		nextBut.setBackground(Color.gray);
		south.add(preBut);
		preBut.setBackground(Color.gray);
		south.add(lastBut);
		lastBut.setBackground(Color.gray);
		south.add(closeBut);
		closeBut.setBackground(Color.gray);
		closeBut.setForeground(Color.red);


		east=new JPanel();
		east.setBorder(BorderFactory.createLoweredBevelBorder());
		east.setLayout(null);
		//east.setBorder(new LineBorder(Color.LIGHT_GRAY,3));
		east.setBackground(Color.gray);
		JScrollPane sp=new JScrollPane(east);
		add(sp);

		pictuLabel=new PicturePanel();
		pictuLabel.setBounds(05,05,150,150);
		east.add(pictuLabel);

		JPanel p=new JPanel();
		p.setBackground(Color.gray);

		p.setBounds(10,200,100,250);
		east.add(p);
		p.setLayout(new GridLayout(7,1,10,10));
		p.add(pituBut);
		p.add(saveBut);
		p.add(modifyBut);
		p.add(deleBut);
		p.add(searBut);
		p.add(viewBut);
		p.add(clearBut);


		saveBut.addActionListener(this);
		modifyBut.addActionListener(this);
		deleBut.addActionListener(this);
		searBut.addActionListener(this);
		pituBut.addActionListener(this);
		viewBut.addActionListener(this);
		clearBut.addActionListener(this);
		firstBut.addActionListener(this);
		nextBut.addActionListener(this);
		preBut.addActionListener(this);
		lastBut.addActionListener(this);
		closeBut.addActionListener(this);
		displayBut(false);

		try
		{
			clsConnection connect=new clsConnection();
			conn = connect.setConnection(conn,"","");

			st=conn.createStatement();
			rs=st.executeQuery("Select * from Dep_Master");
			while(rs.next())
			{
				empTF_Dept.addItem(rs.getString(2));

			}
		}
		catch(Exception er){}
	}
	public void actionPerformed(ActionEvent e)
	{
		Object obj=e.getSource();
		try{scrollDate(obj);}catch(Exception er){JOptionPane.showMessageDialog(null,""+er);}

		if(obj==saveBut)
		{
			if(empTF_Id.getText().equals("")||empTF_Name.getText().equals("")||empTF_city.getText().equals("")||empTF_pinCod.getText().equals("")||empTF_Ph.getText().equals("")||empTF_Mobil.getText().equals("")||empTF_Quli.getText().equals("")||empTF_Acc.getText().equals("")||empTF_Pfno.getText().equals(""))
			{
				JOptionPane.showMessageDialog(null,"Please All Field FillUp It");
			}
			else
			{
				dataFunction("insert into Emp_Master values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			}
		}
		else if(obj==modifyBut)
		{
			if(empTF_Id.getText().equals(""))
			{
				JOptionPane.showMessageDialog(null,"Please Emp Id Field FillUp It");
			}
			else
			{
				dataFunction("update Emp_Master Set emp_Id=?,grade=?,emp_Name=?,address=?,categary=?,dept_Name=?,sex=?,b_Date=?,j_Date=?,city=?,pincode=?,ph_no=?,mobil=?,qualify=?,bank_AC=?,PF_no=?,img=? WHERE emp_Id LIKE '"+empTF_Id.getText()+"'");
			}


		}
		else if(obj==deleBut)
		{
			displayBut(false);
			if(empTF_Id.getText().equals(""))
			{
				JOptionPane.showMessageDialog(null,"Please Emp Id Field FillUp It");
			}
			else
			{
				try
				{
					ps=conn.prepareStatement("delete from Emp_Master where (emp_Id=?)");
					ps.setString(1,empTF_Id.getText());
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
		else if(obj==searBut)
		{
			try
			{
				String s=JOptionPane.showInputDialog(null,"Enter the Employee ID");
				searchFunction("select * from Emp_Master order by emp_Id= '"+s+"'");
			}
			catch(Exception er)
			{
				JOptionPane.showMessageDialog(null,""+er);
			}
		}
		else if(obj==pituBut)
		{
			displayBut(false);
			filepath = getImageFile();
			painting(filepath);
		}
		else if(obj==clearBut)
		{
			displayBut(false);
			clear();
		}
		else if(obj==closeBut)
		{
			dispose();
			displayBut(false);
			Payroll.diskPane.requestFocus();
		}
		else if(obj==viewBut)
		{
			Emp_Report eReport=new Emp_Report();
			Payroll.diskPane.add(eReport);
			eReport.setVisible(true);
			displayBut(false);
		}
	}
	public void dataFunction(String s)
	{
		displayBut(false);
		String birth=""+(String)empCB_Bday.getSelectedItem()+"/"+(String)empCB_Bmon.getSelectedItem()+"/"+(String)empCB_Byear.getSelectedItem();
		String joinDate=""+(String)empCB_Jday.getSelectedItem()+"/"+(String)empCB_Jmon.getSelectedItem()+"/"+(String)empCB_Jyear.getSelectedItem();
		try
		{
			ps=conn.prepareStatement(s);
			ps.setString(1,empTF_Id.getText());
			ps.setString(2,(String)empTF_gade.getSelectedItem());
			ps.setString(3,empTF_Name.getText());
			ps.setString(4,area.getText());
			ps.setString(5,(String)empCB_cate.getSelectedItem());
			ps.setString(6,(String)empTF_Dept.getSelectedItem());
			ps.setString(7,(String)empCB_sex.getSelectedItem());
			ps.setString(8,""+birth);
			ps.setString(9,""+joinDate);
			ps.setString(10,empTF_city.getText());
			ps.setString(11,empTF_pinCod.getText());
			ps.setString(12,empTF_Ph.getText());
			ps.setString(13,empTF_Mobil.getText());
			ps.setString(14,empTF_Quli.getText());
			ps.setString(15,empTF_Acc.getText());
			ps.setString(16,empTF_Pfno.getText());
			ps.setString(17,""+filepath );

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
	public void searchFunction(String query)throws Exception
	{
		st=conn.createStatement();
		rs=st.executeQuery(query);
		rs.next();
		{
			searchFunction();
		}
	}
	public void searchFunction()throws Exception
	{
		empTF_Id.setText(""+rs.getString(1));
		empTF_gade.setSelectedItem(""+rs.getString(2));
		empTF_Name.setText(""+rs.getString(3));
		area.setText(""+rs.getString(4));
		empCB_cate.setSelectedItem(""+rs.getString(5));
		empTF_Dept.setSelectedItem(""+rs.getString(6));
		empCB_sex.setSelectedItem(""+rs.getString(7));
		String tok1=rs.getString(8);
		String tok2=rs.getString(9);
		StringTokenizer token1=new StringTokenizer(tok1,"/");
		StringTokenizer token2=new StringTokenizer(tok2,"/");
		empCB_Bday.setSelectedItem(token1.nextToken());
		empCB_Bmon.setSelectedItem(token1.nextToken());
		empCB_Byear.setSelectedItem(token1.nextToken());
		empCB_Jday.setSelectedItem(token2.nextToken());
		empCB_Jmon.setSelectedItem(token2.nextToken());
		empCB_Jyear.setSelectedItem(token2.nextToken());
		empTF_city.setText(""+rs.getString(10));
		empTF_pinCod.setText(""+rs.getString(11));
		empTF_Ph.setText(""+rs.getString(12));
		empTF_Mobil.setText(""+rs.getString(13));
		empTF_Quli.setText(""+rs.getString(14));
		empTF_Acc.setText(""+rs.getString(15));
		empTF_Pfno.setText(""+rs.getString(16));

		painting(rs.getString(17));
		pictuLabel.repaint();
	}
	public void dataConnection()
	{
		try
		{
			st=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			rs=st.executeQuery("select * from Emp_Master");
		}
		catch(Exception er)
		{
			JOptionPane.showMessageDialog (null, ""+er);
		}
	}
	public void scrollDate(Object obj)throws Exception
	{

		if(obj==firstBut)
		{
			dataConnection();
			if(rs.first())
			{
				displayBut(true);
				//empTF_Id.setText(""+rs.getString(1));
				searchFunction();
			}
		}
		if(obj==nextBut)
		{
			if(rs.next())
			{
				//empTF_Id.setText(""+rs.getString(1));
				searchFunction();
			}
		}
		if(obj==preBut)
		{
			if(rs.previous())
			{
				//empTF_Id.setText(""+rs.getString(1));
				searchFunction();
			}
		}
		if(obj==lastBut)
		{
			if(rs.last())
			{
				empTF_Id.setText(""+rs.getString(1));
				searchFunction();
			}
		}
	}
	public void painting(String s)
	{

		if (s!= null)
		{
			Toolkit kit = Toolkit.getDefaultToolkit();
			img =kit.getImage(s);
			MediaTracker t=new MediaTracker(this);
			img = img.getScaledInstance(200, -1, Image.SCALE_FAST);
			t.addImage(img,0);
			while(true)
			{
				try
				{
					t.waitForAll();
					break;
				}catch(Exception ee){}
			}
			pictuLabel.repaint();
		}
	}
	private String getImageFile()
	{
		JFileChooser fc = new JFileChooser();
		fc.setFileFilter(new ImageFilter());
		int result = fc.showOpenDialog(null);
		File file = null;
		if (result == JFileChooser.APPROVE_OPTION)
		{
			file = fc.getSelectedFile();
			return file.getPath();
		}
		else
		return null;
	}

	private class PicturePanel extends JPanel
	{
		public void paint(Graphics g)
		{
			//g.drawImage(img,150,175, this);
			g.drawImage(img,0,0,null);
		}
	}

	private class ImageFilter  extends javax.swing.filechooser.FileFilter
	{
		public boolean accept(File f)
		{
			if (f.isDirectory())
				return true;
			String name = f.getName();
			if (name.matches(".*((.jpg)|(.gif)|(.png))"))
			   return true;
			else
			   return false;
		}

		public String getDescription()
		{
			return "Image files (*.jpg, *.gif, *.png)";
		}
	}
	public void clear()
	{
		empTF_Id.setText("");
		empTF_Name.setText("");
		empTF_city.setText("");
		empTF_pinCod.setText("");
		empTF_Ph.setText("");
		empTF_Mobil.setText("");
		empTF_Quli.setText("");
		empTF_Acc.setText("");
		empTF_Pfno.setText("");
		area.setText("");
		painting("");
		pictuLabel.repaint();
	}
	public void displayBut(boolean b)
	{
		nextBut.setEnabled(b);
		preBut.setEnabled(b);
		lastBut.setEnabled(b);
	}

	Image img;
	private String label[]={"Employee Id","Employee Name","Employee Department","Employee Sex","Employee Catagory","Employee Grade","EmpBirth","Emp JoinDate",
					"Active/Inactiv","Employee Address","Employee City","Employee Pincode","Employee Ph.No","Employee Mob.No.","Employee Qulification","Employee Bank A/c",
					"Employee PF. No"};
	private String Months[] = {"Janruary		", "February", "March", "April", "May", "June", "July",
					"August", "September", "October", "November", "December"};

	private String category[]={"Genral","OBC","NT","VJNT","NT-A","NT-B","NT-C","SC","ST",};
	private String grade[]={"First","Secound","Third","Fourth","Fifth"};

	PicturePanel pictuLabel;

	private JTextField empTF_Id, empTF_Name,empTF_city,empTF_pinCod,empTF_Ph,empTF_Mobil,empTF_Quli,empTF_Acc,empTF_Pfno;

	private JTextArea area=new JTextArea();
	private JScrollPane sp=new JScrollPane(area);

	private JComboBox empCB_sex,empCB_cate,empTF_gade,empTF_Dept,
			empCB_Bday,empCB_Bmon,empCB_Byear,empCB_Jday,empCB_Jmon,empCB_Jyear,
			empCB_act;
	private JPanel north,panel1,panel2;
	private JLabel titleLabel;
	private JPanel south,east;
	private JButton saveBut,modifyBut,deleBut,searBut,pituBut,viewBut,clearBut;
	private JButton firstBut,nextBut,preBut,lastBut,closeBut;

	String filepath ;

	private Connection conn;
	private PreparedStatement ps;
	private Statement st;
	private ResultSet rs,rs1;

}
