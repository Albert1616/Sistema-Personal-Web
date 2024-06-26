package com.personal.sistemaPersonal.infra;

import com.personal.sistemaPersonal.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
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

    @ExceptionHandler(NutricionistaNaoEncontradoException.class)
    private ResponseEntity<RestErrorMessage> nutricionistaNaoEncontradoHandler(NutricionistaNaoEncontradoException ex){
        RestErrorMessage response = new RestErrorMessage(HttpStatus.NOT_FOUND, ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(DietaNaoEncontradaException.class)
    private ResponseEntity<RestErrorMessage> dietaNaoEncontradoHandler(DietaNaoEncontradaException ex){
        RestErrorMessage response = new RestErrorMessage(HttpStatus.NOT_FOUND, ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(RefeicaoNaoEncontradaException.class)
    private ResponseEntity<RestErrorMessage> refeicaoNaoEncontradoHandler(RefeicaoNaoEncontradaException ex){
        RestErrorMessage response = new RestErrorMessage(HttpStatus.NOT_FOUND, ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(AlimentoNaoEncontradoException.class)
    private ResponseEntity<RestErrorMessage> alimentoNaoEncontradoHandler(AlimentoNaoEncontradoException ex){
        RestErrorMessage response = new RestErrorMessage(HttpStatus.NOT_FOUND, ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
}
