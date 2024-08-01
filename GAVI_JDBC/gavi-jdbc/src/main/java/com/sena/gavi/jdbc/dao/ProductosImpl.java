/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sena.gavi.jdbc.dao;

import com.sena.gavi.jdbc.entities.Productos;
import com.sena.gavi.jdbc.exceptions.DaoExceptions;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class ProductosImpl implements IProductosDao {

    private Connection conn;

    String INSERT = "INSERT INTO productos(codigo, nombre, precio, existencias, user_id) VALUES(?,?,?,?,?)";
    String GETALL = "SELECT id_producto, codigo, nombre, precio, existencias, user_id FROM productos";
    String GETONE = "SELECT id_producto, codigo, nombre, precio, existencias, user_id FROM productos WHERE id_producto = ?";
    String UPDATE = "UPDATE productos SET codigo = ?, nombre = ?, precio = ?, existencias = ?, user_id = ? WHERE id_producto = ?";
    String DELETE = "DELETE FROM productos WHERE id_producto = ?";
    
    //Constructor de clase que reciba una conexión para manipular la DB
    public ProductosImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insertar(Productos p) throws DaoExceptions {
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
        } finally {
            if (stat != null) {
                try {
                    stat.close();
                } catch (SQLException ex) {
                    throw new DaoExceptions("Error en SQL, ex");
                }
            }
        }
    }

    private Productos convertir(ResultSet rs) throws SQLException {
        String codigo = rs.getString("codigo");
        String nombre = rs.getString("nombre");
        double precio = rs.getDouble("precio");
        double existencias = rs.getDouble("existencias");
        Integer user = rs.getInt("user_id");
        Productos producto = new Productos(codigo, nombre, precio, existencias, user);
        producto.setId(rs.getInt("id_producto"));
        return producto;
    }

    @Override
    public Productos obtener(Integer id) throws DaoExceptions {
        PreparedStatement stat = null;
        ResultSet rs = null;
        Productos p = null;
        try {
            stat = conn.prepareStatement(GETONE);
            stat.setInt(1, id);
            rs = stat.executeQuery();
            if (rs.next()) {
                p = convertir(rs);
            } else {
                throw new DaoExceptions("Id no encontrado");
            }
        } catch (Exception e) {
            throw new DaoExceptions("Error en SQL", e);
        } finally {
            if (rs != null) try {
                rs.close();
            } catch (SQLException ex) {
                new DaoExceptions("Error en SQL", ex);
            }
            if (stat != null) try {
                stat.close();
            } catch (SQLException ex) {
                new DaoExceptions("Error en SQL", ex);
            }
        }

        return p;
    }

    @Override
    public List<Productos> obtenerTodos() throws DaoExceptions {
        PreparedStatement stat = null;
        ResultSet rs = null;
        List<Productos> productos = new ArrayList<>();
        try {
            stat = conn.prepareStatement(GETALL);
            rs = stat.executeQuery();
            while (rs.next()) {                
                productos.add(convertir(rs));
            }
        } catch (Exception e) {
            throw new DaoExceptions("Error en SQL", e);
        } finally {
            if (rs != null) try {
                rs.close();
            } catch (SQLException ex) {
                new DaoExceptions("Error en SQL", ex);
            }
            if (stat != null) try {
                stat.close();
            } catch (SQLException ex) {
                new DaoExceptions("Error en SQL", ex);
            }
        }

        return productos;
    }

    @Override
    public void modificar(Productos p, Integer id) throws DaoExceptions{
        PreparedStatement stat = null;
        try {
            stat = conn.prepareStatement(UPDATE);
            stat.setString(1, p.getCodigo());
            stat.setString(2, p.getNombre());
            stat.setDouble(3, p.getPrecio());
            stat.setDouble(4, p.getExistencias());
            stat.setInt(5, p.getUser());
            stat.setInt(6, id);
            if (stat.executeUpdate() == 0) {
                throw new DaoExceptions("La base de datos no guardó");
            };
        } catch (SQLException e) {
            throw new DaoExceptions("Error en SQL", e);
        } finally {
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
    public void eliminar(Integer id) throws DaoExceptions{
        PreparedStatement stat = null;
        Productos p = null;
        try {
            p = obtener(id);
            stat = conn.prepareStatement(DELETE);
            stat.setInt(1, p.getId());
            if (stat.executeUpdate() == 0) {
                throw new DaoExceptions("No se eliminó nada");
            }
        } catch (SQLException e) {
            throw new DaoExceptions("Error en SQL", e);
        }finally {
            if (stat != null) {
                try {
                    stat.close();
                } catch (SQLException e) {
                    throw new DaoExceptions("Error en SQL", e);
                }
            }
        }
    }

}
