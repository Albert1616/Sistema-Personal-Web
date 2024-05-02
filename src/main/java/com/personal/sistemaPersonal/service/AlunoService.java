package com.personal.sistemaPersonal.service;

import com.personal.sistemaPersonal.model.Aluno;
import com.personal.sistemaPersonal.rest.dto.request.AlunoRequestDTO;
import com.personal.sistemaPersonal.rest.dto.response.AlunoResponseDTO;

import java.util.List;

public interface AlunoService {
    public AlunoResponseDTO save(AlunoRequestDTO alunoRequestDTO);
    public void delete(Integer id);
    public void update(Integer id, AlunoRequestDTO alunoRequestDTO);
    public List<AlunoResponseDTO> getAll();
    public Aluno getById(Integer id);
    public AlunoResponseDTO getAlunoInformacoesDTOById(Integer id);
    public Aluno convert(AlunoRequestDTO alunoRequestDTO);
    public AlunoResponseDTO convertToAlunoResponseDTO(Aluno aluno);
    public List<AlunoResponseDTO> convertToAlunoResponseDTO(List<Aluno> alunos);
}
