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
@Table(name = "personal")
public class Personal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 30)
    private String nome;

    @Column(length = 40)
    private String email;

    @Column(length = 10)
    private LocalDate dataNascimento;

    @Column(length = 10)
    private String CREF;

    @OneToMany(mappedBy = "personal", fetch = FetchType.LAZY)
    private List<Aluno> alunos;
}
