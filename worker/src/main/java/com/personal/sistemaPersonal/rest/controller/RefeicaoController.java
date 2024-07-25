package com.personal.sistemaPersonal.rest.controller;

import com.personal.sistemaPersonal.rest.dto.request.RefeicaoRequestDTO;
import com.personal.sistemaPersonal.rest.dto.response.RefeicaoResponseDTO;
import com.personal.sistemaPersonal.service.RefeicaoService;
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
@RequestMapping("/api/refeicao")
public class RefeicaoController {

    @Autowired
    RefeicaoService refeicaoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RefeicaoResponseDTO save(@RequestBody @Valid RefeicaoRequestDTO dto){
        return refeicaoService.save(dto);
    }

    @PutMapping("{id}")
    public void update(@PathVariable Integer id, @RequestBody @Valid RefeicaoRequestDTO dto){
        refeicaoService.update(id, dto);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id){
        refeicaoService.delete(id);
    }

    @GetMapping("{id}")
    public RefeicaoResponseDTO getById(@PathVariable Integer id){
        return refeicaoService.getRefeicaoResponseDTOById(id);
    }

    @GetMapping
    public List<RefeicaoResponseDTO> getAll(){
        return refeicaoService.getAll();
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
