package com.personal.sistemaPersonal.exception;

public class NutricionistaNaoEncontradoException extends RuntimeException{
    public NutricionistaNaoEncontradoException() {
        super("Nutricionista não encontrado.");
    }

    public NutricionistaNaoEncontradoException(String message) {
        super(message);
    }
}
