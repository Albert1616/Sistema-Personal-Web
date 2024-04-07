package com.personal.sistemaPersonal.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "aluno")
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 50)
    private String nome;

    @Column(length = 50)
    private String email;

    @Column
    private LocalDate data_nascimento;

    @OneToMany(mappedBy = "aluno", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @OrderBy("data desc")
    private List<AvalicaoFisica> avalicoes_fisicas = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ficha_treino_id", referencedColumnName = "id")
    private FichaTreino ficha_treino;

    @ManyToOne
    @JoinColumn(name = "personal_id")
    private Personal personal;

    public Aluno(){};

    public Aluno(String nome, String email, LocalDate data_nascimento){
        this.nome = nome;
    }

    public Aluno(String nome, FichaTreino fichaTreino){
        this.nome = nome;
        this.ficha_treino = fichaTreino;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public FichaTreino getFicha_treino() {
        return ficha_treino;
    }

    public List<AvalicaoFisica> getAvalicoesFisicas() {
        return avalicoes_fisicas;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setAvalicoesFisicas(List<AvalicaoFisica> avalicoesFisicas) {
        this.avalicoes_fisicas = avalicoesFisicas;
    }

    public void setFicha_treino(FichaTreino fichaTreino) {
        this.ficha_treino = fichaTreino;
    }

    public void adicionarAvalicao(AvalicaoFisica avalicao){
        this.avalicoes_fisicas.add(avalicao);
    }

    public LocalDate getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(LocalDate data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
