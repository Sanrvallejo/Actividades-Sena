package com.sena.crud.jsp.logica;

//entidad producto para guarda en l bd
public class Producto {
    private int id;
    private String codigo;
    private String nombre;
    private String categoria;
    private double costo;
    private double iva;
    private double precioVenta;

    public Producto() {
    }

    public Producto(int id, String codigo, String nombre, String categoria, double costo, double iva, double precioVenta) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
        this.categoria = categoria;
        this.costo = costo;
        this.iva = iva;
        this.precioVenta = precioVenta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Producto{");
        sb.append("id=").append(id);
        sb.append(", codigo=").append(codigo);
        sb.append(", nombre=").append(nombre);
        sb.append(", categoria=").append(categoria);
        sb.append(", costo=").append(costo);
        sb.append(", iva=").append(iva);
        sb.append(", precioVenta=").append(precioVenta);
        sb.append('}');
        return sb.toString();
    }
    
    
}
