package com.sena.gavi.jdbc;

import com.sena.gavi.jdbc.dao.IProductosDao;
import com.sena.gavi.jdbc.dao.ProductosImpl;
import com.sena.gavi.jdbc.dao.VentasImpl;
import com.sena.gavi.jdbc.entities.Productos;
import com.sena.gavi.jdbc.entities.Ventas;
import com.sena.gavi.jdbc.exceptions.DaoExceptions;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GaviJdbc {

    public static void main(String[] args) throws DaoExceptions, SQLException {
        Connection conexion = null;

        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/gavi-jdbc", "root", "root");
        } catch (Exception e) {
            e.getMessage();
        }

        //Método para crear productos
        /*IProductosDao productoDao = new ProductosImpl(conexion);
        //Productos producto = new Productos("PRD051", "Arroz Roa", 2550, 50, 1);
        try {
            productoDao.eliminar(2);
        } catch (DaoExceptions ex) {
            throw new DaoExceptions("Error en SQL");
        }*/
        //Método para crear cventas completas.
        try {
            conexion.setAutoCommit(false);
        } catch (SQLException ex) {
            throw new SQLException(ex);
        }

        double[] cantidad;
        List<Productos> productos = new ArrayList<>();
        IProductosDao productoDao = new ProductosImpl(conexion);
        VentasImpl ventasDao = new VentasImpl(conexion);

        //Listar productos a vender con su cantidad
        productos.add(productoDao.obtener(1));
        productos.add(productoDao.obtener(3));
        productos.add(productoDao.obtener(4));

        cantidad = new double[productos.size()];
        cantidad[0] = 4;
        cantidad[1] = 1;
        cantidad[2] = 3.3;

        //Crear venta
        ventasDao.crearVenta(productos, cantidad, new Ventas(0, 0, 1), new Date());
    }
}
