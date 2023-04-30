package com.example.owncdi;

import com.example.owncdi.model.Category;
import com.example.owncdi.model.Product;
import com.example.owncdi.repository.imp.ProductRepostoryImp;
import com.example.owncdi.service.impl.CatalogueService;
import com.example.owncdi.service.impl.ProductServiceImpl;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;

@WebServlet(name = "MainServlet", value = "/MainServlet")
public class MainServlet extends HttpServlet {
    @Inject
    @Named("Service")
    private ProductServiceImpl service;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(service);
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        try {
            service.getlist().forEach(element->out.println(element.getProduct_name()));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
