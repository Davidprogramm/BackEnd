package com.example.backend.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "detalle_proveedores")
public class DetalleProveedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_detalle_proveedor;

    @Column(nullable = false)
    private int cantidad;
    @Column(nullable = false)
    private double valorTotal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_producto", nullable = false)
    private Producto producto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_proveedor", nullable = false)
    private Proveedor proveedor;


}
