package com.emidio.pedidoservice.services;

import com.emidio.pedidoservice.entidades.DetalhesPedido;
import com.emidio.pedidoservice.entidades.Pedido;
import com.emidio.pedidoservice.repositorios.PedidoRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * PedidoService
 */
@Service
public class PedidoService {

    @Autowired
    private PedidoRepositorio pedidoRepositorio;

    public Pedido salvarPedido(Pedido pedido){

        for (DetalhesPedido detalhe : pedido.getDetalhesPedido()) {
            if(detalhe.getPedido() == null){
                detalhe.setPedido(pedido);
            }
        }

        return this.pedidoRepositorio.save(pedido);
    }


    public Pedido getPedidoPorId(int id){

        return this.pedidoRepositorio.findById(id).get();
    }
}