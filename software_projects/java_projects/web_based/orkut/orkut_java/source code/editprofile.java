

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
 public class editprofile extends JFrame 
 { 
 	// Variables declaration 
 	private editprofile2 nextframe;
 	private JLabel lang;
 	private JLabel relig;
 	private JLabel eid;
 	private JLabel humour;
 //	private JLabel jLabel1; 
 //	private JLabel jLabel2; 
 //	private JLabel jLabel3; 
 	private JLabel jLabel4; 
 	private JLabel jLabel5; 
 	
 	private JTextField jTextField8; 
 	private JComboBox jComboBox1; 
 	private JComboBox month;
 	private JComboBox year;
 	private JComboBox day;
 //	private JButton check;
 	private JButton create;
 	private JButton cancel;
 	private JButton image;
 //	private JLabel title;
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
 	String username;

 	// End of variables declaration 
  
  
 	public editprofile(String username1) 
 	{ 
 		super();
 	    username=username1;
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
 	{   
 	    create=new JButton("Update");
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
// 	    check=new JButton();
// 	    title =new JLabel("Welcome... to ....orkut");
 	    dob=new JLabel("Date of Birth");
// 		jLabel1 = new JLabel(); 
 		
// 		jLabel2 = new JLabel(); 
// 		jLabel3 = new JLabel(); 
 		jLabel4 = new JLabel(); 
 		jLabel5 = new JLabel(); 
 		inte =new JLabel("Interests");
 		
 		
 		
 		
 		
 		
 		
 		jTextField8 = new JTextField(); 
 		jComboBox1 = new JComboBox(); 
 		month = new JComboBox(); 
 		year = new JComboBox(); 
 		day = new JComboBox(); 
 		
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
         
         // lang
         String temp="select lang from logins where username='"+username+"';";
         
         Client c=new Client(temp);
         
         str=c.strrecv;
         tlang.setText(str);
         
         
         // relig
         temp="select relig from logins where username='"+username+"';";
         c.Processing(temp);
          
           str=c.strrecv;
         trelig.setText(str);
          
          
          // dob
          temp="select dob from logins where username='"+username+"';";
         
         
         c.Processing(temp);
         str=c.strrecv;
         
         str=str.trim();
         
         String m=str.substring(0,3);
         
         if(m.equals("Jan"))
         month.setSelectedIndex(0);
         else
         if(m.equals("Feb"))
         month.setSelectedIndex(1);
         else
         if(m.equals("Mar"))
         month.setSelectedIndex(2);
         else
         if(m.equals("Apr"))
         month.setSelectedIndex(3);
         else
         if(m.equals("May"))
         month.setSelectedIndex(4);
         else
         if(str.contentEquals("Jun"))
         month.setSelectedIndex(5);
         else
         if(m.equals("Jul"))
         month.setSelectedIndex(6);
         else
         if(m.equals("Aug"))
         month.setSelectedIndex(7);
         else
         if(m.equals("Sep"))
         month.setSelectedIndex(8);
         else
         if(m.equals("Oct"))
         month.setSelectedIndex(9);
         else
         if(m.equals("Nov"))
         month.setSelectedIndex(10);
         else
         if(m.equals("Dec"))
         month.setSelectedIndex(11);        
          
          String str1;       
          String d="";
          char cha;
         int k;
         for( k=4;(cha=str.charAt(k))!='/';k++)
           d=d + cha ;
         int dat=Integer.parseInt(d);
            dat--;
         	day.setSelectedIndex(dat);
         
         String y=str.substring(k+1,k+5);
         y=y.trim();
         int yea=Integer.parseInt(y);
         yea=yea-1900;
         
         year.setSelectedIndex(yea);
         
        
         
         
        c.Processing("select interest from logins where username='"+username+"';");
          str=c.strrecv;
          str=str.trim();
         
         if(str.indexOf("Friends")>=0)
          friends = new JCheckBox("Friends",true);
          else
          friends = new JCheckBox("Friends",false);
          
          if(str.indexOf("Activity Partners")>=0)
          activity = new JCheckBox("Activity Partners",true);
          else
          activity = new JCheckBox("Activity Partners",false);
          
          if(str.indexOf("Buissness Networking")>=0)
          buisnet = new JCheckBox("Buissness Networking",true);
          else
          buisnet = new JCheckBox("Buissness Networking",false);
          
          friends.setBackground(new Color(158, 168, 237));
 		  activity.setBackground(new Color(158, 168, 237));
 		  buisnet.setBackground(new Color(158, 168, 237));
 		  
 		  
          c.Processing("select humour from logins where username='"+username+"';");
           str=c.strrecv;
           str=str.trim();
          if(str.indexOf("campy/cheesy")>=0)
          h1=new JCheckBox("campy/cheesy",true);
          else
          h1=new JCheckBox("campy/cheesy",false); 
          
          if(str.indexOf("clever/quick witted")>=0)
          h2=new JCheckBox("clever/quick witted",true);
          else 
          h2=new JCheckBox("clever/quick witted",false);
          
          if(str.indexOf("goofy/slapstick")>=0)
          h3=new JCheckBox("goofy/slapstick",true);
          else
          h3=new JCheckBox("goofy/slapstick",false);
          
           if(str.indexOf("raunchy")>=0)
          h4=new JCheckBox("raunchy",true);
          else
          h4=new JCheckBox("raunchy",false);
          
          if(str.indexOf("dry/sarcastic")>=0)
          h5=new JCheckBox("dry/sarcastic",true);
          else
          h5=new JCheckBox("dry/sarcastic",false);
          
           if(str.indexOf("friendly")>=0)
          h6=new JCheckBox("friendly",true);
          else
          h6=new JCheckBox("friendly",false);
          	
 		   if(str.indexOf("obscure")>=0)
          h7=new JCheckBox("obscure",true);
          else
          h7=new JCheckBox("obscure",false);	
          
          
          //done ************************ 
 		
 	
 		h1.setBackground(new Color(158, 168, 237));
 		h2.setBackground(new Color(158, 168, 237));
 		h3.setBackground(new Color(158, 168, 237));
 		h4.setBackground(new Color(158, 168, 237));
 		h5.setBackground(new Color(158, 168, 237));
 		h6.setBackground(new Color(158, 168, 237));
 		h7.setBackground(new Color(158, 168, 237));
 		
 		
 	
 		// 
 		// jLabel1 
 		// 
// 		jLabel1.setText("Username"); 
 		
 		// 
 		// jLabel2 
 		// 
// 		jLabel2.setText("Password"); 
 		// 
 		// jLabel3 
 		// 
// 		jLabel3.setText("Confirm Password"); 
 		// 
 		// jLabel4 
 		// 
 		jLabel4.setText("Sex"); 
 		// 
 		// jLabel5 
 		// 
 		jLabel5.setText("city"); 
 	
 		// 
 	    c.Processing("select country from logins where username='"+username+"';");
 		String res;
 		if((c.strrecv)==null)  res="";
 		 else res=c.strrecv;
 		jTextField8.setText(res); 
 		
 		
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
 		c.Processing("select sex from logins where username='"+username+"';");
 		temp=c.strrecv;
 		temp=temp.trim();
 
 	if(temp.equals("Female"))
     		jComboBox1.setSelectedIndex(1);
    		else
   		jComboBox1.setSelectedIndex(0);
 		
 	
 	//check button
 		
 		
// 		check.setText("Check"); 
 		
 		
 		
/* 		check.addActionListener(new ActionListener() { 
 			public void actionPerformed(ActionEvent e) 
 			{   
 				check_actionPerformed(e);
 				
 				
 				 
 			} 
  
 		}); 
 		
 		
 		*/
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
 		
        
 		
 		contentPane.setLayout(null); 
 		//addComponent(contentPane, jLabel1, 42,45,60,18);
 		//addComponent(contentPane, check, 350,45,70,18); 
 		//addComponent(contentPane, jLabel2, 40,87,60,18); 
 		//addComponent(contentPane, jLabel3, 40,132,96,18); 
 		addComponent(contentPane, jLabel4, 42,45,60,18); 
 		addComponent(contentPane, jLabel5, 45,98,60,18); 
 	
 		
 		addComponent(contentPane, jTextField8, 217,98,100,22); 
 		addComponent(contentPane, jComboBox1, 218,45,100,22);
 		addComponent(contentPane, month, 218,137,100,22);
 		addComponent(contentPane, day, 400,137,50,22);
 		addComponent(contentPane, year, 218,177,100,22);
 		//addComponent(contentPane, title, 150,10,200,22);
 		addComponent(contentPane, dob, 40,137,100,22);
 		addComponent(contentPane, inte, 40,217,100,22);
 		addComponent(contentPane, friends, 218,217,100,22);
 		addComponent(contentPane, activity, 325,217,150,22);
 		addComponent(contentPane, buisnet, 218,240,250,22);
 		addComponent(contentPane, lang, 40,280,100,22);
 		addComponent(contentPane, tlang, 218,280,100,22);
 		addComponent(contentPane, relig, 40,310,100,22);
 		addComponent(contentPane, trelig, 218,310,100,22);
 		addComponent(contentPane, humour, 40,350,100,22);
 		addComponent(contentPane, h1, 218,350,100,22);
 		addComponent(contentPane, h2, 218,370,100,22);
 		addComponent(contentPane, h3, 218,390,100,22);
 		addComponent(contentPane, h4, 218,410,100,22);
 		addComponent(contentPane, h5, 325,350,100,22);
 		addComponent(contentPane, h6, 325,370,100,22);
 		addComponent(contentPane, h7, 325,390,100,22);
 		addComponent(contentPane, image, 40,450,100,22);
 		addComponent(contentPane, create, 200,450,150,22);
 	//	addComponent(contentPane, cancel, 400,450,100,22);
 		
 		// 
 		// login 
 		// 
 		contentPane.setBackground(new Color(158, 168, 237));
 		this.setTitle("editprofile - extends JFrame"); 
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
 	
 		
 	
 		 
 	} 
  
   private void image_actionPerformed(ActionEvent e) 
 	{ 
 		//System.out.println("\njimage_actionPerformed(ActionEvent e) called."); 
 		
 	     
 	     new imageupload();
 	     this.setVisible(false);
 	    // this.setVisible(true);
 	   
 	     
 		 
 	}
 	
 	private void create_actionPerformed(ActionEvent e) 
 	{ 
 		//System.out.println("\njcreate_actionPerformed(ActionEvent e) called.");
 		
 		Client cl=new Client();
 	 	
 	 	
 	 	String temp="";
 	 	String str="";
 	 	
 	 	
 	 
 	 	
 		for(int i=0;i<9;i++) 
 		   { switch(i)
 		           {
 		           	case 0:
 		           	       Object o = jComboBox1.getSelectedItem(); 
 		           	       temp=((o==null)? "" : o.toString());		           	       
 		           	
 		           	       new Client("update logins set sex='"+temp+"'"+"where username='"+username+"';");
 		           	       
 		           	case 1:new Client("update logins set country='"+jTextField8.getText()+"'"+"where username='"+username+"';");
 		           	       break;
 		           	
 		           	       
 		          	case 2:str="";
 		          	       Object o1 = month.getSelectedItem();
 		           	       Object o2 = day.getSelectedItem(); 
 		           	       Object o3 = year.getSelectedItem();  
 		           	       temp=((o1==null)? "" : o1.toString());
 		           	       str=str+temp+"/";
 		           	       temp=((o2==null)? "" : o2.toString());
 		           	       str=str+temp+"/";
 		           	       temp=((o3==null)? "" : o3.toString());
 		           	       str=str+temp;
 		           	       new Client("update logins set dob='"+str+"'"+"where username='"+username+"';");
 		           	       //System.out.println(str);
 		           	       break;       
 		           	case 3:Object o4 = jComboBox1.getSelectedItem(); 
 		           	       temp=((o4==null)? " " : o4.toString());
 		           	       str=str+temp+"','";
 		           	       //System.out.println(str);
 		           	       break;       
 		           	case 4:str="";
 		           	       temp=((!friends.isSelected())?"":"Friends,");
 		           	       //System.out.println(temp);
 		           	       str=str+temp;
 		           	       temp=((!activity.isSelected())?"":"Activity Partners,");
 		           	       str=str+temp;
 		           	       temp=((!buisnet.isSelected())?"":"Buissness Networking,");
 		           	       str=str+temp;
 		           	       //System.out.println(str); 
 		           	       new Client("update logins set interest='"+str+"' where username='"+username+"';");
 		           	       
 		           	       break;
 		           
 		           	       
 		           	case 5:new Client("update logins set lang='"+tlang.getText()+"'"+"where username='"+username+"';");
 		           	      
 		           	      
 		           	       break;
 		           	       
 		           	case 6:new Client("update logins set relig='"+trelig.getText()+"'"+"where username='"+username+"';");
 		           	       break;
 		           	
 		           	case 7:str="";
 		           	       temp=((!h1.isSelected())?" ":"campy/cheesy,");
 		           	       //System.out.println(temp);
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
 		           	       str=str+temp;	
 		           	       new Client("update logins set humour='"+str+"'"+"where username='"+username+"';");	           	
 		                   
 		            
 		           	}
 		   	
 		   	}
 		 //System.out.println(str);
 		
 		 nextframe=new editprofile2(this,username);
 		 
 		 nextframe.setVisible(true);
 		  this.setVisible(false);
 		 }
 	
 		 
 	  
 	
 	private void cancel_actionPerformed(ActionEvent e) 
 	{ 
 		//System.out.println("\njcancel_actionPerformed(ActionEvent e) called."); 
 		System.exit(0); 
 	
 		 
 	} 
 	// 
 	// TODO: Add any method code to meet your needs in the following area 
 	// 
  
  	
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
   
  
 //============================= Testing ================================// 
 //=                                                                    =// 
 //= The following main method is just for testing this class you built.=// 
 //= After testing,you may simply delete it.                            =// 
 //======================================================================// 
 
  
  
 } 
  
 