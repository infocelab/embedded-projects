
 /****************************************************************/ 
 /*                      login2	                            */ 
 /*                                                              */ 
 /****************************************************************/ 
 import java.awt.*; 
 import java.awt.event.*; 
 import javax.swing.*; 
 import java.io.*;
 /** 
  * Summary description for login2 
  * 
  */ 
 public class login2 extends JFrame 
 { 
 	// Variables declaration 
 	private login pframe;
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
 	
 	private JTextField fname; 	
 	private JTextField lname;
 	private JEditorPane abtme; 
 	private JScrollPane abtme1; 
 	private JEditorPane passion; 
 	private JScrollPane passion1;
 	private JEditorPane books; 
 	private JScrollPane books1;
 	private JEditorPane movies; 
 	private JScrollPane movies1;
 	private JCheckBox jCheckBox1; 
 	private JCheckBox jCheckBox2; 
 	private JCheckBox jCheckBox3; 
 	private JCheckBox jCheckBox4; 
 	private JCheckBox jCheckBox5; 
 	private JCheckBox jCheckBox6; 
 	private JCheckBox jCheckBox7; 
 	private JComboBox jComboBox1; 
 	private JComboBox jComboBox2; 
 	private JComboBox jComboBox3; 
 	private JPanel contentPane; 
 	private String str;
 	private String user;
 	// End of variables declaration 
  
  
 	public login2(String halfquery,login preframe,String username) 
 	{   
 		super();
 		pframe=preframe; 
 		str=halfquery;
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
 		jCheckBox6 = new JCheckBox("alternative "); 
 		jCheckBox7 = new JCheckBox("contemporary"); 
 		jComboBox1 = new JComboBox(); 
 		jComboBox2 = new JComboBox(); 
 		jComboBox3 = new JComboBox(); 
 		update     =new JButton("Sign up");
 		
 		
 		back     =new JButton("back");
 		
 		passion1.setViewportView(passion);
 		books1.setViewportView(books);
 		movies1.setViewportView(movies);
 		abtme1.setViewportView(abtme);
 		
 		//labels
 		           lfname=new JLabel("First Name:");
 	               llname=new JLabel("Last Name");
                   labtme=new JLabel("What i m??");
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
 		 
 		jCheckBox1.addItemListener(new ItemListener() { 
 			public void itemStateChanged(ItemEvent e) 
 			{ 
 				jCheckBox1_itemStateChanged(e); 
 			} 
  
 		}); 
 		// 
 		// jCheckBox2 
 		// 
 		
 		jCheckBox2.setSelected(false); 
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
 		addComponent(contentPane, update, 200,680,80,22);
 	
 		addComponent(contentPane, back, 100,680,75,22);
 		// 
 		// login2 
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
 	
 		this.setTitle("login2 - extends JFrame"); 
 		this.setLocation(new Point(0, 0)); 
 		this.setSize(new Dimension(1024,768 )); 
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
 		for(int i=0;i<11;i++) 
 		   { switch(i)
 		           {
 		           	case 0:str=str+fname.getText()+"','";
 		           	       //System.out.println(str);
 		           	       break;
 		           	       
 		           	case 1:str=str+lname.getText()+"','";
 		           	      // //System.out.println(str);
 		           	       break;
 		           	case 2:str=str+abtme.getText()+"','";
 		           	  
 		           	      // //System.out.println(str);
 		           	       break;
 		           	case 3:str=str+passion.getText()+"','";
 		           	       //System.out.println(str);
 		           	       break;
 		           	case 4:str=str+books.getText()+"','";
 		           	      
 		           	       //System.out.println(str);
 		           	       break;
 		           	       
 		           	case 5:str=str+movies.getText()+"','";
 		           	       
 		           	       //System.out.println(str);         	      
 		           	       
 		           	       
 		           	       break;
 		           	       
 		           	case 6:temp=((!jCheckBox1.isSelected())?"":"with partner,");
 		           	       str=str+temp;
 		           	       temp=((!jCheckBox2.isSelected())?"":"alone,");
 		           	       str=str+temp;
 		           	       temp=((!jCheckBox3.isSelected())?"":"with parents,");
 		           	       str=str+temp+"','";
 		           	       break;
 		           	case 7:temp=((!jCheckBox4.isSelected())?"":"urban (fresh style),");
 		           	       str=str+temp;
 		           	       temp=((!jCheckBox5.isSelected())?"":"classic (Formal),");
 		           	       str=str+temp;
 		           	       temp=((!jCheckBox6.isSelected())?"":"alternative ,");
 		           	       str=str+temp;
 		           	       temp=((!jCheckBox7.isSelected())?" ":"contemporary,");
 		           	       str=str+temp+"','";
 		           	       
 		           	       
 		           	       break;
 		           	case 8:
 		           	       Object o = jComboBox1.getSelectedItem(); 
 		           	       temp=((o==null)? " " : o.toString());
 		           	       str=str+temp+"','";
 		           	       //System.out.println(str);
 		           	       break;
 		           	case 9: Object o1 = jComboBox2.getSelectedItem(); 
 		           	       temp=((o1==null)? " " : o1.toString());
 		           	       str=str+temp+"','";
 		           	       //System.out.println(str);
 		           	       break;
 		           	case 10:Object o2 = jComboBox3.getSelectedItem(); 
 		           	       temp=((o2==null)? " " : o2.toString());
 		           	       str=str+temp+"'";
 		           	       //System.out.println(str);
 		           	       break;
 		           
 		           	       
 		            
 		           	} 
 		 
 		 		 
 	}
 	str=str+");";
   
   /*
   try {FileWriter f0 = new FileWriter("c:/orkut_java/file1.txt",true);
      f0.write(str);
     f0.close();
       }
    catch(Exception e1)
      { //System.out.println(e1);}   
 	   
 	   */
 	    new Client(str);
    
    	
 	    //System.out.println("Sign up complete");
    	new welcome(user);
    	this.setVisible(false);
 	 
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
  
 