package com.crochet.crochetcraft.controller;

import com.crochet.crochetcraft.model.Cliente;
import com.crochet.crochetcraft.service.CarrinhoService;
import com.crochet.crochetcraft.service.ClienteService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EncomendaController {

    private final ClienteService clienteService;
    private final CarrinhoService carrinhoService;

    public EncomendaController(
            ClienteService clienteService,
            CarrinhoService carrinhoService
    ) {
        this.clienteService = clienteService;
        this.carrinhoService = carrinhoService;
    }

    @PostMapping("/encomenda/finalizar")
    public String finalizarEncomenda(

            @RequestParam String nome,
            @RequestParam String email,
            @RequestParam String telefone,
            @RequestParam String morada

    ) {

        // Criar cliente
        Cliente cliente = new Cliente();

        cliente.setNome(nome);
        cliente.setEmail(email);
        cliente.setTelefone(telefone);
        cliente.setMorada(morada);

        // Guardar cliente
        clienteService.guardar(cliente);

        // Limpar carrinho
        carrinhoService.limpar();

        // Página de sucesso
        return "encomenda-sucesso";
    }
}
