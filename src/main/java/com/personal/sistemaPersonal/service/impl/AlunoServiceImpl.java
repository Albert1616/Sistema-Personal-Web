package com.personal.sistemaPersonal.service.impl;

import com.personal.sistemaPersonal.enumerate.UserTypes;
import com.personal.sistemaPersonal.exception.AlunoNaoEncontradoException;
import com.personal.sistemaPersonal.exception.UsuarioNaoEncontrado;
import com.personal.sistemaPersonal.model.*;
import com.personal.sistemaPersonal.repository.AlunoRepository;
import com.personal.sistemaPersonal.rest.dto.request.AlunoRequestDTO;
import com.personal.sistemaPersonal.rest.dto.response.AlunoResponseDTO;
import com.personal.sistemaPersonal.service.AlunoService;
import com.personal.sistemaPersonal.service.FichaTreinoService;
import com.personal.sistemaPersonal.service.PersonalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AlunoServiceImpl implements AlunoService {
    @Autowired
    AlunoRepository alunoRepository;

    @Autowired
    PersonalService personalService;

    @Autowired
    NutricionistaServiceImpl nutricionistaService;

    @Autowired
    UserService userService;

    @Autowired
    FichaTreinoService fichaTreinoService;

    @Override
    public AlunoResponseDTO save(AlunoRequestDTO dto) {
        Aluno aluno = convert(dto);

        FichaTreino fichaTreino = new FichaTreino();
        fichaTreino.setTitulo("Ficha de Treino");
        fichaTreino.setAluno(aluno);

        aluno.setFicha_treino(fichaTreino);
        return convertToAlunoResponseDTO(alunoRepository.save(aluno));
    }

    @Override
    public void delete(Integer id) {
        alunoRepository.delete(getById(id));
    }

    @Override
    public void update(Integer id, AlunoRequestDTO alunoRequestDTO) {
        Aluno alunoAtualizado = convert(alunoRequestDTO);
        Aluno aluno = getById(id);

        aluno.setNome(alunoAtualizado.getNome());
        aluno.setEmail(alunoAtualizado.getEmail());
        aluno.setData_nascimento(alunoAtualizado.getData_nascimento());
        aluno.setPersonal(alunoAtualizado.getPersonal());

        alunoRepository.save(aluno);
    }

    @Override
    public List<AlunoResponseDTO> getAll() {
        return convertToAlunoResponseDTO(alunoRepository.findAll());
    }


    @Override
    public Aluno getById(Integer id) {
        Optional<Aluno> aluno = alunoRepository.findById(id);
        if (aluno.isPresent()){
            return aluno.get();
        }
        else throw new AlunoNaoEncontradoException();
    }

    public void vinculate(Integer id, String login){
        User user = userService.getByLogin(login);
        Aluno aluno = getById(id);

        if(user.getPaper() == UserTypes.NUTRICIONISTA){
            Nutricionista nutricionista = nutricionistaService.getById(user.getId());
            aluno.setNutricionista(nutricionista);
            alunoRepository.save(aluno);
            return;
        }

        if(user.getPaper() == UserTypes.PERSONAL){
            Personal personal = personalService.getById(user.getId());
            aluno.setPersonal(personal);
            alunoRepository.save(aluno);
            return;
        }

        throw new UsuarioNaoEncontrado("Usuário não é nutricionista ou personal");
    }

    @Override
    public AlunoResponseDTO getAlunoInformacoesDTOById(Integer id) {
        return convertToAlunoResponseDTO(getById(id));
    }

    @Override
    public Aluno convert(AlunoRequestDTO dto){
        Aluno aluno = new Aluno();

        aluno.setNome(dto.getNome());
        aluno.setEmail(dto.getEmail());
        aluno.setData_nascimento(dto.getDataNascimento());
        aluno.setLogin(dto.getLogin());
        aluno.setPassword(dto.getPassword());
        aluno.setPaper(dto.getPaper());

        return aluno;
    }

    @Override
    public AlunoResponseDTO convertToAlunoResponseDTO(Aluno aluno) {
        if(Objects.isNull(aluno)) return null;
        return AlunoResponseDTO
                .builder()
                .id(aluno.getId())
                .nome(aluno.getNome())
                .email(aluno.getEmail())
                .dataNascimento(aluno.getData_nascimento())
                .personal(personalService.convertToPersonalResponseDTO(aluno.getPersonal()))
                .nuticionista(nutricionistaService.convertToNutricionistaResponseDTO(aluno.getNutricionista()))
                .build();
    }

    @Override
    public List<AlunoResponseDTO> convertToAlunoResponseDTO(List<Aluno> alunos) {
        if (CollectionUtils.isEmpty(alunos)){
            return Collections.emptyList();
        }
        return alunos.stream().map(
            this::convertToAlunoResponseDTO
        ).collect(Collectors.toList());
    }
}
