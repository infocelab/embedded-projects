import javax.swing.*;
import javax.swing.plaf.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.plaf.metal.*;
import java.sql.*;
import java.io.*;
import javax.swing.event.*;
import javax.swing.table.*;
import javax.swing.border.*;
class MemoWindow extends JFrame
{
	Container c;
	JPanel main;
	JTextArea area;
	JButton sample;
	JButton send;
	JButton sendall;
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
   	MemoWindow()
	{
		Toolkit kits=Toolkit.getDefaultToolkit();
		screenSize=kits.getScreenSize();
		width=screenSize.width/2;
		height=screenSize.height/2;
		setSize(width+180,height+260);
		setTitle("Memo Window");
		setLocation(screenSize.width/6,20);
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				dispose();
				new MainMenuFrame().setVisible(true);
			}
		});
		MemoWindow.setDefaultLookAndFeelDecorated(true);
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("mainicon.png"));

		c=getContentPane();
		JLabel l=new JLabel("<html><font size=6 color=#800080><i>Memo Window");
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
		//area.setBorder(BorderFactory.createBevelBorder(1,new Color(215,192,255),new Color(215,192,255)));
		JScrollPane pane=new JScrollPane(area);
		title=new JTextField(10);
		title.setToolTipText("Enter The Title Of Message");
		title.setFont(new Font("Times New Roman",1,20));
		title.setBorder(new MatteBorder(3,3,3,3,new Color(204,204,255)) );
		to=new JTextField(10);

		cons.weightx=5;
		cons.weighty=0;
		cons.fill=GridBagConstraints.HORIZONTAL;
		Calendar cd=Calendar.getInstance();
		cons.insets=new Insets(15,10,0,2);
		add(new JLabel("<html><font size=5 color=#000080>Title :"),cons,0,1,1,1);
		cons.insets=new Insets(0,10,2,2);
		//add(new JLabel("<html><font size=5 color=#000080>To    :"),cons,0,2,1,1);
		cons.weightx=85;
		cons.weighty=0;
		cons.ipady=10;
		cons.insets=new Insets(15,10,2,2);
		add(title,cons,1,1,2,1);
		cons.insets=new Insets(0,10,2,2);
		//add(to,cons,1,2,2,1);
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
				Image img=kit.getImage("3230.jpg");
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
					g.drawImage(img,0,20,200,420,null);
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
		send=new JButton("Send");
		send.setToolTipText("Send Message");
		Icon ic=new ImageIcon("mainicon.png");
		sendall=new JButton("Send To All",ic);
		sendall.setToolTipText("Send To All Student");
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
		p.add(sendall);
		p.add(save);
		p.add(clear);
		p.add(exit);
		c.add("South",p);

		MemoHandler m=new MemoHandler();
		send.addActionListener(m);
		sendall.addActionListener(m);
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
		class MemoHandler implements ActionListener
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
					int x=chooser.showSaveDialog(MemoWindow.this);
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
				if(source==send)
				{
					SendHandler h=new SendHandler();
				}
				if(source==sendall)
				{
					SendToAllHandler h=new SendToAllHandler();
				}
				if(source==sample)
				{
					JFileChooser chooser = new JFileChooser();
					ExampleFileFilter filter = new ExampleFileFilter();
					filter.addExtension("ris");
					filter.setDescription("Message ris file");
					chooser.setFileFilter(filter);
					chooser.setCurrentDirectory(new File("."));
					int x=chooser.showOpenDialog(MemoWindow.this);
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
					 			JOptionPane.showMessageDialog(MemoWindow.this,"<html><font size=4 color=red>Invalid File Format</font></html> \n\t\t Please Select \" .ris \" File","File",JOptionPane.ERROR_MESSAGE,error);
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
		}
		class SendHandler
		{
			SendHandler()
			{
				SendNumber num=new SendNumber();
				num.setVisible(true);
			}

		}
		class SendNumber extends JFrame
		{
			Container mic=getContentPane();
			JComboBox appyrstmd;
			JComboBox appyredmd;
			JTable stud;
			JComboBox cour;
			JPanel pan;
			DefaultTableModel model;
			String mbno;
			SendNumber()
			{
				final int width2=screenSize.width/3;
				final int height2=screenSize.height/3;
				setSize(width2+150, height2+150);
				setLocation(width2-20,height2-50);
				setTitle("Select Number ");
				addWindowListener(new WindowAdapter()
				{
					public void windowClosing(WindowEvent e)
					{
						dispose();
					}
				});
				SendNumber.setDefaultLookAndFeelDecorated(true);
				setResizable(false);
				setIconImage(Toolkit.getDefaultToolkit().getImage("mainicon.png"));
				//JLabel l=new JLabel("<html><font size=5 color=#800080><i>Select Number To Send Message");
				/*JPanel title=new JPanel()
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
						g.drawImage(img,0,0,width2+100,height2+100,null);
					}
				};
				title.add(l);
				mic.add("North",title);*/

				pan=new JPanel();
				pan.setBackground(new Color(255,197,68));
				pan.setBorder(BorderFactory.createBevelBorder(3,new Color(192,192,255),new Color(192,192,255)));
				pan.setLayout(new GridBagLayout());
				GridBagConstraints cons=new GridBagConstraints();
				cons.fill=GridBagConstraints.BOTH;
				cons.anchor=GridBagConstraints.EAST;
				cons.weightx=10;
				cons.weighty=0;
				appyrstmd=new JComboBox();
				appyrstmd.setToolTipText("Select apperaed year");
				//appyrstmd.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
				appyredmd=new JComboBox();
				appyredmd.setToolTipText("Select apperaed year");
				//appyredmd.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));


				cour=new JComboBox();
				//cour.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));

				try
				{
					conn=DriverManager.getConnection("jdbc:odbc:Student_Info","raj","17java71");
					st=conn.createStatement();
					ResultSet set=st.executeQuery("select * from course_name");
					cour.removeAllItems();
					while(set.next())
					{
						cour.addItem(set.getString(2));
					}
					String cors=(String)cour.getSelectedItem();
					for(int y=1950;y<2100;y++)
					{
						appyrstmd.addItem(Integer.toString(y));
					}
					appyrstmd.setSelectedItem("2007");
					if(cors!=null)
					{
						int x=0;
						try
						{
							set=st.executeQuery("select * from course_name");
							String dur=null;
							while(set.next())
							{
								String cr=set.getString(2).trim();
								dur=set.getString(4).trim();
								if(cr.equals(cors))
									break;
							}
							if(dur.equals("Two Semester") || dur.equals("One Year"))
								x=1;
							else
							if(dur.equals("Four Semester") || dur.equals("Two Year"))
								x=2;
							else
							if(dur.equals("Six Semester") || dur.equals("Three Year"))
								x=3;
							else
							if(dur.equals("Eight Semester") || dur.equals("Four Year"))
								x=4;

							int y=Integer.parseInt((String)appyrstmd.getSelectedItem());
							y=y+x;
							appyredmd.addItem(Integer.toString(y));


						}
						catch(Exception ec)
						{
						}
					}
					st.close();
					String appyear=(String)appyrstmd.getSelectedItem()+"-"+(String)appyredmd.getSelectedItem();
					PreparedStatement ps=conn.prepareStatement("select * from "+cors+"_stud_info where appyear=?");
					ps.setString(1,appyear);
					ResultSet stset=ps.executeQuery();
					int row=0;
					int i=0;
					while(stset.next())
					{
						row++;
					}
					model=new DefaultTableModel(new String[]{"<html><font size=4 color=#800080 ><B>Student Code","<html><font size=4 color=#800080 ><B>Name","<html><font size=4 color=#800080 ><B>Mobile Number"},row);
					ps=conn.prepareStatement("select * from "+cors+"_stud_info where appyear=? order by scode");
					ps.setString(1,appyear);
					stset=ps.executeQuery();
					while(stset.next())
					{
						model.setValueAt(stset.getString(1).trim(),i,0);
						String ft=stset.getString(2).trim();
						ft=ft+" "+stset.getString(4).trim();
						model.setValueAt(ft,i,1);
						model.setValueAt(stset.getString(7).trim(),i,2);
						i++;
					}
					stud=new JTable(model);
					ps.close();
					stud.addMouseListener(new SelectStudList());
					stud.setToolTipText("Select Student");
					stud.doLayout();
					stud.setColumnSelectionAllowed(false);
					stud.setEditingColumn(3);
					stud.setSelectionMode(0);
					stud.setFont(new Font("Times New Roman",Font.BOLD,13));
					stud.setForeground(Color.white);
					stud.setGridColor(new Color(128,128,192));
	  				stud.setBackground(new Color(183,91,0));
        			stud.getTableHeader().setReorderingAllowed(false);
        			stud.setRowMargin(3);
					stud.setShowHorizontalLines(false);
					stud.setShowVerticalLines(false);
					stud.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
					JScrollPane spl=new JScrollPane(stud);
					mic.add(spl);

					cour.setMaximumRowCount(10);
					cons.anchor=GridBagConstraints.CENTER;

					cons.weightx=30;
					cons.weighty=3;
					Box cor1 = Box.createHorizontalBox();
					cor1.add(Box.createGlue());
					cor1.add(new JLabel("Course"));
					cor1.add(Box.createHorizontalStrut(5));
					cor1.add(cour);
					cor1.add(Box.createHorizontalStrut(5));
					addOn(cor1,cons,0,0,2,1);

					cons.weightx=40;
					Box cor = Box.createHorizontalBox();
					cor.add(Box.createGlue());
					cor.add(new JLabel("Appered Year"));
					cor.add(Box.createHorizontalStrut(5));
					cor.add(appyrstmd);
					cor.add(Box.createHorizontalStrut(5));
					cor.add(new JLabel("TO"));
					cor.add(Box.createHorizontalStrut(5));
					cor.add(appyredmd);
					addOn(cor,cons,3,0,2,1);
					cons.weightx=100;
					cons.weighty=100;

					addOn(spl,cons,0,1,5,1);
					cour.addActionListener(new SelectedCourse());
					appyrstmd.addActionListener(new SelectedCourse());

					addWindowListener(new WindowAdapter()
					{
						public void windowActivated(WindowEvent we)
						{
							String cors=(String)cour.getSelectedItem();
							try
							{
								String appyear=(String)appyrstmd.getSelectedItem()+"-"+(String)appyredmd.getSelectedItem();
								PreparedStatement ps=conn.prepareStatement("select * from "+cors+"_stud_info where appyear=?");
								ps.setString(1,appyear);
								ResultSet stset=ps.executeQuery();
								int row=0;
								int i=0;
								while(stset.next())
								{
									row++;
								}
								model=new DefaultTableModel(new String[]{"<html><font size=4 color=#800080 ><B>Student Code","<html><font size=4 color=#800080 ><B>Name","<html><font size=4 color=#800080 ><B>Mobile Number"},row);
								ps=conn.prepareStatement("select * from "+cors+"_stud_info where appyear=? order by scode");
								ps.setString(1,appyear);
								stset=ps.executeQuery();
								while(stset.next())
								{
									model.setValueAt(stset.getString(1).trim(),i,0);
									String ft=stset.getString(2).trim();
									ft=ft+" "+stset.getString(4).trim();
									model.setValueAt(ft,i,1);
									model.setValueAt(stset.getString(7).trim(),i,2);
									i++;
								}
								stud.setModel(model);
							}
							catch(Exception ex)
							{
							}
						}
					});

				}

				catch(Exception es)
				{
				}
			}
			public void addOn(Component comp,GridBagConstraints cons,int x,int y,int w,int h)
			{
				cons.gridx=x;
				cons.gridy=y;
				cons.gridwidth=w;
				cons.gridheight=h;
				comp.setPreferredSize(comp.getPreferredSize());
				pan.add(comp,cons);
				mic.add(pan);
			}
			class SelectedCourse implements ActionListener
			{
				public void actionPerformed(ActionEvent e)
				{
					String cors=(String)cour.getSelectedItem();
					try
					{
						int x=0;
						st=conn.createStatement();
						ResultSet set=st.executeQuery("select * from course_name");
						String dur=null;
						while(set.next())
						{
							String cr=set.getString(2).trim();
							dur=set.getString(4).trim();
							if(cr.equals(cors))
								break;
						}

						if(dur.equals("Two Semester")||dur.equals("One Year"))
							x=1;
						if(dur.equals("Four Semester")||dur.equals("Two Year"))
							x=2;
						if(dur.equals("Six Semester")||dur.equals("Three Year"))
							x=3;
						if(dur.equals("Eight Semester")||dur.equals("Four Year"))
							x=4;

						appyredmd.removeAllItems();
						int y=Integer.parseInt((String)appyrstmd.getSelectedItem());
						y=y+x;
						appyredmd.addItem(Integer.toString(y));
						st.close();
						int row=0;
						int i=0;
						String appyear=(String)appyrstmd.getSelectedItem()+"-"+(String)appyredmd.getSelectedItem();
						PreparedStatement ps=conn.prepareStatement("select * from "+cors+"_stud_info where appyear=? order by scode");
						ps.setString(1,appyear);
						ResultSet stset=ps.executeQuery();

						while(stset.next())
						{
							row++;
						}
						model=new DefaultTableModel(new String[]{"<html><font size=4 color=#800080 ><B>Student Code","<html><font size=4 color=#800080 ><B>Name","<html><font size=4 color=#800080 ><B>Mobile Number"},row);
						ps=conn.prepareStatement("select * from "+cors+"_stud_info where appyear=? order by scode");
						ps.setString(1,appyear);
						stset=ps.executeQuery();
						while(stset.next())
						{
							model.setValueAt(stset.getString(1).trim(),i,0);
							String ft=stset.getString(2).trim();
							ft=ft+" "+stset.getString(4).trim();
							model.setValueAt(ft,i,1);
							model.setValueAt(stset.getString(7).trim(),i,2);
							i++;
						}
						stud.setModel(model);

					}
					catch(Exception ex)
					{
					}
				}
			}

			class SelectStudList extends MouseAdapter
			{
				public void mouseClicked(MouseEvent e)
				{
					String cors=(String)cour.getSelectedItem();
					int ro=stud.getSelectedRow();
					mbno=(String)stud.getValueAt(ro,2);
					Icon ic=new ImageIcon("question.png");
					int x=JOptionPane.showConfirmDialog(SendNumber.this,"<html><font size=4 color=#800000 style=Times New Roman>Send Message \n To : "+mbno,"Send Message",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE ,ic);
					if(x==JOptionPane.OK_OPTION)
					{
						Icon info=new ImageIcon("info.png");
						String titlemsg=title.getText().trim();
						String message=area.getText().trim();
						if(!message.equals(""))
						{
							message=titlemsg+message;
							SMSClient sc=new SMSClient(1);
							sc.sendMessage(mbno,message);
							System.out.println(mbno+"\n"+message);
							JOptionPane.showMessageDialog(SendNumber.this,"Message Send Successfully","Send",JOptionPane.INFORMATION_MESSAGE,info);
						}
						else
						{
							JOptionPane.showMessageDialog(SendNumber.this,"Please Enter Message","Error",JOptionPane.INFORMATION_MESSAGE,info);
						}
					}
				}
			}
		}

		class SendToAllHandler
		{
			SelectStudent ss;
			SendToAllHandler()
			{
				ss=new SelectStudent();
				ss.setVisible(true);

			}
			class SelectStudent extends JDialog
			{
				JPanel p;
				JCheckBox box[]=new JCheckBox[10];
				int i=0;
				JButton ok,cancel;
				SelectStudent()
				{
					super(MemoWindow.this,"Select Course",true);
					setSize(320,300);
					setLocation(screenSize.width/4+130,screenSize.height/4);
					p=new JPanel();
					p.setLayout(null);
					try
					{
						Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
						conn=DriverManager.getConnection("jdbc:odbc:Student_Info","raj","17java71");
						st=conn.createStatement();
						ResultSet set=st.executeQuery("select * from course_name");
						int ht=20;

						while(set.next())
						{
							box[i]=new JCheckBox(set.getString(2));
							box[i].setFont(new Font("Times New Roman",1,16));
							box[i].setBounds(50,ht,100,40);
							ht=ht+40;
							p.add(box[i]);
							i++;
						}
						JPanel npan=new JPanel();
						npan.add(new JLabel("<html><font style=Times New Roman color=#800000 size=5> Select Course To Send Message"));
						add(npan,"North");

					}
					catch(Exception e)
					{
					}
					add(p);

					ok=new JButton("   Ok  ");
					cancel=new JButton("Cancel");
					JPanel btpan=new JPanel();
					btpan.setBackground(new Color(255,197,68));
					btpan.add(ok);
					btpan.add(cancel);
					add(btpan,"South");
					SendProcess ps=new SendProcess();
					ok.addActionListener(ps);
					cancel.addActionListener(ps);
				}
				class SendProcess implements ActionListener
				{
					public void actionPerformed(ActionEvent e)
					{
						Object btn=e.getSource();
						if(btn==ok)
						{
							String msg=area.getText().trim();
							if(msg.equals(""))
							{
								Icon info=new ImageIcon("info.png");
								JOptionPane.showMessageDialog(SelectStudent.this,"Please Enter Message","Error",JOptionPane.INFORMATION_MESSAGE,info);
							}
							else
							{
								SendThread th=new SendThread();
								th.start();
							}
						}
						else
						{
							ss.dispose();
						}
					}
				}
				class SendThread extends Thread
				{
					public void run()
					{
						try
						{
							for(int j=0;j<i;j++)
							{
								if(box[j].isSelected())
								{
									String cors=box[j].getText();
									conn=DriverManager.getConnection("jdbc:odbc:Student_Info","raj","17java71");
									st=conn.createStatement();
									ResultSet set=st.executeQuery("select mobno from "+cors+"_stud_info " );
									String message=area.getText();
									while(set.next())
									{
										String mobileno=set.getString(1).trim();
										//send message on mbile
										SMSClient c=new SMSClient(1);
										c.sendMessage(mobileno,message);
										System.out.println(mobileno+"\n"+message);
										//Construct New Message
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
							//JOptionPane.showMessageDialog(null,"Message Send Successfully","Send",JOptionPane.INFORMATION_MESSAGE,info);
						}
						catch(Exception es)
						{
							System.out.println(es);
						}
					}
				}

			}
		}
}