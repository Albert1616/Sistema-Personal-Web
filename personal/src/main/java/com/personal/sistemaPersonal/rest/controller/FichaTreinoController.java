package com.personal.sistemaPersonal.rest.controller;

import com.personal.sistemaPersonal.entites.FichaTreino;
import com.personal.sistemaPersonal.rest.dto.request.FichaTreinoRequestDTO;
import com.personal.sistemaPersonal.service.FichaTreinoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ficha_treino")
public class FichaTreinoController {

    @Autowired
    FichaTreinoService fichaTreinoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public FichaTreinoRequestDTO create(@RequestBody @Valid FichaTreinoRequestDTO ficha){
        fichaTreinoService.save(ficha);
        return ficha;
    }

    @GetMapping("{id}")
    public FichaTreino getById(@PathVariable Integer id){
        return fichaTreinoService.getById(id);
    }

    @GetMapping
    public List<FichaTreino> getAll(){
        return fichaTreinoService.getAll();
    }
}
