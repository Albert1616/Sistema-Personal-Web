package com.personal.sistemaPersonal.service;

import com.personal.sistemaPersonal.model.AvaliacaoFisica;
import com.personal.sistemaPersonal.rest.dto.AvaliacaoFisicaDTO;
import com.personal.sistemaPersonal.rest.dto.InformacoesAvaliacaoFisicaDTO;

import java.util.List;

public interface AvaliacaoFisicaService {
    InformacoesAvaliacaoFisicaDTO save(AvaliacaoFisicaDTO avalicaoFisica);
    void delete(Integer id);
    InformacoesAvaliacaoFisicaDTO update(Integer id, AvaliacaoFisicaDTO avaliacaoFisicaDTO);
    List<InformacoesAvaliacaoFisicaDTO> getAll();
    AvaliacaoFisica getById(Integer id);
    InformacoesAvaliacaoFisicaDTO getInformacoesAvaliacaoFisicaDTOById(Integer id);
    List<InformacoesAvaliacaoFisicaDTO> getAvaliacoesFisicasByIdAluno(Integer idAluno);
    AvaliacaoFisica convert(AvaliacaoFisicaDTO dto);
    InformacoesAvaliacaoFisicaDTO convertToInformacoesAvaliacaoFisicaDTO(AvaliacaoFisica avaliacaoFisica);
    List<InformacoesAvaliacaoFisicaDTO> convertToInformacoesAvaliacaoFisicaDTO(List<AvaliacaoFisica> avaliacoesFisicas);
}
