package com.aluno.sistemaPersonal.feingClients;

import com.aluno.sistemaPersonal.entites.Nutricionista;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(name = "nutri", path = "/api/nutricionista")
public interface NutriClient {
    @GetMapping("/complete/{id}")
    public Nutricionista getById(@PathVariable Integer id);
}
