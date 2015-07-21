
 /****************************************************************/ 
 /*                      welcome	                            */ 
 /*                                                              */ 
 /****************************************************************/ 
 import java.awt.*; 
 import java.awt.event.*; 
 import javax.swing.*; 
 /** 
  * Summary description for welcome 
  * 
  */ 
 public class welcome extends JFrame 
 { 
 	// Variables declaration 
 	String user1;
 	private JLabel jLabel1; 
 	private JButton jButton1; 
 	private JPanel contentPane; 
 	// End of variables declaration 
  
  
 	public welcome(String user) 
 	{ 
 		super(); 
 		user1=user;
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
 		jLabel1 = new JLabel(); 
 		jButton1 = new JButton(); 
 		contentPane = (JPanel)this.getContentPane(); 
  
 		// 
 	
 		// 
 		// jButton1 
 		// 
 		jButton1.setText("GET IN"); 
 		jButton1.addActionListener(new ActionListener() { 
 			public void actionPerformed(ActionEvent e) 
 			{ 
 				jButton1_actionPerformed(e); 
 			} 
  
 		}); 
 		// 
 		// contentPane 
 		// 
 		contentPane.setLayout(null); 
 		contentPane.setBackground(new Color(140, 152, 236)); 
 		addComponent(contentPane, jLabel1, 347,158,289,117); 
 		addComponent(contentPane, jButton1, 452,319,83,28);  
 		// 
 		// welcome 
 		// 
 		
 			// jLabel1 
 		// 
 			jLabel1.setIcon(new ImageIcon("c:/orkut_java/photos/untitled1.jpg")); 
 		jLabel1.setText("WELCOME TO ORKUT!!!"); 
 
 	this.setTitle("welcome - extends JFrame"); 
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
 	private void jButton1_actionPerformed(ActionEvent e) 
 	{ 
 		//System.out.println("\njButton1_actionPerformed(ActionEvent e) called."); 
 		// TODO: Add any handling code here 
 		
 		new viewprofile(user1);
 		this.setVisible(false);
 		
 		//new viewprofile();
  
 	} 
  
 	// 
 	// TODO: Add any method code to meet your needs in the following area 
 	// 
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
   
  
 //============================= Testing ================================// 
 
  
  
 } 
  
 