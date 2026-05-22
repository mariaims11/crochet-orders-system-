package com.crochet.crochetcraft.repository;

import com.crochet.crochetcraft.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}