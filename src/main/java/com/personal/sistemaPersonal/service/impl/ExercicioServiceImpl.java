package com.personal.sistemaPersonal.service.impl;

import com.personal.sistemaPersonal.model.Exercicio;
import com.personal.sistemaPersonal.repository.ExercicioRepository;
import com.personal.sistemaPersonal.service.ExercicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExercicioServiceImpl implements ExercicioService {

    @Autowired
    ExercicioRepository exercicioRepository;

    public Boolean save(Exercicio exercicio) {
        try{
            exercicioRepository.save(exercicio);
            return true;
        }catch (Exception e){
            System.out.printf(e.toString());
            return false;
        }
    }

    public boolean delete(Exercicio exercicio){
        try{
            exercicioRepository.delete(exercicio);
            return true;
        }catch (Exception e){
            System.out.printf(e.toString());
            return false;
        }
    }

    public List<Exercicio> getAll(){
        return exercicioRepository.findAll();
    }

    public Exercicio getAvaliacaoFisicaById(Integer id){
        return exercicioRepository.findById(id).get();
    }
}
