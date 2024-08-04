package com.aluno.sistemaPersonal.rest.dto.response;

import com.personal.sistemaPersonal.entites.AvaliacaoFisica;
import com.personal.sistemaPersonal.entites.FichaTreino;
import com.personal.sistemaPersonal.entites.Personal;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class AlunoToPersonal {
    private Integer id;
    private String nome;

    private String email;

    private LocalDate data_nascimento;

    private List<Integer> avalicoes_fisicas = new ArrayList<>();

    private Integer ficha_treino;

    private Integer personal;

    public AlunoToPersonal(Integer id, String nome, String email, LocalDate data_nascimento,
                           List<Integer> avalicoes_fisicas, Integer ficha_treino,
                           Integer personal) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.data_nascimento = data_nascimento;
        this.avalicoes_fisicas = avalicoes_fisicas;
        this.ficha_treino = ficha_treino;
        this.personal = personal;
    }
}
