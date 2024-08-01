/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sena.gavi.jdbc.dao;

import com.sena.gavi.jdbc.entities.Productos;
import com.sena.gavi.jdbc.exceptions.DaoExceptions;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class ProductosImpl implements IProductosDao{
    
    private Connection conn;
    
    String INSERT = "INSERT INTO productos(codigo, nombre, precio, existencias, user_id) VALUES(?,?,?,?,?)";
    
    //Constructor de clase que reciba una conexión para manipular la DB
    public ProductosImpl(Connection conn){
        this.conn = conn;
    }

    @Override
    public void insertar(Productos p) throws DaoExceptions{
        PreparedStatement stat = null; //No se usa Statement para evitar SQLInjection
        try {
            stat = conn.prepareStatement(INSERT);
            stat.setString(1, p.getCodigo());
            stat.setString(2, p.getNombre());
            stat.setDouble(3, p.getPrecio());
            stat.setDouble(4, p.getExistencias());
            stat.setInt(5, p.getUser());
            if (stat.executeUpdate() == 0) {
                throw new DaoExceptions("La base de datos no guardó");
            };
        } catch (SQLException e) {
            throw new DaoExceptions("Error en SQL", e);
        }finally {
            if (stat != null) {
                try {
                    stat.close();
                } catch (SQLException ex) {
                    throw new DaoExceptions("Error en SQL, ex");
                }
            }
        }
        
    }

    @Override
    public void modificar(Productos a) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Productos obtener(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Productos> obtenerTodos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void eliminar(Productos a) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
