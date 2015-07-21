package BeanDir;
import java.util.*;
import java.io.*;
import java.sql.*;
import java.awt.*;
import javax.swing.*;



public class Indexer implements Runnable
	{
                    
                    
                    
                    public static boolean stopFlag=true;
                    String dirName="c:/search/repository";
                    File file=new File(dirName);
                    String fList[]=file.list();
                    
                    FileReader indCountRead;
                    StreamTokenizer countTok;
                    
                                       
            public void run()
            {
			int fileNum;
					
			try{
                    	
                    FileReader indCountRead=new FileReader("c:/search/resources/indexcount.txt");
                    StreamTokenizer countTok=new StreamTokenizer(indCountRead);
                    countTok.resetSyntax();
					countTok.wordChars(33,65535);
					countTok.whitespaceChars(0,' ');
					countTok.eolIsSignificant(false);
                    countTok.nextToken();
                    fileNum=Integer.parseInt(countTok.sval);
                    indCountRead.close();
                
				while(stopFlag && fileNum <= fList.length)

                    {

	                String s="c:/search/repository/doc"+fileNum+".txt";
	                FileReader fr;
			    	StreamTokenizer tok;
			    	Table tab;
			    	try
			    		{
	
						fr=new FileReader(s);
						tok=new StreamTokenizer(fr);
						tok.resetSyntax();
						tok.wordChars(33,65535);
						tok.whitespaceChars(0,' ');
						tok.eolIsSignificant(false);
		                //FrameMain.indFrame.jTextFieldFile.setText("File:"+s);
					    tab=new Table();
						tok.nextToken();
	                    String s1=tok.sval;
						while(tok.nextToken()!=tok.TT_EOF)
					  		{
							//FrameMain.indFrame.jTextFieldToken.setText("Token:"+tok.toString());
	                        if(tab.avoidToken(tok.sval)==false)
							if(tab.matchedRecord(tok.sval,s1)==false)
								{
								tab.insertRecord(tok.sval,s1);
						    	}
							else tab.updateRecord(tok.sval,s1);

			          		}//while end
						 

                        }//end of try
                        catch(IOException e)
                        {
                            //System.out.println("File Error1"+e.getMessage());
                            //FrameMain.indFrame.jTextFieldFile.setText("ERROR:"+e.getMessage());

                        }
						
						fileNum++;
           			}//end outer while	
           			
           			
                    //IndexerFrame.jTextFieldFile.setText("");
                    //FrameMain.indFrame.jTextFieldToken.setText("");
                    //FrameMain.indFrame.jButtonStop.setEnabled(false);
                    //FrameMain.indFrame.jButtonRun.setEnabled(false);
                    //FrameMain.indFrame.jLabelWarning.setText("");
						
					FileWriter indCountWrite=new FileWriter("c:/search/resources/indexcount.txt",false);
					Integer count=new Integer(fileNum);
					indCountWrite.write(count.toString(),0,count.toString().length());
					indCountWrite.close();	                    

                       if (fileNum>fList.length)
                           //IndexerFrame.jLabelPop.setText("ALL FILES INDEXED !!   ");
                           stopFlag=true;

	 		}//end of outer try
               catch(Exception e)
               {
            	   	//FrameMain.indFrame.jTextFieldFile.setText("ERROR:"+e.getMessage());
               }
               
	}//end of run
	



}//end of indexer
		 class Table
				{

				String connectionAddress=
					"jdbc:odbc:santosh";
				Connection con;
				Statement stmt;
				ResultSet rs;

				public boolean avoidToken(String token)
			{
				if(token.equalsIgnoreCase("is")||
				token.equalsIgnoreCase("are")||
				token.equalsIgnoreCase("am")||
				token.equalsIgnoreCase("was")||
				token.equalsIgnoreCase("were")||
				token.equalsIgnoreCase("have")||
				token.equalsIgnoreCase("has")||
				token.equalsIgnoreCase("had")||
				token.equalsIgnoreCase("may")||
				token.equalsIgnoreCase("might")||
				token.equalsIgnoreCase("must")||
				token.equalsIgnoreCase("shall")||
				token.equalsIgnoreCase("will")||
				token.equalsIgnoreCase("would")||
				token.equalsIgnoreCase("should")||
				token.equalsIgnoreCase("can")||
				token.equalsIgnoreCase("could")||
				token.equalsIgnoreCase("ought")||
				token.equalsIgnoreCase("to")||
				token.equalsIgnoreCase("do")||
				token.equalsIgnoreCase("did")||
				token.equalsIgnoreCase("does")||
				token.equalsIgnoreCase("a")||
				token.equalsIgnoreCase("an")||
				token.equalsIgnoreCase("the")||
				token.equalsIgnoreCase("in")||
				token.equalsIgnoreCase("of")||
				token.equalsIgnoreCase("at")||
				token.equalsIgnoreCase("as")||
				token.equalsIgnoreCase("into")||
				token.equalsIgnoreCase("for")||
				token.equalsIgnoreCase("from")||
				token.equalsIgnoreCase("while")||
				token.equalsIgnoreCase("if")||
				token.equalsIgnoreCase("then")||
				token.equalsIgnoreCase("."))

						return true;
				else
						return false;
			}
	
		       public void insertRecord(String key,String fileAddress)
		       	{

					String insertString;
					insertString="insert into INDEXER"+
					" values('"+key.toLowerCase()+"','"+fileAddress+"',1)";


		            try
		            	{
		            		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");//myDriver.ClassName");
		            	}
		            catch(java.lang.ClassNotFoundException e)
		            	{
		            		System.err.print("ClassNotFoundException: ");
		            		System.err.println(e.getMessage());
		                }

		            try
		            	{
		            		con=DriverManager.getConnection(connectionAddress,"",
		            		"");
		            		stmt=con.createStatement();
		            		stmt.executeUpdate(insertString);
		            		stmt.close();
		            		con.close();
		            	}
		            catch(SQLException ex)
		            	{
		            		System.err.println("SQLException2: "+ex.getMessage());
		                }

		        }

		        public boolean matchedRecord(String key,String fileAddress)
		        	{
		        		boolean flag=false;
		        		String query;
					query=" select KEYWORD,URLADDRESS from INDEXER "+
					"where KEYWORD='"+key.toLowerCase()+"' and URLADDRESS='"+fileAddress+"'";



		            try
		            	{
		            		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		            	}
		            catch(java.lang.ClassNotFoundException e)
		            	{
		            		System.err.print("ClassNotFoundException: ");
		            		System.err.println(e.getMessage());
		                }

		            try
		            	{
		            		con=DriverManager.getConnection(connectionAddress,"",
		            		"");
		            		stmt=con.createStatement();
                                        rs=stmt.executeQuery(query);
		            		if(rs.next()==true)
		            		{
		            			flag= true;
		            		   	//System.out.println(flag);
		            		}
		            		else
		            		{
		            		   	flag= false;
		            		 	//System.out.println(flag);

		            		}
		            		stmt.close();
		            		con.close();




		            	}
		            catch(SQLException ex)
		            	{
		            		System.err.println( "SQLException3: "+ex.getMessage());
		                }
		       		return flag;


		            }

		            public void updateRecord(String key,String fileAddress)
		           {

					String updateString;
					updateString="update INDEXER"+
					" set FREQUENCY=FREQUENCY+1" + " where KEYWORD='"+key.toLowerCase()+"' and URLADDRESS='"+fileAddress+"'";


		            try
		            	{
		            		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		            	}
		            catch(java.lang.ClassNotFoundException e)
		            	{
		            		System.err.print("ClassNotFoundException: ");
		            		System.err.println(e.getMessage());
		                }

		            try
		            	{
		            		con=DriverManager.getConnection(connectionAddress,"",
		            		"");
		            		stmt=con.createStatement();
		            		stmt.executeUpdate(updateString);
		            		stmt.close();
		            		con.close();
		            	}
		            catch(SQLException ex)
		            	{
		            		System.err.println("SQLException4: "+ex.getMessage());
		                }

		          }
	    	}

