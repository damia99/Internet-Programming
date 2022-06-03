<%-- 
    Document   : adminViewUserList
    Created on : Jan 16, 2022, 9:02:43 PM
    Author     : Mhdrfq
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="bean.Customer"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User list</title>
        <jsp:include page="includes/head.jsp"/>
    </head>
    <body>
        <jsp:include page="includes/adminNavbar.jsp"/>
        <main>
        <div class="container-fluid">
            <h4 class="mt-5 mb-4">List of all Registered Customers</h4>
            <table class="table">
                <thead>
                    <tr>
                        <th scope="col">Customer ID</th>
                        <th scope="col">Full name</th>
                        <th scope="col">Email</th>
                        <th scope="col">Phone</th>
                        <th scope="col">Address</th>
                        <th scope="col">Action</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="customer" items="${customers}">
                    <tr>
                        <td>${customer.id}</td>
                        <td>${customer.firstname} ${customer.lastname}</td>
                        <td>${customer.email}</td>
                        <td>${customer.phone}</td>
                        <td>${customer.address}</td>
                        <td class="d-flex">
                            <form action="editCustomerForm" class="px-2">
                                <button class="btn btn-warning" name="cid" value="${customer.id}"><i class="far fa-edit"></i></button>
                            </form>
                            <form action="deleteCustomer">
                                <button onclick="return confirm('Are you sure you want to delete customer?')" 
                                        class="btn btn-danger" name="cid" value="${customer.id}"><i class="far fa-trash-alt"></i></button>
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
