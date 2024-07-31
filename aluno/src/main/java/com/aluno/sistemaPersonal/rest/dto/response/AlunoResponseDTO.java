package com.aluno.sistemaPersonal.rest.dto.response;

import com.aluno.sistemaPersonal.entites.Personal;
import com.aluno.sistemaPersonal.entites.Nutricionista;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
//    private PersonalResponseDTO personal;
//    private NutricionistaResponseDTO nuticionista;
    private Integer personal;
    private Integer nutricionista;

}

