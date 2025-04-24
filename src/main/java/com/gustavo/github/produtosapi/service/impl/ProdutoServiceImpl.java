package com.gustavo.github.produtosapi.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.gustavo.github.produtosapi.exception.ProdutoException;
import com.gustavo.github.produtosapi.model.Produto;
import com.gustavo.github.produtosapi.repository.ProdutoRepository;
import com.gustavo.github.produtosapi.service.ProdutoService;

@Service
public class ProdutoServiceImpl implements ProdutoService {
    
    private ProdutoRepository produtoRepository;

    public ProdutoServiceImpl(ProdutoRepository produtoRepository) {
        super();
        this.produtoRepository = produtoRepository;
    }

    @Override
    public Produto criarProduto(Produto produto) throws ProdutoException {
        String id = UUID.randomUUID().toString();
        produto.setId(id);
        produto = produtoRepository.save(produto);
        return produto;
    }

    @Override
    public List<Produto> listarProdutos() throws ProdutoException{
        return produtoRepository.findAll();
    }

    @Override
    public Produto lerProdutoPorId(String id) throws ProdutoException {
       return produtoRepository.findById(id).orElse(null);
    }

    @Override
    public Produto atualizarProduto(String id, Produto produtoAtualizado) throws ProdutoException {
        produtoAtualizado.setId(id);
        produtoAtualizado = produtoRepository.save(produtoAtualizado);    
        return produtoAtualizado;
    }

    @Override
    public void deletarProduto(String id) throws ProdutoException {
        produtoRepository.deleteById(id);
    }

    @Override
    public List<Produto> acharProdutoPorNome(String productName) throws ProdutoException {
        return produtoRepository.findByProductName(productName);
    }

}
