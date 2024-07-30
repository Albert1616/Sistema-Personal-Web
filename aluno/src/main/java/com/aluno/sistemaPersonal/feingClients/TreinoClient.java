package com.aluno.sistemaPersonal.feingClients;

import com.personal.sistemaPersonal.rest.dto.response.TreinoResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Component
@FeignClient(name = "personal", path = "/api/personal/treino")
public interface TreinoClient {
    @GetMapping("/getTreinoByIdAluno/{id}")
    public List<TreinoResponseDTO> getAllByIdAluno(@PathVariable Integer id);
}
