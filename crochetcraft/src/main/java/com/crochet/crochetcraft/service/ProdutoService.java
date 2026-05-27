package com.crochet.crochetcraft.service;

import com.crochet.crochetcraft.model.Produto;
import com.crochet.crochetcraft.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    private final ProdutoRepository repository;

    public ProdutoService(ProdutoRepository repository) {
        this.repository = repository;
    }

    public List<Produto> listarTodos() {
        return repository.findAll();
    }

    public Produto buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public List<Produto> listarPorCategoria(Long categoriaId) {
        return repository.findAll()
                .stream()
                .filter(p -> p.getCategoria() != null)
                .filter(p -> p.getCategoria().getIdCategoria().equals(categoriaId))
                .toList();
    }
}