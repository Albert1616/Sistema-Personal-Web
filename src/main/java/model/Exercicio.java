package model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "exercicio")

public class Exercicio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 20)
    private String nome;
    @Column(length = 2)
    private Integer series;
    @Column(length = 50)
    private Integer repeticoes;
    @Column(length = 100)
    private String observacoes;
    @ManyToMany
    @JoinTable(name = "treino_exercicio", joinColumns = @JoinColumn(name = "exercicio_id"),
    inverseJoinColumns = @JoinColumn(name = "treino_id"))
    private List<FichaTreino> fichas;
    public Exercicio(){};
    public Exercicio(String nome, Integer series, Integer repeticoes, String observacoes){
        this.nome = nome;
        this.series = series;
        this.repeticoes = repeticoes;
        this.observacoes = observacoes;
    };
    public void adicionarFicha(FichaTreino fichaTreino){
        this.fichas.add(fichaTreino);
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Integer getRepeticoes() {
        return repeticoes;
    }

    public Integer getSeries() {
        return series;
    }

    public List<FichaTreino> getFichas() {
        return fichas;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setFichas(List<FichaTreino> fichas) {
        this.fichas = fichas;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public void setRepeticoes(Integer repeticoes) {
        this.repeticoes = repeticoes;
    }

    public void setSeries(Integer series) {
        this.series = series;
    }
}
