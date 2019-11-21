package com.emidio.pedidoservice.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

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

        // this.detalhesPedido = new ArrayList<DetalhesPedido>();
    }

    @Id
    @GeneratedValue
    private int id;

    private int clienteId;

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

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int idCliente) {
        this.clienteId = idCliente;
    }

    @PrePersist
    public void prePersist() {
        Date data = new Date();
        this.dataPedido = data;
        this.updateTimeStamp = data;
    }

    @PreUpdate
    public void preUpdate() {
        this.updateTimeStamp = new Date();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((dataPedido == null) ? 0 : dataPedido.hashCode());
        result = prime * result + id;
        result = prime * result + clienteId;
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
        if (clienteId != other.clienteId)
            return false;
        if (updateTimeStamp == null) {
            if (other.updateTimeStamp != null)
                return false;
        } else if (!updateTimeStamp.equals(other.updateTimeStamp))
            return false;
        return true;
    }

}