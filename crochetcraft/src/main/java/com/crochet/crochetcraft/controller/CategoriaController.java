package com.crochet.crochetcraft.controller;

import com.crochet.crochetcraft.service.CategoriaService;
import com.crochet.crochetcraft.service.ProdutoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/categorias")
public class CategoriaController {

    private final CategoriaService categoriaService;
    private final ProdutoService produtoService;

    public CategoriaController(CategoriaService categoriaService, ProdutoService produtoService) {
        this.categoriaService = categoriaService;
        this.produtoService = produtoService;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("categorias", categoriaService.listarTodas());
        return "categorias";
    }

    @GetMapping("/{id}")
    public String produtosPorCategoria(@PathVariable Long id, Model model) {
        model.addAttribute("produtos", produtoService.listarPorCategoria(id));
        return "produtos";
    }
}