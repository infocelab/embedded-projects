
 /****************************************************************/ 
 /*                      login	                            */ 
 /*                                                              */ 
 /****************************************************************/ 
 import java.awt.*; 
 import java.awt.event.*; 
 import javax.swing.*; 
 import java.io.*;
 import java.applet.*;
 /** 
  * Summary description for login 
  * 
  */ 
 public class login extends JFrame 
 { 
 	// Variables declaration 
 	private login2 nextframe;
 	private JLabel lang;
 	private JLabel relig;
 	private JLabel eid;
 	private JLabel humour;
 	private JLabel jLabel1; 
 	private JLabel jLabel2; 
 	private JLabel jLabel3; 
 	private JLabel jLabel4; 
 	private JLabel jLabel5; 
 	private JTextField jTextField3; 
 	private JPasswordField jPasswordField1; 
 	private JPasswordField jPasswordField2; 
 	private JTextField jTextField8; 
 	private JComboBox jComboBox1; 
 	private JComboBox month;
 	private JComboBox year;
 	private JComboBox day;
 	private JButton check;
 	private JButton create;
 	private JButton cancel;
 	private JButton image;
 	private JLabel title;
 	private JLabel dob;
 	private JLabel inte;
 	private JCheckBox friends;
 	private JCheckBox activity;
	private JCheckBox buisnet;
	private JCheckBox h1;
	private JCheckBox h2;
	private JCheckBox h3;
	private JCheckBox h4;
	private JCheckBox h5;
	private JCheckBox h6;
	private JCheckBox h7;
	private JTextField tlang;
	private JTextField trelig;
	private JTextField teid;
 	private JPanel contentPane; 
 	// End of variables declaration 
  
  
 	public login() 
 	{ 
 		super(); 
 		JFrame.setDefaultLookAndFeelDecorated(true); 
 		JDialog.setDefaultLookAndFeelDecorated(true); 
 		try 
 		{ 
 			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel"); 
 		} 
 		catch (Exception ex) 
 		{ 
 			//System.out.println("Failed loading L&F: "); 
 			//System.out.println(ex); 
 		} 
 		initializeComponent(); 
 		// 
 		// TODO: Add any constructor code after initializeComponent call 
 		// 
  
 		this.setVisible(true); 
 	} 
  
 	/** 
 	 * This method is called from within the constructor to initialize the form. 
 	 * WARNING: Do NOT modify this code. The content of this method is always regenerated 
 	 * by the Windows Form Designer. Otherwise, retrieving design might not work properly. 
 	 * Tip: If you must revise this method, please backup this GUI file for JFrameBuilder 
 	 * to retrieve your design properly in future, before revising this method. 
 	 */ 
 	private void initializeComponent() 
 	{   create=new JButton("Next");
 	    image=new JButton("Image");
 	    cancel=new JButton("Cancel");
 	    lang=new JLabel("Language");
 	    relig=new JLabel("Religion");
 	    eid=new JLabel("E-id");
 	    tlang=new JTextField();
 	    tlang.setBackground(new Color(35,247,21));
 	    trelig=new JTextField();
 	    trelig.setBackground(new Color(35,247,21));
 	    teid=new JTextField();
 	    teid.setBackground(new Color(35,247,21));
 	    humour=new JLabel("Humour");
 	    check=new JButton();
 	    title =new JLabel("WELCOME... TO ....ORKUT");
 	    dob=new JLabel("Date of Birth");
 		jLabel1 = new JLabel(); 
 		
 		jLabel2 = new JLabel(); 
 		jLabel3 = new JLabel(); 
 		jLabel4 = new JLabel(); 
 		jLabel5 = new JLabel(); 
 		inte =new JLabel("Interests");
 		friends = new JCheckBox("Friends");
 		activity = new JCheckBox("Activity Partners");
 		buisnet = new JCheckBox("Buissness Networking");
 		friends.setBackground(new Color(158, 168, 237));
 		activity.setBackground(new Color(158, 168, 237));
 		buisnet.setBackground(new Color(158, 168, 237));
 		jTextField3 = new JTextField(); 
 		jPasswordField1 = new JPasswordField(); 
 		jPasswordField2 = new JPasswordField(); 
 		jTextField8 = new JTextField(); 
 		jComboBox1 = new JComboBox(); 
 		month = new JComboBox(); 
 		year = new JComboBox(); 
 		day = new JComboBox(); 
 		h1=new JCheckBox("campy/cheesy"); 		
 		h2=new JCheckBox("clever/quick witted");
 		h3=new JCheckBox("goofy/slapstick");
 		h4=new JCheckBox("raunchy");
 		h5=new JCheckBox("dry/sarcastic");
 		h6=new JCheckBox("friendly");
 		h7=new JCheckBox("obscure");
 		h1.setBackground(new Color(158, 168, 237));
 		h2.setBackground(new Color(158, 168, 237));
 		h3.setBackground(new Color(158, 168, 237));
 		h4.setBackground(new Color(158, 168, 237));
 		h5.setBackground(new Color(158, 168, 237));
 		h6.setBackground(new Color(158, 168, 237));
 		h7.setBackground(new Color(158, 168, 237));
 		contentPane = (JPanel)this.getContentPane(); 
 		month.addItem("Jan"); 
        month.addItem("Feb");
        month.addItem("Mar");
        month.addItem("Apr");
        month.addItem("May");
        month.addItem("Jun");
        month.addItem("Jul");
        month.addItem("Aug");
        month.addItem("Sep");
        month.addItem("Oct");
        month.addItem("Nov");
        month.addItem("Dec");
        String str;
        for(int i=1;i<32;i++)
          { str=Integer.toString(i);
          	day.addItem(str);
           
          } 
        for(int i=1900;i<2007;i++)
         {  str=Integer.toString(i);
         	year.addItem(str);
         }  
    
 		// 
 		// jLabel1 
 		// 
 		jLabel1.setText("Username"); 
 		
 		// 
 		// jLabel2 
 		// 
 		jLabel2.setText("Password"); 
 		// 
 		// jLabel3 
 		// 
 		jLabel3.setText("Confirm Password"); 
 		// 
 		// jLabel4 
 		// 
 		jLabel4.setText("Sex"); 
 		// 
 		// jLabel5 
 		// 
 		jLabel5.setText("city"); 
 		// 
 		// jTextField3 
 		// 
 		jTextField3.setText(""); 
 		jTextField3.setBackground(new Color(241, 245, 31));
 		jTextField3.addActionListener(new ActionListener() { 
 			public void actionPerformed(ActionEvent e) 
 			{ 
 				jTextField3_actionPerformed(e); 
 			} 
  
 		}); 
 		// 
 		// jPasswordField1 
 		// 
 		jPasswordField1.setText(""); 
 		jPasswordField1.setBackground(new Color(251,59,5));
 		jPasswordField1.addActionListener(new ActionListener() { 
 			public void actionPerformed(ActionEvent e) 
 			{ 
 				jPasswordField1_actionPerformed(e); 
 			} 
  
 		}); 
 		// 
 		// jPasswordField2 
 		// 
 		jPasswordField2.setText(""); 
 		jPasswordField2.setBackground(new Color(251,59,5));
 		jPasswordField2.addActionListener(new ActionListener() { 
 			public void actionPerformed(ActionEvent e) 
 			{ 
 			 				jPasswordField2_actionPerformed(e); 
 			} 
  
 		}); 
 		// 
 		// jTextField8 
 		// 
 		jTextField8.setText(""); 
 		jTextField8.addActionListener(new ActionListener() { 
 			public void actionPerformed(ActionEvent e) 
 			{ 
 				jTextField8_actionPerformed(e); 
 			} 
  
 		}); 
 		// 
 		// jComboBox1 
 		// 
 		jComboBox1.addItem("Male"); 
 		jComboBox1.addItem("Female"); 
 		check.setText("Check"); 
 		
 		check.addActionListener(new ActionListener() { 
 			
 			
 			public void actionPerformed(ActionEvent e) 
 			{   
 			   // String username=jTextField3.getText();
 				check_actionPerformed(e);
 				
 			//	Client cl=new Client();
 				
 				//int c=cl.Processing("checkselect username from logins where username='"+username+"';");
 				 
 			} 
  
 		}); 
 	
 		image.addActionListener(new ActionListener() { 
 			public void actionPerformed(ActionEvent e) 
 			{ 
 				image_actionPerformed(e); 
 			
 			} 
  
 		}); 
 		create.addActionListener(new ActionListener() { 
 			public void actionPerformed(ActionEvent e) 
 			{ 
 				create_actionPerformed(e); 
 				 
 			} 
  
 		}); 
 		cancel.addActionListener(new ActionListener() { 
 			public void actionPerformed(ActionEvent e) 
 			{ 
 				cancel_actionPerformed(e); 
 			} 
  
 		}); 
 		
        
 		/*jComboBox1.addActionListener(new ActionListener() { 
 			public void actionPerformed(ActionEvent e) 
 			{ 
 				jComboBox1_actionPerformed(e); 
 			} 
  
 		}); 
 		month.addActionListener(new ActionListener() { 
 			public void actionPerformed(ActionEvent e) 
 			{ 
 				month_actionPerformed(e); 
 			} 
  
 		}); 
 		day.addActionListener(new ActionListener() { 
 			public void actionPerformed(ActionEvent e) 
 			{ 
 				day.actionPerformed(e); 
 			} 
  
 		}); 
 		year.addActionListener(new ActionListener() { 
 			public void actionPerformed(ActionEvent e) 
 			{ 
 				year_actionPerformed(e); 
 			} 
  
 		}); */
 		// 
 		// contentPane 
 		// 
 		contentPane.setLayout(null); 
 		addComponent(contentPane, jLabel1, 42,45,60,18);
 		addComponent(contentPane, check, 350,45,70,18); 
 		addComponent(contentPane, jLabel2, 40,87,60,18); 
 		addComponent(contentPane, jLabel3, 40,132,96,18); 
 		addComponent(contentPane, jLabel4, 42,176,60,18); 
 		addComponent(contentPane, jLabel5, 45,228,60,18); 
 		addComponent(contentPane, jTextField3, 217,45,100,22); 
 		addComponent(contentPane, jPasswordField1, 217,87,100,22); 
 		addComponent(contentPane, jPasswordField2, 218,132,100,22); 
 		addComponent(contentPane, jTextField8, 217,227,100,22); 
 		addComponent(contentPane, jComboBox1, 218,176,100,22);
 		addComponent(contentPane, month, 218,267,100,22);
 		addComponent(contentPane, day, 400,267,50,22);
 		addComponent(contentPane, year, 218,307,100,22);
 		addComponent(contentPane, title, 150,10,200,22);
 		addComponent(contentPane, dob, 40,267,100,22);
 		addComponent(contentPane, inte, 40,347,100,22);
 		addComponent(contentPane, friends, 218,347,100,22);
 		addComponent(contentPane, activity, 325,347,150,22);
 		addComponent(contentPane, buisnet, 218,370,250,22);
 		addComponent(contentPane, lang, 40,410,100,22);
 		addComponent(contentPane, tlang, 218,410,100,22);
 		addComponent(contentPane, relig, 40,440,100,22);
 		addComponent(contentPane, trelig, 218,440,100,22);
 		addComponent(contentPane, humour, 40,480,100,22);
 		addComponent(contentPane, h1, 218,480,100,22);
 		addComponent(contentPane, h2, 218,500,100,22);
 		addComponent(contentPane, h3, 218,520,100,22);
 		addComponent(contentPane, h4, 218,540,100,22);
 		addComponent(contentPane, h5, 325,480,100,22);
 		addComponent(contentPane, h6, 325,500,100,22);
 		addComponent(contentPane, h7, 325,520,100,22);
 		addComponent(contentPane, image, 40,580,100,22);
 		addComponent(contentPane, create, 200,580,150,22);
 		addComponent(contentPane, cancel, 400,580,100,22);
 		
 		// 
 		// login 
 		// 
 		contentPane.setBackground(new Color(158, 168, 237));
 		this.setTitle("login - extends JFrame"); 
 		this.setLocation(new Point(0, 0)); 
 		this.setSize(new Dimension(1024, 768)); 
 	} 
  
 	/** Add Component Without a Layout Manager (Absolute Positioning) */ 
 	private void addComponent(Container container,Component c,int x,int y,int width,int height) 
 	{ 
 		c.setBounds(x,y,width,height); 
 		container.add(c); 
 	} 
  
 	// 
 	// TODO: Add any appropriate code in the following Event Handling Methods 
 	// 
 	private void jTextField3_actionPerformed(ActionEvent e) 
 	{ 
 		//System.out.println("\njTextField3_actionPerformed(ActionEvent e) called."); 
 		// TODO: Add any handling code here 
  
 	} 
  
 	private void jPasswordField1_actionPerformed(ActionEvent e) 
 	{ 
 		//System.out.println("\njPasswordField1_actionPerformed(ActionEvent e) called."); 
 		// TODO: Add any handling code here 
  
 	} 
  
 	private void jPasswordField2_actionPerformed(ActionEvent e) 
 	{ 
 		//System.out.println("\njPasswordField2_actionPerformed(ActionEvent e) called."); 
 		// TODO: Add any handling code here 
  
 	} 
  
 	private void jTextField8_actionPerformed(ActionEvent e) 
 	{ 
 		//System.out.println("\njTextField8_actionPerformed(ActionEvent e) called."); 
 		// TODO: Add any handling code here 
  
 	} 
  
 	private void jComboBox1_actionPerformed(ActionEvent e) 
 	{ 
 		//System.out.println("\njComboBox1_actionPerformed(ActionEvent e) called."); 
 		 
 		Object o = jComboBox1.getSelectedItem(); 
 		//System.out.println(">>" + ((o==null)? "null" : o.toString()) + " is selected."); 
 		// TODO: Add any handling code here for the particular object being selected 
 		 
 	} 
 	
 
 	private void check_actionPerformed(ActionEvent e) 
 	{ 
 		//System.out.println("\njcheck_actionPerformed(ActionEvent e) called."); 
 		
 		Client cl=new Client("select username from logins where username='"+jTextField3.getText()+"'");
 		
 		String ans=cl.strrecv;
 		if(ans==null) new checkid("!!!!UserName  Available!!!!",0);
 		  else new checkid("!!!!UserName Not Available!!!!",1);
 		
 	
 		 
 	} 
  
   private void image_actionPerformed(ActionEvent e) 
 	{ 
 		//System.out.println("\njimage_actionPerformed(ActionEvent e) called."); 
 		 /*
 		 this.setVisible(false);
 	     new imageupload();
 	     this.setVisible(true);
 	     */
 	   // new viewprofile(orkut.currentuser);
 		 
 	}
 	
 	private void create_actionPerformed(ActionEvent e) 
 	{ 
 		//System.out.println("\njcreate_actionPerformed(ActionEvent e) called.");
 		Client cl=new Client();
 	 	
 	 	cl.Processing("select username from logins where username='"+jTextField3.getText()+"';");
 	 	String ans1=cl.strrecv;
 	 	if(ans1==null)
 	 	{
 	 	
 	 	String str="insert into logins values('";
 	 	String temp;
 	 	
 	 	if(!jPasswordField1.getText().equals(jPasswordField2.getText()))
 	 	new passwd();
 	 	
 	 	else
 	 	{
 	 	
 		for(int i=0;i<9;i++) 
 		   { switch(i)
 		           {
 		           	case 0:str=str+jTextField3.getText()+"','";
 		           	       //System.out.println(str);
 		           	       break;
 		           	       
 		           	case 1:str=str+jPasswordField1.getText()+"','";
 		           	      // //System.out.println(str);
 		           	       break;
 		           	case 2:Object o = jComboBox1.getSelectedItem(); 
 		           	       temp=((o==null)? " " : o.toString());
 		           	       str=str+temp+"','";
 		           	     //  //System.out.println(str);
 		           	       break;
 		           	case 3:str=str+jTextField8.getText()+"','";
 		           	       //System.out.println("city..............."+str+"end"+"\n"+"\n");
 		           	       break;
 		           	case 4:Object o1 = month.getSelectedItem();
 		           	       Object o2 = day.getSelectedItem(); 
 		           	       Object o3 = year.getSelectedItem();  
 		           	       temp=((o1==null)? "" : o1.toString());
 		           	       str=str+temp+"/";
 		           	       temp=((o2==null)? "" : o2.toString());
 		           	       str=str+temp+"/";
 		           	       temp=((o3==null)? "" : o3.toString());
 		           	       str=str+temp+"','";
 		           	     //  //System.out.println(str);
 		           	       break;
 		           	       
 		           	case 5:
 		           	      
 		           	       temp=((!friends.isSelected())?"":"Friends,");
 		           	     //  //System.out.println(temp);
 		           	       str=str+temp;
 		           	       temp=((!activity.isSelected())?"":"Activity Partners,");
 		           	       str=str+temp;
 		           	       temp=((!buisnet.isSelected())?"":"Buissness Networking,");
 		           	       str=str+temp+"','"; 
 		           	      // //System.out.println(str);
 		           	       break;
 		           	       
 		           	case 6:str=str+tlang.getText()+"','";
 		           	      // //System.out.println(str);
 		           	       break;
 		           	case 7:str=str+trelig.getText()+"','";
 		           	      // //System.out.println(str);
 		           	       break;
 		           	case 8:
 		           	       temp=((!h1.isSelected())?" ":"campy/cheesy,");
 		           	     //  //System.out.println(temp);
 		           	       str=str+temp;
 		           	       temp=((!h2.isSelected())?" ":"clever/quick witted,");
 		           	       str=str+temp;
 		           	       temp=((!h3.isSelected())?" ":"goofy/slapstick,");
 		           	       str=str+temp;
 		           	       temp=((!h4.isSelected())?" ":"raunchy,");
 		           	       str=str+temp;
 		           	       temp=((!h5.isSelected())?" ":"dry/sarcastic,");
 		           	       str=str+temp;
 		           	       temp=((!h6.isSelected())?" ":"friendly,");
 		           	       str=str+temp;
 		           	       temp=((!h7.isSelected())?" ":"obscure,");
 		           	       str=str+temp+"','";		           	
 		            
 		            
 		           	}
 		   	
 		   	}
 		// //System.out.println(str);
 		 
 		 orkut.currentuser=	jTextField3.getText();
 		 new Client("newus"+ orkut.currentuser);
 		 nextframe=new login2(str,this,jTextField3.getText());
 		 
 		 
 		 nextframe.setVisible(true);
 		 this.setVisible(false);
 	
 		 
 		 }
 	
 		
 		 }
 		 else new checkid("!!!!UserName Not Available!!!!",1);
 	}  
 	
 	private void cancel_actionPerformed(ActionEvent e) 
 	{ 
 		//System.out.println("\njcancel_actionPerformed(ActionEvent e) called."); 
 		System.exit(0); 
 	
 		 
 	} 
 	// 
 	// TODO: Add any method code to meet your needs in the following area 
 	// 
  
 } 
  
 