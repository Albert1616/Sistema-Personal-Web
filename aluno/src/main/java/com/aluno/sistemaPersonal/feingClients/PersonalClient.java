package com.aluno.sistemaPersonal.feingClients;

import com.aluno.sistemaPersonal.entites.Personal;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(name = "personal", path = "/api/personal")
public interface PersonalClient {
    @GetMapping("/complete/{id}")
    public Personal getPersonalById(@PathVariable Integer id);
}
