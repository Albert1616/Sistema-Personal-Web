package com.personal.sistemaPersonal.repository;

import com.personal.sistemaPersonal.model.Treino;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TreinoRepository extends JpaRepository<Treino, Integer> {

    @Query(value = "select treino.* from treino inner join aluno on treino.ficha_treino_id = aluno.ficha_treino_id where aluno.id = ?1", nativeQuery = true)
    public List<Treino> findByAlunoId(Integer id);
}
