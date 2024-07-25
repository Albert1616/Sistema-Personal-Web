package com.personal.sistemaPersonal.service;

import com.personal.sistemaPersonal.model.Treino;
import com.personal.sistemaPersonal.rest.dto.response.TreinoResponseDTO;
import com.personal.sistemaPersonal.rest.dto.request.TreinoRequestDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TreinoService {
    TreinoResponseDTO save(TreinoRequestDTO treino);
    void delete(Integer id);
    TreinoResponseDTO update(Integer id, TreinoRequestDTO dto);
    List<TreinoResponseDTO> getAll();
    Treino getById(Integer id);
    TreinoResponseDTO getInformacoesTreinoDTO(Integer id);
    List<TreinoResponseDTO> getByIdAluno(Integer idAluno);
}
