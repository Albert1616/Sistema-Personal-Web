package com.personal.sistemaPersonal.exception;

public class AlunoNaoEncontradoException extends RuntimeException{
    public AlunoNaoEncontradoException() {
        super("Aluno nao encontrado.");
    }

    public AlunoNaoEncontradoException(String message) {
        super(message);
    }
}
