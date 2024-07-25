package com.personal.sistemaPersonal.rest.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class AlimentoResponseDTO {
    private Integer id;
    private String descricao;
    private String medida;
}
