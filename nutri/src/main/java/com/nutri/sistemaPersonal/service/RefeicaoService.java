package com.nutri.sistemaPersonal.service;



import com.nutri.sistemaPersonal.entites.Refeicao;
import com.nutri.sistemaPersonal.rest.dto.request.RefeicaoRequestDTO;
import com.nutri.sistemaPersonal.rest.dto.response.RefeicaoResponseDTO;

import java.util.List;

public interface RefeicaoService {
    RefeicaoResponseDTO save(RefeicaoRequestDTO refeicao);
    Refeicao getById(Integer id);
    RefeicaoResponseDTO getRefeicaoResponseDTOById(Integer id);
    void delete(Integer id);
    void update(Integer id, RefeicaoRequestDTO refeicaoRequestDTO);
    List<RefeicaoResponseDTO> getAll();
    Refeicao convert(RefeicaoRequestDTO dto);
    RefeicaoResponseDTO convertToRefeicaoResponseDTO(Refeicao refeicao);
    List<RefeicaoResponseDTO> convertToRefeicaoResponseDTO(List<Refeicao> refeicoes);
}
