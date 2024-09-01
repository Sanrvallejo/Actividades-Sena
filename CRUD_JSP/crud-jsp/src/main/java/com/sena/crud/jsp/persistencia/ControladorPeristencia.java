package com.sena.crud.jsp.persistencia;

import com.sena.crud.jsp.logica.Producto;
import java.util.List;

public class ControladorPeristencia {
    ProductoJpaController productoJPA =  new ProductoJpaController();
    VentasJpaController ventaJPA = new VentasJpaController();

    public void crearUsuario(Producto producto) {
        productoJPA.create(producto);
    }

    public List<Producto> getProductos() {
        return productoJPA.findProductoEntities();
    }
}
