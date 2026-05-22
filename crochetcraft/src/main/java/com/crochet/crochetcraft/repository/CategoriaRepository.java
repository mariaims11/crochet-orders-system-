package com.crochet.crochetcraft.repository;

import com.crochet.crochetcraft.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}