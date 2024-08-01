/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sena.gavi.jdbc.entities;

import java.util.Date;
import lombok.Data;

/**
 *
 * @author Usuario
 */
@Data
public class Ventas {
    private Integer id;
    private Date fecha;
    private double total;
    private double totalIva;
    private int user;
}
