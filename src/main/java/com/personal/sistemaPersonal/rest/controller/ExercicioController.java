package com.personal.sistemaPersonal.rest.controller;

import com.personal.sistemaPersonal.model.Exercicio;
import com.personal.sistemaPersonal.rest.dto.ExercicioDTO;
import com.personal.sistemaPersonal.service.ExercicioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/exercicio")
public class ExercicioController {

    @Autowired
    ExercicioService exercicioService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Exercicio save(@RequestBody @Valid ExercicioDTO dto){
        return exercicioService.save(dto);
    }

    @GetMapping("{id}")
    public Exercicio getById(@PathVariable Integer id){
        return exercicioService.getById(id);
    }

    @GetMapping
    public List<Exercicio> getAll(){
        return exercicioService.getAll();
    }

    @PutMapping("{id}")
    public Exercicio update(@PathVariable Integer id, @RequestBody @Valid ExercicioDTO dto){
        return exercicioService.update(id, dto);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id){
        exercicioService.delete(id);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationException(MethodArgumentNotValidException ex){
        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();

            errors.put(fieldName, errorMessage);
        });

        return errors;
    }
}
