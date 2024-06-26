package com.personal.sistemaPersonal.rest.dto.response;

import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AlunoCompletoResponseDTO {
    private Integer id;
    private String login;
    private String nome;
    private String email;
    private LocalDate dataNascimento;
    private PersonalResponseDTO personal;
    private NutricionistaResponseDTO nuticionista;
    private List<TreinoResponseDTO> treinos;
    private List<AvaliacaoFisicaResponseDTO> avaliacoes;
}
