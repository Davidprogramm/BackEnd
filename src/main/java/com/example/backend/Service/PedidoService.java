package com.example.backend.Service;

import com.example.backend.Entity.Pedido;
import com.example.backend.Entity.Tienda;
import com.example.backend.Entity.Vendedor;
import com.example.backend.Interface.PedidoInterface;
import com.example.backend.Interface.TiendaInterface;
import com.example.backend.Interface.VendedorInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    private final PedidoInterface pedidoInterface;
    private final VendedorInterface vendedorInterface;
    private final TiendaInterface tiendaInterface;

    @Autowired
    public PedidoService(PedidoInterface pedidoInterface,VendedorInterface vendedorInterface,TiendaInterface tiendaInterface) {
        this.pedidoInterface = pedidoInterface;
        this.tiendaInterface=tiendaInterface;
        this.vendedorInterface=vendedorInterface;
    }

    public List<Pedido> allPedidos() {
        return pedidoInterface.findAll();
    }

    public Optional<Pedido> findById(Long id) {
        return pedidoInterface.findById(id);
    }

    public Pedido addPedido(Pedido pedido, Long id_vendedor, Long id_sucursal) {
        Vendedor vendedor = new Vendedor();
        Tienda sucursal = new Tienda();

        vendedor = vendedorInterface.findById(id_vendedor).orElse(null);
        sucursal = tiendaInterface.findById(id_sucursal).orElse(null);

        if (vendedor != null && sucursal != null) {
            pedido.setId_vendedor(vendedor);
            pedido.setId_sucursal(sucursal);
            return pedidoInterface.save(pedido);
        } else {
            return null;
        }
    }


    public Pedido updatePedido(Pedido pedido, Long id_tienda,Long id_vendedor) {
        Optional<Pedido> pedidoOptional = pedidoInterface.findById(pedido.getId_pedido());
       Vendedor vendedor= vendedorInterface.findById(id_vendedor).orElse(null);
       Tienda tienda=tiendaInterface.findById(id_tienda).orElse(null);

        if (pedidoOptional.isPresent() && vendedor!=null && tienda !=null) {
            Pedido pedidoExistente = pedidoOptional.get();
            pedidoExistente.setFecha(pedido.getFecha());
            pedidoExistente.setForma_pago(pedido.getForma_pago());
            pedidoExistente.setEstado(pedido.getEstado());
            pedidoExistente.setId_vendedor(vendedor);
            pedidoExistente.setId_sucursal(tienda);
            return pedidoInterface.save(pedidoExistente);
        } else {
            return null;
        }
    }

    public void deletePedido(Long id) {
        pedidoInterface.deleteById(id);
    }

    public List<Object[]>findAllPedidos(){
        return  pedidoInterface.findAllPedidos();
    }
}
