package com.personal.sistemaPersonal.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "avalicao")

public class Avalicao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 15)
    private String titulo;
    @Column(length = 10)
    private LocalDate data;
    @ManyToOne
    private Aluno aluno;
    @Column(length = 3)
    private Integer alunoPeso;
    @Column(length = 3)
    private Integer alunoAltura;
    public Avalicao(){};
    public Avalicao(String titulo, Aluno aluno, Integer alunoAltura, Integer alunoPeso){
        this.titulo = titulo;
        this.aluno = aluno;
        this.alunoAltura = alunoAltura;
        this.alunoPeso= alunoPeso;
        this.data = LocalDate.now();
    };

    public String getTitulo() {
        return titulo;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public Integer getAlunoAltura() {
        return alunoAltura;
    }

    public Integer getAlunoPeso() {
        return alunoPeso;
    }

    public LocalDate getData() {
        return data;
    }

    public Integer getId() {
        return id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public void setAlunoAltura(Integer alunoAltura) {
        this.alunoAltura = alunoAltura;
    }

    public void setAlunoPeso(Integer alunoPeso) {
        this.alunoPeso = alunoPeso;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }
}
