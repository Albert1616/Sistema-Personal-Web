package com.personal.sistemaPersonal.exception;

public class AvaliacaoFisicaNaoEncontradaException extends RuntimeException{
    public AvaliacaoFisicaNaoEncontradaException() {
        super("Avaliacao Fisica nao encontrada.");
    }

    public AvaliacaoFisicaNaoEncontradaException(String message) {
        super(message);
    }
}
