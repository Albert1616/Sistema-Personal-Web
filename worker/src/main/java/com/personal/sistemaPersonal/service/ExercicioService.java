package com.personal.sistemaPersonal.service;

import com.personal.sistemaPersonal.model.Exercicio;
import com.personal.sistemaPersonal.rest.dto.request.ExercicioRequestDTO;

import java.util.List;

public interface ExercicioService {
    public Exercicio save(ExercicioRequestDTO exercicio);
    public void delete(Integer id);
    public Exercicio update(Integer id, ExercicioRequestDTO dto);
    public List<Exercicio> getAll();
    public Exercicio getById(Integer id);
}
