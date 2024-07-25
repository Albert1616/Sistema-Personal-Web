package com.personal.sistemaPersonal.service;

import com.personal.sistemaPersonal.model.Personal;
import com.personal.sistemaPersonal.rest.dto.response.PersonalResponseDTO;
import com.personal.sistemaPersonal.rest.dto.request.PersonalRequestDTO;

import java.util.List;

public interface PersonalService {
    PersonalResponseDTO save(PersonalRequestDTO personal);
    Personal getById(Integer id);
    PersonalResponseDTO getInformacoesPersonalDTOById(Integer id);
    void delete(Integer id);
    void update(Integer id, PersonalRequestDTO personalRequestDTO);
    List<PersonalResponseDTO> getAll();
    PersonalResponseDTO convertToPersonalResponseDTO(Personal personal);
    List<PersonalResponseDTO> convertToPersonalResponseDTO(List<Personal> personais);
}
