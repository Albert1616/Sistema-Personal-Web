package com.personal.sistemaPersonal.exception;

public class PersonalNaoEncontradoException extends RuntimeException{

    public PersonalNaoEncontradoException() {
        super("Personal nao encontrado.");
    }

    public PersonalNaoEncontradoException(String message){
        super(message);
    }
}
