package com.example.backend.Interface;

import com.example.backend.Entity.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProveedorInterface extends JpaRepository<Proveedor,Long> {
}
