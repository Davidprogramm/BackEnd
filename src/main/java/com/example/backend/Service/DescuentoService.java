package com.example.backend.Service;

import com.example.backend.Entity.Descuento;
import com.example.backend.Interface.DescuentoInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DescuentoService {

    private final DescuentoInterface descuentoInterface;

    @Autowired
    public DescuentoService(DescuentoInterface descuentoInterface) {
        this.descuentoInterface = descuentoInterface;
    }

    public List<Descuento> allDescuentos() {
        return descuentoInterface.findAll();
    }

    public Optional<Descuento> findById(Long id) {
        return descuentoInterface.findById(id);
    }

    public Descuento addDescuento(Descuento descuento) {
        return descuentoInterface.save(descuento);
    }

    public Descuento updateDescuento(Descuento descuento) {
        Optional<Descuento> descuentoOptional = descuentoInterface.findById(descuento.getId_descuento());

        if (descuentoOptional.isPresent()) {
            Descuento descuentoExistente = descuentoOptional.get();
            descuentoExistente.setNombre(descuento.getNombre());
            descuentoExistente.setPorcentaje(descuento.getPorcentaje());
            descuentoExistente.setFechaInicio(descuento.getFechaInicio());
            descuentoExistente.setFechaFin(descuento.getFechaFin());


            return descuentoInterface.save(descuentoExistente);
        } else {
            return null;
        }
    }
}
