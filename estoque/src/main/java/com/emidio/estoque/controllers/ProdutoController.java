package com.emidio.estoque.controllers;

import java.util.ArrayList;
import java.util.List;

import com.emidio.estoque.dto.ProdutoDto;
import com.emidio.estoque.entidades.Produto;
import com.emidio.estoque.services.ProdutoService;
import com.emidio.estoque.utils.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ProdutoController
 */
@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping("/{id}")
    public Response<ProdutoDto> obterProduto(@PathVariable(value = "id") int id){
    
        Response<ProdutoDto> response = new Response<ProdutoDto>();

        try {
            Produto produto = this.produtoService.getProduto(id);

            ProdutoDto dto = transformObjectToDto(produto);

            response.setDado(dto);
        } catch (Exception e) {
            
            response.setErro(e.getMessage());            
        }

        return response;
    }

    private ProdutoDto transformObjectToDto(Produto produto) {
        ProdutoDto dto = new ProdutoDto();
        dto.setId(produto.getId());
        dto.setCodigo(produto.getCodigo());
        dto.setNome(produto.getNome());
        dto.setCategoria(produto.getCategoria().getNome());
        dto.setCategoriaCodigo(produto.getCategoria().getCodigo());
        dto.setFornecedor(produto.getFornecedor().getRazaoSocial());
        dto.setFornecedorId(produto.getFornecedor().getId());
        dto.setQuantidadeEstoque(produto.getQuantidadeEstoque());
        return dto;
    }

    @GetMapping
    public Response<List<ProdutoDto>> listarProduto(){
    
        Response<List<ProdutoDto>> response = new Response<List<ProdutoDto>>();

        try {
            List<Produto> produtoList = this.produtoService.listarProdutos();
            List<ProdutoDto> listaDto = new ArrayList<ProdutoDto>();

            produtoList.forEach(p -> listaDto.add(this.transformObjectToDto(p)));

            response.setDado(listaDto);
        } catch (Exception e) {
            
            response.setErro(e.getMessage());            
        }

        return response;
    }
    
}