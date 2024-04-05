package com.personal.sistemaPersonal.service;

import com.personal.sistemaPersonal.model.Aluno;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AlunoService {
    public boolean save(Aluno aluno);
    public boolean delete(Aluno aluno);
    public boolean update(Integer id);
    public List<Aluno> getAll();
    public Aluno getAlunoById(Integer id);
}
