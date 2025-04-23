package com.gustavo.github.produtosapi.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

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
        try {
            String id = UUID.randomUUID().toString();
            produto.setId(id);
            produto = produtoRepository.save(produto);
        } catch (Exception e) {
            throw new ProdutoException(e.getMessage());
        }
        return produto;
    }

    @Override
    public List<Produto> listarProdutos() throws ProdutoException{
        try {
            return produtoRepository.findAll();
        } catch (Exception e) {
            throw new ProdutoException(e.getMessage());
        }
    }

    @Override
    public Produto lerProdutoPorId(String id) throws ProdutoException {
        try {
            return produtoRepository.findById(id).orElse(null);
        } catch (Exception e) {
            throw new ProdutoException(e.getMessage());
        }
    }

    @Override
    public Produto atualizarProduto(Produto produtoAtualizado) throws ProdutoException {
        try {
            produtoAtualizado.getId();
            produtoAtualizado = produtoRepository.save(produtoAtualizado);    
        } catch (Exception e) {
            throw new ProdutoException(e.getMessage());
        }
        return produtoAtualizado;
    }

    @Override
    public void deletarProduto(String id) throws ProdutoException {
        try {
            produtoRepository.deleteById(id);
        } catch (Exception e) {
            throw new ProdutoException(e.getMessage());
        }
    }

    @Override
    public List<Produto> acharProdutoPorNome(@RequestParam("product_name") String productName) throws ProdutoException {
        try {
            return produtoRepository.findByProductName(productName);
        } catch (Exception e) {
            throw new ProdutoException(e.getMessage());
        }
    }

}
