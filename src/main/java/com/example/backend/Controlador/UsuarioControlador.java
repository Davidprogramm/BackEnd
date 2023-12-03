package com.example.backend.Controlador;

import com.example.backend.Entity.Usuario;
import com.example.backend.Service.UsuarioService;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = {"*"})
public class UsuarioControlador {

    private UsuarioService usuarioService;
    public  UsuarioControlador ( UsuarioService usuarioService){
        this.usuarioService=usuarioService;
    }
    @GetMapping("/obtenerUsuario/{correo}")
    public ResponseEntity<?> obtenerUsuario(@PathVariable String correo){
        Map<String, Object> response = new HashMap<>();
        try{
            return new ResponseEntity<>(usuarioService.buscarUsuario(correo), HttpStatus.OK);
        }catch (DataAccessException e){
            response.put("mensaje", "Error al Buscar");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }


    }
    @PostMapping("/addusuario")
    public ResponseEntity<?> addUsuario(@RequestBody Usuario usuario){
        Map<String, Object> response = new HashMap<>();
try {
    return  new ResponseEntity<>(usuarioService.addUsuario(usuario),HttpStatus.OK);
}catch (DataAccessException e){
    response.put("mensaje", "Error al Añadir");
    response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
    return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
}
    }


    }
