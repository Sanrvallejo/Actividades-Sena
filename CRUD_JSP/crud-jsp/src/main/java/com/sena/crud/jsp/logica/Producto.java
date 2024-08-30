package com.sena.crud.jsp.logica;

//entidad producto para guarda en l bd

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Producto implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY) //generacion secuencial con los otros id
    private int id;
    
    @Temporal(TemporalType.DATE) //se formate en la bd dd//mm//aaaa
    private Date creadoEn;
    
    private String codigo;
    private String nombre;
    private String categoria;
    private double costo;
    private double iva;
    private double precioVenta;
    
    @ManyToOne
    private Ventas venta;

    public Producto() {
    }

    public Producto(int id, Date creadoEn, String codigo, String nombre, String categoria, double costo, double iva, double precioVenta, Ventas venta) {
        this.id = id;
        this.creadoEn = creadoEn;
        this.codigo = codigo;
        this.nombre = nombre;
        this.categoria = categoria;
        this.costo = costo;
        this.iva = iva;
        this.precioVenta = precioVenta;
        this.venta = venta;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCreadoEn() {
        return creadoEn;
    }

    public void setCreadoEn(Date creadoEn) {
        this.creadoEn = creadoEn;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public Ventas getVenta() {
        return venta;
    }

    public void setVenta(Ventas venta) {
        this.venta = venta;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Producto{");
        sb.append("id=").append(id);
        sb.append(", creadoEn=").append(creadoEn);
        sb.append(", codigo=").append(codigo);
        sb.append(", nombre=").append(nombre);
        sb.append(", categoria=").append(categoria);
        sb.append(", costo=").append(costo);
        sb.append(", iva=").append(iva);
        sb.append(", precioVenta=").append(precioVenta);
        sb.append(", venta=").append(venta);
        sb.append('}');
        return sb.toString();
    }
    

    
    
}
