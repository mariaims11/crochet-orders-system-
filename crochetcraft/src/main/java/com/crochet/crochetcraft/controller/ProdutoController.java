package com.crochet.crochetcraft.controller;

import com.crochet.crochetcraft.service.ProdutoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoService service;

    public ProdutoController(ProdutoService service) {
        this.service = service;
    }

    @GetMapping
    public String listar(
            @RequestParam(required = false) String pesquisa,
            Model model) {

        if (pesquisa != null && !pesquisa.isBlank()) {
            model.addAttribute("produtos", service.pesquisar(pesquisa));
        } else {
            model.addAttribute("produtos", service.listarTodos());
        }

        model.addAttribute("pesquisa", pesquisa);
        return "produtos";
    }

    @GetMapping("/{id}")
    public String detalhe(@PathVariable Long id, Model model) {
        model.addAttribute("produto", service.buscarPorId(id));
        return "produto-detalhe";
    }
}
