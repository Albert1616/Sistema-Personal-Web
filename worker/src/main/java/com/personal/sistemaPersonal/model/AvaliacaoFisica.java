package com.personal.sistemaPersonal.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "avaliacao_fisica")
public class AvaliacaoFisica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 50)
    private String titulo;

    private LocalDate data;

    @ManyToOne
    @JoinColumn(name = "aluno_id")
    private Aluno aluno;

    private Double alunoPeso;

    private Double alunoAltura;

    private Double medidaBraco;

    private Double medidaPeito;

    private Double medidaPerna;

    private Double medidaCintura;
}
