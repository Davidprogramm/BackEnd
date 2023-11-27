package com.example.backend.Interface;

import com.example.backend.Entity.DetalleProveedor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetalleProveedorInterface extends JpaRepository<DetalleProveedor,Long> {
}
