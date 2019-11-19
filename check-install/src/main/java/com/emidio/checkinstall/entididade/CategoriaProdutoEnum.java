package com.emidio.checkinstall.entididade;

/**
 * CategoriaProduto
 */
public enum CategoriaProdutoEnum {

    CAMA_MESA_BANHO(1),
    LINHA_BRANCA(2),
    UTILIDADE_DOMESTICA(3);

    private final int valorEnum;
    CategoriaProdutoEnum(int valor) {
        this.valorEnum = valor;
    }
    
}