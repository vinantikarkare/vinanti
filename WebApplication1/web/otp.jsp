<%-- 
    Document   : otp
    Created on : 13 Jul, 2020, 1:32:15 PM
    Author     : ind
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html lang="en">
    <head>
        <meta charset="utf-8">
        <title>Email Validation</title>
        <link rel="stylesheet" href="css/style1.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Sofia">
        <script src="https://kit.fontawesome.com/a076d05399.js"></script>
    </head>
    
    <body>
        <div class="content">
            <form action="OtpByUser" method="post">
                <div class="field">
                    <label>Email Id:</label>
                   <!--<input onkeyup="check()" type="text" id="email" placeholder="Enter Email address">-->
                   <Input required type="email" type="text" name="email" id="email" placeholder="enter your email" onkeyup="check()"/>
                    <div class="icons">
                        <span class="icon1 fas fa-check"></span>
                        <span class="icon2 fas fa-times"></span>
                        <span class="icon3 fas fa-exclamation"></span>
                    </div>    
                </div>   
                <br/><br/>
                
                <!--OTP -->
                
                
                <div class="field">
                    <label>OTP: </label>
                   <!--<input onkeyup="check()" type="text" id="email" placeholder="Enter Email address">-->
                   <Input required type="otp" type="text" name="otp" id="otp" placeholder="enter your otp" onkeyup="otpCheck()"/>
                    <div class="icons">
                        <span class="icon4 fas fa-check"></span>
                        <span class="icon5 fas fa-times"></span>
                        <span class="icon6 fas fa-exclamation"></span>
                    </div>    
                </div>   
                
                
                 <br><br>
                 <div align="left">
                <!-- <input type="submit" value="Submit"/> -->
                <Input type="submit" id="button" value="Submit" class="buttonvai">
                 </div>
            </form>
        </div> 
        
                <!--Email verification JavaScript-->
        
                    <script>
                        var email = document.querySelector("#email");
                        var icon1 = document.querySelector(".icon1");
                        var icon2 = document.querySelector(".icon2");
                        var icon3 = document.querySelector(".icon3");
                        var regExp = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;  
                        function check(){
                            if(email.value.match(regExp)){
                                email.style.borderColor = "#27ae60";
                                icon1.style.display = "block";
                                icon2.style.display = "none";
                                icon3.style.display = "none";
                            }
                            else{
                                email.style.borderColor = "#e74c3c";
                                icon1.style.display = "none";
                                icon2.style.display = "block";
                                icon3.style.display = "none";
                            }
                            
                        }
                        </script>
                        
                        
                <!--OTP verification JavaScript-->
                
                <script>
                        var otp = document.querySelector("#otp");
                        var icon4 = document.querySelector(".icon4");
                        var icon5 = document.querySelector(".icon5");
                        var icon6 = document.querySelector(".icon6");
                        var regExp = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;  
                        function otpCheck(){
                            if(otp.value.match(regExp)){
                                otp.style.borderColor = "#27ae60";
                                icon4.style.display = "block";
                                icon5.style.display = "none";
                                icon6.style.display = "none";
                            }
                            else{
                                otp.style.borderColor = "#e74c3c";
                                icon4.style.display = "none";
                                icon5.style.display = "block";
                                icon6.style.display = "none";
                            }
                            
                        }
                        </script>
        </body>
</html>