package com.emidio.estoque.controllers;

import java.util.List;

import com.emidio.estoque.entidades.Produto;
import com.emidio.estoque.services.ProdutoService;
import com.emidio.estoque.utils.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ProdutoController
 */
@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping("/{id}")
    public Response<Produto> obterProduto(@PathVariable(value = "id") int id){
    
        Response<Produto> response = new Response<Produto>();

        try {
            Produto produto = this.produtoService.getProduto(id);

            response.setDado(produto);
        } catch (Exception e) {
            
            response.setErro(e.getMessage());            
        }

        return response;
    }

    @GetMapping
    public Response<List<Produto>> listarProduto(){
    
        Response<List<Produto>> response = new Response<List<Produto>>();

        try {
            List<Produto> produto = this.produtoService.listarProdutos();

            response.setDado(produto);
        } catch (Exception e) {
            
            response.setErro(e.getMessage());            
        }

        return response;
    }
    
}