/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.sena.gavi.jdbc;

import com.sena.gavi.jdbc.dao.IProductosDao;
import com.sena.gavi.jdbc.dao.ProductosImpl;
import com.sena.gavi.jdbc.entities.Productos;
import com.sena.gavi.jdbc.exceptions.DaoExceptions;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class GaviJdbc {

    public static void main(String[] args) throws DaoExceptions {
        Connection conexion = null;

        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/gavi-jdbc", "root", "root");
        } catch (Exception e) {
            e.getMessage();
        }
        
        IProductosDao productoDao = new ProductosImpl(conexion);
        //Productos producto = new Productos("PRD051", "Arroz Roa", 2550, 50, 1);
        try {
            productoDao.eliminar(2);
        } catch (DaoExceptions ex) {
            throw new DaoExceptions("Error en SQL");
        }
    }
}
