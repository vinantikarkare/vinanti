<%-- 
    Document   : otp
    Created on : 13 Jul, 2020, 1:32:15 PM
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
        <form action="OtpByUser" method="post">
            otp<input type="text" name="otp_user"/>
            Email Id:<input type="text" name="email_id"/><br/><br/>
            <input type="submit" value="submit">
        </form>>
   </body>
</html>
