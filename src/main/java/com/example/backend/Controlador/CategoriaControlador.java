package com.example.backend.Controlador;

import com.example.backend.Entity.Categoria;
import com.example.backend.Service.CategoriaService;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.zip.DataFormatException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = {"*"})
public class CategoriaControlador {
    private CategoriaService  categoriaService;
    public CategoriaControlador(CategoriaService categoriaService){
        this.categoriaService=categoriaService;
    }
    @GetMapping("/listcategoria")
    public ResponseEntity<?> listCategoria(){
        Map<String,Object> response= new HashMap<>();
try{
    return  new ResponseEntity<>(categoriaService.allCategorias(),HttpStatus.OK);
}catch (DataAccessException e){

    response.put("mensaje","Error al Buscar");
    response.put("error",e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
    return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
}

    }
    @PostMapping ("/addcategoria")
    public  ResponseEntity<?>addCategoria(@RequestBody Categoria categoria){
        Map<String,Object> response= new HashMap<>();
try{
    return new ResponseEntity<>(categoriaService.addCategoria(categoria),HttpStatus.CREATED);
}catch (DataAccessException e){
    response.put("mensaje","Error al Agregar");
    response.put("error",e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
    return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
}
    }

    @PostMapping("/updatecategoria")
    public ResponseEntity<?>updateCategoria(@RequestBody Categoria categoria){
        Map<String,Object> response= new HashMap<>();
        try{
            return new ResponseEntity<>(categoriaService.updateCategoria(categoria),HttpStatus.CREATED);
        }catch (DataAccessException e){
            response.put("mensaje","Error al Actualizar");
            response.put("error",e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/deletecategoria/{id_categoria}")
    public  ResponseEntity<?>deleteCategoria(@PathVariable Long id_categoria){
        Map<String,Object> response= new HashMap<>();
try{
    return new ResponseEntity<>(categoriaService.deleteCategoria(id_categoria),HttpStatus.OK);
}catch (DataAccessException e){
    response.put("mensaje","Error al Borrar");
    response.put("error",e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
    return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
}
    }


}
