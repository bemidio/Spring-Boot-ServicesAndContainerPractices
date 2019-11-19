package com.emidio.estoque.services;

import java.util.ArrayList;
import java.util.List;

import com.emidio.estoque.entidades.Produto;
import com.emidio.estoque.repositorios.ProdutoRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ProdutoService
 */
@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepositorio produtoRepositorio;

    public Produto criarNovoProduto(Produto produto){

        return this.produtoRepositorio.save(produto);
    }

	public Produto getProduto(int id) {
		return this.produtoRepositorio.findById(id).get();
	}

	public List<Produto> listarProdutos() {

		List<Produto> lista = new ArrayList<Produto>();
		this.produtoRepositorio.findAll().forEach(e -> lista.add(e));

		return lista;
	}    
}