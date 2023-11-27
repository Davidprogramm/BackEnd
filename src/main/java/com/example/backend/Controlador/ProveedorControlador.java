package com.example.backend.Controlador;

import com.example.backend.Entity.Proveedor;
import com.example.backend.Service.ProveedorService;
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
public class ProveedorControlador {
    private final ProveedorService proveedorService;

    public ProveedorControlador(ProveedorService proveedorService) {
        this.proveedorService = proveedorService;
    }

    @GetMapping("/listproveedores")
    public ResponseEntity<?> listProveedores() {
        Map<String, Object> response = new HashMap<>();
        try {
            return new ResponseEntity<>(proveedorService.allProveedores(), HttpStatus.OK);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al Buscar Proveedores");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getproveedor/{id}")
    public ResponseEntity<?> getProveedor(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();
        try {
            Optional<Proveedor> proveedor = proveedorService.findById(id);
            if (proveedor.isPresent()) {
                return new ResponseEntity<>(proveedor.get(), HttpStatus.OK);
            } else {
                response.put("mensaje", "Proveedor no encontrado");
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al Buscar Proveedor");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/addproveedor")
    public ResponseEntity<?> addProveedor(@RequestBody Proveedor proveedor) {
        Map<String, Object> response = new HashMap<>();
        try {
            return new ResponseEntity<>(proveedorService.addProveedor(proveedor), HttpStatus.CREATED);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al Agregar Proveedor");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/updateproveedor")
    public ResponseEntity<?> updateProveedor(@RequestBody Proveedor proveedor) {
        Map<String, Object> response = new HashMap<>();
        try {
            return new ResponseEntity<>(proveedorService.updateProveedor(proveedor), HttpStatus.CREATED);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al Actualizar Proveedor");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deleteproveedor/{id}")
    public ResponseEntity<?> deleteProveedor(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();
        try {
            proveedorService.deleteProveedor(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al Borrar Proveedor");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }
}
