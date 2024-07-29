package com.nutri.sistemaPersonal.entites;


import com.auth.sistemaPersonal.entites.User;
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
@Table(name = "aluno")
@PrimaryKeyJoinColumn(name = "id")
public class Aluno extends User {
    @Column(length = 50)
    private String nome;

    @Column(length = 50)
    private String email;

    private LocalDate data_nascimento;

    @ManyToOne
    @JoinColumn(name = "nutricionista_id")
    private Nutricionista nutricionista;

    @OneToMany(mappedBy = "aluno", fetch = FetchType.LAZY)
    private List<Dieta> dietas;
}
