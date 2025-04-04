package com.gustavo.github.produtosapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gustavo.github.produtosapi.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, String> {
    
}
