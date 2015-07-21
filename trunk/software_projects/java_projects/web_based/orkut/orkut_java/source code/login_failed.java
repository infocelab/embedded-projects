
 /****************************************************************/ 
 /*                      login_failed	                            */ 
 /*                                                              */ 
 /****************************************************************/ 
 import java.awt.*; 
 import java.awt.event.*; 
 import javax.swing.*; 
 /** 
  * Summary description for login_failed 
  * 
  */ 
 public class login_failed extends JFrame 
 { 
 	// Variables declaration 
 	private JTextPane jTextPane4; 
 	private JButton jButton1; 
 	private JPanel contentPane; 
 	// End of variables declaration 
  
  
 	public login_failed() 
 	{ 
 		super(); 
 			JFrame.setDefaultLookAndFeelDecorated(true); 
 		JDialog.setDefaultLookAndFeelDecorated(true); 
 		try 
 		{ 
 			UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel"); 
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
 		jTextPane4 = new JTextPane(); 
 		jButton1 = new JButton(); 
 		contentPane = (JPanel)this.getContentPane(); 
  
 		// 
 		// jTextPane4 
 		// 
 		jTextPane4.setBackground(new Color(204, 204, 204)); 
 		jTextPane4.setDisabledTextColor(new Color(232, 16, 16)); 
 		jTextPane4.setForeground(new Color(215, 12, 12)); 
 		jTextPane4.setText("   USERNAME OR PASSWORD NOT MATCHING                           PLEASE TRY AGAIN!!!!!!!!!!!!!!!"); 
 	   	jTextPane4.setEditable(false);
 		// 
 		// jButton1 
 		// 
 		jButton1.setBackground(new Color(94, 106, 232)); 
 		jButton1.setText("OK"); 
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
 		addComponent(contentPane, jTextPane4, 36,62,292,45); 
 		addComponent(contentPane, jButton1, 137,186,89,40); 
 		// 
 		// login_failed 
 		// 
 		this.setTitle("login_failed - extends JFrame"); 
 		this.setLocation(new Point(40, 102)); 
 		this.setSize(new Dimension(390, 300)); 
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
 	        this.setVisible(false);
 		// TODO: Add any handling code here 
  
 	} 
  
 	// 
 	// TODO: Add any method code to meet your needs in the following area 
 	// 
  
 } 
  
 