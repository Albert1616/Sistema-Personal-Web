package com.personal.sistemaPersonal.service.impl;


import com.personal.sistemaPersonal.entites.Exercicio;
import com.personal.sistemaPersonal.entites.FichaTreino;
import com.personal.sistemaPersonal.exception.FichaTreinoNaoEncontradaException;
import com.personal.sistemaPersonal.repository.FichaTreinoRepository;
import com.personal.sistemaPersonal.rest.dto.request.ExercicioRequestDTO;
import com.personal.sistemaPersonal.rest.dto.request.FichaTreinoRequestDTO;
import com.personal.sistemaPersonal.service.FichaTreinoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FichaTreinoServiceImpl implements FichaTreinoService {

    @Autowired
    private FichaTreinoRepository fichaTreinoRepository;

    @Override
    public Integer save(FichaTreinoRequestDTO ficha) {
        return fichaTreinoRepository.save(convert(ficha)).getId();
    }

    @Override
    public FichaTreino getById(Integer id) {
        Optional<FichaTreino> fichaTreino = fichaTreinoRepository.findById(id);
        if (fichaTreino.isPresent()){
            return fichaTreino.get();
        }
        else throw new FichaTreinoNaoEncontradaException();
    }

    @Override
    public List<FichaTreino> getAll(){
        return fichaTreinoRepository.findAll();
    }

    public FichaTreino convert(FichaTreinoRequestDTO dto){
        FichaTreino fichaTreino = new FichaTreino();

        fichaTreino.setTitulo(dto.getTitulo());
        fichaTreino.setAluno(dto.getAluno());
        fichaTreino.setTreinos(new ArrayList<>());
        return fichaTreino;
    }
}
