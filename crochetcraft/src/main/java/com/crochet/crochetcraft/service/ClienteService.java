package com.crochet.crochetcraft.service;

import com.crochet.crochetcraft.model.Cliente;
import com.crochet.crochetcraft.repository.ClienteRepository;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    private final ClienteRepository repository;

    public ClienteService(ClienteRepository repository) {
        this.repository = repository;
    }

    public Cliente guardar(Cliente cliente) {
        return repository.save(cliente);
    }
}
