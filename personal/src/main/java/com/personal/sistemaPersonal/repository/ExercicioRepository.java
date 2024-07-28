package com.personal.sistemaPersonal.repository;

import com.personal.sistemaPersonal.entites.Exercicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExercicioRepository extends JpaRepository<Exercicio, Integer> {
}
