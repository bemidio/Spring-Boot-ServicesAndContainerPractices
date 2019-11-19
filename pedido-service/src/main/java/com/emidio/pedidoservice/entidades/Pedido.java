package com.emidio.pedidoservice.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * Pedido
 */
@Entity
public class Pedido implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public Pedido() {

      //  this.detalhesPedido = new ArrayList<DetalhesPedido>();
    }

    @Id
    @GeneratedValue
    private int id;

    private int idCliente;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY, mappedBy = "pedido")
    private List<DetalhesPedido> detalhesPedido;

    private Date dataPedido;
    private Date updateTimeStamp;

    public int getId() {
        return id;
    }

    public List<DetalhesPedido> getDetalhesPedido() {
        return detalhesPedido;
    }

    public void setDetalhesPedido(List<DetalhesPedido> detalhesPedido) {
        this.detalhesPedido = detalhesPedido;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public Date getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(Date dataPedido) {
        this.dataPedido = dataPedido;
    }

    public Date getUpdateTimeStamp() {
        return updateTimeStamp;
    }

    public void setUpdateTimeStamp(Date updateTimeStamp) {
        this.updateTimeStamp = updateTimeStamp;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((dataPedido == null) ? 0 : dataPedido.hashCode());
        result = prime * result + id;
        result = prime * result + idCliente;
        result = prime * result + ((updateTimeStamp == null) ? 0 : updateTimeStamp.hashCode());
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
        Pedido other = (Pedido) obj;
        if (dataPedido == null) {
            if (other.dataPedido != null)
                return false;
        } else if (!dataPedido.equals(other.dataPedido))
            return false;
        if (id != other.id)
            return false;
        if (idCliente != other.idCliente)
            return false;
        if (updateTimeStamp == null) {
            if (other.updateTimeStamp != null)
                return false;
        } else if (!updateTimeStamp.equals(other.updateTimeStamp))
            return false;
        return true;
    }
    
}