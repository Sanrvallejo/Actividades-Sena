/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.sena.gavi.jdbc.dao;

import com.sena.gavi.jdbc.exceptions.DaoExceptions;
import java.util.List;

/**
 *
 * @author Usuario
 */
public interface IDao <T, K>{
    void insertar(T a)throws DaoExceptions;
    void modificar (T a);
    T obtener(K id);
    List<T> obtenerTodos();
    void eliminar(T a);
}
