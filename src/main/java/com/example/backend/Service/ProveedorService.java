package com.example.backend.Service;

import com.example.backend.Entity.Proveedor;
import com.example.backend.Interface.ProveedorInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProveedorService {

    private final ProveedorInterface proveedorInterface;

    @Autowired
    public ProveedorService(ProveedorInterface proveedorInterface) {
        this.proveedorInterface = proveedorInterface;
    }

    public List<Proveedor> allProveedores() {
        return proveedorInterface.findAll();
    }

    public Optional<Proveedor> findById(Long id) {
        return proveedorInterface.findById(id);
    }

    public Proveedor addProveedor(Proveedor proveedor) {
        return proveedorInterface.save(proveedor);
    }

    public Proveedor updateProveedor(Proveedor proveedor) {
        Optional<Proveedor> proveedorOptional = proveedorInterface.findById(proveedor.getId_proveedor());

        if (proveedorOptional.isPresent()) {
            Proveedor proveedorExistente = proveedorOptional.get();
            proveedorExistente.setNombre(proveedor.getNombre());
            proveedorExistente.setDireccion(proveedor.getDireccion());
            proveedorExistente.setTelefono(proveedor.getTelefono());
            proveedorExistente.setEmail(proveedor.getEmail());

            return proveedorInterface.save(proveedorExistente);
        } else {
            return null;
        }
    }

    public void deleteProveedor(Long id) {
        proveedorInterface.deleteById(id);
    }
}
