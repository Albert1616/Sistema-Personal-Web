package com.personal.sistemaPersonal.rest.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class RefeicaoResponseDTO {
    private Integer id;
    private String descricao;
    private List<AlimentoResponseDTO> alimentos;
}
