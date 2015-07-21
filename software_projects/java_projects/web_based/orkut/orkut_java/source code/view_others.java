
 /****************************************************************/ 
 /*                      view_others	                            */ 
 /*                                                              */ 
 /****************************************************************/ 
 import java.awt.*; 
 import java.awt.event.*; 
 import javax.swing.*; 
 import java.io.*;
 /** 
  * Summary description for view_others 
  * 
  */ 
 public class view_others extends JFrame 
 { 
 	// Variables declaration 
 	private JButton jButton1;
 	private JButton jButton2;
 	private JButton jButton3;
 	private JButton jButton4;//f1
 	private JButton jButton5;//f2
 	private JButton jButton6;//f4
 	private JButton jButton7;//f5
 	private JButton jButton8;//home
 	private JButton jButton9;//search
 	private JButton jButton10;// scrapbook
 	private JButton jButton11;//f3
	private JButton jButton12;//f6
	private JButton jButton13; //friend upper
 	
 	
 	private JLabel photo; 
 	private JLabel jLabel2; 
 	private JLabel jLabel16;
 	private JLabel jLabel17; 
 	private JLabel jLabel3;
 	private JLabel jLabel4;
 	private JLabel jLabel5;
 	
 	private JTextField jTextField9;
 	private JTextField jTextField10;
 	private JTextField jTextField11;
 	private JTextField jTextField12;
 	private JTextField jTextField13;
 	private JTextField jTextField14;
 	private JTextField jTextField15;
 	private JTextField jTextField16;
 	
 	
    public JEditorPane abtme; 
 	public JScrollPane abtme1; 
 //	private JTextArea jTextArea1; 
 	private JTextField jTextField2; 
 	private JTextField jTextField3; 
 	private JTextField jTextField4; 
 	private JTextField jTextField5; 
 	private JTextField jTextField6; 
 	private JTextField jTextField7; 
 	private JTextField jTextField8; 
 	private JPanel contentPane; 
 	String userdata;
 	
 	private viewprofile1 next=new viewprofile1(this) ; 
 	// End of variables declaration 
  
  
 	public view_others(String s) 
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
 		userdata=s;
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
 	    jButton1=new JButton("Add as Friend"); 	
 	   
 	     Client c3=new Client("addas"+userdata);
 	     //System.out.println(c3.strrecv+"*****in view others");
 	     
 	     
 	     
 	    if(c3.strrecv==null)
 	      jButton1.setVisible(true);
 	    else 
 	    if(c3.strrecv.indexOf(orkut.currentuser)!=-1) 
 	      {jButton1.setVisible(false);
 	       //System.out.println("******** in addas made false " );
 	      }	   
 	      
 	     
 	     else
 	     jButton1.setVisible(true); 
 	      int abc=countfr(userdata);
 	  
 		jButton2=new JButton("View Friends("+abc+")");
 	   if(abc==0)
 	   jButton2.setVisible(false);
 	   jButton3=new JButton("Next");
 	    
 	    //friends order is  4,5,11,6,7,12
 	    jButton4=new JButton("f1");
 	    jButton5=new JButton("f2");
 	    jButton6=new JButton("f4");
 	    jButton7=new JButton("f5");
 	    jButton11=new JButton("f3");
 	    jButton12=new JButton("f6");
 	    jButton13=new JButton("Friend");
 	    //upper
 	    jButton8=new JButton("Home");
 	    jButton9=new JButton("Search");
 	    
 	    Client c111=new Client("noscr"+userdata);
 	     
 	    jButton10=new JButton("Scrapbook ("+c111.strrecv+")");
 		
 		
 		photo = new JLabel();
 		jLabel2 = new JLabel(); 
 		jLabel3 = new JLabel(); 
 		jLabel4 = new JLabel(); 
 		jLabel5 = new JLabel();  
 		jLabel16 = new JLabel();
 		jLabel17 = new JLabel();
 		photo.setIcon(new ImageIcon("c:/orkut_java/photos/"+userdata+".jpg")); 		
 		
 		//photo label order is 2,3,16,4,5,17
 		//friends order is     4,5,11,6,7,12
 	/*	jLabel2.setIcon(new ImageIcon("c:/orkut_java/photos/mahendra.jpg"));
 		jLabel3.setIcon(new ImageIcon("c:/orkut_java/photos/mahendra.jpg"));
 		jLabel4.setIcon(new ImageIcon("c:/orkut_java/photos/mahendra.jpg"));
 		jLabel5.setIcon(new ImageIcon("c:/orkut_java/photos/mahendra.jpg"));
 	    jLabel16.setIcon(new ImageIcon("c:/orkut_java/photos/mahendra.jpg"));
 	    jLabel17.setIcon(new ImageIcon("c:/orkut_java/photos/mahendra.jpg"));*/
 		
 		
 		abtme      =  new JEditorPane();
 		abtme1     =  new JScrollPane();
 	
 	//	jTextArea1 = new JTextArea(); 
 		jTextField2 = new JTextField(); 
 		jTextField3 = new JTextField(); 
 		jTextField4 = new JTextField(); 
 		jTextField5 = new JTextField(); 
 		jTextField6 = new JTextField(); 
 		jTextField7 = new JTextField(); 		
 		jTextField8 = new JTextField(); 
 		jTextField9 = new JTextField(); 
 		jTextField10 = new JTextField(); 
 		jTextField11 = new JTextField(); 
 		jTextField12 = new JTextField(); 
 		jTextField13 = new JTextField(); 
 		jTextField14 = new JTextField(); 
 		jTextField15 = new JTextField(); 
 		jTextField16 = new JTextField(); 
 		
 		abtme1.setViewportView(abtme);
 	
 	    Client c=new Client();
 		
 		String temp;
 		
 		for(int i=0;i<20;i++)
 		    { 
 		      switch(i)
 		            {    
 		             case 0:temp=c.Client("select abtme from logins where username='"+userdata+"';",0);
 		                    //System.out.println(temp);
 		                    abtme.setText(temp);            
 		                    break; 		                   
 		             
 		             case 1:jTextField2.setText(c.Client("select sex from logins where username='"+userdata+"';",0));               
 		                    break; 		                
 		             case 2:jTextField3.setText(c.Client("select country from logins where username='"+userdata+"';",0));               
 		                    break; 		                
 		             case 4:jTextField4.setText(c.Client("select interest from logins where username='"+userdata+"';",0));               
 		                    break; 		                
 		             case 5:jTextField5.setText(c.Client("select lang from logins where username='"+userdata+"';",0));               
 		                    break; 		                
 		             case 6:jTextField6.setText(c.Client("select dob from logins where username='"+userdata+"';",0));               
 		                    break; 		                
 		             case 7:jTextField7.setText(c.Client("select relig from logins where username='"+userdata+"';",0));               
 		                    break; 		                
 		             case 8:
 		                     
 		                     jTextField8.setText(c.Client("select humour from logins where username='"+userdata+"';",0));               
 		                    break; 		                
 		            // case 9:
 		            //case 10
 		             case 9:break;
 		            
 		            
 		             case 10:next.passion.setText(c.Client("select passion from logins where username='"+userdata+"';",0));break;
 		             case 11:next.books.setText(c.Client("select book from logins where username='"+userdata+"';",0));break;
 		             case 12:next.movies.setText(c.Client("select movie from logins where username='"+userdata+"';",0));break;
 		             case 13:next.jTextField4.setText(c.Client("select living from logins where username='"+userdata+"';",0));break;
 		             case 14:next.jTextField5.setText(c.Client("select fashion from logins where username='"+userdata+"';",0));break;
 		             case 15:next.jTextField6.setText(c.Client("select pets from logins where username='"+userdata+"';",0));break;
 		             case 16:next.jTextField7.setText(c.Client("select drink from logins where username='"+userdata+"';",0));break;
 		             case 17:next.jTextField8.setText(c.Client("select smok from logins where username='"+userdata+"';",0));break;
 		             
 		            
 		            }
 		          
 		   	}
 		
 		
 		Client c1=new Client("seefr"+userdata);
 		 String arr[]=new String[6];
 		 int cc1;
 		 int x;
 		 int y;
 		 int count=0;
 		 int start=0;
 		 int last;
 		 if(c1.strrecv!=null)
 		{last =c1.strrecv.length();
 		 temp=null;
 		  while(start<last)
                             {  
                               
                                
                             	if((x=c1.strrecv.indexOf("$",start))!=-1)
                             	   { temp=c1.strrecv.substring(start,x);
                             	     start=x+1;
                             	     
                             	     if((y=temp.lastIndexOf("#"))!=-1)
                             	     temp=temp.substring(y+1,temp.length());
                             	     if((y=temp.lastIndexOf("*"))!=-1)
                             	     temp=temp.substring(y+1,temp.length());
                             	     if(count<6)  
                             	    arr[count++]  =temp;
                             	    //System.out.println("for seefr*****  ="+temp);
                             	 
                             	      
                             	   }
                                else start++;
                             	 
                             	 
                             	
                               }
                             
                             
                             if(count!=6)
                             for(int i=count;i<6;i++)
                             arr[i]=null; 	
                             
                             	 
 		 for(int i=0;i<6;i++)
 		 {  //System.out.println("*****downloading   ="+arr[i]);
 		    if(arr[i]!=null)
 		 	new Client("photo"+arr[i]);
 		 	
 		 }
 		 
 		 }
 		
 		//photo label order is 2,3,16,4,5,17
 		//friends order is     4,5,11,6,7,12
 		
 		if(arr[0]!=null)
 		{
 		 jLabel2.setIcon(new ImageIcon("c:/orkut_java/photos/"+arr[0]+".jpg"));
 		 jButton4.setText(arr[0]+"("+countfr(arr[0])+")");
 		}
 		else
 		jButton4.setVisible(false);
 		
 		
 		if(arr[1]!=null)
 		{jLabel3.setIcon(new ImageIcon("c:/orkut_java/photos/"+arr[1]+".jpg"));
 		 jButton5.setText(arr[1]+"("+countfr(arr[1])+")");
 		}
 		else
 		jButton5.setVisible(false);
 		
 	
 	
 		if(arr[2]!=null)
 		{jLabel16.setIcon(new ImageIcon("c:/orkut_java/photos/"+arr[2]+".jpg"));
 		 jButton11.setText(arr[2]+"("+countfr(arr[2])+")");
 		}
 		else
 		jButton11.setVisible(false);
 		
 		
 		
 		if(arr[3]!=null)
 		{jLabel4.setIcon(new ImageIcon("c:/orkut_java/photos/"+arr[3]+".jpg"));
 		 jButton6.setText(arr[3]+"("+countfr(arr[3])+")");
 		}
 		else
 		jButton6.setVisible(false);   	
 		   	
 	
 	
 	
 		if(arr[4]!=null)
 		{jLabel5.setIcon(new ImageIcon("c:/orkut_java/photos/"+arr[4]+".jpg"));
 		 jButton7.setText(arr[4]+"("+countfr(arr[4])+")");
 		}
 		else
 		jButton7.setVisible(false);   	
 		
 		
 	
 	
 		if(arr[5]!=null)
 	
 		{jLabel17.setIcon(new ImageIcon("c:/orkut_java/photos/"+arr[5]+".jpg"));
 		 jButton12.setText(arr[5]+"("+countfr(arr[5])+")");
 		}
 		else
 		jButton12.setVisible(false);   	
 		
 		
 		
 		contentPane = (JPanel)this.getContentPane(); 
  
 		// 
 		// photo 
 		// 
 		photo.setText("NO PHOTO");
 		
 		// 
 		// jLabel2 
 		// 
 		//jLabel2.setText("friend"); 
 		// 
 		// jTextArea1 
 		// 
 		abtme.setBackground(new Color(239,122,247)); 
 		
 		abtme.setEditable(false); 
 	
 		jTextField9.setBackground(new Color(239,122,247)); 
 		jTextField9.setText("About me"); 
 		jTextField9.setEditable(false); 
 		jTextField9.setHorizontalAlignment(JTextField.RIGHT);
 		
 		
 		/*jTextArea1.addActionListener(new ActionListener() { 
 			public void actionPerformed(ActionEvent e) 
 			{ 
 				jTextArea1_actionPerformed(e); 
 			} 
  
 		}); 
 		*/
 		// 
 		// jTextField2 
 		// 
 		jTextField2.setBackground(new Color(140, 152, 236)); 
 		
 		jTextField2.setEditable(false); 
 	
 		jTextField10.setBackground(new Color(140, 152, 236)); 
 		jTextField10.setText("Sex"); 
 		jTextField10.setEditable(false); 
 		jTextField10.setHorizontalAlignment(JTextField.RIGHT);
 		jTextField2.addActionListener(new ActionListener() { 
 			public void actionPerformed(ActionEvent e) 
 			{ 
 				jTextField2_actionPerformed(e); 
 			} 
  
 		}); 
 		// 
 		// jTextField3 
 		// 
 		jTextField3.setBackground(new Color(239,122,247)); 
 		
 		jTextField3.setEditable(false); 
 		
 		
 		jTextField11.setBackground(new Color(239,122,247)); 
 		jTextField11.setText("country"); 
 		jTextField11.setEditable(false); 
 		jTextField11.setHorizontalAlignment(JTextField.RIGHT);
 		
 		jTextField3.addActionListener(new ActionListener() { 
 			public void actionPerformed(ActionEvent e) 
 			{ 
 				jTextField3_actionPerformed(e); 
 			} 
  
 		}); 
 		// 
 		// jTextField4 
 		// 
 		jTextField4.setBackground(new Color(239,122,247)); 
 		
 		jTextField4.setEditable(false); 
 	
 		jTextField12.setBackground(new Color(239,122,247)); 
 		
 		jTextField12.setText("intrest"); 
 		jTextField12.setEditable(false); 
 		jTextField12.setHorizontalAlignment(JTextField.RIGHT);
 		
 		jTextField4.addActionListener(new ActionListener() { 
 			public void actionPerformed(ActionEvent e) 
 			{ 
 				jTextField4_actionPerformed(e); 
 			} 
  
 		}); 
 		// 
 		// jTextField5 
 		// 
 		jTextField5.setBackground(new Color(140, 152, 236)); 
 		
 		jTextField5.setEditable(false); 
 		
 		
 		jTextField13.setBackground(new Color(140, 152, 236)); 
 		jTextField13.setText("Language I Speak"); 
 		jTextField13.setEditable(false); 
 		jTextField13.setHorizontalAlignment(JTextField.RIGHT);
 		
 		jTextField5.addActionListener(new ActionListener() { 
 			public void actionPerformed(ActionEvent e) 
 			{ 
 				jTextField5_actionPerformed(e); 
 			} 
  
 		}); 
 		// 
 		// jTextField6 
 		// 
 		jTextField6.setBackground(new Color(140, 152, 236)); 
 		
 		jTextField6.setEditable(false); 
 		
 		jTextField14.setBackground(new Color(140, 152, 236)); 
 		jTextField14.setText("Date Of Birth"); 
 		jTextField14.setEditable(false); 
 		jTextField14.setHorizontalAlignment(JTextField.RIGHT);
 		
 		jTextField6.addActionListener(new ActionListener() { 
 			public void actionPerformed(ActionEvent e) 
 			{ 
 				jTextField6_actionPerformed(e); 
 			} 
  
 		}); 
 		// 
 		// jTextField7 
 		// 
 		jTextField7.setBackground(new Color(239,122,247)); 
 		 
 		jTextField7.setEditable(false);	
 	
 		jTextField15.setBackground(new Color(239,122,247)); 
 		jTextField15.setText("Religion"); 
 		jTextField15.setEditable(false); 
 		jTextField15.setHorizontalAlignment(JTextField.RIGHT);
 		
 		jTextField7.addActionListener(new ActionListener() { 
 			public void actionPerformed(ActionEvent e) 
 			{ 
 				jTextField7_actionPerformed(e); 
 			} 
  
 		}); 
 		// 
 		// jTextField8 
 		// 
 		jTextField8.setBackground(new Color(140, 152, 236)); 
 		
 		jTextField8.setEditable(false); 
 		
 		jTextField16.setBackground(new Color(140, 152, 236)); 
 		jTextField16.setText("Humour"); 
 		jTextField16.setEditable(false); 
 		jTextField16.setHorizontalAlignment(JTextField.RIGHT);
 		
 	
 		jTextField8.addActionListener(new ActionListener() { 
 			public void actionPerformed(ActionEvent e) 
 			{ 
 				jTextField8_actionPerformed(e); 
 			} 
  
 		}); 
 		jButton1.addActionListener(new ActionListener() { 
 			public void actionPerformed(ActionEvent e) 
 			{ 
 				jButton1_actionPerformed(e); 
 			} 
  
 		}); 
 		jButton2.addActionListener(new ActionListener() { 
 			public void actionPerformed(ActionEvent e) 
 			{ 
 				jButton2_actionPerformed(e); 
 			} 
  
 		}); 
 		//knet frame
 		
 	
 		jButton3.addActionListener(new ActionListener() { 
 			public void actionPerformed(ActionEvent e) 
 			{ 
 				jButton3_actionPerformed(e); 
 			} 
  
 		}); 
 		
 		
 		
 		
 		//friends here
 		jButton4.addActionListener(new ActionListener() { 
 			public void actionPerformed(ActionEvent e) 
 			{ 
 				jButton4_actionPerformed(e); 
 			} 
  
 		}); 
 		jButton5.addActionListener(new ActionListener() { 
 			public void actionPerformed(ActionEvent e) 
 			{ 
 				jButton5_actionPerformed(e); 
 			} 
  
 		}); 
 		jButton6.addActionListener(new ActionListener() { 
 			public void actionPerformed(ActionEvent e) 
 			{ 
 				jButton6_actionPerformed(e); 
 			} 
  
 		}); 
 		jButton7.addActionListener(new ActionListener() { 
 			public void actionPerformed(ActionEvent e) 
 			{ 
 				jButton7_actionPerformed(e); 
 			} 
  
 		}); 
 			jButton8.addActionListener(new ActionListener() { 
 			public void actionPerformed(ActionEvent e) 
 			{ 
 				jButton8_actionPerformed(e); 
 			} 
  
 		}); 
 			jButton9.addActionListener(new ActionListener() { 
 			public void actionPerformed(ActionEvent e) 
 			{ 
 				jButton9_actionPerformed(e); 
 			} 
  
 		}); 
 			jButton10.addActionListener(new ActionListener() { 
 			public void actionPerformed(ActionEvent e) 
 			{ 
 				jButton10_actionPerformed(e); 
 			} 
  
 		}); 
 		
 		
 			jButton11.addActionListener(new ActionListener() { 
 			public void actionPerformed(ActionEvent e) 
 			{ 
 				jButton11_actionPerformed(e); 
 			} 
  
 		});
 		
 			jButton12.addActionListener(new ActionListener() { 
 			public void actionPerformed(ActionEvent e) 
 			{ 
 				jButton12_actionPerformed(e); 
 			} 
  
 		});
 		
 			jButton13.addActionListener(new ActionListener() { 
 			public void actionPerformed(ActionEvent e) 
 			{ 
 				jButton13_actionPerformed(e); 
 			} 
  
 		});
 		
 		
 		
 		
 		// 
 		// contentPane 
 		// 
 		contentPane.setLayout(null); 
 		contentPane.setBackground(new Color(158,158,237));
 		
 		addComponent(contentPane, photo, 31,55,100,100); 
 		addComponent(contentPane, jButton1, 31,160 ,115,15); 
 	    //photos label
 	    addComponent(contentPane, jLabel16, 820,5,100,100);
 		addComponent(contentPane, jLabel17, 820,130,100,100);
 		addComponent(contentPane, jLabel2, 580,5,100,100);
 		addComponent(contentPane, jLabel3, 700,5,100,100);
 		addComponent(contentPane, jLabel4, 580,130,100,100);
 		addComponent(contentPane, jLabel5, 700,130,100,100);
 		
 		//view friend
 		addComponent(contentPane, jButton2, 700,260,110,20);
 		
 		//friend button
 		addComponent(contentPane, jButton4, 580,110,100,15);
 		addComponent(contentPane, jButton5, 700,110,100,15);
 		addComponent(contentPane, jButton6, 580,235,100,15);
 		addComponent(contentPane, jButton7, 700,235,100,15);
 		addComponent(contentPane, jButton11, 820,110,100,15);
 		addComponent(contentPane, jButton12, 820,235,100,15);
 		
 		//upper buttons
 		addComponent(contentPane, jButton8, 35,10,90,20);
 		addComponent(contentPane, jButton9, 140,10,90,20);
 	    addComponent(contentPane, jButton13, 245,10,90,20);
 	
 		
 		
 		addComponent(contentPane, jButton10, 31,180,115,15);
 		 
 		addComponent(contentPane, abtme1, 262,248,326,80); 
 		addComponent(contentPane, jTextField2, 262,347,326,22); 
 		addComponent(contentPane, jTextField3, 262,379,326,22); 
 		addComponent(contentPane, jTextField4, 262,445,327,22); 
 		addComponent(contentPane, jTextField5, 262,474,327,22); 
 		addComponent(contentPane, jTextField6, 262,413,328,22); 
 		addComponent(contentPane, jTextField7, 262,503,328,22); 
 		addComponent(contentPane, jTextField8, 262,531,327,22); 
 		
 		addComponent(contentPane, jTextField9, 100,248,163,80);
 		addComponent(contentPane, jTextField10, 100,347,163,22); 
 		addComponent(contentPane, jTextField11, 100,379,163,22);
 		addComponent(contentPane, jTextField12, 100,445,163,22);
 		addComponent(contentPane, jTextField13, 100,474,163,22);
 		addComponent(contentPane, jTextField14, 100,413,163,22);
 		addComponent(contentPane, jTextField15, 100,503,163,22);
 		addComponent(contentPane, jTextField16, 100,531,163,22);
 	addComponent(contentPane, jButton3, 510,570,70,20);
 		
 		// 531
 		// view_others 
 		// 
 		
 		
 	
 		this.setTitle(userdata+"'s PROFILE"); 
 		this.setLocation(new Point(0,0)); 
 		this.setSize(new Dimension(1024,768)); 
 		
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
 
 	private void jTextArea1_actionPerformed(ActionEvent e) 
 	{ 
 		//System.out.println("\njTextArea1_actionPerformed(ActionEvent e) called."); 
 		// TODO: Add any handling code here 
  
 	} 
 	*/
  
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
  
 	private void jTextField6_actionPerformed(ActionEvent e) 
 	{ 
 		//System.out.println("\njTextField6_actionPerformed(ActionEvent e) called."); 
 		// TODO: Add any handling code here 
  
 	} 
  
 	private void jTextField7_actionPerformed(ActionEvent e) 
 	{ 
 		//System.out.println("\njTextField7_actionPerformed(ActionEvent e) called."); 
 		// TODO: Add any handling code here 
  
 	} 
  
 	private void jTextField8_actionPerformed(ActionEvent e) 
 	{ 
 		//System.out.println("\njTextField8_actionPerformed(ActionEvent e) called."); 
 		// TODO: Add any handling code here 
  
 	} 
 		private void jButton1_actionPerformed(ActionEvent e) 
 	{ 
 		//System.out.println("\njButton1_actionPerformed(ActionEvent e) called."); 
 		
 		
 	
 		// TODO: Add any handling code here 
 	//	this.setVisible(false);
 	
 	    //System.out.println(orkut.currentuser+"********add as"); 
 		new Client("#####"+orkut.currentuser+"*"+userdata);
 		new view_others(userdata);
 			this.setVisible(false);
 		
  
 	} 
 	
 		private void jButton2_actionPerformed(ActionEvent e) 
 	{ 
 		//System.out.println("\njButton2_actionPerformed(ActionEvent e) called."); 
 		  
  
 			//System.out.println(userdata); 
 		Client c=new Client("frien"+userdata);
 		//System.out.println(c.strrecv+"****************in view");
 		             int start=0;
                     int friends=0;
                     int temp1;
                     int last=0;
                     {
                     
                     last=c.strrecv.length();
                     int max;
                     String arr[]=new String[6];
                     
                     
                     while(start<last)
                        { if((temp1=c.strrecv.indexOf("$",start))!=-1)
                          {
                          	friends++;
                          	start=temp1+1;
                          }
                          start++;
                          
                        }
                     
                     //System.out.println(friends);  
                 if(friends==0)
                     max=0;
                     else 
                     if(friends%6==0)
                     max=friends/6;
                     else
                     max= friends/6+1;
                     //System.out.println("max="+max);                    
                     friend[] fri =new friend[max];
                     //System.out.println("*****max frame="+max);
                        int frameno=0;
                        int count=0;
                        int cc;
                        int c1;
                        int photo=1;
                        start=0;
                        String temp=null;
                        while(start<last)
                             {  
                                if(count==6)
                                  {for(int i=0;i<6;i++) 
                                   if(arr[i]!=null)
                                   {
                                   	//System.out.println("*****downloading   ="+photo+arr[i]);
                                   	new Client("photo"+arr[i]);
                                   	photo++;
                                   }
                                   //System.out.println("*****called frame="+frameno);
                                   fri[frameno]=new friend(arr,userdata,fri,max-1,frameno++);
                                  	for(int i=0;i<6;i++)
                                      arr[i]=null; 
                                     count =0; 
                                  }
                                
                             	if((cc=c.strrecv.indexOf("$",start))!=-1)
                             	   { temp=c.strrecv.substring(start,cc);
                             	     start=cc+1;
                             	     
                             	     if((c1=temp.lastIndexOf("#"))!=-1)
                             	     temp=temp.substring(c1+1,temp.length());
                             	     if((c1=temp.lastIndexOf("*"))!=-1)
                             	     temp=temp.substring(c1+1,temp.length());
                             	      arr[count++]  =temp;
                             	      
                             	   }
                             	   else start++;
                             	   
                             	
                             	
                             	
                             }
                             
                             if(frameno==max-1) 
                               {   //System.out.println("*****count= "+count);
                                   for(int i=0;i<count;i++) 
                                   if(arr[i]!=null)
                                   {//System.out.println("*****downloading   ="+photo+arr[i]);
                                   	new Client("photo"+arr[i]);
                                   	//System.out.println("*****downloading   ="+photo+arr[i]);
                                   	photo++;
                                   	}
                                   //System.out.println("*****called frame="+frameno);
                                   fri[frameno]=new friend(arr,userdata,fri ,max-1,frameno++);
                                  //	for(int i=0;i<6;i++)
                                    //  arr[i]=""; 
                                     
                                }             
                                  
                     }
                              
 		
 	/*	friend[] f1 =new  friend[c.max];
 		for(int i=0;i<c.max;i++)
 		f1[i]=new friend(c.arr,orkut.currentuser,f1,this,c.max-1,i);*/
 		
 	
 		
 		this.setVisible(false);
  
 	} 
 	
 	
 		private void jButton3_actionPerformed(ActionEvent e) 
 	{ 
 		//System.out.println("\njButton3_actionPerformed(ActionEvent e) called."); 
 		// TODO: Add any handling code here 
 		
 		next.setVisible(true);
 		this.setVisible(false);
  
 	} 
 	
 	private void jButton4_actionPerformed(ActionEvent e) 
 	{ 
 		//System.out.println("\njButton4_actionPerformed(ActionEvent e) called."); 
 		// TODO: Add any handling code here 
 		String temp=jButton4.getText();
 		int i=temp.indexOf("(");
 		temp=temp.substring(0,i);
 		if(!(orkut.currentuser).equals(temp))
 		new view_others(temp);
 	        else  	new viewprofile(temp);
 		this.setVisible(false);
 		
  
 	} 
 	private void jButton5_actionPerformed(ActionEvent e) 
 	{ 
 		//System.out.println("\njButton5_actionPerformed(ActionEvent e) called."); 
 		// TODO: Add any handling code here 
 		
 		String temp=jButton5.getText();
 		int i=temp.indexOf("(");
 		temp=temp.substring(0,i);
 			if(!(orkut.currentuser).equals(temp))
 		new view_others(temp);
 	        else  	new viewprofile(temp);
 	        
 	        this.setVisible(false);
 	        
  
 	} 
 	private void jButton6_actionPerformed(ActionEvent e) 
 	{ 
 		//System.out.println("\njButton6_actionPerformed(ActionEvent e) called."); 
 		// TODO: Add any handling code here 
 		  String temp=jButton6.getText();
 		int i=temp.indexOf("(");
 		temp=temp.substring(0,i);
 			if(!(orkut.currentuser).equals(temp))
 		new view_others(temp);
 	        else  	new viewprofile(temp);
 			this.setVisible(false);
 		
  
 	} 
 	private void jButton7_actionPerformed(ActionEvent e) 
 	{ 
 		//System.out.println("\njButton7_actionPerformed(ActionEvent e) called."); 
 		// TODO: Add any handling code here 
        	String temp=jButton7.getText();
 		int i=temp.indexOf("(");
 		temp=temp.substring(0,i);
 		if(!(orkut.currentuser).equals(temp))
 		new view_others(temp);
 	        else  	new viewprofile(temp);
        	this.setVisible(false);
        	
 		
 	} 
 	private void jButton8_actionPerformed(ActionEvent e) 
 	{ 
 		//System.out.println("\njButton8_actionPerformed(ActionEvent e) called."); 
 		
 		new viewprofile(orkut.currentuser);
 		this.setVisible(false);
 		// TODO: Add any handling code here 
 		
  
 	} 
 	private void jButton9_actionPerformed(ActionEvent e) 
 	{ 
 		//System.out.println("\njButton9_actionPerformed(ActionEvent e) called."); 
 		 
 		 new searchname();
 		 this.setVisible(false);
 		// TODO: Add any handling code here 
  
 	} 
 	private void jButton10_actionPerformed(ActionEvent e) 
 	{ 
 		//System.out.println("\njButton10_actionPerformed(ActionEvent e) called."); 
 		
 		
 		 new Client("scrap"+userdata); 
              
              
           	try{
 		
 		FileReader fr = new FileReader("c:/orkut_java/temp.txt");
        BufferedReader br = new BufferedReader(fr);
        
       
        String firstline=br.readLine();
        firstline=firstline.trim();
        //System.out.println("\n first line is="+firstline);
        
        int c=Integer.parseInt(firstline);
         
        int j;
        
        int maxfrm;
       if(c==0) maxfrm=1;
       else if((c%3)==0) 
            maxfrm=c/3;
       else  maxfrm=(c/3)+1;
        //System.out.println(c+"\n"); 
        view_scrapbook array[] =new view_scrapbook [maxfrm];
        //System.out.println(c+"\n"); 
        String temp;
        
        String src[]=new String [3];
        for(int i=0;i<maxfrm;i++)
           { 
               src[0]=src[1]=src[2]="";
             for(j=0;j<3;j++)
             { 
             
             if(br.read()==-1)
           	 break;  
             temp=br.readLine();             
             
           	 //System.out.println(temp+"\n"); 
          
           	 //extracts scraps for a frame           
           	 while(!(temp.equals("~!@#$%")))
           	 {
           	 	src[j]+=temp+"\n";
           	 	temp=br.readLine();
           	 }     
                       	    	 
             }
             	//System.out.println("for a frame"+i+"\n"+src[0]+src[1]+src[2]);
               if( c%3==1 && i==maxfrm-1) src[2]="";
               array[i]=new view_scrapbook(src[0],src[1],src[2],array,i,c,userdata); 
           }
          
             br.close();
             fr.close();
             this.setVisible(false);
           }
           catch(Exception e1) 
                {  
                	new serverdown();
                	this.setVisible(false);
                	//System.out.println("in view profile scrapbook =****"+e1);
                }
 		
 		// TODO: Add any handling code here 
  
 	} 
 	
 	
 		private void jButton11_actionPerformed(ActionEvent e) 
 	{ 
 		//System.out.println("\njButton11_actionPerformed(ActionEvent e) called."); 
 		// TODO: Add any handling code here 
 		
 		String temp=jButton11.getText();
 		int i=temp.indexOf("(");
 		temp=temp.substring(0,i);
 		if(!(orkut.currentuser).equals(temp))
 		new view_others(temp);
 	        else  	new viewprofile(temp);
 		this.setVisible(false);
 		
 		
 		
  
 	} 
 		private void jButton12_actionPerformed(ActionEvent e) 
 	{ 
 		//System.out.println("\njButton12_actionPerformed(ActionEvent e) called."); 
 		// TODO: Add any handling code here 
 		
 		String temp=jButton12.getText();
 		int i=temp.indexOf("(");
 		temp=temp.substring(0,i);
 		if(!(orkut.currentuser).equals(temp))
 		new view_others(temp);
 	        else  	new viewprofile(temp);
 		this.setVisible(false);
 		
 		
  
 	} 
 	
 			private void jButton13_actionPerformed(ActionEvent e) 
 	{ 
 		//System.out.println("\njButton13_actionPerformed(ActionEvent e) called."); 
 		//System.out.println(orkut.currentuser); 
 		Client c=new Client("frien"+userdata);
 		//System.out.println(c.strrecv+"****************in view");
 		             int start=0;
                     int friends=0;
                     int temp1;
                     if(c.strrecv!=null)
                     {int last=c.strrecv.length();
                     int max;
                     String arr[]=new String[6];
                     
                     
                     while(start<last)
                        { if((temp1=c.strrecv.indexOf("$",start))!=-1)
                          {
                          	friends++;
                          	start=temp1+1;
                          }
                          start++;
                          
                        }
                     
                     //System.out.println(friends);  
                 if(friends==0)
                     max=0;
                     else 
                     if(friends%6==0)
                     max=friends/6;
                     else
                     max= friends/6+1;
                     //System.out.println("max="+max);                    
                     friend[] fri =new friend[max];
                     //System.out.println("*****max frame="+max);
                        int frameno=0;
                        int count=0;
                        int cc;
                        int c1;
                        int photo=1;
                        start=0;
                        String temp=null;
                        while(start<last)
                             {  
                                if(count==6)
                                  {for(int i=0;i<6;i++) 
                                   if(arr[i]!=null)
                                   {
                                   	//System.out.println("*****downloading   ="+photo+arr[i]);
                                   	new Client("photo"+arr[i]);
                                   	photo++;
                                   }
                                   //System.out.println("*****called frame="+frameno);
                                   fri[frameno]=new friend(arr,orkut.currentuser,fri,max-1,frameno++);
                                  	for(int i=0;i<6;i++)
                                      arr[i]=null; 
                                     count =0; 
                                  }
                                
                             	if((cc=c.strrecv.indexOf("$",start))!=-1)
                             	   { temp=c.strrecv.substring(start,cc);
                             	     start=cc+1;
                             	     
                             	     if((c1=temp.lastIndexOf("#"))!=-1)
                             	     temp=temp.substring(c1+1,temp.length());
                             	     if((c1=temp.lastIndexOf("*"))!=-1)
                             	     temp=temp.substring(c1+1,temp.length());
                             	      arr[count++]  =temp;
                             	      
                             	   }
                             	   else start++;
                             	   
                             	
                             	
                             	
                             }
                             
                             if(frameno==max-1) 
                               {   //System.out.println("*****count= "+count);
                                   for(int i=0;i<count;i++) 
                                   if(arr[i]!=null)
                                   {//System.out.println("*****downloading   ="+photo+arr[i]);
                                   	new Client("photo"+arr[i]);
                                   	//System.out.println("*****downloading   ="+photo+arr[i]);
                                   	photo++;
                                   	}
                                   //System.out.println("*****called frame="+frameno);
                                   fri[frameno]=new friend(arr,orkut.currentuser,fri ,max-1,frameno++);
                                  //	for(int i=0;i<6;i++)
                                    //  arr[i]=""; 
                                     
                                }             
                           }       
 		// TODO: Add any handling code here 
  
 	} 
  
  
    	int countfr(String user)
 	       {
 	       	 Client d=new Client("frien"+user);
 		   int start1=0;
 		    int friends1=0;
 		   if(d.strrecv!=null)
 		  { int	last1=d.strrecv.length();
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
 	    //jButton2=new JButton("View Friends("+friends1+")");
 	       	
 	       	 
 	       } 
 
  
  
 } 