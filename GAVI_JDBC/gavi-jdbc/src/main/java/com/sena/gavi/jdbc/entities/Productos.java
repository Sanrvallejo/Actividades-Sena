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
    private int id;
    private String codigo;
    private String nombre;
    private double precio;
    private int existencias;
    private int user;
}
