package com.personal.sistemaPersonal.rest.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InformacoesPersonalDTO {
    private Integer id;
    private String nome;
    private String email;
    private LocalDate dataNascimento;
    private String CREF;
}
