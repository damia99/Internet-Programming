<%-- 
    Document   : register
    Created on : Jan 15, 2022, 9:06:28 AM
    Author     : nasrin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sign Up</title>
        <jsp:include page="includes/head.jsp"/>
    </head>
    <body>
        <main>
        <div class="container-fluid">
            <div class="col-sm-6 mb-3 mt-5 mb-4">
                <h4>Enter your information</h4>
            </div>
            <form method="post" action="insertCustomer">
                
                <div class="col-sm-6 mb-3">
                    <label for="customer firstname" class="form-label">Firstname</label>
                    <input type="text" name="firstname" class="form-control" id="firstname">
                </div>
                
                <div class="col-sm-6 mb-3">
                    <label for="customer lastname" class="form-label">Lastname</label>
                    <input type="text" name="lastname" class="form-control" id="lastname">
                </div>
                
                <div class="col-sm-6 mb-3">
                    <label for="customer email" class="form-label">Email</label>
                    <input type="email" name="email" class="form-control" id="email">
                </div>
    
                <div class="col-sm-6 mb-3">
                    <label for="customer phonenumber" class="form-label">Phone Number</label>
                    <input type="phonenumber" name="phonenumber" class="form-control" id="phonenumber">
                </div>
                
                <div class="col-sm-6 mb-3">
                    <label for="customer password" class="form-label">Password</label>
                    <input type="password" name="password" class="form-control" id="password">
                </div>
                
                <div class="col-sm-6 mb-3">
                    <label for="customer address" class="form-label">Address</label>
                    <input type="text-area" name="address" class="form-control" id="address">
                </div>

                <div class="col-sm-2 mb-3 mt-5">
                    <a href="login" class="btn btn-secondary px-4" type="submit" value="submit">Back</a>
                    <button class="btn btn-success px-4" type="submit" value="submit">Submit</button>
                </div>
                
            </form>

        </div>
        </main>
    </body>
</html>
