package com.aluno.sistemaPersonal.feingClients;

import com.aluno.sistemaPersonal.entites.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(name = "auth")//, path = "http://localhost:8080/auth/api/user")
public interface UserClient {
    @GetMapping("/{login}")
    public User getByLogin(@PathVariable String login);
}
