package com.sena.crud.jsp.logica;

import com.sena.crud.jsp.persistencia.ControladorPeristencia;
import java.util.Date;
import java.util.List;

public class Controlador {
    ControladorPeristencia controlPersis = new ControladorPeristencia();
    
    public void crearProducto(Date creadoEn, String codigo, String nombre, String categoria, 
            double costo, double iva, double precioVenta){
       
        Producto producto = new Producto();
        producto.setCodigo(codigo);
        producto.setNombre(nombre);
        producto.setCategoria(categoria);
        producto.setCosto(costo);
        producto.setIva(iva);
        producto.setPrecioVenta(precioVenta);
        producto.setCreadoEn(creadoEn);
        
        controlPersis.crearUsuario(producto);
    }

    public List<Producto> getProductos() {
        return controlPersis.getProductos();
    }
}
