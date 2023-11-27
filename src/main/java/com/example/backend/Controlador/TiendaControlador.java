package com.example.backend.Controlador;

import com.example.backend.Entity.Tienda;
import com.example.backend.Service.TiendaService;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = {"*"})
public class TiendaControlador {
    private TiendaService tiendaService;

    public TiendaControlador(TiendaService tiendaService) {
        this.tiendaService = tiendaService;
    }

    @GetMapping("/listtiendas")
    public ResponseEntity<?> listTiendas() {
        Map<String, Object> response = new HashMap<>();
        try {
            return new ResponseEntity<>(tiendaService.allTiendas(), HttpStatus.OK);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al Buscar");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/addtienda")
    public ResponseEntity<?> addTienda(@RequestBody Tienda tienda) {
        Map<String, Object> response = new HashMap<>();
        try {
            return new ResponseEntity<>(tiendaService.addTienda(tienda), HttpStatus.CREATED);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al Agregar");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/updatetienda")
    public ResponseEntity<?> updateTienda(@RequestBody Tienda tienda) {
        Map<String, Object> response = new HashMap<>();
        try {
            return new ResponseEntity<>(tiendaService.updateTienda(tienda), HttpStatus.CREATED);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al Actualizar");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deletetienda/{id_tienda}")
    public ResponseEntity<?> deleteTienda(@PathVariable Long id_tienda) {
        Map<String, Object> response = new HashMap<>();
        try {
            return new ResponseEntity<>(tiendaService.deleteTienda(id_tienda), HttpStatus.OK);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al Borrar");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }
}
