package com.personal.sistemaPersonal.rest.controller;

import com.personal.sistemaPersonal.rest.dto.request.AlunoRequestDTO;
import com.personal.sistemaPersonal.rest.dto.response.AlunoResponseDTO;
import com.personal.sistemaPersonal.service.AlunoService;
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
    public AlunoResponseDTO save(@RequestBody @Valid AlunoRequestDTO dto){
        return alunoService.save(dto);
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public AlunoResponseDTO getById(@PathVariable Integer id){
        return alunoService.getAlunoInformacoesDTOById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<AlunoResponseDTO> getAll(){
        return alunoService.getAll();
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable Integer id, @RequestBody @Valid AlunoRequestDTO alunoRequestDTO){
        alunoService.update(id, alunoRequestDTO);
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
