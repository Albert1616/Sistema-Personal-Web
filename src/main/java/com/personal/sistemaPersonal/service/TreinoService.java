package com.personal.sistemaPersonal.service;

import com.personal.sistemaPersonal.model.Treino;
import com.personal.sistemaPersonal.repository.TreinoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TreinoService {

    @Autowired
    TreinoRepository treinoRepository;

    public boolean save(Treino treino) {
        try{
            treinoRepository.save(treino);
            return true;
        }catch ( Exception e ) {
            System.err.println(e.getMessage());
            return false;
        }
    }

    public boolean delete(Treino treino) {
        try{
            treinoRepository.delete(treino);
            return true;
        }catch ( Exception e ) {
            System.err.println(e.getMessage());
            return false;
        }
    }

    public List<Treino> findAll() {
        return treinoRepository.findAll();
    }

    public Treino findById(Integer id) {
        return treinoRepository.findById(id).orElse(null);
    }

    public List<Treino> findByIdAluno(Integer idAluno) {
        return treinoRepository.findByAlunoId(idAluno);
    }
}
