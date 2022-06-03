<%-- 
    Document   : approveOrder
    Created on : Jan 25, 2022, 9:23:17 PM
    Author     : Mhdrfq
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Approve order</title>
        <jsp:include page="includes/head.jsp"/>
    </head>
    <body>
        <jsp:include page="includes/adminNavbar.jsp"/>
        <main>
        <div class="container-fluid">
            <form method="post" action="updateOrder">
                <div class="col-sm-6 mb-3 mt-5 mb-4">
                    <h4>Approve Order</h4>
                </div>
    
                <input type="hidden" name="oid" value="${order.order_id}">
                
                <div class="col-sm-6 mb-3">
                    <label for="approve" class="form-label">Would you like to approve this order?</label><br>
                    <select class="form-select" name="os">
                        <option selected>Select an option</option>
                        <option value="true">Approve</option>
                        <option value="false">Decline</option>
                    </select>
                </div>
                
                <div class="col-sm-2 mb-3">
                    <label for="approve" class="form-label">Please inspect the prescription below:</label>
                    <img src="data:image/jpg;base64,${order.prescription}" width="400" height="400"/>
                </div>
                
                <div class="col-sm-2 mb-3 mt-5">
                    <a href="adminViewOrders" class="btn btn-secondary px-4" >Back</a>
                    <button class="btn btn-success px-4" type="submit" value="submit">Submit</button>
                </div>
                
            </form>

        </div>
        </main>
    </body>
</html>
