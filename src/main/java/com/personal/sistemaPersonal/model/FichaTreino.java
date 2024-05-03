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
@Table(name = "ficha_treino")
public class FichaTreino {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 20)
    private String titulo;

    @OneToMany(mappedBy = "ficha_treino", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<Treino> treinos;

    @OneToOne(mappedBy = "ficha_treino")
    private Aluno aluno;
}
