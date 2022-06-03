<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="bean.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tigris Pharmacy</title>
        <jsp:include page="includes/head.jsp"/>
    </head>
    <body>
    <nav class="navbar">
            <jsp:include page="includes/nav.jsp"/>
        </nav>
        
        
            <section class="product">
                <h2 class="product-category">best selling</h2>
                <button class="pre-btn"><img src="img/arrow.png" alt=""></button>
                <button class="nxt-btn"><img src="img/arrow.png" alt=""></button>
                <div class="product-container">
                  
                   <c:forEach var="product" items="${products}">
                    <div class="product-card">
                        <div class="product-image">
                            <img src="data:image/jpg;base64,${product.base64Image} class="product-thumb" alt="">
                            <form action="addOrder">
                                <button class="btn btn-primary btn-sm" name="pid" value="${product.id}">add to cart</button>
                            </form>
                            <form action="viewProduct">
                                <button class="btn btn-dark btn-sm" name="pid" value="${product.id}">View</button>
                            </form> 
                        </div>
                        <div class="product-info">
                            <p class="product-brand"></p>
                            <p class="product-short-des">${product.category}</p>
                            <span class="price">${product.name}</span>
                        </div>  
                       </div></a>
                       </c:forEach>
                
                </div>
            </section>
        </form>
       
        <section class="collection-container">
            <a href="medicine" class="collection">
                <img src="img/medicine.jpg" alt="">
                <p class="collection-title"> Medicines & <br>Prescription Drugs</p>
            </a>
            <a href="wellness" class="collection">
                <img src="img/wellness.jpg" alt="">
                <p class="collection-title">Wellness & <br>lifestyle</p>
            </a>
            <a href="#" class="collection">
                <img src="img/health-content.jpeg" alt="">
                <p class="collection-title">Health Content</p>
            </a>
           
        </section>
        <footer><jsp:include page="includes/footer.jsp"/></footer>
        
        </body>
</html>
