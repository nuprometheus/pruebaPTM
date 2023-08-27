package com.ptm.fullstackbackendPTM.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Producto {
    @Id
    @GeneratedValue
    private Long id;
    private String nombre;
    private String descripcion;
    private Double precio;
    private Long cantidadStock;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Long getCantidadStock() {
        return cantidadStock;
    }

    public void setCantidadStock(Long cantidadStock) {
        this.cantidadStock = cantidadStock;
    }
}
