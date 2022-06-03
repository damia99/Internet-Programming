<%-- 
    Document   : loginCustomer
    Created on : Dec 27, 2021, 12:17:42 PM
    Author     : nasrin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <header class="hero-section">
            <div class="content">
                <img src="img/logo.png" class="logo" alt="">
                
                <br><br>
                <h1 align="center">Sign In</h1>
                
                    <form name = "signin" action = "Login" method = "post">
                        <table align = center>
                            <tr>
                                <td>Username  </td>
                            </tr>    
                            <tr>
                                <td><input type = "text" name = "username" id="username" placeholder="Your username" required/> </td>
                            </tr>
                            <tr>
                                <td>Password </td>
                            </tr>

                            <tr>
                                <td> <input type = "password" name = "password" id="password" required/> </td>
                            </tr><br>

                            <tr> 
                            <td>Forgot password? Click <a href = "#">here</a> </td>
                            </tr>
                            
                            <tr> </tr>

                            <tr>
                            <td><button class = "buttonbox" type="submit">Login</button></td> 
                            </tr>
                            
                            

                            <tr><td>Don't have an account? <a href ="Login" target="resetpassword">Sign Up</a></td>
                            </tr>
                        </table>
                    </form>
                </div>
            </header>
    </body>
</html>
