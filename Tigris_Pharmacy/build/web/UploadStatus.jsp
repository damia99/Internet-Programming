<%-- 
    Document   : UploadStatus
    Created on : Jan 7, 2022, 8:37:01 AM
    Author     : haza
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://fonts.googleapis.com/css?family=Nunito+Sans:400,400i,700,900&display=swap" rel="stylesheet">
        <link href="css/prescription.css" rel="stylesheet" type="text/css">
        <title>Upload Status</title>
    </head>
  
    <body> 
        <center>
        <div class="card">
            <div style="border-radius:200px; height:200px; width:200px; background: #F8FAF5; margin:0 auto;">
            <i class="checkmark">✓</i>
        </div>
        <div id="result">
            <h1>${requestScope["message"]}</h1>
        </div>
        <form action="index.html" method="post">
                <input type="submit" value="Done" />
        </form> 
        </div>
        </center>
    </body>
</html>
