package com.personal.sistemaPersonal.rest.controller;

import com.personal.sistemaPersonal.rest.dto.request.DietaRequestDTO;
import com.personal.sistemaPersonal.rest.dto.response.DietaResponseDTO;
import com.personal.sistemaPersonal.service.DietaService;
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
@RequestMapping("/api/dieta")
public class DietaController {

    @Autowired
    DietaService dietaService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DietaResponseDTO save(@RequestBody @Valid DietaRequestDTO dto){
        return dietaService.save(dto);
    }

    @PutMapping("{id}")
    public void update(@PathVariable Integer id, @RequestBody @Valid DietaRequestDTO dto){
        dietaService.update(id, dto);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id){
        dietaService.delete(id);
    }

    @GetMapping("{id}")
    public DietaResponseDTO getById(@PathVariable Integer id){
        return dietaService.getDietaResponseDTOById(id);
    }

    @GetMapping
    public List<DietaResponseDTO> getAll(){
        return dietaService.getAll();
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
