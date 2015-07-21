
 /****************************************************************/ 
 /*                      editprofile2	                            */ 
 /*                                                              */ 
 /****************************************************************/ 
 import java.awt.*; 
 import java.awt.event.*; 
 import javax.swing.*; 
 import java.io.*;
 /** 
  * Summary description for editprofile2 
  * 
  */ 
 public class editprofile2 extends JFrame 
 { 
 	// Variables declaration 
 	
 	private JLabel lfname;
 	private JLabel llname;
 	private JLabel labtme;
 	private JLabel lpassion;
 	private JLabel lbooks;
 	private JLabel lmovies;
 	private JLabel lfashion;
 	private JLabel lliving;
 	private JLabel lsmoking;
 	private JLabel ldrink;
 	private JLabel lpet;
 	
 	private JButton update;
 	
 	private JButton back;
 	
 	public JTextField fname; 	
 	public JTextField lname;
 	public JEditorPane abtme; 
 	public JScrollPane abtme1; 
 	public JEditorPane passion; 
 	public JScrollPane passion1;
 	public JEditorPane books; 
 	public JScrollPane books1;
 	public JEditorPane movies; 
 	public JScrollPane movies1;
 	public JCheckBox jCheckBox1; 
 	public JCheckBox jCheckBox2; 
 	public JCheckBox jCheckBox3; 
 	public JCheckBox jCheckBox4; 
 	public JCheckBox jCheckBox5; 
 	public JCheckBox jCheckBox6; 
 	public JCheckBox jCheckBox7; 
 	public JComboBox jComboBox1; 
 	public JComboBox jComboBox2; 
 	public JComboBox jComboBox3; 
 	private JPanel contentPane; 
 	private String str;
 	private String user;
 	private editprofile pframe;
 	
 	// End of variables declaration 
  
    public editprofile2()
    {
    }
      
 	public editprofile2(editprofile preframe,String username) 
 	{   
 		super();
 		pframe=preframe; 
 	
 		user=username;
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
  
 		this.setVisible(false); 
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
 		fname      =  new JTextField();
 		lname      =  new JTextField();
 		abtme      =  new JEditorPane();
 		abtme1     =  new JScrollPane();
 		passion    =  new JEditorPane();
 		passion1   =  new JScrollPane();
 		books      =  new JEditorPane();
 		books1     =  new JScrollPane();
 		movies     =  new JEditorPane(); 
 		movies1    =  new JScrollPane();     
 		jCheckBox1 = new JCheckBox("with partner"); 
 		jCheckBox2 = new JCheckBox("alone"); 
 		jCheckBox3 = new JCheckBox("with parents"); 
 		jCheckBox4 = new JCheckBox("urban (fresh style)"); 
 		jCheckBox5 = new JCheckBox("classic (Formal)"); 
 		jCheckBox6 = new JCheckBox("alternative"); 
 		jCheckBox7 = new JCheckBox("contemporary"); 
 		jComboBox1 = new JComboBox(); 
 		jComboBox2 = new JComboBox(); 
 		jComboBox3 = new JComboBox(); 
 		update     =new JButton("update");
 		
 		
 		back     =new JButton("back");
 		
 		passion1.setViewportView(passion);
 		books1.setViewportView(books);
 		movies1.setViewportView(movies);
 		abtme1.setViewportView(abtme);
 		
 		//labels
 		           lfname=new JLabel("First Name:");
 	               llname=new JLabel("Last Name");
                   labtme=new JLabel("About Me");
 	               lpassion=new JLabel("Passion");
 	               lbooks=new JLabel("Books");
                   lmovies=new JLabel("Movies");
 	               lfashion=new JLabel("Fashion");
                   lliving=new JLabel("Living");
 	               lsmoking=new JLabel("Smokiong");
 	               ldrink=new JLabel("Drinking");
 	               lpet=new JLabel("Pets");
 		contentPane = (JPanel)this.getContentPane(); 
  
 		// 
 		// jCheckBox1 
 		// 
 		 Client c=new Client	("select first from logins where username='"+user+"';");
 		
 
 		String str=c.strrecv;
 		str=str.trim();
 		fname.setText(str);
 		
 		 c.Processing("select last from logins where username='"+user+"';");
 		 str=c.strrecv;
 		 str=str.trim();
 		 lname.setText(str);
 		
 		
 		c.Processing("select passion from logins where username='"+user+"';");
        str=c.strrecv;
 		str=str.trim(); 
 		passion.setText(str);
        
        c.Processing("select movie from logins where username='"+user+"';");
        str=c.strrecv;
 		str=str.trim();
        movies.setText(str);
        
        c.Processing("select abtme from logins where username='"+user+"';");
        str=c.strrecv;
 		str=str.trim();
        abtme.setText(str);
        
        c.Processing("select book from logins where username='"+user+"';");
        str=c.strrecv;
 		str=str.trim();
        books.setText(str);
        
        
          c.Processing("select living from logins where username='"+user+"';");
        str=c.strrecv;
 		str=str.trim();
         
         
         
         //System.out.println("living is********"+str);
          //System.out.println("index of alone************"+str.indexOf("alone"));
          if(str.indexOf("alone")>=0)
          jCheckBox2 = new JCheckBox("alone",true);
          else
          jCheckBox2 = new JCheckBox("alone",false);
          
          if(str.indexOf("with partner")>=0)
          jCheckBox1 = new JCheckBox("with partner",true);
          else
          jCheckBox1 = new JCheckBox("with partner",false);
          
          if(str.indexOf("with parents")>=0)
          jCheckBox3 = new JCheckBox("with parents",true);
          else
          jCheckBox3 = new JCheckBox("with parents",false);
          
          
          
         c.Processing("select fashion from logins where username='"+user+"';");
        str=c.strrecv;
 		str=str.trim();
         if(str.indexOf("urban (fresh style)")>=0)
          
          jCheckBox4 = new JCheckBox("urban (fresh style)",true);
          else
          jCheckBox4 = new JCheckBox("urban (fresh style)",false);
          
          if(str.indexOf("classic (Formal)")>=0)
          jCheckBox5 = new JCheckBox("classic (Formal)",true);
          else
          jCheckBox5 = new JCheckBox("classic (Formal)",false);
          
          if(str.indexOf("alternative")>=0)
          jCheckBox6 = new JCheckBox("alternative",true);
          else
          jCheckBox6 = new JCheckBox("alternative",false);
          
           if(str.indexOf("contemporary")>=0)
          jCheckBox7 = new JCheckBox("contemporary",true);
          else
          jCheckBox7 = new JCheckBox("contemporary",false);
          
          
        
      
 		
 		jCheckBox1.addItemListener(new ItemListener() { 
 			public void itemStateChanged(ItemEvent e) 
 			{ 
 				jCheckBox1_itemStateChanged(e); 
 			} 
  
 		}); 
 		// 
 		// jCheckBox2 
 		// 
 		
 		//jCheckBox2.setSelected(false); 
 		jCheckBox2.addItemListener(new ItemListener() { 
 			public void itemStateChanged(ItemEvent e) 
 			{ 
 				jCheckBox2_itemStateChanged(e); 
 			} 
  
 		}); 
 		// 
 		// jCheckBox3 
 		// 
 		
 		jCheckBox3.addItemListener(new ItemListener() { 
 			public void itemStateChanged(ItemEvent e) 
 			{ 
 				jCheckBox3_itemStateChanged(e); 
 			} 
  
 		}); 
 		// 
 		// jCheckBox4 
 		// 
 		 
 		jCheckBox4.addItemListener(new ItemListener() { 
 			public void itemStateChanged(ItemEvent e) 
 			{ 
 				jCheckBox4_itemStateChanged(e); 
 			} 
  
 		}); 
 		// 
 		// jCheckBox5 
 		// 
 		
 		jCheckBox5.addItemListener(new ItemListener() { 
 			public void itemStateChanged(ItemEvent e) 
 			{ 
 				jCheckBox5_itemStateChanged(e); 
 			} 
  
 		}); 
 		// 
 		// jCheckBox6 
 		// 
 	
 		jCheckBox6.addItemListener(new ItemListener() { 
 			public void itemStateChanged(ItemEvent e) 
 			{ 
 				jCheckBox6_itemStateChanged(e); 
 			} 
  
 		}); 
 		// 
 		// jCheckBox7 
 		// 
 		
 		jCheckBox7.addItemListener(new ItemListener() { 
 			public void itemStateChanged(ItemEvent e) 
 			{ 
 				jCheckBox7_itemStateChanged(e); 
 			} 
  
 		}); 
 		
 		// 
 		// jComboBox1 
 		// 
 		jComboBox1.addItem("no answer"); 
 		jComboBox1.addItem("I love my pet(s)"); 
 		jComboBox1.addItem("I like them at zoos"); 
 		jComboBox1.addItem("I dont like pets"); 
 		jComboBox1.addActionListener(new ActionListener() { 
 			public void actionPerformed(ActionEvent e) 
 			{ 
 				jComboBox1_actionPerformed(e); 
 			} 
  
 		}); 
 		
 		
 		
 		update.addActionListener(new ActionListener() { 
 			public void actionPerformed(ActionEvent e) 
 			{ 
 				update_actionPerformed(e); 
 			} 
  
 		}); 
 		
 		back.addActionListener(new ActionListener() { 
 			public void actionPerformed(ActionEvent e) 
 			{ 
 				back_actionPerformed(e); 
 			} 
  
 		}); 
 		// 
 		// jComboBox2 
 		// 
 		jComboBox2.addItem("no answer"); 
 		jComboBox2.addItem("no"); 
 		jComboBox2.addItem("socially"); 
 		jComboBox2.addItem("occasionally"); 
 		jComboBox2.addItem("regularly"); 
 		jComboBox2.addItem("trying to quit"); 
 		jComboBox2.addActionListener(new ActionListener() { 
 			public void actionPerformed(ActionEvent e) 
 			{ 
 				jComboBox2_actionPerformed(e); 
 			} 
  
 		}); 
 		// 
 		// jComboBox3 
 		// 
 		jComboBox3.addItem("no answer"); 
 		jComboBox3.addItem("no"); 
 		jComboBox3.addItem("socially"); 
 		jComboBox3.addItem("occasionally"); 
 		jComboBox3.addItem("regularly"); 
 		jComboBox3.addItem("trying to quit"); 
 		jComboBox3.addActionListener(new ActionListener() { 
 			public void actionPerformed(ActionEvent e) 
 			{ 
 				jComboBox3_actionPerformed(e); 
 			} 
  
 		}); 
 		
 		  
 		  	// pets
 		
 		
 		  c.Processing("select  pets from logins where username='"+user+"';");
        str=c.strrecv;
 		str=str.trim();
        
        if(str.equals("no answer"))
          jComboBox1.setSelectedIndex(0);
         else if(str.equals("I love my pet(s)"))
         jComboBox1.setSelectedIndex(1);
          else if(str.equals("I like them at zoos"))
          jComboBox1.setSelectedIndex(2);
           else jComboBox1.setSelectedIndex(3);
 		
 		  
 		  
 		  
 		  
 		  //drink
 		  
 		  c.Processing("select  drink from logins where username='"+user+"';");
        str=c.strrecv;
 		str=str.trim();
        
        if(str.equals("no answer"))
          jComboBox2.setSelectedIndex(0);
         else if(str.equals("no"))
         jComboBox2.setSelectedIndex(1);
          else if(str.equals("socially"))
          jComboBox2.setSelectedIndex(2);
           else if(str.equals("occasionally"))
           jComboBox2.setSelectedIndex(3);
           else if(str.equals("regularly"))
           jComboBox2.setSelectedIndex(4);
           else jComboBox2.setSelectedIndex(5);
 		
 		
 	//smok
 	
 	
 		  
 		  c.Processing("select  smok from logins where username='"+user+"';");
        str=c.strrecv;
 		str=str.trim();
        
        if(str.equals("no answer"))
          jComboBox3.setSelectedIndex(0);
         else if(str.equals("no"))
         jComboBox3.setSelectedIndex(1);
          else if(str.equals("socially"))
          jComboBox3.setSelectedIndex(2);
           else if(str.equals("occasionally"))
           jComboBox3.setSelectedIndex(3);
           else if(str.equals("regularly"))
           jComboBox3.setSelectedIndex(4);
           else jComboBox3.setSelectedIndex(5);
 		
 		
 		
 		// 
 		// contentPane 
 		// 
 		contentPane.setLayout(null);
 		addComponent(contentPane, fname, 242,5,100,22);
 		addComponent(contentPane, lfname, 40,5,100,22);
 		addComponent(contentPane, lname, 242,33,100,22);
 		addComponent(contentPane, llname, 40,33,100,22);
 		addComponent(contentPane, abtme1, 242,65,350,75);
 		addComponent(contentPane, labtme, 40,65,350,75);
 		addComponent(contentPane, passion1, 242,150,350,75);
 		addComponent(contentPane, lpassion, 40,150,350,75);
 		addComponent(contentPane, books1, 242,235,350,75);
 		addComponent(contentPane, lbooks, 40,235,350,75);
 		addComponent(contentPane, movies1, 242,320,350,75); 
 		addComponent(contentPane, lmovies, 40,320,350,75);
 		addComponent(contentPane, jCheckBox1, 399,406,96,24); 
 		addComponent(contentPane, jCheckBox2, 242,406,96,24); 
 		addComponent(contentPane, lliving, 40,406,96,24);
 		addComponent(contentPane, jCheckBox3, 241,438,96,24); 
 		addComponent(contentPane, jCheckBox4, 241,467,150,24);
 		addComponent(contentPane, jCheckBox6, 400,467,96,24);
 		addComponent(contentPane, lfashion, 40,467,96,24); 
 		addComponent(contentPane, jCheckBox5, 241,502,150,24);  		
 		 
 		addComponent(contentPane, jCheckBox7, 400,502,96,24); 
 		addComponent(contentPane, jComboBox1, 243,553,184,22); 
 		addComponent(contentPane, lpet, 40,553,184,22); 
 		addComponent(contentPane, jComboBox2, 244,595,139,22); 
 		addComponent(contentPane, ldrink, 40,595,139,22); 
 		addComponent(contentPane, jComboBox3, 245,640,137,22); 
 		addComponent(contentPane, lsmoking, 40,640,137,22);
 		addComponent(contentPane, update, 200,680,75,22);
 	
 		addComponent(contentPane, back, 100,680,75,22);
 		// 
 		// editprofile2 
 		// 
 		contentPane.setBackground(new Color(158, 168, 237));
 		fname.setBackground(new Color(241, 245, 31));
 		lname.setBackground(new Color(241, 245, 31));
 		abtme.setBackground(new Color(224, 249, 162));
 		passion.setBackground(new Color(161,247,241));
 		books.setBackground(new Color(244, 195, 103));
 		movies.setBackground(new Color(239,122,247));
 		jCheckBox1.setBackground(new Color(81,240,106));
 		jCheckBox2.setBackground(new Color(81,240,106));
 		jCheckBox3.setBackground(new Color(81,240,106));
 		jCheckBox4.setBackground(new Color(239,122,247));
 		jCheckBox5.setBackground(new Color(239,122,247));
 		jCheckBox6.setBackground(new Color(239,122,247));
 		jCheckBox7.setBackground(new Color(239,122,247));
 		update.setBackground(new Color(59,235,54));
 	
 		this.setTitle("editprofile2 - extends JFrame"); 
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
 	private void jCheckBox1_itemStateChanged(ItemEvent e) 
 	{ 
 		//System.out.println("\njCheckBox1_itemStateChanged(ItemEvent e) called."); 
 		//System.out.println(">>" + ((e.getStateChange() == ItemEvent.SELECTED) ? "selected":"unselected")); 
 		// TODO: Add any handling code here 
 		 
 	} 
  
 	private void jCheckBox2_itemStateChanged(ItemEvent e) 
 	{ 
 		//System.out.println("\njCheckBox2_itemStateChanged(ItemEvent e) called."); 
 		//System.out.println(">>" + ((e.getStateChange() == ItemEvent.SELECTED) ? "selected":"unselected")); 
 		// TODO: Add any handling code here 
 		 
 	} 
  
 	private void jCheckBox3_itemStateChanged(ItemEvent e) 
 	{ 
 		//System.out.println("\njCheckBox3_itemStateChanged(ItemEvent e) called."); 
 		//System.out.println(">>" + ((e.getStateChange() == ItemEvent.SELECTED) ? "selected":"unselected")); 
 		// TODO: Add any handling code here 
 		 
 	} 
  
 	private void jCheckBox4_itemStateChanged(ItemEvent e) 
 	{ 
 		//System.out.println("\njCheckBox4_itemStateChanged(ItemEvent e) called."); 
 		//System.out.println(">>" + ((e.getStateChange() == ItemEvent.SELECTED) ? "selected":"unselected")); 
 		// TODO: Add any handling code here 
 		 
 	} 
  
 	private void jCheckBox5_itemStateChanged(ItemEvent e) 
 	{ 
 		//System.out.println("\njCheckBox5_itemStateChanged(ItemEvent e) called."); 
 		//System.out.println(">>" + ((e.getStateChange() == ItemEvent.SELECTED) ? "selected":"unselected")); 
 		// TODO: Add any handling code here 
 		 
 	} 
  
 	private void jCheckBox6_itemStateChanged(ItemEvent e) 
 	{ 
 		//System.out.println("\njCheckBox6_itemStateChanged(ItemEvent e) called."); 
 		//System.out.println(">>" + ((e.getStateChange() == ItemEvent.SELECTED) ? "selected":"unselected")); 
 		// TODO: Add any handling code here 
 		 
 	} 
  
 	private void jCheckBox7_itemStateChanged(ItemEvent e) 
 	{ 
 		//System.out.println("\njCheckBox7_itemStateChanged(ItemEvent e) called."); 
 		//System.out.println(">>" + ((e.getStateChange() == ItemEvent.SELECTED) ? "selected":"unselected")); 
 		// TODO: Add any handling code here 
 		 
 	} 
  
 	private void jComboBox1_actionPerformed(ActionEvent e) 
 	{ 
 		//System.out.println("\njComboBox1_actionPerformed(ActionEvent e) called."); 
 		 
 		Object o = jComboBox1.getSelectedItem(); 
 		//System.out.println(">>" + ((o==null)? "null" : o.toString()) + " is selected."); 
 		// TODO: Add any handling code here for the particular object being selected 
 		 
 	} 
  
 	private void jComboBox2_actionPerformed(ActionEvent e) 
 	{ 
 		//System.out.println("\njComboBox2_actionPerformed(ActionEvent e) called."); 
 		 
 		Object o = jComboBox2.getSelectedItem(); 
 		//System.out.println(">>" + ((o==null)? "null" : o.toString()) + " is selected."); 
 		// TODO: Add any handling code here for the particular object being selected 
 		 
 	} 
  
 	private void jComboBox3_actionPerformed(ActionEvent e) 
 	{ 
 		//System.out.println("\njComboBox3_actionPerformed(ActionEvent e) called."); 
 		 
 		Object o = jComboBox3.getSelectedItem(); 
 		//System.out.println(">>" + ((o==null)? "null" : o.toString()) + " is selected."); 
 		// TODO: Add any handling code here for the particular object being selected 
 		 
 	} 
 	private void update_actionPerformed(ActionEvent e) 
 	{ 
 		//System.out.println("\njupdate_actionPerformed(ActionEvent e) called.");
 		String temp=new String(); 
 		String temppara=new String(); 
 	//	str="insert into logins(fname,lname,abtme,passion,book,movies,living,fashion,pets,drink,smok) values('";
 		for(int i=0;i<11;i++) 
 		   { switch(i)
 		           {
 		           	case 0:str=fname.getText();
 		           	       //System.out.println(str);
 		           	        temppara="first";
 		           	       // new Client("update logins set first='"+str+"'"+"where username='"+orkut.currentuser+"';");
 		           	       break;
 		           	       
 		           	case 1:str=lname.getText();
 		           	       //System.out.println(str);
 		           	       temppara="last";
 		           	       // new Client("update logins set last='"+str+"'"+"where username='"+orkut.currentuser+"';");
 		           	       break;
 		           	       
 		           	case 2:str=abtme.getText();
 		           	  
 		                   //System.out.println("abt me is"+str);
 		                   str=str.trim();
 		                   temppara="abtme";
 		           	        // new Client("update logins set abtme='"+str+"'"+"where username='"+orkut.currentuser+"';");
 		           	     
 		           	       break;
 		           
 		           	case 3:str=passion.getText();
 		           	       //System.out.println(str);
 		           	       temppara="passion";
 		           	       // new Client("update logins set passion='"+str+"'"+"where username='"+orkut.currentuser+"';");
 		           	     
 		           	       break;
 		           	case 4:str=books.getText();
 		           	       temppara="book";
 		           	       //System.out.println(str);
 		           	        //new Client("update logins set book='"+str+"'"+"where username='"+orkut.currentuser+"';");
 		           	     
 		           	       break;
 		           	     
 		           	case 5:str=movies.getText();
 		           	       temppara="movie";
 		           	       //System.out.println(str);  
 		           	       // new Client("update logins set movie='"+str+"'"+"where username='"+orkut.currentuser+"';");
 		           	            	      
 		           	       
 		           	       
 		           	       break;
 		           	     //**********    
 		           	case 6:temp=((!jCheckBox1.isSelected())?"":"with partner,");
 		           	       str="";
 		           	       str=str+temp;
 		           	       temp=((!jCheckBox2.isSelected())?"":"alone,");
 		           	       str=str+temp;
 		           	       temp=((!jCheckBox3.isSelected())?"":"with parents,");
 		           	     
 		           	       str=str+temp;
 		           	       temppara="living";
 		           	       break;
 		           	
 		           	
 		           	case 7:temp=((!jCheckBox4.isSelected())?"":"urban (fresh style),");
 		           	       str="";
 		           	       str=str+temp;
 		           	       temp=((!jCheckBox5.isSelected())?"":"classic (Formal),");
 		           	       str=str+temp;
 		           	       temp=((!jCheckBox6.isSelected())?"":"alternative,");
 		           	       str=str+temp;
 		           	       temp=((!jCheckBox7.isSelected())?" ":"contemporary,");
 		           	       str=str+temp;
 		           	       
 		           	       temppara="fashion";
 		           	       
 		           	       break;
 		           	case 8:
 		           	       Object o = jComboBox1.getSelectedItem(); 
 		           	       temp=((o==null)? "" : o.toString());
 		           	       str="";
 		           	       str=str+temp;
 		           	       temppara="pets";
 		           	       
 		           	       //System.out.println(str);
 		           	       break;
 		           	case 9: Object o1 = jComboBox2.getSelectedItem(); 
 		           	       temp=((o1==null)? "" : o1.toString());
 		           	       str="";
 		           	       str=str+temp;
 		           	       //System.out.println(str);
 		           	       temppara="drink";
 		           	       break;
 		           	case 10:Object o2 = jComboBox3.getSelectedItem(); 
 		           	       temp=((o2==null)? "" : o2.toString());
 		           	        str="";
 		           	       str=str+temp;
 		           	       //System.out.println(str);
 		           	       temppara="smok";
 		           	       break;
 		           
 		           	       
 		            
 		           	} 
 		 
 		 	new Client("update logins set "+ temppara+ " ='"+str+"'"+"where username='"+orkut.currentuser+"';");	 
        
 	}
 
   /*
   try {FileWriter f0 = new FileWriter("c:/orkut_java/file1.txt",true);
      f0.write(str);
     f0.close();
       }
    catch(Exception e1)
      {//System.out.println(e1);}   
 	
 	//new Client(str);
  */
 	
 
 	//System.out.println("Sign up complete");
    new viewprofile(user);
    
    	this.setVisible(false);
   //	new welcome(user);
 	 
 	}
 	private void back_actionPerformed(ActionEvent e) 
 	{ 
 		//System.out.println("\njback_actionPerformed(ActionEvent e) called."); 
 		
 		 pframe.setVisible(true);
 		  this.setVisible(false);
 		
 		 
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
  
 