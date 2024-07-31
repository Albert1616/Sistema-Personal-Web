package com.aluno.sistemaPersonal.entites;


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

public class FichaTreino {

    private Integer id;

    private String titulo;

    private List<Treino> treinos;

    private Integer aluno;
}
