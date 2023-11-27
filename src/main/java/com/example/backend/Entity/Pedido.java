package com.example.backend.Entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "pedidos")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_pedido;
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Column(nullable = false, length = 50)
    private String forma_pago;
    @Column(nullable = false, length = 50)
    private String estado;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_vendedor", referencedColumnName = "id_vendedor", nullable = false)
    @JsonIgnore
    private Vendedor id_vendedor;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_sucursal")
    @JsonIgnore
    private Tienda id_sucursal;



}