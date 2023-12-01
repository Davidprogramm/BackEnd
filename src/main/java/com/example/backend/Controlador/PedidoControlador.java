package com.example.backend.Controlador;

import com.example.backend.Entity.Pedido;
import com.example.backend.Service.PedidoService;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

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

    @PostMapping("/addpedido/{id_vendedor}/{id_tienda}")
    public ResponseEntity<?> addPedido(@RequestBody Pedido pedido,@PathVariable Long id_vendedor, @PathVariable Long id_tienda) {
        Map<String, Object> response = new HashMap<>();
        try {
            return new ResponseEntity<>(pedidoService.addPedido(pedido, id_vendedor, id_tienda), HttpStatus.CREATED);

        }catch (DataAccessException e){
            response.put("mensaje", "Error al Agregar");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }

    }


    @PostMapping("/updatepedido/{id_vendedor}/{id_tienda}")
    public ResponseEntity<?> updatePedido(@RequestBody Pedido pedido, @PathVariable Long id_vendedor, @PathVariable Long id_tienda) {
        Map<String, Object> response = new HashMap<>();
        try {
            return new ResponseEntity<>(pedidoService.updatePedido(pedido, id_vendedor, id_tienda), HttpStatus.CREATED);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al Actualizar");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deletepedido/{id}")
    public Pedido deletePedido(@PathVariable Long id) {
        Pedido pedido= pedidoService.findById(id).orElse(null);
         pedidoService.deletePedido(id);
         return  pedido;
    }

    @GetMapping("/dellatepedido")
    public List<Map<String, Object>> datospedido(){
        List<Object[]> lista=pedidoService.findAllPedidos();
        List<Map<String, Object>> json=new ArrayList<Map<String, Object>>();
        for(Object[] objects: lista){
            Map<String, Object> datos= new HashMap<>();
            datos.put("id_pedido",objects[0]);
            datos.put("estado",objects[1]);
            datos.put("fecha",objects[2]);
            datos.put("forma_pago",objects[3]);
            datos.put("id_vendedor",objects[4]);
            datos.put("id_tienda",objects[5]);
            json.add(datos);
        }

        return json;

    }
}
