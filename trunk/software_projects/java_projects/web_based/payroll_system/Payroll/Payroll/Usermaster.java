import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import javax.swing.Timer;
import java.sql.*;
import java.net.URL;
import java.applet.*;
class Usermaster extends JFrame
{
	JPanel center;
	JButton login;
	JPasswordField pass;
	JLabel titleLb,output;
	private Statement st;
	private Connection conn;
	private ResultSet rs;
	int x,y;
	Usermaster()
	{
		Dimension dim =Toolkit.getDefaultToolkit().getScreenSize();
		x=dim.width;
		y=dim.height;
		setSize(x,y);
		setUndecorated(true);

		Container c=getContentPane();

		center=new JPanel()
		{
			public void paintComponent(Graphics g)
			{
				Toolkit kit = Toolkit.getDefaultToolkit();
				Image img =kit.getImage("Image/user.jpg");
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
				g.drawImage(img,0,0,x,y,null);
			}
		};

		c.add(center);
		center.setLayout(null);

		titleLb=new JLabel("<html><body ><font size='5'><b><i>&nbsp;&nbsp; User Name &nbsp;&nbsp;</b></i></font></body></html>");
		titleLb.setForeground(new Color(10,110,255));
		titleLb.setBounds(x/2+50,x/4,150,50);
		center.add(titleLb);


		output=new JLabel("<html><body ><font size='5'><b><i>&nbsp;&nbsp; OUTPUT &nbsp;&nbsp;</b></i></font></body></html>");
		output.setForeground(Color.white);
		output.setBounds(x/2-250,x/6,150,50);
		center.add(output);

		login=new JButton(new ImageIcon("Image/logBut.gif"));
		login.setBorder(BorderFactory.createRaisedBevelBorder());
		login.setBounds(x/2+100,x/2-70,100,100);
		login.setBackground(Color.white);


		pass=new JPasswordField();
		pass.setToolTipText("Enter The Password To Payroll System");
		login.requestFocus();
		pass.setBorder(BorderFactory.createRaisedBevelBorder());
		pass.setForeground(new Color(10,110,255));
		pass.setFont(new Font("Arial",Font.BOLD,22));
		pass.setCaretColor(Color.red);
		pass.setBounds(x/2+50,x/3,200,35);
		center.add(pass);
		center.add(login);


		pass.addKeyListener(new KeyAdapter()
		{
			public void keyPressed(KeyEvent e)
			{
				output.setText("<html><body ><font size='5'><b><i>&nbsp;&nbsp; OUTPUT &nbsp;&nbsp;</b></i></font></body></html>");
				output.setForeground(Color.white);
			}
		});

		try
		{
			clsConnection connect=new clsConnection();
			conn = connect.setConnection(conn,"","");
		}
		catch(Exception e)
		{}


		login.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					st=conn.createStatement();
					rs=st.executeQuery("select * from img");
					while(rs.next())
					{
						if(pass.getText().equals(rs.getString(3)))
						{
							setVisible(false);
							URL url= closeSystem.class.getResource("spacemusic.au");
							click = Applet.newAudioClip(url);
							click.play();
							paro.setVisible(true);
						}
						else
						{
							pass.setText("");
							pass.requestFocus();
							output.setText("Fell");
							output.setFont(new Font("Arial",Font.BOLD,36));
							output.setForeground(Color.red);
						}
					}
				}
				catch(Exception er)
				{
					System.out.println("Sorry\n"+er);
				}
			}
		});

	}
	Payroll paro=new Payroll();
	AudioClip click;
}


