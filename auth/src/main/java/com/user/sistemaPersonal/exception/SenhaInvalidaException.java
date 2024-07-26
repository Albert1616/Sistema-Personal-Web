package com.user.sistemaPersonal.exception;

public class SenhaInvalidaException extends RuntimeException{
    public SenhaInvalidaException(){
        super("Senha Incorreta!");
    }
}
