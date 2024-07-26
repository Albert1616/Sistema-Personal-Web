package com.nutri.sistemaPersonal.exception;

public class DietaNaoEncontradaException extends RuntimeException{
    public DietaNaoEncontradaException() {
        super("Dieta não encontrada.");
    }

    public DietaNaoEncontradaException(String message) {
        super(message);
    }
}
