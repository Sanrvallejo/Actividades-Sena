package com.sena.gavi.jdbc.dao;

import com.sena.gavi.jdbc.entities.Productos;
import com.sena.gavi.jdbc.entities.Ventas;
import com.sena.gavi.jdbc.exceptions.DaoExceptions;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

public class VentasImpl implements IVentasDao{

    private Connection conn;
    
    public VentasImpl (Connection conn) {
        this.conn = conn;
    }
    
    String INSERT = "INSERT INTO ventas(fecha, total, total_iva, user_id) VALUES (?, ?, ?, ?)";
    
    public void crearVenta(List<Productos> productos, double cantidad[], Ventas v) throws DaoExceptions{
        try {
            insertar(v);
            
        } catch (Exception e) {
        }
    }
    
    @Override
    public void insertar(Ventas v) throws DaoExceptions {
        PreparedStatement stat = null;
        try {
            stat = conn.prepareStatement(INSERT);
            //Aquí se convierte el Date de la clase Ventas que viene del paquete java.util.Date a un Date de sql: java.sql.Timestamp para manejar la incompatibilidad de tipos de dato
            stat.setTimestamp(1, new Timestamp(v.getFecha().getTime())); 
            stat.setDouble(2, v.getTotal());
            stat.setDouble(3, v.getTotalIva());
            stat.setDouble(4, v.getUser());
            if (stat.executeUpdate() == 0){
                throw new DaoExceptions("No se guardó el registro");
            }
        } catch (SQLException e) {
            throw new DaoExceptions("Error en SQL", e);
        }finally {
            if (stat != null) {
                try {
                    stat.close();
                } catch (SQLException e) {
                    throw new DaoExceptions("Error en SQL");
                }
            }
        }
    }

    @Override
    public void modificar(Ventas a, Integer id) throws DaoExceptions {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Ventas obtener(Integer id) throws DaoExceptions {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Ventas> obtenerTodos() throws DaoExceptions {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void eliminar(Integer id) throws DaoExceptions {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
