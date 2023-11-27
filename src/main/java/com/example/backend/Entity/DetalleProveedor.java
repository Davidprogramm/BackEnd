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

    public DetalleProveedor() {
    }

    public DetalleProveedor(Long id_detalle_proveedor, int cantidad, double valorTotal, Producto producto, Proveedor proveedor) {
        this.id_detalle_proveedor = id_detalle_proveedor;
        this.cantidad = cantidad;
        this.valorTotal = valorTotal;
        this.producto = producto;
        this.proveedor = proveedor;
    }

    public Long getId_detalle_proveedor() {
        return id_detalle_proveedor;
    }

    public void setId_detalle_proveedor(Long id_detalle_proveedor) {
        this.id_detalle_proveedor = id_detalle_proveedor;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }
}
