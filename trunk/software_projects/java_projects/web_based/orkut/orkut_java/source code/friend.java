
 /****************************************************************/ 
 /*                      friend	                            */ 
 /*                                                              */ 
 /****************************************************************/ 
 import java.awt.*; 
 import java.awt.event.*; 
 import javax.swing.*; 
 /** 
  * Summary description for friend 
  * 
  */ 
 public class friend extends JFrame 
 { 
 	// Variables declaration 
 	private JLabel jLabel1; 
 	private JLabel jLabel2;
 	private JLabel jLabel3;
 	private JLabel jLabel4;
 	private JLabel jLabel5;
 	private JLabel jLabel6;
 			
 	private JTextArea jTextArea1; 
 	private JScrollPane jScrollPane1; 
 	private JTextArea jTextArea2; 
 	private JScrollPane jScrollPane2; 
 	private JTextArea jTextArea3; 
 	private JScrollPane jScrollPane3; 
 	private JTextArea jTextArea4; 
 	private JScrollPane jScrollPane4; 
 	private JTextArea jTextArea5; 
 	private JScrollPane jScrollPane5; 
 	private JTextArea jTextArea6; 
 	private JScrollPane jScrollPane6; 
   
 	
 	private JButton jButton1; 
 	private JButton jButton2; 
 	private JButton jButton3; 
 	private JButton jButton4; 
 	private JButton jButton5; 
 	private JButton jButton6; 
 	private JButton jButton7; 
 	private JButton jButton8; 
 	private JButton jButton9; 
 	private JPanel contentPane; 
 	int frno;
 	int frmax;
    friend[] fri;
   
    String arr[];
 	// End of variables declaration 
  
    public friend()
          {
          }
 	public friend(String a[],String user,friend f[],int max,int frameno) 
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
 		
 		frno=frameno;
 		frmax=max;
 		fri=f;
 		arr=a;
 		initializeComponent(); 
 		// 
 		// TODO: Add any constructor code after initializeComponent call 
 		// 
 		//System.out.println("********"+frameno);
        if(frameno==0)
 		this.setVisible(true); 
 		else
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
 		jLabel6 = new JLabel(); 
 		
 		jButton1 = new JButton(); 
 		jButton2 = new JButton(); 
 		jButton3 = new JButton(); 
 		jButton4 = new JButton(); 
 		jButton5 = new JButton(); 
 		jButton6 = new JButton(); 
 		jButton7 = new JButton(); 
 		jButton8 = new JButton(); 
 		jButton9 = new JButton(); 
 		
 		jTextArea1 = new JTextArea(); 
 		jScrollPane1 = new JScrollPane(); 
 		jTextArea2 = new JTextArea(); 
 		jScrollPane2 = new JScrollPane(); 
 		jTextArea3 = new JTextArea(); 
 		jScrollPane3 = new JScrollPane();
 		jTextArea4 = new JTextArea(); 
 		jScrollPane4 = new JScrollPane();
 		jTextArea5 = new JTextArea(); 
 		jScrollPane5 = new JScrollPane(); 
 		jTextArea6 = new JTextArea(); 
 		jScrollPane6 = new JScrollPane(); 
 		
 		jScrollPane1.setViewportView(jTextArea1);
 		jScrollPane2.setViewportView(jTextArea2); 
 		jScrollPane3.setViewportView(jTextArea3); 
 		jScrollPane4.setViewportView(jTextArea4); 
 		jScrollPane5.setViewportView(jTextArea5); 
 		jScrollPane6.setViewportView(jTextArea6);  
 		
 		
 		contentPane = (JPanel)this.getContentPane(); 
  
 		// 
 		// jLabel1 
 		// 
 		
 		jLabel1.setText("NO PHOTO");
 		jLabel2.setText("NO PHOTO");
 		jLabel3.setText("NO PHOTO");	 
 		jLabel4.setText("NO PHOTO");
 		jLabel5.setText("NO PHOTO");
 		jLabel6.setText("NO PHOTO");
 		
 		// 
 	jTextArea1.setEditable(false); 
    jTextArea2.setEditable(false); 
    jTextArea3.setEditable(false); 
    jTextArea4.setEditable(false); 
    jTextArea5.setEditable(false);
    jTextArea6.setEditable(false); 
    jTextArea1.setBackground(new Color(239,122,247)); 
    jTextArea2.setBackground(new Color(239,122,247)); 
    jTextArea3.setBackground(new Color(239,122,247)); 
    jTextArea4.setBackground(new Color(239,122,247)); 
    jTextArea5.setBackground(new Color(239,122,247)); 
    jTextArea6.setBackground(new Color(239,122,247)); 
 		
 	
 		// 
 		// jButton1 
 		// 
 		
 		Client c= new Client();
 		String[] drr=new String[5];
 		calcage age1 = new calcage ();
		
 		
 		
 	  drr[0]=c.Client("select first from logins where username='"+arr[0]+"'",0);
 	  drr[1]=c.Client("select last from logins where username='"+arr[0]+"'",0);
 	  drr[2]=c.Client("select dob from logins where username='"+arr[0]+"'",0);
 	  drr[3]=c.Client("select sex from logins where username='"+arr[0]+"'",0);
 	  drr[4]=c.Client("select country from logins where username='"+arr[0]+"'",0);
 	  int age=age1.calc(drr[2]);
 	  jTextArea1.setText("\n"+drr[0]+" "+drr[1]+"\n"+drr[4]+"\n"+drr[3]+","+age);
 		jLabel1.setIcon(new ImageIcon("c:/orkut_java/photos/"+arr[0]+".jpg")); 
 		jButton1.setText(arr[0]+"("+countfr(arr[0])+")" ); 
 		
 		
 		
 		jButton1.addActionListener(new ActionListener() { 
 			public void actionPerformed(ActionEvent e) 
 			{ 
 				jButton1_actionPerformed(e); 
 			} 
  
 		}); 
 		// 
 		// jButton2 
 		// 
 		
 	
 		
 		
 		
 				
 		
 		if(arr[1]==null)
 		{
 			jButton2.setVisible(false);
 			jLabel2.setVisible(false);
 			jTextArea2.setVisible(false);
 			
 		}
 		else
 		{jButton2.setText(arr[1]+"("+countfr(arr[1])+")"); 
 		  new Client("photo"+arr[1]);
 		  jLabel2.setIcon(new ImageIcon("c:/orkut_java/photos/"+arr[1]+".jpg")); 
 	  drr[0]=c.Client("select first from logins where username='"+arr[1]+"'",0);
 	  drr[1]=c.Client("select last from logins where username='"+arr[1]+"'",0);
 	  drr[2]=c.Client("select dob from logins where username='"+arr[1]+"'",0);
 	  drr[3]=c.Client("select sex from logins where username='"+arr[1]+"'",0);
 	  drr[4]=c.Client("select country from logins where username='"+arr[1]+"'",0);
 	   age=age1.calc(drr[2]);
 	 jTextArea2.setText("\n"+drr[0]+" "+drr[1]+"\n"+drr[4]+"\n"+drr[3]+","+age);
 			
 		}
 		jButton2.addActionListener(new ActionListener() { 
 			public void actionPerformed(ActionEvent e) 
 			{ 
 				jButton2_actionPerformed(e); 
 			} 
  
 		}); 
 		// 
 		// jButton3 
 		// 
 		if(arr[2]==null)
 		{
 			jButton3.setVisible(false);
 			jLabel3.setVisible(false);
 			jTextArea3.setVisible(false);
 		}
 		else
 		{jButton3.setText(arr[2]+"("+countfr(arr[2])+")"); 
 		jLabel3.setIcon(new ImageIcon("c:/orkut_java/photos/"+arr[2]+".jpg")); 
 		 
 	  drr[0]=c.Client("select first from logins where username='"+arr[2]+"'",0);
 	  drr[1]=c.Client("select last from logins where username='"+arr[2]+"'",0);
 	  drr[2]=c.Client("select dob from logins where username='"+arr[2]+"'",0);
 	  drr[3]=c.Client("select sex from logins where username='"+arr[2]+"'",0);
 	  drr[4]=c.Client("select country from logins where username='"+arr[2]+"'",0);
 	   age=age1.calc(drr[2]);
 	 jTextArea3.setText("\n"+drr[0]+" "+drr[1]+"\n"+drr[4]+"\n"+drr[3]+","+age);
 		}
 		jButton3.addActionListener(new ActionListener() { 
 			public void actionPerformed(ActionEvent e) 
 			{ 
 				jButton3_actionPerformed(e); 
 			} 
  
 		}); 
 		// 
 		// jButton4 
 		// 
 			 // //System.out.println("push dob======"+drr[2]);
 		if(arr[3]==null)
 	    {
 			jButton4.setVisible(false);
 			jLabel4.setVisible(false);
 			jTextArea4.setVisible(false);
 		}
 		else
 		{jButton4.setText(arr[3]+"("+countfr(arr[3])+")"); 
 		jLabel4.setIcon(new ImageIcon("c:/orkut_java/photos/"+arr[3]+".jpg")); 
 		drr[0]=c.Client("select first from logins where username='"+arr[3]+"'",0);
 	  drr[1]=c.Client("select last from logins where username='"+arr[3]+"'",0);
 	  drr[2]=c.Client("select dob from logins where username='"+arr[3]+"'",0);
 	 // //System.out.println("push dob======"+drr[2]);
 	  drr[3]=c.Client("select sex from logins where username='"+arr[3]+"'",0);
 	  drr[4]=c.Client("select country from logins where username='"+arr[3]+"'",0);
 	   age=age1.calc(drr[2]);
 	 jTextArea4.setText("\n"+drr[0]+" "+drr[1]+"\n"+drr[4]+"\n"+drr[3]+","+age);
 		
 		}
 		jButton4.addActionListener(new ActionListener() { 
 			public void actionPerformed(ActionEvent e) 
 			{ 
 				jButton4_actionPerformed(e); 
 			} 
  
 		}); 
 		// 
 		// jButton5 
 		//
 		 if(arr[4]==null)
 		{
 			jButton5.setVisible(false);
 			jLabel5.setVisible(false);
 			jTextArea5.setVisible(false);	
 		}
 		else
 		{jButton5.setText(arr[4]+"("+countfr(arr[4])+")"); 
 		jLabel5.setIcon(new ImageIcon("c:/orkut_java/photos/"+arr[4]+".jpg"));
 		 
 		
 	  drr[0]=c.Client("select first from logins where username='"+arr[4]+"'",0);
 	  drr[1]=c.Client("select last from logins where username='"+arr[4]+"'",0);
 	  drr[2]=c.Client("select dob from logins where username='"+arr[4]+"'",0);
 	  
 	  drr[3]=c.Client("select sex from logins where username='"+arr[4]+"'",0);
 	  drr[4]=c.Client("select country from logins where username='"+arr[4]+"'",0);
 	   age=age1.calc(drr[2]);
 	  jTextArea5.setText("\n"+drr[0]+" "+drr[1]+"\n"+drr[4]+"\n"+drr[3]+","+age);
 		}
 		jButton5.addActionListener(new ActionListener() { 
 			public void actionPerformed(ActionEvent e) 
 			{ 
 				jButton5_actionPerformed(e); 
 			} 
  
 		}); 
 		// 
 		// jButton6 
 		// 
 		if(arr[5]==null)
 			{
 			jButton6.setVisible(false);
 			jLabel6.setVisible(false);
 			jTextArea6.setVisible(false);
 		}
 		else
 		{jButton6.setText(arr[5]+"("+countfr(arr[5])+")"); 
 		jLabel6.setIcon(new ImageIcon("c:/orkut_java/photos/"+arr[5]+".jpg")); 
 		
 	  drr[0]=c.Client("select first from logins where username='"+arr[5]+"'",0);
 	  drr[1]=c.Client("select last from logins where username='"+arr[5]+"'",0);
 	  drr[2]=c.Client("select dob from logins where username='"+arr[5]+"'",0);
 	  drr[3]=c.Client("select sex from logins where username='"+arr[5]+"'",0);
 	  drr[4]=c.Client("select country from logins where username='"+arr[5]+"'",0);
 	   age=age1.calc(drr[2]);
 	  jTextArea6.setText("\n"+drr[0]+" "+drr[1]+"\n"+drr[4]+"\n"+drr[3]+","+age);
 		}
 		jButton6.addActionListener(new ActionListener() { 
 			public void actionPerformed(ActionEvent e) 
 			{ 
 				jButton6_actionPerformed(e); 
 			} 
  
 		}); 
 		// 
 		// jButton7 
 		// 
 		jButton7.setText("Next"); 
 		jButton7.addActionListener(new ActionListener() { 
 			public void actionPerformed(ActionEvent e) 
 			{ 
 				jButton7_actionPerformed(e); 
 			} 
  
 		}); 
 		// 
 		// jButton8 
 		// 
 		jButton8.setText("Back"); 
 		jButton8.addActionListener(new ActionListener() { 
 			public void actionPerformed(ActionEvent e) 
 			{ 
 				jButton8_actionPerformed(e); 
 			} 
  
 		}); 
 		// 
 		// jButton9 
 		// 
 		jButton9.setText("Home"); 
 		jButton9.addActionListener(new ActionListener() { 
 			public void actionPerformed(ActionEvent e) 
 			{ 
 				jButton9_actionPerformed(e); 
 			} 
  
 		}); 
 		// 
 		// contentPane 
 		// 
 		contentPane.setLayout(null); 
 		contentPane.setBackground(new Color(158, 168, 237)); 
 		addComponent(contentPane, jLabel1, 150,20,100,100); 
 		addComponent(contentPane, jLabel2, 150,200,100,100); 
 		addComponent(contentPane, jLabel3, 150,380,100,100); 
 		addComponent(contentPane, jLabel4, 470,20,100,100); 
 		addComponent(contentPane, jLabel5, 470,200,100,100); 
 		addComponent(contentPane, jLabel6, 470,380,100,100); 
 	
 		//addComponent(contentPane, jTextField1, 112,16,180,90); 
 		addComponent(contentPane, jTextArea1, 270,20,180,100); 
 		addComponent(contentPane, jTextArea2, 270,200,180,100); 
 		addComponent(contentPane, jTextArea3, 270,380,180,100); 
 		addComponent(contentPane, jTextArea4, 590,20,180,100); 
 		addComponent(contentPane, jTextArea5, 590,200,180,100); 
 		addComponent(contentPane, jTextArea6, 590,380,180,100); 
 	
 		addComponent(contentPane, jButton1, 150,130,100,20); 
 		addComponent(contentPane, jButton2, 150,310,100,20); 
 		addComponent(contentPane, jButton3, 150,490,100,20); 
 		addComponent(contentPane, jButton4, 470,130,100,20); 
 		addComponent(contentPane, jButton5, 470,310,100,20); 
 		addComponent(contentPane, jButton6, 470,490,100,20); 
 		addComponent(contentPane, jButton7, 300,580,83,21); 
 		addComponent(contentPane, jButton8, 400,580,83,22); 
 		addComponent(contentPane, jButton9, 500,580,86,21); 
 		// 
 		// friend 
 		// 
 		this.setTitle("friend - extends JFrame"); 
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
 		
 		if(!(orkut.currentuser).equals(arr[0]))
 		new view_others(arr[0]);
 		
 		else new viewprofile(orkut.currentuser);
 		
 			this.setVisible(false);
  
 	} 
  
 	private void jButton2_actionPerformed(ActionEvent e) 
 	{ 
 		//System.out.println("\njButton2_actionPerformed(ActionEvent e) called."); 
 		// TODO: Add any handling code here 
       	if(!(orkut.currentuser).equals(arr[1]))
 		new view_others(arr[1]);
 		
 		else new viewprofile(orkut.currentuser);
 		
 			this.setVisible(false);
 	} 
  
 	private void jButton3_actionPerformed(ActionEvent e) 
 	{ 
 		//System.out.println("\njButton3_actionPerformed(ActionEvent e) called."); 
 		// TODO: Add any handling code here 
      	if(!(orkut.currentuser).equals(arr[2]))
 		new view_others(arr[2]);
 		
 		else new viewprofile(orkut.currentuser);
 		
 			this.setVisible(false);
 	} 
  
 	private void jButton4_actionPerformed(ActionEvent e) 
 	{ 
 		//System.out.println("\njButton4_actionPerformed(ActionEvent e) called."); 
 		// TODO: Add any handling code here 
 	if(!(orkut.currentuser).equals(arr[3]))
 		new view_others(arr[3]);
 		
 		else new viewprofile(orkut.currentuser);
 		
 			this.setVisible(false);
  
 	} 
  
 	private void jButton5_actionPerformed(ActionEvent e) 
 	{ 
 		//System.out.println("\njButton5_actionPerformed(ActionEvent e) called."); 
 		// TODO: Add any handling code here 
      	if(!(orkut.currentuser).equals(arr[4]))
 		new view_others(arr[4]);
 		
 		else new viewprofile(orkut.currentuser);
 		
 			this.setVisible(false);
 	} 
  
 	private void jButton6_actionPerformed(ActionEvent e) 
 	{ 
 		//System.out.println("\njButton6_actionPerformed(ActionEvent e) called."); 
 		// TODO: Add any handling code here 
 			if(!(orkut.currentuser).equals(arr[5]))
 		new view_others(arr[5]);
 		
 		else new viewprofile(orkut.currentuser);
 			this.setVisible(false);
  
 	} 
  
 	private void jButton7_actionPerformed(ActionEvent e) 
 	{ 
 		//System.out.println("\njButton7_actionPerformed(ActionEvent e) called."); 
 		// TODO: Add any handling code here 
 		//System.out.println(frno);
 		if(frno<frmax)
 		{   fri[frno].setVisible(false);
 			fri[frno+1].setVisible(true);
 		
 		}
 		
 		
  
 	} 
  
 	private void jButton8_actionPerformed(ActionEvent e) 
 	{ 
 		//System.out.println("\njButton8_actionPerformed(ActionEvent e) called."); 
 		// TODO: Add any handling code here 
 		//System.out.println(frno);
 		if(frno>0)
         {  fri[frno].setVisible(false);
         	fri[frno-1].setVisible(true);
         
         }
 	} 
  
 	private void jButton9_actionPerformed(ActionEvent e) 
 	{ 
 		//System.out.println("\njButton9_actionPerformed(ActionEvent e) called."); 
 		// TODO: Add any handling code here 
 		 
        new viewprofile(orkut.currentuser);
        fri[frno].setVisible(false);
        
        
 	} 
  
  
  
   int countfr(String user)
 	       {
 	       	 Client d=new Client("frien"+user);
 		   int start1=0;
 		   int friends1=0;
 		   if(d.strrecv!=null)
 		   {
 		   
 		   int	last1=d.strrecv.length();
 		   int temp2;
 		   
 		   while(start1<last1)
                        { if((temp2=d.strrecv.indexOf("$",start1))!=-1)
                          {
                          	friends1++;
                          	start1=temp2+1;
                          }
                          start1++;
                          
                        }
             }           
 		
 		return friends1;
 		
 		    }
 	// 
 	// TODO: Add any method code to meet your needs in the following area 
 	// 
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
   
  
 //============================= Testing ================================// 
 //=                                                                    =// 
 //= The following main method is just for testing this class you built.=// 
 //= After testing,you may simply delete it.                            =// 
 //======================================================================// 
 /*	public static void main(String[] args) 
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
 	
 	} */
 //= End of Testing = 
  
  
 } 
  
 