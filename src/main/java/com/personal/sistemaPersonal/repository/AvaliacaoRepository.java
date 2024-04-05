package com.personal.sistemaPersonal.repository;

import com.personal.sistemaPersonal.model.AvalicaoFisica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AvaliacaoRepository extends JpaRepository<AvalicaoFisica, Integer> {

    @Query(value = " select a.* from avaliacao_fisica a where a.aluno_id = ?1", nativeQuery = true)
    List<AvalicaoFisica> findAllAvaliacaoFisicaByIdAluno(Integer idAluno);
}
