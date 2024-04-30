package com.personal.sistemaPersonal.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "exercicio")
public class Exercicio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String nome;

    @Column
    private Integer series;

    @Column(length = 50)
    private Integer repeticoes;

    @Column(length = 100)
    private String observacoes;

    @ManyToMany
    @JoinTable(name = "treino_exercicio", joinColumns = @JoinColumn(name = "exercicio_id"),
    inverseJoinColumns = @JoinColumn(name = "treino_id"))
    private List<FichaTreino> fichas;
}