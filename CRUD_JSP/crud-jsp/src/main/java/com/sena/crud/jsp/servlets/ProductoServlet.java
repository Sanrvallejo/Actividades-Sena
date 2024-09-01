package com.sena.crud.jsp.servlets;

import com.sena.crud.jsp.logica.Controlador;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ProductoServlet", urlPatterns = {"/ProductoServlet"})
public class ProductoServlet extends HttpServlet {
    
    Controlador control =  new Controlador();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        String codigoProducto = request.getParameter("codigoProducto");
        String nombreProducto = request.getParameter("nombreProducto");
        double costoProducto = Double.parseDouble(request.getParameter("costoProducto"));
        double iva = Double.parseDouble(request.getParameter("iva"));
        double precioVenta = Double.parseDouble(request.getParameter("precioVenta"));

        String categoria = request.getParameter("categoria");

        Date creadoEn = new Date();
        
        control.crearProducto(creadoEn, codigoProducto, nombreProducto, categoria, costoProducto, iva, precioVenta);
        response.sendRedirect("index.jsp");
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
