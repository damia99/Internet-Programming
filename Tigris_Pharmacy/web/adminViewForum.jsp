<%-- 
    Document   : adminViewForum
    Created on : Jan 16, 2022, 9:36:31 PM
    Author     : Mhdrfq
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="bean.Forum"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Forum entries</title>
        <jsp:include page="includes/head.jsp"/>
    </head>
    <body>
        <jsp:include page="includes/adminNavbar.jsp"/>
        <main>
        <div class="container-fluid">
            <h4 class="mt-5 mb-4">List of customer forum entries</h4>
            <table class="table">
                <thead>
                    <tr>
                        <th scope="col">Entry ID</th>
                        <th scope="col">Topic</th>
                        <th scope="col">Message</th>
                        <th scope="col">Reply</th>
                        <th scope="col">Action</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="entry" items="${forum}">
                    <tr>
                        <td>${entry.id}</td>
                        <td>${entry.topic}</td>
                        <td>${entry.message}</td>
                        <td>${entry.reply}</td>
                        <td class="d-flex">
                            <form action="replyForumForm" class="px-2">
                                <button class="btn btn-primary" name="eid" value="${entry.id}"><i class="fas fa-reply"></i></button>
                            </form>
                            <form action="deleteEntry">
                            <button onclick="return confirm('Are you sure you want to delete forum entry?')" 
                                    class="btn btn-danger" name="eid" value="${entry.id}"><i class="far fa-trash-alt"></i></button>
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
