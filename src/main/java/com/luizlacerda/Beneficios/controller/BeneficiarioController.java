package com.luizlacerda.Beneficios.controller;

import com.luizlacerda.Beneficios.controller.dto.BeneficiarioReturnDTO;
import com.luizlacerda.Beneficios.controller.dto.CreateBeneficiarioDto;
import com.luizlacerda.Beneficios.controller.dto.UpdateBeneficiarioDto;
import com.luizlacerda.Beneficios.service.BeneficiarioService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/Beneficiario")
public class BeneficiarioController {

    private final BeneficiarioService beneficiarioService;

    @GetMapping()
    @Operation(summary = "Listar", description = "Lista todos os beneficiarios", tags = "Beneficiario")
    public ResponseEntity<List<BeneficiarioReturnDTO>> getAllBeneficiarios(){
        List<BeneficiarioReturnDTO> listbeneficiarios = this.beneficiarioService.getAllbeneficiarios();
        return ResponseEntity.ok(listbeneficiarios);
    }

    @PutMapping()
    @Operation(summary = "Update", description = "update um beneficiario", tags = "Beneficiario")
    public ResponseEntity<BeneficiarioReturnDTO> updateBeneficio(@RequestBody UpdateBeneficiarioDto updateBeneficiarioDto){

        BeneficiarioReturnDTO beneficiarioUpdate = this.beneficiarioService.updateBeneficiario(updateBeneficiarioDto);

        return ResponseEntity.ok(beneficiarioUpdate);
    }

    @PostMapping()
    @Operation(summary = "Create", description = "cria um novo beneficiario", tags = "Beneficiario")
    public ResponseEntity<Void> createNewBeneficiaro(@RequestBody CreateBeneficiarioDto beneficiarioDto){

        this.beneficiarioService.createNewbeneficiario(beneficiarioDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{idBeneficiario}")
    @Operation(summary = "Delete", description = "deleta um beneficiario", tags = "Beneficiario")
    public ResponseEntity deleteBeneficiario(@RequestParam UUID idBeneficiario){
        this.beneficiarioService.deleteBeneficiarioById(idBeneficiario);

        return ResponseEntity.ok().build();
    }

}
