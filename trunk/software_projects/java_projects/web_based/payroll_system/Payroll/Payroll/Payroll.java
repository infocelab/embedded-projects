import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.sql.*;
import java.text.*;
import java.net.URL;
import java.applet.*;
import javax.swing.plaf.*;
import javax.swing.plaf.metal.*;
import javax.swing.border.*;


class Payroll extends JFrame implements ActionListener
{
	static JDesktopPane diskPane;
	JPanel south;
	JButton startBut;
	JButton timeField;
	JPopupMenu pMenu,deskMenu;
	DateFormat fmt;
	static int x,y;
	boolean startTO;

	JMenuItem empMaster,attenMaster,payment,deparment,basicSal,
			  Turnoff,attRepo,otRepo,overT;
	JMenu report;

	Payroll()
	{
		Dimension dim =Toolkit.getDefaultToolkit().getScreenSize();
		x=dim.width;
		y=dim.height;
		setSize(x,y);
		setUndecorated(true);
		setResizable(false);
		setLayout(new BorderLayout());


		diskPane=new JDesktopPane()
		{
			public void paintComponent(Graphics g)
			{
				bakImage(g);
			}
		};
		add(diskPane);

		startBut=new JButton("<html><body bgcolor=green><font size='5'><b><i>&nbsp;&nbsp;start&nbsp;&nbsp;</b></i></font></body></html>",new ImageIcon("Image/xp.jpg"));
		startBut.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		startBut.addActionListener(this);
		startBut.setBorder(BorderFactory.createRaisedBevelBorder());
		startBut.setForeground(new Color(255,255,255));
		startBut.setBackground(new Color(205,210,195));
		startBut.setMnemonic('S');

		south=new JPanel()
		{
			public void paintComponent(Graphics g)
			{
				Toolkit kit = Toolkit.getDefaultToolkit();
				Image img =kit.getImage("Image/bar.jpg");
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
					g.drawImage(img,0,0,x,35,null);

			}

		};
		south.setLayout(new BorderLayout());
		south.setBackground(new Color(205,210,195));
		south.setBorder(BorderFactory.createRaisedBevelBorder());
		south.add(startBut,"West");
		south.setBounds(0,y-30,x,40);
		add(south,"South");

		timeField=new JButton();
		timeField.setBorder(BorderFactory.createLoweredBevelBorder());
		timeField.setFont(new Font("Arial",Font.BOLD,12));
		timeField.setBackground(new Color(220,220,220));
//		timeField.setEditable(false);
		south.add(timeField,"East");

		timee=new javax.swing.Timer(1000,new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				java.util.Date now=new java.util.Date();
				String ss= DateFormat.getDateTimeInstance().format(now);
				timeField.setLabel(ss);
				timeField.setToolTipText(""+now);

			}
		});
		timee.start();

		empMaster=new JMenuItem("<html><body><font size='4'><b>&nbsp;&nbsp; Employee Master &nbsp;&nbsp;</b></font></body></html>");
		empMaster.addActionListener(this);
		empMaster.setBackground(new Color(205,210,195));
		empMaster.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,InputEvent.CTRL_MASK));

		attenMaster=new JMenuItem("<html><body><font size='4'><b>&nbsp;&nbsp; Attendence Entry &nbsp;&nbsp;</b></font></body></html>");
		attenMaster.addActionListener(this);
		attenMaster.setBackground(new Color(205,210,195));
		attenMaster.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,InputEvent.CTRL_MASK));

		payment=new JMenuItem("<html><body><font size='4'><b>&nbsp;&nbsp; Payment &nbsp;&nbsp;</b></font></body></html>");
		payment.addActionListener(this);
		payment.setBackground(new Color(205,210,195));
		payment.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P,InputEvent.CTRL_MASK));

		basicSal=new JMenuItem("<html><body><font size='4'><b>&nbsp;&nbsp; BasicSalary &nbsp;&nbsp;</b></font></body></html>");
		basicSal.addActionListener(this);
		basicSal.setBackground(new Color(205,210,195));
		basicSal.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B,InputEvent.CTRL_MASK));

		deparment=new JMenuItem("<html><body><font size='4'><b>&nbsp;&nbsp; DepartMent &nbsp;&nbsp;</b></font></body></html>");
		deparment.addActionListener(this);
		deparment.setBackground(new Color(205,210,195));
		deparment.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D,InputEvent.CTRL_MASK));

		report=new JMenu("<html><body><font size='4'><b>&nbsp;&nbsp; Report &nbsp;&nbsp;</b></font></body></html>");
		report.addActionListener(this);
		report.setBackground(new Color(205,210,195));
		report.setMnemonic('R');

		Turnoff=new JMenuItem("<html><body><font size='4'><b>&nbsp;&nbsp; Turn OFF Computer  &nbsp;&nbsp;</b></font></body></html>",new ImageIcon("Image/turnoff.png"));
		Turnoff.addActionListener(this);
		Turnoff.setBackground(new Color(205,210,195));
		Turnoff.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T,InputEvent.CTRL_MASK));

		attRepo=new JMenuItem("<html><body><font size='4'><b>&nbsp;&nbsp; Attendans Report &nbsp;&nbsp;</b></font></body></html>");
		attRepo.addActionListener(this);
		attRepo.setBackground(new Color(205,210,195));
		attRepo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,InputEvent.ALT_MASK));
		report.add(attRepo);

		otRepo=new JMenuItem("<html><body><font size='4'><b>&nbsp;&nbsp; Over Time Report Computer  &nbsp;&nbsp;</b></font></body></html>");
		otRepo.addActionListener(this);
		otRepo.setBackground(new Color(205,210,195));
		otRepo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,InputEvent.ALT_MASK));
		report.add(otRepo);

		overT=new JMenuItem("<html><body><font size='4'><b>&nbsp;&nbsp; OvetTime Entry &nbsp;&nbsp;</b></font></body></html>");
		overT.addActionListener(this);
		overT.setBackground(new Color(205,210,195));
		overT.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,InputEvent.CTRL_MASK));


		pMenu=new JPopupMenu();
		pMenu.add(empMaster);
		pMenu.add(deparment);
		pMenu.addSeparator();
		pMenu.add(attenMaster);
		pMenu.add(overT);
		pMenu.addSeparator();
		pMenu.add(payment);
		pMenu.add(basicSal);
		pMenu.addSeparator();
		pMenu.add(report);
		pMenu.addSeparator();
		pMenu.add(Turnoff);



		chanPass=new JMenuItem ("Change PassWord");
		chanPass.setBackground(new Color(205,210,195));
		chanPass.addActionListener(this);

		refreshMI=new JMenuItem ("Refresh");
		refreshMI.setBackground(new Color(205,210,195));
		gameM=new JMenu ("Game");
		gameM.setBackground(new Color(205,210,195));

		eaggMI=new JMenuItem("Eagg");
		eaggMI.setBackground(new Color(205,210,195));
		eaggMI.addActionListener(this);
		gameM.add(eaggMI);
		gameM.addSeparator();

		taleMI=new JMenuItem("Sheep");
		taleMI.setBackground(new Color(205,210,195));
		taleMI.addActionListener(this);
		gameM.add(taleMI);
		gameM.addSeparator();

		ballMI=new JMenuItem("Ball");
		ballMI.setBackground(new Color(205,210,195));
		ballMI.addActionListener(this);
		gameM.add(ballMI);

		LookandFillMI=new JMenu ("Look And Fill");
		LookandFillMI.setBackground(new Color(205,210,195));
		properMI=new JMenuItem ("Poperty");
		properMI.setBackground(new Color(205,210,195));


		metalMI=new JMenuItem("Metal");
		metalMI.addActionListener(this);
		motifMI=new JMenuItem("Motif");
		motifMI.addActionListener(this);
		WindowsMI=new JMenuItem("Windows");
		WindowsMI.addActionListener(this);

		LookandFillMI.add(metalMI);
		LookandFillMI.addSeparator();
		LookandFillMI.add(motifMI);
		LookandFillMI.addSeparator();
		LookandFillMI.add(WindowsMI);


		deskMenu=new JPopupMenu();
		deskMenu.add(chanPass);
		deskMenu.addSeparator();
		deskMenu.add(refreshMI);
		deskMenu.addSeparator();
		deskMenu.add(gameM);
		deskMenu.addSeparator();
		deskMenu.add(LookandFillMI);
		deskMenu.addSeparator();
		deskMenu.add(properMI);
		deskMenu.addSeparator();

		properMI.addActionListener(this);

		addMouseListener(new MouseAdapter()
		{
			public void mouseReleased(MouseEvent e)
			{
				if(e.isPopupTrigger())
				deskMenu.show(Payroll.this,e.getX(),e.getY());
			}
		});

		try
		{
			clsConnection connect=new clsConnection();
			conn = connect.setConnection(conn,"","");
		}
		catch(Exception e)
		{}

		BrownTheme sd=new BrownTheme();
		MetalLookAndFeel.setCurrentTheme (sd);

		try
		{UIManager.setLookAndFeel ("javax.swing.plaf.metal.MetalLookAndFeel");}
		catch (Exception ex) { }

		diskPane.setLayout(null);

		empBut=new JButton(new ImageIcon("Image/desk/emp.png"));
		empBut.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		empBut.addActionListener(this);
		empBut.setBounds(25,25,75,75);
		empBut.setBackground(Color.black);

		attenBut=new JButton(new ImageIcon("Image/desk/atte.png"));
		attenBut.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		attenBut.addActionListener(this);
		attenBut.setBounds(25,150,75,75);
		attenBut.setBackground(Color.black);

		payBut=new JButton(new ImageIcon("Image/desk/pay.png"));
		payBut.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		payBut.addActionListener(this);
		payBut.setBounds(25,275,75,75);
		payBut.setBackground(Color.black);

		depBut=new JButton(new ImageIcon("Image/desk/dept.png"));
		depBut.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		depBut.addActionListener(this);
		depBut.setBounds(25,400,75,75);
		depBut.setBackground(Color.black);

		basicBut=new JButton(new ImageIcon("Image/desk/basic.png"));
		basicBut.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		basicBut.addActionListener(this);
		basicBut.setBounds(25,525,75,75);
		basicBut.setBackground(Color.black);

		reportBut=new JButton(new ImageIcon("Image/desk/rep.png"));
		reportBut.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		reportBut.addActionListener(this);
		reportBut.setBounds(25,630,75,75);
		reportBut.setBackground(Color.black);

		empLB=new JTextArea("Emp Master");
		empLB.setBounds(25,100,75,20);
		empLB.setEditable(false);


		attenLB=new JTextArea("Daily Att.");
		attenLB.setBounds(25,225,75,20);
		attenLB.setEditable(false);

		payLB=new JTextArea("SalaryForm");
		payLB.setBounds(25,350,75,20);
		payLB.setEditable(false);

		depLB=new JTextArea("Department");
		depLB.setBounds(25,475,75,20);
		depLB.setEditable(false);

		basicLB=new JTextArea("Basic Form");
		basicLB.setBounds(25,600,75,20);
		basicLB.setEditable(false);

		reportLB=new JTextArea("Attends Rep.");
		reportLB.setBounds(25,705,75,20);
		reportLB.setEditable(false);

		diskPane.add(empBut);
		diskPane.add(attenBut);
		diskPane.add(payBut);
		diskPane.add(depBut);
		diskPane.add(basicBut);
		diskPane.add(reportBut);

		diskPane.add(empLB);
		diskPane.add(attenLB);
		diskPane.add(payLB);
		diskPane.add(depLB);
		diskPane.add(basicLB);
		diskPane.add(reportLB);

		Attendenc atten=new Attendenc();
		atten.requestFocus();
		diskPane.add(atten);
		atten.setVisible(true);


		addMouseListener(new Clicker());
		URL urlClick = Payroll.class.getResource("hit.wav");
		click = Applet.newAudioClip(urlClick);

	}
	private class Clicker extends MouseAdapter
	{
		public void mouseClicked(MouseEvent e)
		{
			if((e.getModifiers() & InputEvent.BUTTON3_MASK)!=0)
			{
				click.play();
			}
		}
	}
	public void actionPerformed(ActionEvent e)
	{
		Object obj=e.getSource();

		if(obj==startBut)
		{
			pMenu.show(startBut,10,10);
			click.play();
		}

		else if(obj==empMaster || obj==empBut)
		{
			click.play();
			Emp_Master E_Master=new Emp_Master();
			E_Master.requestFocus();
			diskPane.add(E_Master);
			E_Master.setVisible(true);

		}
		else if(obj==attenMaster || obj==attenBut)
		{
			click.play();
			Attendenc atten=new Attendenc();
			atten.requestFocus();
				diskPane.add(atten);
			atten.setVisible(true);

		}
		else if(obj==overT)
		{
			click.play();
			OverTime ot=new OverTime();
			ot.requestFocus();
			diskPane.add(ot);
			ot.setVisible(true);
		}
		else if(obj==payment || obj==payBut)
		{
			click.play();
			Salary salary=new Salary();
			salary.requestFocus();
			diskPane.add(salary);
			salary.setVisible(true);
		}
		else if(obj==attRepo || obj==reportBut)
		{
			click.play();
			Basic_Master basic_Master=new Basic_Master();
			basic_Master.requestFocus();
			diskPane.add(basic_Master);
			basic_Master.setVisible(true);
		}
		else if(obj==otRepo)
		{
			click.play();
			OT_Report ot=new OT_Report();
			diskPane.add(ot);
			ot.setVisible(true);
		}
		else if(obj==deparment || obj==depBut)
		{
			click.play();
			Department dept_Master=new Department();
			dept_Master.requestFocus();
			diskPane.add(dept_Master);
			dept_Master.setVisible(true);
		}
		else if(obj==Turnoff)
		{
			System.out.println("sham");
			click.play();
			CS.setVisible(true);
		}
		else if(obj==properMI)
		{
			click.play();
			property p=new property();
			p.requestFocus();
			diskPane.add(p);
			p.setVisible(true);
		}
		else if(obj==basicSal || obj==basicBut)
		{
			click.play();
			Settingswindow Set_Master=new Settingswindow();
			Set_Master.requestFocus();
			diskPane.add(Set_Master);
			Set_Master.setVisible(true);
		}
		else if(obj==motifMI)
		{
			click.play();
			try
			{
				UIManager.setLookAndFeel ("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
				SwingUtilities.updateComponentTreeUI(this);
			}
			catch (Exception ex) { }

		}
		else if(obj==metalMI)
		{
			click.play();
			try
			{
				UIManager.setLookAndFeel ("javax.swing.plaf.metal.MetalLookAndFeel");
				SwingUtilities.updateComponentTreeUI(this);
			}
			catch (Exception ex) { }

		}
		else if(obj==WindowsMI)
		{
			click.play();
			try
			{
				UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
				SwingUtilities.updateComponentTreeUI(this);

			}
			catch (Exception ex) { }
		}
		else if(obj==eaggMI)
		{
			try
			{
				Runtime rt = Runtime.getRuntime();
				rt.exec("game//EGGS");
			}
			catch(Exception er)
			{
				System.out.println(""+er);
			}
		}
		else if(obj==taleMI)
		{
			try
			{
				Runtime rt = Runtime.getRuntime();
				rt.exec("game//Mind games");
			}
			catch(Exception er)
			{
				System.out.println(""+er);
			}
		}
		else if(obj==ballMI)
		{
			try
			{
				Runtime rt = Runtime.getRuntime();
				rt.exec("game//ball");
			}
			catch(Exception er)
			{
				System.out.println(""+er);
			}
		}
		else if(obj==chanPass)
		{
			passWord pw=new passWord();
			diskPane.add(pw);
			pw.setVisible(true);

		}
	}
	public void bakImage(Graphics g)
	{
		try
		{
			st=conn.createStatement();
			ResultSet rs=st.executeQuery("select * from img");
			String s="Image/backgro/";
			while(rs.next())
			{
				String ss=rs.getString(2);
				Toolkit kit = Toolkit.getDefaultToolkit();
				img =kit.getImage(s+ss);
				img = img.getScaledInstance(1500, -1, Image.SCALE_FAST);
				//diskPane.repaint();
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
				g.drawImage(img,0,0,x,y ,null);
			}

		}
		catch(Exception re)
		{
		}
	}
	public static void pane(JDesktopPane pane)
	{
		diskPane=pane;
	}
	public void close()
	{
		setVisible(false);
		dispose();
	}
	closeSystem CS=new closeSystem();
	private Connection conn;
	private Statement st;
	private JMenuItem refreshMI,eaggMI,taleMI,ballMI,properMI,chanPass;
	private JMenuItem metalMI,motifMI,WindowsMI;
	private JMenu LookandFillMI,gameM;
	private Image img ;
	private javax.swing.Timer timee;
	private JButton empBut,attenBut,payBut,depBut,basicBut,reportBut;
	private JTextArea empLB,attenLB,payLB,depLB,basicLB,reportLB;
	AudioClip click;

	public static void main(String []args)
	{
		Payroll p=new Payroll();
		p.setVisible(true);
	}
}
class BrownTheme extends DefaultMetalTheme
{

