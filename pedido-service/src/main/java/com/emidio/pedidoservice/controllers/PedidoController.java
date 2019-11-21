package com.emidio.pedidoservice.controllers;

import com.emidio.pedidoservice.entidades.Pedido;
import com.emidio.pedidoservice.services.PedidoService;
import com.emidio.pedidoservice.util.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * PedidoController
 */
@RestController
@RequestMapping("/api")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    private final Logger logger = LoggerFactory.getLogger(PedidoController.class);

    @PostMapping("/pedidos")
    public Response<Pedido> salvarPedido(@RequestBody Pedido pedido) {

        Response<Pedido> response = new Response<Pedido>();

        try {
            
            Pedido novoPedido = this.pedidoService.salvarPedido(pedido);    

            response.setDado(novoPedido);        

        } catch (Exception e) {

            String erro = "Erro ao salvar criar um novo pedido: " + e.getMessage();
            logger.error(erro);
            response.setErro(erro);
            response.setDado(null);
        }
        
        return response;
    }


    @GetMapping(path = "/pedidos/{id}")
    public Response<Pedido> obterPedido(@PathVariable(name = "id") int idPedido) {

        Response<Pedido> response = new Response<Pedido>();

        try {
            Pedido pedido =this.pedidoService.getPedidoPorId(idPedido);    
            response.setDado(pedido);
        } catch (Exception e) {
            
            String erro = "Erro ao tentar obter pedido pelo id " + idPedido + ": " + e.getMessage();
            logger.error(erro);
            response.setErro(erro);
        }
        


    //     DetalhesPedido det = new DetalhesPedido();
    //     det.setId(1);
    //     det.setIdProduto(22);
    //     det.setQuantidade(10);
    //     det.setValorUnitario(BigDecimal.valueOf(50.00));
        
    //     Pedido pedido = new Pedido();
    //     pedido.setId(idPedido);
    //     pedido.setDataPedido(new Date());
    //     pedido.setUpdateTimeStamp(new Date());
    //     pedido.setIdCliente(1);
    //    // pedido.setDetalhesPedido(det);
        
    //     response.setDado(pedido);

        return response;
    }
    
}