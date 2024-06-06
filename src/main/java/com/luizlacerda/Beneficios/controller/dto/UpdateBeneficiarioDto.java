package com.luizlacerda.Beneficios.controller.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
public class UpdateBeneficiarioDto {


    private UUID idBeneficiario;
    private String name;
    private int telefone;

    private Date dataNascimento;


}
