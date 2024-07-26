package com.nutri.sistemaPersonal.repository;


import com.nutri.sistemaPersonal.entites.Alimento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlimentoRepository extends JpaRepository<Alimento, Integer> {
}
