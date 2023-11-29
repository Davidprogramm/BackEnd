package com.example.backend.Interface;

import com.example.backend.Entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PedidoInterface extends JpaRepository<Pedido,Long> {

    @Query(value="select * from pedidos", nativeQuery = true)
    List<Object[]> findAllPedidos();


}
