package com.user.sistemaPersonal.repository;

import com.user.sistemaPersonal.entites.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByLogin(String login);
}
