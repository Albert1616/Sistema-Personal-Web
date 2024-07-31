package com.personal.sistemaPersonal.service.impl;

import com.personal.sistemaPersonal.entites.Aluno;

import com.personal.sistemaPersonal.entites.AvaliacaoFisica;
import com.personal.sistemaPersonal.exception.AvaliacaoFisicaNaoEncontradaException;
import com.personal.sistemaPersonal.feingClients.AlunoClient;
import com.personal.sistemaPersonal.repository.AvaliacaoRepository;
import com.personal.sistemaPersonal.rest.dto.request.AvaliacaoFisicaRequestDTO;
import com.personal.sistemaPersonal.rest.dto.response.AvaliacaoFisicaResponseDTO;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import com.personal.sistemaPersonal.service.AvaliacaoFisicaService;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AvaliacaoFisicaServiceImpl implements AvaliacaoFisicaService {

    @Autowired
    AvaliacaoRepository avaliacaoRepository;

    @Autowired
    AlunoClient alunoClient;

    @Override
    public AvaliacaoFisicaResponseDTO save(AvaliacaoFisicaRequestDTO dto){
        AvaliacaoFisica avaliacaoFisica = convert(dto);
        return convertToAvaliacaoFisicaResponseDTO(avaliacaoRepository.save(avaliacaoFisica));
    }

    @Override
    public void delete(Integer id){
        avaliacaoRepository.delete(getById(id));
    }

    @Override
    public AvaliacaoFisicaResponseDTO update(Integer id, AvaliacaoFisicaRequestDTO dto) {
        AvaliacaoFisica avaliacaoFisica = getById(id);

        avaliacaoFisica.setTitulo(dto.getTitulo());
        avaliacaoFisica.setData(dto.getData());
        avaliacaoFisica.setAlunoPeso(dto.getAlunoPeso());
        avaliacaoFisica.setAlunoAltura(dto.getAlunoAltura());
        avaliacaoFisica.setMedidaBraco(dto.getMedidaBraco());
        avaliacaoFisica.setMedidaPerna(dto.getMedidaPerna());
        avaliacaoFisica.setMedidaPeito(dto.getMedidaPeito());
        avaliacaoFisica.setMedidaCintura(dto.getMedidaCintura());
        avaliacaoFisica.setAluno(alunoClient.getAlunoById(dto.getAluno()).getId());

        return convertToAvaliacaoFisicaResponseDTO(avaliacaoRepository.save(avaliacaoFisica));
    }

    public List<AvaliacaoFisicaResponseDTO> getAll(){
        return convertToAvaliacaoFisicaResponseDTO(avaliacaoRepository.findAll());
    }

    @Override
    public List<AvaliacaoFisicaResponseDTO> getAvaliacoesFisicasByIdAluno(Integer idAluno){
        Aluno aluno = alunoClient.getAlunoById(idAluno);
        return convertToAvaliacaoFisicaResponseDTO(avaliacaoRepository.findAllAvaliacaoFisicaByIdAluno(aluno.getId()));
    }

    @Override
    public AvaliacaoFisica getById(Integer id) {
        Optional<AvaliacaoFisica> avalicaoFisica = avaliacaoRepository.findById(id);
        if(avalicaoFisica.isPresent()){
            return avalicaoFisica.get();
        }
        else throw new AvaliacaoFisicaNaoEncontradaException();
    }

    @Override
    public AvaliacaoFisicaResponseDTO getInformacoesAvaliacaoFisicaDTOById(Integer id) {
        return convertToAvaliacaoFisicaResponseDTO(getById(id));
    }

    @Override
    public AvaliacaoFisica convert(AvaliacaoFisicaRequestDTO dto){
        AvaliacaoFisica avalicaoFisica = new AvaliacaoFisica();

        avalicaoFisica.setTitulo(dto.getTitulo());
        avalicaoFisica.setData(dto.getData());
        avalicaoFisica.setAlunoPeso(dto.getAlunoPeso());
        avalicaoFisica.setAlunoAltura(dto.getAlunoAltura());
        avalicaoFisica.setMedidaBraco(dto.getMedidaBraco());
        avalicaoFisica.setMedidaPerna(dto.getMedidaPerna());
        avalicaoFisica.setMedidaPeito(dto.getMedidaPeito());
        avalicaoFisica.setMedidaCintura(dto.getMedidaCintura());
        avalicaoFisica.setAluno(alunoClient.getAlunoById(dto.getAluno()).getId());

        return avalicaoFisica;
    }

    @Override
    public AvaliacaoFisicaResponseDTO convertToAvaliacaoFisicaResponseDTO(AvaliacaoFisica avaliacaoFisica){
        if(Objects.isNull(avaliacaoFisica)) return null;
        return AvaliacaoFisicaResponseDTO
                .builder()
                .id(avaliacaoFisica.getId())
                .titulo(avaliacaoFisica.getTitulo())
                .data(avaliacaoFisica.getData())
                .alunoPeso(avaliacaoFisica.getAlunoPeso())
                .alunoAltura(avaliacaoFisica.getAlunoAltura())
                .medidaPeito(avaliacaoFisica.getMedidaPeito())
                .medidaCintura(avaliacaoFisica.getMedidaCintura())
                .medidaBraco(avaliacaoFisica.getMedidaBraco())
                .medidaPerna(avaliacaoFisica.getMedidaPerna())
                .aluno(alunoClient.getAlunoById(avaliacaoFisica.getAluno()))
                .build();
    }

    @Override
    public List<AvaliacaoFisicaResponseDTO> convertToAvaliacaoFisicaResponseDTO(List<AvaliacaoFisica> avaliacoesFisicas) {
        if (CollectionUtils.isEmpty(avaliacoesFisicas)){
            return Collections.emptyList();
        }

        return avaliacoesFisicas.stream().map(
                this::convertToAvaliacaoFisicaResponseDTO
        ).collect(Collectors.toList());
    }
}
