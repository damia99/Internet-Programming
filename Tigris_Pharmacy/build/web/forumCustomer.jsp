<%-- 
    Document   : forumCustomer
    Created on : Jan 16, 2022, 9:36:31 PM
    Author     : nasrin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="bean.Forum"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Forum</title>
        <jsp:include page="includes/head.jsp"/>
    </head>
    <body>
        <jsp:include page="includes/nav.jsp"/>
        <main>
        <div class="container-fluid">
            <h4 class="mt-5 mb-4">Forum: Let's Talk</h4>
            <table class="table">
                <thead>
                    <tr>
                        <th scope="col">Entry ID</th>
                        <th scope="col">Topic</th>
                        <th scope="col">Message</th>
                        <th scope="col">Reply</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="entry" items="${forum}">
                    <tr>
                        <td>${entry.id}</td>
                        <td>${entry.topic}</td>
                        <td>${entry.message}</td>
                        <td>${entry.reply}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
        </main>
    </body>
</html>
