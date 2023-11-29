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
    @JoinColumn(name = "id_tienda")
    @JsonIgnore
    private Tienda id_tienda;

    public Pedido() {
    }

    public Pedido(Long id_pedido, Date fecha, String forma_pago, String estado, Vendedor id_vendedor, Tienda id_sucursal) {
        this.id_pedido = id_pedido;
        this.fecha = fecha;
        this.forma_pago = forma_pago;
        this.estado = estado;
        this.id_vendedor = id_vendedor;
        this.id_tienda = id_tienda;
    }

    public Long getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(Long id_pedido) {
        this.id_pedido = id_pedido;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getForma_pago() {
        return forma_pago;
    }

    public void setForma_pago(String forma_pago) {
        this.forma_pago = forma_pago;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Vendedor getId_vendedor() {
        return id_vendedor;
    }

    public void setId_vendedor(Vendedor id_vendedor) {
        this.id_vendedor = id_vendedor;
    }

    public Tienda getId_sucursal() {
        return id_tienda;
    }

    public void setId_sucursal(Tienda id_sucursal) {
        this.id_tienda = id_sucursal;
    }
}