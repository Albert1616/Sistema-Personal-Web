package com.nutri.sistemaPersonal.entites;


import com.auth.sistemaPersonal.entites.User;
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
    private String nome;

    private String email;

    private LocalDate data_nascimento;

    private Nutricionista nutricionista;

    private List<Dieta> dietas;
}
