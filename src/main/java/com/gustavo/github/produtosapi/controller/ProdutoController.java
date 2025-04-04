package com.gustavo.github.produtosapi.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gustavo.github.produtosapi.model.Produto;
import com.gustavo.github.produtosapi.repository.ProdutoRepository;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private ProdutoRepository produtoRepository;

    public ProdutoController(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @PostMapping
    public Produto criarProduto(@RequestBody Produto produto) {
        String id = UUID.randomUUID().toString();
        produto.setId(id);
        return produtoRepository.save(produto);
    }

    @GetMapping("/{id}")
    public Optional<Produto> lerProdutoPorId(@PathVariable String id) {
        return Optional.ofNullable(produtoRepository.findById(id).orElse(null));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> atualizarProduto(@PathVariable String id, 
    @RequestBody Produto produtoAtualizado) {
        produtoAtualizado.setId(id);
        produtoRepository.save(produtoAtualizado);
        return ResponseEntity.ok().body(produtoAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarProduto(@PathVariable String id) {
        produtoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public List<Produto> acharProdutoPorNome(@RequestParam("product_name") String productName) {
        return produtoRepository.findByProductName(productName);
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
