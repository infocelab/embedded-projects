
 /****************************************************************/ 
 /*                      view_scrapbook	                            */ 
 /*                                                              */ 
 /****************************************************************/ 
 import java.io.*; 
 import java.awt.*; 
 import java.awt.event.*; 
 import javax.swing.*; 
 import java.util.Date;
 
 /** 
  * Summary description for view_scrapbook 
  * 
  */ 
 public class view_scrapbook extends JFrame 
 { 
 	// Variables declaration 
    private JLabel jLabel1; 
    private JLabel jLabel2; 
 	private JLabel jLabel3; 
 	private JLabel jLabel4;
 	private JTextArea jTextArea2; 
 	private JScrollPane jScrollPane3; 
 	private JTextArea jTextArea3; 
 	private JScrollPane jScrollPane4; 
 	private JTextArea jTextArea4; 
 	private JScrollPane jScrollPane5; 
 	private JTextArea jTextArea5; 
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
 	private JButton jButton10; 
 	private JButton jButton11; 
 	private JButton jButton12; 
 	private JButton jButton13; 
 	private JPanel contentPane; 
 
    public view_scrapbook aa[];
    public int number;
    public int maxscrap;
    public int max;//max frames
     String name;
    
 	// End of variables declaration 
  
  
 	public view_scrapbook(String str11,String str22,String str33,view_scrapbook a[],int num,int maxx,String name1) 
 	{ 
 		super(); 
 		aa=a;
 		number=num;
 		maxscrap=maxx;
 		
 		if (maxx==0)
 		    max=1;
 		
 		else if(maxx%3==0)
 		      max=maxx/3;
 		else
 		max=maxx/3+1;
 		
 		name=name1;
 		JFrame.setDefaultLookAndFeelDecorated(true); 
 		JDialog.setDefaultLookAndFeelDecorated(true); 
 		try 
 		{ 
 			UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel"); 
 		} 
 		catch (Exception ex) 
 		{ 
 		    new serverdown();	
 			//System.out.println("Failed loading L&F: "); 
 			//System.out.println(ex); 
 		} 
       
 	
 		initializeComponent(str11,str22,str33); 
 		// 
 		// TODO: Add any constructor code after initializeComponent call 
 		// 
        if(num==0)
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
 	private void initializeComponent(String str1,String str2,String str3) 
 
 	{   jLabel1 = new JLabel(); 
 	    jLabel2 = new JLabel(); 
 	    jLabel3 = new JLabel(); 
 	    jLabel4 = new JLabel();
 	   
 	    jTextArea2 = new JTextArea(); 
 	   
 	    jScrollPane3 = new JScrollPane(); 
 		
 		jTextArea3 = new JTextArea(); 
 		jScrollPane4 = new JScrollPane(); 
 		jTextArea4 = new JTextArea(); 
 		jScrollPane5 = new JScrollPane(); 
 		jTextArea5 = new JTextArea(); 
 		jScrollPane6 = new JScrollPane(); 
 		jButton1 = new JButton(); //submit
 		jButton2 = new JButton(); //next
 		jButton3 = new JButton(); //back
 		jButton4 = new JButton(); // home
 		jButton5 = new JButton(); //friends
 		jButton6 = new JButton(); //refresh
 		jButton7 = new JButton(); //search
 	    jButton8 = new JButton();//photo names
 	    jButton9 = new JButton();
 	    jButton10 = new JButton();
 	    jButton11 = new JButton();//delete
 	    jButton12 = new JButton();
 	    jButton13 = new JButton();
 		
 		contentPane = (JPanel)this.getContentPane(); 
        String sender1="";
         String sender2="";
          String sender3="";
     // 
 		// jLabel1 
 		// 
 		if(!str1.equals(""))
 		{
 		
 		sender1=getsender(str1);
 		
 		new Client("photo"+sender1);
 		jLabel1.setIcon(new ImageIcon("c:/orkut_java/photos/"+sender1+".jpg")); 
 		jLabel1.setForeground(new Color(255, 0, 0));
 		jLabel1.setText("NO PHOTO"); 
 		}
 		 // 
 		// jLabel2 
 		// 
 			if(!str2.equals(""))
 			{
 			
 		sender2=getsender(str2);
 			new Client("photo"+sender2);
 		jLabel2.setIcon(new ImageIcon("c:/orkut_java/photos/"+sender2+".jpg")); 
 		jLabel2.setForeground(new Color(255, 0, 0));
 		jLabel2.setText("NO PHOTO"); 
 		}
 		 // 
 		// jLabel3 
 		// 
 			if(!str3.equals(""))
 		{
 		
 		sender3=getsender(str3);
 			new Client("photo"+sender3);
 		jLabel3.setIcon(new ImageIcon("c:/orkut_java/photos/"+sender3+".jpg")); 
 		jLabel3.setForeground(new Color(255, 0, 0)); 
 		jLabel3.setText("NO PHOTO"); 
 		
 		} 
 		
 		
 			 // 
 		// jLabel4
 		// 
 			
 		{
 		
 	
 		jLabel4.setIcon(new ImageIcon("c:/orkut_java/photos/"+name+".jpg")); 
 		jLabel4.setForeground(new Color(255, 0, 0)); 
 		jLabel4.setText("NO PHOTO"); 
 		
 		} 
 		
 		
 		// 
 		// jTextArea2 
 		// 
 		jTextArea2.setBackground(new Color(255, 255, 255)); 
 			jTextArea3.setEditable(true); 
 		// 
 		// jScrollPane3 
 		// 
 		jScrollPane3.setViewportView(jTextArea2); 
 		// 
 		// jTextArea3 
 		// 
 		jTextArea3.setBackground(new Color(140, 152, 236)); 
 		jTextArea3.setText(str1);
 		jTextArea3.setEditable(false); 
 		// 
 		// jScrollPane4 
 		// 
 		jScrollPane4.setViewportView(jTextArea3); 
 		// 
 		// jTextArea4 
 		// 
 		jTextArea4.setBackground(new Color(140, 152, 236)); 
 			jTextArea4.setText(str2);
 	
 		jTextArea4.setEditable(false); 
 		// 
 		// jScrollPane5 
 		// 
 		jScrollPane5.setViewportView(jTextArea4); 
 		// 
 		// jTextArea5 
 		// 
 		jTextArea5.setBackground(new Color(140, 152, 236)); 
 			jTextArea5.setText(str3);
 	
 		jTextArea5.setEditable(false); 
 		// 
 		// jScrollPane6 
 		// 
 		jScrollPane6.setViewportView(jTextArea5); 
 		// 
 		// jButton1 
 		// 
 		jButton1.setText("Submit"); 
 		jButton1.addActionListener(new ActionListener() { 
 			public void actionPerformed(ActionEvent e) 
 			{ try{
 			
 				jButton1_actionPerformed(e); 
 			} 
 			catch(Exception ex) 
 			{ 
 			new serverdown();
 			}
 			 
 			} 
  
 		}); 
 		
 		// 
 		// jButton2 
 		// 
 		
 		jButton2.setText("Next"); 
 		jButton2.addActionListener(new ActionListener() 
 		{ 
 			public void actionPerformed(ActionEvent e) 
 			{ 
 				jButton2_actionPerformed(e); 
 			} 
  
 		}); 
 		
 		if(max==1) {
 			       jButton2.setVisible(false);
 		            jButton3.setVisible(false);
 		           }
 		
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
 		jButton4.setText("Home"); 
 		jButton4.addActionListener(new ActionListener() { 
 			public void actionPerformed(ActionEvent e) 
 			{ 
 				jButton4_actionPerformed(e); 
 			} 
  
 		}); 
 				// 
 		// jButton5
 		// 
 		jButton5.setText("Friends"); 
 		jButton5.addActionListener(new ActionListener() { 
 			public void actionPerformed(ActionEvent e) 
 			{ 
 				jButton5_actionPerformed(e); 
 			} 
  
 		}); 
 				// 
 		// jButton6
 		// 
 		jButton6.setText("Refresh"); 
 		jButton6.addActionListener(new ActionListener() { 
 			public void actionPerformed(ActionEvent e) 
 			{ 
 				jButton6_actionPerformed(e); 
 			} 
  
 		}); 
 					// 
 		// jButton7
 		// 
 		jButton7.setText("Search"); 
 		jButton7.addActionListener(new ActionListener() { 
 			public void actionPerformed(ActionEvent e) 
 			{ 
 				jButton7_actionPerformed(e); 
 			} 
  
 		}); 
 	    
 	    // 
 		// jButton8 
 		// 
 		 if(str1.equals("")) jButton8.setVisible(false);	
 		   
 		 else{
 		  
 		 jButton8.setBackground(new Color(140, 152, 236)); 
 	   
 		
 		 jButton8.setText(sender1); 
 		  
 		 jButton8.addActionListener(new ActionListener() { 
 			public void actionPerformed(ActionEvent e) 
 			{ 
 				jButton8_actionPerformed(e); 
 			} 
  
 		}); 
 		
 		 }
 		 
 		 // jbutton9
 		 
 		 if(str2.equals("")) jButton9.setVisible(false);	
 		   
 		 else{
 		  
 		 jButton9.setBackground(new Color(140, 152, 236)); 
 	   
 		
 		 jButton9.setText(sender2); 
 		  
 		 jButton9.addActionListener(new ActionListener() { 
 			public void actionPerformed(ActionEvent e) 
 			{ 
 				jButton9_actionPerformed(e); 
 			} 
  
 		}); 
 		
 		 }
 	       // 
 		// jButton10 
 		// 
 		 if(str3.equals("")) jButton10.setVisible(false);	
 		   
 		 else{
 		  
 		 jButton10.setBackground(new Color(140, 152, 236)); 
 	   
 		
 		 jButton10.setText(sender3); 
 		  
 		 jButton10.addActionListener(new ActionListener() { 
 			public void actionPerformed(ActionEvent e) 
 			{ 
 				jButton10_actionPerformed(e); 
 			} 
  
 		}); 
 		
 		 }
 		
 		    // 
 		// jButton11 
 		// 
 		 if(str1.equals("") || ! (name.equals(orkut.currentuser) || sender1.equals(orkut.currentuser) )) 
 		 jButton11.setVisible(false);	
 		   
 		 else{
 		  
 		 jButton11.setBackground(new Color(140, 152, 236)); 
 	   
 		
 		 jButton11.setText("Delete"); 
 		  
 		 jButton11.addActionListener(new ActionListener() { 
 			public void actionPerformed(ActionEvent e) 
 			{ 
 				jButton11_actionPerformed(e); 
 			} 
  
 		}); 
 		
 		 }
 			    // 
 		// jButton12
 		// 
 		 if(str2.equals("") || ! (name.equals(orkut.currentuser) || sender2.equals(orkut.currentuser) )) 
 		 jButton12.setVisible(false);	
 		   
 		 else{
 		  
 		 jButton12.setBackground(new Color(140, 152, 236)); 
 	   
 		
 		 jButton12.setText("Delete"); 
 		  
 		 jButton12.addActionListener(new ActionListener() { 
 			public void actionPerformed(ActionEvent e) 
 			{ 
 				jButton12_actionPerformed(e); 
 			} 
  
 		}); 
 		
 		 }

	    // 
 		// jButton13
 		// 
 		 if(str3.equals("") || ! (name.equals(orkut.currentuser) || sender3.equals(orkut.currentuser) )) 
 		 jButton13.setVisible(false);	
 		   
 		 else{
 		  
 		 jButton13.setBackground(new Color(140, 152, 236)); 
 	   
 		
 		 jButton13.setText("Delete"); 
 		  
 		 jButton13.addActionListener(new ActionListener() { 
 			public void actionPerformed(ActionEvent e) 
 			{ 
 				jButton13_actionPerformed(e); 
 			} 
  
 		}); 
 		
 		 } 		
 		// 
 		// contentPane 
 		// 
 		contentPane.setLayout(null); 
 		contentPane.setBackground(new Color(140, 152, 236)); 
 		
 		//photos
 		addComponent(contentPane, jLabel1, 22,163,100,100); 
 		addComponent(contentPane, jLabel2, 22,327,100,100); 
 		addComponent(contentPane, jLabel3, 22,471,100,100); 
 		addComponent(contentPane, jLabel4, 22,45,100,100); 
 		
 		//edit scrap
 		addComponent(contentPane, jScrollPane3, 184,55,420,87); 
 		
 		//scrap 
 		addComponent(contentPane, jScrollPane4, 150,163,534,120); 
 		addComponent(contentPane, jScrollPane5, 150,327,534,120); 
 		addComponent(contentPane, jScrollPane6, 150,471,534,120); 
 		
 		
 		addComponent(contentPane, jButton1, 631,75,83,40); 
 		addComponent(contentPane, jButton2, 583,615,83,37); 
 		addComponent(contentPane, jButton3, 494,615,83,37); 
 		
 		addComponent(contentPane, jButton4, 22,6,83,37); 
 		addComponent(contentPane, jButton5, 108,6,83,37); 
 		addComponent(contentPane, jButton6, 194,6,83,37); 
 		addComponent(contentPane, jButton7, 280,6,83,37); 
 	    //photo buttons
 	    
 	    addComponent(contentPane, jButton8, 1,266,138,30); 
 	    addComponent(contentPane, jButton9, 1,430,138,30); 
         addComponent(contentPane, jButton10, 1,574,138,30); 
          
          //delete
          addComponent(contentPane, jButton11, 695,200,83,35);
          addComponent(contentPane, jButton12, 695,364,83,35);
            addComponent(contentPane, jButton13, 695,508,83,35);   
           
           
 		 		
 		// view_scrapbook 
 		// 
 		this.setTitle( "Welcome to "+name+"'s  Scrapbook" ); 
 		this.setLocation(new Point(0, 0)); 
 		this.setSize(new Dimension(1024,768 )); 
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
 	try
 	{
 	
 		String str=jTextArea2.getText();
 	      FileReader fr = new FileReader("c:/orkut_java/temp.txt");
        BufferedReader br = new BufferedReader(fr);
        int maxscrp =Integer.parseInt(br.readLine());
        maxscrp++;
        Date date=new Date();
       // //System.out.println(""+maxscrp); 	    
 	    String s="filin"+name+'*'+maxscrp+"\n"+str+"\n\n\n"+date+"\n"+orkut.currentuser+"\n~!@#$%\n";
 	    
 	   
 	  //  //System.out.println(s); 
 	    new Client(s);
        fr.close(); 
        br.close(); 
        
        
         refresh();
         this.setVisible(false);
    	jTextArea2.setText("");     
 	} catch(Exception ex) 
 	    {   
 			new serverdown();
 			this.setVisible(false);
 			//System.out.println("in view scrap"+ex); 
 		}    
 	
 		
 	
 //	File f=new File("c:/orkut_java/temp.txt");
 //	 f.delete();
 		
 
 		// TODO: Add any handling code here 
  
 	} 
  
 	private void jButton2_actionPerformed(ActionEvent e) 
 	{ 
 			//System.out.println("\njButton2_actionPerformed(ActionEvent e) called."); 
 		// TODO: Add any handling code here 
 		if((max-1)!=number)
 		   {    aa[number].setVisible(false);
            	aa[number+1].setVisible(true);
            }
 	} 
  

  	private void jButton3_actionPerformed(ActionEvent e) 
 	{ 
 		 // //System.out.println("\njButton3_actionPerformed(ActionEvent e) called."); 
 		// TODO: Add any handling code here 
           if(number!=0)
            {    aa[number].setVisible(false);
            	 aa[number-1].setVisible(true);
             
            } 
 	} 
 // home
 	private void jButton4_actionPerformed(ActionEvent e) 
 	{ 
 		 // //System.out.println("\njButton4_actionPerformed(ActionEvent e) called."); 
 		// TODO: Add any handling code here 
 		new viewprofile(orkut.currentuser);
 		 this.setVisible(false);
        
 	} 
 	//friends
 	private void jButton5_actionPerformed(ActionEvent e) 
 	{ 
 		  //System.out.println("\njButton5_actionPerformed(ActionEvent e) called."); 
 		  	Client c=new Client("frien"+orkut.currentuser);
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
 		  	this.setVisible(false);
 		  
 		// TODO: Add any handling code here 
          
 	} 
 	// refresh
 	private void jButton6_actionPerformed(ActionEvent e) 
 	{ 
 		  //System.out.println("\njButton6_actionPerformed(ActionEvent e) called."); 
 		// TODO: Add any handling code here 
           try{
            
           refresh();
           this.setVisible(false);
           }
           catch(Exception ex) 
                             { //System.out.println("in view scrap jbutton 6");
                                 
                                new serverdown();
                            }
 	} 
 		// search
 	private void jButton7_actionPerformed(ActionEvent e) 
 	{ 
 		  //System.out.println("\njButton7_actionPerformed(ActionEvent e) called."); 
 		  
 		 
 		  
 		  new searchname();
 		  this.setVisible(false);
 		
 		// TODO: Add any handling code here 
           
 	} 
 	
 			// photo name
 	private void jButton8_actionPerformed(ActionEvent e) 
 	{ 
 		  //System.out.println("\njButton8_actionPerformed(ActionEvent e) called."); 
 	       if(!(jButton8.getText()).equals(orkut.currentuser))
 	       new view_others(jButton8.getText());
 	       else
 	       new viewprofile(jButton8.getText());
 	      // new Client("profi"+jButton8.getText());
 	       this.setVisible(false);
 	       
 	
 		// TODO: Add any handling code here 
           
 	} 
  
   
 	private void jButton9_actionPerformed(ActionEvent e) 
 	{ 
 		  //System.out.println("\njButton9_actionPerformed(ActionEvent e) called."); 
 		  if(!(jButton8.getText()).equals(orkut.currentuser))
 	       new view_others(jButton9.getText());
 	       else
 	       new viewprofile(jButton9.getText());
 	       this.setVisible(false);
 		// TODO: Add any handling code here 
          
 	} 
 	
 	
 	private void jButton10_actionPerformed(ActionEvent e) 
 	{ 
 		  //System.out.println("\njButton10_actionPerformed(ActionEvent e) called."); 
 		  
 		   if(!(jButton10.getText()).equals(orkut.currentuser))
 	       new view_others(jButton10.getText());
 	       else
 	       new viewprofile(jButton10.getText());
 	       this.setVisible(false);
 		// TODO: Add any handling code here 
          
 	} 
 	
 	
 	// delete
 	private void jButton11_actionPerformed(ActionEvent e) 
 	{ 
 		  //System.out.println("\njButton11_actionPerformed(ActionEvent e) called."); 
 	        int scrapno=3*number+1;
 	        new Client("delet"+name+"*"+scrapno);
 	        
 	        //System.out.println(" ******frame no is "+ number +"  scrap no is "+scrapno); 
 	         
 	        
 	         try{
 	         
 	        
 	         
 	         refresh();
 	         this.setVisible(false);
 	         }
 	         catch(Exception exs) 
 	         { new serverdown(); 
 	         //System.out.println(" while deleting "+exs);
 	         }  
 		// TODO: Add any handling code here 
          
 	} 
 
 	// delete
 	private void jButton12_actionPerformed(ActionEvent e) 
 	{ 
 		  //System.out.println("\njButton12_actionPerformed(ActionEvent e) called."); 
 		   int scrapno=3*number+2;
 		   //System.out.println(" ********frame no is "+ number +"  scrap no is "+ scrapno) ;
             new Client("delet"+name+"*"+scrapno);
 	        try{
 	         
 	        
 	         refresh();
 	          this.setVisible(false);
 	         }
 	         catch(Exception exs) 
 	         { new serverdown(); 
 	         //System.out.println(" while deleting "+exs);
 	         }
 		// TODO: Add any handling code here 
          
 	} 
 	
 		// delete
 	private void jButton13_actionPerformed(ActionEvent e) 
 	{ 
 		  //System.out.println("\njButton13_actionPerformed(ActionEvent e) called."); 
 		   int scrapno=3*number+3;
 		   //System.out.println(" *******frame no is "+ number +"  scrap no is "+scrapno);
             new Client("delet"+name+"*"+scrapno);
 		 try{
 	         
 	       
 	         refresh();
 	           this.setVisible(false);
 	         }
 	         catch(Exception exs) 
 	         { new serverdown(); 
 	         //System.out.println(" while deleting "+exs);
 	         }
 		// TODO: Add any handling code here 
          
 	} 
 	// 
 	// 
 	// TODO: Add any method code to meet your needs in the following area 
 	// 
  void refresh() throws Exception
  { 
  
  
       new Client("scrap"+name); 
              
              
          
 		
 		FileReader fr = new FileReader("c:/orkut_java/temp.txt");
        BufferedReader br = new BufferedReader(fr);
        int c=Integer.parseInt(br.readLine());
         
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
        String src[]=new String[3];
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
           	 while( !(temp.equals("~!@#$%")))
           	 {
           	 	src[j]+=temp+"\n";
           	 	temp=br.readLine();
           	 }     
                       	    	 
             }
             	 if( c%3==1 && i==maxfrm-1) src[2]="";
             	//System.out.println("for a frame"+src[0]+src[1]+src[2]);
               array[i]=new view_scrapbook(src[0],src[1],src[2],array,i,c,name); 
           }
          
             br.close();
             fr.close();
           
         
        
 	
  }
 String getsender(String s)
 { 
   int i,l;
   String nm;
   
   
   l=s.length();
   
   
   for( i=l-2;s.charAt(i)!='\n' && i>=0;i--);
             
   nm = s.substring(i+1,l);
   nm=nm.trim();
    
   return nm;
 }
 
 } 
  
 