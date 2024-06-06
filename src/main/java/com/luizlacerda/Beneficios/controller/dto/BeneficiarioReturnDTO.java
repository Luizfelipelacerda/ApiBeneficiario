package com.luizlacerda.Beneficios.controller.dto;

import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
@Builder
public class BeneficiarioReturnDTO {

    private UUID idBeneficiario;
    private String name;
    private int telefone;
    private Date dataNascimento;
    private Date dataInclusao;
    private Date dataAtualizacao;
}
