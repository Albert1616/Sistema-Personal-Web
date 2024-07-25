package com.personal.sistemaPersonal.rest.controller;

import com.personal.sistemaPersonal.rest.dto.request.AlimentoRequestDTO;
import com.personal.sistemaPersonal.rest.dto.response.AlimentoResponseDTO;
import com.personal.sistemaPersonal.service.AlimentoService;
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
@RequestMapping("/api/alimento")
public class AlimentoController {

    @Autowired
    AlimentoService alimentoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AlimentoResponseDTO save(@RequestBody @Valid AlimentoRequestDTO dto){
        return alimentoService.save(dto);
    }

    @PutMapping("{id}")
    public void update(@PathVariable Integer id, @RequestBody @Valid AlimentoRequestDTO dto){
        alimentoService.update(id, dto);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id){
        alimentoService.delete(id);
    }

    @GetMapping("{id}")
    public AlimentoResponseDTO getById(@PathVariable Integer id){
        return alimentoService.getAlimentoResponseDTOById(id);
    }

    @GetMapping
    public List<AlimentoResponseDTO> getAll(){
        return alimentoService.getAll();
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
