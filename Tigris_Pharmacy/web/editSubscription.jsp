<%-- 
    Document   : editSubscription
    Created on : Jan 23, 2022, 12:50:45 PM
    Author     : Mhdrfq
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="bean.Product"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Subscription</title>
        <jsp:include page="includes/head.jsp"/>
    </head>
    <body>
        <jsp:include page="includes/adminNavbar.jsp"/>
        
        <main>
        <div class="container-fluid">
            <form method="post" action="updateSubscription">
                <div class="col-sm-6 mb-3 mt-5 mb-4">
                    <h4>Edit subscription information</h4>
                </div>
    
                <input type="hidden" name="sid" value="${sub.id}">
                
                <div class="col-sm-6 mb-3">
                    <label for="username" class="form-label">Username</label>
                    <input type="text" name="username" class="form-control" id="username" placeholder="${sub.username}" required>
                </div>
                
                <div class="col-sm-2 mb-3">
                    <label for="medication" class="form-label pr-2">Medication</label><br>
                    <select class="form-select" name="medication" required>
                        <option selected>${sub.medication}</option>
                        <c:forEach var="product" items="${products}">
                            <option value="${product.name}">${product.name}</option>
                        </c:forEach>
                    </select>
                </div>
    
                <div class="col-sm-2 mb-3">
                    <label for="time" class="form-label">Time</label>
                    <input type="date" name="time" class="form-control" id="time" placeholder="${sub.time}" required>
                </div>

                <div class="col-sm-2 mb-3 mt-5">
                    <a href="adminViewSubscriptions" class="btn btn-secondary px-4" >Back</a>
                    <button class="btn btn-success px-4" type="submit" value="submit">Submit</button>
                </div>
                
            </form>

        </div>
        </main>
                
    </body>
</html>
