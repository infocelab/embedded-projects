import javax.swing.*;
import javax.swing.plaf.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.plaf.metal.*;
import java.sql.*;
import java.io.*;
import javax.swing.event.*;
import javax.swing.border.*;
class InvetationForm extends JFrame
{
	Container c;
	JPanel main;
	JTextArea area;
	JButton sample;
	JButton send;
	JButton sendstud;
	JButton sendguest;
	JTextField title;
	JTextField to;
	JButton save;
	JButton clear;
	JButton exit;
	int height;
   	int width;
   	Dimension screenSize;
   	Connection conn;
   	Statement st;
   	InvetationForm()
	{
		Toolkit kits=Toolkit.getDefaultToolkit();
		screenSize=kits.getScreenSize();
		width=screenSize.width/2;
		height=screenSize.height/2;
		setSize(width+180,height+260);
		setTitle("Invetation Form");
		setLocation(screenSize.width/6,20);
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				dispose();
				new MainMenuFrame().setVisible(true);
			}
		});
		InvetationForm.setDefaultLookAndFeelDecorated(true);
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("mainicon.png"));

		c=getContentPane();
		JLabel l=new JLabel("<html><font size=6 color=#800080><i>Invetation Form");
		JPanel titlepan=new JPanel()
		{
			public void paintComponent(Graphics g)
			{

				Toolkit kit=Toolkit.getDefaultToolkit();
				Image img=kit.getImage("HEADER.gif");
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
				g.drawImage(img,0,0,width+180,50,null);
			}
		};
		titlepan.add(l);
		c.add(titlepan,"North");

		main=new JPanel()
		{
			public void paintBorder(Graphics g)
			{

				Toolkit kit=Toolkit.getDefaultToolkit();
				Image img=kit.getImage("plain.jpg");
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
				g.drawImage(img,0,0,width+180,height+260,null);

			}

		};
		main.setLayout(new GridBagLayout());
		GridBagConstraints cons=new GridBagConstraints();

		cons.anchor=GridBagConstraints.EAST;
		cons.weightx=50;
		cons.weighty=80;
		area=new JTextArea(50,50);
		area.setToolTipText("Enter The Message");
		area.setFont(new Font("Times New Roman",1,20));
		area.setBorder(new MatteBorder(7,7,7,7,new Color(204,204,255)) );
		JScrollPane pane=new JScrollPane(area);
		title=new JTextField(10);
		to=new JTextField(10);
		title.setToolTipText("Enter The Title Of Message");
		to.setToolTipText("Enter Mobile Number");
		to.addKeyListener(new NumberValid());
		to.setFont(new Font("Times New Roman",1,20));
		title.setFont(new Font("Times New Roman",1,20));
		title.setBorder(new MatteBorder(3,3,3,3,new Color(204,204,255)) );
		to.setBorder(new MatteBorder(3,3,3,3,new Color(204,204,255)) );

		cons.weightx=5;
		cons.weighty=0;
		cons.fill=GridBagConstraints.HORIZONTAL;
		Calendar cd=Calendar.getInstance();
		cons.insets=new Insets(15,10,0,2);
		add(new JLabel("<html><font size=5 color=#000080>Title :"),cons,0,1,1,1);
		cons.insets=new Insets(0,10,2,2);
		add(new JLabel("<html><font size=5 color=#000080>To    :"),cons,0,2,1,1);
		cons.weightx=85;
		cons.weighty=0;
		cons.ipady=10;
		cons.insets=new Insets(15,10,2,2);
		add(title,cons,1,1,2,1);
		cons.insets=new Insets(0,10,2,2);
		add(to,cons,1,2,2,1);
		cons.ipady=0;
		cons.weightx=50;
		cons.weighty=80;
		cons.fill=GridBagConstraints.BOTH;
		cons.insets=new Insets(5,20,30,2);
		add(pane,cons,0,3,4,5);

		JPanel image=new JPanel()
		{
			public void paint(Graphics g)
			{

				Toolkit kit=Toolkit.getDefaultToolkit();
				Image img=kit.getImage("009.gif");
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
				for(int i=1;i<=3;i++)
				{
					g.drawImage(img,0,50,200,400,null);
					try
					{
						Thread.sleep(100);
					}
					catch(Exception es){}
				}
			}
		};
		add(image,cons,6,2,4,6);
		sample=new JButton("Sample");
		sample.setToolTipText("Sample Message");
		Icon ic=new ImageIcon("mainicon.png");
		send=new JButton("Send");
		send.setToolTipText("Send Message");
		sendstud=new JButton("Send To Student",ic);
		sendstud.setToolTipText("Send Invetation To All Student");
		sendguest=new JButton("Send To Guest",ic);
		sendguest.setToolTipText("Send Invetation To All Guest");
		save=new JButton("Save");
		save.setToolTipText("Save Message");
		clear=new JButton("Clear");
		clear.setToolTipText("Clear");
		exit=new JButton("Exit");
		exit.setToolTipText("Exit");
		JPanel p=new JPanel();
		p.setBackground(new Color(255,197,68));
		p.add(sample);
		p.add(send);
		p.add(sendstud);
		p.add(sendguest);
		p.add(save);
		p.add(clear);
		p.add(exit);
		c.add("South",p);
		InvetationHandler m=new InvetationHandler();
		send.addActionListener(m);
		sendstud.addActionListener(m);
		sendguest.addActionListener(m);
		save.addActionListener(m);
		clear.addActionListener(m);
		sample.addActionListener(m);
		exit.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				dispose();
				new MainMenuFrame().setVisible(true);
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
		class InvetationHandler implements ActionListener
		{
			public void actionPerformed(ActionEvent e)
			{
				Object source=e.getSource();
				if(source==save)
				{
					JFileChooser chooser = new JFileChooser();
					ExampleFileFilter filter = new ExampleFileFilter();
					filter.addExtension("ris");
					filter.setDescription("Message ris file");
					chooser.setFileFilter(filter);
					chooser.setCurrentDirectory(new File("."));
					int x=chooser.showSaveDialog(InvetationForm.this);
					if(x==JFileChooser.APPROVE_OPTION)
					{
						try
						{
							String filepath=chooser.getSelectedFile().getPath();
							boolean fs=filepath.endsWith(".ris");
							if(fs==true)
							{
							}
							else
							{
								filepath=filepath.concat(".ris");
							}

							System.out.println(filepath);
							FileWriter f=new FileWriter(filepath);
							f.write(area.getText());
							f.close();
						}
						catch(Exception ex)
						{
							System.out.println(ex);
						}
					}
					else
					{
					}
				}
				if(source==clear)
				{
					area.setText("");
					title.setText("");
					to.setText("");
				}
				if(source==sendstud)
				{
					Icon question=new ImageIcon("question.png");
					Icon warning=new ImageIcon("warning.png");
					int ans=JOptionPane.showConfirmDialog(null,"<html><font size=4 color=#800000 style=Times New Roman>Are you sure you want to <br> Send Message To All Student ? <br><br>","Send",JOptionPane.YES_NO_OPTION,1,question);

					if(ans==JOptionPane.YES_OPTION)
					{
						StudentMessageThread th=new StudentMessageThread();
						th.start();
					}
					else
					{
						JOptionPane.showMessageDialog(null,"Sending Message Failed","Disacard",JOptionPane.WARNING_MESSAGE,warning);
					}

				}
				if(source==sendguest)
				{
					Icon question=new ImageIcon("question.png");
					Icon warning=new ImageIcon("warning.png");
					Icon info=new ImageIcon("info.png");

					int ans=JOptionPane.showConfirmDialog(null,"<html><font size=4 color=#800000 style=Times New Roman>Are you sure you want to <br> Send Message To All Guest ? <br><br>","Send",JOptionPane.YES_NO_OPTION,1,question);

					if(ans==JOptionPane.YES_OPTION)
					{
						GuestMessageThread gst=new GuestMessageThread();
						gst.start();
					}
					else
					{
						JOptionPane.showMessageDialog(null,"Sending Message Failed","Disacard",JOptionPane.WARNING_MESSAGE,warning);
					}
				}
				if(source==send)
				{
					String message=area.getText().trim();
					String mobno=to.getText().trim();
					String titlemsg=title.getText().trim();
					if(message.equals("")||mobno.equals("")||titlemsg.equals(""))
					{
						Icon info=new ImageIcon("info.png");
						JOptionPane.showMessageDialog(InvetationForm.this,"<html><font size=4 color=red style=Times New Roman>Please Enter Message ,<br> Title and Mobile No","Error",JOptionPane.INFORMATION_MESSAGE,info);
					}
					else
					{
						String mobTest=to.getText().trim();
						boolean valid=false;
						if((mobTest.length() == 10)||(mobTest.length() == 11))
						{
							valid=true;
							if(mobTest.length() == 11)
							{
								char ch=mobTest.charAt(0);
								if(ch != '0')
								{
									valid=false;
									Icon error=new ImageIcon("error.png");
									JOptionPane.showMessageDialog(InvetationForm.this,"<html><font size=4 color=red>Mobile Number Not Be Valid </font></html> \n\t\t Please Enter Valid Mobile Number","Student Information",JOptionPane.ERROR_MESSAGE,error);

								}
							}
						}
						else
						{
							valid=false;
							Icon error=new ImageIcon("error.png");
							JOptionPane.showMessageDialog(InvetationForm.this,"<html><font size=4 color=red>Mobile Number Not Be Valid </font></html> \n\t\t Please Enter Valid Mobile Number","Student Information",JOptionPane.ERROR_MESSAGE,error);
						}
						if(valid)
						{
							message=titlemsg+"\n\r"+message;
							SMSClient sm=new SMSClient(1);
							sm.sendMessage(mobno,message);
							System.out.println(mobno+"\n"+message);
							Icon info=new ImageIcon("info.png");
							JOptionPane.showMessageDialog(InvetationForm.this,"Message Send Successfully","Send",JOptionPane.INFORMATION_MESSAGE,info);
						}
					}
				}
				if(source==sample)
				{
					JFileChooser chooser = new JFileChooser();
					ExampleFileFilter filter = new ExampleFileFilter();
					filter.addExtension("ris");
					filter.setDescription("Message ris file");
					chooser.setFileFilter(filter);
					chooser.setCurrentDirectory(new File("."));
					int x=chooser.showOpenDialog(InvetationForm.this);
					if(x==JFileChooser.APPROVE_OPTION)
					{
						try
						{
							String filepath=chooser.getSelectedFile().getPath();
							System.out.println(filepath);
							String chk=filepath.substring(filepath.length()-4);
							System.out.println(chk);
							if(chk.equals(".ris"))
							{
								int y;
								String str="";
								FileReader f=new FileReader(filepath);
								while((y=f.read())!=-1)
									str=str+(char)y;
								area.setText(str);
								f.close();							}
							else
							{
								Icon error=new ImageIcon("error.png");
					 			JOptionPane.showMessageDialog(InvetationForm.this,"<html><font size=4 color=red>Invalid File Format</font></html> \n\t\t Please Select \" .ris \" File","File",JOptionPane.ERROR_MESSAGE,error);
							}

						}
						catch(Exception ex)
						{
							System.out.println(ex);
						}
					}
					else
					{
					}
				}


			}
			class GuestMessageThread extends Thread
			{
				public void run()
				{
					try
					{
						Icon info=new ImageIcon("info.png");
						Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
						conn=DriverManager.getConnection("jdbc:odbc:Gest_Info","raj","17java71");
						st=conn.createStatement();
						ResultSet set=st.executeQuery("select mobno from GestInfo");
						String mobno="";
						String message=area.getText().trim();
						String titlemsg=title.getText().trim();
						if(message.equals("")||titlemsg.equals(""))
						{
							JOptionPane.showMessageDialog(InvetationForm.this,"<html><font size=4 color=red style=Times New Roman>Please Enter Message ,<br> Title and Mobile No","Error",JOptionPane.INFORMATION_MESSAGE,info);
						}
						else
						{
							message=titlemsg+"\n\r"+message;
							while(set.next())
							{
								mobno=set.getString(1).trim();
								SMSClient sms=new SMSClient(1);
								sms.sendMessage(mobno,message);
								System.out.println(mobno+"\n"+message);
								try
								{
									Thread.sleep(5000);
								}
								catch(Exception exc)
								{
								}
							}
							JOptionPane.showMessageDialog(InvetationForm.this,"Message Send Successfully","Send",JOptionPane.INFORMATION_MESSAGE,info);
						}
					}
					catch(Exception ex)
					{
						System.out.println(ex);
					}
				}
			}
			class StudentMessageThread extends Thread
			{
				Connection conn2;
				Statement st2;
				public void run()
				{
					try
					{
						Icon info=new ImageIcon("info.png");
						Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
						conn=DriverManager.getConnection("jdbc:odbc:Student_Info","raj","17java71");
						st=conn.createStatement();
						conn2=DriverManager.getConnection("jdbc:odbc:Student_Info","raj","17java71");
						st2=conn2.createStatement();
						ResultSet set=st.executeQuery("select course_name from course_name");
						String message=area.getText().trim();
						String titlemsg=title.getText().trim();
						if(message.equals("")||titlemsg.equals(""))
						{
							JOptionPane.showMessageDialog(InvetationForm.this,"<html><font size=4 color=red style=Times New Roman>Please Enter Message ,<br> Title and Mobile No","Error",JOptionPane.INFORMATION_MESSAGE,info);
						}
						else
						{
							message=titlemsg+"\n\r"+message;
							while(set.next())
							{
								ResultSet sts=st2.executeQuery("select mobno from "+set.getString(1).trim()+"_stud_info ");
								while(sts.next())
								{
									String mobno=sts.getString(1).trim();
									SMSClient sms=new SMSClient(1);
									sms.sendMessage(mobno,message);
									System.out.println(mobno+"\n"+message);
									try
									{
										Thread.sleep(5000);
									}
									catch(Exception exc)
									{
									}
								}
							}
						}
		 			}
					catch(Exception ex)
					{
					}
				}
			}
		}
}