package com.personal.sistemaPersonal.service;

import com.personal.sistemaPersonal.model.Dieta;
import com.personal.sistemaPersonal.rest.dto.request.DietaRequestDTO;
import com.personal.sistemaPersonal.rest.dto.response.DietaResponseDTO;

import java.util.List;

public interface DietaService {
    DietaResponseDTO save(DietaRequestDTO dieta);
    Dieta getById(Integer id);
    DietaResponseDTO getDietaResponseDTOById(Integer id);
    void delete(Integer id);
    void update(Integer id, DietaRequestDTO dietaRequestDTO);
    List<DietaResponseDTO> getAll();
    Dieta convert(DietaRequestDTO dto);
    DietaResponseDTO convertToDietaResponseDTO(Dieta dieta);
    List<DietaResponseDTO> convertToDietaResponseDTO(List<Dieta> dietas);
}
