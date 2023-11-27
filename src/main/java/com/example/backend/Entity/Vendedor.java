package com.example.backend.Entity;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "vendedores")
public class Vendedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_vendedor;

    @Column(nullable = false, length = 50, unique = true)
    private String identificacion;

    @Column(nullable = false, length = 60)
    private String nombre;

    @Column(nullable = false, length = 60)
    private String apellido;

    @Column(nullable = false, length = 100)
    private String direccion;

    @Column(nullable = false, length = 50, unique = true)
    private String telefono;

    @Column(nullable = false, length = 100)
    private String email;

    @OneToMany(mappedBy = "id_vendedor", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Pedido> pedidos = new HashSet<>();

    public Vendedor() {
    }

    public Vendedor(Long id_vendedor, String identificacion, String nombre, String apellido, String direccion, String telefono, String email, Set<Pedido> pedidos) {
        this.id_vendedor = id_vendedor;
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.pedidos = pedidos;
    }

    public Long getId_vendedor() {
        return id_vendedor;
    }

    public void setId_vendedor(Long id_vendedor) {
        this.id_vendedor = id_vendedor;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
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

    public Set<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(Set<Pedido> pedidos) {
        this.pedidos = pedidos;
    }
}
