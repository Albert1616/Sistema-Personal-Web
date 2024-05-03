package com.personal.sistemaPersonal.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class Refeicao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 40)
    private String titulo;

    @ManyToOne
    @JoinColumn(name = "dieta_id")
    private Dieta dieta;

    @OneToMany(mappedBy = "refeicao", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<Alimento> alimentos;
}
