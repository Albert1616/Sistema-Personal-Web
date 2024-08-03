package com.aluno.sistemaPersonal.entites;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "aluno")
@PrimaryKeyJoinColumn(name = "id")
@PersistenceContext(unitName = "aluno-personal")
public class Aluno extends User {
    @Column(length = 50)
    private String nome;

    @Column(length = 50)
    private String email;

    private LocalDate data_nascimento;

    @JoinColumn(name = "avaliacao_id")
    private List<Integer> avalicoes_fisicas = new ArrayList<>();

    @JoinColumn(name = "ficha_treino_id", referencedColumnName = "id")
    private Integer ficha_treino;

    @JoinColumn(name = "personal_id")
    private Integer personal;

    @JoinColumn(name = "nutricionista_id")
    private Integer nutricionista;

    @JoinColumn(name = "Dietas_id")
    private List<Integer> dietas;
}
