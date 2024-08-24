/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sena.gavi.jdbc.entities;

import lombok.Data;

/**
 *
 * @author Usuario
 */

@Data
public class Productos {
    private Integer id;
    private String codigo;
    private String nombre;
    private double precio;
    private double existencias;
    private int user;

    public Productos(String codigo, String nombre, double precio, double existencias, int user) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.existencias = existencias;
        this.user = user;
    }
    
    
}
