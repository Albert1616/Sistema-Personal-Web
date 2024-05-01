package com.personal.sistemaPersonal.rest.controller;

import com.personal.sistemaPersonal.model.Personal;
import com.personal.sistemaPersonal.rest.dto.InformacoesPersonalDTO;
import com.personal.sistemaPersonal.rest.dto.PersonalDTO;
import com.personal.sistemaPersonal.service.PersonalService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RequestMapping("/api/personal")
@RestController
public class PersonalController {

    @Autowired
    PersonalService personalService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public InformacoesPersonalDTO save(@RequestBody @Valid PersonalDTO dto){
        return personalService.save(dto);
    }

    @GetMapping("{id}")
    public InformacoesPersonalDTO getById(@PathVariable Integer id){
        return personalService.getInformacoesPersonalDTOById(id);
    }

    @GetMapping
    public List<InformacoesPersonalDTO> getAll(){
        return personalService.getAll();
    }

    @PutMapping("{id}")
    public void update(@PathVariable Integer id, @RequestBody @Valid PersonalDTO dto){
        personalService.update(id, dto);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id){
        personalService.delete(id);
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
