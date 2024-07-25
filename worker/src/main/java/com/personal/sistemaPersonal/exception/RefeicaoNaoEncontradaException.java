package com.personal.sistemaPersonal.exception;

public class RefeicaoNaoEncontradaException extends RuntimeException{
    public RefeicaoNaoEncontradaException() {
        super("Refeição não encontrada.");
    }

    public RefeicaoNaoEncontradaException(String message) {
        super(message);
    }
}
