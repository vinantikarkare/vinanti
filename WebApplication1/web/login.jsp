<%-- 
    Document   : login
    Created on : 12 Jul, 2020, 10:42:32 PM
    Author     : ind
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <form action="login" method="post">  
  
Email :<input type="text" name="email"/><br/><br/>
Password :<input type="text" name="password"/><br/><br/>
<input type="submit" value="submit"/>  
        </form>
        
        <br><br><br><br><br>
        
<div id="fb-root" style="align:center;"></div>
<script async defer crossorigin="anonymous" src="https://connect.facebook.net/en_GB/sdk.js#xfbml=1&version=v7.0" nonce="TAQxP5dd"></script>
<div class="fb-comments" data-href="http://localhost:8084/WebApplication1/login.jsp" data-numposts="50" data-width=""></div>

    </body>
</html>
