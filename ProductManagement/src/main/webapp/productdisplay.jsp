<%@ page import="java.util.*,com.dao.ProductDAO,com.model.Product" %>

<!DOCTYPE html>
<html>
<head>
<title>Product List</title>

<!-- Bootstrap -->
<link rel="stylesheet"
 href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">

<!-- Bootstrap Icons -->
<link rel="stylesheet"
 href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.css">

</head>

<body class="container">

<!-- 🔹 TOP BAR -->
<div class="d-flex justify-content-between align-items-center mt-3">

    <!-- HOME BUTTON -->
    <a href="index.jsp" class="btn btn-outline-dark">
        <i class="bi bi-house-door"></i> Home
    </a>

    <h2>Product List</h2>

</div>

<!-- ADD PRODUCT BUTTON -->
<a href="productadd.jsp" class="btn btn-success mb-3"> + Add New Product</a>


<table class="table table-bordered">
<tr class="table-dark">
<th>ID</th>
<th>Name</th>
<th>Category</th>
<th>Price</th>
<th>Qty</th>
<th>Action</th>
</tr>

<%
List<Product> list = ProductDAO.getAllProducts();

for(Product p : list) {
%>

<tr>
<td><%=p.getProductID()%></td>
<td><%=p.getProductName()%></td>
<td><%=p.getCategory()%></td>
<td><%=p.getPrice()%></td>
<td><%=p.getQuantity()%></td>

<td>
<a href="DeleteProductServlet?id=<%=p.getProductID()%>" 
   class="btn btn-danger btn-sm">Delete</a>

<a href="productupdate.jsp?id=<%=p.getProductID()%>" 
   class="btn btn-warning btn-sm">Update</a>
</td>
</tr>

<% } %>

</table>

</body>
</html>