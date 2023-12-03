package com.example.backend.Interface;

import com.example.backend.Entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PedidoInterface extends JpaRepository<Pedido,Long> {

    @Query(value="SELECT * from pedidos", nativeQuery = true)
    List<Object[]> findAllPedidos();

    @Query(value="SELECT dp.cantidad, dp.valor_total, pr.nombre FROM detalles_pedidos dp JOIN productos pr ON dp.id_producto = pr.id_producto WHERE dp.id_pedido = :id_pedido", nativeQuery = true)
    List<Object[]> findDetallesPedidos(String id_pedido);

    @Query(value="SELECT id_pedido, SUM(valor_total) FROM detalles_pedidos WHERE id_pedido =:id_pedido GROUP BY id_pedido;", nativeQuery = true)
    List<Object[]> factura(String id_pedido);

}
