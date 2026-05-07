package com.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import com.dao.ProductDAO;

public class DeleteProductServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        ProductDAO.deleteProduct(id);

        response.sendRedirect("productdisplay.jsp");
    }
}