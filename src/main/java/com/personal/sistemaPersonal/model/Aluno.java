package com.personal.sistemaPersonal.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

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

    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate data_nascimento;

    @OneToMany(mappedBy = "aluno", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @OrderBy("data desc")
    private List<AvalicaoFisica> avalicoes_fisicas = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ficha_treino_id", referencedColumnName = "id")
    private FichaTreino ficha_treino;

    @ManyToOne
    @JoinColumn(name = "personal_id")
    private Personal personal;
}
