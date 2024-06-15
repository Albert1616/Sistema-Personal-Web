package com.personal.sistemaPersonal.exception;

public class SenhaInvalidaException extends RuntimeException{
    public SenhaInvalidaException(){
        super("Senha Incorreta!");
    }
}
