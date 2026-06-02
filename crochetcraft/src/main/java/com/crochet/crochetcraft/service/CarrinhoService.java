package com.crochet.crochetcraft.service;

import com.crochet.crochetcraft.model.CarrinhoItem;
import com.crochet.crochetcraft.model.Produto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarrinhoService {

    private final List<CarrinhoItem> itens = new ArrayList<>();

    public void adicionar(Produto produto) {

        for (CarrinhoItem item : itens) {
            if (item.getProduto().getIdProduto().equals(produto.getIdProduto())) {
                item.setQuantidade(item.getQuantidade() + 1);
                return;
            }
        }

        itens.add(new CarrinhoItem(produto, 1));
    }

    public List<CarrinhoItem> listar() {
        return itens;
    }

    //aumentar ou diminuir quantidades do mesmo produto no carrinho
    public void aumentar(Long idProduto) {

        for (CarrinhoItem item : itens) {

            if (item.getProduto().getIdProduto().equals(idProduto)) {

                item.setQuantidade(item.getQuantidade() + 1);

                return;
            }
        }
    }

    public void diminuir(Long idProduto) {

        for (CarrinhoItem item : itens) {

            if (item.getProduto().getIdProduto().equals(idProduto)) {

                if (item.getQuantidade() > 1) {

                    item.setQuantidade(item.getQuantidade() - 1);

                } else {

                    remover(idProduto);
                }

                return;
            }
        }
    }

    public void remover(Long idProduto) {
        itens.removeIf(item ->
                item.getProduto().getIdProduto().equals(idProduto)
        );
    }


    public void limpar() {
        itens.clear();
    }


    public double total() {
        double total = 0;

        for (CarrinhoItem item : itens) {
            total += item.getProduto().getPreco() * item.getQuantidade();
        }

        return total;
    }
}
