<%-- 
    Document   : viewProfile
    Created on : Jan 20, 2022, 12:56:45 AM
    Author     : nasrin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="bean.Customer"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Profile</title>
        <jsp:include page="includes/head.jsp"/>
    </head>
    <body>
        <jsp:include page="includes/nav.jsp"/>
        <main>
        <div class="container-fluid">
            <h4 class="mt-5 mb-4">Your profile information</h4>
            <table class="table">
                <thead>
                    <tr>
                        <th scope="col">Customer ID</th>
                        <th scope="col">Full name</th>
                        <th scope="col">Email</th>
                        <th scope="col">Phone</th>
                        <th scope="col">Address</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>${customer.id}</td>
                        <td>${customer.firstname} ${customer.lastname}</td>
                        <td>${customer.email}</td>
                        <td>${customer.phone}</td>
                        <td>${customer.address}</td>
                        <td class="d-flex">
                            <form action="editProfile" class="px-2">
                                <button class="btn btn-warning" name="cid" value="${customer.id}"><i class="far fa-edit"></i></button>
                            </form>
                        </td>
                    </tr>
                    
                </tbody>
            </table>
        </div>
        </main>
    </body>
</html>
