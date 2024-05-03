package com.personal.sistemaPersonal.exception;

public class ExercicioNaoEncontradoException extends RuntimeException{
    public ExercicioNaoEncontradoException() {
        super("Exercicio nao encontrado.");
    }

    public ExercicioNaoEncontradoException(String message) {
        super(message);
    }
}
