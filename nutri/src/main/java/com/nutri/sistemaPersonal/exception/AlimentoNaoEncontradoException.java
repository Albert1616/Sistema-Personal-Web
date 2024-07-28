package com.nutri.sistemaPersonal.exception;

public class AlimentoNaoEncontradoException extends RuntimeException{
    public AlimentoNaoEncontradoException() {
        super("Alimento não encontrado.");
    }

    public AlimentoNaoEncontradoException(String message) {
        super(message);
    }
}
