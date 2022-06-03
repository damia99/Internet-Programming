<%-- 
    Document   : adminLogin
    Created on : Jan 16, 2022, 8:42:44 PM
    Author     : Mhdrfq
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Login</title>
        <jsp:include page="includes/head.jsp"/>
        <link rel="stylesheet" href="css/adminLogin.css" type="text/css">
    </head>
    <body class="text-center">
        <main class="form-signin">
        <form>

            <h1 class="h3 mb-3 fw-normal">Admin login</h1>

            <div class="form-floating">
              <input type="email" class="form-control" id="floatingInput" placeholder="name@example.com">
            </div>
            <div class="form-floating">
              <input type="password" class="form-control" id="floatingPassword" placeholder="Password">

            </div>

<!--            <button class="w-100 btn btn-lg btn-primary" type="submit">Sign in</button>-->
            <a href="adminViewProducts" class="w-100 btn btn-lg btn-primary">Sign in</a>
            
            <label class="my-3">
                Not an admin? Back to 
                <a href="index.jsp">Tigris Pharmacy</a>
            </label>

        </form>
        </main>
    </body>
</html>
