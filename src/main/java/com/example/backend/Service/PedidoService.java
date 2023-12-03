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

    public Pedido addPedido(Pedido pedido,Long id_vendedor, Long id_tienda) {
        Vendedor vendedor = vendedorInterface.findById(id_vendedor).orElse(null);
        Tienda tienda = tiendaInterface.findById(id_tienda).orElse(null);

if(vendedor !=null &&   tienda != null){
    pedido.setId_tienda(tienda);
    pedido.setId_vendedor(vendedor);
    pedidoInterface.save(pedido);

}
        return pedido;


    }


    public Pedido updatePedido(Pedido pedido, Long id_vendedor,Long id_tienda) {

       Pedido pedidoExistente = pedido;

       Vendedor vendedor= vendedorInterface.findById(id_vendedor).orElse(null);
       Tienda tienda=tiendaInterface.findById(id_tienda).orElse(null);

        if (pedidoExistente!=null && vendedor!=null && tienda !=null) {
            pedidoExistente.setFecha(pedido.getFecha());
            pedidoExistente.setForma_pago(pedido.getForma_pago());
            pedidoExistente.setEstado(pedido.getEstado());
            pedidoExistente.setId_vendedor(vendedor);
            pedidoExistente.setId_tienda(tienda);
            return pedidoInterface.save(pedidoExistente);
        } else {
            return null;
        }
    }

    public void deletePedido(Long id) {
        Pedido pedido=pedidoInterface.findById(id).orElse(null);
        pedidoInterface.deleteById(id);

    }

    public List<Object[]>findAllPedidos(){
        return  pedidoInterface.findAllPedidos();
    }

    public List <Object[]>findDetallesPedido(String id_pedido){return pedidoInterface.findDetallesPedidos(id_pedido);}
    public List <Object[]>factura(String id_pedido ){return pedidoInterface.factura(id_pedido);}
}
