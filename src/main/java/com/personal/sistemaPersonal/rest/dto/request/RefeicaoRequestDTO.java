package com.personal.sistemaPersonal.rest.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RefeicaoRequestDTO {

    @NotBlank(message = "Campo não informado.")
    private String descricao;

    @Positive(message = "O valor deve ser um número positivo.")
    private Integer dieta;
}
