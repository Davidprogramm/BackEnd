package com.example.backend.Interface;

import com.example.backend.Entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioInterface extends JpaRepository<Usuario,Long> {

    Usuario findByCorreo (String correo);

}
