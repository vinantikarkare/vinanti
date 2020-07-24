<%-- 
    Document   : comment
    Created on : 21 Jul, 2020, 10:04:34 PM
    Author     : ind
--%>

<%@page import="com.art.dao.UserDao"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.art.dto.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html> 
<head> 
	<title> 
	getcomment
	</title> 
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
	<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head> 
<style>
   
  body {
  font-family: Arial, sans-serif; 
}

h1 {
  font-family: Tahoma, Arial, sans-serif;
  color: orange;
  
}

.box {
  width: 20%;
 
  background: rgba(255,255,255,0.2);
  color:#009973;
  
  border-radius: 20px/50px;
  background-clip: padding-box;
  
}

.button {
  font-size: 1.7em;
 color: #009973;
 text-decoration: none;
  cursor: pointer;
  transition: all 0.8s ease-out;
}
.button:hover {
  color: #cc6600;
}

.overlay {
  position: absolute;
  top: 0;
  bottom: 0;
  left: 0;
  right: 0;
  background: rgba(0, 0, 0, 0.7);
  transition: opacity 700ms;
  visibility: hidden;
  opacity: 0;
}
.overlay:target {
  visibility: visible;
  opacity: 1;
}

.popup {
  margin: 70px auto;
  padding: 20px;
  background: #fff;
  border-radius: 5px;
  width: 30%;
  position: relative;
  transition: all 9s ease-in-out;
  box-shadow: 0px 1px 197px 92px rgba(121,108,140,0.76);
}

.popup h2 {
  margin-top: 0;
  color: #333;
  font-family: Tahoma, Arial, sans-serif;
}
.popup .close {
  position: absolute;
  top: 20px;
  right: 30px;
  transition: all 200ms;
  font-size: 30px;
  font-weight: bold;
  text-decoration: none;
  color: #333;
}
.popup .close:hover {
  color: orange;
}
.popup .content {
  max-height: 30%;
  overflow: auto;
}
   
    
    
.btn-group button {
  background-color: #4CAF50; /* Green background */
  border: 1px solid green; /* Green border */
  color: white; /* White text */
  padding: 10px 24px; /* Some padding */
  cursor: pointer; /* Pointer/hand icon */
  float: left; /* Float the buttons side by side */
}

/* Clear floats (clearfix hack) */
.btn-group:after {
  content: "";
  clear: both;
  display: table;
}

.btn-group button:not(:last-child) {
  border-right: none; /* Prevent double borders */
}

/* Add a background color on hover */
.btn-group button:hover {
  background-color: #3e8e41;
}

input[type=text] {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  box-sizing: border-box;
  border: 1px solid #555;
  outline: none;
}

input[type=text]:focus {
  background-color: lightblue;
}

