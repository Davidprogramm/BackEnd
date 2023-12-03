package com.example.backend.Service;

import com.example.backend.Entity.Usuario;
import com.example.backend.Interface.UsuarioInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    private final UsuarioInterface usuarioInterface;

    @Autowired
    public UsuarioService (UsuarioInterface usuarioInterface){this.usuarioInterface=usuarioInterface;}

  public Usuario buscarUsuario(String correo){
      return usuarioInterface.findByCorreo(correo);

  }
  public Usuario addUsuario(Usuario  usuario){
        return usuarioInterface.save(usuario);
  }
}
