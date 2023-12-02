package com.example.backend.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "detalles_pedidos")
public class DetallePedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_detalle_pedido;
    @Column(nullable = false)
    private int cantidad;
    @Column(nullable = false)
    private int valor_total;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_pedido", referencedColumnName = "id_pedido", nullable = false)
    private Pedido pedido;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_producto", referencedColumnName = "id_producto", nullable = false)
    private Producto producto;

    public DetallePedido() {
    }

    public DetallePedido(Long id_detalle_pedido, int cantidad, int valor_total, Pedido pedido, Producto producto) {
        this.id_detalle_pedido = id_detalle_pedido;
        this.cantidad = cantidad;
        this.valor_total = valor_total;
        this.pedido = pedido;
        this.producto = producto;
    }

    public Long getId_detalle_pedido() {
        return id_detalle_pedido;
    }

    public void setId_detalle_pedido(Long id_detalle_pedido) {
        this.id_detalle_pedido = id_detalle_pedido;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getValorTotal() {
        return valor_total;
    }

    public void setValorTotal(int valorTotal) {
        this.valor_total = valorTotal;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
}
