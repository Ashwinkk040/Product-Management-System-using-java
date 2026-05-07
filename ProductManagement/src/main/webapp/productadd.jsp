<!DOCTYPE html>
<html>
<head>
<title>Add Product</title>

<!-- Bootstrap -->
<link rel="stylesheet"
 href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">

</head>

<body class="bg-light">

<div class="container mt-5">

    <div class="card shadow p-4">

        <h3 class="text-center mb-4">+ Add Product</h3>

        <form action="AddProductServlet" method="post">

            <div class="mb-3">
                <label class="form-label">Product ID</label>
                <input type="number" name="id" class="form-control" required>
            </div>

            <div class="mb-3">
                <label class="form-label">Product Name</label>
                <input type="text" name="name" class="form-control" required>
            </div>

            <div class="mb-3">
                <label class="form-label">Category</label>
                <input type="text" name="category" class="form-control" required>
            </div>

            <div class="mb-3">
                <label class="form-label">Price</label>
                <input type="number" step="0.01" name="price" class="form-control" required>
            </div>

            <div class="mb-3">
                <label class="form-label">Quantity</label>
                <input type="number" name="quantity" class="form-control" required>
            </div>

            <div class="d-flex justify-content-between">

                <a href="index.jsp" class="btn btn-secondary"><- Back</a>

                <button type="submit" class="btn btn-success">
                    Add Product
                </button>

            </div>

        </form>

    </div>

</div>

</body>
</html>