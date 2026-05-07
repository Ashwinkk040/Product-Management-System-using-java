<%@ page import="java.util.*,com.model.Product" %>

<!DOCTYPE html>
<html>
<head>
<title>Report Result</title>

<!-- Bootstrap -->
<link rel="stylesheet"
 href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">

</head>

<body class="bg-light">

<div class="container mt-5">

    <div class="card shadow p-4">

        <!-- ✅ UPDATED HEADING -->
        <h2 class="text-center mb-2">Report Results</h2>
        <p class="text-muted text-center">Filtered Results</p>

        <!-- BACK BUTTON -->
        <div class="mb-3 text-end">
            <a href="report_form.jsp" class="btn btn-primary">Back</a>
        </div>

        <!-- TABLE -->
        <table class="table table-bordered table-striped text-center">
            <thead class="table-dark">
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Category</th>
                    <th>Price</th>
                    <th>Quantity</th>
                </tr>
            </thead>

            <tbody>

            <%
            List<Product> list = (List<Product>) request.getAttribute("list");

            if(list != null && !list.isEmpty()) {
                for(Product p : list) {
            %>

                <tr>
                    <td><%=p.getProductID()%></td>
                    <td><%=p.getProductName()%></td>
                    <td><%=p.getCategory()%></td>
                    <td><%=p.getPrice()%></td>
                    <td><%=p.getQuantity()%></td>
                </tr>

            <%
                }
            } else {
            %>

                <tr>
                    <td colspan="5" class="text-danger fw-bold">
                        No records found
                    </td>
                </tr>

            <%
            }
            %>

            </tbody>
        </table>

    </div>

</div>

</body>
</html>