package com.servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.model.Product;
import com.dao.ProductDAO;

public class UpdateProductServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Product p = new Product();

        p.setProductID(Integer.parseInt(request.getParameter("id")));
        p.setProductName(request.getParameter("name"));
        p.setCategory(request.getParameter("category"));
        p.setPrice(Double.parseDouble(request.getParameter("price")));
        p.setQuantity(Integer.parseInt(request.getParameter("quantity")));

        ProductDAO.updateProduct(p);

        response.sendRedirect("productdisplay.jsp");
    }
}