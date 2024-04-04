package com.personal.sistemaPersonal.repository;

import com.personal.sistemaPersonal.model.FichaTreino;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FichaTreinoRepository extends JpaRepository<FichaTreino, Integer> {
}
