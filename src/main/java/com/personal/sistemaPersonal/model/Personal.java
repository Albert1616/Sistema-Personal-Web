package com.personal.sistemaPersonal.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "personal")

public class Personal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 30)
    private String nome;
    @Column(length = 40)
    private String email;
    @Column(length = 10)
    private LocalDate dataNascimento;
    @Column(length = 10)
    private String CREF;
    @OneToMany
    private List<Aluno> alunos;
    public Personal(){};
    public Personal(String nome, String email, LocalDate dataNascimento, String CREF){
        this.nome = nome;
        this.email = email;
        this.dataNascimento = dataNascimento;
        this.CREF = CREF;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public String getNome() {
        return nome;
    }

    public Integer getId() {
        return id;
    }

    public LocalDate getDataNascimento() {
        return this.dataNascimento;
    }

    public String getEmail() {
        return email;
    }

    public String getCREF() {
        return CREF;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    public void setCREF(String CREF) {
        this.CREF = CREF;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public void adicionarAluno(Aluno aluno){
        this.alunos.add(aluno);
    }
}
