package com.luizlacerda.Beneficios.service;

import com.luizlacerda.Beneficios.controller.dto.CreateBeneficiarioDto;
import com.luizlacerda.Beneficios.entities.Beneficiario;
import com.luizlacerda.Beneficios.repository.BeneficiarioRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ActiveProfiles;

import java.time.Instant;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;


@ActiveProfiles("test")
@ExtendWith(MockitoExtension.class)
class BeneficiarioServiceImplTest {

    @Mock
    private BeneficiarioRepository beneficiarioRepository;
    private BeneficiarioServiceImpl beneficiarioServiceImpl;
    private DocumentoServiceImpl documentoService;

    @BeforeEach
    void setUp() {
        beneficiarioServiceImpl = new BeneficiarioServiceImpl(beneficiarioRepository, documentoService);
    }

    @Test
    void createNewbeneficiario() {

        //given
        Date now = Date.from(Instant.now());
        CreateBeneficiarioDto beneficiario = CreateBeneficiarioDto.builder()
                .name("luiz felipe")
                .telefone(99999)
                .dataNascimento(now)
                .build();

        //when
        beneficiarioServiceImpl.createNewbeneficiario(beneficiario);

        //then
        ArgumentCaptor<Beneficiario> beneficiarioArgumentCaptor =
                ArgumentCaptor.forClass(Beneficiario.class);

        verify(beneficiarioRepository)
                .save(beneficiarioArgumentCaptor.capture());

        Beneficiario capturedBeneficiario = beneficiarioArgumentCaptor.getValue();
        assertEquals(capturedBeneficiario.getName(),beneficiario.getName());
        assertEquals(capturedBeneficiario.getName(),beneficiario.getName());

    }

    @Test
    void CanGetAllbeneficiarios() {
        //When
        beneficiarioServiceImpl.getAllbeneficiarios();
        //then
        verify(beneficiarioRepository).findAll();
    }

    @Test
    @Disabled
    void deleteBeneficiarioById() {
    }

    @Test
    @Disabled
    void updateBeneficiario() {
    }
}