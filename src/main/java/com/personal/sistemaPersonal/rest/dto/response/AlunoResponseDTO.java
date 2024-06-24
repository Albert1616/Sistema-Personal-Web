package com.personal.sistemaPersonal.rest.dto.response;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AlunoResponseDTO {
    private Integer id;
    private String nome;
    private String email;
    private LocalDate dataNascimento;
    private PersonalResponseDTO personal;
    private NutricionistaResponseDTO nuticionista;
}
