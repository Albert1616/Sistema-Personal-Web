package com.auth.sistemaPersonal.exception;

public class SenhaInvalidaException extends RuntimeException{
    public SenhaInvalidaException(){
        super("Usuário não encontrado na base de dados!");
    }

    public SenhaInvalidaException(String mensagem){
        super(mensagem);
    }
}
