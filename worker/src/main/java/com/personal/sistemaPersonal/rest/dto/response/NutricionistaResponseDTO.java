package com.personal.sistemaPersonal.rest.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Builder
public class NutricionistaResponseDTO {
    private Integer id;
    private String nome;
    private String email;
    private LocalDate data_nascimento;
}
