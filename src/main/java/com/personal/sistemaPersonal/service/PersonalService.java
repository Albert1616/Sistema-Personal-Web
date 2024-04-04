package com.personal.sistemaPersonal.service;

import com.personal.sistemaPersonal.model.Personal;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PersonalService {
    public boolean save(Personal personal);
    public boolean delete(Personal personal);
    public boolean update(Integer id);
    public List<Personal> getAll();
}
