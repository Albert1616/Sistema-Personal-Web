package com.aluno.sistemaPersonal.service.impl;

import com.aluno.sistemaPersonal.entites.Aluno;
import com.aluno.sistemaPersonal.exception.AlunoNaoEncontradoException;
import com.aluno.sistemaPersonal.feingClients.*;
import com.aluno.sistemaPersonal.repository.AlunoRepository;
import com.aluno.sistemaPersonal.rest.dto.request.AlunoRequestDTO;
import com.aluno.sistemaPersonal.rest.dto.response.AlunoCompletoResponseDTO;
import com.aluno.sistemaPersonal.rest.dto.response.AlunoResponseDTO;
import com.aluno.sistemaPersonal.service.AlunoService;
import com.auth.sistemaPersonal.entites.User;
import com.auth.sistemaPersonal.enumerate.UserTypes;
import com.auth.sistemaPersonal.exception.UsuarioNaoEncontrado;
import com.aluno.sistemaPersonal.entites.Nutricionista;
import com.aluno.sistemaPersonal.entites.FichaTreino;
import com.aluno.sistemaPersonal.entites.Personal;
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
    PersonalClient personalClient;

    @Autowired
    NutriClient nutriClient;

    @Autowired
    UserClient userClient;

    @Autowired
    TreinoClient treinoClient;

    @Autowired
    AvaliacaoClient avaliacaoClient;

    @Override
    public AlunoResponseDTO save(AlunoRequestDTO dto) {
        Aluno aluno = convert(dto);

        FichaTreino fichaTreino = new FichaTreino();
        fichaTreino.setTitulo("Ficha de Treino");
        fichaTreino.setAluno(aluno.getId());

        aluno.setFicha_treino(fichaTreino.getId());
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

    @Override
    public AlunoCompletoResponseDTO getAllInformartionsById(Integer id){
        Optional<Aluno> aluno = alunoRepository.findById(id);
        if (aluno.isPresent()){
            return convertToAlunoCompletoResponseDTO(aluno.get());
        }else throw new AlunoNaoEncontradoException();
    }

    public void vinculate(Integer id, String login){
        User user = userClient.getByLogin(login);
        Aluno aluno = getById(id);

        if(user.getPaper() == UserTypes.NUTRICIONISTA){
            Nutricionista nutricionista = nutriClient.getById(user.getId());
            aluno.setNutricionista(nutricionista.getId());
            alunoRepository.save(aluno);
            return;
        }

        if(user.getPaper() == UserTypes.PERSONAL){
            Personal personal = personalClient.getPersonalById(id);
            aluno.setPersonal(personal.getId());
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
    public AlunoCompletoResponseDTO convertToAlunoCompletoResponseDTO(Aluno aluno) {
        if(Objects.isNull(aluno)) return null;
        return AlunoCompletoResponseDTO
                .builder()
                .id(aluno.getId())
                .login(aluno.getLogin())
                .nome(aluno.getNome())
                .email(aluno.getEmail())
                .dataNascimento(aluno.getData_nascimento())
                .personal(aluno.getPersonal())
                .nuticionista(aluno.getNutricionista())
                .treinos(treinoClient.getAllByIdAluno(aluno.getId()))
                .avaliacoes(avaliacaoClient.getAllByIdAluno(aluno.getId()))
                .build();
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
                .personal(aluno.getPersonal())
                .nutricionista(aluno.getNutricionista())
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
