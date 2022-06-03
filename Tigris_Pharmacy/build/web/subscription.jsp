<%-- 
    Document   : subscription
    Created on : Jan 26, 2022, 6:59:55 PM
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
        <title>Subscribe Now</title>
        <jsp:include page="includes/head.jsp"/>
    </head>
    <body>
        <nav class="navbar">
            <jsp:include page="includes/nav.jsp"/>
        </nav>
        <h2 class="product-category">Subscribe to Our Services</h2>
        <div class="container" style="text-align: center;">
           Subscribe to enjoy exclusive features we offer on Tigris Pharmacy.
           <ul>
               <li>Product Discount</li>
               <li>Medicine Intake Reminder</li>
           </ul>
           
        <form action="addCustomerSubs">
            <button type="button" class="btn btn-success">Subscribe</button>
        </form>
        </div>
    </body>
</html>
