package com.personal.sistemaPersonal.rest.controller;

import com.personal.sistemaPersonal.rest.dto.request.NutricionistaRequestDTO;
import com.personal.sistemaPersonal.rest.dto.response.NutricionistaResponseDTO;
import com.personal.sistemaPersonal.service.NutricionistaService;
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
@RequestMapping("/api/nutricionista")
public class NutricionistaController {

    @Autowired
    NutricionistaService nutricionistaService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public NutricionistaResponseDTO save(@RequestBody @Valid NutricionistaRequestDTO nutricionistaRequestDTO){
        return nutricionistaService.save(nutricionistaRequestDTO);
    }

    @GetMapping("{id}")
    public NutricionistaResponseDTO getByID(@PathVariable Integer id){
        return nutricionistaService.getNutricionistaResponseDTOById(id);
    }

    @GetMapping
    public List<NutricionistaResponseDTO> getAll(){
        return nutricionistaService.getAll();
    }

    @PutMapping("{id}")
    public void update(@PathVariable Integer id, @RequestBody @Valid NutricionistaRequestDTO dto){
        nutricionistaService.update(id, dto);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id){
        nutricionistaService.delete(id);
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
