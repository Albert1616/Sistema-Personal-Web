package com.nutri.sistemaPersonal.service;

import com.nutri.sistemaPersonal.entites.Nutricionista;
import com.nutri.sistemaPersonal.rest.dto.request.NutricionistaRequestDTO;
import com.nutri.sistemaPersonal.rest.dto.response.NutricionistaResponseDTO;

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
