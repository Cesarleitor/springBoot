package br.com.cesar.springboot.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/metodos")
public class MetodosHttpController {

    @GetMapping
    public String get() {
        return "Requisição GET recebida com sucesso!";
    }

    @PostMapping
    public String post() {
        return "Requisição POST recebida com sucesso!";
    }

    @PutMapping
    public String put() {
        return "Requisição PUT recebida com sucesso!";
    }

    @PatchMapping
    public String patch() {
        return "Requisição PATCH recebida com sucesso!";
    }

    @DeleteMapping
    public String delete() {
        return "Requisição DELETE recebida com sucesso!";
    }

}
