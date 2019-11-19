package com.emidio.checkinstall.repository;

import com.emidio.checkinstall.entididade.Cliente;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * ClienteRepository
 */
@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Integer>{

    
}