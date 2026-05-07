package com.servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class DisplayProductsServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher rd = request.getRequestDispatcher("productdisplay.jsp");
        rd.forward(request, response);
    }
}