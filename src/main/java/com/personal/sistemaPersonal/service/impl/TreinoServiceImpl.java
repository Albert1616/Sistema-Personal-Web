package com.personal.sistemaPersonal.service.impl;

import com.personal.sistemaPersonal.exception.TreinoNaoEncontradoException;
import com.personal.sistemaPersonal.model.Exercicio;
import com.personal.sistemaPersonal.model.Treino;
import com.personal.sistemaPersonal.repository.TreinoRepository;
import com.personal.sistemaPersonal.rest.dto.InformacoesTreinoDTO;
import com.personal.sistemaPersonal.rest.dto.TreinoDTO;
import com.personal.sistemaPersonal.service.ExercicioService;
import com.personal.sistemaPersonal.service.FichaTreinoService;
import com.personal.sistemaPersonal.service.TreinoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TreinoServiceImpl implements TreinoService {

    @Autowired
    TreinoRepository treinoRepository;

    @Autowired
    FichaTreinoService fichaTreinoService;

    @Autowired
    ExercicioService exercicioService;

    @Override
    public InformacoesTreinoDTO save(TreinoDTO treino) {
        return convertToInformacoesTreinoDTO(treinoRepository.save(convert(treino)));
    }

    @Override
    public void delete(Integer id) {
        treinoRepository.delete(getById(id));
    }

    @Override
    public InformacoesTreinoDTO update(Integer id, TreinoDTO dto) {
        Treino treino = getById(id);

        treino.setTitulo(dto.getTitulo());
        treino.setData_vencimento(dto.getData_vencimento());
        treino.setFicha_treino(fichaTreinoService.getById(dto.getFichaTreino()));

        List<Exercicio> exercicios = new ArrayList<>();

        dto.getExercicios().forEach((ex) ->{
            exercicios.add(exercicioService.getById(ex));
        });

        treino.setExercicios(exercicios);

        return convertToInformacoesTreinoDTO(treino);
    }

    @Override
    public List<InformacoesTreinoDTO> getAll() {
        return convertToInformacoesTreinoDTO(treinoRepository.findAll());
    }

    @Override
    public Treino getById(Integer id) {
        Optional<Treino> treino = treinoRepository.findById(id);
        if(treino.isPresent()){
            return treino.get();
        }
        else throw new TreinoNaoEncontradoException();
    }

    @Override
    public InformacoesTreinoDTO getInformacoesTreinoDTO(Integer id) {
        return convertToInformacoesTreinoDTO(getById(id));
    }

    @Override
    public List<InformacoesTreinoDTO> getByIdAluno(Integer idAluno) {
        return convertToInformacoesTreinoDTO(treinoRepository.findByAlunoId(idAluno));
    }

    public Treino convert(TreinoDTO dto){
        Treino treino = new Treino();

        treino.setTitulo(dto.getTitulo());
        treino.setData_vencimento(dto.getData_vencimento());
        treino.setFicha_treino(fichaTreinoService.getById(dto.getFichaTreino()));

        List<Exercicio> exercicios = new ArrayList<>();

        dto.getExercicios().forEach((ex) ->{
            exercicios.add(exercicioService.getById(ex));
        });

        treino.setExercicios(exercicios);

        return treino;
    }

    public InformacoesTreinoDTO convertToInformacoesTreinoDTO(Treino treino){
        return InformacoesTreinoDTO
                .builder()
                .id(treino.getId())
                .titulo(treino.getTitulo())
                .data_criacao(treino.getData_criacao())
                .data_vencimento(treino.getData_vencimento())
                .exercicios(treino.getExercicios())
                .build();
    }

    public List<InformacoesTreinoDTO> convertToInformacoesTreinoDTO(List<Treino> treinos){
        if(CollectionUtils.isEmpty(treinos)){
            return Collections.emptyList();
        }

        return treinos.stream().map(
                this::convertToInformacoesTreinoDTO
        ).collect(Collectors.toList());
    }
}
