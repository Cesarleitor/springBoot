package br.com.cesar.springboot.controllers;

import br.com.cesar.springboot.model.entities.Produto;
import br.com.cesar.springboot.model.repositories.ProdutoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;


    //ADICIONAR PRODUTOS
    //@RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})  METODO QUE ADD PRODUTO E TAMBEM PODE SER USADO PARA ALTERAR DADOS DO PRODUTO.
    @PostMapping
    public @ResponseBody Produto novoProduto (@Valid Produto produto){
        produtoRepository.save(produto);
        return produto;
    }

    //CONSULTAR TODOS OS PRODUTOS cuidado caso seja muitos itens
    @GetMapping
    public Iterable<Produto> obterProdutos() {
        return produtoRepository.findAll();
    }

    //CONSULTA POR PARTE DO NOME DO PRODUTO
    @GetMapping(path = "/nome/{parteNome}")
    public Iterable<Produto> obterProdutosPorNome(@PathVariable String parteNome) {
        return produtoRepository.findByNomeContainingIgnoreCase(parteNome);
    }

    //CONSULTA POR PAGINA "MAIS SEGURO QUE A ACIMA"
    @GetMapping(path = "/pagina/{numeroPagina}/{qtdePagina}")
    public Iterable<Produto> obterProdutoPorPagina(
            @PathVariable int numeroPagina, @PathVariable int qtdePagina) {
        if (qtdePagina >= 5) qtdePagina = 5; //se a quantidade de itens for > ou = a 5, mostrar so 5 itens por pagina
        Pageable page = PageRequest.of(numeroPagina, qtdePagina); // quantidade de paginas a ser dividida
        return produtoRepository.findAll(page);
    }

    //ENCONTRAR ITENS POR ID
    @GetMapping(path = "/{id}")
    public Optional<Produto> obterProdutoPorId(@PathVariable int id) {
        return produtoRepository.findAllById(id);
    }

    //ALTERAR DADOS DOS ITENS
    @PutMapping
    public Produto alterarProduto(@Valid Produto produto) {
        produtoRepository.save(produto);
        return produto;
    }

    //DELETAR ITENS
    @DeleteMapping(path = "/{id}")
    public void excluirProduto(@PathVariable int id) {
        produtoRepository.deleteById(id);
    }
}
