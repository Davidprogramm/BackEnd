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
}
