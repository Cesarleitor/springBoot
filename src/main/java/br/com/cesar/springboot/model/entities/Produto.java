package br.com.cesar.springboot.model.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    @NotBlank //NAO ACEITA NULO
    private String nome;

    @Min(0) // NAO ACEITA VALOR MENOR QUE 0
    private Double preco;

    @Min(0) //MINIMO DE DESCONTO 0%
    @Max(1) //MAXIMO DE DESCONTO 100%
    private Double desconto;

    public Produto() {

    }

    public Produto(String nome, Double preco, Double desconto) {
        super();
        this.nome = nome;
        this.preco = preco;
        this.desconto = desconto;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Double getDesconto() {
        return desconto;
    }

    public void setDesconto(Double desconto) {
        this.desconto = desconto;
    }
}
