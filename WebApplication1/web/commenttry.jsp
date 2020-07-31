<%-- 
    Document   : commenttry
    Created on : 27 Jul, 2020, 11:02:30 PM
    Author     : ind
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="com.art.dto.User"%>
<%@page import="com.art.dao.UserDao"%>
<%@page import="java.io.FileNotFoundException"%>
<%@page import="java.util.Scanner"%>
<%@page import="java.io.File"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href='https://fonts.googleapis.com/css?family=Montserrat' rel='stylesheet'>
    </head>
    <style>
        body{
            background-image: url("img/comment.jpg");
  background-repeat: no-repeat;
  background-attachment: fixed;
  background-size: cover;
   background-position: center;
  
        }
        
      html {
  font-family: Helvetica, Arial, sans-serif;
  font-size: 100%;
  
}

#page-wrapper {
  width: 80%;
  background: #FFF;
  padding: 1em;
  margin: 1em auto;
  min-height: 300px;
  border-top: 5px solid #69c773;
  box-shadow: 0 2px 10px rgba(0,0,0,0.8);
}

h1 {
	margin-top: 0;
}

img {
  max-width: 100%;
}

#fileDisplayArea {
  margin-top: 2em;
  width: 90%;
  overflow-x: auto;
}  

.select{
    border: 2px solid black;
    padding: 10px;
    font-size: 19px;
     font-family: 'Montserrat';
}

.fontStyle{
    border: 1px solid #69c773;
    border-radius: 10px;
    background-color:#00b36b;
    color:#e6ffff;
    padding: 5px 8px;
    margin: 5px 15px;
    font-size: 20px;
}

.button1 {
      background: none repeat scroll 0 0;
      border: medium none;
      color: #FFFFFF;
      height: 100px;
      left: 90%;
      position: fixed;
      top: 200px;
      width: 100px;
    }
    </style>

    <body >
        
             <% if (session.getAttribute("id") != null) {
                    System.out.println("session");
                    
                    String id = session.getAttribute("id").toString();
                        int idd = Integer.parseInt(id);
                System.out.println(idd);
                
   %>
  
   
   <div id="page-wrapper">

		<h1>Upload File : -</h1>
		<div>
			Select a text file: 
			<input type="file" id="fileInput">
		</div>
		<p id="fileDisplayArea" contenteditable="true" class="select"></p>
                 <fieldset class="field button1">
    <button class="fontStyle " onclick="document.execCommand('italic',false,null);" title="Italicize Highlighted Text"><i>Italic</i>
    </button>
    <button class="fontStyle" onclick="document.execCommand( 'bold',false,null);" title="Bold Highlighted Text"><b>Bold</b>
    </button>
    <button class="fontStyle" onclick="document.execCommand( 'underline',false,null);"><u>Underline</u>
    </button>
  </fieldset>

	</div>
 <script>
 window.onload = function() {
		var fileInput = document.getElementById('fileInput');
		var fileDisplayArea = document.getElementById('fileDisplayArea');

		fileInput.addEventListener('change', function(e) {
			var file = fileInput.files[0];
			var textType = /text.*/;

			if (file.type.match(textType)) {
				var reader = new FileReader();

				reader.onload = function(e) {
					fileDisplayArea.innerText = reader.result;
				}

				reader.readAsText(file);	
			} else {
				fileDisplayArea.innerText = "File not supported!"
			}
		});
}

</script> 
   
   
   
   
   
   
   
   
               <%
        }
          else {
                        System.out.println("no session");
                        response.sendRedirect("login.jsp");

                    }
        
        %>
    </body>
</html>
