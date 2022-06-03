<%-- 
    Document   : UploadFile
    Created on : Jan 7, 2022, 3:00:17 AM
    Author     : haza
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/prescription.css" rel="stylesheet" type="text/css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <title>Prescription Upload</title>
    </head>
  
    <body> 
        <center style="margin-top: 200px;">
            <div class="container">
                <i class="fa fa-cloud-upload" style="font-size:150px;color:blue"></i><br><br>
            <form action="uploads" method="post" enctype="multipart/form-data">
                <input type="file" name="file" />
                <input type="submit" value="Upload" />
            </form>          
            </div>
        </center>
    </body>
</html>