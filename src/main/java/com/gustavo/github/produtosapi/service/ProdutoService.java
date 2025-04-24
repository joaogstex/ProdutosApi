package com.gustavo.github.produtosapi.service;

import java.util.List;

import com.gustavo.github.produtosapi.exception.ProdutoException;
import com.gustavo.github.produtosapi.model.Produto;

public interface ProdutoService {

    List<Produto> listarProdutos() throws ProdutoException;

    Produto criarProduto(Produto produto) throws ProdutoException;

    Produto lerProdutoPorId(String id) throws ProdutoException;

    Produto atualizarProduto(String id, Produto produtoAtualizado) throws ProdutoException;

    void deletarProduto(String id) throws ProdutoException;

    List<Produto> acharProdutoPorNome(String productName) throws ProdutoException;
}
