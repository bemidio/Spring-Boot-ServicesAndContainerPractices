package com.emidio.estoque.services;

import com.emidio.estoque.entidades.Categoria;
import com.emidio.estoque.repositorios.CategoriaRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * CategoriaService
 */
@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepositorio categoriaRepositorio;

    public void criarNovaCategoria(Categoria categoria){

        this.categoriaRepositorio.save(categoria);
    }

	public Categoria obterCategoriaPorCodigo(String codigo) {
		return this.categoriaRepositorio.findByCodigo(codigo);
	}
    
}