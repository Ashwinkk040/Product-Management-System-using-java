<!DOCTYPE html>
<html>
<head>
<title>Product Management System</title>

<!-- Bootstrap -->
<link rel="stylesheet"
 href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">

</head>

<body class="bg-light">

<div class="container mt-5">

    <div class="text-center mb-5">
        <h1 class="fw-bold"> Product Management System</h1>
        <p class="text-muted">Manage your products efficiently</p>
    </div>

    <div class="row">

        <!-- ADD PRODUCT -->
        <div class="col-md-4">
            <div class="card shadow text-center p-4">
                <h4> Add Product</h4>
                <p>Add new products to the system</p>
                <a href="productadd.jsp" class="btn btn-success">Go</a>
            </div>
        </div>

        <!-- VIEW PRODUCTS -->
        <div class="col-md-4">
            <div class="card shadow text-center p-4">
                <h4> View Products</h4>
                <p>View, update or delete products</p>
                <a href="productdisplay.jsp" class="btn btn-primary">Go</a>
            </div>
        </div>

        <!-- REPORTS -->
        <div class="col-md-4">
            <div class="card shadow text-center p-4">
                <h4> Reports</h4>
                <p>Generate product reports</p>
                <a href="report_form.jsp" class="btn btn-warning">Go</a>
            </div>
        </div>

    </div>

</div>

</body>
</html>