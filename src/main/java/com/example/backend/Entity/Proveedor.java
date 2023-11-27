package com.example.backend.Entity;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "proveedores")
public class Proveedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_proveedor;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(nullable = false, length = 100)
    private String direccion;

    @Column(nullable = false, length = 50)
    private String telefono;

    @Column(nullable = false, length = 100)
    private String email;

    @OneToMany(mappedBy = "proveedor", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<DetalleProveedor> detallesProveedores = new HashSet<>();

    public Proveedor() {
    }

    public Proveedor(Long id_proveedor, String nombre, String direccion, String telefono, String email, Set<DetalleProveedor> detallesProveedores) {
        this.id_proveedor = id_proveedor;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.detallesProveedores = detallesProveedores;
    }

    public Long getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(Long id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
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

    public Set<DetalleProveedor> getDetallesProveedores() {
        return detallesProveedores;
    }

    public void setDetallesProveedores(Set<DetalleProveedor> detallesProveedores) {
        this.detallesProveedores = detallesProveedores;
    }
}
