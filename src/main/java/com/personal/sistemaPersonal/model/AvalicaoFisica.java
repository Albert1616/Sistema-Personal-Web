package com.personal.sistemaPersonal.model;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Table(name = "avaliacao_fisica")
public class AvalicaoFisica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 50)
    private String titulo;

    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate data;

    @ManyToOne
    @JoinColumn(name = "aluno_id")
    private Aluno aluno;

    @Column
    private Double alunoPeso;

    @Column
    private Double alunoAltura;

    @Column
    private Double medidaBraco;

    @Column
    private Double medidaPeito;

    @Column
    private Double medidaPerna;

    @Column
    private Double medidaCintura;

    public AvalicaoFisica(){};

    public AvalicaoFisica(String titulo, Aluno aluno, Double alunoAltura, Double alunoPeso){
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

    public Double getAlunoAltura() {
        return alunoAltura;
    }

    public Double getAlunoPeso() {
        return alunoPeso;
    }

    public LocalDate getData() {
        return data;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public void setAlunoAltura(Double alunoAltura) {
        this.alunoAltura = alunoAltura;
    }

    public void setAlunoPeso(Double alunoPeso) {
        this.alunoPeso = alunoPeso;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Double getMedidaBraco() {
        return medidaBraco;
    }

    public void setMedidaBraco(Double medidaBraco) {
        this.medidaBraco = medidaBraco;
    }

    public Double getMedidaPeito() {
        return medidaPeito;
    }

    public void setMedidaPeito(Double medidaPeito) {
        this.medidaPeito = medidaPeito;
    }

    public Double getMedidaPerna() {
        return medidaPerna;
    }

    public void setMedidaPerna(Double medidaPerna) {
        this.medidaPerna = medidaPerna;
    }

    public Double getMedidaCintura() {
        return medidaCintura;
    }

    public void setMedidaCintura(Double medidaCintura) {
        this.medidaCintura = medidaCintura;
    }
}
