package com.personal.sistemaPersonal.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "treino")

public class Treino {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 20)
    private String titulo;

    @Column(length = 1)
    private TipoTreino tipo;

    @ManyToOne
    @JoinColumn(name = "ficha_treino_id")
    private FichaTreino ficha_treino;

    @Column(length = 10)
    private LocalDate data_criacao;

    @Column(length = 2)
    private Integer duracao;

    @Column(length = 10)
    private LocalDate data_vencimento;

    @ManyToMany
    @JoinTable(name = "treino_exercicio", joinColumns = @JoinColumn(name = "treino_id"),
    inverseJoinColumns = @JoinColumn(name = "exercicio_id"))
    private List<Exercicio> exercicios;
    public Treino(){};
    public Treino(String titulo, TipoTreino tipoTreino, Integer duracao){
        this.titulo = titulo;
        this.tipo = tipoTreino;
        this.duracao = duracao;
        this.data_criacao = LocalDate.now();
        this.data_vencimento = this.data_criacao.plusMonths(this.duracao);
    };
    public void adicionarExercicio(Exercicio exercicio){
        this.exercicios.add(exercicio);
    }

    public Integer getId() {
        return id;
    }

    public FichaTreino getFichaTreino() {
        return ficha_treino;
    }

    public String getTitulo() {
        return titulo;
    }

    public Integer getDuracao() {
        return duracao;
    }

    public List<Exercicio> getExercicios() {
        return exercicios;
    }

    public LocalDate getDataCriacao() {
        return data_criacao;
    }

    public LocalDate getDataVencimento() {
        return data_vencimento;
    }

    public TipoTreino getTipo() {
        return tipo;
    }

    public void setFichaTreino(FichaTreino fichaTreino) {
        this.ficha_treino = fichaTreino;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public void setDuracao(Integer duracao) {
        this.duracao = duracao;
        this.data_vencimento = this.data_criacao.plusMonths(duracao);
    }

    public void setExercicios(List<Exercicio> exercicios) {
        this.exercicios = exercicios;
    }

    public void setTipo(TipoTreino tipo) {
        tipo = tipo;
    }
}
