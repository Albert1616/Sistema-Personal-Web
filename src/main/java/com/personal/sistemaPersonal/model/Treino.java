package com.personal.sistemaPersonal.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

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

    private TipoTreino tipo;

    @ManyToOne
    @JoinColumn(name = "ficha_treino_id")
    private FichaTreino ficha_treino;

    private LocalDate data_criacao;

    private Integer duracao;

    private LocalDate data_vencimento;

    @ManyToMany(cascade = CascadeType.DETACH)
    @JoinTable(name = "treino_exercicio", joinColumns = @JoinColumn(name = "treino_id"),
    inverseJoinColumns = @JoinColumn(name = "exercicio_id"))
    private List<Exercicio> exercicios;
}
