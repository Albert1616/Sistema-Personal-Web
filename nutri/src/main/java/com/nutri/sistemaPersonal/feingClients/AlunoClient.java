package com.nutri.sistemaPersonal.feingClients;

import com.nutri.sistemaPersonal.entites.Aluno;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(name = "aluno", path = "/api/aluno")
public interface AlunoClient {
    @GetMapping(value = "get/{id}")
    public Aluno getAlunoById(@PathVariable Integer id);

}
