<%-- 
    Document   : deliveryservice
    Created on : Jan 17, 2022, 9:46:54 AM
    Author     : haza
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" 
        integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" 
        crossorigin="anonymous">
        <link rel="stylesheet" href="css/prescription.css/">
        <link rel="stylesheet" href="css/home.css" type="text/css">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" 
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
        
        <title>Delivery Service</title>
    </head>
    <body>
        <header class="hero-section">
            <div class="content">
                <img src="img/logo.png" class="logo" alt="">
                <p class="sub-heading">Delivery Service</p>
            </div>
        </header><br><br><br><br><br><br><br>
    <center>
       
        <section style="border-style:solid; width:30%;" class="collection">
            <a class="collection">
                <form name="deliveryService" method="post" action="deliveryServlet">
                    <label for="delivery" style="font: Times New Roman;"><br><br><br><b>Choose your preference shipping method:</b></label><br>

                <select name="delivery" id="delivery">
                    <option value="Delivery">Delivery</option>
                    <option value="Self-pick up">Self-pick up</option>
                </select><br><br>
                
                <label for="delivery" style="font: Times New Roman;"><br><br><b>Set your delivery time:</b></label><br>
                <select name="time" id="time">
                    <option value="Anytime">Anytime</option>
                    <option value="During office hours">During office hours</option>
                </select><br><br>
                
                <input type="submit" value="Submit">
                </form>
            </a><br><br><br>
        </section>
       
    </center><br><br><br><br><br><br><br>
   <footer></footer>
        <script src="js/footer.js"></script>
    </body>
</html>
