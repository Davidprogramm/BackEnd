package com.example.backend.Interface;

import com.example.backend.Entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaInterface extends JpaRepository<Categoria,Long> {
}
