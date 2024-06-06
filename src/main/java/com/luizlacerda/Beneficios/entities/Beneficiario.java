package com.luizlacerda.Beneficios.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "beneficiarios")
@Data
public class Beneficiario {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID idBeneficiario;

    private String name;
    private int telefone;

    private Date dataNascimento;
    private Date dataInclusao;
    private Date dataAtualizacao;
}