</style>
<body> 
    
     <%
          if (session.getAttribute("id") != null) {
                    System.out.println("session");
                    
                    String id = session.getAttribute("id").toString();
                        int idd = Integer.parseInt(id);
                System.out.println(idd);
                
                int comment_id=0;
                String first_index="";
                String last_index="";
                String comment="";
                String unique_code="";
                String comment_reply="";
                
              
                %>
                
Select any text :<br>



<p type="text" id="my-textarea" style="padding: 10px 100px;; height:200px;" >
While delivering a lecture at the Indian Institute of Management Shillong, Kalam collapsed and died from an apparent cardiac arrest on 27 July 2015, aged 83. Thousands including national-level dignitaries attended the funeral ceremony held in his hometown of Rameshwaram, where he was buried with full state honours.
</p>
<dialog id="myDialog" style="width:70%;border-radius: 25px;box-shadow: 0px 1px 197px 92px rgba(121,108,140,0.76);">
<span style="font-size:17px;">Selected Text : </span><b><p id="selectedd"></p></b>
 <br>
 <!-- Form Start -->
 
  <form action="Comment" method="post">  
 Id: <input type="text" name="idd" value="<%=idd%>"  readonly="">
 firstindex : <input id="firstindex" name="firstindex" readonly=""/>
 lastIndex : <input id="lastindex" name="lastindex"  readonly=""/>
 uniquecode:<input id="unique" name="uniqueCode" />
 <!-- <p id="past"></p> -->
<p>
  <label>Comment : </label>
  <input class="w3-input" type="text" name="comment"></p>
  <p>
<br>
<input type="submit" value="Comment Submit"/>  
        </form>
<!-- form end -->

<br>
<button onclick="myvai()">close</button>
</dialog>


<button onclick="vai3()">Show dialog</button>
<br>

<div id="vaitry"></div>

<script>var array = [];</script>

<%
   ArrayList<User> userList=UserDao.getComment();
                   for(User user:userList){
                       comment_id = user.getId();
                       first_index=user.getFirst_index();
                       last_index=user.getLast_index();
                       comment=user.getComment();
                       unique_code=user.getUnique_code();
                       comment_reply=user.getComment_reply();
                       
                       System.out.println("====================================");
                       System.out.println(comment_id);
                       System.out.println(first_index);
                       System.out.println(last_index);
                       System.out.println(comment);
                       System.out.println(unique_code);
                       System.out.println(comment_reply);
                       int i=0;
                       
                       int aa= Integer.parseInt(first_index) + Integer.parseInt(last_index);
                       i=i+1;
                        System.out.println("------------"+aa);
                     %>

                    
                     <script>  
                         array.push(<%=aa %>);
                        </script>
    <%
                   }
%>
<!--
<script>

  var x = document.createElement("script");
  var t = document.createTextNode("function vai3() { document.getElementById('mypat').showModal(); }");
  x.appendChild(t);
  document.body.appendChild(x);

</script>
-->

            <script>
                function getUnique(array){
        var uniqueArray = [];
        
        // Loop through array values
        for(i=0; i < array.length; i++){
            if(uniqueArray.indexOf(array[i]) === -1) {
                uniqueArray.push(array[i]);
            }
        }
        return uniqueArray;
    }
    
    
    var uniqueNames = getUnique(array);
    console.log(uniqueNames);
  uniqueNames.reverse();
  
              
    document.write(uniqueNames);
    document.write("<br>");
    
    document.write(uniqueNames.length);
    
    
                            String.prototype.splice = function(idx, rem, str) {
                             return this.slice(0, idx) + str + this.slice(idx + Math.abs(rem));
                        };
                     var dia="";var comm="";var pati="";var r="";var count;
                  for(var i=0 ; i<uniqueNames.length; i++){
                       comm=""; count=0;
                        var p = document.getElementById("my-textarea").innerHTML;
                       <%
                        int aaa=0; 
                        userList=UserDao.getComment();
                        for(User user:userList){
                            comment_id = user.getId();
                            first_index=user.getFirst_index();
                            last_index=user.getLast_index();
                             comment=user.getComment();
                            unique_code=user.getUnique_code();
                            comment_reply=user.getComment_reply();
                       
                            aaa= Integer.parseInt(first_index) + Integer.parseInt(last_index); %>
                   
                          pati = new String("<%=comment%>");
                          
                       if(<%=aaa%> == uniqueNames[i]){
                           count += 1;
                           comm += "<p>("+count+") "+pati+"</p>";
                          }
                     
              <%       }   
                       %>
                               
                                                       r = Math.random().toString(36).substring(7);
                                
                       dia="<a class='button' href='#"+r+"'>&nbsp;<i class='fa fa-comments' aria-hidden='true'><spam style='font-size:0.7em;' >("+count+")</spam></i></a><div id='"+r+"' class='overlay'><div class='popup'><h2>Comment...</h2><a class='close' href='#'>×</a><div class='content'>"+comm+"<br>Comment : <br><input type='text' id='lname' name='lname'><br><input type='submit' value='Submit'></div></div></div>";
                        var result = p.splice(uniqueNames[i], 0, dia);
                          document.getElementById("my-textarea").innerHTML = result;
                          
                        
    }
                        
                       </script>
















<script>
function getSelected() {
	if(window.getSelection) { return window.getSelection(); }
	else if(document.getSelection) { return document.getSelection(); }
	else {
		var selection = document.selection && document.selection.createRange();
if(selection.text) { return selection.text; }
		return false;
	}
	return false;
}
var selection="";
/* create sniffer */
$(document).ready(function() {
	$('#my-textarea').mouseup(function(event) {
		selection = getSelected();
        selection = $.trim(selection);
        if(selection != ''){
		document.getElementById("myDialog").showModal(); 
	    document.getElementById("selectedd").innerHTML = selection ;
		
		var p= document.getElementById("my-textarea").textContent;
		var n = p.indexOf(selection);
		 var m = selection.length;
		document.getElementById("firstindex").value = n;
		document.getElementById("lastindex").value = m;
		
		var res = p.substr(n, m);
		document.getElementById("past").innerHTML = res;
        }
	});
});


function myvai(){
	document.getElementById("myDialog").close(); 
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
