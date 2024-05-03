package com.personal.sistemaPersonal.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Dieta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 40)
    private String titulo;

    @ManyToOne
    @JoinColumn(name = "aluno_id")
    private Aluno aluno;

    private LocalDate data_criacao;

    @ManyToOne
    @JoinColumn(name = "nutricionista_id")
    private Nutricionista nutricionista;

    @OneToMany(mappedBy = "dieta", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<Refeicao> refeicoes;
}
