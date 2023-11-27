package com.example.backend.Controlador;

import com.example.backend.Entity.Vendedor;
import com.example.backend.Service.VendedorService;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = {"*"})
public class VendedorControlador {
    private VendedorService vendedorService;

    public VendedorControlador(VendedorService vendedorService) {
        this.vendedorService = vendedorService;
    }

    @GetMapping("/listvendedores")
    public ResponseEntity<?> listVendedores() {
        Map<String, Object> response = new HashMap<>();
        try {
            return new ResponseEntity<>(vendedorService.allVendedor(), HttpStatus.OK);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al Buscar");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/addvendedor")
    public ResponseEntity<?> addVendedor(@RequestBody Vendedor vendedor) {
        Map<String, Object> response = new HashMap<>();
        try {
            return new ResponseEntity<>(vendedorService.addVendedor(vendedor), HttpStatus.CREATED);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al Agregar");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/updatevendedor")
    public ResponseEntity<?> updateVendedor(@RequestBody Vendedor vendedor) {
        Map<String, Object> response = new HashMap<>();
        try {
            return new ResponseEntity<>(vendedorService.updateVendedor(vendedor), HttpStatus.CREATED);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al Actualizar");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deletevendedor/{id}")
    public ResponseEntity<?> deleteVendedor(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();
        try {
            return new ResponseEntity<>(vendedorService.deleteVendedor(id), HttpStatus.OK);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al Borrar");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }
}
