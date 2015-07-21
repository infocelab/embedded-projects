package BeanDir;
import java.text.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import java.net.*;
import java.io.*;
import java.io.PrintWriter;

public class Crawler{
        
    String ret;
    public static final String DISALLOW = "Disallow:";
    //public static final int SEARCH_LIMIT = 150;
    public static int fileCounter=1;
    CrawlTable tab;
   	public Crawler() {

	tab=new CrawlTable();
	URLConnection.setDefaultAllowUserInteraction(false);
    Properties props= new Properties(System.getProperties());
    props.put("http.proxySet", "true");
    props.put("http.proxyHost", "webcache-cup");
    props.put("http.proxyPort", "8080");
    Properties newprops = new Properties(props);
    System.setProperties(newprops);

    }


    String avoidHTMLTag(String s){
                StringBuffer sb=new StringBuffer();
                sb.ensureCapacity((s.length())*2);
                sb.append(s);
                int start = 0;
                int end = 0;
                try{

					while (((start = sb.indexOf("<",start)) != -1)|((end = sb.indexOf(">",start)) != -1))
					{		try{
								if(end<start)
									continue;

			                    sb.replace(start,end+1," ");
			                    start--;
			                    end=start;
			                   }
			                catch( Exception ex)
			                	{
			                        System.out.println("ERROR:HTML FORMAT");
			                	}
			                }


					String s1=new String (sb);
                	return s1;
			    }
                catch(Exception e)
                {
                ret="WRONG HTML FORMAT";
                return "";
                }


      }//end of htmlavoid




public String start (String strURL)
{

        
	try
	{

    FileReader clCountRead=new FileReader("c:/search/resources/crawlcount.txt");
    StreamTokenizer countTok=new StreamTokenizer(clCountRead);
    countTok.resetSyntax();
	countTok.wordChars(33,65535);
	countTok.whitespaceChars(0,' ');
	countTok.eolIsSignificant(false);
    countTok.nextToken();
    Crawler.fileCounter=Integer.parseInt(countTok.sval);
	clCountRead.close();
	//String strURL= CrawlerFrame.jTextFieldUrlAddress.getText();
	//out.println("CRAWLER STARTING....");
	//CrawlerFrame.jListURL.removeAll();
	int counter=0;
	boolean condition;
	URL url;
    try
    {
		url = new URL(strURL);
		if (!tab.contains(strURL))
		{
	    	// test to make sure it is robot-safe!
			//if (robotSafe(url))
		    tab.insertRecord(strURL);
    	}
    }
    catch (MalformedURLException e)
    {
		if(!strURL.equals("")){
                ret="ERROR: invalid URL " + strURL;
		//CrawlerFrame.jTextFieldUrlAddress.setText("");
		}
	}



	while(((condition=tab.isRecordFalse())||strURL.length()!=0))
	{
			if(condition)
			{
				strURL = tab.retrieveFirst();
				//CrawlerFrame.jTextFieldUrlAddress.setText(strURL);
				tab.updateRecord(strURL);
				//setStatus("searching " + strURL);
		    	//CrawlerFrame.jListURL.add(strURL);

			}
			else
				strURL="";

			if (strURL.length() == 0)
			{
                        //ret="Enter a starting URL then press RUN";
			    break;
			}


		    try
		    {
			url = new URL(strURL);
		    }
		    catch (MalformedURLException e)
		    {
                        ret="ERROR: invalid URL " + strURL;
			tab.delete(strURL);
			//CrawlerFrame.jTextFieldUrlAddress.setText("");
			strURL="";
			continue;
		    }

		    //tab.updateRecord(strURL);
		    // CrawlerFrame.jListURL.add(strURL);

		    // can only search http: protocol URLs
		    if (url.getProtocol().compareTo("http") != 0)
			break;

		    // test to make sure it is before searching
		    //if (!robotSafe(url))
			//break;

		    try
		    {
			// try opening the URL
			URLConnection urlConnection = url.openConnection();
			urlConnection.setAllowUserInteraction(false);
			InputStream urlStream = url.openStream();
			String type
			  = URLConnection.guessContentTypeFromName(url.getFile());
			  if (type == null)
			    break;
			if (type.compareTo("text/html") != 0)
			    break;

			byte b[] = new byte[1000];
			int numRead = urlStream.read(b);
			String content = new String(b, 0, numRead);
			while (numRead != -1)
			{
			    //if (Thread.currentThread() != CrawlerFrame.clThread)
				//break;
			    numRead = urlStream.read(b);
			    if (numRead != -1)
			    {
				String newContent = new String(b, 0, numRead);
				content += newContent;
	            }
			}
            String fileString=content;
            fileString=fileString.replace('(',' ');
            fileString=fileString.replace(')',' ');
            fileString=fileString.replace(',',' ');
            fileString=fileString.replace('.',' ');
            fileString=fileString.replace(':',' ');
            fileString=fileString.replace('?',' ');
            fileString=fileString.replace('!',' ');
            fileString=fileString.replace('@',' ');
            fileString=fileString.replace('\'',' ');
            fileString=fileString.replace('\"',' ');
            fileString=strURL+" "+fileString;
            //fileString.replace('',' ');
            File htmlDoc=new File("c:/search/repository/doc"+fileCounter+".txt");
            FileWriter fp=new FileWriter(htmlDoc);
            fp.write(avoidHTMLTag(fileString));
            //fp.write(fileString);
            fp.close();
            fileCounter++;
			urlStream.close();
			//if (Thread.currentThread() != CrawlerFrame.clThread)
			    //break;
			String lowerCaseContent = content.toLowerCase();
			int index = 0;
			while ((index = lowerCaseContent.indexOf("<a", index)) != -1)
			{
			    if ((index = lowerCaseContent.indexOf("href", index)) == -1)
				break;
			    if ((index = lowerCaseContent.indexOf("=", index)) == -1)
				break;

			    //if (Thread.currentThread() !=CrawlerFrame.clThread)
				//break;

			    index++;
			    String remaining = content.substring(index);


			    StringTokenizer st
			      = new StringTokenizer(remaining, "\t\n\r\">#");
			    String strLink = st.nextToken();

			    URL urlLink;
			    try
			    {
				urlLink = new URL(url, strLink);
				strLink = urlLink.toString();
			    }
			    catch (MalformedURLException e)
			    {
				//setStatus("ERROR: bad URL " + strLink);
				tab.delete(strLink);
				//CrawlerFrame.jTextFieldUrlAddress.setText("");
				strURL="";
				continue;
				}


				if (urlLink.getProtocol().compareTo("http") != 0)
					break;

				//if (Thread.currentThread() != CrawlerFrame.clThread)
					//break;

				try
				{
					// try opening the URL
					URLConnection urlLinkConnection
					  = urlLink.openConnection();
					urlLinkConnection.setAllowUserInteraction(false);
					InputStream linkStream = urlLink.openStream();
					String strType
					  = urlLinkConnection.guessContentTypeFromName(urlLink.getFile());
					linkStream.close();

					// if another page, add to the end of search list
					if (strType == null)
					    break;
					if (strType.compareTo("text/html") == 0) {
					    // check to see if this URL has already been
					    // searched or is going to be searched
					    //////////////////////////////////////////////////////
					if (!tab.contains(strLink))
					{

						// test to make sure it is robot-safe!
						//if (robotSafe(urlLink))
						    tab.insertRecord(strLink);
			        }
				}


				}
				catch (IOException e)
				{
					ret="ERROR: couldn't open URL " + strLink;
					continue;
				}
				if (strURL.length() == 0)
				{
		       		//ret="Enter a starting URL then press RUN";
			    	/////return;
			    	break;
				}

				}//end of try
			    } catch (IOException e)
			    {
				ret="ERROR1: couldn't open URL " + strURL;
		        tab.delete(strURL);
		        //CrawlerFrame.jTextFieldUrlAddress.setText("");
		        strURL="";
		        continue;
			    }


	}//end while
	    //setStatus("done");
        //CrawlerFrame.jButtonStop.setEnabled(false);
        //CrawlerFrame.jButtonRun.setEnabled(true);
        FileWriter clCountWrite=new FileWriter("c:/search/resources/crawlcount.txt",false);
		Integer count=new Integer(fileCounter);
		clCountWrite.write(count.toString(),0,count.toString().length());
		clCountWrite.close();
        //CrawlerFrame.clThread = null;
	}//end of try
	catch(Exception e)
	{
		ret="ERROR:"+e.getMessage();
	}
return(ret);
  }
  //end of run

 }//end of classCrawler


