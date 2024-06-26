package com.personal.sistemaPersonal.rest.dto.response;

import com.personal.sistemaPersonal.model.Exercicio;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Builder
public class TreinoResponseDTO {
    private Integer id;
    private String titulo;
    private LocalDate data_criacao;
    private LocalDate data_vencimento;
    private List<Exercicio> exercicios;
}
