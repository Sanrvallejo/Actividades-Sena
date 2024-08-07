package com.sena.gavi.jdbc.dao;

import com.sena.gavi.jdbc.entities.DetalleVenta;
import com.sena.gavi.jdbc.entities.Productos;
import com.sena.gavi.jdbc.entities.Ventas;
import com.sena.gavi.jdbc.exceptions.DaoExceptions;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DetalleVentaImpl implements IDetalleVentaDao {

    private Connection conn;

    public DetalleVentaImpl(Connection conn) {
        this.conn = conn;
    }

    String INSERT = "INSERT INTO detalle_venta(venta, producto, cantidad, fecha) VALUES (?, ?, ?, ?)";

    public void crearDetalleVenta(List<Productos> productos, int cantidad[], int id_venta, Date fecha) throws DaoExceptions {
        DetalleVenta d = new DetalleVenta();
        double subtotal = 0;
        d.setVenta(id_venta);
        d.setFecha(fecha);
        int i = 0;
        for (Productos p : productos) {
            d.setProducto(p.getId());
            d.setCantidad(cantidad[i]);
            i++;
            insertar(d);
        }
    }

    @Override
    public void insertar(DetalleVenta d) throws DaoExceptions {
        PreparedStatement stat = null;
        try {
            stat = conn.prepareStatement(INSERT);
            stat.setInt(1, d.getVenta());
            stat.setInt(2, d.getProducto());
            stat.setDouble(3, d.getCantidad());
            stat.setTimestamp(4, new Timestamp(d.getFecha().getTime()));
            if (stat.executeUpdate() == 0) {
                throw new DaoExceptions("El registró no se guardó");
            }
        } catch (SQLException ex) {
            throw new DaoExceptions("Error en SQL", ex);
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

    @Override
    public void modificar(DetalleVenta a, Integer id) throws DaoExceptions {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public DetalleVenta obtener(Integer id) throws DaoExceptions {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<DetalleVenta> obtenerTodos() throws DaoExceptions {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void eliminar(Integer id) throws DaoExceptions {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
