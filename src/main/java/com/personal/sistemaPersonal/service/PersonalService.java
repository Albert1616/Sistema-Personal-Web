package com.personal.sistemaPersonal.service;

import com.personal.sistemaPersonal.model.Personal;
import com.personal.sistemaPersonal.rest.dto.PersonalDTO;

import java.util.List;

public interface PersonalService {
    public Personal save(PersonalDTO personal);
    public Personal getById(Integer id);
    public void delete(Integer id);
    public void update(Integer id, PersonalDTO personalDTO);
    public List<Personal> getAll();
}
