package com.nutri.sistemaPersonal.service.impl;


import com.nutri.sistemaPersonal.entites.Dieta;
import com.nutri.sistemaPersonal.entites.Nutricionista;
import com.nutri.sistemaPersonal.exception.DietaNaoEncontradaException;
import com.nutri.sistemaPersonal.feingClients.AlunoClient;
import com.nutri.sistemaPersonal.repository.DietaRepository;
import com.nutri.sistemaPersonal.rest.dto.request.DietaRequestDTO;
import com.nutri.sistemaPersonal.rest.dto.response.DietaResponseDTO;
import com.nutri.sistemaPersonal.service.DietaService;
import com.nutri.sistemaPersonal.service.NutricionistaService;
import com.nutri.sistemaPersonal.entites.Aluno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DietaServiceImpl implements DietaService {

    @Autowired
    DietaRepository dietaRepository;

    @Autowired
    AlunoClient alunoClient;

    @Autowired
    NutricionistaService nutricionistaService;

    @Override
    public DietaResponseDTO save(DietaRequestDTO dto) {
        Dieta dieta = convert(dto);
        dieta.setData_criacao(LocalDate.now());
        return convertToDietaResponseDTO(dietaRepository.save(dieta));
    }

    @Override
    public Dieta getById(Integer id) {
        Optional<Dieta> dieta = dietaRepository.findById(id);
        if (dieta.isPresent()){
            return dieta.get();
        }
        else throw new DietaNaoEncontradaException();
    }

    @Override
    public DietaResponseDTO getDietaResponseDTOById(Integer id) {
        return convertToDietaResponseDTO(getById(id));
    }

    @Override
    public void delete(Integer id) {
        dietaRepository.delete(getById(id));
    }

    @Override
    public void update(Integer id, DietaRequestDTO dto) {
        Dieta dieta = getById(id);

        dieta.setTitulo(dto.getTitulo());

        Aluno aluno = alunoClient.getAlunoById(dto.getAluno());
        dieta.setAluno(aluno);

        Nutricionista nutricionista = nutricionistaService.getById(dto.getNutricionista());
        dieta.setNutricionista(nutricionista);

        dietaRepository.save(dieta);
    }

    @Override
    public List<DietaResponseDTO> getAll() {
        return convertToDietaResponseDTO(dietaRepository.findAll());
    }

    @Override
    public Dieta convert(DietaRequestDTO dto) {
        Dieta dieta = new Dieta();

        dieta.setTitulo(dto.getTitulo());

        Aluno aluno = alunoClient.getAlunoById(dto.getAluno());
        dieta.setAluno(aluno);

        Nutricionista nutricionista = nutricionistaService.getById(dto.getNutricionista());
        dieta.setNutricionista(nutricionista);

        return dieta;
    }

    @Override
    public DietaResponseDTO convertToDietaResponseDTO(Dieta dieta) {
        if(Objects.isNull(dieta)) return null;
        return DietaResponseDTO
                .builder()
                .id(dieta.getId())
                .titulo(dieta.getTitulo())
                .data_criacao(dieta.getData_criacao())
                .build();
    }

    @Override
    public List<DietaResponseDTO> convertToDietaResponseDTO(List<Dieta> dietas) {
        if(CollectionUtils.isEmpty(dietas)){
            return Collections.emptyList();
        }
        return dietas.stream().map(
                this::convertToDietaResponseDTO
        ).collect(Collectors.toList());
    }
}