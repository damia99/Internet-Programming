<%-- 
    Document   : editCustomerForm
    Created on : Jan 23, 2022, 2:51:35 PM
    Author     : Mhdrfq
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Customer</title>
        <jsp:include page="includes/head.jsp"/>
    </head>
    <body>
        <jsp:include page="includes/adminNavbar.jsp"/>
        
        <main>
        <div class="container-fluid">
            <form method="post" action="updateCustomer">
                <div class="col-sm-6 mb-3 mt-5 mb-4">
                    <h4>Edit customer information</h4>
                </div>
    
                <input type="hidden" name="cid" value="${customer.id}">
                
                <div class="col-sm-6 mb-3">
                    <label for="firstname" class="form-label">First name</label>
                    <input type="text" name="firstname" class="form-control" id="firstname" placeholder="${customer.firstname}" required>
                </div>
                
                <div class="col-sm-6 mb-3">
                    <label for="lastname" class="form-label">Last name</label>
                    <input type="text" name="lastname" class="form-control" id="lastname" placeholder="${customer.lastname}" required>
                </div>

                <div class="col-sm-6 mb-3">
                    <label for="email" class="form-label">Email</label>
                    <input type="text" name="email" class="form-control" id="email" placeholder="${customer.email}" required>
                </div>

                <div class="col-sm-6 mb-3">
                    <label for="phone" class="form-label">Phone number</label>
                    <input type="text" name="phone" class="form-control" id="phone" placeholder="${customer.phone}" required>
                </div>
                
                <div class="col-sm-6 mb-3">
                    <label for="address" class="form-label">Address</label>
                    <input type="text" name="address" class="form-control" id="address" placeholder="${customer.address}" required>
                </div>
                
                <div class="col-sm-2 mb-3 mt-5">
                    <a href="adminViewCustomers" class="btn btn-secondary px-4" >Back</a>
                    <button class="btn btn-success px-4" type="submit" value="submit">Submit</button>
                </div>
                
            </form>

        </div>
        </main>
                
    </body>
</html>
