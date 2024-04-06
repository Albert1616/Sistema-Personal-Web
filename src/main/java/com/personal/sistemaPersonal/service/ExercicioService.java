package com.personal.sistemaPersonal.service;

import com.personal.sistemaPersonal.model.AvalicaoFisica;
import com.personal.sistemaPersonal.model.Exercicio;
import com.personal.sistemaPersonal.repository.ExercicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExercicioService {

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
