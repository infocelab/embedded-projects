
 /****************************************************************/ 
 /*                      checkid	                            */ 
 /*                                                              */ 
 /****************************************************************/ 
 import java.awt.*; 
 import java.awt.event.*; 
 import javax.swing.*; 
 /** 
  * Summary description for checkid 
  * 
  */ 
 public class checkid extends JFrame 
 { 
 	// Variables declaration 
 	private JLabel jLabel1; 
 	private JButton OK; 
 	private JPanel contentPane; 
 	// End of variables declaration 
  
  
 	public checkid(String str, int f) 
 	{   super();
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
 		
 		 
 		initializeComponent(str,f); 
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
 	private void initializeComponent(String str1, int f1) 
 	{ 
 		jLabel1 = new JLabel();
 		if(f1==0)
 		jLabel1.setBackground(new Color(14,247,7));
 		else
 		jLabel1.setBackground(new Color(245,44,9));
 		jLabel1.setText(str1);
 		OK = new JButton(); 
 		contentPane = (JPanel)this.getContentPane(); 
  
 		// 
 		// jLabel1 
 		// 
 		// 
 		// OK 
 		// 
 		OK.setText("OK"); 
 		OK.addActionListener(new ActionListener() { 
 			public void actionPerformed(ActionEvent e) 
 			{ 
 				OK_actionPerformed(e); 
 			} 
  
 		}); 
 		// 
 		// contentPane 
 		// 
 		contentPane.setLayout(null); 
 		addComponent(contentPane, jLabel1, 100,48,250,43); 
 		addComponent(contentPane, OK, 160,142,83,28); 
 		// 
 		// checkid 
 		// 
 		this.setTitle("checkid - extends JFrame"); 
 		this.setLocation(new Point(0, 0)); 
 		this.setSize(new Dimension(412, 236)); 
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
 	private void OK_actionPerformed(ActionEvent e) 
 	{ 
 		//System.out.println("\nOK_actionPerformed(ActionEvent e) called."); 
 		// TODO: Add any handling code here 
        this.setVisible(false);
 	} 
 	}
  
 	// 
 	// TODO: Add any method code to meet your needs in the following area 
 	// 
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
   
  
 
 