<%-- 
    Document   : wellness
    Created on : Jan 20, 2022, 8:07:10 PM
    Author     : Damia Nizam
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="bean.Product"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Wellness</title>
        <jsp:include page="includes/head.jsp"/>
    </head>
    <body>
        <nav class="navbar">
            <jsp:include page="includes/nav.jsp"/>
        </nav>
        <h2 class="product-category">Wellness</h2>
        
        <div class="container">
        <div class="row">
                <c:forEach var="product" items="${products}">
                <div class="card d-grid gap-2 d-md-block" style="width: 18rem;">
                <img alt="img" class="card-img-top" src="data:image/jpg;base64,${product.base64Image}"/>
                <div class="card-body">
                    <p class="product-brand">${product.name}</p>
                    <span class="price">RM ${product.price}</span>
                <form action="viewProduct">
                    <button class="btn btn-primary btn-sm" name="pid" value="${product.id}" >View</button>
                </form>
                <form action="addOrder">
                    <button class="btn btn-dark btn-sm" name="pid" value="${product.id}">add to cart</button>
                </form>
                </div>    
                </div>
                &emsp;
                 
                </c:forEach>
        </div>
        </div>
        <footer><jsp:include page="includes/footer.jsp"/></footer>
    </body>
</html>
