package com.personal.sistemaPersonal.service.impl;

import com.personal.sistemaPersonal.exception.TreinoNaoEncontradoException;
import com.personal.sistemaPersonal.model.Aluno;
import com.personal.sistemaPersonal.model.Exercicio;
import com.personal.sistemaPersonal.model.Treino;
import com.personal.sistemaPersonal.repository.TreinoRepository;
import com.personal.sistemaPersonal.rest.dto.response.TreinoResponseDTO;
import com.personal.sistemaPersonal.rest.dto.request.TreinoRequestDTO;
import com.personal.sistemaPersonal.service.AlunoService;
import com.personal.sistemaPersonal.service.ExercicioService;
import com.personal.sistemaPersonal.service.FichaTreinoService;
import com.personal.sistemaPersonal.service.TreinoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.time.LocalDate;
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

    @Autowired
    AlunoService alunoService;

    @Override
    public TreinoResponseDTO save(TreinoRequestDTO dto) {
        Treino treino = convert(dto);
        treino.setData_criacao(LocalDate.now());
        return convertToTreinoResponseDTO(treinoRepository.save(treino));
    }

    @Override
    public void delete(Integer id) {
        treinoRepository.delete(getById(id));
    }

    @Override
    public TreinoResponseDTO update(Integer id, TreinoRequestDTO dto) {
        Treino treino = getById(id);

        treino.setTitulo(dto.getTitulo());
        treino.setData_vencimento(dto.getData_vencimento());
        treino.setFicha_treino(fichaTreinoService.getById(dto.getFicha_treino()));

        List<Exercicio> exercicios = new ArrayList<>();

        dto.getExercicios().forEach((ex) ->{
            exercicios.add(exercicioService.getById(ex));
        });

        treino.setExercicios(exercicios);

        return convertToTreinoResponseDTO(treinoRepository.save(treino));
    }

    @Override
    public List<TreinoResponseDTO> getAll() {
        return convertToTreinoResponseDTO(treinoRepository.findAll());
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
    public TreinoResponseDTO getInformacoesTreinoDTO(Integer id) {
        return convertToTreinoResponseDTO(getById(id));
    }

    @Override
    public List<TreinoResponseDTO> getByIdAluno(Integer idAluno) {
        Aluno aluno = alunoService.getById(idAluno);
        return convertToTreinoResponseDTO(treinoRepository.findByAlunoId(aluno.getId()));
    }

    public Treino convert(TreinoRequestDTO dto){
        Treino treino = new Treino();

        treino.setTitulo(dto.getTitulo());
        treino.setData_vencimento(dto.getData_vencimento());
        treino.setFicha_treino(fichaTreinoService.getById(dto.getFicha_treino()));

        List<Exercicio> exercicios = new ArrayList<>();

        dto.getExercicios().forEach((ex) ->{
            exercicios.add(exercicioService.getById(ex));
        });

        treino.setExercicios(exercicios);

        return treino;
    }

    public TreinoResponseDTO convertToTreinoResponseDTO(Treino treino){
        return TreinoResponseDTO
                .builder()
                .id(treino.getId())
                .titulo(treino.getTitulo())
                .data_criacao(treino.getData_criacao())
                .data_vencimento(treino.getData_vencimento())
                .exercicios(treino.getExercicios())
                .build();
    }

    public List<TreinoResponseDTO> convertToTreinoResponseDTO(List<Treino> treinos){
        if(CollectionUtils.isEmpty(treinos)){
            return Collections.emptyList();
        }

        return treinos.stream().map(
                this::convertToTreinoResponseDTO
        ).collect(Collectors.toList());
    }
}
