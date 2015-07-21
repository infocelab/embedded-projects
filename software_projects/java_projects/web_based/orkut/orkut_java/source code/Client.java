//package ksm.mulitiserver;

import java.io.*;
import java.net.*;


public class Client
{
	String strinput;
        String  strrecv;
        int max;
        viewprofile p1;
        public Client()
	   {  
       }
      
      /*
       public Client(String str_user,viewprofile p)
	{   p1=p;
		Processing(str_user);

	}
       */
        public String Client(String str,int c)
	      { 
	        Processing(str);
	        
	        return strrecv; 
	        
	      	}
       
       
       public  Client(String str)
	{
		Processing(str);
		
	
		

	}
	public void Processing(String str)
	{  strinput=str;
		try
		{
			Socket client=new Socket("localhost",4444);
			BufferedReader br;
			BufferedWriter bw;
		    String usname ="" , scrap="";
			br=new BufferedReader(new InputStreamReader(client.getInputStream()));
			bw=new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
			//System.out.println("Connected to "+client.getInetAddress().getHostName());


            
			 
			
				//	//System.out.println("strin put is = "+strinput);	
				
	            
                bw.write(strinput.length()+"\n");
                
            	bw.flush();
                 
                  bw.write(strinput+"\n");
                             
			    	bw.flush();
			
			   	int length=strinput.length();
				String temp=strinput.substring(0,5);
                
               	if(temp.equals("filin")||temp.equals("delet")||temp.equals("phtin")||temp.equals("phoin"))	
			  { 
			    int i=5;
				char c;
			  //  //System.out.println("strin put is = "+strinput);	
				while((i<length) && (c=strinput.charAt(i))!='*') 
				   { 
				     usname=usname+c;
				   	  i++;
				   	}
			
               
                
                scrap =strinput.substring(i+1,length);
                
              
               
               }
              
               else  
              
              usname=strinput.substring(5,length);
               
               
              usname=usname.trim();
                 
               
               
               
         //***************************************************************      
               
                 // if else ladder starts
               
               
                 
                 if(temp.equals("phtin"))
                {
                }
                
                else if(temp.equals("#####")||temp.equals("addco"))
                    { 
                    }
                
               else if(temp.equals("frien")||temp.equals("seefr")||temp.equals("chkfr")||temp.equals("addas"))//view friends
                  { 
                  
                  	strrecv=br.readLine();
                  	strrecv=strrecv.trim();
                  	                 	
                         
                  	       
                    //new friend(strrecv,strinput.substring(5,));
                  }
              /* else  if(temp.equals("frien"))
                  { 
                  
                  	strrecv=br.readLine();
                  	strrecv=strrecv.trim();
                  	 int start=0;
                     int friends=0;
                     int temp1;
                     int last=strrecv.length();
                     
                     while(start<last)
                        { if((temp1=strrecv.indexOf("$",start))!=-1)
                          {
                          	friends++;
                          	start=temp1+1;
                          }
                          start++;
                          
                        }
                     
                     //System.out.println(friends);
                     int i=0;
                     //photo transfer
                     start=0;
                     int c;
                     
                     String tempuser;
                     //calculate max frames
                     if(friends==0)
                     max=0;
                     else 
                     if(friends%6==0)
                     max=friends/6;
                     else
                     max= friends/6+1;
                     //System.out.println("max="+max);                    
                       friend[] fri =new friend[max];
                  
                      int user=0;
                      int frameno=0;
                      String arr[]=new String[6];
                     while(i<friends)
                          { c=strrecv.indexOf("$",start);
                            tempuser=strrecv.substring(start,c);
                            start=c+1;
                            i++;
                            arr[user++]=tempuser;
                            if(i%6==0)
                            {//System.out.println("***********framecalled"+frameno);
                            fri[frameno]  =new friend(arr,usr,fri,p1,frameno++,max-1);   
                                                                                 
                             user=0;
                             for(int k=0;k<6;k++)
                             //System.out.println(arr[k]);
                             
                             
                            }
                            
                            //System.out.println("*****usr="+user);
                            new Client("photo"+tempuser);
                          }
                  	     
                  	     if(frameno==max-1)
                  	       {
                  	       	 for(int j=user;j<6;j++)
                  	        arr[j]="";
                  	        for(int k=0;k<6;k++)
                             //System.out.println(arr[k]);
                  	       	 //System.out.println("*****usr="+user);
                  	       	  //System.out.println("***********framecalled"+frameno);
                  	       	 fri[frameno]  =new friend(arr,usr,fri,p1,frameno++,max-1);  
                  	        
                  	       }
                  	       
                    //new friend(strrecv,strinput.substring(5,));
                  }*/
               
               else if(temp.equals("noscr"))
               {  
                  strrecv= br.readLine();
                  strrecv=strrecv.trim();
               }
                else if(temp.equals("scrap"))
                  { 
                     FileOutputStream fos=new FileOutputStream("c:/orkut_java/temp.txt");
                    InputStream in = client.getInputStream();
                    byte[] buffer = new byte[8192];
                    int bytesRead;
                    while ((bytesRead = in.read(buffer)) > 0) 
                   {
                    fos.write(buffer, 0, bytesRead);
                   }
                     fos.flush(); // Very important
                     fos.close(); // Also very important
                   }



                 else if(temp.equals("phoin"))
                 { 
                 
                   //System.out.println("path in client is ="+scrap);
                  FileInputStream fis=new FileInputStream(scrap);
			      OutputStream out = client.getOutputStream();
                   byte[] buffer = new byte[8192];
                  int bytesRead;
                  while ((bytesRead = fis.read(buffer)) > 0) {
                   out.write(buffer, 0, bytesRead);
                     }
                     out.flush(); // Very important
                     fis.close(); // Also very important
                 }
				//receive result
				
				
				
				else if(temp.equals("newus")) {}
                          
                          
                          else if(temp.equals("filin")) 
                          {  }
                          
                            else if(temp.equals("delet")) 
                          {  }
                           
                           /*else if(temp.equals("profi")) 
				      	           { 
				      	           	     if((orkut.currentuser).equals(usr)) 	              
				      	             	 new viewprofile(usr);
				      	             	 else
				      	             	 new view_others(usr);
				      	              
				      	             }   */
				      	             
                               
                           else if(temp.equals("photo")) 
                                {  
                                 
                    FileOutputStream fos=new FileOutputStream("c:/orkut_java/photos/"+usname+".jpg");
                    InputStream in = client.getInputStream();
                    byte[] buffer = new byte[8192];
                    int bytesRead;
                    while ((bytesRead = in.read(buffer)) > 0) 
                   {
                    fos.write(buffer, 0, bytesRead);
                   }
                     fos.flush(); // Very important
                     fos.close(); // Also very important
                                }  
                           
                           else    {  
                           
                                          int charsread = Integer.parseInt(br.readLine());
		                                	//System.out.println("charsread="+charsread);
		   
		                              	char [] chars=new char [charsread];
			 
		                                	br.read(chars);
					
		                            	 strrecv= String.valueOf(chars);
                                       if(strrecv!=null) strrecv=strrecv.trim();
                                   
                                   
                                   }
				
				
			  	
			
			bw.close();
			br.close();
			client.close();
			//System.out.println("client closed");

		}
		catch(Exception e)
		{
			//System.out.println(e);
		}
	}

	
}




