package com.personal.sistemaPersonal.service;

import com.personal.sistemaPersonal.model.Alimento;
import com.personal.sistemaPersonal.rest.dto.request.AlimentoRequestDTO;
import com.personal.sistemaPersonal.rest.dto.response.AlimentoResponseDTO;

import java.util.List;

public interface AlimentoService {
    AlimentoResponseDTO save(AlimentoRequestDTO alimento);
    Alimento getById(Integer id);
    AlimentoResponseDTO getAlimentoResponseDTOById(Integer id);
    void delete(Integer id);
    void update(Integer id, AlimentoRequestDTO alimentoRequestDTO);
    List<AlimentoResponseDTO> getAll();
    Alimento convert(AlimentoRequestDTO dto);
    AlimentoResponseDTO convertToAlimentoResponseDTO(Alimento alimento);
    List<AlimentoResponseDTO> convertToAlimentoResponseDTO(List<Alimento> alimentos);
}
