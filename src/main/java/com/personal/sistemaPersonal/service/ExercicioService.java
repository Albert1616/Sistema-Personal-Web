package com.personal.sistemaPersonal.service;

import com.personal.sistemaPersonal.model.Exercicio;
import com.personal.sistemaPersonal.rest.dto.ExercicioDTO;

import java.util.List;

public interface ExercicioService {
    public Exercicio save(ExercicioDTO exercicio);
    public void delete(Integer id);
    public Exercicio update(Integer id, ExercicioDTO dto);
    public List<Exercicio> getAll();
    public Exercicio getById(Integer id);
}
