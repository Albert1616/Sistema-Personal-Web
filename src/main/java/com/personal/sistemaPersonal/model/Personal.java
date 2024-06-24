package com.personal.sistemaPersonal.model;

import com.personal.sistemaPersonal.rest.dto.request.PersonalRequestDTO;
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
@PrimaryKeyJoinColumn(name = "id")
public class Personal extends User{
    @Column(length = 50)
    private String nome;

    @Column(length = 50)
    private String email;

    private LocalDate dataNascimento;

    @OneToMany(mappedBy = "personal", fetch = FetchType.LAZY)
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
