package com.aluno.sistemaPersonal.feingClients;


import com.personal.sistemaPersonal.rest.dto.response.AvaliacaoFisicaResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Component
@FeignClient(name = "personal", path = "/api/personal/treino")
public interface AvaliacaoClient {
    @GetMapping("/getAvaliacaoFisicaByIdAluno/{id}")
    public List<AvaliacaoFisicaResponseDTO> getAllByIdAluno(@PathVariable Integer id);
}
