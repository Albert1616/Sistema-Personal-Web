package com.personal.sistemaPersonal.repository;

import com.personal.sistemaPersonal.model.Alimento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlimentoRepository extends JpaRepository<Alimento, Integer> {
}
