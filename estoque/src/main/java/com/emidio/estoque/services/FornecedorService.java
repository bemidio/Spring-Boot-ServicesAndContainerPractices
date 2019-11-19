package com.emidio.estoque.services;

import java.util.List;

import com.emidio.estoque.entidades.Fornecedor;
import com.emidio.estoque.repositorios.FornecedorRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * FornecedorService
 */
@Service
public class FornecedorService {

    @Autowired
    private FornecedorRepositorio fornecedorRepositorio;

    public void criarNovoFornecedor(Fornecedor fornecedor){

        this.fornecedorRepositorio.save(fornecedor);
    }

	public List<Fornecedor> getFornecedorPorNome(String nome) {

        return this.fornecedorRepositorio.findByRazaoSocialContaining(nome);
	}
}