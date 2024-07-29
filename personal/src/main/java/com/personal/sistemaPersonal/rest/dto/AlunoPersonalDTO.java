package com.personal.sistemaPersonal.rest.dto;

import com.personal.sistemaPersonal.entites.AvaliacaoFisica;
import com.personal.sistemaPersonal.entites.FichaTreino;
import com.personal.sistemaPersonal.entites.Personal;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Builder
public class AlunoPersonalDTO {
    private String nome;
    private String email;
    private LocalDate data_nascimento;
    private List<AvaliacaoFisica> avalicoes_fisicas;
    private FichaTreino ficha_treino;
    private Personal personal;
}
