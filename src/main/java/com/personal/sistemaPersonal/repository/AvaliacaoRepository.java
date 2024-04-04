package com.personal.sistemaPersonal.repository;

import com.personal.sistemaPersonal.model.Avalicao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AvaliacaoRepository extends JpaRepository<Avalicao, Integer> {
}
