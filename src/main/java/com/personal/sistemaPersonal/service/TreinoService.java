package com.personal.sistemaPersonal.service;

import com.personal.sistemaPersonal.model.Treino;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TreinoService {
    public boolean save(Treino treino);
    public boolean delete(Treino treino);
    public List<Treino> findAll();
    public Treino findById(Integer id);
    public List<Treino> findByIdAluno(Integer idAluno);
}
