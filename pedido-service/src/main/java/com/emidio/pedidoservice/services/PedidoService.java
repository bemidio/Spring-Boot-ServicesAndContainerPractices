package com.emidio.pedidoservice.services;

import com.emidio.pedidoservice.entidades.DetalhesPedido;
import com.emidio.pedidoservice.entidades.Pedido;
import com.emidio.pedidoservice.repositorios.PedidoRepositorio;
import com.emidio.pedidoservice.response.Produto;
import com.emidio.pedidoservice.response.ResponseProduto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * PedidoService
 */
@Service
public class PedidoService {

    private final Logger logger = LoggerFactory.getLogger(PedidoService.class);

    @Value("${servico.estoque.endereco}")
    private String urlProduto;

    @Autowired
    private PedidoRepositorio pedidoRepositorio;

    public Pedido salvarPedido(Pedido pedido) throws Exception {

        this.logger.info("Endereço do serviço de estoque: " + this.urlProduto);

        for (DetalhesPedido detalhe : pedido.getDetalhesPedido()) {

            if(detalhe.getQuantidade() < 1)
                throw new Exception("Quantidade inválida de itens");

            Produto produto = this.getProdutoEstoque(detalhe.getProdutoId());

            if (produto == null) {
                throw new Exception("Produto selecionado fora de catálogo");
            }

            if (produto.getQuantidadeEstoque() < detalhe.getQuantidade()) {
                throw new Exception("Quantidade de produto disponível em estoque inferior ao solicitado.");
            }

            if (detalhe.getPedido() == null) {
                detalhe.setPedido(pedido);
            }
        }

        return this.pedidoRepositorio.save(pedido);
    }

    public Pedido getPedidoPorId(int id) {

        return this.pedidoRepositorio.findById(id).get();
    }

    // @Autowired
    // private RestTemplate restTemplate;

    public Produto getProdutoEstoque(int idProduto) {

        String url = this.urlProduto + idProduto;

        this.logger.info("URL_TO_PRODUTO_SERVICE: " + url);

        ResponseProduto response = new RestTemplate().getForObject(url, ResponseProduto.class);

        return response.getDado();

    }

    // @Bean
    // public RestTemplate restTemplate(RestTemplateBuilder builder) {
    // return builder.build();
    // }
}