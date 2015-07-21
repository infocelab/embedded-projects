
 /****************************************************************/ 
 /*                      viewprofile1	                            */ 
 /*                                                              */ 
 /****************************************************************/ 
 import java.awt.*; 
 import java.awt.event.*; 
 import javax.swing.*; 
 /** 
  * Summary description for viewprofile1 
  * 
  */ 
 public class viewprofile1 extends JFrame 
 { 
 	// Variables declaration 
 	public JLabel jLabel1; 
 	public JLabel jLabel2; 
 	public JLabel jLabel3; 
 	public JLabel jLabel4; 
 	public JLabel jLabel5; 
 	public JLabel jLabel6; 
 	public JLabel jLabel7; 
 	public JLabel jLabel8; 
 	private JButton jButton1;
 	
 		public JEditorPane passion; 
 	public JScrollPane passion1;
 	public JEditorPane books; 
 	public JScrollPane books1;
 	public JEditorPane movies; 
 	public JScrollPane movies1;
 	/*
 	public JTextField jTextField1; 
 	public JTextField jTextField2; 
 	public JTextField jTextField3; 
 */
 	public JTextField jTextField4; 
 	public JTextField jTextField5; 
 	public JTextField jTextField6; 
 	public JTextField jTextField7; 
 	public JTextField jTextField8; 
 	public JPanel contentPane; 
 	// End of variables declaration 
 	viewprofile pre1;
 	view_others pre2;
 	public int flag;
  
    public viewprofile1() 
           {
           }
 	public viewprofile1(viewprofile pre) 
 	{ 
 		super(); 
 		pre1=pre;
 		flag=0;
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
 	public viewprofile1(view_others pre) 
 	{ 
 		super(); 
 		pre2=pre;
 		flag =1;
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
 		jLabel1 = new JLabel(); 
 		jLabel2 = new JLabel(); 
 		jLabel3 = new JLabel(); 
 		jLabel4 = new JLabel(); 
 		jLabel5 = new JLabel(); 
 		jLabel6 = new JLabel("Pets"); 
 		jLabel7 = new JLabel("Drinking"); 
 		jLabel8 = new JLabel("Smoking");
 		jButton1=new JButton("Back");
 		 
 		passion    =  new JEditorPane();
 		passion1   =  new JScrollPane();
 		books      =  new JEditorPane();
 		books1     =  new JScrollPane();
 		movies     =  new JEditorPane(); 
 		movies1    =  new JScrollPane(); 
 		/*
 		jTextField1 = new JTextField(); 
 		jTextField2 = new JTextField(); 
 		jTextField3 = new JTextField(); 
 		*/
 		jTextField4 = new JTextField(); 
 		jTextField5 = new JTextField(); 
 		jTextField6 = new JTextField(); 
 		jTextField7 = new JTextField(); 
 		jTextField8 = new JTextField(); 
 		
 		passion1.setViewportView(passion);
 		books1.setViewportView(books);
 		movies1.setViewportView(movies);
 	
 		contentPane = (JPanel)this.getContentPane(); 
  
        //set editable false
        
        passion.setEditable(false);
        books.setEditable(false);
        movies.setEditable(false);
      	jTextField4.setEditable(false);
        jTextField5.setEditable(false);
        jTextField6.setEditable(false);
        jTextField7.setEditable(false);
        jTextField8.setEditable(false);
        
  
 		// 
 		// jLabel1 
 		// 
 		jLabel1.setText("Passion"); 
 		// 
 		// jLabel2 
 		// 
 		jLabel2.setText("Books"); 
 		// 
 		// jLabel3 
 		// 
 		jLabel3.setText("Movies"); 
 		// 
 		// jLabel4 
 		// 
 		jLabel4.setText("Living"); 
 		// 
 		// jLabel5 
 		// 
 		jLabel5.setText("Fashion"); 
 		// 
 		// jTextField1 
 		// 
 	
 		/*
 		jTextField1.addActionListener(new ActionListener() { 
 			public void actionPerformed(ActionEvent e) 
 			{ 
 				jTextField1_actionPerformed(e); 
 			} 
  
 		}); 
 		// 
 		// jTextField2 
 		// 
 	
 		jTextField2.addActionListener(new ActionListener() { 
 			public void actionPerformed(ActionEvent e) 
 			{ 
 				jTextField2_actionPerformed(e); 
 			} 
  
 		}); 
 		// 
 		// jTextField3 
 		// 
 	
 		jTextField3.addActionListener(new ActionListener() { 
 			public void actionPerformed(ActionEvent e) 
 			{ 
 				jTextField3_actionPerformed(e); 
 			} 
  
 		}); 
 		
 		*/
 		// 
 		// jTextField4 
 		// 
 	
 		jTextField4.addActionListener(new ActionListener() { 
 			public void actionPerformed(ActionEvent e) 
 			{ 
 				jTextField4_actionPerformed(e); 
 			} 
  
 		}); 
 		// 
 		// jTextField5 
 		// 
 		
 		jTextField5.addActionListener(new ActionListener() { 
 			public void actionPerformed(ActionEvent e) 
 			{ 
 				jTextField5_actionPerformed(e); 
 			} 
  
 		}); 
 		
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
 		contentPane.setBackground(new Color(158, 168, 237)); 
 		addComponent(contentPane, jLabel1, 36,97,86,26); 
 		addComponent(contentPane, jLabel2, 34,238,60,18); 
 		addComponent(contentPane, jLabel3, 33,373,60,18); 
 		addComponent(contentPane, jLabel4, 31,440,60,18); 
 		addComponent(contentPane, jLabel5, 30,484,60,18); 
 		addComponent(contentPane, jLabel6, 30,527,60,18); 
 		addComponent(contentPane, jLabel7, 30,567,60,18); 
 		addComponent(contentPane, jLabel8, 30,612,60,18); 
 		addComponent(contentPane, passion1, 237,59,350,96); 
 		addComponent(contentPane, books1, 236,189,350,96); 
 		addComponent(contentPane, movies1, 236,320,350,98); 
 		addComponent(contentPane, jTextField4, 237,440,350,22); 
 		addComponent(contentPane, jTextField5, 237,484,350,22); 
 		addComponent(contentPane, jTextField6, 237,527,350,22); 
 		addComponent(contentPane, jTextField7, 237,567,350,22); 
 		addComponent(contentPane, jTextField8, 237,612,350,22); 
 		addComponent(contentPane, jButton1, 456,654,74,25); 
 	
 		// 
 		// viewprofile1 
 		// 
 		
 		passion.setBackground(new Color(161,247,241));
 		books.setBackground(new Color(244, 195, 103));
 		movies.setBackground(new Color(239,122,247));
 		jTextField4.setBackground(new Color(161,247,241));
 		jTextField5.setBackground(new Color(244, 195, 103));
 		jTextField6.setBackground(new Color(239,122,247));
 		jTextField7.setBackground(new Color(161,247,241));
 		jTextField8.setBackground(new Color(244, 195, 103));
 		this.setTitle("viewprofile1 - extends JFrame"); 
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
 /*
 	private void jTextField1_actionPerformed(ActionEvent e) 
 	{ 
 		//System.out.println("\njTextField1_actionPerformed(ActionEvent e) called."); 
 		// TODO: Add any handling code here 
  
 	} 
  
 	private void jTextField2_actionPerformed(ActionEvent e) 
 	{ 
 		//System.out.println("\njTextField2_actionPerformed(ActionEvent e) called."); 
 		// TODO: Add any handling code here 
  
 	} 
  
 	private void jTextField3_actionPerformed(ActionEvent e) 
 	{ 
 		//System.out.println("\njTextField3_actionPerformed(ActionEvent e) called."); 
 		// TODO: Add any handling code here 
  
 	} 
  
  */
 	private void jTextField4_actionPerformed(ActionEvent e) 
 	{ 
 		//System.out.println("\njTextField4_actionPerformed(ActionEvent e) called."); 
 		// TODO: Add any handling code here 
  
 	} 
  
 	private void jTextField5_actionPerformed(ActionEvent e) 
 	{ 
 		//System.out.println("\njTextField5_actionPerformed(ActionEvent e) called."); 
 		// TODO: Add any handling code here 
  
 	} 
   
   
   	private void jButton1_actionPerformed(ActionEvent e) 
 	{ 
 		//System.out.println("\njButton1_actionPerformed(ActionEvent e) called."); 
 		// TODO: Add any handling code here 
 		this.setVisible(false);
 		if(flag==0)
 		pre1.setVisible(true);
 		else
 		pre2.setVisible(true);
 		 		
  
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
  
 