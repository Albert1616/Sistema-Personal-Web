package com.personal.sistemaPersonal.service;

import com.personal.sistemaPersonal.model.Aluno;
import com.personal.sistemaPersonal.model.AvalicaoFisica;
import com.personal.sistemaPersonal.rest.dto.AlunoDTO;
import com.personal.sistemaPersonal.rest.dto.InformacoesAlunoDTO;
import org.springframework.stereotype.Service;

import java.util.List;

public interface AlunoService {
    public InformacoesAlunoDTO save(AlunoDTO alunoDTO);
    public void delete(Integer id);
    public void update(Integer id, AlunoDTO alunoDTO);
    public List<InformacoesAlunoDTO> getAll();
    public Aluno getById(Integer id);
    public InformacoesAlunoDTO getAlunoInformacoesDTOById(Integer id);
    public Aluno convert(AlunoDTO alunoDTO);
    public InformacoesAlunoDTO convertToInformacoesAlunoDTO(Aluno aluno);
    public List<InformacoesAlunoDTO> convertToInformacoesAlunoDTO(List<Aluno> alunos);
}
