package com.personal.sistemaPersonal.service.impl;

import com.personal.sistemaPersonal.exception.RefeicaoNaoEncontradaException;
import com.personal.sistemaPersonal.model.Dieta;
import com.personal.sistemaPersonal.model.Refeicao;
import com.personal.sistemaPersonal.repository.RefeicaoRepository;
import com.personal.sistemaPersonal.rest.dto.request.RefeicaoRequestDTO;
import com.personal.sistemaPersonal.rest.dto.response.RefeicaoResponseDTO;
import com.personal.sistemaPersonal.service.AlimentoService;
import com.personal.sistemaPersonal.service.DietaService;
import com.personal.sistemaPersonal.service.RefeicaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RefeicaoServiceImpl implements RefeicaoService {

    @Autowired
    RefeicaoRepository refeicaoRepository;

    @Autowired
    DietaService dietaService;

    @Override
    public RefeicaoResponseDTO save(RefeicaoRequestDTO dto) {
        Refeicao refeicao = convert(dto);
        return convertToRefeicaoResponseDTO(refeicaoRepository.save(refeicao));
    }

    @Override
    public Refeicao getById(Integer id) {
        Optional<Refeicao> refeicao = refeicaoRepository.findById(id);
        if(refeicao.isPresent()){
            return refeicao.get();
        }
        else throw new RefeicaoNaoEncontradaException();
    }

    @Override
    public RefeicaoResponseDTO getRefeicaoResponseDTOById(Integer id) {
        return convertToRefeicaoResponseDTO(getById(id));
    }

    @Override
    public void delete(Integer id) {
        refeicaoRepository.delete(getById(id));
    }

    @Override
    public void update(Integer id, RefeicaoRequestDTO dto) {
        Refeicao refeicao = getById(id);

        refeicao.setDescricao(dto.getDescricao());

        Dieta dieta = dietaService.getById(dto.getDieta());
        refeicao.setDieta(dieta);

        refeicaoRepository.save(refeicao);
    }

    @Override
    public List<RefeicaoResponseDTO> getAll() {
        return convertToRefeicaoResponseDTO(refeicaoRepository.findAll());
    }

    @Override
    public Refeicao convert(RefeicaoRequestDTO dto) {
        Refeicao refeicao = new Refeicao();

        refeicao.setDescricao(dto.getDescricao());

        Dieta dieta = dietaService.getById(dto.getDieta());
        refeicao.setDieta(dieta);

        return refeicao;
    }

    @Override
    public RefeicaoResponseDTO convertToRefeicaoResponseDTO(Refeicao refeicao) {
        if(Objects.isNull(refeicao)) return null;
        return RefeicaoResponseDTO
                .builder()
                .id(refeicao.getId())
                .descricao(refeicao.getDescricao())
                .build();
    }

    @Override
    public List<RefeicaoResponseDTO> convertToRefeicaoResponseDTO(List<Refeicao> refeicoes) {
        if(CollectionUtils.isEmpty(refeicoes)){
            return Collections.emptyList();
        }
        return refeicoes.stream().map(
                this::convertToRefeicaoResponseDTO
        ).collect(Collectors.toList());
    }
}
