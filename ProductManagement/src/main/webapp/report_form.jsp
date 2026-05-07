<!DOCTYPE html>
<html>
<head>
<title>Generate Report</title>

<link rel="stylesheet"
 href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>

<body class="bg-light">

<div class="container mt-5">
    <div class="card shadow p-4">

        <h3 class="text-center mb-4">Generate Report</h3>

        <form action="ReportCriteriaServlet" method="post">

            <!-- SELECT REPORT TYPE -->
            <div class="mb-3">
                <label class="form-label">Select Report Type</label>
                <select name="type" class="form-control" required>
                    <option value="">-- Select --</option>
                    <option value="price">Price Greater Than</option>
                    <option value="category">Category</option>
                    <option value="top">Top N Products</option>
                </select>
            </div>

            <!-- PRICE -->
            <div class="mb-3">
                <label>Enter Minimum Price</label>
                <input type="number" step="0.01" name="price" class="form-control">
            </div>

            <!-- CATEGORY -->
            <div class="mb-3">
                <label>Enter Category</label>
                <input type="text" name="category" class="form-control">
            </div>

            <!-- TOP N -->
            <div class="mb-3">
                <label>Enter N (Top Products)</label>
                <input type="number" name="limit" class="form-control">
            </div>

            <div class="d-flex justify-content-between">
                <a href="index.jsp" class="btn btn-secondary">Back</a>
                <button type="submit" class="btn btn-primary">Generate</button>
            </div>

        </form>
    </div>
</div>

</body>
</html>