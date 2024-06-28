package com.luizlacerda.Beneficios.service;

import com.luizlacerda.Beneficios.controller.dto.BeneficiarioReturnDTO;
import com.luizlacerda.Beneficios.controller.dto.CreateBeneficiarioDto;
import com.luizlacerda.Beneficios.controller.dto.UpdateBeneficiarioDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface BeneficiarioService {

    void createNewbeneficiario(CreateBeneficiarioDto beneficiarioDto);

    List<BeneficiarioReturnDTO> getAllbeneficiarios();

    void deleteBeneficiarioById(UUID idBeneficiario);

    BeneficiarioReturnDTO updateBeneficiario(UpdateBeneficiarioDto updateBeneficiarioDto);
}
