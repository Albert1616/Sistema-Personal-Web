package com.personal.sistemaPersonal.service;

import com.personal.sistemaPersonal.model.FichaTreino;

public interface FichaTreinoService {
    public Integer save(FichaTreino fichaTreino);
    public FichaTreino getById(Integer id);
}
