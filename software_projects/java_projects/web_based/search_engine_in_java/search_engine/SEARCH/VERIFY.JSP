<%@ page import="java.sql.*" %>
<html>
    <body>
        <%
        String id=request.getParameter("id");
        String password=request.getParameter("password");
        try{
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
       
        Connection conn=DriverManager.getConnection("jdbc:odbc:santosh","","");
        
        PreparedStatement ps=conn.prepareStatement("select userid,password from admin where userid=? and password=? ");

        ps.setString(1,id);
        ps.setString(2,password);
        ResultSet rs=ps.executeQuery();

        if(rs.next()) {
        %>
     
                  <jsp:forward page="resources.html"/>
      
      <% } else { %>
      
        
               <jsp:forward page="invalid.html"/>
     
      <% } ps.close();
      
      }catch(Exception e){e.printStackTrace();}
    
      %> 
   
 </body>
 </html>