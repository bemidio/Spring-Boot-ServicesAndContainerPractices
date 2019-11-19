package com.emidio.pedidoservice.repositorios;

import com.emidio.pedidoservice.entidades.Pedido;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * PedidoRepositorio
 */
@Repository
public interface PedidoRepositorio extends JpaRepository<Pedido, Integer>{

    
}