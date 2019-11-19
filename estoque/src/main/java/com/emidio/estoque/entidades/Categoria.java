package com.emidio.estoque.entidades;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

/**
 * Categoria
 */
@Entity
public class Categoria {

    @Id
    @GeneratedValue
    private int id;

    @Column
    private String codigo;

    @Column
    private String nome;

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

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Date getUpdateTimeStamp() {
        return updateTimeStamp;
    }

    public void setUpdateTimeStamp(Date updateTimeStamp) {
        this.updateTimeStamp = updateTimeStamp;
    }

    @PreUpdate
    public void preUpdate() {
        this.updateTimeStamp = new Date();
    }

    @PrePersist
    public void prePersist() {

        Date date = new Date();
        this.updateTimeStamp = date;
        this.dataCriacao = date;
    }
}