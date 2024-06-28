package com.luizlacerda.Beneficios.repository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
@ActiveProfiles("test")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class DocumentoRepositoryTest {

    @Autowired
    @Mock
    private DocumentoRepository documentoRepository;

    @AfterEach
    void tearDown() {

    }

    @Test
    void findAllByBeneficiarioId() {


    }
}