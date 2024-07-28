package com.personal.sistemaPersonal.service;



import com.personal.sistemaPersonal.entites.AvaliacaoFisica;
import com.personal.sistemaPersonal.rest.dto.request.AvaliacaoFisicaRequestDTO;
import com.personal.sistemaPersonal.rest.dto.response.AvaliacaoFisicaResponseDTO;

import java.util.List;

public interface AvaliacaoFisicaService {
    AvaliacaoFisicaResponseDTO save(AvaliacaoFisicaRequestDTO avalicaoFisica);
    void delete(Integer id);
    AvaliacaoFisicaResponseDTO update(Integer id, AvaliacaoFisicaRequestDTO avaliacaoFisicaRequestDTO);
    List<AvaliacaoFisicaResponseDTO> getAll();
    AvaliacaoFisica getById(Integer id);
    AvaliacaoFisicaResponseDTO getInformacoesAvaliacaoFisicaDTOById(Integer id);
    List<AvaliacaoFisicaResponseDTO> getAvaliacoesFisicasByIdAluno(Integer idAluno);
    AvaliacaoFisica convert(AvaliacaoFisicaRequestDTO dto);
    AvaliacaoFisicaResponseDTO convertToAvaliacaoFisicaResponseDTO(AvaliacaoFisica avaliacaoFisica);
    List<AvaliacaoFisicaResponseDTO> convertToAvaliacaoFisicaResponseDTO(List<AvaliacaoFisica> avaliacoesFisicas);
}
