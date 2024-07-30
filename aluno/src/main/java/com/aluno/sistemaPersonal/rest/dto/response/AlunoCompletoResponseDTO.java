package com.aluno.sistemaPersonal.rest.dto.response;

import com.aluno.sistemaPersonal.entites.Nutricionista;
import com.aluno.sistemaPersonal.entites.Personal;
import com.personal.sistemaPersonal.rest.dto.response.AvaliacaoFisicaResponseDTO;
import com.personal.sistemaPersonal.rest.dto.response.TreinoResponseDTO;
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
    private Personal personal;
    private Nutricionista nuticionista;
    private List<TreinoResponseDTO> treinos;
    private List<AvaliacaoFisicaResponseDTO> avaliacoes;
}
