package com.emidio.clienteservice.repository;

import com.emidio.clienteservice.entididade.Cliente;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * ClienteRepository
 */
@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Integer>{

    
}