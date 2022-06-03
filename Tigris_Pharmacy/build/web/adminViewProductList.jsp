<%-- 
    Document   : adminViewProductList
    Created on : Jan 13, 2022, 12:36:13 PM
    Author     : Mhdrfq
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="bean.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product List</title>
        <jsp:include page="includes/head.jsp"/>
    </head>
    <body>
        <jsp:include page="includes/adminNavbar.jsp"/>
        
        <main>
        <div class="container-fluid">
            <h4 class="mt-5 mb-4">List of all products</h4>
            <a href="addProductForm" class="btn btn-success mb-3">Add a new product</a>
            <table class="table">
                <thead>
                    <tr>
                      <th scope="col">Product ID</th>
                      <th scope="col">Product name</th>
                      <th scope="col">Product price</th>
                      <th scope="col">Available stock</th>
                      <th scope="col">Action</th>
                    </tr>
                </thead>
                <tbody>
                    
                    <c:forEach var="product" items="${products}">
                    <tr>
                    <td>${product.id}</td>
                    <td>${product.name}</td>
                    <td>${product.price}</td>
                    <td>${product.stock}</td>
                    <td class="d-flex">
                        <form action="editProductForm" class="px-2">
                            <button class="btn btn-warning" name="pid" value="${product.id}"><i class="far fa-edit"></i></button>
                        </form>
                        <form action="deleteProduct">
                            <button onclick="return confirm('Are you sure you want to delete')" 
                                    class="btn btn-danger" name="pid" value="${product.id}"><i class="far fa-trash-alt"></i></button>
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
