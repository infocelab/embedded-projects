import java.net.*;
import java.io.*;
import java.awt.*;
import java.util.*;
import java.applet.*;
import javax.swing.*;
import java.awt.event.*;

class Servermain1 extends JFrame
{

public MulticastSocket serveqr;
	private ServerSocket server;
	public InputStream in;
	public OutputStream out;
	private Socket socket;
	public InetAddress ina;
	public byte[] bytes;
	int fbytes[]=new int[4];
	
	String msg="";
	char ch='y';
	JTextField t1,t2,t3,t4,t5,t6;
	JPasswordField p1,p2,p3,p4;
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10;
	JButton b1,b2,b3,b4,b5,b6,b7;
	JPanel j1,j2,j3,j4,j5,j6;
	ImageIcon i1,i2,i3,i4,i5,i6;
	Container cp;
	
        BufferedReader br;
	PrintWriter wr;
	
	BufferedReader dis;
	
	

	public Servermain1(int port)
	{
	super("Server Login");

	try

		{

			UIManager.setLookAndFeel ("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");

		}

		catch(Exception e)
		{}
	cp=getContentPane();
	cp.setLayout(null);
	j1=new JPanel(null,true);
	
	i1=new ImageIcon("ico/2.jpg");
	l1=new JLabel(i1);
	l1.setBounds(30,0,275,216);
	j1.add(l1);
	j1.setBackground(Color.white);
	j1.setLocation(0,0);
	j1.setSize(300,220);
	cp.add(j1);
	
	
	j2=new JPanel(null,true);
	i3=new ImageIcon("ico/4.jpg");
	l2=new JLabel(i3);
	l2.setBounds(30,05,275,110);

	j2.add(l2);

	t1=new JTextField();
	
	t1.setBounds(130,45,140,30);
	j2.add(t1);

	p1=new JPasswordField();
	p1.setBounds(130,79,140,30);
	j2.add(p1);

	t1.setVisible(true);
	p1.setVisible(true);

	b1=new JButton("Connect...");
	b1.setBounds(40,130,100,30);
	j2.add(b1);
	
	
	b2=new JButton("Reset");
	b2.setBounds(160,130,100,30);
	j2.add(b2);

	

	Color c=new Color(255,255,255);
	j2.setBackground(Color.white);
	j2.setBounds(0,220,300,190);
	cp.add(j2); 
	

	

	
	
	b1.addActionListener(new ActionListener()
	{
	public void actionPerformed(ActionEvent e)
	{
	if(t1.getText().equals("Admin") || t1.getText().equals("admin") && p1.getText().equals("sherkhan"))
	{
	
		
	
	try{
	   
		  Runtime rt=Runtime.getRuntime();
		  rt.exec("ServerRun.bat");	

			
			ServerSocket server=new ServerSocket(1200);
			System.out.println(" Server Socket before accept");
			InetAddress group = InetAddress.getByName("224.0.0.0");

			  System.out.println(" "+server);
			  System.out.println(" waiting for client");
			 
                          while(true)
			  {	
			  Socket socket = server.accept();
			  ina=socket.getInetAddress();
			  System.out.println(" Server responce to "+ina.getHostName());
			  System.out.println(" with ip address");
			  bytes=ina.getAddress();


				for(int i=0;i<4;i++)
				{	
					fbytes[i]=bytes[i]&255;
					System.out.println(fbytes[0]+":"+fbytes[1]+":"+fbytes[2]+":"+fbytes[3]);
					in=socket.getInputStream();
					out=socket.getOutputStream();
				}

				dis=new BufferedReader(new InputStreamReader(System.in));
			
				br=new BufferedReader(new InputStreamReader(socket.getInputStream()));
				wr=new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
				wr.println("Server date info :"+new Date());
				wr.flush();
				String reqx=br.readLine();
				System.out.println("My Command:"+reqx);
			  	Servermain s=new Servermain(reqx,socket);	
			   }
	
		}catch(Exception fg){ System.out.println(fg); try{ socket.close();}catch(Exception hy){}}
	
		
	   }
	  }
	 });
	}

}

