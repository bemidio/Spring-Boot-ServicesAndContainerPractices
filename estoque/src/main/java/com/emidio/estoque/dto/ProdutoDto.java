package com.emidio.estoque.dto;

/**
 * ProdutoDto  Hhh
 */
public class ProdutoDto {

    private int id;
    private String nome;
    private String codigo;
    private int fornecedorId;
    private String fornecedor;
    private String categoriaCodigo;
    private String categoria;
    private int quantidadeEstoque;

    public int getId() {
        return id;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public String getCategoriaCodigo() {
        return categoriaCodigo;
    }

    public void setCategoriaCodigo(String categoriaCodigo) {
        this.categoriaCodigo = categoriaCodigo;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getFornecedorId() {
        return fornecedorId;
    }

    public void setFornecedorId(int fornecedorId) {
        this.fornecedorId = fornecedorId;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }  
}
