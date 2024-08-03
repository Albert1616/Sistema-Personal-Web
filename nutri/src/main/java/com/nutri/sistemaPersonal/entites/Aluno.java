package com.nutri.sistemaPersonal.entites;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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

public class Aluno extends User {
    private Integer id;
    private String nome;

    private String email;

    private LocalDate data_nascimento;

    private Nutricionista nutricionista;

    private List<Dieta> dietas;
}
