package com.emidio.pedidoservice.entidades;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * DetalhesPedido
 */
@Entity
public class DetalhesPedido implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public DetalhesPedido() {
    }

    @Id
    @GeneratedValue
    private int id;

    //@JoinColumn(name = "idPedido", nullable = false, insertable = true)
    @ManyToOne(fetch = FetchType.EAGER)   
    @JsonIgnore 
    private Pedido pedido;
    
    private int idProduto;
    private int quantidade;
    private BigDecimal valorUnitario;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
    

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(BigDecimal valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        result = prime * result + idProduto;
        result = prime * result + ((pedido == null) ? 0 : pedido.hashCode());
        result = prime * result + quantidade;
        result = prime * result + ((valorUnitario == null) ? 0 : valorUnitario.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        DetalhesPedido other = (DetalhesPedido) obj;
        if (id != other.id)
            return false;
        if (idProduto != other.idProduto)
            return false;
        if (pedido == null) {
            if (other.pedido != null)
                return false;
        } else if (!pedido.equals(other.pedido))
            return false;
        if (quantidade != other.quantidade)
            return false;
        if (valorUnitario == null) {
            if (other.valorUnitario != null)
                return false;
        } else if (!valorUnitario.equals(other.valorUnitario))
            return false;
        return true;
    }

  

    
}