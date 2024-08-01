/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sena.gavi.jdbc.entities;

import java.sql.Time;
import java.util.Date;
import lombok.Data;

/**
 *
 * @author Usuario
 */
@Data
public class DetalleVenta {
    private Integer id;
    private int venta;
    private int producto;
    private Date fecha;
    private double cantidad;
    private double subtotal;
}
