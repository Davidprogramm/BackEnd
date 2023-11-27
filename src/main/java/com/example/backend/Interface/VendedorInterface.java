package com.example.backend.Interface;

import com.example.backend.Entity.Vendedor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendedorInterface extends JpaRepository<Vendedor,Long> {

}
