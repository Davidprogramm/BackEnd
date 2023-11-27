package com.example.backend.Service;

import com.example.backend.Entity.Pedido;
import com.example.backend.Interface.PedidoInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    private final PedidoInterface pedidoInterface;

    @Autowired
    public PedidoService(PedidoInterface pedidoInterface) {
        this.pedidoInterface = pedidoInterface;
    }

    public List<Pedido> allPedidos() {
        return pedidoInterface.findAll();
    }

    public Optional<Pedido> findById(Long id) {
        return pedidoInterface.findById(id);
    }

    public Pedido addPedido(Pedido pedido) {
        return pedidoInterface.save(pedido);
    }

    public Pedido updatePedido(Pedido pedido) {
        Optional<Pedido> pedidoOptional = pedidoInterface.findById(pedido.getId_pedido());

        if (pedidoOptional.isPresent()) {
            Pedido pedidoExistente = pedidoOptional.get();
            pedidoExistente.setFecha(pedido.getFecha());
            pedidoExistente.setForma_pago(pedido.getForma_pago());
            pedidoExistente.setEstado(pedido.getEstado());
            pedidoExistente.setId_vendedor(pedido.getId_vendedor());
            pedidoExistente.setId_sucursal(pedido.getId_sucursal());
            return pedidoInterface.save(pedidoExistente);
        } else {
            return null;
        }
    }

    public void deletePedido(Long id) {
        pedidoInterface.deleteById(id);
    }
}
