package com.personal.sistemaPersonal.model;

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
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 50)
    private String nome;

    @Column(length = 50)
    private String email;

    private LocalDate data_nascimento;

    @OneToMany(mappedBy = "aluno", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @OrderBy("data desc")
    private List<AvaliacaoFisica> avalicoes_fisicas = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ficha_treino_id", referencedColumnName = "id")
    private FichaTreino ficha_treino;

    @ManyToOne
    @JoinColumn(name = "personal_id")
    private Personal personal;

    @ManyToOne
    @JoinColumn(name = "nutricionista_id")
    private Nutricionista nutricionista;

    @OneToMany(mappedBy = "aluno", fetch = FetchType.LAZY)
    private List<Dieta> dietas;
}
