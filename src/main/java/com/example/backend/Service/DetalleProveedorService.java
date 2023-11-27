package com.example.backend.Service;

import com.example.backend.Entity.DetalleProveedor;
import com.example.backend.Entity.Producto;
import com.example.backend.Entity.Proveedor;
import com.example.backend.Interface.DetalleProveedorInterface;
import com.example.backend.Interface.ProductoInterface;
import com.example.backend.Interface.ProveedorInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DetalleProveedorService {

    private final DetalleProveedorInterface detalleProveedorInterface;
    private final ProductoInterface productoInterface;
    private final ProveedorInterface proveedorInterface;

    @Autowired
    public DetalleProveedorService(DetalleProveedorInterface detalleProveedorInterface, ProductoInterface productoInterface, ProveedorInterface proveedorInterface) {
        this.detalleProveedorInterface = detalleProveedorInterface;
        this.productoInterface = productoInterface;
        this.proveedorInterface = proveedorInterface;
    }

    public List<DetalleProveedor> allDetallesProveedor() {
        return detalleProveedorInterface.findAll();
    }

    public Optional<DetalleProveedor> findById(Long id) {
        return detalleProveedorInterface.findById(id);
    }

    public DetalleProveedor addDetalleProveedor(DetalleProveedor detalleProveedor, Long id_producto, Long id_proveedor) {


        Producto producto = productoInterface.findById(id_producto).orElse(null);
        Proveedor proveedor = proveedorInterface.findById(id_proveedor).orElse(null);
        if (producto != null && proveedor != null) {
            detalleProveedor.setProducto(producto);
            detalleProveedor.setProveedor(proveedor);
            return detalleProveedorInterface.save(detalleProveedor);
        } else {
            return null;
        }
    }

    public DetalleProveedor updateDetalleProveedor(DetalleProveedor detalleProveedor) {
        Optional<DetalleProveedor> detalleProveedorOptional = detalleProveedorInterface.findById(detalleProveedor.getId_detalle_proveedor());

        if (detalleProveedorOptional.isPresent()) {
            DetalleProveedor detalleProveedorExistente = detalleProveedorOptional.get();
            detalleProveedorExistente.setCantidad(detalleProveedor.getCantidad());
            detalleProveedorExistente.setValorTotal(detalleProveedor.getValorTotal());
            detalleProveedorExistente.setProducto(detalleProveedor.getProducto());
            detalleProveedorExistente.setProveedor(detalleProveedor.getProveedor());

            return detalleProveedorInterface.save(detalleProveedorExistente);
        } else {
            return null;
        }
    }

    public void deleteDetalleProveedor(Long id) {
        detalleProveedorInterface.deleteById(id);
    }
}
