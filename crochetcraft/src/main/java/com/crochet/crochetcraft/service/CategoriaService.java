package com.crochet.crochetcraft.service;

import com.crochet.crochetcraft.model.Categoria;
import com.crochet.crochetcraft.repository.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    private final CategoriaRepository repository;

    public CategoriaService(CategoriaRepository repository) {
        this.repository = repository;
    }

    public List<Categoria> listarTodas() {
        return repository.findAll();
    }

    public Categoria guardar(Categoria categoria) {
        return repository.save(categoria);
    }
}
