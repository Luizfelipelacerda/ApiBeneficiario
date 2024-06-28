package com.luizlacerda.Beneficios.controller.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Builder
public class CreateBeneficiarioDto {

    private String name;
    private int telefone;

    private Date dataNascimento;

    private List<DocumentoDTO> documento;

}
