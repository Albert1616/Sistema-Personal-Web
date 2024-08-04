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

public class Aluno extends User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 50)
    private String nome;

    @Column(length = 50)
    private String email;

    private LocalDate data_nascimento;

    @Column(name = "avaliacao_id")
    private List<Integer> avalicoes_fisicas;

    @Column(name = "ficha_treino_id")
    private Integer ficha_treino;

    @Column(name = "personal_id")
    private Integer personal;

    @Column(name = "nutricionista_id")
    private Integer nutricionista;

    @Column(name = "Dietas_id")
    private List<Integer> dietas;
}
