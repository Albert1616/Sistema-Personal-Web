package model;

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
    private TipoTreino Tipo;
    @ManyToOne
    private FichaTreino fichaTreino;
    @Column(length = 10)
    private LocalDate dataCriacao;
    @Column(length = 2)
    private Integer duracao;
    @Column(length = 10)
    private LocalDate dataVencimento;
    @ManyToMany
    @JoinTable(name = "treino_exercicio", joinColumns = @JoinColumn(name = "treino_id"),
    inverseJoinColumns = @JoinColumn(name = "exercicio_id"))
    private List<Exercicio> exercicios;
    public Treino(){};
    public Treino(String titulo, TipoTreino tipoTreino, Integer duracao){
        this.titulo = titulo;
        this.Tipo = tipoTreino;
        this.duracao = duracao;
        this.dataCriacao = LocalDate.now();
        this.dataVencimento = this.dataCriacao.plusMonths(this.duracao);
    };
    public void adicionarExercicio(Exercicio exercicio){
        this.exercicios.add(exercicio);
    }

    public Integer getId() {
        return id;
    }

    public FichaTreino getFichaTreino() {
        return fichaTreino;
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
        return dataCriacao;
    }

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

    public TipoTreino getTipo() {
        return Tipo;
    }

    public void setFichaTreino(FichaTreino fichaTreino) {
        this.fichaTreino = fichaTreino;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public void setDuracao(Integer duracao) {
        this.duracao = duracao;
        this.dataVencimento = this.dataCriacao.plusMonths(duracao);
    }

    public void setExercicios(List<Exercicio> exercicios) {
        this.exercicios = exercicios;
    }

    public void setTipo(TipoTreino tipo) {
        Tipo = tipo;
    }
}
