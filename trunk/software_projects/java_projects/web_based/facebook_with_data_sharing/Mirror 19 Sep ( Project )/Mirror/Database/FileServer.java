import java.net.*;
import java.io.*;

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



public class FileServer {
  public static void main (String [] args ) throws IOException {
    // create socket
    ServerSocket servsock = new ServerSocket(1202);
    String output="";	
 

    while (true) {
      System.out.println("\n\n\n\n\n\n\n\n\n\n\n"+"   Welcome To Mirror Data Shearing Server");
      System.out.println("****************************************** ")	;	
      System.out.println(" Waiting For Client... ");
      output="\r\r\r"+"   Welcome To Mirror Data Shearing Server"+"\r *************************************************** ";	
	
      FileReader rj=new FileReader("Shrearing Data Summery.txt");
      JTextField jtb=new JTextField();	
      jtb.read(rj,null);
      rj.close();
      output=jtb.getText()+"\r\r"+output;	

     
   		 		

      Socket sock = servsock.accept();
      System.out.println("Accepted connection : " + sock);
      output=output+"\r\n"+sock;		

      BufferedReader br=new BufferedReader(new InputStreamReader(sock.getInputStream()));
      PrintWriter wr=new PrintWriter(new OutputStreamWriter(sock.getOutputStream()));
	
      	
      String lsg=br.readLine();
      char ch=	lsg.charAt(0);
     System.out.println("Char="+ch);	
      System.out.println("My Command="+lsg);
	output=output+"\r User Command"+lsg;

     

      if(ch=='@')
      {
       try{				
      		File f=new File("Download/*.*");
      		String parent=f.getParent();
      		File f2=new File(parent);

		      String str4[]=f2.list();	
      
      		        for(int z=0;z<str4.length;z++)
      			{			
      			wr.write(str4[z]+"\r\n");	
       			//System.out.println(str4[z]); 
			
      			wr.flush();	
			}
			
			br.close();
			wr.close();
	  }catch(Exception hy){System.err.println(hy);}			      					
      }	


	try{
	   if(ch=='*')
     		 {

		try{				
      		File f=new File("Mp3/*.*");
      		String parent=f.getParent();
      		File f2=new File(parent);

		      String str4[]=f2.list();	
      
      		        for(int z=0;z<str4.length;z++)
      			{			
      			wr.write(str4[z]+"\r\n");	
       			//System.out.println(str4[z]);
				 	
      			wr.flush();	
			}
			
			br.close();
			wr.close();
	              }catch(Exception hy){System.err.println(hy);}	



		}	
	   


	    }catch(Exception hy){}	

	   try{
	   if(ch=='^')
     		 {

		try{				
      		File f=new File("Videos/*.*");
      		String parent=f.getParent();
      		File f2=new File(parent);

		      String str4[]=f2.list();	
      
      		        for(int z=0;z<str4.length;z++)
      			{			
      			wr.write(str4[z]+"\r\n");	
       			//System.out.println(str4[z]); 
				
      			wr.flush();	
			}
			
			br.close();
			wr.close();
	              }catch(Exception hy){System.err.println(hy);}	



		}	
	   


	    }catch(Exception hy){}	



      try{
      if(ch=='%')
      {		
      // sendfile
	
	 System.out.println("User want To Receive ?Data");
	 String msg2="";

         int len2=lsg.length();
         for(int k=1;k<len2;k++)
	 {	
           msg2=msg2+lsg.charAt(k);
	 }
		output=output+"\r"+msg2;
	    System.out.println("File Name"+msg2);
	   String fname="";
			    
  	    File f4=new File("Mp3/"+msg2);
	    if(f4.isFile() && f4.exists())
	    {
		fname="Mp3/"+msg2;	
	    }	
	     File f41=new File("Download/"+msg2);
	    if(f41.isFile() && f41.exists())
	    {
		fname="Download/"+msg2;	
	    }
	     File f42=new File("Videos/"+msg2);
	    if(f42.isFile() && f42.exists())
	    {
		fname="Videos/"+msg2;	
	    }					
					
            File myFile = new File (fname);
	    
		
	    System.out.println("File Found in "+fname);	
            byte [] mybytearray  = new byte [(int)myFile.length()];
            FileInputStream fis = new FileInputStream(myFile);
            BufferedInputStream bis = new BufferedInputStream(fis);
            bis.read(mybytearray,0,mybytearray.length);
            OutputStream os = sock.getOutputStream();
            System.out.println("Sending...");
            os.write(mybytearray,0,mybytearray.length);
            os.flush();
            sock.close();
	    output=output+"\r"+"Data Send Sucessfully";		
	   System.out.println("Data Send Sucessfully");	
        }

	}catch(Exception gt){ System.out.println(gt); }

	try{
	if(ch=='$')
	{
	

	 String msg2="";
	 System.out.println("Command for Getting dta from client");
	  
         int len2=lsg.length();
         for(int k=1;k<len2;k++)
	{	
          msg2=msg2+lsg.charAt(k);
	}
	output=output+"\r"+msg2;
				String fileStore="";
	   			int i = msg2.lastIndexOf('.');
				if( msg2.substring(i+1).toLowerCase().equals("mp3") || msg2.substring(i+1).toLowerCase().equals("wav") ||msg2.substring(i+1).toLowerCase().equals("mp2") || msg2.substring(i+1).toLowerCase().equals("mkv"))
				{
				fileStore="Mp3/";
				} 
				else if( msg2.substring(i+1).toLowerCase().equals("exe") || msg2.substring(i+1).toLowerCase().equals("msi") ||msg2.substring(i+1).toLowerCase().equals("rar") || msg2.substring(i+1).toLowerCase().equals("zip") ||  msg2.substring(i+1).toLowerCase().equals("iso"))
				{
				fileStore="Download/";

				}
				else if( msg2.substring(i+1).toLowerCase().equals("avi") || msg2.substring(i+1).toLowerCase().equals("mpeg") ||msg2.substring(i+1).toLowerCase().equals("3gp") || msg2.substring(i+1).toLowerCase().equals("flv"))
	    			{
				 fileStore="Videos/";
				}
				
			
	   long start = System.currentTimeMillis();
           int bytesRead;
           int current = 0;
	   int filesize=60022386;

	     byte [] mybytearray  = new byte [filesize];
  	     InputStream is = sock.getInputStream();
   	     FileOutputStream fos = new FileOutputStream(fileStore+msg2);
             BufferedOutputStream bos = new BufferedOutputStream(fos);
             bytesRead = is.read(mybytearray,0,mybytearray.length);
             current = bytesRead;

        // thanks to A. Cádiz for the bug fix
        do {
             bytesRead =
                        is.read(mybytearray, current, (mybytearray.length-current));
                if(bytesRead >= 0) current += bytesRead;
            } while(bytesRead > -1);

         bos.write(mybytearray, 0 , current);
         bos.flush();
         long end = System.currentTimeMillis();
         System.out.println(end-start);

                double time=(end-start)/1000;

	         File fg=new File(fileStore+msg2);
		 double leng=fg.length();
		  leng=leng/1024;
		      
		 if(leng>=1024)
		 {
		  double t=leng/1024;
	 	  float h=(float)t;	  	
	           System.out.println("Size="+t +" Mb");  
		   	
		 }
		 else{
			long  b=(long)leng;
			 System.out.println("Size="+b +" Kb");
			   
		    }
		 double speed=leng/time;
		
		 //System.out.println("Size="+leng +" Kb");  
		 if(speed>=1024)
		 {
		
		 speed=speed/1024;
		 float g=(float)speed; 
		  System.out.println("Speed="+g +" Mbps");
		
		 }
		 else{
		  long speed1=(long)speed;
		System.out.println("Speed="+speed +" Kbps");
		

		}	


	 output=output+"\r"+"Getting Data Sucessfully";
	  System.out.println("Getting Data Sucessfully...");
          bos.close();
          sock.close();
	
	

	
	}
	}catch(Exception fr){System.out.println(fr); }
	 try{	
       FileWriter wwe=new FileWriter("Shrearing Data Summery.txt");		
       wwe.write(output+"\r\r\r");
       wwe.close();		
      
	}catch(Exception gt){System.out.println(gt);}
	
    }
}
}
                                       