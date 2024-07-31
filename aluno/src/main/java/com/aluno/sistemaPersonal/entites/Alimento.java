package com.aluno.sistemaPersonal.entites;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Alimento {

    private Integer id;

    private String descricao;

    private String medida;

    private Refeicao refeicao;
}
