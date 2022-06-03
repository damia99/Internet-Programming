<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <link href="${contextPath}/resource/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="${contextPath}/resource/css/style.css" type="text/css">
</head>

    <body>
        <div class="nav">  
            <a href="index">
                <img src="img/logo.png" class="brand-logo" alt="">
            </a>
            <div class="nav-items">
                <div class="search">
                <input type="text" class="search-box" placeholder="search brand, product">
                <button class="search-btn">search</button>
                <a href="loginCustomer"><img src="img/user.png" alt=""></a>
                <a href="viewOrder"><img src="img/cart.png" alt=""></a>
            </div>
        </div>

        <ul class="links-container">
            <li class="link-item"><a href="medicine" class="link link-primary">Medicine</a></li>
            <li class="link-item"><a href="wellness" class="link link-primary">Wellness</a></li>
            <li class="link-item"><a href="personalCare" class="link link-primary">Personal Care</a></li>
            <li class="link-item"><a href="healthFood" class="link link-primary">Health Food</a></li>
            <li class="link-item"><a href="healthDevice" class="link link-primary">Healthcare Device</a></li>
            <li class="link-item"><a href="testKit" class="link link-primary">Test Kit</a></li>
        </ul>
        </div>
    </body>
</html>