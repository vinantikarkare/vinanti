<%-- 
    Document   : dashboard
    Created on : 19 Jul, 2020, 12:53:52 AM
    Author     : ind
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.art.dto.User"%>
<%@page import="com.art.dao.UserDao"%>

    
        <%
          if (session.getAttribute("id") != null) {
                    System.out.println("session");
                    
                    String id = session.getAttribute("id").toString();
                        int idd = Integer.parseInt(id);
                System.out.println(idd);
                
                
                    String codee="ASDF";
        String ide = id+" ,";
         
         String likebuttonid= UserDao.checkid(codee);
            System.out.println("************* "+likebuttonid);
            
            Boolean flag= likebuttonid.contains(","+ide);
        %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <style> 

</style>
    </head>
    <body>
    
        
        <h1>Hello World!</h1>
        <h1><%=idd%></h1>
        <br>  <br>  <br>  <br>  <br>  <br>
         <form action="like" method="post">  
       <input type="text" name="idd" value="<%=idd%>" >
       <br>
       
       <br>      
       <input type="submit" <%if(flag){%> value="&#10084;"  style="font-size:25px; color:#cc0000; outline: 0; background:white; border:0px;<% } else{%> value="&#9825;" style="font-size:27px;width: 40px; outline: 0;  color: blue; background:white; border:0px;"<%}%> class="button" />
     
        </form>
        
        
       <br>
      
      
        <%
        }
          else {
                        System.out.println("no session");
                        response.sendRedirect("login.jsp");

                    }
        
        %>
    </body>
</html>
