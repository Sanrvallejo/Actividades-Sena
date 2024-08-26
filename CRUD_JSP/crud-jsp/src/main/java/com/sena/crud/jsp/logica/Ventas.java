package com.sena.crud.jsp.logica;

//entidad ventas en bd

import java.util.Date;
import java.util.Map;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Ventas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Temporal(TemporalType.DATE)
    private Date creadoEn;
    
    
    private double subtotal;
    private double iva;
    private double total;

    @OneToMany(mappedBy = "venta")
    private Map<Producto, Double> productos; //se usa map para tener la posibilidad de gestionar cantidades en la misma lista o conjunto
    
    public Ventas() {
    }

    public Ventas(int id, Date creadoEn, Map<Producto, Double> productos, double subtotal, double iva, double total) {
        this.id = id;
        this.creadoEn = creadoEn;
        this.productos = productos;
        this.subtotal = subtotal;
        this.iva = iva;
        this.total = total;
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

    public Map<Producto, Double> getProductos() {
        return productos;
    }

    public void setProductos(Map<Producto, Double> productos) {
        this.productos = productos;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Ventas{");
        sb.append("id=").append(id);
        sb.append(", creadoEn=").append(creadoEn);
        sb.append(", productos=").append(productos);
        sb.append(", subtotal=").append(subtotal);
        sb.append(", iva=").append(iva);
        sb.append(", total=").append(total);
        sb.append('}');
        return sb.toString();
    }
    
    
    
}
