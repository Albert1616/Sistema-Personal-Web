package com.personal.sistemaPersonal.rest.controller;

import com.personal.sistemaPersonal.rest.dto.request.AlunoRequestDTO;
import com.personal.sistemaPersonal.rest.dto.response.AlunoResponseDTO;
import com.personal.sistemaPersonal.service.AlunoService;
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

@RestController
@RequestMapping("/api/aluno")
@AllArgsConstructor
public class AlunoController {

    @Autowired
    AlunoService alunoService;

    private final PasswordEncoder passwordEncoder;

    @PostMapping("/cadaster")
    @ResponseStatus(HttpStatus.CREATED)
    public AlunoResponseDTO save(@RequestBody @Valid AlunoRequestDTO dto){
        String passwordAfter = passwordEncoder.encode(dto.getPassword());
        dto.setPassword(passwordAfter);
        return alunoService.save(dto);
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public AlunoResponseDTO getById(@PathVariable Integer id){
        return alunoService.getAlunoInformacoesDTOById(id);
    }

//    @GetMapping("/getAllInformationsById/{id}")
//    @ResponseStatus(HttpStatus.OK)
//    public List<AlunoResponseDTO> getAllInformationsById(@PathVariable Integer id){
//
//    }

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

    @PatchMapping("{id}/vinculate/{login}")
    @ResponseStatus(HttpStatus.OK)
    public void vinculate(@PathVariable Integer id, @PathVariable String login){
        alunoService.vinculate(id, login);
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
