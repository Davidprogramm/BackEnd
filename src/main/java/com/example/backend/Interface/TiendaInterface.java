package com.example.backend.Interface;

import com.example.backend.Entity.Tienda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TiendaInterface extends JpaRepository<Tienda,Long> {
}
