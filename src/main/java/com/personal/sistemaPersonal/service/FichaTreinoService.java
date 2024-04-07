package com.personal.sistemaPersonal.service;

import com.personal.sistemaPersonal.model.FichaTreino;
import com.personal.sistemaPersonal.repository.FichaTreinoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class FichaTreinoService {

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
