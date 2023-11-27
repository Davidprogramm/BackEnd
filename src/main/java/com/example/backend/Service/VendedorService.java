package com.example.backend.Service;

import com.example.backend.Entity.Tienda;
import com.example.backend.Entity.Vendedor;
import com.example.backend.Interface.VendedorInterface;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VendedorService {
    private VendedorInterface vendedorInterface;

    public VendedorService(VendedorInterface vendedorInterface) {
        this.vendedorInterface = vendedorInterface;
    }

    public List<Vendedor> allVendedor() {
        return vendedorInterface.findAll();
    }

    public Optional<Vendedor> findById(Long id) {
        return vendedorInterface.findById(id);
    }

    public Vendedor addVendedor(Vendedor vendedor) {
        return vendedorInterface.save(vendedor);
    }

    public Vendedor deleteVendedor(Long id){
        Vendedor  vendedor=vendedorInterface.findById(id).orElse(null);
        vendedorInterface.deleteById(id);
        return  vendedor;
    }
    public Vendedor updateVendedor(Vendedor vendedor){
    Optional<Vendedor>vendedor1=vendedorInterface.findById(vendedor.getId_vendedor());
        if(vendedor1.isPresent()){
            Vendedor vendedor2=vendedor1.get();
            vendedor2.setIdentificacion(vendedor.getIdentificacion());
            vendedor2.setNombre(vendedor.getNombre());
            vendedor2.setApellido(vendedor.getApellido());
            vendedor2.setDireccion(vendedor.getDireccion());
            vendedor2.setTelefono(vendedor.getTelefono());
            vendedor2.setEmail(vendedor.getEmail());
            return vendedorInterface.save(vendedor2);
        }else{
            return vendedor;
        }
    }

}

