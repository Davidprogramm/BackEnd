package com.example.backend.Interface;

import com.example.backend.Entity.Descuento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DescuentoInterface extends JpaRepository<Descuento,Long> {
}
