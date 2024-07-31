package com.aluno.sistemaPersonal.entites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

public class Refeicao {

    private Integer id;

    private String descricao;

    private Dieta dieta;

    private List<Alimento> alimentos;
}
