package com.personal.sistemaPersonal.service.impl;

import com.personal.sistemaPersonal.exception.NutricionistaNaoEncontradoException;
import com.personal.sistemaPersonal.model.Nutricionista;
import com.personal.sistemaPersonal.repository.NutricionistaRepository;
import com.personal.sistemaPersonal.rest.dto.request.NutricionistaRequestDTO;
import com.personal.sistemaPersonal.rest.dto.response.NutricionistaResponseDTO;
import com.personal.sistemaPersonal.service.NutricionistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NutricionistaServiceImpl implements NutricionistaService {
    @Autowired
    NutricionistaRepository nutricionistaRepository;

    @Override
    public NutricionistaResponseDTO save(NutricionistaRequestDTO dto) {
        Nutricionista nutricionista = convert(dto);
        return convertToNutricionistaResponseDTO(nutricionistaRepository.save(nutricionista));
    }

    @Override
    public Nutricionista getById(Integer id) {
        Optional<Nutricionista> nutricionista = nutricionistaRepository.findById(id);
        if(nutricionista.isPresent()){
            return nutricionista.get();
        }
        else throw new NutricionistaNaoEncontradoException();
    }

    @Override
    public NutricionistaResponseDTO getNutricionistaResponseDTOById(Integer id) {
        return convertToNutricionistaResponseDTO(getById(id));
    }

    @Override
    public void delete(Integer id) {
        nutricionistaRepository.delete(getById(id));
    }

    @Override
    public void update(Integer id, NutricionistaRequestDTO dto) {
        Nutricionista nutricionista = getById(id);

        nutricionista.setNome(dto.getNome());
        nutricionista.setEmail(dto.getEmail());
        nutricionista.setDataNascimento(dto.getData_nascimento());

        nutricionistaRepository.save(nutricionista);
    }

    @Override
    public List<NutricionistaResponseDTO> getAll() {
        return convertToNutricionistaResponseDTO(nutricionistaRepository.findAll());
    }

    @Override
    public Nutricionista convert(NutricionistaRequestDTO dto) {
        Nutricionista nutricionista = new Nutricionista();

        nutricionista.setNome(dto.getNome());
        nutricionista.setEmail(dto.getEmail());
        nutricionista.setDataNascimento(dto.getData_nascimento());

        return nutricionista;
    }

    @Override
    public NutricionistaResponseDTO convertToNutricionistaResponseDTO(Nutricionista nutricionista) {
        if(Objects.isNull(nutricionista)) return null;
        return NutricionistaResponseDTO
                .builder()
                .id(nutricionista.getId())
                .nome(nutricionista.getNome())
                .email(nutricionista.getEmail())
                .data_nascimento(nutricionista.getDataNascimento())
                .build();
    }

    @Override
    public List<NutricionistaResponseDTO> convertToNutricionistaResponseDTO(List<Nutricionista> nutricionistas) {
        if(CollectionUtils.isEmpty(nutricionistas)){
            return Collections.emptyList();
        }
        return nutricionistas.stream().map(
                this::convertToNutricionistaResponseDTO
        ).collect(Collectors.toList());
    }
}
