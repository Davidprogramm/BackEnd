package com.example.backend.Controlador;

import com.example.backend.Entity.Pedido;
import com.example.backend.Service.PedidoService;
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
public class PedidoControlador {
    private PedidoService pedidoService;

    public PedidoControlador(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @GetMapping("/listpedidos")
    public ResponseEntity<?> listPedidos() {
        Map<String, Object> response = new HashMap<>();
        try {
            return new ResponseEntity<>(pedidoService.allPedidos(), HttpStatus.OK);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al Buscar");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/addpedido/{id_vendedor}/{id_sucursal}")
    public ResponseEntity<?> addPedido(@RequestBody Pedido pedido, @PathVariable Long id_vendedor, @PathVariable Long id_sucursal) {
        Map<String, Object> response = new HashMap<>();
        try {
            return new ResponseEntity<>(pedidoService.addPedido(pedido, id_vendedor, id_sucursal), HttpStatus.CREATED);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al Agregar");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }


    @PostMapping("/updatepedido/{id_vendedor}/{id_sucursal}")
    public ResponseEntity<?> updatePedido(@RequestBody Pedido pedido, @PathVariable Long id_vendedor, @PathVariable Long id_sucursal) {
        Map<String, Object> response = new HashMap<>();
        try {
            return new ResponseEntity<>(pedidoService.updatePedido(pedido, id_vendedor, id_sucursal), HttpStatus.CREATED);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al Actualizar");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deletepedido/{id}")
    public ResponseEntity<?> deletePedido(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();
        try {
            pedidoService.deletePedido(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al Borrar");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }
}
