package com.sena.gavi.jdbc.dao;

import com.sena.gavi.jdbc.entities.Productos;
import com.sena.gavi.jdbc.entities.Ventas;
import com.sena.gavi.jdbc.exceptions.DaoExceptions;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VentasImpl implements IVentasDao{

    private Connection conn;
    
    public VentasImpl (Connection conn) {
        this.conn = conn;
    }
    
    String INSERT = "INSERT INTO ventas(fecha, total, total_iva, user_id) VALUES (?, ?, ?, ?)";
    String GETONE = "SELECT id_venta, fecha, total, total_iva, user_id FROM ventas WHERE id_venta = ?";
    String UPDATE = "UPDATE ventas SET total = ?, total_iva = ? WHERE id_venta = ?";

    public void crearVenta(List<Productos> productos, double[] cantidad, Ventas v, Date fecha) throws DaoExceptions{
        DetalleVentaImpl detalleDao = new DetalleVentaImpl(conn);
        IProductosDao productoDao = new ProductosImpl(conn);
        double total = 0;
        try {
            insertar(v); //guardar venta
            total = detalleDao.crearDetalleVenta(productos, cantidad, 10, fecha); //guardar detalle de venta
            v.setTotal(total);
            v.setTotalIva(total*0.19);
            modificar(v, 10);
            
            conn.commit();
            System.out.println("Registros guardados en BD");
            
        } catch (SQLException e) {
            try {
                conn.rollback();
                e.printStackTrace();
            } catch (SQLException ex) {
                throw new DaoExceptions("No se guardó ningún registro");
            }finally {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    throw new DaoExceptions("Error");
                }
            }
        }
    }
    
    public Ventas convertir(ResultSet rs) throws SQLException{
        Date fecha = rs.getTime("fecha");
        double total = rs.getDouble("total");
        double totalIva = rs.getDouble("total_iva");
        int user = rs.getInt("user_id");
        Ventas venta =  new Ventas(total, totalIva, user);
        venta.setId(rs.getInt("id_venta"));
        venta.setFecha(fecha);
        return venta;
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
    public Ventas obtener(Integer id) throws DaoExceptions {
        PreparedStatement stat = null;
        ResultSet rs = null;
        Ventas v = null;
        try {
            stat =  conn.prepareStatement(GETONE);
            stat.setInt(1, id);
            rs = stat.executeQuery();
            if (rs.next()) {
                v = convertir(rs);
            }else {
                throw new DaoExceptions("Id no encontrado");
            }
        } catch (SQLException e) {
            throw new DaoExceptions("Error en SQL", e);
        }finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    new DaoExceptions("Error en SQL", ex);
                }
            }
            
            if (stat != null) {
                try {
                    stat.close();
                } catch (SQLException ex) {
                    new DaoExceptions("Error en SQL", ex);
                }
            }
        }
        
        return v;
    }
    
    @Override
    public void modificar(Ventas v, Integer id) throws DaoExceptions {
        PreparedStatement stat = null;
        try {
            stat = conn.prepareStatement(UPDATE);
            stat.setDouble(1, v.getTotal());
            stat.setDouble(2, v.getTotalIva());
            stat.setInt(3, id);
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
    public List<Ventas> obtenerTodos() throws DaoExceptions {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void eliminar(Integer id) throws DaoExceptions {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
