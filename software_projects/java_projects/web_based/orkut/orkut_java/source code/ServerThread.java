//package ksm.mulitiserver;

import java.io.*;
import java.net.*;
import java.sql.*;


public class ServerThread extends Thread
{

	public Socket Client;
	public int ID;

	public ServerThread()
	{

	}

	public ServerThread(Socket stemp,int id)
	{
		try
		{
			Client=stemp;
			ID=id;
		}
		catch(Exception e)
		{
			//System.out.println(e);
		}
		this.start();

	}

	public void run()
	{
		Processing();

	}
		public void Processing()
	{
		try
		{
			BufferedReader br;
			BufferedWriter bw;

			//String strmsg;

			br=new BufferedReader(new InputStreamReader(Client.getInputStream()));
			bw=new BufferedWriter(new OutputStreamWriter(Client.getOutputStream()));

		    String strquerytext="";
			String strresult="";
			String str="";
		
		 int charsread = Integer.parseInt(br.readLine());
		   	//System.out.println("charsread="+charsread);
		   
		   	char [] chars=new char [charsread];
			 
			br.read(chars);
					
			strquerytext= String.valueOf(chars);
			        
			
		  	strquerytext=	strquerytext.trim();
		
			String strres=strquerytext.substring(0,5);
				
			
				int length=strquerytext.length();
		     	//System.out.println("before text length = "+length);
		     	String usname=new String();
		     	String scrap = new String();
	  		
			if(strres.equals("filin")||strres.equals("delet")||strres.equals("phtin")||strres.equals("phoin"))	
			  { 
			    int i=5;
				char c;
			
				while((i<length) && (c=strquerytext.charAt(i))!='*') 
				   { 
				     usname=usname+c;
				   	  i++;
				   	}
			
               
                
                scrap =strquerytext.substring(i+1,length);
                
              
               
               }
              
               else  
              
              usname=strquerytext.substring(5,length);
              
              
              
             
			  usname=usname.trim();
			
			 //System.out.println("in server"+strres);
			 
	
	
		//************************************************************************	 
			 
			 
			 
			 
			  //next if else ladder starts
				
				
				if(strres.equals("frien")||strres.equals("seefr")||strres.equals("addas")||strres.equals("chkfr"))
	  		  { 
	  		  //String username=strquerytext.substring(5,length);
	  		   
	  		   try{
                               
                    String str1=new String();
                    FileReader fis=new FileReader("c:/orkut_java/friends/"+usname+".txt");
			      
                    char[] buffer = new char[100];
                    
                    while ( fis.read(buffer) > 0)
                    { 
                      str1=str1+String.valueOf(buffer);
                     }
                     str1=str1.trim();
                     //System.out.println(str1);
                    
                             bw.write(str1);
	  		             bw.flush();  
	  		    
	  		        } 
                                
                       catch(Exception e) 
                       {
                       	 //System.out.println(e);
                         
                       }
                       
	  		 
	  		     }
	  		     
	  		      else if(strres.equals("noscr"))
	  		      { 
	  		             FileReader fr1 = new FileReader("c:/orkut_java/scrapbook/"+usname+".txt");
                         BufferedReader br1 = new BufferedReader(fr1);
       				   
       				   
       				     bw.write(br1.readLine());
	  		             bw.flush();  	
	  		                
			 
	  		      }
	  		  
	  		  else if(strres.equals("#####"))
	  		     { //#=add req pending 
	  		      //* waiting to accept
	  		      // String st=br.readLine();
	  		      
	  		       int c=strquerytext.indexOf("*",5);
			       String cur=strquerytext.substring(5,c);
			       String view=strquerytext.substring(c+1,strquerytext.length());
	  		       //System.out.println("#####cur="+cur+"######view="+view);
	  		       
	  		       FileWriter f=new FileWriter( "c:/orkut_java/friends/"+cur+".txt",true);
	  		       f.write(view+"*");
	  		       f.close();
	  		       FileWriter f1=new FileWriter( "c:/orkut_java/friends/"+view+".txt",true);
	  		       f1.write(cur+"#");
	  		       f1.close();
	  		       
	  		     }
	  		else 
	  		if(strres.equals("addco"))  //accept or reject
	  		       {  char flag='*';
	  		       int c=strquerytext.indexOf("*",5);
	  		       
	  		       if(c==-1)
	  		       { c=strquerytext.indexOf("@",5);
	  		         flag='@';
	  		       }
	  		      	
	  		       //System.out.println("flag=88888"+flag);
	  		        //*=ans is yes
	  		       //@ =ans is no
			       String cur=strquerytext.substring(5,c);
			       String view=strquerytext.substring(c+1,strquerytext.length());
			       String str1=new String();//cur
			       String str2=new String();//view
                    FileReader f=new FileReader("c:/orkut_java/friends/"+cur+".txt");
			      
                    char[] buffer = new char[100];
                    
                    while ( f.read(buffer) > 0)
                     { 
                      str1=str1+String.valueOf(buffer);
                     }
                     str1=str1.trim();
                     f.close();
                     FileReader f1=new FileReader("c:/orkut_java/friends/"+view+".txt");
			      
                    char[] buffer1 = new char[100];
                    
                    while ( f1.read(buffer1) > 0)
                     { 
                      str2=str2+String.valueOf(buffer1);
                     }
                     str2=str2.trim();
                     f1.close();
                      //System.out.println("88888before replace mah "+str1+"88888har"+str2);
                     int index;
                     if(flag=='*')
                       {//index=str1.indexOf(view+"#");
                        //int charrep=index+view.length();
                        //System.out.println("before replace  "+str1);
                        str1=str1.replace(view+"#",view+"$");
                        FileWriter f11=new FileWriter( "c:/orkut_java/friends/"+cur+".txt");
                        //System.out.println("in mahendra  "+str1);
                        f11.write(str1);
                        f11.close();
                        ///index=str1.indexOf(cur+"*");
                        //charrep=index+view.length();
                        str2= str2.replace(cur+"*",cur+"$");
                        FileWriter f111=new FileWriter( "c:/orkut_java/friends/"+view+".txt");
                        //System.out.println("in harshad  "+str2);
                        f111.write(str2);
                        f111.close();
                        
                       }
                      else
                       {
                       	
                        str1=str1.replace(view+"#","");
                        FileWriter f2=new FileWriter( "c:/orkut_java/friends/"+cur+".txt");
                        f2.write(str1);
                        f2.close();
                        
                        str2=str2.replace(cur+"*","");
                        FileWriter f222=new FileWriter( "c:/orkut_java/friends/"+view+".txt");
                        f222.write(str2);
                        f222.close();
                        
                       } 
                     
			       
	  		      }	
	  		else  
	  		if( strres.equals("photo")) 			
	  			
	  		            {  //System.out.println("*******");
	  		            
	  		                FileInputStream fis=new FileInputStream("c:/orkut_java/dataphoto/"+usname+".jpg");
			                OutputStream out = Client.getOutputStream();
                            byte[] buffer = new byte[8192];
                            int bytesRead;
                            while ((bytesRead = fis.read(buffer)) > 0) {
                            out.write(buffer, 0, bytesRead);
                            }
                            out.flush(); // Very important
                            fis.close(); // Also very important
	  		            }		 
		
			
		else	if(strres.equals("phtin"))
			{ 
			      try{
			      
			      char c;
   
                   int len=scrap.length();
                      
                    int  j=-1;


            FileOutputStream  fout = new FileOutputStream("c:/orkut_java/dataphoto/"+usname+".jpg");
              while(j<len)
               {  
                   j++;
   				   String stri="";
   				
   				for(;j<len && ((c=scrap.charAt(j))!='\n');j++)
    				
    				{ stri=stri+c;
    				}
   
    			   fout.write(Integer.parseInt(stri));
    			   fout.flush();
				}
			
			  fout.close();
			  }
			  catch(Exception ex)
			  { 
			    //System.out.println("In phtin"+ex);
			    
			  }
			}
			
		   else	if(strres.equals("scrap"))
			  {
			  //	//System.out.println(strres);
			   FileInputStream fis=new FileInputStream("c:/orkut_java/scrapbook/"+usname+".txt");
			      OutputStream out = Client.getOutputStream();
                   byte[] buffer = new byte[8192];
                  int bytesRead;
                  while ((bytesRead = fis.read(buffer)) > 0) {
                   out.write(buffer, 0, bytesRead);
                     }
                     out.flush(); // Very important
                     fis.close(); // Also very important
			  }

             else if(strres.equals("newus"))
             {  FileWriter f0=new FileWriter("c:/orkut_java/scrapbook/"+usname+".txt");
                 f0.write(""+0);
             	 f0.flush();
             	 f0.close();
             	 
             	 f0=new FileWriter("c:/orkut_java/friends/"+usname+".txt");
             	 f0.close();
             	 
             	 f0=new FileWriter("c:/orkut_java/dataphoto/"+usname+".jpg");
             	 f0.close();
             	 
             	}
             
             else if(strres.equals("phoin"))
             {
             	 //System.out.println("path in server is ="+scrap);
             	FileOutputStream fos=new FileOutputStream("c:/orkut_java/dataphoto/"+usname+".jpg");
                    InputStream in = Client.getInputStream();
                    byte[] buffer = new byte[8192];
                    int bytesRead;
                    while ((bytesRead = in.read(buffer)) > 0) 
                   {
                    fos.write(buffer, 0, bytesRead);
                   }
                     fos.flush(); // Very important
                     fos.close(); // Also very important
             }
             
             	else if(strres.equals("filin"))
            { 
                 
                 
                
                 FileReader fr1 = new FileReader ("c:/orkut_java/scrapbook/"+usname+".txt");
                    
                     
                     	BufferedReader br1= new BufferedReader(fr1);
                     	String scr=br1.readLine();
                       // //System.out.println("first line is ="+scr);
                     	byte [] buf1 = scr.getBytes();
                       // //System.out.println("bytes of no of scraps ="+buf1.length);
                     	br1.close();
                     	
                     	FileInputStream  in = new FileInputStream ("c:/orkut_java/scrapbook/"+usname+".txt");
                     	
                     	
                      in.read(buf1);
                     
                     
                     int n=in.available();
                   
                    byte[] buffer = new byte[n];
                    
                    
                    in.read(buffer);
                   
                   
                     
                     in.close();
                     FileOutputStream fos=new FileOutputStream("c:/orkut_java/scrapbook/"+usname+".txt");
                     
                     // //System.out.println("scrap ="+scrap);
                     byte buf[]= scrap.getBytes();
                     fos.write(buf);
                     fos.close();
                     fos=new FileOutputStream("c:/orkut_java/scrapbook/"+usname+".txt",true);
                     fos.write(buffer);
                     fos.flush();
                     fos.close();
                    // //System.out.println("in server"+usname);
           
            }
             
              else if(strres.equals("profi")) {} 
             
             
             else if(strres.equals("delet"))
             {
             	 
             	 int scrno=Integer.parseInt(scrap);
             	 
             	 
             	 //System.out.println("username is "+usname+" scrap no is "+scrno);
             	  
             	FileReader fr1=new FileReader("c:/orkut_java/scrapbook/"+usname+".txt");
             	BufferedReader br1 = new BufferedReader(fr1);
             	FileWriter fw1=new FileWriter("c:/orkut_java/scrapbook/"+usname+"temp.txt",true);
             	String tmp;
             	int scrpsno=Integer.parseInt(br1.readLine());
             
             	scrpsno--;
             	//System.out.println(" no of scraps become"+scrpsno);
             	if(scrpsno==0) { 
             	                    //System.out.println(" no of scraps become zero ");
             	                    fr1.close();
                                    br1.close();
                                    fw1.flush();
                                    fw1.close();
             	                   fw1=new FileWriter("c:/orkut_java/scrapbook/"+usname+".txt");
             	                   fw1.write(""+0);
             	                   fw1.close();
             	              } 
             	else{
             	
             	for(int i=0;i<scrno-1;)
             	{   tmp=br1.readLine();
             	    fw1.write(tmp+"\n");
             	   if(tmp.equals("~!@#$%"))
             	     i++;
             	}
             
              //just read scrap which is deleted ,not storing it
              do
               { 
                 tmp=br1.readLine();
                }
              while(tmp!=null && !tmp.equals("~!@#$%"));
             
              
              while((tmp=br1.readLine())!=null)
              { 
               fw1.write(tmp+"\n");
              }
              
              
              fr1.close();
              br1.close();
              fw1.flush();
              fw1.close();
             
               fr1=new FileReader("c:/orkut_java/scrapbook/"+usname+"temp.txt");
               fw1=new FileWriter("c:/orkut_java/scrapbook/"+usname+".txt");
               br1 = new BufferedReader(fr1);
               fw1.write(scrpsno+"\n") ;
               fw1.flush();
               fw1.close();
               fw1=new FileWriter("c:/orkut_java/scrapbook/"+usname+".txt",true);   
              while((tmp=br1.readLine())!=null)
              { 
               fw1.write(tmp+"\n");
              }
              
              fr1.close();
              br1.close();
              fw1.flush();
              fw1.close();
              File f= new File("c:/orkut_java/scrapbook/"+usname+"temp.txt");
              f.delete();
             
             }
             
             }
             else
             {
                                  
               
			//database handling
			//loads the driver
		    
              Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            
            // set this to a MS Access DB you have on your machine
            
            String filename = "c:/orkut_java/passwd.mdb";
            
            String database = "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=";
            
            database+= filename.trim() + ";DriverID=22;READONLY=true}"; // add on to the end 
            
            // now we can get the connection from the DriverManager
            
            Connection con = DriverManager.getConnection( database); 
          	
            //create statement
            Statement s = con.createStatement();
			//make connection
			
		   
		
			
			


				//read from the client
			
				//System.out.println("CLIENT "+ID+">>\t"+strquerytext);
				
                               
                                 
				
                                //Query
				s.execute(strquerytext);
				ResultSet rs = s.getResultSet();
				if(rs==null){
                              bw.write(null+"\n");
					          bw.flush();
					          
                            }
                                else
                                  {
                                    
				//Getting MetaData			
				ResultSetMetaData metadata=rs.getMetaData();
				int itotalcolumns=metadata.getColumnCount();
				
                 strresult=""; 
				//Extracting from Resultset
                               while(rs.next())
				  {     
					for( int i=1;i<=itotalcolumns;i++)
					{
						strresult+=rs.getString(i)+"   ";
                        
					}
					
                   // System.out.print(strresult+"\n");
					//send result to client
					             
					             bw.write(strresult.length()+"\n");
				            	 bw.flush();
				            	
				            	bw.write(strresult+"\n");
					            bw.flush();
		       			              strresult="";

				   
                                       }
				

			       }       
                        
                s.close();
                con.close();        
                }        
			
            br.close();
			bw.close();
			
			//System.out.println("Client:\t"+Client.getInetAddress().getHostName()+" terminated");
			Client.close();


		}
		catch(Exception e)
		{
			//System.out.println("in server thread ****"+e);
		}
	}
}