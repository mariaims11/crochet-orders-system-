package com.crochet.crochetcraft.controller;

import com.crochet.crochetcraft.service.CarrinhoService;
import com.crochet.crochetcraft.service.ProdutoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/carrinho")
public class CarrinhoController {

    private final CarrinhoService carrinhoService;
    private final ProdutoService produtoService;

    public CarrinhoController(CarrinhoService carrinhoService, ProdutoService produtoService) {
        this.carrinhoService = carrinhoService;
        this.produtoService = produtoService;
    }

    @GetMapping
    public String verCarrinho(Model model) {
        model.addAttribute("itens", carrinhoService.listar());
        model.addAttribute("total", carrinhoService.total());
        return "carrinho";
    }

    @GetMapping("/adicionar/{id}")
    public String adicionar(@PathVariable Long id) {
        var produto = produtoService.listarTodos()
                .stream()
                .filter(p -> p.getIdProduto().equals(id))
                .findFirst()
                .orElse(null);

        if (produto != null) {
            carrinhoService.adicionar(produto);
        }

        return "redirect:/carrinho";
    }

    @GetMapping("/aumentar/{id}")
    public String aumentar(@PathVariable Long id) {

        carrinhoService.aumentar(id);

        return "redirect:/carrinho";
    }

    @GetMapping("/diminuir/{id}")
    public String diminuir(@PathVariable Long id) {

        carrinhoService.diminuir(id);

        return "redirect:/carrinho";
    }

    @GetMapping("/remover/{id}")
    public String remover(@PathVariable Long id) {
        carrinhoService.remover(id);
        return "redirect:/carrinho";
    }

    @GetMapping("/limpar")
    public String limpar() {
        carrinhoService.limpar();
        return "redirect:/carrinho";
    }
}
