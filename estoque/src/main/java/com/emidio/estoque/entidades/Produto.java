package com.emidio.estoque.entidades;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

/**
 * Produto
 */
@Entity
public class Produto {

    @Id
    @GeneratedValue
    private int id;

    @Column
    private String nome;

    @Column
    private String codigo;

    @ManyToOne(fetch = FetchType.EAGER)
    private Fornecedor fornecedor;

    @ManyToOne(fetch = FetchType.EAGER)
    private Categoria categoria;  
    
    @Column
    private Date dataCriacao;

    @Column
    private Date updateTimeStamp;

    public int getId() {
        return id;
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

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @PrePersist
    public void prePersist(){
        Date date = new Date();
        this.dataCriacao = date;
        this.updateTimeStamp = date;
    }

    @PreUpdate
    public void preUpdate(){
        this.dataCriacao = new Date();        
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public int getQuantidadeEstoque(){
        return 10;
    }
    
}