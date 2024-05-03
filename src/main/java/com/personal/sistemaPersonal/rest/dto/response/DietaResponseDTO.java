package com.personal.sistemaPersonal.rest.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Builder
public class DietaResponseDTO {
    private Integer id;
    private String titulo;
    private LocalDate data_criacao;
    private List<RefeicaoResponseDTO> refeicoes;
}
