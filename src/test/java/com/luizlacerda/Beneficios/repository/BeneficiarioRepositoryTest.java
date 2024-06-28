package com.luizlacerda.Beneficios.repository;

import com.luizlacerda.Beneficios.entities.Beneficiario;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.Instant;
import java.util.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@ActiveProfiles("test")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class BeneficiarioRepositoryTest {

    @Autowired
    private BeneficiarioRepository testRepository;

    @AfterAll
    void tearDown(){
        testRepository.deleteAll();
    }

    @Test
    void itShouldfindByName() {
        //given
        Beneficiario beneficiario = new Beneficiario();
        String name = "luiz felipe";
        Date now = Date.from(Instant.now());
        beneficiario.setName(name);
        beneficiario.setTelefone(999999);
        beneficiario.setDataNascimento(now);
        beneficiario.setDataAtualizacao(now);
        beneficiario.setDataInclusao(now);

        this.testRepository.save(beneficiario);
        //when
        Optional<Beneficiario> byName = this.testRepository.findByName(name);
        //then
        assertTrue(byName.isPresent());
        assertEquals(name,byName.get().getName());
    }
}