package com.personal.sistemaPersonal.service.impl;

import com.personal.sistemaPersonal.exception.DietaNaoEncontradaException;
import com.personal.sistemaPersonal.model.Aluno;
import com.personal.sistemaPersonal.model.Dieta;
import com.personal.sistemaPersonal.model.Nutricionista;
import com.personal.sistemaPersonal.repository.DietaRepository;
import com.personal.sistemaPersonal.rest.dto.request.DietaRequestDTO;
import com.personal.sistemaPersonal.rest.dto.response.DietaResponseDTO;
import com.personal.sistemaPersonal.service.AlunoService;
import com.personal.sistemaPersonal.service.DietaService;
import com.personal.sistemaPersonal.service.NutricionistaService;
import com.personal.sistemaPersonal.service.RefeicaoService;
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
    AlunoService alunoService;

    @Autowired
    NutricionistaService nutricionistaService;

    @Autowired
    RefeicaoService refeicaoService;

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

        Aluno aluno = alunoService.getById(dto.getAluno());
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

        Aluno aluno = alunoService.getById(dto.getAluno());
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
                .refeicoes(refeicaoService.convertToRefeicaoResponseDTO(dieta.getRefeicoes()))
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