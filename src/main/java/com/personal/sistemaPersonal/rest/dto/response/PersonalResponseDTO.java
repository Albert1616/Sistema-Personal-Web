package com.personal.sistemaPersonal.rest.dto.response;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PersonalResponseDTO {
    private Integer id;
    private String nome;
    private String email;
    private LocalDate dataNascimento;
    private String CREF;
}
