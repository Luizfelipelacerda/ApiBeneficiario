package com.luizlacerda.Beneficios.controller;

import com.luizlacerda.Beneficios.controller.dto.DocumentoReturnDTO;
import com.luizlacerda.Beneficios.entities.Documento;
import com.luizlacerda.Beneficios.service.DocumentoService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/Documento")
public class DocumentoController {

    private final DocumentoService documentoService;

    @PostMapping("/{idBeneficiario}")
    @Operation(summary = "Find", description = "Busca uma lista de Documentos apartir do id do Beneficiario", tags = "Documento")
    public ResponseEntity<List<DocumentoReturnDTO>> findAllDocumentosByBeneficiarioId(@RequestParam UUID idBeneficiario){
        List<DocumentoReturnDTO> ListaDocumentosDTO = this.documentoService.getAllByBeneficiarioId(idBeneficiario);

        return ResponseEntity.ok(ListaDocumentosDTO);
    }

    @GetMapping("/")
        @Operation(summary = "Listar", description = "Lista todos os documentos no banco.", tags = "Documento")
    public ResponseEntity<List<Documento>> getAllDocumentos(){
        List<Documento> doc = this.documentoService.getAllDocumentos();
        return ResponseEntity.ok(doc);
    }
}
