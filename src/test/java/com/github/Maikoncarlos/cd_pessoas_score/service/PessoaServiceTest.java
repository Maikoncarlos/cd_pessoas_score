package com.github.maikoncarlos.cd_pessoas_score.service;

import com.github.maikoncarlos.cd_pessoas_score.dto.AllPessoaDTO;
import com.github.maikoncarlos.cd_pessoas_score.dto.PessoaDTO;
import com.github.maikoncarlos.cd_pessoas_score.model.Pessoa;
import com.github.maikoncarlos.cd_pessoas_score.repository.PessoaRepository;
import com.github.maikoncarlos.cd_pessoas_score.repository.ScoreRepository;
import lombok.SneakyThrows;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

@SpringBootTest
class PessoaServiceTest {

    @Mock
    PessoaRepository pessoaRepository;

    @Mock
    ScoreRepository scoreRepository;

    @InjectMocks
    PessoaService pessoaService;

    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void tearDown() {
    }

    @SneakyThrows
    @Test
    public void shouldReturnAnObjectAllPessoaDTOFilled() {

        Pessoa pessoa = new Pessoa(3L, "Maikon", "12 99999-5588", 37, "SP", "SP", 1000);
        AllPessoaDTO allPessoaDTO;

        Mockito.when(scoreRepository.findAll()).thenReturn(new ArrayList<>());
        allPessoaDTO = pessoaService.toAllPessoaDTO(pessoa, new ModelMapper());

        Assert.assertTrue(allPessoaDTO != null);

        Assert.assertTrue(allPessoaDTO.getNome().equals("Maikon"));

        Assert.assertTrue(allPessoaDTO.getCidade().equals("SP"));

    }

    @Test
    public void shouldCreateANewPessoa() {

        PessoaDTO pessoaDTO = new PessoaDTO();
        pessoaDTO.setNome("Maikon");
        pessoaDTO.setIdade(32);
        pessoaDTO.setCidade("");

        Pessoa pessoa = new Pessoa();
        pessoa.setId(10L);
        pessoa.setNome("Maikon");
        pessoa.setIdade(32);
        pessoa.setCidade("");

        Mockito.when(pessoaRepository.save(Mockito.any(Pessoa.class))).thenReturn(pessoa);
        String result = pessoaService.createPessoa(pessoaDTO, new ModelMapper());


        System.out.println("Resultado : " + result);

        Assert.assertTrue(result != null);

        Assert.assertTrue(!result.isEmpty());

        Assert.assertTrue(pessoa.getNome().equals("Maikon"));

    }

    @Test
    public void shouldRunCreateANewPessoaButReturnAStringEmpty() {

        PessoaDTO pessoaDTO = new PessoaDTO();
        pessoaDTO.setNome("Maikon");
        pessoaDTO.setIdade(32);
        pessoaDTO.setCidade("");

        Pessoa pessoa = new Pessoa();
        pessoa.setId(0L);
        pessoa.setNome("Maikon");
        pessoa.setIdade(32);
        pessoa.setCidade("");

        Mockito.when(pessoaRepository.save(Mockito.any(Pessoa.class))).thenReturn(pessoa);
        String result = pessoaService.createPessoa(pessoaDTO, new ModelMapper());


        Assert.assertTrue(result != null);

        Assert.assertTrue(result.isEmpty());

    }

}