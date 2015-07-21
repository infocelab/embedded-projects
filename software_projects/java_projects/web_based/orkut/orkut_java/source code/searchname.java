/****************************************************************/
/*                      searchname	                            */
/*                                                              */
/****************************************************************/
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 * Summary description for searchname
 *
 */
public class searchname extends JFrame
{
	// Variables declaration
     private  JLabel  jLabel2  ;
 	 private  JLabel	jLabel3 ; 
 	 private JTextField	jTextField1;  
 	 private JTextPane	jTextPane1 ; 
 	 private JTextPane	jTextPane2 ; 
 	 private JButton	jButton1 ; 
 	 private JButton	jButton2 ; 
 	 private JButton	jButton3 ; 
 	 private JPanel	contentPane ; 
	// End of variables declaration


	public searchname()
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
		jLabel2 = new JLabel(); 
 	  	jLabel3 = new JLabel(); 
 	  	jTextField1 = new JTextField(); 
 	 	jTextPane1 = new JTextPane(); 
 	   	jTextPane2 = new JTextPane(); 
 	    jButton1 = new JButton();
 		jButton2 = new JButton(); 
 	 	jButton3 = new JButton(); 
 	 	contentPane = (JPanel)this.getContentPane();

		//
		// jLabel2
		//
	    jLabel2.setForeground(new Color(255, 0, 0));
		jLabel2.setText("NO PHOTO");
		jLabel2.setVisible(false);
		
		
		//
		// jLabel3
		//
		jLabel3.setText("Search");
		//
		// jTextField1
		//
		jTextField1.setBackground(new Color(255, 255, 255));
		jTextField1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				jTextField1_actionPerformed(e);
			}

		});
		
			// 
 		// jTextPane1 
 		// 
 		jTextPane1.setBackground(new Color(105, 120, 224)); 
 		jTextPane1.setForeground(new Color(255, 0, 0)); 
 		jTextPane1.setText("                                 NO RESULT"); 
 		jTextPane1.setEditable(false); 
 		jTextPane1.setVisible(false);
		
			// 
 		// jTextPane2 
 		// 
 		jTextPane2.setBackground(new Color(239,122,247)); 
 		 
 		jTextPane2.setText(""); 
 		jTextPane2.setEditable(false); 
 		jTextPane2.setVisible(false);
	
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
		
		jButton2.setBackground(new Color(140, 152, 236));
	//	jButton2.setText("harshad");
		jButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				jButton2_actionPerformed(e);
			}

		});
		jButton2.setVisible(false);
		//
		// jButton3
		//
		jButton3.setText("Search");
		jButton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				jButton3_actionPerformed(e);
			}

		});
	
		//
		// contentPane
		//
		contentPane.setLayout(null);
		contentPane.setBackground(new Color(140, 152, 236));
		addComponent(contentPane, jLabel2, 122,195,100,100);
		addComponent(contentPane, jLabel3, 334,83,56,21);
		addComponent(contentPane, jTextField1, 391,81,256,25);
		addComponent(contentPane, jTextPane2, 246,195,432,100);
		addComponent(contentPane, jButton2, 94,305,148,30);
		addComponent(contentPane, jTextPane1, 380,152,294,33); 
		addComponent(contentPane, jButton3, 652,77,83,37);
		addComponent(contentPane, jButton1, 152,30,83,37);
		
		//
		// searchname
		//
		this.setTitle("searchname - extends JFrame");
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
	private void jTextField1_actionPerformed(ActionEvent e)
	{
		//System.out.println("\njTextField1_actionPerformed(ActionEvent e) called.");
		// TODO: Add any handling code here

	}
    
    
    //home
    	private void jButton1_actionPerformed(ActionEvent e)
	{
		new viewprofile(orkut.currentuser);
			this.setVisible(false);

	}
    
    
    
    
     //username button
	private void jButton2_actionPerformed(ActionEvent e)
	{
		//System.out.println("\njButton2_actionPerformed(ActionEvent e) called.");
		if(!(jButton2.getText()).equals(orkut.currentuser))
	    new view_others(jButton2.getText());
	    else
	    new viewprofile(jButton2.getText());
		//new Client("profi"+jButton2.getText());
	   	this.setVisible(false);
	
		// TODO: Add any handling code here

	}

    //search
	private void jButton3_actionPerformed(ActionEvent e)
	{
		//System.out.println("\njButton3_actionPerformed(ActionEvent e) called.");
		String query="select username from logins where username = '"+jTextField1.getText()+"'" ;
		Client c=new Client(query);
		if(c.strrecv==null ) {
		                        jLabel2.setVisible(false);
		                        jTextPane2.setVisible(false);
		                        jButton2.setVisible(false);
		                      jTextPane1.setVisible(true) ;
		                      
		                      }
		 
		 
		 else
		      { 
		        jLabel2.setIcon(new ImageIcon("c:/orkut_java/photos/"+jTextField1.getText()+".jpg"));
		        String sx = c.Client("select sex from logins where username ='"+jTextField1.getText()+"'",0);
		        String bir=c. Client("select dob from logins where username ='"+jTextField1.getText()+"'",0);
		        String fname = c.Client("select first from logins where username ='"+jTextField1.getText()+"'",0);
		        String lname=c. Client("select last from logins where username ='"+jTextField1.getText()+"'",0);
		        String addr=c. Client("select country from logins where username ='"+jTextField1.getText()+"'",0);
		        
		        calcage age1 = new calcage ();
		        int age=age1.calc(bir);
		        
		        jTextPane2.setText("\n		"+fname+"  "+lname+"\n		"+addr+"\n		"+sx+" ,"+age);
		        jButton2.setText(jTextField1.getText());
		        jTextPane1.setVisible(false) ;
		        jLabel2.setVisible(true);
		        jTextPane2.setVisible(true);
		        jButton2.setVisible(true);
               		       
		       }
		   
		// TODO: Add any handling code here

        
   
	}

	//
	// TODO: Add any method code to meet your needs in the following area
	//

}
