package com.personal.sistemaPersonal.rest.controller;

import com.personal.sistemaPersonal.rest.dto.AvaliacaoFisicaDTO;
import com.personal.sistemaPersonal.rest.dto.InformacoesAlunoDTO;
import com.personal.sistemaPersonal.rest.dto.InformacoesAvaliacaoFisicaDTO;
import com.personal.sistemaPersonal.service.AlunoService;
import com.personal.sistemaPersonal.service.AvaliacaoFisicaService;
import jakarta.persistence.criteria.CriteriaBuilder;
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
@RequestMapping("/api/avaliacao_fisica")
public class AvaliacaoFisicaController {

    @Autowired
    AvaliacaoFisicaService avaliacaoFisicaService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public InformacoesAvaliacaoFisicaDTO save(@RequestBody @Valid AvaliacaoFisicaDTO dto){
        return avaliacaoFisicaService.save(dto);
    }

    @GetMapping("{id}")
    public InformacoesAvaliacaoFisicaDTO getById(@PathVariable Integer id){
        return avaliacaoFisicaService.getInformacoesAvaliacaoFisicaDTOById(id);
    }

    @GetMapping
    public List<InformacoesAvaliacaoFisicaDTO> getAll(){
        return avaliacaoFisicaService.getAll();
    }

    @GetMapping("/getAvaliacaoFisicaByIdAluno/{id}")
    public List<InformacoesAvaliacaoFisicaDTO> getAllByIdAluno(@PathVariable Integer id){
        return avaliacaoFisicaService.getAvaliacoesFisicasByIdAluno(id);
    }

    @PutMapping("{id}")
    public InformacoesAvaliacaoFisicaDTO update(@PathVariable Integer id, @RequestBody @Valid AvaliacaoFisicaDTO dto){
        return avaliacaoFisicaService.update(id, dto);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id){
        avaliacaoFisicaService.delete(id);
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