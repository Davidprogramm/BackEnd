package com.example.backend.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
@Entity
@Table(name = "descuentos")
public class Descuento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_descuento;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private double porcentaje;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date fechaInicio;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date fechaFin;

    @OneToMany(mappedBy = "descuento", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Producto> productos = new HashSet<>();

    public Descuento() {
    }

    public Descuento(Long id_descuento, String nombre, double porcentaje, Date fechaInicio, Date fechaFin, Set<Producto> productos) {
        this.id_descuento = id_descuento;
        this.nombre = nombre;
        this.porcentaje = porcentaje;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.productos = productos;
    }

    public Long getId_descuento() {
        return id_descuento;
    }

    public void setId_descuento(Long id_descuento) {
        this.id_descuento = id_descuento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(double porcentaje) {
        this.porcentaje = porcentaje;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Set<Producto> getProductos() {
        return productos;
    }

    public void setProductos(Set<Producto> productos) {
        this.productos = productos;
    }
}
