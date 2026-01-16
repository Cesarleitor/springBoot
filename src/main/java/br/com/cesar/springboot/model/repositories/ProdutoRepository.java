package br.com.cesar.springboot.model.repositories;

import br.com.cesar.springboot.model.entities.Produto;

import jakarta.validation.Valid;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface ProdutoRepository
        extends PagingAndSortingRepository<Produto, Integer> {

    Optional<Produto> findAllById(int id);

    void save(@Valid Produto produto);

    void deleteById(int id);

    Iterable<Produto> findAll();

    Iterable<Produto> findByNomeContainingIgnoreCase(String parteNome); //consulta itens por parte do nome
}
