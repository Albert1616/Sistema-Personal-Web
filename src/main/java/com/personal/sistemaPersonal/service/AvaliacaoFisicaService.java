package com.personal.sistemaPersonal.service;

import com.personal.sistemaPersonal.model.AvalicaoFisica;
import com.personal.sistemaPersonal.repository.AvaliacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
public class AvaliacaoFisicaService {

    @Autowired
    AvaliacaoRepository avaliacaoRepository;

    public boolean save(AvalicaoFisica avalicaoFisica){
        try{
            avaliacaoRepository.save(avalicaoFisica);
            return true;
        }catch (Exception e){
            System.out.printf(e.toString());
            return false;
        }
    }

    public boolean delete(AvalicaoFisica avalicaoFisica){
        try{
            avaliacaoRepository.delete(avalicaoFisica);
            return true;
        }catch (Exception e){
            System.out.printf(e.toString());
            return false;
        }
    }

    public List<AvalicaoFisica> getAll(){
        return avaliacaoRepository.findAll();
    }

    public AvalicaoFisica getAvaliacaoFisicaById(Integer id){
        return avaliacaoRepository.findById(id).get();
    }

    public List<AvalicaoFisica> getAvaliacoesFisicasByIdAluno(Integer idAluno){
        return avaliacaoRepository.findAllAvaliacaoFisicaByIdAluno(idAluno);
    }
}
