package com.personal.sistemaPersonal.service.impl;

import com.personal.sistemaPersonal.model.FichaTreino;
import com.personal.sistemaPersonal.repository.FichaTreinoRepository;
import com.personal.sistemaPersonal.service.FichaTreinoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FichaTreinoServiceImpl implements FichaTreinoService {

    @Autowired
    private FichaTreinoRepository fichaTreinoRepository;

    public boolean save(FichaTreino fichaTreino) {
        try{
            fichaTreinoRepository.save(fichaTreino);
            return true;
        }catch (Exception e){
            System.err.println(e.toString());
            return false;
        }
    }

    public FichaTreino findById(Integer id) {
        return fichaTreinoRepository.findById(id).orElse(null);
    }
}
