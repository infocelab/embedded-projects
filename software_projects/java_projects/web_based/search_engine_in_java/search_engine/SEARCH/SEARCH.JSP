<%@ page language="java" import="java.sql.*,java.util.* " %>

<HTML>
<HEAD>
<TITLE>Search Our Site</TITLE>
<LINK href="newstyle.css" type=text/css 
rel=stylesheet>
</head>

<BODY bgColor=#862b13 leftMargin=0 topMargin=0 MARGINHEIGHT="0" MARGINWIDTH="0">


<TABLE cellSpacing=1 cellPadding=0 width=776 align=center bgColor=#ff9900 
border=0>
  <TBODY>
  <TR>
    <TD>
      <TABLE cellSpacing=0 cellPadding=0 width=776 border=0>
        <TBODY>
        <TR>
          <TD>
          <IMG height=44 alt="" 
            src="napt_inside1.jpg" width=776></TD></TR>
        <TR>
          <TD>
          <IMG height=60 alt="" 
            src="napt_inside2.jpg" width=776></TD></TR>
        <TR>
          <TD>
          <IMG height=55 alt="" 
            src="napt_inside3.jpg" width=776></TD></TR>
        <TR>
          <TD>
          <IMG height=69 alt="" 
            src="napt_inside4.jpg" width=776></TD></TR>
        <TR>
          <TD>
          <IMG height=35 
            alt=Search src="tab_search.gif" 
            width=776> </TD></TR>
        <TR>
          <TD bgcolor="#FFFFFF" bordercolor="#FFFFFF" background="">
          <p align="center">&nbsp;</p>
    <p align="left" style="margin-top: 0; margin-bottom: 0">
</p>
	
    <p align="center"><b><font size="5" face="Bookman Old Style">
          <font color="#862B13">Search Results</font>

			    
		    <%
		    		
		   String delims=" ";
			String tempString="";
			Connection con=null;
        	Statement stmt=null;
        	Statement stmtAnother;
        	ResultSet rs=null;
        	Statement stmt1=null;
        	ResultSet rsAnother=null;
        	String value="";
        	StringTokenizer tok;
        	
        	
		
		Vector v=new Vector();
		value=request.getParameter("T1");
		if(value!=null)
		{
			tok=new StringTokenizer(value,delims);
			while(tok.hasMoreTokens())
			{
				String s1=tok.nextToken();
				//if(tab.avoidToken(s1)==false)
				//{
					v.addElement(s1);
				//}
			}
			for(int i=0;i<v.size();i++)
			{
				tempString=(v.elementAt(i)).toString();
			
				try{	
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");					
				con=DriverManager.getConnection("jdbc:odbc:santosh","","");
				}catch(Exception ws){System.out.println("1"+ws);}
				try{
				Statement st=con.createStatement();
				ResultSet result=st.executeQuery("select URLADDRESS,FREQUENCY from INDEXER where KEYWORD like'"+tempString+"%'");
				if(result!=null)
				{
					while(result.next())
					{
						String urlAddress=result.getString("URLADDRESS");
						int frequency=Integer.parseInt(result.getString("FREQUENCY"));
						try{
						stmtAnother=con.createStatement();
		            	rsAnother=stmtAnother.executeQuery("select URLADDRESS from RESULT "+"where URLADDRESS='"+urlAddress+"'");
		            	if(rsAnother.next())
	        			{
	        				try{
	        				stmt1=con.createStatement();
		            		stmt1.executeUpdate("update RESULT"+" set SUMFREQ=SUMFREQ+"+frequency+"  where URLADDRESS='"+urlAddress+"'");
		            		stmt1.close();
		            		}catch(Exception wd){System.out.println("2"+wd);}
		            	}
	        			
	        			else
	        			{
	        				try{
	        				stmt1=con.createStatement();
		            		stmt1.executeUpdate("insert into RESULT"+" values('"+urlAddress+"',"+frequency+")");
		            		stmt1.close();
		            		}catch(Exception we){System.out.println("3"+we);}
						}
						stmtAnother.close();
						}catch(Exception wc){System.out.println("4"+wc);}
	
					}
				}
				st.close();
				con.close();
				}catch(Exception wb){System.out.println("5"+wb);}
			}
		}
		try{	
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");					
		con=DriverManager.getConnection("jdbc:odbc:santosh","","");
		}catch(Exception ws1){System.out.println("6"+ws1);}
		stmt=con.createStatement();
	    rs=stmt.executeQuery("select URLADDRESS from RESULT order by SUMFREQ desc");
		
		%>
      
		  </font><font face="Bookman Old Style">
          </font><font size="5" face="Bookman Old Style">
          <ul style="color: #862B13; font-size: 12pt" type="square">

			<%
			int size=0;
			
			if(rs!=null)
			{
				while(rs.next())
				{
					String urlname=rs.getString("URLADDRESS");
					size++;
			%>
				
		
       
            <li>
            <p align="left" style="margin-bottom: 5"><font face="Tahoma">
            <a href=<%=urlname%>><font color="#862B13">
            <%=urlname%></font></a></font><br>
			
			
		<%
		
				}
			
			v=null;
			stmt.executeUpdate("delete from RESULT");
			stmt.close(); 
			
		%>
 </li>
          </ul>
		
		<b>
                <font face="Bookman Old Style"> <font color="#FF9900" size="4">&nbsp; 
                Your search returns <%=size%> results.</font> 
                <%}%>
                <object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=5,0,0,0" width="50" height="37">
                  <param name="movie" value="button4.swf">
                  <param name="quality" value="high">
                  <param name="base" value=".">
                  <embed src="button4.swf" base="."  quality="high" pluginspage="http://www.macromedia.com/shockwave/download/index.cgi?P1_Prod_Version=ShockwaveFlash" type="application/x-shockwave-flash" width="50" height="37" ></embed> 
                </object>
                </font> 
                <p align="left" style="margin-top: 0; margin-bottom: 0">
    <font face="Book Antiqua" size="4" color="#FF9900">&nbsp;&nbsp; </font></p>


          </TD></TR>
        <TR>
          <TD bgcolor="#FFFFFF" bordercolor="#FFFFFF" background="">&nbsp;
          </TD></TR></TBODY></TABLE></TD></TR></TBODY></TABLE><MAP 
name=Map><AREA shape=RECT alt=Home coords=6,31,50,50 
  href="index.html"><AREA shape=RECT 
  coords=51,31,105,50 href="contact.html"><AREA 
  shape=RECT alt=Search coords=107,31,160,50 
  href="search.html"><AREA shape=RECT 
  coords=165,31,219,50 href="sitemap.html"><AREA 
  shape=RECT alt=Copyright coords=224,31,289,50 
  href="copyright.html"></MAP>
<IMG height=55 alt="" 
            src="producer_resource_footer.jpg" 
            width=776 useMap=#Map 
border=0><BR>
  
</BODY>
</HTML>