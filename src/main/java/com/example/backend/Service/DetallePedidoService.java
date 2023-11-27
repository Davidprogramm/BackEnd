package com.example.backend.Service;

import com.example.backend.Entity.*;
import com.example.backend.Interface.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DetallePedidoService {

    private final DetallePedidoInterface detallePedidoInterface;
    private  final ProductoInterface productoInterface;
    private final PedidoInterface pedidoInterface;

    @Autowired
    public DetallePedidoService(DetallePedidoInterface detallePedidoInterface,PedidoInterface pedidoInterface,ProductoInterface productoInterface) {
        this.detallePedidoInterface = detallePedidoInterface;
        this.pedidoInterface=pedidoInterface;
        this.productoInterface=productoInterface;
    }

    public List<DetallePedido> allDetallesPedido() {
        return detallePedidoInterface.findAll();
    }

    public Optional<DetallePedido> findById(Long id) {
        return detallePedidoInterface.findById(id);
    }

    public DetallePedido addDetallePedido(DetallePedido detallePedido,Long id_pedido,Long id_producto) {
        Pedido pedido = pedidoInterface.findById(id_pedido).orElse(null);
        Producto producto = productoInterface.findById(id_producto).orElse(null);
        if(pedido !=null && producto !=null){
            detallePedido.setPedido(pedido);
            detallePedido.setProducto(producto);
            return detallePedidoInterface.save(detallePedido);

        }else {
            return null;
        }

    }

    public DetallePedido updateDetallePedido(DetallePedido detallePedido,Long id_pedido,Long id_producto) {
        Optional<DetallePedido> detallePedidoOptional = detallePedidoInterface.findById(detallePedido.getId_detalle_pedido());
        Pedido pedido=pedidoInterface.findById(id_pedido).orElse(null);
        Producto producto=productoInterface.findById(id_producto).orElse(null);
        if (detallePedidoOptional.isPresent() && pedido!=null && producto !=null) {
            DetallePedido detallePedidoExistente = detallePedidoOptional.get();
            detallePedidoExistente.setCantidad(detallePedido.getCantidad());
            detallePedidoExistente.setValorTotal(detallePedido.getValorTotal());
            detallePedidoExistente.setPedido(pedido);
            detallePedidoExistente.setProducto(producto);


            return detallePedidoInterface.save(detallePedidoExistente);
        } else {
            return null;
        }
    }

    public void deleteDetallePedido(Long id) {
        detallePedidoInterface.deleteById(id);
    }
}
