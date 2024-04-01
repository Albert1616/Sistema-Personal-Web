package model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "aluno")
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 30)
    private String nome;
    @OneToMany
    private List<Avalicao> avalicoesFisicas;
    @OneToOne
    private FichaTreino fichaTreino;
    public Aluno(){};
    public Aluno(String nome){
        this.nome = nome;
    }
    public Aluno(String nome, FichaTreino fichaTreino){
        this.nome = nome;
        this.fichaTreino = fichaTreino;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public FichaTreino getFichaTreino() {
        return fichaTreino;
    }

    public List<Avalicao> getAvalicoesFisicas() {
        return avalicoesFisicas;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setAvalicoesFisicas(List<Avalicao> avalicoesFisicas) {
        this.avalicoesFisicas = avalicoesFisicas;
    }

    public void setFichaTreino(FichaTreino fichaTreino) {
        this.fichaTreino = fichaTreino;
    }
    public void adicionarAvalicao(Avalicao avalicao){
        this.avalicoesFisicas.add(avalicao);
    }
}
