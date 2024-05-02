package com.personal.sistemaPersonal.service.impl;

import com.personal.sistemaPersonal.exception.ExercicioNaoEncontradoException;
import com.personal.sistemaPersonal.model.Exercicio;
import com.personal.sistemaPersonal.repository.ExercicioRepository;
import com.personal.sistemaPersonal.rest.dto.request.ExercicioRequestDTO;
import com.personal.sistemaPersonal.service.ExercicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExercicioServiceImpl implements ExercicioService {

    @Autowired
    ExercicioRepository exercicioRepository;

    @Override
    public Exercicio save(ExercicioRequestDTO exercicio) {
        return exercicioRepository.save(convert(exercicio));
    }

    @Override
    public Exercicio update(Integer id, ExercicioRequestDTO dto) {
        Exercicio exercicio = getById(id);

        exercicio.setNome(dto.getNome());
        exercicio.setSeries(dto.getSeries());
        exercicio.setRepeticoes(dto.getRepeticoes());
        exercicio.setObservacoes(dto.getObservacoes());

        return exercicioRepository.save(exercicio);
    }

    @Override
    public void delete(Integer id){
        exercicioRepository.delete(getById(id));
    }

    @Override
    public List<Exercicio> getAll(){
        return exercicioRepository.findAll();
    }

    @Override
    public Exercicio getById(Integer id){
        Optional<Exercicio> exercicio = exercicioRepository.findById(id);
        if (exercicio.isPresent()){
            return exercicio.get();
        }
        else throw new ExercicioNaoEncontradoException();
    }

    public Exercicio convert(ExercicioRequestDTO dto){
        Exercicio exercicio = new Exercicio();

        exercicio.setNome(dto.getNome());
        exercicio.setSeries(dto.getSeries());
        exercicio.setRepeticoes(dto.getRepeticoes());
        exercicio.setObservacoes(dto.getObservacoes());

        return exercicio;
    }
}
