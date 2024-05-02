package com.personal.sistemaPersonal.service;

import com.personal.sistemaPersonal.model.Treino;
import com.personal.sistemaPersonal.rest.dto.InformacoesTreinoDTO;
import com.personal.sistemaPersonal.rest.dto.TreinoDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TreinoService {
    InformacoesTreinoDTO save(TreinoDTO treino);
    void delete(Integer id);
    InformacoesTreinoDTO update(Integer id, TreinoDTO dto);
    List<InformacoesTreinoDTO> getAll();
    Treino getById(Integer id);
    InformacoesTreinoDTO getInformacoesTreinoDTO(Integer id);
    List<InformacoesTreinoDTO> getByIdAluno(Integer idAluno);
}
