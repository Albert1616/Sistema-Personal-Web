package com.personal.sistemaPersonal.repository;

import com.personal.sistemaPersonal.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Integer>{
}