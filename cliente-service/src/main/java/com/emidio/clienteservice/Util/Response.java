package com.emidio.clienteservice.Util;

import java.util.ArrayList;
import java.util.List;

/**
 * Response
 */
public class Response<T> {

    private List<String> erros;

    private T dado;

    public T getDado() {

        return dado;
    }

    public void setDado(final T obj)
    {
        this.dado = obj;
    }

    public List<String> getErros(){

        if(this.erros == null){
            this.erros = new ArrayList<String>();
        }

        return this.erros;
    }

    public void setErro(final String errorMessage){

        this.getErros().add(errorMessage);
    }
}