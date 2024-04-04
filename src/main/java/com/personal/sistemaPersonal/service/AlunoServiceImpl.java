package com.personal.sistemaPersonal.service;

import com.personal.sistemaPersonal.model.Aluno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.personal.sistemaPersonal.repository.AlunoRepository;

import java.util.List;
import java.util.Optional;

@Component
public class AlunoServiceImpl implements AlunoService {
    @Autowired
    AlunoRepository alunoRepository;

    @Override
    public boolean save(Aluno aluno) {
        try{
            alunoRepository.save(aluno);
            return true;
        }catch (Exception e){
            System.out.printf(e.toString());
            return false;
        }
    }

    @Override
    public boolean delete(Aluno aluno) {
        if(alunoRepository.findById(aluno.getId())!=null){
            alunoRepository.delete(aluno);
            return true;
        }
        System.out.printf("Aluno não encontrado!");
        return false;
    }

    @Override
    public boolean update(Integer id) {
        if(alunoRepository.findById(id)!=null){
            Optional<Aluno> aluno = alunoRepository.findById(id);
            alunoRepository.save(aluno.get());
            return true;
        }
        System.out.printf("Aluno não encontrado!");
        return false;
    }

    @Override
    public List<Aluno> getAll() {
        return alunoRepository.findAll();
    }

    @Override
    public Aluno getAlunoById(Integer id) {
        Optional<Aluno> aluno =  alunoRepository.findById(id);
        return aluno.get();
    }
}
