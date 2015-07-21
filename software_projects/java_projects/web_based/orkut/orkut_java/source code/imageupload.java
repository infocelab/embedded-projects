
 /****************************************************************/ 
 /*                      imageupload	                            */ 
 /*                                                              */ 
 /****************************************************************/ 
 import java.awt.*; 
 import java.awt.event.*; 
 import javax.swing.*; 
 import java.io.*;
 //import java.util.*;
 /** 
  * Summary description for imageupload 
  * 
  */ 
 public class imageupload  extends JFrame 
 { 
 	// Variables declaration 
 	 transient JLabel jLabel1; 
 	 JTextField jTextField1; 
 	 JEditorPane jEditorPane1; 
 	 JButton jButton1; 
 	 JButton jButton2; 
 	 JButton jButton3; 
 	 JButton jButton4; 
 	 
 //	private JButton jButton5; 
 	private JPanel contentPane; 
 	// End of variables declaration 
  
  
 	public imageupload() 
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
 	         File f=new File("c:/orkut_java/photos/"+orkut.currentuser+".jpg");
 	           f.delete(); 
 	    	new Client("photo"+orkut.currentuser);
 		jLabel1 = new JLabel(); 
 		jTextField1 = new JTextField(); 
 		jEditorPane1 = new JEditorPane(); 
 		jButton1 = new JButton(); 
 		jButton2 = new JButton(); 
 		jButton3 = new JButton(); 
 		jButton4 = new JButton(); 
 		//jButton5 = new JButton(); 
 		contentPane = (JPanel)this.getContentPane(); 
  
 		// 
 		// jLabel1 
 		// 
 		jLabel1.setForeground(new Color(255, 0, 0)); 
 		jLabel1.setText("       NO PHOTO"); 
 		
 	
 		try{
 		
 		InputStream f0 = new FileInputStream("c:/orkut_java/photos/"+orkut.currentuser+".jpg");
 		
 		  int nobytes=f0.available();
 		  
 		  f0.close();
 		  
 		  //System.out.println("nobytes photo file= "+nobytes);
 	
          }
          catch (Exception ex){ //System.out.println(" in image upload"+ex);
                                }	
 	      
 	     ImageIcon    cruser = new ImageIcon("c:/orkut_java/photos/"+orkut.currentuser+".jpg");
 	    	
 	    	//jLabel1.setIcon(cruser);
 	
 	
 		jLabel1=new JLabel (cruser);
 		// 
 		// jTextField1 
 		// 
 		jTextField1.addActionListener(new ActionListener() { 
 			public void actionPerformed(ActionEvent e) 
 			{ 
 				jTextField1_actionPerformed(e); 
 			} 
  
 		}); 
 		// 
 		// jEditorPane1 
 		// 
 		jEditorPane1.setBackground(new Color(255, 153, 255)); 
 		jEditorPane1.setForeground(new Color(0, 0, 204)); 
 		jEditorPane1.setText("\n               IF YOU WANT TO CHANGE YOUR\n                      YOUR PREVIOUS PHOTO\n                     BROUSE & SELECT PHOTO\n         EVEN IF  IT\'S NOT CHANGING REFRESH IT "); 
 		jEditorPane1.setEditable(false); 
 		// 
 		// jButton1 
 		// 
 		jButton1.setText("Browse"); 
 		jButton1.addActionListener(new ActionListener() { 
 			public void actionPerformed(ActionEvent e) 
 			{ 
 				jButton1_actionPerformed(e); 
 			} 
  
 		}); 
 		// 
 		// jButton2 
 		// 
 		jButton2.setText("Upload"); 
 		jButton2.addActionListener(new ActionListener() { 
 			public void actionPerformed(ActionEvent e) 
 			{ 
 				jButton2_actionPerformed(e); 
 			} 
  
 		}); 
 		// 
 		// jButton3 
 		// 
 		jButton3.setText("Back"); 
 		jButton3.addActionListener(new ActionListener() { 
 			public void actionPerformed(ActionEvent e) 
 			{ 
 				jButton3_actionPerformed(e); 
 			} 
  
 		}); 
 		// 
 		// jButton4 
 		// 
 		jButton4.setText("Refresh"); 
 		jButton4.addActionListener(new ActionListener() { 
 			public void actionPerformed(ActionEvent e) 
 			{ 
 				jButton4_actionPerformed(e); 
 			} 
  
 		}); 
 		
 		
 			// 
 		// jButton5 
 		// 
 	
 	/*
 		jButton5.setText("Back"); 
 		jButton5.addActionListener(new ActionListener() { 
 			public void actionPerformed(ActionEvent e) 
 			{ 
 				jButton5_actionPerformed(e); 
 			} 
  
 		}); 
 		
 		
 		*/
 		// 
 		// contentPane 
 		// 
 		contentPane.setLayout(null); 
 		contentPane.setBackground(new Color(140, 152, 236)); 
 		addComponent(contentPane, jLabel1, 289,172,100,100); 
 		addComponent(contentPane, jTextField1, 400,49,310,24); 
 		addComponent(contentPane, jEditorPane1, 401,172,309,100); 
 		addComponent(contentPane, jButton1, 732,50,83,24); 
 		addComponent(contentPane, jButton2, 733,202,83,24); 
 		addComponent(contentPane, jButton3, 124,16,83,24); 
 		addComponent(contentPane, jButton4, 225,16,83,24); 
 	//	addComponent(contentPane, jButton5, 320,16,83,24); 
 		// 
 		// imageupload 
 		// 
 		//System.out.println("*****label set*****");
 	     
	    
	   
 	
 	    
 	
 		this.setTitle("imageupload - extends JFrame"); 
 		this.setLocation(new Point(0, 0)); 
 		this.setSize(new Dimension(1024, 768)); 
 		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
 	
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
  
 	private void jButton1_actionPerformed(ActionEvent e) 
 	{ 
 		//System.out.println("\njButton1_actionPerformed(ActionEvent e) called."); 
 		
 	FileDialogDemo f1 =	new FileDialogDemo();
 		
 	String filepath1 =	f1.filepath;
 	
 	jTextField1.setText(filepath1);	
 	// TODO: Add any handling code here 
  
 	} 
  
 
 	private void jButton2_actionPerformed(ActionEvent e) 
 	{ 
 		
 		
 	//	//System.out.println("\njButton2_actionPerformed(ActionEvent e) called."); 
 				try{
   
   
    int i;
    FileInputStream fin;
  // open input file

    fin = new FileInputStream(jTextField1.getText());
 


// Copy File into string s


	int bytes=fin.available(),j=0;
    
 
 //read in string s

String s="";
do {

i = fin.read();
if(i != -1) 
  s=s+i+'\n';

} while(i != -1);

fin.close();
new Client("phtin"+orkut.currentuser+"*"+s);
}
catch(Exception ex){ //System.out.println("while phtin"+ex);
                    }
 	
 //	new Client ("photo"+orkut.currentuser);
 	
 	
 	
 	  
    // new Client("phoin"+orkut.currentuser+'*'+jTextField1.getText());
 	
   
       File 	 f=new File("c:/orkut_java/photos/"+orkut.currentuser+".jpg");
 	           f.delete(); 
 	
 	
    	new Client ("photo"+orkut.currentuser);
    
 	
 		try{
 			
 		
 			InputStream  f0 = new FileInputStream(jTextField1.getText());
 		
 		  int nobytes2=f0.available();
 		  
 		  f0.close();
 		  
 		  
 		  //System.out.println("nobytes2 = "+nobytes2);
 		
 		
 		
 	 f0 = new FileInputStream("c:/orkut_java/photos/"+orkut.currentuser+".jpg");
 		
 		  int nobytes1=f0.available();
 		  
 		  f0.close();
 		  
 		  
 		  //System.out.println("nobytes1 = "+nobytes1);
 		  
 		 
 		  
 		 // if(nobytes2!=nobytes1) throw new Exception("upload error");
 		  //else
 		  
 		  {
 		  
 		     
 	         ImageIcon   cruser=new ImageIcon("c:/orkut_java/photos/"+orkut.currentuser+".jpg");
 	    	jLabel1.setIcon(cruser);
 	    	new imageupload1();
 	       this.setVisible(false);
 	      
 	       }
 	
 	
          }
          catch (Exception ex)
          { 
            //System.out.println(" in image upload"+ex);
             
            new serverdown();
            
            this.setVisible(false);
           
          
          }	
 	
 
 	//new viewprofile(orkut.currentuser);
 	
 
 	
 
 //jLabel1.setIcon(new ImageIcon("c:/orkut_java/photos/"+orkut.currentuser+".jpg"));
 	
 	 	
 		
 		// TODO: Add any handling code here 
  
 	} 
  
 	private void jButton3_actionPerformed(ActionEvent e) 
 	{ 
 		//System.out.println("\njButton3_actionPerformed(ActionEvent e) called."); 
 		
 		new editprofile(orkut.currentuser);
 		
 		this.setVisible(false);
 		
 		
 		// TODO: Add any handling code here 
  
 	} 
  
 	private void jButton4_actionPerformed(ActionEvent e) 
 	{ 
 		//System.out.println("\njButton4_actionPerformed(ActionEvent e) called."); 
 	
 		
 		new imageupload();
 			this.setVisible(false);
 		
 		
 		// TODO: Add any handling code here 
  
 	} 
  
  /*
  	private void jButton5_actionPerformed(ActionEvent e) 
 	{ 
 		//System.out.println("\njButton5_actionPerformed(ActionEvent e) called."); 
 	     this.setVisible(false);
 	
 		// TODO: Add any handling code here 
  
 	} 
 	
 	*/
 	// 
 	// TODO: Add any method code to meet your needs in the following area 
 	// 
  
  
  
  
 } 
  
 