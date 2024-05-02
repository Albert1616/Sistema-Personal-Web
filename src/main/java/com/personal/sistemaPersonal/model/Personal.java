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
public class Personal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 50)
    private String nome;

    @Column(length = 50)
    private String email;

    private LocalDate dataNascimento;

    @Column(length = 10)
    private String CREF;

    @OneToMany(mappedBy = "personal", fetch = FetchType.LAZY)
    private List<Aluno> alunos;

    public static Personal convert(PersonalRequestDTO personalRequestDTO){
        Personal personal = new Personal();

        personal.setNome(personalRequestDTO.getNome());
        personal.setEmail(personalRequestDTO.getEmail());
        personal.setDataNascimento(personalRequestDTO.getDataNascimento());
        personal.setCREF(personalRequestDTO.getCREF());

        return personal;
    }
}
