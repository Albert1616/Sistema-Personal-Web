package com.personal.sistemaPersonal.service;

import com.personal.sistemaPersonal.model.Aluno;
import com.personal.sistemaPersonal.rest.dto.request.AlunoRequestDTO;
import com.personal.sistemaPersonal.rest.dto.response.AlunoCompletoResponseDTO;
import com.personal.sistemaPersonal.rest.dto.response.AlunoResponseDTO;

import java.util.List;

public interface AlunoService {
    AlunoResponseDTO save(AlunoRequestDTO alunoRequestDTO);
    void delete(Integer id);
    void update(Integer id, AlunoRequestDTO alunoRequestDTO);
    List<AlunoResponseDTO> getAll();
    Aluno getById(Integer id);
    AlunoResponseDTO getAlunoInformacoesDTOById(Integer id);
    Aluno convert(AlunoRequestDTO alunoRequestDTO);
    AlunoResponseDTO convertToAlunoResponseDTO(Aluno aluno);
    AlunoCompletoResponseDTO convertToAlunoCompletoResponseDTO(Aluno aluno);
    List<AlunoResponseDTO> convertToAlunoResponseDTO(List<Aluno> alunos);
    AlunoCompletoResponseDTO getAllInformartionsById(Integer id);
    void vinculate(Integer id, String login);
}
