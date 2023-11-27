package com.example.backend.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="tiendas")
public class Tienda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_tienda;

    @Column(nullable = false, length = 60)
    private String nombre_tienda;

    @Column(nullable = false, length = 60)
    private String encargado;

    @Column(nullable = false, length = 100)
    private String direccion;

    @Column(nullable = false, length = 50)
    private String municipio;

    @Column(nullable = false, length = 50)
    private String departamento;

    @Column(nullable = false, length = 15)
    private String telefono;

    @Column(nullable = false, length = 100)
    private String email;

    @OneToMany(mappedBy = "id_sucursal", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Pedido> pedidos = new HashSet<>();

    public Tienda() {
    }

    public Tienda(Long id_tienda, String nombre_tienda, String encargado, String direccion, String municipio, String departamento, String telefono, String email, Set<Pedido> pedidos) {
        this.id_tienda = id_tienda;
        this.nombre_tienda = nombre_tienda;
        this.encargado = encargado;
        this.direccion = direccion;
        this.municipio = municipio;
        this.departamento = departamento;
        this.telefono = telefono;
        this.email = email;
        this.pedidos = pedidos;
    }

    public Long getId_tienda() {
        return id_tienda;
    }

    public void setId_tienda(Long id_tienda) {
        this.id_tienda = id_tienda;
    }

    public String getNombre_tienda() {
        return nombre_tienda;
    }

    public void setNombre_tienda(String nombre_tienda) {
        this.nombre_tienda = nombre_tienda;
    }

    public String getEncargado() {
        return encargado;
    }

    public void setEncargado(String encargado) {
        this.encargado = encargado;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(Set<Pedido> pedidos) {
        this.pedidos = pedidos;
    }
}
