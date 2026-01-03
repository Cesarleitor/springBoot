package br.com.cesar.springboot.controllers;

import org.springframework.web.bind.annotation.RestController;
import br.com.cesar.springboot.models.Cliente;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class ClienteController {

    @GetMapping(path = "/cliente/qualquer")
    public Cliente obterCliente() {
        return new Cliente(1, "Cesar", "123.456.789-00", "11-5894-2549");
    }

}
