package com.personal.sistemaPersonal.entites;

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

    @Column(name = "titulo", length = 50)
    private String titulo;

    @Column(name = "observacoes")
    private String observacoes;

    @Column(name = "data")
    private LocalDate data;

    @Column(name = "aluno_id")
    private Integer aluno;  // Renomeado para `alunoId` para seguir boas práticas e evitar confusão com o nome da coluna.

    @Column(name = "aluno_peso")
    private Double alunoPeso;

    @Column(name = "aluno_altura")
    private Double alunoAltura;

    @Column(name = "medida_braco")
    private Double medidaBraco;

    @Column(name = "medida_peito")
    private Double medidaPeito;

    @Column(name = "medida_perna")
    private Double medidaPerna;

    @Column(name = "medida_cintura")
    private Double medidaCintura;
}
