package com.personal.sistemaPersonal.infra;

import com.personal.sistemaPersonal.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(PersonalNaoEncontradoException.class)
    private ResponseEntity<RestErrorMessage> personalNaoEncontradoHandler(PersonalNaoEncontradoException ex){
        RestErrorMessage response = new RestErrorMessage(HttpStatus.NOT_FOUND, ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(AlunoNaoEncontradoException.class)
    private ResponseEntity<RestErrorMessage> alunoNaoEncontradoHandler(AlunoNaoEncontradoException ex){
        RestErrorMessage response = new RestErrorMessage(HttpStatus.NOT_FOUND, ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(FichaTreinoNaoEncontradaException.class)
    private ResponseEntity<RestErrorMessage> fichaTreinoNaoEncontradaHandler(FichaTreinoNaoEncontradaException ex){
        RestErrorMessage response = new RestErrorMessage(HttpStatus.NOT_FOUND, ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(TreinoNaoEncontradoException.class)
    private ResponseEntity<RestErrorMessage> treinoNaoEncontradoHandler(TreinoNaoEncontradoException ex){
        RestErrorMessage response = new RestErrorMessage(HttpStatus.NOT_FOUND, ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(AvaliacaoFisicaNaoEncontradaException.class)
    private ResponseEntity<RestErrorMessage> avaliacaoFisicaNaoEncontradoHandler(AvaliacaoFisicaNaoEncontradaException ex){
        RestErrorMessage response = new RestErrorMessage(HttpStatus.NOT_FOUND, ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(ExercicioNaoEncontradoException.class)
    private ResponseEntity<RestErrorMessage> exercicioNaoEncontradoHandler(ExercicioNaoEncontradoException ex){
        RestErrorMessage response = new RestErrorMessage(HttpStatus.NOT_FOUND, ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
}
