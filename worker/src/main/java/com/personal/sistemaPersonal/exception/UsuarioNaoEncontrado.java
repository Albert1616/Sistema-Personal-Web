package com.personal.sistemaPersonal.exception;

public class UsuarioNaoEncontrado extends RuntimeException{
    public UsuarioNaoEncontrado(){
        super("Usuário não encontrado na base de dados!");
    }

    public UsuarioNaoEncontrado(String mensagem){
        super(mensagem);
    }
}
