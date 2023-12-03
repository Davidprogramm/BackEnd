package com.example.backend.Service;

import com.example.backend.Entity.Usuario;
import com.example.backend.Interface.UsuarioInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

  public List<Usuario> findAllUsuarios(){return  usuarioInterface.findAll();}
  public List<Usuario> allUsuario (Usuario usuario){
        return usuarioInterface.findAll();
  }
  public Usuario updateUsuario(Usuario usuario){
      Optional <Usuario> usuarioOptional=usuarioInterface.findById(usuario.getId_usuario());

      if(usuarioOptional.isPresent()){
          Usuario usuarioExistente= usuarioOptional.get();
          usuarioExistente.setCorreo(usuario.getCorreo());
          usuarioExistente.setNombre(usuario.getNombre());
          usuarioExistente.setRol(usuario.getRol());
    return usuarioInterface.save(usuarioExistente);

      }
      return null;
  }

  public Usuario deleteUsuario(Long id_usuario){
     Usuario usuario=usuarioInterface.findById(id_usuario).orElse(null);
     usuarioInterface.deleteById(id_usuario);
     return usuario;

  }
}
