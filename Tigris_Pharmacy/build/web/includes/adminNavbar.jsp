<%-- 
    Document   : adminNavbar
    Created on : Jan 13, 2022, 12:36:49 PM
    Author     : Mhdrfq
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <nav class="navbar navbar-expand navbar-dark bg-dark">
        <div class="container-fluid">
            <a class="navbar-brand" href="adminViewProducts">Tigris Pharmacy Admin</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarsExample02" aria-controls="navbarsExample02" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
        
            <div class="collapse navbar-collapse" id="navbarsExample02">
                <ul class="navbar-nav me-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="adminViewProducts">Product Inventory</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="adminViewCustomers">Manage Users</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="adminViewForum">Manage Forum</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="adminViewSubscriptions">Manage Subscriptions</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="adminViewOrders">Manage Orders</a>
                    </li>
                </ul>
                
                <ul class="navbar-nav ml-auto">
                <li class="nav-item">
                    <a class="nav-link" href="adminLoginForm">Logout</a>
                </li>
                </ul>
 
            </div>
        </div>
    </nav>
</html>
