package com.personal.sistemaPersonal.repository;

import com.personal.sistemaPersonal.model.Personal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonalRepository extends JpaRepository<Personal, Integer> {
}
