package com.example.backend.Interface;

import com.example.backend.Entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductoInterface extends JpaRepository<Producto,Long> {

    @Query(value="select * from productos", nativeQuery = true)
    List<Object[]> findAllProductos();
}