public class Servermain 
{
        BufferedReader br;
	PrintWriter wr;
	String reqz="";
	BufferedReader dis;
	String msg="profile";
	char ch='y';
	String str33="";
	String str4="";
	FileReader rt1;
	JTextField jt1;
	String send="";
	PrintWriter wr1;
Servermain(String str1,Socket s){

try{
			

			while(true)
			{
		
				try{
					wr1=new PrintWriter(new OutputStreamWriter(s.getOutputStream()));
					reqz=str1;
					//
					String str2=reqz;
					char cg=reqz.charAt(0);
					
				  
				if(reqz.startsWith("End"))
				{
				System.out.println(" Diconnect...");
				wr.flush();
				}
				if(reqz.startsWith("Quit"))
				{
				System.out.println(" Diconnect...");
				wr.flush();
				System.exit(0);
				}
				else if(cg=='<'){
				
					System.out.println(" Clinet:"+reqz);
					int len=str2.length();
					for(int z=0;z<len;z++)
					     {
						char ch3=str2.charAt(z);
						if(ch3=='<')	
						  {	//System.out.println(ch3);
							//System.out.println("< Found");
							for(int x=z+1;x<len;x++)
							{
								char ch2=str2.charAt(x);
								if(ch2!='>')
								{ 
								//System.out.println(ch2);			
								str33=str33+ch2;
								}
								else
								{ break; }
															

							}
							
						  }	
					
					     }
					System.out.println("User="+str33);		
					for(int z1=0;z1<len;z1++)
					     {
						char ch3=str2.charAt(z1);
						if(ch3=='{')	
						  {	//System.out.println(ch3);
							//System.out.println("< Found");
							for(int x1=z1+1;x1<len;x1++)
							{
								char ch2=str2.charAt(x1);
								if(ch2!='}')
								{ 
								//System.out.println(ch2);			
								str4=str4+ch2;
								}
								else
								{ break; }
																

							}
							
						  }	
					
					     }
					    System.out.println("Password="+str4);		
					    try{
						
						FileReader rt=new FileReader(str33+"/password.txt");
						JTextField jt=new JTextField();
						jt.read(rt,null);
						rt.close();

						if(jt.getText().equals(str4) || jt.getText()==str4)
						  {
						  System.out.println("User name & Password Match");
						  System.out.println("Server send the user info to the Client");	

						  rt1=new FileReader(str33+"/First name.txt");
						  jt1=new JTextField();
						  jt1.read(rt1,null);
						  send=send+"<f>"+jt1.getText()+"</f>";	
						  rt1.close();	

						   rt1=new FileReader(str33+"/last name.txt");
						  jt1=new JTextField();
						  jt1.read(rt1,null);
						  send=send+"<l>"+jt1.getText()+"</l>";	
						  rt1.close();	

						    rt1=new FileReader(str33+"/date.txt");
						  jt1=new JTextField();
						  jt1.read(rt1,null);
						  send=send+"<d>"+jt1.getText()+"</d>";	
						  rt1.close();	
						
						  rt1=new FileReader(str33+"/month.txt");
						  jt1=new JTextField();
						  jt1.read(rt1,null);
						  send=send+"<m>"+jt1.getText()+"</m>";	
						  rt1.close();

						  
						  rt1=new FileReader(str33+"/email.txt");
						  jt1=new JTextField();
						  jt1.read(rt1,null);
						  send=send+"<e>"+jt1.getText()+"</e>";	
						  rt1.close();	

						  rt1=new FileReader(str33+"/City.txt");
						  jt1=new JTextField();
						  jt1.read(rt1,null);
						  send=send+"<c>"+jt1.getText()+"</c>";	
						  rt1.close();	

						  rt1=new FileReader(str33+"/contry.txt");
						  jt1=new JTextField();
						  jt1.read(rt1,null);
						  send=send+"<co>"+jt1.getText()+"</co>";	
						  rt1.close();	
		
						  rt1=new FileReader(str33+"/Collage.txt");
						  jt1=new JTextField();
						  jt1.read(rt1,null);
						  send=send+"<col>"+jt1.getText()+"</col>";	
						  rt1.close();			
							
						  rt1=new FileReader(str33+"/about.txt");
						  jt1=new JTextField();
						  jt1.read(rt1,null);
						  send=send+"<z>"+jt1.getText()+"</z>";	
						  rt1.close();	

						   	
						  FileReader rt3=new FileReader(str33+"/scrap/pointer.dat");
						  JTextField jt3=new JTextField();
						  jt3.read(rt3,null);
						  int count=Integer.parseInt(jt3.getText());
						  rt3.close();
						  send=send+"<sr>"+count+"</sr>";	

						  for(int d=0;d<count;d++)
							{
							 rt1=new FileReader(str33+"/scrap/"+d+".txt");
						 	 jt1=new JTextField();
						 	 jt1.read(rt1,null);
						 	 send=send+"<sr"+d+">"+jt1.getText()+"</sr"+d+">";	
						 	 rt1.close();
							
							 rt1=new FileReader(str33+"/scrap/"+d+".user");
						 	 jt1=new JTextField();
						 	 jt1.read(rt1,null);
						 	 send=send+"<u"+d+">"+jt1.getText()+"</u"+d+">";	
						 	 rt1.close();			

							} 

							FileReader rt31=new FileReader(str33+"/friends/pointer.dat");
						        JTextField jt31=new JTextField();
						        jt31.read(rt31,null);
						        int count1=Integer.parseInt(jt31.getText());
						         rt31.close();
							  send=send+"<fr>"+count1+"</fr>";
						  for(int d1=0;d1<count;d1++)
							{
							rt1=new FileReader(str33+"/friends/"+d1+".txt");
						 	 jt1=new JTextField();
						 	 jt1.read(rt1,null);
						 	 send=send+"<fr"+d1+">"+jt1.getText()+"</fr"+d1+">"+"\r\n";	
						 	 rt1.close();		

							} 
							System.out.println("Want to Send Data...<y>");
							
							wr1.write(send);
							wr1.flush();
							System.out.println("Data Will be send...");
						  }	
						  else{
							
						    System.out.println("User will Enter Incorrect Password");
						    System.out.println("Block the user?<y/n>");
						    System.out.println("Client is diconnected");
						    wr1.write("End");
						    wr1.flush();			
						   }		
					
						}catch(Exception gt){System.out.println(gt);}	
					
					break;
				}
				else if(cg=='$'){

				String sender="";
				String Reciever="";
				String Message="";

				str33="";
				int len=str2.length();
					for(int z=0;z<len;z++)
					     {
						char ch3=str2.charAt(z);
						if(ch3=='<')	
						  {	//System.out.println(ch3);
							//System.out.println("< Found");
							for(int x=z+1;x<len;x++)
							{
								char ch2=str2.charAt(x);
								if(ch2!='>')
								{ 
								//System.out.println(ch2);			
								str33=str33+ch2;
								}
								else
								{ break; }
															

							}
							
						  }	
					
					     }
					   sender=str33;	
					   System.out.println("Sender="+str33);

					  str33="";
					   for(int z=0;z<len;z++)
					     {
						char ch3=str2.charAt(z);
						if(ch3=='{')	
						  {	//System.out.println(ch3);
							//System.out.println("< Found");
							for(int x=z+1;x<len;x++)
							{
								char ch2=str2.charAt(x);
								if(ch2!='}')
								{ 
								//System.out.println(ch2);			
								str33=str33+ch2;
								}
								else
								{ break; }
															

							}
							
						  }	
					
					     }
					   Reciever=str33;
					   System.out.println("Reciever="+str33);
					
					  str33="";	
					   for(int z=0;z<len;z++)
					     {
						char ch3=str2.charAt(z);
						if(ch3=='@')	
						  {	//System.out.println(ch3);
							//System.out.println("< Found");
							for(int x=z+1;x<len;x++)
							{
								char ch2=str2.charAt(x);
								if(ch2!='%')
								{ 
								//System.out.println(ch2);			
								str33=str33+ch2;
								}
								else
								{ break; }
															

							}
							
						  }	
					
					     }
					   Message=str33;
					   System.out.println("Message="+str33);

					   try{
					    FileReader r=new FileReader(Reciever+"/scrap/pointer.dat");
					    JTextField t2=new JTextField();
					    t2.read(r,null);
					    int c=Integer.parseInt(t2.getText());
					    r.close();
					
					    FileWriter w=new FileWriter(Reciever+"/scrap/"+c+".txt");
					    	
					    w.write(Message+(new Date()));
					    w.close();
						
					     FileWriter w1=new FileWriter(Reciever+"/scrap/"+c+".user");
					    	
					    w1.write(sender+"");
					    w1.close();  			


					    c=c+1;

					     FileWriter w2=new FileWriter(Reciever+"/scrap/pointer.dat");
					    	
					    w2.write(c+"");
					    w2.close();
	
					    System.out.println("Message Send to Reciever Sucessfully !!!");  
					    }catch(Exception f4){System.out.println(f4); }			
					   	

					   break;  
				  

				}

			break;	
	            }catch(ArrayIndexOutOfBoundsException fr){System.out.println(fr);}
		   break;	
		}	

}catch(Exception gt){System.out.println(gt);}
}
public static void main(String args[])
	{
	Servermain1 s=new Servermain1(1200);
	s.setVisible(true);
	s.setSize(315,430);
	s.setLocation(150,20);
}
}                                  