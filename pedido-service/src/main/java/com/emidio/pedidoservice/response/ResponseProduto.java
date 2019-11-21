package com.emidio.pedidoservice.response;

import java.util.ArrayList;
import java.util.List;

/**
 * Response
 */
public class ResponseProduto {

    private List<String> erros;

    private Produto dado;

    public Produto getDado() {

        return dado;
    }

    public void setDado(Produto obj)
    {
        this.dado = obj;
    }

    public List<String> getErros(){

        if(this.erros == null){
            this.erros = new ArrayList<String>();
        }

        return this.erros;
    }

    public void setErro(String errorMessage){

        this.getErros().add(errorMessage);
    }
}