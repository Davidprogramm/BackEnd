package com.example.backend.Service;

import com.example.backend.Entity.Categoria;
import com.example.backend.Entity.Producto;
import com.example.backend.Interface.CategoriaInterface;
import com.example.backend.Interface.ProductoInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {

    private final ProductoInterface productoInterface;
    private final CategoriaInterface categoriaInterface;

    @Autowired
    public ProductoService(ProductoInterface productoInterface, CategoriaInterface categoriaInterface) {
        this.productoInterface = productoInterface;
        this.categoriaInterface= categoriaInterface;
    }

    public List<Producto> allProductos() {
        return productoInterface.findAll();
    }

    public Optional<Producto> findById(Long id) {
        return productoInterface.findById(id);
    }

    public Producto addProducto(Producto producto,Long id_categoria) {


        Categoria categoria=new Categoria();
        categoria=categoriaInterface.findById(id_categoria).orElse(null);
        if(categoria !=null){
            producto.setCategoria(categoria);
            return productoInterface.save(producto);

        }else {
            return null;
        }



    }

    public Producto updateProducto(Producto producto) {
        Optional<Producto> productoOptional = productoInterface.findById(producto.getId_producto());

        if (productoOptional.isPresent()) {
            Producto productoExistente = productoOptional.get();
            productoExistente.setNombre(producto.getNombre());
            productoExistente.setDescripcion(producto.getDescripcion());
            productoExistente.setPrecio(producto.getPrecio());
            productoExistente.setStock(producto.getStock());
            productoExistente.setCategoria(producto.getCategoria());
            productoExistente.setDescuento(producto.getDescuento());
            productoExistente.setDetallesProveedores(producto.getDetallesProveedores());

            // Puedes manejar la actualización de otras propiedades si es necesario

            return productoInterface.save(productoExistente);
        } else {
            // Manejar el caso en el que el producto no exista
            return null;
        }
    }

    public void deleteProducto(Long id) {
        productoInterface.deleteById(id);
    }
}
