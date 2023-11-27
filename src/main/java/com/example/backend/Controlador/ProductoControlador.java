package com.example.backend.Controlador;

import com.example.backend.Entity.Producto;
import com.example.backend.Service.ProductoService;
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
public class ProductoControlador {
    private final ProductoService productoService;

    public ProductoControlador(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping("/listproductos")
    public ResponseEntity<?> listProductos() {
        Map<String, Object> response = new HashMap<>();
        try {
            return new ResponseEntity<>(productoService.allProductos(), HttpStatus.OK);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al Buscar Productos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getproducto/{id}")
    public ResponseEntity<?> getProducto(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();
        try {
            Optional<Producto> producto = productoService.findById(id);
            if (producto.isPresent()) {
                return new ResponseEntity<>(producto.get(), HttpStatus.OK);
            } else {
                response.put("mensaje", "Producto no encontrado");
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al Buscar Producto");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/addproducto/{id_categoria}/{id_descuento}")
    public ResponseEntity<?> addProducto(@RequestBody Producto producto,
                                         @PathVariable Long id_categoria, @PathVariable Long id_descuento) {
        Map<String, Object> response = new HashMap<>();
        try {
            return new ResponseEntity<>(productoService.addProducto(producto, id_categoria, id_descuento), HttpStatus.CREATED);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al Agregar Producto");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/updateproducto")
    public ResponseEntity<?> updateProducto(@RequestBody Producto producto) {
        Map<String, Object> response = new HashMap<>();
        try {
            return new ResponseEntity<>(productoService.updateProducto(producto), HttpStatus.CREATED);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al Actualizar Producto");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deleteproducto/{id}")
    public ResponseEntity<?> deleteProducto(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();
        try {
            productoService.deleteProducto(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al Borrar Producto");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }
}
