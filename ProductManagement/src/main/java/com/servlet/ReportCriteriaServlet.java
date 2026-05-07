package com.servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.*;
import javax.servlet.http.*;

import com.dao.ProductDAO;
import com.model.Product;

public class ReportCriteriaServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String type = request.getParameter("type");
        List<Product> list = null;

        try {

            if ("price".equals(type)) {
                double price = Double.parseDouble(request.getParameter("price"));
                list = ProductDAO.getProductsByPrice(price);

            } else if ("category".equals(type)) {
                String category = request.getParameter("category");
                list = ProductDAO.getProductsByCategory(category);

            } else if ("top".equals(type)) {
                int limit = Integer.parseInt(request.getParameter("limit"));
                list = ProductDAO.getTopProducts(limit);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        request.setAttribute("list", list);
        RequestDispatcher rd = request.getRequestDispatcher("report_result.jsp");
        rd.forward(request, response);
    }
}