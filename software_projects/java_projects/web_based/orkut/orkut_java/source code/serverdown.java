
 /****************************************************************/ 
 /*                      serverdown	                            */ 
 /*                                                              */ 
 /****************************************************************/ 
 import java.awt.*; 
 import java.awt.event.*; 
 import javax.swing.*; 
 /** 
  * Summary description for serverdown 
  * 
  */ 
 public class serverdown extends JFrame 
 { 
 	// Variables declaration 
 	private JTextPane jTextPane1; 
 	private JButton jButton1; 
 	private JButton jButton2; 
 	private JPanel contentPane; 
 	// End of variables declaration 
  
  
 	public serverdown() 
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
 	{ 
 		jTextPane1 = new JTextPane(); 
 		jButton1 = new JButton(); 
 		jButton2 = new JButton(); 
 		contentPane = (JPanel)this.getContentPane(); 
  
 		// 
 		// jTextPane1 
 		// 
 		jTextPane1.setBackground(new Color(140, 152, 236)); 
 		jTextPane1.setForeground(new Color(255, 0, 0)); 
 		jTextPane1.setText("                               \n                                                 NO DONUT FOR YOU\n                           SORRY FOR INCONVINIENCE FACED BY YOU\n                                    SEVER IS DOWN FOR A TIME BEING\n                                         PLEASE TRY AGAIN LATER"); 
 		jTextPane1.setEditable(false);
 		// 
 		// jButton1 
 		// 
 		jButton1.setText("Home"); 
 		jButton1.addActionListener(new ActionListener() { 
 			public void actionPerformed(ActionEvent e) 
 			{ 
 				jButton1_actionPerformed(e); 
 			} 
  
 		}); 
 		// 
 		// jButton2 
 		// 
 		jButton2.setText("Friends"); 
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
 		contentPane.setBackground(new Color(140, 152, 236)); 
 		addComponent(contentPane, jTextPane1, 76,165,451,150); 
 		addComponent(contentPane, jButton1, 94,36,83,39); 
 		addComponent(contentPane, jButton2, 184,36,83,39); 
 		// 
 		// serverdown 
 		// 
 		this.setTitle("serverdown - extends JFrame"); 
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
   
 //
 	private void jButton1_actionPerformed(ActionEvent e) 
 	{ 
 		//System.out.println("\njButton1_actionPerformed(ActionEvent e) called."); 
 	    
 	    new viewprofile(orkut.currentuser);
 		this.setVisible(false);
 		// TODO: Add any handling code here 
  
 	} 
  //Friends
 	private void jButton2_actionPerformed(ActionEvent e) 
 	{ 
 		//System.out.println("\njButton2_actionPerformed(ActionEvent e) called."); 
 	//	new Client("frien"+orkut.currentuser);
 	new viewprofile(orkut.currentuser);
 		this.setVisible(false);
 		// TODO: Add any handling code here 
  
 	} 
  
 	// 
 	// TODO: Add any method code to meet your needs in the following area 
 	// 
  
  
 } 
  
 