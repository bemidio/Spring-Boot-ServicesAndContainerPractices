package com.emidio.pedidoservice.response;

/**
 * ProdutoResponse
 */
public class Produto {

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

    public void setQuantidadeEstoque(int quantidade) {
        this.quantidadeEstoque = quantidade;
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

// "id": 7,
// "nome": "Super Mario 3 - Super Nintendo",
// "codigo": "SM3nes",
// "fornecedor": {
// "id": 3,
// "razaoSocial": "Vitor Game Mania",
// "endereco": "Rua Constantino Fusco",
// "numero": "295",
// "cidade": "São Paulo",
// "estado": "SP",
// "ativo": true,
// "dataCriacao": "2019-11-20T01:30:47.624+0000",
// "updateTimeStamp": "2019-11-20T01:30:47.624+0000"
// },
// "categoria": {
// "id": 4,
// "codigo": "game",
// "nome": "Jogos de Video Game",
// "dataCriacao": "2019-11-20T01:30:47.628+0000",
// "updateTimeStamp": "2019-11-20T01:30:47.628+0000"
// },
// "quantidadeEstoque": 10