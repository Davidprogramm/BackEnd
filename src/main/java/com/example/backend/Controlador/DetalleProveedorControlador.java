package com.example.backend.Controlador;

import com.example.backend.Entity.DetalleProveedor;
import com.example.backend.Service.DetalleProveedorService;
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
public class DetalleProveedorControlador {
    private final DetalleProveedorService detalleProveedorService;

    public DetalleProveedorControlador(DetalleProveedorService detalleProveedorService) {
        this.detalleProveedorService = detalleProveedorService;
    }

    @GetMapping("/listdetallesproveedor")
    public ResponseEntity<?> listDetallesProveedor() {
        Map<String, Object> response = new HashMap<>();
        try {
            return new ResponseEntity<>(detalleProveedorService.allDetallesProveedor(), HttpStatus.OK);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al Buscar Detalles de Proveedor");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getdetalleproveedor/{id}")
    public ResponseEntity<?> getDetalleProveedor(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();
        try {
            Optional<DetalleProveedor> detalleProveedor = detalleProveedorService.findById(id);
            if (detalleProveedor.isPresent()) {
                return new ResponseEntity<>(detalleProveedor.get(), HttpStatus.OK);
            } else {
                response.put("mensaje", "Detalle de Proveedor no encontrado");
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al Buscar Detalle de Proveedor");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/adddetalleproveedor/{id_producto}/{id_proveedor}")
    public ResponseEntity<?> addDetalleProveedor(@RequestBody DetalleProveedor detalleProveedor, @PathVariable Long id_producto, @PathVariable Long id_proveedor) {
        Map<String, Object> response = new HashMap<>();
        try {
            return new ResponseEntity<>(detalleProveedorService.addDetalleProveedor(detalleProveedor, id_producto, id_proveedor), HttpStatus.CREATED);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al Agregar Detalle de Proveedor");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/updatedetalleproveedor")
    public ResponseEntity<?> updateDetalleProveedor(@RequestBody DetalleProveedor detalleProveedor) {
        Map<String, Object> response = new HashMap<>();
        try {
            return new ResponseEntity<>(detalleProveedorService.updateDetalleProveedor(detalleProveedor), HttpStatus.CREATED);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al Actualizar Detalle de Proveedor");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deletedetalleproveedor/{id}")
    public ResponseEntity<?> deleteDetalleProveedor(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();
        try {
            detalleProveedorService.deleteDetalleProveedor(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al Borrar Detalle de Proveedor");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }
}
