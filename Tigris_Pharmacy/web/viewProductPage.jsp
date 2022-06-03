<!DOCTYPE html>
<html lang="en">
<head>
    <title>View Product Page</title>
    <jsp:include page="includes/head.jsp"/>
</head>
<body>
    <nav class="navbar">
        <jsp:include page="includes/nav.jsp"/>
    </nav>
    
    <div class="container">
      
        <main class="mt-3">
            
            <div class="mb-4">
                <a href="index"> <button type="button" class="btn btn-md btn-secondary" ><i class="fa fa-chevron-left"></i> Back</button> </a>
            </div>
            <form action="addOrder">
            <div class="card shadow-sm">
                <img src="data:image/jpg;base64,${product.base64Image}" width="225" height="225"></img>

                <div class="card-body">
                    <h3 class="mb-sm-4">${product.name}</h3>
                    <h6 class="card-subtitle mb-2 text-muted">${product.stock} in stock</h6>
                    <div class="d-flex justify-content-between align-items-center mb-sm-4">
                        <div class="btn-group">
                        <select type="button" class="btn btn-sm btn-outline-primary" name="qty">
                            <option selected value="1" >1</option>
                            <option value="2">2</option>
                            <option value="3">3</option>
                        </select>
                            
                        <button type="button" class="btn btn-sm btn-primary" name="pid" value="${product.id}" >Add to cart</button>
                        </div>
                    </div>
                    
                    <div>
                        <p>${product.description}</p>
                    </div>   
                </div>     
             </div>
            </form>
        </main>
    </div>
    <footer class="mt-5">
        <jsp:include page="includes/footer.jsp"/>
    </footer>
</body>
</html>