	public String getName()
	{
		return "Brown";
	}

	private final ColorUIResource primary1 = new ColorUIResource (87, 87, 47);
	private final ColorUIResource primary2 = new ColorUIResource (159, 151, 111);
	private final ColorUIResource primary3 = new ColorUIResource (185, 160, 115);
	private final ColorUIResource secondary1 = new ColorUIResource (111, 111, 111);
	private final ColorUIResource secondary2 = new ColorUIResource (159, 159, 159);
	private final ColorUIResource secondary3 = new ColorUIResource (225, 200, 160);

	protected ColorUIResource getPrimary1() { return primary1; }
	protected ColorUIResource getPrimary2() { return primary2; }
	protected ColorUIResource getPrimary3() { return primary3; }
	protected ColorUIResource getSecondary1() { return secondary1; }
	protected ColorUIResource getSecondary2() { return secondary2; }
	protected ColorUIResource getSecondary3() { return secondary3; }

}
class passWord extends JInternalFrame
{
	passWord()
	{
		super("Change PassWord",false,true,false,false);
		setSize(350,150);
		setLocation(Payroll.x/5,Payroll.y/5);
		setBackground(Color.white);

		oldTF=new JPasswordField();
		oldTF.setForeground(Color.yellow);
		oldTF.setBackground(Color.black);
		oldTF.setFont(new Font("Arial",Font.BOLD,22));
		oldTF.setToolTipText("Enter The Old Id");
		oldTF.setCaretColor(Color.red);
		oldTF.setSelectedTextColor(Color.blue);
		oldTF.setSelectionColor(Color.gray);


		newTF=new JPasswordField();
		newTF.setForeground(Color.green);
		newTF.setBackground(Color.black);
		newTF.setFont(new Font("Arial",Font.BOLD,22));
		newTF.setToolTipText("Enter The New Id");
		newTF.setCaretColor(Color.red);
		newTF.setSelectedTextColor(Color.blue);
		newTF.setSelectionColor(Color.gray);

		okBut=new JButton(" OK ");
		okBut.setBackground(Color.DARK_GRAY);
		okBut.setForeground(Color.green);
		canBut=new JButton("Cancel");
		canBut.setBackground(Color.DARK_GRAY);
		canBut.setForeground(Color.red);

		setLayout(new GridLayout(3,2,25,10));

		add(new JLabel(" Enter the Old PassWord "));
		add(oldTF);
		add(new JLabel(" Enter the New PassWord "));
		add(newTF);
		add(okBut);
		add(canBut);

		okBut.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if(oldTF.getText().equals("") || newTF.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null,"Enter the Old Password & New PassWord");
				}
				else
				{
					try
					{
						clsConnection connect=new clsConnection();
						conn = connect.setConnection(conn,"","");
						st=conn.createStatement();
						rs=st.executeQuery("Select * from img");
						rs.next();
						{
							if(oldTF.getText().equals(rs.getString(3)))
							{
								st.executeUpdate("update img set Pass='"+newTF.getText()+"' where ID LIKE 1");
								JOptionPane.showMessageDialog(null,"Success");
								oldTF.setText("");
								newTF.setText("");oldTF.requestFocus();
							}
							else
							{
								JOptionPane.showMessageDialog(null,"The Old PassWord Is Wrong");
								oldTF.setText("");
								newTF.setText("");oldTF.requestFocus();

							}
						}
					}
					catch(Exception er)
					{
						JOptionPane.showMessageDialog(null,""+er);
					}
				}
			}
		});
		canBut.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				dispose();
			}
		});


	}
	JPasswordField oldTF,newTF;
	JButton okBut,canBut;
	private Connection conn;
	private Statement st;
	private ResultSet rs;

}
