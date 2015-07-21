import javax.swing.*;
import javax.swing.plaf.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.plaf.metal.*;
import java.sql.*;
import java.io.*;
import javax.swing.event.*;
import javax.swing.Timer;
import javax.swing.plaf.*;
import javax.swing.plaf.metal.*;
import com.sun.java.swing.plaf.motif.*;
import com.sun.java.swing.plaf.windows.*;

class LoginTest
{
	public static void main(String args[])
	{
		LoginFrame f=new LoginFrame();
		f.setVisible(true);
		f.setDefaultCloseOperation(3);
	}
}
class LoginFrame extends JFrame
{
	JTextField tf=new JTextField(12);
	JPasswordField pf=new JPasswordField(12);
	Connection conn;
	Statement stat;
	ResultSet set;
	ChangePass pass;
	JPanel progressPanel;
	JProgressBar bar;
	private Timer activityMonitor;
	private SimulatedActivity activity;
	Container c;
	JPanel main;JButton changepw;
	int width;
	int height;
	Dimension screenSize;
	static StartTeacherMessage stm;
	LoginFrame()
	{
		Toolkit kits=Toolkit.getDefaultToolkit();
		screenSize=kits.getScreenSize();
		width=screenSize.width/3;
		height=screenSize.height/3;
		setSize(width,height);
		setResizable(false);
		setLocation(screenSize.width/3,screenSize.height/4);
		LoginFrame.setDefaultLookAndFeelDecorated(true);
		try
		{
		  // UIManager.setLookAndFeel(new MotifLookAndFeel());
          // SwingUtilities.updateComponentTreeUI(this);
		}
		catch(Exception es)
		{}

		setTitle("Login");
		Image img=Toolkit.getDefaultToolkit().getImage("mainicon.png");
		setIconImage(img);
		try
		{
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		}
		catch(Exception e)
		{

		}

		c=getContentPane();
		tf.setBorder(BorderFactory.createBevelBorder(1, new Color(200, 200, 200), new Color(200, 200, 200)));
		pf.setBorder(BorderFactory.createBevelBorder(1, new Color(200, 200, 200), new Color(200, 200, 200)));
		tf.setMaximumSize(tf.getPreferredSize());
		pf.setMaximumSize(tf.getPreferredSize());
		JButton ok=new JButton("OK");
		JButton clear=new JButton("Clear");
		JButton exit=new JButton("Exit ");
		exit.setMnemonic(KeyEvent.VK_F4);
		changepw=new JButton("Change Password");
		progressPanel=new JPanel()
		{
			public void paintComponent(Graphics g)
			{
				Toolkit kit=Toolkit.getDefaultToolkit();
				Image img=kit.getImage("Gradien.jpg");
				MediaTracker t=new MediaTracker(this);
				t.addImage(img,1);
				while(true)
				{
					try
					{
						t.waitForID(1);
						break;
					}
					catch(Exception e)
					{
					}
				}
				g.drawImage(img,0,0,width,height+100,null);
			}

		};
		bar=new JProgressBar();
		bar.setStringPainted(true);
		bar.setMaximum(1000);
		bar.setString("Loading...");
		progressPanel.add(bar);
		bar.setVisible(false);
		c.add("South",progressPanel);
		activity = new SimulatedActivity(1000);
        activity.start();
		activityMonitor = new Timer(500, new
		 ActionListener()
		 {
			public void actionPerformed(ActionEvent event)
			{
			   int current = activity.getCurrent();

			   // show progress
			   bar.setValue(current);

			   // check if task is completed
			   if (current == activity.getTarget())
			   {
				  activityMonitor.stop();
				  MainMenuFrame f=new MainMenuFrame();
				  f.setVisible(true);

				 try
				 {
					DataInputStream sin=new DataInputStream(new FileInputStream("status.dat"));
					String st=sin.readUTF();
					boolean flag=false;
					if(st.equals("true"))
						flag=true;
					stm=new StartTeacherMessage();
				  	stm.startMsg(flag);
				  	if(flag)
				  	{
				  		Message m=new Message("Msg.jpg");
				  		synchronized(m)
				  		{
				  			m.start();
						}
					}
				}
				 catch(Exception ex)
				 {
				 }
				  ;


				dispose();
			   }
			}
 		});
 		main=new JPanel()
 		{
			public void paintComponent(Graphics g)
			{
				Toolkit kit=Toolkit.getDefaultToolkit();
				Image img=kit.getImage("Gradien.jpg");
				MediaTracker t=new MediaTracker(this);
				t.addImage(img,1);
				while(true)
				{
					try
					{
						t.waitForID(1);
						break;
					}
					catch(Exception e)
					{
					}
				}
				g.drawImage(img,0,0,width,height+20,null);
			}
		};
		JPanel im=new JPanel()
		{
			public void paintComponent(Graphics g)
			{
				Toolkit kit=Toolkit.getDefaultToolkit();
				Image img=kit.getImage("Gradien.jpg");
				MediaTracker t=new MediaTracker(this);
				t.addImage(img,1);
				while(true)
				{
					try
					{
						t.waitForID(1);
						break;
					}
					catch(Exception e)
					{
					}
				}
				g.drawImage(img,0,0,width,height,null);
			}

		};
		im.add(changepw);
		main.setLayout(new GridBagLayout());
		GridBagConstraints cons=new GridBagConstraints();
		cons.fill=GridBagConstraints.HORIZONTAL;
		cons.anchor=GridBagConstraints.EAST;
		cons.weightx=10;
		cons.weighty=00;

		cons.insets = new Insets(7, 25, 0, 5);

		add(new JLabel("User Name "),cons,0,0,1,1);
		cons.insets = new Insets(0, 25, 0, 0);
		add(new JLabel("Password   "),cons,0,1,1,1);
		cons.fill=GridBagConstraints.BOTH;
		cons.weightx=40;
		cons.insets = new Insets(7, 0, 5, 13);

		add(tf,cons,1,0,2,1);
		cons.insets = new Insets(0, 0, 5, 13);
		add(pf,cons,1,1,2,1);
		cons.insets = new Insets(10, 5, 0, 0);
		add(ok,cons,0,2,1,1);
		cons.insets = new Insets(10, 5, 0, 0);
		add(clear,cons,1,2,1,1);
		cons.insets = new Insets(10, 5, 0, 5);
		add(exit,cons,2,2,1,1);
		cons.insets = new Insets(10, 0, 0, 0);
		add(im,cons,0,3,3,1);
		ok.setToolTipText("Save Password");
		clear.setToolTipText("Clear Text");
		exit.setToolTipText("Exit");
		tf.setToolTipText("Enter the User Name");
		pf.setToolTipText("Enter the Password");
		changepw.setToolTipText("Change The password");
		//Font ft=new Font("comic sans ms",Font.PLAIN,20);
		//tf.setFont(ft);
		//tf.setForeground(new Color(0,0,0));
		//pf.setFont(ft);
		//pf.setForeground(new Color(0,0,0));
		pf.addKeyListener(new KeyAdapter()
		{
			public void keyPressed(KeyEvent e)
			{
				if((e.getKeyCode())==KeyEvent.VK_ENTER)
				{
				boolean flag=false;
				String s="";
				s=tf.getText();
				char a[]=pf.getPassword();
				String u_name=null;
				String p_name=null;
				try
				{
				conn=DriverManager.getConnection("jdbc:odbc:Student_Info","raj","17java71");
				stat=conn.createStatement();
				set=stat.executeQuery("Select * from Login");
				set.next();
				u_name=set.getString(1);
				p_name=set.getString(2);
				}
				catch(Exception ex)
				{
				}

				if(s.equals(u_name) && a.length==p_name.length())
				{
					for(int i=0;i<p_name.length();i++)
					{
					  if(a[i]==p_name.charAt(i))
					       flag=true;
					  else
					  {
					       flag=false;
					       break;
					  }


					}
				 }
				if(flag==true)
				{
					setSize(width,height);
					bar.setVisible(true);
					activityMonitor.start();

				}
				else
				{
					Icon error=new ImageIcon("error.png");
					 JOptionPane.showMessageDialog(LoginFrame.this,"<html><font size=4 color=red>Invalid Password </font></html> \n\t\t Please enter valid password","Login",JOptionPane.ERROR_MESSAGE,error);
				}
			}
			}
		});

		ok.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				boolean flag=false;
				String s=tf.getText();
				char a[]=pf.getPassword();

				String u_name="";
				String p_name="";
				try
				{
				conn=DriverManager.getConnection("jdbc:odbc:Student_Info","raj","17java71");
				stat=conn.createStatement();
				set=stat.executeQuery("Select * from Login");
				set.next();
				u_name=set.getString("u_name");
				p_name=set.getString("p_name");
				}
				catch(Exception ex)
				{
				}

				if(s.equals(u_name)&&a.length==p_name.length())
				{
					for(int i=0;i<p_name.length();i++)
					{
					  if(a[i]==p_name.charAt(i))
					       flag=true;
					  else
					  {
					       flag=false;
					       break;
					  }


					}
				 }
				if(flag==true)
				{
					setSize(width,height);
					bar.setVisible(true);
					activityMonitor.start();

				}
				else
				{
					Icon error=new ImageIcon("error.png");
					 JOptionPane.showMessageDialog(LoginFrame.this,"<html><font size=4 color=red>Invalid Password \n\t\t Please enter valid password","Login",JOptionPane.ERROR_MESSAGE,error);
				}
			}
		});
		clear.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{

				tf.setText("");
				pf.setText("");

			}
		});
		exit.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				System.exit(0);
			}
		});
		changepw.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				pass=new ChangePass(LoginFrame.this);
				pass.setVisible(true);
			}
		});



	}
	public void add(Component comp,GridBagConstraints cons,int x,int y,int w,int h)
	{
		cons.gridx=x;
		cons.gridy=y;
		cons.gridwidth=w;
		cons.gridheight=h;
		comp.setPreferredSize(comp.getPreferredSize());
		main.add(comp,cons);
		c.add(main);
	}
	class SimulatedActivity extends Thread
	{
	   /**
	      Constructs the simulated activity thread object. The
	      thread increments a counter from 0 to a given target.
	      @param t the target value of the counter.
	   */
	   public SimulatedActivity(int t)
	   {
	      current = 0;
	      target = t;
	   }

	   public int getTarget()
	   {
	      return target;
	   }

	   public int getCurrent()
	   {
	      return current;
	   }

	   public void run()
	   {
	      try
	      {
	         while (current < target)
	         {
	            sleep(10);
	            current++;
	         }
	      }
	      catch(InterruptedException e)
	      {
	      }
	   }

	   private int current;
	   private int target;
	}

	class ChangePass extends JDialog
	{
		JTextField chuname1;
		JPasswordField chpass1;
		JTextField chuname2;
		JPasswordField chpass2;

		ChangePass(JFrame parent)
		{
			super(LoginFrame.this,"Change Password",true);
			setSize(width,height);setLocation(screenSize.width/3+20,screenSize.height/4+40);
			setResizable(false);
			LoginFrame.setDefaultLookAndFeelDecorated(true);
			Container c=getContentPane();
			chuname1=new JTextField(10);
			chuname1.setBorder(BorderFactory.createBevelBorder(1, new Color(200, 200, 200), new Color(200, 200, 200)));
			chpass1=new JPasswordField(10);
			chpass1.setBorder(BorderFactory.createBevelBorder(1, new Color(200, 200, 200), new Color(200, 200, 200)));
			chuname2=new JTextField(10);
			chuname2.setBorder(BorderFactory.createBevelBorder(1, new Color(200, 200, 200), new Color(200, 200, 200)));
			chpass2=new JPasswordField(10);
			chpass2.setBorder(BorderFactory.createBevelBorder(1, new Color(200, 200, 200), new Color(200, 200, 200)));

			JPanel main=new JPanel()
			{
				public void paintComponent(Graphics g)
				{
					Toolkit kit=Toolkit.getDefaultToolkit();
					Image img=kit.getImage("Gradien.jpg");
					MediaTracker t=new MediaTracker(this);
					t.addImage(img,1);
					while(true)
					{
						try
						{
							t.waitForID(1);
							break;
						}
						catch(Exception e)
						{
						}
					}
					g.drawImage(img,0,0,width,height,null);
				}
			};
			main.setLayout(new BorderLayout());
			Box vbox=Box.createVerticalBox();
			JPanel chun1=new JPanel()
			{
				public void paintComponent(Graphics g)
				{
					Toolkit kit=Toolkit.getDefaultToolkit();
					Image img=kit.getImage("Gradien.jpg");
					MediaTracker t=new MediaTracker(this);
					t.addImage(img,1);
					while(true)
					{
						try
						{
							t.waitForID(1);
							break;
						}
						catch(Exception e)
						{
						}
					}
					g.drawImage(img,0,0,width,height,null);
				}
			};
			chun1.add(new JLabel("    User Name        "));
			chun1.add(chuname1);
			vbox.add(chun1);

			JPanel chpas1=new JPanel()
			{
				public void paintComponent(Graphics g)
				{
					Toolkit kit=Toolkit.getDefaultToolkit();
					Image img=kit.getImage("Gradien.jpg");
					MediaTracker t=new MediaTracker(this);
					t.addImage(img,1);
					while(true)
					{
						try
						{
							t.waitForID(1);
							break;
						}
						catch(Exception e)
						{
						}
					}
					g.drawImage(img,0,0,width,height,null);
				}
			};
			chpas1.add(new JLabel("    Password         "));
			chpas1.add(chpass1);
			vbox.add(chpas1);

			JPanel chun2=new JPanel()
			{
				public void paintComponent(Graphics g)
				{
					Toolkit kit=Toolkit.getDefaultToolkit();
					Image img=kit.getImage("Gradien.jpg");
					MediaTracker t=new MediaTracker(this);
					t.addImage(img,1);
					while(true)
					{
						try
						{
							t.waitForID(1);
							break;
						}
						catch(Exception e)
						{
						}
					}
					g.drawImage(img,0,0,width,height,null);
				}
			};
			chun2.add(new JLabel("New User Name   "));
			chun2.add(chuname2);
			vbox.add(chun2);

			JPanel chpas2=new JPanel()
			{
				public void paintComponent(Graphics g)
				{
					Toolkit kit=Toolkit.getDefaultToolkit();
					Image img=kit.getImage("Gradien.jpg");
					MediaTracker t=new MediaTracker(this);
					t.addImage(img,1);
					while(true)
					{
						try
						{
							t.waitForID(1);
							break;
						}
						catch(Exception e)
						{
						}
					}
					g.drawImage(img,0,0,width,height,null);
				}
			};
				chpas2.add(new JLabel("New Password     "));
			chpas2.add(chpass2);
			vbox.add(chpas2);
			vbox.add(Box.createVerticalStrut(20));

			JButton ok=new JButton("Ok");
			JButton clear=new JButton("clear");
			JButton exit=new JButton("exit");
			Box butpan=Box.createHorizontalBox();
			butpan.setCursor(new Cursor(Cursor.HAND_CURSOR));
			butpan.add(ok);
			butpan.add(Box.createHorizontalStrut(20));
			butpan.add(clear);
			butpan.add(Box.createHorizontalStrut(20));
			butpan.add(exit);
			vbox.add(butpan);
			main.add(vbox);
			c.add(main);

			ok.setToolTipText("Save Password");
			clear.setToolTipText("Clear Text");
			exit.setToolTipText("Exit");
			chuname1.setToolTipText("Enter The User Name");
			chpass1.setToolTipText("Enter The Password");
			chuname2.setToolTipText("Enter The New User Name");
			chpass2.setToolTipText("Enter The New password");


			clear.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					chuname1.setText("");
					chpass1.setText("");
					chuname2.setText("");
					chpass2.setText("");

				}
			});
			exit.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					pass.dispose();
				}
			});

			chpass2.addKeyListener(new KeyAdapter()
			{
				public void keyPressed(KeyEvent e)
				{
					if((e.getKeyCode())==KeyEvent.VK_ENTER)
					{
						boolean flag=false;
						String s="";
						s=chuname1.getText();
						char a[]=chpass1.getPassword();
						String u_name=null;
						String p_name=null;
						try
						{
						conn=DriverManager.getConnection("jdbc:odbc:Student_Info","raj","17java71");
						stat=conn.createStatement();
						set=stat.executeQuery("Select * from Login");
						set.next();
						u_name=set.getString(1);
						p_name=set.getString(2);
						}
						catch(Exception ex)
						{
						}
						if(s.equals(u_name) && a.length==p_name.length())
						{
							for(int i=0;i<p_name.length();i++)
							{
							  if(a[i]==p_name.charAt(i))
								   flag=true;
							  else
							  {
								   flag=false;
								   break;
							  }

							}
						 }
						if(flag==true)
						{
							if(chuname2.getText().equals("") || chpass2.getPassword().length==0)
							{
								Icon error=new ImageIcon("error.png");
								JOptionPane.showMessageDialog(ChangePass.this,"<html><font size=4 color=red>Enter New User Name and Password</font></html>","change Password",JOptionPane.ERROR_MESSAGE,error);
							}
							else
							{


							try
							{

							PreparedStatement ps=conn.prepareStatement("UPDATE Login set u_name=?,p_name=? where u_name=?");
							ps.setString(1,chuname2.getText());
							ps.setString(2,String.copyValueOf(chpass2.getPassword()));
							ps.setString(3,chuname1.getText());
							ps.execute();
							Icon info=new ImageIcon("info.png");
							JOptionPane.showMessageDialog(ChangePass.this,"<html><font size=4 color=green>Password Is Change</font></html> \n\t\t Use New password","Change Password",JOptionPane.INFORMATION_MESSAGE,info);
							pass.dispose();
							}
							catch(Exception e2)
							{
							}
							}

						}
						else
						{
							Icon error=new ImageIcon("error.png");
							 JOptionPane.showMessageDialog(ChangePass.this,"<html><font size=4 color=red>Invalid Password </font></html> \n\t\t Please enter valid password","Login",JOptionPane.ERROR_MESSAGE,error);
						}
					}
				}
			});
			ok.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
						boolean flag=false;
						String s="";
						s=chuname1.getText();
						char a[]=chpass1.getPassword();
						String u_name=null;
						String p_name=null;
						try
						{
							conn=DriverManager.getConnection("jdbc:odbc:Student_Info","raj","17java71");
							stat=conn.createStatement();
							set=stat.executeQuery("Select * from Login");
							set.next();
							u_name=set.getString(1);
							p_name=set.getString(2);
						}
						catch(Exception ex)
						{
						}
						if(s.equals(u_name) && a.length==p_name.length())
						{
							for(int i=0;i<p_name.length();i++)
							{
							  if(a[i]==p_name.charAt(i))
							   flag=true;
							  else
							  {
							   flag=false;
							   break;
							  }
							}
						 }
						if(flag==true)
						{
							if(chuname2.getText().equals("")|| chpass2.getPassword().length==0)
							{
								Icon error=new ImageIcon("error.png");
								JOptionPane.showMessageDialog(ChangePass.this,"<html><font size=4 color=red>Enter New User Name and Password</font></html>","change Password",JOptionPane.ERROR_MESSAGE,error);
							}
							else
							{

							try
							{

								PreparedStatement ps=conn.prepareStatement("UPDATE Login set u_name=?,p_name=? where u_name=?");
								ps.setString(1,chuname2.getText());
								ps.setString(2,String.copyValueOf(chpass2.getPassword()));
								ps.setString(3,chuname1.getText());
								ps.execute();
								Icon info=new ImageIcon("info.png");
								JOptionPane.showMessageDialog(ChangePass.this,"<html><font size=4 color=green>Password Is Change</font></html> \n\t\t Use New password","Change Password",JOptionPane.INFORMATION_MESSAGE,info);
								pass.dispose();
							}
							catch(Exception e2)
							{
							}
							}
						}
						else
						{
							 Icon error=new ImageIcon("error.png");
							 JOptionPane.showMessageDialog(ChangePass.this,"<html><font size=4 color=red>Invalid Password </font></html> \n\t\t Please enter valid password","Login",JOptionPane.ERROR_MESSAGE,error);
						}


				}
			});


		}



	}
}