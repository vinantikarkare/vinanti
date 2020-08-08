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
            background-image: url("img/cmt.jpg");
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
    
     .sticky-container{
    padding:0px;
    margin:0px;
    position:fixed;
    right:-130px;
    top:230px;
    width:210px;
    z-index: 1100;
}
.sticky li{
    list-style-type:none;
    background-color:#fff;
    color:#efefef;
    height:43px;
    padding:0px;
    margin:0px 0px 1px 0px;
    -webkit-transition:all 0.25s ease-in-out;
    -moz-transition:all 0.25s ease-in-out;
    -o-transition:all 0.25s ease-in-out;
    transition:all 0.25s ease-in-out;
    cursor:pointer;
}
.sticky li:hover{
    margin-left:-115px;
}
.sticky li img{
    float:left;
    margin:5px 4px;
    margin-right:5px;
}
.sticky li p{
    padding-top:5px;
    margin:0px;
    line-height:16px;
    font-size:11px;
}
.sticky li p a{
    text-decoration:none;
    color:#2C3539;
}
.sticky li p a:hover{
    text-decoration:underline;
}


.stybut{
    border: 0px;
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
       <!--          <fieldset class="field button1">
    <button class="fontStyle " onclick="document.execCommand('italic',false,null);" title="Italicize Highlighted Text"><i>Italic</i>
    </button>
    <button class="fontStyle" onclick="document.execCommand( 'bold',false,null);" title="Bold Highlighted Text"><b>Bold</b>
    </button>
    <button class="fontStyle" onclick="document.execCommand( 'underline',false,null);"><u>Underline</u>
    </button>
  </fieldset>
-->
<div class="sticky-container">
    <ul class="sticky">
        <li>
            <img src="img/use/italic.png" width="32" height="32">
            <p><button class="" onclick="document.execCommand('italic',false,null);" title="Italicize Highlighted Text"><spam class="stybut"><i>Click for <br>Italic</i></spam></button></p>
        </li>
        <li>
            <img src="img/use/bold.png" width="32" height="32">
            <p><button class="" onclick="document.execCommand( 'bold',false,null);" title="Bold Highlighted Text"><b>Bold</b></button></p>
        </li>
        <li>
            <img src="img/use/underlinee.png" width="32" height="32">
            <p><button class="" onclick="document.execCommand( 'underline',false,null);"><u>Underline</u></button></p>
        </li>
       
    </ul>
</div>
<br>
<br>
<button onclick="myfun()">save</button>
<form action="FileSubmit" method="post">
    <input type="text" name="idd" value="<%=idd%>" >
    Topic :  <input type="text" name="topic" >
   File :  <textarea id="text" name="textfile"></textarea>
    
   <br><br>
   
   <br>
   <br>
   <Input type="submit" id="button" value="Submit" class="buttonvai">
   </form>
	</div>
     <script>
	function myfun(){
		var v = document.getElementById("fileDisplayArea").innerHTML;
		
		
	document.getElementById("text").innerHTML = v;
	console.log(v);
	
	}
</script> 
   
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
