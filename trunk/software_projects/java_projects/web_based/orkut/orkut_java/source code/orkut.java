//javac -Xlint orkut.java    ->  will give 3 warnings ignore it
//compile others as usuall
//java MultiServer
//java orkut
//go to new user button only
//in passwd, tables are
//(table) logins
//username city scrapbook sex country firstname lastname password
//(table)friends
//user1 user2 done
//done is of yes/no type

 /****************************************************************/ 
 /*                      orkut	                            */ 
 /*                                                              */ 
 /****************************************************************/ 
 import java.io.*; 
 import java.awt.*; 
 import java.awt.event.*; 
 import javax.swing.*; 
 /** 
  * Summary description for orkut 
  * 
  */ 
 public class orkut extends JFrame 
 { 
 	// Variables declaration 
 	private JLabel jLabel1; 
 	private JLabel jLabel2; 
 	private JLabel jLabel3; 
 	private JLabel jLabel4; 
 	private JTextField jTextField1; 
 	private JPasswordField jPasswordField1; 
 	private JButton jButton1; 
 	private JButton jButton2; 
 	private JPanel contentPane; 
 	
 	public static String currentuser;
 	public static String viewname;
 	// End of variables declaration 
  
  
 	public orkut() 
 	{ 
 		super(); 
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
 		jLabel1 = new JLabel(); 
 		jLabel2 = new JLabel(); 
 		jLabel3 = new JLabel(); 
 		jLabel4 = new JLabel(); 
 		jTextField1 = new JTextField(); 
 		jPasswordField1 = new JPasswordField(); 
 		jButton1 = new JButton(); 
 		jButton2 = new JButton(); 
 		contentPane = (JPanel)this.getContentPane(); 
        
                new Client("photo"+"us-photo-true");
                 new Client("photo"+"orkut-only"); 
 		
 		// 
 		// jLabel1 
 		// 
 		
 		
 		jLabel1.setBackground(new Color(196, 212, 242)); 
 		jLabel1.setOpaque(true); 
 		jLabel1.setText("USERNAME"); 
 		// 
 		// jLabel2 
 		// 
 	jLabel2.setBackground(new Color(196, 212, 242)); 
 		jLabel2.setOpaque(true); 
 		jLabel2.setText("PASSWORD"); 
 		
 		// jLabel3 
 		// 
                 
 		jLabel3.setIcon(new ImageIcon("c:/orkut_java/photos/us-photo-true.jpg")); 
 		jLabel4.setIcon(new ImageIcon("c:/orkut_java/photos/orkut-only.jpg")); 
 		// 
 		// jTextField1 
 		// 
 		jTextField1.setBackground(new Color(255, 255, 153)); 
 		jTextField1.addActionListener(new ActionListener() { 
 			public void actionPerformed(ActionEvent e) 
 			{ 
 				jTextField1_actionPerformed(e); 
 			} 
  
 		}); 
 		// 
 		// jPasswordField1 
 		// 
 		jPasswordField1.setBackground(new Color(255, 255, 153)); 
 		jPasswordField1.addActionListener(new ActionListener() { 
 			public void actionPerformed(ActionEvent e) 
 			{ 
 				jPasswordField1_actionPerformed(e); 
 			} 
  
 		}); 
 		// 
 		// jButton1 
 		// 
 		jButton1.setText("login"); 
 		jButton1.addActionListener(new ActionListener() { 
 			public void actionPerformed(ActionEvent e) 
 			{ 
 				jButton1_actionPerformed(e); 
 			} 
  
 		}); 
 		// 
 		// jButton2 
 		// 
 		jButton2.setText("new user"); 
 		jButton2.addActionListener(new ActionListener() { 
 			public void actionPerformed(ActionEvent e) 
 			{ 
 				jButton2_actionPerformed(e); 
 			} 
  
 		}); 
 		// 
 		// contentPane 
 		// 
 		contentPane.setLayout(null); 
 		contentPane.setBackground(new Color(196, 212, 242)); 
 		addComponent(contentPane, jLabel1, 722,192,71,20); 
 		addComponent(contentPane, jLabel2, 721,253,74,18); 
 		addComponent(contentPane, jLabel3, 74,111,600,400); 
 		addComponent(contentPane, jLabel4, 0,10,1024,60); 
 		addComponent(contentPane, jTextField1, 807,191,167,22); 
 		addComponent(contentPane, jPasswordField1, 808,251,164,22); 
 		addComponent(contentPane, jButton1, 781,315,83,22); 
 		addComponent(contentPane, jButton2, 879,315,90,22); 
 		// 
 		// orkut 
 		// 
 		this.setTitle("orkut - extends JFrame"); 
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
 	private void jTextField1_actionPerformed(ActionEvent e) 
 	{ 
 		//System.out.println("\njTextField1_actionPerformed(ActionEvent e) called."); 
 		// TODO: Add any handling code here 
  
 	} 
  
 	private void jPasswordField1_actionPerformed(ActionEvent e) 
 	{ 
 		//System.out.println("\njPasswordField1_actionPerformed(ActionEvent e) called."); 
 		// TODO: Add any handling code here 
  
 	} 
  
 
 	private void jButton1_actionPerformed(ActionEvent e) 
 	{ 
 		//System.out.println("\njButton1_actionPerformed(ActionEvent e) called."); 
 		
              String  strinput="select password from logins where username='"+jTextField1.getText()+"'";
              //  //System.out.println(strinput);

                Client c=new Client(strinput);
                if(c.strrecv!=null && (c.strrecv).equals(jPasswordField1.getText()))
                  { 
                        
                      //  //System.out.println("logging in"); 
                        currentuser=jTextField1.getText();
                        new viewprofile(jTextField1.getText());
                        this.setVisible(false);
                        
                        
                   } 
                 else { 
                        //  //System.out.println(c.strrecv+"no logging in");
                          new login_failed();
                       }
                 
                  // TODO: Add any handling code here 
  
 	} 
  
 	private void jButton2_actionPerformed(ActionEvent e) 
 	{ 
 		//System.out.println("\njButton2_actionPerformed(ActionEvent e) called."); 
 		 
 		   new login();
 		    this.setVisible(false);
 		   //System.out.println("created"); 
 		  
           //this.setVisible(false);
                // TODO: Add any handling code here 
  
 	} 
  
 	// 
 	// TODO: Add any method code to meet your needs in the following area 
 	// 
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
   
  
 //============================= Testing ================================// 
 //=                                                                    =// 
 //= The following main method is just for testing this class you built.=// 
 //= After testing,you may simply delete it.                            =// 
 //======================================================================// 
 	public static void main(String[] args) 
 	{ 
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
 		new orkut(); 
 	} 
 //= End of Testing = 
  
  
 } 
  
 