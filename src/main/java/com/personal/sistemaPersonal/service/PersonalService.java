package com.personal.sistemaPersonal.service;

import com.personal.sistemaPersonal.model.Personal;
import com.personal.sistemaPersonal.rest.dto.response.PersonalResponseDTO;
import com.personal.sistemaPersonal.rest.dto.request.PersonalRequestDTO;

import java.util.List;

public interface PersonalService {
    public PersonalResponseDTO save(PersonalRequestDTO personal);
    public Personal getById(Integer id);
    public PersonalResponseDTO getInformacoesPersonalDTOById(Integer id);
    public void delete(Integer id);
    public void update(Integer id, PersonalRequestDTO personalRequestDTO);
    public List<PersonalResponseDTO> getAll();
    public PersonalResponseDTO convertToPersonalResponseDTO(Personal personal);
    public List<PersonalResponseDTO> convertToPersonalResponseDTO(List<Personal> personais);
}
