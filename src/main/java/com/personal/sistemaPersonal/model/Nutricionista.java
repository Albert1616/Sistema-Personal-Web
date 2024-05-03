package com.personal.sistemaPersonal.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "nutricionista")
public class Nutricionista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 50)
    private String nome;

    @Column(length = 50)
    private String email;

    private LocalDate dataNascimento;

    @OneToMany(mappedBy = "nutricionista", fetch = FetchType.LAZY)
    private List<Aluno> alunos;

    @OneToMany(mappedBy = "nutricionista", fetch = FetchType.LAZY)
    private List<Dieta> dietas;
}
