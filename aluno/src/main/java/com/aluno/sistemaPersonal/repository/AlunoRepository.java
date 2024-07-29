package com.aluno.sistemaPersonal.repository;

import com.personal.sistemaPersonal.entites.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Integer>{
}