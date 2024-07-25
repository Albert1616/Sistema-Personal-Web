package com.personal.sistemaPersonal.exception;

public class TreinoNaoEncontradoException extends RuntimeException{
    public TreinoNaoEncontradoException() {
        super("Treino nao encontrado.");
    }

    public TreinoNaoEncontradoException(String message) {
        super(message);
    }
}
