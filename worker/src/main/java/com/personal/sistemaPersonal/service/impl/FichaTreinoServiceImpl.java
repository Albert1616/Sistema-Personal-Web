package com.personal.sistemaPersonal.service.impl;

import com.personal.sistemaPersonal.exception.FichaTreinoNaoEncontradaException;
import com.personal.sistemaPersonal.model.FichaTreino;
import com.personal.sistemaPersonal.repository.FichaTreinoRepository;
import com.personal.sistemaPersonal.service.FichaTreinoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FichaTreinoServiceImpl implements FichaTreinoService {

    @Autowired
    private FichaTreinoRepository fichaTreinoRepository;

    @Override
    public Integer save(FichaTreino fichaTreino) {
        return fichaTreinoRepository.save(fichaTreino).getId();
    }

    @Override
    public FichaTreino getById(Integer id) {
        Optional<FichaTreino> fichaTreino = fichaTreinoRepository.findById(id);
        if (fichaTreino.isPresent()){
            return fichaTreino.get();
        }
        else throw new FichaTreinoNaoEncontradaException();
    }
}
