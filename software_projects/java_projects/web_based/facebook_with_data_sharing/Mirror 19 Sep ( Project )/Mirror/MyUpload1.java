import java.net.*;
import java.io.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JApplet;
import javax.swing.JButton;
import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.io.File.*;
 import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.io.File.*;
import java.io.*;
import java.net.*;



class MyUpload1 extends JFrame
{
JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b18,b16,b17,b19;
JList le1,le2,le3,le4;
JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14;
JPanel j1,j2,j4,j3,j5,j6,j7;
JTextField  t1,t2,t3,t4,t5;
FileDialog fd1,fd2,fd3;
JToolBar jt;
DefaultListModel model1,model2,model3;
String list[];
ImageIcon i1,i2,i3,i4,i5;
String filename="",dirname="";
JProgressBar pg1;

JLabel q1,q2,q3,q4;

MyUpload1(){
super("Mirror Data Shearing");

Container cp=getContentPane();
cp.setLayout(null);


try

		{

			UIManager.setLookAndFeel ("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");

		}

		catch(Exception e)
		{}

j3=new JPanel(null,true);
i1=new ImageIcon("ico/green.gif");
l5=new JLabel(i1);
l5.setBounds(40,03,10,10);
j3.add(l5);


l4=new JLabel("Server Status");

l4.setBounds(60,0,200,20);
j3.add(l4);

j3.setBounds(0,500,600,20);
cp.add(j3);


try{


}catch(Exception fr){
l4.setText("Unknown Server");
}







jt=new JToolBar();
jt.setSize(450,50);
jt.setLocation(0,0);
jt.setVisible(true);



j1=new JPanel(null,true);

l1=new JLabel("File ");
l1.setBounds(10,20,100,30);
j1.add(l1);

t1=new JTextField();
t1.setBounds(40,20,300,30);
j1.add(t1);

b1=new JButton("Browse");
b1.setBounds(350,20,100,30);
j1.add(b1);

b2=new JButton("Upload File");
b2.setBounds(10,60,150,30);
j1.add(b2);


b6=new JButton("Refresh");
b6.setBounds(190,60,150,30);
j1.add(b6);

l13=new JLabel();
l13.setBounds(360,60,150,30);
j1.add(l13);

j1.setBounds(0,50,550,100);
cp.add(j1);


j1.setBorder(
      BorderFactory.createCompoundBorder(
        BorderFactory.createTitledBorder("Upload File"),
        BorderFactory.createEmptyBorder(0,0,5,5)));

j2=new JPanel(null,true);
model1=new DefaultListModel();
le1=new JList(model1);

int h=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS;
int v=ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS;

JScrollPane jsp=new JScrollPane(le1,v,h);
jsp.setBounds(10,20,350,250);
j2.add(jsp);

t3=new JTextField();
t3.setBounds(30,290,300,30);
j2.add(t3);

try{
FileReader rt=new FileReader("Save.txt");
JTextField hy=new JTextField();
hy.read(rt,null);
t3.setText(hy.getText());
rt.close();
}catch(Exception dr){ t3.setText("C:/"); }

b5=new JButton("Output File");
b5.setBounds(340,290,100,30);
j2.add(b5);

q1=new JLabel();
q1.setBounds(20,330,150,20);
j2.add(q1);

q2=new JLabel();
q2.setBounds(170,330,200,20);
j2.add(q2);

q3=new JLabel();
q3.setBounds(370,330,160,20);
j2.add(q3);


ImageIcon zwq=new ImageIcon("ico/ico_alpha_NetConnections_32x32.png");
b16=new JButton("Download",zwq);
b16.setBounds(420,30,100,30);
j2.add(b16);

ImageIcon zw=new ImageIcon("ico/ico_alpha_Software_16x16.png");
b17=new JButton("Software",zw);
b17.setBounds(420,70,100,30);
j2.add(b17);

ImageIcon z5=new ImageIcon("ico/ico_alpha_2_16x16.png");
b18=new JButton("Mp3",z5);
b18.setBounds(420,110,100,30);
j2.add(b18);



ImageIcon z=new ImageIcon("ico/ico_alpha_3_16x16.png");
b19=new JButton("Videos",z);
b19.setBounds(420,150,100,30);
j2.add(b19);

JPanel j6=new JPanel(null,true);
j6.setBounds(365,200,180,50);
pg1=new JProgressBar();
pg1.setBounds(9,15,160,25);
j6.add(pg1);

j6.setBorder(
      BorderFactory.createCompoundBorder(
        BorderFactory.createTitledBorder("Progress"),
        BorderFactory.createEmptyBorder(0,0,5,5)));


j2.add(j6);


j4=new JPanel(null,true);

ImageIcon iu=new ImageIcon("ico/3.png");
l12=new JLabel(iu);
l12.setBounds(30,0,82,80);
j4.add(l12);
 
l11=new JLabel("Mirror Client Server Data Shearing");
Color r=new Color(100,195,133);
l11.setForeground(r);
Font f=new Font("Arial",Font.BOLD,14);
l11.setFont(f);
l11.setBounds(130,10,300,30);
j4.add(l11);

j4.setBounds(0,0,550,50);
j4.setBackground(Color.black);
cp.add(j4);




j2.setBounds(0,150,550,350);
cp.add(j2);


j2.setBorder(
      BorderFactory.createCompoundBorder(
        BorderFactory.createTitledBorder("Download File"),
        BorderFactory.createEmptyBorder(0,0,5,5)));

try{
		 Socket sock = new Socket("",1202);
   		 System.out.println("Connecting...");
		 System.out.println("Socket info: "+sock);
		 l4.setText("Connected To Server          (Pravin H. Rane)");
		 PrintWriter wr=new PrintWriter(new OutputStreamWriter(sock.getOutputStream()));
		String hy="@"+"\r\n";
		 wr.write(hy+"\r\n");
		System.out.println(hy+"");
		
		 wr.flush();

		BufferedReader br=new BufferedReader(new InputStreamReader(sock.getInputStream()));
		String msg3="";
		
		while( (msg3=br.readLine())!=null || (msg3=br.readLine())=="End")
		{	
		// System.out.println(msg3);
		 if(!msg3.equals("End") || msg3!="End" )
		   {		
		  model1.addElement(msg3);
		  //System.out.println("Added");
		   }
		else
		{
		break;
		}	
		}
		sock.close();

}catch(Exception gt){ l4.setText("Server Down             (Pravin H. Rane)");
l5.setVisible(false); 
i2=new ImageIcon("ico/red.gif");
l6=new JLabel(i2);
l6.setBounds(40,03,10,10);
j3.add(l6);}


//ActionListener

		b1.addActionListener(new ActionListener()
		{
		public void actionPerformed(ActionEvent e)
		{
		JFrame jf=new JFrame();
		fd1=new FileDialog(jf,"Select File To Upload");
		fd1.setVisible(true);
		
		String Dir=fd1.getDirectory();
		String file=fd1.getFile();
		t1.setText(Dir+file);
		filename=file;	
		dirname=Dir;	

		}
		});

		b2.addActionListener(new ActionListener()
		{
		public void actionPerformed(ActionEvent e)
		{

		try{
		    Socket sock = new Socket("",1202);
   		     System.out.println("Connecting...");
		     System.out.println("Socket info: "+sock);

		int filesize=99999999; //6022386  filesize temporary hardcoded

   		  long start = System.currentTimeMillis();
  		  int bytesRead;
  		  int current = 0;

    		// localhost for testing
    		 

		 BufferedReader br=new BufferedReader(new InputStreamReader(sock.getInputStream()));
		 PrintWriter wr=new PrintWriter(new OutputStreamWriter(sock.getOutputStream()));

		 String msg="";
		 msg="$"+filename+"\r\n";
		 wr.write(msg+"\r\n");
		 wr.flush();
		 System.out.println("File Name Send");	
		
		  	

		  

		  File myFile = new File (dirname+filename);
     		  byte [] mybytearray  = new byte [(int)myFile.length()];
    		  FileInputStream fis = new FileInputStream(myFile);
    		  BufferedInputStream bis = new BufferedInputStream(fis);
     		  bis.read(mybytearray,0,mybytearray.length);
     		  OutputStream os = sock.getOutputStream();
      		 System.out.println("Sending...");
     		 os.write(mybytearray,0,mybytearray.length);
    		  os.flush();
		 l13.setText("Sending Data sucessfully!!!");	
		 System.out.println("Sending Data sucessfully!!!");
     		 sock.close();

		}catch(Exception fr){ System.out.println(fr);}
		

		}});

		b16.addActionListener(new ActionListener()
		{
		public void actionPerformed(ActionEvent e)
		{
		try{
		
		 pg1.setValue(0);
		
	  	 double start = System.currentTimeMillis();
          	 int bytesRead;
          	 int current = 0;
	  	 int filesize=60022386; //6022386
		 String msg="";

		  Socket sock = new Socket("",1202);

		int ad=le1.getSelectedIndex();
		String str=(String)model1.getElementAt(ad);
		System.out.println("File NAme"+str);

		BufferedReader br=new BufferedReader(new InputStreamReader(sock.getInputStream()));
		PrintWriter wr=new PrintWriter(new OutputStreamWriter(sock.getOutputStream()));
		
		msg="%"+str+"\r\n";
		wr.write(msg+"\r\n");
		wr.flush();

	    
	     	

	     byte [] mybytearray  = new byte [filesize];
  	     InputStream is = sock.getInputStream();
   	     FileOutputStream fos = new FileOutputStream( t3.getText()+str );
             BufferedOutputStream bos = new BufferedOutputStream(fos);
             bytesRead = is.read(mybytearray,0,mybytearray.length);
	     System.out.println("Total="+bytesRead);	
	    // pg1.setMaximum(bytesRead);	
             current = bytesRead;
	     int d=0;	
        // thanks to A. Cádiz for the bug fix
          do {
             bytesRead =
                        is.read(mybytearray, current, (mybytearray.length-current));
                if(bytesRead > -1)
		 { 
		   //System.out.println("Recieve="+bytesRead); 
		   pg1.setValue(d);
		   d=d+2;	
		   current += bytesRead;
		  
		 }
            } while(bytesRead >-1);

		 pg1.setValue(100);
        	 bos.write(mybytearray, 0 , current);
        	 bos.flush();

        	 double end = System.currentTimeMillis();
         	 System.out.println(((end-start)/1000)+"Sec");

		 double time=((end-start)/1000);
		 float k=(float)time;
		 q3.setText("Time Required="+k+" Sec.");

		 File fg=new File(t3.getText()+str);
		 double leng=fg.length();
		  leng=leng/1024;
		      
		 if(leng>=1024)
		 {
		  double t=leng/1024;
	 	  float h=(float)t;	  	
	           //System.out.println("Size="+t +" Mb");  
		   q1.setText("File Size="+h+" MB");	
		 }
		 else{
			long  b=(long)leng;
			 //System.out.println("Size="+b +" Kb");
			 q1.setText("File Size="+b+" Kb");  
		    }
		 double speed=leng/time;
		
		 //System.out.println("Size="+leng +" Kb");  
		 if(speed>=1024)
		 {
		
		 speed=speed/1024;
		 float g=(float)speed; 
		  //System.out.println("Speed="+g +" Mbps");
		  q2.setText("Download speed="+g+" Mbps");	
		 }
		 else{
		  long speed1=(long)speed;
		 //System.out.println("Speed="+speed +" Kbps");
		 q2.setText("Download speed="+speed1+" Kbps");

		}	
		
	

	 	 System.out.println("Getting Data Sucessfully");

         	 bos.close();
         	 sock.close();

     		

	     
		
		}catch(Exception fr){System.out.println(fr); }
		}
		}); 	

		b18.addActionListener(new ActionListener()
		{
		public void actionPerformed(ActionEvent e)
		{
		try{
		 Socket sock = new Socket("",1202);
		 BufferedReader br=new BufferedReader(new InputStreamReader(sock.getInputStream()));
		 PrintWriter wr=new PrintWriter(new OutputStreamWriter(sock.getOutputStream()));
		
		  String msg="*";
		  wr.write(msg+"\n\r");
		
		  wr.flush();	
		String msg3="";
		model1.removeAllElements(); 

		 while( (msg3=br.readLine())!=null || (msg3=br.readLine())=="End")
		  {	
		     //System.out.println(msg3);
		      if(!msg3.equals("End") || msg3!="End" )
		        {		
		         model1.addElement(msg3);
		         // System.out.println("Added");
		         }
		     else
		        {
		       break;
		        }	
		}
		sock.close();		
	
		}catch(Exception gt){ }
		}
		});

		b19.addActionListener(new ActionListener()
		{
		public void actionPerformed(ActionEvent e)
		{
		try{
		 Socket sock = new Socket("",1202);
		 BufferedReader br=new BufferedReader(new InputStreamReader(sock.getInputStream()));
		 PrintWriter wr=new PrintWriter(new OutputStreamWriter(sock.getOutputStream()));
		
		  String msg="^";
		  wr.write(msg+"\n\r");
		
		wr.flush();	
		String msg3="";
		model1.removeAllElements(); 

		 while( (msg3=br.readLine())!=null || (msg3=br.readLine())=="End")
		  {	
		    // System.out.println(msg3);
		      if(!msg3.equals("End") || msg3!="End" )
		        {	
			
				
		         model1.addElement(msg3);
		          //System.out.println("Added");
		         }
		     else
		        {
		       break;
		        }	
		}
		sock.close();		
	
		}catch(Exception gt){ }
		}
		});

		b17.addActionListener(new ActionListener()
		{
		public void actionPerformed(ActionEvent e)
		{
		MyUpload1 uk=new MyUpload1();
		setVisible(false);
		uk.setVisible(true);
		uk.setSize(560,560);	
		}
		});

		b6.addActionListener(new ActionListener()
		{
		public void actionPerformed(ActionEvent e)
		{
		MyUpload1 uk=new MyUpload1();
		setVisible(false);
		uk.setVisible(true);
		uk.setSize(560,560);	
		}
		});

		b5.addActionListener(new ActionListener()
		{
		public void actionPerformed(ActionEvent e)
		{
		JFrame jf=new JFrame();
		fd1=new FileDialog(jf,"Select File To Upload");
		fd1.setMode(FileDialog.SAVE);
		fd1.setFile("Save Here");
		fd1.setVisible(true);
		
		String Dir=fd1.getDirectory();
		String file=fd1.getFile();
		t3.setText(Dir);
		try{
		FileWriter w=new FileWriter("Save.txt");
		w.write(Dir);
		w.close();
	
		}catch(Exception fr){}


		}
		});



//End
 

}

public static void main(String args[])
{
MyUpload1 uk=new MyUpload1();
uk.setVisible(true);
uk.setSize(560,560);
}

}



