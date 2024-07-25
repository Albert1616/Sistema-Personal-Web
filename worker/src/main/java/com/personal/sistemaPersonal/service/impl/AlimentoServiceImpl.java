package com.personal.sistemaPersonal.service.impl;

import com.personal.sistemaPersonal.exception.AlimentoNaoEncontradoException;
import com.personal.sistemaPersonal.model.Alimento;
import com.personal.sistemaPersonal.model.Refeicao;
import com.personal.sistemaPersonal.repository.AlimentoRepository;
import com.personal.sistemaPersonal.rest.dto.request.AlimentoRequestDTO;
import com.personal.sistemaPersonal.rest.dto.response.AlimentoResponseDTO;
import com.personal.sistemaPersonal.service.AlimentoService;
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
public class AlimentoServiceImpl implements AlimentoService {

    @Autowired
    AlimentoRepository alimentoRepository;

    @Autowired
    RefeicaoService refeicaoService;

    @Override
    public AlimentoResponseDTO save(AlimentoRequestDTO dto) {
        Alimento alimento = convert(dto);
        return convertToAlimentoResponseDTO(alimentoRepository.save(alimento));
    }

    @Override
    public Alimento getById(Integer id) {
        Optional<Alimento> alimento = alimentoRepository.findById(id);
        if (alimento.isPresent()){
            return alimento.get();
        }
        else throw new AlimentoNaoEncontradoException();
    }

    @Override
    public AlimentoResponseDTO getAlimentoResponseDTOById(Integer id) {
        return convertToAlimentoResponseDTO(getById(id));
    }

    @Override
    public void delete(Integer id) {
        alimentoRepository.delete(getById(id));
    }

    @Override
    public void update(Integer id, AlimentoRequestDTO dto) {
        Alimento alimento = getById(id);

        alimento.setDescricao(dto.getDescricao());
        alimento.setMedida(dto.getMedida());

        Refeicao refeicao = refeicaoService.getById(dto.getRefeicao());
        alimento.setRefeicao(refeicao);
        alimentoRepository.save(alimento);
    }

    @Override
    public List<AlimentoResponseDTO> getAll() {
        return convertToAlimentoResponseDTO(alimentoRepository.findAll());
    }

    @Override
    public Alimento convert(AlimentoRequestDTO dto) {
        Alimento alimento = new Alimento();

        alimento.setDescricao(dto.getDescricao());
        alimento.setMedida(dto.getMedida());

        Refeicao refeicao = refeicaoService.getById(dto.getRefeicao());
        alimento.setRefeicao(refeicao);

        return alimento;
    }

    @Override
    public AlimentoResponseDTO convertToAlimentoResponseDTO(Alimento alimento) {
        if(Objects.isNull(alimento)) return null;
        return AlimentoResponseDTO
                .builder()
                .id(alimento.getId())
                .descricao(alimento.getDescricao())
                .medida(alimento.getMedida())
                .build();
    }

    @Override
    public List<AlimentoResponseDTO> convertToAlimentoResponseDTO(List<Alimento> alimentos) {
        if(CollectionUtils.isEmpty(alimentos)){
            return Collections.emptyList();
        }
        return alimentos.stream().map(
                this::convertToAlimentoResponseDTO
        ).collect(Collectors.toList());
    }
}
