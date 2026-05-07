package com.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.*;
import javax.servlet.http.*;

import com.dao.ProductDAO;
import com.model.Product;

public class ReportServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Get category from form
        String category = request.getParameter("category");

        // Get all products
        List<Product> list = ProductDAO.getAllProducts();

        // Filter products by category
        List<Product> result = new ArrayList<>();

        for (Product p : list) {
            if (p.getCategory().equalsIgnoreCase(category)) {
                result.add(p);
            }
        }

        // Send filtered list to JSP
        request.setAttribute("list", result);

        // Forward to result page
        RequestDispatcher rd = request.getRequestDispatcher("report_result.jsp");
        rd.forward(request, response);
    }
}