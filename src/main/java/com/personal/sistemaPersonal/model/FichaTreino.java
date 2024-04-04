package com.personal.sistemaPersonal.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "FichaTreino")

public class FichaTreino {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 20)
    private String titulo;
    @OneToMany
    private List<Treino> treinos;
    public FichaTreino(){}
    public FichaTreino(String titulo){
        this.titulo = titulo;
    }

    public Integer getId() {
        return id;
    }

    public List<Treino> getTreinos() {
        return treinos;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setTreinos(List<Treino> treinos) {
        this.treinos = treinos;
    }
    public void adicionarTreino(Treino treino){
        this.treinos.add(treino);
    }
}
