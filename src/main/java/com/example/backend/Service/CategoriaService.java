package com.example.backend.Service;

import com.example.backend.Entity.Categoria;
import com.example.backend.Interface.CategoriaInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    private final CategoriaInterface categoriaInterface;

    @Autowired
    public CategoriaService(CategoriaInterface categoriaInterface) {
        this.categoriaInterface = categoriaInterface;
    }

    public List<Categoria> allCategorias() {
        return categoriaInterface.findAll();
    }

    public Optional<Categoria> findById(Long id) {
        return categoriaInterface.findById(id);
    }

    public Categoria addCategoria(Categoria categoria) {
        return categoriaInterface.save(categoria);
    }

    public Categoria updateCategoria(Categoria categoria) {
        Optional<Categoria> categoriaOptional = categoriaInterface.findById(categoria.getId_categoria());

        if (categoriaOptional.isPresent()) {
            Categoria categoriaExistente = categoriaOptional.get();
            categoriaExistente.setNombre(categoria.getNombre());
            categoriaExistente.setDescripcion(categoria.getDescripcion());
            return categoriaInterface.save(categoriaExistente);
        } else {
            return null;
        }
    }
    public Categoria deleteCategoria(Long id_categoria) {
        Optional<Categoria> categoriaOptional = categoriaInterface.findById(id_categoria);
        categoriaOptional.ifPresent(categoria -> categoriaInterface.deleteById(id_categoria));
        return categoriaOptional.orElse(null);
    }
}
