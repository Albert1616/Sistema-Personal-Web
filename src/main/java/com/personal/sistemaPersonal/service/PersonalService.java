package com.personal.sistemaPersonal.service;

import com.personal.sistemaPersonal.model.Personal;
import com.personal.sistemaPersonal.rest.dto.InformacoesPersonalDTO;
import com.personal.sistemaPersonal.rest.dto.PersonalDTO;

import java.util.List;

public interface PersonalService {
    public InformacoesPersonalDTO save(PersonalDTO personal);
    public Personal getById(Integer id);
    public InformacoesPersonalDTO getInformacoesPersonalDTOById(Integer id);
    public void delete(Integer id);
    public void update(Integer id, PersonalDTO personalDTO);
    public List<InformacoesPersonalDTO> getAll();
    public InformacoesPersonalDTO convertToInformacoesPersonalDTO(Personal personal);
    public List<InformacoesPersonalDTO> convertToInformacoesPersonalDTO(List<Personal> personais);
}
