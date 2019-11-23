package com.emidio.clienteservice.controller;

import com.emidio.clienteservice.Util.Response;
import com.emidio.clienteservice.entididade.Cliente;
import com.emidio.clienteservice.repository.ClienteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClienteController
 */
@RestController
@RequestMapping("/api")
public class ClienteController {

    @Autowired
    private ClienteRepository repositorio;


    @GetMapping("/cliente/{id}")
    public Response<Cliente> getCliente(@PathVariable int id) {

        Response<Cliente> response = new Response<Cliente>();
        Cliente cliente = this.repositorio.findById(id).get();

        if (cliente != null) {
            response.setDado(cliente);
        }

        return response;
    }
    
    @GetMapping("/cliente/{id}/dependentes/{id-dependente}")
    public Response<Cliente> getClientePorEmail(@PathVariable int id, @PathVariable(name = "id-dependente") int idDependente) {
        
        Response<Cliente> response = new Response<Cliente>();
        Cliente cliente = this.repositorio.findById(id).get();

        if (cliente != null) {
            response.setDado(cliente);
        }

        return response;
    }

    @PostMapping("cliente")
    public Response<Cliente> salvarCliente(@RequestBody Cliente cliente) {

        Response<Cliente> response = new Response<Cliente>();

        if (cliente.getNome().isEmpty()) {
            response.setErro("Nome do cliente inválido");
            return response;
        }

        this.repositorio.save(cliente);

        response.setDado(cliente);

        return response;
    }



   
}