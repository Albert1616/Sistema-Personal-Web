package com.personal.sistemaPersonal.rest.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InformacoesAlunoDTO {
    private Integer id;
    private String nome;
    private String email;
    private LocalDate data_nascimento;
    private InformacoesPersonalDTO personal;
}
