package com.example.backend.Controlador;

import com.example.backend.Entity.Descuento;
import com.example.backend.Service.DescuentoService;
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
public class DescuentoControlador {
    private final DescuentoService descuentoService;

    public DescuentoControlador(DescuentoService descuentoService) {
        this.descuentoService = descuentoService;
    }

    @GetMapping("/listdescuentos")
    public ResponseEntity<?> listDescuentos() {
        Map<String, Object> response = new HashMap<>();
        try {
            return new ResponseEntity<>(descuentoService.allDescuentos(), HttpStatus.OK);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al Buscar Descuentos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getdescuento/{id}")
    public ResponseEntity<?> getDescuento(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();
        try {
            Optional<Descuento> descuento = descuentoService.findById(id);
            if (descuento.isPresent()) {
                return new ResponseEntity<>(descuento.get(), HttpStatus.OK);
            } else {
                response.put("mensaje", "Descuento no encontrado");
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al Buscar Descuento");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/adddescuento")
    public ResponseEntity<?> addDescuento(@RequestBody Descuento descuento) {
        Map<String, Object> response = new HashMap<>();
        try {
            return new ResponseEntity<>(descuentoService.addDescuento(descuento), HttpStatus.CREATED);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al Agregar Descuento");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/updatedescuento")
    public ResponseEntity<?> updateDescuento(@RequestBody Descuento descuento) {
        Map<String, Object> response = new HashMap<>();
        try {
            return new ResponseEntity<>(descuentoService.updateDescuento(descuento), HttpStatus.CREATED);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al Actualizar Descuento");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }
}
