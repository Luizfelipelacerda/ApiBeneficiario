package com.luizlacerda.Beneficios.entities;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "documentos")
@Data
public class Documento {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID idDocumento;

    private UUID beneficiarioId;

    private String descricao;

    private String tipoDocumento;

    private Date dataInclusao;
    private Date dataAtualizacao;
}
