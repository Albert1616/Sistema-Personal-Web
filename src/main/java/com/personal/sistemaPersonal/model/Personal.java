package com.personal.sistemaPersonal.model;

import com.personal.sistemaPersonal.rest.dto.PersonalDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

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

    public static Personal convert(PersonalDTO personalDTO){
        Personal personal = new Personal();

        personal.setNome(personalDTO.getNome());
        personal.setEmail(personalDTO.getEmail());
        personal.setDataNascimento(personalDTO.getDataNascimento());
        personal.setCREF(personalDTO.getCREF());

        return personal;
    }
}
