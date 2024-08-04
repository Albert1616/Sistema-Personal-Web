package com.personal.sistemaPersonal.entites;

import com.personal.sistemaPersonal.rest.dto.request.PersonalRequestDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "personal")

public class Personal extends User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 50)
    private String nome;

    @Column(length = 50)
    private String email;

    @Column(name="dataNascimento")
    private LocalDate dataNascimento;

    @Column(name = "Alunos_id")
    private List<Integer> alunos = new ArrayList<>();

    public static Personal convert(PersonalRequestDTO personalRequestDTO){
        Personal personal = new Personal();

        personal.setNome(personalRequestDTO.getNome());
        personal.setEmail(personalRequestDTO.getEmail());
        personal.setDataNascimento(personalRequestDTO.getDataNascimento());
        personal.setLogin( personalRequestDTO.getLogin());
        personal.setPassword(personalRequestDTO.getPassword());
        personal.setPaper(personalRequestDTO.getPaper());
        personal.setAlunos(new ArrayList<>());

        return personal;
    }
}
