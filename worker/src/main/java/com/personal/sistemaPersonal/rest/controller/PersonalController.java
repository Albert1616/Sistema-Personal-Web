package com.personal.sistemaPersonal.rest.controller;

import com.personal.sistemaPersonal.rest.dto.response.PersonalResponseDTO;
import com.personal.sistemaPersonal.rest.dto.request.PersonalRequestDTO;
import com.personal.sistemaPersonal.service.PersonalService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RequestMapping("/api/personal")
@RestController
@AllArgsConstructor
public class PersonalController {
    @Autowired
    PersonalService personalService;

    private final PasswordEncoder passwordEncoder;

    @PostMapping("/cadaster")
    @ResponseStatus(HttpStatus.CREATED)
    public PersonalResponseDTO save(@RequestBody @Valid PersonalRequestDTO dto){
        String passwordAfter = passwordEncoder.encode(dto.getPassword());
        dto.setPassword(passwordAfter);
        return personalService.save(dto);
    }

    @GetMapping("{id}")
    public PersonalResponseDTO getById(@PathVariable Integer id){
        return personalService.getInformacoesPersonalDTOById(id);
    }

    @GetMapping
    public List<PersonalResponseDTO> getAll(){
        return personalService.getAll();
    }

    @PutMapping("{id}")
    public void update(@PathVariable Integer id, @RequestBody @Valid PersonalRequestDTO dto){
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
