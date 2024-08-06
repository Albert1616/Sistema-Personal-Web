package com.personal.sistemaPersonal.service;


import com.personal.sistemaPersonal.entites.FichaTreino;
import com.personal.sistemaPersonal.rest.dto.request.FichaTreinoRequestDTO;

import java.util.List;

public interface FichaTreinoService {
    public Integer save(FichaTreinoRequestDTO ficha);
    public FichaTreino getById(Integer id);
    public List<FichaTreino> getAll();
    public FichaTreino convert(FichaTreinoRequestDTO dto);
}
