<%
int id = Integer.parseInt(request.getParameter("id"));
response.sendRedirect("DeleteProductServlet?id=" + id);
%>