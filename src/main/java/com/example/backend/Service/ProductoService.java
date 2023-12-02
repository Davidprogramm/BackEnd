package com.example.backend.Service;

import com.example.backend.Entity.Categoria;
import com.example.backend.Entity.Descuento;
import com.example.backend.Entity.Producto;
import com.example.backend.Interface.CategoriaInterface;
import com.example.backend.Interface.DescuentoInterface;
import com.example.backend.Interface.ProductoInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {

    private final ProductoInterface productoInterface;
    private final CategoriaInterface categoriaInterface;

    private final DescuentoInterface descuentoInterface;

    @Autowired
    public ProductoService(ProductoInterface productoInterface, CategoriaInterface categoriaInterface,DescuentoInterface descuentoInterface) {
        this.productoInterface = productoInterface;
        this.categoriaInterface= categoriaInterface;
        this.descuentoInterface=descuentoInterface;
    }

    public List<Object[]> findAllProductos(){
        return productoInterface.findAllProductos();
    }

    public Producto updateStock(int i, Long id_producto){
        Producto producto=findById(id_producto).orElse(null);
        producto.setStock(i);
        productoInterface.save(producto);
        return  producto;

    }
    public List<Object[]>descuentoProducto(String id_producto){return productoInterface.findDescuentoProducto(id_producto);}

    public List<Producto> allProductos() {
        return productoInterface.findAll();
    }

    public Optional<Producto> findById(Long id) {
        return productoInterface.findById(id);
    }

    public Producto addProducto(Producto producto,Long id_categoria,Long id_descuento) {
        Categoria categoria = categoriaInterface.findById(id_categoria).orElse(null);
        Descuento descuento = descuentoInterface.findById(id_descuento).orElse(null);
        if(categoria !=null){
            producto.setCategoria(categoria);
            producto.setDescuento(descuento);
            return productoInterface.save(producto);
        }else {
            return null;
        }
    }


    public Producto updateProducto(Producto producto, Long id_categoria, Long id_descuento) {
        Optional<Producto> productoOptional = productoInterface.findById(producto.getId_producto());

        Categoria categoria=categoriaInterface.findById(id_categoria).orElse(null);
        Descuento descuento=descuentoInterface.findById(id_descuento).orElse(null);

        if (productoOptional.isPresent()) {
            Producto productoExistente = productoOptional.get();
            productoExistente.setNombre(producto.getNombre());
            productoExistente.setDescripcion(producto.getDescripcion());
            productoExistente.setPrecio(producto.getPrecio());
            productoExistente.setStock(producto.getStock());
            productoExistente.setCategoria(categoria);
            productoExistente.setDescuento(descuento);
            productoExistente.setDetallesProveedores(producto.getDetallesProveedores());


            return productoInterface.save(productoExistente);
        } else {
            return null;
        }
    }

    public void deleteProducto(Long id) {
        productoInterface.deleteById(id);
    }
}
