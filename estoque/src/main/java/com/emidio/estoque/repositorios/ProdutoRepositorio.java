package com.emidio.estoque.repositorios;


import com.emidio.estoque.entidades.Produto;

import org.springframework.data.repository.CrudRepository;

/**
 * ProdutoRepositorio
 */
public interface ProdutoRepositorio extends CrudRepository<Produto, Integer>{

    Produto findByCodigo(String codigo);
}