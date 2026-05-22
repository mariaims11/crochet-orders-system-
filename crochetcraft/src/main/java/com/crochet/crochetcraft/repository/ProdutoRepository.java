package com.crochet.crochetcraft.repository;

import com.crochet.crochetcraft.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
