package com.emidio.estoque.repositorios;

import com.emidio.estoque.entidades.Categoria;

import org.springframework.data.repository.CrudRepository;

/**
 * CategoriaRepositorio
 */
public interface CategoriaRepositorio extends CrudRepository<Categoria, Integer>{
    
    Categoria findByCodigo(String codigo);
}