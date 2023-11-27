package com.example.backend.Controlador;

import com.example.backend.Entity.DetallePedido;
import com.example.backend.Service.DetallePedidoService;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = {"*"})
public class DetallePedidoControlador {
    private final DetallePedidoService detallePedidoService;

    public DetallePedidoControlador(DetallePedidoService detallePedidoService) {
        this.detallePedidoService = detallePedidoService;
    }

    @GetMapping("/listdetallespedido")
    public ResponseEntity<?> listDetallesPedido() {
        Map<String, Object> response = new HashMap<>();
        try {
            return new ResponseEntity<>(detallePedidoService.allDetallesPedido(), HttpStatus.OK);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al Buscar Detalles de Pedido");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/adddetallepedido/{id_pedido}/{id_producto}")
    public ResponseEntity<?> addDetallePedido(@RequestBody DetallePedido detallePedido,
                                              @PathVariable Long id_pedido, @PathVariable Long id_producto) {
        Map<String, Object> response = new HashMap<>();
        try {
            return new ResponseEntity<>(detallePedidoService.addDetallePedido(detallePedido, id_pedido, id_producto), HttpStatus.CREATED);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al Agregar Detalle de Pedido");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/updatedetallepedido")
    public ResponseEntity<?> updateDetallePedido(@RequestBody DetallePedido detallePedido,@PathVariable Long id_pedido,@PathVariable Long id_producto) {
        Map<String, Object> response = new HashMap<>();
        try {
            return new ResponseEntity<>(detallePedidoService.updateDetallePedido(detallePedido,id_pedido,id_producto), HttpStatus.CREATED);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al Actualizar Detalle de Pedido");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deletedetallepedido/{id}")
    public ResponseEntity<?> deleteDetallePedido(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();
        try {
            detallePedidoService.deleteDetallePedido(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al Borrar Detalle de Pedido");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }
}
