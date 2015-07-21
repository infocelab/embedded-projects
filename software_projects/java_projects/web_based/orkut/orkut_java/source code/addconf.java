
 /****************************************************************/ 
 /*                      addconf	                            */ 
 /*                                                              */ 
 /****************************************************************/ 
 import java.awt.*; 
 import java.awt.event.*; 
 import javax.swing.*; 
 /** 
  * Summary description for addconf 
  * 
  */ 
 public class addconf extends JFrame 
 { 
 	// Variables declaration 
 	private JLabel jLabel1; 
 	private JButton jButton1; 
 	private JButton jButton2; 
 	private JPanel contentPane; 
 	// End of variables declaration 
    addconf[] req1;
    String b1[];
    int frame;
    int frno1;
    	public addconf() 
 	{ 
 	}
 	public addconf(String b[],addconf req[],int max,int frno) 
 	{ 
 		super(); 
 		req1=req;
 		b1=b;
 		frame=max;
 		frno1=frno;
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
        if(frno1==0)
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
 		jButton2 = new JButton(); 
 		contentPane = (JPanel)this.getContentPane(); 
  
 		// 
 		// jLabel1 
 		// 
 		jLabel1.setText("Do you want to add "+ b1[frno1]+" as Friend?"); 
 		// 
 		// jButton1 
 		// 
 		jButton1.setText("Yes"); 
 		jButton1.addActionListener(new ActionListener() { 
 			public void actionPerformed(ActionEvent e) 
 			{ 
 				jButton1_actionPerformed(e); 
 			} 
  
 		}); 
 		// 
 		// jButton2 
 		// 
 		jButton2.setText("No"); 
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
 		contentPane.setBackground(new Color(158, 168, 237)); 
 		addComponent(contentPane, jLabel1, 90,49,224,18); 
 		addComponent(contentPane, jButton1, 65,122,82,25); 
 		addComponent(contentPane, jButton2, 201,121,83,26); 
 		// 
 		// addconf 
 		// 
 		this.setTitle("addconf - extends JFrame"); 
 		this.setLocation(new Point(0, 0)); 
 		this.setSize(new Dimension(349, 208)); 
 		this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE); 
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
 	
 		//System.out.println("******frno="+frno1+"max fr=  "+frame); 
 		new Client("addco"+orkut.currentuser+"*"+b1[frno1]);
 		if(frno1<frame)
 	    {
 	     req1[frno1].setVisible(false);
 	     
 	     //System.out.println("current="+orkut.currentuser+"view=  "+b1[frno1++]);
 	     
 	    
 	     req1[frno1+1].setVisible(true);
 	     }
 		if(frno1==frame)
 		req1[frno1].setVisible(false);
       
 	} 
  
 	private void jButton2_actionPerformed(ActionEvent e) 
 	{ 
 		//System.out.println("\njButton2_actionPerformed(ActionEvent e) called."); 
 		// TODO: Add any handling code here 
 		//System.out.println("******frno="+frno1);
 		
        
        //System.out.println("******frno="+frno1+"max fr=  "+frame);
        new Client("addco"+orkut.currentuser+"@"+b1[frno1]);
 		if(frno1<frame)
 	    {req1[frno1].setVisible(false); 
 	   // //System.out.println("******frno="+frno1);
 	   	
 	    req1[frno1+1].setVisible(true);
 	    }
 		if(frno1==frame)
 		req1[frno1].setVisible(false);
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
  
 