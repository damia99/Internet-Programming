<%-- 
    Document   : personalCare
    Created on : Jan 20, 2022, 11:39:02 PM
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
        <title>Personal Care</title>
        <jsp:include page="includes/head.jsp"/>
    </head>
    <body>
        <nav class="navbar">
            <jsp:include page="includes/nav.jsp"/>
        </nav>
        <section class="product">
                <h2 class="product-category">Personal Care</h2>
                <div class="product-container">
                <div class="product-card">
                    <c:forEach var="product" items="${products}">
                        <a class="link-product" href="viewProduct">
                        <div class="product-image">
                            
                            <img alt="img" class="product-thumb" src="data:image/jpg;base64,${product.base64Image}"/>
                            <button class="card-btn" id="cart" name="cart" >add to cart</button>
                        </div>
                        <div class="product-info">
                            <p class="product-brand">${product.name}</p>
                            <span class="price">RM ${product.price}</span>
                        </div>
                        </a>
                    </c:forEach>
                    </div>
                </div>
            </section>
        <footer><jsp:include page="includes/footer.jsp"/></footer>
    </body>
</html>
