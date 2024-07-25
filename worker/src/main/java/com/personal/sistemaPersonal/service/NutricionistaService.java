package com.personal.sistemaPersonal.service;

import com.personal.sistemaPersonal.model.Nutricionista;
import com.personal.sistemaPersonal.rest.dto.request.NutricionistaRequestDTO;
import com.personal.sistemaPersonal.rest.dto.response.NutricionistaResponseDTO;

import java.util.List;

public interface NutricionistaService {
    NutricionistaResponseDTO save(NutricionistaRequestDTO nutricionista);
    Nutricionista getById(Integer id);
    NutricionistaResponseDTO getNutricionistaResponseDTOById(Integer id);
    void delete(Integer id);
    void update(Integer id, NutricionistaRequestDTO nutricionistaRequestDTO);
    List<NutricionistaResponseDTO> getAll();
    Nutricionista convert(NutricionistaRequestDTO dto);
    NutricionistaResponseDTO convertToNutricionistaResponseDTO(Nutricionista nutricionista);
    List<NutricionistaResponseDTO> convertToNutricionistaResponseDTO(List<Nutricionista> nutricionistas);
}
