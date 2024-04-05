package com.personal.sistemaPersonal.repository;

import com.personal.sistemaPersonal.model.Aluno;
import com.personal.sistemaPersonal.model.AvalicaoFisica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Integer>{
}
