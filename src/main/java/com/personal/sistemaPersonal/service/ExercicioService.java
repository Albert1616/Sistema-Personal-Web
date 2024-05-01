package com.personal.sistemaPersonal.service;

import com.personal.sistemaPersonal.model.Exercicio;

import java.util.List;

public interface ExercicioService {
    public Boolean save(Exercicio exercicio);
    public boolean delete(Exercicio exercicio);
    public List<Exercicio> getAll();
    public Exercicio getAvaliacaoFisicaById(Integer id);
}
