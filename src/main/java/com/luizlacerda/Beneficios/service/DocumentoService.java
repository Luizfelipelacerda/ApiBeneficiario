package com.luizlacerda.Beneficios.service;

import com.luizlacerda.Beneficios.controller.dto.DocumentoDTO;
import com.luizlacerda.Beneficios.controller.dto.DocumentoReturnDTO;
import com.luizlacerda.Beneficios.entities.Documento;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface DocumentoService {

    void createDocumentoS(UUID idBeneficiario, List<DocumentoDTO> listDocumentoDTO);

    List<DocumentoReturnDTO> getAllByBeneficiarioId(UUID idBeneficiario);

    List<Documento> getAllDocumentos();
}
