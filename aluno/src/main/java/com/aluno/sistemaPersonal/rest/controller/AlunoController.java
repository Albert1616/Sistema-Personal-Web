package com.aluno.sistemaPersonal.rest.controller;

import com.aluno.sistemaPersonal.rest.dto.request.AlunoRequestDTO;
import com.aluno.sistemaPersonal.rest.dto.response.AlunoCompletoResponseDTO;
import com.aluno.sistemaPersonal.rest.dto.response.AlunoResponseDTO;
import com.aluno.sistemaPersonal.rest.dto.response.AlunoToPersonal;
import com.aluno.sistemaPersonal.service.AlunoService;
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

    @GetMapping("/get/{id}")
    public AlunoToPersonal getAlunoById(@PathVariable Integer id){
        return alunoService.getById(id);
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public AlunoResponseDTO getById(@PathVariable Integer id){
        return alunoService.getAlunoInformacoesDTOById(id);
    }

    @GetMapping("/getAllInformationsById/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AlunoCompletoResponseDTO getAllInformationsById(@PathVariable Integer id){
        return alunoService.getAllInformartionsById(id);
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
