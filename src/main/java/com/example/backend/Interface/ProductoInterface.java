package com.example.backend.Interface;

import com.example.backend.Entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoInterface extends JpaRepository<Producto,Long> {
}
