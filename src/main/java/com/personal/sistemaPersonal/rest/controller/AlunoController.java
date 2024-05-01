package com.personal.sistemaPersonal.rest.controller;

import com.personal.sistemaPersonal.model.Aluno;
import com.personal.sistemaPersonal.rest.dto.AlunoDTO;
import com.personal.sistemaPersonal.rest.dto.InformacoesAlunoDTO;
import com.personal.sistemaPersonal.service.AlunoService;
import com.personal.sistemaPersonal.service.AvaliacaoFisicaService;
import com.personal.sistemaPersonal.service.FichaTreinoService;
import com.personal.sistemaPersonal.service.TreinoService;
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
@RequestMapping("/api/aluno")
public class AlunoController {

    @Autowired
    AlunoService alunoService;

//    @Autowired
//    AvaliacaoFisicaService avaliacaoFisicaService;
//
//    @Autowired
//    FichaTreinoService fichaTreinoService;
//
//    @Autowired
//    TreinoService treinoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public InformacoesAlunoDTO save(@RequestBody @Valid AlunoDTO dto){
        return alunoService.save(dto);
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public InformacoesAlunoDTO getById(@PathVariable Integer id){
        return alunoService.getAlunoInformacoesDTOById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<InformacoesAlunoDTO> getAll(){
        return alunoService.getAll();
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable Integer id, @RequestBody @Valid AlunoDTO alunoDTO){
        alunoService.update(id, alunoDTO);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Integer id){
        alunoService.delete(id);
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
