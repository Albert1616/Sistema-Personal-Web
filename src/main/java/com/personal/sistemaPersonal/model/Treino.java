package com.personal.sistemaPersonal.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "treino")
public class Treino {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 40)
    private String titulo;

    @ManyToOne
    @JoinColumn(name = "ficha_treino_id")
    private FichaTreino ficha_treino;

    private LocalDate data_criacao;

    private LocalDate data_vencimento;

    @ManyToMany(cascade = CascadeType.DETACH)
    @JoinTable(name = "treino_exercicio", joinColumns = @JoinColumn(name = "treino_id"),
    inverseJoinColumns = @JoinColumn(name = "exercicio_id"))
    private List<Exercicio> exercicios;
}
