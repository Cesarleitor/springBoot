package br.com.cesar.springboot.controllers;

import org.springframework.web.bind.annotation.RestController;
import br.com.cesar.springboot.model.entities.Cliente;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @GetMapping("/qualquer")
    public Cliente obterCliente() {
        return new Cliente(1, "Cesar", "123.456.789-00", "11-5894-2549", "cesar@email.com", "Rua das Flores, 123");
    }

    @GetMapping("/{id}")
    public Cliente obterClientePorId1(@PathVariable int id) {
        // Lógica para obter o cliente por ID (simulada aqui)
        return new Cliente(id, "Maria", "589.799.788-13", "11-5894-2879", "email:maria@email.com", "Rua das Flores, 123");
    }

    @GetMapping
    public Cliente obterClientePorId2(@RequestParam(name = "id", defaultValue = "1") int id) {
        // Lógica para obter o cliente por ID (simulada aqui)
        return new Cliente(id, "João", "987.654.321-00", "11-1234-5678", "email:joao@email.com", "Rua das Flores, 123");
    }
}