class CrawlTable
	{

        String connectionAddress="jdbc:odbc:santosh";
	Connection con;
	Statement stmt;
	ResultSet rs;
  	public void insertRecord(String urlAddress)
   		{

		String insertString;
		insertString="insert into CRAWLER (URLADDRESS,ISCRAWLED)"+
		" values('"+urlAddress+"',false)";


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
                        con=DriverManager.getConnection(connectionAddress,"","");
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


public void delete(String urlAddress)
   		{

		String deleteString;
		deleteString="delete from CRAWLER where URLADDRESS='"+urlAddress+"'";
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
                        con=DriverManager.getConnection(connectionAddress,"","");
        		stmt=con.createStatement();
        		stmt.executeUpdate(deleteString);
        		stmt.close();
        		con.close();
        	}
        catch(SQLException ex)
        	{
        		System.err.println("SQLException2: "+ex.getMessage());
            }

    }




    public boolean isRecordFalse()
    	{
    	boolean flag=false;
    	String query;
		query=" select URLADDRESS from CRAWLER "+
		"where ISCRAWLED=false";

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
                        con=DriverManager.getConnection(connectionAddress,"","");
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




    public String retrieveFirst()
    	{

    	String query,s="";
		query=" select URLADDRESS from CRAWLER where "+
		"ISCRAWLED=false order by SERIAL";

        try
        	{
        		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        	}
        catch(java.lang.ClassNotFoundException e)
        	{
        		System.err.print("ClassNotFoundException: ");
        		System.err.println(e.getMessage());
        		return null;
            }

        try
        	{
                        con=DriverManager.getConnection(connectionAddress,"","");
        		stmt=con.createStatement();
                rs=stmt.executeQuery(query);

        		if(rs.next()==true)
        		{
        		s=rs.getString("URLADDRESS");
        		}
        		stmt.close();
        		con.close();




        	}
        catch(SQLException ex)
        	{
        		System.err.println( "SQLException3: "+ex.getMessage());
        		return null;
            }

		return s;

        }




    public boolean contains(String strURL)
    	{
    	boolean flag=false;
    	String query;
		query=" select URLADDRESS from CRAWLER "+
		"where URLADDRESS='"+strURL+"'";

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
                        con=DriverManager.getConnection(connectionAddress,"","");
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




       public void updateRecord(String urlAddress)
       {

		String updateString;
		updateString="update CRAWLER"+
		" set ISCRAWLED=true" + " where URLADDRESS='"+urlAddress+"'";


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
                        con=DriverManager.getConnection(connectionAddress,"","");
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



