package com.personal.sistemaPersonal.rest.controller;

import com.personal.sistemaPersonal.rest.dto.response.TreinoResponseDTO;
import com.personal.sistemaPersonal.rest.dto.request.TreinoRequestDTO;
import com.personal.sistemaPersonal.service.TreinoService;
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
@RequestMapping("/api/treino")
public class TreinoController {

    @Autowired
    TreinoService treinoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TreinoResponseDTO save(@RequestBody @Valid TreinoRequestDTO dto){
        return treinoService.save(dto);
    }

    @PutMapping("{id}")
    public TreinoResponseDTO update(@PathVariable Integer id, @RequestBody @Valid TreinoRequestDTO dto){
        return treinoService.update(id, dto);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id){
        treinoService.delete(id);
    }

    @GetMapping("{id}")
    public TreinoResponseDTO getById(@PathVariable Integer id){
        return treinoService.getInformacoesTreinoDTO(id);
    }

    @GetMapping
    public List<TreinoResponseDTO> getAll(){
        return treinoService.getAll();
    }

    @GetMapping("/getTreinoByIdAluno/{id}")
    public List<TreinoResponseDTO> getAllByIdAluno(@PathVariable Integer id){
        return treinoService.getByIdAluno(id);
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
