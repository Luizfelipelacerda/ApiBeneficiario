package com.luizlacerda.Beneficios.controller.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
@Builder
public class DocumentoReturnDTO {
    private UUID idDocumento;

    private UUID BeneficiarioId;

    private String descricao;

    private String tipoDocumento;

    private Date dataInclusao;
    private Date dataAtualizacao;
}
