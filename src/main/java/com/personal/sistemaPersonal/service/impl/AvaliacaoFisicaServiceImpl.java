package com.personal.sistemaPersonal.service.impl;

import com.personal.sistemaPersonal.exception.AvaliacaoFisicaNaoEncontradaException;
import com.personal.sistemaPersonal.model.Aluno;
import com.personal.sistemaPersonal.model.AvaliacaoFisica;
import com.personal.sistemaPersonal.repository.AvaliacaoRepository;
import com.personal.sistemaPersonal.rest.dto.AvaliacaoFisicaDTO;
import com.personal.sistemaPersonal.rest.dto.InformacoesAvaliacaoFisicaDTO;
import com.personal.sistemaPersonal.service.AlunoService;
import com.personal.sistemaPersonal.service.AvaliacaoFisicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AvaliacaoFisicaServiceImpl implements AvaliacaoFisicaService {

    @Autowired
    AvaliacaoRepository avaliacaoRepository;

    @Autowired
    AlunoService alunoService;

    @Override
    public InformacoesAvaliacaoFisicaDTO save(AvaliacaoFisicaDTO dto){
        AvaliacaoFisica avaliacaoFisica = convert(dto);
        return convertToInformacoesAvaliacaoFisicaDTO(avaliacaoRepository.save(avaliacaoFisica));
    }

    @Override
    public void delete(Integer id){
        avaliacaoRepository.delete(getById(id));
    }

    @Override
    public InformacoesAvaliacaoFisicaDTO update(Integer id, AvaliacaoFisicaDTO dto) {
        AvaliacaoFisica avaliacaoFisica = getById(id);

        avaliacaoFisica.setTitulo(dto.getTitulo());
        avaliacaoFisica.setData(dto.getData());
        avaliacaoFisica.setAlunoPeso(dto.getAlunoPeso());
        avaliacaoFisica.setAlunoAltura(dto.getAlunoAltura());
        avaliacaoFisica.setMedidaBraco(dto.getMedidaBraco());
        avaliacaoFisica.setMedidaPerna(dto.getMedidaPerna());
        avaliacaoFisica.setMedidaPeito(dto.getMedidaPeito());
        avaliacaoFisica.setMedidaCintura(dto.getMedidaCintura());
        avaliacaoFisica.setAluno(alunoService.getById(dto.getAluno()));

        return convertToInformacoesAvaliacaoFisicaDTO(avaliacaoRepository.save(avaliacaoFisica));
    }

    public List<InformacoesAvaliacaoFisicaDTO> getAll(){
        return convertToInformacoesAvaliacaoFisicaDTO(avaliacaoRepository.findAll());
    }

    @Override
    public List<InformacoesAvaliacaoFisicaDTO> getAvaliacoesFisicasByIdAluno(Integer idAluno){
        Aluno aluno = alunoService.getById(idAluno);
        return convertToInformacoesAvaliacaoFisicaDTO(avaliacaoRepository.findAllAvaliacaoFisicaByIdAluno(aluno.getId()));
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
    public InformacoesAvaliacaoFisicaDTO getInformacoesAvaliacaoFisicaDTOById(Integer id) {
        return convertToInformacoesAvaliacaoFisicaDTO(getById(id));
    }

    @Override
    public AvaliacaoFisica convert(AvaliacaoFisicaDTO dto){
        AvaliacaoFisica avalicaoFisica = new AvaliacaoFisica();

        avalicaoFisica.setTitulo(dto.getTitulo());
        avalicaoFisica.setData(dto.getData());
        avalicaoFisica.setAlunoPeso(dto.getAlunoPeso());
        avalicaoFisica.setAlunoAltura(dto.getAlunoAltura());
        avalicaoFisica.setMedidaBraco(dto.getMedidaBraco());
        avalicaoFisica.setMedidaPerna(dto.getMedidaPerna());
        avalicaoFisica.setMedidaPeito(dto.getMedidaPeito());
        avalicaoFisica.setMedidaCintura(dto.getMedidaCintura());
        avalicaoFisica.setAluno(alunoService.getById(dto.getAluno()));

        return avalicaoFisica;
    }

    @Override
    public InformacoesAvaliacaoFisicaDTO convertToInformacoesAvaliacaoFisicaDTO(AvaliacaoFisica avaliacaoFisica){
        return InformacoesAvaliacaoFisicaDTO
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
                .aluno(alunoService.convertToInformacoesAlunoDTO(avaliacaoFisica.getAluno()))
                .build();
    }

    @Override
    public List<InformacoesAvaliacaoFisicaDTO> convertToInformacoesAvaliacaoFisicaDTO(List<AvaliacaoFisica> avaliacoesFisicas) {
        if (CollectionUtils.isEmpty(avaliacoesFisicas)){
            return Collections.emptyList();
        }

        return avaliacoesFisicas.stream().map(
                this::convertToInformacoesAvaliacaoFisicaDTO
        ).collect(Collectors.toList());
    }
}
