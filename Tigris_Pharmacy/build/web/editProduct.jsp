<%-- 
    Document   : editProduct
    Created on : Jan 18, 2022, 7:13:19 PM
    Author     : Mhdrfq
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>edit product</title>
        <jsp:include page="includes/head.jsp"/>
    </head>
    <body>
        <jsp:include page="includes/adminNavbar.jsp"/>
        
        <main>
        <div class="container-fluid">
            <form method="post" action="updateProduct">
                <div class="col-sm-6 mb-3 mt-5 mb-4">
                    <h4>Edit product information</h4>
                </div>
    
                <input type="hidden" name="pid" value="${product.id}">
                
                <div class="col-sm-6 mb-3">
                    <label for="product_name" class="form-label">Product name</label>
                    <input type="text" name="name" class="form-control" id="name" placeholder="${product.name}" required>
                </div>
                
                <div class="col-sm-2 mb-3">
                    <label for="category" class="form-label pr-2">Category</label>
                    <select class="form-select" name="category">
                        <option selected>${product.category}</option>
                        <option value="medicine">medicine</option>
                        <option value="wellness">wellness</option>
                        <option value="personal_care">personal care</option>
                        <option value="health_food">health food</option>
                        <option value="health_device">healthcare device</option>
                        <option value="test_kit">test kit</option>
                    </select>
                </div>
    
                <div class="col-sm-6 mb-3">
                    <label for="description" class="form-label">Description</label>
                    <textarea rows="4" name="description" class="form-control" id="description" placeholder="${product.description}" required></textarea>
                </div>

                <div class="col-sm-2 mb-3">
                    <label for="price" class="form-label">Price (RM)</label>
                    <input type="number" name="price" step="0.01" class="form-control" id="price" placeholder="${product.price}" required>
                </div>
                
                <div class="col-sm-2 mb-3">
                    <label for="stock" class="form-label">Stock</label>
                    <input type="number" name="stock" class="form-control" id="stock" placeholder="${product.stock}" required>
                </div>
                
                <div class="col-sm-2 mb-3">
                    <img src="data:image/jpg;base64,${product.base64Image}" width="300" height="300"/>
                </div>
                
                <div class="col-sm-2 mb-3">
                    <label for="image" class="form-label">Image</label>
                    <input type="file" name="image" class="form-control" id="image" accept="image/*">
                </div>

                <div class="col-sm-2 mb-3 mt-5">
                    <a href="adminViewProducts" class="btn btn-secondary px-4" >Back</a>
                    <button class="btn btn-success px-4" type="submit" value="submit">Submit</button>
                </div>
                
            </form>

        </div>
        </main>
    </body>
</html>
