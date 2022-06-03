<%-- 
    Document   : adminViewOrderList
    Created on : Jan 23, 2022, 10:58:48 PM
    Author     : Mhdrfq
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="bean.Order"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Order List</title>
        <jsp:include page="includes/head.jsp"/>
    </head>
    <body>
        <jsp:include page="includes/adminNavbar.jsp"/>
        
        <main>
        <div class="container-fluid">
            <h4 class="mt-5 mb-4">List of all orders</h4>
            <table class="table">
                <thead>
                    <tr>
                      <th scope="col">Order ID</th>
                      <th scope="col">Customer ID</th>
                      <th scope="col">Product ID</th>
                      <th scope="col">Quantity</th>
                      <th scope="col">Order status</th>
                      <th scope="col">Action</th>
                    </tr>
                </thead>
                <tbody>
                    
                    <c:forEach var="order" items="${orders}">
                    <tr>
                    <td>${order.order_id}</td>
                    <td>${order.customer_id}</td>
                    <td>${order.product_id}</td>
                    <td>${order.quantity}</td>
                    <td>
                        <c:choose>
                            <c:when test="${order.order_status != false}">
                                Approved 
                            </c:when>    
                            <c:otherwise>
                                Unapproved 
                            </c:otherwise>   
                        </c:choose>
                    </td>
                    <td class="d-flex">
                        <form action="approveOrderForm" class="px-2">
                            <button class="btn btn-primary" name="oid" value="${order.order_id}"><i class="far fa-check-circle"></i></button>
                        </form>
                        <form action="">
                            <button onclick="return confirm('Are you sure you want to delete the order?')" 
                                    class="btn btn-danger" name="oid" value="${order.order_id}"><i class="far fa-trash-alt"></i></button>
                        </form>
                    </td>
                    </tr>
                    </c:forEach>

                </tbody>
            </table>
        </div>
        </main>
        
    </body>
</html>
