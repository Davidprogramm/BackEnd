package com.example.backend.Interface;

import com.example.backend.Entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoInterface extends JpaRepository<Pedido,Long> {
}
