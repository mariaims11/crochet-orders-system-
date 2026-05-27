package com.crochet.crochetcraft.service;

import com.crochet.crochetcraft.model.CarrinhoItem;
import com.crochet.crochetcraft.model.Produto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarrinhoService {

    private final List<CarrinhoItem> itens = new ArrayList<>();

    // ADICIONAR PRODUTO AO CARRINHO
    public void adicionar(Produto produto) {

        for (CarrinhoItem item : itens) {
            if (item.getProduto().getIdProduto().equals(produto.getIdProduto())) {
                item.setQuantidade(item.getQuantidade() + 1);
                return;
            }
        }

        itens.add(new CarrinhoItem(produto, 1));
    }

    // VER ITENS
    public List<CarrinhoItem> listar() {
        return itens;
    }

    // REMOVER UM PRODUTO
    public void remover(Long idProduto) {
        itens.removeIf(item ->
                item.getProduto().getIdProduto().equals(idProduto)
        );
    }

    // LIMPAR CARRINHO
    public void limpar() {
        itens.clear();
    }

    // CALCULAR TOTAL
    public double total() {
        double total = 0;

        for (CarrinhoItem item : itens) {
            total += item.getProduto().getPreco() * item.getQuantidade();
        }

        return total;
    }
}
