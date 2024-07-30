package com.aluno.sistemaPersonal.feingClients;

import com.auth.sistemaPersonal.entites.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(name = "auth", path = "/auth/api/user")
public interface UserClient {
    @GetMapping("/{login}")
    public User getByLogin(@PathVariable String login);
}
