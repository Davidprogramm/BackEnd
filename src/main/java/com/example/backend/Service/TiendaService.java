package com.example.backend.Service;

import com.example.backend.Entity.Tienda;
import com.example.backend.Interface.TiendaInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TiendaService {

    private final TiendaInterface tiendaInterface;

    @Autowired
    public TiendaService(TiendaInterface tiendaInterface) {
        this.tiendaInterface = tiendaInterface;
    }

    public List<Tienda> allTiendas() {
        return tiendaInterface.findAll();
    }

    public Optional<Tienda> findById(Long id) {
        return tiendaInterface.findById(id);
    }

    public Tienda addTienda(Tienda tienda) {
        return tiendaInterface.save(tienda);
    }

    public Tienda updateTienda(Tienda tienda) {
        Optional<Tienda> tiendaOptional = tiendaInterface.findById(tienda.getId_tienda());

        if (tiendaOptional.isPresent()) {
            Tienda tiendaExistente = tiendaOptional.get();
            tiendaExistente.setNombre_tienda(tienda.getNombre_tienda());
            tiendaExistente.setEncargado(tienda.getEncargado());
            tiendaExistente.setDireccion(tienda.getDireccion());
            tiendaExistente.setMunicipio(tienda.getMunicipio());
            tiendaExistente.setDepartamento(tienda.getDepartamento());
            tiendaExistente.setTelefono(tienda.getTelefono());
            tiendaExistente.setEmail(tienda.getEmail());

            // Puedes manejar la actualización de los pedidos si es necesario
            // tiendaExistente.setPedidos(tienda.getPedidos());

            return tiendaInterface.save(tiendaExistente);
        } else {
            // Manejar el caso en el que la tienda no exista
            return null;
        }
    }
}
