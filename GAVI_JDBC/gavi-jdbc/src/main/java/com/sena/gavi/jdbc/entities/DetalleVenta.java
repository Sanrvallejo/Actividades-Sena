package com.sena.gavi.jdbc.entities;

import java.sql.Time;
import java.util.Date;
import lombok.Data;

@Data
public class DetalleVenta {
    private Integer id;
    private int venta;
    private int producto;
    private Date fecha;
    private double cantidad;

    public DetalleVenta() {
    }
    
    public DetalleVenta(int venta, int producto, Date fecha, double cantidad) {
        this.venta = venta;
        this.producto = producto;
        this.fecha = fecha;
        this.cantidad = cantidad;
    }
}
