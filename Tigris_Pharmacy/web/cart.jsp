<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="bean.Product"%>
<%@page import="java.util.ArrayList"%>
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
    
    <div class="container">
        <h4>My Cart</h4>
        <table> 
            <c:forEach var="product" items="${products}">
            <tr>
                <td rowspan="2"><img src="data:image/jpg;base64,${product.base64Image} class="product-thumb" alt=""> </td>
                <td><p class="product-brand">${product.name}</p>
                    <span class="price">RM ${product.price}</span>
                </td>       
            </tr>
        
            <tr>
                <td><label for="pass-quantity" class="pass-quantity">Quantity</label>
                    <input class="form-control" type="number" value="1" min="1"> </td>
                <td style="padding: 25px;"><button class="btn"><i class="fa fa-trash"></i>Delete</button></td>
            </tr>
            </c:forEach>
        </table>               
 
    </body>
</html>