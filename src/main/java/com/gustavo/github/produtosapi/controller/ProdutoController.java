package com.gustavo.github.produtosapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gustavo.github.produtosapi.exception.ProdutoException;
import com.gustavo.github.produtosapi.model.Produto;
import com.gustavo.github.produtosapi.service.ProdutoService;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    public Produto criarProd(@RequestBody Produto produto) throws ProdutoException {
        return produtoService.criarProduto(produto);
    }

    @GetMapping
    public List<Produto> listarProd() throws ProdutoException {
        return produtoService.listarProdutos();
    }

    @GetMapping("/{id}")
    public Optional<Produto> lerProdPorId(@PathVariable String id) throws ProdutoException {
        return Optional.of(produtoService.lerProdutoPorId(id));
    }

    @PutMapping("/{id}")
    public Produto atualizarProd(@PathVariable String id, 
    @RequestBody Produto produtoAtualizado) throws ProdutoException {
        //produtoAtualizado.setId(id);
        return produtoService.atualizarProduto(id, produtoAtualizado);
    }

    @DeleteMapping("/{id}")
    public void deletarProd(@PathVariable String id) throws ProdutoException {
        produtoService.deletarProduto(id);
    }

    @GetMapping("/pegar/{productName}")
    public List<Produto> acharProdPorNome(@PathVariable String productName) throws ProdutoException {
        return produtoService.acharProdutoPorNome(productName);
    }

    //Só pra teste
    /* Fazer funcionar depois como estudo
    @GetMapping
    public List<Produto> acharProdutoPorLetra(@RequestParam("product_name") String productName) {
        String letra = Character.toString(productName.charAt(0));
        return produtoRepository.findByProductName(letra);
    }

    /*
     * @GetMapping("/{id}")
     * public ResponseEntity<Produto> lerProdutoPorId(@PathVariable String id) {
     * return produtos.stream()
     * .filter(produto -> produto.getId().equals(id))
     * .findFirst()
     * .map(ResponseEntity::ok)
     * .orElseGet(() -> ResponseEntity.notFound().build());
     * }
     * 
     * @PutMapping("/{id}")
     * public ResponseEntity<Produto> atualizarProduto(@PathVariable String
     * id, @RequestBody Produto produtoAtualizado) {
     * for(int i = 0; i < produtos.size(); i++) {
     * if(produtos.get(i).getId().equals(id)) {
     * produtos.set(i, produtoAtualizado);
     * return ResponseEntity.ok(produtoAtualizado);
     * }
     * }
     * return ResponseEntity.notFound().build();
     * }
     * 
     * @DeleteMapping("/{id}")
     * public ResponseEntity<Void> deletarProduto(@PathVariable String id) {
     * produtos.removeIf(produto -> produto.getId().equals(id));
     * return ResponseEntity.noContent().build();
     * }
     */
}
