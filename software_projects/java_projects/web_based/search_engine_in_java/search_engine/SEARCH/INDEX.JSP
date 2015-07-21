<%@ page import="BeanDir.Indexer" %>
<%@ page import="java.sql.*" %>

<jsp:useBean id="Indexer" class="BeanDir.Indexer" scope="request">
<jsp:setProperty name="Indexer" property="*" />
</jsp:useBean>

<HTML>
<HEAD>
<TITLE>Search Our Site</TITLE>
<LINK href="newstyle.css" type=text/css 
rel=stylesheet>
<BODY bgColor=#862b13 leftMargin=0 topMargin=0 MARGINHEIGHT="0" MARGINWIDTH="0">

        <% Indexer.run(); %>

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
          <IMG id=image1 height=35 alt="" 
            src="napt_inside_nav.jpg" width=776 
            useMap=#Map2 border=0></TD></TR>
        <TR>
          <TD>
          <IMG height=35 
            alt=Search src="tab_search.gif" 
            width=776> </TD></TR>
        <TR>
          <TD bgcolor="#FFFFFF" bordercolor="#FFFFFF" background="">
          <p align="center">&nbsp;</p>
          <p align="center"><b>
          <font size="6" face="Bookman Old Style" color="#862B13">Administration 
          Tools</font></b></p>


    <p>&nbsp;</p>
    <p align="center"><font face="Book Antiqua" size="4" color="#FF9900">
    Indexing is completed !!!</font></p>


          <p align="left">&nbsp;</p>

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
border=0><BR><MAP name=Map2><AREA 
  shape=RECT alt=Home coords=162,7,238,32 
  href="index.html"><AREA 
  shape=RECT alt="About Us" coords=244,7,331,32 
  href="about.html"><AREA 
  shape=RECT alt=Services coords=340,6,425,31 
  href="services.html"><AREA 
  shape=RECT alt=Resources coords=433,7,530,32 
  href="resources.html"><AREA shape=RECT alt=Contact 
  coords=542,7,630,32 href="contact.html"></MAP>
  
</BODY>
</HTML>