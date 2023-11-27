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
}
