package com.personal.sistemaPersonal.service;

import com.personal.sistemaPersonal.model.AvalicaoFisica;

import java.util.List;

public interface AvaliacaoFisicaService {
    public boolean save(AvalicaoFisica avalicaoFisica);
    public boolean delete(AvalicaoFisica avalicaoFisica);
    public List<AvalicaoFisica> getAll();
    public AvalicaoFisica getAvaliacaoFisicaById(Integer id);
    public List<AvalicaoFisica> getAvaliacoesFisicasByIdAluno(Integer idAluno);
}
