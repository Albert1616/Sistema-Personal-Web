package com.nutri.sistemaPersonal.entites;

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

public class Nutricionista extends User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 50)
    private String nome;

    @Column(length = 50)
    private String email;

    private LocalDate dataNascimento;

    private List<Integer> alunos;

    @OneToMany(mappedBy = "nutricionista", fetch = FetchType.LAZY)
    private List<Dieta> dietas;
}
