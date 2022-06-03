<%-- 
    Document   : adminViewSubList
    Created on : Jan 23, 2022, 12:37:50 PM
    Author     : Mhdrfq
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="bean.Subscription"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Subscription List</title>
        <jsp:include page="includes/head.jsp"/>
    </head>
    <body>
        <jsp:include page="includes/adminNavbar.jsp"/>
        
        <main>
        <div class="container-fluid">
            <h4 class="mt-5 mb-4">List of all Subscriptions</h4>
            <table class="table">
                <thead>
                    <tr>
                      <th scope="col">Subscription ID</th>
                      <th scope="col">Username</th>
                      <th scope="col">Medication</th>
                      <th scope="col">Time</th>
                    </tr>
                </thead>
                <tbody>
                    
                    <c:forEach var="sub" items="${subs}">
                    <tr>
                    <td>${sub.id}</td>
                    <td>${sub.username}</td>
                    <td>${sub.medication}</td>
                    <td>${sub.time}</td>
                    <td class="d-flex">
                        <form action="editSubscriptionForm" class="px-2">
                            <button class="btn btn-warning" name="sid" value="${sub.id}"><i class="far fa-edit"></i></button>
                        </form>
                        <form action="deleteSubscription">
                            <button onclick="return confirm('Are you sure you want to end subscription')" 
                                    class="btn btn-danger" name="sid" value="${sub.id}"><i class="far fa-trash-alt"></i></button>
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
