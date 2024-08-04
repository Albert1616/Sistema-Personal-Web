package com.aluno.sistemaPersonal.entites;


import com.aluno.sistemaPersonal.rest.dto.request.PersonalRequestDTO;
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

public class Personal extends User {
    private String nome;

    private String email;

    private LocalDate dataNascimento;

    private List<Aluno> alunos;

    public static Personal convert(PersonalRequestDTO personalRequestDTO){
        Personal personal = new Personal();

        personal.setNome(personalRequestDTO.getNome());
        personal.setEmail(personalRequestDTO.getEmail());
        personal.setDataNascimento(personalRequestDTO.getDataNascimento());
        personal.setLogin( personalRequestDTO.getLogin());
        personal.setPassword(personalRequestDTO.getPassword());
        personal.setPaper(personalRequestDTO.getPaper());

        return personal;
    }
}
