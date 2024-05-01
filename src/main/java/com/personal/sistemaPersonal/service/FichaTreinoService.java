package com.personal.sistemaPersonal.service;

import com.personal.sistemaPersonal.model.FichaTreino;

public interface FichaTreinoService {
    public boolean save(FichaTreino fichaTreino);
    public FichaTreino findById(Integer id);
}
