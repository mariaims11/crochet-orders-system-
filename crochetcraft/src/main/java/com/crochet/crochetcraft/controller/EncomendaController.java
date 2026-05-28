package com.crochet.crochetcraft.controller;

import com.crochet.crochetcraft.model.Cliente;
import com.crochet.crochetcraft.service.ClienteService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EncomendaController {

    private final ClienteService clienteService;

    public EncomendaController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping("/encomenda/finalizar")
    public String finalizarEncomenda(
            @RequestParam String nome,
            @RequestParam String email,
            @RequestParam String telefone,
            @RequestParam String morada
    ) {

        // 1. Criar cliente
        Cliente cliente = new Cliente();
        cliente.setNome(nome);
        cliente.setEmail(email);
        cliente.setTelefone(telefone);
        cliente.setMorada(morada);

        // 2. Guardar na base de dados
        clienteService.guardar(cliente);

        // 3. Redirecionar
        return "encomenda-sucesso";
    }
}
