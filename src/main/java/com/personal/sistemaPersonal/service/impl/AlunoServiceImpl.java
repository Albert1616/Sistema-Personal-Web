package com.personal.sistemaPersonal.service.impl;

import com.personal.sistemaPersonal.exception.AlunoNaoEncontradoException;
import com.personal.sistemaPersonal.model.Aluno;
import com.personal.sistemaPersonal.model.Personal;
import com.personal.sistemaPersonal.rest.dto.AlunoDTO;
import com.personal.sistemaPersonal.rest.dto.InformacoesAlunoDTO;
import com.personal.sistemaPersonal.service.AlunoService;
import com.personal.sistemaPersonal.service.PersonalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.personal.sistemaPersonal.repository.AlunoRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.swing.text.html.Option;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AlunoServiceImpl implements AlunoService {
    @Autowired
    AlunoRepository alunoRepository;

    @Autowired
    PersonalService personalService;

    @Override
    public InformacoesAlunoDTO save(AlunoDTO dto) {
        Aluno aluno = convert(dto);
        return convertToInformacoesAlunoDTO(alunoRepository.save(aluno));
    }

    @Override
    public void delete(Integer id) {
        alunoRepository.delete(getById(id));
    }

    @Override
    public void update(Integer id, AlunoDTO alunoDTO) {
        Aluno alunoAtualizado = convert(alunoDTO);
        Aluno aluno = getById(id);

        aluno.setNome(alunoAtualizado.getNome());
        aluno.setEmail(alunoAtualizado.getEmail());
        aluno.setData_nascimento(alunoAtualizado.getData_nascimento());
        aluno.setPersonal(alunoAtualizado.getPersonal());

        alunoRepository.save(aluno);
    }

    @Override
    public List<InformacoesAlunoDTO> getAll() {
        return convertToInformacoesAlunoDTO(alunoRepository.findAll());
    }

    @Override
    public Aluno getById(Integer id) {
        Optional<Aluno> aluno = alunoRepository.findById(id);
        if (aluno.isPresent()){
            return aluno.get();
        }
        else throw new AlunoNaoEncontradoException();
    }

    @Override
    public InformacoesAlunoDTO getAlunoInformacoesDTOById(Integer id) {
        return convertToInformacoesAlunoDTO(getById(id));
    }

    @Override
    public Aluno convert(AlunoDTO dto){
        Aluno aluno = new Aluno();

        aluno.setNome(dto.getNome());
        aluno.setEmail(dto.getEmail());
        aluno.setData_nascimento(dto.getData_nascimento());
        Personal personal = personalService.getById(dto.getPersonal());
        aluno.setPersonal(personal);

        return aluno;
    }

    @Override
    public InformacoesAlunoDTO convertToInformacoesAlunoDTO(Aluno aluno) {
        return InformacoesAlunoDTO
                .builder()
                .id(aluno.getId())
                .nome(aluno.getNome())
                .email(aluno.getEmail())
                .data_nascimento(aluno.getData_nascimento())
                .personal(personalService.convertToInformacoesPersonalDTO(aluno.getPersonal()))
                .build();
    }

    @Override
    public List<InformacoesAlunoDTO> convertToInformacoesAlunoDTO(List<Aluno> alunos) {
        if (CollectionUtils.isEmpty(alunos)){
            return Collections.emptyList();
        }
        return alunos.stream().map(
         aluno ->   InformacoesAlunoDTO
                    .builder()
                    .id(aluno.getId())
                    .nome(aluno.getNome())
                    .email(aluno.getEmail())
                    .data_nascimento(aluno.getData_nascimento())
                    .personal(personalService.convertToInformacoesPersonalDTO(aluno.getPersonal()))
                    .build()
        ).collect(Collectors.toList());
    }
}
