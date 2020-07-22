<%-- 
    Document   : comment
    Created on : 21 Jul, 2020, 10:04:34 PM
    Author     : ind
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html> 
<head> 
	<title> 
	Golu
	</title> 
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
	<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head> 
<style>
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
</style>
<body> 
    
     <%
          if (session.getAttribute("id") != null) {
                    System.out.println("session");
                    
                    String id = session.getAttribute("id").toString();
                        int idd = Integer.parseInt(id);
                System.out.println(idd);
                %>
                
Select any text :<br>



<p type="text" id="my-textarea" style="width:100%; height:200px;" >
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
