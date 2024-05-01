package com.personal.sistemaPersonal.exception;

public class FichaTreinoNaoEncontradaException extends RuntimeException{
    public FichaTreinoNaoEncontradaException() {
        super("Ficha de Treino nao encontrada.");
    }

    public FichaTreinoNaoEncontradaException(String message) {
        super(message);
    }
}
