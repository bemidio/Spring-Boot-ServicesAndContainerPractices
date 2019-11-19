package com.emidio.estoque.repositorios;

import java.util.List;

import com.emidio.estoque.entidades.Fornecedor;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * FornecedorRepositorio
 */
@Repository
public interface FornecedorRepositorio extends CrudRepository<Fornecedor, Integer>{
    
    List<Fornecedor> findByRazaoSocialContaining(String nome);
    
}