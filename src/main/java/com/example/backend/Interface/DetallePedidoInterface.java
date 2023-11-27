package com.example.backend.Interface;

import com.example.backend.Entity.DetallePedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetallePedidoInterface extends JpaRepository<DetallePedido,Long> {
}
