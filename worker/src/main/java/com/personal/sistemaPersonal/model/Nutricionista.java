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
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "nutricionista")
@PrimaryKeyJoinColumn(name = "id")
public class Nutricionista extends User{
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
